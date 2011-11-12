/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 17, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.openanzo.osgi.attributes.CombusAttributes;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;

/**
 * OSGI configuration utilities
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class OsgiConfigurationUtils {
    private final static Set<String> systemProperties = new HashSet<String>();
    static {
        systemProperties.add(ServicesDictionary.KEY_SERVICE_USER);
        systemProperties.add(ServicesDictionary.KEY_SERVICE_PASSWORD);
        systemProperties.add(CombusAttributes.Host.getID());
        systemProperties.add(CombusAttributes.Port.getID());
    }

    /**
     * Validate that the provided config properties are valid based on the given class def
     * 
     * @param classDef
     *            classdef to verify config against
     * @param configProperties
     *            config properties to verify
     * @throws ConfigurationException
     */
    public static void validateConfiguration(ObjectClassDefinition classDef, Dictionary<? extends Object, ? extends Object> configProperties) throws ConfigurationException {
        for (AttributeDefinition ad : classDef.getAttributeDefinitions(ObjectClassDefinition.REQUIRED)) {
            Object value = configProperties.get(ad.getID());
            if (value == null) {
                if (!systemProperties.contains(ad.getID())) {
                    throw new ConfigurationException(ad.getID(), classDef.getID() + "'s " + ad.getName() + " value cannot be null.");
                }
            } else {
                String result = ad.validate(value.toString());
                if (result != null && result.length() > 0) {
                    throw new ConfigurationException(ad.getID(), classDef.getID() + "'s " + ad.getName() + " not of valid form:" + result);
                }
            }
        }
        for (AttributeDefinition ad : classDef.getAttributeDefinitions(ObjectClassDefinition.OPTIONAL)) {
            Object value = configProperties.get(ad.getID());
            if (value != null) {
                String result = ad.validate(value.toString());
                if (result != null && result.length() > 0) {
                    throw new ConfigurationException(ad.getID(), classDef.getID() + "'s " + ad.getName() + " not of valid form:" + result);
                }
            }
        }
    }

    /**
     * Validate that the provided config properties are valid based on the given class def
     * 
     * @param classDef
     *            classdef to verify config against
     * @param oldConfigProperties
     *            config properties to verify
     * @param newConfigProperties
     *            config properties to verify
     * @return true if changing these properties requires a restart
     * @throws ConfigurationException
     */
    public static Set<String> isRestartRequired(ObjectClassDefinition classDef, Dictionary<? extends Object, ? extends Object> oldConfigProperties, Dictionary<? extends Object, ? extends Object> newConfigProperties) throws ConfigurationException {
        HashMap<String, Object> oldProps = new HashMap<String, Object>();
        for (Enumeration<? extends Object> keys = oldConfigProperties.keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = oldConfigProperties.get(key);
            oldProps.put(key.toString(), value);
        }

        HashMap<String, Object> newProps = new HashMap<String, Object>();
        for (Enumeration<? extends Object> keys = newConfigProperties.keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = newConfigProperties.get(key);

            Object oldValue = oldProps.remove(key);
            if (oldValue == null || !oldValue.equals(value)) {
                newProps.put(key.toString(), value);
            }
        }

        for (AttributeDefinition ad : classDef.getAttributeDefinitions(ObjectClassDefinition.ALL)) {
            Object value = newProps.get(ad.getID());
            if (value != null) {
                if (ad instanceof AnzoAttributeDefinition) {
                    if (((AnzoAttributeDefinition) ad).isRestartRequired()) {
                        return null;
                    }
                } else {
                    return null;
                }
            }

            value = oldProps.get(ad.getID());
            if (value != null) {
                if (ad instanceof AnzoAttributeDefinition) {
                    if (((AnzoAttributeDefinition) ad).isRestartRequired()) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }
        HashSet<String> changedProps = new HashSet<String>();
        changedProps.addAll(newProps.keySet());
        changedProps.addAll(oldProps.keySet());
        return changedProps;
    }

    /**
     * Create a new array that is the union of the provided arrays
     * 
     * @param arrays
     *            arrays to union together
     * @return union of the provided arrays
     */
    public static AttributeDefinition[] union(AttributeDefinition[]... arrays) {
        if (arrays.length == 1)
            return arrays[0];
        AttributeDefinition[] result = null;
        for (AttributeDefinition[] array : arrays) {
            if (array.length > 0) {
                AttributeDefinition[] temp = new AttributeDefinition[(result != null ? result.length : 0) + array.length];
                if (result != null)
                    System.arraycopy(result, 0, temp, 0, result.length);
                System.arraycopy(array, 0, temp, (result != null ? result.length : 0), array.length);
                result = temp;
            }
        }
        return result;
    }

    /**
     * Update the config properties based on the current context. This means that templated values within the config will be updated, ie ${anzoHome}
     * 
     * @param configProperties
     *            config properties to augment
     * @param context
     *            context for which to use to update properties
     */
    @SuppressWarnings("unchecked")
    public static void updateConfigProperties(Dictionary configProperties, BundleContext context) {
        for (Enumeration<? extends Object> keys = configProperties.keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = configProperties.get(key);
            if (value instanceof String) {
                value = preprocessString((String) value, context);
                configProperties.put(key, value);
            }
        }
    }

    /**
     * Replace templated value with computed value based on context
     * 
     * <br/>
     * <code> ${bundleLocation}</code> <br/>
     * <code>  ${bundleResourcePrefix}</code>
     * 
     * @param value
     *            value to augment
     * @param context
     *            context for which to use to update value
     * @return augmented value
     */
    public static String preprocessString(String value, BundleContext context) {
        String result = value;
        while ((result).contains("${")) {
            int index = (result).indexOf("${");
            String val = (result).substring(0, index);
            int endIndex = (result).indexOf("}", index);
            if (endIndex < 0)
                endIndex = (result).length();
            String replacement = (result).substring(index + 2, endIndex);
            if (replacement.equals("bundleLocation")) {
                val = val.concat(context.getDataFile(".").getAbsolutePath());
            } else if (replacement.equals("bundleResourcePrefix")) {
                String bp = context.getProperty("BUNDLE_RESOURCE_PREFIX");
                if (bp != null) {
                    val = val.concat(bp);
                }
            } else if (replacement.startsWith("system.")) {
                String prop = replacement.substring("system.".length());
                if (System.getProperty(prop) != null) {
                    val = val.concat(System.getProperty(prop));
                } else if (System.getenv(prop) != null) {
                    val = val.concat(System.getenv(prop));
                } else if (prop.equals("ANZO_HOME")) {
                    val = ".";
                } else if (prop.equals("ANZO_SERVER_HOME")) {
                    val = ".";
                }
            }
            if (endIndex < (result).length()) {
                val = val.concat((result).substring(endIndex + 1));
            }
            result = val;
        }
        return result;
    }

    /**
     * The minimum number of server port number.
     */
    public static final int MIN_PORT_NUMBER = 1;

    /**
     * The maximum number of server port number.
     */
    public static final int MAX_PORT_NUMBER = 65536;

    /**
     * Checks to see if a specific port is available.
     * 
     * @param port
     *            the port to check for availability
     */
    public static boolean networkPortAvailable(int port, InetAddress address) {
        if (port < MIN_PORT_NUMBER || port > MAX_PORT_NUMBER) {
            throw new IllegalArgumentException("Invalid start port: " + port);
        }

        ServerSocket ss = null;
        DatagramSocket ds = null;
        try {
            ss = new ServerSocket(port, 0, address);
            ss.setReuseAddress(true);
            ds = new DatagramSocket(port, address);
            ds.setReuseAddress(true);
            return true;
        } catch (IOException e) {
        } finally {
            if (ds != null) {
                ds.close();
            }

            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    /* should not be thrown */
                }
            }
        }

        return false;
    }

}
