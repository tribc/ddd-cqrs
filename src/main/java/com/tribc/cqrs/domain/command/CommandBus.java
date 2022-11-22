package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.HandleableId;
import com.tribc.ddd.domain.handler.MapBus;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Receives a command and matches it to a command handler. Only a single handler can be matched
 * to a command.
 */
@NoArgsConstructor
@Slf4j
public class CommandBus extends MapBus {

    /**
     * Match command to command handler.
     *
     * @param commandId      Unique command type identifier.
     * @param commandHandler Command handler
     */
    public void match(@NonNull HandleableId commandId,
                      @NonNull CommandHandler<AbstractCommand> commandHandler) {
        log.trace("match()");
        super.match(commandId, commandHandler);
    }
}
