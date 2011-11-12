/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/inference/OntologyClass.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: OntologyClass.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.inference;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.JastorException;
import org.openanzo.rdf.jastor.JavaIdentifierEncoder;
import org.openanzo.rdf.jastor.Thing;
import org.openanzo.rdf.owl.DatatypeProperty;
import org.openanzo.rdf.owl.OWL11Factory;
import org.openanzo.rdf.owl.ObjectProperty;
import org.openanzo.rdf.owl.Restriction;
import org.openanzo.rdf.owl._Thing;
import org.openanzo.rdf.owl.utils.OntologyUtils;
import org.openanzo.rdf.query.QuadStoreEngineConfig;
import org.openanzo.rdf.query.QueryEncoder;
import org.openanzo.rdf.rdfs._Property;
import org.openanzo.rdf.utils.StatementUtils;
import org.openanzo.rdf.vocabulary.OWL;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.rdf.vocabulary.RDFS;

/**
 * 
 * This class is a wrapper for an ontology class. Most of the time, the containing ontology class is a name classes but occasionally, instances are internally
 * used as place holders for restrictions.
 * 
 * @author Ben Szekely ( <a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com </a>)
 * 
 */
public class OntologyClass {

    private final org.openanzo.rdf.owl.Class ontClass;

    private final INamedGraph                ontGraph;

    private final JastorContext              ctx;

    private final OntologyComment            comment;

    /**
     * Construct a new OntologyClass to represent a Thing. Such instances will not contain an org.openanzo.owl.Class, but will return basic naming questions.
     * Several methods such as listProperties will never be called on such an instance so we leave them unmodified. In particular, the file name generation
     * routines will generate a file for Thing as though it resided with the generated classes. This is wrong, but OK, since such methods will never be called.
     * 
     * @param ctx
     *            parent context for this class
     */
    public OntologyClass(JastorContext ctx) {
        this.ctx = ctx;
        this.ontGraph = ctx.getOntGraph();
        comment = null;
        ontClass = null;
    }

    /**
     * Construct an OntologyClass wrapper around the given org.openanzo.owl.Class. This org.openanzo.owl.Class can be an anonymous restriction on a property in
     * which case the listProperties call will return the restricted property
     * 
     * @param ontClass
     *            Jastor class bean
     * @param ctx
     *            parent context for this class
     */
    public OntologyClass(org.openanzo.rdf.owl.Class ontClass, JastorContext ctx) {
        this.ontClass = ontClass;
        this.ctx = ctx;
        ontGraph = ctx.getOntGraph();
        this.comment = OntologyComment.getOntologyComment(ctx.getOntGraph(), ontClass.resource());
    }

    /**
     * Get the context for this ontology
     * 
     * @return the context for this ontology
     */
    public JastorContext getContext() {
        return ctx;
    }

    /**
     * Get the Jastor Class bean for this class
     * 
     * @return the Jastor Class bean for this class
     */
    public org.openanzo.rdf.owl.Class getOntClass() {
        return ontClass;
    }

    /**
     * Get the URI for this class
     * 
     * @return the URI for this class
     */
    public URI getURI() {
        if (ontClass == null)
            return RDFS.RESOURCE;
        return (URI) ontClass.resource();
    }

    /**
     * Get the local name of this classes uri
     * 
     * @return the local name of this classes uri
     */
    public String getLocalName() {
        if (ontClass == null)
            return RDFS.RESOURCE.getLocalName();
        return ((URI) ontClass.resource()).getLocalName();
    }

    /**
     * Get the comment for this class
     * 
     * @return the comment for this class
     */
    public OntologyComment getComment() {
        return comment;
    }

    @Override
    public String toString() {
        if (ontClass == null)
            return RDFS.RESOURCE.toString();
        return ontClass.uri();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OntologyClass))
            return false;
        OntologyClass oc = (OntologyClass) o;
        return oc.getOntClass().equals(getOntClass());
    }

    @Override
    public int hashCode() {
        return getOntClass().hashCode();
    }

    /**
     * Return a string that can be used to represent one of these as an instance variable
     * 
     * @return a string that can be used to represent one of these as an instance variable
     */
    public String getVariableName() {
        String ret = getInterfaceClassname();
        String first = ret.substring(0, 1).toLowerCase();
        return first + ret.substring(1);
    }

    /**
     * Get the full classname for this class's interface
     * 
     * @return the full classname for this class's interface
     */
    public String getInterfaceFullClassname() {
        if (ontClass == null)
            return ctx.getThingInterface().getName();
        Resource uri = getURI();
        String pkg = ctx.getPackageForClass(uri);
        if (ctx.isUseEntireURIForIdentifiers())
            return pkg + "." + JavaIdentifierEncoder.encode(uri.toString());
        else
            return pkg + "." + JavaIdentifierEncoder.encode(getLocalName());
    }

    /**
     * Get the full classname for this class's implementation
     * 
     * @return the full classname for this class's implementation
     */
    public String getImplFullClassname() {
        return getInterfaceFullClassname() + "Impl";
    }

    /**
     * Get the full classname for this class's listener
     * 
     * @return the full classname for this class's listener
     */
    public String getListenerFullClassname() {
        return getInterfaceFullClassname() + "Listener";
    }

    /**
     * Get the full classname for this class's listener adapter
     * 
     * @return the full classname for this class's listener adapter
     */
    public String getListenerAdapterFullClassname() {
        return getInterfaceFullClassname() + "ListenerAdapter";
    }

    /**
     * Get the file for this class's interface
     * 
     * @param baseDir
     *            directory where file is to be created
     * @return the file for this class's interface
     */
    public File getInterfaceFile(File baseDir) {
        return new File(baseDir, getInterfaceFullClassname().replace('.', '/') + ".java");
    }

    /**
     * Get the file for this class's implementation
     * 
     * @param baseDir
     *            directory where file is to be created
     * @return the file for this class's implementation
     */
    public File getImplFile(File baseDir) {
        return new File(baseDir, getImplFullClassname().replace('.', '/') + ".java");
    }

    /**
     * Get the file for this class's listener
     * 
     * @param baseDir
     *            directory where file is to be created
     * @return the file for this class's listener
     */
    public File getListenerFile(File baseDir) {
        return new File(baseDir, getListenerFullClassname().replace('.', '/') + ".java");
    }

    /**
     * Get the classname for this class's interface
     * 
     * @return the classname for this class's interface
     */
    public String getInterfaceClassname() {
        return getInterfaceFullClassname().substring(getInterfaceFullClassname().lastIndexOf('.') + 1);
    }

    /**
     * Get the classname for this class's implementation
     * 
     * @return the classname for this class's implementation
     */
    public String getImplClassname() {
        return getImplFullClassname().substring(getImplFullClassname().lastIndexOf('.') + 1);
    }

    /**
     * Get the classname for this class's listener
     * 
     * @return the classname for this class's listener
     */
    public String getListenerClassname() {
        return getListenerFullClassname().substring(getListenerFullClassname().lastIndexOf('.') + 1);
    }

    /**
     * Get the classname for this class's listener adapter
     * 
     * @return the classname for this class's listener adapter
     */
    public String getListenerAdapterClassname() {
        return getListenerAdapterFullClassname().substring(getListenerAdapterFullClassname().lastIndexOf('.') + 1);
    }

    /**
     * Get the package name for the class
     * 
     * @return the package name for the class
     */
    public String getPackageName() {
        return ctx.getPackageForClass(getURI());
    }

    /**
     * Get the full classname for this class's parent factory
     * 
     * @return the full classname for this class's parent factory
     */
    public String getFactoryFullClassname() {
        if (ontClass == null) {
            return ctx.getThingFactory().getName();
        }
        URI ontres = ctx.getOntologyForClass(getURI());
        // String pkg = ctx.getPackageForOntology(onturi);
        String pkg = getPackageName();
        String classname = null;
        if (ctx.isUseEntireURIForIdentifiers())
            classname = pkg + "." + JavaIdentifierEncoder.encode(ontres.toString()) + "Factory";
        else {
            if (ontres.getLocalName() == null) {
                System.err.println("ontres null: " + ontres);
                System.err.println(RDF.TYPE);
            }
            classname = pkg + "." + JavaIdentifierEncoder.encode(ontres.getLocalName()) + "Factory";
        }
        return classname;
    }

    /**
     * Get the classname for this class's parent factory
     * 
     * @return the classname for this class's parent factory
     */
    public String getFactoryClassname() {
        return getFactoryFullClassname().substring(getFactoryFullClassname().lastIndexOf('.') + 1);
    }

    /**
     * Get the file for this class's parent factory
     * 
     * @param baseDir
     *            directory where file is to be created
     * @return the file for this class's parent factory
     */
    public File getFactoryFile(File baseDir) {
        return new File(baseDir, getFactoryFullClassname().replace('.', '/') + ".java");
    }

    private List<OntologyProperty> propertyListWithExtensionClasses = null;

    private List<OntologyProperty> propertyListNoExtensionClasses   = null;

    /**
     * Get list of OntologyProperties for the class
     * 
     * @param includeExtensionClasses
     *            whether or not to include properties in extensions from subClassOf, interesectionOf, and unionOf
     * @return list of OntologyProperties for the class
     */
    public List<OntologyProperty> listProperties(boolean includeExtensionClasses) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            if (includeExtensionClasses && propertyListWithExtensionClasses != null)
                return propertyListWithExtensionClasses;
            if (!includeExtensionClasses && propertyListNoExtensionClasses != null)
                return propertyListNoExtensionClasses;
            try {
                List<OntologyProperty> props = listProperties(includeExtensionClasses, new ArrayList<org.openanzo.rdf.owl.Class>());
                List<OntologyProperty> allprops = null;
                if (includeExtensionClasses)
                    allprops = props;
                else {
                    allprops = listProperties(true, new ArrayList<org.openanzo.rdf.owl.Class>());
                    purgeLooseRestrictions(allprops);
                }
                purgeLooseRestrictions(props);
                markDuplicates(props, allprops);
                if (includeExtensionClasses)
                    propertyListWithExtensionClasses = props;
                else
                    propertyListNoExtensionClasses = props;
                return props;
            } catch (JastorException e) {
                e.printStackTrace();
                return new ArrayList<OntologyProperty>();
            }
        } finally {
            if (RequestAnalysis.isAnalysisEnabled()) {
                long end = System.currentTimeMillis();
                RequestAnalysis.incrementAnalysisPropertyCount("listProps", (end - start));
            }
        }
    }

    /**
     * Get a deep listing of all named extension classes. Unfortunately, we can't use this routine to do much, but we do use to generate type-closure code.
     * 
     * @return list of all classes that extend this class
     */
    public List<OntologyClass> listAllExtensionClasses() {
        try {
            List<org.openanzo.rdf.owl.Class> visited = new ArrayList<org.openanzo.rdf.owl.Class>();
            return listAllExtensionClasses(visited);
        } catch (JastorException e) {
            e.printStackTrace();
            return new ArrayList<OntologyClass>();
        }
    }

    /**
     * Get a list of immediate extension classes derived from subClassOf, intersectionOf and unionOf
     * 
     * @return a list of immediate extension classes derived from subClassOf, intersectionOf and unionOf
     */
    public List<OntologyClass> listImmediateExtensionClasses() {
        try {
            return listImmediateExtensionClasses(new ArrayList<org.openanzo.rdf.owl.Class>(), false);
        } catch (JastorException e) {
            e.printStackTrace();
            return new ArrayList<OntologyClass>();
        }
    }

    /**
     * Finds a cardinality restriction in sub-class hierarchy for the given property. This method is needed because some super-classes won't specify a range,
     * but all of there subclasses will have the same (hopefully) restriction. If not, this approach will surely break.
     * 
     * @param prop
     *            property to check
     * @return Restriction for this property in the classes hierarchy
     * @throws JastorException
     */
    protected Restriction findCardinalityRestrictionInSubClassHierarchy(OntologyProperty prop) throws JastorException {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            Restriction[] resHolder = ctx.getSubClassRestriction(getURI().toString(), prop.getURI());
            if (resHolder != null) {
                return resHolder[0];
            }

            List<org.openanzo.rdf.rdfs.Class> subClasses = OntologyUtils.getSubClasses(ontClass, false);
            // if this a union class, one of its operands might have
            // a cardinality restriction. Since they are subclassing us,
            // we should have the same restriction as well.
            // TODO: we may need to included subclasses that are Unions as well, though
            // we have never encountered a case of this.  So we'd probably want to
            // move the union case into getSubClasses
            // TODO: we may also need to check for classes that include this class as an 
            // intersection.  
            Thing unionOf = ontClass.getUnionOf();
            if (unionOf != null) {
                for (Value value : StatementUtils.getCollectionMembers(unionOf.resource(), ontGraph)) {
                    if (value instanceof URI) {
                        org.openanzo.rdf.owl.Class oc = OWL11Factory.getClass((URI) value, ontGraph);
                        subClasses.add(oc);
                    }
                }
            }
            List<org.openanzo.rdf.owl.Class> visited = new ArrayList<org.openanzo.rdf.owl.Class>();
            visited.add(ontClass);
            Restriction res = null;
            for (org.openanzo.rdf.rdfs.Class c : subClasses) {
                if (c.isRDFType(org.openanzo.rdf.owl.Class.TYPE)) {
                    if (!visited.contains(c)) {
                        org.openanzo.rdf.owl.Class cc = OWL11Factory.getClass(c.resource(), c.graph());
                        visited.add(cc);
                        OntologyClass oc = new OntologyClass(cc, ctx);
                        res = oc.findCardinalityRestrictionInSubClassHierarchy(prop, visited);
                        if (res != null) {
                            break;
                        }
                    }
                }
            }
            ctx.addSubClassRestriction(getURI().toString(), prop.getURI(), res);
            return res;
        } finally {
            if (RequestAnalysis.isAnalysisEnabled()) {
                long end = System.currentTimeMillis();
                RequestAnalysis.incrementAnalysisPropertyCount("findCardResSubClass", (end - start));
            }
        }
    }

    /**
     * List all individuals for this type
     * 
     * @return all individuals for this type
     */
    public List<Resource> listIndividuals() {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        ArrayList<Resource> list = new ArrayList<Resource>();
        Iterable<Statement> stmts = ontGraph.find(null, RDF.TYPE, getOntClass().resource());
        for (Statement stmt : stmts) {
            Resource subject = stmt.getSubject();
            // protect against generating individuals for RDFS and OWL ontologies
            if (subject instanceof URI) {
                URI suburi = (URI) subject;
                if (suburi.getNamespace().equals(RDFS.NAMESPACE) || suburi.getNamespace().equals(OWL.NAMESPACE) || suburi.getNamespace().equals(RDF.NAMESPACE)) {
                    continue;
                }
                list.add(subject);
            }
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("listIndividuals", (end - start));
        }
        return list;
    }

    /**
     * Get the identifier name for the given individual
     * 
     * @param ind
     *            resource of individual
     * @return the identifier name for the given individual
     */
    public String getIndividualIdentifierName(Resource ind) {
        if (individualDuplicateLocalName(ind)) {
            return JavaIdentifierEncoder.encode(ind.toString());
        } else {
            if (ind instanceof BlankNode) {
                return JavaIdentifierEncoder.encode(ind.toString());
            } else {
                return JavaIdentifierEncoder.encode(((URI) ind).getLocalName());
            }
        }
    }

    /**
     * Is this an enumerated class
     * 
     * @return true if this an enumerated class
     */
    public boolean isEnumeratedClass() {
        return (ontClass.getOneOf() != null);
    }

    /**
     * Return the oneOf classes
     * 
     * @return the oneOf classes
     */
    public List<Resource> listOneOfClasses() {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        Thing oneOf = ontClass.getOneOf();
        List<Resource> list = new ArrayList<Resource>();
        for (Value value : StatementUtils.getCollectionMembers(oneOf.resource(), ontGraph)) {
            if (value instanceof Resource) {
                list.add((Resource) value);
            }
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("listOneOf", (end - start));
        }
        return list;
    }

    private boolean individualDuplicateLocalName(Resource ind) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            Iterable<Statement> stmts = ontGraph.find(null, RDF.TYPE, getOntClass().resource());
            boolean found = false;
            for (Statement stmt : stmts) {
                if (ind instanceof URI && stmt.getSubject() instanceof URI) {
                    URI subject = (URI) stmt.getSubject();
                    if (subject.getLocalName().equals(((URI) ind).getLocalName())) {
                        if (found)
                            return true;
                        else
                            found = true;
                    }
                } else if (ind instanceof BlankNode && stmt.getSubject() instanceof BlankNode) {
                    BlankNode subject = (BlankNode) stmt.getSubject();
                    if (subject.equals(ind)) {
                        if (found)
                            return true;
                        else
                            found = true;
                    }
                }
            }
            return false;
        } finally {
            if (RequestAnalysis.isAnalysisEnabled()) {
                long end = System.currentTimeMillis();
                RequestAnalysis.incrementAnalysisPropertyCount("indDupLocalname", (end - start));
            }
        }
    }

    private Restriction findCardinalityRestrictionInSubClassHierarchy(OntologyProperty prop, List<org.openanzo.rdf.owl.Class> visited) throws JastorException {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        String query = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>  PREFIX owl: <http://www.w3.org/2002/07/owl#>  SELECT ?res WHERE {" + QueryEncoder.encodeForQuery(ontClass.resource()) + " rdfs:subClassOf ?res . ?res owl:onProperty " + QueryEncoder.encodeForQuery(prop.getOntProperty().resource()) + "}";
        QuadStoreEngineConfig config = new QuadStoreEngineConfig(ctx.getOntGraphQuadStore());
        Engine glitter = new Engine(config);
        try {
            QueryResults results = glitter.executeQuery(null, query, Collections.singleton(ontGraph.getNamedGraphUri()), Collections.<URI> emptySet());
            Iterator<PatternSolution> iter = results.getSelectResults().iterator();
            while (iter.hasNext()) {
                PatternSolution next = iter.next();
                Resource restrictionRes = (Resource) next.getBinding("res");
                if (restrictionRes != null) {
                    Restriction restriction = OWL11Factory.getRestriction(restrictionRes, ontGraph);
                    Iterable<Integer> res = restriction.getCardinality();
                    if (res.iterator().hasNext()) {
                        return restriction;
                    }

                    Iterable<Integer> res2 = restriction.getMaxCardinality();
                    if (res2.iterator().hasNext()) {
                        return restriction;
                    }

                }
            }
        } catch (Exception e) {
            throw new JastorException(e, "Error querying for restriction");
        }
        //        List<org.openanzo.rdf.rdfs.Class> subClasses = OntologyUtils.getSubClasses(ontClass, false);
        //        Restriction restriction = null;
        //        for (org.openanzo.rdf.rdfs.Class c : subClasses) {
        //            if (c.isRDFType(org.openanzo.rdf.owl.Class.TYPE)) {
        //                org.openanzo.rdf.owl.Class subClass = OWL11Factory.getClass(c.resource(), c.graph());
        //                if (!visited.contains(subClass) && restriction == null) {
        //                    OntologyClass oc = new OntologyClass(subClass, ctx);
        //                    restriction = oc.findCardinalityRestrictionInSubClassHierarchy(prop, visited);
        //                }
        //            }
        //        }
        //        return restriction;
        finally {
            if (RequestAnalysis.isAnalysisEnabled()) {
                long end = System.currentTimeMillis();
                RequestAnalysis.incrementAnalysisPropertyCount("findCardSubInternal", (end - start));
            }
        }
        return null;
    }

    private final HashMap<String, List<OntologyProperty>> listCache = new HashMap<String, List<OntologyProperty>>();

    private List<OntologyProperty> listProperties(boolean includeExtensionClasses, List<org.openanzo.rdf.owl.Class> visitedClasses) throws JastorException {
        String cacheKey = String.valueOf(includeExtensionClasses + visitedClasses.toString());
        List<OntologyProperty> cachedList = listCache.get(cacheKey);
        if (cachedList != null) {
            return cachedList;
        }
        ArrayList<OntologyProperty> list = new ArrayList<OntologyProperty>();
        // we may have visited this class since it was queued up to search. So just add
        // a final cycle check as a catch-all
        if (visitedClasses.contains(ontClass))
            return list;
        visitedClasses.add(ontClass);
        // add properties from immediate superclasses and unions (which will
        // themselves, recurse)
        if (includeExtensionClasses) {
            List<OntologyClass> extClasses = listImmediateExtensionClasses(visitedClasses, false);
            Iterator<OntologyClass> it = extClasses.iterator();
            while (it.hasNext()) {
                OntologyClass extClass = it.next();
                if (!(extClass.getOntClass() instanceof BlankNode)) {
                    List<OntologyProperty> extClassProperties = extClass.listProperties(true, visitedClasses);
                    // this call overwrites the role made in any recursive call
                    // because we only care about role from the perspective of the root
                    // caller
                    setRoleOfProperties(extClassProperties, OntologyProperty.ROLE_EXTENSIONCLASS);
                    // must check for duplicates
                    Iterator<OntologyProperty> itr = extClassProperties.iterator();
                    while (itr.hasNext()) {
                        OntologyProperty extprop = itr.next();
                        if (!list.contains(extprop))
                            list.add(extprop);
                    }
                }
            }
            // merge loose restrictions with actual properties
            mergeProperties(list);
        }
        // check for any restrictions declared here that may apply to properties
        // from extension classes. Restrictions are contained in anonymous
        // extension classes
        // note, we moved this outside the include extension class case because want to get union domain properties
        // in both cases. Even though union domains are handled elsewhere, we keep this code outside that condition
        Iterator<OntologyClass> it = listImmediateExtensionClasses(visitedClasses, true).iterator();
        while (it.hasNext()) {
            OntologyClass extClass = it.next();
            if (extClass.getOntClass().isRDFType(Restriction.TYPE)) {
                Restriction res = OWL11Factory.createRestriction(extClass.getOntClass().resource(), ontGraph);
                _Property prop = res.getOnProperty();
                if (prop == null) {
                    System.err.println("Warning: class " + getOntClass().resource() + " has restrictions on unknown properties");
                    continue;
                }
                Iterator<OntologyProperty> itr2 = list.iterator();
                OntologyProperty restrictedProp = null;
                // iterate through the list of properties found so far and see if there is one
                // the restriction applies to
                while (itr2.hasNext()) {
                    OntologyProperty op = itr2.next();
                    if (op.getOntProperty().resource().equals(prop.resource())) {
                        restrictedProp = op;
                        break;
                    }
                }
                // add the restriction to the proprety..will be dealt with by
                // the property
                if (restrictedProp != null)
                    restrictedProp.addRestriction(res);
                // if we didn't find a property in the extension classes for the restriction,
                // we have a few choices to make...
                else {
                    org.openanzo.rdf.rdfs.Class domain = OntologyProperty.getDomain(prop);
                    if (domain != null && domain.resource() instanceof BlankNode && domain.isRDFType(org.openanzo.rdf.owl.Class.TYPE) && (OWL11Factory.getClass(domain.resource(), ontGraph).getUnionOf() != null)) {
                        // ignore restrictions on union domains, they are taken care of below
                    } else if (domain == null || domain.resource().equals(RDFS.RESOURCE)) {
                        // if the domain is null, then we have a property with no declared domain. Although, we suspect
                        // this is not good OWL, we allow the user to do it anyway and assume the user wants to have
                        // this class as a possible domain.
                        list.add(new OntologyProperty(prop, this));
                    } else if (domain instanceof BlankNode || !domain.resource().equals(ontClass.resource())) {
                        // add a placeholder for this restriction if it doesn't belong to us. This restriction
                        // will get added to the property from another branch of the type-hierarchy.
                        list.add(new OntologyProperty(prop, res));
                    } else {
                        // In rare cases, a restriction might be added to this property through
                        // an Intersection, not subclass. This handles that case.
                        Thing intersectionOf = getOntClass().getIntersectionOf();
                        if (intersectionOf != null) {
                            // if one of the operands is the restriction we are considering
                            // then add the restricted property and the restriction
                            for (Value value : StatementUtils.getCollectionMembers(intersectionOf.resource(), ontGraph))
                                if (value instanceof Resource) {
                                    org.openanzo.rdf.owl.Class op = OWL11Factory.getClass((Resource) value, ontGraph);
                                    if (op.equals(res)) {
                                        OntologyProperty property = new OntologyProperty(prop, this);
                                        // add the restriction because getPrimaryRestriction in the constructor won't
                                        // find it.
                                        property.addRestriction(res);
                                        list.add(property);
                                    }
                                }
                        }
                    }
                } // otherwise, we have a normal restriction on a declared or union domain property,
                // handeled below
            }
        }
        // end restriction search
        // finally, add properties declared here
        List<_Property> declprops = new ArrayList<_Property>();

        List<OntologyProperty> udps = ctx.getUnionDomainProperties(getURI());
        for (OntologyProperty prop : udps) {
            declprops.add(prop.getOntProperty());
        }

        // FIND DECLARED PROPERTIES
        List<_Property> itr = findDeclaredProperties();
        for (_Property prop : itr) {
            declprops.add(prop);
        }
        addOpenDomainProperties(declprops);
        for (_Property prop : declprops) {
            // make sure that if we have an open domain property
            // that it is defined in this ontology..skip it otherwise
            org.openanzo.rdf.rdfs.Class domain = OntologyProperty.getDomain(prop);
            if (domain == null || domain.resource().equals(RDFS.RESOURCE) || domain.equals(_Thing.TYPE)) {
                // have to also check if the class of the property is defined in an ontology of any extension class
                boolean includeODP = ctx.isPropetyAndClassDefinedInSameOntology(prop.resource(), getURI());
                if (!includeODP) {
                    for (OntologyClass extClass : listAllExtensionClasses()) {
                        if (ctx.isPropetyAndClassDefinedInSameOntology(prop.resource(), extClass.getURI())) {
                            includeODP = true;
                            break;
                        }
                    }
                }
                if (!includeODP)
                    continue;
            }
            // more efficient to scan the list than construct an OntologyProperty unnecessarily
            // to check for List membership because the constructor does a query.
            boolean found = false;
            Iterator<OntologyProperty> props = list.iterator();
            while (props.hasNext() && !found) {
                OntologyProperty p = props.next();
                if (p.getOntProperty().resource().equals(prop.resource()))
                    found = true;
            }
            if (!found) {
                OntologyProperty prop2 = new OntologyProperty(prop, this);
                list.add(prop2);
            }
        }
        listCache.put(cacheKey, list);
        return list;
    }

    /**
     * compute a list of _Property that have no domain, or domain of Resource or Thing
     */
    private void addOpenDomainProperties(List<_Property> propertyList) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        List<_Property> odProps = ctx.getOpenDomainProperties();
        for (_Property prop : odProps) {
            if (!propertyList.contains(prop)) {
                propertyList.add(prop);
            }
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("addODProps", (end - start));
        }
    }

    private List<OntologyClass> listAllExtensionClasses(List<org.openanzo.rdf.owl.Class> visited) throws JastorException {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        visited.add(ontClass);
        List<OntologyClass> scs = listImmediateExtensionClasses(visited, false);
        List<OntologyClass> recur = new ArrayList<OntologyClass>();
        Iterator<OntologyClass> it = scs.iterator();
        while (it.hasNext()) {
            OntologyClass oc = it.next();
            if (!visited.contains(oc.getOntClass())) {
                List<OntologyClass> list = oc.listAllExtensionClasses(visited);
                for (int i = 0; i < list.size(); i++) {
                    if (!recur.contains(list.get(i))) {
                        recur.add(list.get(i));
                    }
                }
            }
        }
        recur.addAll(scs);
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("listAllExt", (end - start));
        }
        return recur;
    }

    private List<OntologyClass> listImmediateExtensionClasses(List<org.openanzo.rdf.owl.Class> visited, boolean includeAnon) throws JastorException {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        // get classes from subClassOf
        List<OntologyClass> list = listImmediateSuperClasses(visited, includeAnon);
        // get classes from other side of unionOf
        List<OntologyClass> list2 = listImmediateUnionClasses(visited);
        for (int i = 0; i < list2.size(); i++) {
            if (!list.contains(list2.get(i)))
                list.add(list2.get(i));
        }
        // get classes from intersectionOf
        list2 = listImmediateIntersectionClasses(visited, includeAnon);
        for (int i = 0; i < list2.size(); i++) {
            if (!list.contains(list2.get(i)))
                list.add(list2.get(i));
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("listImmExt", (end - start));
        }
        return list;
    }

    private List<OntologyClass> listImmediateSuperClasses(List<org.openanzo.rdf.owl.Class> visited, boolean includeAnon) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        Iterable<org.openanzo.rdf.rdfs.Class> subClassOf = ontClass.getSubClassOf();
        ArrayList<OntologyClass> list = new ArrayList<OntologyClass>();
        for (org.openanzo.rdf.rdfs.Class ontClass : subClassOf) {
            if (!includeAnon && ontClass.resource() instanceof BlankNode)
                continue;
            //if (!includeAnon && ((URI) ontClass.resource()).getLocalName() != null && ((URI) ontClass.resource()).getLocalName().equals("Resource"))
            //  continue;
            if (ontClass.resource() != null && ontClass.resource().equals(_Thing.TYPE))
                continue;
            if (visited.contains(ontClass))
                continue;
            if (ontClass.resource().toString().indexOf("EconomicDemographic") != -1) {
                System.err.println(ontClass);
            }
            if (!ontClass.isRDFType(org.openanzo.rdf.owl.Class.TYPE) && !includeAnon) {
                continue;
            }
            OntologyClass oc = new OntologyClass(OWL11Factory.getClass(ontClass.resource(), ontGraph), ctx);
            list.add(oc);
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("listImmSc", (end - start));
        }
        return list;
    }

    /**
     * This method not returns a list of classes that are a union of us because those are what we want to extend
     * 
     * @param visited
     * @return
     */
    private List<OntologyClass> listImmediateUnionClasses(List<org.openanzo.rdf.owl.Class> visited) throws JastorException {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        Iterator<OntologyClass> itr = ctx.getUnionClassExtensions(getURI()).iterator();
        ArrayList<OntologyClass> list = new ArrayList<OntologyClass>();
        while (itr.hasNext()) {
            OntologyClass ontologyClass = itr.next();
            if (visited.contains(ontologyClass.getOntClass()))
                continue;
            list.add(ontologyClass);
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("listImmUnion", (end - start));
        }
        return list;
    }

    private List<OntologyClass> listImmediateIntersectionClasses(List<org.openanzo.rdf.owl.Class> visited, boolean includeAnon) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        List<OntologyClass> list = new ArrayList<OntologyClass>();
        Thing intersectionOf = ontClass.getIntersectionOf();
        if (intersectionOf != null) {
            for (Value value : StatementUtils.getCollectionMembers(intersectionOf.resource(), ontGraph)) {
                if (value instanceof Resource) {
                    org.openanzo.rdf.owl.Class rangeClazz = OWL11Factory.getClass((Resource) value, ontGraph);
                    if (value instanceof BlankNode) {
                        if (includeAnon) {
                            list.add(new OntologyClass(rangeClazz, ctx));
                        }
                    } else {
                        list.add(new OntologyClass(rangeClazz, ctx));
                    }
                }
            }
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("listImmIntx", (end - start));
        }
        return list;
    }

    /**
     * Merge any loose restriction properties into the property it comes from
     * 
     * @param props
     */
    private void mergeProperties(List<OntologyProperty> props) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        // this is innefficient, but the size of these lists should be small.
        // this list stores loose restrictions that cannot be merged at this
        // level and must be passed down to
        // the calling subclass or union class.
        List<OntologyProperty> unboundlr = new ArrayList<OntologyProperty>();
        OntologyProperty lr = findLooseRestriction(props);
        while (lr != null) {
            props.remove(lr);
            OntologyProperty prop = findRealProp(props, lr);
            if (prop == null) // not sure about this...will follow up later.
                unboundlr.add(lr);
            else
                prop.addRestrictions(lr.getRestrictions());
            lr = findLooseRestriction(props);
        }
        props.addAll(unboundlr);
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("mergeProps", (end - start));
        }
    }

    /**
     * Find a real property for a loose restriction
     */
    private OntologyProperty findRealProp(List<OntologyProperty> props, OntologyProperty lr) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            for (OntologyProperty prop : props) {
                if (prop.isLooseRestriction())
                    continue;
                if (prop.getURI().equals(lr.getURI())) {
                    return prop;
                }
            }
            return null;
        } finally {
            if (RequestAnalysis.isAnalysisEnabled()) {
                long end = System.currentTimeMillis();
                RequestAnalysis.incrementAnalysisPropertyCount("findRealProp", (end - start));
            }
        }
    }

    /**
     * returns a loose restriction if one exists
     * 
     * @return
     */
    private OntologyProperty findLooseRestriction(List<OntologyProperty> props) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            for (OntologyProperty prop : props) {
                if (prop.isLooseRestriction()) {
                    return prop;
                }
            }
        } finally {
            if (RequestAnalysis.isAnalysisEnabled()) {
                long end = System.currentTimeMillis();
                RequestAnalysis.incrementAnalysisPropertyCount("findLR", (end - start));
            }
        }
        return null;
    }

    /**
     * remove any loose restrictions from this property list
     * 
     * @param props
     */
    private void purgeLooseRestrictions(List<OntologyProperty> props) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        Iterator<OntologyProperty> it = props.iterator();
        while (it.hasNext()) {
            OntologyProperty prop = it.next();
            if (prop.isLooseRestriction()) {
                // /System.err.println("removing loose res: " + prop);
                it.remove();
            }
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("purgeLR", (end - start));
        }
    }

    /**
     * Set the role of the all the given properties. Also make this OntologyClass the activeClass
     * 
     * @param props
     * @param role
     */
    private void setRoleOfProperties(List<OntologyProperty> props, int role) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        for (OntologyProperty prop : props) {
            prop.setRole(role);
            prop.setActiveClass(this);
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("setRole", (end - start));
        }
    }

    /**
     * Go through the list of properties and mark any properties as duplicates...
     */
    private void markDuplicates(List<OntologyProperty> props, List<OntologyProperty> allprops) {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        for (int i = 0; i < allprops.size(); i++) {
            OntologyProperty propi = allprops.get(i);
            String namei = propi.getPropertyName();
            for (int j = 0; j < props.size(); j++) {
                OntologyProperty propj = props.get(j);
                String namej = propj.getPropertyName();
                if (!propi.getURI().equals(propj.getURI()) && namei.equals(namej)) {
                    propj.setDuplicateProperty(true);
                }
            }
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("markDup", (end - start));
        }
    }

    static Set<Resource> calls = new HashSet<Resource>();

    private List<_Property> findDeclaredProperties() throws JastorException {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        List<_Property> properties = ctx.getDeclaredProperties(getURI());
        if (properties == null) {
            properties = new ArrayList<_Property>();
            String query = "SELECT ?res WHERE {?res " + QueryEncoder.encodeForQuery(RDF.TYPE) + " " + QueryEncoder.encodeForQuery(DatatypeProperty.TYPE) + " . ?res " + QueryEncoder.encodeForQuery(RDFS.domain) + " " + QueryEncoder.encodeForQuery(ontClass.resource()) + "}";
            QuadStoreEngineConfig config = new QuadStoreEngineConfig(ctx.getOntGraphQuadStore());
            Engine glitter = new Engine(config);
            try {
                QueryResults results = glitter.executeQuery(null, query, Collections.singleton(ontGraph.getNamedGraphUri()), Collections.<URI> emptySet());
                Iterator<PatternSolution> sol = results.getSelectResults().iterator();
                while (sol.hasNext()) {
                    PatternSolution next = sol.next();
                    Resource propRes = (Resource) next.getBinding("res");
                    if (propRes != null) {
                        DatatypeProperty dp = OWL11Factory.getDatatypeProperty(propRes, ontGraph);
                        if (dp.isRDFType(DatatypeProperty.TYPE)) {
                            properties.add(dp);
                        }
                    }
                }
            } catch (Exception e) {
                throw new JastorException(e, "Error querying for properties");
            }
            query = "SELECT ?res WHERE {?res " + QueryEncoder.encodeForQuery(RDF.TYPE) + " " + QueryEncoder.encodeForQuery(ObjectProperty.TYPE) + " . ?res " + QueryEncoder.encodeForQuery(RDFS.domain) + " " + QueryEncoder.encodeForQuery(ontClass.resource()) + "}";
            try {
                QueryResults results = glitter.executeQuery(null, query, Collections.singleton(ontGraph.getNamedGraphUri()), Collections.<URI> emptySet());
                Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                while (iter.hasNext()) {
                    PatternSolution next = iter.next();
                    Resource propRes = (Resource) next.getBinding("res");
                    if (propRes != null) {
                        DatatypeProperty dp = OWL11Factory.getDatatypeProperty(propRes, ontGraph);
                        if (dp.isRDFType(ObjectProperty.TYPE)) {
                            properties.add(dp);
                        }
                    }
                }
            } catch (Exception e) {
                throw new JastorException(e, "Error querying for properties");
            }
            ctx.setDeclaredProperties(getURI(), properties);
            if (RequestAnalysis.isAnalysisEnabled()) {
                long end = System.currentTimeMillis();
                RequestAnalysis.incrementAnalysisPropertyCount("findDeclProps", (end - start));
            }

        }
        return properties;
    }
}
