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
package org.openanzo.security.ldap;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.text.MessageFormat;
import java.util.Dictionary;
import java.util.Properties;
import java.util.Set;

import org.openanzo.cache.CachedAuthenticationService;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.LDAPAttributes;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.rdf.Constants.OSGI;
import org.openanzo.security.keystore.KeyStoreDictionary;
import org.openanzo.security.ldap.attributes.LDAPAuthAttributes;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IUserRolesExtender;
import org.openanzo.services.LDAPDictionary;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPJSSESecureSocketFactory;
import com.novell.ldap.LDAPReferralException;
import com.novell.ldap.LDAPSearchResults;

/**
 * Activator for LDAP Authentication provider
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class LdapAuthenticatorActivator extends ConfiguredServiceActivator {
    private static final Logger                    log                 = LoggerFactory.getLogger(LdapAuthenticatorActivator.class);

    private LdapAuthenticationProvider             authProvider        = null;

    private OsgiServiceTracker<IUserRolesExtender> extenderTracker;

    /** Service PID for LDAP Authentication Provider */
    public static final String                     SERVICE_PID         = "org.openanzo.security.ldap.LdapAuthentication";

    public static final GenericObjectClassDef      classDef            = new GenericObjectClassDef(SERVICE_PID, "LDAP Authentication Provider", "Authentication provider that binds to an embedded or external LDAP server for authentication and user's roles.", new AttributeDefinition[] { ServicesAttributes.Enabled, LDAPAuthAttributes.UseEmbeddedServer, LDAPAttributes.Host, LDAPAttributes.Port, LDAPAuthAttributes.RoleBaseDN, LDAPAuthAttributes.UserBaseDN, LDAPAuthAttributes.SysadminRole,
            LDAPAuthAttributes.UserSearch, LDAPAuthAttributes.RolesSearch, LDAPAuthAttributes.RoleObjectClass, LDAPAuthAttributes.UserObjectClass }, new AttributeDefinition[] { LDAPAttributes.UseSSL, LDAPAuthAttributes.UserIdAttribute, LDAPAttributes.LdapServerUser, LDAPAttributes.LdapServerPassword, LDAPAuthAttributes.RoleSearchFilter, LDAPAuthAttributes.UserSearchFilter }) {

                                                                           @SuppressWarnings("unchecked")
                                                                           @Override
                                                                           public boolean validateConfiguration(BundleContext context, Dictionary config) throws AnzoException {
                                                                               String host = LDAPDictionary.getHost(config, "localhost");
                                                                               Integer port = LDAPDictionary.getPort(config, 10389);
                                                                               String ldapAdminDN = LDAPDictionary.getLdapServerUser(config);
                                                                               String ldapAdminPassword = LDAPDictionary.getLdapServerPassword(config);

                                                                               String userSearch = LDAPAuthDictionary.getUserSearch(config);
                                                                               String rolesSearchTemplateFormat = LDAPAuthDictionary.getRolesSearch(config);
                                                                               String userId = (String) config.get("org.openanzo.ldap.testUserId");
                                                                               String testPassword = (String) config.get("org.openanzo.ldap.testPassword");
                                                                               String baseDN = LDAPAuthDictionary.getUserBaseDN(config);
                                                                               String roleBaseDN = LDAPAuthDictionary.getRoleBaseDN(config);

                                                                               String trustStorePassword = KeyStoreDictionary.getClientTrustPassword(config);
                                                                               String truststoreType = KeyStoreDictionary.getClientTruststoreType(config);
                                                                               String truststoreFile = OsgiConfigurationUtils.preprocessString(KeyStoreDictionary.getClientTrustFileLocation(config), context);

                                                                               String keyStorePassword = KeyStoreDictionary.getKeyPassword(config);
                                                                               String keystoreType = KeyStoreDictionary.getKeystoreType(config);
                                                                               String keystoreFile = OsgiConfigurationUtils.preprocessString(KeyStoreDictionary.getKeyFileLocation(config), context);

                                                                               boolean usessl = false;
                                                                               Boolean useSSL = LDAPDictionary.getUseSSL(config);
                                                                               if (useSSL != null) {
                                                                                   usessl = useSSL.booleanValue();
                                                                               }
                                                                               try {
                                                                                   userSearch = (new MessageFormat(userSearch)).format(new String[] { userId });
                                                                               } catch (java.lang.IllegalArgumentException e) {
                                                                                   throw new AnzoException(ExceptionConstants.SERVER.INSTALL_LDAP_INVALID_CONFIGURATION, e);
                                                                               }

                                                                               if (userId == null || userId.trim().length() == 0) {
                                                                                   throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, "org.openanzo.ldap.testUserId");
                                                                               }
                                                                               if (testPassword == null || testPassword.trim().length() == 0) {
                                                                                   throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, "org.openanzo.ldap.testPassword");
                                                                               }
                                                                               LDAPConnection ldapConnection = null;
                                                                               try {
                                                                                   if (usessl) {
                                                                                       //String anzoHome = context.getProperty("ANZO_HOME");
                                                                                       Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

                                                                                       ldapConnection = new LDAPConnection(new LDAPJSSESecureSocketFactory(Utils.getSSLSocketFactory(keystoreFile, keyStorePassword, keystoreType, truststoreFile, trustStorePassword, truststoreType)));
                                                                                   } else {
                                                                                       ldapConnection = new LDAPConnection();
                                                                                   }
                                                                                   try {
                                                                                       ldapConnection.connect(host, port);
                                                                                       try {
                                                                                           ldapConnection.bind(LDAPConnection.LDAP_V3, ldapAdminDN, ldapAdminPassword.getBytes("UTF8"));
                                                                                       } catch (LDAPException e) {
                                                                                           throw new AnzoException(ExceptionConstants.SERVER.INSTALL_LDAP_ADMIN_BIND, e, ldapAdminDN);
                                                                                       } catch (UnsupportedEncodingException e) {
                                                                                           throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR, e);
                                                                                       }
                                                                                       LDAPSearchResults results = null;
                                                                                       try {
                                                                                           results = ldapConnection.search(baseDN, LDAPConnection.SCOPE_SUB, userSearch, null, false);
                                                                                       } catch (LDAPException e) {
                                                                                           throw new AnzoException(ExceptionConstants.SERVER.INSTALL_LDAP_ADMIN_SEARCH, e);
                                                                                       }
                                                                                       try {
                                                                                           if (results.hasMore()) {
                                                                                               LDAPEntry entry = results.next();
                                                                                               if (entry != null) {
                                                                                                   String dn = entry.getDN();
                                                                                                   LDAPConnection userConnection = null;
                                                                                                   try {
                                                                                                       if (usessl) {
                                                                                                           //String anzoHome = context.getProperty("ANZO_HOME");
                                                                                                           Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                                                                                                           userConnection = new LDAPConnection(new LDAPJSSESecureSocketFactory(Utils.getSSLSocketFactory(keystoreFile, keyStorePassword, keystoreType, truststoreFile, trustStorePassword, truststoreType)));
                                                                                                       } else {
                                                                                                           userConnection = new LDAPConnection();
                                                                                                       }
                                                                                                       userConnection.connect(host, port);
                                                                                                       try {
                                                                                                           userConnection.bind(LDAPConnection.LDAP_V3, dn, testPassword.getBytes("UTF8"));
                                                                                                       } catch (LDAPException e) {
                                                                                                           throw new AnzoException(ExceptionConstants.SERVER.INSTALL_LDAP_USER_BIND, e, userId);
                                                                                                       } catch (UnsupportedEncodingException e) {
                                                                                                           throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR, e);
                                                                                                       }
                                                                                                       rolesSearchTemplateFormat = (new MessageFormat(rolesSearchTemplateFormat)).format(new String[] { dn });
                                                                                                       LDAPSearchResults rolesSearch = userConnection.search(roleBaseDN, LDAPConnection.SCOPE_SUB, rolesSearchTemplateFormat, null, false);
                                                                                                       try {
                                                                                                           if (rolesSearch.hasMore()) {
                                                                                                               String roleDN = Utils.encodeLdapUri("ldap://" + rolesSearch.next().getDN());
                                                                                                               org.openanzo.rdf.Constants.valueFactory.createURI(roleDN);
                                                                                                           }
                                                                                                       } catch (LDAPReferralException rfe) {
                                                                                                           log.debug("Error dereferencing referrel", rfe);
                                                                                                       }
                                                                                                   } finally {
                                                                                                       if (userConnection != null) {
                                                                                                           userConnection.disconnect();
                                                                                                       }
                                                                                                   }
                                                                                               } else {
                                                                                                   throw new AnzoException(ExceptionConstants.SERVER.INSTALL_LDAP_FAILED_TEST_SEARCH);
                                                                                               }
                                                                                           } else {
                                                                                               throw new AnzoException(ExceptionConstants.SERVER.INSTALL_LDAP_FAILED_TEST_SEARCH);
                                                                                           }
                                                                                       } catch (LDAPReferralException rfe) {
                                                                                           log.debug("Error dereferencing referrel", rfe);
                                                                                           throw new AnzoException(ExceptionConstants.SERVER.INSTALL_LDAP_FAILED_TEST_SEARCH);
                                                                                       }
                                                                                   } catch (LDAPException e) {
                                                                                       throw new AnzoException(ExceptionConstants.SERVER.INSTALL_LDAP_INVALID_CONFIGURATION, e);
                                                                                   } catch (AnzoRuntimeException e) {
                                                                                       throw new AnzoException(ExceptionConstants.SERVER.INSTALL_LDAP_INVALID_CONFIGURATION, e);
                                                                                   }
                                                                                   return true;
                                                                               } finally {
                                                                                   if (ldapConnection != null) {
                                                                                       try {
                                                                                           ldapConnection.disconnect();
                                                                                       } catch (LDAPException e) {
                                                                                           log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error disconnecting ldap connection", e);
                                                                                       }
                                                                                   }
                                                                               }
                                                                           }

                                                                       };

    private ServiceRegistration                    serviceRegistration = null;

    private boolean                                useEmbedded         = true;

    private boolean                                embeddedServerOk    = false;

    private ServiceTracker                         tracker             = null;

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { ICacheProvider.class.getName() };
    }

    @Override
    public boolean isInitialized() {
        return super.isInitialized() && (!useEmbedded || embeddedServerOk);
    }

    @Override
    public String getExtraStatus(boolean html) {
        StringBuilder sb = new StringBuilder(super.getExtraStatus(html));
        if (html) {
            sb.append("<br/>EmbeddedLdapServerOk:" + embeddedServerOk);

        } else {
            sb.append("\n EmbeddedLdapServerOk=" + embeddedServerOk);
        }
        return sb.toString();
    }

    @Override
    public void configurationPropertiesSet(Set<String> changedProperties) throws ConfigurationException {
        if (configProperties != null) {
            String host = context.getProperty(LDAPDictionary.KEY_LDAP_HOST);
            String port = context.getProperty(LDAPDictionary.KEY_LDAP_PORT);
            if (host != null) {
                LDAPDictionary.setHost(configProperties, host);
            }
            if (port != null) {
                LDAPDictionary.setPort(configProperties, Integer.valueOf(port));
            }
            Boolean useEmbedded = LDAPAuthDictionary.getUseEmbeddedServer(configProperties);
            if (useEmbedded != null) {
                this.useEmbedded = useEmbedded.booleanValue();
            }
            if (useEmbedded && tracker == null) {
                tracker = new ServiceTracker(context, "org.openanzo.ldap.internal.LdapServer", null) {
                    @Override
                    public Object addingService(ServiceReference reference) {
                        Object service = context.getService(reference);
                        embeddedServerOk = true;
                        if (isInitialized()) {
                            startLocked();
                        }
                        return service;
                    }

                    @Override
                    public void removedService(ServiceReference reference, Object serviceObject) {
                        context.ungetService(reference);
                        embeddedServerOk = false;
                        stopLocked(false);
                    }
                };
                tracker.open();
            }
        }
    }

    @Override
    public void start() throws AnzoException {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            authProvider = new LdapAuthenticationProvider(configProperties);
            authProvider.start();
            String[] topics = new String[] { CachedAuthenticationService.USER_CREDENTIALS_CHANGED_TOPIC, CachedAuthenticationService.USER_ROLES_CHANGED_TOPIC, OSGI.RESET_TOPIC };
            Properties props = new Properties();
            props.put(EventConstants.EVENT_TOPIC, topics);
            extenderTracker = new OsgiServiceTracker<IUserRolesExtender>(new IServiceTrackerListener<IUserRolesExtender>() {

                public void unregisterService(IUserRolesExtender extender) {
                    if (authProvider != null) {
                        authProvider.unregisterRoleExtender(extender);
                    }
                }

                public void registerService(IUserRolesExtender extender) {
                    if (authProvider != null) {
                        authProvider.registerRoleExtender(extender);
                    }
                }

                public Class<IUserRolesExtender> getComponentType() {
                    return IUserRolesExtender.class;
                }
            }, context);
            extenderTracker.open();
            serviceRegistration = context.registerService(new String[] { IAuthenticationService.class.getName(), EventHandler.class.getName() }, new CachedAuthenticationService(authProvider, getDependency(ICacheProvider.class)), props);
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    @Override
    public void stop(boolean bundleStopping) {
        if (extenderTracker != null) {
            extenderTracker.close();
            extenderTracker = null;
        }
        if (authProvider != null) {
            try {
                authProvider.close();
            } catch (AnzoException ae) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error stopping ldap authentication provider", ae);
            }
        }
        if (!bundleStopping && serviceRegistration != null) {
            serviceRegistration.unregister();
            serviceRegistration = null;
        }
        if (tracker != null) {
            tracker.close();
        }
    }

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef;
    }
}
