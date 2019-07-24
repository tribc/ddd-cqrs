/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import java.util.Collection;

/**
 * Receives Handleables, and matches each Handleable to Handlers that subsequently 
 * deal with them.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Bus
{
    /**
     * Deals with or handles a single Handleable.
     * @param handleable Handleable.
     */
    void handle(Handleable handleable);
    
    /**
     * Handles multiple Handleables.
     * @param handleables Handleable collection.
     */
    void handle(Collection<? extends Handleable> handleables);
}
