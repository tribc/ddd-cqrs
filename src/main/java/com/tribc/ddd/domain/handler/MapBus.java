/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.cqrs.domain.handleable.HandleableId;
import lombok.NonNull;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple implementation that uses a map to match a handle with multiple handlers.
 * A handleable identifier serves as the key to link handlers to the handleable.
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public abstract class MapBus extends AbstractBus {

    private static final Logger logger = Logger.getLogger(MapBus.class.getName());

    // Key is the handleable identifier. Value are the handlers for the handleable.
    private final Map<HandleableId, Set<Handler>> handlers;

    public MapBus() {
        super();
        this.handlers = new HashMap<>();
    }

    /**
     * All handlers for each handeable.
     *
     * @return Unmodifiable map.
     */
    public Map<HandleableId, Set<Handler>> getHandlers() {
        return Collections.unmodifiableMap(this.handlers);
    }

    public void match(@NonNull HandleableId handleableId,
                      @NonNull Handler handler) {
        if (this.handlers.containsKey(handleableId)) {
            Set<Handler> hs = this.handlers.get(handleableId);
            hs.add(handler);
        } else {
            Set<Handler> hs = new HashSet<>();
            hs.add(handler);
            this.handlers.put(handleableId, hs);
        }
    }

    /**
     * Handles or deals with a handleable.After handling, the handleable is notified that it
     * has been dealt with.
     *
     * @param handleable Handleable.
     */
    public void handle(@NonNull Handleable handleable) {
        HandleableId handleableId = handleable.getHandleableId();
        if (!this.containsHandlerFor(handleable)) {
            throw new IllegalArgumentException(
                    handleable.getHandleableId().getValue() +
                            ": No handler registered for this handleable."
            );
        }

        if (handleable.isNotHandled()) {

            // Mark ongoing handling of handeable.
            handleable.markOngoing();

            // Find the handeable's handlers. Multiple handlers may exists.
            Set<Handler> hs = this.handlers.get(handleableId);
            hs.forEach((handler) -> handler.handle(handleable));

            // Mark handling is complete.
            handleable.markHandled();
        } else {
            logger.log(Level.WARNING, handleable.getHandleableId() + ": Not handling this headable.");
        }
    }

    protected boolean containsHandlerFor(@NonNull Handleable handleable) {
        return this.handlers.containsKey(handleable.getHandleableId());
    }
}

