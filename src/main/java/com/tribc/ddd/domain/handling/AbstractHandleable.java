/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import java.time.Instant;

/**
 * Base class for an actual handleable.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class AbstractHandleable 
    implements Handleable
{
    private final String handlebleId_;
    private boolean handled_;
    private boolean handling_;
    private Instant time_;
    
    /**
     * Constructor.
     * @param clazz Class. The <code>clazz.getName()</code> will serve as a 
     * handleable identifier.
     */
    protected AbstractHandleable(Class clazz)
    {
        handlebleId_ = clazz.getName();
        handled_ = false;
        handling_ = false;
        time_ = Instant.ofEpochMilli(0);
    }
    
    /**
     * Constructor.
     * @param handleableId Identifier for uniquely identifying this handleable.
     */
    protected AbstractHandleable(String handleableId)
    {
        handlebleId_ = handleableId;
        handled_ = false;
        time_ = Instant.ofEpochMilli(0);
    }
    
    private void setTime(Instant time)
    {
        time_ = time;
    }
    
    @Override
    public void handled() 
    {
        handled_ = true;
        handling_ = false;
        this.setTime(Instant.now());
    }

    @Override
    public boolean isHandled() 
    {
        return handled_;
    }
    
    @Override
    public String getHandleableId()
    {
        return handlebleId_;
    }
    
    @Override
    public Instant handledOn()
    {
        return time_;
    }

    @Override
    public void handling() 
    {
        handling_ = true;
    }

    @Override
    public boolean handlingNow() 
    {
        return handling_;
    }
}
