/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/query/Attic/BasicNodeConverter.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/27/06
 * Revision: $Id: BasicNodeConverter.java 168 2007-07-31 14:11:14Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.adapter;

import java.lang.ref.SoftReference;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.PatternSolutionImpl;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.MemPlainLiteral;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.MemValueFactory;
import org.openanzo.rdf.MemVariable;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.openrdf.model.BNode;
import org.openrdf.model.Literal;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.query.Binding;
import org.openrdf.query.BindingSet;
import org.openrdf.query.impl.MapBindingSet;

/**
 * Convert between Anzo and OpenRDF nodes.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class BasicNodeConverter {
    /** Static RIO valuefactory */
    public static final ValueFactory                                         valueFactory = new ValueFactoryImpl();

    private final Map<BlankNode, BNode>                                      bnodeMap;

    /**
     * Since you can be parsing an extremely large RDF file, you can't cache all values, since it can cause the memory stack to overflow
     */
    private final WeakHashMap<org.openrdf.model.Value, SoftReference<Value>> cachedNodes;

    /**
     * Create a new BasicNodeConverter
     */
    public BasicNodeConverter() {
        this.bnodeMap = new HashMap<BlankNode, BNode>();
        this.cachedNodes = new WeakHashMap<org.openrdf.model.Value, SoftReference<Value>>();
    }

    /**
     * Convert glitter node to Anzo Value
     * 
     * @param glitterNode
     *            Node to convert
     * @param blankNodesAsVariables
     *            are blanknodes being converted to variables in this scope
     * @return converted Anzo value, or null if glitterNode was blank, was a variable, or was a bnode with blankNodeAsVariable true
     */
    protected org.openrdf.model.Value convert(TriplePatternComponent glitterNode, boolean blankNodesAsVariables) {
        if (glitterNode == null || glitterNode instanceof Variable) {
            return null;
        }
        if (blankNodesAsVariables && glitterNode instanceof BlankNode) {
            return null;
        }
        if (glitterNode instanceof BlankNode) {
            if (!this.bnodeMap.containsKey(glitterNode)) {
                this.bnodeMap.put((BlankNode) glitterNode, BasicNodeConverter.valueFactory.createBNode(((BlankNode) glitterNode).getLabel()));
            }
            return this.bnodeMap.get(glitterNode);
        } else if (glitterNode instanceof org.openanzo.rdf.Literal) {
            if (glitterNode instanceof TypedLiteral) {
                TypedLiteral glitterTypedLit = (TypedLiteral) glitterNode;
                if (glitterTypedLit.getDatatypeURI() != null) {
                    return BasicNodeConverter.valueFactory.createLiteral(glitterTypedLit.getLabel(), BasicNodeConverter.valueFactory.createURI(glitterTypedLit.getDatatypeURI().toString()));
                }
            } else if (glitterNode instanceof PlainLiteral) {
                org.openanzo.rdf.PlainLiteral glitterPlainLit = (org.openanzo.rdf.PlainLiteral) glitterNode;
                String lang = glitterPlainLit.getLanguage();
                return BasicNodeConverter.valueFactory.createLiteral(glitterPlainLit.getLabel(), lang);
            }

        } else if (glitterNode instanceof org.openanzo.rdf.URI) {
            return BasicNodeConverter.valueFactory.createURI(((org.openanzo.rdf.URI) glitterNode).toString());
        }
        throw new GlitterRuntimeException(ExceptionConstants.GLITTER.NO_PRODUCE_NODE, glitterNode.getClass().getName());
    }

    //  long hits = 0;

    /**
     * Convert Anzo value to glitter RDFTerm
     * 
     * @param value
     *            Anzo value to convert
     * @return Glitter RDFTerm version of value
     */
    protected Value convert(org.openrdf.model.Value value) {
        SoftReference<Value> resultRef = cachedNodes.get(value);
        Value result = (resultRef != null) ? resultRef.get() : null;
        if (result != null) {
            return result;
        }
        if (value instanceof URI) {
            result = MemURI.create(value.toString());
        } else if (value instanceof org.openrdf.model.Literal) {
            Literal lit = (Literal) value;
            if (lit.getDatatype() == null) {
                if (lit.getLanguage() == null) {
                    result = MemPlainLiteral.create(lit.getLabel());
                } else {
                    result = MemPlainLiteral.create(lit.getLabel(), lit.getLanguage());
                }
            } else {
                result = MemTypedLiteral.create(lit.getLabel(), MemURI.create(lit.getDatatype().toString()));
            }
        } else if (value instanceof BNode) {
            result = MemValueFactory.defaultFactory.createBNode(((BNode) value).toString());
        }
        if (result != null) {
            cachedNodes.put(value, new SoftReference<Value>(result));
        }
        return result;
    }

    /**
     * Convert binding set to pattern solution
     * 
     * @param solution
     *            binding set to convert
     * @return converted pattern solution
     */
    public PatternSolution convert(BindingSet solution) {
        PatternSolution patternSolution = new PatternSolutionImpl();
        Set<String> bindings = solution.getBindingNames();
        for (String binding : bindings) {
            Binding b = solution.getBinding(binding);
            patternSolution.setBinding(MemVariable.createVariable(b.getName()), convert(b.getValue()));
        }
        return patternSolution;
    }

    /**
     * Convert pattern solution to binding set
     * 
     * @param solution
     *            pattern solution
     * @return binding sets
     */
    public BindingSet convert(PatternSolution solution) {
        MapBindingSet binding = new MapBindingSet();
        for (int i = 0; i < solution.size(); i++) {
            Bindable bindable = solution.getBinding(i);
            String key = (bindable instanceof Variable) ? ((Variable) bindable).getName() : bindable.toString();
            org.openrdf.model.Value value = convert(solution.getValue(i), false);
            binding.addBinding(key, value);
        }
        return binding;
    }

    private static final org.openrdf.rio.RDFFormat sparqlTbl  = new org.openrdf.rio.RDFFormat("Solution Table", "application/anzo-sparql-results+tbl", Charset.forName("UTF-8"), Collections.singleton("tbl"), false, false);

    private static final org.openrdf.rio.RDFFormat jsonFormat = new org.openrdf.rio.RDFFormat("JSON", RDFFormat.JSON.getDefaultMIMEType(), Charset.defaultCharset(), ".json", false, true);

    /**
     * Convert RIO RDFFormat to RDFFOrmat object
     * 
     * @param format
     *            format to convert
     * @return converted RDFFormat
     */
    public static RDFFormat convert(org.openrdf.rio.RDFFormat format) {
        if (format.equals(org.openrdf.rio.RDFFormat.RDFXML)) {
            return RDFFormat.RDFXML;
        } else if (format.equals(org.openrdf.rio.RDFFormat.NTRIPLES)) {
            return RDFFormat.NTRIPLES;
        } else if (format.equals(org.openrdf.rio.RDFFormat.N3)) {
            return RDFFormat.N3;
        } else if (format.equals(org.openrdf.rio.RDFFormat.TURTLE)) {
            return RDFFormat.TURTLE;
        } else if (format.equals(org.openrdf.rio.RDFFormat.TRIX)) {
            return RDFFormat.TRIX;
        } else if (format.equals(org.openrdf.rio.RDFFormat.TRIG)) {
            return RDFFormat.TRIG;
        } else if (format.equals(jsonFormat)) {
            return RDFFormat.JSON;
        } else if (format.equals(sparqlTbl)) {
            return RDFFormat.TBL;
        } else
            throw new AnzoRuntimeException(ExceptionConstants.IO.UNSUPPORTED_FORMAT_ERROR, format.toString());
    }

    /**
     * Convert RDFFormat to RIO RDFFormat
     * 
     * @param format
     *            RDFFormat to convert
     * @return converted format
     */
    public static org.openrdf.rio.RDFFormat convert(RDFFormat format) {
        switch (format) {
        case RDFXML:
            return org.openrdf.rio.RDFFormat.RDFXML;
        case NTRIPLES:
            return org.openrdf.rio.RDFFormat.NTRIPLES;
        case N3:
            return org.openrdf.rio.RDFFormat.N3;
        case TURTLE:
            return org.openrdf.rio.RDFFormat.TURTLE;
        case TRIX:
            return org.openrdf.rio.RDFFormat.TRIX;
        case TRIG:
            return org.openrdf.rio.RDFFormat.TRIG;
        case JSON:
            return jsonFormat;
        case TBL:
            return sparqlTbl;
        case SPARQL:
            return org.openrdf.rio.RDFFormat.N3;
        default:
            throw new AnzoRuntimeException(ExceptionConstants.IO.UNSUPPORTED_FORMAT_ERROR, format.toString());
        }
    }
}
