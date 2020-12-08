/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.cqrs.domain.command.CommandBus;
import com.tribc.cqrs.domain.command.CommandHandler;
import com.tribc.ddd.domain.event.EventBus;
import com.tribc.cqrs.domain.handleable.HandleableId;
import com.tribc.ddd.domain.handler.Handler;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author ajuffer
 */
public class TestHandling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Long customerId = 1L;
        CustomerRepository customerRepository = new MapCustomerRepository();
        Customer c = new Customer(customerId, "André H. Juffer");
        customerRepository.add(c);
        System.out.println("Customer before: " + c);
        
        EventBus eventBus = new EventBus();

        CustomerUpdatedHandler customerUpdatedHandler = new CustomerUpdatedHandler();
        
        System.out.println("Generic Superclasses of CustomerUpdatedHandler: " + 
                           CustomerUpdatedHandler.class.getGenericSuperclass());

        eventBus.match(CustomerUpdated.HANDLEABLE_ID, customerUpdatedHandler);
        eventBus.match(SomethingOccurred.HANDLEABLE_ID, new SomethingOccurredHandler());

        final Map<HandleableId, Set<Handler>> emap = eventBus.getHandlers();
        System.out.println("EventBus size: " + emap.size());
        emap.keySet().forEach(eid -> emap.get(eid).forEach(h -> {
            System.out.println(new StringBuilder()
                    .append("handleableId, handler: ")
                    .append(eid.getValue()).append(", ")
                    .append(h.getClass().getName())
                    .toString());
        }));
        
        CommandBus commandBus = new CommandBus();
        CustomerFacade customerFacade = new CustomerFacade(commandBus);
        
        UpdateCustomerHandler updateCustomerHandler =
                new UpdateCustomerHandler(customerRepository, eventBus);
        //System.out.println("UpdateCustomer class: " + UpdateCustomer.class);
        //System.out.println("Generic Superclasses of UpdateCustomerHandler: " +
        //                   updateCustomerHandler.getClass().getGenericSuperclass());
        commandBus.match(UpdateCustomer.HANDLEABLE_ID, updateCustomerHandler);

        final Map<HandleableId, Set<Handler>> cmap = commandBus.getHandlers();
        System.out.println("CommandBus size: " + cmap.size());
        cmap.keySet().forEach(cid -> {
            cmap.get(cid).forEach(h -> {
                System.out.println(new StringBuilder()
                        .append("handleableId, handler: ")
                        .append(cid.getValue()).append(", ")
                        .append(h.getClass().getName())
                        .toString());
            });
        });

        customerFacade.update(c.getCustomerId(), "André Harold Juffer");
        
        Customer updated = customerRepository.forCustomerId(customerId);
        System.out.println("Updated customer: " + updated);
    }
    
}
