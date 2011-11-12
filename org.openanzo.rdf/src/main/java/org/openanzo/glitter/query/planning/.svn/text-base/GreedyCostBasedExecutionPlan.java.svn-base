/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/planning/GreedyCostBasedExecutionPlan.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: GreedyCostBasedExecutionPlan.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.planning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openanzo.glitter.query.CostBasedQueryExecutionPlan;
import org.openanzo.glitter.query.NodeCostModel;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;

/**
 * The GreedyCostBasedExecutionPlan provides a simple way to order the execution of a SPARQL query: namely, compare the isolated costs of two nodes and evaluate
 * the cheapest node first.
 * 
 * Much more sophisticated approaches are possible, including: A dynaminc programming approach which assesses costs per node *given a set of sibling nodes which
 * have already been evaluated* The {@link OdoQueryOptimizer} approach which evaluates triple patterns containing variables that will provide bindings for other
 * triple patterns before isolated triple patterns. Predicate selectivity based models (a predicate selectivty model could feed into a simple cost model)
 * Runtime statistics based models (these could also feed into simple cost models)
 * 
 * @author Lee
 * 
 */
public class GreedyCostBasedExecutionPlan implements CostBasedQueryExecutionPlan {
    protected NodeCostModel costModel;

    /**
     * 
     * @param ncm
     *            A {@link NodeCostModel} used to determine the cost of evaluating each query node.
     */
    public GreedyCostBasedExecutionPlan(NodeCostModel ncm) {
        this.costModel = ncm;
    }

    public List<TreeNode> orderNodes(List<? extends TreeNode> it) {
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>(it);

        Collections.sort(nodes, new Comparator<TreeNode>() {
            public int compare(TreeNode o1, TreeNode o2) {
                return new Double(GreedyCostBasedExecutionPlan.this.costModel.computeCost(o1)).compareTo(GreedyCostBasedExecutionPlan.this.costModel.computeCost(o2));
            }
        });
        return nodes;
    }

    public NodeCostModel getCostModel() {
        return this.costModel;
    }
}
