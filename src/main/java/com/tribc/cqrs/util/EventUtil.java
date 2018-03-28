/*
 * The MIT License
 *
 * Copyright 2018 Andr&#233; Juffer, Triacle Biocomputing
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

package com.tribc.cqrs.util;

import com.tribc.ddd.domain.event.Event;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class EventUtil {
    
    private EventUtil()
    {        
    }
    
    /**
     * Selects events currently not being handled from a list of events.
     * @param events Events.
     * @return Events. May be empty.
     */
    public static Collection<Event> selectUnhandled(Collection<Event> events)
    {
        Collection<Event> unhandled = new HashSet<>();
        events.stream().filter((event) -> ( !event.isHandled() || !event.handlingNow() )).forEachOrdered((event) -> {
            unhandled.add(event);
        });
        return unhandled;
        
    }
    

}
