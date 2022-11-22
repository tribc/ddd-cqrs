package com.tribc.ddd.domain.event;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.ddd.domain.handler.Handler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Handles an event. Base class for all event handlers.
 *
 * @param <E> Event type.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class EventHandler<E extends AbstractEvent> implements Handler {

    public abstract void handle(E event);

    @Override
    public void handle(Handleable handleable) {
        @SuppressWarnings("unchecked")
        E event = (E) handleable;
        this.handle(event);
    }
}
