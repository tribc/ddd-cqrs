/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.cqrs.domain.command.CommandHandler;
import com.tribc.cqrs.domain.command.CommandHandlerProvider;

/**
 *
 * @author ajuffer
 */
public class CustomerFacade 
{
    CommandHandlerProvider commandHandlerProvider_;
    
    public CustomerFacade (CommandHandlerProvider provider)
    {
        commandHandlerProvider_ = provider;
    }
    
    public void update(Long customerId, String name)
    {
        UpdateCustomer command = new UpdateCustomer(customerId, name);
        CommandHandler<UpdateCustomer> handler = 
            commandHandlerProvider_.getHandler(command);
        handler.handle(command);        
    }
}
