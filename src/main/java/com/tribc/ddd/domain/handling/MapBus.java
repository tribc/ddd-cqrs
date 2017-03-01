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
 * @param <T> Handle type.
 * @param <H> Handler type.
 */
public class MapBus <T extends Handle,H extends Handler<T> > 
    extends AbstractBus <T,H>
{   
    private final Map<String, H> handlers_;
    
    public MapBus()
    {
        super();
        handlers_ = new HashMap<>();
    }

    /**
     * @throws NullPointerException if either handleId or handler are null.
     * @throws IllegalStateException if a handler was already assigned to handleId.
     */
    @Override
    public void match(String handleId, H handler)
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
    public void handle(T handle) 
    {
        if ( !handlers_.containsKey(handle.getHandleId()) ) {
            throw new NullPointerException("No handler for '" + 
                                            handle.getHandleId() + "'.");
        }
        H handler = handlers_.get(handle.getHandleId());
        handler.handle(handle);
        handle.handled();
    }
    
    @Override
    public void handle(Collection<T> handles)
    {
        for (T handle : handles) {
            this.handle(handle);
        }
    }
}
