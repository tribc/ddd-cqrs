/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import com.tribc.ddd.domain.event.Eventful;
import java.util.Collection;
import java.util.HashSet;
import com.tribc.ddd.domain.event.Event;
import lombok.ToString;

/**
 *
 * @author ajuffer
 */
@ToString
public class Customer 
    implements Eventful
{
    private final Long customerId_;
    private String name_;
    private final Collection<Event> events_;
    
    public Customer(Long customerId, String name)
    {
        customerId_ = customerId;
        name_ = name;
        events_ = new HashSet<>();
    }
    
    public Long getCustomerId()
    {
        return customerId_;
    }
    
    public void updateName(String name)
    {
        name_ = name;
        events_.add(new CustomerUpdated(customerId_));
        events_.add(new SomethingOccurred(customerId_));
    }

    @Override
    public Collection<Event> getEvents() 
    {
        return events_;
    }

    @Override
    public void clearEvents() 
    {
        events_.clear();
    }
    
}
