/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.rdf;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;

/**
 * Enumeration of RDF formats.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public enum RDFFormat {
    /** RDF XML */
    RDFXML(false, "application/rdf+xml", false, "rdf", "owl", "rdfs", "xml"),
    /** NTriples */
    NTRIPLES(false, "text/plain", false, "nt"),
    /** N3 */
    N3(false, "text/rdf+n3", false, "n3"),
    /** Turtle */
    TURTLE(false, "application/x-turtle", false, "ttl"),
    /** TRIX */
    TRIX(true, "application/trix", true, "trix", "xml"),
    /** TRIG */
    TRIG(true, "application/x-trig", true, "trig"),
    /** JSON */
    JSON(true, "application/json", true, "json"),
    /** SPARQL Text Results */
    TBL(false, "application/anzo-sparql-results+tbl", false, "tbl"),
    /** SPARQL XML Results */
    SPARQL(false, "application/sparql-results+xml", false, "srx"),
    /** SPARQL Boolean results */
    BOOLEANRESULT(false, "text/boolean", false, "txt"), ;

    private final boolean  supportsNamedGraph;

    private final boolean  supportsNamespaces;

    private final String   mimeType;

    private final String[] fileExtensions;

    RDFFormat(boolean supportsNamedGraphs, String mimeType, boolean supportsNamespace, String... fileExtensions) {
        this.supportsNamedGraph = supportsNamedGraphs;
        this.supportsNamespaces = supportsNamespace;
        this.mimeType = mimeType;
        this.fileExtensions = fileExtensions;
    }

    /**
     * @return the supportsNamespaces
     */
    public boolean supportsNamespaces() {
        return supportsNamespaces;
    }

    /**
     * @return the fileExtensions
     */
    public String[] getFileExtensions() {
        return fileExtensions;
    }

    /**
     * Return true if this format supports namedgraph uris as part of statements
     * 
     * @return true if this format supports namedgraph uris as part of statements
     */
    public boolean supportsNamedGraphs() {
        return supportsNamedGraph;
    }

    /**
     * Get the default MIME type string for this format
     * 
     * @return the default MIME type string for this format
     */
    public String getDefaultMIMEType() {
        return mimeType;
    }

    /**
     * Get the RDFFormat for the provided mimetype
     * 
     * @param type
     *            mimetype to find
     * @return RDFFORmat for the mimetype
     */
    public static RDFFormat forMIMEType(String type) {
        if (type == null)
            return null;
        else if (type.equals(RDFXML.getDefaultMIMEType()))
            return RDFXML;
        else if (type.equals(NTRIPLES.getDefaultMIMEType()))
            return NTRIPLES;
        else if (type.equals(N3.getDefaultMIMEType()))
            return N3;
        else if (type.equals(TURTLE.getDefaultMIMEType()))
            return TURTLE;
        else if (type.equals(TRIX.getDefaultMIMEType()))
            return TRIX;
        else if (type.equals(TRIG.getDefaultMIMEType()))
            return TRIG;
        else if (type.equals(JSON.getDefaultMIMEType()))
            return JSON;
        else if (type.equals(SPARQL.getDefaultMIMEType()))
            return SPARQL;
        else if (type.equals(TBL.getDefaultMIMEType()))
            return TBL;
        else
            throw new AnzoRuntimeException(ExceptionConstants.IO.UNKNOWN_MIME_RDF_FORMAT_ERROR, type);
    }

    /**
     * RDFFormat for the given filename
     * 
     * @param fileName
     *            filename for which to get RDFFormat
     * @return RDFFormat for the given filename
     */
    public static RDFFormat forFileName(String fileName) {
        if (fileName == null)
            return null;
        else if (matchesExtension(RDFXML, fileName))
            return RDFXML;
        else if (matchesExtension(NTRIPLES, fileName))
            return NTRIPLES;
        else if (matchesExtension(N3, fileName))
            return N3;
        else if (matchesExtension(TURTLE, fileName))
            return TURTLE;
        else if (matchesExtension(TRIX, fileName))
            return TRIX;
        else if (matchesExtension(TRIG, fileName))
            return TRIG;
        else if (matchesExtension(JSON, fileName))
            return JSON;
        else if (matchesExtension(SPARQL, fileName))
            return SPARQL;
        else if (matchesExtension(TBL, fileName))
            return TBL;
        else
            throw new AnzoRuntimeException(ExceptionConstants.IO.UNKNOWN_EXTENSION_RDF_FORMAT_ERROR, fileName);
    }

    /**
     * Does the RDFFormat suppport the given filename
     * 
     * @param format
     *            RDFFOrmat to check
     * @param filename
     *            filename to check
     * @return true if the RDFFormat suppport the given filename
     */
    public static boolean matchesExtension(RDFFormat format, String filename) {
        String extensions[] = format.fileExtensions;
        if (extensions != null) {
            for (String extension : extensions) {
                if (filename.toLowerCase().endsWith(extension.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }
}
