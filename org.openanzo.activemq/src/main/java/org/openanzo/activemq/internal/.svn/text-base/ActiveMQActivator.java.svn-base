/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 15, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.activemq.internal;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.StringTokenizer;

import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.region.policy.NoSubscriptionRecoveryPolicy;
import org.apache.activemq.broker.region.policy.PolicyEntry;
import org.apache.activemq.broker.region.policy.PolicyMap;
import org.apache.activemq.store.memory.MemoryPersistenceAdapter;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.combus.ActiveMqProvider;
import org.openanzo.combus.CombusDictionary;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.datasource.ConfiguredWithPrimaryDatasourceActivator;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.CombusAttributes;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.security.keystore.ISecretKeystore;
import org.openanzo.security.keystore.KeyStoreDictionary;
import org.openanzo.security.keystore.attributes.KeyStoreAttributes;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IAuthorizationEventListener;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;

/**
 * Activator for an embedded ActiveMQ server
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ActiveMQActivator extends ConfiguredWithPrimaryDatasourceActivator {
    //private static final Logger log         = LoggerFactory.getLogger(ActiveMQActivator.class);

    static final String   SERVICE_PID = "org.openanzo.activemq.EmbeddedActiveMQServer";

    GenericObjectClassDef classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : //
                (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), //
                        new AttributeDefinition[] { //
                        ServicesAttributes.Enabled, //
                                CombusAttributes.Host, //
                                CombusAttributes.Port, //
                                ServicesAttributes.User, //
                                ServicesAttributes.Password //
                        },//
                        new AttributeDefinition[] { //
                        CombusAttributes.SslHost, //
                                CombusAttributes.SslPort, //
                                KeyStoreAttributes.KeyFileLocation, //
                                KeyStoreAttributes.KeyPassword, //
                                KeyStoreAttributes.KeystoreType //
                        }));
    }

    private BrokerService       broker              = null;

    private SecurityPlugin      securityPlugin      = null;

    private ServiceRegistration aclRegistration     = null;

    private ServiceRegistration serviceRegistration = null;

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { IAuthenticationService.class.getName(), ICacheProvider.class.getName(), ISecretKeystore.class.getName() };
    }

    @Override
    public void start() throws AnzoException {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            String host = CombusDictionary.getHost(configProperties);
            Integer port = CombusDictionary.getPort(configProperties);
            String sslHost = CombusDictionary.getSslHost(configProperties);
            Integer sslPort = CombusDictionary.getSslPort(configProperties);
            String user = ServicesDictionary.getUser(configProperties, null);
            String password = ServicesDictionary.getPassword(configProperties, null);
            boolean reqSSL = false;
            Boolean requireSSL = ServicesDictionary.getRequireSSL(configProperties);
            if (requireSSL != null) {
                reqSSL = requireSSL.booleanValue();
            }
            try {
                securityPlugin = new SecurityPlugin(getDependency(IAuthenticationService.class), getDependency(ICacheProvider.class), user, password);
                securityPlugin.setDatasource(primaryDatasource);
                aclRegistration = context.registerService(IAuthorizationEventListener.class.getName(), securityPlugin, null);
                broker = new BrokerService();
                broker.setEnableStatistics(false);
                broker.setUseJmx(false);
                broker.setPopulateJMSXUserID(true);
                BrokerPlugin pluginsNew[] = new BrokerPlugin[] { securityPlugin };
                broker.setPlugins(pluginsNew);
                broker.setPersistenceAdapter(new MemoryPersistenceAdapter());
                broker.setPersistent(false);
                broker.setDeleteAllMessagesOnStartup(true);
                PolicyMap map = broker.getDestinationPolicy();
                if (map == null) {
                    map = new PolicyMap();
                    PolicyEntry pe = new PolicyEntry();
                    pe.setSendAdvisoryIfNoConsumers(false);
                    pe.setSubscriptionRecoveryPolicy(new NoSubscriptionRecoveryPolicy());
                    pe.setEnableAudit(false);
                    map.setDefaultEntry(pe);
                    broker.setDestinationPolicy(map);
                }
                if (!reqSSL) {
                    if (host == null || host.length() == 0 || host.equals("*")) {
                        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                        while (interfaces.hasMoreElements()) {
                            NetworkInterface ni = interfaces.nextElement();
                            Enumeration<InetAddress> addresses = ni.getInetAddresses();
                            while (addresses.hasMoreElements()) {
                                InetAddress ia = addresses.nextElement();
                                if (!ia.isMulticastAddress() && !(ia instanceof Inet6Address)) {
                                    if (!OsgiConfigurationUtils.networkPortAvailable(port, ia)) {
                                        throw new AnzoException(ExceptionConstants.CORE.PORT_NOT_AVAILABLE, port.toString(), ia.getHostAddress());
                                    }
                                    broker.addConnector("nio://" + ia.getHostAddress() + ":" + port);
                                }
                            }
                        }
                    } else if (host.contains(",")) {
                        StringTokenizer st = new StringTokenizer(host, ",");
                        while (st.hasMoreTokens()) {
                            if (!OsgiConfigurationUtils.networkPortAvailable(port, InetAddress.getByName(st.nextToken()))) {
                                throw new AnzoException(ExceptionConstants.CORE.PORT_NOT_AVAILABLE, port.toString(), st.nextToken());
                            }
                            broker.addConnector("nio://" + st.nextToken() + ":" + port);
                        }
                    } else {
                        if (!OsgiConfigurationUtils.networkPortAvailable(port, InetAddress.getByName(host))) {
                            throw new AnzoException(ExceptionConstants.CORE.PORT_NOT_AVAILABLE, port.toString(), host);
                        }
                        broker.addConnector("nio://" + host + ":" + port);
                    }

                }
                broker.addConnector("vm://localhost?broker.persistent=false");
                if (sslPort != null) {
                    System.setProperty("javax.net.ssl.keyStore", KeyStoreDictionary.getKeyFileLocation(configProperties));
                    System.setProperty("javax.net.ssl.keyStorePassword", KeyStoreDictionary.getKeyPassword(configProperties));
                    System.setProperty("javax.net.ssl.keyStoreType", KeyStoreDictionary.getKeystoreType(configProperties));
                    if (context.getProperty("javax.net.ssl.keyStoreType") != null && context.getProperty("javax.net.ssl.keyStore") != null && context.getProperty("javax.net.ssl.keyStorePassword") != null) {
                        if (sslHost.length() == 0 || sslHost.equals("*")) {
                            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                            while (interfaces.hasMoreElements()) {
                                NetworkInterface ni = interfaces.nextElement();
                                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                                while (addresses.hasMoreElements()) {
                                    InetAddress ia = addresses.nextElement();
                                    if (!ia.isMulticastAddress() && !(ia instanceof Inet6Address)) {
                                        if (!OsgiConfigurationUtils.networkPortAvailable(sslPort, ia)) {
                                            throw new AnzoException(ExceptionConstants.CORE.PORT_NOT_AVAILABLE, sslPort.toString(), ia.getHostAddress());
                                        }
                                        broker.addConnector("ssl://" + ia.getHostAddress() + ":" + sslPort);
                                    }
                                }
                            }
                        } else if (sslHost.contains(",")) {
                            StringTokenizer st = new StringTokenizer(host, ",");
                            while (st.hasMoreTokens()) {
                                if (!OsgiConfigurationUtils.networkPortAvailable(port, InetAddress.getByName(st.nextToken()))) {
                                    throw new AnzoException(ExceptionConstants.CORE.PORT_NOT_AVAILABLE, sslPort.toString(), st.nextToken());
                                }
                                broker.addConnector("ssl://" + st.nextToken() + ":" + sslPort);
                            }
                        } else {
                            if (!OsgiConfigurationUtils.networkPortAvailable(sslPort, InetAddress.getByName(sslHost))) {
                                throw new AnzoException(ExceptionConstants.CORE.PORT_NOT_AVAILABLE, sslPort.toString(), sslHost);
                            }
                            broker.addConnector("ssl://" + sslHost + ":" + sslPort);
                        }

                    }
                } else if (reqSSL) {
                    throw new AnzoRuntimeException(ExceptionConstants.COMBUS.SSL_MISMATCH);
                }
                broker.start();
            } catch (Exception e) {
                throw new AnzoException(ExceptionConstants.COMBUS.CREATE_BROKER_FAILED, e);
            }
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
        serviceRegistration = context.registerService(IJmsProvider.class.getName(), new ActiveMqProvider(enabled), null);
    }

    @Override
    public void stop(boolean bundleStopping) throws AnzoException {
        if (broker != null) {
            try {
                broker.stop();
                broker = null;
            } catch (Exception e) {
                throw new AnzoException(ExceptionConstants.COMBUS.CREATE_BROKER_FAILED, e);
            }
        }
        if (!bundleStopping && aclRegistration != null) {
            aclRegistration.unregister();
            aclRegistration = null;
        }
        if (!bundleStopping && serviceRegistration != null) {
            serviceRegistration.unregister();
            serviceRegistration = null;
        }
    }

}
