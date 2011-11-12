/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 7, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.jastor;

import java.util.Collection;

import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface Thing {

    /**
     * Get the Dataset where this Thing resides
     * 
     * @return Dataset where this Thing resides
     */
    public IDataset dataset();

    /**
     * Get the graph where this Thing resides
     * 
     * @return the graph where this Thing resides
     */
    public INamedGraph graph();

    /**
     * String representation of this Thing's resource
     * 
     * @return String representation of this Thing's resource
     */
    public abstract String uri();

    /**
     * Resource representation of this Thing's resource
     * 
     * @return Resource representation of this Thing's resource
     */
    public abstract Resource resource();

    /**
     * Get set of statements that makeup this ThingS's properties and types
     * 
     * @return set of statements that makeup this ThingS's properties and types
     */
    public abstract Collection<Statement> listStatements();

    /**
     * Remove set of statements that makeup this ThingS's properties and types
     */
    public abstract void removeStatements();

    /**
     * Register a ThingListener for this Thing
     * 
     * @param listener
     *            ThingListener
     */
    public abstract void registerListener(ThingListener listener);

    /**
     * Unregister a ThingListener for this Thing
     * 
     * @param listener
     *            ThingListener
     */
    public abstract void unregisterListener(ThingListener listener);

    /**
     * Verify if this Thing is of RDFType type
     * 
     * @param type
     *            type to verify
     * @return true if Thing is of RDFType type
     */
    public abstract boolean isRDFType(Resource type);

    /**
     * Get the value of a property
     * 
     * @param property
     *            property to retrieve
     * @param namedGraphUris
     *            graphs to search against
     * @return value of property
     */
    public Value getPropertyValue(URI property, URI... namedGraphUris);

    /**
     * Get all values of a property
     * 
     * @param property
     *            property to retrieve
     * @param namedGraphUris
     *            graphs to search against
     * @return all values of a property
     */
    public Collection<Value> getPropertyValues(URI property, URI... namedGraphUris);

    /**
     * Set value of a property, clearing old values
     * 
     * @param property
     *            property to set
     * @param value
     *            value to set
     * @param namedGraphUri
     *            graphs where value should be put
     */
    public void setPropertyValue(URI property, Value value, URI... namedGraphUri);

    /**
     * Clear all values for property
     * 
     * @param property
     *            property to clear
     * @param namedGraphUris
     *            graphs in which to clear properties
     */
    public void clearPropertyValues(URI property, URI... namedGraphUris);

    /**
     * Add a property value, without clearing old values
     * 
     * @param property
     *            property to add
     * @param value
     *            value to add
     * @param namedGraphUri
     *            graphs where value should be added
     */
    public void addPropertyValue(URI property, Value value, URI... namedGraphUri);

}
