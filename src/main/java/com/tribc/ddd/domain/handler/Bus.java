/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;
import lombok.NonNull;

import java.util.Collection;

/**
 * Matches Handleable to Handlers who deal with them.
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Bus {

    /**
     * Deals with or handles a single Handleable.
     *
     * @param handleable Handleable.
     */
    void handle(@NonNull Handleable handleable);

    /**
     * Handles multiple Handleables.
     *
     * @param handleables Handleable collection.
     */
    void handle(@NonNull Collection<Handleable> handleables);
}
