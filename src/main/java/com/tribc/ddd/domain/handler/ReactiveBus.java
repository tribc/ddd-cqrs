package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * Matches handleable to handlers who reactively handle them.
 */
public interface ReactiveBus {

    /**
     * Handles a single Handleable.
     *
     * @param handleable Handleable.
     */
    Handleable handle(Handleable handleable);

    /**
     * Deals with or handles a single handleable.
     * @param handleable Handleable.
     * @return Handleable.
     */
    Mono<Handleable> manage(Handleable handleable);

    /**
     * Handles multiple handleables reactively.
     * @param handleables Handleables.
     * @return Handled handleables.
     */
    Flux<Handleable> handle(Collection<Handleable> handleables);
}
