/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import java.time.Instant;
import com.tribc.ddd.domain.handling.Handleable;

/**
 * Specifies what a client application wants to get done.
 * @author  Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Command 
    extends Handleable
{
    /**
     * Returns timestamp this command was issued.
     * @return Timestamp.
     */
    Instant issuedOn();
}
