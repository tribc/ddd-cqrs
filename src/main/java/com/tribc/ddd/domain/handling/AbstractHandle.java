/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.ddd.domain.handling;

import java.time.Instant;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class AbstractHandle
    implements Handle
{
    private final String handleId_;
    private boolean handled_;
    Instant time_;
    
    protected AbstractHandle(String handleId)
    {
        handleId_ = handleId;
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
        this.setTime(Instant.now());
    }

    @Override
    public boolean isHandled() 
    {
        return handled_;
    }
    
    @Override
    public String getHandleId()
    {
        return handleId_;
    }
    
    @Override
    public Instant handledOn()
    {
        return time_;
    }
}
