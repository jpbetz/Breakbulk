/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/TypedLiteral.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: TypedLiteral.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.io.ObjectStreamException;
import java.lang.ref.SoftReference;
import java.text.MessageFormat;

import javax.xml.datatype.XMLGregorianCalendar;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.datatype.TypedValueMapper;
import org.openanzo.rdf.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An implementation of {@link TypedLiteral} that maintains the typed literal's lexical form, datatype, and native value (as a native Java object).
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class MemTypedLiteral extends MemLiteral implements TypedLiteral {
    private static final long               serialVersionUID = 6800687957527699783L;

    private static final Logger             log              = LoggerFactory.getLogger(MemTypedLiteral.class);

    private transient Object                value;

    private final URI                       datatype;

    private final String                    lexical;

    /** Use a SoftReference to cache toString value for this literal. SoftReference will be GCed before an out of mem error */
    private transient SoftReference<String> toStringValue;

    /** Constant for TRUE */
    public static final TypedLiteral        TRUE             = MemTypedLiteral.create(true);

    /** Constant for FALSE */
    public static final TypedLiteral        FALSE            = MemTypedLiteral.create(false);

    /**
     * Create a typed literal
     * 
     * @param value
     *            value of literal
     * @param datatype
     *            datatype for literal
     * @return a typed literal
     */
    public static TypedLiteral create(String value, URI datatype) {
        return MemValueFactory.defaultFactory.createLiteral(value, datatype);
    }

    /**
     * Create a typed literal for the given native object
     * 
     * @param nativeObject
     *            native object to convert
     * @return a typed literal for the given native object
     */
    public static TypedLiteral create(Object nativeObject) {
        return MemValueFactory.defaultFactory.createTypedLiteral(nativeObject);
    }

    protected Object readResolve() throws ObjectStreamException {
        return create(lexical, datatype);
    }

    /**
     * Create a typed literal from a lexical form and datatype.
     * 
     * @param value
     *            The lexical form of the literal.
     * @param datatype
     *            The typed literal's datatype.
     */
    protected MemTypedLiteral(String value, URI datatype) {
        this.lexical = replace(value);
        this.datatype = datatype;
    }

    public Object getNativeValue() {
        if (this.value == null) {
            try {
                this.value = TypedValueMapper.getNativeObject(lexical, datatype);
            } catch (IllegalArgumentException e) {
                log.warn(LogUtils.GLITTER_MARKER, "Exception constructing native value for typed literal: {}", e);
                throw e;
            }
        }
        if (this.value instanceof XMLGregorianCalendar) {
            return ((XMLGregorianCalendar) this.value).clone();
        } else if (this.value instanceof byte[]) {
            return ((byte[]) this.value).clone();
        } else {
            return this.value;
        }
    }

    public URI getDatatypeURI() {
        return this.datatype;
    }

    public String getLabel() {
        String s = null;
        // SPARQL prefers that we remember the lexical form we were given originally
        if (this.lexical != null)
            s = this.lexical;
        else if (this.value != null) {
            Pair<String, URI> val = TypedValueMapper.getLexicalValue(this.value);
            if (val != null) {
                s = val.first;
            }
        }
        return s;
    }

    private static final String typeFormat = "\"\"\"{0}\"\"\"^^<{1}>";

    // TODO - handle escaping correctly
    @Override
    public String toString() {
        String string = (toStringValue != null) ? toStringValue.get() : null;
        if (string == null) {
            string = MessageFormat.format(typeFormat, getLabel(), getDatatypeURI().toString());
            toStringValue = new SoftReference<String>(string);
        }
        return string;
    }

    public int compareTo(TriplePatternComponent o) {
        return toString().compareTo(o.toString());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (!(other instanceof TypedLiteral)) {
            return false;
        } else if (other instanceof MemTypedLiteral) {
            return ((this.lexical == null && ((MemTypedLiteral) other).lexical == null) || (this.lexical != null && ((MemTypedLiteral) other).lexical != null && this.lexical.equals(((MemTypedLiteral) other).lexical))) && ((this.datatype == null && ((MemTypedLiteral) other).datatype == null) || (this.datatype != null && ((MemTypedLiteral) other).datatype != null && this.datatype.equals(((MemTypedLiteral) other).datatype)));
        } else {
            return super.equals(other);
        }
    }
}
