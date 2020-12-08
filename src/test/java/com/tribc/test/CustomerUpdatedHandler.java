/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.ddd.domain.event.EventHandler;
import com.tribc.cqrs.domain.handleable.Handleable;

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
    public void handle(Handleable event) {
        this.handle((CustomerUpdated)event);
    }

    private void handle(CustomerUpdated event) {
        Long customerId = event.getCustomerId();
        if (event.isNotHandled()) {
            System.out.println("Customer #" + customerId + " updated.");
        }
    }

}
