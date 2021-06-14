package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.cqrs.domain.handleable.HandleableId;
import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

public class ReactiveMapBus extends ReactiveAbstractBus {

    private static final Logger logger = LogManager.getLogger(ReactiveMapBus.class.getName());

    // Key is the handleable identifier. Value are the handlers for the handleable.
    private final Map<HandleableId, Set<ReactiveHandler>> handlers;

    protected ReactiveMapBus() {
        super();
        this.handlers = new HashMap<>();
    }

    /**
     * Returns all handles for each handleable.
     * @return Unmodifiable map.
     */
    public Map<HandleableId, Set<ReactiveHandler>> getHandlers() {
        return Collections.unmodifiableMap(this.handlers);
    }

    @Override
    public void match(@NonNull HandleableId handleableId, @NonNull ReactiveHandler handler) {
        if (this.handlers.containsKey(handleableId)) {
            Set<ReactiveHandler> hs = this.handlers.get(handleableId);
            hs.add(handler);
        } else {
            Set<ReactiveHandler> hs = new HashSet<>();
            hs.add(handler);
            this.handlers.put(handleableId, hs);
        }

    }

    @Override
    public Mono<Handleable> manage(Handleable handleable) {
        if (!this.containsHandlerFor(handleable)) {
            return Mono.error(
                    new IllegalArgumentException(handleable.getHandleableId().getValue() +
                            ": No handler registered for this handleable."));
        }
        if (handleable.isNotHandled()) {
            return Mono.just(handleable)
                    .map(h -> {
                        h.markOngoing();
                        return h;
                    })
                    .flatMapIterable(h -> this.handlers.get(h.getHandleableId()))
                    .flatMap(hdl -> hdl.handle(handleable))
                    .last()
                    .map(h -> {
                        h.markHandled();
                        return h;
                    })
                    .log();
        } else {
            logger.warn(
                    handleable.getHandleableId() +
                            ": This handleable is skipped as it was already handled."
            );
            return Mono.just(handleable);
        }
    }

    /**
     * Blocking.
     */
    @Override
    public Handleable handle(@NonNull Handleable handleable) {
        return this.manage(handleable).block();
    }

    protected boolean containsHandlerFor(@NonNull Handleable handleable) {
        return this.handlers.containsKey(handleable.getHandleableId());
    }

    private Handleable handle(@NonNull Handleable handleable, @NonNull ReactiveHandler handler) {
        return handle(handleable);
    }

}
