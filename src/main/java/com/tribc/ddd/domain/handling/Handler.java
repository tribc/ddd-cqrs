/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

/**
 * Handles something of type T.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Handled type. An instance of T is handled by this handler.
 */
public interface Handler<T extends Handled>
{
    /**
     * Handles t
     * @param t Handled.
     */
    void handle(T t);
}
