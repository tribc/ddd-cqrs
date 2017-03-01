/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.ddd.domain.handling.AbstractHandler;
import com.tribc.ddd.domain.handling.Handle;

/**
 * Executes a command issued by client application.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Command type.
 */
public abstract class CommandHandler<T extends Handle> 
    extends AbstractHandler<T>
{
    protected CommandHandler()
    {
        super();
    }

}
