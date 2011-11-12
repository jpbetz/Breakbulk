/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 7, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.exceptions;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class TestExceptions extends TestCase {
    /**
     * Test the creation of exceptions
     * 
     * @throws Exception
     */
    public void testExceptionCreation() throws Exception {
        new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES).getMessage();
        new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, new Exception("Test")).getMessage();
        new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1").getMessage();
        new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1", "testParam2").getMessage();
        new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1", "testParam2", "testParam3").getMessage();
        new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1", "testParam2", "testParam3", "testParam4").getMessage();

        assertEquals(2, new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1", "testParam2").getArgs().length);
        assertEquals(ExceptionConstants.CLIENT.NO_NULL_VALUES, new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES).getErrorCode());
    }

    /**
     * Test the compound exceptions
     * 
     * @throws Exception
     */
    public void testCompoundExceptionCreation() throws Exception {
        new CompoundAnzoException(new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES)).getMessage();
        new CompoundAnzoException(new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, new Exception("Test")), new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1")).getMessage();
        List<AnzoException> list = new ArrayList<AnzoException>();
        list.add(new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1", "testParam2"));
        list.add(new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1"));
        new CompoundAnzoException(list);
        assertEquals(list, new CompoundAnzoException(list).getErrors());
        new CompoundAnzoException(list, ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1", "testParam2", "testParam3");
        new CompoundAnzoException(list, ExceptionConstants.CLIENT.NO_NULL_VALUES, new Exception("Test"), "testParam1", "testParam2", "testParam3", "testParam4");

    }

    /**
     * Test the runtime exceptions
     * 
     * @throws Exception
     */
    public void testRuntimeExceptionCreation() throws Exception {
        new AnzoRuntimeException(new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES)).getMessage();
        new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_NULL_VALUES, new Exception("Test")).getMessage();
        new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1").getMessage();
        new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1", "testParam2").getMessage();
        new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1", "testParam2", "testParam3").getMessage();
        new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1", "testParam2", "testParam3", "testParam4").getAnzoException();

        assertEquals(2, new AnzoRuntimeException(new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES, "testParam1", "testParam2")).getArgs().length);
        assertEquals(ExceptionConstants.CLIENT.NO_NULL_VALUES, new AnzoRuntimeException(new AnzoException(ExceptionConstants.CLIENT.NO_NULL_VALUES)).getErrorCode());
    }

    /**
     * Test messages
     * 
     * @throws Exception
     */
    public void testMessages() throws Exception {
        assertEquals("![-1]!", Messages.getString(-1));
        assertEquals("!ExceptionConstants.test!", Messages.getString("test"));
        Messages.getString("257");
    }

    /**
     * Test asserts
     * 
     * @throws Exception
     */
    public void testAssert() throws Exception {
        Assert.isTrue(true);
        Error e = null;
        try {
            Assert.isTrue(false);
        } catch (Error re) {
            e = re;
        }
        assertNotNull(e);
    }
}
