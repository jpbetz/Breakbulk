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

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.IRDFHandler;
import org.openanzo.rdf.MemValueFactory;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openrdf.rio.RDFHandlerException;

/**
 * Anzo to rio handler
 * 
 */
public class AnzoToRioHandlerAdapter implements org.openrdf.rio.RDFHandler {
    private final IRDFHandler        handler;

    private final BasicNodeConverter converter;

    /**
     * create anzo to rio handler
     * 
     * @param handler
     */
    public AnzoToRioHandlerAdapter(IRDFHandler handler) {
        this.handler = handler;
        converter = new BasicNodeConverter();
    }

    public void endRDF() throws RDFHandlerException {
        try {
            handler.endRDF();
        } catch (AnzoException e) {
            throw new RDFHandlerException(e);
        }
    }

    public void handleComment(String comment) throws RDFHandlerException {
        try {
            handler.handleComment(comment);
        } catch (AnzoException e) {
            throw new RDFHandlerException(e);
        }
    }

    public void handleNamespace(String prefix, String uri) throws RDFHandlerException {
        try {
            handler.handleNamespace(prefix, uri);
        } catch (AnzoException e) {
            throw new RDFHandlerException(e);
        }
    }

    public void handleStatement(org.openrdf.model.Statement st) throws RDFHandlerException {
        if (st.getSubject() == null || st.getPredicate() == null || st.getObject() == null)
            throw new IllegalStateException("rdf model statement may not contain nulls");
        Value subject = converter.convert(st.getSubject());
        Value predicate = converter.convert(st.getPredicate());
        Value object = converter.convert(st.getObject());
        Value context = converter.convert(st.getContext());

        Statement statement;
        if (context == null) {
            statement = MemValueFactory.defaultFactory.createStatement((Resource) subject, (URI) predicate, object);
        } else {
            statement = MemValueFactory.defaultFactory.createStatement((Resource) subject, (URI) predicate, object, (URI) context);
        }

        try {
            handler.handleStatement(statement);
        } catch (AnzoException e) {
            throw new RDFHandlerException(e);
        }
    }

    public void startRDF() throws RDFHandlerException {
        try {
            handler.startRDF();
        } catch (AnzoException e) {
            throw new RDFHandlerException(e);
        }
    }
}
