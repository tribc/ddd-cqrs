package com.tribc.ddd.domain.event;

import com.tribc.cqrs.domain.handleable.HandleableId;
import com.tribc.ddd.domain.handler.MapBus;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 * Receives an event and matches event handlers. Multiple handlers may be associated to an event.
 */
@NoArgsConstructor
@Slf4j
public class EventBus extends MapBus {

    /**
     * Matches event to event handler.
     *
     * @param eventId      Unique event type identifier.
     * @param eventHandler Event handler
     */
    public void match(HandleableId eventId,
                      EventHandler<AbstractEvent> eventHandler) {
        log.trace("match()");
        super.match(eventId, eventHandler);
    }

    /**
     * Selects all unhandled events and handles them all. After handling, the
     * eventful is cleared of all events.
     *
     * @param eventful An Eventful.
     */
    public void handle(Eventful eventful) {
        log.trace("handle()");
        Collection<Event> events = Events.selectUnhandled(eventful.getEvents());
        events.forEach(this::handle);
        eventful.clearEvents();
    }

    /**
     * Handle all events of an eventful in a new thread. After the new
     * thread has started, control is immediately returned to the calling client.
     *
     * @param eventful Eventful.
     * @see #handle(com.tribc.ddd.domain.event.Eventful
     */
    public void handleAsync(Eventful eventful) {
        log.trace("handleAsync()");
        Runnable r = () -> this.handle(eventful);
        Thread t = new Thread(r);
        t.start();
    }

}
