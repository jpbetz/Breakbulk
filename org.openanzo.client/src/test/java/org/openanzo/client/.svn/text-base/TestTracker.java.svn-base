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
package org.openanzo.client;

import java.util.Collections;

import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;
import org.openanzo.services.ITracker;
import org.openanzo.services.impl.SelectorTracker;

/**
 * Unit tests for the Tracker class.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class TestTracker extends TestConfiguration {

    boolean deleted, deleted2;

    boolean changed, changed2;

    /**
     * Verifies a trackers getters return the correct results after a tracker is created.
     */
    public void testCreateTracker() {
        SelectorTracker tracker = new SelectorTracker(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1);
        assertEquals(Collections.<Resource> singleton(TestData.subj1), tracker.getSubject());
        assertEquals(Collections.<URI> singleton(TestData.pred1), tracker.getPredicate());
        assertEquals(Collections.<Value> singleton(TestData.obj1), tracker.getObject());
        assertEquals(Collections.<URI> singleton(TestData.graph1), tracker.getNamedGraphUri());

    }

    /**
     * For a statement add, Verify that after a listener is registered for a tracker, that a call to notifyListeners sends the correct event to the listener.
     */
    public void testNotifyAdd() {
        SelectorTracker tracker = new SelectorTracker(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1);

        tracker.addListener(listener);
        deleted = false;
        changed = false;

        tracker.notifyListeners(true, TestData.stmt1);
        assertTrue(changed);
        assertFalse(deleted);
    }

    /**
     * For a statement delete, Verify that after a listener is registered for a tracker, that a call to notifyListeners sends the correct event to the listener.
     */
    public void testNotifyDelete() {
        SelectorTracker tracker = new SelectorTracker(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1);

        deleted = false;
        changed = false;
        tracker.addListener(listener);

        tracker.notifyListeners(false, TestData.stmt1);
        assertFalse(changed);
        assertTrue(deleted);
    }

    /**
     * Verifies that if a tracker is removed by it's handle that the listener registered is unregistered and events are no longer sent to the listener.
     */
    public void testUnregistersListener() {
        SelectorTracker tracker = new SelectorTracker(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1);

        deleted = false;
        changed = false;
        tracker.addListener(listener);
        tracker.removeListener(listener);
        tracker.notifyListeners(false, TestData.stmt1);
        assertFalse(changed);
        assertFalse(deleted);
    }

    /**
     * Verifies that multiple tracker, listeners may co-exist.
     */
    public void testMultipleHandles() {
        SelectorTracker tracker = new SelectorTracker(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1);

        deleted = deleted2 = false;
        changed = changed2 = false;

        tracker.addListener(listener);
        tracker.addListener(listener2);

        tracker.notifyListeners(true, TestData.stmt1);

        assertTrue(changed);
        assertTrue(changed2);
        assertFalse(deleted);
        assertFalse(deleted2);

        deleted = deleted2 = false;
        changed = changed2 = false;

        tracker.removeListener(listener);
        tracker.notifyListeners(true, TestData.stmt1);

        assertFalse(changed);
        assertTrue(changed2);
        assertFalse(deleted);
        assertFalse(deleted2);
    }

    IStatementListener<ITracker> listener  = new IStatementListener<ITracker>() {
                                               public void statementsAdded(ITracker tracker, Statement... statement) {
                                                   changed = true;
                                               }

                                               public void statementsRemoved(ITracker tracker, Statement... tatement) {
                                                   deleted = true;
                                               }
                                           };

    IStatementListener<ITracker> listener2 = new IStatementListener<ITracker>() {
                                               public void statementsAdded(ITracker tracker, Statement... statement) {
                                                   changed2 = true;
                                               }

                                               public void statementsRemoved(ITracker tracker, Statement... tatement) {
                                                   deleted2 = true;
                                               }
                                           };
}
