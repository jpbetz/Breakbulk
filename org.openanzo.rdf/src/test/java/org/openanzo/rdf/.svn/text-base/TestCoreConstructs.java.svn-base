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

import java.util.UUID;

import junit.framework.TestCase;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Coverage test for core statement,literal, and valuefactory operations
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class TestCoreConstructs extends TestCase {

    /**
     * Coverage test for AnzoContextStatementsImpl
     * 
     * @throws Exception
     */
    public void testContextStatements() throws Exception {
        AnzoRuntimeException e = null;
        AssertionError ae = null;
        try {
            Constants.valueFactory.createStatement(null, null, null, null);
        } catch (AnzoRuntimeException are) {
            e = are;
        } catch (AssertionError ase) {
            ae = ase;
        }
        if (ae == null && e != null) {
            assertNotNull(e);
            assertEquals(ExceptionConstants.CLIENT.NO_NULL_VALUES, e.getErrorCode());
        }
        Statement stmt = new Statement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        Statement stmt2 = new Statement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        Statement stmt3 = new Statement(Constants.valueFactory.createURI("http://test2"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        new Statement(Constants.valueFactory.createURI("http://test2"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        assertFalse(stmt.equals("test"));
        assertTrue(stmt.equals(stmt2));
        assertTrue(stmt.equals(stmt));
        assertFalse(stmt.equals(stmt3));
        assertFalse(-1 == stmt.hashCode());
        assertFalse(-1 == stmt.hashCode());
        URI testURI = Constants.valueFactory.createURI("http://test");
        e = null;
        ae = null;
        try {
            Constants.valueFactory.createStatement(null, null, null);
        } catch (AnzoRuntimeException are) {
            e = are;
        } catch (AssertionError ase) {
            ae = ase;
        }
        if (ae == null && e != null) {
            assertNotNull(e);
            assertEquals(ExceptionConstants.CLIENT.NO_NULL_VALUES, e.getErrorCode());
        }
        e = null;
        ae = null;
        try {
            Constants.valueFactory.createStatement(testURI, null, null);
        } catch (AnzoRuntimeException are) {
            e = are;
        } catch (AssertionError ase) {
            ae = ase;
        }
        if (ae == null && e != null) {
            assertNotNull(e);
            assertEquals(ExceptionConstants.CLIENT.NO_NULL_VALUES, e.getErrorCode());
        }
        e = null;
        ae = null;
        try {
            Constants.valueFactory.createStatement(null, testURI, null);
        } catch (AnzoRuntimeException are) {
            e = are;
        } catch (AssertionError ase) {
            ae = ase;
        }
        if (ae == null && e != null) {
            assertNotNull(e);
            assertEquals(ExceptionConstants.CLIENT.NO_NULL_VALUES, e.getErrorCode());
        }
        e = null;
        ae = null;
        try {
            Constants.valueFactory.createStatement(testURI, testURI, null);
        } catch (AnzoRuntimeException are) {
            e = are;
        } catch (AssertionError ase) {
            ae = ase;
        }
        if (ae == null && e != null) {
            assertNotNull(e);
            assertEquals(ExceptionConstants.CLIENT.NO_NULL_VALUES, e.getErrorCode());
        }
        e = null;
        ae = null;
        try {
            Constants.valueFactory.createStatement(null, null, testURI);
        } catch (AnzoRuntimeException are) {
            e = are;
        } catch (AssertionError ase) {
            ae = ase;
        }
        if (ae == null && e != null) {
            assertNotNull(e);
            assertEquals(ExceptionConstants.CLIENT.NO_NULL_VALUES, e.getErrorCode());
        }
        e = null;
        ae = null;
        try {
            Constants.valueFactory.createStatement(testURI, null, testURI);
        } catch (AnzoRuntimeException are) {
            e = are;
        } catch (AssertionError ase) {
            ae = ase;
        }
        if (ae == null && e != null) {
            assertNotNull(e);
            assertEquals(ExceptionConstants.CLIENT.NO_NULL_VALUES, e.getErrorCode());
        }
        e = null;
        ae = null;
        try {
            Constants.valueFactory.createStatement(null, testURI, testURI);
        } catch (AnzoRuntimeException are) {
            e = are;
        } catch (AssertionError ase) {
            ae = ase;
        }
        if (ae == null && e != null) {
            assertNotNull(e);
            assertEquals(ExceptionConstants.CLIENT.NO_NULL_VALUES, e.getErrorCode());
        }
    }

    /**
     * Coverage test for AnzoValueFactory
     * 
     * @throws Exception
     */
    @SuppressWarnings("null")
    public void testValueFactory() throws Exception {
        Constants.valueFactory.createResource("http://test");
        Constants.valueFactory.createResource("_:b0");
        Constants.valueFactory.createBNode();
        Constants.valueFactory.createBNode("0");
        Constants.valueFactory.createBNode("_:b0");
        TypedLiteral lit = Constants.valueFactory.createLiteral(false);
        assertEquals(XMLSchema.BOOLEAN, lit.getDatatypeURI());
        lit = Constants.valueFactory.createLiteral((byte) 0);
        assertEquals(XMLSchema.BYTE, lit.getDatatypeURI());
        lit = Constants.valueFactory.createLiteral(0.0);
        assertEquals(XMLSchema.DOUBLE, lit.getDatatypeURI());
        lit = Constants.valueFactory.createLiteral((float) 0.0);
        assertEquals(XMLSchema.FLOAT, lit.getDatatypeURI());
        lit = Constants.valueFactory.createLiteral(0);
        assertEquals(XMLSchema.INT, lit.getDatatypeURI());
        lit = Constants.valueFactory.createLiteral((long) 0);
        assertEquals(XMLSchema.LONG, lit.getDatatypeURI());
        lit = Constants.valueFactory.createLiteral((short) 0);
        assertEquals(XMLSchema.SHORT, lit.getDatatypeURI());
        PlainLiteral plain = Constants.valueFactory.createLiteral("label");
        lit = Constants.valueFactory.createTypedLiteral("label");
        assertEquals(XMLSchema.STRING, lit.getDatatypeURI());
        plain = Constants.valueFactory.createLiteral("test", "EN");
        assertEquals("EN", plain.getLanguage());

        {
            boolean exceptionCaught = false;
            try {
                lit = Constants.valueFactory.createLiteral("test", (URI) null);
            } catch (Exception e) {
                exceptionCaught = true;
            }
            assertTrue(exceptionCaught);
        }

        plain = Constants.valueFactory.createLiteral("test", (String) null);
        assertNull(plain.getLanguage());

        {
            boolean exceptionCaught = false;
            try {
                lit = Constants.valueFactory.createTypedLiteral(UUID.randomUUID());
            } catch (Exception e) {
                exceptionCaught = true;
            }
            assertTrue(exceptionCaught);
        }

        try {
            Constants.valueFactory.createLiteral(null, (String) null);
            MemPlainLiteral.create(null);
        } catch (AssertionError ae) {
        }
        Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        Constants.valueFactory.createMatchStatement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        Constants.valueFactory.createMatchStatement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        Constants.valueFactory.createMatchStatement(Constants.valueFactory.createURI("http://test"), null, null, null);
        Constants.valueFactory.createMatchStatement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), null, null);
        Constants.valueFactory.createMatchStatement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), null);
        Constants.valueFactory.createMatchStatement(Constants.valueFactory.createURI("http://test"), null, Constants.valueFactory.createURI("http://test"), null);
        Constants.valueFactory.createMatchStatement(Constants.valueFactory.createURI("http://test"), null, Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        Constants.valueFactory.createMatchStatement(Constants.valueFactory.createURI("http://test"), null, null, Constants.valueFactory.createURI("http://test"));
        Constants.valueFactory.createMatchStatement(null, Constants.valueFactory.createURI("http://test"), null, null);
        Constants.valueFactory.createMatchStatement(null, Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), null);
        Constants.valueFactory.createMatchStatement(null, Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        Constants.valueFactory.createMatchStatement(null, null, Constants.valueFactory.createURI("http://test"), null);
        Constants.valueFactory.createMatchStatement(null, null, Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://test"));
        Constants.valueFactory.createMatchStatement(null, null, null, Constants.valueFactory.createURI("http://test"));
        Constants.valueFactory.createMatchStatement(Constants.valueFactory.createURI("http://test"), null, null, null);
        AnzoRuntimeException are = null;
        try {
            Constants.valueFactory.createURI("http:// test ");
        } catch (AnzoRuntimeException e) {
            are = e;
        }
        assertNotNull(are);
        assertEquals(ExceptionConstants.CLIENT.SPACE_IN_URI, are.getErrorCode());
        Constants.valueFactory.createURI("http://", "test");
    }
}
