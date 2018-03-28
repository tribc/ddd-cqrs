/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.ddd.domain.handling.MapBus;
import java.util.Collection;

/**
 * Receives an event and matches event handlers to it that subsequently 
 * deal with the event.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class EventBus
    extends MapBus
{
    public EventBus()
    {
        super();
    }    
    
    /**
     * Matches event to event handler.
     * @param <E> Event type.
     * @param eventId Unique event type identifier.
     * @param eventHandler Command handler
     */
    public <E extends Event> 
    void match(String eventId, EventHandler<E> eventHandler)
    {
        super.match(eventId, eventHandler);
    }
    
    /**
     * Handles all events of an eventful. After handling, the eventful is 
     * cleared of all events.
     * @param eventful An Eventful.
     */
    public void handle(Eventful eventful)
    {
        Collection<Event> events = eventful.getEvents();
        this.handle(events);
        eventful.clearEvents();
    }
    
    /**
     * Handle all events of an eventful asynchronously in a new thread. After the new
     * thread has started, control is immediately returned to the calling client.
     * @param eventful Eventful.
     * @see #handle(com.tribc.ddd.domain.event.Eventful
     * @deprecated Event handler itself should decide whether it can handle 
     * events asynchronously.
     */
    @Deprecated
    public void handleAsync(Eventful eventful)
    {
        Runnable r = () -> {
            this.handle(eventful);
        };
        Thread t = new Thread(r);
        t.start();
    }
}
