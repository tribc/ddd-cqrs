/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import java.time.Instant;
import com.tribc.ddd.domain.handling.Handleable;

/**
 * Event raised in the domain, a domain event.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Event 
    extends Handleable
{  
    /**
     * Returns the timestamp of this event.
     * @return Timestamp.
     */
    Instant occurredOn();
}
