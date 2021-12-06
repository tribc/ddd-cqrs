package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.ddd.domain.handler.ReactiveHandler;
import reactor.core.publisher.Mono;

public abstract class ReactiveCommandHandler<C extends AbstractCommand> implements ReactiveHandler {

    public abstract Mono<C> handleReactively(C command);

    @Override
    public <T extends Handleable> Mono<T> handle(T handleable) {
        @SuppressWarnings("unchecked")
        C command = (C) handleable;
        return this.handleReactively(command).map(c -> handleable);
    }
}
