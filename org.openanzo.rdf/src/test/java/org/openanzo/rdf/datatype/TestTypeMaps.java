/******************************************************************************* 
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *******************************************************************************/

package org.openanzo.rdf.datatype;

import java.sql.Timestamp;

import junit.framework.TestCase;

/**
 * @author Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 * 
 */
public class TestTypeMaps extends TestCase {

    /**
     * Ensure that the SQL timestamp conversion preserves nanosecond precision without running into the JDK bugs:
     * http://bugs.sun.com/view_bug.do?bug_id=2154623 and http://bugs.sun.com/view_bug.do?bug_id=6608696.
     * 
     * @throws Exception
     */
    public void testSQLTimestampConversion() throws Exception {
        // Thu Jul 17 17:32:24.336512127 EDT 2008 which is Thu Jul 17 21:32:24.336512127 UTC 2008
        Timestamp ts = new Timestamp(1216330344000L);
        ts.setNanos(336512127);
        TypeMaps.TMSQLTimestamp typemap = new TypeMaps.TMSQLTimestamp();
        assertEquals("2008-07-17T21:32:24.336512127Z", typemap.convertToLexicalValue(ts));

        // Thu Jul 17 17:32:24.000000001 EDT 2008 which is Thu Jul 17 21:32:24.000000001 UTC 2008
        ts = new Timestamp(1216330344000L);
        ts.setNanos(1); // If we don't account for the JDK bugs, then this can come out as 2008-07-17T21:32:24.1E-9Z
        assertEquals("2008-07-17T21:32:24.000000001Z", typemap.convertToLexicalValue(ts));

        // Thu Jul 17 17:32:24.0000001 EDT 2008 which is Thu Jul 17 21:32:24.0000001 UTC 2008
        ts = new Timestamp(1216330344000L);
        ts.setNanos(100); // Test that trailing zeroes aren't output
        assertEquals("2008-07-17T21:32:24.0000001Z", typemap.convertToLexicalValue(ts));

        // Thu Jul 17 17:32:24 EDT 2008 which is Thu Jul 17 21:32:24 UTC 2008
        ts = new Timestamp(1216330344000L);
        ts.setNanos(0); // Test that trailing zeroes aren't output
        assertEquals("2008-07-17T21:32:24Z", typemap.convertToLexicalValue(ts));
    }
}
