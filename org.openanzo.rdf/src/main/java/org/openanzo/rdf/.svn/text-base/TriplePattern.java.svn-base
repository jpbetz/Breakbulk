/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/TriplePattern.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: TriplePattern.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.io.Serializable;

import org.openanzo.rdf.utils.SerializationUtils;

/**
 * A {@link TriplePattern} is a subject, predicate, and object in which each slot can be either an {@link Value} or a {@link Variable}.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class TriplePattern implements Serializable {
    private static final long serialVersionUID = 8933026441688525697L;

    protected final TriplePatternComponent subject, predicate, object;

    /**
     * Constructor.
     * 
     * @param subject
     *            Subject
     * @param predicate
     *            Predicate
     * @param object
     *            Object
     */
    public TriplePattern(TriplePatternComponent subject, TriplePatternComponent predicate, TriplePatternComponent object) {
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
    }

    @Override
    public String toString() {
        return toPatternString(this.subject) + " " + toPatternString(this.predicate) + " " + toPatternString(this.object);
    }

    protected final String toPatternString(TriplePatternComponent component) {
        return (component instanceof URI) ? ("<" + component + ">") : ((component == null) ? "null" : component.toString());
    }

    /**
     * @return The subject.
     */
    public TriplePatternComponent getSubject() {
        return this.subject;
    }

    /**
     * @return The predicate.
     */
    public TriplePatternComponent getPredicate() {
        return this.predicate;
    }

    /**
     * @return The object.
     */
    public TriplePatternComponent getObject() {
        return this.object;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TriplePattern))
            return false;
        TriplePattern otherTP = (TriplePattern) other;
        return this.subject.equals(otherTP.getSubject()) && this.predicate.equals(otherTP.getPredicate()) && this.object.equals(otherTP.getObject());
    }

    @Override
    public int hashCode() {
        return SerializationUtils.augmentHashValue(SerializationUtils.augmentHashValue(SerializationUtils.augmentHashValue(13, this.subject), this.predicate), this.object);
    }

}
