/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */
package com.tribc.test;

import com.tribc.ddd.domain.event.EventHandler;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class SomethingOccuredHandler 
    extends EventHandler<SomethingOccurred>
{
    public SomethingOccuredHandler()
    {        
    }
    
    @Override
    public void handle(SomethingOccurred event) 
    {
        if ( !event.isHandled() ) {
            System.out.println("Something occured with customer #" + event.getCustomerId());
        }
    }
    
}
