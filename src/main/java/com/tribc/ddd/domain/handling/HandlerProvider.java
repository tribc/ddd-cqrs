/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

/**
 * Holds handlers of type H for Handled of type T
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <H> Handler type
 * @param <T> Handled type
 */
public interface HandlerProvider <H extends Handler,T extends Handled> 
{    
    /**
     * Adds new handler for t.
     * @param t Handled.
     * @param handler Handler.
     * @deprecated 
     */
    void addHandler(T t, H handler);
    
    /**
     * Adds handler.
     * @param clazz Class type handled of type T
     * @param handler 
     */
    void addHandler(Class<T> clazz, H handler);
    
    /**
     * Returns handler for t.
     * @param t Handled.
     * @return Handler.
     */
    H getHandler(T t);
}
