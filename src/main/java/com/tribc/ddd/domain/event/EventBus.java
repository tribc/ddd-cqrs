/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.ddd.domain.handling.MapBus;
import java.util.Collection;

/**
 * Handles events raised.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Event type.
 */
public class EventBus<T extends Event>
    extends MapBus<T, EventHandler<T> >
{
    public EventBus()
    {
        super();
    }    
}
