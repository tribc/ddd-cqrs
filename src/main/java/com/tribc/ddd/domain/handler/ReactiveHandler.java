package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;
import reactor.core.publisher.Mono;

/**
 * Handles reactively a handleable.
 */
public interface ReactiveHandler {

    <T extends Handleable> Mono<T> handle(T handleable);
}
