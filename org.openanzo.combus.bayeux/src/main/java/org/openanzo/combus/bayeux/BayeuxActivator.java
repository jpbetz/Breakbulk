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
package org.openanzo.combus.bayeux;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.eclipse.jetty.servlets.GzipFilter;
import org.openanzo.analysis.ProfilingServletFilter;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.combus.bayeux.attributes.BayeuxBridgeAttributes;
import org.openanzo.datasource.ConfiguredWithPrimaryDatasourceActivator;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.CombusAttributes;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.security.keystore.ISecretKeystore;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IAuthorizationEventListener;
import org.openanzo.services.ServicesDictionary;
import org.openanzo.services.impl.ConfiguredCredentials;
import org.openanzo.servlet.EncryptedTokenAuthenticator;
import org.openanzo.servlet.PathSpec;
import org.openanzo.servlet.SecurityConstraint;
import org.openanzo.servlet.ServerRealm;
import org.openanzo.servlet.WebcontainerTracker;
import org.ops4j.pax.web.service.WebContainer;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator for the Bayeux listener
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class BayeuxActivator extends ConfiguredWithPrimaryDatasourceActivator implements IDatasourceListener, IAuthorizationEventListener {
    private static final Logger    log               = LoggerFactory.getLogger("org.openanzo.combus.bayeux.BayeuxJmsBridge");

    private Servlet                servlet           = null;

    private PrincipalFilter        principalFilter   = null;

    private GzipFilter             gzipFilter        = null;

    private ProfilingServletFilter profilingFilter   = null;

    private BayeuxJMSBridge        bridge            = null;

    private String[]               cometdPathSpec    = new String[] { "/cometd/*" };

    private ServerRealm            relm              = null;

    EncryptedTokenAuthenticator    authenticator     = null;

    Properties                     servletProperties = null;

    static final String            SERVICE_PID       = "org.openanzo.combus.BayeuxBridge";

    GenericObjectClassDef          classDef;

    HashMap<String, WebContainer>  webContainers     = new HashMap<String, WebContainer>();

    WebcontainerTracker            wcTracker;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled, CombusAttributes.Host, CombusAttributes.Port, ServicesAttributes.User, ServicesAttributes.Password }, new AttributeDefinition[] { BayeuxBridgeAttributes.ThreadPoolSize }));
    }

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { IAuthenticationService.class.getName(), ISecretKeystore.class.getName(), IJmsProvider.class.getName(), ICacheProvider.class.getName() };
    }

    public void reset() throws AnzoException {
        bridge.reset();
    }

    public void resetFinished() throws AnzoException {
        bridge.resetFinished();
    }

    public void resetStarting() throws AnzoException {
        bridge.resetStarting();
    }

    @Override
    public boolean isInitialized() {
        return super.isInitialized() && webContainers.size() > 0;
    }

    @Override
    public void configurationPropertiesSet(Set<String> changedProps) throws ConfigurationException {
        if (configProperties != null && wcTracker == null) {
            String instanceIds = (String) configProperties.get("org.ops4j.pax.web.instanceId");
            try {
                wcTracker = new WebcontainerTracker(context, instanceIds, new WebcontainerTracker.WebcontainerTrackerListener() {

                    public void webcontainerUnAvailable(String instanceId, WebContainer wc) {
                        webContainers.remove(instanceId);
                        if (webContainers.size() == 0) {
                            stopLocked(false);
                        }
                    }

                    public void webcontainerAvailable(String instanceId, WebContainer wc) {
                        webContainers.put(instanceId, wc);
                        if (state != ServiceLifecycleState.STARTED) {
                            if (isInitialized()) {
                                startLocked();
                            }
                        } else {
                            try {
                                registerWebContainer(wc);
                            } catch (ServletException se) {
                                log.error(LogUtils.LIFECYCLE_MARKER, "Error registering bayuex with webContainer", se);
                            }
                        }
                    }
                });
                wcTracker.open();
            } catch (InvalidSyntaxException ise) {
                throw new ConfigurationException("org.ops4j.pax.web.instanceId", ise.getMessage());
            }
        }
    }

    public void postReset() throws AnzoException {
    }

    @Override
    public void start() throws AnzoException {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            boolean reqSSL = false;
            Boolean requireSSL = ServicesDictionary.getRequireSSL(configProperties);
            if (requireSSL != null) {
                reqSSL = requireSSL.booleanValue();
            }
            servletProperties = new Properties();
            for (Enumeration<?> keys = configProperties.keys(); keys.hasMoreElements();) {
                Object key = keys.nextElement();
                servletProperties.put(key, configProperties.get(key));
            }
            primaryDatasource.registerDatasourceListener(this);
            servlet = new BayeuxJMSBridgeServlet();

            servletProperties.setProperty("timeout", "60000");
            servletProperties.setProperty("maxInterval", "30000");
            servletProperties.setProperty("multiFrameInterval", "1500");
            servletProperties.setProperty("logLevel", "1");
            servletProperties.setProperty("JSONCommented", "false");
            servletProperties.setProperty("requestAvailable", "true");
            servletProperties.setProperty("asyncDeliver", "false"); // Removes a possible point of Bayeux message loss. See http://groups.google.com/group/cometd-dev/browse_thread/thread/b8cb84108a934073

            ConfiguredCredentials credentials = new ConfiguredCredentials(servletProperties, null, null);
            bridge = new BayeuxJMSBridge(getDependency(IAuthenticationService.class), getDependency(IJmsProvider.class), getDependency(ICacheProvider.class), servletProperties, credentials, primaryDatasource);
            //HttpContext httpContext = httpService.createDefaultHttpContext();
            relm = new ServerRealm(getDependency(IAuthenticationService.class));
            authenticator = new EncryptedTokenAuthenticator(context, reqSSL ? SecurityConstraint.INTEGRAL : SecurityConstraint.NONE, relm, getDependency(ISecretKeystore.class), null, null, new ArrayList<PathSpec>() {
                private static final long serialVersionUID = 1L;
                {
                    add(new PathSpec("/cometd/*"));
                }
            });

            profilingFilter = new ProfilingServletFilter();
            gzipFilter = new GzipFilter();
            principalFilter = new PrincipalFilter();
            for (WebContainer webContainer : webContainers.values()) {
                try {
                    registerWebContainer(webContainer);
                } catch (ServletException se) {
                    log.error(LogUtils.LIFECYCLE_MARKER, "Error registering bayuex servlet with webcontainer", se);
                }
            }
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    private void registerWebContainer(WebContainer webContainer) throws ServletException {
        webContainer.registerEventListener(bridge, authenticator);
        webContainer.registerServlet(servlet, cometdPathSpec, servletProperties, authenticator);
        webContainer.registerFilter(profilingFilter, cometdPathSpec, null, servletProperties, authenticator);
        webContainer.registerFilter(gzipFilter, cometdPathSpec, null, servletProperties, authenticator);
        webContainer.registerFilter(principalFilter, cometdPathSpec, null, servletProperties, authenticator);
    }

    private void unregisterWebContainer(WebContainer webContainer) {
        if (bridge != null)
            webContainer.unregisterEventListener(bridge);
        if (servlet != null)
            webContainer.unregisterServlet(servlet);
        if (profilingFilter != null)
            webContainer.unregisterFilter(profilingFilter);
        if (gzipFilter != null)
            webContainer.unregisterFilter(gzipFilter);
        if (principalFilter != null)
            webContainer.unregisterFilter(principalFilter);
    }

    @Override
    public void stop(boolean bundleStopping) throws AnzoException {
        if (primaryDatasource != null) {
            primaryDatasource.unregisterDatasourceListener(this);
        }
        servlet.destroy();
        for (WebContainer webContainer : webContainers.values()) {
            unregisterWebContainer(webContainer);
        }
        servlet = null;
        principalFilter = null;
        gzipFilter = null;
        if (bridge != null) {
            bridge.stop(bundleStopping);
            bridge = null;
        }
        if (wcTracker != null && bundleStopping) {
            wcTracker.close();
            wcTracker = null;
        }
    }

    @Override
    public void restarted(Set<String> changedProps) {
        if (changedProps.contains(BayeuxBridgeDictionary.KEY_THREAD_POOL_SIZE)) {
            bridge.refreshThreadPoolSize(configProperties);
        }
        super.restarted(changedProps);
    }

    public void handleAuthorizationUpdates(Set<Statement> aclAdditions, Set<Statement> aclRemovals) throws AnzoException {
        if (aclRemovals != null && bridge != null) {
            for (Statement acl : aclRemovals) {
                URI namedGraphUri = (URI) acl.getSubject();
                URI privilege = acl.getPredicate();
                if (privilege.equals(NamedGraph.canBeReadByProperty)) {
                    bridge.namedGraphReadPrivilegeRemoved(namedGraphUri, (URI) acl.getObject());
                }
            }
        }
    }
}
