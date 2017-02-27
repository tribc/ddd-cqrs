/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import java.util.Collection;

/**
 * Signifies that an implementing entity may raise domain events.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Eventful 
{
    /**
     * Returns all raised domain events.
     * @return Domain events. May be empty. Never null.
     */
    Collection<DomainEvent> getDomainEvents();
    
    /**
     * Clear entity from all domain events. Typically called after all domain
     * events have been handled.
     */
    void clearDomainEvents();
}
