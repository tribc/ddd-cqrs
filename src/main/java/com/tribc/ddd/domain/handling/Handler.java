/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

/**
 * Operates a handle.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Handle type.
 */
public interface Handler<T extends Handle>
{
    /**
     * Handles handle.
     * @param handle Handle.
     */
    void handle(T handle);
}
