/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

import java.util.Collection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Base class for a bus.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Handleable type.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractBus<T extends Handleable> implements Bus {
    
    /**
     * Matches handleable to handler.
     * @param id Identifier.
     * @param handler Handler.
     */
    public abstract void match(@NonNull HandleableId id, @NonNull Handler handler);
    
    @Override
    public abstract void handle(@NonNull Handleable handleable);
    
    @Override
    public void handle(@NonNull Collection<? extends Handleable> handleables)
    {
        handleables.forEach(handleable -> this.handle(handleable));
    }
    
}
