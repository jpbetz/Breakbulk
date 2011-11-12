/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.test/src/com/ibm/adtech/boca/test/AbstractBocaTest.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  9/17/2004
 * Revision:	$Id: AbstractTest.java 171 2007-07-31 14:11:17Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test;

import java.util.Collection;
import java.util.Properties;

import junit.framework.TestCase;

import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.combus.CombusProperties;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SmartEncodingInputStream;
import org.openanzo.services.ServicesProperties;

/**
 * Parent class for anzo tests
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
public class AbstractTest extends TestCase {
    /** Property name to determine mode of testing, ie regular or regression */
    public static String            TEST_ENVIRONMENT_PROPERTY = "org.openanzo.test.environment";

    /** Regression constant */
    public static String            REGRESSION                = "regress";

    protected static final URI      trackerSetURI             = Constants.valueFactory.createURI("http://openanzo#Test");

    private static final Properties properties                = new Properties();

    static {
        String env = System.getProperty(TEST_ENVIRONMENT_PROPERTY);
        if (env != null && env.equals(REGRESSION)) {
            CombusProperties.setHost(properties, "localhost");
            CombusProperties.setPort(properties, 61618);
            CombusProperties.setUseSsl(properties, false);
            ServicesProperties.setUser(properties, "default");
            try {
                ServicesProperties.setPassword(properties, "123");
            } catch (AnzoException ae) {
                throw new AnzoRuntimeException(ae);
            }
            properties.put("http.port", "8082");
        } else {
            CombusProperties.setHost(properties, "localhost");
            CombusProperties.setPort(properties, 61616);
            CombusProperties.setUseSsl(properties, false);
            ServicesProperties.setUser(properties, "default");
            try {
                ServicesProperties.setPassword(properties, "123");
            } catch (AnzoException ae) {
                throw new AnzoRuntimeException(ae);
            }
            properties.put("http.port", "8080");
        }
    }

    /**
     * basic abstract test
     */
    public AbstractTest() {
    }

    /**
     * @param name
     *            name of test
     * 
     */
    public AbstractTest(String name) {
        super(name);
    }

    protected Collection<Statement> loadStatements(String file) throws Exception {
        return ReadWriteUtils.loadStatements(SmartEncodingInputStream.createSmartReader(AbstractTest.class.getClassLoader().getResourceAsStream(file)), RDFFormat.forFileName(file), "");
    }

    static Properties serverProps = null;

    @Override
    protected void tearDown() throws Exception {
    }

    static protected Properties getDefaultClientConfiguration() throws AnzoException {
        return getClientConfiguration("default", "123");
    }

    static protected Properties getSystemClientConfiguration() throws AnzoException {
        return getClientConfiguration("sysadmin", "123");
    }

    static protected Properties getAnonymousClientConfiguration() throws AnzoException {
        return getClientConfiguration(Constants.DEFAULT_ANONYMOUS_USER, "");
    }

    static protected Properties getPersistedClientConfiguration() throws AnzoException {
        Properties props = getProperties();
        String user = "default";
        String password = "123";
        boolean useSsl = false;
        String host = CombusProperties.getHost(props);
        int port = CombusProperties.getPort(props);
        String dbType = "H2";
        String dbUrl = "jdbc:h2:mem:anzodb";
        String dbUser = "sa";
        String dbPassword = "";
        Properties configGraph = AnzoClientConfigurationFactory.createJMSConfiguration(user, password, host, port, useSsl);
        AnzoClientConfigurationFactory.configurePersistedClient(configGraph, "ANZO_CLIENT", dbType, dbUrl, dbUser, dbPassword);
        return configGraph;
    }

    static protected Properties getClientConfiguration(String userName, String password) throws AnzoException {
        Properties props = getProperties();
        String host = CombusProperties.getHost(props);
        int port = CombusProperties.getPort(props);
        boolean useSsl = CombusProperties.getUseSsl(props);
        Properties configGraph = AnzoClientConfigurationFactory.createJMSConfiguration(userName, password, host, port, useSsl);
        ServicesProperties.setTimeout(configGraph, 60000);
        AnzoClientConfigurationFactory.configureNonPersistedClient(configGraph);
        return configGraph;
    }

    /**
     * Create a testURI
     * 
     * @param name
     *            uri suffix
     * @return minted uri
     */
    public static URI createTestUri(String name) {
        return Constants.valueFactory.createURI("http://test.example.com/test#" + name);
    }

    protected static Properties getProperties() {
        return (Properties) properties.clone();
    }
}
