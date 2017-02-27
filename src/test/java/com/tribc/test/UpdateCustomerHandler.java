/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.cqrs.domain.command.CommandHandler;

/**
 *
 * @author ajuffer
 */
public class UpdateCustomerHandler
    implements CommandHandler<UpdateCustomer>
{
    private final CustomerRepository customerRepository_;
    
    public UpdateCustomerHandler(CustomerRepository customerRepository)
    {        
        customerRepository_ = customerRepository;
    }
    
    @Override
    public void handle(UpdateCustomer command) 
    {
        Customer customer = customerRepository_.forCustomerId(command.getCustomerid());
        if ( !command.isHandled() ) {
            customer.setName(command.getName());
            command.handled();
        }    
    }
    
}
