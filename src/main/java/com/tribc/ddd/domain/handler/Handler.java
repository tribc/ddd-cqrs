/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;

/**
 * Deals with or manages/handles a Handleable.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Handler {
    
    /**
     * Deals with a handleable
     * @param handleable Handleable
     */
    void handle(Handleable handleable);
}
