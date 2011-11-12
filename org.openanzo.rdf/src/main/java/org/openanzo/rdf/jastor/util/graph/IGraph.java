/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/util/graph/IGraph.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: IGraph.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.util.graph;

import java.util.List;

/**
 * Graph of nodes
 * 
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 * 
 * 
 */
public interface IGraph extends IGraphPart {
    /**
     * Does graph contain edge
     * 
     * @param e
     *            edge to check
     * @return true if graph contains edge
     */
    public boolean contains(IEdge e);

    /**
     * Does graph contain node
     * 
     * @param n
     *            node to check
     * @return true if graph contains node
     */
    public boolean contains(INode n);

    /**
     * Get all edges
     * 
     * @return all edges
     */
    public List<IEdge> edges();

    /**
     * Get all nodes
     * 
     * @return all nodes
     */
    public List<INode> nodes();

    /**
     * Is graph empty
     * 
     * @return is empty
     */
    public boolean isEmpty();

    /**
     * Get size of edges
     * 
     * @return size of edges
     */
    public int getEdgeCount();

    /**
     * Get size of nodes
     * 
     * @return size of nodes
     */
    public int getNodeCount();

    /**
     * Add an edge
     * 
     * @param e
     *            add an edge
     */
    public void addEdge(IEdge e);

    /**
     * Remove an edge
     * 
     * @param e
     *            edge to remove
     */
    public void removeEdge(IEdge e);

    /**
     * Add a node
     * 
     * @param n
     *            node to add
     */
    public void addNode(INode n);

    /**
     * Remove a node
     * 
     * @param n
     *            node to remove
     */
    public void removeNode(INode n);

    /**
     * Get Node by name
     * 
     * @param name
     *            name of node
     * @return node
     */
    public INode getNodeByName(String name);

    /**
     * Get Edge by node
     * 
     * @param name
     *            name of edge
     * @return edge
     */
    public IEdge getEdgeByName(String name);
}
