/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.owl/src/com/ibm/adtech/boca/utils/Attic/OntologyUtils.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Apr 5, 2007
 * Revision:	$Id: OntologyUtils.java 165 2007-07-31 14:11:11Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.owl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.jastor.JastorException;
import org.openanzo.rdf.jastor.Thing;
import org.openanzo.rdf.owl.DatatypeProperty;
import org.openanzo.rdf.owl.Individual;
import org.openanzo.rdf.owl.OWL11Factory;
import org.openanzo.rdf.owl.ObjectProperty;
import org.openanzo.rdf.owl._Thing;
import org.openanzo.rdf.query.QuadStoreEngineConfig;
import org.openanzo.rdf.query.QueryEncoder;
import org.openanzo.rdf.rdfs.RDFSFactory;
import org.openanzo.rdf.rdfs._Property;
import org.openanzo.rdf.utils.StatementUtils;
import org.openanzo.rdf.vocabulary.OWL;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.rdf.vocabulary.RDFS;

/**
 * Utilities for operating on ontology data within a INamedGraph
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class OntologyUtils {

    /**
     * Within an INamedGraph, retrieve all the individuals of the given class type
     * 
     * @param graph
     *            graph containing data
     * @param clazz
     *            class for which whose type must match
     * @param directlyAssertedOnly
     *            only include individuals that directly assert the classes type
     * @return set of Resources for the individuals that match
     */
    public static Collection<Resource> getAllImplementors(INamedGraph graph, org.openanzo.rdf.rdfs.Class clazz, boolean directlyAssertedOnly) {
        HashSet<Resource> impls = new HashSet<Resource>();
        Iterable<Statement> stmts = graph.find(null, RDF.TYPE, clazz.resource());
        for (Statement stmt : stmts) {
            impls.add(stmt.getSubject());
        }

        if (!directlyAssertedOnly) {
            List<org.openanzo.rdf.rdfs.Class> subclasses = getSubClasses(clazz, directlyAssertedOnly);
            for (org.openanzo.rdf.rdfs.Class clazzz : subclasses) {
                Iterable<Statement> stmtss = graph.find(null, RDF.TYPE, clazzz.resource());
                for (Statement stmt : stmtss) {
                    impls.add(stmt.getSubject());
                }

            }
        }
        return impls;
    }

    /**
     * Get the set of all defined Classes within the INamedGraph
     * 
     * @param graph
     *            graph containing data
     * @param directlyAssertedOnly
     *            only include classes that directly assert RDFS.CLASS TYPE or OWL.CLASS TYPE
     * @return the set of Resources for all defined Classes within the INamedGraph
     */
    public static Collection<Resource> getAllClasses(INamedGraph graph, boolean directlyAssertedOnly) {
        HashSet<Resource> impls = new HashSet<Resource>();
        Iterable<Statement> stmts = graph.find(null, RDF.TYPE, RDFS.Class);
        for (Statement stmt : stmts) {
            impls.add(stmt.getSubject());
        }
        stmts = graph.find(null, RDF.TYPE, OWL.CLASS);
        for (Statement stmt : stmts) {
            impls.add(stmt.getSubject());
        }
        if (!directlyAssertedOnly) {
            List<Resource> subclasses = getSubClasses(graph, RDFS.Class, directlyAssertedOnly);
            for (Resource clazzz : subclasses) {
                Iterable<Statement> stmtss = graph.find(null, RDF.TYPE, clazzz);
                for (Statement stmt : stmtss) {
                    impls.add(stmt.getSubject());
                }

            }
            subclasses = getSubClasses(graph, OWL.CLASS, directlyAssertedOnly);
            for (Resource clazzz : subclasses) {
                Iterable<Statement> stmtss = graph.find(null, RDF.TYPE, clazzz);
                for (Statement stmt : stmtss) {
                    impls.add(stmt.getSubject());
                }
            }
        }
        return impls;
    }

    /**
     * Get subclasses for a given Class
     * 
     * @param graph
     *            graph containing data
     * @param clazz
     *            type of class of which to find subclasses
     * @param directlyAssertedOnly
     *            only include classes that are directlyAssertedOnly subclasses
     * @return set of Resources for subclasses for a given Class
     */
    public static List<Resource> getSubClasses(INamedGraph graph, Resource clazz, boolean directlyAssertedOnly) {
        ArrayList<Resource> subClasses = new ArrayList<Resource>();
        Iterable<Statement> subClazzes = graph.find(null, RDFS.subClassOf, clazz);
        for (Statement next : subClazzes) {
            Resource subClazz = next.getSubject();
            if (!subClasses.contains(subClazz)) {
                subClasses.add(subClazz);
                if (!directlyAssertedOnly) {
                    List<Resource> scs = getSubClasses(graph, subClazz, directlyAssertedOnly);
                    for (Resource scc : scs) {
                        if (!subClasses.contains(scc)) {
                            subClasses.add(scc);
                        }
                    }
                }
            }
        }

        return subClasses;
    }

    /**
     * Get subclasses for a given Class
     * 
     * @param clazz
     *            class of which to find subclasses
     * @param directlyAssertedOnly
     *            only include classes that directly asserted subclasses
     * @return set of subclasses for the Class
     */
    public static List<org.openanzo.rdf.rdfs.Class> getSubClasses(org.openanzo.rdf.rdfs.Class clazz, boolean directlyAssertedOnly) {
        ArrayList<org.openanzo.rdf.rdfs.Class> subClasses = new ArrayList<org.openanzo.rdf.rdfs.Class>();
        Iterable<Statement> subClazzes = clazz.graph().find(null, RDFS.subClassOf, clazz.resource());
        for (Statement next : subClazzes) {
            org.openanzo.rdf.rdfs.Class subClazz = OWL11Factory.getClass(next.getSubject(), clazz.graph());
            if (subClazz.isRDFType(org.openanzo.rdf.rdfs.Class.TYPE) || subClazz.isRDFType(org.openanzo.rdf.owl.Class.TYPE)) {
                if (!subClasses.contains(subClazz)) {
                    subClasses.add(subClazz);
                    if (!directlyAssertedOnly) {
                        List<org.openanzo.rdf.rdfs.Class> scs = getSubClasses(subClazz, directlyAssertedOnly);
                        for (org.openanzo.rdf.rdfs.Class scc : scs) {
                            if (!subClasses.contains(scc)) {
                                subClasses.add(scc);
                            }
                        }
                    }
                }
            }
        }
        return subClasses;
    }

    /**
     * Get super classes for a given Class
     * 
     * @param clazz
     *            class of which to find super classes
     * @param directlyAssertedOnly
     *            only include classes that directly asserted super classes
     * @return set of super classes for the Class
     */
    public static List<org.openanzo.rdf.rdfs.Class> getSuperClasses(org.openanzo.rdf.rdfs.Class clazz, boolean directlyAssertedOnly) {
        ArrayList<org.openanzo.rdf.rdfs.Class> subClasses = new ArrayList<org.openanzo.rdf.rdfs.Class>();
        Iterable<Statement> subClazzes = clazz.graph().find(clazz.resource(), RDFS.subClassOf, null);
        for (Statement next : subClazzes) {
            if (next.getObject() instanceof Resource) {
                org.openanzo.rdf.owl.Class subClazz = OWL11Factory.getClass((Resource) next.getObject(), clazz.graph());
                if (subClazz.isRDFType(org.openanzo.rdf.rdfs.Class.TYPE)) {
                    if (!subClasses.contains(subClazz)) {
                        subClasses.add(subClazz);
                        if (!directlyAssertedOnly) {
                            List<org.openanzo.rdf.rdfs.Class> scs = getSuperClasses(subClazz, directlyAssertedOnly);
                            for (org.openanzo.rdf.rdfs.Class scc : scs) {
                                if (!subClasses.contains(scc)) {
                                    subClasses.add(scc);
                                }
                            }
                        }
                    }
                }
            }
        }
        subClasses.add(OWL11Factory.getClass(_Thing.TYPE, clazz.graph()));
        return subClasses;
    }

    /**
     * Get set of sub properties for the property
     * 
     * @param property
     *            property of which to find sub properties
     * @param directlyAssertedOnly
     *            only include directly asserted sub properties
     * @return set of sub properties for the property
     */
    public static List<_Property> getSubProperties(_Property property, boolean directlyAssertedOnly) {
        ArrayList<_Property> subProperties = new ArrayList<_Property>();
        Iterable<Statement> subProperteizes = property.graph().find(null, RDFS.subPropertyOf, property.resource());
        for (Statement next : subProperteizes) {
            _Property subProperty = RDFSFactory.get_Property(next.getSubject(), property.graph());
            if (subProperty.isRDFType(_Property.TYPE)) {
                if (!subProperties.contains(subProperty)) {
                    subProperties.add(subProperty);
                    if (!directlyAssertedOnly) {
                        List<_Property> scs = getSubProperties(subProperty, directlyAssertedOnly);
                        for (_Property spp : scs) {
                            if (!subProperties.contains(spp)) {
                                subProperties.add(spp);
                            }
                        }
                    }
                }
            }
        }

        return subProperties;
    }

    /**
     * Get set of super properties for the property
     * 
     * @param property
     *            property of which to find super properties
     * @param directlyAssertedOnly
     *            only include directly asserted super properties
     * @return set of super properties for the property
     */
    public static List<_Property> getSuperProperties(_Property property, boolean directlyAssertedOnly) {
        ArrayList<_Property> subProperties = new ArrayList<_Property>();
        Iterable<Statement> subProperteizes = property.graph().find(property.resource(), RDFS.subPropertyOf, null);
        for (Statement next : subProperteizes) {
            if (next.getObject() instanceof Resource) {
                _Property subProperty = RDFSFactory.get_Property((Resource) next.getObject(), property.graph());
                if (subProperty.isRDFType(_Property.TYPE) || subProperty.isRDFType(DatatypeProperty.TYPE) || subProperty.isRDFType(ObjectProperty.TYPE)) {
                    if (!subProperties.contains(subProperty)) {
                        subProperties.add(subProperty);
                        if (!directlyAssertedOnly) {
                            List<_Property> scs = getSuperProperties(subProperty, directlyAssertedOnly);
                            for (_Property spp : scs) {
                                if (!subProperties.contains(spp)) {
                                    subProperties.add(spp);
                                }
                            }
                        }
                    }
                }
            }
        }
        return subProperties;
    }

    /**
     * Get all individuals for the given class type. Includes non direct implementors of the class type.
     * 
     * @param graph
     *            graph containing data
     * @param clazz
     *            class of which to find individuals
     * @return set of Individuals of a given class type
     */
    public static Collection<Individual> getAllIndividuals(INamedGraph graph, org.openanzo.rdf.rdfs.Class clazz) {
        HashSet<Individual> individuals = new HashSet<Individual>();
        Collection<Resource> implementors = getAllImplementors(graph, clazz, false);
        for (Resource resource : implementors) {
            Individual indv = OWL11Factory.getIndividual(resource, graph);
            individuals.add(indv);
        }
        return individuals;
    }

    /**
     * Get the set of Classes that make up the Range of a property
     * 
     * @param property
     *            property of which to find the Range classes
     * @return set of Classes that make up the Range of a property
     * @throws AnzoException
     */
    public static List<org.openanzo.rdf.rdfs.Class> getRange(_Property property) throws AnzoException {
        ArrayList<org.openanzo.rdf.rdfs.Class> ranges = new ArrayList<org.openanzo.rdf.rdfs.Class>();
        org.openanzo.rdf.rdfs.Class range = property.getRange();
        if (range != null && range.resource() instanceof BlankNode) {
            org.openanzo.rdf.owl.Class clazz = OWL11Factory.getClass(range.resource(), property.graph());
            Thing union = clazz.getUnionOf();
            if (union != null) {
                for (Value value : StatementUtils.getContainerMembers(union.resource(), property.graph())) {
                    if (value instanceof Resource) {
                        // org.openanzo.rdf.rdfs.Class rangeClazz = OWL11Factory.getClass((Resource) value, ontGraph);
                        ranges.add(OWL11Factory.createClass((Resource) value, property.graph()));
                    }
                }
            } else {
                if (!clazz.isRDFType(org.openanzo.rdf.rdfs.Class.TYPE)) {
                    ranges.add(OWL11Factory.createClass(clazz.resource(), property.graph()));
                } else {
                    ranges.add(clazz);
                }
            }
        } else if (range != null) {
            if (!range.isRDFType(org.openanzo.rdf.rdfs.Class.TYPE)) {
                range = OWL11Factory.createClass(range.resource(), property.graph());
            }
            ranges.add(range);
        }
        return ranges;
    }

    /**
     * Get the set of Classes that make up the Domain of a property
     * 
     * @param property
     *            property of which to find the Domain classes
     * @return set of Classes that make up the Domain of a property
     * @throws AnzoException
     */
    public static List<org.openanzo.rdf.rdfs.Class> getDomain(_Property property) throws AnzoException {
        ArrayList<org.openanzo.rdf.rdfs.Class> domains = new ArrayList<org.openanzo.rdf.rdfs.Class>();
        org.openanzo.rdf.rdfs.Class domain = property.getDomain();
        if (domain != null && domain.resource() instanceof BlankNode) {
            org.openanzo.rdf.owl.Class clazz = OWL11Factory.getClass(domain.resource(), property.graph());
            Thing union = clazz.getUnionOf();
            if (union != null) {
                for (Value value : StatementUtils.getContainerMembers(union.resource(), property.graph())) {
                    if (value instanceof Resource) {
                        // org.openanzo.rdf.rdfs.Class rangeClazz = OWL11Factory.getClass((Resource) value, ontGraph);
                        domains.add(OWL11Factory.createClass((Resource) value, property.graph()));
                    }
                }
            } else {
                if (!clazz.isRDFType(org.openanzo.rdf.rdfs.Class.TYPE)) {
                    domains.add(OWL11Factory.createClass(clazz.resource(), property.graph()));
                } else {
                    domains.add(clazz);
                }
            }
        } else if (domain != null) {
            if (!domain.isRDFType(org.openanzo.rdf.rdfs.Class.TYPE)) {
                domain = OWL11Factory.createClass(domain.resource(), property.graph());
            }
            domains.add(domain);
        }
        return domains;
    }

    /**
     * Get the set of properties whose domain matches the class
     * 
     * @param clazz
     *            class for which to find properties
     * @return the set of properties whose domain matches the class
     * @throws JastorException
     */
    public static List<_Property> findDeclaredProperties(org.openanzo.rdf.rdfs.Class clazz) throws JastorException {
        List<_Property> properties = new ArrayList<_Property>();
        String query = "SELECT ?res WHERE {?res " + QueryEncoder.encodeForQuery(RDF.TYPE) + " " + QueryEncoder.encodeForQuery(DatatypeProperty.TYPE) + " . ?res " + QueryEncoder.encodeForQuery(RDFS.domain) + " " + QueryEncoder.encodeForQuery(clazz.resource()) + "}";
        MemQuadStore ds = new MemQuadStore();
        ds.add(clazz.graph().getStatements());
        QuadStoreEngineConfig config = new QuadStoreEngineConfig(ds);
        Engine glitter = new Engine(config);
        try {
            QueryResults results = glitter.executeQuery(null, query, Collections.singleton(clazz.graph().getNamedGraphUri()), Collections.<URI> emptySet());
            Iterator<PatternSolution> iter = results.getSelectResults().iterator();
            while (iter.hasNext()) {
                iter.next();
                Resource propRes = (Resource) iter.next().getBinding("res");
                if (propRes != null) {
                    DatatypeProperty dp = OWL11Factory.getDatatypeProperty(propRes, clazz.graph());
                    if (dp.isRDFType(DatatypeProperty.TYPE)) {
                        properties.add(dp);
                    }
                }
            }
        } catch (Exception e) {
            throw new JastorException(e, "Error querying for properties");
        }
        query = "SELECT ?res WHERE {?res " + QueryEncoder.encodeForQuery(RDF.TYPE) + " " + QueryEncoder.encodeForQuery(ObjectProperty.TYPE) + " . ?res " + QueryEncoder.encodeForQuery(RDFS.domain) + " " + QueryEncoder.encodeForQuery(clazz.resource()) + "}";
        try {
            QueryResults results = glitter.executeQuery(null, query, Collections.singleton(clazz.graph().getNamedGraphUri()), Collections.<URI> emptySet());

            Iterator<PatternSolution> iter = results.getSelectResults().iterator();
            while (iter.hasNext()) {
                iter.next();
                Resource propRes = (Resource) iter.next().getBinding("res");
                if (propRes != null) {
                    ObjectProperty dp = OWL11Factory.getObjectProperty(propRes, clazz.graph());
                    if (dp.isRDFType(ObjectProperty.TYPE)) {
                        properties.add(dp);
                    }
                }
            }
        } catch (Exception e) {
            throw new JastorException(e, "Error querying for properties");
        }
        return properties;
    }
}
