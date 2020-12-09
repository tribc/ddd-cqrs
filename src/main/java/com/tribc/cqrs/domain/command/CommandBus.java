/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.HandleableId;
import com.tribc.ddd.domain.handler.MapBus;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Receives a command and matches it to a command handler that subsequently
 * deals with the command. Only a single handler can be matched to a command.
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
@NoArgsConstructor
public class CommandBus extends MapBus {

    /**
     * Match command to command handler.
     *
     * @param commandId      Unique command type identifier.
     * @param commandHandler Command handler
     */
    public void match(@NonNull HandleableId commandId,
                      CommandHandler<AbstractCommand> commandHandler) {
        super.match(commandId, commandHandler);
    }
}
