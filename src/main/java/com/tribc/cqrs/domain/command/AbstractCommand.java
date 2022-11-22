package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.AbstractHandleable;
import com.tribc.cqrs.domain.handleable.HandleableId;
import lombok.Getter;
import lombok.NonNull;

import java.time.Instant;

/**
 * Base class for commands.
 */
public class AbstractCommand extends AbstractHandleable implements Command {

    @Getter
    private final Instant issuedOn;

    protected AbstractCommand(@NonNull HandleableId handleableId) {
        super(handleableId);
        this.issuedOn = Instant.now();
    }

    @Override
    public Instant issuedOn() {
        return this.getIssuedOn();
    }

}
