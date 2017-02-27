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
public class TestCustomerUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        CustomerRepository r = new MapCustomerRepository();
        Customer c = new Customer(new Long(1), "Foo Bar");
        r.add(c);
        
        
    }
    
}
