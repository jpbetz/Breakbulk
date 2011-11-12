/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/inference/OntologyComment.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: OntologyComment.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.inference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.vocabulary.DC;
import org.openanzo.rdf.vocabulary.OWL;
import org.openanzo.rdf.vocabulary.RDFS;

/**
 * 
 * Represents content to be added to the definition of a property or class as a comment, i.e. javadoc. The methods in this class provide mappings of name-value
 * pairs in various categories DC, RDFS, etc...
 * 
 * @author Joe Betz
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * 
 */
public class OntologyComment {

    private static final URI[]                        DC_PROPERTIES   = new URI[] { DC.CONTRIBUTOR, DC.COVERAGE, DC.CREATOR, DC.DATE, DC.DESCRIPTION, DC.FORMAT, DC.IDENTIFIER, DC.LANGUAGE, DC.PUBLISHER, DC.RELATION, DC.RIGHTS, DC.SOURCE, DC.SUBJECT, DC.TITLE, DC.TYPE };

    private static final URI[]                        RDFS_PROPERTIES = new URI[] { RDFS.comment, RDFS.isDefinedBy, RDFS.seeAlso, RDFS.label };

    private final Resource                            resource;

    private final HashMap<String, String>             rdfs            = new HashMap<String, String>();

    private final HashMap<String, String>             dc              = new HashMap<String, String>();

    private final String                              label;

    private final String                              versionInfo;

    private final INamedGraph                         ontGraph;

    private static HashMap<Resource, OntologyComment> comments        = new HashMap<Resource, OntologyComment>();

    /**
     * 
     * @param ontGraph
     * @param commentedResource
     * @return Ontology comment for the given resource
     */
    public static OntologyComment getOntologyComment(INamedGraph ontGraph, Resource commentedResource) {
        OntologyComment comment = comments.get(commentedResource);
        if (comment == null) {
            comment = new OntologyComment(ontGraph, commentedResource);
            comments.put(commentedResource, comment);
        }
        return comment;
    }

    /**
     * Create a new comment with the given resource
     * 
     * @param ontGraph
     *            source of ontology data
     * @param commentedResource
     *            the resource of the property or class being commented
     */
    private OntologyComment(INamedGraph ontGraph, Resource commentedResource) {
        this.ontGraph = ontGraph;
        resource = commentedResource;
        if (contains(RDFS.label)) {
            label = get(RDFS.label);
        } else if (contains(DC.TITLE)) {
            label = get(DC.TITLE);
        } else if (resource instanceof URI) {
            label = ((URI) resource).getLocalName();
        } else {
            label = resource.toString();
        }
        for (int i = 0; i < DC_PROPERTIES.length; i++) {
            if (contains(DC_PROPERTIES[i]))
                dc.put(DC_PROPERTIES[i].getLocalName(), get(DC_PROPERTIES[i]));
        }
        for (int i = 0; i < RDFS_PROPERTIES.length; i++) {
            if (contains(RDFS_PROPERTIES[i]))
                rdfs.put(RDFS_PROPERTIES[i].getLocalName(), get(RDFS_PROPERTIES[i]));
        }
        versionInfo = contains(OWL.VERSIONINFO) ? get(OWL.VERSIONINFO) : null;
    }

    private boolean contains(URI property) {
        return ontGraph.contains(resource, property, null);
    }

    /**
     * Get this comment's label
     * 
     * @return this comment's label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Get this comment's version info
     * 
     * @return this comment's version info
     */
    public String getVersionInfo() {
        return versionInfo;
    }

    /**
     * Get this comment's authors info
     * 
     * @return this comment's authors info
     */
    public List<String> getAuthors() {
        ArrayList<String> authors = new ArrayList<String>();
        authors.addAll(getStringList(DC.CREATOR));
        authors.addAll(getStringList(DC.CONTRIBUTOR));
        return authors;
    }

    /**
     * Get the set of properties for this comment
     * 
     * @return the set of properties for this comment
     */
    public String[] listRDFSPropertyNames() {
        String[] s = new String[rdfs.keySet().size()];
        return rdfs.keySet().toArray(s);
    }

    /**
     * Get the value for this property
     * 
     * @param name
     *            name of property to get
     * @return the value for this property
     */
    public String getRDFSProperty(String name) {
        return rdfs.get(name);
    }

    /**
     * Get the DC property names
     * 
     * @return the DC property names
     */
    public String[] listDCPropertyNames() {
        String[] s = new String[dc.keySet().size()];
        return dc.keySet().toArray(s);
    }

    /**
     * Get a specific DC property
     * 
     * @param name
     *            name of DC property go get
     * @return a specific DC property
     */
    public String getDCProperty(String name) {
        return dc.get(name);
    }

    private String get(URI property) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Iterable<Statement> iter = ontGraph.find(resource, property, null);
        for (Statement stmt : iter) {
            Value obj = stmt.getObject();
            if (i > 0)
                sb.append(", ");
            if (obj instanceof Literal) {
                Literal l = (Literal) obj;
                sb.append(l.getLabel());
            } else {
                sb.append(obj.toString());
            }
        }
        return sb.toString();
    }

    private List<String> getStringList(URI property) {
        ArrayList<String> list = new ArrayList<String>();
        if (ontGraph.contains(resource, property, null)) {
            Iterable<Statement> iter = ontGraph.find(resource, property, null);
            for (Statement stmt : iter) {
                Value obj = stmt.getObject();
                if (obj instanceof Literal) {
                    Literal l = (Literal) obj;
                    list.add(l.getLabel());
                }
            }
        }
        return list;
    }
}
