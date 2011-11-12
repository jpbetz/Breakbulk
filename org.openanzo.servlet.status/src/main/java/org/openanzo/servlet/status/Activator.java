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
package org.openanzo.servlet.status;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;

import org.eclipse.jetty.server.Request;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.AnzoAttributeDefinition;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.ServicesDictionary;
import org.openanzo.servlet.BasicAuthenticator;
import org.openanzo.servlet.IAuthenticatorRealm;
import org.openanzo.servlet.PathSpec;
import org.openanzo.servlet.SecurityConstraint;
import org.openanzo.servlet.WebcontainerTracker;
import org.ops4j.pax.web.service.WebContainer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.http.HttpContext;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator for status servlet
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class Activator extends ConfiguredServiceActivator {
    private static final Logger                 log         = LoggerFactory.getLogger(Activator.class);

    StatusServlet                               servlet     = null;

    static final String                         SERVICE_PID = "org.openanzo.servlet.Status";

    GenericObjectClassDef                       classDef;

    WebContainer                                webContainer;

    WebcontainerTracker                         wcTracker;

    public static final AnzoAttributeDefinition Secure      = new AnzoAttributeDefinition() {
                                                                public String getName() {
                                                                    return "secure";
                                                                }

                                                                public boolean isRestartRequired() {
                                                                    return false;
                                                                }

                                                                public String getID() {
                                                                    return "org.openanzo.servlet.status.secure";
                                                                }

                                                                public String getDescription() {
                                                                    return "" + "Is encryption required for accessing this servlet";
                                                                }

                                                                public String validate(String value) {
                                                                    return "";
                                                                }

                                                                public int getType() {
                                                                    return AnzoAttributeDefinition.BOOLEAN;
                                                                }

                                                                public String[] getOptionValues() {
                                                                    return null;
                                                                }

                                                                public String[] getOptionLabels() {
                                                                    return null;
                                                                }

                                                                public String[] getDefaultValue() {
                                                                    return new String[] { Boolean.toString(true) };
                                                                }

                                                                public int getCardinality() {
                                                                    return 0;
                                                                }
                                                            };

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled }, new AttributeDefinition[] { Secure }));
    }

    @Override
    public String[] getDependencies() {
        return new String[] {};
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
    }

    /**
     * @return the SERVICE_PID
     */
    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public boolean isInitialized() {
        return super.isInitialized() && webContainer != null;
    }

    @Override
    public void configurationPropertiesSet(Set<String> changedProps) throws ConfigurationException {
        if (configProperties != null && wcTracker == null) {
            String instanceIds = (String) configProperties.get("org.ops4j.pax.web.instanceId");
            try {
                wcTracker = new WebcontainerTracker(context, instanceIds, new WebcontainerTracker.WebcontainerTrackerListener() {

                    public void webcontainerUnAvailable(String instanceId, WebContainer wc) {
                        Activator.this.webContainer = null;
                        stopLocked(false);
                    }

                    public void webcontainerAvailable(String instanceId, WebContainer wc) {
                        Activator.this.webContainer = wc;
                        if (isInitialized()) {
                            startLocked();
                        }
                    }
                });
                wcTracker.open();
            } catch (InvalidSyntaxException ise) {
                throw new ConfigurationException("org.ops4j.pax.web.instanceId", ise.getMessage());
            }
        }
    }

    @Override
    public void start() {
        try {
            final String serviceUserName = ServicesDictionary.getUser(configProperties, null);
            final String servicePassword = ServicesDictionary.getPassword(configProperties, null);

            servlet = new StatusServlet(context);
            PathSpec ps = new PathSpec("*");
            Boolean requireSSL = ServicesDictionary.getRequireSSL(configProperties);
            final boolean reqSSL = (requireSSL != null) ? requireSSL.booleanValue() : false;

            HttpContext httpContext = null;
            String secure = (String) configProperties.get("org.openanzo.servlet.status.secure");
            if (secure == null || Boolean.parseBoolean(secure)) {
                httpContext = new BasicAuthenticator(context, reqSSL ? SecurityConstraint.INTEGRAL : SecurityConstraint.NONE, new IAuthenticatorRealm() {
                    public AnzoPrincipal authenticate(String userId, Object credentials, Request request) {
                        if (userId != null && serviceUserName.equals(userId) && credentials != null && credentials.equals(servicePassword)) {
                            HashSet<URI> rolesSet = new HashSet<URI>();
                            URI userURI = Constants.valueFactory.createURI("http://openanzo.org/system/internal/sysadmin");
                            rolesSet.add(userURI);
                            rolesSet.add(Constants.AUTHENTICATED_USERS_ROLE);
                            rolesSet.add(Constants.EVERYONE_ROLE);
                            AnzoPrincipal principal = new AnzoPrincipal(userId, userURI, rolesSet, true, false);
                            return principal;
                        } else {
                            return null;
                        }
                    }
                }, null, Collections.<PathSpec> emptySet(), Collections.<PathSpec> singleton(ps));
            }
            webContainer.registerServlet(servlet, new String[] { "/status/*" }, null, httpContext);
        } catch (ServletException se) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error starting status servlet", se);
            throw new RuntimeException(se);
        } catch (AnzoException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error starting status servlet", ae);
            throw new AnzoRuntimeException(ae);
        }
    }

    @Override
    public void stop(boolean bundleStopping) {
        if (webContainer != null)
            webContainer.unregisterServlet(servlet);
        if (wcTracker != null && bundleStopping) {
            wcTracker.close();
            wcTracker = null;
        }
    }
}
