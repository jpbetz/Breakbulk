/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model.indexer.lucene/src/com/ibm/adtech/boca/model/indexer/lucene/ModelIndexQuery.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: ModelIndexQuery.java 161 2007-07-31 14:11:06Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.indexer;

import java.util.Calendar;

import junit.framework.TestCase;

import org.openanzo.indexer.IndexerException;
import org.openanzo.indexer.lucene.LuceneConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Adds a date filter to the query.
 * 
 * This stuff should be in another class since it's not indexer-specific.
 * 
 * A date range should be specified as part of the query string. It will have the following format:
 * 
 * http://openanzo.orgified:<i>date_expression</i>
 * 
 * The date expression defines a date range determined by two time expressions.
 * 
 * Time expressions can assume one of four forms: 1) a string containing the number of ms that have elapsed since January 1, 1970, 2) * for before/after
 * expressions (see below), 3) a relative time expression, or 4) an absolute time expression.
 * 
 * Relative time expressions begin with y (year), mo (month), d (date), * h (hour) or mi (minute). The next character in a relative time expression is '-' (can
 * be interpreted as minus). mo-2 means two months ago, h-4 means four hours ago, etc.
 * 
 * Absolute time expressions also begin with y, mo, d, h, or mi. The numbers following specify the exact time, with 4 chars for the year and two for each
 * subsequent time unit. mo200404 means April 2004, mi200505051921 means 7:21pm on May 5, 2005.
 * 
 * An absolute time may be passed in alone as a time range. The implied time range goes from the specified time to one time unit beyond the specified time. so
 * modified:mo200506 encapsulates all of June 2005, modified:d20050621 encapsulates all of June 21, 2005.
 * 
 * Ranges are of the form <i>start_char</i> <i>time_expr_1</i> to <i>time_expr_2</i> <i>end_char</i>. start_char is '[' or '{'. end_char is ']' or '}'. [ and ]
 * include the dates that they are adjacent to, and { and } exclude the dates that they are adjacent to. Note that in the case where both time expressions are
 * relative time expressions, the start_char and end_char must be present but they will be ignored. For relative time expressions, the implied
 * inclusion/exclusion is as follows:
 * 
 * [time_expr_1 to time_expr_2}
 * 
 * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 */
public class TestModelIndexQuery extends TestCase {
    private static final Logger log = LoggerFactory.getLogger(TestModelIndexQuery.class);

    /**
     * Tests date parsing
     * 
     * @throws Exception
     */
    public void testIndexDateParsing() throws Exception {
        // Last month (mo), week (w), day (d), hour (h), minute (mi)
        // y2005 - 2005
        // y-0 - this year
        // y-1 - last year

        String[] timeExpressions = { "d-2", "y2004", "h-2", "m200507", "mo2005", "mo200507", "mi200507122304", "d20050712", "mo200507122304", "mo20050", "h-", "h", };
        for (int i = 0; i < timeExpressions.length; i++) {
            long time;
            try {
                String currTime = timeExpressions[i];
                time = ModelIndexQuery.parseTimeExpression(timeExpressions[i]);
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(time);
                log.debug(currTime + ": ");
                printReadableCal(cal);
            } catch (IndexerException e) {
                log.debug(timeExpressions[i] + ": invalid");
            }
        }
        String[] timeSpans = { LuceneConstants.INDEXER_FIELD_MODIFIED + ":y2004", LuceneConstants.INDEXER_FIELD_MODIFIED + ":y2003", LuceneConstants.INDEXER_FIELD_MODIFIED + ":[mo200404 to mo200407]", LuceneConstants.INDEXER_FIELD_MODIFIED + ":[mo-5 to mo-3]", LuceneConstants.INDEXER_FIELD_MODIFIED + ":{mo-5 to mo-3}", LuceneConstants.INDEXER_FIELD_MODIFIED + ":{mo200404 to mo200407}", LuceneConstants.INDEXER_FIELD_MODIFIED + ":{mo200404 to mo200407}",
                LuceneConstants.INDEXER_FIELD_MODIFIED + ":{mo200404 to mo200407]", LuceneConstants.INDEXER_FIELD_MODIFIED + ":[mo200404 to mo200407}", "blah " + LuceneConstants.INDEXER_FIELD_MODIFIED + ":y2003", LuceneConstants.INDEXER_FIELD_MODIFIED + ":h-1", LuceneConstants.INDEXER_FIELD_MODIFIED + ":h-5", LuceneConstants.INDEXER_FIELD_MODIFIED + ":h-30", LuceneConstants.INDEXER_FIELD_MODIFIED + ":mo-24", LuceneConstants.INDEXER_FIELD_MODIFIED + ":[h-5 to *]",
                LuceneConstants.INDEXER_FIELD_MODIFIED + ":[* to h-5]", LuceneConstants.INDEXER_FIELD_MODIFIED + ":[h-5 to h-3}", LuceneConstants.INDEXER_FIELD_MODIFIED + ":{h-5 to h-3}", LuceneConstants.INDEXER_FIELD_MODIFIED + ":{mo200606 to mo200608}", };
        for (int i = 0; i < timeSpans.length; i++) {
            String currentSpan = timeSpans[i];
            long[] range = new long[2];
            try {
                String queryStr = ModelIndexQuery.parseModifiedOut(currentSpan, range);
                log.debug("query: " + currentSpan);
                log.debug("leftover: " + queryStr);
                log.debug("range:");
                Calendar cal1 = Calendar.getInstance();
                cal1.setTimeInMillis(range[0]);
                Calendar cal2 = Calendar.getInstance();
                cal2.setTimeInMillis(range[1]);
                printReadableCal(cal1);
                printReadableCal(cal2);
            } catch (IndexerException e) {
            }
        }
    }

    static void printReadableCal(Calendar cal) {
        log.debug(cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE) + "/" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE));
    }
}
