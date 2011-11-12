/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 16, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.ldap.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.Security;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.ldap.InitialLdapContext;

import org.apache.directory.server.constants.ServerDNConstants;
import org.apache.directory.server.core.DefaultDirectoryService;
import org.apache.directory.server.core.DirectoryService;
import org.apache.directory.server.core.entry.DefaultServerEntry;
import org.apache.directory.server.core.entry.ServerEntry;
import org.apache.directory.server.core.interceptor.context.AddOperationContext;
import org.apache.directory.server.core.jndi.CoreContextFactory;
import org.apache.directory.server.core.partition.Partition;
import org.apache.directory.server.core.partition.impl.btree.jdbm.JdbmPartition;
import org.apache.directory.server.protocol.shared.transport.TcpTransport;
import org.apache.directory.server.protocol.shared.transport.Transport;
import org.apache.directory.shared.ldap.constants.SchemaConstants;
import org.apache.directory.shared.ldap.csn.CsnFactory;
import org.apache.directory.shared.ldap.ldif.LdifEntry;
import org.apache.directory.shared.ldap.ldif.LdifReader;
import org.apache.directory.shared.ldap.name.LdapDN;
import org.apache.directory.shared.ldap.schema.SchemaUtils;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Constants.OSGI;
import org.openanzo.security.keystore.KeyStoreDictionary;
import org.openanzo.services.LDAPDictionary;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LdapServer {
    private static final Logger                               log             = LoggerFactory.getLogger(LdapServer.class);

    private static final int                                  DEFAULT_TIMEOUT = 30000;

    private final DefaultDirectoryService                     directoryService;

    private final org.apache.directory.server.ldap.LdapServer ldapService;

    protected LdapServer(final BundleContext context, final Dictionary<? extends Object, ? extends Object> configProperties, EventAdmin eventAdmin) throws Exception {
        final ClassLoader currentLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        boolean exists = false;
        final File ldapDirectory = context.getDataFile("ldap-anzo");
        exists = ldapDirectory.exists();
        final String purge = context.getProperty("purgeLdap");
        if (purge != null && Boolean.parseBoolean(purge)) {
            if (exists) {
                deleteFile(ldapDirectory);
                exists = false;
            }
        }
        boolean reqSSL = false;
        Boolean requireSSL = ServicesDictionary.getRequireSSL(configProperties);
        if (requireSSL != null) {
            reqSSL = requireSSL.booleanValue();
        }

        final String searchBaseDN = LDAPDictionary.getSearchBaseDN(configProperties);
        String id = LDAPDictionary.getId(configProperties);
        if (id == null) {
            id = "OpenAnzo";
        }
        final String suffix = LDAPDictionary.getSuffix(configProperties);
        final String o = LDAPDictionary.getOrganization(configProperties);

        final String principal = LDAPDictionary.getLdapServerUser(configProperties);
        final String credentials = LDAPDictionary.getLdapServerPassword(configProperties);

        final String initFile = LDAPDictionary.getInitFile(configProperties);

        directoryService = new DefaultDirectoryService();
        directoryService.setShutdownHookEnabled(false);
        directoryService.setWorkingDirectory(ldapDirectory);
        ldapService = new org.apache.directory.server.ldap.LdapServer();
        Transport transports[] = new Transport[1];
        transports[0] = new TcpTransport(LDAPDictionary.getPort(configProperties, null));
        if (reqSSL) {
            transports[0].setEnableSSL(true);
        }
        ldapService.setTransports(transports);
        ldapService.setDirectoryService(directoryService);
        final int timeout = ServicesDictionary.getTimeout(configProperties, DEFAULT_TIMEOUT);
        ldapService.setMaxTimeLimit(timeout);
        ldapService.setSearchBaseDn(searchBaseDN);
        ldapService.setAllowAnonymousAccess(true);

        if (reqSSL) {
            Security.setProperty("keystore.type", KeyStoreDictionary.getKeystoreType(configProperties));
            ldapService.setKeystoreFile(KeyStoreDictionary.getKeyFileLocation(configProperties));
            ldapService.setCertificatePassword(KeyStoreDictionary.getKeyPassword(configProperties));
        }
        directoryService.setExitVmOnShutdown(true);
        directoryService.setShutdownHookEnabled(true);
        directoryService.startup();
        final Partition partition = new JdbmPartition();
        partition.setId(id);
        partition.setSuffix(suffix);
        directoryService.addPartition(partition);

        final LdapDN suffixDn = new LdapDN(suffix);
        suffixDn.normalize(directoryService.getRegistries().getAttributeTypeRegistry().getNormalizerMapping());
        ServerEntry ctxEntry = directoryService.newEntry(suffixDn);
        //final ServerEntry ctxEntry = new DefaultServerEntry(directoryService.getRegistries(), suffixDn);
        ctxEntry.put("objectClass", "top", "organization");
        ctxEntry.put("o", o);
        CsnFactory csnFactory = new CsnFactory(0);
        ctxEntry.add(SchemaConstants.ENTRY_CSN_AT, csnFactory.newInstance().toString());
        ctxEntry.add(SchemaConstants.ENTRY_UUID_AT, SchemaUtils.uuidToBytes(UUID.randomUUID()));
        partition.add(new AddOperationContext(directoryService.getAdminSession(), ctxEntry));

        final Hashtable<String, Object> env = new Hashtable<String, Object>();
        env.put(DirectoryService.JNDI_KEY, directoryService);
        env.put(Context.SECURITY_PRINCIPAL, principal);
        env.put(Context.SECURITY_CREDENTIALS, credentials);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.INITIAL_CONTEXT_FACTORY, CoreContextFactory.class.getName());

        final Hashtable<String, Object> envFinal = new Hashtable<String, Object>(env);
        envFinal.put(Context.PROVIDER_URL, ServerDNConstants.SYSTEM_DN);
        new InitialLdapContext(envFinal, null);

        envFinal.put(Context.PROVIDER_URL, "");
        directoryService.getAdminSession();

        envFinal.put(Context.PROVIDER_URL, ServerDNConstants.OU_SCHEMA_DN);
        new InitialLdapContext(envFinal, null);

        if (!exists) {
            if (initFile != null) {
                InputStream is = null;
                if (initFile.startsWith("bundle://")) {
                    final URL inputURL = context.getBundle().getEntry(initFile);
                    is = inputURL.openStream();
                } else {
                    is = new FileInputStream(initFile);
                }
                try {
                    for (final LdifEntry ldifEntry : new LdifReader(is)) {
                        directoryService.getAdminSession().add(new DefaultServerEntry(directoryService.getRegistries(), ldifEntry.getEntry()));
                    }
                } finally {
                    is.close();
                }
            } else {
                LdapDN usersDn = new LdapDN("ou=users," + suffix);
                ServerEntry usersEntry = directoryService.newEntry(usersDn);
                usersEntry.put("objectClass", "top", "organizationalUnit");
                usersEntry.put("ou", "users");
                directoryService.getAdminSession().add(usersEntry);

                LdapDN groupsDn = new LdapDN("ou=groups," + suffix);
                ServerEntry groupsEntry = directoryService.newEntry(groupsDn);
                groupsEntry.put("objectClass", "top", "organizationalUnit");
                groupsEntry.put("ou", "groups");
                directoryService.getAdminSession().add(groupsEntry);

            }
        }
        ldapService.start();

        Thread.currentThread().setContextClassLoader(currentLoader);
        Dictionary<Object, Object> props = new Properties();
        ServicesDictionary.setEnabled(props, true);
        eventAdmin.postEvent(new Event(OSGI.LDAP_SERVER_TOPIC, props));
        context.registerService(LdapServer.class.getName(), this, null);
    }

    protected void stop(boolean bundleStopping) {
        if (directoryService != null) {
            try {
                ldapService.stop();
                directoryService.shutdown();
            } catch (final Exception ie) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error stopping the ApacheDS embedded server", ie);
                throw new AnzoRuntimeException(ExceptionConstants.COMBUS.STOP_BROKER_FAILED, ie);
            }
        }
    }

    private void deleteFile(final File file) {
        if (file.isDirectory()) {
            for (final File subFile : file.listFiles()) {
                deleteFile(subFile);
            }
        }
        file.delete();
    }
}
