/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/Attic/INamedGraphListener.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Dec 26, 2006
 * Revision:	$Id: INamedGraphListener.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

/**
 * Listener to handle statement events
 * 
 * @param <T>
 *            type of element firing events
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IStatementListener<T> {

    /**
     * Statements were added to INamedGraph
     * 
     * @param source
     *            INamedGraph that statements were added
     * @param statements
     *            Set of statements added to INamedGraph
     */
    public void statementsAdded(T source, Statement... statements);

    /**
     * Statements were deleted from INamedGraph
     * 
     * @param source
     *            INamedGraph that statements were deleted
     * @param statements
     *            Set of statements deleted to INamedGraph
     */
    public void statementsRemoved(T source, Statement... statements);

}
