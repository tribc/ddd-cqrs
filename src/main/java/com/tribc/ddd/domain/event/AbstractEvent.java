package com.tribc.ddd.domain.event;

import com.tribc.cqrs.domain.handleable.AbstractHandleable;
import com.tribc.cqrs.domain.handleable.HandleableId;
import lombok.Getter;
import lombok.NonNull;

import java.time.Instant;

/**
 * Base class for domain events.
 */
public class AbstractEvent extends AbstractHandleable implements Event {

    @Getter
    private final Instant occurredOn;

    protected AbstractEvent(@NonNull HandleableId handleableId) {
        super(handleableId);
        occurredOn = Instant.now();
    }

    @Override
    public Instant occurredOn() {
        return this.getOccurredOn();
    }

}
