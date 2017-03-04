/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.cqrs.domain.command.CommandHandler;
import com.tribc.ddd.domain.event.Event;
import com.tribc.ddd.domain.event.EventBus;
import java.util.Collection;

/**
 *
 * @author ajuffer
 */
public class UpdateCustomerHandler
    extends CommandHandler<UpdateCustomer>
{
    private final CustomerRepository customerRepository_;
    private final EventBus eventBus_;
    
    public UpdateCustomerHandler(CustomerRepository customerRepository,
                                 EventBus eventBus)
    {        
        customerRepository_ = customerRepository;
        eventBus_ = eventBus;
    }
    
    @Override
    public void handle(UpdateCustomer command) 
    {
        Customer customer = customerRepository_.forCustomerId(command.getCustomerid());
        if ( !command.isHandled() ) {
            customer.setName(command.getName());
            customerRepository_.update(customer);
            
            Collection<Event> events = customer.getEvents();
            eventBus_.handle(events);
            customer.clearEvents();
        }    
    }
    
}
