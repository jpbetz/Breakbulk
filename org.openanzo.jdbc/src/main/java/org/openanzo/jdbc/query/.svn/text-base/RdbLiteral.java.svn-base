/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/glitter/Literal.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Literal.java 178 2007-07-31 14:22:33Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.query;

import java.sql.Connection;

import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.TriplePatternComponent;

/**
 * Implementation of ILiteralTerm that maps an Anzo Litera to a Glitter ILiteralTerm
 *
 * @param <L>
 *            Type of Literal
 *
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 *
 */
abstract class RdbLiteral<L extends Literal> implements IRdbValue, Literal {
    private static final long           serialVersionUID = 6236311024862153834L;

    private final long                  id;

    transient final CompositeNodeLayout nodeLayout;

    transient Connection                connection;

    protected L                         literal;

    /**
     * Create a new Literal for value stored in database with given ID
     *
     * @param connection
     *            connection to jdbc database
     * @param nodeLayout
     *            source of data
     * @param id
     *            id of Literal in the database
     */
    protected RdbLiteral(CompositeNodeLayout nodeLayout, Connection connection, long id) {
        this.id = id;
        this.nodeLayout = nodeLayout;
        this.connection = connection;
    }

    @Override
    public boolean equals(Object other) {
        // via the definition in:
        // http://www.w3.org/TR/rdf-concepts/#section-Literal-Equality
        // we need only compare the lexicalizations of the two literals
        // since the lexicalizations include the language tag and datatype
        // parts
        return other != null && ((other == this) || this.toString().equals(other.toString()));
    }

    public long getId() {
        return id;
    }

    abstract void populateNode();

    public Literal getValue() {
        populateNode();
        return literal;
    }

    public String getLabel() {
        populateNode();
        return literal.getLabel();
    }

    @Override
    public int hashCode() {
        populateNode();
        return literal.hashCode();
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

    @Override
    public String toString() {
        populateNode();
        return getValue().toString();
    }

    public void populate(Connection connection) throws RdbException {
        this.connection = connection;
        populateNode();
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
}
