/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/IRITerm.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Dec 7, 2006
 * Revision:	$Id: IRITerm.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

/**
 * 
 * Represents a URI (Unique Resource Identifier).
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface URI extends Resource {

    /**
     * Gets the local name of the URI, which is the part of the URI following either a '#', ':' or a '/', whichever comes last.
     * 
     * @return The local name part of the URI.
     */
    public String getLocalName();

    /**
     * Gets the namespace of the URI, which is all of the URI string preceding the local name.
     * 
     * @return The namespace part of the URI.
     */
    public String getNamespace();
}
