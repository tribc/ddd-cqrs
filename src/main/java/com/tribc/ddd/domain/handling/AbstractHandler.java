/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */
package com.tribc.ddd.domain.handling;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Handleable type.
 */
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public abstract class AbstractHandler<T extends Handleable> implements Handler {
    
    @Override
    public abstract void handle(Handleable handleable);
    
}
