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
 * Revision:	$Id: OdoQueryOptimizer.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.planning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.openanzo.glitter.query.NodeCostModel;
import org.openanzo.glitter.query.QueryExecutionPlan;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.rdf.Variable;

/**
 * The OdoQueryOptimizer attempts to prioritize evaluation of triple patterns with less free variables before those with more free variables.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class OdoQueryOptimizer implements QueryExecutionPlan {

    //private static final Logger  log  = LoggerFactory.getLogger(OdoQueryOptimizer.class);

    private final GreedyCostBasedExecutionPlan plan;

    //private final IQuadStore                   quadStore;

    /**
     * Create optimizer
     * 
     */
    public OdoQueryOptimizer() {
        this(new SimpleCostModel());
    }

    public OdoQueryOptimizer(NodeCostModel costModel) {
        plan = new GreedyCostBasedExecutionPlan(costModel);
    }

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
            List<TreeNode> newNodes = this.plan.orderNodes(ntNodes);
            LinkedList<TreeNode> uncompiled = new LinkedList<TreeNode>(newNodes);
            Set<TreeNode> compiled = new LinkedHashSet<TreeNode>();

            //VariableReferenceCount runningCount = new VariableReferenceCount();
            while (!uncompiled.isEmpty()) {
                TreeNode current = uncompiled.removeFirst();
                compiled.add(current);
                Collection<TreeNode> changedNodes = new TreeSet<TreeNode>(new TNNumberMatchComparator(current.getReferencedVariables()));

                for (TreeNode uncompiledNode : uncompiled) {
                    if (tnVariablesMatch(current.getBindableVariables(), uncompiledNode)) {
                        changedNodes.add(uncompiledNode);
                    }
                }
                for (TreeNode changedNode : changedNodes) {
                    uncompiled.remove(changedNode);
                    compiled.add(changedNode);
                }
            }
            ArrayList<TreeNode> tnodes = new ArrayList<TreeNode>();
            for (TreeNode tn : compiled) {
                tnodes.add(tn);
            }
            return tnodes;
        }
    }

    private static boolean tnVariablesMatch(Set<Variable> vars, TreeNode node) {
        for (Variable v : node.getReferencedVariables()) {
            if (vars.contains(v))
                return true;
        }
        return false;
    }

    private static class NumberMatchComparator implements Comparator<OdoTripleNode> {
        Collection<Variable> variables;

        NumberMatchComparator(Collection<Variable> variables) {
            this.variables = variables;
        }

        public int compare(OdoTripleNode o1, OdoTripleNode o2) {
            int a = 0;
            int b = 0;
            for (Variable var : variables) {
                if (o1.checkMatch(var)) {
                    a++;
                }
                if (o2.checkMatch(var)) {
                    b++;
                }
            }
            if (a > b)
                return -1;
            else if (b > a)
                return 1;
            else {
                return o1.toString().compareTo(o2.toString());
            }
        }
    }

    private static class TNNumberMatchComparator implements Comparator<TreeNode> {
        Collection<Variable> variables;

        TNNumberMatchComparator(Collection<Variable> variables) {
            this.variables = variables;
        }

        public int compare(TreeNode o1, TreeNode o2) {
            int a = 0;
            int b = 0;
            for (Variable var : variables) {
                if (o1.getReferencedVariables().contains(var)) {
                    a++;
                }
                if (o2.getReferencedVariables().contains(var)) {
                    b++;
                }
            }
            if (a > b)
                return -1;
            else if (b > a)
                return 1;
            else {
                return o1.toString().compareTo(o2.toString());
            }
        }
    }

    private static class TripleList implements Iterable<TreeNode> {

        private final SortedSet<OdoTripleNode> sortedSet = new TreeSet<OdoTripleNode>();

        private Set<OdoTripleNode>             set       = this.sortedSet;

        private TripleList() {
        }

        private void add(TriplePatternNode tripleNode) {
            OdoTripleNode node = new OdoTripleNode(tripleNode);//, quadStore);
            this.sortedSet.add(node);
        }

        private void compile() {
            // NOTE: the matched variables count is the number of variables in a
            // triple that will be
            // known by the time the query is run.
            // Find the match variable values for all triples
            Set<OdoTripleNode> compiled = new LinkedHashSet<OdoTripleNode>();
            //VariableReferenceCount runningCount = new VariableReferenceCount();
            while (!this.sortedSet.isEmpty()) {
                OdoTripleNode current = this.sortedSet.first();
                compiled.add(current);
                this.sortedSet.remove(current);
                Collection<OdoTripleNode> changedNodes = new TreeSet<OdoTripleNode>(new NumberMatchComparator(current.getVariables()));
                for (Variable variable : current.getVariables()) {
                    for (OdoTripleNode uncompiledNode : this.sortedSet) {
                        if (uncompiledNode.checkMatch(variable)) {
                            changedNodes.add(uncompiledNode);
                        }
                    }
                }
                for (OdoTripleNode changedNode : changedNodes) {
                    this.sortedSet.remove(changedNode);
                    compiled.add(changedNode);
                }
            }
            this.set = compiled;
        }

        public Iterator<TreeNode> iterator() {
            compile();
            List<TreeNode> list = new ArrayList<TreeNode>();
            for (OdoTripleNode node : this.set) {
                list.add(node.getTriple());
            }
            return list.iterator();
        }
    }
}
