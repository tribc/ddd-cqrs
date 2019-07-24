/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.ddd.domain.handling.HandleableId;
import com.tribc.ddd.domain.handling.MapBus;
import java.util.Collection;
import lombok.NoArgsConstructor;

/**
 * Receives an event and matches event handlers to it that subsequently 
 * deal with the event.
 * @author Andr&#233; Juffer, Triacle Biocomputing.
 */
@NoArgsConstructor
public class EventBus extends MapBus<Event> {
    
    /**
     * Matches event to event handler.
     * @param eventId Unique event type identifier.
     * @param eventHandler Command handler
     */
    public void match(HandleableId eventId, EventHandler<Event> eventHandler)
    {        
        super.match(eventId, eventHandler);
    }
    
    /**
     * Selects all unhandled events and handles them. After handling, the 
     * eventful is cleared of all events.
     * @param eventful An Eventful.
     */
    public void handle(Eventful eventful)
    {
        Collection<Event> events = Events.selectUnhandled(eventful.getEvents());
        this.handle(events);
        eventful.clearEvents();
    }
    
    /**
     * Handle all events of an eventful asynchronously in a new thread. After the new
     * thread has started, control is immediately returned to the calling client.
     * @param eventful Eventful.
     * @see #handle(com.tribc.ddd.domain.event.Eventful
     */
    public void handleAsync(Eventful eventful)
    {
        Runnable r = () -> {
            this.handle(eventful);
        };
        Thread t = new Thread(r);
        t.start();
    }
}
