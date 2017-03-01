/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import java.time.Instant;

/**
 * Marks something that should be handled by some handler.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Handle
{
    /**
     * Marks that this handled was already handled by a handler. Calling this method
     * ensures that this handle is handled more than once.
     */
    void handled();
    
    /**
     * Was already handled by a handler?
     * @return Result.
     */
    boolean isHandled();
    
    /**
     * Returns time this handle was handled.
     * @return Time-stamp.
     */
    Instant handledOn();
    
    /**
     * Returns an unique identifier.
     * @return Identifier.
     */
    String getHandleId();
}
