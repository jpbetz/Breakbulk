/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.opensource.org/licenses/cpl.php
 *
 ******************************************************************************/

package org.openanzo.rdf.jastor.test.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import junit.framework.TestCase;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.inference.OntologyClass;
import org.openanzo.rdf.jastor.inference.OntologyProperty;
import org.openanzo.rdf.owl.Class;
import org.openanzo.rdf.owl.OWL11Factory;
import org.openanzo.rdf.utils.ReadWriteUtils;

/**
 * Test owl internals
 * 
 */
public class InternalsOWLSTest extends TestCase {
    /** Copyright statement */
    public static final String copyright = "(C) Copyright IBM Corporation 2005  All Rights Reserved.";

    private JastorContext      ctx;

    @Override
    public void setUp() {
        try {
            ctx = new JastorContext();
            ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources/owls-11/Process.owl"), "http://www.daml.org/services/owl-s/1.1/Process.owl", "org.openanzo.rdf.jastor.test.owls.process");
            ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources/owls-11/Grounding.owl"), "http://www.daml.org/services/owl-s/1.1/Grounding.owl", "org.openanzo.adtech.jastor.test.owls.grounding");
            ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources/owls-11/ObjectList.owl"), "http://www.daml.org/services/owl-s/1.1/generic/ObjectList.owl", "org.openanzo.adtech.jastor.test.owls.objectlist");
            ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources/owls-11/Expression.owl"), "http://www.daml.org/services/owl-s/1.1/generic/Expression.owl", "org.openanzo.adtech.jastor.test.owls.expression");
            ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources/owls-11/time-entry.owl"), "http://www.isi.edu/~pan/damltime/time-entry.owl", "org.openanzo.adtech.jastor.test.owls.timeentry");
            ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources/owls-11/Service.owl"), "http://www.daml.org/services/owl-s/1.1/Service.owl", "org.openanzo.adtech.jastor.test.owls.service");
            ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources/owls-11/Profile.owl"), "http://www.daml.org/services/owl-s/1.1/Profile.owl", "org.openanzo.adtech.jastor.test.owls.profile");
            ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources/owls-11/swrl.owl"), "http://www.daml.org/2003/11/swrl/swrl.owl", "org.openanzo.adtech.jastor.test.owls.swrl");
            ctx.finalizeContext();
        } catch (AnzoException e) {
            e.printStackTrace();
        }

    }

    /**
     * Test cycling duplicates
     */
    public void testCycleDuplicates() {
        INamedGraph gm = ctx.getOntGraph();
        Class c = OWL11Factory.getClass("http://www.daml.org/services/owl-s/1.1/Process.owl#Process", gm);
        OntologyClass oc = new OntologyClass(c, ctx);
        List<OntologyProperty> list = oc.listProperties(true);
        List<String> seen = new ArrayList<String>();
        for (OntologyProperty prop : list) {
            assertFalse(seen.contains(prop.getURI()));
            seen.add(prop.getURI());
        }
    }

    /**
     * This tests a problem we had with the implementation not implementing all methods
     * 
     */
    public void testCardinalityInSubClassWsdlMessageMap() {
        INamedGraph gm = ctx.getOntGraph();
        Class c = OWL11Factory.getClass("http://www.daml.org/services/owl-s/1.1/Grounding.owl#WsdlMessageMap", gm);
        OntologyClass oc = new OntologyClass(c, ctx);
        List<OntologyProperty> list = oc.listProperties(true);
        OntologyProperty prop = null;
        for (OntologyProperty p : list) {
            Resource resource = p.getOntProperty().resource();
            if (resource.toString().endsWith("owlsParameter")) {
                prop = p;
                break;
            }
        }
        assertTrue(prop != null && prop.isSingleValued());
    }

    /**
     * This tests a problem we had with the implementation not implementing all methods
     * 
     */
    @SuppressWarnings("null")
    public void testCardinalityInSubClassList() {
        INamedGraph gm = ctx.getOntGraph();
        Class c = OWL11Factory.getClass("http://www.daml.org/services/owl-s/1.1/generic/ObjectList.owl#List", gm);
        OntologyClass oc = new OntologyClass(c, ctx);
        List<OntologyProperty> list = oc.listProperties(true);
        OntologyProperty prop = null;
        for (OntologyProperty p : list) {
            if (p.getOntProperty().resource().toString().endsWith("first")) {
                prop = p;
            }
        }
        assertNotNull(prop);
        assertTrue(prop.isSingleValued());

    }

    /**
     * This tests another problem with cycles in the union hierarchy
     * 
     */
    public void testDuplicatesTimeEntry() {
        INamedGraph gm = ctx.getOntGraph();
        Class c = OWL11Factory.getClass("http://www.isi.edu/~pan/damltime/time-entry.owl#TemporalThing", gm);
        OntologyClass oc = new OntologyClass(c, ctx);
        List<OntologyProperty> list = oc.listProperties(true);
        List<String> seen = new ArrayList<String>();
        for (OntologyProperty prop : list) {
            assertFalse(seen.contains(prop.getURI()));
            seen.add(prop.getURI());
        }
    }

    /**
     * In Process.owl, the components property is initially not assigned any range at all other than an anonymouse union class of all the guys it wants to have
     * the property. However, all those guys have an all-values from restriction which was being tossed away as a loose restriction.
     */
    public void testUnionDomainProblem() {
        INamedGraph gm = ctx.getOntGraph();
        Class c = OWL11Factory.getClass("http://www.daml.org/services/owl-s/1.1/Process.owl#Sequence", gm);
        OntologyClass oc = new OntologyClass(c, ctx);
        List<OntologyProperty> list = oc.listProperties(true);
        for (OntologyProperty prop : list) {
            if (prop.getURI().equals("http://www.daml.org/services/owl-s/1.1/Process.owl#components")) {
                Iterator<Resource> it = prop.listAlternativeRanges(false).iterator();
                assertTrue("No alt range found for sequence", it.hasNext());
                while (it.hasNext())
                    assertEquals("http://www.daml.org/services/owl-s/1.1/Process.owl#ControlConstructList", it.next().toString());
                assertTrue(prop.isSingleValued());
            }
        }
    }

    /**
     * Test has value
     */
    public void testHasValue() {
        INamedGraph gm = ctx.getOntGraph();
        Class c = OWL11Factory.getClass("http://www.daml.org/services/owl-s/1.1/Process.owl#AtomicProcess", gm);
        OntologyClass oc = new OntologyClass(c, ctx);
        List<OntologyProperty> list = oc.listProperties(true);
        for (OntologyProperty prop : list) {
            if (prop.getURI().equals("http://www.daml.org/services/owl-s/1.1/Process.owl#hasClient")) {
                List<Value> l = prop.getHasValueValues();
                for (int j = 0; j < l.size(); j++) {
                    assertEquals("http://www.daml.org/services/owl-s/1.1/Process.owl#TheClient", l.get(j).toString());
                }
            }
        }
    }

    /**
     * Test intersection inheritance
     */
    public void testIntersectionInheritance() {
        INamedGraph gm = ctx.getOntGraph();
        Class c = OWL11Factory.getClass("http://www.daml.org/services/owl-s/1.1/Process.owl#CompositeProcess", gm);
        OntologyClass oc = new OntologyClass(c, ctx);
        List<OntologyClass> list = oc.listImmediateExtensionClasses();
        Vector<String> v = new Vector<String>();
        for (OntologyClass ontClass : list) {
            String s = ontClass.toString();
            v.add(s);
        }
        assertTrue(v.contains("http://www.daml.org/services/owl-s/1.1/Process.owl#Process"));
        assertEquals(1, v.size());
    }

    /**
     * Test intersection alt range
     */
    public void testIntersectionAltRange() {
        INamedGraph gm = ctx.getOntGraph();
        Class c = OWL11Factory.getClass("http://www.daml.org/services/owl-s/1.1/Process.owl#OutputBinding", gm);
        OntologyClass oc = new OntologyClass(c, ctx);
        List<OntologyProperty> props = oc.listProperties(true);
        for (OntologyProperty prop : props) {
            if (prop.toString().equals("http://www.daml.org/services/owl-s/1.1/Process.owl#toParam")) {

                Iterator<Resource> it = prop.listRanges(false, true).iterator();
                while (it.hasNext()) {
                    assertEquals("http://www.daml.org/services/owl-s/1.1/Process.owl#Output", it.next().toString());
                }
            }
        }
    }

    /**
     * Test intersection cardinality
     */
    public void testIntersectionCardinality() {
        INamedGraph gm = ctx.getOntGraph();
        Class c = OWL11Factory.getClass("http://www.daml.org/services/owl-s/1.1/Process.owl#CompositeProcess", gm);
        OntologyClass oc = new OntologyClass(c, ctx);
        List<OntologyProperty> props = oc.listProperties(true);
        for (OntologyProperty prop : props) {
            if (prop.toString().equals("http://www.daml.org/services/owl-s/1.1/Process.owl#composedOf")) {
                assertTrue(prop.isSingleValued());
            }
        }
    }

}
