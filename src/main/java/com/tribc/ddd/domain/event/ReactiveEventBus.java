package com.tribc.ddd.domain.event;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.ddd.domain.handler.ReactiveMapBus;
import lombok.NonNull;
import reactor.core.publisher.Mono;

/**
 * Simple reactive queue-based event bus.
 */
public class ReactiveEventBus extends ReactiveMapBus {

    /**
     * Handles all events in an eventful.
     * @param eventful Eventful.
     * @param <T> Eventful type
     * @return T
     */
    public <T extends Eventful> Mono<T> handleReactively(@NonNull T eventful) {
        return Mono.just(eventful)
                .flatMapIterable(ef -> Events.selectUnhandled(ef.getEvents()))
                .flatMap(evt -> this.manage(evt))
                .last()
                .map(evt -> eventful);
    }

}