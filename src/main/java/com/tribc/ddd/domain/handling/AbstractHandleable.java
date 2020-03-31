/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Base class for an actual handleable.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class AbstractHandleable implements Handleable
{
    @Getter
    private final HandleableId handleableId;
    
    private boolean handled;
    private boolean handling;
    
    @Setter(AccessLevel.PRIVATE)
    private Instant time;
    
    protected AbstractHandleable(HandleableId handlebleId)
    {
        this.handleableId = handlebleId;
        this.handled = false;
        this.handling = false;
        this.time = Instant.ofEpochMilli(0);
    }
    
    @Override
    public void handled() 
    {
        this.handled = true;
        this.handling = false;
        this.setTime(Instant.now());
    }

    @Override
    public boolean isHandled() 
    {
        return this.handled;
    }
    
    @Override
    public Instant handledOn()
    {
        return this.time;
    }

    @Override
    public void ongoing() 
    {
        this.handling = true;
    }

    @Override
    public boolean isOngoing() 
    {
        return this.handling;
    }

}
