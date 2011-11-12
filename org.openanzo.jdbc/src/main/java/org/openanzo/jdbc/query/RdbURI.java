/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/glitter/IRIReference.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: IRIReference.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.query;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.SQLException;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of IRITerm that maps an Anzo Resource to a Glitter IRITerm
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class RdbURI implements URI, IRdbValue {
    private static final long                   serialVersionUID = -5065622213444814025L;

    transient private static final Logger       log              = LoggerFactory.getLogger(RdbURI.class);

    private final long                          id;

    transient final private CompositeNodeLayout nodeLayout;

    transient private Connection                connection;

    private URI                                 node;

    /**
     * Create a new IRIReference for the URI with the given ID
     * 
     * @param connection
     *            connection to jdbc database
     * @param nodeLayout
     *            source of data
     * @param id
     *            ID of URI
     */
    protected RdbURI(CompositeNodeLayout nodeLayout, Connection connection, long id) {
        this.nodeLayout = nodeLayout;
        this.connection = connection;
        try {
            if (connection.isClosed())
                throw new InvalidParameterException("connection is closed");
        } catch (SQLException e) {
            throw new InvalidParameterException("connection is unusable");
        }
        this.id = id;
    }

    public long getId() {
        return id;
    }

    private void populateNode() {
        if (node == null) {
            try {
                node = nodeLayout.getNodeURILayout().fetchValue(id, connection);
            } catch (RdbException rdbe) {
                log.error(LogUtils.RDB_MARKER, "error loading uri node " + getId(), rdbe);
                throw new AnzoRuntimeException(rdbe);
            }
        }
    }

    public Value getValue() {
        if (node == null) {
            populateNode();
        }
        return node;
    }

    @Override
    public String toString() {
        populateNode();
        return node.toString();
    }

    @Override
    public boolean equals(Object other) {
        // http://www.w3.org/TR/rdf-concepts/#section-Graph-URIref
        // specifies that two RDF IRI references compare equal only
        // if they are equivalent on a character-by-character basis.
        //
        // This differs from the URI.equals() method (which ignores
        // case in the scheme, for instance), and so we compare
        // strings instead
        if (other instanceof RdbURI && nodeLayout == ((RdbURI) other).nodeLayout) {
            long otherId = ((RdbURI) other).getId();
            return id == otherId;
        }
        return other != null && this.toString().equals(other.toString());
    }

    @Override
    public int hashCode() {
        populateNode();
        return this.node.hashCode();
    }

    public int compareTo(TriplePatternComponent o) {
        /*if (o instanceof IRdbValue) {
            if (getId() < ((IRdbValue) o).getId())
                return -1;
            else if (getId() > ((IRdbValue) o).getId())
                return 1;
            else
                return 0;
        }*/
        return toString().compareTo(o.toString());
    }

    public String getLocalName() {
        populateNode();
        return node.getLocalName();
    }

    public String getNamespace() {
        populateNode();
        return node.getNamespace();
    }

    public void populate(Connection connection) throws RdbException {
        this.connection = connection;
        populateNode();
    }

    public boolean populated() {
        return node != null;
    }

    public void setValue(Value value) {
        this.node = (URI) value;
    }
}
