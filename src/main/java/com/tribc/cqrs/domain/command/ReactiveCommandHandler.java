package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.ddd.domain.handler.ReactiveHandler;
import reactor.core.publisher.Mono;

/**
 * Handles a command in a reactive manner. Base class for reactive command handlers.
 *
 * @param <C>
 */
public abstract class ReactiveCommandHandler<C extends AbstractCommand> implements ReactiveHandler {

    /**
     * The actual handler.
     * @param command Command to be handled.
     * @return Handled command.
     */
    public abstract Mono<C> handleReactively(C command);

    @Override
    public <T extends Handleable> Mono<T> handle(T handleable) {
        @SuppressWarnings("unchecked")
        C command = (C) handleable;
        return this.handleReactively(command).map(c -> handleable);
    }
}
