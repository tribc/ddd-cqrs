/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.cqrs.domain.command.CommandHandler;
import com.tribc.ddd.domain.event.EventBus;
import com.tribc.ddd.domain.handling.Handleable;

/**
 *
 * @author ajuffer
 */
public class UpdateCustomerHandler extends CommandHandler<UpdateCustomer>
{
    private final CustomerRepository customerRepository_;
    private final EventBus eventBus_;
    
    public UpdateCustomerHandler(CustomerRepository customerRepository,
                                 EventBus eventBus)
    {        
        customerRepository_ = customerRepository;
        eventBus_ = eventBus;
    }
    
   
    private void handle(UpdateCustomer command) 
    {
            Customer customer = 
                customerRepository_.forCustomerId(command.getCustomerid());
            customer.updateName(command.getName());
            customerRepository_.update(customer);
            
            //eventBus_.handleAsync(customer);
            eventBus_.handle(customer);
           
    }

    @Override
    public void handle(Handleable handleable) 
    {
        this.handle((UpdateCustomer)handleable);
    }
    
}
