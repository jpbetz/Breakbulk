/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 5, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf;

import java.util.Collection;
import java.util.Collections;

import junit.framework.TestCase;

/**
 * Coverage test for BasicGraphs
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class NamedGraphTest extends TestCase {
    /**
     * Coverage test for BasicGraph
     * 
     * @throws Exception
     */
    public void testBasicGraph() throws Exception {
        NamedGraph bg = new NamedGraph(null);
        assertNull(bg.getNamedGraphUri());
        assertEquals(0, bg.size());
        assertTrue(bg.isEmpty());
        assertFalse(bg.isClosed());
        bg.close();
        assertTrue(bg.isClosed());
        Collection<Statement> stmts = Collections.singleton(Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test")));
        URI ng = Constants.valueFactory.createURI("http://testNG");
        bg = new NamedGraph(ng);
        bg.add(stmts.toArray(new Statement[0]));
        assertEquals(ng, bg.getNamedGraphUri());
        assertEquals(1, bg.size());
        assertFalse(bg.isEmpty());
        assertFalse(bg.isClosed());
        Statement stmt1 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://test2"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        bg.add(stmt1.getSubject(), stmt1.getPredicate(), stmt1.getObject());
        NamedGraph bg2 = new NamedGraph(ng);
        bg2.add(bg.getStatements());
        assertEquals(bg.size(), bg2.size());

        bg.remove(stmts.toArray(new Statement[0]));
        assertEquals(1, bg.size());
        assertTrue(bg.contains(stmt1));
        assertTrue(bg.contains(stmt1.getSubject(), stmt1.getPredicate(), stmt1.getObject()));

        bg.remove(stmt1.getSubject(), null, null);
        assertEquals(0, bg.size());
        bg.add(stmt1);
        bg.remove(null, null, null);
        assertEquals(0, bg.size());
        bg.add(stmt1);
        bg.remove(stmt1.getSubject(), stmt1.getPredicate(), stmt1.getObject());
        assertEquals(0, bg.size());

    }
}
