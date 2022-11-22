package com.tribc.cqrs.domain.handleable;

import java.time.Instant;

/**
 * Something that can be handled or dealt with.
 */
public interface Handleable {

    /**
     * Marks this handleable as being handled right now.
     */
    void markOngoing();

    /**
     * Whether this handleable is currently (now) being handled with.
     *
     * @return Result.
     * @deprecated
     * @see #isOngoing()
     */
    @Deprecated
    boolean isNotOngoing();

    /**
     * Whether this handleable is being handled right now.
     *
     * @return Result.
     */
    boolean isOngoing();

    /**
     * Marks this handleable as handled.
     */
    void markHandled();

    /**
     * Whether this handleable was already handled.
     *
     * @return Result.
     * @deprecated
     * @see #isHandled()
     */
    @Deprecated
    boolean isNotHandled();

    /**
     * Whether this handleable was already handled.
     * @return Result.
     */
    boolean isHandled();

    /**
     * Returns timestamp this handleable was handled. If this handleable was not yet handled,
     * returns Instant.ofEpochMilli(0).
     *
     * @return Timestamp.
     */
    Instant handledOn();

    /**
     * Returns an identifier that uniquely identifies this handleable.
     *
     * @return Identifier.
     */
    HandleableId getHandleableId();
}
