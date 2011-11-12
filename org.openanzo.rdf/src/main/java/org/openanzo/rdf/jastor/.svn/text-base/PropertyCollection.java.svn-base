/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/JavaIdentifierEncoder.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:    $Id: JavaIdentifierEncoder.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor;

import java.util.ArrayList;
import java.util.Collection;

import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.vocabulary.RDFS;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * 
 * @param <E>
 *            The Jastor Type for the values that are returned for the collection.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public abstract class PropertyCollection<E> {
    /**
     * Get property value
     * 
     * @param value
     *            value to convert to property
     * @return converted property
     */
    public abstract E getPropertyValue(Value value);

    /**
     * Get Collection of converted properties
     * 
     * @param dataset
     *            dataset containing data
     * @param graph
     *            graph containing data
     * @param resource
     *            subject of statements
     * @param property
     *            property to retrieve
     * @param type
     *            type to retrieve
     * @param includeEntireDataset
     *            search across entire dataset and not just parent graph
     * @return collection of converted jastor objects for property
     */
    public final Collection<E> getPropertyCollection(IDataset dataset, INamedGraph graph, Resource resource, URI property, URI type, boolean includeEntireDataset) {
        Collection<E> results = new ArrayList<E>();
        Collection<Statement> stmts = dataset.find(includeEntireDataset, resource, property, null, graph.getNamedGraphUri());
        for (Statement stmt : stmts) {
            Value rdfNode = stmt.getObject();

            boolean accept = acceptsObjectForProperty(rdfNode, type);
            if (accept) {
                results.add(getPropertyValue(rdfNode));
            }

        }
        return results;
    }

    /**
     * Determines if the given RDF node is an acceptable value for a an RDF property of the given type.
     */
    private final boolean acceptsObjectForProperty(Value rdfNode, URI type) {
        boolean accept = false;
        if (type == null) {
            accept = true;
        } else if (rdfNode instanceof Literal) {
            // add literal support though we won't use it right away
            // if we are expecting any literal, anything will do
            if (type.equals(RDFS.literal)) {
                accept = true;
            } else {
                Literal literal = (Literal) rdfNode;
                // not sure if this is semantically the best
                // but it should make everything work.
                if (literal instanceof PlainLiteral) {
                    accept = true;
                } else {
                    accept = areTypesCompatible(type, ((TypedLiteral) literal).getDatatypeURI());
                }
            }
        } else if (getPropertyValue(rdfNode) != null) {
            // only in the case of strict type checking does getPropertyValue ever return null
            accept = true;
        }
        return accept;
    }

    /**
     * Determine if 2 URI datatypes are compatible
     * 
     * @param t1
     *            first datatype to compare
     * @param t2
     *            second datatype to compare
     * @return true if the 2 datatypes are compatible
     */
    private static final boolean areTypesCompatible(URI t1, URI t2) {
        // we'll grow this list as necessary
        if (XMLSchema.INTEGER.equals(t1) || XMLSchema.INT.equals(t1) || XMLSchema.NON_POSITIVE_INTEGER.equals(t1) || XMLSchema.NON_NEGATIVE_INTEGER.equals(t1)) {
            return XMLSchema.INTEGER.equals(t2) || XMLSchema.INT.equals(t2) || XMLSchema.NON_POSITIVE_INTEGER.equals(t2) || XMLSchema.NON_NEGATIVE_INTEGER.equals(t2);
        } else {
            return t1.equals(t2);
        }
    }
}
