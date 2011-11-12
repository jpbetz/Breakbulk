/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/INodeLayout.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: INodeLayout.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.sql.Connection;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Value;

/**
 * Provides read/write access to persisted nodes.
 * 
 * @param <T>
 *            Type of Node this layout handles
 * @author Joe Betz
 * @author Stephen Evanchik <evanchik@us.ibm.com>
 */
interface INodeLayout<T extends Value> {

    /**
     * Stores a node in the database
     * 
     * @param n
     *            The node to be stored
     * @param connection
     *            The connection to the database
     * @param transactionId
     *            id of the transaction for which this storage operation is a part
     * @return The ID of the node stored
     * @throws RdbException
     */
    public Long store(T n, Connection connection, long transactionId) throws RdbException;

    /**
     * Fetches a node's ID from the database
     * 
     * @param n
     *            The node who's ID is to be found
     * @param connection
     *            The connection to the database
     * @return The ID of the node or null if not found
     * @throws RdbException
     */
    public Long fetchId(T n, Connection connection) throws RdbException;

    /**
     * Fetches a nodes value from the database based on its long identifier and NodeType.
     * 
     * @param id
     *            The ID of the node to be found
     * @param connection
     *            The connection to the database
     * @return The node
     * @throws RdbException
     */
    public T fetchValue(Long id, Connection connection) throws RdbException;

    /**
     * This method will determine which nodes in a list of given nodes are already stored in the database. If storeUnresolvedNodes is true, then any node that
     * is unresolved will be stored.
     * 
     * @param nodes
     *            The nodes which need to be resolved to whether they are already stored or need to be stored.
     * @param storeUnresolvedNodes
     *            Store nodes that are not already stored
     * @param connection
     *            The connection to the database
     * @param transactionId
     *            id of the transaction for which this storage operation is a part
     * 
     * @return A Map of the nodes already stored in the database.
     * @throws RdbException
     */
    public Map<T, Long> resolveStoredNodes(Collection<T> nodes, boolean storeUnresolvedNodes, Connection connection, long transactionId) throws RdbException;

    public long commitReferencedIds(Connection connection, long transactionId) throws RdbException;

    public long abortReferencedIds(Connection connection, long transactionId) throws RdbException;

    /**
     * This method will determine which IDs in a list of given Ids are already stored in the database.
     * 
     * @param ids
     *            The ids which need to be resolved to whether they are already stored.
     * @param connection
     *            The connection to the database
     * @return A Map of the ids already stored in the database.
     * @throws RdbException
     */
    public Map<Long, T> resolveStoredIds(Set<Long> ids, Connection connection) throws RdbException;

    /**
     * @return type of Nodes this layout handles
     */
    public NodeType getType();

    /**
     * Convert raw value from database into Node of appropriate type
     * 
     * @param value
     *            raw value of node from database
     * @param modifier
     *            for literal values
     * @param connection
     *            The connection to the database
     * @return converted Node of appropriate type
     * @throws RdbException
     */
    public T convert(String value, Long modifier, Connection connection) throws RdbException;

    /**
     * 
     * @param length
     */
    public void setMaxLength(int length);
}
