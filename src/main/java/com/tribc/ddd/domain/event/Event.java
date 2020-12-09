/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.cqrs.domain.handleable.Handleable;

import java.time.Instant;

/**
 * Event raised in the domain, a domain event.
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Event extends Handleable {

    /**
     * Returns the timestamp of this event.
     *
     * @return Timestamp.
     */
    Instant occurredOn();
}
