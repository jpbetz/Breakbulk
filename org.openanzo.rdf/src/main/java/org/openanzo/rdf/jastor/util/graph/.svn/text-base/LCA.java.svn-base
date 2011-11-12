/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/util/graph/LCA.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: LCA.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.util.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 * 
 */
public class LCA extends AlgorithmsBase {

    private DFS dfs = new DFS();

    @Override
    public void setGraph(IGraph graph) {
        super.setGraph(graph);
        dfs.setGraph(graph);
    }

    @Override
    public void execute() {
        startExecution();
        dfs.execute();
        endExecution();
    }

    @Override
    public Object result() {
        return null;
    }

    /**
     * Get least common ancestor for 2 nodes
     * 
     * @param node1
     *            node1
     * @param node2
     *            node1
     * @return return least common ancestor for 2 nodes
     */
    public INode getLCA(INode node1, INode node2) {
        checkState();
        INode ancestor = null;
        // LCA(v,v) = v
        if (node1.equals(node2)) {
            return node1;
        }
        List<INode> ancestors1 = getAncestry(node1);
        List<INode> ancestors2 = getAncestry(node2);
        // node2 is an ancestor of node1
        int index = ancestors1.indexOf(node2);
        if (index != -1 && index != (ancestors1.size() - 1)) {
            return node2;
        }
        // node1 is an ancestor of node2
        index = ancestors2.indexOf(node1);
        if (index != -1 && index != (ancestors2.size() - 1)) {
            return node1;
        }
        // node1 == root
        if (ancestors1.size() == 1) {
            return node1;
        } else if (ancestors2.size() == 1) {
            // node2 == root
            return node2;
        }
        Iterator<INode> it1 = ancestors1.iterator();
        Iterator<INode> it2 = ancestors2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            INode ancestor1 = it1.next();
            INode ancestor2 = it2.next();
            if (ancestor1.getName().equals(ancestor2.getName())) {
                ancestor = ancestor1;
            } else {
                break;
            }
        }
        return ancestor;
    }

    private List<INode> getAncestry(INode node) {
        List<INode> ancestors = new ArrayList<INode>();
        ancestors.add(node);
        INode current = dfs.getParent(node);
        while (current != null) {
            ancestors.add(0, current);
            current = dfs.getParent(current);
        }
        return ancestors;
    }
}
