/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/glitter/predicates/Attic/TextLikePredicate.java,v $
 * Created by:  Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 * Created on:  12/18/2006
 * Revision:	$Id: TextLikePredicate.java 199 2007-08-01 16:25:34Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.container.query;

import java.util.ArrayList;
import java.util.List;

import org.openanzo.glitter.exception.FunctionalPredicateInvocationException;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.NodeCostModel;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.PatternSolutionImpl;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionList;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.indexer.IndexerException;
import org.openanzo.jdbc.container.sql.NodeSQL;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.MemVariable;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * Special predicate that allows one to use a SQL like query to match literal values. <li>Example: SELECT ?S WHERE {?s <http:/openanzo.org/predicates/textlike>
 * 'test%'}</li>
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class TextLikePredicate implements FunctionalPredicate {

    protected Variable            var;

    protected String              textMatch;

    protected List<TriplePattern> patterns                = new ArrayList<TriplePattern>();

    protected QueryInformation    queryInformation;

    protected TriplePattern       functionalTriplePattern = null;

    public void initialize(QueryInformation qi) {
        this.queryInformation = qi;
    }

    public boolean canBindGraphVariables() {
        return false;
    }

    public SolutionSet generateSolutions(URI namedGraph, Variable namedGraphVariable, SolutionSet bindingConstraints) throws GlitterException {
        // Massage the match text to include other variables.
        // For now, only support one pattern; not clear what multiple
        // patterns mean.
        SolutionGenerator sg = queryInformation.getSolutionGenerator();
        SolutionSet ss = new SolutionList();
        if (sg instanceof RdbSolutionGenerator) {
            RdbSolutionGenerator bssg = (RdbSolutionGenerator) sg;
            if (bssg.getContainer().getLiteralIndexer() != null) {
                try {
                    List<Long> ids = bssg.getContainer().getLiteralIndexer().query(textMatch);
                    for (Long id : ids) {
                        PatternSolution sol = new PatternSolutionImpl();
                        sol.setBinding(var, bssg.getContainer().getNodeLayout().getNodeConverter().getGlitterNode(id, bssg.getContainer().getConnection()));
                        ss.add(sol);
                    }
                } catch (IndexerException ie) {
                    throw new GlitterException(ie);
                }
            } else {
                ClosableIterator<Long> results = null;
                try {
                    Long id = bssg.getContainer().getNodeLayout().getDatatypeLayout().fetchId(org.openanzo.rdf.vocabulary.XMLSchema.STRING.toString(), bssg.getContainer().getConnection());
                    results = NodeSQL.findNodeID(bssg.getContainer().getPreparedStatementProvider(), bssg.getContainer().getConnection(), (id != null) ? id.longValue() : 0, textMatch, bssg.getContainer().getNodeLayout().getLiteralTableName(), bssg.getContainer().getConfiguration().getOptimizationString());
                } catch (RdbException e) {
                    throw new GlitterException(e);
                }
                try {
                    while (results.hasNext()) {
                        long id = results.next();
                        PatternSolution sol = new PatternSolutionImpl();
                        sol.setBinding(var, bssg.getContainer().getNodeLayout().getNodeConverter().getGlitterNode(id, bssg.getContainer().getConnection()));
                        ss.add(sol);
                    }
                } finally {
                    results.close();
                }
            }
        } else {
            throw new GlitterException("SolutionGenerator must be a RdbServerSolutionGenerator to generate TextLikePredicate solutions");
        }
        return ss;
    }

    public boolean handlesTriplePattern(TriplePattern pattern) throws FunctionalPredicateInvocationException {
        if (pattern.getObject().equals(var)) {
            patterns.add(pattern);
            return false;
        }
        return false;
    }

    public void setFunctionalTriplePattern(TriplePattern pattern) throws FunctionalPredicateInvocationException {
        if (!(pattern.getSubject() instanceof Bindable))
            throw new FunctionalPredicateInvocationException("Subject of textmatch must be a bindable");
        if (!TypeConversions.isSimpleLiteral(pattern.getObject()))
            throw new FunctionalPredicateInvocationException("Object of textmatch must be a simple literal");
        this.var = (MemVariable) pattern.getSubject();
        this.textMatch = pattern.getObject().toString();
        this.textMatch = this.textMatch.substring(1, this.textMatch.length() - 1);
        functionalTriplePattern = pattern;
    }

    public boolean usesDataFromGraphs() {
        return false;
    }

    public double getCost(NodeCostModel costModel) {
        return 0;
    }

    public TriplePattern getFunctionalTriplePattern() {
        return functionalTriplePattern;
    }
}
