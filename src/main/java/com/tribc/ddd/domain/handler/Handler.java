package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;

/**
 * Handles a handleable.
 */
public interface Handler {

    /**
     * Handles a handleable.
     *
     * @param handleable Handleable
     */
    void handle(Handleable handleable);
}
