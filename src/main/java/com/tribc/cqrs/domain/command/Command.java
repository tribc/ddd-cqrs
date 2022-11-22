package com.tribc.cqrs.domain.command;

import com.tribc.cqrs.domain.handleable.Handleable;

import java.time.Instant;

/**
 * Specifies a task, a command that must be executed.
 */
public interface Command extends Handleable {

    /**
     * Returns timestamp this command was issued.
     *
     * @return Timestamp.
     */
    Instant issuedOn();
}
