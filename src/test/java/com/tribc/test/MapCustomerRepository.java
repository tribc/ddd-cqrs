/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ajuffer
 */
public class MapCustomerRepository 
    implements CustomerRepository
{
    private final Map<Long, Customer> customers_;
    
    public MapCustomerRepository()
    {
        customers_ = new HashMap<>();
    }

    @Override
    public Customer forCustomerId(Long customerId) 
    {
        return customers_.get(customerId);
    }

    @Override
    public void add(Customer customer) 
    {
        customers_.put(customer.getCustomerId(), customer);
    }

    @Override
    public void update(Customer customer) 
    {
        customers_.put(customer.getCustomerId(), customer);
    }
    
}
