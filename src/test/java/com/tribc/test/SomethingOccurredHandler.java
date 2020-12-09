/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */
package com.tribc.test;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.ddd.domain.event.EventHandler;

/**
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class SomethingOccurredHandler extends EventHandler<SomethingOccurred> {

    @Override
    public void handle(SomethingOccurred event) {
        System.out.println(SomethingOccurredHandler.class.getName() + ":");
        System.out.println("Something occured with customer #" + event.getCustomerId());
    }

}
