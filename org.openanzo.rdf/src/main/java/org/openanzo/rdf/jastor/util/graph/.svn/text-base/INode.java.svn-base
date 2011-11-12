/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/util/graph/INode.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: INode.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.util.graph;

import java.util.List;

/**
 * Node of a graph
 * 
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 * 
 */
public interface INode extends IGraphPart {
    /**
     * Is node in the graph
     * 
     * @return node in the graph
     */
    public boolean isInGraph();

    /**
     * Is this node in the graph
     * 
     * @param graph
     *            graph to check
     * @return true if node is the graph
     */
    public boolean isInGraph(IGraph graph);

    /**
     * Get the graph for the node
     * 
     * @return the graph for the node
     */
    public IGraph getGraph();

    /**
     * Get all incoming edges
     * 
     * @return all incoming edges
     */
    public List<IEdge> getIncomingEdges();

    /**
     * Get all outgoing edges
     * 
     * @return all outgoing edges
     */
    public List<IEdge> getOutgoingEdges();

    /**
     * Does node have this incoming node
     * 
     * @param n
     *            node to check
     * @return true if node has an incoming edge for n
     */
    public boolean hasIncomingEdge(INode n);

    /**
     * Get incoming edge for node n
     * 
     * @param n
     *            node to get
     * @return incoming edge for node
     */
    public IEdge getIncomingEdge(INode n);

    /**
     * Remove the incoming edge
     * 
     * @param e
     *            edge to remove
     */
    public void removeIncomingEdge(IEdge e);

    /**
     * Does node have an outgoing node for node n
     * 
     * @param n
     *            node to check
     * @return true if node has outgoing edge for n
     */
    public boolean hasOutgoingEdge(INode n);

    /**
     * Get outgoing edge for node n
     * 
     * @param n
     *            node to get
     * @return outgoing edge for n
     */
    public IEdge getOutgoingEdge(INode n);

    /**
     * Remove outgoing edge
     * 
     * @param e
     *            edge to remove
     */
    public void removeOutgoingEdge(IEdge e);
}
