/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/cast/XSDInteger.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: XSDInteger.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin.function;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.expression.UnaryFunction;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Given a URI returns the local name
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class ToURI extends UnaryFunction {

    @Override
    public Value call(Value arg1) throws IncompatibleTypeException {
        if (arg1 instanceof URI)
            return arg1;
        if (arg1 instanceof Literal) {
            try {
                return Constants.valueFactory.createURI(((Literal)arg1).getLabel());
            } catch (AnzoRuntimeException are) {
                throw new IncompatibleTypeException(arg1, "URI or literal with a lexical form that is a valid URI");
            }
        }
        throw new IncompatibleTypeException(arg1, "URI or literal with a lexical form that is a valid URI");
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.GLITTER_FUNCTION_NAMESPACE + "toURI");
    }

}
