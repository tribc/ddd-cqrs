/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.cqrs.domain.command.Command;

/**
 *
 * @author ajuffer
 */
public class UpdateCustomer implements Command
{
    private final Long customerId_;
    private final String name_;
    private boolean handled_;
    
    public UpdateCustomer(Long customerId, String name)
    {   
        customerId_ = customerId;
        name_ = name;
        handled_ = false;
    }
    
    public Long getCustomerid()
    {
        return customerId_;
    }
    
    public String getName()
    {
        return name_;
    }

    @Override
    public boolean isHandled() 
    {
        return handled_;
    }
    
    public void handled()
    {
        handled_ = true;
    }
}
