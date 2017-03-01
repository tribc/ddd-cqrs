/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribc.test;

/**
 *
 * @author ajuffer
 */
public interface CustomerRepository 
{
    Customer forCustomerId(Long customerId);
    
    void add(Customer customer);
    
    void update(Customer customer);
}
