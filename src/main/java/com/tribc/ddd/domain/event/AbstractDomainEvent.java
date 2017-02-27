/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import java.util.Date;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public abstract class AbstractDomainEvent 
    implements DomainEvent
{
    private final Date date_;
    private boolean handled_;
    
    protected AbstractDomainEvent()
    {
        date_ = new Date();
        handled_ = false;
    }

    @Override
    public Date occuredOn() 
    {
        return date_;
    }

    @Override
    public boolean isHandled()
    {
        return handled_;
    }
    
    /**
     * Signals that this domain event was handled.
     */
    public void handled()
    {
        handled_ = true;
    }
}
