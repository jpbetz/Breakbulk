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
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.PerFieldAnalyzerWrapper;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.DateTools;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermRangeFilter;
import org.apache.lucene.util.Version;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.indexer.IndexerException;
import org.openanzo.indexer.lucene.LuceneConstants;
import org.openanzo.indexer.lucene.LuceneQuery;
import org.openanzo.rdf.Constants.INDEXER;

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
public class ModelIndexQuery extends LuceneQuery {

    //private static final Logger log           = LoggerFactory.getLogger(ModelIndexQuery.class);

    private static final String PREFIX_YEAR   = "y";

    private static final String PREFIX_MONTH  = "mo";

    private static final String PREFIX_WEEK   = "w";

    private static final String PREFIX_DAY    = "d";

    private static final String PREFIX_HOUR   = "h";

    private static final String PREFIX_MINUTE = "mi";

    /**
     * Create a new ModelIndexQuery
     */
    public ModelIndexQuery() {
        super();
        analyzer = new PerFieldAnalyzerWrapper(new StandardAnalyzer(Version.LUCENE_30));
        ((PerFieldAnalyzerWrapper) analyzer).addAnalyzer(INDEXER.INDEXER_FIELD_PREDICATE, new WhitespaceAnalyzer());
        ((PerFieldAnalyzerWrapper) analyzer).addAnalyzer(INDEXER.INDEXER_FIELD_SUBJECT, new WhitespaceAnalyzer());
        ((PerFieldAnalyzerWrapper) analyzer).addAnalyzer(INDEXER.INDEXER_FIELD_GRAPH_URI, new WhitespaceAnalyzer());
        ((PerFieldAnalyzerWrapper) analyzer).addAnalyzer(LuceneConstants.INDEXER_FIELD_CREATED_BY, new WhitespaceAnalyzer());
    }

    @Override
    public void initialize(String defaultField, String queryStr) throws IndexerException {
        super.initialize(defaultField, queryStr);
    }

    @Override
    public void initialize(String defaultField, String queryStr, Collection<Query> terms) throws IndexerException {
        super.initialize(defaultField, queryStr, terms);
    }

    @Override
    public void initialize(String queryStr) throws IndexerException {
        long[] range = new long[2];
        String newQueryStr;
        newQueryStr = parseModifiedOut(queryStr, range);
        if (!newQueryStr.equals(queryStr)) {
            if (range[0] != -1 && range[1] != -1) {
                filter = new TermRangeFilter(LuceneConstants.INDEXER_FIELD_MODIFIED, DateTools.timeToString(range[0], DateTools.Resolution.MILLISECOND), DateTools.timeToString(range[1], DateTools.Resolution.MILLISECOND), true, true);
            } else if (range[0] == -1) {
                filter = new TermRangeFilter(LuceneConstants.INDEXER_FIELD_MODIFIED, DateTools.timeToString(0, DateTools.Resolution.MILLISECOND), DateTools.timeToString(range[1], DateTools.Resolution.MILLISECOND), true, true);
            } else if (range[1] == -1) {
                filter = new TermRangeFilter(LuceneConstants.INDEXER_FIELD_MODIFIED, DateTools.timeToString(range[0], DateTools.Resolution.MILLISECOND), DateTools.timeToString(Integer.MAX_VALUE, DateTools.Resolution.MILLISECOND), false, false);
            } else {
                // No range found...
                // Probably some sort of error, because the query was changed - may lead to 
                // unexpected behavior. For now, change it back to the original query.
                newQueryStr = queryStr;
            }
        }
        super.initialize(newQueryStr);
    }

    /*
     * Modified string: 
     *  modified:xxx
     *  modified:[xxx TO yyy]
     *  modified:[xxx to yyy]
     */
    static String parseModifiedOut(String queryStr, long[] newRange) throws IndexerException {
        Pattern modRangePattern = Pattern.compile(LuceneConstants.INDEXER_FIELD_MODIFIED + ":(\\[|\\{)(\\S+) to ([^]]+)(\\]|\\})");
        Matcher matcher = modRangePattern.matcher(queryStr);
        if (matcher.find()) {
            String opener = matcher.group(1);
            String closer = matcher.group(4);
            boolean beginIsInclusive = opener.equals("[");
            boolean endIsInclusive = closer.equals("]");
            long time1 = parseTimeExpression(matcher.group(2), true, true, beginIsInclusive, null);
            long time2 = parseTimeExpression(matcher.group(3), true, false, endIsInclusive, null);
            newRange[0] = time1;
            newRange[1] = time2;
            int startIndex = matcher.start();
            int endIndex = matcher.group(0).length() + startIndex;
            String retStr = queryStr.substring(0, startIndex).trim() + " " + queryStr.substring(endIndex).trim();
            retStr = retStr.trim();
            return retStr;
        }
        Pattern singlePattern = Pattern.compile(LuceneConstants.INDEXER_FIELD_MODIFIED + ":(\\S+)");
        matcher = singlePattern.matcher(queryStr);
        if (matcher.find()) {
            String timeStr = matcher.group(1);
            long[] range = new long[2];
            long time1 = parseTimeExpression(timeStr, false, false, false, range);
            long time2 = range[1];
            if (newRange != null && newRange.length == 2) {
                newRange[0] = time1;
                newRange[1] = time2;
            }
            int startIndex = matcher.start();
            int endIndex = matcher.group(0).length() + startIndex;
            String retStr = queryStr.substring(0, startIndex).trim() + " " + queryStr.substring(endIndex).trim();
            retStr = retStr.trim();
            return retStr;
        }
        return queryStr;
    }

    static long parseTimeExpression(String timeExpression) throws IndexerException {
        return parseTimeExpression(timeExpression, false, false, false, null);
    }

    /**
     * Parses the given time expression.
     * 
     * @param timeExpression
     * @param isRange
     *            - true if this time expression is part of a range (xxx to yyy)
     * @param isBegin
     *            - true if this time expression is the beginning marker, false if it is the ending marker. Only considered if isRange == true
     * @param isInclusive
     *            - true if this time expression is inclusive (it is adjacent to a '[' or ']'), false if it is adjacent to a '{' or '}'. Only considered if
     *            isRange == true.
     * @param range
     *            - this gets filled in by the method, if there is some reasonable interpretation of the time as a range. For example, y2004 could be
     *            interpreted as 1/1/2004 - 1/1/2005
     * @return
     * @throws IndexerException
     */
    private static long parseTimeExpression(String timeExpression, boolean isRange, boolean isBegin, boolean isInclusive, long range[]) throws IndexerException {
        long retval = -1;
        if (timeExpression.equals("*")) {
            return -1;
        }
        //RE re = new RE("(\\w+)((\\d\\d\\d\\d)(\\d\\d)?(\\d\\d)?(\\d\\d)?(\\d\\d)?|-(\\d+))");
        long now = System.currentTimeMillis();
        try {
            // If it's a plain long, just parse it.
            long time = Long.parseLong(timeExpression);
            if (time <= 0) {
                retval = now + time;
            } else {
                retval = time;
            }
        } catch (NumberFormatException nfe) {
            try {
                int year = 0;
                int month = 0;
                int day = 1;
                int hour = 0;
                int minute = 0;
                int endyear = 0;
                int endmonth = 0;
                int endday = 1;
                int endhour = 0;
                int endminute = 0;
                Pattern relativePattern = Pattern.compile("([a-z]+)-(\\d+)");
                Matcher match = relativePattern.matcher(timeExpression);
                String type = null;
                long nummsInInterval = 0;
                if (match.find()) {
                    Calendar cal = Calendar.getInstance();
                    year = endyear = cal.get(Calendar.YEAR);
                    month = endmonth = cal.get(Calendar.MONTH);
                    day = endday = cal.get(Calendar.DATE);
                    hour = endhour = cal.get(Calendar.HOUR_OF_DAY);
                    minute = endminute = cal.get(Calendar.MINUTE);
                    type = match.group(1);
                    int length = Integer.parseInt(match.group(2));
                    retval = now - length * nummsInInterval;
                    if (type.equals(PREFIX_YEAR)) {
                        endyear = (year -= length);
                        endyear++;
                    } else if (type.equals(PREFIX_MONTH)) {
                        endmonth = (month -= length);
                        endmonth++;
                    } else if (type.equals(PREFIX_WEEK)) {
                        endday = (day -= 7 * length);
                        endday += 7;
                    } else if (type.equals(PREFIX_DAY)) {
                        endday = (day -= length);
                        endday++;
                    } else if (type.equals(PREFIX_HOUR)) {
                        endhour = (hour -= length);
                        endhour++;
                    } else if (type.equals(PREFIX_MINUTE)) {
                        endminute = (minute -= length);
                        endminute++;
                    } else {
                        throw new IndexerException(ExceptionConstants.INDEX.INVALID_TIME_SPECIFIER, nfe, type);
                    }
                    if (isRange) {
                        cal = Calendar.getInstance();
                        /* Not sure if this makes sense for relative times. 
                         * When you say h-3 to h-1, it's not ambiguous (it means three hours before to one hour before),
                         * covering a time period of two hours. The range is an implicit
                         * [h-3 to h-1}
                         * 
                         * However, when you say h2005093011 to h2005093013 it's not entirely clear whether
                         * it is inclusive (covering a time period of three hours) or exclusive (covering
                         * a time period of two hours). This ambiguity can be resolved with []'s (inclusive) and 
                         * {}'s (exclusive.
                         * 
                         * Unfortunately, [h-3 to h-2] would mean "after three hours ago and before and including the hour
                         * that started two hours ago." This is somewhat confusing. 
                         * 
                         */
                        /*
                        if ((isBegin && ! isInclusive)
                                || (! isBegin && isInclusive)){
                            cal.set(endyear, endmonth, endday, endhour, endminute);
                        } else {
                            cal.set(year, month, day, hour, minute);
                        }
                        */
                        cal.set(year, month, day, hour, minute);
                        retval = cal.getTimeInMillis();
                    } else {
                        Calendar start = Calendar.getInstance();
                        start.set(year, month, day, hour, minute);
                        Calendar end = Calendar.getInstance();
                        end.set(endyear, endmonth, endday, endhour, endminute);
                        if (range != null && range.length == 2) {
                            range[0] = start.getTimeInMillis();
                            range[1] = end.getTimeInMillis();
                        }
                        retval = start.getTimeInMillis();
                    }
                    return retval;
                }
                Pattern absolutePattern = Pattern.compile("([a-z]+)(\\d\\d\\d\\d)(\\d\\d)?(\\d\\d)?(\\d\\d)?(\\d\\d)?");
                match = absolutePattern.matcher(timeExpression);
                if (match.find()) {
                    type = match.group(1);
                    if (type.equals(PREFIX_YEAR)) {
                        year = Integer.parseInt(match.group(2));
                        endyear = year + 1;
                    } else if (type.equals(PREFIX_MONTH)) {
                        year = Integer.parseInt(match.group(2));
                        month = Integer.parseInt(match.group(3));
                        endyear = year;
                        endmonth = month + 1;
                    } else if (type.equals(PREFIX_WEEK)) {
                        throw new IndexerException(ExceptionConstants.INDEX.INVALID_TIME_SPECIFIER, nfe, type);
                    } else if (type.equals(PREFIX_DAY)) {
                        year = Integer.parseInt(match.group(2));
                        month = Integer.parseInt(match.group(3));
                        day = Integer.parseInt(match.group(4));
                        endyear = year;
                        endmonth = month;
                        endday = day + 1;
                    } else if (type.equals(PREFIX_HOUR)) {
                        year = Integer.parseInt(match.group(2));
                        month = Integer.parseInt(match.group(3));
                        day = Integer.parseInt(match.group(4));
                        hour = Integer.parseInt(match.group(5));
                        endyear = year;
                        endmonth = month;
                        endday = day;
                        endhour = hour + 1;
                    } else if (type.equals(PREFIX_MINUTE)) {
                        year = Integer.parseInt(match.group(2));
                        month = Integer.parseInt(match.group(3));
                        day = Integer.parseInt(match.group(4));
                        hour = Integer.parseInt(match.group(5));
                        minute = Integer.parseInt(match.group(6));
                        endyear = year;
                        endmonth = month;
                        endday = day;
                        endhour = hour;
                        endminute = minute + 1;
                    } else {
                        throw new IndexerException(ExceptionConstants.INDEX.INVALID_TIME_SPECIFIER, nfe, type);
                    }
                } else {
                    throw new IndexerException(ExceptionConstants.INDEX.INVALID_TIME_SPECIFIER, nfe, timeExpression);
                }
                if (month > 0)
                    month -= 1;
                if (endmonth > 0)
                    endmonth -= 1;
                // If it's not a range, it's possible that it is an implicit range - 
                // For example, if "y2004" was specified, this implies the range
                // from 1/1/2004 to 1/1/2005.
                if (!isRange) {
                    Calendar cal = Calendar.getInstance();
                    // Calendar month is 0-indexed.
                    cal.set(year, month, day, hour, minute);
                    retval = cal.getTimeInMillis();
                    if (range != null && range.length == 2) {
                        range[0] = retval;
                        cal.set(endyear, endmonth, endday, endhour, endminute);
                        range[1] = cal.getTimeInMillis();
                    }
                } else {
                    Calendar cal = Calendar.getInstance();
                    // By default, isBegin and isInclusive is handled correctly,
                    // as is ! isBegin and ! isInclusive. 
                    // In the other cases, use the end of the implied interval.
                    if ((isBegin && !isInclusive) || (!isBegin && isInclusive)) {
                        cal.set(endyear, endmonth, endday, endhour, endminute);
                    } else {
                        cal.set(year, month, day, hour, minute);
                    }
                    retval = cal.getTimeInMillis();
                }
            } catch (NumberFormatException nfe2) {
                // Date wasn't formatted correctly.
                throw new IndexerException(ExceptionConstants.INDEX.INVALID_MODIFIED_TIME, nfe2, timeExpression);
            } catch (StringIndexOutOfBoundsException oe) {
                throw new IndexerException(ExceptionConstants.INDEX.INVALID_MODIFIED_TIME, oe, timeExpression);
            }
        }
        return retval;
    }
}
