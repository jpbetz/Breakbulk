/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/FunctionRegistry.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: FunctionRegistry.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression;

import java.util.HashMap;
import java.util.Map;

import org.openanzo.rdf.URI;

/**
 * A singleton class that maintains a mapping from function {@link URI}s to {@link Function}s
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class FunctionRegistry {
    static private FunctionRegistry theRegistry = null;

    /**
     * 
     * @return The singleton {@link FunctionRegistry} instance.
     */
    static public FunctionRegistry getRegistry() {
        if (theRegistry == null)
            theRegistry = new FunctionRegistry();
        return theRegistry;
    }

    /**
     * Register a function. It is a parse error if a query is received that references a function not registered in the {@link FunctionRegistry}.
     * 
     * @param name
     *            Identifies the function
     * @param f
     *            The function itself
     */
    public void registerFunction(URI name, Function f) {
        this.registry.put(name, f);
    }

    /**
     * 
     * @param name
     *            Identifies the desired function
     * @return The function associated with the given <tt>name</tt>, or <tt>null</tt> if no such function is registered.
     */
    public Function getFunction(URI name) {
        return this.registry.get(name);
    }

    @Override
    public String toString() {
        return this.registry.toString();
    }

    private FunctionRegistry() {
        this.registry = new HashMap<URI, Function>();
    }

    private Map<URI, Function> registry;
}
