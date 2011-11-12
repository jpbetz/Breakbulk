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
package org.openanzo.services;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

import org.openanzo.services.serialization.XMLFactoryFinder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ServicesActivator implements BundleActivator {
    private ServiceTracker eventTracker;

    private ServiceTracker inputTracker;

    private ServiceTracker outputTracker;

    private ServiceTracker documentTracker;

    private ServiceTracker saxTracker;

    public void start(BundleContext context) throws Exception {
        eventTracker = new ServiceTracker(context, XMLEventFactory.class.getName(), null) {
            @Override
            public Object addingService(ServiceReference reference) {
                XMLEventFactory service = (XMLEventFactory) context.getService(reference);
                XMLFactoryFinder.addXMLEventFactory(service);
                return service;
            }

            @Override
            public void removedService(ServiceReference reference, Object serviceObject) {
                XMLEventFactory service = (XMLEventFactory) context.getService(reference);
                XMLFactoryFinder.removeXMLEventFactory(service);
                context.ungetService(reference);
            }
        };
        eventTracker.open();

        inputTracker = new ServiceTracker(context, XMLInputFactory.class.getName(), null) {
            @Override
            public Object addingService(ServiceReference reference) {
                XMLInputFactory service = (XMLInputFactory) context.getService(reference);
                XMLFactoryFinder.addXMLInputFactory(service);
                return service;
            }

            @Override
            public void removedService(ServiceReference reference, Object serviceObject) {
                XMLInputFactory service = (XMLInputFactory) context.getService(reference);
                XMLFactoryFinder.removeXMLInputFactory(service);
                context.ungetService(reference);
            }
        };
        inputTracker.open();

        outputTracker = new ServiceTracker(context, XMLOutputFactory.class.getName(), null) {
            @Override
            public Object addingService(ServiceReference reference) {
                XMLOutputFactory service = (XMLOutputFactory) context.getService(reference);
                XMLFactoryFinder.addXMLOutputFactory(service);
                return service;
            }

            @Override
            public void removedService(ServiceReference reference, Object serviceObject) {
                XMLOutputFactory service = (XMLOutputFactory) context.getService(reference);
                XMLFactoryFinder.removeXMLOutputFactory(service);
                context.ungetService(reference);
            }
        };
        outputTracker.open();

        saxTracker = new ServiceTracker(context, SAXParserFactory.class.getName(), null) {
            @Override
            public Object addingService(ServiceReference reference) {
                SAXParserFactory service = (SAXParserFactory) context.getService(reference);
                XMLFactoryFinder.addSAXParserFactory(service);
                return service;
            }

            @Override
            public void removedService(ServiceReference reference, Object serviceObject) {
                SAXParserFactory service = (SAXParserFactory) context.getService(reference);
                XMLFactoryFinder.removeSAXParserFactory(service);
                context.ungetService(reference);
            }
        };
        saxTracker.open();

        documentTracker = new ServiceTracker(context, DocumentBuilderFactory.class.getName(), null) {
            @Override
            public Object addingService(ServiceReference reference) {
                DocumentBuilderFactory service = (DocumentBuilderFactory) context.getService(reference);
                XMLFactoryFinder.addDocumentBuilderFactory(service);
                return service;
            }

            @Override
            public void removedService(ServiceReference reference, Object serviceObject) {
                DocumentBuilderFactory service = (DocumentBuilderFactory) context.getService(reference);
                XMLFactoryFinder.removeDocumentBuilderFactory(service);
                context.ungetService(reference);
            }
        };
        documentTracker.open();

    }

    public void stop(BundleContext context) throws Exception {
        if (eventTracker != null) {
            eventTracker.close();
            eventTracker = null;
        }
        if (inputTracker != null) {
            inputTracker.close();
            inputTracker = null;
        }
        if (outputTracker != null) {
            outputTracker.close();
            outputTracker = null;
        }
        if (saxTracker != null) {
            saxTracker.close();
            saxTracker = null;
        }
        if (documentTracker != null) {
            documentTracker.close();
            documentTracker = null;
        }

    }

}
