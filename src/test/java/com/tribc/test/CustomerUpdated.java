/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.test;

import com.tribc.ddd.domain.event.AbstractEvent;
import com.tribc.cqrs.domain.handleable.HandleableId;
import lombok.Getter;
import lombok.NonNull;

/**
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class CustomerUpdated extends AbstractEvent {

    public static final HandleableId HANDLEABLE_ID = HandleableId.of(CustomerUpdated.class);

    @Getter
    private final Long customerId;

    public CustomerUpdated(@NonNull Long customerId) {
        super(HANDLEABLE_ID);
        this.customerId = customerId;
    }

}
