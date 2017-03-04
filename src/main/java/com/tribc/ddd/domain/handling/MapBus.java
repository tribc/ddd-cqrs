/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.ddd.domain.handling;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple implementation that uses a map to match handles with handlers.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class MapBus
    implements Bus
{   
    private final Map<String, Handler> handlers_;
    
    public MapBus()
    {
        super();
        handlers_ = new HashMap<>();
    }

    /**
     * Matches handler (of type T) to handler of type H.
     * @param handleId Unique handle identifier.
     * @param handler Handler that is matched to the handle.
     * @throws NullPointerException if either handleId or handler are null.
     * @throws IllegalStateException if a handler was already assigned to handleId.
     */
    protected void match(String handleId, Handler handler)
    {
        // Validate.
        if ( handleId == null ) {
            throw new NullPointerException("An handle identifier must be provided. ");
        }
        if ( handler == null ) {
            throw new NullPointerException("A handler must be provided.");
        }
        if ( handlers_.containsKey(handleId) ) {
            throw new IllegalStateException("A handler for '" + handleId +
                                            "' was already provided.");
        }
        handlers_.put(handleId, handler);
    }

    /**
     * @throws NullPointerException if no handlers can be found.
     */
    @Override
    public void handle(Handle handle) 
    {
        if ( !handlers_.containsKey(handle.getHandleId()) ) {
            throw new NullPointerException("No handler for '" + 
                                            handle.getHandleId() + "'.");
        }
        Handler handler = handlers_.get(handle.getHandleId());
        handler.handle(handle);
        handle.handled();
    }
    
    @Override
    public void handle(Collection<? extends Handle> handles)
    {
        for (Handle handle : handles) {
            this.handle(handle);
        }
    }
}
