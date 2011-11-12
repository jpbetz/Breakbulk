/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 20, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.jastor.test.tests;

import junit.framework.TestCase;

import org.openanzo.rdf.jastor.JavaIdentifierEncoder;

/**
 * Test Encoder
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
public class EncoderTest extends TestCase {
    /**
     * Test jastor encoding
     * 
     * @throws Exception
     */
    public void testEncoder() throws Exception {
        String[] samples = new String[] { "1", "_1", "1A", "__", ":1", "~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+", "=", "if", "switch", "simple", "(@else)" };
        for (int i = 0; i < samples.length; i++) {
            String sample = samples[i];
            String encoded = JavaIdentifierEncoder.encode(sample);
            String dblEncoded = JavaIdentifierEncoder.encode(encoded);
            String dblDecoded = JavaIdentifierEncoder.decode(dblEncoded);
            String decoded = JavaIdentifierEncoder.decode(encoded);
            assertEquals(sample, decoded);
            assertEquals(encoded, dblDecoded);
        }
    }
}
