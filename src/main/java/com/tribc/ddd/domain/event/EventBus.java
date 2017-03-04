/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.ddd.domain.handling.MapBus;

/**
 * Receives an event and matches an event handler to it.
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
     * Match event to event handler.
     * @param <E> Event type.
     * @param eventId Unique event type identifier.
     * @param eventHandler Command handler
     */
    public <E extends Event> 
    void match(String eventId, EventHandler<E> eventHandler)
    {
        super.match(eventId, eventHandler);
    }    
}
