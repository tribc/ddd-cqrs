/*
 * The MIT License
 *
 * Copyright 2019 André Juffer, Triacle Biocomputing.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.tribc.cqrs.domain.handleable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

/**
 * Uniquely identifies an Handleable.
 *
 * @author André Juffer, Triacle Biocomputing
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
