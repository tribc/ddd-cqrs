package com.tribc.ddd.domain.event;

import com.tribc.ddd.domain.handler.ReactiveMapBus;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Receives an eventful and matches its events to event handlers that handle events in a reactive manner.
 * Multiple handler can be match to an event.
 */
@Slf4j
public class ReactiveEventBus extends ReactiveMapBus {

    /**
     * Handles all unhandled events in an eventful.
     * @param eventful Eventful.
     * @param <T> Eventful type
     * @return T, the eventful.
     */
    public <T extends Eventful> Mono<T> handleReactively(@NonNull T eventful) {
        log.trace("handleReactively");
        return Mono.just(eventful)
                .log()
                .flatMapIterable(ef -> Events.selectUnhandled(ef.getEvents()))
                .flatMap(this::manage)
                .last()
                .map(h -> eventful);
    }

}
