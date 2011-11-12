/*******************************************************************************
 * Copyright (c) 2010 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 * Created on:  March 8, 2010
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.security.ldap;

import java.util.Collections;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import junit.framework.TestCase;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.impl.BaseOperationContext;

/**
 * Unit tests for LdapAuthenticationProvider.
 * 
 * @author Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 */
public class LdapAuthenticationProviderTest extends TestCase {

    private static final AnzoPrincipal sysadminPrincipal;
    static {
        HashSet<URI> rolesSet = new HashSet<URI>();
        rolesSet.add(Constants.DEFAULT_SYSADMIN);
        rolesSet.add(Constants.AUTHENTICATED_USERS_ROLE);
        rolesSet.add(Constants.EVERYONE_ROLE);
        sysadminPrincipal = new AnzoPrincipal("sysadmin", Constants.DEFAULT_SYSADMIN, rolesSet, true, false);
    }

    private static final Set<URI>      expectedAnonymousRoles;
    static {
        HashSet<URI> rolesSet = new HashSet<URI>();
        rolesSet.add(Constants.DEFAULT_ANONYMOUS);
        rolesSet.add(Constants.EVERYONE_ROLE);
        expectedAnonymousRoles = Collections.unmodifiableSet(rolesSet);
    }

    private Dictionary<Object, Object> getBasicConfigProperties() {
        Dictionary<Object, Object> configProperties = new Hashtable<Object, Object>();
        configProperties.put(LdapAuthenticationProvider.KEY_OFFLINE, "true"); // This is just for the test so that it doesn't try to connect to an LDAP server.
        LDAPAuthDictionary.setSysadminRole(configProperties, "");
        return configProperties;
    }

    /**
     * Makes sure that by the default the LdapAuthenticationProvider rejects authentication as the anonymous user.
     * 
     * @throws Exception
     */
    public void testAuthenticateUserDoesNotAuthenticateAnonymousByDefault() throws Exception {
        Dictionary<Object, Object> configProperties = getBasicConfigProperties();
        LdapAuthenticationProvider authProvider = new LdapAuthenticationProvider(configProperties);
        authProvider.start();

        IOperationContext context = new BaseOperationContext("AuthenticateUser-AnonymousTest", "12345", sysadminPrincipal);

        // We expect an exception mainly because it will have to go to LDAP if anonymous authentication is disabled
        // and we haven't configured an LDAP server in this test.
        boolean expectedExceptionCaught = false;
        AnzoPrincipal principal = null;
        try {
            principal = authProvider.authenticateUser(context, Constants.DEFAULT_ANONYMOUS_USER, "123");
        } catch (AnzoException e) {
            expectedExceptionCaught = true;
        }
        assertTrue(expectedExceptionCaught);
        assertNull(principal);
    }

    /**
     * Makes sure that the appropriate property disables anonymous authentication.
     * 
     * @throws Exception
     */
    public void testAuthenticateUserDoesNotAuthenticateAnonymousWhenDisabled() throws Exception {
        Dictionary<Object, Object> configProperties = getBasicConfigProperties();
        LDAPAuthDictionary.setAnonymousAccessEnabled(configProperties, Boolean.FALSE);
        LdapAuthenticationProvider authProvider = new LdapAuthenticationProvider(configProperties);
        authProvider.start();

        IOperationContext context = new BaseOperationContext("AuthenticateUser-AnonymousTest", "123456", sysadminPrincipal);

        // We expect an exception mainly because it will have to go to LDAP if anonymous authentication is disabled
        // and we haven't configured an LDAP server in this test.
        boolean expectedExceptionCaught = false;
        AnzoPrincipal principal = null;
        try {
            principal = authProvider.authenticateUser(context, Constants.DEFAULT_ANONYMOUS_USER, "123");
        } catch (AnzoException e) {
            expectedExceptionCaught = true;
        }
        assertTrue(expectedExceptionCaught);
        assertNull(principal);
    }

    /**
     * Makes sure that anonymous users are allowed through when anonymous authentication is enabled.
     * 
     * @throws Exception
     */
    public void testAuthenticateUserAuthenticatesAnonymousWhenEnabled() throws Exception {
        Dictionary<Object, Object> configProperties = getBasicConfigProperties();
        LDAPAuthDictionary.setAnonymousAccessEnabled(configProperties, Boolean.TRUE);
        LdapAuthenticationProvider authProvider = new LdapAuthenticationProvider(configProperties);
        authProvider.start();

        IOperationContext context = new BaseOperationContext("AuthenticateUser-AnonymousTest", "123457", sysadminPrincipal);
        AnzoPrincipal principal = authProvider.authenticateUser(context, Constants.DEFAULT_ANONYMOUS_USER, "123");
        assertNotNull(principal);
        assertFalse(principal.isSysadmin());
        assertTrue(principal.isAnonymous());
        assertEquals(Constants.DEFAULT_ANONYMOUS, principal.getUserURI());
        assertEquals(Constants.DEFAULT_ANONYMOUS_USER, principal.getName());
        assertEquals(expectedAnonymousRoles, principal.getRoles());

        // Try again with a different password to prove that the password is irrelevant for anonymous users
        context = new BaseOperationContext("AuthenticateUser-AnonymousTest", "123457", sysadminPrincipal);
        principal = authProvider.authenticateUser(context, Constants.DEFAULT_ANONYMOUS_USER, "whatever10832");
        assertNotNull(principal);
        assertFalse(principal.isSysadmin());
        assertTrue(principal.isAnonymous());
        assertEquals(Constants.DEFAULT_ANONYMOUS, principal.getUserURI());
        assertEquals(Constants.DEFAULT_ANONYMOUS_USER, principal.getName());
        assertEquals(expectedAnonymousRoles, principal.getRoles());
    }

    /**
     * Test that the system doesn't consider the anonymous user to exist if anonymous access is disabled. This tests that behavior as the default.
     * 
     * @throws Exception
     */
    public void testGetUserPrincipalIgnoresAnonymousByDefault() throws Exception {
        Dictionary<Object, Object> configProperties = getBasicConfigProperties();
        LdapAuthenticationProvider authProvider = new LdapAuthenticationProvider(configProperties);
        authProvider.start();

        IOperationContext context = new BaseOperationContext("GetUserPrincipal-AnonymousTest", "1234572", sysadminPrincipal);

        // We expect an exception mainly because it will have to go to LDAP if anonymous authentication is disabled
        // and we haven't configured an LDAP server in this test.
        boolean expectedExceptionCaught = false;
        AnzoPrincipal principal = null;
        try {
            principal = authProvider.getUserPrincipal(context, Constants.DEFAULT_ANONYMOUS_USER);
        } catch (AnzoException e) {
            expectedExceptionCaught = true;
        }
        assertTrue(expectedExceptionCaught);
        assertNull(principal);
    }

    /**
     * Test that the system doesn't consider the anonymous user to exist if anonymous access is disabled.
     * 
     * @throws Exception
     */
    public void testGetUserPrincipalIgnoresAnonymousWhenDisabled() throws Exception {
        Dictionary<Object, Object> configProperties = getBasicConfigProperties();
        LDAPAuthDictionary.setAnonymousAccessEnabled(configProperties, Boolean.FALSE);
        LdapAuthenticationProvider authProvider = new LdapAuthenticationProvider(configProperties);
        authProvider.start();

        IOperationContext context = new BaseOperationContext("GetUserPrincipal-AnonymousTest", "1234571", sysadminPrincipal);

        // We expect an exception mainly because it will have to go to LDAP if anonymous authentication is disabled
        // and we haven't configured an LDAP server in this test.
        boolean expectedExceptionCaught = false;
        AnzoPrincipal principal = null;
        try {
            principal = authProvider.getUserPrincipal(context, Constants.DEFAULT_ANONYMOUS_USER);
        } catch (AnzoException e) {
            expectedExceptionCaught = true;
        }
        assertTrue(expectedExceptionCaught);
        assertNull(principal);
    }

    /**
     * Makes sure that anonymous users are allowed through when anonymous authentication is enabled.
     * 
     * @throws Exception
     */
    public void testGetUserPrincipalReturnsAnonymousWhenEnabled() throws Exception {
        Dictionary<Object, Object> configProperties = getBasicConfigProperties();
        LDAPAuthDictionary.setAnonymousAccessEnabled(configProperties, Boolean.TRUE);
        LdapAuthenticationProvider authProvider = new LdapAuthenticationProvider(configProperties);
        authProvider.start();

        IOperationContext context = new BaseOperationContext("GetUserPrincipal-AnonymousTest", "1234574", sysadminPrincipal);
        AnzoPrincipal principal = authProvider.getUserPrincipal(context, Constants.DEFAULT_ANONYMOUS_USER);
        assertNotNull(principal);
        assertFalse(principal.isSysadmin());
        assertTrue(principal.isAnonymous());
        assertEquals(Constants.DEFAULT_ANONYMOUS, principal.getUserURI());
        assertEquals(Constants.DEFAULT_ANONYMOUS_USER, principal.getName());
        assertEquals(expectedAnonymousRoles, principal.getRoles());
    }

}
