/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/glitter/predicates/TextMatchPredicate.java,v $
 * Created by:  Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 * Created on:  12/18/2006
 * Revision:	$Id: TextMatchPredicate.java 227 2007-08-02 13:52:42Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.BooleanClause.Occur;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.FunctionalPredicateInvocationException;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.INDEXER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Special predicate that allows one to use the text indexer to match literal values. <li>Example: SELECT ?S WHERE {?s <http:/openanzo.org/predicates/textlike>
 * 'test%'}</li>
 * 
 * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 * 
 */
//FIXEXCEPTIONS:Fix strings in exceptions
public class TextMatchPredicate implements FunctionalPredicate {
    private static final Logger       log                     = LoggerFactory.getLogger(TextMatchPredicate.class.getName());

    private Bindable                  var;

    private String                    textMatch;

    private final List<TriplePattern> patterns                = new ArrayList<TriplePattern>();

    private QueryInformation          queryInformation;

    private TriplePattern             functionalTriplePattern = null;

    public void initialize(QueryInformation qi) {
        this.queryInformation = qi;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append("(TriplePatternNode(");
        sb.append(functionalTriplePattern.toString());
        sb.append(")");
        for (TriplePattern tp : patterns) {
            sb.append(", TriplePatternNode(");
            sb.append(tp.toString());
            sb.append(")");
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean canBindGraphVariables() {
        return true;
    }

    /**
     * Return the patterns that this special predicate handles
     * 
     * @return the patterns that this special predicate handles
     */
    public List<TriplePattern> getPatterns() {
        return patterns;
    }

    /**
     * Create a solution set based on the results of a lucene query
     * 
     * @param results
     *            results to convert
     * @param namedGraphVariable
     *            variable binding for namedgraph
     * @return the converted solution set
     */
    public SolutionSet createSolutionSet(Collection<Statement> results, Variable namedGraphVariable) {
        SolutionList ss = new SolutionList();
        boolean includePattern = patterns.size() > 0;

        Bindable subjBindable = null;
        Bindable predBindable = null;

        if (includePattern) {
            TriplePattern p = patterns.get(0);
            TriplePatternComponent subj = p.getSubject();
            TriplePatternComponent pred = p.getPredicate();
            if (subj instanceof Bindable) {
                subjBindable = (Bindable) subj;
            }
            if (pred instanceof Bindable) {
                predBindable = (Bindable) pred;
            }
        }

        for (Statement quad : results) {

            PatternSolution sol = new PatternSolutionImpl();
            sol.setBinding(var, quad.getObject());
            if (includePattern && subjBindable != null) {
                sol.setBinding(subjBindable, quad.getSubject());
            }
            if (includePattern && predBindable != null) {
                sol.setBinding(predBindable, quad.getPredicate());
            }
            if (namedGraphVariable != null)
                sol.setBinding(namedGraphVariable, quad.getNamedGraphUri());
            ss.add(sol);
        }
        return ss;
    }

    /**
     * @return the textMatch
     */
    public String getTextMatch() {
        return textMatch;
    }

    /**
     * @return the var
     */
    public Bindable getVar() {
        return var;
    }

    /**
     * Create a lucene query for the given configuration
     * 
     * @param namedGraph
     *            namedgraph for query
     * @param namedGraphVariable
     *            variable for binding namedgraph
     * @return lucene query object
     * @throws GlitterException
     */
    public TextMatchQuery getLuceneQuery(org.openanzo.rdf.URI namedGraph, Variable namedGraphVariable) throws GlitterException {
        // Massage the match text to include other variables.
        // For now, only support one pattern; not clear what multiple
        // patterns mean.
        boolean includePattern = patterns.size() > 0;
        if (patterns.size() > 1) {
            throw new GlitterException("Can't support multiple patterns for textmatch");
        }
        TextMatchQuery query = new TextMatchQuery();
        query.literalQuery = textMatch;
        if (includePattern) {
            TriplePattern p = patterns.get(0);
            TriplePatternComponent subj = p.getSubject();
            TriplePatternComponent pred = p.getPredicate();
            if (!(subj instanceof Bindable)) {
                query.terms.add(new TermQuery(new Term(INDEXER.INDEXER_FIELD_SUBJECT, subj.toString())));
            }
            if (!(pred instanceof Bindable)) {
                query.terms.add(new TermQuery(new Term(INDEXER.INDEXER_FIELD_PREDICATE, pred.toString())));
            }
        }
        boolean noSolutions = false;
        if (namedGraph != null) {
            if (namedGraph.equals(GRAPHS.ALL_METADATAGRAPHS))
                noSolutions = true;
            if (!namedGraph.equals(GRAPHS.ALL_NAMEDGRAPHS) && !namedGraph.equals(GRAPHS.ALL_GRAPHS))
                query.terms.add(new TermQuery(new Term(INDEXER.INDEXER_FIELD_GRAPH_URI, namedGraph.toString())));
        } else {
            Set<URI> iter = null;
            if (namedGraphVariable == null) {
                iter = queryInformation.getSolutionGenerator().getQueryDataset().getDefaultGraphURIs();
            } else {
                iter = queryInformation.getSolutionGenerator().getQueryDataset().getNamedGraphURIs();
            }
            Set<URI> ngraphs = new HashSet<URI>();
            for (URI currURI : iter) {
                // Ignore metadatagraphs.
                if (currURI.equals(GRAPHS.ALL_METADATAGRAPHS))
                    continue;
                // Don't restrict search to certain graphs since these include all named graphs.
                if (currURI.equals(GRAPHS.ALL_GRAPHS) || currURI.equals(GRAPHS.ALL_NAMEDGRAPHS)) {
                    ngraphs.clear();
                    break;
                }
                ngraphs.add(currURI);
            }
            int datasetThreshold = 500;
            if (ngraphs.size() > 0) {
                if (ngraphs.size() < datasetThreshold) {
                    if (ngraphs.size() == 1) {
                        URI ngURI = ngraphs.iterator().next();
                        query.terms.add(new TermQuery(new Term(INDEXER.INDEXER_FIELD_GRAPH_URI, ngURI.toString())));
                    } else {
                        BooleanQuery booleanQuery = new BooleanQuery();
                        for (URI uri : ngraphs) {
                            booleanQuery.add(new BooleanClause(new TermQuery(new Term(INDEXER.INDEXER_FIELD_GRAPH_URI, uri.toString())), Occur.SHOULD));
                        }
                        query.terms.add(booleanQuery);
                    }
                } else {
                    query.graphs.addAll(ngraphs);
                }
            }
        }
        return noSolutions ? null : query;
    }

    public boolean handlesTriplePattern(TriplePattern pattern) throws FunctionalPredicateInvocationException {
        if (pattern.getObject().equals(var)) {
            patterns.add(pattern);
            return true;
        }
        return false;
    }

    public void setFunctionalTriplePattern(TriplePattern pattern) throws FunctionalPredicateInvocationException {
        if (!(pattern.getSubject() instanceof Bindable))
            throw new FunctionalPredicateInvocationException("Subject of textmatch must be a bindable");
        if (!TypeConversions.isSimpleLiteral(pattern.getObject()))
            throw new FunctionalPredicateInvocationException("Object of textmatch must be a simple literal");
        this.var = (Bindable) pattern.getSubject();
        this.textMatch = ((PlainLiteral) pattern.getObject()).getLabel();
        functionalTriplePattern = pattern;
    }

    public boolean usesDataFromGraphs() {
        return true;
    }

    public double getCost(NodeCostModel costModel) {
        return 0;
    }

    public TriplePattern getFunctionalTriplePattern() {
        return functionalTriplePattern;
    }

    public SolutionSet generateSolutions(URI namedGraph, Variable namedGraphVariable, SolutionSet bindingConstraints) throws GlitterException {
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.GLITTER_MARKER, "TextMatchPredicate.generateSolutions called directly, returning noSolutions.");
        }
        return SolutionUtils.noSolutions();
    }

    /**
     *Text match query that is passed to lucene
     */
    public static class TextMatchQuery {
        /** The literal query to run */
        public String                  literalQuery = null;

        /** Extra query terms for query */
        public final Collection<Query> terms        = new HashSet<Query>();

        /** Graphs over which this query is run */
        public final Collection<URI>   graphs       = new HashSet<URI>();

    }
}
