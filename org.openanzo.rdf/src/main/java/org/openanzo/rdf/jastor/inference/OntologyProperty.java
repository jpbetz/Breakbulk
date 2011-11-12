/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/inference/OntologyProperty.java,v $
 * Created by:
 * Created on:  01/23/2007
 * Revision:	$Id: OntologyProperty.java 172 2007-07-31 14:22:23Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     C Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.inference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.datatype.TypedValueMapper;
import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.JastorException;
import org.openanzo.rdf.jastor.JavaIdentifierEncoder;
import org.openanzo.rdf.jastor.Thing;
import org.openanzo.rdf.owl.DataRange;
import org.openanzo.rdf.owl.DatatypeProperty;
import org.openanzo.rdf.owl.FunctionalProperty;
import org.openanzo.rdf.owl.OWL11Factory;
import org.openanzo.rdf.owl.ObjectProperty;
import org.openanzo.rdf.owl.Restriction;
import org.openanzo.rdf.owl._Thing;
import org.openanzo.rdf.query.QuadStoreEngineConfig;
import org.openanzo.rdf.query.QueryEncoder;
import org.openanzo.rdf.rdfs._Property;
import org.openanzo.rdf.utils.StatementUtils;
import org.openanzo.rdf.vocabulary.OWL;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.rdf.vocabulary.RDFS;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Represents an Ontology Property
 * 
 * @author Ben Szekely ( <a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com </a>)
 * 
 */
public class OntologyProperty {

    /**
     * this uri is a placeholder for the default range of a property that is returned by getAllReturnTypes. We don't use the actual default return type URI in
     * that call because it might be null.
     */
    public static final URI                  DEFAULT_RANGE          = Constants.valueFactory.createURI("http://jastor.adtech.ibm.com/defaultRange");

    /** This property is defined within itself */
    public static final int                  ROLE_HERE              = 0;

    /** This property is defined in an extension class */
    protected static final int               ROLE_EXTENSIONCLASS    = 1;

    /** This property is a placeholder for a loose restriction to send downstream */
    private static final int                 ROLE_LOOSE_RESTRICTION = 2;

    /** List of restrictions where the end of the list contains the most downstream restriction */
    private final List<Restriction>          restrictions           = new ArrayList<Restriction>();

    /**
     * this list stores multiple ranges in the case that the the range of the property is defined as a Union. Otherwise, the list will not be used. These will
     * considered as coming from the active class. we may eventually clean this up when we see more clearly how these multiple ranges are used.
     */
    private final List<Resource>             ranges                 = new ArrayList<Resource>();

    /**
     * The ontology class where this property was originally defined, i.e. the top of the hierarchy.
     */
    private final OntologyClass              ontologyClass;

    private final _Property                  ontProperty;

    private final org.openanzo.rdf.owl.Class ontClass;

    private final INamedGraph                ontGraph;

    private final JastorContext              ctx;

    private final OntologyComment            comment;

    /**
     * the active class is the ontology class that this property is being used to generate, not to be confused with the ontologyClass where the property was
     * originally defined
     */
    private OntologyClass                    activeClass;

    /**
     * The role of this property class, see above for the different options
     */
    private int                              role                   = ROLE_HERE;

    /**
     * If this flag is true, it means that this property exists in the frame of an ontology class that has another property with the same local name
     */
    private boolean                          duplicateProperty      = false;

    /**
     * Create a new Property
     * 
     * @param ontProperty
     *            the underlying Jastor property bean
     * @param ontologyClass
     *            The parent class for this property
     * @throws JastorException
     */
    public OntologyProperty(_Property ontProperty, OntologyClass ontologyClass) throws JastorException {
        long start = System.currentTimeMillis();

        this.ontProperty = ontProperty;
        this.ontologyClass = ontologyClass;
        this.ontClass = ontologyClass.getOntClass();
        this.activeClass = ontologyClass;
        ctx = ontologyClass.getContext();
        this.ontGraph = ctx.getOntGraph();
        computePrimaryRestrictions();
        checkForMultipleBaseRanges();
        this.comment = OntologyComment.getOntologyComment(this.ontGraph, this.ontProperty.resource());
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("makeProp", end - start);
        }
    }

    /**
     * This version of the constructor should only be use if the instance is used for utility methods on the property..i.e. getName, etc...
     * 
     * @param ontProperty
     *            the underlying Jastor property bean
     * @param ctx
     *            the parent jastor context
     * @throws JastorException
     */
    public OntologyProperty(_Property ontProperty, JastorContext ctx) throws JastorException {
        this.ontProperty = ontProperty;
        this.ctx = ctx;
        comment = null;
        ontClass = null;
        ontGraph = null;
        ontologyClass = null;
    }

    /**
     * This constructor is used to create a place holder for loose restriciton on a property that might not actually be found in the search because of the
     * visited list. OntologyClasses should return instances of these properties if they have restrictions on properties not found in their recursive search.
     * 
     * @param ontProperty
     */
    OntologyProperty(_Property ontProperty, Restriction restriction) {
        this.ontProperty = ontProperty;
        restrictions.add(restriction);
        role = ROLE_LOOSE_RESTRICTION;
        comment = null;
        ctx = null;
        ontClass = null;
        ontGraph = null;
        ontologyClass = null;
    }

    /**
     * Returns whether or not this instance is a placeholder for a restriction on a property
     * 
     * @return whether or not this instance is a placeholder for a restriction on a property
     */
    public boolean isLooseRestriction() {
        return (ontologyClass == null);
    }

    /**
     * Get the role of the property's participation in the owning class.
     * 
     * @return the role of the property's participation in the owning class.
     */
    public int getRole() {
        return role;
    }

    /**
     * set the role of the property
     * 
     * @param role
     *            the role of the property
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * Get the ontology class begin generated.
     * 
     * @return the ontology class begin generated.
     */
    public OntologyClass getActiveClass() {
        return activeClass;
    }

    /**
     * Set the active class for the property
     * 
     * @param activeClass
     *            the active class for the property
     */
    public void setActiveClass(OntologyClass activeClass) {
        this.activeClass = activeClass;
    }

    /**
     * Get the ontology class that declares this property
     * 
     * @return the ontology class that declares this property
     */
    public OntologyClass getOntologyClass() {
        return ontologyClass;
    }

    /**
     * Get the jastor Property bean for this property
     * 
     * @return the jastor Property bean for this property
     */
    public _Property getOntProperty() {
        return ontProperty;
    }

    /**
     * Get the comment info for this property
     * 
     * @return the comment info for this property
     */
    public OntologyComment getComment() {
        return comment;
    }

    /**
     * yields the restriction declared with the original declaration of the property
     * 
     * @return the restriction declared with the original declaration of the property
     */
    public Restriction getPrimaryRestriction() {
        return restrictions.get(0);
    }

    /**
     * Add a restriction to the property
     * 
     * @param res
     *            restriction to add
     */
    protected void addRestriction(Restriction res) {
        // must check if we already have this restriction
        if (!restrictions.contains(res))
            restrictions.add(res);
    }

    /**
     * Add a list of restrictions to the property
     * 
     * @param res
     *            a list of restrictions to the property
     */
    protected void addRestrictions(List<Restriction> res) {
        for (Restriction r : res) {
            addRestriction(r);
        }
    }

    /**
     * Get the list of restrictions for the property
     * 
     * @return the list of restrictions for the property
     */
    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    /**
     * Determine if this property can take on multiple values
     * 
     * @return true if this property can take on multiple values
     */
    public boolean isMultiValued() {
        // find the first cardinality restriction we see
        if (ontProperty.isRDFType(FunctionalProperty.TYPE))
            return false;
        for (int i = restrictions.size() - 1; i >= 0; i--) {
            Restriction res = restrictions.get(i);
            Iterable<Integer> cardinal = res.getCardinality();
            if (cardinal.iterator().hasNext()) {
                Integer cr = cardinal.iterator().next();
                if (cr.longValue() > 1)
                    return true;
                else
                    return false;
            }

            Iterable<Integer> maxCardinal = res.getMaxCardinality();
            if (maxCardinal.iterator().hasNext()) {
                Integer cr = maxCardinal.iterator().next();
                if (cr.longValue() > 1)
                    return true;
                else
                    return false;
            }

        }
        return true;
    }

    /**
     * Is this property required
     * 
     * @return true if this property is required
     */
    public boolean isRequired() {
        for (int i = restrictions.size() - 1; i >= 0; i--) {
            Restriction res = restrictions.get(i);
            Iterable<Integer> cardinal = res.getCardinality();
            if (cardinal.iterator().hasNext()) {
                Integer cr = cardinal.iterator().next();
                if (cr.longValue() >= 1)
                    return true;
                else
                    return false;
            }

            Iterable<Integer> minCardinal = res.getMinCardinality();
            if (minCardinal.iterator().hasNext()) {
                Integer cr = minCardinal.iterator().next();
                if (cr.longValue() >= 1)
                    return true;
                else
                    return false;
            }

        }
        return false;
    }

    /**
     * Determine if this property is single valued
     * 
     * @return if this property is single valued
     */
    public boolean isSingleValued() {
        return !isMultiValued();
    }

    /**
     * Determine if this is an Object property
     * 
     * @return if this is an Object property
     */
    public boolean isObjectProperty() {
        return ontProperty.isRDFType(ObjectProperty.TYPE);
    }

    /**
     * Determine if this is a Datatype property
     * 
     * @return if this is a Datatype property
     */
    public boolean isDatatypeProperty() {
        return ontProperty.isRDFType(DatatypeProperty.TYPE);
    }

    /**
     * Determine if the given value is contained in the property's DataRange. If the property does not have a data range, returns true.
     * 
     * @param value
     * @return true if the given value is contained in the property's DataRange
     */
    public boolean isValueInRange(Value value) {
        if (restrictions.isEmpty())
            return true;
        Restriction restriction = getPrimaryRestriction();
        Collection<Thing> valueRanges = restriction.getAllValuesFrom();
        if (valueRanges.isEmpty())
            return true;
        Thing valueRange = valueRanges.iterator().next();

        // for now, assume that the oneOf contains all the same type.
        DataRange dr = OWL11Factory.getDataRange(valueRange.resource(), ontGraph);
        Thing oneOf = dr.getOneOf();
        if (oneOf != null) {
            for (Value dataRangeVal : StatementUtils.getCollectionMembers(oneOf.resource(), ontGraph)) {
                if (dataRangeVal.equals(value))
                    return true;
            }
        }
        return false;
    }

    /**
     * Return the name of the property to be used for variable names and as a prefix for vocabulary property constants
     * 
     * @return the name of the property to be used for variable names and as a prefix for vocabulary property constants
     */
    public String getPropertyName() {
        if (ctx == null) {
            System.err.println(getURI());
            System.err.println(isLooseRestriction());
        }
        if (ctx != null && ctx.isUseEntireURIForIdentifiers())
            return JavaIdentifierEncoder.encode(ontProperty.uri());
        else {
            String name = JavaIdentifierEncoder.encode(Constants.valueFactory.createURI(ontProperty.uri()).getLocalName());
            if (duplicateProperty) {
                name = addPrefix(name);
            }
            return name;
        }
    }

    /**
     * Return the name of the property to be used for variable names and constants using the restricted range argument
     * 
     * @param restrictedRange
     *            restrictedRange argument
     * @return the name of the property to be used for variable names and constants using the restricted range argument
     */
    public String getPropertyName(Resource restrictedRange) {
        // handle the case where we are being called with the default range
        if (restrictedRange != null && restrictedRange.equals(DEFAULT_RANGE))
            return getPropertyName();
        String resrange = getReturnType(restrictedRange);
        if (ctx.isUsePackageNameForRestrictedRanges())
            resrange = resrange.replace('.', '_');
        else
            resrange = resrange.substring(resrange.lastIndexOf('.') + 1);
        String name = getPropertyName() + "_as" + resrange;
        if (duplicateProperty) {
            name = addPrefix(name);
        }
        return name;
    }

    /**
     * Return the name of the property capitalized, should be prepended for use in method names
     * 
     * @return the name of the property capitalized, should be prepended for use in method names
     */
    public String getPropertyCapped() {
        if (ctx.isUseEntireURIForIdentifiers())
            return capitalize(JavaIdentifierEncoder.encode(ontProperty.uri()));
        else {
            String name = capitalize(JavaIdentifierEncoder.encode(Constants.valueFactory.createURI(ontProperty.uri()).getLocalName()));
            if (duplicateProperty) {
                name = capitalize(addPrefix(name));
            }
            return name;
        }
    }

    /**
     * Return the name of the property capitalized, should be prepended for use in method names *
     * 
     * @param restrictedRange
     *            restrictedRange argument
     * @return the name of the property capitalized, should be prepended for use in method names
     */
    public String getPropertyCapped(Resource restrictedRange) {
        // handle the case where we are being called with the default range
        if (restrictedRange != null && restrictedRange.equals(DEFAULT_RANGE))
            return getPropertyCapped();
        String resrange = getReturnType(restrictedRange);
        if (ctx.isUsePackageNameForRestrictedRanges())
            resrange = resrange.replace('.', '_');
        else
            resrange = resrange.substring(resrange.lastIndexOf('.') + 1);
        String toappend = "";
        if (restrictedRange != null) {
            toappend = "_as" + resrange;
        }
        if (ctx.isUseEntireURIForIdentifiers())
            return capitalize(JavaIdentifierEncoder.encode(ontProperty.uri()) + toappend);
        else {
            String name = capitalize(JavaIdentifierEncoder.encode(Constants.valueFactory.createURI(ontProperty.uri()).getLocalName()) + toappend);
            if (duplicateProperty) {
                name = capitalize(addPrefix(name));
            }
            return name;
        }
    }

    // We need both of the next methods because some template sections will operate on all ranges
    // separately while others will operate on the default and alt together. Also, some will be interested in
    // alt ranges for the entire hierarchy, or just the activeClass
    /**
     * Return an Iterable of ranges for this property
     * 
     * @param all
     *            whether or not to include the default range in addition to all alt ranges
     * @param activeClassOnly
     *            whether or not to include ranges in the activeClass only
     * @return an Iterable of ranges for this property
     */
    public Iterable<Resource> listRanges(boolean all, boolean activeClassOnly) {
        if (all)
            return listAllRanges(activeClassOnly);
        else
            return listAlternativeRanges(activeClassOnly);
    }

    /**
     * Return an an Iterable of Resources that represent additional ranges for this property. The activeClassOnly flag determines if we consider only those
     * restrictions declared in the active class
     * 
     * @param activeClassOnly
     *            only return active class ranges
     * @return an Iterable of alternative ranges for this property
     */
    public Iterable<Resource> listAlternativeRanges(boolean activeClassOnly) {
        List<Resource> list = listAlternativeRangesList(activeClassOnly);
        return list;
    }

    /**
     * Return an an Iterable of Resources that represent all possible ranges for this property gathered from the entire hierarchy. An element in the iterator
     * will be a special Resource indicating the default return type. As such, the items in the Iterator may be used in calls to getReturnType(),
     * getPropertyName(), and getPropertyCapped() but should not be treated as verbatim.
     * 
     * @return an Iterable of all ranges
     */
    public Iterable<Resource> listAllRanges() {
        return listAllRanges(false);
    }

    /**
     * Return an an interator or Resources that represent all possible ranges for this property. the boolean parameter indicates whether we should include
     * return types declared in the activeClass only or in the entire hiearchy. The active class is the class we are generating for. *
     * 
     * @param activeClassOnly
     *            only return active class ranges
     * @return an Iterable of all ranges
     */
    private Iterable<Resource> listAllRanges(boolean activeClassOnly) {
        List<Resource> list = listAlternativeRangesList(activeClassOnly);
        // list.addAll(list);
        // we have to make sure that ranges don't get added twice because some ontologies
        // might cause this.
        if (!ranges.isEmpty()) {
            for (Resource range : ranges) {
                if (!list.contains(range))
                    list.add(range);
            }
        } else {
            if (!list.contains(DEFAULT_RANGE))
                list.add(0, DEFAULT_RANGE);
        }
        return list;
    }

    /**
     * Get the string representation of the full java name of the return type for this property. The return type is based on the original range declaration of
     * the property.
     * 
     * @return the string representation of the full java name of the return type for this property
     */
    public String getReturnType() {
        Resource range = null;
        // check for multiple base ranges.
        if (!ranges.isEmpty()) {
            range = ranges.get(0);
        } else {
            range = getRange();
        }
        return getReturnType(range);
    }

    /**
     * Get the string representation of the full java name of the return type for this property.
     * 
     * @param range
     *            indicates an alternative range or the DEFAULT_RANGE
     * @return the string representation of the full java name of the return type for this property
     */
    public String getReturnType(Resource range) {
        if (range != null && range.equals(DEFAULT_RANGE))
            return getReturnType();
        try {
            if (isObjectProperty()) {
                if (range == null || range.equals(_Thing.TYPE) || range instanceof BlankNode) {
                    return ctx.getThingInterface().getName();
                } else {
                    org.openanzo.rdf.owl.Class rangeclass = OWL11Factory.getClass(range, ontGraph);
                    if (rangeclass == null || !rangeclass.isRDFType(org.openanzo.rdf.owl.Class.TYPE))
                        return ctx.getThingInterface().getName();
                    OntologyClass oc = new OntologyClass(rangeclass, ctx);
                    return oc.getInterfaceFullClassname();
                }
            } else {
                if (range == null || range.equals(RDFS.literal))
                    return ctx.getBaseLiteralClass().getName();
                if (ontGraph.contains(range, RDF.TYPE, DataRange.TYPE)) {
                    // for now, assume that the oneOf contains all the same time.
                    DataRange dr = OWL11Factory.getDataRange(range, ontGraph);
                    Thing oneOf = dr.getOneOf();
                    if (oneOf != null) {
                        Iterable<Value> oneOfs = StatementUtils.getCollectionMembers(oneOf.resource(), ontGraph);
                        Iterator<Value> it = oneOfs.iterator();
                        while (it.hasNext()) {
                            Value val = it.next();
                            if (val instanceof Literal) {
                                Literal lit = (Literal) val;

                                if (lit instanceof TypedLiteral) {
                                    range = ((TypedLiteral) lit).getDatatypeURI();
                                } else {
                                    range = XMLSchema.STRING;
                                }
                                continue;
                            }
                        }
                    }
                }
                java.lang.Class<?> cls = TypedValueMapper.getNativeClass((URI) range);
                if (cls == null) {
                    return ctx.getBaseLiteralClass().getName();
                }
                /*
                 * what we had here seems decidedly wrong! if (cls == null) { cls = type.getClass(); }

                // not sure if this is better, but it seems to be what other reasoners
                // do if the didn't have a java class registered, ala XMLLiteral
                if (cls == null)
                    cls = String.class;*/
                return cls.getName();
            }
        } catch (JastorException e) {
            e.printStackTrace();
            return isDatatypeProperty() ? ctx.getBaseLiteralClass().getName() : ctx.getThingInterface().getName();
        }
    }

    /**
     * Get the string representation of the full range datatype URI
     * 
     * @param res
     *            resource to get string representation
     * @return the string representation of the full range datatype URI
     */
    public String getRangeURI(Resource res) {
        if (res != null && res.equals(DEFAULT_RANGE)) {
            if (!ranges.isEmpty()) {
                return (ranges.get(0)).toString();
            } else {
                Resource propRange = getRange();
                if (propRange == null) {
                    if (isDatatypeProperty()) {
                        return RDFS.literal.toString();
                    } else {
                        return RDFS.RESOURCE.toString();
                    }
                }
                if (isDatatypeProperty() /*&& propRange instanceof BlankNode */) {
                    if (ontGraph.contains(propRange, RDF.TYPE, DataRange.TYPE)) {
                        // for now, assume that the oneOf contains all the same time.
                        DataRange dr = OWL11Factory.getDataRange(propRange, ontGraph);
                        Thing oneOf = dr.getOneOf();
                        if (oneOf != null) {
                            Iterable<Value> oneOfs = StatementUtils.getCollectionMembers(oneOf.resource(), ontGraph);
                            Iterator<Value> it = oneOfs.iterator();
                            while (it.hasNext()) {
                                Value val = it.next();
                                if (val instanceof Literal) {
                                    Literal lit = (Literal) val;

                                    if (lit instanceof TypedLiteral) {
                                        propRange = ((TypedLiteral) lit).getDatatypeURI();
                                    } else {
                                        propRange = XMLSchema.STRING;
                                    }
                                    continue;
                                }
                            }
                            return propRange.toString();
                        }
                    }
                }
                return propRange.toString();
            }
        } else if (res != null) {
            return res.toString();
        } else {
            return null;
        }
    }

    /**
     * Get the string representation of the full range datatype URI
     * 
     * @return the string representation of the full range datatype URI
     */
    public String getRangeURI() {
        return getRangeURI(DEFAULT_RANGE);
    }

    /**
     * Get the ontology class for the default range of this property
     * 
     * @return the ontology class for the default range of this property
     */
    public OntologyClass getRangeOntologyClass() {
        Resource propRange = getRange();
        return getRangeOntologyClass(propRange);
    }

    /**
     * Get the ontology class for the given range of this property
     * 
     * @param range
     *            indicates an alternative range or the DEFAULT_RANGE
     * @return the ontology class for the given range of this property
     */
    public OntologyClass getRangeOntologyClass(Resource range) {
        if (range != null && range.equals(DEFAULT_RANGE))
            return getRangeOntologyClass();
        if (isObjectProperty()) {
            if (range == null || range.equals(_Thing.TYPE) || range instanceof BlankNode) {
                return new OntologyClass(ctx); // OntologyClass for Thing
            } else {
                org.openanzo.rdf.owl.Class rangeclass = OWL11Factory.getClass(range, ctx.getOntGraph());
                if (rangeclass == null || !rangeclass.isRDFType(org.openanzo.rdf.owl.Class.TYPE))
                    return new OntologyClass(ctx);
                OntologyClass oc = new OntologyClass(rangeclass, ctx);
                return oc;
            }
        } else {
            return null;
        }
    }

    /**
     * Return a list of RDFNodes that are values of hasValue for this property
     * 
     * @return a list of RDFNodes that are values of hasValue for this property
     */
    public List<Value> getHasValueValues() {
        List<Value> list = new ArrayList<Value>();
        computePrimaryRestrictions();
        Iterator<Restriction> it = restrictions.iterator();
        while (it.hasNext()) {
            Restriction res = it.next();
            // have to find the hasValue values manually because the generated Jastor OWL classes
            // assume its always a datatype property
            Iterable<Statement> stmts = ontGraph.find(res.resource(), Restriction.hasValueProperty, null);
            for (Statement stmt : stmts) {
                list.add(stmt.getObject());
            }
        }
        return list;
    }

    /**
     * Set whether there can be duplicate properties
     * 
     * @param duplicateProperty
     *            whether there can be duplicate properties
     */
    public void setDuplicateProperty(boolean duplicateProperty) {
        this.duplicateProperty = duplicateProperty;
    }

    /**
     * Get the Property's URI
     * 
     * @return the Property's URI
     */
    public String getURI() {
        return ontProperty.resource().toString();
    }

    @Override
    public String toString() {
        return ontProperty.resource().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (isLooseRestriction())
            return super.equals(o); // test equality only on actual properties
        if (!(o instanceof OntologyProperty)) {
            return false;
        }
        OntologyProperty other = (OntologyProperty) o;
        return getURI().equals(other.getURI());
    }

    @Override
    public int hashCode() {
        if (isLooseRestriction())
            return super.hashCode();
        return getURI().hashCode();
    }

    /**
     * Capitalize the first letter of a String
     * 
     * @param string
     *            String to Capitalize
     * @return Capitalize version of string
     */
    private static String capitalize(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    /**
     * list all possible return types other than the originally defined range.
     * 
     * @param activeClassOnly
     *            determines whether we consider range restrictions declared in the activeClass or the entire hierarchy
     * @return
     */
    private List<Resource> listAlternativeRangesList(boolean activeClassOnly) {
        List<Resource> list = new ArrayList<Resource>();
        for (int i = restrictions.size() - 1; i >= 0; i--) {
            Restriction res = restrictions.get(i);
            if (activeClassOnly) {
                // check if the restriction belongs to the active class
                if (!activeClass.getOntClass().graph().contains(activeClass.getOntClass().resource(), RDFS.subClassOf, res.resource())) {
                    Thing intersectionOf = activeClass.getOntClass().getIntersectionOf();
                    if (intersectionOf != null) {
                        List<Resource> intersectionClasses = new ArrayList<Resource>();
                        for (Value value : StatementUtils.getCollectionMembers(intersectionOf.resource(), ontGraph)) {
                            if (value instanceof Resource) {
                                intersectionClasses.add((Resource) value);
                            }
                        }
                        if (!intersectionClasses.contains(res.resource()))
                            continue;
                    } else
                        continue;
                }
            }
            Iterable<Thing> allValuesFrom = res.getAllValuesFrom();
            Iterable<Thing> someValuesFrom = res.getAllValuesFrom();
            if (allValuesFrom.iterator().hasNext()) {
                for (Thing nextThing : allValuesFrom) {
                    Resource range = nextThing.resource();
                    Resource propRange = getRange();
                    if (propRange != null && propRange.equals(range)) {
                        continue;
                    }
                    if (ontGraph.contains(range, RDF.TYPE, DataRange.TYPE))
                        continue; // don't support DataRange yet
                    if (ontGraph.contains(range, OWL.ONEOF, null))
                        continue; // don't support owl:oneOf yet
                    if (ontGraph.contains(range, org.openanzo.rdf.owl.Class.unionOfProperty, null))
                        addUnionOperands(range, list);
                    else {
                        if (!list.contains(range))
                            list.add(range);
                    }
                }
            } else if (someValuesFrom.iterator().hasNext()) {
                for (Thing nextThing : someValuesFrom) {
                    Resource range = nextThing.resource();
                    Resource propRange = getRange();
                    if (propRange != null && propRange.equals(range)) {
                        continue;
                    }
                    if (ontGraph.contains(range, RDF.TYPE, DataRange.TYPE))
                        continue; // don't support DataRange yet
                    if (ontGraph.contains(range, org.openanzo.rdf.owl.Class.unionOfProperty, null))
                        addUnionOperands(range, list);
                    else {
                        if (!list.contains(range))
                            list.add(range);
                    }
                }
            }
        }
        return list;
    }

    private void addUnionOperands(Resource range, List<Resource> list) {
        Iterable<Statement> union = ontGraph.find(range, org.openanzo.rdf.owl.Class.unionOfProperty, null);
        for (Statement stmt : union) {
            if (stmt.getObject() instanceof Resource) {
                for (Value value : StatementUtils.getCollectionMembers((Resource) stmt.getObject(), ontGraph)) {
                    if (value instanceof Resource) {
                        ranges.add((Resource) value);
                    }
                }
            }
        }
    }

    /**
     * Find the restriction(s) on this property in the enclosing class. Will also look for a cardinality restriction in the subclasses if one is not found here
     * 
     * @throws JastorException
     */
    private void computePrimaryRestrictions() throws JastorException {

        Restriction[] baseRestrictions = ctx.getRestriction(ontClass.resource().toString(), ontProperty.resource().toString());
        if (baseRestrictions == null) {
            String query = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>  PREFIX owl: <http://www.w3.org/2002/07/owl#>  SELECT ?res WHERE {" + QueryEncoder.encodeForQuery(ontClass.resource()) + " rdfs:subClassOf ?res . ?res owl:onProperty " + QueryEncoder.encodeForQuery(ontProperty.resource()) + "}";

            QuadStoreEngineConfig config = new QuadStoreEngineConfig(ctx.getOntGraphQuadStore());
            Engine glitter = new Engine(config);

            try {

                long start = 0;
                if (RequestAnalysis.isAnalysisEnabled()) {
                    start = System.currentTimeMillis();
                }

                QueryResults results = glitter.executeQuery(null, query, Collections.singleton(ontGraph.getNamedGraphUri()), Collections.<URI> emptySet());

                Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                baseRestrictions = new Restriction[results.getSelectResults().size()];
                int i = 0;
                while (iter.hasNext()) {
                    Resource restrictionRes = (Resource) iter.next().getBinding("res");
                    Restriction restriction = OWL11Factory.getRestriction(restrictionRes, ontGraph);
                    baseRestrictions[i++] = restriction;
                }
                ctx.addRestriction(ontClass.resource().toString(), ontProperty.resource().toString(), baseRestrictions);
                if (RequestAnalysis.isAnalysisEnabled()) {
                    long end = System.currentTimeMillis();
                    RequestAnalysis.incrementAnalysisPropertyCount("cardQuery", end - start);
                }

            } catch (Exception e) {
                throw new JastorException(e, "Error querying for restriction");
            }
        }

        Restriction cardrestriction = null;
        for (Restriction restriction : baseRestrictions) {
            Iterable<Integer> res = restriction.getCardinality();
            if (res.iterator().hasNext()) {
                cardrestriction = restriction;
            }
            restrictions.add(restriction);
        }

        if (cardrestriction == null && ctx.isSearchSubClassHierarchyForCardRes()) {
            cardrestriction = ontologyClass.findCardinalityRestrictionInSubClassHierarchy(this);
        }
        if (cardrestriction != null) {
            restrictions.add(cardrestriction);
        }

    }

    private String addPrefix(String name) {
        String prefix = ctx.getNamespacePrefix(((URI) ontProperty.resource()).getNamespace());
        return prefix + "_" + name;
    }

    /**
     * Determine if this property has multiple ranges defined in the base declaration of the property. Note, this is different from multiple ranges via-all
     * values from.
     */
    private void checkForMultipleBaseRanges() {

        Resource range = getRange();
        if (range != null && range instanceof BlankNode) {
            org.openanzo.rdf.owl.Class clazz = OWL11Factory.getClass(range, ontGraph);
            Thing union = clazz.getUnionOf();
            if (union != null) {
                for (Value value : StatementUtils.getCollectionMembers(union.resource(), ontGraph)) {
                    if (value instanceof Resource) {
                        ranges.add((Resource) value);
                    }
                }
            }
        }
    }

    private Resource getRange() {
        Thing range = getRange(ontProperty);
        if (range != null) {
            return range.resource();
        }
        return null;
    }

    /**
     * Get the range bean for the given property
     * 
     * @param ontProperty
     *            property to get bean
     * @return the range bean for given property
     */
    public static Thing getRange(_Property ontProperty) {
        return ontProperty.getRange();
    }

    /**
     * Get the domain bean for the given property
     * 
     * @param ontProperty
     *            property to get bean
     * @return the domain bean for given property
     */
    public static org.openanzo.rdf.rdfs.Class getDomain(_Property ontProperty) {
        return ontProperty.getDomain();
    }

    /**
     * Set the range bean for the given property
     * 
     * @param ontProperty
     *            property to get bean
     * @param range
     *            the range resource to set
     */
    public static void setRange(_Property ontProperty, Resource range) {
        ontProperty.setRange(range);
    }

    /**
     * Set the domain bean for the given property
     * 
     * @param ontProperty
     *            property to get bean
     * @param domain
     *            the domain resource to set
     */
    public static void setDomain(_Property ontProperty, Resource domain) {
        ontProperty.setDomain(domain);
    }
}
