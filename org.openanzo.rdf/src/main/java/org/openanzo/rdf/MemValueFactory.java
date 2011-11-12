/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/Attic/BocaValueFactory.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Dec 27, 2006
 * Revision:	$Id: AnzoValueFactory.java 168 2007-07-31 14:11:14Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.InvalidBlankNodeLabelException;
import org.openanzo.rdf.datatype.TypedValueMapper;
import org.openanzo.rdf.utils.Pair;
import org.openanzo.rdf.vocabulary.DC;
import org.openanzo.rdf.vocabulary.FOAF;
import org.openanzo.rdf.vocabulary.OWL;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.rdf.vocabulary.RDFS;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * In memory implementation of a ValueFactory.
 * 
 * <li>Contains weakHashMaps for caching uris, literals, typedLiterals, and bNodes. <li>Has a createTypedLiteral method, which sets datatype for literals on
 * creation <li>Uses random uuid for bnodes to prevent clashes
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class MemValueFactory extends ValueFactory {

    /** Static final ValueFactory that Anzo classes use to create URIs,Statements,Literals and BlankNodes */
    public static final MemValueFactory                             defaultFactory = new MemValueFactory();
    static {
        defaultFactory.registerPrefix("faof", FOAF.NAMESPACE);
        defaultFactory.registerPrefix("rdfs", RDFS.NAMESPACE);
        defaultFactory.registerPrefix("rdf", RDF.NAMESPACE);
        defaultFactory.registerPrefix("xsd", XMLSchema.NAMESPACE);
        defaultFactory.registerPrefix("owl", OWL.NAMESPACE);
        defaultFactory.registerPrefix("dc", DC.NAMESPACE);
    }

    /** WeakHashMap cache of uris */
    private final VacatingSoftMap<URI, URI>                         uris           = new VacatingSoftMap<URI, URI>();

    /** WeakHashMap cache of literals */
    private final VacatingSoftMap<MemPlainLiteral, MemPlainLiteral> plainLiterals  = new VacatingSoftMap<MemPlainLiteral, MemPlainLiteral>();

    /** WeakHashMap cache of literals */
    private final VacatingSoftMap<MemPlainLiteral, MemPlainLiteral> langLiterals   = new VacatingSoftMap<MemPlainLiteral, MemPlainLiteral>();

    /** WeakHashMap cache of typedLiterals */
    private final VacatingSoftMap<MemTypedLiteral, MemTypedLiteral> typedLiterals  = new VacatingSoftMap<MemTypedLiteral, MemTypedLiteral>();

    /** WeakHashMap cache of blankNodes */
    private final VacatingSoftMap<MemBlankNode, MemBlankNode>       blankNodes     = new VacatingSoftMap<MemBlankNode, MemBlankNode>();

    private static final String                                     SPACE          = " ";

    private final Map<String, String>                               prefixes       = new HashMap<String, String>();

    private final BlankNodeManager                                  blankNodeManager;

    // this prevents apps that use multiple factories (i.e. JastorThingFactory, Constants.valueFactory)
    // from having colliding bnodes.
    /**
     * Memvalue factory constructor
     */
    public MemValueFactory() {
        blankNodeManager = new BlankNodeManager(false);
    }

    public void purgeCaches() {
        uris.clear();
        plainLiterals.clear();
        langLiterals.clear();
        typedLiterals.clear();
        blankNodes.clear();
    }

    @Override
    public BlankNode createBNode() {
        return createBNode(BlankNodeManager.generateBnodeString());
    }

    @Override
    public BlankNode createBNode(String id) {
        // String bid = new StringBuilder().append(id).toString(); // This copy of the string is done since sometimes Java String.substring is sometimes implemented by reusing the array of the original string and keeping an offset. But this wastes memory especially if the rest of that string is no longer needed. This happens, for example, when reading a very large XML document.
        String bid = id;
        BlankNode result;

        if (bid.startsWith(Constants.ANZO_BNODE_PREFIX)) {
            String label = bid.substring(Constants.BNODE_PREFIX.length());
            result = getBlankNode(label);
        } else if (bid.startsWith(Constants.ANZO_BNODE)) {
            result = getBlankNode(bid);
        } else {
            try {
                result = blankNodeManager.getBlankNode(bid);
            } catch (InvalidBlankNodeLabelException e) {
                throw new AnzoRuntimeException(ExceptionConstants.DATASOURCE.CREATE_OBJECT, e);
            }
        }
        return result;
    }

    private BlankNode getBlankNode(String label) {
        MemBlankNode bnode = new MemBlankNode(label);
        MemBlankNode result = null;
        synchronized (blankNodes) {
            result = blankNodes.get(bnode);
            if (result == null) {
                result = bnode;
                blankNodes.put(result, result);
            }
        }
        return result;
    }

    @Override
    public Resource createResource(String value) {
        if (value.startsWith(Constants.BNODE_PREFIX)) {
            return createBNode(value);
        } else {
            return createURI(value);
        }
    }

    @Override
    public PlainLiteral createLiteral(String label) {
        MemPlainLiteral lit = new MemPlainLiteral(label);
        MemPlainLiteral literal = null;
        synchronized (plainLiterals) {
            literal = plainLiterals.get(lit);
            if (literal == null) {
                literal = lit;
                plainLiterals.put(literal, literal);
            }
            return literal;
        }
    }

    @Override
    public PlainLiteral createLiteral(String label, String lang) {
        if (lang == null)
            return createLiteral(label);
        MemPlainLiteral lit = new MemPlainLiteral(label, lang);
        MemPlainLiteral literal = null;
        synchronized (langLiterals) {
            literal = langLiterals.get(lit);
            if (literal == null) {
                literal = lit;
                langLiterals.put(literal, literal);
            }
            return literal;
        }

    }

    @Override
    public TypedLiteral createLiteral(String label, URI dataType) {
        if (dataType == null) {
            throw new InvalidParameterException("dataType must be non-null.");
        }
        MemTypedLiteral lit = new MemTypedLiteral(label, dataType);
        MemTypedLiteral literal = null;
        synchronized (typedLiterals) {
            literal = typedLiterals.get(lit);
            if (literal == null) {
                literal = lit;
                typedLiterals.put(literal, literal);
            }
            return literal;
        }
    }

    @Override
    public TypedLiteral createTypedLiteral(Object value) {
        Pair<String, URI> lexicalInfo = TypedValueMapper.getLexicalValue(value);
        if (lexicalInfo == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_MAPPING, value.getClass().getName());
        } else {
            return createLiteral(lexicalInfo.first, lexicalInfo.second);
        }
    }

    @Override
    public Statement createStatement(Resource subj, URI prop, Value obj) {
        if (subj == null || prop == null || obj == null)
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_NULL_VALUES, ObjectUtils.toString(subj), ObjectUtils.toString(prop), ObjectUtils.toString(obj));
        return new Statement(subj, prop, obj);
    }

    @Override
    public Statement createStatement(Resource subj, URI prop, Value obj, URI namedGraphUri) {
        if (subj == null || prop == null || obj == null || namedGraphUri == null)
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_NULL_VALUES, ObjectUtils.toString(namedGraphUri), ObjectUtils.toString(subj), ObjectUtils.toString(prop), ObjectUtils.toString(obj));
        return new Statement(subj, prop, obj, namedGraphUri);
    }

    @Override
    public Statement createMatchStatement(Resource subj, URI prop, Value obj, URI context) {
        return new Statement((subj != null) ? subj : Constants.ANY_URI, (prop != null) ? prop : Constants.ANY_URI, (obj != null) ? obj : Constants.ANY_URI, (context != null) ? context : Constants.ANY_URI);
    }

    @Override
    public Statement createMatchStatement(Resource subj, URI prop, Value obj) {
        return createMatchStatement(subj, prop, obj, null);
    }

    @Override
    public URI createURI(String uri) {
        if (uri.contains(SPACE)) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.SPACE_IN_URI, uri);
        }
        synchronized (uris) {
            URI uriObject = new MemURI(uri);
            URI uriVal = uris.get(uriObject);
            if (uriVal == null) {
                uriVal = uriObject;
                uris.put(uriVal, uriVal);
            }
            return uriVal;
        }
    }

    @Override
    public URI createURIFromCURIE(String curie) {
        String[] split = StringUtils.split(curie, ":", 2);
        if (split.length != 2)
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.CURIE_ERROR, curie);

        String prefix = prefixes.get(split[0]);
        if (prefix == null)
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_VALUEFACTORY_MAPPING, split[0]);
        return createURI(prefix + split[1]);
    }

    @Override
    public void registerPrefix(String shortName, String uriPrefix) {
        prefixes.put(shortName, uriPrefix);
    }

    @Override
    public String prefixQuery(String queryString) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> prefix : prefixes.entrySet()) {
            builder.append("PREFIX ");
            builder.append(prefix.getKey());
            builder.append(": <");
            builder.append(prefix.getValue());
            builder.append(">\n");
        }
        builder.append(queryString);
        return builder.toString();
    }

    @Override
    public Map<String, String> getRegisteredPrefixes() {
        return prefixes;
    }

}
