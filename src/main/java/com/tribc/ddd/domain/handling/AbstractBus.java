/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import java.util.Collection;

/**
 * Base class for a bus.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public abstract class AbstractBus 
    implements Bus
{
    protected AbstractBus()
    {        
    }
    
    @Override
    public abstract void handle(Handleable handleable);
    
    /**
     * Matches handleable to handler.
     * @param clazz Handleable class.
     * @param handler Handler.
     */
    public void match(Class clazz, Handler handler)
    {
        this.match(clazz.getName(), handler);
    }
    
    /**
     * Matches handleable to handler.
     * @param handleableId Unique handleable identifier.
     * @param handler Handler.
     */
    public abstract void match(String handleableId, Handler handler);    
    
    @Override
    public void handle(Collection<? extends Handleable> handleables)
    {
        for (Handleable handleable : handleables) {            
            this.handle(handleable);
        }        
    }
    
}
