/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/query/Attic/ContainerSolutionGenerator.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: $Date$
 * Revision: $Id: ContainerSolutionGenerator.java 168 2007-07-31 14:11:14Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.SolutionList;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;

/**
 * ContainerSolutionGenerator solves only TriplePatternNode patterns using the IContainer to find triples
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class QuadStoreSolutionGenerator extends CoreSolutionGenerator {

    /** Source of data for query */
    protected IQuadStore    container;

    private Collection<URI> defaultGraphs = null;

    private Collection<URI> namedGraphs   = null;

    /**
     * Create new ContainerSolutionGenerator in order to solve TriplePatternNode patterns within query
     * 
     * @param container
     *            Source of data for queries
     */
    public QuadStoreSolutionGenerator(IQuadStore container) {
        super();
        this.container = container;
    }

    /**
     * Create new ContainerSolutionGenerator in order to solve TriplePatternNode patterns within query
     * 
     * @param container
     *            Source of data for queries
     */
    public QuadStoreSolutionGenerator() {
        super();
    }

    public String getQueryId() {
        return null;
    }

    /**
     * Get the quadstore for the generator
     * 
     * @return the quadstore for the generator
     */
    public IQuadStore getQuadStore() {
        return container;
    }

    public SolutionSet generateSolutions(TreeNode node, org.openanzo.rdf.URI namedGraph, Variable namedGraphVariable, SolutionSet requiredBindings, QueryController controller) {
        if (!(node instanceof TriplePatternNode)) {
            return null;
        }
        // get a model
        populateModels();
        TriplePattern tp = ((TriplePatternNode) node).getTriplePattern();
        TriplePatternComponent gs = tp.getSubject();
        TriplePatternComponent gp = tp.getPredicate();
        TriplePatternComponent go = tp.getObject();
        Value s = ((gs instanceof Bindable) ? null : (Value) gs);
        URI p = ((gp instanceof Bindable) ? null : (URI) gp);
        Value o = ((go instanceof Bindable) ? null : (Value) go);
        URI context = ((namedGraph instanceof Bindable) ? null : (URI) namedGraph);
        SolutionSet solutions = new SolutionList();
        if (namedGraph == null) {
            if (namedGraphVariable != null) {
                Collection<Statement> statements = container.find((Resource) s, p, o, namedGraphs.toArray(new URI[0]));
                for (Statement statement : statements) {
                    Statement triple = statement;
                    PatternSolution sol = triple.entails(tp);
                    if (sol != null) {
                        org.openanzo.rdf.Value v = sol.getBinding(namedGraphVariable);
                        if (v == null || v.equals(statement.getNamedGraphUri())) {
                            sol.setBinding(namedGraphVariable, statement.getNamedGraphUri());
                            solutions.add(sol);
                        }
                    }
                }

            } else {
                Collection<Statement> statements = container.find((Resource) s, p, o, defaultGraphs.toArray(new URI[0]));
                for (Statement statement : statements) {
                    Statement triple = statement;
                    PatternSolution sol = triple.entails(tp);
                    if (sol != null) {
                        solutions.add(sol);
                    }
                }
            }
        } else {
            Collection<Statement> statements = container.find((Resource) s, p, o, context);
            for (Statement statement : statements) {
                Statement triple = statement;
                PatternSolution sol = triple.entails(tp);
                if (sol != null) {
                    if (namedGraphVariable != null) {
                        org.openanzo.rdf.Value v = sol.getBinding(namedGraphVariable);
                        if (v != null && !v.equals(context))
                            continue;
                        sol.setBinding(namedGraphVariable, context);
                    }
                    solutions.add(sol);
                }
            }
        }
        return solutions;
    }

    private final void populateModels() {
        if (this.defaultGraphs != null) {
            return;
        }
        this.defaultGraphs = new ArrayList<URI>();
        this.namedGraphs = new ArrayList<URI>();
        Set<URI> dgs = this.dataset.getDefaultGraphURIs();
        if (dgs != null)
            this.defaultGraphs.addAll(dgs);

        Set<URI> ngs = this.dataset.getNamedGraphURIs();
        if (ngs != null)
            this.namedGraphs.addAll(ngs);

    }
}
