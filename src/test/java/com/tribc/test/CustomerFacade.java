/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tribc.test;

import com.tribc.cqrs.domain.command.CommandBus;

/**
 *
 * @author ajuffer
 */
public class CustomerFacade 
{
    private final CommandBus commandBus_;
    
    public CustomerFacade (CommandBus commandBus)
    {
        commandBus_ = commandBus;
    }
    
    public void update(Long customerId, String name)
    {
        UpdateCustomer command = new UpdateCustomer(customerId, name);
        commandBus_.handle(command);
    }
}
