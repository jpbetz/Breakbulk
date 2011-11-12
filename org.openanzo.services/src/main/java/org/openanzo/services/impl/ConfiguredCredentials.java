package org.openanzo.services.impl;

import java.util.Dictionary;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.services.ServicesDictionary;

/**
 * Holds the username and password from configuration properties
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class ConfiguredCredentials {
    private final String userName;

    private final String password;

    /**
     * Read username and password from configuration properties
     * 
     * @param configProperties
     *            configuration properties
     * @param defaultUser
     *            default user if not present in config properties
     * @param defaultPassword
     *            default password if not present in config properties
     * @throws AnzoException
     */
    public ConfiguredCredentials(Dictionary<? extends Object, ? extends Object> configProperties, String defaultUser, String defaultPassword) throws AnzoException {
        if (configProperties != null) {
            Object userObject = ServicesDictionary.getUser(configProperties, defaultUser);
            if (userObject != null) {
                this.userName = userObject.toString();
            } else {
                this.userName = defaultUser;
            }

            Object passwordObject = ServicesDictionary.getPassword(configProperties, defaultPassword);
            if (passwordObject != null) {
                this.password = passwordObject.toString();
            } else {
                this.password = defaultPassword;
            }
        } else {
            this.userName = defaultUser;
            this.password = defaultPassword;
        }
    }

    /**
     * Get the username
     * 
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Get the password
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

}
