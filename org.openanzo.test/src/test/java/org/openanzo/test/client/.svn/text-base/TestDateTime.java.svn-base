/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.test.client;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.time.DateUtils;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.vocabulary.XMLSchema;
import org.openanzo.test.AbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests for date and time information used within the system via the AnzoClient API, SPARQL queries, etc.
 * 
 * See http://www.openanzo.org/projects/openanzo/ticket/377
 * 
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 */
public class TestDateTime extends AbstractTest {

    private static final Logger log             = LoggerFactory.getLogger(TestDateTime.class);

    private static final URI    GRAPH_URI       = createTestUri("graph1");

    private int                 statementSuffix = 1;

    /**
     * The most basic of date/time handling tests. Here we make sure that we can add a date literal to the store and then retrieve it via find/contains and via
     * a SPARQL query. The data must not have been changed in any way through this round-trip. This tests works by creating the literals with their raw lexical
     * values. No special native Java type conversion is expected to be going on here.
     * 
     * @throws Exception
     */
    public void testLexicalDateTimeIsPreservedInServerRoundTrip() throws Exception {

        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);

            // xsd:dateTime
            // UTC
            addAndRetrieveLexicalLiteral(client, graph, "2008-07-11T16:48:32Z", XMLSchema.DATETIME);
            // With time zone offset
            addAndRetrieveLexicalLiteral(client, graph, "2008-07-12T16:48:32-04:00", XMLSchema.DATETIME);
            // Without time zone
            addAndRetrieveLexicalLiteral(client, graph, "2008-07-13T16:48:32", XMLSchema.DATETIME);
            // With fractional seconds
            addAndRetrieveLexicalLiteral(client, graph, "2008-07-15T16:48:32.25", XMLSchema.DATETIME);
            // With fractional seconds at the nanosecond precision
            addAndRetrieveLexicalLiteral(client, graph, "2008-07-15T16:48:32.254221458", XMLSchema.DATETIME);
            // With fractional seconds and time zone
            addAndRetrieveLexicalLiteral(client, graph, "2008-07-16T16:48:32.25-05:00", XMLSchema.DATETIME);

            // xsd:date
            // UTC
            addAndRetrieveLexicalLiteral(client, graph, "2008-07-11Z", XMLSchema.DATE);
            // With time zone offset
            addAndRetrieveLexicalLiteral(client, graph, "2008-07-12-04:00", XMLSchema.DATE);
            // Without time zone
            addAndRetrieveLexicalLiteral(client, graph, "2008-07-13", XMLSchema.DATE);

            // xsd:time
            // UTC
            addAndRetrieveLexicalLiteral(client, graph, "16:48:32Z", XMLSchema.TIME);
            // With time zone offset
            addAndRetrieveLexicalLiteral(client, graph, "17:48:32-04:00", XMLSchema.TIME);
            // Without time zone
            addAndRetrieveLexicalLiteral(client, graph, "18:48:32", XMLSchema.TIME);
            // With fractional seconds
            addAndRetrieveLexicalLiteral(client, graph, "19:48:32.25", XMLSchema.TIME);
            // With fractional seconds and time zone
            addAndRetrieveLexicalLiteral(client, graph, "20:48:32.25-05:00", XMLSchema.TIME);

            // xsd:gYearMonth
            // UTC
            addAndRetrieveLexicalLiteral(client, graph, "2008-06Z", XMLSchema.GYEARMONTH);
            // With time zone offset
            addAndRetrieveLexicalLiteral(client, graph, "2008-07-04:00", XMLSchema.GYEARMONTH);
            // Without time zone
            addAndRetrieveLexicalLiteral(client, graph, "2008-08", XMLSchema.GYEARMONTH);

            // xsd:gYear
            // UTC
            addAndRetrieveLexicalLiteral(client, graph, "2008", XMLSchema.GYEAR);
            // With time zone offset
            addAndRetrieveLexicalLiteral(client, graph, "2009-06:00", XMLSchema.GYEAR);
            // Without time zone
            addAndRetrieveLexicalLiteral(client, graph, "2010", XMLSchema.GYEAR);

            // xsd:gMonthDay
            // UTC
            addAndRetrieveLexicalLiteral(client, graph, "--07-14Z", XMLSchema.GMONTHDAY);
            // With time zone offset
            addAndRetrieveLexicalLiteral(client, graph, "--07-15-06:00", XMLSchema.GMONTHDAY);
            // Without time zone
            addAndRetrieveLexicalLiteral(client, graph, "--07-16", XMLSchema.GMONTHDAY);

            // xsd:gMonth
            // UTC
            addAndRetrieveLexicalLiteral(client, graph, "--07Z", XMLSchema.GMONTH);
            // With time zone offset
            addAndRetrieveLexicalLiteral(client, graph, "--08-06:00", XMLSchema.GMONTH);
            // Without time zone
            addAndRetrieveLexicalLiteral(client, graph, "--09", XMLSchema.GMONTH);

            // xsd:gDay
            // UTC
            addAndRetrieveLexicalLiteral(client, graph, "---14Z", XMLSchema.GDAY);
            // With time zone offset
            addAndRetrieveLexicalLiteral(client, graph, "---15-06:00", XMLSchema.GDAY);
            // Without time zone
            addAndRetrieveLexicalLiteral(client, graph, "---16", XMLSchema.GDAY);

            // xsd:duration
            addAndRetrieveLexicalLiteral(client, graph, "P1Y2M3DT10H30M13.136S", XMLSchema.DURATION);
            addAndRetrieveLexicalLiteral(client, graph, "P1Y2MT2H", XMLSchema.DURATION);

            // xsd:yearMonthDuration
            addAndRetrieveLexicalLiteral(client, graph, "P28Y5M", XMLSchema.DURATION_YEARMONTH);
            addAndRetrieveLexicalLiteral(client, graph, "P1347Y", XMLSchema.DURATION_YEARMONTH);
            addAndRetrieveLexicalLiteral(client, graph, "P1347M", XMLSchema.DURATION_YEARMONTH);

            // xsd:dayTimeDuration
            addAndRetrieveLexicalLiteral(client, graph, "P3DT10H30M13.136S", XMLSchema.DURATION_DAYTIME);
            addAndRetrieveLexicalLiteral(client, graph, "P32D", XMLSchema.DURATION_DAYTIME);
            addAndRetrieveLexicalLiteral(client, graph, "PT47H", XMLSchema.DURATION_DAYTIME);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test that XMLGregorianCalendar objects of various flavors are converted into the appropriate lexical representation with the appropriate datatype.
     * 
     * @throws Exception
     */
    public void testXsdTimeRelatedTypeLiteralsBecomeXMLGregorianCalendar() throws Exception {

        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);

            DatatypeFactory df = DatatypeFactory.newInstance();

            // xsd:dateTime
            // Without time zone
            XMLGregorianCalendar cal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 11, 16, 48, 32, 357, DatatypeConstants.FIELD_UNDEFINED);
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-11T16:48:32.357", XMLSchema.DATETIME, cal);
            // Without time zone without fractional seconds
            cal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 12, 16, 48, 32, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-12T16:48:32", XMLSchema.DATETIME, cal);
            // With time zone
            cal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 11, 16, 48, 32, 357, 7 * 60);
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-11T16:48:32.357+07:00", XMLSchema.DATETIME, cal);
            // With time zone and nanosecond precision 
            cal = df.newXMLGregorianCalendar(BigInteger.valueOf(2008), DatatypeConstants.JULY, 11, 16, 48, 32, BigDecimal.valueOf(123665845, 9), -8 * 60);
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-11T16:48:32.123665845-08:00", XMLSchema.DATETIME, cal);
            // UTC
            cal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 11, 16, 48, 32, 357, 0);
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-11T16:48:32.357Z", XMLSchema.DATETIME, cal);

            // xsd:date
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(2008, DatatypeConstants.JULY, 12, DatatypeConstants.FIELD_UNDEFINED);
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-12", XMLSchema.DATE, cal);
            // With time zone
            cal = df.newXMLGregorianCalendarDate(2008, DatatypeConstants.JULY, 11, -8 * 60);
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-11-08:00", XMLSchema.DATE, cal);

            // xsd:time
            // Without time zone
            cal = df.newXMLGregorianCalendarTime(16, 48, 32, 357, DatatypeConstants.FIELD_UNDEFINED);
            retrieveLexicalLiteralAsNativeType(client, graph, "16:48:32.357", XMLSchema.TIME, cal);
            // With time zone
            cal = df.newXMLGregorianCalendarTime(16, 48, 32, 357, 4 * 60);
            retrieveLexicalLiteralAsNativeType(client, graph, "16:48:32.357+04:00", XMLSchema.TIME, cal);

            // xsd:gYearMonth
            // With time zone
            cal = df.newXMLGregorianCalendarDate(2008, DatatypeConstants.JULY, DatatypeConstants.FIELD_UNDEFINED, -4 * 60);
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-04:00", XMLSchema.GYEARMONTH, cal);
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(2008, DatatypeConstants.AUGUST, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-08", XMLSchema.GYEARMONTH, cal);

            // xsd:gYear
            // With time zone
            cal = df.newXMLGregorianCalendarDate(2009, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, -6 * 60);
            retrieveLexicalLiteralAsNativeType(client, graph, "2009-06:00", XMLSchema.GYEAR, cal);
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(2010, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
            retrieveLexicalLiteralAsNativeType(client, graph, "2010", XMLSchema.GYEAR, cal);

            // xsd:gMonthDay
            // With time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.JULY, 15, -6 * 60);
            retrieveLexicalLiteralAsNativeType(client, graph, "--07-15-06:00", XMLSchema.GMONTHDAY, cal);
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.JULY, 16, DatatypeConstants.FIELD_UNDEFINED);
            retrieveLexicalLiteralAsNativeType(client, graph, "--07-16", XMLSchema.GMONTHDAY, cal);

            // xsd:gMonth
            // With time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.AUGUST, DatatypeConstants.FIELD_UNDEFINED, -6 * 60);
            retrieveLexicalLiteralAsNativeType(client, graph, "--08-06:00", XMLSchema.GMONTH, cal);
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.SEPTEMBER, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
            retrieveLexicalLiteralAsNativeType(client, graph, "--09", XMLSchema.GMONTH, cal);

            // xsd:gDay
            // With time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, 15, -6 * 60);
            retrieveLexicalLiteralAsNativeType(client, graph, "---15-06:00", XMLSchema.GDAY, cal);
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, 16, DatatypeConstants.FIELD_UNDEFINED);
            retrieveLexicalLiteralAsNativeType(client, graph, "---16", XMLSchema.GDAY, cal);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test that Duration objects of various flavors are converted into the appropriate lexical representation with the appropriate datatype.
     * 
     * @throws Exception
     */
    public void testXsdDurationRelatedTypeLiteralsBecomeDuration() throws Exception {

        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);

            DatatypeFactory df = DatatypeFactory.newInstance();

            // xsd:duration
            Duration duration = df.newDuration(true, 28, 5, 16, 1, 15, 37);
            retrieveLexicalLiteralAsNativeType(client, graph, "P28Y5M16DT1H15M37S", XMLSchema.DURATION, duration);

            // xsd:yearMonthDuration
            duration = df.newDuration(true, 28, 5, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
            retrieveLexicalLiteralAsNativeType(client, graph, "P28Y5M", XMLSchema.DURATION_YEARMONTH, duration);

            // xsd:dayTimeDuration
            duration = df.newDuration(true, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, 16, 1, 15, 37);
            retrieveLexicalLiteralAsNativeType(client, graph, "P16DT1H15M37S", XMLSchema.DURATION_DAYTIME, duration);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test the conversion of java.util.Calendar objects in the Anzo.java API into xsd:dateTime RDF literals with time zones. The test will add statements using
     * java.util.Calendar objects and verify that when those statements are retrieved, the expected lexical value, datatype, etc. are correct.
     * 
     * @throws Exception
     */
    public void testCalendarBecomesXsdDateTime() throws Exception {

        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);

            DatatypeFactory df = DatatypeFactory.newInstance();

            // UTC
            Calendar cal = getCleanCalendar();
            cal.set(2008, Calendar.JULY, 11, 16, 48, 32);
            XMLGregorianCalendar xmlcal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 11, 16, 48, 32, DatatypeConstants.FIELD_UNDEFINED, 0);
            addAndRetrieveNativeLiteral(client, graph, cal, xmlcal, "2008-07-11T16:48:32Z", XMLSchema.DATETIME);

            // Time zone offset
            cal = getCleanCalendar();
            cal.set(2008, Calendar.JULY, 11, 16, 48, 32);
            cal.setTimeZone(TimeZone.getTimeZone("GMT-09:00"));
            xmlcal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 11, 16, 48, 32, DatatypeConstants.FIELD_UNDEFINED, -9 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, xmlcal, "2008-07-11T16:48:32-09:00", XMLSchema.DATETIME);

            // Fractional seconds
            cal = getCleanCalendar();
            cal.set(2008, Calendar.JULY, 11, 16, 48, 32);
            cal.set(Calendar.MILLISECOND, 357);
            cal.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
            xmlcal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 11, 16, 48, 32, 357, -3 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, xmlcal, "2008-07-11T16:48:32.357-03:00", XMLSchema.DATETIME);

            // A partially filled Calendar still ends up as a fully specified xsd:dateTime with the default values
            // used for unspecified fields (i.e. 0 for time fields, January for month, 1 for day of month, etc.) 
            cal = getCleanCalendar();
            cal.set(2008, Calendar.JULY, 11);
            cal.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
            xmlcal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 11, 0, 0, 0, DatatypeConstants.FIELD_UNDEFINED, -3 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, xmlcal, "2008-07-11T00:00:00-03:00", XMLSchema.DATETIME);

            // Another partially filled Calendar. 
            cal = getCleanCalendar();
            cal.set(Calendar.YEAR, 2012);
            xmlcal = df.newXMLGregorianCalendar(2012, DatatypeConstants.JANUARY, 1, 0, 0, 0, DatatypeConstants.FIELD_UNDEFINED, 0);
            addAndRetrieveNativeLiteral(client, graph, cal, xmlcal, "2012-01-01T00:00:00Z", XMLSchema.DATETIME);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test the conversion of java.util.Date objects in the Anzo.java API into xsd:dateTime RDF literals in the UTC time zone. The test will add statements
     * using java.util.Date objects and verify that when those statements are retrieved, the expected lexical value, datatype, etc. are correct.
     * 
     * @throws Exception
     */
    public void testJavaDateBecomesXsdDateTimeInUTCTimeZone() throws Exception {

        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
            DatatypeFactory df = DatatypeFactory.newInstance();

            Date d = new Date(1216330344703L); // Thu Jul 17 17:32:24.703 EDT 2008 which is Thu Jul 17 21:32:24.703 UTC 2008 
            XMLGregorianCalendar cal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 17, 21, 32, 24, 703, 0);
            addAndRetrieveNativeLiteral(client, graph, d, cal, "2008-07-17T21:32:24.703Z", XMLSchema.DATETIME);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test the conversion of java.sql.Timestamp objects in the Anzo.java API into xsd:dateTime RDF literals in the UTC time zone. The test will add statements
     * using java.util.Timestamp objects and verify that when those statements are retrieved, the expected lexical value, datatype, etc. are correct.
     * 
     * We also make sure that the nanosecond precision of java.sql.Timestamp objects is maintained.
     * 
     * @throws Exception
     */
    public void testSqlTimestampBecomesXsdDateTimeInUTCTimeZone() throws Exception {

        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
            DatatypeFactory df = DatatypeFactory.newInstance();

            // Thu Jul 17 17:32:24.336512127 EDT 2008 which is Thu Jul 17 21:32:24.336512127 UTC 2008
            Timestamp ts = new Timestamp(1216330344000L);
            ts.setNanos(336512127);
            XMLGregorianCalendar cal = df.newXMLGregorianCalendar(BigInteger.valueOf(2008), DatatypeConstants.JULY, 17, 21, 32, 24, BigDecimal.valueOf(336512127, 9), 0);
            addAndRetrieveNativeLiteral(client, graph, ts, cal, "2008-07-17T21:32:24.336512127Z", XMLSchema.DATETIME);

            // Thu Jul 17 17:32:24.000000001 EDT 2008 which is Thu Jul 17 21:32:24.000000001 UTC 2008
            ts = new Timestamp(1216330344000L);
            ts.setNanos(1); // If we don't account for some JDK bugs, then this can come out as 2008-07-17T21:32:24.1E-9Z
            cal = df.newXMLGregorianCalendar(BigInteger.valueOf(2008), DatatypeConstants.JULY, 17, 21, 32, 24, BigDecimal.valueOf(1, 9), 0);
            addAndRetrieveNativeLiteral(client, graph, ts, cal, "2008-07-17T21:32:24.000000001Z", XMLSchema.DATETIME);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test the conversion of javax.xml.datatype.XMLGregorianCalendar objects in the Anzo.java API into various XML Schema-types RDF literals. The test will add
     * statements using javax.xml.datatype.XMLGregorianCalendar objects and verify that when those statements are retrieved, the expected lexical value,
     * datatype, etc. are correct.
     * 
     * @throws Exception
     */
    public void testXMLGregorianCalendarBecomesXsdTypedLiterals() throws Exception {

        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);

            DatatypeFactory df = DatatypeFactory.newInstance();

            // xsd:dateTime with time zone.
            // With time zone, a literal with a time zone is represented as a java.util.Calendar when it is retrieved even if the input is an XMLGregorianCalendar. 
            XMLGregorianCalendar cal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 11, 16, 48, 32, 357, 9 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "2008-07-11T16:48:32.357+09:00", XMLSchema.DATETIME);
            // Without time zone
            cal = df.newXMLGregorianCalendar(2008, DatatypeConstants.JULY, 12, 16, 48, 32, 357, DatatypeConstants.FIELD_UNDEFINED);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "2008-07-12T16:48:32.357", XMLSchema.DATETIME);

            // xsd:date
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(2008, DatatypeConstants.JULY, 12, DatatypeConstants.FIELD_UNDEFINED);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "2008-07-12", XMLSchema.DATE);
            // With time zone
            cal = df.newXMLGregorianCalendarDate(2008, DatatypeConstants.JULY, 11, -8 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "2008-07-11-08:00", XMLSchema.DATE);

            // xsd:time
            // Without time zone
            cal = df.newXMLGregorianCalendarTime(16, 48, 32, 357, DatatypeConstants.FIELD_UNDEFINED);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "16:48:32.357", XMLSchema.TIME);
            // With time zone
            cal = df.newXMLGregorianCalendarTime(16, 48, 32, 357, 4 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "16:48:32.357+04:00", XMLSchema.TIME);

            // xsd:gYearMonth
            // With time zone
            cal = df.newXMLGregorianCalendarDate(2008, DatatypeConstants.JULY, DatatypeConstants.FIELD_UNDEFINED, -4 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "2008-07-04:00", XMLSchema.GYEARMONTH);
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(2008, DatatypeConstants.AUGUST, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "2008-08", XMLSchema.GYEARMONTH);

            // xsd:gYear
            // With time zone
            cal = df.newXMLGregorianCalendarDate(2009, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, -6 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "2009-06:00", XMLSchema.GYEAR);
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(2010, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "2010", XMLSchema.GYEAR);

            // xsd:gMonthDay
            // With time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.JULY, 15, -6 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "--07-15-06:00", XMLSchema.GMONTHDAY);
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.JULY, 16, DatatypeConstants.FIELD_UNDEFINED);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "--07-16", XMLSchema.GMONTHDAY);

            // xsd:gMonth
            // With time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.AUGUST, DatatypeConstants.FIELD_UNDEFINED, -6 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "--08-06:00", XMLSchema.GMONTH);
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.SEPTEMBER, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "--09", XMLSchema.GMONTH);

            // xsd:gDay
            // With time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, 15, -6 * 60);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "---15-06:00", XMLSchema.GDAY);
            // Without time zone
            cal = df.newXMLGregorianCalendarDate(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, 16, DatatypeConstants.FIELD_UNDEFINED);
            addAndRetrieveNativeLiteral(client, graph, cal, cal, "---16", XMLSchema.GDAY);

            // Invalid XMLGregorianCalendar objects
            // Incomplete data. No XML Schema built-in type allows just an hour. We expect an exception.
            cal = df.newXMLGregorianCalendar();
            cal.setHour(13);
            try {
                Constants.valueFactory.createTypedLiteral(cal);
                fail("Should not get here since previous statement should throw exception.");
            } catch (AnzoRuntimeException e) {
                log.debug("Expected exception.");
            }

            // An XMLGregorianCalendar that has invalid data (February 31st) will go into the
            // system but will not be able to be parsed back into an XMLGregorianCalendar on retrieval.
            cal = df.newXMLGregorianCalendar();
            cal.setDay(31);
            cal.setMonth(DatatypeConstants.FEBRUARY);
            addAndRetrieveNativeLiteral(client, graph, cal, null, "--02-31", XMLSchema.GMONTHDAY);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test the conversion of javax.xml.datatype.Duration objects in the Anzo.java API into various XML Schema-types RDF literals. The test will add statements
     * using javax.xml.datatype.Duration objects and verify that when those statements are retrieved, the expected lexical value, datatype, etc. are correct.
     * 
     * @throws Exception
     */
    public void testDurationBecomesXsdTypedLiterals() throws Exception {

        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);

            DatatypeFactory df = DatatypeFactory.newInstance();

            // xsd:duration
            Duration duration = df.newDuration(true, 28, 5, 16, 1, 15, 37);
            addAndRetrieveNativeLiteral(client, graph, duration, duration, "P28Y5M16DT1H15M37S", XMLSchema.DURATION);

            // xsd:yearMonthDuration
            duration = df.newDuration(true, 28, 5, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
            addAndRetrieveNativeLiteral(client, graph, duration, duration, "P28Y5M", XMLSchema.DURATION_YEARMONTH);

            // xsd:dayTimeDuration
            duration = df.newDuration(true, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, 16, 1, 15, 37);
            addAndRetrieveNativeLiteral(client, graph, duration, duration, "P16DT1H15M37S", XMLSchema.DURATION_DAYTIME);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test various invalid lexical values for XML Schema date/time-related types. The system should allow you to enter those types but should throw exceptions
     * for such literals' getNativeValue.
     * 
     * @throws Exception
     */
    public void testInvalidLexicalDateTimeLiteralsHaveNullNativeValue() throws Exception {
        AnzoClient client = null;
        try {

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);

            // xsd:dateTime
            // Missing Seconds 
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-11T16:48Z", XMLSchema.DATETIME, null);
            // Time zone offset out of allowed range (-14 hours to +14 hours inclusive). 
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-11T16:48:12-17:00", XMLSchema.DATETIME, null);
            // Single digit month
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-7-11T16:48:15", XMLSchema.DATETIME, null);

            // xsd:date
            // Missing day
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07", XMLSchema.DATE, null);
            // Time zone offset out of allowed range (-14 hours to +14 hours inclusive). 
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-17:00", XMLSchema.DATE, null);
            // Day of month too large
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-32", XMLSchema.DATE, null);

            // xsd:time
            // Missing Seconds 
            retrieveLexicalLiteralAsNativeType(client, graph, "16:48Z", XMLSchema.TIME, null);
            // Time zone offset out of allowed range (-14 hours to +14 hours inclusive). 
            retrieveLexicalLiteralAsNativeType(client, graph, "16:48:12-17:00", XMLSchema.TIME, null);
            // Hour too large
            retrieveLexicalLiteralAsNativeType(client, graph, "25:48:15", XMLSchema.TIME, null);

            // xsd:gYearMonth
            // Single digit month
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-7", XMLSchema.GYEARMONTH, null);
            // Time zone offset out of allowed range (-14 hours to +14 hours inclusive). 
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-17:00", XMLSchema.GYEARMONTH, null);
            // Too much data
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-15", XMLSchema.GYEARMONTH, null);

            // xsd:gYear
            // Time zone offset out of allowed range (-14 hours to +14 hours inclusive). 
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-17:00", XMLSchema.GYEAR, null);
            // Too much data
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07", XMLSchema.GYEAR, null);

            // xsd:gMonthDay
            // Missing leading dashes
            retrieveLexicalLiteralAsNativeType(client, graph, "07-13", XMLSchema.GMONTHDAY, null);
            retrieveLexicalLiteralAsNativeType(client, graph, "-07-13", XMLSchema.GMONTHDAY, null);
            // Time zone offset out of allowed range (-14 hours to +14 hours inclusive). 
            retrieveLexicalLiteralAsNativeType(client, graph, "--07-15-17:00", XMLSchema.GMONTHDAY, null);
            // Too much data
            retrieveLexicalLiteralAsNativeType(client, graph, "2008-07-15", XMLSchema.GMONTHDAY, null);

            // xsd:gMonth
            // Missing leading dashes
            retrieveLexicalLiteralAsNativeType(client, graph, "07", XMLSchema.GMONTH, null);
            retrieveLexicalLiteralAsNativeType(client, graph, "-07", XMLSchema.GMONTH, null);
            // Time zone offset out of allowed range (-14 hours to +14 hours inclusive). 
            retrieveLexicalLiteralAsNativeType(client, graph, "--07-17:00", XMLSchema.GMONTH, null);
            // Too much data
            retrieveLexicalLiteralAsNativeType(client, graph, "--07-15", XMLSchema.GMONTH, null);

            // xsd:gDay
            // Missing leading dashes
            retrieveLexicalLiteralAsNativeType(client, graph, "15", XMLSchema.GDAY, null);
            retrieveLexicalLiteralAsNativeType(client, graph, "-16", XMLSchema.GDAY, null);
            retrieveLexicalLiteralAsNativeType(client, graph, "--17", XMLSchema.GDAY, null);
            // Time zone offset out of allowed range (-14 hours to +14 hours inclusive). 
            retrieveLexicalLiteralAsNativeType(client, graph, "---18-17:00", XMLSchema.GDAY, null);
            // Day too large
            retrieveLexicalLiteralAsNativeType(client, graph, "---32", XMLSchema.GDAY, null);

            // xsd:duration
            // Missing 'P'
            retrieveLexicalLiteralAsNativeType(client, graph, "1Y2M3DT10H30M13.136S", XMLSchema.DURATION, null);
            // Missing 'T'
            retrieveLexicalLiteralAsNativeType(client, graph, "P1Y2M3D10H30M13.136S", XMLSchema.DURATION, null);

            // xsd:yearMonthDuration
            // Missing 'P'
            retrieveLexicalLiteralAsNativeType(client, graph, "56Y34M", XMLSchema.DURATION_YEARMONTH, null);
            // Too much data
            retrieveLexicalLiteralAsNativeType(client, graph, "P56Y34M12D", XMLSchema.DURATION_YEARMONTH, null);

            // xsd:dayTimeDuration
            // Missing 'P'
            retrieveLexicalLiteralAsNativeType(client, graph, "3DT10H30M13.136S", XMLSchema.DURATION_DAYTIME, null);
            // Too much data
            retrieveLexicalLiteralAsNativeType(client, graph, "P1Y2M3DT10H30M13.136S", XMLSchema.DURATION_DAYTIME, null);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Writes out a literal using the given lexical value and datatype. Then it retrieves the literal as a native object and compares it to the given expected
     * native object instance.
     * 
     * @param client
     * @param graph
     * @param lexicalLiteralString
     *            the lexical value of the literal to write to the server.
     * @param literalDatatypeUri
     *            the datatype of the literal to write to the server.
     * @param expectedNativeInstance
     *            the native object to which we'll compare the result of retrieving the literal and calling getNativeValue. We compare via .equals except for
     *            java.util.Calendar which we compare via the 'compareTo' method. If this is null, then we assert that the getNativeValue method throws an
     *            IllegalArgumentException.
     * @throws AnzoException
     */
    private void retrieveLexicalLiteralAsNativeType(AnzoClient client, ClientGraph graph, String lexicalLiteralString, URI literalDatatypeUri, Object expectedNativeInstance) throws AnzoException {
        TypedLiteral lexicalLiteral = Constants.valueFactory.createLiteral(lexicalLiteralString, literalDatatypeUri);
        Statement stmt = Constants.valueFactory.createStatement(createTestUri("subject" + statementSuffix), createTestUri("predicate" + statementSuffix), lexicalLiteral);
        statementSuffix++;

        graph.add(stmt);
        client.updateRepository();

        Iterator<Statement> iter = graph.find(stmt.getSubject(), stmt.getPredicate(), stmt.getObject()).iterator();
        assertTrue(iter.hasNext());
        TypedLiteral literal = (TypedLiteral) iter.next().getObject();
        boolean exception = false;
        Object nativeValue = null;
        try {
            nativeValue = literal.getNativeValue();
        } catch (IllegalArgumentException iae) {
            exception = true;
        }
        if (expectedNativeInstance == null) {
            assertTrue(exception);
        } else {
            assertExpectedNativeValue(expectedNativeInstance, nativeValue);
        }
        iter = graph.find(stmt.getSubject(), stmt.getPredicate(), null).iterator();
        assertTrue(iter.hasNext());
        literal = (TypedLiteral) iter.next().getObject();
        nativeValue = null;
        exception = false;
        try {
            nativeValue = literal.getNativeValue();
        } catch (IllegalArgumentException iae) {
            exception = true;
        }
        if (expectedNativeInstance == null) {
            assertTrue(exception);
        } else {
            assertExpectedNativeValue(expectedNativeInstance, nativeValue);
        }
        iter = client.serverFind(stmt.getSubject(), stmt.getPredicate(), null, graph.getNamedGraphUri()).iterator();
        assertTrue(iter.hasNext());
        literal = (TypedLiteral) iter.next().getObject();
        nativeValue = null;
        exception = false;
        try {
            nativeValue = literal.getNativeValue();
        } catch (IllegalArgumentException iae) {
            exception = true;
        }
        if (expectedNativeInstance == null) {
            assertTrue(exception);
        } else {
            assertExpectedNativeValue(expectedNativeInstance, nativeValue);
        }
        String selectQuery = "SELECT ?x WHERE { <" + stmt.getSubject() + "> <" + stmt.getPredicate() + "> ?x }";
        QueryResults queryResults = client.serverQuery(Collections.singleton(GRAPH_URI), Collections.<URI> emptySet(), Collections.<URI> emptySet(), selectQuery);
        SolutionSet solutions = queryResults.getSelectResults();
        assertTrue(solutions.size() == 1);
        literal = (TypedLiteral) solutions.get(0).getBinding("x");
        assertExpectedNativeValue(expectedNativeInstance, nativeValue);
    }

    /**
     * The java.util.Calendar API makes it tricky to get a calendar initialized in a predictable state since most ways to create it use the system default time
     * zone, locale, and sometimes the current time.
     * 
     * This method helps ensure getting a calendar object that is more predictable across different systems.
     * 
     * @return a new fairly clean Calendar, ready for you to put your dirty paws all over it.
     */
    private Calendar getCleanCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(DateUtils.UTC_TIME_ZONE);
        cal.clear();
        cal.setLenient(false);
        return cal;
    }

    /**
     * Adds a statement with the object being a typed literal with the given lexical value and datatype URIs. Then the contains, find, and serverQuery methods
     * are called to make sure the literal can be retrieved properly.
     */
    private void addAndRetrieveLexicalLiteral(AnzoClient client, ClientGraph graph, String lexicalLiteralString, URI literalDatatypeUri) throws AnzoException {
        TypedLiteral lexicalLiteral = Constants.valueFactory.createLiteral(lexicalLiteralString, literalDatatypeUri);
        Statement stmt = Constants.valueFactory.createStatement(createTestUri("subject" + statementSuffix), createTestUri("predicate" + statementSuffix), lexicalLiteral);
        statementSuffix++;

        graph.add(stmt);
        assertTrue(graph.contains(stmt));
        client.updateRepository();
        assertTrue(graph.contains(stmt));

        Iterator<Statement> iter = graph.find(stmt.getSubject(), stmt.getPredicate(), Constants.valueFactory.createLiteral(lexicalLiteralString, literalDatatypeUri)).iterator();
        assertTrue(iter.hasNext());
        TypedLiteral literal = (TypedLiteral) iter.next().getObject();
        assertEquals(lexicalLiteralString, literal.getLabel());
        assertEquals(literalDatatypeUri, literal.getDatatypeURI());

        iter = client.serverFind(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), graph.getNamedGraphUri()).iterator();
        assertTrue(iter.hasNext());
        literal = (TypedLiteral) iter.next().getObject();
        assertEquals(lexicalLiteralString, literal.getLabel());
        assertEquals(literalDatatypeUri, literal.getDatatypeURI());

        String askQuery = "ASK { <" + stmt.getSubject() + "> <" + stmt.getPredicate() + "> " + "'" + lexicalLiteralString + "'^^<" + literalDatatypeUri + "> }";
        QueryResults queryResults = client.serverQuery(Collections.singleton(GRAPH_URI), Collections.<URI> emptySet(), Collections.<URI> emptySet(), askQuery);
        assertTrue(queryResults.getAskResults());

        String selectQuery = "SELECT ?x WHERE { <" + stmt.getSubject() + "> <" + stmt.getPredicate() + "> ?x }";
        queryResults = client.serverQuery(Collections.singleton(GRAPH_URI), Collections.<URI> emptySet(), Collections.<URI> emptySet(), selectQuery);
        SolutionSet solutions = queryResults.getSelectResults();
        assertTrue(solutions.size() == 1);
        assertTrue(solutions.get(0).getBinding("x").equals(lexicalLiteral));
    }

    /**
     * Add and retrieves a literal created from the given native Java object and asserts that the expected values are maintained during the entire round trip,
     * including via SPARQL queries.
     * 
     * @param client
     * @param graph
     * @param obj
     *            The native Object to use in creating the literal
     * @param expectedObj
     *            The native Object expected in the literal retrieved from the server. Equality is asserted via
     *            {@link #assertExpectedNativeValue(Object, Object)}.
     * @param expectedLexicalDateTime
     *            The expected lexical value of the literal created from the given Calendar
     * @param expectedDatatype
     *            The expected datatype URI of the literal created from the given Calendar
     * @throws AnzoException
     */
    private void addAndRetrieveNativeLiteral(AnzoClient client, ClientGraph graph, Object obj, Object expectedObj, String expectedLexicalDateTime, URI expectedDatatype) throws AnzoException {
        TypedLiteral derivedLiteral = Constants.valueFactory.createTypedLiteral(obj);
        TypedLiteral rawLiteral = Constants.valueFactory.createLiteral(expectedLexicalDateTime, expectedDatatype);

        assertTrue(rawLiteral.equals(derivedLiteral));

        Statement derivedStatement = Constants.valueFactory.createStatement(createTestUri("subject" + statementSuffix), createTestUri("predicate" + statementSuffix), derivedLiteral);
        Statement rawStatement = Constants.valueFactory.createStatement(derivedStatement.getSubject(), derivedStatement.getPredicate(), rawLiteral);
        statementSuffix++;

        graph.add(derivedStatement);
        assertTrue(graph.contains(derivedStatement));
        assertTrue(graph.contains(rawStatement));
        client.updateRepository();
        assertTrue(graph.contains(derivedStatement));
        assertTrue(graph.contains(rawStatement));

        Iterator<Statement> iter = graph.find(rawStatement.getSubject(), rawStatement.getPredicate(), rawStatement.getObject()).iterator();
        assertTrue(iter.hasNext());
        TypedLiteral literal = (TypedLiteral) iter.next().getObject();
        assertLiteral(literal, expectedObj, expectedLexicalDateTime, expectedDatatype, derivedLiteral, rawLiteral);

        iter = graph.find(derivedStatement.getSubject(), derivedStatement.getPredicate(), derivedStatement.getObject()).iterator();
        assertTrue(iter.hasNext());
        literal = (TypedLiteral) iter.next().getObject();
        assertLiteral(literal, expectedObj, expectedLexicalDateTime, expectedDatatype, derivedLiteral, rawLiteral);

        iter = graph.find(rawStatement.getSubject(), rawStatement.getPredicate(), null).iterator();
        assertTrue(iter.hasNext());
        literal = (TypedLiteral) iter.next().getObject();
        assertLiteral(literal, expectedObj, expectedLexicalDateTime, expectedDatatype, derivedLiteral, rawLiteral);

        iter = client.serverFind(derivedStatement.getSubject(), derivedStatement.getPredicate(), derivedStatement.getObject(), graph.getNamedGraphUri()).iterator();
        assertTrue(iter.hasNext());
        literal = (TypedLiteral) iter.next().getObject();
        assertLiteral(literal, expectedObj, expectedLexicalDateTime, expectedDatatype, derivedLiteral, rawLiteral);

        String askQuery = "ASK { <" + derivedStatement.getSubject() + "> <" + derivedStatement.getPredicate() + "> " + "'" + expectedLexicalDateTime + "'^^<" + expectedDatatype + "> }";
        QueryResults queryResults = client.serverQuery(Collections.singleton(GRAPH_URI), Collections.<URI> emptySet(), Collections.<URI> emptySet(), askQuery);
        assertTrue(queryResults.getAskResults());

        String selectQuery = "SELECT ?x WHERE { <" + derivedStatement.getSubject() + "> <" + derivedStatement.getPredicate() + "> ?x }";
        queryResults = client.serverQuery(Collections.singleton(GRAPH_URI), Collections.<URI> emptySet(), Collections.<URI> emptySet(), selectQuery);
        SolutionSet solutions = queryResults.getSelectResults();
        assertTrue(solutions.size() == 1);
        literal = (TypedLiteral) solutions.get(0).getBinding("x");
        assertLiteral(literal, expectedObj, expectedLexicalDateTime, expectedDatatype, derivedLiteral, rawLiteral);
    }

    /**
     * Assert that the given literal has the expected values as given.
     * 
     * @param literal
     *            Literal being tested.
     * @param obj
     *            Object to compare with the result of literal.getNativeValue(). Equality is asserted via {@link #assertExpectedNativeValue(Object, Object)} .
     * @param expectedLexicalDateTime
     *            The expected value of literal.getLabel()
     * @param expectedDatatype
     *            The expected value of literal.getDatatype()
     * @param derivedLiteral
     *            literal should be equals to this via .equals
     * @param rawLiteral
     *            literal should be equals to this via .equals
     */
    private static void assertLiteral(TypedLiteral literal, Object obj, String expectedLexicalDateTime, URI expectedDatatype, TypedLiteral derivedLiteral, TypedLiteral rawLiteral) {
        assertTrue(literal.equals(derivedLiteral));
        assertTrue(literal.equals(rawLiteral));
        assertEquals(expectedLexicalDateTime, literal.getLabel());
        assertEquals(expectedDatatype, literal.getDatatypeURI());
        if (obj == null) {
            boolean exception = false;
            try {
                literal.getNativeValue();
            } catch (IllegalArgumentException iae) {
                exception = true;
            }
            assertTrue(exception);
        } else {
            assertExpectedNativeValue(obj, literal.getNativeValue());
        }
    }

    /**
     * Assert that the two objects are equal, or both null. java.util.Calendar is handled specially and compared via the compareTo method rather than equals.
     * 
     * @param expectedNativeInstance
     * @param nativeValue
     */
    private static void assertExpectedNativeValue(Object expectedNativeInstance, Object nativeValue) {
        if (expectedNativeInstance == null) {
            assertNull(nativeValue);
        } else if (expectedNativeInstance instanceof Calendar) {
            assertTrue(((Calendar) expectedNativeInstance).compareTo((Calendar) nativeValue) == 0);
        } else {
            assertTrue(expectedNativeInstance.equals(nativeValue));
        }
    }

}
