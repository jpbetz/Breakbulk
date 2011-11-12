/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/UnknownGraphException.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: UnknownGraphException.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.URI;

/**
 * Thrown if a graph that is part of an RDF dataset cannot be found/loaded.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class UnknownGraphException extends GlitterException {
    private static final long serialVersionUID = -569451207412634664L;

    /**
     * Default constructor. 
     */
    public UnknownGraphException() {
        super(ExceptionConstants.GLITTER.UNKNOWN_GRAPH, "One or more unknown graphs");
    }
    /**
     * 
     * @param graph
     *            The unknown graph
     */
    public UnknownGraphException(URI graph) {
        super(ExceptionConstants.GLITTER.UNKNOWN_GRAPH, graph.toString());
    }

    /**
     * 
     * @param graph
     *            The unknown graph
     */
    public UnknownGraphException(String graph) {
        super(ExceptionConstants.GLITTER.UNKNOWN_GRAPH, graph);
    }
}
