package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.ddd.domain.handler.ReactiveMapBus;
import lombok.NonNull;
import reactor.core.publisher.Mono;

/**
 * Simple reactive command bus.
 */
public class ReactiveCommandBus extends ReactiveMapBus {

    /**
     * Handles the command.
     * @param command Command.
     * @param <T> Command type.
     * @return Handled command
     */
    public <T extends Handleable> Mono<T> handleReactively(@NonNull T command) {
        return Mono.just(command)
                .flatMap(this::manage)
                .map(c -> command)
                .log();
    }
}
