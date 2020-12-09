/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.ddd.domain.handler.Handler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Executes a command issued by the client application. Base class for all
 * command handlers.
 *
 * @param <C> Command type.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CommandHandler<C extends AbstractCommand> implements Handler {

    public abstract void handle(C command);

    @Override
    public void handle(Handleable handleable) {
        @SuppressWarnings("unchecked")
        C command = (C) handleable;
        this.handle(command);
    }
}
