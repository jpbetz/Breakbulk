/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/util/graph/NodeMem.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: NodeMem.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.util.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Get in memory node
 * 
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 * 
 */
public class NodeMem extends GraphPartBase implements INode {

    private GraphMem graph = null;

    /**
     * Create in memory node
     * 
     * @param name
     *            name of node
     */
    public NodeMem(String name) {
        super(name);
    }

    protected LinkedList<IEdge> incomingEdges = new LinkedList<IEdge>();

    protected LinkedList<IEdge> outgoingEdges = new LinkedList<IEdge>();

    protected Map<INode, IEdge> incoming      = new HashMap<INode, IEdge>();

    protected Map<INode, IEdge> outgoing      = new HashMap<INode, IEdge>();

    void addIncomingEdge(EdgeMem e) {
        incoming.put(e.getSource(), e);
        incomingEdges.add(e);
    }

    void addOutgoingEdge(EdgeMem e) {
        outgoing.put(e.getDestination(), e);
        outgoingEdges.add(e);
    }

    public IEdge getIncomingEdge(INode n) {
        return incoming.get(n);
    }

    public boolean hasIncomingEdge(INode n) {
        return incoming.containsKey(n);
    }

    public IEdge getOutgoingEdge(INode n) {
        return outgoing.get(n);
    }

    public boolean hasOutgoingEdge(INode n) {
        return outgoing.containsKey(n);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ibm.adtech.slingshot.graph.Node#isInGraph()
     */
    public boolean isInGraph() {
        return (graph != null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ibm.adtech.slingshot.graph.Node#isInGraph(com.ibm.adtech.slingshot.graph.Graph)
     */
    public boolean isInGraph(IGraph graph) {
        return this.graph == graph;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ibm.adtech.slingshot.graph.INode#getGraph()
     */
    public IGraph getGraph() {
        return this.graph;
    }

    void setInGraph(GraphMem graph) {
        this.graph = graph;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ibm.adtech.slingshot.graph.Node#getIncomingEdges()
     */
    public List<IEdge> getIncomingEdges() {
        return Collections.unmodifiableList(incomingEdges);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ibm.adtech.slingshot.graph.Node#getOutgoingEdges()
     */
    public List<IEdge> getOutgoingEdges() {
        return Collections.unmodifiableList(outgoingEdges);
    }

    @Override
    public String toString() {
        return getName();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ibm.adtech.slingshot.graph.INode#removeIncomingEdge(com.ibm.adtech.slingshot.graph.IEdge)
     */
    public void removeIncomingEdge(IEdge e) {
        IEdge removed = incoming.remove(e.getSource());
        incomingEdges.remove(removed);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ibm.adtech.slingshot.graph.INode#removeOutgoingEdge(com.ibm.adtech.slingshot.graph.IEdge)
     */
    public void removeOutgoingEdge(IEdge e) {
        IEdge removed = outgoing.remove(e.getDestination());
        outgoingEdges.remove(removed);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof INode)) {
            return false;
        }
        return getName().equals(((INode) obj).getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
