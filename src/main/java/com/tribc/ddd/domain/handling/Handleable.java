/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import java.time.Instant;

/**
 * Something that is capable of being handled.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Handleable
{
    /**
     * Marks this handleable is now being handled. Thus do not handle 
     * it again.
     */
    void handling();
    
    /**
     * Inquires whether this handleable is currently being handled.
     * @return Result.
     */
    boolean handlingNow();
    
    /**
     * Marks that this handleable has been dealt with to ensure that it is 
     * dealt with not more than once.
     */
    void handled();
    
    /**
     * Was this handleable already handled?
     * @return Result.
     */
    boolean isHandled();
    
    /**
     * Returns timestamp this handleable was handled.
     * @return Timestamp.
     */
    Instant handledOn();
    
    /**
     * Returns an identifier that uniquely identifies this handleable.
     * @return Identifier.
     */
    String getHandleableId();
}
