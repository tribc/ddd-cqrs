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

package com.tribc.ddd.domain.handling;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import reactor.core.publisher.Flux;

/**
 * Base class for a reactive bus.
 * @author André Juffer, Triacle Biocomputing
 * @param <T> Handleable type.
 * @param <R> Result type.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractReactiveBus<T extends Handleable, R> 
    implements ReactiveBus<R> {
    
    /**
     * Matches handleable to handler.
     * @param id Identifier.
     * @param handler Handler.
     */
    public abstract void match(@NonNull HandleableId id, 
                               @NonNull ReactiveHandler<R> handler);

    @Override
    public abstract Flux<R> handle(Handleable handleable);

}