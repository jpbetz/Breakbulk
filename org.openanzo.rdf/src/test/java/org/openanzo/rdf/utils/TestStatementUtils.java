/******************************************************************************* 
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *******************************************************************************/

package org.openanzo.rdf.utils;

import junit.framework.TestCase;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Test statment utils
 * 
 * @author Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 * 
 */
public class TestStatementUtils extends TestCase {

    /**
     * Test method for {@link org.openanzo.rdf.utils.StatementUtils#convertToMilliseconds(TypedLiteral)}.
     */
    @SuppressWarnings("all")
    public void testConvertToMilliseconds() {
        TypedLiteral literal = Constants.valueFactory.createLiteral("2008-07-23T05:18:16.98765324199999779+08:00", XMLSchema.DATETIME);
        assertEquals(Long.valueOf(1216761496987L), StatementUtils.convertToMilliseconds(literal));

        // Timezone is required
        literal = Constants.valueFactory.createLiteral("2008-07-23T05:18:16", XMLSchema.DATETIME);
        assertNull(StatementUtils.convertToMilliseconds(literal));

        // Full xsd:dateTime including timezone is required
        literal = Constants.valueFactory.createLiteral("2008-07-23", XMLSchema.DATE);
        assertNull(StatementUtils.convertToMilliseconds(literal));
    }

}
