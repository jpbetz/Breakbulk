/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/util/graph/DFS.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: DFS.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.util.graph;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Depth First Search
 * 
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 * 
 */
public class DFS extends AlgorithmsBase {

    // run data
    private HashMap<INode, Integer> discover, color, finish;

    private HashMap<INode, INode>   prev;

    private List<INode>             nodesByDiscover, nodesByFinish;

    private int                     time = 0;

    protected boolean               done = false;

    private INode                   end;

    private GraphMem                tree = null;

    synchronized void executeSubgraph() {
        startExecution();
        reinit();
        for (INode node : graph.nodes()) {
            if (isDone())
                break;
            if (color.get(node).equals(WHITE) && node.getIncomingEdges().size() == 0) {
                visit(node);
            }
        }
        endExecution();
    }

    synchronized void executeSubgraph(INode start) {
        startExecution();
        reinit();
        visit(start);
        endExecution();
    }

    synchronized void execute(INode start) {
        startExecution();
        reinit();
        visit(start);
        internalExecute();
        endExecution();
    }

    synchronized void execute(INode start, INode end) {
        startExecution();
        reinit();
        this.end = end;
        visit(start);
        internalExecute();
        endExecution();
    }

    @Override
    public synchronized void execute() {
        startExecution();
        reinit();
        internalExecute();
        endExecution();
    }

    void internalExecute() {
        for (INode node : graph.nodes()) {
            if (isDone())
                break;
            if (color.get(node).equals(WHITE) && node.getIncomingEdges().size() == 0) {
                visit(node);
            }
        }
        for (INode node : graph.nodes()) {
            if (isDone())
                break;
            if (color.get(node).equals(WHITE)) {
                visit(node);
            }
        }
    }

    protected void reinit() {
        prev = new HashMap<INode, INode>();
        color = new HashMap<INode, Integer>();
        discover = new HashMap<INode, Integer>();
        finish = new HashMap<INode, Integer>();
        nodesByDiscover = new LinkedList<INode>();
        nodesByFinish = new LinkedList<INode>();
        end = null;
        time = 0;
        for (INode node : graph.nodes()) {
            color.put(node, WHITE);
            prev.put(node, NILNODE);
        }
        tree = new GraphMem("dfs-tree");
    }

    /**
     * Print results of depth first search
     * 
     * @param writer
     *            output writer
     */
    public void printResults(PrintWriter writer) {
        checkState();
        ArrayList<INode> ordered = new ArrayList<INode>(time);
        for (int i = 0; i < time; i++) {
            ordered.add(NILNODE);
        }
        for (INode node : graph.nodes()) {
            ordered.set(getDiscoverTime(node) - 1, node);
            ordered.set(getFinishTime(node) - 1, node);
        }
        for (int i = 0; i < ordered.size(); i++) {
            System.out.print(ordered.get(i) + ",");
        }
    }

    private void visit(INode node) {
        color.put(node, GRAY);
        time++;
        discover.put(node, Integer.valueOf(time));
        nodesByDiscover.add(node);
        startVisit(node);
        for (IEdge edge : node.getOutgoingEdges()) {
            if (isDone())
                break;
            INode adj = edge.getDestination();
            if (color.get(adj).equals(WHITE)) {
                prev.put(adj, node);
                visit(adj);
            } else if (color.get(adj).equals(GRAY)) { // back-edge
                foundBackEdge(edge);
            } else if (color.get(adj).equals(BLACK)) {
                if (getDiscoverTime(edge.getSource()) > getDiscoverTime(edge.getDestination())) {
                    foundCrossEdge(edge);
                } else {
                    foundForwardEdge(edge);
                }
            }
        }
        color.put(node, BLACK);
        time++;
        finish.put(node, Integer.valueOf(time));
        nodesByFinish.add(node);
        finishVisit(node);
    }

    INode getParent(INode child) {
        checkState();
        INode object = prev.get(child);
        return (object != NILNODE) ? (INode) object : null;
    }

    private int getFinishTime(INode node) {
        if (!finish.containsKey(node))
            return INVALID_TIME;
        Integer val = finish.get(node);
        return val.intValue();
    }

    private int getDiscoverTime(INode node) {
        if (!discover.containsKey(node))
            return INVALID_TIME;
        Integer val = discover.get(node);
        return val.intValue();
    }

    /**
     * Get nodes by discover time
     * 
     * @return nodes by discover time
     */
    public List<INode> getNodesByDiscoverTime() {
        checkState();
        return Collections.unmodifiableList(nodesByDiscover);
    }

    /**
     * Get nodes by finish time
     * 
     * @return nodes by finish time
     */
    public List<INode> getNodesByFinishTime() {
        checkState();
        return Collections.unmodifiableList(nodesByFinish);
    }

    @Override
    public Object result() {
        checkState();
        if (tree.getEdgeCount() == 0) {
            for (INode node : prev.keySet()) {
                tree.addNode(new NodeMem(node.getName()));
            }
            for (INode node : prev.keySet()) {
                if (!prev.get(node).equals(NILNODE)) {
                    INode prevNode = prev.get(node);
                    tree.addEdge(new EdgeMem("tree-edge", tree.getNodeByName(prevNode.getName()), tree.getNodeByName(node.getName())));
                }
            }
        }
        return tree;
    }

    /**
     * Print results
     */
    public void printResult() {
        checkState();
    }

    protected boolean isDone() {
        return done;
    }

    protected void startVisit(INode n) {
        if (end != null && end.equals(n))
            done = true;
    }

    protected void finishVisit(INode n) {
    }

    protected void foundForwardEdge(IEdge edge) {
    }

    protected void foundBackEdge(IEdge edge) {
    }

    protected void foundCrossEdge(IEdge edge) {
    }
}
