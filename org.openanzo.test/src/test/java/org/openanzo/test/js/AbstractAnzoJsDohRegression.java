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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This test runs against a remote controlled browser using Selenium Remote Control. The test runs all of the Anzo.JS JavaScript unit tests against a running
 * Anzo server.
 * 
 * @author Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 */
public class AbstractAnzoJsDohRegression extends SeleniumTestCase {

    private static final Logger log = LoggerFactory.getLogger(AbstractAnzoJsDohRegression.class);

    protected void runTest(String testUrl) throws Exception {
        selenium.open(testUrl);

        try {
            TestUtilities.waitFor(8000, new Condition() {
                @Override
                public boolean check() {
                    return "The Dojo Unit Test Harness, $Rev: 20149 $".equals(selenium.getTitle());
                }
            });
        } catch (TimeoutException e) {
            log.error("Timeout waiting for browser title. Current title is:" + selenium.getTitle());
            throw e;
        }

        try {
            TestUtilities.waitFor(300000, new Condition() {
                @Override
                public boolean check() {
                    return selenium.isElementPresent("id=test-completion-report");
                }
            });

            String errorCount = selenium.getText("id=test-completion-report-errors");
            String failureCount = selenium.getText("id=test-completion-report-failures");

            if (!"0".equals(errorCount) || !"0".equals(failureCount)) {
                throw new Exception("Failed Anzo.JS JavaScript Unit Tests:\n" + selenium.getText("id=test-failed-tests-report"));
            }

            assertEquals("0", errorCount);
            assertEquals("0", failureCount);
        } finally {
            // Log the output from the FirebugLite console if it exists. The FirebugLite console will have
            // all of the output sent to "console.xxx" methods or the anzo.log logs. This is mainly
            // useful when running in the build since the browser won't be there for inspection once the test finished.
            if (selenium.isElementPresent("id=firebugLog")) {
                log.info(selenium.getText("id=firebugLog"));
            } else {
                // If we can't find the FirebugLite console, then we'll settle for the output
                // in the D.O.H. logBody. That will only have output sent to the "doh.debug" method.
                // But if there isn't FirebugLite, then that means that the real Firebug is there so you can
                // use that to look at the console anyway.
                log.info(selenium.getText("id=logBody"));
            }
        }
    }
}
