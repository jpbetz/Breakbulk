/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/util/graph/AlgorithmsBase.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: AlgorithmsBase.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.util.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Base algorithm
 * 
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 * 
 */
public abstract class AlgorithmsBase {

    protected final static Integer WHITE        = Integer.valueOf(0);

    protected final static Integer GRAY         = Integer.valueOf(1);

    protected final static Integer BLACK        = Integer.valueOf(2);

    protected final static int     NOTEXECUTED  = -1;

    protected final static int     EXECUTED     = 0;

    protected final static int     EXECUTING    = 1;

    protected final static INode   NILNODE      = new INode() {

                                                    public IGraph getGraph() {
                                                        return null;
                                                    }

                                                    public IEdge getIncomingEdge(INode n) {
                                                        return null;
                                                    }

                                                    public List<IEdge> getIncomingEdges() {
                                                        return null;
                                                    }

                                                    public IEdge getOutgoingEdge(INode n) {
                                                        return null;
                                                    }

                                                    public List<IEdge> getOutgoingEdges() {
                                                        return null;
                                                    }

                                                    public boolean hasIncomingEdge(INode n) {
                                                        return false;
                                                    }

                                                    public boolean hasOutgoingEdge(INode n) {
                                                        return false;
                                                    }

                                                    public boolean isInGraph() {
                                                        return false;
                                                    }

                                                    public boolean isInGraph(IGraph graph) {
                                                        return false;
                                                    }

                                                    public void removeIncomingEdge(IEdge e) {
                                                    }

                                                    public void removeOutgoingEdge(IEdge e) {
                                                    }

                                                    public Object getData() {
                                                        return null;
                                                    }

                                                    public String getName() {
                                                        return null;
                                                    }

                                                    public void setData(Object data) {
                                                    }
                                                };

    protected final static int     INVALID_TIME = -1;

    protected IGraph               graph        = null;

    protected int                  state        = NOTEXECUTED;

    /**
     * Set the graph for the algorithm
     * 
     * @param graph
     *            the graph for the algorithm
     */
    public void setGraph(IGraph graph) {
        this.graph = graph;
        resetState();
    }

    IGraph getGraph() {
        return this.graph;
    }

    protected void checkState() {
        if (EXECUTED != state)
            throw new IllegalStateException();
    }

    protected void resetState() {
        state = NOTEXECUTED;
    }

    /**
     * Execute the algorithm
     */
    public abstract void execute();

    /**
     * Get results of running algorithm
     * 
     * @return results of running algorithm
     */
    public abstract Object result();

    static String[][] convertToPrintMatrix(IGraph graph, INode[] nodes) {
        String[][] closure = new String[nodes.length + 1][nodes.length + 1];
        closure[0][0] = "    ";
        for (int n = 1; n < closure.length; n++) {
            String name = nodes[n - 1].getName();
            if (name.length() < 3) {
                while (name.length() != 3) {
                    name = " " + name;
                }
            }
            name = " " + name.substring(name.length() - 3);
            closure[n][0] = name;
            closure[0][n] = name;
        }
        for (int n = 1; n < closure.length; n++) {
            for (int m = 1; m < closure.length; m++) {
                INode source = graph.getNodeByName(nodes[n - 1].getName());
                INode dest = graph.getNodeByName(nodes[m - 1].getName());
                closure[n][m] = source.hasOutgoingEdge(dest) ? "   1" : "    ";
            }
        }
        return closure;
    }

    static String[][] convertToPrintMatrix(IGraph graph) {
        INode[] nodes = new INode[graph.getNodeCount()];
        graph.nodes().toArray(nodes);
        return convertToPrintMatrix(graph, nodes);
    }

    static int[][] convertToAdjMatrix(IGraph graph, INode[] nodes) {
        int[][] closure = new int[nodes.length][nodes.length];
        for (int n = 0; n < nodes.length; n++) {
            for (int m = 0; m < nodes.length; m++) {
                INode source = graph.getNodeByName(nodes[n].getName());
                INode dest = graph.getNodeByName(nodes[m].getName());
                closure[n][m] = source.hasOutgoingEdge(dest) ? 1 : 0;
            }
        }
        return closure;
    }

    static int[][] convertToAdjMatrix(IGraph graph) {
        INode[] nodes = new INode[graph.getNodeCount()];
        graph.nodes().toArray(nodes);
        return convertToAdjMatrix(graph, nodes);
    }

    static List<List<INode>> convertToAdjList(IGraph graph) {
        INode[] nodes = new INode[graph.getNodeCount()];
        graph.nodes().toArray(nodes);
        List<List<INode>> list = new ArrayList<List<INode>>(nodes.length);
        for (int n = 0; n < nodes.length; n++) {
            List<INode> edges = new LinkedList<INode>();
            for (IEdge edge : nodes[n].getOutgoingEdges()) {
                edges.add(edge.getDestination());
            }
            list.add(edges);
        }
        return list;
    }

    protected void startExecution() {
        state = EXECUTING;
    }

    protected void endExecution() {
        state = EXECUTED;
    }

    static void printMatrix(String[][] matrix) {
        for (int n = 0; n < matrix.length; n++) {
            for (int m = 0; m < matrix.length; m++) {
                System.out.print(matrix[n][m]);
            }
            System.out.println();
        }
    }

    static void printMatrix(IGraph graph) {
        printMatrix(convertToPrintMatrix(graph));
    }

    static void printMatrix(IGraph graph, INode[] nodes) {
        printMatrix(convertToPrintMatrix(graph, nodes));
    }
}
