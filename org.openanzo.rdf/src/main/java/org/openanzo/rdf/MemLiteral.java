/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/Literal.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: Literal.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * RDF Literal Node base. Provides common methods.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
abstract class MemLiteral implements Literal {
    private static final long                         serialVersionUID = 941229149446590776L;

    private int                                       hashCode         = -1;

    private static Map<String, WeakReference<String>> map              = new WeakHashMap<String, WeakReference<String>>();

    protected synchronized static String replace(String object) {
        if (object == null) {
            return null;
        }
        WeakReference<String> reference = map.get(object);
        if (reference != null) {
            String result = reference.get();
            // Another null check, since the GC may have kicked in between the 
            // two lines above.
            if (result != null) {
                return result;
            }
        }
        // If we got here it is because the map doesn't have the key, add it.
        map.put(object, new WeakReference<String>(object));
        return object;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        // via the definition in:
        //  http://www.w3.org/TR/rdf-concepts/#section-Literal-Equality
        // we need only compare the lexicalizations of the two literals
        // since the lexicalizations include the language tag and datatype
        // parts
        return other != null && this.toString().equals(other.toString());
    }

    @Override
    public int hashCode() {
        if (hashCode == -1) {
            hashCode = this.toString().hashCode();
        }
        return hashCode;
    }
}
