package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.ddd.domain.handler.Handler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Handles a command. Base class for command handlers.
 *
 * @param <C> Command type.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CommandHandler<C extends AbstractCommand> implements Handler {

    public abstract void handle(C command);

    @Override
    public void handle(@NonNull Handleable handleable) {
        @SuppressWarnings("unchecked")
        C command = (C) handleable;
        this.handle(command);
    }
}
