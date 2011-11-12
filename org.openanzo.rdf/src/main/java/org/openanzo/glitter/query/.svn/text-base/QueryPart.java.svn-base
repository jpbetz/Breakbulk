/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;

import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * A {@link QueryPart} represents any structural part of a query. A QueryPart can return collections of variables and URIs referenced.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public interface QueryPart {
    /**
     * Get the variables referenced in this part of a query
     * 
     * @return the variables referenced in this part of a query
     */
    public Collection<Variable> getReferencedVariables();

    /**
     * Get the variables that can be bound
     * 
     * @return the variables that can be bound
     */
    public Collection<Variable> getBindableVariables();

    /**
     * Get all the uris referenced in this query part
     * 
     * @return all the uris referenced in this query part
     */
    public Collection<URI> getReferencedURIs();

    /**
     * Pretty print this part of the query
     * 
     * @param printFlags
     *            flags to printing
     * @param indentLevel
     *            indentation level for this part
     * @param uri2prefix
     *            uri prefixes
     * @param s
     *            output builder
     */
    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s);

}
