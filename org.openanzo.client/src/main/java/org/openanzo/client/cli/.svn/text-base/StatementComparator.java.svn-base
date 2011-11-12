/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client.cli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.vocabulary.RDF;

/**
 * Sorts statements by named graph, then subject, pred, obj. This sorting results in well framed serialized rdf.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class StatementComparator implements Comparator<Statement> {

    private static StatementComparator statementComparator = new StatementComparator();

    private static PredicateComparator predicateComparator = new PredicateComparator();

    public static Collection<Statement> sort(Collection<Statement> stmt) {
        ArrayList<Statement> list = new ArrayList<Statement>(stmt);
        Collections.sort(list, statementComparator);
        return list;
    }

    public int compare(Statement o1, Statement o2) {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(o1.getNamedGraphUri() != null ? o1.getNamedGraphUri().toString() : null, o2.getNamedGraphUri() != null ? o2.getNamedGraphUri().toString() : null);
        builder.append(o1.getSubject().toString(), o2.getSubject().toString());
        builder.append(o1.getPredicate(), o2.getPredicate(), predicateComparator);
        builder.append(o1.getObject().toString(), o2.getObject().toString());
        return builder.toComparison();
    }

    /**
     * This sort URIs in lexical order except for the rdf:type uri, which it always sorts before any other URI. This makes the serialization of RDF simpler to
     * read since it's typically easier to read when the type assertions for a resource come first, before other properties.
     * 
     * The rdf:type URI is specifically <code>http://www.w3.org/1999/02/22-rdf-syntax-ns#type</code>.
     * 
     * @author Jordi Albornoz Mulligan <jordi@cambridgesemantics.com>
     */
    public static class PredicateComparator implements Comparator<URI> {
        public int compare(URI o1, URI o2) {
            int ret;
            if (o1.equals(o2)) {
                ret = 0;
            } else if (o1.equals(RDF.TYPE)) {
                ret = -1;
            } else if (o2.equals(RDF.TYPE)) {
                ret = 1;
            } else {
                ret = o1.compareTo(o2);
            }
            return ret;
        }
    }
}
