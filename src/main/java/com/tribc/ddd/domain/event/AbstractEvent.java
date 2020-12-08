/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.cqrs.domain.handleable.AbstractHandleable;
import com.tribc.cqrs.domain.handleable.HandleableId;
import java.time.Instant;
import lombok.NonNull;

/**
 * Base class for all domain events.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class AbstractEvent extends AbstractHandleable implements Event {
    
    private final Instant occurredOn_;
    
    protected AbstractEvent(@NonNull HandleableId handleableId)
    {
        super(handleableId);
        occurredOn_ = Instant.now();
    }

    @Override
    public Instant occurredOn() 
    {
        return occurredOn_;
    }
    
}
