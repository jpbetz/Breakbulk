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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.JastorException;
import org.openanzo.rdf.jastor.inference.Ontology;
import org.openanzo.rdf.jastor.inference.OntologyClass;
import org.openanzo.rdf.jastor.inference.OntologyProperty;
import org.openanzo.rdf.owl.Class;
import org.openanzo.rdf.owl.OWL11Factory;
import org.openanzo.rdf.owl._Thing;
import org.openanzo.rdf.rdfs._Property;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.vocabulary.RDFS;

/**
 * Test ski test internals
 * 
 */
public class InternalsSkiTest extends TestCase {

    JastorContext ctx;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ctx = new JastorContext();
        ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources//ski.owl"), "http://jastor.openanzo.org/testonts/Ski", "org.openanzo.rdf.jastor.test.ski");
        ctx.finalizeContext();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * This is kind of a wonky, catch-all test.
     * 
     * @throws Exception
     */
    public void testGetOntologyProperites() throws Exception {
        List<OntologyClass> classes = ctx.listOntologyClassesToGenerate();
        HashMap<String, Integer> lengths = new HashMap<String, Integer>();
        lengths.put("http://jastor.openanzo.org/testonts/classes#BaseColor", 4);
        lengths.put("http://jastor.openanzo.org/testonts/classes#PipeSki", 24);
        lengths.put("http://jastor.openanzo.org/testonts/classes#Snowboard", 7);
        lengths.put("http://jastor.openanzo.org/testonts/classes#SpecialtySki", 5);
        lengths.put("http://jastor.openanzo.org/testonts/classes#TwinTip", 24);
        lengths.put("http://jastor.openanzo.org/testonts/classes#FatTwin", 26);
        lengths.put("http://jastor.openanzo.org/testonts/classes#PowderSki", 23);
        lengths.put("http://jastor.openanzo.org/testonts/classes#Ski", 20);

        for (OntologyClass c : classes) {
            List<OntologyProperty> props = c.listProperties(true);
            System.err.println(c + ":" + props.size());

            for (OntologyProperty prop : props) {
                if (prop.isLooseRestriction())
                    fail("found loose property: " + prop.getURI());
            }
            if (lengths.get(c.getURI().toString()) == null)
                continue;
            assertEquals("class + " + c + " failed: " + c.getURI().toString(), lengths.get(c.getURI().toString()).intValue(), props.size());
        }
    }

    /**
     * Test non extension properties
     * 
     * @throws Exception
     */
    public void testListNonExtensionProperties() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        Class twintip = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#PowderSki", gm);
        OntologyClass oc = new OntologyClass(twintip, ctx);
        List<OntologyProperty> list = oc.listProperties(false);
        assertEquals(6, list.size());
    }

    /**
     * Test all values from restrictions
     * 
     * @throws Exception
     */
    public void testAllValuesFromRestriction() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        Class twintip = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#TwinTip", gm);
        OntologyClass oc = new OntologyClass(twintip, ctx);
        ArrayList<String> list = new ArrayList<String>();
        for (OntologyProperty p : oc.listProperties(true)) {
            if (p.getURI().toString().endsWith("competesWith")) {
                Iterable<Resource> itr = p.listAlternativeRanges(false);
                for (Resource res : itr) {
                    list.add(p.getURI() + ":" + res.toString());
                }
            }
        }
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/predicates#competesWith:http://jastor.openanzo.org/testonts/classes#TwinTip"));
    }

    /**
     * Test get ontology for package
     */
    public void testGetOntologyForPackage() {
        assertEquals("http://jastor.openanzo.org/testonts/Ski", ctx.getOntologyForPackage("org.openanzo.rdf.jastor.test.ski").toString());
    }

    /**
     * Test cardinality restriction
     * 
     * @throws Exception
     */
    public void testCardinalityRestriction() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        Class twintip = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#TwinTip", gm);
        OntologyClass oc = new OntologyClass(twintip, ctx);
        for (OntologyProperty p : oc.listProperties(true)) {
            if (p.toString().equals("http://jastor.openanzo.org/testonts/predicates#attribute"))
                assertFalse(p.isMultiValued());
            if (p.toString().equals("http://jastor.openanzo.org/testonts/predicates#availableLength"))
                assertTrue(p.isMultiValued());
            if (p.toString().equals("http://jastor.openanzo.org/testonts/predicates#model"))
                assertFalse(p.isMultiValued());
            if (p.toString().equals("http://jastor.openanzo.org/testonts/predicates#competesWith"))
                assertTrue(p.isMultiValued());
            if (p.toString().equals("http://jastor.openanzo.org/testonts/predicates#pipeOrPark"))
                assertFalse(p.isMultiValued());
        }
    }

    /**
     * Test class names
     * 
     * @throws Exception
     */
    public void testClassNames() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        Class twintip = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#TwinTip", gm);
        OntologyClass oc = new OntologyClass(twintip, ctx);
        assertEquals("org.openanzo.rdf.jastor.test.ski.SkiFactory", oc.getFactoryFullClassname());
        assertEquals(new File(new File(".").getCanonicalFile(), "org" + File.separatorChar + "openanzo" + File.separatorChar + "rdf" + File.separatorChar + "jastor" + File.separatorChar + "test" + File.separatorChar + "ski" + File.separatorChar + "SkiFactory.java"), oc.getFactoryFile(new File("").getCanonicalFile()));
        assertEquals("org.openanzo.rdf.jastor.test.ski.TwinTipImpl", oc.getImplFullClassname());
        assertEquals(new File(new File(".").getCanonicalFile(), "org" + File.separatorChar + "openanzo" + File.separatorChar + "rdf" + File.separatorChar + "jastor" + File.separatorChar + "test" + File.separatorChar + "ski" + File.separatorChar + "TwinTipImpl.java"), oc.getImplFile(new File("").getCanonicalFile()));
        assertEquals("org.openanzo.rdf.jastor.test.ski.TwinTip", oc.getInterfaceFullClassname());
        assertEquals(new File(new File(".").getCanonicalFile(), "org" + File.separatorChar + "openanzo" + File.separatorChar + "rdf" + File.separatorChar + "jastor" + File.separatorChar + "test" + File.separatorChar + "ski" + File.separatorChar + "TwinTip.java"), oc.getInterfaceFile(new File("").getCanonicalFile()));
        assertEquals("org.openanzo.rdf.jastor.test.ski.TwinTipListener", oc.getListenerFullClassname());
        assertEquals(new File(new File(".").getCanonicalFile(), "org" + File.separatorChar + "openanzo" + File.separatorChar + "rdf" + File.separatorChar + "jastor" + File.separatorChar + "test" + File.separatorChar + "ski" + File.separatorChar + "TwinTipListener.java"), oc.getListenerFile(new File("").getCanonicalFile()));
    }

    /**
     * Test thing names
     * 
     * @throws Exception
     */
    public void testThingNames() throws Exception {
        OntologyClass oc = new OntologyClass(ctx);
        assertEquals("org.openanzo.rdf.jastor.ThingFactory", oc.getFactoryFullClassname());
        assertEquals("org.openanzo.rdf.jastor.ThingImpl", oc.getImplFullClassname());
        assertEquals("org.openanzo.rdf.jastor.Thing", oc.getInterfaceFullClassname());
        assertEquals("org.openanzo.rdf.jastor.ThingListener", oc.getListenerFullClassname());
    }

    /**
     * Test property names
     * 
     * @throws Exception
     */
    @SuppressWarnings("null")
    public void testPropertyNames() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        Class twintip = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#Ski", gm);
        OntologyClass oc = new OntologyClass(twintip, ctx);
        OntologyProperty prop = null;
        for (OntologyProperty p : oc.listProperties(true)) {
            if (p.getURI().equals("http://jastor.openanzo.org/testonts/predicates#attribute"))
                prop = p;
        }

        //Resource res = (Resource)prop.listAlternativeReturnTypes().next();
        assertNotNull(prop);
        assertEquals("http://jastor.openanzo.org/testonts/predicates#attribute", prop.getURI());
        assertEquals("Attribute", prop.getPropertyCapped());
        assertEquals("Attribute", prop.getPropertyCapped(OntologyProperty.DEFAULT_RANGE));
        assertEquals("attribute", prop.getPropertyName());
        assertEquals("org.openanzo.rdf.Literal", prop.getReturnType());
        assertEquals("org.openanzo.rdf.Literal", prop.getReturnType(OntologyProperty.DEFAULT_RANGE));

    }

    /**
     * Test list all extension classes
     * 
     * @throws Exception
     */
    public void testListAllExtensionclasses() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        Class fattwin = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#FatTwin", gm);
        OntologyClass oc = new OntologyClass(fattwin, ctx);
        ArrayList<String> list = new ArrayList<String>();
        for (OntologyClass ontClass : oc.listAllExtensionClasses()) {
            String s = ontClass.toString();
            //System.err.println(s);
            list.add(s);

        }
        assertEquals(4, list.size());
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#Ski"));
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#PowderSki"));
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#TwinTip"));
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#SpecialtySki"));
    }

    /**
     * Test all return types
     */
    @SuppressWarnings("null")
    public void testAllReturnTypes() {
        INamedGraph gm = ctx.getOntGraph();
        Class twintip = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#FatTwin", gm);
        OntologyClass oc = new OntologyClass(twintip, ctx);
        OntologyProperty prop = null;
        for (OntologyProperty p : oc.listProperties(true)) {
            if (p.getURI().equals("http://jastor.openanzo.org/testonts/predicates#competesWith"))
                prop = p;
        }
        assertNotNull(prop);
        Iterable<Resource> itr = prop.listAllRanges();
        ArrayList<String> list = new ArrayList<String>();
        for (Resource res : itr) {
            list.add(res.toString());
        }
        assertTrue(list.contains(OntologyProperty.DEFAULT_RANGE.toString()));
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#TwinTip"));
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#PowderSki"));
    }

    /**
     * Test alternative return types
     */
    @SuppressWarnings("null")
    public void testAlternativeReturnTypes() {
        INamedGraph gm = ctx.getOntGraph();
        Class twintip = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#FatTwin", gm);
        OntologyClass oc = new OntologyClass(twintip, ctx);
        OntologyProperty prop = null;

        for (OntologyProperty p : oc.listProperties(true)) {
            if (p.getURI().equals("http://jastor.openanzo.org/testonts/predicates#competesWith"))
                prop = p;
        }

        ArrayList<String> list = new ArrayList<String>();
        assertNotNull(prop);
        for (Resource res : prop.listAlternativeRanges(false)) {
            list.add(res.toString());
        }
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#TwinTip"));
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#PowderSki"));
    }

    /**
     * Test intersection properties
     */
    public void testIntersectionProperties() {
        INamedGraph gm = ctx.getOntGraph();
        Class si = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#PipeSki", gm);
        OntologyClass oc = new OntologyClass(si, ctx);
        for (OntologyProperty prop : oc.listProperties(true)) {
            List<Value> list = prop.getHasValueValues();
            if (!list.isEmpty()) {
                Value val = list.get(0);
                assertTrue(val instanceof Literal);
                Literal lit = (Literal) val;
                assertEquals("pipe", lit.getLabel());
            }
        }
    }

    /**
     * Test union
     * 
     * @throws Exception
     */
    public void testUnion() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        //gm.write(System.out);
        Class ps = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#PowderSki", gm);
        OntologyClass oc = new OntologyClass(ps, ctx);

        ArrayList<String> list = new ArrayList<String>();
        for (OntologyClass ontClass : oc.listImmediateExtensionClasses()) {
            String s = ontClass.toString();
            //System.err.println(s);
            list.add(s);
        }
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#SpecialtySki"));

        Class tt = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#TwinTip", gm);
        oc = new OntologyClass(tt, ctx);

        list = new ArrayList<String>();
        for (OntologyClass ontClass : oc.listImmediateExtensionClasses()) {
            list.add(ontClass.toString());
        }
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#SpecialtySki"));
    }

    /**
     * Test union domain
     * 
     * @throws Exception
     */
    public void testUnionDomain() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        List<OntologyProperty> list = ctx.getUnionDomainProperties(MemURI.create("http://jastor.openanzo.org/testonts/classes#TwinTip"));
        boolean found = false;
        for (OntologyProperty prop : list) {
            if (prop.getURI().toString().equals("http://jastor.openanzo.org/testonts/predicates#proRider")) {
                found = true;
                break;
            }
        }
        assertTrue(found);

        Class ps = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#PowderSki", gm);
        OntologyClass oc = new OntologyClass(ps, ctx);
        found = false;
        for (OntologyProperty p : oc.listProperties(false)) {
            if (p.getURI().equals("http://jastor.openanzo.org/testonts/predicates#proRider"))
                found = true;
        }
        assertTrue(found);
    }

    /**
     * Test cardinality subclass restriction
     * 
     * @throws Exception
     */
    public void testCardinalitySubclassRestrictionOnUnionDomainProperty() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        Class ps = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#PowderSki", gm);
        OntologyClass oc = new OntologyClass(ps, ctx);
        _Property prop = OWL11Factory.getObjectProperty("http://jastor.openanzo.org/testonts/predicates#designer", gm);
        OntologyProperty op = new OntologyProperty(prop, oc);
        assertTrue(op.isSingleValued());
    }

    /**
     * Test cardinality subclass restriction
     * 
     * @throws Exception
     */
    public void testCardinalitySubclassRestrictionFromUnion() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        Class ps = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#SpecialtySki", gm);
        OntologyClass oc = new OntologyClass(ps, ctx);
        _Property prop = OWL11Factory.getDatatypeProperty("http://jastor.openanzo.org/testonts/predicates#specialty", gm);
        OntologyProperty op = new OntologyProperty(prop, oc);
        assertTrue(op.isSingleValued());
    }

    /**
     * Test multiple base domain classes
     * 
     * @throws Exception
     */
    @SuppressWarnings("null")
    public void testMultipleBaseDomainClasses() throws Exception {
        INamedGraph gm = ctx.getOntGraph();
        Class twintip = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#FatTwin", gm);
        OntologyClass oc = new OntologyClass(twintip, ctx);
        OntologyProperty prop = null;
        for (OntologyProperty p : oc.listProperties(true)) {
            if (p.getURI().equals("http://jastor.openanzo.org/testonts/predicates#relative"))
                prop = p;
        }

        ArrayList<String> list = new ArrayList<String>();
        assertNotNull(prop);
        for (Resource res : prop.listRanges(true, true)) {
            list.add(res.toString());
        }
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#TwinTip"));
        assertTrue(list.contains("http://jastor.openanzo.org/testonts/classes#PowderSki"));
    }

    /**
     * Test list class sorted
     * 
     * @throws JastorException
     */
    public void testListClassSorted() throws JastorException {
        Ontology ontology = ctx.listOntologiesToGenerate().get(0);
        List<OntologyClass> classes = ontology.getClassesSorted();
        INamedGraph gm = ctx.getOntGraph();
        Class ft = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#FatTwin", gm);
        OntologyClass oc1 = new OntologyClass(ft, ctx);
        Class tt = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#TwinTip", gm);
        OntologyClass oc2 = new OntologyClass(tt, ctx);
        Class ski = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#Ski", gm);
        OntologyClass oc3 = new OntologyClass(ski, ctx);
        assertTrue(classes.indexOf(oc1) < classes.indexOf(oc2));
        assertTrue(classes.indexOf(oc2) < classes.indexOf(oc3));
    }

    /**
     * Test no domain properties
     * 
     * @throws JastorException
     */
    public void testNoDomainProperties() throws JastorException {
        INamedGraph gm = ctx.getOntGraph();
        Class ski = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#Ski", gm);
        OntologyClass oc = new OntologyClass(ski, ctx);
        for (OntologyProperty p : oc.listProperties(true)) {
            if (p.getOntProperty().getDomain() == null) {
                assertTrue(ctx.isPropetyAndClassDefinedInSameOntology(p.getOntProperty().resource(), ski.resource()));
            }
        }
    }

    /**
     * Test sub property domain range
     * 
     * @throws JastorException
     */
    public void testSubPropertyDomainRangeInheritance() throws JastorException {
        INamedGraph gm = ctx.getOntGraph();
        _Property prop = OWL11Factory.getDatatypeProperty("http://jastor.openanzo.org/testonts/predicates#coreMaterial", gm);
        assertEquals("http://jastor.openanzo.org/testonts/classes#Ski", prop.getDomain().uri());
        assertEquals("http://www.w3.org/2001/XMLSchema#string", prop.getRange().uri());
    }

    /**
     * Test list individuals
     * 
     * @throws JastorException
     */
    public void testListIndividuals() throws JastorException {
        INamedGraph gm = ctx.getOntGraph();
        Class cl = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#TwinTip", gm);
        OntologyClass oc = new OntologyClass(cl, ctx);
        List<Resource> list = oc.listIndividuals();
        assertTrue(list.contains(MemURI.create("http://jastor.openanzo.org/testonts/Ski/TeneightyLab")));
    }

    /**
     * Test same range all values
     * 
     * @throws JastorException
     */
    public void testSameRangeAndAllValuesFrom() throws JastorException {
        INamedGraph gm = ctx.getOntGraph();
        Class cl = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#Ski", gm);
        OntologyClass oc = new OntologyClass(cl, ctx);
        _Property p = OWL11Factory.getObjectProperty("http://jastor.openanzo.org/testonts/predicates#previousModel", gm);
        OntologyProperty op = new OntologyProperty(p, oc);
        Iterator<Resource> it = op.listAllRanges().iterator();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }

    /**
     * Test duplicate property prefixes
     * 
     * @throws JastorException
     */
    public void testDuplicatePropertyPrefixes() throws JastorException {
        ctx.setNamespacePrefix("http://jastor.openanzo.org/testonts/predicates#", "testonts");
        ctx.setNamespacePrefix("http://jastor.openanzo.org/altnamespace/predicates#", "alt");
        INamedGraph gm = ctx.getOntGraph();
        Class cl = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#TwinTip", gm);
        OntologyClass oc = new OntologyClass(cl, ctx);

        List<String> names = new ArrayList<String>();
        for (OntologyProperty prop : oc.listProperties(true)) {
            assertFalse(names.contains(prop.getPropertyName()));
            names.add(prop.getPropertyName());
        }
    }

    /**
     * Test sub property of different domain
     * 
     * @throws JastorException
     */
    public void testSubPropertyOfWithDifferentDomain() throws JastorException {
        INamedGraph gm = ctx.getOntGraph();
        Class cl = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#Snowboard", gm);
        OntologyClass oc = new OntologyClass(cl, ctx);
        boolean found = false;
        for (OntologyProperty prop : oc.listProperties(true)) {
            if (prop.getOntProperty().resource().toString().endsWith("availableBoardLength")) {
                found = true;
                assertEquals("http://jastor.openanzo.org/testonts/classes#Snowboard", prop.getOntProperty().getDomain().resource().toString());
                assertEquals("http://www.w3.org/2001/XMLSchema#int", prop.getOntProperty().getRange().resource().toString());
            }
        }
        assertTrue(found);
    }

    /**
     * Test xml literal
     * 
     * @throws JastorException
     */
    public void testXMLLiteralReturnType() throws JastorException {
        // first a sanity check that Jena is doing what we think it is
        //   	Model model = new ModelMem();
        //   	Resource res = model.createResource("http://example.org/res1");
        //   	Literal lit = model.createTypedLiteral("<size>10</size>",XMLLiteralType.theXMLLiteralType);
        //   	res.addProperty(Snowboard.extensionXMLProperty,lit);
        //   	Literal newlit = (Literal)res.getProperty(Snowboard.extensionXMLProperty).getObject().as(Literal.class);
        //   	assertEquals(XMLLiteralType.theXMLLiteralType.getURI(),newlit.getDatatypeURI());
        //   	assertEquals("java.lang.String",newlit.getValue().getClass().getName());
        //   	RDFDatatype type = TypeMapper.getInstance().getTypeByName(XMLLiteralType.theXMLLiteralType.getURI());
        //   	assertNull(type.getJavaClass());

        INamedGraph gm = ctx.getOntGraph();
        Class cl = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#Snowboard", gm);
        OntologyClass oc = new OntologyClass(cl, ctx);
        _Property op = OWL11Factory.getDatatypeProperty("http://jastor.openanzo.org/testonts/predicates#extensionXML", gm);
        OntologyProperty prop = new OntologyProperty(op, oc);
        assertEquals("java.lang.String", prop.getReturnType());
    }

    /**
     * Test open domain property
     * 
     * @throws JastorException
     */
    public void testOpenDomainProperties() throws JastorException {
        INamedGraph gm = ctx.getOntGraph();
        Class cl = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#Ski", gm);
        OntologyClass oc = new OntologyClass(cl, ctx);
        int count = 0;
        for (OntologyProperty prop : oc.listProperties(false)) {
            if (prop.getOntProperty().getDomain() != null && prop.getOntProperty().getDomain().resource() instanceof BlankNode)
                continue;
            if (prop.getOntProperty().getDomain() == null || prop.getOntProperty().getDomain().resource().equals(_Thing.TYPE) || prop.getOntProperty().getDomain().resource().equals(RDFS.RESOURCE))
                count++;
        }
        assertEquals(4, count);
    }

    /**
     * Test enumeration classes
     * 
     * @throws JastorException
     */
    public void testEnumeratedClasses() throws JastorException {
        INamedGraph gm = ctx.getOntGraph();
        Class cl = OWL11Factory.getClass("http://jastor.openanzo.org/testonts/classes#BaseColor", gm);

        assertTrue(cl.getOneOf() != null);
        OntologyClass oc = new OntologyClass(cl, ctx);
        assertEquals(3, oc.listIndividuals().size());
    }

    /**
     * Test anonymous enumerated classes
     * 
     * @throws JastorException
     */
    public void testAnonymousEnumeratedClasses() throws JastorException {
        boolean found = false;
        for (OntologyClass c : ctx.listOntologyClassesToGenerate()) {
            if (c.getURI().toString().equals("http://jastor.openanzo.org/gen#SidewallEnum")) {
                found = true;
                assertEquals(3, c.listIndividuals().size());
            }
        }
        assertTrue(found);
    }

}
