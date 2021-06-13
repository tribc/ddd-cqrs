package com.tribc.cqrs.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Marks method as an command handler.
 */
@Target({ElementType.METHOD})
public @interface CommandHandler {
}
