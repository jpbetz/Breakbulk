/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/PlainLiteral.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: PlainLiteral.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.io.ObjectStreamException;
import java.lang.ref.SoftReference;
import java.text.MessageFormat;

/**
 * An implementation of {@link PlainLiteral} to represent plain literals in a query parsed by Glitter.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class MemPlainLiteral extends MemLiteral implements PlainLiteral {
    private static final long               serialVersionUID = 8698909625642501980L;

    private final String                    value;

    private final String                    language;

    private final String                    language_original;

    /** Use a softReference to cache toString value for this literal. Soft reference will be GCed before an out of mem error */
    private transient SoftReference<String> lexicalForm;

    /**
     * Create a plain literal for value
     * 
     * @param value
     *            value of literal
     * @return plain literal for value
     */
    public static PlainLiteral create(String value) {
        return MemValueFactory.defaultFactory.createLiteral(value);
    }

    /**
     * Create a plain literal for value and language
     * 
     * @param value
     *            value of literal
     * @param language
     *            language for literal
     * @return a plain literal for value and language
     */
    public static PlainLiteral create(String value, String language) {
        return MemValueFactory.defaultFactory.createLiteral(value, language);
    }

    protected Object readResolve() throws ObjectStreamException {
        return create(value, language);
    }

    /**
     * Build a plain literal from its lexical value and language.
     * 
     * @param value
     * @param language
     */
    protected MemPlainLiteral(String value, String language) {
        this.value = value != null ? replace(value) : null;
        this.language_original = (language != null) ? replace(language) : null;
        this.language = language == null ? null : replace(language.toLowerCase());
    }

    /**
     * Build a plain literal from its lexical value.
     * 
     * @param value
     */
    protected MemPlainLiteral(String value) {
        this(value, null);
    }

    public String getLanguage() {
        return this.language_original;
    }

    public boolean hasLanguage() {
        return this.language != null && this.language.length() > 0;
    }

    public String getLabel() {
        return this.value;
    }

    private static final String basicFormat = "\"{0}\"";

    private static final String langFormat  = "\"{0}\"@{1}";

    @Override
    public String toString() {
        String string = (lexicalForm != null) ? lexicalForm.get() : null;
        if (string == null) {
            string = hasLanguage() ? MessageFormat.format(langFormat, this.value, this.language) : MessageFormat.format(basicFormat, this.value);
            lexicalForm = new SoftReference<String>(string);
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
        } else if (!(other instanceof PlainLiteral)) {
            return false;
        } else if (other instanceof MemPlainLiteral) {
            return ((this.value == null && ((MemPlainLiteral) other).value == null) || (this.value != null && ((MemPlainLiteral) other).value != null && this.value.equals(((MemPlainLiteral) other).value))) && ((this.language == null && ((MemPlainLiteral) other).language == null) || (this.language != null && ((MemPlainLiteral) other).language != null && this.language.equals(((MemPlainLiteral) other).language)));
        } else {
            return super.equals(other);
        }
    }
}
