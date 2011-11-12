/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/jastor/Attic/DatasetThingImpl.java,v $
 * Created by:  Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 * Created on:  5/15/2006
 * Revision:	$Id: DatasetThingImpl.java 168 2007-07-31 14:11:14Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemPlainLiteral;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.datatype.TypedValueMapper;
import org.openanzo.rdf.utils.Pair;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.vocabulary.RDF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of Thing
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class ThingImpl implements Thing {
    private static final Logger log = LoggerFactory.getLogger(ThingImpl.class);

    // must prefix these members so that they don't collide with
    // member variables in generated classes

    protected final Resource    _resource;

    protected final INamedGraph _graph;

    protected final IDataset    _dataset;

    /**
     * Create a new ThingImpl for given resource
     * 
     * @param resource
     *            Resource of Thing
     * @param namedGraphUri
     *            URI of NamedGraph where this Thing resides
     * @param dataset
     *            Dataset where data for this Thing resides
     * @throws JastorException
     *             if dataset is null
     */
    public ThingImpl(Resource resource, URI namedGraphUri, IDataset dataset) throws JastorException {
        if (resource == null)
            throw new JastorException("The resource parameter must not be null.");

        if (dataset == null) {
            throw new JastorException("The dataset parameter must not be null.");
        }
        INamedGraph graph = dataset.getNamedGraph(namedGraphUri);
        if (graph == null) {
            graph = dataset.addNamedGraph(namedGraphUri);
            //throw new JastorException("Named graph " + namedGraphUri + " does not exist in dataset");
        }
        this._graph = graph;
        this._dataset = dataset;
        this._resource = resource;

    }

    public String uri() {
        return _resource.toString();
    }

    public IDataset dataset() {
        return _dataset;
    }

    public INamedGraph graph() {
        return _graph;
    }

    public Resource resource() {
        return _resource;
    }

    public Collection<Statement> listStatements() {
        return Collections.<Statement> emptySet();
    }

    public void removeStatements() {
        _dataset.remove(listStatements().toArray(new Statement[0]));
    }

    public void registerListener(ThingListener listener) {
        // Nothing to do since there are no properties on a thing object
    }

    public void unregisterListener(ThingListener listener) {
        // Nothing to do since there are no properties on a thing object
    }

    public boolean isRDFType(Resource type) {
        return _graph.contains(_resource, RDF.TYPE, type);
    }

    @Override
    public String toString() {
        StringWriter output = new StringWriter();
        try {
            ReadWriteUtils.writeStatements(listStatements(), output, RDFFormat.TRIG, null, true);
        } catch (Exception e) {
            log.error(LogUtils.GLITTER_MARKER, "Error writing thing statements", e);
        }
        return output.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof Thing) {
            Thing other = (Thing) obj;
            if (other.resource().equals(this.resource())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return resource().hashCode();
    }

    /**
     * Get the native value of a literal
     * 
     * @param literal
     *            literal value to convert
     * @param expectedDatatype
     *            expected datatype URI
     * @param <T>
     *            Type of class for which to convert
     * @return native value of literal
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("unchecked")
    // marshal from rdf
    public final <T> T getLiteralValue(Literal literal, String expectedDatatype) throws IllegalArgumentException {
        T ret;
        if (literal instanceof TypedLiteral && ((TypedLiteral) literal).getDatatypeURI().equals(MemURI.create(expectedDatatype))) {
            ret = (T) ((TypedLiteral) literal).getNativeValue();
        } else {
            // For plain literals or typed literals where the type isn't exactly what we want, we'll attempt to convert
            // the literal's label into a native object based on the type we actually want.
            ret = (T) TypedValueMapper.getNativeObject(literal.getLabel(), MemURI.create(expectedDatatype));
        }
        return ret;
    }

    /**
     * Get the Literal value for the raw data
     * 
     * @param value
     *            the native value to convert
     * @param rangeUri
     *            the range type
     * @return native value of literal
     */
    public final Literal getLiteral(Object value, String rangeUri) {
        if (value instanceof Literal) {
            return (Literal) value;
        }
        URI desiredDatatype = rangeUri == null ? null : MemURI.create(rangeUri);
        Pair<String, URI> lexicalValue = TypedValueMapper.getLexicalValue(value, desiredDatatype);
        if (lexicalValue == null) {
            if (desiredDatatype == null) {
                return MemPlainLiteral.create(value.toString());
            } else {
                return MemTypedLiteral.create(value.toString(), desiredDatatype);
            }
        } else {
            return MemTypedLiteral.create(lexicalValue.first, lexicalValue.second);
        }
    }

    public Value getPropertyValue(URI property, URI... namedGraphUris) {
        Collection<Statement> stmts = (namedGraphUris != null && namedGraphUris.length == 0) ? _dataset.find(_resource, property, null, _graph.getNamedGraphUri()) : _dataset.find(_resource, property, null, namedGraphUris);
        return (!stmts.isEmpty()) ? stmts.iterator().next().getObject() : null;

    }

    public Collection<Value> getPropertyValues(URI property, URI... namedGraphUris) {
        Collection<Statement> stmts = (namedGraphUris != null && namedGraphUris.length == 0) ? _dataset.find(_resource, property, null, _graph.getNamedGraphUri()) : _dataset.find(_resource, property, null, namedGraphUris);
        Collection<Value> results = new ArrayList<Value>();
        for (Statement stmt : stmts) {
            results.add(stmt.getObject());
        }
        return results;
    }

    public void setPropertyValue(URI property, Value value, URI... namedGraphUris) {

        if (namedGraphUris == null || namedGraphUris.length == 0) {
            _graph.remove(_resource, property, null);
            if (value != null) {
                _graph.add(_resource, property, value);
            }
        } else {
            _dataset.remove(_dataset.find(_resource, property, null, namedGraphUris));
            for (URI namedGraphUri : namedGraphUris) {
                if (!_dataset.containsNamedGraph(namedGraphUri)) {
                    throw new JastorException("Named graph " + namedGraphUri + " does not exist in dataset");
                }
                if (value != null) {
                    _dataset.add(_resource, property, value, namedGraphUri);
                }
            }
        }
    }

    public void clearPropertyValues(URI property, URI... namedGraphUri) {
        Collection<Statement> stmtsAll = _dataset.find(_resource, null, null, namedGraphUri);
        stmtsAll.removeAll(listStatements());
        _dataset.remove(stmtsAll);
    }

    public void addPropertyValue(URI property, Value value, URI... namedGraphUris) {
        if (namedGraphUris == null || namedGraphUris.length == 0) {
            if (value != null) {
                _graph.add(_resource, property, value);
            }
        } else {
            for (URI namedGraphUri : namedGraphUris) {
                if (!_dataset.containsNamedGraph(namedGraphUri)) {
                    throw new JastorException("Named graph " + namedGraphUri + " does not exist in dataset");
                }
                if (value != null) {
                    _dataset.add(_resource, property, value, namedGraphUri);
                }
            }
        }
    }

}
