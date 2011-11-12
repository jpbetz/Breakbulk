/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 8, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

/**
 * Collection of XML utilities that provide single point of accessing all sorts of xml readers/writers/parsers/transformers
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class XMLFactoryFinder {

    static final private Object                            lock                   = new Object();

    private static final ArrayList<XMLEventFactory>        eventFactory           = new ArrayList<XMLEventFactory>();

    private static final ArrayList<XMLInputFactory>        inputFactory           = new ArrayList<XMLInputFactory>();

    private static final ArrayList<XMLOutputFactory>       outputFactory          = new ArrayList<XMLOutputFactory>();

    private static final ArrayList<DocumentBuilderFactory> documentBuilderFactory = new ArrayList<DocumentBuilderFactory>();

    private static final ArrayList<SAXParserFactory>       saxParserFactory       = new ArrayList<SAXParserFactory>();

    /**
     * get an MXL eventFactory
     * 
     * @return an MXL eventFactory
     */
    public static XMLEventFactory getXMLEventFactory() {
        synchronized (lock) {
            if (eventFactory.size() == 0) {
                return XMLEventFactory.newInstance();
            }
            return eventFactory.get(0);
        }
    }

    /**
     * Get an xml input factory
     * 
     * @return an xml input factory
     */
    public static XMLInputFactory getXMLInputFactory() {
        synchronized (lock) {
            if (inputFactory.size() == 0) {
                return XMLInputFactory.newInstance();
            }
            return inputFactory.get(0);
        }
    }

    /**
     * Get an xml output factory
     * 
     * @return an xml output factory
     */
    public static XMLOutputFactory getXMLOutputFactory() {
        synchronized (lock) {
            if (outputFactory.size() == 0) {
                return XMLOutputFactory.newInstance();
            }
            return outputFactory.get(0);
        }
    }

    /**
     * Get an xml document builder factory
     * 
     * @return an xml document builder factory
     */
    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        synchronized (lock) {
            if (documentBuilderFactory.size() == 0) {
                return DocumentBuilderFactory.newInstance();
            }
            return documentBuilderFactory.get(0);
        }
    }

    /**
     * Get an xml sax parser factory
     * 
     * @return an xml sax parser factory
     */
    public static SAXParserFactory getSAXParserFactory() {
        synchronized (lock) {
            if (saxParserFactory.size() == 0) {
                return SAXParserFactory.newInstance();
            }
            return saxParserFactory.get(0);
        }
    }

    /**
     * Add an xml event factory
     * 
     * @param factory
     *            an xml event factory
     */
    public static void addXMLEventFactory(XMLEventFactory factory) {
        synchronized (lock) {
            eventFactory.add(factory);
        }
    }

    /**
     * Remove an xml event factory
     * 
     * @param factory
     *            an xml event factory
     */
    public static void removeXMLEventFactory(XMLEventFactory factory) {
        synchronized (lock) {
            eventFactory.remove(factory);
        }
    }

    /**
     * Add an xml input factory
     * 
     * @param factory
     *            an xml input factory
     */
    public static void addXMLInputFactory(XMLInputFactory factory) {
        synchronized (lock) {
            inputFactory.add(factory);
        }
    }

    /**
     * Remove an xml input factory
     * 
     * @param factory
     *            an xml input factory
     */
    public static void removeXMLInputFactory(XMLInputFactory factory) {
        synchronized (lock) {
            inputFactory.remove(factory);
        }
    }

    /**
     * Add an xml output factory
     * 
     * @param factory
     *            an xml output factory
     */
    public static void addXMLOutputFactory(XMLOutputFactory factory) {
        synchronized (lock) {
            outputFactory.add(factory);
        }
    }

    /**
     * Remove an xml output factory
     * 
     * @param factory
     */
    public static void removeXMLOutputFactory(XMLOutputFactory factory) {
        synchronized (lock) {
            outputFactory.remove(factory);
        }
    }

    /**
     * Add an xml document builder factory
     * 
     * @param factory
     *            an xml document builder factory
     */
    public static void addDocumentBuilderFactory(DocumentBuilderFactory factory) {
        synchronized (lock) {
            documentBuilderFactory.add(factory);
        }
    }

    /**
     * Remove an xml document builder factory
     * 
     * @param factory
     *            an xml document builder factory
     */
    public static void removeDocumentBuilderFactory(DocumentBuilderFactory factory) {
        synchronized (lock) {
            documentBuilderFactory.remove(factory);
        }
    }

    /**
     * Add an xml sax parser factory
     * 
     * @param factory
     *            an xml sax parser factory
     */
    public static void addSAXParserFactory(SAXParserFactory factory) {
        synchronized (lock) {
            saxParserFactory.add(factory);
        }
    }

    /**
     * Remove an xml sax parser Factory
     * 
     * @param factory
     *            an xml sax parser factory
     */
    public static void removeSAXParserFactory(SAXParserFactory factory) {
        synchronized (lock) {
            saxParserFactory.remove(factory);
        }
    }
}
