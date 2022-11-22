package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.cqrs.domain.handleable.HandleableId;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.*;

@Slf4j
public class ReactiveMapBus extends ReactiveAbstractBus {

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

    /**
     * Handles the handleable if it is not yet handled.
     * @param handleable Handleable.
     * @return Handled handleable.
     * @throws MissingHandlerException if no handler exists for the given handleable.
     */
    @Override
    public Mono<Handleable> manage(Handleable handleable) {
        log.trace("manage()");
        return Mono.just(handleable)
                .log()
                .filter(h -> !h.isHandled())
                .map(h -> {
                    if (!this.containsHandlerFor(h)) {
                        throw new MissingHandlerException(h.getHandleableId().getValue() + ": Handleable");
                    }
                    h.markOngoing();
                    return h;
                })
                .flatMapIterable(h -> this.handlers.get(h.getHandleableId()))
                .flatMap(hdl -> hdl.handle(handleable))
                .last()
                .map(h -> {
                    h.markHandled();
                    return h;
                });
    }

    /**
     * Blocking. Not entirely reactive....
     */
    @Override
    public Handleable handle(@NonNull Handleable handleable) {
        log.trace("handle(Handleable handleable)");
        return this.manage(handleable).block();
    }

    protected boolean containsHandlerFor(@NonNull Handleable handleable) {
        return this.handlers.containsKey(handleable.getHandleableId());
    }

    private Handleable handle(@NonNull Handleable handleable, @NonNull ReactiveHandler handler) {
        log.trace("handle(Handleable handleable, ReactiveHandler handler)");
        return handle(handleable);
    }

}
