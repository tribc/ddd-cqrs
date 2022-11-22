package com.tribc.ddd.domain.event;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;

/**
 * Some useful utilities.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Events {

    /**
     * Selects unhandled events from a list of events.
     *
     * @param events Events.
     * @return Events. May be empty.
     */
    public static Collection<Event> selectUnhandled(Collection<Event> events) {
        Collection<Event> unhandled = new HashSet<>();
        events.stream()
                .filter((event) -> (!event.isHandled()))
                .forEachOrdered(unhandled::add);
        return unhandled;
    }


}
