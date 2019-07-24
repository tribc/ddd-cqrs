/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.ddd.domain.handling.HandleableId;
import com.tribc.ddd.domain.handling.MapBus;
import lombok.NoArgsConstructor;

/**
 * Receives a command and matches it to multiple command handler that subsequently 
 * deal with the command.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
@NoArgsConstructor
public class CommandBus extends MapBus<Command> {
    
    /**
     * Match command to command handler.
     * @param commandId Unique command type identifier.
     * @param commandHandler Command handler
     */
    public void match(HandleableId commandId, CommandHandler<Command> commandHandler)
    {
        super.match(commandId, commandHandler);
    }
}
