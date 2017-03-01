/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */
package com.tribc.test;

import java.lang.reflect.Type;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class TestUpdateCustomer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        UpdateCustomer command = new UpdateCustomer(Long.valueOf(1), "Ata Bos");
        Type[] types = command.getClass().getGenericInterfaces();
        System.out.println("Types: " + types);
        System.out.println("Generic superclass: " + command.getClass().getGenericSuperclass());
        System.out.println("Issued on: " + command.issuedOn());
    }
    
}
