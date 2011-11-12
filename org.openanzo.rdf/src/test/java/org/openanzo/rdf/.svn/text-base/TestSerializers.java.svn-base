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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;
import org.openanzo.rdf.adapter.RioToAnzoWriterAdapter;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SmartEncodingInputStream;

/**
 * Test serializers
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class TestSerializers extends TestCase {
    static final URI       subj1 = MemURI.create("http://www.example.org/index.html");

    static final URI       pred1 = MemURI.create("http://www.example.org/terms/creation-date");

    static final URI       pred2 = MemURI.create("http://purl.org/dc/elements/1.1/#language");

    static final URI       pred3 = MemURI.create("http://purl.org/dc/elements/1.1/#creator");

    static final Literal   obj1  = MemPlainLiteral.create("August 16, 1999");

    static final Literal   obj2  = MemPlainLiteral.create("en");

    static final URI       obj3  = MemURI.create("http://www.example.org/staffid/85740");

    static final Statement stmt1 = new Statement(subj1, pred1, obj1);

    static final Statement stmt2 = new Statement(subj1, pred2, obj2);

    static final Statement stmt3 = new Statement(subj1, pred3, obj3);

    /**
     * Test writer
     * 
     * @throws Exception
     */
    public void testWriter() throws Exception {
        StringWriter stream = new StringWriter();
        RioToAnzoWriterAdapter writer = new RioToAnzoWriterAdapter(stream, RDFFormat.TURTLE);
        writer.startRDF();
        writer.handleStatement(stmt1);
        writer.handleStatement(stmt2);
        writer.handleStatement(stmt3);
        writer.endRDF();

        String RET = System.getProperty("line.separator");
        String expected = RET + "<http://www.example.org/index.html> <http://www.example.org/terms/creation-date> \"August 16, 1999\" ;" + RET + "\t<http://purl.org/dc/elements/1.1/#language> \"en\" ;" + RET + "\t<http://purl.org/dc/elements/1.1/#creator> <http://www.example.org/staffid/85740> ." + RET;

        assertEquals(expected, stream.toString());
    }

    /**
     * Tests that the readStatements method can read statements in JSON format.
     * 
     * @throws Exception
     */
    public void testReadStatementsInJSON() throws Exception {
        ValueFactory vf = MemValueFactory.defaultFactory;
        List<Statement> expectedStatements = new ArrayList<Statement>();
        expectedStatements.add(vf.createStatement(vf.createResource("http://example.org/subject1"), vf.createURI("http://example.org/predicate1"), vf.createResource("http://example.org/object1"), vf.createURI("http://example.org/namedGraph1")));
        expectedStatements.add(vf.createStatement(vf.createResource("http://example.org/subject2"), vf.createURI("http://example.org/predicate2"), vf.createResource("http://example.org/object2"), vf.createURI("http://example.org/namedGraph1")));
        expectedStatements.add(vf.createStatement(vf.createResource("http://example.org/subject1"), vf.createURI("http://example.org/predicate3"), vf.createLiteral("A literal value"), vf.createURI("http://example.org/namedGraph2")));

        String input = IOUtils.toString((SmartEncodingInputStream.createSmartReader(TestSerializers.class.getResourceAsStream("test-statements.json"))));
        Collection<Statement> statements = ReadWriteUtils.readStatements(input, RDFFormat.forMIMEType("application/json"));

        // The statements collection isn't ordered so we have to do this more elaborate search
        // to make sure all statements that should exist, do exist.
        assertEquals(3, statements.size());
        for (Statement expectedStatement : expectedStatements) {
            boolean foundStatement = false;
            for (Statement statement : statements) {
                if (statement.equals(expectedStatement)) {
                    foundStatement = true;
                    break;
                }
            }
            assertTrue("Statement not found:" + expectedStatement, foundStatement);
        }
    }

    /**
     * Tests that the readStatements method can read blank nodes in JSON format.
     * 
     * @throws Exception
     */
    public void testReadBlankNodesInJSON() throws Exception {
        ValueFactory vf = MemValueFactory.defaultFactory;
        String input = IOUtils.toString((SmartEncodingInputStream.createSmartReader(this.getClass().getResourceAsStream("test-blank-nodes.json"))));
        Collection<Statement> statements = ReadWriteUtils.readStatements(input, RDFFormat.forMIMEType("application/json"));

        assertEquals(3, statements.size());

        // Look for the first statement in the unordered collection
        BlankNode node123 = null;
        boolean found = false;
        for (Statement statement : statements) {
            if (statement.getPredicate().equals(vf.createURI("http://example.org/predicate1"))) {
                assertTrue(statement.getSubject() instanceof BlankNode);
                node123 = (BlankNode) statement.getSubject();
                found = true;
            }
        }
        assertTrue(found);

        // Look for the second statement in the unordered collection
        found = false;
        for (Statement statement : statements) {
            if (statement.getPredicate().equals(vf.createURI("http://example.org/predicate2"))) {
                assertTrue(statement.getSubject() instanceof BlankNode);
                found = true;
            }
        }
        assertTrue(found);

        // Look for the third statement in the unordered collection
        found = false;
        for (Statement statement : statements) {
            if (statement.getPredicate().equals(vf.createURI("http://example.org/predicate3"))) {
                assertTrue(statement.getSubject() instanceof BlankNode);
                assertTrue(statement.getObject() instanceof BlankNode);
                assertEquals(node123, statement.getSubject());
                found = true;
            }
        }
        assertTrue(found);
    }
}
