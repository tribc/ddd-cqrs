/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */
package com.tribc.test;

import com.tribc.ddd.domain.event.AbstractEvent;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class SomethingOccurred 
    extends AbstractEvent
{
    private final Long customerId_;
    
    public SomethingOccurred(Long customerId)
    {
        super(SomethingOccurred.class.getName());
        customerId_ = customerId;
    }
    
    public Long getCustomerId()
    {
        return customerId_;
    }
}
