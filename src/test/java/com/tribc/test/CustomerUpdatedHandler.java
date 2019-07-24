/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.ddd.domain.event.EventHandler;
import com.tribc.ddd.domain.handling.Handleable;

/**
 *
 * @author ajuffer
 */
public class CustomerUpdatedHandler extends EventHandler<CustomerUpdated>
{
    public CustomerUpdatedHandler()
    {
        super();
    }
    
    @Override
    public void handle(Handleable handleable) {
        this.handle((CustomerUpdated)handleable);
    }
    
    
    private void handle(CustomerUpdated event) 
    {
        Long customerId = event.getCustomerId();
        if ( !event.isHandled() ) {
            System.out.println("Customer #" + customerId + " updated.");
        }
    }

    
}
