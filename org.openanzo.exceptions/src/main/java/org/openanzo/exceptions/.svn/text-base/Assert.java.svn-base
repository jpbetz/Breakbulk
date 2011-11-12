/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.exceptions;

/**
 * Basic Assert functionality used since JVMs don't always enfore the java assert statement
 * 
 * @author
 * 
 */
public class Assert {
    /**
     * Throw exception if assertion is false
     * 
     * @param assertion
     *            test that needs to be true
     */
    public static void isTrue(final boolean assertion) {
        if (!assertion) {
            throw new AssertionError("Assertion failed.");
        }
    }
}
