package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.cqrs.domain.handleable.HandleableId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Collection;

/**
 * Base class for a bus.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractBus implements Bus {

    /**
     * Matches a handleable to a handler.
     *
     * @param handleableId Identifier.
     * @param handler      Handler.
     */
    public abstract void match(@NonNull HandleableId handleableId,
                               @NonNull Handler handler);

    @Override
    public abstract void handle(@NonNull Handleable handleable);

    @Override
    public void handle(@NonNull Collection<Handleable> handleables) {
        handleables.forEach(this::handle);
    }

}
