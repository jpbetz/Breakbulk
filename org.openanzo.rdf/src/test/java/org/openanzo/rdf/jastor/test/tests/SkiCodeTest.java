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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.jastor.JastorException;
import org.openanzo.rdf.jastor.SingletonDataset;
import org.openanzo.rdf.jastor.Thing;
import org.openanzo.rdf.jastor.test.ski.BaseColor;
import org.openanzo.rdf.jastor.test.ski.FatTwin;
import org.openanzo.rdf.jastor.test.ski.FatTwinListener;
import org.openanzo.rdf.jastor.test.ski.PipeSki;
import org.openanzo.rdf.jastor.test.ski.PowderSki;
import org.openanzo.rdf.jastor.test.ski.SidewallEnum;
import org.openanzo.rdf.jastor.test.ski.Ski;
import org.openanzo.rdf.jastor.test.ski.SkiFactory;
import org.openanzo.rdf.jastor.test.ski.Snowboard;
import org.openanzo.rdf.jastor.test.ski.SpecialtySki;
import org.openanzo.rdf.jastor.test.ski.TwinTip;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Test ski code
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class SkiCodeTest extends TestCase implements FatTwinListener {
    /** copyright statement */
    public static final String copyright                      = "(C) Copyright IBM Corporation 2005  All Rights Reserved.";

    protected INamedGraph      graph;

    boolean                    attributeChanged               = false;

    boolean                    availableLengthAdded           = false;

    boolean                    availableLengthRemoved         = false;

    boolean                    competesWithAdded              = false;

    boolean                    competesWithAsPowderSkiAdded   = false;

    boolean                    competesWithAsTwinTipAdded     = false;

    boolean                    competesWithRemoved            = false;

    boolean                    competesWithAsPowderSkiRemoved = false;

    boolean                    competesWithAsTwinTipRemoved   = false;

    boolean                    coreConstructionChanged        = false;

    boolean                    flotationChanged               = false;

    boolean                    identifierChanged              = false;

    boolean                    manufacturerChanged            = false;

    boolean                    modelChanged                   = false;

    boolean                    mostSimilarToChanged           = false;

    boolean                    pipeOrParkChanged              = false;

    @Override
    public void setUp() throws Exception {

        attributeChanged = false;
        availableLengthAdded = false;
        competesWithAdded = false;
        competesWithAsPowderSkiAdded = false;
        competesWithAsTwinTipAdded = false;
        competesWithRemoved = false;
        competesWithAsPowderSkiRemoved = false;
        competesWithAsTwinTipRemoved = false;
        coreConstructionChanged = false;
        flotationChanged = false;
        identifierChanged = false;
        manufacturerChanged = false;
        modelChanged = false;
        mostSimilarToChanged = false;
        pipeOrParkChanged = false;

        graph = new NamedGraph(Constants.valueFactory.createURI("http://jastor.openanzo.org/test"));

        Ski ski = SkiFactory.createSki("skis:xscream", graph);
        ski.setCoreConstruction("foam");
        ski.setAttribute(Constants.valueFactory.createLiteral("extra hot"));
        ski.setManufacturer("Salomon");
        ski.setModel("xscream");
        ski.addAvailableLength(Integer.valueOf(165));
        ski.addAvailableLength(Integer.valueOf(175));
        ski.addAvailableLength(Integer.valueOf(185));

        Ski ski2 = SkiFactory.createSki("skis:b2", graph);
        ski.setMostSimilarTo(ski2);
        ski.addCompetesWith(ski2);

        FatTwin ft = SkiFactory.createFatTwin("skis:pocketrocket", graph);
        ft.setCoreConstruction("foam");
        ft.setAttribute(Constants.valueFactory.createLiteral("90"));
        ft.setFlotation(Integer.valueOf(8));
        ft.setManufacturer("Salomon");
        ft.setModel("Pocket Rocket");
        ft.addAvailableLength(Integer.valueOf(165));
        ft.addAvailableLength(Integer.valueOf(175));
        ft.addAvailableLength(Integer.valueOf(185));

        FatTwin ft2 = SkiFactory.createFatTwin("skis:scratchbc", graph);
        ft2.setManufacturer("Rossignol");
        ft2.setModel("Scratch BC");
        ft.setMostSimilarTo(ft2);
        ft.addCompetesWith((PowderSki) ft2);

        FatTwin ft3 = SkiFactory.createFatTwin("skis:k2seth", graph);
        ft3.setManufacturer("K2");
        ft3.setModel("Seth Pistol");
        ft.addCompetesWith((PowderSki) ft3);

        TwinTip twin = SkiFactory.createTwinTip("skis:teneighty", graph);
        twin.setModel("TenEighty");
        ft.setRelative(twin);

        SkiFactory.createTwinTip("skis:scratchfs", graph);

        PowderSki ak = SkiFactory.createPowderSki("skis:akrocket", graph);
        ak.setModel("AK Rocket");

        //writeGraph(graph, new PrintWriter(System.err));

    }

    /**
     * Test single datatype value
     * 
     * @throws Exception
     */
    public void testSingleValuedDatatypeProperties() throws Exception {
        Ski ski = SkiFactory.getSki("skis:xscream", graph);
        assertEquals("foam", ski.getCoreConstruction());
        assertEquals("extra hot", ski.getAttribute().getLabel());
        assertEquals("Salomon", ski.getManufacturer());
        assertEquals("xscream", ski.getModel());
    }

    /**
     * Test multi valued prop
     * 
     * @throws Exception
     */
    public void testMultiValuedDatatypeProperties() throws Exception {
        Ski ski = SkiFactory.getSki("skis:xscream", graph);
        Iterable<Integer> it = ski.getAvailableLength();
        Iterator<Integer> iterator = it.iterator();
        ArrayList<Integer> v = new ArrayList<Integer>();

        v.add(iterator.next());
        v.add(iterator.next());
        v.add(iterator.next());
        assertTrue(v.contains(Integer.valueOf(165)));
        assertTrue(v.contains(Integer.valueOf(175)));
        assertTrue(v.contains(Integer.valueOf(185)));
    }

    /**
     * Test multivalue datatype
     * 
     * @throws Exception
     */
    public void testMultiValuedDatatypePropertiesRemove() throws Exception {
        Ski ski = SkiFactory.getSki("skis:xscream", graph);
        ski.removeAvailableLength(Integer.valueOf(175));
        Iterable<Integer> it = ski.getAvailableLength();
        Iterator<Integer> iterator = it.iterator();
        ArrayList<Integer> v = new ArrayList<Integer>();
        v.add(iterator.next());
        v.add(iterator.next());
        //v.add(it.next());
        assertTrue(v.contains(Integer.valueOf(165)));
        assertFalse(v.contains(Integer.valueOf(175)));
        assertTrue(v.contains(Integer.valueOf(185)));
    }

    /**
     * Test single valued object
     * 
     * @throws Exception
     */
    public void testSingleValuedObjectProperties() throws Exception {
        FatTwin ft = SkiFactory.createFatTwin("skis:pocketrocket", graph);
        Ski ski = ft.getMostSimilarTo();
        assertEquals("skis:scratchbc", ski.uri());
        assertEquals("Rossignol", ski.getManufacturer());
    }

    /**
     * Test multi valued object
     * 
     * @throws Exception
     */
    public void testMultiValuedObjectProperties() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        boolean rossifound = false;
        boolean k2found = false;
        Iterator<PowderSki> it = ft.getCompetesWith_asPowderSki().iterator();
        while (it.hasNext()) {
            PowderSki ps = it.next();
            if (ps.getManufacturer().equals("Rossignol"))
                rossifound = true;
            if (ps.getManufacturer().equals("K2"))
                k2found = true;
        }

        assertTrue(rossifound);
        assertTrue(k2found);
    }

    /**
     * Test multi valued null set
     * 
     * @throws Exception
     */
    public void testSingleValuedDatatypePropertiesSetNull() throws Exception {
        Ski ski = SkiFactory.getSki("skis:xscream", graph);
        assertEquals("foam", ski.getCoreConstruction());
        ski.setCoreConstruction(null);
        assertNull(ski.getCoreConstruction());
    }

    /***
     * Test single valued object null
     * 
     * @throws Exception
     */
    public void testSingleValuedObjectPropertiesSetNull() throws Exception {
        Ski ski = SkiFactory.getSki("skis:xscream", graph);
        ski.setMostSimilarTo((Ski) null);
        assertNull(ski.getMostSimilarTo());
    }

    /**
     * Test multi value object prop remove
     * 
     * @throws Exception
     */
    public void testMultiValuedObjectPropertiesRemove() throws Exception {

        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        FatTwin ft2 = SkiFactory.getFatTwin("skis:scratchbc", graph);

        ft.removeCompetesWith((PowderSki) ft2);
        Iterator<PowderSki> it = ft.getCompetesWith_asPowderSki().iterator();
        boolean rossifound = false;
        boolean k2found = false;

        while (it.hasNext()) {
            PowderSki ps = it.next();
            if (ps.getManufacturer().equals("Rossignol"))
                rossifound = true;
            if (ps.getManufacturer().equals("K2"))
                k2found = true;
        }

        assertFalse(rossifound);
        assertTrue(k2found);
    }

    /**
     * Test listener add
     * 
     * @throws Exception
     */
    public void testListenerSingleValuedDataTypePropertyAddStatements() throws Exception {
        FatTwin ft = SkiFactory.createFatTwin("skis:pocketrocket2", graph);
        ft.registerListener(this);
        graph.add(ft.resource(), FatTwin.flotationProperty, Constants.valueFactory.createLiteral("9"));
        assertTrue(flotationChanged);
        graph.add(ft.resource(), FatTwin.attributeProperty, Constants.valueFactory.createLiteral("95"));
        assertTrue(attributeChanged);
    }

    /**
     * Test listener remove
     * 
     * @throws Exception
     */
    public void testListenerSingleValuedDataTypePropertyRemoveStatements() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        ft.registerListener(this);
        Literal lit = Constants.valueFactory.createLiteral("8", XMLSchema.INT);
        graph.remove(graph.find(ft.resource(), FatTwin.flotationProperty, lit));
        assertNull(ft.getFlotation());
        assertTrue(flotationChanged);
        graph.remove(graph.find(ft.resource(), FatTwin.attributeProperty, Constants.valueFactory.createLiteral("90")));
        assertNull(ft.getAttribute());
        assertTrue(attributeChanged);
    }

    /**
     * Test listener add
     * 
     * @throws Exception
     */
    public void testListenerSingleValuedObjectPropertyAddStatements() throws Exception {
        // use a new uri for the ski so we can add new statements
        FatTwin ft = SkiFactory.createFatTwin("skis:pocketrocket2", graph);
        ft.registerListener(this);
        SkiFactory.createFatTwin(Constants.valueFactory.createURI("skis:sethpistol"), graph);
        graph.add(ft.resource(), FatTwin.mostSimilarToProperty, Constants.valueFactory.createURI("skis:sethpistol"));
        assertTrue(mostSimilarToChanged);
        graph.add(ft.resource(), FatTwin.identifierProperty, Constants.valueFactory.createURI("skis:special"));
        assertTrue(identifierChanged);
    }

    /**
     * Test listener remove
     * 
     * @throws Exception
     */
    public void testListenerSingleValuedObjectPropertyRemoveStatements() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        ft.registerListener(this);
        graph.remove(graph.find(ft.resource(), FatTwin.mostSimilarToProperty, Constants.valueFactory.createURI("skis:scratchbc")));
        assertNull(ft.getMostSimilarTo());
        assertTrue(mostSimilarToChanged);
    }

    /**
     * Test listener multi valued
     * 
     * @throws Exception
     */
    public void testListenerMultiValuedDatatypePropertyAddStatements() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        ft.registerListener(this);
        Literal lit = Constants.valueFactory.createLiteral("195", XMLSchema.INT);
        graph.add(ft.resource(), FatTwin.availableLengthProperty, lit);
        assertTrue(availableLengthAdded);
    }

    /**
     * Test listener multi valued
     * 
     * @throws Exception
     */
    public void testListenerMultiValuedDatatypePropertyRemoveStatements() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        ft.registerListener(this);
        Literal lit = Constants.valueFactory.createLiteral("185", XMLSchema.INT);
        graph.remove(graph.find(ft.resource(), FatTwin.availableLengthProperty, lit));
        Iterator<Integer> it = ft.getAvailableLength().iterator();
        boolean found = false;
        while (it.hasNext()) {
            if (it.next().equals(Integer.valueOf(185)))
                found = true;
        }
        assertFalse(found);
        assertTrue(availableLengthRemoved);
    }

    /**
     * Test listener
     * 
     * @throws Exception
     */
    public void testListenerMultiValuedObjectPropertyAddStatements() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        ft.registerListener(this);
        SkiFactory.createFatTwin(Constants.valueFactory.createURI("skis:sethpistol"), graph);
        graph.add(ft.resource(), FatTwin.competesWithProperty, Constants.valueFactory.createURI("skis:sethpistol"));
        assertTrue(competesWithAdded);
        assertTrue(competesWithAsPowderSkiAdded);
        assertTrue(competesWithAsTwinTipAdded);
    }

    /**
     * Test listener
     * 
     * @throws Exception
     */
    public void testListenerMultiValuedObjectPropertyRemoveStatements() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        ft.registerListener(this);

        Iterator<Ski> it = ft.getCompetesWith().iterator();
        boolean found = false;
        while (it.hasNext()) {
            Ski ski = it.next();
            if (ski.uri().equals("skis:scratchbc"))
                found = true;
        }
        assertTrue(found);

        graph.remove(graph.find(ft.resource(), FatTwin.competesWithProperty, Constants.valueFactory.createURI("skis:scratchbc")));
        it = ft.getCompetesWith().iterator();
        found = false;
        while (it.hasNext()) {
            if (it.next().equals(Constants.valueFactory.createURI("skis:scratchbc")))
                found = true;
        }
        assertFalse(found);
        assertTrue(competesWithRemoved);
        assertTrue(competesWithAsPowderSkiRemoved);
        assertTrue(competesWithAsTwinTipRemoved);
    }

    /**
     * Test list statmeents
     * 
     * @throws Exception
     */
    public void testListStatements() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        Collection<Statement> stmts = ft.listStatements();
        assertEquals(18, stmts.size());
    }

    /**
     * Test remove statements
     * 
     * @throws Exception
     */
    public void testRemoveStatements() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        ft.removeStatements();
        ft.listStatements();
        assertEquals(0, ft.listStatements().size());
        assertFalse(ft.isRDFType(FatTwin.TYPE));
    }

    /**
     * Test to String
     * 
     * @throws Exception
     */
    public void testToString() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        assertTrue(ft.toString().length() > 1000);
    }

    /**
     * Test rdf type
     * 
     * @throws Exception
     */
    public void testIsRDFType() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        assertTrue(ft.isRDFType(Ski.TYPE));
        assertTrue(ft.isRDFType(TwinTip.TYPE));
        assertTrue(ft.isRDFType(PowderSki.TYPE));
    }

    /**
     * Test has value
     * 
     * @throws Exception
     */
    public void testHasValue() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        assertEquals("park", ft.getPipeOrPark());
    }

    /**
     * Test intersection
     * 
     * @throws Exception
     */
    @SuppressWarnings("cast")
    public void testIntersectionHasValue() throws Exception {
        PipeSki ps = SkiFactory.createPipeSki("skis:crslab", graph);
        assertTrue(ps instanceof TwinTip);
        assertEquals("pipe", ps.getPipeOrPark());
    }

    /**
     * Test union
     * 
     * @throws Exception
     */
    @SuppressWarnings("cast")
    public void testUnion() throws Exception {
        assertTrue(SkiFactory.createPowderSki("skis:temp", graph) instanceof SpecialtySki);
        assertTrue(SkiFactory.createTwinTip("skis:temp2", graph) instanceof SpecialtySki);
        assertTrue(SkiFactory.createFatTwin("skis:temp3", graph) instanceof SpecialtySki);
    }

    /**
     * Test strict type check
     * 
     * @throws Exception
     */
    @SuppressWarnings("cast")
    public void testStrictTypeCheckingInFactory() throws Exception {
        PipeSki ps = SkiFactory.createPipeSki("skis:crslab", graph);
        assertTrue(ps instanceof TwinTip);
        assertEquals("pipe", ps.getPipeOrPark());
        SkiFactory.getPipeSki(ps.resource(), graph);

        PipeSki ps2 = SkiFactory.getPipeSki("skis:pocketrocket", graph);
        assertNull(ps2);
    }

    /**
     * Test strict type check
     * 
     * @throws Exception
     */
    public void testStrictTypeCheckingSetResource() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        boolean caught = false;
        try {
            ft.setMostSimilarTo(Constants.valueFactory.createBNode("id1"));
        } catch (JastorException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    /**
     * Test strick type check
     * 
     * @throws Exception
     */
    public void testStrictTypeCheckingAddResource() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        boolean caught = false;
        try {
            ft.addCompetesWith(Constants.valueFactory.createBNode("id2"));
        } catch (JastorException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    /**
     * Test multiple base domains
     * 
     * @throws Exception
     */
    public void testMultipleBaseDomains() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        TwinTip twin = ft.getRelative_asTwinTip();
        assertEquals("TenEighty", twin.getModel());
    }

    /**
     * Test factory dynamic typing
     * 
     * @throws Exception
     */
    public void testFactoryDynamicTyping() throws Exception {
        Thing Thing = SkiFactory.getThing(Constants.valueFactory.createURI("skis:pocketrocket"), graph.getNamedGraphUri(), SingletonDataset.getInstance(graph));
        assertTrue(Thing instanceof FatTwin);
    }

    /**
     * Test alt range
     * 
     * @throws Exception
     */
    public void testAlternativeRangeFilteringSVOP() throws Exception {
        Ski ski = SkiFactory.getSki("skis:xscream", graph);
        TwinTip twin = SkiFactory.getTwinTip("skis:teneighty", graph);
        TwinTip twin2 = SkiFactory.getTwinTip("skis:scratchfs", graph);

        twin.setMostSimilarTo(twin2);
        assertEquals(twin2, twin.getMostSimilarTo_asTwinTip());
        twin.setMostSimilarTo(ski);
        assertNull(twin.getMostSimilarTo_asTwinTip());
        assertNotNull(twin.getMostSimilarTo());
    }

    /**
     * Test alt range
     * 
     * @throws Exception
     */
    public void testAlternativeRangeFilteringMVOP() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        TwinTip twin = SkiFactory.getTwinTip("skis:teneighty", graph);
        PowderSki ak = SkiFactory.getPowderSki("skis:akrocket", graph);
        ft.addCompetesWith(twin);
        ft.addCompetesWith(ak);

        ArrayList<String> list = new ArrayList<String>();
        Iterator<? extends Ski> it = ft.getCompetesWith().iterator();
        while (it.hasNext()) {
            Ski ski = it.next();
            list.add(ski.uri());
        }

        assertEquals(4, list.size());
        assertTrue(list.contains("skis:scratchbc"));
        assertTrue(list.contains("skis:k2seth"));
        assertTrue(list.contains("skis:akrocket"));
        assertTrue(list.contains("skis:teneighty"));

        list = new ArrayList<String>();
        it = ft.getCompetesWith_asPowderSki().iterator();
        while (it.hasNext()) {
            PowderSki ski = (PowderSki) it.next();
            list.add(ski.uri());
        }

        assertEquals(3, list.size());
        assertFalse(list.contains("skis:teneighty"));
        assertTrue(list.contains("skis:scratchbc"));
        assertTrue(list.contains("skis:k2seth"));
        assertTrue(list.contains("skis:akrocket"));

        list = new ArrayList<String>();
        it = ft.getCompetesWith_asTwinTip().iterator();
        while (it.hasNext()) {
            TwinTip ski = (TwinTip) it.next();
            list.add(ski.uri());
        }

        assertEquals(3, list.size());
        assertTrue(list.contains("skis:scratchbc"));
        assertTrue(list.contains("skis:k2seth"));
        assertTrue(list.contains("skis:teneighty"));
        assertFalse(list.contains("skis:akrocket"));
    }

    /**
     * Test alt range
     * 
     * @throws Exception
     */
    public void testAlternativeRangeFilteringMVOPListener() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        TwinTip twin = SkiFactory.getTwinTip("skis:teneighty", graph);
        SkiFactory.getPowderSki("skis:akrocket", graph);
        ft.registerListener(this);
        ft.addCompetesWith(twin);
        assertFalse(competesWithAsPowderSkiAdded);
        assertTrue(competesWithAsTwinTipAdded);

        ft.removeCompetesWith(twin);
        assertFalse(competesWithAsPowderSkiRemoved);
        assertTrue(competesWithAsTwinTipRemoved);

    }

    /**
     * We add this test because to make sure properties with resource range don't get messed up by type checking
     * 
     * @throws Exception
     */
    public void testMultiValuedPropertyWithResourceRange() throws Exception {
        FatTwin ft = SkiFactory.getFatTwin("skis:pocketrocket", graph);
        ft.addMultiIdentifier(Constants.valueFactory.createURI("test:id1"));
        ft.addMultiIdentifier(Constants.valueFactory.createURI("test:id2"));
        Iterator<Thing> it = ft.getMultiIdentifier().iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
    }

    /**
     * Test get all objects
     * 
     * @throws Exception
     */
    public void testGetAllObjects() throws Exception {
        List<Ski> list = SkiFactory.getAllSki(graph);
        assertEquals(8, list.size());
    }

    /**
     * Test long integer
     * 
     * @throws Exception
     */
    public void testLongIntegerBug() throws Exception {
        INamedGraph g = new NamedGraph(Constants.valueFactory.createURI("http://jastor.openanzo.org/test/tmp"));
        FatTwin ski = SkiFactory.createFatTwin("http://test", g);
        ski.registerListener(this);
        Literal lit = Constants.valueFactory.createLiteral("4", XMLSchema.LONG);
        g.add(ski.resource(), Ski.partnumProperty, lit);
        ski.getPartnum();

        g.add(ski.resource(), Ski.relatedPartnumProperty, lit);
        Iterator<Long> itr = ski.getRelatedPartnum().iterator();
        while (itr.hasNext()) {
            itr.next();
        }
    }

    /**
     * Test xsd:anyURI range properties
     * 
     * @throws Exception
     */
    public void testAnyURIRangeLiterals() throws Exception {
        // NOTE: This test is checked in such that a failure is expected temporarily until ticket
        // http://www.openanzo.org/projects/openanzo/ticket/854 is fixed. Once that ticket is fixed,
        // the assertion will no longer happen and the test try/catch wrapper for expected failure
        // can be removed.
        boolean testFailed = false;
        try {
            INamedGraph g = new NamedGraph(Constants.valueFactory.createURI("http://jastor.openanzo.org/test/tmp"));
            FatTwin ski = SkiFactory.createFatTwin("http://test", g);
            ski.setWebsite(Constants.valueFactory.createURI("http://example.org/a/ski/website/"));
            Collection<Statement> statements = g.find(Constants.valueFactory.createURI("http://test"), Ski.websiteProperty, null);
            assertEquals(1, statements.size());
            Statement websiteStatement = statements.iterator().next();
            Value websiteValue = websiteStatement.getObject();
            assertTrue(websiteValue instanceof TypedLiteral);
            TypedLiteral websiteLiteral = (TypedLiteral) websiteValue;
            assertEquals("http://example.org/a/ski/website/", websiteLiteral.getLabel());
            assertEquals(XMLSchema.ANYURI, websiteLiteral.getDatatypeURI());

            Literal lit = Constants.valueFactory.createLiteral("http://example.org/a/ski/website/2", XMLSchema.ANYURI);
            g.add(ski.resource(), Ski.websiteProperty, lit);
            assertEquals("http://example.org/a/ski/website/2", ski.getWebsite());
        } catch (AssertionFailedError e) {
            testFailed = true;
        }
        assertTrue(testFailed);
    }

    /**
     * Test xml literals
     * 
     * @throws Exception
     */
    public void testXMLLiteralFormats() throws Exception {
        new NamedGraph(Constants.valueFactory.createURI("http://jastor.openanzo.org/test/tmp"));
        Resource res = Constants.valueFactory.createURI("http://example.org/uri1");
        String xml = "<tag><tag2>hi</tag2></tag>";
        Literal lit = Constants.valueFactory.createLiteral(xml, RDF.XMLLiteral.toString());
        graph.add(res, Snowboard.extensionXMLProperty, lit);
        graph.add(res, RDF.TYPE, Snowboard.TYPE);

        Snowboard sb = SkiFactory.getSnowboard(res, graph);
        assertEquals(xml, sb.getExtensionXML());

        new NamedGraph(Constants.valueFactory.createURI("http://jastor.openanzo.org/test/tmp"));
        res = Constants.valueFactory.createURI("http://example.org/uri2");
        xml = "<x:foo xmlns:x=\"http://example.org/\" />";
        lit = Constants.valueFactory.createLiteral(xml, RDF.XMLLiteral.toString());
        graph.add(res, Snowboard.extensionXMLProperty, lit);
        graph.add(res, RDF.TYPE, Snowboard.TYPE);

        sb = SkiFactory.getSnowboard(res, graph);
        assertEquals(xml, sb.getExtensionXML());

    }

    /**
     * Test literal check
     * 
     * @throws Exception
     */
    public void testLiteralTypeChecking() throws Exception {
        INamedGraph g = new NamedGraph(Constants.valueFactory.createURI("http://jastor.openanzo.org/test/tmp"));
        Resource res = Constants.valueFactory.createURI("http://example.org/res1");
        TwinTip tt = SkiFactory.createTwinTip(res, graph);
        g.add(res, TwinTip.pipeOrParkProperty, Constants.valueFactory.createLiteral("pipe"));
        assertNull(tt.getPipeOrPark());

        g.add(res, TwinTip.availableLengthProperty, Constants.valueFactory.createLiteral("180"));
        Iterator<Integer> itr = tt.getAvailableLength().iterator();
        assertFalse(itr.hasNext());

    }

    /**
     * Test enumeration classes
     * 
     * @throws Exception
     */
    public void testEnumerationClasses() throws Exception {
        SkiFactory.createBaseColor(BaseColor.Black, graph);
        boolean caught = false;
        try {
            SkiFactory.createBaseColor("http://notabasecolor/", graph);
        } catch (JastorException e) {
            caught = true;
        }
        assertTrue(caught);
        SkiFactory.createBaseColor("http://jastor.openanzo.org/testonts/individuals#Grey", graph);
    }

    /**
     * Test anonymous enumeration
     * 
     * @throws Exception
     */
    public void testAnonymousEnumerationClass() throws Exception {
        Ski ski = SkiFactory.createSki(Constants.valueFactory.createBNode("id3"), graph);
        ski.setSidewall(SkiFactory.createSidewallEnum(SidewallEnum.Angled, graph));
    }

    // Listener implementation

    public void competesWithAdded(FatTwin source, PowderSki newValue) {
        competesWithAsPowderSkiAdded = true;
        assertTrue(newValue.resource().equals(Constants.valueFactory.createURI("skis:sethpistol")));
        try {
            Iterator<PowderSki> it = source.getCompetesWith_asPowderSki().iterator();
            boolean found = false;
            while (it.hasNext()) {
                PowderSki ps = it.next();
                if (ps.resource().equals(newValue.resource()))
                    found = true;
            }
            assertTrue(found);
        } catch (JastorException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void competesWithRemoved(FatTwin source, PowderSki oldValue) {
        competesWithAsPowderSkiRemoved = true;
    }

    public void flotationChanged(FatTwin source) {
        flotationChanged = true;

        try {
            if (source.getFlotation() == null)
                return;
            assertEquals(9, source.getFlotation().intValue());
        } catch (JastorException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void competesWithAdded(FatTwin source, TwinTip newValue) {
        competesWithAsTwinTipAdded = true;
        //assertTrue(newValue.resource().equals(Constants.valueFactory.createURI("skis:sethpistol")));
        try {
            Iterator<TwinTip> it = source.getCompetesWith_asTwinTip().iterator();
            boolean found = false;
            while (it.hasNext()) {
                TwinTip tt = it.next();
                if (tt.resource().equals(newValue.resource()))
                    found = true;
            }
            assertTrue(found);
        } catch (JastorException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void competesWithRemoved(FatTwin source, TwinTip oldValue) {
        competesWithAsTwinTipRemoved = true;
    }

    public void pipeOrParkChanged(FatTwin source) {
        pipeOrParkChanged = true;
    }

    public void attributeChanged(FatTwin source) {
        attributeChanged = true;
        try {
            if (source.getAttribute() == null)
                return;
            assertEquals(Constants.valueFactory.createLiteral("95"), source.getAttribute());
        } catch (JastorException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void availableLengthAdded(FatTwin source, Integer newValue) {
        availableLengthAdded = true;
        assertEquals(195, newValue.intValue());
        boolean found = false;
        try {
            Iterator<Integer> it = source.getAvailableLength().iterator();
            while (it.hasNext()) {
                if (it.next().equals(newValue))
                    found = true;
            }
            assertTrue(found);
        } catch (JastorException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void availableLengthRemoved(FatTwin source, Integer oldValue) {
        availableLengthRemoved = true;
    }

    public void competesWithAdded(FatTwin source, Ski newValue) {
        competesWithAdded = true;
        //assertTrue(newValue.resource().equals(Constants.valueFactory.createURI("skis:sethpistol")));
        try {
            Iterator<Ski> it = source.getCompetesWith().iterator();
            boolean found = false;
            while (it.hasNext()) {
                Ski ski = it.next();
                if (ski.resource().equals(newValue.resource()))
                    found = true;
            }
            assertTrue(found);
        } catch (JastorException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void competesWithRemoved(FatTwin source, Ski oldValue) {
        competesWithRemoved = true;
    }

    public void coreConstructionChanged(FatTwin source) {
        coreConstructionChanged = true;
    }

    public void identifierChanged(FatTwin source) {
        identifierChanged = true;
        try {
            assertEquals(Constants.valueFactory.createURI("skis:special"), source.getIdentifier().resource());
        } catch (JastorException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void manufacturerChanged(FatTwin source) {
        manufacturerChanged = true;
    }

    public void modelChanged(FatTwin source) {
        modelChanged = true;
    }

    public void mostSimilarToChanged(FatTwin source) {
        mostSimilarToChanged = true;
        try {
            if (source.getMostSimilarTo() == null)
                return;
            assertEquals(Constants.valueFactory.createURI("skis:sethpistol"), source.getMostSimilarTo().resource());
        } catch (JastorException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void proRiderAdded(FatTwin source, String newValue) {
    }

    public void proRiderRemoved(FatTwin source, String oldValue) {
    }

    public void designerChanged(FatTwin source) {
    }

    public void specialtyChanged(FatTwin source) {
    }

    public void relativeChanged(FatTwin source) {

    }

    public void complimentBoardAdded(FatTwin source, Thing newValue) {
    }

    public void complimentBoardRemoved(FatTwin source, Thing oldValue) {
    }

    public void coreMaterialAdded(FatTwin source, String newValue) {
    }

    public void coreMaterialRemoved(FatTwin source, String oldValue) {
    }

    public void multiIdentifierAdded(FatTwin source, Thing newValue) {
    }

    public void multiIdentifierRemoved(FatTwin source, Thing oldValue) {
    }

    public void partnumChanged(FatTwin source) {
    }

    public void relatedPartnumAdded(FatTwin source, Long newValue) {
    }

    public void relatedPartnumRemoved(FatTwin source, Long oldValue) {
    }

    public void previousModelAdded(FatTwin source, Ski newValue) {
    }

    public void previousModelRemoved(FatTwin source, Ski oldValue) {
    }

    public void ns1_modelChanged(FatTwin source) {
    }

    public void preferredStanceAdded(FatTwin source, String newValue) {
    }

    public void preferredStanceRemoved(FatTwin source, String oldValue) {
    }

    public void isAlpineAdded(FatTwin source, Boolean newValue) {
    }

    public void isAlpineRemoved(FatTwin source, Boolean oldValue) {
    }

    public void isFreestyleAdded(FatTwin source, Thing newValue) {
    }

    public void isFreestyleRemoved(FatTwin source, Thing oldValue) {
    }

    public void sidewallChanged(FatTwin source) {
    }

    public void websiteChanged(FatTwin source) {
    }

}
