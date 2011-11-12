/******************************************************************************* 
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *******************************************************************************/
package org.openanzo.test.js;

import org.openanzo.servlet.EncryptedTokenAuthenticator;

/**
 * Tests login and protection behavior of the EncryptedTokenAuthentication schema as described at
 * http://www.openanzo.org/projects/openanzo/wiki/AnzoJsSessionKeyAuthenticationDesign
 * 
 * @author Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 */
public class TestEncryptedTokenAuthenticationRegression extends SeleniumTestCase {

    /**
     * Test login redirects
     * 
     * @throws Exception
     */
    public void testLoginRedirects() throws Exception {

        // test unauthenticated request redirects to login page
        selenium.deleteCookie(EncryptedTokenAuthenticator.ANZO_TOKEN_COOKIE_NAME, "/");
        selenium.open("/private/"); // access the protected data from docroot-private
        assertEquals("Login to OpenAnzo 3.1.0 Private Resources", selenium.getTitle());

        // test invalid login credentials redirects to error page
        selenium.deleteCookie(EncryptedTokenAuthenticator.ANZO_TOKEN_COOKIE_NAME, "/");
        selenium.open("/private/login.html");
        assertEquals("Login to OpenAnzo 3.1.0 Private Resources", selenium.getTitle());
        selenium.type("anzo_username", "invalidUser");
        selenium.type("anzo_password", "theWrongPassw0rd");
        selenium.click("Login");
        selenium.waitForPageToLoad("5000");
        assertEquals("Invalid Login Credentials for OpenAnzo 3.1.0 Private Resources", selenium.getTitle());

        // test login grants access to protected resources
        selenium.deleteCookie(EncryptedTokenAuthenticator.ANZO_TOKEN_COOKIE_NAME, "/");
        selenium.open("/private/index.html");
        assertEquals("Login to OpenAnzo 3.1.0 Private Resources", selenium.getTitle());
        selenium.type("anzo_username", "default");
        selenium.type("anzo_password", "123");
        selenium.click("Login");
        selenium.waitForPageToLoad("5000");
        assertEquals("Anzo 3.0 Private Resources", selenium.getTitle());

        // Test unauthenticated request redirects to login page and user
        // is redirected to their initially desired page after submitting credentials.
        selenium.deleteCookie(EncryptedTokenAuthenticator.ANZO_TOKEN_COOKIE_NAME, "/");
        selenium.open("/private/protectedContent.html"); // access the protected data from docroot-private
        assertEquals("Login to OpenAnzo 3.1.0 Private Resources", selenium.getTitle());
        selenium.type("anzo_username", "default");
        selenium.type("anzo_password", "123");
        selenium.click("Login");
        selenium.waitForPageToLoad("5000");
        assertEquals("Sample Anzo 3.0 Protected Content", selenium.getTitle());
    }
}
