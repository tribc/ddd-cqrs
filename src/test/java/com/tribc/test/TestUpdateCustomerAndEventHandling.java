/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.cqrs.domain.command.CommandBus;
import com.tribc.ddd.domain.event.EventBus;

/**
 *
 * @author ajuffer
 */
public class TestUpdateCustomerAndEventHandling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        CustomerRepository r = new MapCustomerRepository();
        Customer c = new Customer(new Long(1), "Foo Bar");
        r.add(c);
        
        CommandBus commandBus = new CommandBus();
        
        EventBus eventBus = new EventBus();
        CustomerUpdatedHandler customerUpdatedHandler = new CustomerUpdatedHandler();
        System.out.println(CustomerUpdatedHandler.class.getGenericSuperclass());
        eventBus.match(CustomerUpdated.class.getName(), customerUpdatedHandler);
        
        SomethingOccuredHandler somethingOccuredHandler = new SomethingOccuredHandler();
        eventBus.match(SomethingOccurred.class.getName(), somethingOccuredHandler);
        
        CustomerFacade f = new CustomerFacade(commandBus);
        
        UpdateCustomerHandler updateCustomerHandler = 
            new UpdateCustomerHandler(r, eventBus);
        System.out.println(UpdateCustomer.class);
        System.out.println(updateCustomerHandler.getClass().getGenericSuperclass());
        commandBus.match(UpdateCustomer.class.getName(), updateCustomerHandler);
        
        f.update(c.getCustomerId(), "New Name");
    }
    
}
