/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.Handleable;

import java.time.Instant;

/**
 * Specifies a task.
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Command extends Handleable {

    /**
     * Returns timestamp this command was issued.
     *
     * @return Timestamp.
     */
    Instant issuedOn();
}
