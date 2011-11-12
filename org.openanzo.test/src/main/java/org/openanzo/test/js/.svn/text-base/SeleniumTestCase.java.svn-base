/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.openanzo.test.js;

import java.util.concurrent.TimeoutException;

import org.openanzo.rdf.utils.test.Condition;
import org.openanzo.rdf.utils.test.TestUtilities;
import org.openanzo.test.AbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.selenium.DefaultSelenium;

/**
 * Base class useful for writing tests that remote control a web browser. This uses the Selenium Remote Control system to remote control various browsers. The
 * base class will setup the connection to the remote control browser based on the appropriate environment ("regress" mode in the build or "development" mode
 * otherwise).
 * 
 * Create such tests by extending this class and writing test methods. Inside those methods, use the <code>selenium</code> member to remote control a browser.
 * 
 * When writing Selenium-based tests, the {@link org.openanzo.rdf.utils.test.TestUtilities#waitFor(Condition)} method is very useful.You might use that to wait
 * for an HTML element to exist, for example.
 * 
 * @author Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 */
public abstract class SeleniumTestCase extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(SeleniumTestCase.class);

    protected DefaultSelenium   selenium;

    /**
     * The port where the Selenium server is running. This is set based on the property for the regress test mode for the build or the development mode.
     */
    public static final int     seleniumServerPort;

    /** The URI of the running Anzo Server the Selenium tests will point. */
    public static final String  anzoServerBaseUri;

    /** True if you want to close the browser on teardown */
    public static final boolean closeBrowserOnTearDown;
    static {
        String env = System.getProperty(AbstractTest.TEST_ENVIRONMENT_PROPERTY);
        int httpPort = 80;
        if (env != null && env.equals(AbstractTest.REGRESSION)) {
            log.debug("SeleniumTestCase using config: " + AbstractTest.REGRESSION);
            seleniumServerPort = 9191;
            httpPort = 8082;
            closeBrowserOnTearDown = true;
        } else {
            log.debug("SeleniumTestCase using config: {}", "Regular");
            seleniumServerPort = 9190;
            httpPort = 8080;
            closeBrowserOnTearDown = false;
        }
        anzoServerBaseUri = "http://localhost:" + httpPort + "/";
    }

    /**
     * Basic test
     */
    public SeleniumTestCase() {
        super();
    }

    /**
     * Test with name
     * 
     * @param name
     *            name of test
     */
    public SeleniumTestCase(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        selenium = new DefaultSelenium("localhost", seleniumServerPort, "*chrome", anzoServerBaseUri);
        selenium.start();
    }

    @Override
    protected void tearDown() throws Exception {
        if (closeBrowserOnTearDown) {
            selenium.stop();
        }
        super.tearDown();
    }

    protected void assertAlert(String alertRegex) {
        assertTrue(selenium.getAlert().matches(alertRegex));
    }

    protected void waitForElementPresent(final String locator, String error_message) throws Exception {
        try {
            TestUtilities.waitFor(10000, new Condition() {
                @Override
                public boolean check() {
                    return selenium.isElementPresent(locator);
                }
            });
        } catch (TimeoutException e) {
            log.error("Timeout waiting for " + error_message);
            throw e;
        }
    }

    protected void waitForValueEquals(final String locator, final String not) throws Exception {
        try {
            TestUtilities.waitFor(10000, new Condition() {
                @Override
                public boolean check() {
                    return selenium.getValue(locator).equals(not);
                }
            });
        } catch (TimeoutException e) {
            log.error("Timeout waiting for text boxes to load");
            throw e;
        }
    }

    protected void contextMenu(String locator) {
        selenium.getEval("this.doContextMenuAt(\"" + locator + "\", \"0,0\");");
    }

    protected void contextMenuAt(String locator, String coords) {
        selenium.getEval("this.doContextMenuAt(\"" + locator + "\", \"" + coords + "\");");
    }

}
