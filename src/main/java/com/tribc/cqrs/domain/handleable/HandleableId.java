package com.tribc.cqrs.domain.handleable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

/**
 * Uniquely identifies an Handleable.
 */
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HandleableId {

    String value;

    /**
     * Creates an identifier for a given class.
     *
     * @param clazz Class.
     * @return Identifier.
     */
    public static HandleableId of(@NonNull Class<?> clazz) {
        return new HandleableId(clazz.getName());
    }

    /**
     * Creates an identifier from a given non-empty value.
     *
     * @param value Value.
     * @return Identifier.
     * @deprecated
     */
    @Deprecated
    public static HandleableId of(@NonNull String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(
                    "HandleableId: value must not be empty."
            );
        }
        return new HandleableId(value);
    }

    /**
     * Generates an identifier.
     *
     * @return Identifier.
     * @deprecated
     */
    @Deprecated
    public static HandleableId generate() {
        return new HandleableId(UUID.randomUUID().toString());
    }

}
