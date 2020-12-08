/*
 * The MIT License
 *
 * Copyright 2018 juffer.
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

package com.tribc.ddd.domain.handler;

/**
 * Encapsulates an exception thrown when no handler can be found for a handleable.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public class NoHandlerException 
        extends RuntimeException 
{
    /**
     * Creates new exception.
     */
    public NoHandlerException()
    {
        super();
    }
    
    /**
     * Creates new exception.
     * @param throwable Cause.
     */
    public NoHandlerException(Throwable throwable)
    {
        super(throwable);
    }
    
    /**
     * Creates new exception.
     * @param message Message explaining reason for throwing this exception.
     */
    public NoHandlerException (String message)
    {
        super(message);
    }
    
    /**
     * Creates new exception
     * @param message Message explaining reason for throwing this exception.
     * @param throwable Cause.
     */
    public NoHandlerException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
