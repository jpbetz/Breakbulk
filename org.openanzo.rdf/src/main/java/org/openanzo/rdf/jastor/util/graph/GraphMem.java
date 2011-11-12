/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/util/graph/GraphMem.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: GraphMem.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.util.graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * In memory graph
 * 
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 * 
 */
public class GraphMem extends GraphPartBase implements IGraph {

    protected Map<String, IEdge> edgesByName = new TreeMap<String, IEdge>();

    protected Map<String, INode> nodesByName = new TreeMap<String, INode>();

    protected LinkedList<IEdge>  edges       = new LinkedList<IEdge>();

    protected LinkedList<INode>  nodes       = new LinkedList<INode>();

    /**
     * Create memory graph
     * 
     * @param name
     *            name of graph
     */
    public GraphMem(String name) {
        super(name);
    }

    INode getNode(String name) {
        return nodesByName.get(name);
    }

    IEdge getEdge(String name) {
        return edgesByName.get(name);
    }

    public INode getNodeByName(String name) {
        return nodesByName.get(name);
    }

    public IEdge getEdgeByName(String name) {
        return edgesByName.get(name);
    }

    public void addEdge(IEdge e) {
        INode source = e.getSource();
        INode dest = e.getDestination();
        if (!contains(source) || !contains(dest)) {
            //
        }
        ((NodeMem) source).addOutgoingEdge((EdgeMem) e);
        ((NodeMem) dest).addIncomingEdge((EdgeMem) e);
        ((EdgeMem) e).setInGraph(this);
        edgesByName.put(e.getName(), e);
        edges.add(e);
    }

    public void addNode(INode n) {
        ((NodeMem) n).setInGraph(this);
        nodesByName.put(n.getName(), n);
        nodes.add(n);
    }

    public boolean contains(IEdge e) {
        return edges.contains(e);
    }

    public boolean contains(INode n) {
        return nodes.contains(n);
    }

    public List<IEdge> edges() {
        return Collections.unmodifiableList(edges);
    }

    public List<INode> nodes() {
        return Collections.unmodifiableList(nodes);
    }

    public int getEdgeCount() {
        return edges.size();
    }

    public int getNodeCount() {
        return nodes.size();
    }

    public boolean isEmpty() {
        return (nodes.size() == 0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ibm.adtech.slingshot.graph.IGraph#removeEdge(com.ibm.adtech.slingshot.graph.IEdge)
     */
    public void removeEdge(IEdge e) {
        if (!edges.contains(e))
            return;
        ((EdgeMem) e).setInGraph(null);
        edgesByName.remove(e.getName());
        edges.remove(e);
        e.getSource().removeOutgoingEdge(e);
        e.getDestination().removeIncomingEdge(e);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ibm.adtech.slingshot.graph.IGraph#removeNode(com.ibm.adtech.slingshot.graph.INode)
     */
    public void removeNode(INode n) {
        if (!nodes.contains(n))
            return;
        ((NodeMem) n).setInGraph(null);
        nodesByName.remove(n.getName());
        nodes.remove(n);
        for (IEdge edge : n.getIncomingEdges()) {
            removeEdge(edge);
        }
        for (IEdge edge : n.getOutgoingEdges()) {
            removeEdge(edge);
        }
    }
}
