/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.ddd.domain.handling.Handled;
import java.util.Date;

/**
 * Event raised by the domain.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface DomainEvent extends Handled
{  
    /**
     * Returns date or time this event was raised.
     * @return Date.
     */
    Date occuredOn();
}
