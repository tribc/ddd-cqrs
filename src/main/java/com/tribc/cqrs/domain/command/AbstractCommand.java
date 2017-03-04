/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.ddd.domain.handling.AbstractHandle;
import java.time.Instant;

/**
 * Base class for all commands.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class AbstractCommand
    extends AbstractHandle
    implements Command
{
    private final Instant time_;
    
    protected AbstractCommand(String handleId)
    {
        super(handleId);
        time_ = Instant.now();
    }
    
    @Override
    public Instant issuedOn()
    {
        return time_;
    }
    
}
