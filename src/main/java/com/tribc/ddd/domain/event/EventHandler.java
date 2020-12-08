/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.event;

import com.tribc.ddd.domain.handler.Handler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Handles events raised somewhere. Base class for all event handlers.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <E> Event type.
 */
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public abstract class EventHandler<E extends Event> implements Handler {

}
