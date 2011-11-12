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

import java.util.Iterator;

import junit.framework.TestCase;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.jastor.Thing;
import org.openanzo.rdf.jastor.collections.Collection;
import org.openanzo.rdf.jastor.collections.CollectionsFactory;
import org.openanzo.rdf.jastor.collections.OrderedCollection;
import org.openanzo.rdf.jastor.collections.util.CollectionWrapper;
import org.openanzo.rdf.jastor.test.ski.Ski;
import org.openanzo.rdf.jastor.test.ski.SkiFactory;

/**
 * Test collection wrappers
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class CollectionWrapperTest extends TestCase {

    private static final URI GRAPH = Constants.valueFactory.createURI("http://graph1");

    /**
     * Test ordered list of literals
     * 
     * @throws Exception
     */
    public void testOrderedLiteralCollection() throws Exception {

        INamedGraph graph = new NamedGraph(GRAPH);
        OrderedCollection oc = CollectionsFactory.createOrderedCollection("test:oc", graph);
        CollectionWrapper cw = new CollectionWrapper(oc);
        cw.add("Dan");
        cw.add("Ben");
        cw.add("Joe");
        assertEquals(3, cw.size());

        cw.iterator();
        assertTrue(cw.contains("Dan"));
        assertTrue(cw.contains("Ben"));
        assertTrue(cw.contains("Joe"));

        assertFalse(cw.isEmpty());

        cw.remove("Ben");
        assertEquals(2, cw.size());
        assertTrue(cw.contains("Dan"));
        assertFalse(cw.contains("Ben"));
        assertTrue(cw.contains("Joe"));

        cw.remove("Dan");
        assertEquals(1, cw.size());
        assertFalse(cw.contains("Dan"));
        assertFalse(cw.contains("Ben"));
        assertTrue(cw.contains("Joe"));

        @SuppressWarnings("unchecked")
        Iterator iter = cw.iterator();
        assertTrue(iter.hasNext());
        assertTrue(iter.next().equals("Joe"));

        cw.remove("Joe");
        assertEquals(0, cw.size());
        assertFalse(cw.contains("Dan"));
        assertFalse(cw.contains("Ben"));
        assertFalse(cw.contains("Joe"));

    }

    /**
     * Test ordered resource collection
     * 
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void testOrderedResourceCollection() throws Exception {
        INamedGraph graph = new NamedGraph(GRAPH);
        OrderedCollection oc = CollectionsFactory.createOrderedCollection("test:oc", graph);
        CollectionWrapper cw = new CollectionWrapper(oc);

        Ski s1 = SkiFactory.createSki("test:ski1", graph);
        Ski s2 = SkiFactory.createSki("test:ski2", graph);
        Ski s3 = SkiFactory.createSki("test:ski3", graph);

        cw.add(s1);
        cw.add(s2);
        cw.add(s3);
        assertEquals(3, cw.size());
        Iterator iter = cw.iterator();
        while (iter.hasNext()) {
            Thing thing = (Thing) iter.next();
            assertTrue(thing.uri().equals(s1.uri()) || thing.uri().equals(s2.uri()) || thing.uri().equals(s3.uri()));
        }

        CollectionWrapper cw2 = new CollectionWrapper(oc, SkiFactory.class);
        Iterator iter2 = cw2.iterator();
        while (iter2.hasNext()) {
            Object obj = iter2.next();
            assertTrue(Ski.class.isInstance(obj));
        }

        assertTrue(cw.contains(s1));
        assertTrue(cw.contains(s2));
        assertTrue(cw.contains(s3));

        assertFalse(cw.isEmpty());

        cw.remove(s2);
        assertEquals(2, cw.size());
        assertTrue(cw.contains(s1));
        assertFalse(cw.contains(s2));
        assertTrue(cw.contains(s3));

        cw.remove(s1);
        assertEquals(1, cw.size());
        assertFalse(cw.contains(s1));
        assertFalse(cw.contains(s2));
        assertTrue(cw.contains(s3));

        cw.remove(s3);
        assertEquals(0, cw.size());
        assertFalse(cw.contains(s1));
        assertFalse(cw.contains(s2));
        assertFalse(cw.contains(s3));

    }

    /**
     * Test literal collection
     * 
     * @throws Exception
     */
    public void testLiteralCollection() throws Exception {
        INamedGraph graph = new NamedGraph(GRAPH);
        Collection c = CollectionsFactory.createCollection("test:oc", graph);
        CollectionWrapper cw = new CollectionWrapper(c);
        cw.add("Dan");
        cw.add("Ben");
        cw.add("Joe");
        assertEquals(3, cw.size());

        assertTrue(cw.contains("Dan"));
        assertTrue(cw.contains("Ben"));
        assertTrue(cw.contains("Joe"));

        assertFalse(cw.isEmpty());

        cw.remove("Ben");
        assertEquals(2, cw.size());
        assertTrue(cw.contains("Dan"));
        assertFalse(cw.contains("Ben"));
        assertTrue(cw.contains("Joe"));

        cw.remove("Dan");
        assertEquals(1, cw.size());
        assertFalse(cw.contains("Dan"));
        assertFalse(cw.contains("Ben"));
        assertTrue(cw.contains("Joe"));

        cw.remove("Joe");
        assertEquals(0, cw.size());
        assertFalse(cw.contains("Dan"));
        assertFalse(cw.contains("Ben"));
        assertFalse(cw.contains("Joe"));

    }

    /**
     * Test resource collection
     * 
     * @throws Exception
     */
    public void testResourceCollection() throws Exception {
        INamedGraph graph = new NamedGraph(GRAPH);
        Collection oc = CollectionsFactory.createCollection("test:oc", graph);
        CollectionWrapper cw = new CollectionWrapper(oc);

        Ski s1 = SkiFactory.createSki("test:ski1", graph);
        Ski s2 = SkiFactory.createSki("test:ski2", graph);
        Ski s3 = SkiFactory.createSki("test:ski3", graph);

        cw.add(s1);
        cw.add(s2);
        cw.add(s3);
        assertEquals(3, cw.size());

        @SuppressWarnings("unchecked")
        Iterator iter = cw.iterator();
        while (iter.hasNext()) {
            Thing thing = (Thing) iter.next();
            assertTrue(thing.uri().equals(s1.uri()) || thing.uri().equals(s2.uri()) || thing.uri().equals(s3.uri()));
        }

        assertTrue(cw.contains(s1));
        assertTrue(cw.contains(s2));
        assertTrue(cw.contains(s3));

        assertFalse(cw.isEmpty());

        cw.remove(s2);
        assertEquals(2, cw.size());
        assertTrue(cw.contains(s1));
        assertFalse(cw.contains(s2));
        assertTrue(cw.contains(s3));

        cw.remove(s1);
        assertEquals(1, cw.size());
        assertFalse(cw.contains(s1));
        assertFalse(cw.contains(s2));
        assertTrue(cw.contains(s3));

        cw.remove(s3);
        assertEquals(0, cw.size());
        assertFalse(cw.contains(s1));
        assertFalse(cw.contains(s2));
        assertFalse(cw.contains(s3));

    }

    /**
     * Test ordered resource collection with dynamic typing
     * 
     * @throws Exception
     */
    public void testOrderedResourceCollectionDynamicTyping() throws Exception {
        INamedGraph graph = new NamedGraph(GRAPH);
        OrderedCollection oc = CollectionsFactory.createOrderedCollection("test:oc", graph);
        CollectionWrapper cw = new CollectionWrapper(oc, SkiFactory.class);

        Ski s1 = SkiFactory.createSki("test:ski1", graph);
        Ski s2 = SkiFactory.createSki("test:ski2", graph);
        Ski s3 = SkiFactory.createSki("test:ski3", graph);

        cw.add(s1);
        cw.add(s2);
        cw.add(s3);
        assertEquals(3, cw.size());

        @SuppressWarnings("unchecked")
        Iterator it = cw.iterator();
        int i = 0;
        Ski[] skis = new Ski[] { s1, s2, s3 };
        while (it.hasNext()) {
            assertTrue(it.next().equals(skis[i++]));
        }

    }

    private int sizeByIterator(CollectionWrapper cw) throws Exception {
        @SuppressWarnings("unchecked")
        Iterator iter = cw.iterator();
        int size = 0;
        while (iter.hasNext()) {
            size++;
            iter.next();
        }
        return size;
    }

    /**
     * Test wrapping existing collection
     * 
     * @throws Exception
     */
    public void testWrappingExistingCollection() throws Exception {
        INamedGraph graph = new NamedGraph(GRAPH);
        OrderedCollection oc = CollectionsFactory.createOrderedCollection("test:oc", graph);
        CollectionWrapper cw1 = new CollectionWrapper(oc, SkiFactory.class);

        Ski s1 = SkiFactory.createSki("test:ski1", graph);
        Ski s2 = SkiFactory.createSki("test:ski2", graph);
        Ski s3 = SkiFactory.createSki("test:ski3", graph);

        cw1.add(s1);
        cw1.add(s2);
        cw1.add(s3);

        assertEquals(3, sizeByIterator(cw1));

        CollectionWrapper cw2 = new CollectionWrapper(oc, SkiFactory.class);

        Ski s4 = SkiFactory.createSki("test:ski4", graph);

        cw2.add(s4);

        assertEquals(4, sizeByIterator(cw2));
        assertEquals(4, sizeByIterator(cw1));
    }

}
