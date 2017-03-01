/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.ddd.domain.handling;

import java.util.Collection;

/**
 * Receives a handle and matches it to a handler.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Handle type.
 */
public interface Bus <T extends Handle>
{
    /**
     * Handles handle.
     * @param handle Handle that requires handling.
     */
    void handle(T handle);
    
    /**
     * Handles multiple handles.
     * @param handles Handles that require handling.
     */
    void handle(Collection<T> handles);
}
