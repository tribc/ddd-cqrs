/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tribc.ddd.domain.handling;

import java.util.Collection;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Handle type.
 * @param <H> Handler type.
 */
public abstract class AbstractBus <T extends Handle,
                                   H extends Handler<T>>
    implements Bus
{
    protected AbstractBus()
    {        
    }
    
    @Override
    public abstract void handle(Handle handle);
    
    /*
    @Override
    public abstract void handle(Collection<Handle> handles);
    */
    
    /**
     * Matches handler of type T to handler of type H.
     * @param handleId Unique handle identifier.
     * @param handler Handler that is matched to the handle.
     */
    public abstract void match(String handleId, H handler);
    
}
