package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;

import java.util.Collection;

/**
 * Matches Handleable to handlers who handle them.
 */
public interface Bus {

    /**
     * Handles a single handleable.
     *
     * @param handleable Handleable.
     */
    void handle(Handleable handleable);

    /**
     * Handles multiple handleables.
     *
     * @param handleables Handleable collection.
     */
    void handle(Collection<Handleable> handleables);
}
