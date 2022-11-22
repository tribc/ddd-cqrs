package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.ddd.domain.handler.ReactiveMapBus;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Receives a command and matches it to a command handler that handles it
 * in a reactive manner. Only a single handler can be matched
 * to a command.
 */
@Slf4j
public class ReactiveCommandBus extends ReactiveMapBus {

    /**
     * Handles the command.
     * @param command Command.
     * @param <T> Command type.
     * @return Handled command
     */
    public <T extends Handleable> Mono<T> handleReactively(@NonNull T command) {
        log.trace("handleReactively()");
        return Mono.just(command)
                .log()
                .flatMap(this::manage)
                .map(h -> command);
    }
}
