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
package org.openanzo.rdf.utils;

/**
 * Pretty print interface for types to provide a verbose string representation that is to verbose, to expensive to compute, or otherwise inappropriate for
 * toString().
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public interface PrettyPrintable {
    /**
     * Write verbose string representation to the output builder
     * 
     * @param output
     *            output builder to which data is written
     */
    public void prettyPrint(StringBuilder output);
}
