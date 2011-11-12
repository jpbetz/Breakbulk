/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/jastor/Attic/InvalidNodeException.java,v $
 * Created by:  Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 * Created on:  5/15/2006
 * Revision:	$Id: InvalidNodeException.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor;

import org.openanzo.rdf.Value;

/**
 * Exception caused by problem with a resource value
 * 
 * @author Joe Betz
 * @author Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 */
public class InvalidNodeException extends JastorException {

    private static final long serialVersionUID = 1L;

    /** Node value causing exception */
    private final Value       object;

    /**
     * Create invalid Node exception
     * 
     * @param errorDescription
     *            Description of error
     * @param object
     *            Node object that caused error
     */
    public InvalidNodeException(String errorDescription, Value object) {
        super(errorDescription);
        this.object = object;
    }

    /**
     * Get the Node object that caused error
     * 
     * @return Node object that caused error
     */
    public Value getNode() {
        return object;
    }
}
