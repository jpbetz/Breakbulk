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
package org.openanzo.rdf.adapter;

import java.io.Writer;
import java.util.Map;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.IRDFWriter;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.impl.ContextStatementImpl;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFWriter;
import org.openrdf.rio.Rio;

/**
 * RIO to anzo writer
 */
public class RioToAnzoWriterAdapter implements IRDFWriter {
    private final RDFWriter          writer;

    private final BasicNodeConverter converter;

    /**
     * Convert from anzo data to rio writer
     * 
     * @param writer
     *            writer data
     * @param format
     *            format of writer
     */
    public RioToAnzoWriterAdapter(Writer writer, RDFFormat format) {
        this.writer = Rio.createWriter(BasicNodeConverter.convert(format), writer);
        converter = new BasicNodeConverter();
    }

    /* (non-Javadoc)
     * @see org.openanzo.rdf.RDFWriter#endRDF()
     */
    public void endRDF() throws AnzoException {
        try {
            writer.endRDF();
        } catch (RDFHandlerException e) {
            throw new AnzoException(ExceptionConstants.IO.RDF_HANDLER_ERROR, e);
        }
    }

    /* (non-Javadoc)
     * @see org.openanzo.rdf.RDFWriter#handleComment(java.lang.String)
     */
    public void handleComment(String comment) throws AnzoException {
        try {
            writer.handleComment(comment);
        } catch (RDFHandlerException e) {
            throw new AnzoException(ExceptionConstants.IO.RDF_HANDLER_ERROR, e);
        }
    }

    /* (non-Javadoc)
     * @see org.openanzo.rdf.RDFWriter#handleNamespace(java.lang.String, java.lang.String)
     */
    public void handleNamespace(String prefix, String uri) throws AnzoException {
        try {
            writer.handleNamespace(prefix, uri);
        } catch (RDFHandlerException e) {
            throw new AnzoException(ExceptionConstants.IO.RDF_HANDLER_ERROR, e);
        }
    }

    /**
     * Handle namespaces
     * 
     * @param prefixes
     *            prefixes to handle
     * @throws AnzoException
     */
    public void handleNamespaces(Map<String, String> prefixes) throws AnzoException {
        for (Map.Entry<String, String> prefix : prefixes.entrySet()) {
            handleNamespace(prefix.getKey(), prefix.getValue());
        }
    }

    /* (non-Javadoc)
     * @see org.openanzo.rdf.RDFWriter#handleStatement(org.openanzo.rdf.Statement)
     */
    public void handleStatement(Statement statement) throws AnzoException {
        org.openrdf.model.Statement stmt = new ContextStatementImpl((Resource) converter.convert(statement.getSubject(), false), (URI) converter.convert(statement.getPredicate(), false), converter.convert(statement.getObject(), false), (Resource) converter.convert(statement.getNamedGraphUri(), false));
        try {
            writer.handleStatement(stmt);
        } catch (RDFHandlerException e) {
            throw new AnzoException(ExceptionConstants.IO.DESERIALIZATION_ERROR, e);
        }
    }

    /* (non-Javadoc)
     * @see org.openanzo.rdf.RDFWriter#startRDF()
     */
    public void startRDF() throws AnzoException {
        try {
            writer.startRDF();
        } catch (RDFHandlerException e) {
            throw new AnzoException(ExceptionConstants.IO.RDF_HANDLER_ERROR, e);
        }
    }

    /* (non-Javadoc)
     * @see org.openanzo.rdf.RDFWriter#getRDFFormat()
     */
    public RDFFormat getRDFFormat() {
        return BasicNodeConverter.convert(writer.getRDFFormat());
    }
}
