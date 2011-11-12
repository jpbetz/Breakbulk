/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client.cli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class RdfIOCommand implements SubCommand {
    private static final Logger   log     = LoggerFactory.getLogger(RdfIOCommand.class);

    protected static final Option VERBOSE = new Option("v", "verbose", false, "Display filenames being uploaded");

    protected static final Option RECURSE = new Option("r", "recurse", false, "Recurse directories");

    RDFFormat getFormatOption(CommandLine cl, Option option) throws AnzoException {
        RDFFormat format = null;
        if (cl.hasOption(option.getOpt())) {
            String formatString = cl.getOptionValue(option.getOpt());
            format = RDFFormat.forFileName("." + formatString);
            if (format == null) {
                throw new InvalidArgumentException("unsupported format: " + formatString);
            }
        }
        return format;
    }

    RDFFormat getFormatOption(CommandLine cl, Option option, String defaultFormat) throws AnzoException {
        String formatString = cl.getOptionValue(option.getOpt(), defaultFormat);

        RDFFormat format = RDFFormat.forFileName("." + formatString);
        if (format == null) {
            throw new InvalidArgumentException("unrecognized rdf format: " + formatString);
        }

        return format;
    }

    protected String getEncodingOption(CommandLine cl, Option option) throws AnzoException {
        String charsetName = cl.getOptionValue(option.getOpt());
        if (charsetName == null)
            return Constants.byteEncoding;
        if (!Charset.isSupported(charsetName))
            throw new InvalidArgumentException("unsupported charset: " + charsetName);
        return charsetName;
    }

    protected void printOnConnectionSuccess(CommandContext context) {
        if (context.getRequireLogin()) {
            context.writeOutput("\nAuthentication Successful\n");
        }
    }

    protected Pair<File, RDFFormat> getFileArgument(CommandContext context, String arg, RDFFormat formatOverride, boolean exists) throws AnzoException {
        File file = new File(arg);
        if (exists && !file.isFile()) {
            throw new InvalidArgumentException("file not found: " + file.getAbsolutePath());
        }
        RDFFormat format = null;
        try {
            format = formatOverride != null ? formatOverride : RDFFormat.forFileName(file.getName());
        } catch (AnzoRuntimeException ae) {
            log.debug(LogUtils.INTERNAL_MARKER, "Error getting rdf format for:" + arg, ae);
        }
        return new Pair<File, RDFFormat>(file, format);
    }

    Collection<RdfInputArgument> getArgumentsAsStreams(CommandLine cl, CommandContext context, String[] args, int start, int end, RDFFormat formatOverride, String charsetName) throws AnzoException {
        List<RdfInputArgument> results = new ArrayList<RdfInputArgument>();
        for (int i = start; i < end; i++) {
            String arg = args[i];
            if (new File(arg).exists() && new File(arg).isDirectory()) {
                Collection<File> files = getFiles(new File(arg), cl.hasOption(RECURSE.getOpt()));
                for (File file : files) {
                    try {
                        RDFFormat.forFileName(file.getName());
                        results.add(getArgumentAsInputStream(context, file.getAbsolutePath(), formatOverride, charsetName));
                        if (cl.hasOption(VERBOSE.getOpt())) {
                            context.writeOutput("Adding file: " + file.getAbsolutePath());
                        }
                    } catch (AnzoRuntimeException e) {
                        log.debug("Skipping file: " + file.getAbsolutePath());
                    }
                }
            } else {
                RdfInputArgument entry = getArgumentAsInputStream(context, arg, formatOverride, charsetName);
                results.add(entry);
            }
        }
        return results;
    }

    Collection<File> getFiles(File dir, boolean recurse) {
        TreeSet<File> files = new TreeSet<File>();
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                if (recurse) {
                    files.addAll(getFiles(file, recurse));
                }
            } else {
                files.add(file);
            }
        }
        return files;
    }

    RdfInputArgument getArgumentAsInputStream(CommandContext context, String arg, RDFFormat formatOverride, String charsetName) throws AnzoException {
        if (!new File(arg).exists() && (context.isURI(arg) || context.isCURIE(arg))) {
            try {
                URI uri = context.getURI(arg);
                return getInputStreamForURIArgument(uri, charsetName);
            } catch (URISyntaxException e) {
                throw new InvalidArgumentException("URI Syntax Exception: " + arg + "\n" + e.getMessage());
            }
        }
        Pair<File, RDFFormat> file = getFileArgument(context, arg, formatOverride, true);

        try {
            return new RdfInputArgument(new FileInputStream(file.first), file.second, file.first.getAbsolutePath(), null, charsetName);
        } catch (FileNotFoundException e) {
            throw new InvalidArgumentException("file not found: " + file.first.getName());
        }
    }

    Pair<Writer, RDFFormat> getFileArgumentAsOutputStream(CommandContext context, String arg, RDFFormat formatOverride) throws AnzoException {
        Pair<File, RDFFormat> file = getFileArgument(context, arg, formatOverride, false);

        try {
            return new Pair<Writer, RDFFormat>(new OutputStreamWriter(new FileOutputStream(file.first), Constants.byteEncoding), file.second);
        } catch (FileNotFoundException e) {
            throw new InvalidArgumentException("file not found: " + file.first.getName());
        } catch (IOException e) {
            throw new InvalidArgumentException("file not found: " + file.first.getName());
        }
    }

    RdfInputArgument getRdfInputOption(CommandContext context, CommandLine cl, Option option, RDFFormat formatOverride, String charsetName) throws AnzoException {
        String fileOption = cl.getOptionValue(option.getOpt());
        if (fileOption == null)
            return null;
        return getArgumentAsInputStream(context, fileOption, formatOverride, charsetName);
    }

    Pair<File, RDFFormat> getFileOption(CommandLine cl, Option option, RDFFormat formatOverride, boolean exists) throws AnzoException {
        String fileOption = cl.getOptionValue(option.getOpt());
        File file = null;
        RDFFormat format = null;
        if (fileOption != null) {
            file = new File(fileOption);
            if (exists && !file.isFile()) {
                throw new InvalidArgumentException("File not found:" + file);
            }
            format = formatOverride != null ? formatOverride : RDFFormat.forFileName(file.getName());
        }

        return file == null ? null : new Pair<File, RDFFormat>(file, format);
    }

    URI getURIOption(CommandLine cl, Option option, CommandContext context) throws AnzoException {
        URI uri = null;
        if (cl.hasOption(option.getOpt())) {
            String uriString = cl.getOptionValue(option.getOpt());
            try {
                uri = context.getURI(uriString);
            } catch (URISyntaxException e) {
                throw new InvalidArgumentException("illegal URI: " + uriString);
            }
        }
        return uri;
    }

    RdfInputArgument getInputStreamForURIArgument(URI uri, String charsetName) throws AnzoException {
        try {
            HttpClient client = new HttpClient();
            GetMethod get = new GetMethod(uri.toString());
            get.addRequestHeader("Accept", RDFFormat.RDFXML.getDefaultMIMEType());
            get.setFollowRedirects(true); // handles See Also headers
            client.executeMethod(get);
            int statusCode = get.getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                Header contentType = get.getResponseHeader("Content-Type");
                RDFFormat format;
                if (contentType == null) {
                    format = RDFFormat.RDFXML;
                } else {
                    String type = contentType.getValue();
                    format = RDFFormat.forMIMEType(type);
                    format = format == null ? RDFFormat.RDFXML : format;
                }

                InputStream input = get.getResponseBodyAsStream();
                return new RdfInputArgument(input, format, uri.toString(), uri, charsetName);

            } else {
                throw new CommandException("Error retrieving data from URI: " + uri);
            }
        } catch (IOException e) {
            throw new CommandException("Error retrieving data from URI: " + uri);
        } catch (IllegalStateException e) {
            throw new CommandException(e, "Error retrieving data from URI: " + uri);
        }

    }

    URI getURIArgument(String arg, CommandContext context) throws AnzoException {
        URI uri = null;
        try {
            uri = context.getURI(arg);
        } catch (URISyntaxException e) {
            throw new InvalidArgumentException("Invalid (1) URI: " + arg);
        }
        return uri;
    }

    List<URI> getURIArguments(String[] args, int start, int end, CommandContext context) throws AnzoException {
        List<URI> uris = new ArrayList<URI>();
        for (int i = start; i < end; i++) {
            String uriString = args[i];
            try {
                if (context.isURI(uriString)) {
                    uris.add(context.getURI(uriString));
                } else {
                    throw new InvalidArgumentException("Invalid (2) URI: " + uriString);
                }
            } catch (URISyntaxException e) {
                throw new InvalidArgumentException("Invalid (3) URI: " + uriString);
            }
        }
        return uris;
    }

    boolean isFlagSet(CommandLine cl, Option option) {
        return cl.hasOption(option.getOpt());
    }

}
