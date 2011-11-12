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
package org.openanzo.jdbc.container;

import java.util.Properties;
import java.util.Random;

import org.openanzo.exceptions.AnzoException;

/**
 * RDB test utilities
 * 
 */
public class RDBTestUtilities {
    static final Random random = new Random();

    /**
     * Get an RDBQuadStore
     * 
     * @return an RDBQuadStore
     * @throws AnzoException
     */
    public static RDBQuadStore getRDBQuadStore() throws AnzoException {
        return getRDBQuadStore("ANZO_TEST");
    }

    /**
     * Get an RDBQuadStore for given container name
     * 
     * @param containerName
     *            name of RDB container
     * @return an RDBQuadStore
     * @throws AnzoException
     */
    public static RDBQuadStore getRDBQuadStore(String containerName) throws AnzoException {
        RDBQuadStore quadStore = RDBQuadStore.createQuadStore(getConfiguration(containerName), true);
        quadStore.connect();
        quadStore.clear();
        return quadStore;
    }

    /**
     * Get an RDBQuadStore for given configuration
     * 
     * @param configuration
     *            configuration of RDBQuadStore
     * @return an RDBQuadStore
     * @throws AnzoException
     */
    public static RDBQuadStore getRDBQuadStore(CoreDBConfiguration configuration) throws AnzoException {
        RDBQuadStore quadStore = RDBQuadStore.createQuadStore(configuration, true);
        quadStore.connect();
        quadStore.clear();
        return quadStore;
    }

    /**
     * Get CoreDBconfiguration for the given container name
     * 
     * @param containerName
     *            container name for rdb
     * @return CoreDBconfiguration
     * @throws AnzoException
     */
    public static CoreDBConfiguration getConfiguration(String containerName) throws AnzoException {
        Properties props = new Properties();
        RDBProperties.setContainerName(props, containerName);
        RDBProperties.setUrl(props, "jdbc:h2:mem:anzotest" + random.nextInt() + ";DB_CLOSE_DELAY=-1");
        RDBProperties.setUser(props, "sa");
        try {
            RDBProperties.setPassword(props, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        CoreDBConfiguration.configureH2(props, true);
        return CoreDBConfiguration.createConfiguration(props);
    }
}
