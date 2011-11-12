/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/planning/Attic/OdoQueryOptimizer.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Feb 8, 2007
 * Revision:	$Id: QueryOptimizer.java 229 2007-08-07 15:22:00Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.planning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.openanzo.glitter.query.QueryExecutionPlan;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;

/**
 * QueryOptimizer
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class QueryOptimizer implements QueryExecutionPlan {
    private final GreedyCostBasedExecutionPlan plan = new GreedyCostBasedExecutionPlan(new SimpleCostModel());

    public List<TreeNode> orderNodes(List<? extends TreeNode> nodes) {
        TripleList list = new TripleList();
        boolean allTPN = true;
        List<TreeNode> ntNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (!(node instanceof TriplePatternNode)) {
                allTPN = false;
            } else {
                list.add((TriplePatternNode) node);
            }
            ntNodes.add(node);
        }
        if (allTPN) {
            ArrayList<TreeNode> tnodes = new ArrayList<TreeNode>();
            for (TreeNode tn : list) {
                tnodes.add(tn);
            }
            return tnodes;
        } else {
            return this.plan.orderNodes(ntNodes);
        }
    }

    /**
     * Orders the given nodes by number of variables (ascending)
     * 
     * @param nodes
     * @return the set of ordered nodes
     */
    public Set<TripleNode> getOrderedSet(Iterator<? extends TreeNode> nodes) {
        TripleList list = new TripleList();
        boolean allTPN = true;
        Collection<TreeNode> ntNodes = new ArrayList<TreeNode>();
        while (nodes.hasNext()) {
            TreeNode node = nodes.next();
            if (!(node instanceof TriplePatternNode)) {
                allTPN = false;
            } else {
                list.add((TriplePatternNode) node);
            }
            ntNodes.add(node);
        }
        if (allTPN) {
            return list.getSet();
        } else {
            return null;
        }
    }

    private static class TripleList implements Iterable<TreeNode> {

        private final SortedSet<TripleNode> sortedSet = new TreeSet<TripleNode>();

        private Set<TripleNode>             set       = this.sortedSet;

        private TripleList() {
        }

        private void add(TriplePatternNode tripleNode) {
            TripleNode node = new TripleNode(tripleNode);
            this.sortedSet.add(node);
        }

        // SortedSet contains set of nodes sorted by number of variables
        private void compile() {
            // NOTE: the matched variables count is the number of variables in a
            // triple that will be
            // known by the time the query is run.
            // Find the match variable values for all triples
            Set<TripleNode> compiled = new TreeSet<TripleNode>();
            // VariableReferenceCount runningCount = new VariableReferenceCount();
            TripleNode ss[] = this.sortedSet.toArray(new TripleNode[0]);
            for (int i = 0; i < ss.length; i++) {
                TripleNode current = ss[i];
                compiled.add(current);
                for (int k = i + 1; k < ss.length; k++) {
                    current.buildMatch(ss[k]);
                }
            }
            this.set = compiled;
        }

        public Iterator<TreeNode> iterator() {
            compile();
            Collection<TreeNode> list = new ArrayList<TreeNode>();
            for (TripleNode node : this.set) {
                list.add(node.getTriple());
            }
            return list.iterator();
        }

        Set<TripleNode> getSet() {
            compile();
            return this.set;
        }
    }
}
