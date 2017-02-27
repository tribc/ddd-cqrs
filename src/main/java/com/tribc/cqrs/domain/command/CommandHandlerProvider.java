/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.ddd.domain.handling.internal.AbstractHandlerProvider;

/**
 * Holds available command handlers.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class CommandHandlerProvider 
    extends AbstractHandlerProvider<CommandHandler, Command>
{
    public CommandHandlerProvider()
    {
        super();
    }
}
