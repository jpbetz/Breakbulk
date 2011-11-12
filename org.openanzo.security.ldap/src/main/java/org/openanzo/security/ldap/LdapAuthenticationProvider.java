/*******************************************************************************
 * Copyright (c) 2004, 2007-2010 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/security/LdapAuthenticationProvider.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  8/25/2006
 * Revision:	$Id: LdapAuthenticationProvider.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.security.ldap;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.security.keystore.KeyStoreDictionary;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUserRolesExtender;
import org.openanzo.services.LDAPDictionary;
import org.openanzo.services.ServicesDictionary;
import org.openanzo.services.impl.BaseAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPJSSESecureSocketFactory;
import com.novell.ldap.LDAPReferralException;
import com.novell.ldap.LDAPSearchConstraints;
import com.novell.ldap.LDAPSearchResults;

/**
 * Ldap authentication providers an example that authenticates userid and password against an ldap store, and returns the a value from ldap that maps to an Anzo
 * id
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class LdapAuthenticationProvider extends BaseAuthenticationService {

    private static final Logger                            log                       = LoggerFactory.getLogger(LdapAuthenticationProvider.class);

    private String                                         ldapHost                  = null;

    private Integer                                        ldapPort                  = null;

    /** Basedn for ldap search */
    private String                                         userBaseDN                = "ou=users,dc=openanzo,dc=org";

    private String                                         roleBaseDN                = "ou=groups,dc=openanzo,dc=org";

    private String                                         ldapPrefix                = "ldap://";

    private String                                         rolesSearchTemplate       = "(&(member={0})(objectclass=groupOfNames))";

    private MessageFormat                                  rolesSearchTemplateFormat = null;

    private String                                         userSearchTemplate        = "(uid={0})";

    private MessageFormat                                  userSearchTemplateFormat  = null;

    /** LDAP attribute that maps to user's id in server, if null DN is converted to URI */
    private String                                         uidIdAttribute            = null;

    /** LDAP administrator userId */
    private String                                         ldapAdministratorDN       = null;

    /** LDAP administrator password */
    private String                                         ldapAdministratorPassword = null;

    private String                                         serviceUserName           = null;

    private String                                         servicePassword           = null;

    private boolean                                        anonymousUserEnabled      = false;

    private String                                         keystoreFile              = null;

    private String                                         keystorePassword          = null;

    private String                                         keystoreType              = null;

    private String                                         truststoreFile            = null;

    private String                                         truststorePassword        = null;

    private String                                         truststoreType            = null;

    private LdapConnectionManager                          connectionManager         = null;

    private Set<URI>                                       sysadminRoles             = new HashSet<URI>();

    private Dictionary<? extends Object, ? extends Object> configProperties          = null;

    private static int                                     MAX_RETRIES               = 10;

    private boolean                                        connecting                = false;

    /**
     * Determines whether to try to connect to LDAP. If true, the system won't connect to an LDAP server. This is used mainly for testing to avoid making
     * connections that will need to timeout.
     */
    private boolean                                        offline                   = false;

    private boolean                                        useSSL                    = false;

    private LDAPJSSESecureSocketFactory                    ssf;

    private ReentrantReadWriteLock                         resetLock                 = new ReentrantReadWriteLock();

    static final String                                    KEY_OFFLINE               = "org.openanzo.security.ldap.offline";

    static final LDAPSearchConstraints                     defaultConstraints        = new LDAPSearchConstraints();
    static {
        defaultConstraints.setServerTimeLimit(60);
    }

    static final LDAPSearchConstraints                     userConstraints           = new LDAPSearchConstraints();
    static {
        userConstraints.setMaxResults(2);
        userConstraints.setServerTimeLimit(60);
        userConstraints.setReferralFollowing(false);
        userConstraints.setHopLimit(0);

    }

    /**
     * Create new LdapAuthenticationProvider with provided configuration properties
     */
    protected LdapAuthenticationProvider(Dictionary<? extends Object, ? extends Object> configProperties) {
        this.configProperties = configProperties;
    }

    public String getName() {
        return "service=LdapAuthenticationProvider";
    }

    public String getDescription() {
        return "Ldap Authentication Provider";
    }

    public void start() throws AnzoException {
        String rolesSearchTemplate = LDAPAuthDictionary.getRolesSearch(configProperties);
        if (rolesSearchTemplate != null) {
            this.rolesSearchTemplate = rolesSearchTemplate;
        }
        String userSearchTemplate = LDAPAuthDictionary.getUserSearch(configProperties);
        if (userSearchTemplate != null) {
            this.userSearchTemplate = userSearchTemplate;
        }
        String uidIdAttribute = LDAPAuthDictionary.getUserIdAttribute(configProperties);
        if (uidIdAttribute != null && uidIdAttribute.length() > 0) {
            this.uidIdAttribute = uidIdAttribute;
        }

        String userBaseDN = LDAPAuthDictionary.getUserBaseDN(configProperties);
        if (userBaseDN != null) {
            this.userBaseDN = userBaseDN;
        }

        String roleBaseDN = LDAPAuthDictionary.getRoleBaseDN(configProperties);
        if (roleBaseDN != null) {
            this.roleBaseDN = roleBaseDN;
        }

        String sysadminRolesIn = LDAPAuthDictionary.getSysadminRole(configProperties);
        StringTokenizer st = new StringTokenizer(sysadminRolesIn, "|");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.startsWith(ldapPrefix)) {
                sysadminRoles.add(Constants.valueFactory.createURI(token));
            } else {
                if (token.endsWith(roleBaseDN)) {
                    sysadminRoles.add(dnToUri(token));
                } else {
                    sysadminRoles.add(dnToUri(token + "," + roleBaseDN));
                }
            }
        }
        Boolean useSSL = LDAPDictionary.getUseSSL(configProperties);
        if (useSSL != null) {
            this.useSSL = useSSL.booleanValue();
        }

        Boolean anonymousEnabled = LDAPAuthDictionary.getAnonymousAccessEnabled(configProperties);
        this.anonymousUserEnabled = anonymousEnabled == null ? false : anonymousEnabled;

        this.serviceUserName = ServicesDictionary.getUser(configProperties, null);
        this.servicePassword = ServicesDictionary.getPassword(configProperties, null);
        this.ldapHost = LDAPDictionary.getHost(configProperties, null);
        this.ldapPort = LDAPDictionary.getPort(configProperties, null);
        this.ldapAdministratorDN = LDAPDictionary.getLdapServerUser(configProperties);
        this.ldapAdministratorPassword = LDAPDictionary.getLdapServerPassword(configProperties);

        keystoreFile = KeyStoreDictionary.getKeyFileLocation(configProperties);
        keystorePassword = KeyStoreDictionary.getKeyPassword(configProperties);
        keystoreType = KeyStoreDictionary.getKeystoreType(configProperties);
        truststoreFile = KeyStoreDictionary.getClientTrustFileLocation(configProperties);
        truststorePassword = KeyStoreDictionary.getClientTrustPassword(configProperties);
        truststoreType = KeyStoreDictionary.getClientTruststoreType(configProperties);

        Object offlineObj = configProperties.get(KEY_OFFLINE);
        if (offlineObj != null && offlineObj.equals("true")) {
            this.offline = true;
        }

        initialize();
    }

    void close() throws AnzoException {
        disconnect();

    }

    private void connect() throws AnzoException {
        synchronized (this) {
            if (offline) {
                // Don't connect in offline mode
                throw new AnzoException(ExceptionConstants.SERVER.LDAP_ERROR);
            }
            if (connectionManager == null) {
                AnzoException lastThrownException = null;
                if (connecting) {
                    try {
                        this.wait(10000);
                    } catch (InterruptedException ie) {
                        if (log.isInfoEnabled()) {
                            log.info(LogUtils.LIFECYCLE_MARKER, "Connecting to LDAP interrupted", ie);
                        }
                        return;
                    }
                } else {
                    connecting = true;
                    try {
                        int retries = 0;
                        while (retries < MAX_RETRIES) {
                            try {
                                LDAPConnection connection = bindUser(ldapAdministratorDN, ldapAdministratorPassword);
                                connection.disconnect();
                                connectionManager = new LdapConnectionManager(ldapAdministratorDN, ldapAdministratorPassword, ldapHost, ldapPort, useSSL, keystoreFile, keystorePassword, keystoreType, truststoreFile, truststorePassword, truststoreType);
                                break;
                            } catch (Exception ae) {
                                if (log.isInfoEnabled()) {
                                    log.info(LogUtils.LIFECYCLE_MARKER, "Retrying connection to ldap server:" + retries, ae);
                                }
                                if (ae instanceof AnzoException)
                                    lastThrownException = (AnzoException) ae;
                                retries++;
                            }
                            try {
                                this.wait((retries * 1000));
                            } catch (InterruptedException ie) {
                                if (log.isInfoEnabled()) {
                                    log.info(LogUtils.LIFECYCLE_MARKER, "Connecting to LDAP interrupted", ie);
                                }
                                return;
                            }
                        }
                        if (connectionManager == null) {
                            if (lastThrownException != null) {
                                log.error(LogUtils.LIFECYCLE_MARKER, "Error connecting to ldap server", lastThrownException);
                            }
                            throw new AnzoException(ExceptionConstants.SERVER.LDAP_ERROR);
                        }
                    } finally {
                        this.notifyAll();
                        connecting = false;
                    }
                }

            }
        }

    }

    private void disconnect() throws AnzoException {
        if (connectionManager != null) {
            connectionManager.close();
            connectionManager = null;
        }
    }

    private URI dnToUri(String dn) throws AnzoException {
        try {
            String uri = ldapPrefix + dn;
            return Constants.valueFactory.createURI(Utils.encodeLdapUri(uri));
        } catch (AnzoRuntimeException are) {
            throw are.getAnzoException();
        }
    }

    private LDAPConnection bindUser(String userDN, String password) throws AnzoException, LDAPException {
        LDAPConnection ctx = null;
        try {
            if (this.useSSL) {

                if (ssf == null) {
                    Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    ssf = new LDAPJSSESecureSocketFactory(Utils.getSSLSocketFactory(keystoreFile, keystorePassword, keystoreType, truststoreFile, truststorePassword, truststoreType));
                }
                ctx = new LDAPConnection(ssf);
            } else {
                ctx = new LDAPConnection();
            }
            ctx.connect(ldapHost, ldapPort);
            ctx.bind(LDAPConnection.LDAP_V3, userDN, password.getBytes("UTF8"));
        } catch (LDAPException ae) {
            log.error(LogUtils.SECURITY_MARKER, "LdapException binding user [" + userDN + "] :" + ae.getLDAPErrorMessage(), ae);
            throw new AnzoException(ExceptionConstants.SERVER.BAD_USER_PASSWORD, ae, userDN);
        } catch (UnsupportedEncodingException uee) {
            throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR, uee);
        }
        return ctx;
    }

    private UserResult searchForUser(LDAPConnection connection, String userName) throws AnzoException {
        LDAPConnection ctx = null;
        LDAPSearchResults results = null;
        String uniqueId = null;
        String authenticateDN = "";
        try {
            String resultAttributes[] = (uidIdAttribute != null) ? new String[] { uidIdAttribute } : null;
            String filter = userSearchTemplateFormat.format(new String[] { userName });
            if (connection == null) {
                ctx = connectionManager.getConnection();
            } else {
                ctx = connection;
            }
            results = ctx.search(userBaseDN, LDAPConnection.SCOPE_SUB, filter, resultAttributes, false, userConstraints);
            if (results.hasMore()) {
                LDAPEntry searchResult = results.next();
                if (results.hasMore()) {
                    try {
                        results.next();
                        throw new AnzoException(ExceptionConstants.SERVER.USERID_MULTIPLE_USERS, userName);
                    } catch (LDAPReferralException lre) {
                        log.debug(LogUtils.SECURITY_MARKER, "Error dereferencing referrel", lre);
                    }
                }
                authenticateDN = searchResult.getDN();
                uniqueId = authenticateDN;
                if (resultAttributes != null) {
                    LDAPAttribute attribute = searchResult.getAttribute(uidIdAttribute);
                    Object value = attribute.getStringValue();
                    if (value instanceof String) {
                        uniqueId = (String) value;
                    } else {
                        try {
                            byte b[] = (byte[]) value;
                            String s = new String(b, "ISO-8859-1");
                            uniqueId = s;
                        } catch (UnsupportedEncodingException e) {
                            log.error(LogUtils.SECURITY_MARKER, "Invalid byte encoding for ldap value", e);
                        }
                    }
                }
                return new UserResult(authenticateDN, uniqueId);
            } else {
                throw new AnzoException(ExceptionConstants.SERVER.UNKNOWN_USER_ERROR, userName);
            }
        } catch (LDAPException ne) {
            log.warn(LogUtils.SECURITY_MARKER, "LdapException searching for user", ne);
            throw new AnzoException(ExceptionConstants.SERVER.ERROR_SEARCHING_USERS, ne, userName);
        } finally {
            if (results != null) {
                try {
                    if (ctx != null && connection == null) {
                        ctx.disconnect();
                    }
                } catch (LDAPException e) {
                    log.warn(LogUtils.SECURITY_MARKER, "Error diconnecting ldap connection", e);
                }
            }
        }
    }

    @Override
    protected AnzoPrincipal getUserPrincipalInternal(IOperationContext context, String userName) throws AnzoException {
        try {
            if (userName.equals(serviceUserName)) {
                HashSet<URI> rolesSet = new HashSet<URI>();
                rolesSet.add(Constants.DEFAULT_SYSADMIN);
                rolesSet.add(Constants.AUTHENTICATED_USERS_ROLE);
                rolesSet.add(Constants.EVERYONE_ROLE);
                AnzoPrincipal principal = new AnzoPrincipal(userName, Constants.DEFAULT_SYSADMIN, rolesSet, true, false);
                return principal;
            } else if (anonymousUserEnabled && userName.equals(Constants.DEFAULT_ANONYMOUS_USER)) {
                HashSet<URI> rolesSet = new HashSet<URI>();
                rolesSet.add(Constants.DEFAULT_ANONYMOUS);
                rolesSet.add(Constants.EVERYONE_ROLE);
                AnzoPrincipal principal = new AnzoPrincipal(userName, Constants.DEFAULT_ANONYMOUS, rolesSet, false, true);
                return principal;
            }
            if (connectionManager == null) {
                connect();
            }
            LDAPConnection connection = connectionManager.getConnection();
            try {
                UserResult result = searchForUser(connection, userName);
                ArrayList<String> roles = getRoles(connection, result.authenticateDN);
                boolean sysAdmin = false;
                HashSet<URI> rolesSet = new HashSet<URI>();
                URI userURI = dnToUri(result.uniqueID);
                rolesSet.add(userURI);
                rolesSet.add(Constants.AUTHENTICATED_USERS_ROLE);
                rolesSet.add(Constants.EVERYONE_ROLE);
                for (String role : roles) {
                    URI roleURI = dnToUri(role);
                    rolesSet.add(roleURI);
                    if (!sysAdmin && sysadminRoles.contains(roleURI)) {
                        sysAdmin = true;
                    }
                }
                for (IUserRolesExtender extender : roleExtenders) {
                    Set<URI> extraRoles = extender.getRolesForUser(context, userURI);
                    if (extraRoles != null) {
                        rolesSet.addAll(extraRoles);
                    }
                }
                AnzoPrincipal principal = new AnzoPrincipal(userName, userURI, rolesSet, sysAdmin, false);
                return principal;
            } finally {
                connectionManager.returnConnection(connection);
            }
        } catch (AnzoException ae) {
            log.info(LogUtils.SECURITY_MARKER, "Error getting user pricipal", ae);
            throw ae;
        }
    }

    @Override
    protected AnzoPrincipal authenticateUserInternal(IOperationContext context, String userName, String password) throws AnzoException {
        if (userName.equals(serviceUserName) && password.equals(servicePassword)) {
            HashSet<URI> rolesSet = new HashSet<URI>();
            rolesSet.add(Constants.DEFAULT_SYSADMIN);
            rolesSet.add(Constants.AUTHENTICATED_USERS_ROLE);
            rolesSet.add(Constants.EVERYONE_ROLE);
            AnzoPrincipal principal = new AnzoPrincipal(userName, Constants.DEFAULT_SYSADMIN, rolesSet, true, false);
            return principal;
        } else if (anonymousUserEnabled && userName.equals(Constants.DEFAULT_ANONYMOUS_USER)) {
            HashSet<URI> rolesSet = new HashSet<URI>();
            rolesSet.add(Constants.DEFAULT_ANONYMOUS);
            rolesSet.add(Constants.EVERYONE_ROLE);
            AnzoPrincipal principal = new AnzoPrincipal(userName, Constants.DEFAULT_ANONYMOUS, rolesSet, false, true);
            return principal;
        }
        if (connectionManager == null) {
            connect();
        }
        LDAPConnection ctx = null;
        ArrayList<String> roles = null;
        LDAPConnection connection = connectionManager.getConnection();
        UserResult result = null;
        try {
            try {
                result = searchForUser(connection, userName);
            } finally {
                connectionManager.returnConnection(connection);
            }
            try {
                ctx = bindUser(result.authenticateDN, password);
                roles = getRoles(ctx, result.authenticateDN);
            } finally {
                if (ctx != null) {
                    ctx.disconnect();
                }
            }
        } catch (AnzoException ae) {
            log.info(LogUtils.SECURITY_MARKER, "Error authentication user", ae);
            throw ae;
        } catch (LDAPException ne) {
            log.error(LogUtils.SECURITY_MARKER, "Ldap exception authentication user [" + userName + "] : " + ne.getLDAPErrorMessage(), ne);
            throw new AnzoException(ExceptionConstants.SERVER.ERROR_SEARCHING_USERS, userName);
        }
        boolean sysAdmin = false;
        URI userURI = dnToUri(result.uniqueID);
        HashSet<URI> rolesSet = new HashSet<URI>();
        rolesSet.add(userURI);
        rolesSet.add(Constants.AUTHENTICATED_USERS_ROLE);
        rolesSet.add(Constants.EVERYONE_ROLE);
        for (String role : roles) {
            URI roleURI = dnToUri(role);
            rolesSet.add(roleURI);
            if (!sysAdmin && sysadminRoles.contains(roleURI)) {
                sysAdmin = true;
            }
        }
        for (IUserRolesExtender extender : roleExtenders) {
            Set<URI> extraRoles = extender.getRolesForUser(context, userURI);
            if (extraRoles != null) {
                rolesSet.addAll(extraRoles);
            }
        }
        AnzoPrincipal principal = new AnzoPrincipal(userName, userURI, rolesSet, sysAdmin, false);
        return principal;
    }

    private ArrayList<String> getRoles(LDAPConnection context, String userDn) throws AnzoException {
        ArrayList<String> list = new ArrayList<String>();
        String filter = rolesSearchTemplateFormat.format(new String[] { Utils.escapeDN(userDn) });

        try {
            LDAPSearchResults results = context.search(roleBaseDN, LDAPConnection.SCOPE_SUB, filter, null, false, defaultConstraints);
            while (results.hasMore()) {
                try {
                    LDAPEntry result = results.next();
                    list.add(result.getDN());
                } catch (LDAPReferralException rfe) {
                    log.debug(LogUtils.SECURITY_MARKER, "Error dereferencing referrel", rfe);
                }
            }
        } catch (LDAPException ne) {
            log.error(LogUtils.SECURITY_MARKER, "LdapException searching for user's [" + userDn + "] roles:" + ne.getLDAPErrorMessage(), ne);
            throw new AnzoException(ExceptionConstants.SERVER.ERROR_SEARCHING_USERS, ne, userDn);
        }
        return list;

    }

    void initialize() throws AnzoException {

        rolesSearchTemplateFormat = new MessageFormat(rolesSearchTemplate);
        userSearchTemplateFormat = new MessageFormat(userSearchTemplate);

    }

    static class UserResult {
        String authenticateDN = null;

        String uniqueID       = null;

        UserResult(String authenticateDN, String uniqueID) {
            this.authenticateDN = authenticateDN;
            this.uniqueID = uniqueID;
        }
    }

    public ReentrantReadWriteLock getLockProvider() {
        return resetLock;
    }
}
