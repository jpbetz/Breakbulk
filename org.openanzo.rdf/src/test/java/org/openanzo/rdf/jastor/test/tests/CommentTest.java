/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.rdf.jastor.test.tests;

import java.util.List;

import junit.framework.TestCase;

import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.inference.Ontology;
import org.openanzo.rdf.jastor.inference.OntologyComment;
import org.openanzo.rdf.owl.Class;
import org.openanzo.rdf.owl.OWL11Factory;
import org.openanzo.rdf.rdfs._Property;
import org.openanzo.rdf.utils.ReadWriteUtils;

/**
 *Test jastor comments
 */
public class CommentTest extends TestCase {

    JastorContext   ctx;

    OntologyComment classComment;

    OntologyComment propComment;

    OntologyComment pkgComment;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ctx = new JastorContext();
        ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources/ski.owl"), "http://jastor.openanzo.org/testonts/Ski", "org.openanzo.rdf.jastor.test.ski");
        INamedGraph gm = ctx.getOntGraph();
        Class twintip = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#Ski", gm);
        classComment = OntologyComment.getOntologyComment(gm, twintip.resource());
        _Property manufacturer = OWL11Factory.getDatatypeProperty("http://jastor.openanzo.org/testonts/predicates#manufacturer", gm);
        propComment = OntologyComment.getOntologyComment(gm, manufacturer.resource());
        Ontology pkg = ctx.listOntologiesToGenerate().get(0);
        pkgComment = pkg.getComment();
    }

    /**
     * Test class label
     */
    public void testClassLabel() {
        assertEquals("Ski Class", classComment.getLabel());
    }

    /**
     * Test class authors
     */
    public void testClassAuthors() {
        List<String> authors = classComment.getAuthors();
        assertTrue(authors.contains("Ben Szekely"));
        assertTrue(authors.contains("Joe Betz"));
    }

    /**
     * Test dc properties
     */
    public void testClassDCProperites() {
        String[] props = classComment.listDCPropertyNames();
        assertEquals(3, props.length);
        assertEquals("Ben Szekely", classComment.getDCProperty("creator"));
        assertEquals("Ski Title", classComment.getDCProperty("title"));
        assertEquals("Joe Betz", classComment.getDCProperty("contributor"));
    }

    /**
     * Test rdfs properties
     */
    public void testClassRDFSProperties() {
        String[] props = classComment.listRDFSPropertyNames();
        assertEquals(3, props.length);
        assertEquals("This class represents the base ontology class for describing skis", classComment.getRDFSProperty("comment"));
        assertEquals("Ski Class", classComment.getRDFSProperty("label"));
    }

    /**
     * Test property label
     */
    public void testPropLabel() {
        assertEquals("Manufacturer", propComment.getLabel());
    }

    /**
     * Test property authors
     */
    public void testPropAuthors() {
        List<String> authors = propComment.getAuthors();
        assertTrue(authors.contains("Ben Szekely"));
        assertTrue(authors.contains("Joe Betz"));
    }

    /**
     * Test dc properties
     */
    public void testPropDCProperites() {
        String[] props = propComment.listDCPropertyNames();
        assertEquals(3, props.length);
        assertEquals("Ben Szekely", propComment.getDCProperty("creator"));
        assertEquals("Manufacturer Title", propComment.getDCProperty("title"));
        assertEquals("Joe Betz", propComment.getDCProperty("contributor"));
    }

    /**
     * Test RDFS properties
     */
    public void testPropRDFSProperties() {
        String[] props = propComment.listRDFSPropertyNames();
        assertEquals(2, props.length);
        assertEquals("This property indicates the manufacturer of the ski", propComment.getRDFSProperty("comment"));
        assertEquals("Manufacturer", propComment.getRDFSProperty("label"));
    }

    /**
     * Test package label
     */
    public void testPkgLabel() {
        assertEquals("Ski Ontology", pkgComment.getLabel());
    }

    /**
     * Test package authors
     */
    public void testPkgAuthors() {
        List<String> authors = pkgComment.getAuthors();
        assertTrue(authors.contains("Ben Szekely"));
        assertTrue(authors.contains("Joe Betz"));
    }

}
