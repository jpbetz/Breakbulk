/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/PolymorphicFunction.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: PolymorphicFunction.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Base class for functions that have different behavior (corresponding to different {@link Function}s) depending on the arguments given.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public abstract class PolymorphicFunction implements ScalarFunctionOnValues {
    private ScalarFunctionOnValues[] functions;

    /**
     * 
     * @param functions
     *            An ordered list of functions that implement this polymorphic function.
     */
    public PolymorphicFunction(ScalarFunctionOnValues[] functions) {
        this.functions = functions.clone();
    }

    /**
     * See {@link ScalarFunctionOnValues#call(List)}
     * 
     * @return The return value of the first function that comprise this polymorphic function that does not result in an {@link ExpressionEvaluationException}
     *         when invoked.
     */
    public Value call(List<Value> arguments) throws ExpressionEvaluationException {
        ExpressionEvaluationException lastError = null;
        for (int i = 0; i < this.functions.length; i++) {
            try {
                return this.functions[i].call(arguments);
            } catch (ExpressionEvaluationException e) {
                lastError = e;
                // try the next most specific function
            }
        }
        if (lastError != null)
            throw lastError;
        else
            return null;
    }

    /**
     * All of SPARQL's spec'ed out polymorphic functions are actually operators without a URI.
     */
    public URI getIdentifier() {
        return null;
    }

    public boolean operatesOnTypeErrors() {
        return false;
    }

    public boolean operatesOnValues() {
        return true;
    }

}
