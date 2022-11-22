package com.tribc.ddd.domain.handler;

import com.tribc.cqrs.domain.handleable.Handleable;
import com.tribc.cqrs.domain.handleable.HandleableId;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * A simple implementation that uses a map to match a handle with multiple handlers.
 * A handleable identifier serves as the key to link handlers to the handleable.
 */
@Slf4j
public abstract class MapBus extends AbstractBus {

    // Key is the handleable identifier.
    // Value are the handlers for the handleable.
    private final Map<HandleableId, Set<Handler>> handlers;

    protected MapBus() {
        super();
        this.handlers = new HashMap<>();
    }

    /**
     * All handlers for each handleable.
     *
     * @return Unmodifiable map.
     */
    public Map<HandleableId, Set<Handler>> getHandlers() {
        return Collections.unmodifiableMap(this.handlers);
    }

    public void match(@NonNull HandleableId handleableId,
                      @NonNull Handler handler) {
        log.trace("match()");
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
     * Handles a handleable sequentially. After handling, the handleable is notified that
     * it was handled.
     *
     * @param handleable Handleable.
     * @throws MissingHandlerException if no handler exists for the given handleable.
     */
    public void handle(@NonNull Handleable handleable) {
        log.trace("handle()");
        HandleableId handleableId = handleable.getHandleableId();
        if (!this.containsHandlerFor(handleable)) {
            throw new MissingHandlerException(
                handleable.getHandleableId().getValue() + ": Handleable."
            );
        }

        if (!handleable.isHandled()) {
            // Mark handleable as ongoing.
            handleable.markOngoing();

            // Find the handleable's handlers. Multiple handlers may exist.
            Set<Handler> hs = this.handlers.get(handleableId);
            hs.forEach((handler) -> handler.handle(handleable));

            // Mark handleable as handled.
            handleable.markHandled();
        } else {
            log.warn(handleable.getHandleableId() + ": Handleable already handled. Skipping.");
        }
    }

    /**
     * Whether there exists a handler for the given handleable.
     * @param handleable Handleable.
     * @return Result.
     */
    protected boolean containsHandlerFor(@NonNull Handleable handleable) {
        return this.handlers.containsKey(handleable.getHandleableId());
    }
}

