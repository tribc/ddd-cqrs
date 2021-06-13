/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.handleable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * Base class for an handleable.
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class AbstractHandleable implements Handleable {

    @Getter
    private final HandleableId handleableId;

    private boolean handled;
    private boolean handling;

    @Setter(AccessLevel.PRIVATE)
    private Instant time;

    protected AbstractHandleable(HandleableId handlebleId) {
        this.handleableId = handlebleId;
        this.handled = false;
        this.handling = false;
        this.time = Instant.ofEpochMilli(0);
    }

    @Override
    public void markHandled() {
        this.handled = true;
        this.handling = false;
        this.setTime(Instant.now());
    }

    @Override
    public boolean isNotHandled() {
        return !this.handled;
    }

    @Override
    public Instant handledOn() {
        return this.time;
    }

    @Override
    public void markOngoing() {
        this.handling = true;
    }

    @Override
    public boolean isNotOngoing() {
        return this.handling;
    }

}
