package com.tribc.cqrs.domain.handleable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * Base class for handleables.
 *
 */
public class AbstractHandleable implements Handleable {

    @Getter
    private final HandleableId handleableId;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private boolean handled;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private boolean ongoing;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private Instant handledOn;

    protected AbstractHandleable(HandleableId handleableId) {
        this.handleableId = handleableId;
        this.setOngoing(false);
        this.setHandled(false);
        this.setHandledOn(Instant.ofEpochMilli(0));
    }

    @Override
    public void markHandled() {
        this.setHandled(true);
        this.setOngoing(false);
        this.setHandledOn(Instant.now());
    }

    @Override
    public boolean isNotHandled() {
        return !this.isHandled();
    }

    @Override
    public Instant handledOn() {
        return this.getHandledOn();
    }

    @Override
    public void markOngoing() {
        if ( this.isHandled() ) {
            throw new IllegalStateException("Handleable already handled.");
        }
        this.setOngoing(true);
    }

    @Override
    public boolean isNotOngoing() {
        return !this.isOngoing();
    }

}
