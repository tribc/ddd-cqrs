/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tribc.test;

import com.tribc.cqrs.domain.command.CommandBus;
import com.tribc.ddd.domain.event.QueueEventBus;

/**
 *
 * @author ajuffer
 */
public class CustomerFacade 
{
    private final CommandBus commandBus_;
    private final QueueEventBus eventBus_;
    
    public CustomerFacade (CommandBus commandBus, QueueEventBus eventBus) {
        this.commandBus_ = commandBus;
        this.eventBus_ = eventBus;
    }
    
    public void update(Long customerId, String name) {
        UpdateCustomer command = new UpdateCustomer(customerId, name);
        commandBus_.handle(command);
        System.out.println("CustomerFacade: EventBus has events? Result: " + this.eventBus_.hasEvents());
        eventBus_.handleAsync();
    }
}
