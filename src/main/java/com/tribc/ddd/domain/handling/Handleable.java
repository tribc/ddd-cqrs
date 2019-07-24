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
    void nowHandled();
    
    /**
     * Inquires whether this handleable is currently being handled.
     * @return Result. If true, do not handled it now.
     */
    boolean isHandledNow();
    
    /**
     * Marks that this handleable has already been dealt with to ensure to avoid
     * that it is handled more than once.
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
    HandleableId getHandleableId();
}
