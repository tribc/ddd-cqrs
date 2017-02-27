/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.ddd.domain.event.DomainEvent;
import com.tribc.ddd.domain.event.Eventful;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author ajuffer
 */
public class Customer 
    implements Eventful
{
    private final Long customerId_;
    private String name_;
    private final Collection<DomainEvent> domainEvents_;
    
    public Customer(Long customerId, String name)
    {
        customerId_ = customerId;
        name_ = name;
        domainEvents_ = new HashSet<>();
    }
    
    public Long getCustomerId()
    {
        return customerId_;
    }
    
    public void setName(String name)
    {
        name_ = name;
        domainEvents_.add(new CustomerUpdated(this));
        
    }

    @Override
    public Collection<DomainEvent> getDomainEvents() 
    {
        return domainEvents_;
    }

    @Override
    public void clearDomainEvents() 
    {
        domainEvents_.clear();
    }
}
