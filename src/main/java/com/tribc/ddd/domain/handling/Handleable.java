/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import java.time.Instant;

/**
 * Something that is capable of being handled or dealt with.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Handleable
{
    /**
     * Marks that this handleable is currently being dealt with.
     */
    void ongoing();
    
    /**
     * Inquires whether this handleable is currently being dealt with.
     * @return Result.
     */
    boolean isOngoing();
    
    /**
     * Marks that this handleable has been dealt with.
     */
    void handled();
    
    /**
     * Was this handleable being dealt with?
     * @return Result.
     */
    boolean isHandled();
    
    /**
     * Returns timestamp this handleable was dealt with.
     * @return Timestamp.
     */
    Instant handledOn();
    
    /**
     * Returns an identifier that uniquely identifies this handleable.
     * @return Identifier.
     */
    HandleableId getHandleableId();
}
