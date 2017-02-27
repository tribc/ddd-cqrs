/*
 * Copyright (c) Triacle Biocomputing. All rights reserved.
 * All information contained herein is proprietary and confidential to Triacle
 * Biocomputing.  Any use, reproduction, or disclosure without the written
 * permission of Triacle Biocomputing is prohibited.
 */

package com.tribc.ddd.domain.handling;

/**
 * Marks something that should be handled by some handler.
 * @author Andr&#233; Juffer, Triacle Biocomputing
 */
public interface Handled 
{
    /**
     * Was already handled by a handler?
     * @return Result.
     */
    boolean isHandled();
}
