package com.tribc.ddd.domain.event;

import com.tribc.cqrs.domain.handleable.Handleable;

import java.time.Instant;

/**
 * Event raised in the domain, a domain event.
 */
public interface Event extends Handleable {

    /**
     * Returns the timestamp of this event.
     *
     * @return Timestamp.
     */
    Instant occurredOn();
}
