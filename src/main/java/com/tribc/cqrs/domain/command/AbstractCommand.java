/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class AbstractCommand
    implements Command
{
    private boolean handled_;
    
    protected AbstractCommand()
    {
        handled_ = false;
    }

    @Override
    public boolean isHandled() 
    {
        return handled_;
    }
    
    /**
     * Signals that this command was handled.
     */
    public void handled()
    {
        handled_ = true;
    }

}
