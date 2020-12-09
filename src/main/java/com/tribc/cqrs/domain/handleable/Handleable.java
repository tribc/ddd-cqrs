/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.cqrs.domain.handleable;

import java.time.Instant;

/**
 * Something that is capable of being handled or dealt with.
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Handleable {

    /**
     * Marks that this handleable is being dealt with right now.
     */
    void markOngoing();

    /**
     * Is this handleable currently being dealt with?
     *
     * @return Result.
     */
    boolean isNotOngoing();

    /**
     * Marks that this handleable has been dealt with.
     */
    void markHandled();

    /**
     * Was this handleable already being dealt with?
     *
     * @return Result.
     */
    boolean isNotHandled();

    /**
     * Returns timestamp this handleable was dealt with.
     *
     * @return Timestamp.
     */
    Instant handledOn();

    /**
     * Returns an identifier that uniquely identifies this handleable.
     *
     * @return Identifier.
     */
    HandleableId getHandleableId();
}
