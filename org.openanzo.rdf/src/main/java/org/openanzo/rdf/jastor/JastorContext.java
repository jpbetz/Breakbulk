/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/JastorContext.java,v $
 * Created by:
 * Created on:  01/23/2007
 * Revision:	$Id: JastorContext.java 172 2007-07-31 14:22:23Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor;

import java.io.File;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.jastor.inference.Ontology;
import org.openanzo.rdf.jastor.inference.OntologyClass;
import org.openanzo.rdf.jastor.inference.OntologyProperty;
import org.openanzo.rdf.jastor.jet.OntologyClassFileProvider;
import org.openanzo.rdf.jastor.jet.OntologyClassTemplate;
import org.openanzo.rdf.jastor.jet.OntologyFileProvider;
import org.openanzo.rdf.jastor.jet.OntologyTemplate;
import org.openanzo.rdf.jastor.rdfs.Rdfs2Owl;
import org.openanzo.rdf.jastor.templates.FactoryTemplate;
import org.openanzo.rdf.jastor.templates.ImplementationTemplate;
import org.openanzo.rdf.jastor.templates.InterfaceTemplate;
import org.openanzo.rdf.jastor.templates.ListenerTemplate;
import org.openanzo.rdf.jastor.util.graph.DFS;
import org.openanzo.rdf.jastor.util.graph.EdgeMem;
import org.openanzo.rdf.jastor.util.graph.GraphMem;
import org.openanzo.rdf.jastor.util.graph.IEdge;
import org.openanzo.rdf.jastor.util.graph.IGraph;
import org.openanzo.rdf.jastor.util.graph.INode;
import org.openanzo.rdf.jastor.util.graph.NodeMem;
import org.openanzo.rdf.owl.DatatypeProperty;
import org.openanzo.rdf.owl.OWL11Factory;
import org.openanzo.rdf.owl.ObjectProperty;
import org.openanzo.rdf.owl.Restriction;
import org.openanzo.rdf.owl._Thing;
import org.openanzo.rdf.owl.utils.OntologyUtils;
import org.openanzo.rdf.query.QuadStoreEngineConfig;
import org.openanzo.rdf.query.QueryEncoder;
import org.openanzo.rdf.rdfs.RDFSFactory;
import org.openanzo.rdf.rdfs._Property;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.StatementUtils;
import org.openanzo.rdf.vocabulary.OWL;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.rdf.vocabulary.RDFS;

/**
 * 
 * This class holds context information for code generation: ontGraphs, options, names, etc...
 * 
 * @author Ben Szekely ( <a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com </a>)
 * 
 */
public class JastorContext {

    /** OWL type extension */
    private static final String                             ONT_LANG_OWL                      = "owl";

    /** RDFS type extension */
    public static final String                              ONT_LANG_RDFS                     = "rdfs";

    private static final List<String>                       ONT_LANGS                         = new ArrayList<String>();
    static {
        ONT_LANGS.add(ONT_LANG_OWL);
        ONT_LANGS.add(ONT_LANG_RDFS);
    }

    private static final String                             GEN_NS                            = "http://jastor.openanzo.org/gen#";

    private final INamedGraph                               ontGraph;

    // this is a simple dataset containing each original ont graph..used by the ontologies
    private final Dataset                                   ontDataset                        = new Dataset();

    // this is a dataset containing all the ontologies in a single graph..used to query the collected graph
    private final IQuadStore                                ontGraphQuadStore                 = new MemQuadStore();

    /** map from ontology class URI to the containing ontology Resource->URI */
    private final HashMap<Resource, URI>                    ontologyClassMap                  = new HashMap<Resource, URI>();

    /** map from ontology propery uri to the containing onotology Resource->URI */
    private final HashMap<Resource, URI>                    ontologyPropertyMap               = new HashMap<Resource, URI>();

    /** from from ontology class URI to package Resource->String */
    private final HashMap<Resource, String>                 ontologyClassPackageMap           = new HashMap<Resource, String>();

    /** from the ontology URI to package Resource->String */
    private final HashMap<Resource, String>                 ontologyPackageMap                = new HashMap<Resource, String>();

    /** from the package to ontology URI String->URI */
    private final HashMap<String, URI>                      packageOntologyMap                = new HashMap<String, URI>();

    /** from class uri to a List(OntologyClass) that are classes that class uri should extend */
    private final HashMap<Resource, List<OntologyClass>>    unionTable                        = new HashMap<Resource, List<OntologyClass>>();

    /**
     * from class uri to a List(OntProperty) that are properties whose domain comes from a union. We must compute this table initially because some such
     * properties won't have restrictions so they would be ignored
     */
    private final HashMap<Resource, List<OntologyProperty>> unionDomainTable                  = new HashMap<Resource, List<OntologyProperty>>();

    private final List<Resource>                            classesToGenerate;

    private final List<Ontology>                            ontologiesToGenerate              = new ArrayList<Ontology>();

    private int                                             curPrefixNumber                   = 1;

    private final HashMap<String, String>                   namespacePrefixes                 = new HashMap<String, String>();

    private final HashMap<String, String>                   namespaceRemapper                 = new HashMap<String, String>();

    // generation flags
    private boolean                                         generateStandardCode              = true;

    private boolean                                         generateListeners                 = true;

    private boolean                                         generateVocabularyOnly            = false;

    private boolean                                         useEntireURIForIdentifiers        = false;

    private boolean                                         generateCacheInFactory            = true;

    private boolean                                         usePackageNameForRestrictedRanges = false;

    private boolean                                         useStrictTypeChecking             = false;

    private boolean                                         returnNullOnMissingTypes          = false;

    private boolean                                         useTypedLiterals                  = true;

    private boolean                                         addAllRDFTypesInHierarchy         = true;

    private boolean                                         includeCopyright                  = true;

    private boolean                                         searchSubClassHierarchyForCardRes = true;

    // Thing implementation
    private Class<?>                                        thingInterface                    = Thing.class;

    private Class<?>                                        thingImpl                         = ThingImpl.class;

    private Class<?>                                        thingFactory                      = ThingFactory.class;

    // base literal implementation
    private Class<?>                                        baseLiteralClass                  = Literal.class;

    // generation templates
    private final Map<String, OntologyTemplate>             ontologyTemplates                 = new HashMap<String, OntologyTemplate>();

    private final Map<String, OntologyClassTemplate>        ontologyClassTemplates            = new HashMap<String, OntologyClassTemplate>();

    // memoization for the computation of property restrictions in subClasses
    // <classUri><propUri> => Restriction
    Map<String, Restriction[]>                              subClassRestrictions              = new HashMap<String, Restriction[]>();

    // memoization for the computation of property restrictions
    // <classUri><propUri> => Restriction
    Map<String, Restriction[]>                              baseRestrictions                  = new HashMap<String, Restriction[]>();

    List<_Property>                                         odProps                           = null;

    Map<URI, List<_Property>>                               declProps                         = new HashMap<URI, List<_Property>>();

    /**
     * Construct an empty context with initially nothing to generate
     * 
     */
    public JastorContext() {
        ontGraph = createOntGraph(false, null);
        OWL11Factory.createClass(_Thing.TYPE, ontGraph);
        //OWL11Factory.createClass(RDFS.RESOURCE, ontGraph);
        classesToGenerate = new ArrayList<Resource>();
    }

    /**
     * Should be called to finalize the context after all ontologies have been added but before generation
     */
    public void finalizeContext() {

        ontGraphQuadStore.add(ontGraph.getStatements());

        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        buildUnionTable();
        buildUnionDomainTable();
        if (isGenerateStandardCode())
            setupDefaultTemplates();
        fillInDomainRangeFromSuperProperties();
        addRDFTypeToEnumerationClassMembers();
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.incrementAnalysisPropertyCount("finalizeContext", end - start);
        }

        ontGraphQuadStore.clear();
        ontGraphQuadStore.add(ontGraph.getStatements());
    }

    /**
     * Set a custom thing implementation.
     * 
     * @param thingInterface
     *            - the classname of an extension of Thing
     * @param thingImpl
     *            - the classname of an extension of ThingImpl
     * @param thingFactory
     *            the classname of an extension of ThingFactory
     * @throws JastorException
     */
    public void setCustomThing(String thingInterface, String thingImpl, String thingFactory) throws JastorException {
        try {
            this.thingInterface = Class.forName(thingInterface);
            this.thingImpl = Class.forName(thingImpl);
            this.thingFactory = Class.forName(thingFactory);
        } catch (ClassNotFoundException e) {
            throw new JastorException(e, "Error loading custom thing class");
        }
    }

    /**
     * Return the Class of the base Thing interface
     * 
     * @return the Class of the base Thing interface
     */
    public Class<?> getThingInterface() {
        return thingInterface;
    }

    /**
     * Return the Class of the base Thing implementation
     * 
     * @return the Class of the base Thing implementation
     */
    public Class<?> getThingImpl() {
        return thingImpl;
    }

    /**
     * Return the Class of the base Thing factory
     * 
     * @return the Class of the base Thing factory
     */
    public Class<?> getThingFactory() {
        return thingFactory;
    }

    /**
     * Specify an OWL ontology to generate
     * 
     * @param ontologyFile
     *            The Reader containing the ontology document
     * @param ontologyURI
     *            The URI of the ontology
     * @param packagename
     *            The Java package that generate classes should be in.
     */
    public void addOntologyToGenerate(Reader ontologyFile, String ontologyURI, String packagename) {
        addOntologyToGenerate(ontologyFile, null, ontologyURI, packagename);
    }

    /**
     * Specify an OWL ontology to generate
     * 
     * @param ontologyFile
     *            The Reader containing the ontology document
     * @param rdflang
     *            The seriazation format of the ontology file (N3,RDF/XM)
     * @param ontologyURI
     *            The URI of the ontology
     * @param packagename
     *            The Java package that generate classes should be in.
     */
    public void addOntologyToGenerate(Reader ontologyFile, String rdflang, String ontologyURI, String packagename) {
        addOntologyToGenerate(ontologyFile, ONT_LANG_OWL, rdflang, ontologyURI, packagename);
    }

    /**
     * Specify an ontology to generate
     * 
     * @param ontologyFile
     *            The Reader containing the ontology document
     * @param ontLang
     *            The Ontology Language, owl or rdfs.
     * @param rdflang
     *            The serialization format of the ontology file (N3,RDF/XM,)
     * @param ontologyURI
     *            The URI of the ontology
     * @param packagename
     *            The Java package that generate classes should be in.
     */
    public void addOntologyToGenerate(Reader ontologyFile, String ontLang, String rdflang, String ontologyURI, String packagename) {
        try {
            RDFFormat rdfFormat = null;
            if (rdflang != null) {
                if (rdflang.equals("RDF/XML")) {
                    rdflang = "RDFXML";
                }
                rdfFormat = RDFFormat.valueOf(rdflang);
            } else {
                rdfFormat = RDFFormat.RDFXML;
            }
            INamedGraph temp = createOntGraph(false, ontLang);
            ReadWriteUtils.loadGraph(temp, ontologyFile, rdfFormat, ontologyURI);
            if (ontLang != null && ontLang.equals(ONT_LANG_RDFS)) {
                temp = Rdfs2Owl.convertToOwl(temp, ontologyURI);
            }
            addConcreteEnumClasses(temp);
            ReadWriteUtils.addGraph(temp, ontGraph);
            registerOntology(temp, ontologyURI, packagename, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Specify an ontology to generate
     * 
     * @param ontGraph
     *            An INamedGraph containing the ontology
     * @param ontologyURI
     *            The URI of the ontology
     * @param packagename
     *            The Java package that generate classes should be in.
     */
    public void addOntologyToGenerate(INamedGraph ontGraph, String ontologyURI, String packagename) {
        ReadWriteUtils.addGraph(ontGraph, this.ontGraph);
        registerOntology(ontGraph, ontologyURI, packagename, true);
    }

    /**
     * Specify an ontology dependency
     * 
     * @param ontGraph
     *            An INamedGraph containing the ontology
     * @param ontologyURI
     *            The URI of the ontology
     * @param packagename
     *            The Java package that generate classes should be in.
     */
    public void addOntologyDependency(INamedGraph ontGraph, String ontologyURI, String packagename) {
        ReadWriteUtils.addGraph(ontGraph, this.ontGraph);
        registerOntology(ontGraph, ontologyURI, packagename, false);
    }

    /**
     * Specify an ontology needed by one of the generation ontologies. One of these entries should be added for every import in every ontology to generate. We
     * have this call because imports aren't automatically loaded.
     * 
     * @param ontologyFile
     *            The Reader containing the ontology document
     * @param rdflang
     *            The seriazation format of the ontology file (N3,RDF/XM,...all supported formats)
     * @param ontologyURI
     *            The URI of the ontology
     * @param packagename
     *            The Java package that generate classes should be in.
     * 
     *            private void addOntologyDependency(Reader ontologyFile, String rdflang, String ontologyURI, String packagename) {
     *            addOntologyDependency(ontologyFile, ONT_LANG_OWL, rdflang, ontologyURI, packagename); }
     */
    /**
     * Specify an ontology needed by one of the generation ontologies. One of these entries should be added for every import in every ontology to generate. We
     * have this call because imports aren't automatically loaded.
     * 
     * @param ontologyFile
     *            The Reader containing the ontology document
     * @param ontLang
     *            The Ontology Language, owl or rdfs.
     * @param rdflang
     *            The serialization format of the ontology file (N3,RDF/XM)
     * @param ontologyURI
     *            The URI of the ontology
     * @param packagename
     *            The Java package that generate classes should be in.
     */
    public void addOntologyDependency(Reader ontologyFile, String ontLang, String rdflang, String ontologyURI, String packagename) {
        try {
            INamedGraph temp = createOntGraph(false, ontLang);
            if (rdflang != null && !rdflang.equals("RDF/XML"))
                ReadWriteUtils.loadGraph(temp, ontologyFile, RDFFormat.valueOf(rdflang), ontologyURI);
            else
                ReadWriteUtils.loadGraph(temp, ontologyFile, RDFFormat.RDFXML, ontologyURI);
            if (ontLang != null && ontLang.equals(ONT_LANG_RDFS)) {
                temp = Rdfs2Owl.convertToOwl(temp, ontologyURI);
            }
            addConcreteEnumClasses(temp);
            ReadWriteUtils.addGraph(temp, ontGraph);
            registerOntology(temp, ontologyURI, packagename, false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return a List of OntologyClass objects representing all the classes to be generated.
     * 
     * @return a List of OntologyClass objects representing all the classes to be generated.
     */
    public List<OntologyClass> listOntologyClassesToGenerate() {
        List<OntologyClass> classes = new ArrayList<OntologyClass>();
        for (Resource resource : classesToGenerate) {
            org.openanzo.rdf.owl.Class oc = OWL11Factory.getClass(resource, ontGraph);
            classes.add(new OntologyClass(oc, this));
        }
        return classes;
    }

    /**
     * Return a list of Ontology objects representing all the ontologies to be generated
     * 
     * @return a list of Ontology objects representing all the ontologies to be generated
     */
    public List<Ontology> listOntologiesToGenerate() {
        return ontologiesToGenerate;
    }

    /**
     * Determine if we generate listeners for the beans
     * 
     * @return true if we generate listeners for the beans, default true
     */
    public boolean isGenerateListeners() {
        return generateListeners;
    }

    /**
     * Indicate whether or not to generate listeners, default true
     * 
     * @param generateListeners
     *            set whether or not to generate listeners
     */
    public void setGenerateListeners(boolean generateListeners) {
        this.generateListeners = generateListeners;
    }

    /**
     * Determine if we generate only vocabulary files for the ontology
     * 
     * @return true if we generate only vocabulary files for the ontology
     */
    public boolean isGenerateVocabularyOnly() {
        return generateVocabularyOnly;
    }

    /**
     * Set if we generate only vocabulary files for the ontology
     * 
     * @param generateVocabularyOnly
     *            sets if we generate only vocabulary files for the ontology
     */
    public void setGenerateVocabularyOnly(boolean generateVocabularyOnly) {
        this.generateVocabularyOnly = generateVocabularyOnly;
    }

    /**
     * Determine if we use the entire URI for identifiers
     * 
     * @return true if we use the entire URI for identifiers
     */
    public boolean isUseEntireURIForIdentifiers() {
        return useEntireURIForIdentifiers;
    }

    /**
     * Set if we use the entire URI for identifiers
     * 
     * @param useEntireURIForIdentifiers
     *            sets if we use the entire URI for identifiers
     */
    public void setUseEntireURIForIdentifiers(boolean useEntireURIForIdentifiers) {
        this.useEntireURIForIdentifiers = useEntireURIForIdentifiers;
    }

    public boolean isSearchSubClassHierarchyForCardRes() {
        return searchSubClassHierarchyForCardRes;
    }

    public void setSearchSubClassHierarchyForCardRes(boolean searchSubClassHierarchyForCardRes) {
        this.searchSubClassHierarchyForCardRes = searchSubClassHierarchyForCardRes;
    }

    /**
     * Determine if we generate a cache of objects within the ontology factory
     * 
     * @return true if we generate a cache of objects within the ontology factory
     */
    public boolean isGenerateCacheInFactory() {
        return generateCacheInFactory;
    }

    /**
     * Set if we generate a cache of objects within the ontology factory
     * 
     * @param generateCacheInFactory
     *            sets if we generate a cache of objects within the ontology factory
     */
    public void setGenerateCacheInFactory(boolean generateCacheInFactory) {
        this.generateCacheInFactory = generateCacheInFactory;
    }

    /**
     * Determine if we use package names for restricted ranges
     * 
     * @return true if we use package names for restricted ranges
     */
    public boolean isUsePackageNameForRestrictedRanges() {
        return usePackageNameForRestrictedRanges;
    }

    /**
     * Set if we use package names for restricted ranges
     * 
     * @param usePackageNameForRestrictedRanges
     *            sets if we use package names for restricted ranges
     */
    public void setUsePackageNameForRestrictedRanges(boolean usePackageNameForRestrictedRanges) {
        this.usePackageNameForRestrictedRanges = usePackageNameForRestrictedRanges;
    }

    /**
     * Determine if we use strict type checking
     * 
     * @return true if we use strict type checking
     */
    public boolean isUseStrictTypeChecking() {
        return useStrictTypeChecking;
    }

    /**
     * Set if we use strict type checking
     * 
     * @param useStrictTypeChecking
     *            sets if we use strict type checking
     */
    public void setUseStrictTypeChecking(boolean useStrictTypeChecking) {
        this.useStrictTypeChecking = useStrictTypeChecking;
    }

    /**
     * Determine if we generate standard code
     * 
     * @return true if we generate standard code
     */
    public boolean isGenerateStandardCode() {
        return generateStandardCode;
    }

    /**
     * Set if we generate standard code
     * 
     * @param generateStandardCode
     *            sets if we generate standard code
     */
    public void setGenerateStandardCode(boolean generateStandardCode) {
        this.generateStandardCode = generateStandardCode;
    }

    /**
     * Determine if we used typed literals
     * 
     * @return true if we used typed literals
     */
    public boolean isUseTypedLiterals() {
        return useTypedLiterals;
    }

    /**
     * Set if we used typed literals
     * 
     * @param useTypedLiterals
     *            sets if we used typed literals
     */
    public void setUseTypedLiterals(boolean useTypedLiterals) {
        this.useTypedLiterals = useTypedLiterals;
    }

    /**
     * Determine if all RDF types in the classes hierarchy should be added
     * 
     * @return true if all RDF types in the classes hierarchy should be added
     */
    public boolean isAddAllRDFTypesInHierarchy() {
        return addAllRDFTypesInHierarchy;
    }

    /**
     * Set if all RDF types in the classes hierarchy should be added
     * 
     * @param addAllRDFTypesInHierarchy
     *            sets if all RDF types in the classes hierarchy should be added
     */
    public void setAddAllRDFTypesInHierarchy(boolean addAllRDFTypesInHierarchy) {
        this.addAllRDFTypesInHierarchy = addAllRDFTypesInHierarchy;
    }

    /**
     * Get the INamedGraph that contains the ontology data
     * 
     * @return the INamedGraph that contains the ontology data
     */
    public INamedGraph getOntGraph() {
        return ontGraph;
    }

    /**
     * 
     * @return ont dataset
     */
    public IDataset getOntDataset() {
        return ontDataset;
    }

    /**
     * 
     * @return ont dataset
     */
    public IQuadStore getOntGraphQuadStore() {
        return ontGraphQuadStore;
    }

    /**
     * Get the Ontology for the given class URI
     * 
     * @param ontClassURI
     *            URI of class for which to get ontology
     * @return URI of ontology for given class
     */
    public URI getOntologyForClass(Resource ontClassURI) {
        return ontologyClassMap.get(ontClassURI);
    }

    /**
     * Get the Package name for the given class URI
     * 
     * @param ontClassURI
     *            URI of class for which to get Package
     * @return Package for given class
     */
    public String getPackageForClass(Resource ontClassURI) {
        return ontologyClassPackageMap.get(ontClassURI);
    }

    /**
     * Get the Ontology for the given Package
     * 
     * @param pkg
     *            Package for which to get ontology
     * @return URI of ontology for given Package
     */
    public URI getOntologyForPackage(String pkg) {
        return packageOntologyMap.get(pkg);
    }

    /**
     * Return a list of OntologyClass that the given class should extend because the returned classes are unions of classuri. Returns an empty list if no
     * extensions exist. We pre-compute this table because the corresponding per-class query is messy and inefficient.
     * 
     * @param classURI
     *            URI of class to get OntologyClasses for
     * @return list of OntologyClass that the given class
     */
    public List<OntologyClass> getUnionClassExtensions(Resource classURI) {
        List<OntologyClass> list = unionTable.get(classURI);
        if (list == null)
            return new ArrayList<OntologyClass>();
        return list;
    }

    /**
     * Return a list or OntologyProperty that are properies declared with a domain that is a union of classes.
     * 
     * @param classuri
     *            URI of union domain
     * @return list or OntProperty that are properies declared with a domain
     */
    public List<OntologyProperty> getUnionDomainProperties(Resource classuri) {
        List<OntologyProperty> list = unionDomainTable.get(classuri);
        if (list == null)
            return new ArrayList<OntologyProperty>();
        return list;
    }

    /**
     * Add a generation template to be run for each ontology class
     * 
     * @param name
     *            template name
     * @param ontgen
     *            template for code generation
     */
    public void addOntologyClassTemplate(String name, OntologyClassTemplate ontgen) {
        ontologyClassTemplates.put(name, ontgen);
    }

    /**
     * Add a generation template to be run for each ontology
     * 
     * @param name
     *            template name
     * @param ontgen
     *            template for code generation
     */
    public void addOntologyTemplate(String name, OntologyTemplate ontgen) {
        ontologyTemplates.put(name, ontgen);
    }

    /**
     * Get the mapping of ontology class template names to their template class
     * 
     * @return the mapping of ontology class template names to their template class
     */
    public Map<String, OntologyClassTemplate> getOntologyClassTemplates() {
        return ontologyClassTemplates;
    }

    /**
     * Get the mapping of ontology template names to their template class
     * 
     * @return the mapping of ontology template names to their template class
     */
    public Map<String, OntologyTemplate> getOntologyTemplates() {
        return ontologyTemplates;
    }

    /**
     * Add a new mapping between a prefix and a full namespace.
     * 
     * @param ns
     *            full namespace
     * @param prefix
     *            prefixed namespace
     */
    public void setNamespacePrefix(String ns, String prefix) {
        namespacePrefixes.put(ns, prefix);
    }

    /**
     * Get the prefix for a namespace
     * 
     * @param ns
     *            namespace to lookup
     * @return prefix for the namespace, or if no prefix is found, ns[number] is used
     */
    public String getNamespacePrefix(String ns) {
        String prefix = namespacePrefixes.get(ns);
        if (prefix == null) {
            prefix = "ns" + curPrefixNumber++;
            namespacePrefixes.put(ns, prefix);
        }
        return prefix;
    }

    /**
     * Check if ontology and class are part of same ontology
     * 
     * @param ontPropertyUri
     *            URI of property to check
     * @param ontClassUri
     *            URI of class to check
     * @return true if ontology and class are part of same ontology
     */
    public boolean isPropetyAndClassDefinedInSameOntology(Resource ontPropertyUri, Resource ontClassUri) {
        Resource propOnt = ontologyPropertyMap.get(ontPropertyUri);
        Resource classOnt = ontologyClassMap.get(ontClassUri);
        if (propOnt == null || ontClassUri == null)
            return false;
        return propOnt.equals(classOnt);
    }

    private void registerOntology(INamedGraph tempont, String ontURI, String packagename, boolean generate) {
        URI ontologyURI = Constants.valueFactory.createURI(ontURI);
        ontDataset.addNamedGraph(ontologyURI).add(tempont.getStatements());
        ontologyPackageMap.put(ontologyURI, packagename);
        packageOntologyMap.put(packagename, ontologyURI);
        List<org.openanzo.rdf.owl.Class> classes = OWL11Factory.getAllClass(tempont);
        List<Resource> classuris = new ArrayList<Resource>();
        for (org.openanzo.rdf.owl.Class oc : classes) {
            if (!(oc.resource() instanceof BlankNode)) {
                ontologyClassPackageMap.put(oc.resource(), packagename);
                ontologyClassMap.put(oc.resource(), ontologyURI);
                if (generate) {
                    classuris.add(oc.resource());
                    classesToGenerate.add(oc.resource());
                }
            }
        }
        List<org.openanzo.rdf.owl.DatatypeProperty> dataProps = OWL11Factory.getAllDatatypeProperty(tempont);
        for (DatatypeProperty prop : dataProps) {
            if (ontologyPropertyMap.containsKey(prop.resource())) {
                System.err.println("Warning: " + prop.resource() + " defined in multiple ontologies");
            } else {
                ontologyPropertyMap.put(prop.resource(), ontologyURI);
            }
        }
        List<org.openanzo.rdf.owl.ObjectProperty> objProps = OWL11Factory.getAllObjectProperty(tempont);
        for (ObjectProperty prop : objProps) {
            if (ontologyPropertyMap.containsKey(prop.resource())) {
                System.err.println("Warning: " + prop.resource() + " defined in multiple ontologies");
            } else {
                ontologyPropertyMap.put(prop.resource(), ontologyURI);
            }
        }
        if (generate) {
            ontologiesToGenerate.add(new org.openanzo.rdf.jastor.inference.Ontology(ontURI, packagename, this, classuris));
        }
    }

    private INamedGraph createOntGraph(boolean processImports, String ontLang) {
        return new NamedGraph(Constants.valueFactory.createURI("http://openanzo.org/jastor/graph"));
    }

    private void buildUnionTable() {
        List<OntologyClass> list = listOntologyClassesToGenerate();
        for (int i = 0; i < list.size(); i++) {
            OntologyClass oc = list.get(i);
            org.openanzo.rdf.owl.Class ontClass = oc.getOntClass();
            if (ontClass.resource() instanceof URI) {
                Thing unionOf = ontClass.getUnionOf();
                if (unionOf != null) {
                    Iterable<Value> unions = StatementUtils.getCollectionMembers(unionOf.resource(), getOntGraph());
                    for (Value val : unions) {
                        if (val instanceof Resource) {
                            org.openanzo.rdf.owl.Class op = OWL11Factory.getClass((Resource) val, getOntGraph());
                            if (op != null) {
                                List<OntologyClass> l = unionTable.get(op.resource());
                                if (l == null) {
                                    l = new ArrayList<OntologyClass>();
                                    unionTable.put(op.resource(), l);
                                }
                                l.add(oc);
                            }
                        }
                    }
                }
            }
        }
    }

    private void buildUnionDomainTable() {
        buildDPUnionDomainTable(OWL11Factory.getAllDatatypeProperty(ontGraph));
        buildOPUnionDomainTable(OWL11Factory.getAllObjectProperty(ontGraph));
    }

    private void buildDPUnionDomainTable(List<DatatypeProperty> it) {
        for (DatatypeProperty prop : it) {
            OntologyProperty op = new OntologyProperty(prop, this);
            if (prop.getDomain() != null && (prop.getDomain().resource() instanceof BlankNode)) {
                org.openanzo.rdf.owl.Class clazz = OWL11Factory.getClass(prop.getDomain().resource(), getOntGraph());
                Thing union = clazz.getUnionOf();
                Iterable<Value> unions = StatementUtils.getCollectionMembers(union.resource(), getOntGraph());
                for (Value val : unions) {
                    if (val instanceof Resource) {
                        org.openanzo.rdf.owl.Class oc = OWL11Factory.getClass((Resource) val, getOntGraph());
                        if (oc != null) {
                            List<OntologyProperty> l = unionDomainTable.get(oc.resource());
                            if (l == null) {
                                l = new ArrayList<OntologyProperty>();
                                unionDomainTable.put(oc.resource(), l);
                            }
                            l.add(op);
                        }
                    }
                }
            }
        }
    }

    private void buildOPUnionDomainTable(List<ObjectProperty> it) {
        for (ObjectProperty prop : it) {
            OntologyProperty op = new OntologyProperty(prop, this);
            if (prop.getDomain() != null && (prop.getDomain().resource() instanceof BlankNode)) {
                org.openanzo.rdf.owl.Class clazz = OWL11Factory.getClass(prop.getDomain().resource(), getOntGraph());
                Thing union = clazz.getUnionOf();
                Iterable<Value> unions = StatementUtils.getCollectionMembers(union.resource(), getOntGraph());
                for (Value val : unions) {
                    if (val instanceof Resource) {
                        org.openanzo.rdf.owl.Class oc = OWL11Factory.getClass((Resource) val, getOntGraph());
                        if (oc != null) {
                            List<OntologyProperty> l = unionDomainTable.get(oc.resource());
                            if (l == null) {
                                l = new ArrayList<OntologyProperty>();
                                unionDomainTable.put(oc.resource(), l);
                            }
                            l.add(op);
                        }
                    }
                }
            }
        }
    }

    private void fillInDomainRangeFromSuperProperties() {
        List<DatatypeProperty> properties = OWL11Factory.getAllDatatypeProperty(getOntGraph());
        for (DatatypeProperty property : properties) {
            fillIn(property, new ArrayList<_Property>());
        }
        List<ObjectProperty> properties2 = OWL11Factory.getAllObjectProperty(getOntGraph());
        for (ObjectProperty property : properties2) {
            fillIn(property, new ArrayList<_Property>());
        }
    }

    private Resource[] fillIn(_Property prop, List<_Property> visited) {
        if (visited.contains(prop))
            return new Resource[2];
        visited.add(prop);
        // while the proper behavior of this method is undefined,
        // use the following guidelines:
        // - if a property defines it own domain/range, use it.
        // - takethe domain or range from a super-property.
        // - super-prop domain/ranges yield to a complete
        //   complete d/r range pairs from super property
        org.openanzo.rdf.rdfs.Class domain = OntologyProperty.getDomain(prop);
        Thing range = OntologyProperty.getRange(prop);
        Resource domainResource = (domain != null) ? domain.resource() : null;
        Resource rangeResource = (range != null) ? range.resource() : null;
        Resource[] vals = { domainResource, rangeResource };
        if (domain == null || range == null) {
            final int DOMAIN = 0;
            final int RANGE = 1;
            boolean domainSet = domain != null;
            boolean rangeSet = range != null;
            List<_Property> it = OntologyUtils.getSuperProperties(prop, false);
            for (_Property ontProp : it) {
                Resource[] parVals = fillIn(ontProp, visited);
                if (!domainSet && parVals[DOMAIN] != null)
                    vals[DOMAIN] = parVals[DOMAIN];
                if (!rangeSet && parVals[RANGE] != null)
                    vals[RANGE] = parVals[RANGE];
                if ((domainSet && vals[RANGE] != null) || (rangeSet && vals[DOMAIN] != null) || (vals[DOMAIN] != null && vals[RANGE] != null)) {
                    break;
                }
            }
            if (!domainSet && vals[DOMAIN] != null)
                OntologyProperty.setDomain(prop, vals[DOMAIN]);
            if (!rangeSet && vals[RANGE] != null)
                OntologyProperty.setRange(prop, vals[RANGE]);
            return vals;
        } else {
            return new Resource[] { domainResource, rangeResource };
        }
    }

    private void setupDefaultTemplates() {
        addOntologyClassTemplate("Interface", new InterfaceTemplate(new OntologyClassFileProvider() {

            public File getFile(OntologyClass oc, File outputDir) {
                return oc.getInterfaceFile(outputDir);
            }
        }));
        if (!isGenerateVocabularyOnly()) {
            addOntologyClassTemplate("Implementation", new ImplementationTemplate(new OntologyClassFileProvider() {

                public File getFile(OntologyClass oc, File outputDir) {
                    return oc.getImplFile(outputDir);
                }
            }));
            addOntologyTemplate("Factory", new FactoryTemplate(new OntologyFileProvider() {

                public File getFile(Ontology ont, File outputDir) {
                    return ont.getFactoryFile(outputDir);
                }
            }));
            if (isGenerateListeners()) {
                addOntologyClassTemplate("Listener", new ListenerTemplate(new OntologyClassFileProvider() {

                    public File getFile(OntologyClass oc, File outputDir) {
                        return oc.getListenerFile(outputDir);
                    }
                }));
            }
        }
    }

    private void addRDFTypeToEnumerationClassMembers() {
        List<org.openanzo.rdf.owl.Class> itr = OWL11Factory.getAllClass(ontGraph);
        for (org.openanzo.rdf.owl.Class clazz : itr) {
            Thing oneOf = clazz.getOneOf();
            if (oneOf != null) {
                Iterable<Value> unions = StatementUtils.getCollectionMembers(oneOf.resource(), getOntGraph());
                for (Value val : unions) {
                    if (val instanceof Resource) {
                        if (!ontGraph.contains((Resource) val, RDF.TYPE, clazz.resource())) {
                            ontGraph.add((Resource) val, RDF.TYPE, clazz.resource());
                        }
                    }
                }
            }
        }
    }

    private void addConcreteEnumClasses(INamedGraph tempOnt) {
        List<org.openanzo.rdf.owl.Class> itr = OWL11Factory.getAllClass(tempOnt);
        List<org.openanzo.rdf.owl.Class> list = new LinkedList<org.openanzo.rdf.owl.Class>();
        for (org.openanzo.rdf.owl.Class clazz : itr) {
            Thing oneOf = clazz.getOneOf();
            if (oneOf != null) {
                list.add(clazz);
            }
        }
        for (org.openanzo.rdf.owl.Class clazz : list) {
            if (clazz.resource() instanceof BlankNode) {
                try {
                    Iterable<Statement> stmts = tempOnt.find(null, RDFS.range, clazz.resource());
                    for (Statement stmt : stmts) {
                        Resource prop = stmt.getSubject();
                        _Property ontProp = RDFSFactory.get_Property(prop, tempOnt);
                        OntologyProperty op = new OntologyProperty(ontProp, this);
                        String uri = GEN_NS + op.getPropertyCapped() + "Enum";
                        org.openanzo.rdf.owl.Class ec2 = OWL11Factory.createClass(uri, tempOnt);
                        ec2.setOneOf(clazz.getOneOf());
                        if (ontProp.isRDFType(DatatypeProperty.TYPE)) {
                            DatatypeProperty dp = OWL11Factory.getDatatypeProperty(ontProp.resource(), tempOnt);
                            dp.setRange(ec2);
                        } else if (ontProp.isRDFType(ObjectProperty.TYPE)) {
                            ObjectProperty objp = OWL11Factory.getObjectProperty(ontProp.resource(), tempOnt);
                            objp.setRange(ec2);
                        }
                        for (Value value : StatementUtils.getCollectionMembers(ec2.getOneOf().resource(), tempOnt)) {
                            tempOnt.add(Constants.valueFactory.createURI(value.toString()), RDF.TYPE, Constants.valueFactory.createURI(uri));
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Warning, bad anonymous Enum (oneOf) class found");
                }
            }
        }
    }

    /**
     * Get the base literal Class for this context
     * 
     * @return the base literal Class for this context
     */
    public Class<?> getBaseLiteralClass() {
        return baseLiteralClass;
    }

    /**
     * Set the base literal Class for this context
     * 
     * @param baseLiteralClass
     *            the name of the base literal Class for this context
     * @throws JastorException
     *             if the Class does not exist
     */
    public void setBaseLiteralClass(String baseLiteralClass) throws JastorException {
        try {
            this.baseLiteralClass = Class.forName(baseLiteralClass);
        } catch (Exception e) {
            throw new JastorException(e, "Error loading base literal class");
        }
    }

    /**
     * Determine if code returns null on missing types
     * 
     * @return true if code returns null on missing types
     */
    public boolean isReturnNullOnMissingTypes() {
        return returnNullOnMissingTypes;
    }

    /**
     * Set if code returns null on missing types
     * 
     * @param returnNullOnMissingTypes
     *            Set if code returns null on missing types
     */
    public void setReturnNullOnMissingTypes(boolean returnNullOnMissingTypes) {
        this.returnNullOnMissingTypes = returnNullOnMissingTypes;
    }

    /**
     * Determine if generated code should include copyright statements
     * 
     * @return true if generated code should include copyright statements
     */
    public boolean isIncludeCopyright() {
        return includeCopyright;
    }

    /**
     * Set if generated code should include copyright statements
     * 
     * @param includeCopyright
     *            Set if generated code should include copyright statements
     */
    public void setIncludeCopyright(boolean includeCopyright) {
        this.includeCopyright = includeCopyright;
    }

    /**
     * Set a remapped namespace for the given namespace
     * 
     * @param namespace
     *            namespace to replace
     * @param remappedNamesapce
     *            remapped namespace to use in its place
     */
    public void setNamespaceRemapper(String namespace, String remappedNamesapce) {
        this.namespaceRemapper.put(namespace, remappedNamesapce);
    }

    /**
     * Determine if the namespace for a URI needs to be replace, and replace if necessary
     * 
     * @param uri
     *            URI to check
     * @return a new URI with its namespace remapped, if there is a remapping for the namespace
     */
    public String remapUri(URI uri) {
        String result = uri.toString();
        for (Map.Entry<String, String> entry : namespaceRemapper.entrySet()) {
            if (result.contains(entry.getKey())) {
                return result.replace(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    /**
     * Determine if the namespace for a URI needs to be replace, and replace if necessary
     * 
     * @param uri
     *            URI to check
     * @return a new URI with its namespace remapped, if there is a remapping for the namespace
     */
    public String remapUri(String uri) {
        String result = uri;
        for (Map.Entry<String, String> entry : namespaceRemapper.entrySet()) {
            if (result.contains(entry.getKey())) {
                return result.replace(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    /**
     * Get sorted classes
     * 
     * @return sorted classes
     * @throws JastorException
     */
    public List<OntologyClass> getClassesSorted() throws JastorException {

        List<OntologyClass> classes = new ArrayList<OntologyClass>();

        for (Ontology ont : ontologiesToGenerate) {
            classes.addAll(ont.getClasses());
        }

        IGraph graph = new GraphMem("classes");
        for (OntologyClass oc : classes) {
            INode node = new NodeMem(oc.getURI().toString());
            node.setData(oc);
            graph.addNode(node);
        }
        for (OntologyClass oc : classes) {
            INode src = graph.getNodeByName(oc.getURI().toString());
            for (OntologyClass oc2 : oc.listImmediateExtensionClasses()) {
                INode dst = graph.getNodeByName(oc2.getURI().toString());
                if (dst == null)
                    continue;
                IEdge edge = new EdgeMem(oc.getURI() + "->" + oc2.getURI(), src, dst);
                graph.addEdge(edge);
            }
        }
        DFS dfs = new DFS();
        dfs.setGraph(graph);
        dfs.execute();
        List<OntologyClass> sorted = new ArrayList<OntologyClass>();
        for (INode node : dfs.getNodesByFinishTime()) {
            OntologyClass oc = (OntologyClass) node.getData();
            sorted.add(0, oc);
        }
        return sorted;

    }

    /**
     * 
     * @param classUri
     * @param propUri
     * @param res
     */
    public void addSubClassRestriction(String classUri, String propUri, Restriction res) {
        Restriction[] holder = new Restriction[] { res };
        subClassRestrictions.put(classUri + "|" + propUri, holder);
    }

    /**
     * 
     * @param classUri
     * @param propUri
     * @return sub class restrictions
     */
    public Restriction[] getSubClassRestriction(String classUri, String propUri) {
        return subClassRestrictions.get(classUri + "|" + propUri);
    }

    /**
     * 
     * @param classUri
     * @param propUri
     * @param res
     */
    public void addRestriction(String classUri, String propUri, Restriction[] res) {
        baseRestrictions.put(classUri + "|" + propUri, res);
    }

    /**
     * 
     * @param classUri
     * @param propUri
     * @return sub class restrictions
     */
    public Restriction[] getRestriction(String classUri, String propUri) {
        return baseRestrictions.get(classUri + "|" + propUri);
    }

    /**
     * 
     * @return the open domain properties within the context
     */
    public List<_Property> getOpenDomainProperties() {
        if (odProps != null) {
            return odProps;
        } else {
            odProps = new ArrayList<_Property>();
            // There might be inconsistent behavior when adding open domain properties to the
            // class frames..so, we basically have to do it ourselves, and rule out duplicates
            // in the case that they are provided
            Resource[] openDomainResources = new Resource[] { RDFS.RESOURCE, _Thing.TYPE };
            for (int i = 0; i < openDomainResources.length; i++) {
                Iterable<Statement> stmts = getOntGraph().find(null, RDFS.domain, openDomainResources[i]);
                for (Statement stmt : stmts) {
                    Resource propres = stmt.getSubject();
                    _Property prop = RDFSFactory.get_Property(propres, ontGraph);
                    if (!odProps.contains(prop))
                        odProps.add(prop);
                }
            }
            Resource[] propTypes = new Resource[] { OWL.DATATYPEPROPERTY, OWL.OBJECTPROPERTY };
            for (int i = 0; i < propTypes.length; i++) {
                String sparql = "SELECT ?res " + " { ?res a " + QueryEncoder.encodeForQuery(propTypes[i]) + " . " + " OPTIONAL { ?res <" + RDFS.domain + "> ?prop . } " + " FILTER (!bound(?prop)) . " + " } ";

                QuadStoreEngineConfig config = new QuadStoreEngineConfig(getOntGraphQuadStore());
                Engine glitter = new Engine(config);
                try {
                    QueryResults results = glitter.executeQuery(null, sparql, Collections.singleton(ontGraph.getNamedGraphUri()), Collections.<URI> emptySet());
                    Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                    while (iter.hasNext()) {
                        PatternSolution next = iter.next();
                        Resource propres = (Resource) next.getBinding("res");
                        _Property prop = RDFSFactory.get_Property(propres, ontGraph);
                        if (!odProps.contains(prop))
                            odProps.add(prop);
                    }
                } catch (Exception ge) {
                    ge.printStackTrace();
                }
            }
            return odProps;
        }
    }

    /**
     * 
     * @param classUri
     * @param properties
     */
    public void setDeclaredProperties(URI classUri, List<_Property> properties) {
        this.declProps.put(classUri, properties);
    }

    /**
     * 
     * @param classUri
     * @return declared properties
     */
    public List<_Property> getDeclaredProperties(URI classUri) {
        return this.declProps.get(classUri);
    }

}
