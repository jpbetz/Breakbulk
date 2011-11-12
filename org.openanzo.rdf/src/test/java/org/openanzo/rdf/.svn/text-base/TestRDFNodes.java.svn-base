/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.rdf;

import java.math.BigDecimal;
import java.math.BigInteger;

import junit.framework.TestCase;

import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Tests the various RDF Node classes in org.openanzo.rdf:
 * <ul>
 * <li>URI</li>
 * <li>PlainLiteral</li>
 * <li>TypedLiteral</li>
 * <li>Variable</li>
 * <li>BlankNode</li>
 * </ul>
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class TestRDFNodes extends TestCase {

    /**
     * Checks that the various namespace/local name separators function properly.
     * 
     * The separators are '/', '#' and ':'.
     * 
     */
    public void testGetURILocalName() {
        URI subj = MemURI.create("http://example.com/subject");
        assertEquals("http://example.com/", subj.getNamespace());
        assertEquals("subject", subj.getLocalName());

        URI pred = MemURI.create("http://example.com/preds#predicate1");
        assertEquals("http://example.com/preds#", pred.getNamespace());
        assertEquals("predicate1", pred.getLocalName());

        URI obj = MemURI.create("urn:guid:example.com:object1");
        assertEquals("urn:guid:example.com:", obj.getNamespace());
        assertEquals("object1", obj.getLocalName());
    }

    /**
     * Verifies the various ways a URI can be created function properly.
     */
    public void testCreateURI() {
        URI simple = MemURI.create("http://example.com/simple");
        assertEquals("http://example.com/simple", simple.toString());

        URI subj = MemURI.create("http://example.com/", "subject");
        assertEquals("http://example.com/subject", subj.toString());

        URI pred = MemURI.create("http://example.com/preds#", "predicate1");
        assertEquals("http://example.com/preds#predicate1", pred.toString());

        URI obj = MemURI.create("urn:guid:example.com:", "object1");
        assertEquals("urn:guid:example.com:object1", obj.toString());
    }

    /**
     * Verifies attempts to create illegal URIs throw exceptions.
     */
    public void testCreateIllegalUri() {
        String[] illegals = new String[] { "example.com/missingProtocol", "http://two words", "http://two\nlines", "http://example.com>", "!@#$%#@$///|||}{P~!11``><L.,l%^%&^%&&^*&^^^(*&(K)^%&*$%^#@$%#!$%\n\n\n1324134$%@!#$%#@!@#$!@#%" };
        for (String illegal : illegals) {
            boolean exceptionCaught = false;
            try {
                MemURI.create(illegal);
            } catch (Exception e) {
                exceptionCaught = true;
            }
            assertTrue("checking uri: " + illegal, exceptionCaught);
        }
    }

    /**
     * Verifies attempts to create variables using illegal names throw exceptions.
     */
    public void testCreateIllegalVariable() {
        String[] illegals = new String[] { "??", "two words", "two\nlines" };
        for (String illegal : illegals) {
            boolean exceptionCaught = false;
            try {
                MemVariable.createVariable(illegal);
            } catch (Exception e) {
                exceptionCaught = true;
            }
            assertTrue("checking variable: " + illegal, exceptionCaught);
        }
    }

    /**
     * Verifies that variables with the same name are equal.
     */
    public void testCreateVariable() {
        MemVariable subjVar = MemVariable.createVariable("subj");
        MemVariable identicalNameVar = MemVariable.createVariable("subj");
        assertEquals("subj", subjVar.getName());
        assertTrue(subjVar.equals(identicalNameVar));
    }

    /**
     * Creates a plain literal with and without a language tag, verifies they are constructed properly.
     */
    public void testCreatePlainLiteral() {
        PlainLiteral smith = MemPlainLiteral.create("John Smith");
        PlainLiteral smithEN = MemPlainLiteral.create("John Smith", "EN");

        assertEquals("John Smith", smith.getLabel());
        assertNull(smith.getLanguage());
        assertFalse(smith.hashCode() == -1);

        assertEquals("John Smith", smithEN.getLabel());
        assertEquals("EN", smithEN.getLanguage());
    }

    /**
     * Verifies that equality is handled properly for plain literal's and their language tags.
     */
    public void testCompareLanguage() {
        PlainLiteral lang_none = MemPlainLiteral.create("John Smith");
        PlainLiteral lang_EN = MemPlainLiteral.create("John Smith", "EN");
        PlainLiteral lang_en = MemPlainLiteral.create("John Smith", "en");
        PlainLiteral lang_en_US = MemPlainLiteral.create("John Smith", "en-US");
        PlainLiteral lang_EN_US = MemPlainLiteral.create("John Smith", "EN-US");
        PlainLiteral lang_EN_us = MemPlainLiteral.create("John Smith", "EN-us");

        assertEquals(lang_EN, lang_en);
        assertEquals(lang_en_US, lang_EN_US);
        assertEquals(lang_EN_US, lang_EN_us);

        assertNotSame(lang_none, lang_en);
        assertNotSame(lang_en, lang_en_US);
    }

    /**
     * Creates typed literals by passing in native java objects representing the typed literal and verifies the typed literal properly represents the object
     * passed in.
     * 
     * @throws Exception
     */
    public void testCreateTypedLiteralByNativeObject() throws Exception {
        TypedLiteral intLiteral = MemTypedLiteral.create(1024);
        assertEquals("1024", intLiteral.getLabel());
        assertEquals(Integer.valueOf(1024), intLiteral.getNativeValue());
        assertEquals(XMLSchema.INT, intLiteral.getDatatypeURI());
        assertFalse(intLiteral.hashCode() == -1);
        assertFalse(intLiteral.hashCode() == -1);

        TypedLiteral shortLiteral = MemTypedLiteral.create((short) 55);
        assertEquals("55", shortLiteral.getLabel());
        assertEquals(Short.valueOf((short) 55), shortLiteral.getNativeValue());
        assertEquals(XMLSchema.SHORT, shortLiteral.getDatatypeURI());

        TypedLiteral longLiteral = MemTypedLiteral.create((long) 2048);
        assertEquals("2048", longLiteral.getLabel());
        assertEquals(Long.valueOf(2048), longLiteral.getNativeValue());
        assertEquals(XMLSchema.LONG, longLiteral.getDatatypeURI());

        TypedLiteral booleanLiteral = MemTypedLiteral.create(true);
        assertEquals("true", booleanLiteral.getLabel());
        assertEquals(Boolean.TRUE, booleanLiteral.getNativeValue());
        assertEquals(XMLSchema.BOOLEAN, booleanLiteral.getDatatypeURI());

        TypedLiteral doubleLiteral = MemTypedLiteral.create(9.87654);
        assertEquals("9.87654", doubleLiteral.getLabel());
        assertEquals(Double.valueOf(9.87654), doubleLiteral.getNativeValue());
        assertEquals(XMLSchema.DOUBLE, doubleLiteral.getDatatypeURI());

        TypedLiteral floatLiteral = MemTypedLiteral.create((float) 1.2345678);
        assertEquals("1.2345678", floatLiteral.getLabel());
        assertEquals(Float.valueOf((float) 1.2345678), floatLiteral.getNativeValue());
        assertEquals(XMLSchema.FLOAT, floatLiteral.getDatatypeURI());

        TypedLiteral stringLiteral = MemTypedLiteral.create("John Smith");
        assertEquals("John Smith", stringLiteral.getLabel());
        assertEquals("John Smith", stringLiteral.getNativeValue());
        assertEquals(XMLSchema.STRING, stringLiteral.getDatatypeURI());

        TypedLiteral byteLiteral = MemTypedLiteral.create((byte) 15);
        assertEquals("15", byteLiteral.getLabel());
        assertEquals(Byte.valueOf((byte) 15), byteLiteral.getNativeValue());
        assertEquals(XMLSchema.BYTE, byteLiteral.getDatatypeURI());

        TypedLiteral decimalLiteral = MemTypedLiteral.create(BigDecimal.valueOf(334));
        assertEquals("334", decimalLiteral.getLabel());
        assertEquals(BigDecimal.valueOf(334), decimalLiteral.getNativeValue());
        assertEquals(XMLSchema.DECIMAL, decimalLiteral.getDatatypeURI());

        TypedLiteral byteArrayLiteral = MemTypedLiteral.create(new byte[] { 15, 3, 9, 2 });
        assertEquals(byte[].class, byteArrayLiteral.getNativeValue().getClass());
        byte[] val = (byte[]) byteArrayLiteral.getNativeValue();
        assertEquals(15, val[0]);
        assertEquals(3, val[1]);
        assertEquals(9, val[2]);
        assertEquals(2, val[3]);
        assertEquals(XMLSchema.BASE64BINARY, byteArrayLiteral.getDatatypeURI());

        // XML Schema datatypes are tested in org.openanzo.test.client.TestDateTime. 
    }

    /**
     * Change the type of a MemTypedLiteral and verify the native value is changed. Also verify the label is correct afterwards.
     */
    public void testChangeMemTypedLiteral() {
        MemTypedLiteral lit = (MemTypedLiteral) MemTypedLiteral.create("9990", XMLSchema.LONG);
        assertEquals(Long.valueOf(9990), lit.getNativeValue());

        lit = (MemTypedLiteral) MemTypedLiteral.create("9990", XMLSchema.INTEGER);
        assertEquals(BigInteger.valueOf(9990), lit.getNativeValue());

        String label = lit.getLabel();
        assertEquals("9990", label);
    }

    /**
     * Checks that blank node scopes are properly isolated.
     * 
     * @throws Exception
     */
    public void testBlankNodeScope() throws Exception {
        BlankNodeManager manager = new BlankNodeManager(false);
        manager.enterLabelScope();
        BlankNode first = manager.getBlankNode("a1");
        BlankNode second = manager.getBlankNode("a1");
        manager.enterLabelScope();
        BlankNode third = manager.getBlankNode("a1");
        BlankNode fourth = manager.getBlankNode("a1");
        manager.exitLabelScope();
        manager.exitLabelScope();

        assertSame(first, second);
        assertNotSame(second, third);
        assertSame(third, fourth);
    }

    /**
     * Checks that a blank node label can be properly associated with a blank node by the blank node manager.
     * 
     * @throws Exception
     */
    public void testBlankNodeId() throws Exception {
        BlankNodeManager manager = new BlankNodeManager(false);
        BlankNode first = manager.getBlankNode("a1");
        assertEquals("a1", manager.getLabel(first));
    }
}
