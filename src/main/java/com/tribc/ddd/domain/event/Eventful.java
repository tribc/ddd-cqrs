/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import java.util.Collection;

/**
 * Marks that some entity may raise events.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Eventful 
{
    /**
     * Returns all raised events.
     * @return Domain events. May be empty. Never null.
     */
    Collection<Event> getEvents();
    
    /**
     * Clear entity from all events. Typically called after all 
     * events have been handled.
     */
    void clearEvents();
}
