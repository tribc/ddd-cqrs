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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author André Juffer, Triacle Biocomputing
 * @param <T> Handleable type.
 * @param <R> Result type.
 */
public class MappingReactiveBus<T extends Handleable, R> extends AbstractReactiveBus <T,R> {
    
    private final Map<String, Set<ReactiveHandler<R>>> handlers;
    
    public MappingReactiveBus()
    {
        super();
        this.handlers = new HashMap<>();
    }

    @Override
    public void match(HandleableId handleableId, ReactiveHandler<R> handler) 
    {
        String id = handleableId.getValue();
        if ( this.handlers.containsKey(id) ) {
            Set<ReactiveHandler<R>> hs = this.handlers.get(id);
            hs.add(handler);
        } else {
            Set<ReactiveHandler<R>> hs = new HashSet<>();
            hs.add(handler);
            this.handlers.put(id, hs);
        }
    }

    /**
     * Handles or deals with handleable. After handling, the handleable is notified
     * that it has been handled.
     * @param handleable Handleable.
     * @return Publishers of results.
     */
    @Override
    public Flux<R> handle(Handleable handleable) 
    {
        String id = handleable.getHandleableId().getValue();
        
        if ( handleable.isHandled() || handleable.isOngoing() ) {
            return Flux.error(new IllegalStateException(
                id + ": Already handled."
            ));
        }
        
        if ( !this.handlers.containsKey(id) ) {
            return Flux.error(new NoHandlerException(
                id + ": No handler for this handleable."
            ));
        }
        
        handleable.ongoing();
        Set<ReactiveHandler<R>> hs = this.handlers.get(id);
        Flux<ReactiveHandler<R>> flux = Flux.fromIterable(hs);
        
        // There should be a better way.
        Flux<R> results = 
            flux.map(h -> h.handle(handleable).block());
        
        
        
        
        // Mark handled.
        handleable.handled();
        
        return results;
    }
    
    private Mono<R> handled(R result, Handleable handleable)
    {
        handleable.isHandled();
        return Mono.just(result);
    }

}
