/*******************************************************************************
 * Copyright (c) 2010 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import java.util.List;

import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.glitter.expression.ScalarFunctionOnValues;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Implements <a href="http://www.w3.org/2006/sparql-functions#in">the SPARQL IN function</a>.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class In implements ScalarFunctionOnValues {

    public In() {
    }

    public Value call(List<Value> args) throws IncompatibleTypeException, InvalidArgumentCountException {
        if (args.size() < 2)
            throw new InvalidArgumentCountException(args.size(), 2);

        Value value = args.get(0);

        return (args.lastIndexOf(value) > 0) ? org.openanzo.glitter.util.Constants.TRUE : org.openanzo.glitter.util.Constants.FALSE;
    }

    public boolean operatesOnTypeErrors() {
        return false;
    }

    public boolean operatesOnValues() {
        return true;
    }

    public org.openanzo.rdf.URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.BUILTIN_NAMESPACE + "in");
    }

}
