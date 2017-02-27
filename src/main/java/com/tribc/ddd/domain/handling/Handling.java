/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import com.tribc.ddd.domain.event.DomainEvent;
import com.tribc.ddd.domain.event.Eventful;
import java.util.Collection;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Entity type.
 */
public class Handling<T extends Eventful> 
{
    
    protected void publish(T entity)
    {
        Collection<DomainEvent> domainEvents = entity.getDomainEvents();
    }
}
