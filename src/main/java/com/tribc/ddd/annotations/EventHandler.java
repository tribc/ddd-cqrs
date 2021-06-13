package com.tribc.ddd.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Marks method as an event handler.
 */
@Target({ElementType.METHOD})
public @interface EventHandler {
}
