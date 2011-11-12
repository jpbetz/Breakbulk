/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/glitter/IBocaTerm.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Dec 7, 2006
 * Revision:	$Id: IRdbTerm.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.query;

import java.sql.Connection;

import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Value;

/**
 * Extend RDFTerm to allow for lazy loading of nodes from the database
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IRdbValue extends org.openanzo.rdf.Value {

    /**
     * Get the ID of this node in the database
     * 
     * @return the ID of this node in the database
     */
    long getId();

    /**
     * Get the Value representation of this term
     * 
     * @return the Value representation of this term
     * @throws RdbException
     */
    Value getValue() throws RdbException;

    /**
     * Uses the provided JDBC connection and the ID field to load this value's string fields from the JDBC database.
     * 
     * @param connection
     *            A JDBC connection.
     * @throws RdbException
     */
    void populate(Connection connection) throws RdbException;

    /**
     * @return true if node is populated with value
     */
    boolean populated();

    /**
     * @param value
     *            new value
     */
    void setValue(Value value);
}
