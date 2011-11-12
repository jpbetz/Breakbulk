/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/IValueLayout.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: IValueLayout.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.sql.Connection;
import java.util.Collection;

import org.openanzo.jdbc.container.sql.NodeSQL.FetchAllCommonValuesResult;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.RdbException;

/**
 * Provides read/write access to persisted string values of limited length. This class's original purpose was for storing RDF datatype and language strings. The
 * length limit is database dependent. For example, a DB2 instance may limit length to 250 chars.
 * 
 * @author Joe Betz
 * @author Stephen Evanchik <evanchik@us.ibm.com>
 */
interface IValueLayout {

    /**
     * Store String value
     * 
     * @param value
     *            value to store
     * @param connection
     *            connection to the database
     * @return ID of stored value
     * @throws RdbException
     */
    Long store(String value, Connection connection) throws RdbException;

    /**
     * Fetch the ID for this value
     * 
     * 
     * @param value
     *            value to lookup
     * @param connection
     *            connection to the database
     * @return ID of stored value
     * @throws RdbException
     */
    Long fetchId(String value, Connection connection) throws RdbException;

    /**
     * Fetch the value for this ID
     * 
     * @param id
     *            id to lookup
     * @param connection
     *            connection to the database
     * @return the value for this ID
     * @throws RdbException
     */
    String fetchValue(Long id, Connection connection) throws RdbException;

    /**
     * Add a set of strings, ignoring resulting IDs
     * 
     * @param iter
     *            Set of strings to store
     * @param connection
     *            connection to the database
     * @throws RdbException
     */
    void batchAdd(Collection<String> iter, Connection connection) throws RdbException;

    /**
     * FetchAll the values for this type
     * 
     * @param connection
     *            connection to the database *
     * @return all values for this type
     * @throws RdbException
     */
    ClosableIterator<FetchAllCommonValuesResult> fetchAll(Connection connection) throws RdbException;

}
