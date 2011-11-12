/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Jan 3, 2008
 * Revision: $Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.rdf.utils.test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeoutException;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common utilities for testing open anzo.
 * 
 * Intentionally put in main build for a couple reasons: this class is useful to multiple projects
 * 
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class TestUtilities {

    private static final Logger log                  = LoggerFactory.getLogger(TestUtilities.class);

    private static final int    DEFAULT_WAIT_TIMEOUT = 30000;

    /**
     * Get properties from a resource bundle
     * 
     * @return properties from a resource bundle
     */
    public static Properties getProperties() {
        Properties properties = new Properties();
        ResourceBundle bundle = ResourceBundle.getBundle(TestUtilities.class.getName());

        for (Enumeration<?> keys = bundle.getKeys(); keys.hasMoreElements();) {
            String key = keys.nextElement().toString();
            properties.put(key, bundle.getString(key));
        }

        return properties;
    }

    /**
     * General purpose test data: RDF Nodes, and Statements.
     * 
     * @author Joe Betz <jpbetz@cambridgesemantics.com>
     * 
     */
    @SuppressWarnings("all")
    public static class TestData {
        public static final String    prefix    = "http://test.example.com/test#";

        public static final URI       subj1     = Constants.valueFactory.createURI(prefix + "s1");

        public static final URI       pred1     = Constants.valueFactory.createURI(prefix + "p1");

        public static final URI       pred2     = Constants.valueFactory.createURI(prefix + "p2");

        public static final URI       pred3     = Constants.valueFactory.createURI(prefix + "p3");

        public static final URI       pred4     = Constants.valueFactory.createURI(prefix + "p4");

        public static final Value     obj1      = Constants.valueFactory.createLiteral("o1");

        public static final Value     obj2      = Constants.valueFactory.createLiteral("o2");

        public static final Value     obj3      = Constants.valueFactory.createLiteral("o3");

        public static final Value     obj4      = Constants.valueFactory.createLiteral("o4");

        public static final Value     obj5      = Constants.valueFactory.createLiteral("o5");

        public static final Value     obj6      = Constants.valueFactory.createLiteral("o6");

        public static final Value     obj7      = Constants.valueFactory.createTypedLiteral(4);

        public static final Value     obj8      = Constants.valueFactory.createTypedLiteral("string");

        public static final Value     objuri1   = Constants.valueFactory.createURI(prefix + "o1");

        public static final Resource  objbnode1 = Constants.valueFactory.createBNode();

        public static final URI       graph1    = Constants.valueFactory.createURI(prefix + "namedGraph1");

        public static final URI       graph2    = Constants.valueFactory.createURI(prefix + "namedGraph2");

        public static final URI       graph3    = Constants.valueFactory.createURI(prefix + "namedGraph3");

        public static final URI       graph4    = Constants.valueFactory.createURI(prefix + "namedGraph4");

        public static final Statement stmt1     = Constants.valueFactory.createStatement(subj1, pred1, obj1, graph1);

        public static final Statement stmt2     = Constants.valueFactory.createStatement(subj1, pred2, obj2, graph2);

        public static final Statement stmt3     = Constants.valueFactory.createStatement(subj1, pred3, obj3, graph2);

        public static final Statement stmt4     = Constants.valueFactory.createStatement(subj1, pred3, obj4, graph2);

        public static final Statement stmt5     = Constants.valueFactory.createStatement(subj1, pred3, obj5, graph3);

        public static final Statement stmt6     = Constants.valueFactory.createStatement(subj1, pred3, obj6, graph3);

        public static final Statement stmt7     = Constants.valueFactory.createStatement(subj1, pred3, obj7, graph3);

        public static final Statement stmt8     = Constants.valueFactory.createStatement(subj1, pred1, objuri1, graph1);

        public static final Statement stmt9     = Constants.valueFactory.createStatement(subj1, pred1, objbnode1, graph1);

        public static final Statement stmt10    = Constants.valueFactory.createStatement(objbnode1, pred4, obj8, graph1);

        public static final URI       role1     = Constants.valueFactory.createURI("http://test.example.com/Role/myRole1");

    }

    /**
     * Blocking call that will return if the provided condition becomes true within 30 seconds, otherwise a TimedoutException is thrown.
     * 
     * @param condition
     *            condition to test
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void waitFor(AssertBlock condition) throws InterruptedException, TimeoutException {
        waitFor((Condition) condition);
    }

    /**
     * Blocking call that will return if the provided condition becomes true within 30 seconds, otherwise a TimedoutException is thrown.
     * 
     * @param condition
     *            The condition to check until it returns true or the timeout is reached.
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void waitFor(Condition condition) throws InterruptedException, TimeoutException {
        waitFor(DEFAULT_WAIT_TIMEOUT, 300, condition);
    }

    /**
     * Blocking call that will return if the provided condition becomes true within 30 seconds, otherwise a TimedoutException is thrown.
     * 
     * @param timeout
     *            time to wait
     * @param block
     *            block to check
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void waitFor(long timeout, AssertBlock block) throws InterruptedException, TimeoutException {
        waitFor(timeout, 200, block);
    }

    /**
     * Blocking call that will return if the provided condition becomes true within 30 seconds, otherwise a TimedoutException is thrown.
     * 
     * @param timeout
     *            time to wait
     * @param condition
     *            block to check
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void waitFor(long timeout, Condition condition) throws InterruptedException, TimeoutException {
        waitFor(timeout, 300, condition);
    }

    /**
     * Blocking call that will return if the provided condition becomes true before the timeout is reached, otherwise a TimedoutException is thrown.
     * 
     * @param timeout
     *            Time in milliseconds to wait for the condition to be true.
     * @param sleepTime
     *            Time to sleep between tests
     * @param condition
     *            The condition to check until it returns true or the timeout is reached.
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void waitFor(long timeout, long sleepTime, Condition condition) throws InterruptedException, TimeoutException {
        long startTime = System.currentTimeMillis();
        long currentTime;
        while (!condition.run()) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                log.debug(LogUtils.GLITTER_MARKER, "Interrupted exception while sleeping, waiting for condition.", e);
                // Do Nothing...just try waiting again.
            }
            currentTime = System.currentTimeMillis();
            if (currentTime - startTime >= timeout) {

                if (condition.error != null) {
                    StringWriter writer = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(writer);
                    condition.error.printStackTrace(printWriter);
                    printWriter.flush();
                    writer.flush();
                    throw new TimeoutException("Timeout of " + timeout + "ms expired waiting for condition to be satisfied: " + writer.toString());
                } else {
                    throw new TimeoutException("Timeout of " + timeout + "ms expired waiting for condition to be satisfied.");
                }
            }
        }
    }

    /**
     * Wait for a statement to exists or doesn't exist in a graph
     * 
     * @param timeout
     *            time to wait between checks
     * @param graph
     *            graph to check for statement
     * @param stmt
     *            statment to check
     * @param contains
     *            true if statement should or shouldn't exist
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void waitForStatement(long timeout, INamedGraph graph, Statement stmt, boolean contains) throws InterruptedException, TimeoutException {

        final INamedGraph checkGraph = graph;
        final Statement checkStmt = stmt;
        final boolean checkContains = contains;

        Condition condition = new Condition() {
            @Override
            public boolean check() {
                if (checkContains) {
                    return checkGraph.contains(checkStmt);
                } else {
                    return !checkGraph.contains(checkStmt);
                }
            }
        };
        waitFor(timeout, condition);
    }

    /**
     * Wait for a statement to exists or doesn't exist in a graph
     * 
     * @param graph
     *            graph to check for statement
     * @param stmt
     *            statment to check
     * @param contains
     *            true if statement should or shouldn't exist
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void waitForStatement(INamedGraph graph, Statement stmt, boolean contains) throws InterruptedException, TimeoutException {

        waitForStatement(DEFAULT_WAIT_TIMEOUT, graph, stmt, contains);

    }

    /**
     * Wait for a graph to reach a certain size
     * 
     * @param timeout
     *            time to wait between checks
     * @param graph
     *            graph to check for statement
     * @param size
     *            size of graph
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void waitForSize(long timeout, INamedGraph graph, long size) throws InterruptedException, TimeoutException {

        final INamedGraph checkGraph = graph;
        final long checkSize = size;

        Condition condition = new Condition() {
            @Override
            public boolean check() {
                return checkGraph.size() == checkSize;
            }
        };
        waitFor(timeout, condition);
    }

    /**
     * Wait for a graph to reach a certain size
     * 
     * @param graph
     *            graph to check for statement
     * @param size
     *            size of graph
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void waitForSize(INamedGraph graph, long size) throws InterruptedException, TimeoutException {

        waitForSize(DEFAULT_WAIT_TIMEOUT, graph, size);

    }

}
