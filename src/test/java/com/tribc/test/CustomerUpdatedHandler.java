/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.ddd.domain.event.DomainEventHandler;

/**
 *
 * @author ajuffer
 */
public class CustomerUpdatedHandler 
    implements DomainEventHandler<CustomerUpdated>
{

    public CustomerUpdatedHandler()
    {        
    }
    
    @Override
    public void handle(CustomerUpdated domainEvent) 
    {
        Customer customer = domainEvent.getCustomer();
        if ( !domainEvent.isHandled() ) {
            System.out.print("Customer #" + customer.getCustomerId() + " updated.");
        }
    }
    
}
