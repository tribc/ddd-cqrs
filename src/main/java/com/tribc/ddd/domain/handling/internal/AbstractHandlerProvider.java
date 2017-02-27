/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling.internal;

import com.tribc.ddd.domain.handling.Handled;
import com.tribc.ddd.domain.handling.Handler;
import com.tribc.ddd.domain.handling.HandlerProvider;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple implementation.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <H> handled type.
 * @param <T> Handler type. Handles handled.
 */
public abstract class AbstractHandlerProvider<H extends Handler,T extends Handled>
    implements HandlerProvider<H,T>
{
    private final Map<Class<?>, H> handlers_;
    
    protected AbstractHandlerProvider()
    {
        handlers_ = new HashMap<>();
    }

    @Override
    public void addHandler(T t, H handler) 
    {
        handlers_.put(t.getClass(), handler);
    }
    
    @Override
    public void addHandler(Class<T> clazz, H handler)
    {
        handlers_.put(clazz, handler);
    }

    /**
     * Returns null if no handler of type H is available for the given handled of type T.
     * @param t Handled.
     * @return Handler.
     */
    @Override
    public H getHandler(T t) 
    {
        if ( handlers_.containsKey(t.getClass())) {
            return handlers_.get(t.getClass());
        } else {
            return null;
        }
    }
    
}
