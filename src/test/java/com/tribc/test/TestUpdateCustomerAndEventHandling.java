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
        Long customerId = new Long(1);
        CustomerRepository customerRepository = new MapCustomerRepository();
        Customer c = new Customer(customerId, "André H. Juffer");
        customerRepository.add(c);
        System.out.println("Customer before: " + c);
        
        EventBus eventBus = new EventBus();
        CustomerUpdatedHandler customerUpdatedHandler = new CustomerUpdatedHandler();
        System.out.println("Generic Superclasses of CustomerUpdatedHandler: " + 
                           CustomerUpdatedHandler.class.getGenericSuperclass());
        eventBus.match(CustomerUpdated.class, customerUpdatedHandler);
        eventBus.match(CustomerUpdated.class, new Notifier());
        
        eventBus.match(SomethingOccurred.class.getName(), 
                       new SomethingOccuredHandler());
        
        CommandBus commandBus = new CommandBus();        
        CustomerFacade customerFacade = new CustomerFacade(commandBus);
        
        UpdateCustomerHandler updateCustomerHandler = 
            new UpdateCustomerHandler(customerRepository, eventBus);
        System.out.println("UpdateCustomer class: " + UpdateCustomer.class);
        System.out.println("Generic Superclasses of UpdateCustomerHandler: " + 
                           updateCustomerHandler.getClass().getGenericSuperclass());
        commandBus.match(UpdateCustomer.class, updateCustomerHandler);
        
        customerFacade.update(c.getCustomerId(), "André Harold Juffer");
        
        Customer updated = customerRepository.forCustomerId(customerId);
        System.out.println("Updated customer: " + updated);
    }
    
}
