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

/**
 *
 * @author André Juffer, Triacle Biocomputing
 * @param <T> Handleable type.
 * @param <R> Result type.
 */
public class MapReactiveBus <T extends Handleable, R> extends AbstractReactiveBus<T,R> {
    
    private final Map<String, Set<ReactiveHandler<R>>> handlers;
    
    public MapReactiveBus()
    {
        super();
        handlers = new HashMap<>();
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
     * Handles or deals with a handleable.After handling, the handleable is 
     * notified that it has been dealt with.
     * @param handleable Handleable.
     * @return Publisher with results.
     * @throws IllegalStateException if no handlers are registered for the 
     * handleable or if handleable was already handled.
     */
    @Override
    public Flux<R> handle(Handleable handleable)
    {
        if ( !handleable.isHandled() && !handleable.isOngoing() ) {
            String id = handleable.getHandleableId().getValue();
             
            if ( !this.handlers.containsKey(id) ) {
                return Flux.error(new IllegalStateException(
                    id + ": No handler registered for this handleable."
                ));
            }                
            
            // Mark ongoing handling of handleable.
            handleable.ongoing();
            Set<ReactiveHandler<R>> hs = this.handlers.get(id);
            Flux<ReactiveHandler<R>> flux = Flux.fromIterable(this.handlers.get(id));
            
            // There should be a better way!
            Flux<R> results = flux.map(h -> h.handle(handleable).block());
            
            // Mark handling is complete.
            handleable.handled();
            
            return results;        
        }
        return Flux.error(new IllegalStateException(
            handleable.getHandleableId() + ": Already handled or handling ongoing.")
        );
    }

}
