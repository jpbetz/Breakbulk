/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/glitter/Attic/BlankNode.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Dec 26, 2006
 * Revision:	$Id: BlankNode.java 178 2007-07-31 14:22:33Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.query;

import java.sql.Connection;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BlankNode Term for Anzo Glitter mapping
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class RdbBlankNode implements BlankNode, IRdbValue {
    private static final long                   serialVersionUID = -3426302313344048932L;

    transient private static final Logger       log              = LoggerFactory.getLogger(RdbBlankNode.class);

    private final long                          id;

    private BlankNode                           value;

    transient final private CompositeNodeLayout nodeLayout;

    transient private Connection                connection       = null;

    /**
     * Create a new BlankNode for the given ID *
     * 
     * @param connection
     *            connection to jdbc database
     * @param nodeLayout
     *            layout where value is stored
     * @param id
     *            ID of value in DB
     */
    protected RdbBlankNode(CompositeNodeLayout nodeLayout, Connection connection, long id) {
        this.nodeLayout = nodeLayout;
        this.connection = connection;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        try {
            populateData();
        } catch (AnzoException ae) {
            throw new AnzoRuntimeException(ae);
        }
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        // blank nodes are only equal if they're the same object
        return this == other;
    }

    @Override
    public int hashCode() {
        // blank nodes are only equal if they're the same object
        return super.hashCode();
    }

    public String getLabel() {
        try {
            populateData();
        } catch (AnzoException ae) {
            throw new AnzoRuntimeException(ae);
        }
        return value.getLabel();
    }

    /**
     * Lookup the BlankNodes ID in the database
     * 
     * @throws RdbException
     */
    private void populateData() throws RdbException {
        if (value == null) {
            try {
                value = (BlankNode) nodeLayout.fetchValue(getId(), connection);
            } catch (RdbException rdbe) {
                log.error(LogUtils.RDB_MARKER, "error loading blank node " + getId(), rdbe);
                throw new AnzoRuntimeException(rdbe);
            }

        }
    }

    public Value getValue() throws RdbException {
        populateData();
        return value;
    }

    public int compareTo(TriplePatternComponent o) {
        return toString().compareTo(o != null ? o.toString() : "");
    }

    public void populate(Connection connection) throws RdbException {
        this.connection = connection;
        populateData();
    }

    public int nodeIdCompareTo(IRdbValue o) {
        if (getId() < o.getId())
            return -1;
        else if (getId() > o.getId())
            return 1;
        else
            return 0;
    }

    public boolean nodeIdEquals(IRdbValue o) {
        return getId() == o.getId();
    }

    public int nodeIdHash() {
        return Long.valueOf(getId()).hashCode();
    }

    public boolean populated() {
        return value != null;
    }

    public void setValue(Value value) {
        this.value = (BlankNode) value;
    }
}
