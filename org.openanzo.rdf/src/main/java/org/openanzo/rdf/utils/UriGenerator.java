/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/Attic/UriGenerator.java,v $
 * Created by:  Christopher R. Vincent
 * Created on:  3/22/2006
 * Revision:	$Id: UriGenerator.java 200 2007-08-01 16:25:35Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Set;
import java.util.UUID;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Generate URIS for standard uris
 * 
 * @author Christopher R. Vincent
 */
public class UriGenerator {
    /**
     * Generate an anonymous URI
     * 
     * @param prefix
     *            prefix for anonymous uri
     * @return prefixed uri
     */
    public static URI generateAnonymousURI(String prefix) {
        return MemURI.create(generateUriString(prefix));
    }

    private static String generateUriString(String prefix) {
        return prefix + UUID.randomUUID().toString();
    }

    /**
     * Create a new Server ID
     * 
     * @return a new server id
     */
    public static URI generateServerIdURI() {
        return MemURI.create(generateUriString(NAMESPACES.SERVER_PREFIX));
    }

    /**
     * Create a metadataGraph URI
     * 
     * @param namedGraphUri
     *            URI of namedGraph to wrap
     * @return a new metadataGraph URI
     */
    public static URI generateMetadataGraphUri(URI namedGraphUri) {
        try {
            return generateEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, namedGraphUri);
        } catch (AnzoException ae) {
            throw new AnzoRuntimeException(ae);
        }
    }

    static final String OA_PREFIX  = "http://openanzo.org/";

    static final String META_GRAPH = "metadataGraphs";

    /**
     * 
     * @param namedGraphUri
     * @return true if graph is a metadata graph
     */
    public static boolean isMetadataGraphUri(URI namedGraphUri) {
        if (namedGraphUri.getNamespace().equals(OA_PREFIX) && namedGraphUri.getLocalName().startsWith(META_GRAPH)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param graphUri
     * @return
     * @throws AnzoException
     */
    public static URI getNamedGraphUri(URI graphUri) throws AnzoException {
        if (isMetadataGraphUri(graphUri)) {
            return stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, graphUri);
        } else {
            return graphUri;
        }
    }

    /**
     * Create a namedgraph URI
     * 
     * @param name
     *            of named graph
     * @return a new named graph string
     */
    public static String generateNamedGraphUriString(String name) {
        return NAMESPACES.NAMEDGRAPH_PREFIX + name;
    }

    /**
     * Creates a namedGraph URI
     * 
     * @return a new named graph URI
     */
    public static URI generateNamedGraphUri() {
        return MemURI.create(generateUriString(NAMESPACES.NAMEDGRAPH_PREFIX));
    }

    /**
     * Creates a revisioned namedGraph uuid
     * 
     * @return a new named graph URI
     */
    public static URI generateNamedGraphUUIDRevisioned() {
        return MemURI.create(generateUriString(NAMESPACES.NAMEDGRAPH_REVISIONED_UUID_PREFIX));
    }

    /**
     * Creates a revisioned namedGraph uuid
     * 
     * @return a new named graph URI
     */
    public static URI generateNamedGraphUUIDNonRevisioned() {
        return MemURI.create(generateUriString(NAMESPACES.NAMEDGRAPH_NONREVISIONED_UUID_PREFIX));
    }

    /**
     * Create a new Transaction URI string
     * 
     * @return a new Transaction URI string
     */
    private static String generateTransactionUriString() {
        return generateUriString(NAMESPACES.TRANSACTION_PREFIX);
    }

    /**
     * Create a new Transaction URI
     * 
     * @return a new Transaction URI
     */
    public static URI generateTransactionURI() {
        return MemURI.create(generateTransactionUriString());
    }

    /**
     * Expands a set of URIs based on the semantics of the Anzo special "all graphs" URIs. In this context, all graphs are taken to be all *local* graphs.
     * 
     * @param uris
     *            The original set of URIs which may or may not include special URIs.
     * @param quadStore
     *            source of namedgraphs in quadStore
     */
    public static void handleSpecialGraphUris(Set<URI> uris, IQuadStore quadStore) {
        if (uris == null) {
            return;
        }
        // handle the all graphs catchall
        if (uris.contains(GRAPHS.ALL_GRAPHS)) {
            for (URI u : quadStore.getNamedGraphUris()) {
                uris.add(u);
            }
        } else {
            // otherwise, handle the all named graphs special and the
            // all metadata graphs special
            if (uris.contains(GRAPHS.ALL_NAMEDGRAPHS)) {
                for (URI u : quadStore.getNamedGraphUris()) {
                    if (!isMetadataGraphUri(u)) {
                        uris.add(u);
                    }
                }
            }
            if (uris.contains(GRAPHS.ALL_METADATAGRAPHS)) {
                for (URI u : quadStore.getNamedGraphUris()) {
                    if (isMetadataGraphUri(u)) {
                        uris.add(u);
                    }
                }
            }
        }
        // regardless, remove the special URIs from the set
        uris.remove(GRAPHS.ALL_GRAPHS);
        uris.remove(GRAPHS.ALL_NAMEDGRAPHS);
        uris.remove(GRAPHS.ALL_METADATAGRAPHS);
    }

    /**
     * Take an existing URI and encapsulate it within another URI
     * 
     * @param prefix
     *            prefix of result URI
     * @param encapsulatedURI
     *            URI to encapsulate
     * @return URI in form prefix("url encoded encapsulated uri")
     * @throws AnzoException
     */
    public static URI generateEncapsulatedURI(String prefix, URI encapsulatedURI) throws AnzoException {
        return MemURI.create(generateEncapsulatedString(prefix, encapsulatedURI.toString()));
    }

    /**
     * Take an existing URI and encapsulate it within another URI
     * 
     * @param prefix
     *            prefix of result URI
     * @param encapsulatedURI
     *            URI to encapsulate
     * @return URI in form prefix("url encoded encapsulated uri")
     * @throws AnzoException
     */
    public static String generateEncapsulatedString(String prefix, String encapsulatedURI) throws AnzoException {
        try {
            return prefix + '(' + URLEncoder.encode(encapsulatedURI, Constants.byteEncoding) + ')';
        } catch (UnsupportedEncodingException uee) {
            throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR, uee);
        }
    }

    /**
     * String the prefix of an encapsulated URI
     * 
     * @param prefix
     *            prefix to strip
     * @param encapsulatedURI
     *            uri to strip
     * @return stripped URI
     * @throws AnzoException
     */
    public static URI stripEncapsulatedURI(String prefix, URI encapsulatedURI) throws AnzoException {
        return MemURI.create(stripEncapsulatedString(prefix, encapsulatedURI.toString()));
    }

    /**
     * String prefix from encapsulated string
     * 
     * @param prefix
     *            prefix to strip
     * @param encapsulatedURI
     *            string to strip
     * @return stripped string
     * @throws AnzoException
     */
    public static String stripEncapsulatedString(String prefix, String encapsulatedURI) throws AnzoException {
        if (encapsulatedURI.startsWith(prefix)) {
            encapsulatedURI = encapsulatedURI.substring(prefix.length());
            if (encapsulatedURI.startsWith("(") && encapsulatedURI.endsWith(")")) {
                encapsulatedURI = encapsulatedURI.substring(1, encapsulatedURI.length() - 1);
            }
            return decodeEncapsulatedString(encapsulatedURI);
        } else {
            throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR, encapsulatedURI);
        }

    }

    private static String decodeEncapsulatedString(String encapsulatedString) throws AnzoException {
        try {
            if (encapsulatedString.contains("(") && encapsulatedString.contains(")")) {
                String prefix = encapsulatedString.substring(0, encapsulatedString.indexOf('('));
                return URLDecoder.decode(prefix, Constants.byteEncoding).concat(encapsulatedString.substring(encapsulatedString.indexOf('(')));
            } else {
                return URLDecoder.decode(encapsulatedString, Constants.byteEncoding);
            }
        } catch (UnsupportedEncodingException uee) {
            throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR, uee);
        }
    }
}
