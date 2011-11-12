/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/Construct.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Construct.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.exception.InvalidBlankNodeLabelException;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.BlankNodeManager;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link Construct} query form applies the result set's bindings to an RDF template, resulting in an RDF graph.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Construct implements QueryResultForm {
    private static final Logger                     log     = LoggerFactory.getLogger(Construct.class);

    private final ArrayList<TriplePatternNode>      template;

    private final ArrayList<TriplePatternComponent> templateGraph;                                     // parallel with template

    private Collection<Statement>                   results = null;

    /**
     * Constructor.
     * 
     * @param template
     *            The triple patterns that comprise the CONSTRUCT template.
     * @param templateGraph
     *            The graph into which each triple pattern should end up. Can be null (no graph), constant IRI, or a variable.
     */
    public Construct(List<TriplePatternNode> template, List<TriplePatternComponent> templateGraph) {
        this.template = new ArrayList<TriplePatternNode>(template);
        this.templateGraph = new ArrayList<TriplePatternComponent>(templateGraph);
        if (this.template.size() != this.templateGraph.size())
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.UNEXPECTED, "Graph parameters not provided for all triples within CONSTRUCT template");
    }

    /**
     * 
     * @return The CONSTRUCT template triple patterns.
     */
    public List<TriplePatternNode> getTemplate() {
        return this.template;
    }

    /**
     * @return The list of quad portions of the statements in the CONSTRUCT template. In parallel with the return value of Construct.getTemplate().
     */
    public List<TriplePatternComponent> getTemplateGraphComponents() {
        return this.templateGraph;
    }

    public SolutionSet refineSolutionsBeforeOrdering(SolutionSet solutions) {
        return solutions;
    }

    public SolutionSet refineSolutionsAfterOrdering(SolutionSet solutions, List<OrderingCondition> sortedByConditions) {
        return solutions;
    }

    public Object serializeResults(SolutionSet solutionSet) {
        Collection<Statement> results = this.results != null ? this.results : new HashSet<Statement>();
        BlankNodeManager bnm = new BlankNodeManager(false);
        boolean skipTriple;
        for (PatternSolution solution : solutionSet) {

            bnm.enterLabelScope();
            Iterator<TriplePatternComponent> tpcIter = this.templateGraph.iterator();
            for (TriplePatternNode tpn : this.template) {
                TriplePatternComponent tpc = tpcIter.next();
                URI graph = null;
                skipTriple = false;
                TriplePattern tp = tpn.getTriplePattern();
                TriplePatternComponent[] spo = new TriplePatternComponent[] { tp.getSubject(), tp.getPredicate(), tp.getObject() };
                for (int i = 0; i < spo.length; i++) {
                    if (spo[i] instanceof Variable)
                        spo[i] = solution.getBinding((Variable) spo[i]);
                    else if (spo[i] instanceof BlankNode)
                        try {
                            spo[i] = bnm.getBlankNode(spo[i].toString());
                        } catch (InvalidBlankNodeLabelException e) {
                            log.warn(LogUtils.GLITTER_MARKER, "Invalid blanknode label:" + spo[i].toString(), e);
                        }
                    // if a var. was unbound, don't include this solution
                    if (spo[i] == null) {
                        skipTriple = true;
                        break;
                    }
                }
                if (tpc != null) {
                    if (tpc instanceof URI) {
                        graph = (URI) tpc;
                    } else if (tpc instanceof Variable) {
                        Value v = solution.getBinding((Variable) tpc);
                        if (v instanceof URI) {
                            graph = (URI) v;
                        } else {
                            skipTriple = true;
                        }
                    } else {
                        skipTriple = true;
                    }
                }
                if (spo[0] instanceof Literal || !(spo[1] instanceof URI))
                    skipTriple = true;
                if (!skipTriple)
                    results.add(new Statement((Resource) spo[0], (URI) spo[1], (Value) spo[2], graph));
            }
            bnm.exitLabelScope();
        }
        this.results = results;
        return results;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CONSTRUCT { ");

        {
            TriplePatternComponent lastGraph = null;
            for (int i = 0; i < this.template.size(); i++) {
                TriplePatternNode triple = this.template.get(i);
                TriplePatternComponent graph = this.templateGraph.get(i);
                // end a previous graph if the last one is non-null and this one is different
                if (lastGraph != null && !lastGraph.equals(graph)) {
                    builder.append("} ");
                }
                // start a graph if this one is non-null and the last one is different
                if (graph != null && !graph.equals(lastGraph)) {
                    builder.append("GRAPH ");
                    builder.append(graph.toString());
                    builder.append(" { ");
                }
                builder.append(triple.toString());
                if (i + 1 < this.template.size())
                    builder.append(". ");
                lastGraph = graph;
            }
        }
        builder.append(" }");
        return builder.toString();
    }

    public void prettyPrint(StringBuilder buffer) {
        buffer.append("Construct(");

        {
            TriplePatternComponent lastGraph = null;
            for (int i = 0; i < this.template.size(); i++) {
                TriplePatternNode triple = this.template.get(i);
                TriplePatternComponent graph = this.templateGraph.get(i);
                // end a previous graph if the last one is non-null and this one is different
                if (lastGraph != null && !lastGraph.equals(graph)) {
                    buffer.append("), ");
                }
                // start a graph if this one is non-null and the last one is different
                if (graph != null && !graph.equals(lastGraph)) {
                    buffer.append("Graph( ");
                    buffer.append(graph.toString());
                    buffer.append(", ");
                }
                triple.prettyPrint(buffer);
                if (i + 1 < this.template.size())
                    buffer.append(", ");
                lastGraph = graph;
            }
        }
        buffer.append(")");
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        s.append("CONSTRUCT {");
        indentLevel++;
        TriplePatternComponent lastGraph = null;
        for (int i = 0; i < this.template.size(); i++) {
            TriplePatternNode triple = this.template.get(i);
            TriplePatternComponent graph = this.templateGraph.get(i);

            QueryController.printSeparator(printFlags, indentLevel, s);
            // end a previous graph if the last one is non-null and this one is different
            if (lastGraph != null && !lastGraph.equals(graph)) {
                s.append("}");
                indentLevel--;
                QueryController.printSeparator(printFlags, indentLevel, s);
            }
            // start a graph if this one is non-null and the last one is different
            if (graph != null && !graph.equals(lastGraph)) {
                s.append("GRAPH ");
                s.append(graph.toString());
                s.append(" { ");
                indentLevel++;
                QueryController.printSeparator(printFlags, indentLevel, s);
            }
            triple.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
            if (i + 1 < this.template.size())
                s.append(". ");
            lastGraph = graph;
        }
        indentLevel--;
        QueryController.printSeparator(printFlags, indentLevel, s);
        s.append("}");
    }

    public Collection<Variable> getBindableVariables() {
        return Collections.emptyList();
    }

    public Collection<URI> getReferencedURIs() {
        HashSet<URI> uris = new HashSet<URI>();
        for (TriplePatternNode tpn : this.template)
            uris.addAll(tpn.getReferencedURIs());
        for (TriplePatternComponent tpc : this.templateGraph)
            if (tpc instanceof URI)
                uris.add((URI) tpc);
        return uris;
    }

    public Collection<Variable> getReferencedVariables() {
        HashSet<Variable> vars = new HashSet<Variable>();
        for (TriplePatternNode tpn : this.template)
            vars.addAll(tpn.getReferencedVariables());
        for (TriplePatternComponent tpc : this.templateGraph)
            if (tpc instanceof Variable)
                vars.add((Variable) tpc);
        return vars;
    }

}
