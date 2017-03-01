/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.ddd.domain.handling.MapBus;

/**
 * Receives a command and matches a handler to it.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Command type
 */
public class CommandBus<T extends Command>
    extends MapBus<T, CommandHandler<T> >
{
    public CommandBus()
    {
        super();
    }
}
