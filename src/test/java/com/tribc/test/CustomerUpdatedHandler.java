/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.ddd.domain.event.EventHandler;

/**
 *
 * @author ajuffer
 */
public class CustomerUpdatedHandler 
    extends EventHandler<CustomerUpdated>
{
    public CustomerUpdatedHandler()
    {        
    }
    
    @Override
    public void handle(CustomerUpdated event) 
    {
        Long customerId = event.getCustomerId();
        if ( !event.isHandled() ) {
            System.out.println("Customer #" + customerId + " updated.");
        }
    }
    
}
