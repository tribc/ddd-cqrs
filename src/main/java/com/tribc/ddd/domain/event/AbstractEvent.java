/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.ddd.domain.handling.AbstractHandle;
import java.time.Instant;

/**
 * Base class for all events.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class AbstractEvent 
    extends AbstractHandle
    implements Event
{
    private final Instant time_;
    
    protected AbstractEvent(String handleId)
    {
        super(handleId);
        time_ = Instant.now();
    }

    @Override
    public Instant occuredOn() 
    {
        return time_;
    }
    
}
