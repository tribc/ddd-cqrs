/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.ddd.domain.handling.Handler;

/**
 * Handles commands send to the domain.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <C> Command type.
 */
public interface CommandHandler <C extends Command> extends Handler<C>
{
    /**
     * Handles the command.
     * @param command Command.
     * @return Result. The result type R may be Void (e.g. for asynchronous handling).
     */
    @Override
    void handle(C command);
}
