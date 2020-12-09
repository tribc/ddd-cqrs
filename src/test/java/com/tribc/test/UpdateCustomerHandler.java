/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.cqrs.domain.command.CommandHandler;
import com.tribc.ddd.domain.event.QueueEventBus;

/**
 * @author ajuffer
 */
public class UpdateCustomerHandler extends CommandHandler<UpdateCustomer> {
    private final CustomerRepository customerRepository;
    private QueueEventBus eventBus;

    public UpdateCustomerHandler(CustomerRepository customerRepository, QueueEventBus eventBus) {
        this.customerRepository = customerRepository;
        this.eventBus = eventBus;
    }

    @Override
    public void handle(UpdateCustomer command) {
        Customer customer = this.customerRepository.forCustomerId(command.getCustomerid());
        customer.updateName(command.getName());
        this.customerRepository.update(customer);
        this.eventBus.add(customer);
        System.out.println("UpdateCustomerHandler: EventBus has events? Result: " + this.eventBus.hasEvents());
    }

}
