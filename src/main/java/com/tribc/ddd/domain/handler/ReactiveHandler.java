package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;
import reactor.core.publisher.Mono;

/**
 * Handles a handleable in a reactive manner.
 */
public interface ReactiveHandler {

    /**
     * Handles a handleable.
     *
     * @param handleable Handleable.
     * @param <T> Handleable type.
     * @return Handled handleable.
     */
    <T extends Handleable> Mono<T> handle(T handleable);
}
