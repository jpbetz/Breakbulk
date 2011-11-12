/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/Attic/BocaQuad.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  3/31/2006
 * Revision:	$Id: Quad.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import org.openanzo.jdbc.query.IRdbValue;
import org.openanzo.jdbc.query.NodeConverter;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Data structure to hold quads from Glitter
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class Quad {

    private final IRdbValue namedGraphTerm;

    private final IRdbValue subjTerm;

    private final IRdbValue predTerm;

    private final IRdbValue objTerm;

    /**
     * Create a new Quad using IDs
     * 
     * @param connection
     *            The connection to the jdbc database from which the quad is loaded
     * @param converter
     *            Converter that converts between the Glitter and Anzo types
     * @param namedGraphId
     *            stored ID of namedGraphURI
     * @param subjId
     *            stored ID of subject
     * @param predId
     *            stored ID of predicate
     * @param objId
     *            stored ID of object
     */
    public Quad(java.sql.Connection connection, NodeConverter converter, long namedGraphId, long subjId, long predId, long objId) {
        this.namedGraphTerm = converter.getGlitterNode(namedGraphId, connection);
        this.subjTerm = converter.getGlitterNode(subjId, connection);
        this.predTerm = converter.getGlitterNode(predId, connection);
        this.objTerm = converter.getGlitterNode(objId, connection);
    }

    /**
     * Get this quad as a statement
     * 
     * @return this quad as a statement
     */
    public Statement asStatement() {
        return Constants.valueFactory.createStatement((Resource) subjTerm, (URI) predTerm, (Value) objTerm, (URI) namedGraphTerm);
    }

    /**
     * Get the namedGraphTerm
     * 
     * @return the namedGraphTerm
     */
    public IRdbValue getNamedGraphTerm() {
        return namedGraphTerm;
    }

    /**
     * Get the subjTerm
     * 
     * @return the subjTerm
     */
    public IRdbValue getSubjTerm() {
        return subjTerm;
    }

    /**
     * Get the predTerm
     * 
     * @return the predTerm
     */
    public IRdbValue getPredTerm() {
        return predTerm;
    }

    /**
     * Get the objTerm
     * 
     * @return the objTerm
     */
    public IRdbValue getObjTerm() {
        return objTerm;
    }
}
