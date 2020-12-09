package com.tribc.ddd.domain.event;

import java.util.Collection;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Stores events in a queue.
 */
public class QueueEventBus extends EventBus {

    private final Deque<Event> events;

    public QueueEventBus() {
        super();
        this.events = new ConcurrentLinkedDeque<>();
    }

    /**
     * Adds all events produced by eventful to the queue.
     *
     * @param eventful SOmething that may have events.
     */
    public void add(Eventful eventful) {
        Collection<Event> events = Events.selectUnhandled(eventful.getEvents());
        events.forEach(this::add);
    }

    /**
     * Adds an event to the queue.
     *
     * @param event Event
     */
    public void add(Event event) {
        this.events.add(event);
    }

    /**
     * Handle all events currently in the queue sequentially.
     */
    public synchronized void handle() {
        while (!this.events.isEmpty()) {
            Event event = this.events.pop();
            this.handle(event);
        }

    }

    /**
     * Handles all events currently in the queue asynchronously in a new thread.
     * For low volume of events only.
     */
    public void handleAsync() {
        if (!this.events.isEmpty()) {
            Runnable r = this::handle;
            Thread t = new Thread(r);
            t.start();
        }
    }

    /**
     * Are there any events?
     *
     * @return Results.
     */
    public boolean hasEvents() {
        return !this.events.isEmpty();
    }

}
