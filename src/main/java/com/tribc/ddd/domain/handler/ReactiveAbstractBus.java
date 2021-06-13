package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.cqrs.domain.handleable.HandleableId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * Base class for a reactive bus.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ReactiveAbstractBus implements ReactiveBus {

    @Override
    public abstract Handleable handle(Handleable handleable);

    @Override
    public abstract Mono<Handleable> manage(Handleable handleable);

    /**
     * Matches a handleable to a handler.
     *
     * @param handleableId Identifier.
     * @param handler      Handler.
     */
    public abstract void match(@NonNull HandleableId handleableId,
                               @NonNull ReactiveHandler handler);

    @Override
    public Flux<Handleable> handle(@NonNull Collection<Handleable> handleables) {
        return Flux.fromIterable(handleables).map(h -> this.handle(h));
    }

}
