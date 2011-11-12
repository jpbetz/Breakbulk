package org.openanzo.client;

import java.util.Properties;

import junit.framework.TestCase;

import org.openanzo.exceptions.AnzoException;

abstract class TestConfiguration extends TestCase {

    static Properties getBasicConfiguration() throws AnzoException {
        Properties conf = AnzoClientConfigurationFactory.createJMSConfiguration("default", "123", "localhost", 61616, false);
        AnzoClientConfigurationFactory.configureNonPersistedClient(conf);
        return conf;

    }

    static Properties getPersistenceConfiguration() throws AnzoException {
        Properties conf = AnzoClientConfigurationFactory.createJMSConfiguration("default", "123", "localhost", 61616, false);
        AnzoClientConfigurationFactory.configurePersistedClient(conf, "testContainer", "H2", "jdbc:h2:mem:anzoclientdb;DB_CLOSE_DELAY=-1", "sa", "");
        return conf;
    }

}
