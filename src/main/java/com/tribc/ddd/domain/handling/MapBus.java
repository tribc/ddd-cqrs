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
import lombok.NonNull;

/**
 * A simple implementation that uses a map to match a handle with multiple handlers. 
 * A handleable identifier serves as the key to link handlers to the handleable.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Handleable type.
 */
public class MapBus<T extends Handleable> extends AbstractBus<T> {
    
    private final Map<String, Set<Handler>> handlers;    
    
    public MapBus()
    {
        super();
        this.handlers = new HashMap<>();
    }

    @Override
    public void match(@NonNull HandleableId handleableId, @NonNull Handler handler)
    {
        String id = handleableId.getValue();        
        if ( this.handlers.containsKey(id) ) {
            Set<Handler> hs = this.handlers.get(id);
            hs.add(handler);
        } else {
            Set<Handler> hs = new HashSet<>();
            hs.add(handler);
            this.handlers.put(id, hs);
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
    public void handle(@NonNull Handleable handleable) 
    {
        HandleableId handleableId = handleable.getHandleableId();
        if ( !this.containsHandlerFor(handleableId) ) {
            throw new IllegalStateException(
                    handleable.getClass().getName() + 
                    ": No handler registered for this handleable."
                );
        }
        
        if ( !handleable.isHandled() && !handleable.isOngoing() ) {
            String id = handleable.getHandleableId().getValue();
             
            // Mark ongoing handling of handeable.
            handleable.ongoing();
            
            // Find the handlers. Multiple handlers may exists.
            Set<Handler> hs = this.handlers.get(id);
            hs.forEach((handler) -> {
                handler.handle(handleable);
            });
            
            // Mark handling is complete.
            handleable.handled();
        }
    }
    
    protected boolean containsHandlerFor(@NonNull HandleableId handleableId)
    {
        return this.handlers.containsKey(handleableId.getValue());
    }

}
