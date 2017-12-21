/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

/**
 * Deals with or manages a handleable.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Handleable type.
 */
public interface Handler<T extends Handleable>
{
    /**
     * Deals with a handleable
     * @param handleable Handleable
     */
    void handle(T handleable);
}
