/*
 * The MIT License
 *
 * Copyright 2017 André J. Juffer, Triacle Biocomputing
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
package com.tribc.test;

import com.tribc.ddd.domain.event.EventHandler;
import com.tribc.cqrs.domain.handleable.Handleable;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class Notifier extends EventHandler<CustomerUpdated> {
    
    public Notifier()
    {
        super();
    }

    private void handle(CustomerUpdated handleable)
    {
        Long customerId = handleable.getCustomerId();
        System.out.println("NOTICE: Customer #" + customerId + " has updated customer information.");
    }

    @Override
    public void handle(Handleable handleable) 
    {
        this.handle((CustomerUpdated)handleable);
    }
}
