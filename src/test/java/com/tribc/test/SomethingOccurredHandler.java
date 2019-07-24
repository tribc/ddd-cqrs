/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */
package com.tribc.test;

import com.tribc.ddd.domain.event.EventHandler;
import com.tribc.ddd.domain.handling.Handleable;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class SomethingOccurredHandler 
    extends EventHandler<SomethingOccurred>
{
    public SomethingOccurredHandler()
    {        
    }
    
    @Override
    public void handle(Handleable handleable) {
        this.handle((SomethingOccurred)handleable);
    }
    
    private void handle(SomethingOccurred event) 
    {
        System.out.println("Something occured with customer #" + event.getCustomerId());        
    }

 }
