/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.AbstractHandleable;
import com.tribc.cqrs.domain.handleable.HandleableId;
import lombok.NonNull;

import java.time.Instant;

/**
 * Base class for all commands.
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class AbstractCommand extends AbstractHandleable implements Command {

    private final Instant issuedOn_;

    protected AbstractCommand(@NonNull HandleableId handleableId) {
        super(handleableId);
        issuedOn_ = Instant.now();
    }

    @Override
    public Instant issuedOn() {
        return issuedOn_;
    }

}
