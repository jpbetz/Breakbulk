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
package org.openanzo.rdf;

/**
 * Represents a SPARQL variable.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 *
 */
public interface Variable extends Bindable {

    /**
     * 
     * @return The name of the variable (excludes any leading ? or $ characters).
     */
    public abstract String getName();

    /**
     * Determines variable equality solely based on the name, rather than object equality.
     * 
     * @param other
     *            variable for which to determine equality
     * @return true if other variable's name is equal to this variables name
     */
    public abstract boolean equalName(Variable other);

}
