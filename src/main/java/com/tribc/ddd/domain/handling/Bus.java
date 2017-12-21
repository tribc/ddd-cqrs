/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import java.util.Collection;

/**
 * Receives a handleable, and matches it to handlers that subsequently 
 * deal with it.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Bus
{
    /**
     * Deals with a single handleable.
     * @param handleable Handleable.
     */
    void handle(Handleable handleable);
    
    /**
     * Handles multiple handles.
     * @param handleables Handleable collection.
     */
    void handle(Collection<? extends Handleable> handleables);
}
