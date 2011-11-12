/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 7, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import org.json.JSONException;
import org.json.JSONWriter;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Serialization Utilities
 *
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 *
 */

/**
 * Serialization Utilities
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
public class SerializationUtils {
    /**
     * Method to augment a hashcode with some extra hash
     * 
     * @param initial
     *            initial hash value
     * @param o
     *            object to extend hash
     * @return augmented hashcode
     */
    static public int augmentHashValue(int initial, Object o) {
        return 31 * initial + (o == null ? 0 : o.hashCode());
    }

    /**
     * Write an exception to a Writer
     * 
     * @param exception
     *            exception to write
     * @param writer
     *            write to which data is written
     * @throws JSONException
     */
    public static void writeExceptionJSON(Exception exception, Writer writer) throws JSONException {
        JSONWriter jw = new JSONWriter(writer);
        jw.object();
        jw.key("error");
        jw.value(true);
        jw.key(SerializationConstants.errorMessage);
        if (exception instanceof AnzoException) {
            AnzoException anzoException = (AnzoException) exception;
            jw.value(anzoException.getMessage(false));
            jw.key(SerializationConstants.errorTags);
            jw.value("0");
            jw.key(SerializationConstants.errorCode);
            jw.value(anzoException.getErrorCode());
        } else {
            jw.value(exception.getMessage());
        }
        jw.endObject();
    }

    /**
     * Write a {@link Value} to the output
     * 
     * @param value
     *            value to write out
     * @param out
     *            writer on which to write data
     * @param format
     *            format of output stream
     * @throws AnzoException
     *             if there is an error writing URIs to output writer
     */
    public static void writeValue(Value value, Writer out, String format) throws AnzoException {
        try {
            if (format == null || SerializationConstants.MIMETYPE_TEXT.equals(format)) {
                if (value != null) {
                    out.write(value.toString());
                }
            } else if (RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
                JSONRdfWriter writer = new JSONRdfWriter(out);
                writer.handleValue(value);
            }
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
    }

    /**
     * Write a Long to the output
     * 
     * @param value
     *            value to write out
     * @param out
     *            writer on which to write data
     * @param format
     *            format of output stream
     * @throws AnzoException
     *             if there is an error writing URIs to output writer
     */
    public static void writeValue(Long value, Writer out, String format) throws AnzoException {
        try {
            if (format == null || SerializationConstants.MIMETYPE_TEXT.equals(format)) {
                if (value != null) {
                    out.write(value.toString());
                }
            } else if (RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
                out.write(value.toString());
            }
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
    }

    /**
     * Write an Integer to the output
     * 
     * @param value
     *            value to write out
     * @param out
     *            writer on which to write data
     * @param format
     *            format of output stream
     * @throws AnzoException
     *             if there is an error writing URIs to output writer
     */
    public static void writeValue(Boolean value, Writer out, String format) throws AnzoException {
        try {
            if (format == null || SerializationConstants.MIMETYPE_TEXT.equals(format)) {
                if (value != null) {
                    out.write(value.toString());
                }
            } else if (RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
                out.write(value.toString());
            }
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
    }

    /** Delimiter for CSV string */
    private static final String CSV_DELIM  = ",";

    /** Delimiter for Text string */
    private static final String TEXT_DELIM = "\n";

    /**
     * Convert a comma delimited or newline delimited list into a Set
     * 
     * @param value
     *            string containing URIs
     * @param format
     *            The format of the value string. The supported formats are, <code>application/csv</code> which uses commas for delimiting items in the list,
     *            and <code>text/plain</code> uses newlines ('\n') for delimiting items the list.
     * @return set of URIs
     */
    public static Set<URI> convertStringToSet(String value, String format) {
        String delimiter = null;
        if (SerializationConstants.MIMETYPE_CSV.equals(format)) {
            delimiter = CSV_DELIM;
        } else if (SerializationConstants.MIMETYPE_TEXT.equals(format)) {
            delimiter = TEXT_DELIM;
        } else {
            throw new AnzoRuntimeException(ExceptionConstants.IO.ERROR_CONVERT_STRING_SET, format);
        }
        HashSet<URI> list = null;
        if (value != null && value.length() > 0) {
            list = new HashSet<URI>();
            StringTokenizer st = new StringTokenizer(value, delimiter);
            while (st.hasMoreTokens()) {
                list.add(MemURI.create(st.nextToken()));
            }
        }
        return list;
    }

    /**
     * Convert a collection of objects to a comma separated list of their toString values
     * 
     * @param collection
     *            collection of objects for which to create list
     * @param format
     *            output format
     * @param writer
     *            writer to which data is written
     * @throws IOException
     *             if there was an error writing to the writer
     */
    private static void convertToList(Collection<? extends Value> collection, String format, Writer writer) throws IOException {
        String delimiter = null;
        boolean quote = false;
        if (SerializationConstants.MIMETYPE_CSV.equals(format)) {
            delimiter = CSV_DELIM;
        } else if (SerializationConstants.MIMETYPE_TEXT.equals(format)) {
            delimiter = TEXT_DELIM;
        } else if (RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
            delimiter = TEXT_DELIM;
            quote = true;
        }
        if (collection != null) {
            for (Iterator<?> iterator = collection.iterator(); iterator.hasNext();) {
                writer.write(iterator.next().toString());
                if (iterator.hasNext()) {
                    if (quote)
                        writer.write('"');
                    writer.write(delimiter);
                    if (quote)
                        writer.write('"');
                }
            }
        }
    }

    /**
     * Convert a collection of objects to a comma separated list of their toString values
     * 
     * @param collection
     *            collection of objects for which to create list
     * @param format
     *            output format
     * @return Collection converted to String
     * @throws AnzoException
     *             if there was an error writing to the writer
     */
    public static String convertToList(Collection<? extends Value> collection, String format) throws AnzoException {
        try {
            StringWriter writer = new StringWriter();
            convertToList(collection, format, writer);
            return writer.toString();
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
        }
    }

    /**
     * Convert a collection of objects to a comma separated list of their toString values
     * 
     * @param collection
     *            collection of objects for which to create list
     * @param format
     *            output format
     * @param writer
     *            writer to which data is written
     * @throws IOException
     *             if there was an error writing to the writer
     */
    private static void convertToList(Value[] collection, String format, Writer writer) throws IOException {
        String delimiter = null;
        boolean quote = false;
        if (SerializationConstants.MIMETYPE_CSV.equals(format)) {
            delimiter = CSV_DELIM;
        } else if (SerializationConstants.MIMETYPE_TEXT.equals(format)) {
            delimiter = TEXT_DELIM;
        } else if (RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
            delimiter = TEXT_DELIM;
            quote = true;
        }
        if (collection != null) {
            for (int i = 0; i < collection.length; i++) {
                writer.write(collection[i].toString());
                if (i < collection.length - 1) {
                    if (quote)
                        writer.write('"');
                    writer.write(delimiter);
                    if (quote)
                        writer.write('"');
                }
            }
        }
    }

    /**
     * Convert a collection of objects to a comma separated list of their toString values
     * 
     * @param collection
     *            collection of objects for which to create list
     * @param format
     *            output format
     * @return Collection converted to String
     * @throws AnzoException
     *             if there was an error writing to the writer
     */
    public static String convertToList(Value[] collection, String format) throws AnzoException {
        try {
            StringWriter writer = new StringWriter();
            convertToList(collection, format, writer);
            return writer.toString();
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
        }
    }
}
