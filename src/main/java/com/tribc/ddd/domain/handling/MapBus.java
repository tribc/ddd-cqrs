/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A simple implementation that uses a map to match a handle with multiple handlers. 
 * A handleable identifier serves as the key to link handlers to the handleable.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class MapBus
    extends AbstractBus
{   
    private final Map<String, Set<Handler>> handlers_;
    
    
    public MapBus()
    {
        super();
        handlers_ = new HashMap<>();
    }

    /**
     * @throws NullPointerException if handleableId or handler or both are null.
     */
    @Override
    public void match(String handleableId, Handler handler)
    {
        // Validate.
        if ( handleableId == null ) {
            throw new NullPointerException("A handleable identifier must be provided. ");
        }
        if ( handler == null ) {
            throw new NullPointerException("A handler must be provided.");
        }
        
        // Match.
        if ( handlers_.containsKey(handleableId) ) {
            Set<Handler> handlers = handlers_.get(handleableId);
            handlers.add(handler);
        } else {
            Set<Handler> handlers = new HashSet<>();
            handlers.add(handler);
            handlers_.put(handleableId, handlers);
        }
    }

    /**
     * Handles or deals with a handleable. After handling, the handleable is 
     * notified that it has been dealt with.
     * @param handleable Handleable.
     * @throws IllegalStateException if no handlers are registered for the 
     * handleable.
     */
    @Override
    public void handle(Handleable handleable) 
    {
        if ( !handleable.isHandled() && !handleable.handlingNow() ) {
            if ( !handlers_.containsKey(handleable.getHandleableId()) ) {
                String handleableId = handleable.getHandleableId();
                throw new IllegalStateException(
                    handleableId + ": No handler register for this handleable."
                );
            }
            Set<Handler> handlers = handlers_.get(handleable.getHandleableId());
            handlers.forEach((handler) -> {
                handleable.handling();
                handler.handle(handleable);
            });
            
            // Mark handled to avoid double-hanling.
            handleable.handled();
        }
    }

}
