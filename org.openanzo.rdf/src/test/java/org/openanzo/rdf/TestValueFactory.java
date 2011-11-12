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
package org.openanzo.rdf;

import java.io.StringWriter;

import junit.framework.TestCase;

import org.openanzo.rdf.adapter.RioToAnzoWriterAdapter;
import org.openanzo.rdf.vocabulary.DC;
import org.openanzo.rdf.vocabulary.FOAF;

/**
 * Test basic value Factory
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class TestValueFactory extends TestCase {
    /**
     * Test expanding prefix
     */
    public void testExpandPrefix() {
        assertEquals(MemValueFactory.defaultFactory.createURIFromCURIE("dc:title"), DC.TITLE);
    }

    /**
     * Test prefixed query string
     */
    public void testPrefixQueryString() {
        String prefixQuery = MemValueFactory.defaultFactory.prefixQuery("SELECT * WHERE { ?s ?p ?o }");
        assertTrue(prefixQuery.contains("dc: <" + DC.NAMESPACE + ">"));
    }

    /**
     * Test serialize using prefixes
     * 
     * @throws Exception
     */
    public void testSerializeUsingPrefixes() throws Exception {
        StringWriter string = new StringWriter();
        RioToAnzoWriterAdapter writer = new RioToAnzoWriterAdapter(string, RDFFormat.TRIG);

        writer.handleNamespaces(MemValueFactory.defaultFactory.getRegisteredPrefixes()); // use the prefixes to setup a writer
        writer.startRDF();
        writer.handleStatement(new Statement(FOAF.Person, DC.TITLE, MemPlainLiteral.create("Describes a person.")));
        writer.endRDF();
        assertTrue(string.toString().contains("@prefix dc: <http://purl.org/dc/elements/1.1/>"));
    }
}
