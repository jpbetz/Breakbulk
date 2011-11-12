/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/IRIReference.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: IRIReference.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.io.ObjectStreamException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

import org.apache.commons.lang.StringUtils;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openrdf.model.util.URIUtil;

/**
 * Represents an IRI reference for SPARQL queries. Equality is determined by the equality of the string representation of the IRIs.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class MemURI implements URI {
    private static final long                         serialVersionUID = -6160182879901923931L;

    private final String                              namespace;

    private final String                              localpart;

    private int                                       hashCode         = -1;

    private static final String                       SPACE            = " ";

    private static Map<String, WeakReference<String>> map              = new WeakHashMap<String, WeakReference<String>>();

    private synchronized static String replace(String object) {
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

    /**
     * Create a uri
     * 
     * @param uri
     *            uri to create
     * @return new uri
     */
    public static URI create(String uri) {
        return MemValueFactory.defaultFactory.createURI(uri);
    }

    /**
     * Create uri from java.net.URI
     * 
     * @param uri
     *            uri to create
     * @return new URI
     */
    public static URI create(java.net.URI uri) {
        return MemValueFactory.defaultFactory.createURI(uri.toString());
    }

    protected static URI create(String namespace, String localName) {
        return MemValueFactory.defaultFactory.createURI(namespace, localName);
    }

    protected Object readResolve() throws ObjectStreamException {
        return create(namespace + localpart);
    }

    /**
     * Construct an {@link MemURI} from a string.
     * 
     * @param uri
     */
    protected MemURI(String uri) {
        if (!StringUtils.contains(uri, ':')) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_COLON_IN_URI, uri);
        }
        if (uri.contains(SPACE)) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.SPACE_IN_URI, uri);
        }
        try {
            java.net.URI.create(uri);
        } catch (IllegalArgumentException iae) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.INVALID_URI, iae, uri);
        }
        int index = URIUtil.getLocalNameIndex(uri);
        this.localpart = replace(uri.substring(index));
        this.namespace = replace(uri.substring(0, index));
    }

    @Override
    public String toString() {
        return this.namespace + this.localpart;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (this == other)
            return true;
        // http://www.w3.org/TR/rdf-concepts/#section-Graph-URIref
        // specifies that two RDF IRI references compare equal only
        // if they are equivalent on a character-by-character basis.
        //
        // This differs from the URI.equals() method (which ignores
        // case in the scheme, for instance), and so we compare
        // strings instead
        if (!(other instanceof URI)) {
            return false;
        }
        if (other instanceof MemURI) {
            return this.localpart.equals(((MemURI) other).localpart) && this.namespace.equals(((MemURI) other).namespace);
        }
        return this.toString().equals(other.toString());
    }

    @Override
    public int hashCode() {
        if (hashCode == -1) {
            hashCode = toString().hashCode();
        }
        return hashCode;
    }

    public int compareTo(TriplePatternComponent o) {
        if (o instanceof URI) {
            return compareTo((URI) o);
        }
        return toString().compareTo(o.toString());
    }

    public String getLocalName() {
        return localpart;
    }

    public String getNamespace() {
        return namespace;
    }

    /**
     * Compare 2 URIs
     * 
     * @param o
     *            other URI to compare
     * @return comparison of the 2 uris
     */
    public int compareTo(URI o) {
        if (this == o)
            return 0;
        int compare = 0;
        if (this.namespace == o.getNamespace()) {
            compare = 0;
        } else {
            compare = this.namespace.compareTo(o.getNamespace());
        }
        if (compare == 0) {
            return this.localpart.compareTo(o.getLocalName());
        } else {
            return compare;
        }
    }
}
