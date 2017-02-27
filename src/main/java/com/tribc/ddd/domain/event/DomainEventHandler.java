/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.ddd.domain.handling.Handler;

/**
 * Handles events raised by the domain.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <E> Domain event type.
 */
public interface DomainEventHandler<E extends DomainEvent> extends Handler<E>
{
    /**
     * Handles a domain event.
     * @param domainEvent Domain event.
     */
    @Override
    void handle(E domainEvent);
}
