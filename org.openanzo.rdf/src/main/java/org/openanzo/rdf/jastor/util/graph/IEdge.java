/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/util/graph/IEdge.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: IEdge.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.util.graph;

/**
 * Edge in graph
 * 
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 * 
 */
public interface IEdge extends IGraphPart {
    /**
     * Is this edge in a graph
     * 
     * @return true if edge in the graph
     */
    public boolean isInGraph();

    /**
     * Is this edge in the specified graph
     * 
     * @param graph
     *            graph to check
     * @return true if edge in the graph
     */
    public boolean isInGraph(IGraph graph);

    /**
     * Get source of edge
     * 
     * @return source of edge
     */
    public INode getSource();

    /**
     * Get destination of edge
     * 
     * @return destination of edge
     */
    public INode getDestination();
}
