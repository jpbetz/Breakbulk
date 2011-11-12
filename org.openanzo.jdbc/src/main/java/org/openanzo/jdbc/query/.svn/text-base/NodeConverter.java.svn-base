/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/glitter/BocaNodeConverter.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/27/06
 * Revision: $Id: NodeConverter.java 178 2007-07-31 14:22:33Z mroy $
 *  
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.query;

import java.sql.Connection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.layout.NodeType;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.MemBlankNode;
import org.openanzo.rdf.Value;

/**
 * Convert between Glitter and Anzo node types
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
//FIXEXCEPTIONS:Fix exception handing in conversion process
public class NodeConverter {

    private Map<MemBlankNode, BlankNode>   bnodeMap;

    private final HashMap<Long, IRdbValue> cachedNodes = new HashMap<Long, IRdbValue>();

    private final CompositeNodeLayout      nodeLayout;

    /**
     * Create a new NodeConverter
     * 
     * @param nodeLayout
     *            source of data
     */
    public NodeConverter(CompositeNodeLayout nodeLayout) {
        this.bnodeMap = new HashMap<MemBlankNode, BlankNode>();
        this.nodeLayout = nodeLayout;
    }

    /**
     * Resolve all the nodes in the cache
     * 
     * @param connection
     * @throws AnzoException
     */
    public void resolveNodes(Connection connection) throws AnzoException {
        HashSet<Long> ids = new HashSet<Long>();
        for (Map.Entry<Long, IRdbValue> entry : cachedNodes.entrySet()) {
            if (!entry.getValue().populated()) {
                ids.add(entry.getKey());
            }
        }
        if (ids.size() < 20000) {
            for (Map.Entry<Long, Value> entry : nodeLayout.resolveStoredIds(ids, connection).entrySet()) {
                IRdbValue rdbValue = cachedNodes.get(entry.getKey());
                rdbValue.setValue(entry.getValue());
            }
        } else {
            Long idsArray[] = ids.toArray(new Long[0]);
            for (int i = 0; i <= idsArray.length / 20000; i++) {
                Long newArray[] = new Long[Math.min(20000, idsArray.length - (i * 20000))];
                System.arraycopy(idsArray, i * 20000, newArray, 0, newArray.length);
                HashSet<Long> newIds = new HashSet<Long>();
                Collections.addAll(newIds, newArray);
                for (Map.Entry<Long, Value> entry : nodeLayout.resolveStoredIds(newIds, connection).entrySet()) {
                    IRdbValue rdbValue = cachedNodes.get(entry.getKey());
                    rdbValue.setValue(entry.getValue());
                }
            }
        }
    }

    /**
     * Convert a node ID into the corresponding Glitter IRdbTerm
     * 
     * @param connection
     *            connection to jdbc database
     * @param id
     *            of node
     * @return converted IRdbTerm for node
     */
    public IRdbValue getGlitterNode(long id, Connection connection) {
        if (id == 0) {
            throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER, "ID");
        }
        IRdbValue result = cachedNodes.get(Long.valueOf(id));

        if (result != null) {
            return result;
        }
        // use the blank node manager to ensure that we always get the same
        // blank node for the same anzo blank node
        int typeId = (int) ((id & 0xf000000000000000L) >> 60);
        switch (typeId) {
        case NodeType.BLANK_TYPE:
            result = new org.openanzo.jdbc.query.RdbBlankNode(nodeLayout, connection, id);
            break;
        case NodeType.URI_TYPE:
        case NodeType.LONG_URI_TYPE:
            result = new org.openanzo.jdbc.query.RdbURI(nodeLayout, connection, id);
            break;
        case NodeType.LITERAL_TYPE:
        case NodeType.LONG_LITERAL_TYPE:
            result = new org.openanzo.jdbc.query.RdbPlainLiteral(nodeLayout, connection, id);
            break;
        case NodeType.TYPED_LITERAL_TYPE:
        case NodeType.TYPED_LONG_LITERAL_TYPE:
            result = new org.openanzo.jdbc.query.RdbTypedLiteral(nodeLayout, connection, id);
            break;
        }
        if (result != null) {
            cachedNodes.put(Long.valueOf(id), result);
            return result;
        }
        return null;
    }

    /**
     * Clear the node and bnode caches
     */
    public void clearCache() {
        cachedNodes.clear();
        bnodeMap.clear();
    }
}
