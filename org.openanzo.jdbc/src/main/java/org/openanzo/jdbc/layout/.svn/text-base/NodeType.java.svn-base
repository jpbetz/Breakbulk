/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/NodeType.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: NodeType.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.jdbc.utils.UnhandledRdbException;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Provides allocation and conversion between RDF Node types and ids used by the node centric layout to reference them. Supports the various RDF Node types and
 * subtypes: URI, LITERAL, TYPED_LITERAL, Blank, Language and Datatype.
 * 
 * Intended to be an internal component of the node layout package.
 * 
 * @see org.openanzo.jdbc.layout.CompositeNodeLayout
 * 
 * @author Joe Betz
 */
public class NodeType {

    /** Prefix for the names of the sequences */
    public static final String      sequencePrefix           = "NODE_SEQ_";

    /** Sequence name for blank nodes */
    public static final String      blankSequence            = sequencePrefix + 0;

    /** Sequence name for URIs */
    public static final String      uriSequence              = sequencePrefix + 1;

    /** Sequence name for literals */
    public static final String      literalSequence          = sequencePrefix + 2;

    /** Sequence name for long literals */
    public static final String      longLiteralSequence      = sequencePrefix + 3;

    /** Sequence name for literals */
    public static final String      typedliteralSequence     = sequencePrefix + 4;

    /** Sequence name for long literals */
    public static final String      longTypedLiteralSequence = sequencePrefix + 5;

    /** Sequence name for long URIS */
    public static final String      longUriSequence          = sequencePrefix + 6;

    /** From a 64bit number, use 4 most significant bits as node type */
    static final long               mask                     = 15 << 60;

    /** Number of types */
    public static final int         typeCount                = 7;

    /** Blank node type mask */
    public static final int         BLANK_TYPE               = 0;

    /** URI node type mask */
    public static final int         URI_TYPE                 = 1;

    /** Literal node type mask */
    public static final int         LITERAL_TYPE             = 2;

    /** Long Literal node type mask */
    public static final int         LONG_LITERAL_TYPE        = 3;

    /** Literal node type mask */
    public static final int         TYPED_LITERAL_TYPE       = 4;

    /** Long Literal node type mask */
    public static final int         TYPED_LONG_LITERAL_TYPE  = 5;

    /** Long URI node type mask */
    public static final int         LONG_URI_TYPE            = 6;

    /** Blank node type */
    public static final NodeType    BLANK                    = new NodeType("BLANK", BLANK_TYPE, "_B");

    /** URI node type */
    public static final NodeType    URI                      = new NodeType("URI", URI_TYPE, "_U");

    /** Literal node type */
    public static final NodeType    LITERAL                  = new NodeType("LITERAL", LITERAL_TYPE, "_L");

    /** Long Literal node type */
    public static final NodeType    LONG_LITERAL             = new NodeType("LONG_LITERAL", LONG_LITERAL_TYPE, "_LL");

    /** Literal node type */
    public static final NodeType    TYPED_LITERAL            = new NodeType("TYPED_LITERAL", TYPED_LITERAL_TYPE, "_TL");

    /** Long Literal node type */
    public static final NodeType    TYPED_LONG_LITERAL       = new NodeType("TYPED_LONG_LITERAL", TYPED_LONG_LITERAL_TYPE, "_LTL");

    /** Long URI node type */
    public static final NodeType    LONG_URI                 = new NodeType("LONG_URI", LONG_URI_TYPE, "_LU");

    private static final NodeType[] byId                     = { BLANK, URI, LITERAL, LONG_LITERAL, TYPED_LITERAL, TYPED_LONG_LITERAL, LONG_URI };

    final private long              typeMask;

    final private long              maxValue;

    final private String            value;

    final private String            suffix;

    final private int               range;

    /**
     * Get the type id for the given node ID
     * 
     * @param id
     *            node ID to lookup
     * @return type ID for given node ID
     */
    public static long getTypeId(long id) {
        return (id & mask);
    }

    /**
     * Get the NodeType for the given node ID
     * 
     * @param id
     *            node ID
     * @return NodeType for the given node ID
     */
    public static NodeType getById(long id) {
        long typeId = getTypeId(id);
        for (int i = 0; i < byId.length; i++) {
            if (byId[i].getTypeMask() == typeId) {
                return byId[i];
            }
        }
        throw new UnhandledRdbException(ExceptionConstants.RDB.NO_NODETYPE_ID, Long.toString(typeId), Long.toString(id));
    }

    /**
     * Get the regular NodeType for this Value
     * 
     * @param n
     *            value for which to retrieve NodeType
     * @return the regular NodeType for this Value
     */
    public static NodeType getShortLayout(Value n) {
        if (n instanceof BlankNode) {
            return BLANK;
        } else if (n instanceof URI) {
            return URI;
        } else if (n instanceof PlainLiteral) {
            return LITERAL;
        } else if (n instanceof TypedLiteral) {
            return TYPED_LITERAL;
        }
        return null;
    }

    /**
     * Get the long NodeType for this Value
     * 
     * @param n
     *            value for which to retrieve NodeType
     * @return the long NodeType for this Value
     */
    public static NodeType getLongLayout(Value n) {
        if (n instanceof BlankNode) {
            return BLANK;
        } else if (n instanceof URI) {
            return LONG_URI;
        } else if (n instanceof TypedLiteral) {
            return TYPED_LONG_LITERAL;
        } else if (n instanceof PlainLiteral) {
            return LONG_LITERAL;
        }
        return null;
    }

    private NodeType(String value, int range, String suffix) {
        this.range = range;
        this.typeMask = ((long) range << 60);
        this.maxValue = ((long) (range + 1) << 60);
        this.value = value;
        this.suffix = suffix;
    }

    /**
     * Get the string representation of NodeType
     * 
     * @return the string representation of NodeType
     */
    public String getValue() {
        return value;
    }

    /**
     * Get the suffix which is appended to the end of the container name to generate the table name for this type
     * 
     * @return suffix which is appended to the end of the container name to generate the table name for this type
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Get a table name consisting of the suffix appended to the end of the container name
     * 
     * @param containerName
     *            name of container
     * @return a table name consisting of the suffix appended to the end of the container name
     */
    public String getName(String containerName) {
        return containerName + suffix;
    }

    @Override
    public String toString() {
        return getValue();
    }

    /**
     * Get the id of NodeType out of the 16 possible type ids
     * 
     * @return the id of NodeType out of the 16 possible type ids
     */
    public int getRange() {
        return range;
    }

    /**
     * The typeMake for this nodeType
     * 
     * @return the typeMake for this nodeType
     */
    public long getTypeMask() {
        return typeMask;
    }

    /**
     * @return the maxValue
     */
    public long getMaxValue() {
        return maxValue;
    }
}
