/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */
package com.tribc.ddd.domain.handling;

/**
 *
 * @author Andr&#233; Juffer, Triacle Biocomputing
 * @param <T> Handle type.
 */
public abstract class AbstractHandler<T extends Handle>
    implements Handler<T>
{
    protected AbstractHandler()
    {
    }
}
