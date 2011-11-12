/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 5, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client;

import java.util.Properties;

import org.openanzo.combus.CombusProperties;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.container.DBTypes;
import org.openanzo.jdbc.container.RDBProperties;
import org.openanzo.services.ServicesProperties;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class AnzoClientConfigurationFactory {

    /**
     * Create a new JMS based service container configuration
     * 
     * @param userName
     *            user name for the connection
     * @param password
     *            password for the connection
     * @param host
     *            hostname for the JMS broker
     * @param port
     *            port for the JMS broker
     * @param useSsl
     *            use ssl
     * @return INamedGraph containing configuration for a JMS backed service container
     * @throws AnzoException
     */
    public static Properties createJMSConfiguration(String userName, String password, String host, Integer port, Boolean useSsl) throws AnzoException {
        Properties clientConfiguration = new Properties();
        AnzoClientProperties.setPersistenceEnabled(clientConfiguration, false);
        AnzoClientProperties.setQuadstoreShared(clientConfiguration, false);

        CombusProperties.setHost(clientConfiguration, host);
        CombusProperties.setPort(clientConfiguration, port);
        if (useSsl != null) {
            CombusProperties.setUseSsl(clientConfiguration, useSsl);
        } else {
            CombusProperties.setUseSsl(clientConfiguration, false);
        }
        ServicesProperties.setUser(clientConfiguration, userName);
        ServicesProperties.setPassword(clientConfiguration, password);

        return clientConfiguration;
    }

    /**
     * Set client persistence off within the given config properties
     * 
     * @param configProperties
     *            Properties on which to set persistence off
     * @throws AnzoException
     */
    public static void configureNonPersistedClient(Properties configProperties) throws AnzoException {
        AnzoClientProperties.setPersistenceEnabled(configProperties, false);
    }

    /**
     * Set persistence on within the given config properties
     * 
     * @param configProperties
     *            Properties on which to set persistence settings
     * @param containerName
     *            Instance name for this set of persisted data
     * @param databaseType
     *            Database type @see {@link DBTypes}
     * @param databaseUrl
     *            URL for the database connection
     * @param databaseUser
     *            User name for the database connection
     * @param databasePassword
     *            Password for the database connection
     * @throws AnzoException
     */
    public static void configurePersistedClient(Properties configProperties, String containerName, String databaseType, String databaseUrl, String databaseUser, String databasePassword) throws AnzoException {
        AnzoClientProperties.setPersistenceEnabled(configProperties, true);
        configurePersistedClient(configProperties, true, containerName, databaseType, databaseUrl, databaseUser, databasePassword);
    }

    private static void configurePersistedClient(Properties containerConfiguration, boolean client, String containerName, String databaseType, String databaseUrl, String databaseUser, String databasePassword) throws AnzoException {
        RDBProperties.setContainerName(containerConfiguration, containerName);
        RDBProperties.setUser(containerConfiguration, databaseUser);
        RDBProperties.setPassword(containerConfiguration, databasePassword);
        RDBProperties.setUrl(containerConfiguration, databaseUrl);
        DBTypes type = DBTypes.valueOf(databaseType);
        switch (type) {
        case DB2:
            CoreDBConfiguration.configureDB2(containerConfiguration, client);
            break;
        case MSSQL:
            CoreDBConfiguration.configureMSSQL(containerConfiguration, client);
            break;
        case H2:
            CoreDBConfiguration.configureH2(containerConfiguration, client);
            break;
        case HSQL:
            CoreDBConfiguration.configureHSQL(containerConfiguration, client);
            break;
        case Oracle:
            CoreDBConfiguration.configureOracle(containerConfiguration, client);
            break;
        case Postgres:
            CoreDBConfiguration.configurePostgres(containerConfiguration, client);
            break;
        }
    }

}
