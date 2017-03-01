/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.cqrs.domain.command.AbstractCommand;

/**
 *
 * @author ajuffer
 */
public class UpdateCustomer 
    extends AbstractCommand
{
    private final Long customerId_;
    private final String name_;
    
    public UpdateCustomer(Long customerId, String name)
    {
        super(UpdateCustomer.class.getName());
        customerId_ = customerId;
        name_ = name;
    }
    
    public Long getCustomerid()
    {
        return customerId_;
    }
    
    public String getName()
    {
        return name_;
    }

}
