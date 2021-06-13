package com.tribc.ddd.domain.event;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.ddd.domain.handler.ReactiveHandler;
import reactor.core.publisher.Mono;

public abstract class ReactiveEventHandler<E extends AbstractEvent> implements ReactiveHandler {

    public abstract Mono<E> handleReactively(E event);

    @Override
    public <T extends Handleable> Mono<T> handle(T handleable) {
        @SuppressWarnings("unchecked")
        E event = (E) handleable;
        return this.handleReactively(event).map(e -> handleable);
    }
}
