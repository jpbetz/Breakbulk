/*
 * $Header: /cvshome/build/org.osgi.util.xml/src/org/osgi/util/xml/XMLParserActivator.java,v 1.10 2006/06/21 17:41:20 hargrave Exp $
 * 
 * Copyright (c) OSGi Alliance (2002, 2006). All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Derived from XMLParserActivator
 */
package org.openanzo.osgi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.transform.TransformerFactory;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

/*
 * A BundleActivator class that allows any JAXP compliant XML Parser to register itself as an OSGi parser service.
 * 
 * Multiple JAXP compliant parsers can concurrently register by using this BundleActivator class. Bundles who wish to use an XML parser can then use the
 * framework's service registry to locate available XML Parsers with the desired characteristics such as validating and namespace-aware.
 * 
 * <p>
 * The services that this bundle activator enables a bundle to provide are:
 * <ul>
 * <li><code>javax.xml.parsers.SAXParserFactory</code>({@link #SAXFACTORYNAME})
 * <li><code>javax.xml.parsers.DocumentBuilderFactory</code>( {@link #DOMFACTORYNAME})
 * </ul>
 * 
 * <p>
 * The algorithm to find the implementations of the abstract parsers is derived from the JAR file specifications, specifically the Services API.
 * <p>
 * An XMLParserActivator assumes that it can find the class file names of the factory classes in the following files:
 * <ul>
 * <li><code>/META-INF/services/javax.xml.parsers.SAXParserFactory</code> is a file contained in a jar available to the runtime which contains the
 * implementation class name(s) of the SAXParserFactory.
 * <li><code>/META-INF/services/javax.xml.parsers.DocumentBuilderFactory</code> is a file contained in a jar available to the runtime which contains the
 * implementation class name(s) of the <code>DocumentBuilderFactory</code>
 * </ul>
 * <p>
 * If either of the files does not exist, <code>XMLParserActivator</code> assumes that the parser does not support that parser type.
 * 
 * <p>
 * <code>XMLParserActivator</code> attempts to instantiate both the <code>SAXParserFactory</code> and the <code>DocumentBuilderFactory</code>. It registers each
 * factory with the framework along with service properties:
 * <ul>
 * <li>{@link #PARSER_VALIDATING}- indicates if this factory supports validating parsers. It's value is a <code>Boolean</code>.
 * <li>{@link #PARSER_NAMESPACEAWARE}- indicates if this factory supports namespace aware parsers It's value is a <code>Boolean</code>.
 * </ul>
 * <p>
 * Individual parser implementations may have additional features, properties, or attributes which could be used to select a parser with a filter. These can be
 * added by extending this class and overriding the <code>setSAXProperties</code> and <code>setDOMProperties</code> methods.
 */
/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class XMLTransformerActivator implements BundleActivator, ServiceFactory {
    /** Context of this bundle */
    private BundleContext       context;

    /**
     * Filename containing the Transformer Factory Class name. Also used as the basis for the <code>SERVICE_PID<code> registration property.
     */
    private static final String TRANSFORMERFACTORYNAME        = "javax.xml.transform.TransformerFactory";

    /** Path to the factory class name files */
    private static final String TRANSFORMERCLASSFILEPATH      = "/META-INF/services/";

    /** Fully qualified path name of Transformer Factory Class Name file */
    private static final String TRANSFORMERCLASSFILE          = TRANSFORMERCLASSFILEPATH + TRANSFORMERFACTORYNAME;

    /** DOM Factory Service Description */
    private static final String TRANSFORMERFACTORYDESCRIPTION = "A JAXP Compliant XML Transformer";

    /**
     * Key for parser factory name property - this must be saved in the parsers properties hashtable so that the parser factory can be instantiated from a
     * ServiceReference
     */
    private static final String FACTORYNAMEKEY                = "transformer.factoryname";

    /**
     * Called when this bundle is started so the Framework can perform the bundle-specific activities necessary to start this bundle. This method can be used to
     * register services or to allocate any resources that this bundle needs.
     * 
     * <p>
     * This method must complete and return to its caller in a timely manner.
     * 
     * <p>
     * This method attempts to register a SAX and DOM parser with the Framework's service registry.
     * 
     * @param context
     *            The execution context of the bundle being started.
     * @throws java.lang.Exception
     *             If this method throws an exception, this bundle is marked as stopped and the Framework will remove this bundle's listeners, unregister all
     *             services registered by this bundle, and release all services used by this bundle.
     * @see Bundle#start
     */
    public void start(BundleContext context) throws Exception {
        this.context = context;
        Bundle parserBundle = context.getBundle();
        try {
            // check for transformers
            registerTransformer(getTransformerFactoryClassNames(parserBundle.getResource(TRANSFORMERCLASSFILE)));
        } catch (IOException ioe) {
            // if there were any IO errors accessing the resource files
            // containing the class names
            ioe.printStackTrace();
            throw new FactoryConfigurationError(ioe);
        }
    }

    /**
     * <p>
     * This method has nothing to do as all active service registrations will automatically get unregistered when the bundle stops.
     * 
     * @param context
     *            The execution context of the bundle being stopped.
     * @throws java.lang.Exception
     *             If this method throws an exception, the bundle is still marked as stopped, and the Framework will remove the bundle's listeners, unregister
     *             all services registered by the bundle, and release all services used by the bundle.
     * @see Bundle#stop
     */
    public void stop(BundleContext context) throws Exception {
    }

    /**
     * Given the URL for a file, reads and returns the parser class names. There may be multiple classes specified in this file, one per line. There may also be
     * comment lines in the file, which begin with "#".
     * 
     * @param parserUrl
     *            The URL of the service file containing the parser class names
     * @return A vector of strings containing the parser class names or null if parserUrl is null
     * @throws IOException
     *             if there is a problem reading the URL input stream
     */
    @SuppressWarnings("unchecked")
    // marshal for unchecked interface
    private Vector getTransformerFactoryClassNames(URL parserUrl) throws IOException {
        Vector v = new Vector(1);
        if (parserUrl != null) {
            String parserFactoryClassName = null;
            InputStream is = parserUrl.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            try {
                while (true) {
                    parserFactoryClassName = br.readLine();
                    if (parserFactoryClassName == null) {
                        break; // end of file reached
                    }
                    String pfcName = parserFactoryClassName.trim();
                    if (pfcName.length() == 0) {
                        continue; // blank line
                    }
                    int commentIdx = pfcName.indexOf("#");
                    if (commentIdx == 0) { // comment line
                        continue;
                    } else if (commentIdx < 0) { // no comment on this line
                        v.addElement(pfcName);
                    } else {
                        v.addElement(pfcName.substring(0, commentIdx).trim());
                    }
                }
            } finally {
                br.close();
            }
            return v;
        } else {
            return null;
        }
    }

    /**
     * Register Transformer Factory Services with the framework.
     * 
     * @param parserFactoryClassNames
     *            - a <code>Vector</code> of <code>String</code> objects containing the names of the parser Factory Classes
     * @throws FactoryConfigurationError
     *             if thrown from <code>getFactory</code>
     */
    @SuppressWarnings("unchecked")
    // marshal for unchecked interface
    private void registerTransformer(Vector transformerFactoryClassNames) throws FactoryConfigurationError {
        if (transformerFactoryClassNames != null) {
            Enumeration e = transformerFactoryClassNames.elements();
            int index = 0;
            while (e.hasMoreElements()) {
                String transformerFactoryClassName = (String) e.nextElement();
                // create a sax parser factory just to get it's default
                // properties. It will never be used since
                // this class will operate as a service factory and give each
                // service requestor it's own SaxParserFactory
                TransformerFactory factory = (TransformerFactory) getFactory(transformerFactoryClassName);
                Hashtable properties = new Hashtable(7);
                // figure out the default properties of the parser
                setDefaultTransformerProperties(factory, properties, index);
                // store the parser factory class name in the properties so that
                // it can be retrieved when getService is called
                // to return a parser factory
                properties.put(FACTORYNAMEKEY, transformerFactoryClassName);
                // release the factory
                factory = null;
                // register the factory as a service
                context.registerService(TRANSFORMERFACTORYNAME, this, properties);
                index++;
            }
        }
    }

    /**
     * <p>
     * Set the SAX Parser Service Properties. By default, the following properties are set:
     * <ul>
     * <li><code>SERVICE_DESCRIPTION</code>
     * <li><code>SERVICE_PID</code>
     * <li><code>PARSER_VALIDATING</code>- instantiates a parser and queries it to find out whether it is validating or not
     * <li><code>PARSER_NAMESPACEAWARE</code>- instantiates a parser and queries it to find out whether it is namespace aware or not
     * <ul>
     * 
     * @param factory
     *            The <code>SAXParserFactory</code> object
     * @param props
     *            <code>Hashtable</code> of service properties.
     */
    @SuppressWarnings("unchecked")
    // marshal for unchecked interface
    private void setDefaultTransformerProperties(TransformerFactory factory, Hashtable props, int index) {
        props.put(Constants.SERVICE_DESCRIPTION, TRANSFORMERFACTORYDESCRIPTION);
        props.put(Constants.SERVICE_PID, TRANSFORMERFACTORYNAME + "." + context.getBundle().getBundleId() + "." + index);
        setTransformerProperties(factory, props);
    }

    /**
     * <p>
     * Set the customizable SAX Parser Service Properties.
     * 
     * <p>
     * This method attempts to instantiate a validating parser and a namespaceaware parser to determine if the parser can support those features. The
     * appropriate properties are then set in the specified properties object.
     * 
     * <p>
     * This method can be overridden to add additional SAX2 features and properties. If you want to be able to filter searches of the OSGi service registry,
     * this method must put a key, value pair into the properties object for each feature or property. For example,
     * 
     * properties.put("http://www.acme.com/features/foo", Boolean.TRUE);
     * 
     * @param factory
     *            - the SAXParserFactory object
     * @param properties
     *            - the properties object for the service
     */
    @SuppressWarnings("unchecked")
    // marshal for unchecked interface
    private void setTransformerProperties(TransformerFactory factory, Hashtable properties) {

    }

    /**
     * Given a parser factory class name, instantiate that class.
     * 
     * @param parserFactoryClassName
     *            A <code>String</code> object containing the name of the parser factory class
     * @return a parserFactoryClass Object
     * @pre parserFactoryClassName!=null
     */
    private Object getFactory(String parserFactoryClassName) throws FactoryConfigurationError {
        Exception e = null;
        try {
            return Class.forName(parserFactoryClassName).newInstance();
        } catch (ClassNotFoundException cnfe) {
            e = cnfe;
        } catch (InstantiationException ie) {
            e = ie;
        } catch (IllegalAccessException iae) {
            e = iae;
        }
        throw new FactoryConfigurationError(e);
    }

    /**
     * Creates a new XML Parser Factory object.
     * 
     * <p>
     * A unique XML Parser Factory object is returned for each call to this method.
     * 
     * <p>
     * The returned XML Parser Factory object will be configured for validating and namespace aware support as specified in the service properties of the
     * specified ServiceRegistration object.
     * 
     * This method can be overridden to configure additional features in the returned XML Parser Factory object.
     * 
     * @param bundle
     *            The bundle using the service.
     * @param registration
     *            The <code>ServiceRegistration</code> object for the service.
     * @return A new, configured XML Parser Factory object or null if a configuration error was encountered
     */
    public Object getService(Bundle bundle, ServiceRegistration registration) {
        ServiceReference sref = registration.getReference();
        String parserFactoryClassName = (String) sref.getProperty(FACTORYNAMEKEY);
        try {
            // need to set factory properties
            Object factory = getFactory(parserFactoryClassName);
            return factory;
        } catch (FactoryConfigurationError fce) {
            fce.printStackTrace();
            return null;
        }
    }

    /**
     * Releases a XML Parser Factory object.
     * 
     * @param bundle
     *            The bundle releasing the service.
     * @param registration
     *            The <code>ServiceRegistration</code> object for the service.
     * @param service
     *            The XML Parser Factory object returned by a previous call to the <code>getService</code> method.
     */
    public void ungetService(Bundle bundle, ServiceRegistration registration, Object service) {
    }
}
