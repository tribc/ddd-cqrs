/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.test;

import com.tribc.ddd.domain.event.AbstractEvent;
import com.tribc.ddd.domain.handling.HandleableId;

/**
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class CustomerUpdated extends AbstractEvent {
    
    private final Long customerId_;
    
    public static final HandleableId HANDLEABLE_ID = 
        HandleableId.valueOf(CustomerUpdated.class);
        
    public CustomerUpdated(Long customerId)
    {
        super(HANDLEABLE_ID);
        customerId_ = customerId;
    }
    
    public Long getCustomerId()
    {
        return customerId_;
    }
}
