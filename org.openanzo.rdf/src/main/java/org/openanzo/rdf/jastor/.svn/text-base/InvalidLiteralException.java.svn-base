/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/jastor/Attic/InvalidLiteralException.java,v $
 * Created by:  Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 * Created on:  5/15/2006
 * Revision:	$Id: InvalidLiteralException.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor;

import org.openanzo.rdf.Literal;

/**
 * Exception caused by problem with Literal value
 * 
 * @author Joe Betz
 * @author Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 */
public class InvalidLiteralException extends JastorException {

    private static final long serialVersionUID = 1L;

    /** Literal value causing exception */
    final private Literal     literal;

    /**
     * Create invalid Literal exception
     * 
     * @param errorDescription
     *            Description of error
     * @param object
     *            Literal object that caused error
     */
    public InvalidLiteralException(String errorDescription, Literal object) {
        super(errorDescription);
        this.literal = object;
    }

    /**
     * Get the Literal object that caused error
     * 
     * @return Literal object that caused error
     */
    public Literal getLiteral() {
        return literal;
    }
}
