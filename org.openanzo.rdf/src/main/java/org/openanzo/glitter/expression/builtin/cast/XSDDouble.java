/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/cast/XSDDouble.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: XSDDouble.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin.cast;

import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.expression.UnaryFunction;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Implements cast to <tt>xsd:double</tt>.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class XSDDouble extends UnaryFunction {

    @Override
    public Value call(Value arg1) throws IncompatibleTypeException {
        // see http://www.w3.org/TR/xpath-functions/#casting-from-primitive-to-primitive
        if (arg1 instanceof Literal) {
            return MemTypedLiteral.create(((Literal) arg1).getLabel(), XMLSchema.DOUBLE);
        }
        throw new IncompatibleTypeException(arg1, "literal with a numeric-compatible lexical form");
    }

    public URI getIdentifier() {
        return XMLSchema.DOUBLE;
    }

}
