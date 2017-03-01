/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.ddd.domain.handling.AbstractHandler;
import com.tribc.ddd.domain.handling.Handle;

/**
 * Handles events.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <E> Event of type E.
 */
public abstract class EventHandler<E extends Handle> 
    extends AbstractHandler<E>
{
    protected EventHandler()
    {
        super();
    }
}
