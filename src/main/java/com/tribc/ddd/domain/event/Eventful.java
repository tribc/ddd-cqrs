package com.tribc.ddd.domain.event;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Marks an entity as being capable of raising events.
 */
public interface Eventful {

    /**
     * Returns all raised events.
     *
     * @return Events. May be empty, but is never null.
     */
    Collection<Event> getEvents();

    /**
     * Returns an event stream.
     *
     * @return Event stream.
     */
    default Stream<Event> getEventStream() {
        return this.getEvents().stream();
    }

    /**
     * Clear entity from all events. Typically called after all
     * events have been handled.
     */
    void clearEvents();
}
