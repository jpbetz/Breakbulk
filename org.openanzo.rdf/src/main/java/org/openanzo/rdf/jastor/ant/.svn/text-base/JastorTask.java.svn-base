/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/ant/JastorTask.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: JastorTask.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.ant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.JastorException;
import org.openanzo.rdf.jastor.JastorGenerator;
import org.openanzo.rdf.jastor.JavaIdentifierEncoder;
import org.openanzo.rdf.jastor.inference.Ontology;
import org.openanzo.rdf.jastor.inference.OntologyClass;
import org.openanzo.rdf.jastor.jet.OntologyClassFileProvider;
import org.openanzo.rdf.jastor.jet.OntologyClassTemplate;
import org.openanzo.rdf.jastor.jet.OntologyFileProvider;
import org.openanzo.rdf.jastor.jet.OntologyTemplate;
import org.openanzo.rdf.utils.ReadWriteUtils;

/**
 * 
 * @author Ben Szekely ( <a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com </a>)
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 */
public class JastorTask extends MatchingTask {

    private List<OntologyElement>        ontologies                         = new ArrayList<OntologyElement>();

    private List<CustomThingElement>     customThing                        = new ArrayList<CustomThingElement>();

    private List<TemplateElement>        templates                          = new ArrayList<TemplateElement>();

    private List<PrefixElement>          prefixes                           = new ArrayList<PrefixElement>();

    private final List<BaseTypesElement> baseTypes                          = new ArrayList<BaseTypesElement>();

    private File                         destdir;

    private boolean                      generateStandardCode               = true;

    private boolean                      generateListeners                  = true;

    private boolean                      generateVocublaryOnly              = false;

    private boolean                      useEntireURIForIdentifiers         = false;

    private boolean                      generateCacheInFactory             = true;

    private boolean                      usePackageNamesForRestrictedRanges = false;

    private boolean                      useStrictTypeChecking              = false;

    private boolean                      useTypedLiterals                   = true;

    private boolean                      addAllRDFTypesInHierarchy          = true;

    /**
     * Whether the Thing interface should extend OpenRdf's Resource interface in the generated source.
     * 
     * WARNING: this could cause collisions in ontologies with property names that collide with get-methods in Resource. e.g. getModel().
     */
    private boolean                      thingExtendsResource               = false;

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.tools.ant.Task#execute()
     */
    @Override
    public void execute() throws BuildException {
        JastorGenerator gen = null;
        JastorContext ctx = new JastorContext();
        ctx.setGenerateCacheInFactory(isGenerateCacheInFactory());
        ctx.setGenerateListeners(isGenerateListeners());
        ctx.setGenerateVocabularyOnly(isGenerateVocublaryOnly());
        ctx.setUseEntireURIForIdentifiers(isUseEntireURIForIdentifiers());
        ctx.setUsePackageNameForRestrictedRanges(isUsePackageNamesForRestrictedRanges());
        ctx.setUseStrictTypeChecking(isUseStrictTypeChecking());
        ctx.setGenerateStandardCode(isGenerateStandardCode());
        ctx.setUseTypedLiterals(isUseTypedLiterals());
        ctx.setAddAllRDFTypesInHierarchy(isAddAllRDFTypesInHierarchy());
        try {
            if (this.thingExtendsResource) {
                ctx.setCustomThing("com.ibm.adtech.jastor.resource(.ResourceThing", "com.ibm.adtech.jastor.resource.ResourceThingImpl", "com.ibm.adtech.jastor.resource.ResourceThingFactory");
            } else {
                CustomThingElement cte = getCustomThing();
                if (cte != null)
                    ctx.setCustomThing(cte.getThingInterface(), cte.getThingImpl(), cte.getThingFactory());
            }
        } catch (JastorException e) {
            throw new BuildException(e);
        }
        BaseTypesElement bte = getBaseTypes();
        if (bte != null) {
            ctx.setBaseLiteralClass(bte.getBaseLiteralClass());
        }
        if (getDestdir() != null) {
            gen = new JastorGenerator(getDestdir(), ctx);
        } else {
            throw new BuildException("destDir is a required property.");
        }
        for (OntologyElement ont : ontologies) {
            ont.validate();
            try {
                if (ont.isGenerate()) {
                    ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader(ont.getPath().toString()), ont.getOntlang(), ont.getLang(), ont.getUri(), ont.getJavaPackage());
                } else {
                    ctx.addOntologyDependency(ReadWriteUtils.createSmartFileReader(ont.getPath().toString()), ont.getOntlang(), ont.getLang(), ont.getUri(), ont.getJavaPackage());
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new BuildException(e);
            }
        }
        for (PrefixElement elt : prefixes) {
            ctx.setNamespacePrefix(elt.getNs(), elt.getPrefix());
        }
        for (TemplateElement tmp : templates) {
            try {
                String ext = tmp.getFileExtension();
                if (ext == null) {
                    ext = "java";
                }
                final String fileExtension = ext;
                String className = tmp.getClassName();
                Class<?> c = Class.forName(className);
                final String name = tmp.getName();
                if (OntologyTemplate.class.isAssignableFrom(c)) {
                    OntologyTemplate ot = (OntologyTemplate) c.newInstance();
                    ot.setFileProvider(new OntologyFileProvider() {

                        public File getFile(Ontology ont, File outputDir) {
                            String str = JavaIdentifierEncoder.encode(ont.getLocalName());
                            return new File(ont.getFactoryFile(outputDir).getParentFile(), str + name + "." + fileExtension);
                        }
                    });
                    ctx.addOntologyTemplate(name, ot);
                } else if (OntologyClassTemplate.class.isAssignableFrom(c)) {
                    OntologyClassTemplate oct = (OntologyClassTemplate) c.newInstance();
                    oct.setFileProvider(new OntologyClassFileProvider() {

                        public File getFile(OntologyClass ont, File outputDir) {
                            String str = JavaIdentifierEncoder.encode(ont.getLocalName());
                            return new File(ont.getFactoryFile(outputDir).getParentFile(), str + name + "." + fileExtension);
                        }
                    });
                    ctx.addOntologyClassTemplate(name, oct);
                } else
                    throw new BuildException("template: " + name + " does not implement suitable interface");
            } catch (ClassNotFoundException e) {
                throw new BuildException(e);
            } catch (InstantiationException e) {
                throw new BuildException(e);
            } catch (IllegalAccessException e) {
                throw new BuildException(e);
            }
        }
        try {
            gen.run();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException(e);
        }
    }

    /**
     * Get the destination directory for this task
     * 
     * @return the destination directory for this task
     */
    public File getDestdir() {
        return destdir;
    }

    /**
     * Set the destination directory for this task
     * 
     * @param destdir
     *            the destination directory for this task
     */
    public void setDestdir(File destdir) {
        this.destdir = destdir;
    }

    /**
     * Return true if a cache should be created in the factory
     * 
     * @return true if a cache should be created in the factory
     */
    public boolean isGenerateCacheInFactory() {
        return generateCacheInFactory;
    }

    /**
     * Set if a cache should be created in the factory
     * 
     * @param generateCacheInFactory
     *            set if a cache should be created in the factory
     */
    public void setGenerateCacheInFactory(boolean generateCacheInFactory) {
        this.generateCacheInFactory = generateCacheInFactory;
    }

    /**
     * Return true if listeners should be generated for the jastor objects
     * 
     * @return true if listeners should be generated for the jastor objects
     */
    public boolean isGenerateListeners() {
        return generateListeners;
    }

    /**
     * Set if listeners should be generated for the jastor objects
     * 
     * @param generateListeners
     *            set if listeners should be generated for the jastor objects
     */
    public void setGenerateListeners(boolean generateListeners) {
        this.generateListeners = generateListeners;
    }

    /**
     * Return true if the jastor objects should only be vocabulary files
     * 
     * @return true if the jastor objects should only be vocabulary files
     */
    public boolean isGenerateVocublaryOnly() {
        return generateVocublaryOnly;
    }

    /**
     * Set if the jastor objects should only be vocabulary files
     * 
     * @param generateVocublaryOnly
     *            set the jastor objects should only be vocabulary files
     */
    public void setGenerateVocublaryOnly(boolean generateVocublaryOnly) {
        this.generateVocublaryOnly = generateVocublaryOnly;
    }

    /**
     * Get the OntologyElements for this task
     * 
     * @return the OntologyElements for this task
     */
    public List<OntologyElement> getOntologies() {
        return ontologies;
    }

    /**
     * Set the OntologyElements for this task
     * 
     * @param ontologies
     *            OntologyElements for this task
     */
    public void setOntologies(List<OntologyElement> ontologies) {
        this.ontologies = ontologies;
    }

    /**
     * Get the custom thing for this task
     * 
     * @return the custom thing for this task
     * @throws JastorException
     */
    public CustomThingElement getCustomThing() throws JastorException {
        if (customThing.isEmpty())
            return null;
        if (customThing.size() > 1)
            throw new JastorException("Only one custom Thing may be defined");
        return customThing.get(0);
    }

    /**
     * Get the base types for this task
     * 
     * @return the base types for this task
     * @throws JastorException
     */
    public BaseTypesElement getBaseTypes() throws JastorException {
        if (baseTypes.isEmpty())
            return null;
        if (baseTypes.size() > 1)
            throw new JastorException("Only one base types element may be defined");
        return baseTypes.get(0);
    }

    /**
     * Get if this task should use the entire URI for identifiers
     * 
     * @return if this task should use the entire URI for identifiers
     */
    public boolean isUseEntireURIForIdentifiers() {
        return useEntireURIForIdentifiers;
    }

    /**
     * Set if this task should use the entire URI for identifiers
     * 
     * @param useEntireURIForIdentifiers
     *            set if this task should use the entire URI for identifiers
     */
    public void setUseEntireURIForIdentifiers(boolean useEntireURIForIdentifiers) {
        this.useEntireURIForIdentifiers = useEntireURIForIdentifiers;
    }

    /**
     * Get if this task should use package names for restricted ranges
     * 
     * @return if this task should use package names for restricted ranges
     */
    public boolean isUsePackageNamesForRestrictedRanges() {
        return usePackageNamesForRestrictedRanges;
    }

    /**
     * Set if this task should use package names for restricted ranges
     * 
     * @param usePackageNamesForRestrictedRanges
     *            set if this task should use package names for restricted ranges
     */
    public void setUsePackageNamesForRestrictedRanges(boolean usePackageNamesForRestrictedRanges) {
        this.usePackageNamesForRestrictedRanges = usePackageNamesForRestrictedRanges;
    }

    /**
     * Get if this task should use strict type checking
     * 
     * @return if this task should use strict type checking
     */
    public boolean isUseStrictTypeChecking() {
        return useStrictTypeChecking;
    }

    /**
     * Set if this task should use strict type checking
     * 
     * @param useStrictTypeChecking
     *            set if this task should use strict type checking
     */
    public void setUseStrictTypeChecking(boolean useStrictTypeChecking) {
        this.useStrictTypeChecking = useStrictTypeChecking;
    }

    /**
     * Get if Thing should extend Resource
     * 
     * @return if Thing should extend Resource
     */
    public boolean isThingExtendsResource() {
        return this.thingExtendsResource;
    }

    /**
     * Set if Thing should extend Resource
     * 
     * @param thingExtendsResource
     */
    public void setThingExtendsResource(boolean thingExtendsResource) {
        this.thingExtendsResource = thingExtendsResource;
    }

    /**
     * Get if task should generate standard code
     * 
     * @return if task should generate standard code
     */
    public boolean isGenerateStandardCode() {
        return generateStandardCode;
    }

    /**
     * Set if task should generate standard code
     * 
     * @param generateStandardCode
     *            set if task should generate standard code
     */
    public void setGenerateStandardCode(boolean generateStandardCode) {
        this.generateStandardCode = generateStandardCode;
    }

    /**
     * Get if task should use typed literals
     * 
     * @return if task should use typed literals
     */
    public boolean isUseTypedLiterals() {
        return useTypedLiterals;
    }

    /**
     * Set if task should use typed literals
     * 
     * @param useTypedLiterals
     *            set if task should use typed literals
     */
    public void setUseTypedLiterals(boolean useTypedLiterals) {
        this.useTypedLiterals = useTypedLiterals;
    }

    /**
     * Get if all RDF types should be added to a classes hierarchy
     * 
     * @return true if all RDF types should be added to a classes hierarchy
     */
    public boolean isAddAllRDFTypesInHierarchy() {
        return addAllRDFTypesInHierarchy;
    }

    /**
     * Set if all RDF types should be added to a classes hierarchy
     * 
     * @param addAllRDFTypesInHierarchy
     *            set if all RDF types should be added to a classes hierarchy
     */
    public void setAddAllRDFTypesInHierarchy(boolean addAllRDFTypesInHierarchy) {
        this.addAllRDFTypesInHierarchy = addAllRDFTypesInHierarchy;
    }

    /**
     * Add an ontologyElement to this task
     * 
     * @param ont
     *            an ontologyElement to this task
     */
    public void addOntology(OntologyElement ont) {
        ontologies.add(ont);
    }

    /**
     * Add a custom thing to this task
     * 
     * @param thing
     *            a custom thing to this task
     */
    public void addCustomThing(CustomThingElement thing) {
        customThing.add(thing);
    }

    /**
     * Add template to this task
     * 
     * @param tmp
     *            template to add to this task
     */
    public void addTemplate(TemplateElement tmp) {
        templates.add(tmp);
    }

    /**
     * Add a prefix element to this task
     * 
     * @param tmp
     *            a prefix element to this task
     */
    public void addPrefix(PrefixElement tmp) {
        prefixes.add(tmp);
    }

    /**
     * Add a BaseTypesElement to this task
     * 
     * @param baseTypeElement
     *            baseTypeElement to add to this task
     */
    public void addBaseTypes(BaseTypesElement baseTypeElement) {
        baseTypes.add(baseTypeElement);
    }
}
