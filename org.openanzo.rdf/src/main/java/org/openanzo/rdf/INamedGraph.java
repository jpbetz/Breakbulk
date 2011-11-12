/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/INamedGraph.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/24/2006
 * Revision:	$Id: INamedGraph.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.io.Serializable;
import java.util.Collection;

/**
 * Graph representation of data
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface INamedGraph extends IStatementNotifier<INamedGraph>, Serializable {

    /**
     * Get NamedGraph's URI
     * 
     * @return URI for this grpah
     */
    URI getNamedGraphUri();

    /**
     * Get an iterator of all statements within this graph
     * 
     * @return CloseableIterator of all statements within this graph
     */
    public Collection<Statement> getStatements();

    /**
     * Return an iterator of all statements that match the pattern of subj,prop,obj
     * 
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @return an iterator of all statements that match the pattern of subj,prop,obj
     */
    public Collection<Statement> find(Resource subj, URI prop, Value obj);

    /**
     * Return true if the graph contains at least 1 statement that matches the pattern of subj,prop,obj
     * 
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @return true if the graph contains at least 1 statement that matches the pattern of subj,prop,obj
     */
    public boolean contains(Resource subj, URI prop, Value obj);

    /**
     * Return true if the graph contains at least 1 statement that matches the statement provided
     * 
     * @param statement
     *            Statement to check for existence in graph
     * @return true if the graph contains at least 1 statement that matches the statement provided
     */
    public boolean contains(Statement statement);

    /**
     * Add a new statement with given subj,pred,obj
     * 
     * @param subj
     *            Subject of statement
     * @param pred
     *            Predicate of statement
     * @param obj
     *            Object of statement
     */
    public void add(Resource subj, URI pred, Value obj);

    /**
     * Add a set of statements from graph
     * 
     * @param statements
     *            statements to delete from graph
     */
    public void add(Collection<Statement> statements);

    /**
     * Add one or more statements to graph
     * 
     * @param statements
     *            statements to add to graph
     */
    public void add(Statement... statements);

    /**
     * Delete a statement from graph
     * 
     * @param subj
     *            Subject of statement
     * @param pred
     *            Predicate of statement
     * @param obj
     *            Object of statement
     */
    public void remove(Resource subj, URI pred, Value obj);

    /**
     * Delete a set of statements from graph
     * 
     * @param statements
     *            statements to delete from graph
     */
    public void remove(Statement... statements);

    /**
     * Delete a set of statements from graph
     * 
     * @param statements
     *            statements to delete from graph
     */
    public void remove(Collection<Statement> statements);

    /**
     * Delete all statements in graph
     * 
     */
    public void clear();

    /**
     * Return number of statements in graph
     * 
     * @return number of statements in graph
     */
    public int size();

    /**
     * Return if graph is empty
     * 
     * @return true if graph is empty
     */
    public boolean isEmpty();

    /**
     * Close the graph.
     * 
     */
    public void close();

    /**
     * Return if graph is closed
     * 
     * @return true if graph is closed
     */
    public boolean isClosed();

}
