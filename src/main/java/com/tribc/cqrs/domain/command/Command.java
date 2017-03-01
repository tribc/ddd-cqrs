/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.ddd.domain.handling.Handle;
import java.time.Instant;

/**
 * Specifies what a client application wants to get done (a task).
 * @author  Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Command 
    extends Handle
{
    /**
     * Returns time-stamp this command was issued.
     * @return Time-stamp.
     */
    Instant issuedOn();
}
