/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/Triple.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: Triple.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.PatternSolutionImpl;

/**
 * A {@link Statement} is either a {@link TriplePattern} or a quad without any variables.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Statement extends TriplePattern implements Comparable<Statement> {
    private static final long serialVersionUID = -8405680742581917240L;

    private final Value       namedGraphUri;

    private int               hashCode         = -1;

    /**
     * Construct a triple from three {@link Value}s.
     * 
     * @param subject
     * @param predicate
     * @param object
     */
    public Statement(Resource subject, URI predicate, Value object) {
        super(subject, predicate, object);
        this.namedGraphUri = null;
    }

    /**
     * Create a statement quad
     * 
     * @param subject
     * @param predicate
     * @param object
     * @param namedGraphUri
     */
    public Statement(Resource subject, URI predicate, Value object, URI namedGraphUri) {
        super(subject, predicate, object);
        this.namedGraphUri = namedGraphUri;
    }

    @Override
    public Resource getSubject() {
        return (Resource) subject;
    }

    @Override
    public URI getPredicate() {
        return (URI) predicate;
    }

    @Override
    public Value getObject() {
        return (Value) object;
    }

    /**
     * Get namedgraphURI of statement
     * 
     * @return namedGraphUri
     */
    public URI getNamedGraphUri() {
        return (URI) namedGraphUri;
    }

    /**
     * Determines whether this triple entails the given {@link TriplePattern}, and if so, what bindings are necessary to make that so. (This is effectively
     * subgraph matching.) entails it
     * 
     * @param other
     *            The {@link TriplePattern} that may contain {@link Bindable}s to be bound in defining the entailment relationship.
     * @return A {@link PatternSolution} that, when applied to <tt>other</tt> results in this {@link Statement}. If this triple does not entail <tt>other</tt>,
     *         then <tt>null</tt> is returned.
     */
    public PatternSolution entails(TriplePattern other) {
        PatternSolutionImpl sol = new PatternSolutionImpl();

        TriplePatternComponent otherS = other.getSubject(), otherP = other.getPredicate(), otherO = other.getObject();

        TriplePatternComponent[][] pairs = new TriplePatternComponent[][] { new TriplePatternComponent[] { this.subject, otherS }, new TriplePatternComponent[] { this.predicate, otherP }, new TriplePatternComponent[] { this.object, otherO } };

        for (int i = 0; i < pairs.length; i++) {
            Value us = (Value) pairs[i][0];
            TriplePatternComponent them = pairs[i][1];
            // if we're a bindable object, then we need to bind us as long
            // as we're not already bound to something else
            if (them instanceof Bindable) {
                Value existing = sol.getBinding((Bindable) them);
                if (existing != null && !existing.equals(us))
                    return null;
                sol.setBinding((Bindable) them, us);
            } else if (!(them.equals(us))) {
                // a non-bindable object only entails itself
                return null;
            }
        }
        return sol;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Statement))
            return false;
        if (hashCode() == other.hashCode()) {
            Statement otherStmt = (Statement) other;
            if (this.namedGraphUri != null && otherStmt.namedGraphUri != null) {
                if (!this.namedGraphUri.equals(otherStmt.namedGraphUri))
                    return false;
            }
            return super.equals(other);
        } else {
            return false;
        }
    }

    public int compareTo(Statement o) {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(getNamedGraphUri() != null ? getNamedGraphUri() : null, o.getNamedGraphUri() != null ? o.getNamedGraphUri() : null);
        builder.append(getSubject(), o.getSubject());
        builder.append(getPredicate(), o.getPredicate());
        builder.append(getObject(), o.getObject());
        return builder.toComparison();

    }

    @Override
    public int hashCode() {
        if (hashCode == -1) {
            if (namedGraphUri == null)
                hashCode = super.hashCode();
            else {
                HashCodeBuilder builder = new HashCodeBuilder();
                builder.append(this.subject);
                builder.append(this.predicate);
                builder.append(this.object);
                builder.append(this.namedGraphUri);
                hashCode = builder.toHashCode();
            }
        }
        return hashCode;
    }

    @Override
    public String toString() {
        String str = toPatternString(this.subject) + " " + toPatternString(this.predicate) + " " + toPatternString(this.object) + " " + toPatternString(this.namedGraphUri);
        return str;
    }
}
