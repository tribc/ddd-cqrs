/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */
package com.tribc.ddd.domain.handling;

/**
 * Encapsulates an exception thrown if no handler is register for a handle.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class NoHandlerException 
    extends RuntimeException
{
    public NoHandlerException()
    {
        super();
    }
    
    public NoHandlerException(Throwable cause)
    {
        super(cause);
    }
    
    public NoHandlerException(String message)
    {
        super(message);
    }
    
    public NoHandlerException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
