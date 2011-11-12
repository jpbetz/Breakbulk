/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/inference/Ontology.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: Ontology.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.inference;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.util.graph.DFS;
import org.openanzo.rdf.jastor.util.graph.EdgeMem;
import org.openanzo.rdf.jastor.util.graph.GraphMem;
import org.openanzo.rdf.jastor.util.graph.IEdge;
import org.openanzo.rdf.jastor.util.graph.IGraph;
import org.openanzo.rdf.jastor.util.graph.INode;
import org.openanzo.rdf.jastor.util.graph.NodeMem;
import org.openanzo.rdf.owl.OWL11Factory;
import org.openanzo.rdf.rdfs.RDFSFactory;
import org.openanzo.rdf.vocabulary.OWL;
import org.openanzo.rdf.vocabulary.RDF;

/**
 * 
 * Simple class to encapsulate an ontology to be generated.
 * 
 * @author Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 * 
 */
public class Ontology {

    private final String                        pkg;

    private final JastorContext                 ctx;

    private final OntologyClass                 witness;

    private final OntologyComment               comment;

    private final org.openanzo.rdf.owl.Ontology ont;

    private final URI                           uri;

    private final List<Resource>                classes;

    private final INamedGraph                   ontGraph;

    /**
     * Create new Ontology object
     * 
     * @param ontUri
     *            ontology URI
     * @param pkg
     *            Package name for ontology
     * @param ctx
     *            parent Jastor context
     * @param classes
     *            a list of String uri's of the classes in this ontology
     */
    public Ontology(String ontUri, String pkg, JastorContext ctx, List<Resource> classes) {
        super();
        this.pkg = pkg;
        this.ctx = ctx;
        this.classes = classes;
        uri = Constants.valueFactory.createURI(ontUri);
        // possible speed up could be done here
        if (getClasses().isEmpty()) {
            System.err.println("Warning, ontology not found: " + uri);
        }
        witness = getClasses().get(0);
        INamedGraph gm = ctx.getOntGraph();
        ontGraph = ctx.getOntDataset().getNamedGraph(uri);
        ont = OWL11Factory.getOntology(uri, gm);
        if (ont != null)
            this.comment = OntologyComment.getOntologyComment(gm, ont.resource());
        else
            this.comment = OntologyComment.getOntologyComment(gm, uri);
    }

    /**
     * Get all the classes in this ontology
     * 
     * @return list of all the classes in this ontology
     */
    public List<OntologyClass> getClasses() {
        ArrayList<OntologyClass> alist = new ArrayList<OntologyClass>();
        for (Resource uri : classes) {
            OntologyClass oc = new OntologyClass(OWL11Factory.getClass(uri, ctx.getOntGraph()), ctx);
            alist.add(oc);
        }
        return alist;
    }

    /**
     * Get all the properties of all classes in the ontology. Even though we are spanning this entire ontology, we might have properties from extension classes
     * in other ontologies so we give the choice
     * 
     * @param includeExtensionClasses
     * @return collection of ontology properties
     */
    public Collection<OntologyProperty> getProperties(boolean includeExtensionClasses) {
        Set<OntologyProperty> props = new HashSet<OntologyProperty>();
        for (OntologyClass oc : getClasses()) {
            props.addAll(oc.listProperties(includeExtensionClasses));
        }
        // add any other properties..very redundant, but necessary.

        Set<URI> uris = new HashSet<URI>();
        for (OntologyProperty prop : props) {
            uris.add((URI) prop.getOntProperty().resource());
        }

        Collection<Statement> stmts = ontGraph.find(null, RDF.TYPE, RDF.Property);
        if (!stmts.isEmpty())
            stmts.addAll(ontGraph.find(null, RDF.TYPE, OWL.DATATYPEPROPERTY));
        else
            stmts = ontGraph.find(null, RDF.TYPE, OWL.DATATYPEPROPERTY);
        if (!stmts.isEmpty())
            stmts.addAll(ontGraph.find(null, RDF.TYPE, OWL.OBJECTPROPERTY));
        else
            stmts = ontGraph.find(null, RDF.TYPE, OWL.OBJECTPROPERTY);
        for (Statement stmt : stmts) {
            URI uri = (URI) stmt.getSubject();
            if (!uris.contains(uri)) {
                uris.add(uri);
                props.add(new OntologyProperty(RDFSFactory.create_Property(uri, ontGraph), ctx));
            }
        }
        return props;
    }

    /**
     * @return set of individuals in ontology
     */
    public Collection<Resource> getIndividuals() {
        Set<Resource> uris = new HashSet<Resource>();
        for (OntologyClass oc : getClasses()) {
            uris.addAll(oc.listIndividuals());
        }
        return uris;
    }

    /**
     * Return a topologically sorted list of the classes in this ontology based on the extension class-hierarchy.
     * 
     * @return a topologically sorted list of the classes in this ontology based on the extension class-hierarchy
     */
    public List<OntologyClass> getClassesSorted() {
        List<OntologyClass> classes = getClasses();
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
     * Get the package for this ontology
     * 
     * @return the package for this ontology
     */
    public String getPackage() {
        return pkg;
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
     * Get the Jastor Ontology bean for this ontology
     * 
     * @return the Jastor Ontology bean for this ontology
     */
    public org.openanzo.rdf.owl.Ontology getOntology() {
        return ont;
    }

    /**
     * Get the local name for this ontology's URI
     * 
     * @return the local name for this ontology's URI
     */
    public String getLocalName() {
        if (ont != null)
            return Constants.valueFactory.createURI(ont.uri()).getLocalName();
        return uri.getLocalName();
    }

    /**
     * Get the ontology's URI
     * 
     * @return the ontology's URI
     */
    public URI getURI() {
        return uri;
    }

    /**
     * Get the Ontology's comment
     * 
     * @return ontology's comment
     */
    public OntologyComment getComment() {
        return comment;
    }

    /**
     * Get the class name of the factory for this ontology
     * 
     * @return the class name of the factory for this ontology
     */
    public String getFactoryClassname() {
        return witness.getFactoryClassname();
    }

    /**
     * Get the full class name of the factory for this ontology
     * 
     * @return the full class name of the factory for this ontology
     */
    public String getFactoryFullClassname() {
        return witness.getFactoryFullClassname();
    }

    /**
     * Get the file for the factory
     * 
     * @param basedir
     *            directory where file is located
     * @return the file for the factory
     */
    public File getFactoryFile(File basedir) {
        return witness.getFactoryFile(basedir);
    }
}
