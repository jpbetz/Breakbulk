/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/ILayoutCache.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: ILayoutCache.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.sql.Connection;

import org.openanzo.jdbc.utils.RdbException;

/**
 * Provides cache clearing and checking presence of objects cached by their reference or (long) id.
 * 
 * @param <T>
 *            Type of object being cached
 * @author <a href="mailto:evanchik@us.ibm.com">Stephen Evanchik</a>
 * @author Joe Betz
 */
interface ILayoutCache<T> {

    /**
     * Create object from provided ID and value and cache result
     * 
     * @param id
     *            ID of node
     * @param value
     *            String value of node
     * @param modifierId
     *            modifierId for literals
     * @param connection
     *            connection to the database
     * @return converted object for provided data
     * @throws RdbException
     */
    T cache(Long id, String value, Long modifierId, Connection connection) throws RdbException;

    /**
     * Return true if a ID for this Object is already cached
     * 
     * @param obj
     *            object to check
     * @return true if a ID for this Object is already cached
     * @throws RdbException
     */
    boolean isCached(T obj) throws RdbException;

    /**
     * Get the ID for this Object, if already cached
     * 
     * @param obj
     *            object to find cached ID
     * @return the ID for this Object, if already cached
     * @throws RdbException
     */
    Long getIfCached(T obj) throws RdbException;

    /**
     * Return true if an Object with this ID is already cached
     * 
     * @param id
     *            id to check
     * @return true if an Object with this ID is already cached
     * @throws RdbException
     */
    boolean isCached(Long id) throws RdbException;

    /**
     * Get the Object for this ID, if already cached
     * 
     * @param id
     *            id of Object to retrieve
     * @return the Object for this ID, if already cached
     * @throws RdbException
     */
    T getIfCached(Long id) throws RdbException;

    /**
     * Clear all cached objects and IDs
     */
    void clearCache();

    /**
     * Commit any uncommitted cache entries
     */
    void commitUncommittedCache();

    /**
     * Clear any uncommitted cache entries
     */
    void clearUncommittedCache();
}
