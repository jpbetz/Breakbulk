/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/planning/SimpleCostModel.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: SimpleCostModel.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.planning;

import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.NodeCostModel;
import org.openanzo.glitter.syntax.abstrakt.BGP;
import org.openanzo.glitter.syntax.abstrakt.Graph;
import org.openanzo.glitter.syntax.abstrakt.Subquery;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.Variable;

/**
 * The SimpleCostModel is a very simple model of costs for a SPARQL query. It penalizes triple patterns with variables and GRAPH clauses with variables. As
 * such, it prioritizes ground triple patterns and GRAPH clauses that target specific named graphs. All other node costs simply sum the costs of their children.
 * 
 * The values used are purely arbitrary. TODO - tweak values to get reasonable results.
 * 
 * This simple mode could also be supplemented with base costs for the various node types, such that, e.g., a FILTER might be cheaper (because more selective?)
 * than an unfiltered GROUP.
 * 
 * @author Lee
 * 
 */
class SimpleCostModel implements NodeCostModel {
    static private final double TRIPLE_BASE_COST       = 1;

    static private final double TRIPLE_VARIABLE_COST   = 3;

    static private final double GRAPH_VARIABLE_PENALTY = 20;

    /**
     * Default constructor.
     */
    public SimpleCostModel() {
    }

    public double computeCost(TreeNode node) {
        if (node == null)
            return 0;
        FunctionalPredicate fp = null;
        if (node instanceof BGP && (fp = ((BGP) node).getFunctionalPredicate()) != null) {
            return fp.getCost(this);
        } else if (node instanceof TriplePatternNode) {
            TriplePattern tp = ((TriplePatternNode) node).getTriplePattern();
            int variableCount = 0;
            if (tp.getSubject() instanceof Variable)
                variableCount++;
            if (tp.getPredicate() instanceof Variable)
                variableCount++;
            if (tp.getObject() instanceof Variable)
                variableCount++;

            return TRIPLE_BASE_COST + variableCount * TRIPLE_VARIABLE_COST;
        } else if (node instanceof Graph) {
            TriplePatternComponent context = ((Graph) node).getGraphContext();
            double factor = context instanceof Variable ? GRAPH_VARIABLE_PENALTY : 1;
            return factor * computeCost(((Graph) node).getGraphPattern());
        } else if (node instanceof Subquery) {
            return 1 * ((Subquery) node).getBindableVariables().size();
        } else {
            double cost = 0;
            for (TreeNode it : node.getChildren()) {
                cost += computeCost(it);
            }
            return cost;
        }
    }

}
