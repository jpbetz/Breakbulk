/*******************************************************************************
 * Copyright (c) 2010 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.test;

import java.util.Properties;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.openanzo.rdf.utils.Pair;
import org.openanzo.services.EncryptedTokenAuthenticatorConstants;
import org.openanzo.services.ServicesProperties;
import org.openanzo.servlet.control.ControlServlet;

/**
 * Tests for the EncryptedTokenAuthorization class which test whether the class properly protects servlets.
 * 
 * This class was built to test the situation found in ticket http://www.openanzo.org/projects/openanzo/ticket/852 in which a request to authenticate was
 * handled by both the authenticator and the servlet when it should have only been handled by the authenticator.
 * 
 * Many of these tests depend on the 'ControlServlet' being setup and responding to commands to increment and read a counter that the servlet keeps internally.
 * 
 * @author Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 */
public class TestEncryptedTokenAuthorizationBlocksServletAccess extends AbstractTest {

    private static final String PROTECTED_URI_PATH = "protected/";

    private String getControlServletURI() {
        String port = getProperties().getProperty("http.port");
        String uri = "http://localhost:" + port + "/control/";
        return uri;
    }

    private Pair<String, String> getDefaultUserAndPassword() throws Exception {
        Properties properties = getProperties();
        String user = ServicesProperties.getUser(properties, "default");
        String password = ServicesProperties.getPassword(properties, "123");
        Pair<String, String> info = new Pair<String, String>(user, password);
        return info;
    }

    private void resetServletCounter() throws Exception {
        HttpClient client = new HttpClient();
        String uri = getControlServletURI() + ControlServlet.OPERATION_URI_SUFFIX_COUNTER_RESET;
        GetMethod request = new GetMethod(uri);
        request.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        client.executeMethod(request);
        int statusCode = request.getStatusCode();
        assertEquals("Invalid status code. Status text: " + request.getStatusText(), HttpStatus.SC_OK, statusCode);
        assertEquals("0", request.getResponseBodyAsString());
    }

    /**
     * Make sure that the ControlServlet's incrementing counter functionality works properly since most of the other tests depend on it.
     * 
     * @throws Exception
     */
    public void testControlServletIncrementsCounter() throws Exception {
        resetServletCounter();

        // Try to tell the servlet to increment the counter (via an unprotected path)
        HttpClient client = new HttpClient();
        GetMethod request = new GetMethod(getControlServletURI() + "increment_the_counter");
        request.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        client.executeMethod(request);
        int statusCode = request.getStatusCode();
        assertEquals("Invalid status code. Status text: " + request.getStatusText(), HttpStatus.SC_OK, statusCode);
        assertEquals("1", request.getResponseBodyAsString());

        // Increment again
        client = new HttpClient();
        request = new GetMethod(getControlServletURI() + "increment_it_again");
        request.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        client.executeMethod(request);
        statusCode = request.getStatusCode();
        assertEquals("Invalid status code. Status text: " + request.getStatusText(), HttpStatus.SC_OK, statusCode);
        assertEquals("2", request.getResponseBodyAsString());
    }

    /**
     * Trying to access a protected path without proper authentication should prevent access to the servlet.
     * 
     * @throws Exception
     */
    public void testUnauthenticatedProtectedPathAccessDoesNotReachServlet() throws Exception {
        resetServletCounter();

        // Try to tell the servlet to increment the counter via a path that is protected by authentication.
        // This should fail via an authentication error.
        HttpClient client = new HttpClient();
        GetMethod request = new GetMethod(getControlServletURI() + PROTECTED_URI_PATH + "increment_the_counter");
        request.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        client.executeMethod(request);
        int statusCode = request.getStatusCode();
        assertEquals("Invalid status code. Status text: " + request.getStatusText(), HttpStatus.SC_FORBIDDEN, statusCode);

        // Get the value of the counter (via a non-protected path) to make sure it stayed at zero.
        request = new GetMethod(getControlServletURI() + ControlServlet.OPERATION_URI_SUFFIX_COUNTER_READ);
        request.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        client.executeMethod(request);
        statusCode = request.getStatusCode();
        assertEquals("Invalid status code. Status text: " + request.getStatusText(), HttpStatus.SC_OK, statusCode);
        assertEquals("0", request.getResponseBodyAsString());
    }

    /**
     * An authenticate request should not invoke the protected servlet. It should be handled only by the authenticator in both successful and invalid
     * authentication cases.
     * 
     * @throws Exception
     */
    public void testSuccessfulAuthenticateRequestDoesNotReachServlet() throws Exception {
        resetServletCounter();

        Pair<String, String> userInfo = getDefaultUserAndPassword();

        // Send a authentication request that we expect to succeed.
        HttpClient client = new HttpClient();
        PostMethod authpost = new PostMethod(getControlServletURI() + EncryptedTokenAuthenticatorConstants.LOGIN_URI_SUFFIX);
        NameValuePair formUserid = new NameValuePair(EncryptedTokenAuthenticatorConstants.USERNAME_PARAMETER_NAME, userInfo.first);
        NameValuePair formPassword = new NameValuePair(EncryptedTokenAuthenticatorConstants.PASSWORD_PARAMETER_NAME, userInfo.second);
        authpost.setRequestBody(new NameValuePair[] { formUserid, formPassword });
        authpost.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        authpost.setDoAuthentication(false);
        client.executeMethod(authpost);
        int statusCode = authpost.getStatusCode();
        assertEquals("Invalid status code. Status text: " + authpost.getStatusText(), HttpStatus.SC_OK, statusCode);
        authpost.releaseConnection();
        Cookie[] logoncookies = client.getState().getCookies();
        boolean authenticated = false;
        for (int i = 0; i < logoncookies.length; i++) {
            if (logoncookies[i].getName().equals(EncryptedTokenAuthenticatorConstants.ANZO_TOKEN_COOKIE_NAME))
                authenticated = true;
        }
        assertTrue("Expect a successful authentication.", authenticated);

        // Get the value of the counter (via a non-protected path) to make sure it stayed at zero, which would indicate the
        // servlet wasn't touched by the authenticate request.
        GetMethod request = new GetMethod(getControlServletURI() + ControlServlet.OPERATION_URI_SUFFIX_COUNTER_READ);
        request.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        client.executeMethod(request);
        statusCode = request.getStatusCode();
        assertEquals("Invalid status code. Status text: " + request.getStatusText(), HttpStatus.SC_OK, statusCode);
        assertEquals("0", request.getResponseBodyAsString());
    }

    /**
     * An authenticate request should not invoke the protected servlet. It should be handled only by the authenticator in both successful and invalid
     * authentication cases.
     * 
     * @throws Exception
     */
    public void testFailedAuthenticateRequestDoesNotReachServlet() throws Exception {
        resetServletCounter();

        Pair<String, String> userInfo = getDefaultUserAndPassword();

        // Send a authentication request that we expect to fail.
        HttpClient client = new HttpClient();
        PostMethod authpost = new PostMethod(getControlServletURI() + EncryptedTokenAuthenticatorConstants.LOGIN_URI_SUFFIX);
        NameValuePair formUserid = new NameValuePair(EncryptedTokenAuthenticatorConstants.USERNAME_PARAMETER_NAME, userInfo.first);
        NameValuePair formPassword = new NameValuePair(EncryptedTokenAuthenticatorConstants.PASSWORD_PARAMETER_NAME, "anIncorrectPassword");
        authpost.setRequestBody(new NameValuePair[] { formUserid, formPassword });
        authpost.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        authpost.setDoAuthentication(false);
        client.executeMethod(authpost);
        int statusCode = authpost.getStatusCode();
        assertEquals("Invalid status code. Status text: " + authpost.getStatusText(), HttpStatus.SC_FORBIDDEN, statusCode);
        authpost.releaseConnection();
        Cookie[] logoncookies = client.getState().getCookies();
        boolean authenticated = false;
        for (int i = 0; i < logoncookies.length; i++) {
            if (logoncookies[i].getName().equals(EncryptedTokenAuthenticatorConstants.ANZO_TOKEN_COOKIE_NAME))
                authenticated = true;
        }
        assertFalse("Expect a failed authentication.", authenticated);

        // Get the value of the counter (via a non-protected path) to make sure it stayed at zero, which would indicate the
        // servlet wasn't touched by the authenticate request.
        GetMethod request = new GetMethod(getControlServletURI() + ControlServlet.OPERATION_URI_SUFFIX_COUNTER_READ);
        request.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        client.executeMethod(request);
        statusCode = request.getStatusCode();
        assertEquals("Invalid status code. Status text: " + request.getStatusText(), HttpStatus.SC_OK, statusCode);
        assertEquals("0", request.getResponseBodyAsString());
    }

}
