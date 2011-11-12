/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/Variable.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: Variable.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.io.ObjectStreamException;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.WeakHashMap;

import org.apache.commons.lang.StringUtils;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;

/**
 * A variable in a SPARQL query. The {@link MemVariable} class maintains a cache to reuse {@link MemVariable} objects sharing the same name.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class MemVariable implements Variable {

    private static final long                                    serialVersionUID = -7113608448508192908L;

    private final String                                         name;

    private int                                                  hashCode         = -1;

    private String                                               varName;

    /** WeakHashMap cache of uris */
    static private final Map<String, SoftReference<MemVariable>> cache            = new WeakHashMap<String, SoftReference<MemVariable>>();

    /**
     * Static factory method that uses an WeakHashMap cache to reuse {@link MemVariable} objects for variables with the same name.
     * 
     * @param variableName
     *            name of variable
     * @return {@link MemVariable} for given name
     */
    static public MemVariable createVariable(String variableName) {
        if (variableName.startsWith("?")) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.VARIABLE_START_QUESTION, variableName);
        }
        if (!StringUtils.containsNone(variableName, " \t\n\r\f")) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.VARIABLE_NO_SPACES, variableName);
        }
        SoftReference<MemVariable> ref = cache.get(variableName);
        MemVariable var = (ref != null) ? ref.get() : null;
        if (var == null) {
            var = new MemVariable(variableName);
            cache.put(variableName, new SoftReference<MemVariable>(var));
        }
        return var;
    }

    private MemVariable(String variableName) {
        this.name = variableName;
        this.varName = "?" + this.name;
    }

    protected Object readResolve() throws ObjectStreamException {
        return createVariable(name);
    }

    @Override
    public String toString() {
        return this.varName;
    }

    /* (non-Javadoc)
     * @see org.openanzo.rdf.Variable#getName()
     */
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        //Since we have a weak-hash-map of variables, you will always get the same object for the same variable
        return (this == other);
        // we've gone back and forth over whether identity for
        // variables is universal identity (object identity) or 
        // whether the name of a variableis universally scoped
        // such that ?x always is equal to ?x. Currently, that's
        // the definition we go with.
    }

    @Override
    public int hashCode() {
        if (hashCode == -1) {
            hashCode = this.name.hashCode();
        }
        return hashCode;
    }

    public boolean equalName(Variable other) {
        return other != null && this.getName().equals(other.getName());
    }

    public int compareTo(TriplePatternComponent o) {
        if (o == this)
            return 0;
        return toString().compareTo(o.toString());
    }
}
