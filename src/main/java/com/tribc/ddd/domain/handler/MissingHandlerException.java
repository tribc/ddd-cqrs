package com.tribc.ddd.domain.handler;

/**
 * Encapsulates an exception thrown when no handler can be found for a handleable.
 */
public class MissingHandlerException extends RuntimeException {

    /**
     * Creates new exception.
     *
     * @param throwable Cause.
     */
    public MissingHandlerException(Throwable throwable) {
        super(throwable);
    }

    /**
     * Creates new exception.
     *
     * @param message Message explaining reason for throwing this exception.
     */
    public MissingHandlerException(String message) {
        super(message);
    }

    /**
     * Creates new exception
     *
     * @param message   Message explaining reason for throwing this exception.
     * @param throwable Cause.
     */
    public MissingHandlerException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
