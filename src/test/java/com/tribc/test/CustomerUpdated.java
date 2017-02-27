/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.test;

import com.tribc.ddd.domain.event.AbstractDomainEvent;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class CustomerUpdated extends AbstractDomainEvent    
{
    private final Customer customer_;
    private boolean handled_;
        
    public CustomerUpdated(Customer customer)
    {
        super();
        customer_ = customer;
        handled_ = false;
    }
    
    public Customer getCustomer()
    {
        return customer_;
    }

    @Override
    public boolean isHandled() 
    {
        return handled_;
    }
    
    public void handled()
    {
        handled_ = true;
    }
}
