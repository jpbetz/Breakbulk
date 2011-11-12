/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/util/graph/EdgeMem.java,v $
 * Created by:
 * Created on:  01/23/2007
 * Revision:	$Id: EdgeMem.java 172 2007-07-31 14:22:23Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.util.graph;

/**
 * In memory edge
 * 
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 * 
 */
public class EdgeMem extends GraphPartBase implements IEdge {

    private GraphMem graph  = null;

    private NodeMem  source = null;

    private NodeMem  dest   = null;

    /**
     * Create an in memory edge
     * 
     * @param name
     *            name of edge
     * @param source
     *            source of edge
     * @param dest
     *            destination of edge
     */
    public EdgeMem(String name, INode source, INode dest) {
        super(name);
        this.source = (NodeMem) source;
        this.dest = (NodeMem) dest;
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

    void setInGraph(GraphMem graph) {
        this.graph = graph;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ibm.adtech.slingshot.graph.Edge#getSource()
     */
    public INode getSource() {
        return source;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ibm.adtech.slingshot.graph.Edge#getDestination()
     */
    public INode getDestination() {
        return dest;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Edge: ");
        buffer.append(getName());
        buffer.append(" ( ");
        buffer.append("source=");
        buffer.append(source.toString());
        buffer.append(", dest=");
        buffer.append(dest.toString());
        buffer.append(" )");
        return buffer.toString();
    }
}
