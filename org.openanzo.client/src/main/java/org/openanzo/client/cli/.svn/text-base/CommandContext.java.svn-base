/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client.cli;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.glitter.util.CURIE;
import org.openanzo.ontologies.system.Credentials;
import org.openanzo.ontologies.system.NetworkConnection;
import org.openanzo.ontologies.system.SystemFactory;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.adapter.RioToAnzoWriterAdapter;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.ReadWriteUtils.StatementsAndPrefixes;
import org.openanzo.services.ServicesProperties;

/**
 * Loads context for an anzo command line invocation.
 * 
 * Loads user settings if present and applies hostname, port and user, password options.
 * 
 * Also keeps track of prefixes found in user setting file if they have one and if these prefixes should be applied to inputs and outputs of the command.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class CommandContext {
    final AnzoClient          client;

    final INamedGraph         settings;

    final Map<String, String> prefixes;

    final boolean             noPrefixes;

    final String              user;

    final String              password;

    final String              host;

    final String              port;

    final boolean             useSsl;

    final String              timeout;

    boolean                   showTrace;

    final boolean             requireLogin;

    final IConsole            consoleWriter;

    /**
     * Sets things up.
     * 
     * Loads user settings if the user has them.
     * 
     * If non-null, overrides the hostname, port, user and password fields.
     * 
     */
    static CommandContext create(String settingsPath, String hostname, String port, Boolean useSsl, String user, String password, String timeout, boolean noPrefixes, boolean showTrace, IConsole consoleWriter) throws AnzoException {
        if (consoleWriter == null) {
            consoleWriter = CommandLineInterface.DEFAULT_CONSOLE;
        }
        INamedGraph settingsGraph = new NamedGraph(MemURI.create("http://openanzo.org/reserved/user-config"));
        Map<String, String> prefixes = new HashMap<String, String>();
        boolean hasSettings = true;
        File clientFile = null;
        if (settingsPath != null) {
            File file = new File(settingsPath);
            if (!file.exists()) {
                throw new CommandException("requested user settings file does not exist:" + file.getAbsolutePath());
            }
            clientFile = file;
        } else {
            String userHome = System.getProperty("user.home");
            File anzoDirectory = new File(new File(userHome), ".anzo");
            if (!anzoDirectory.isDirectory()) {
                hasSettings = false;
            } else {
                clientFile = new File(anzoDirectory, "settings.trig");
                if (!clientFile.isFile()) {
                    hasSettings = false;
                }
            }
        }

        if (hasSettings && clientFile != null) {
            try {
                StatementsAndPrefixes sAndP = ReadWriteUtils.loadStatementsAndPrefixes(ReadWriteUtils.createSmartFileReader(clientFile), RDFFormat.forFileName(clientFile.getName()), "", settingsGraph.getNamedGraphUri());
                settingsGraph.add(sAndP.getStatements());
                prefixes.putAll(sAndP.getPrefixes());
                stripCommonSchemesFromPrefix(consoleWriter, prefixes);
            } catch (Exception ae) {
                throw new CommandException(ae, "Error loading configuration file");
            }
        }

        Credentials credentials = SystemFactory.getCredentials(CommandLineInterface.CLIConfigURI, settingsGraph);
        if (credentials != null) {
            if (user == null) {
                user = credentials.getUser();
            }
            if (password == null) {
                password = credentials.getPassword();
            }
        }

        boolean reqLogin = user == null || password == null;
        if (reqLogin) {
            consoleWriter.writeOutput(CommandLineInterface.generateVersionHeader() + "\n");

            try {
                if (user == null) {
                    user = consoleWriter.readString("Username required. Please enter a username: ", false);
                }
                if (password == null) {
                    password = consoleWriter.readString("Password required. Please enter the password for user '" + user + "': ", true);
                }
            } catch (IOException ie) {
                throw new CommandException(ie, "Unable to read username or password from the command line");
            }
        }

        AnzoClient client = null;
        NetworkConnection connection = SystemFactory.getNetworkConnection(CommandLineInterface.CLIConfigURI, settingsGraph);
        if (connection != null) {
            if (hostname == null) {
                hostname = connection.getHost();
            }
            if (port == null && connection.getPort() != null) {
                port = connection.getPort().toString();
            }
            if (useSsl == null && connection.getUseSsl() != null) {
                useSsl = connection.getUseSsl();
            }
            Long time = connection.getTimeout();
            if (time != null && timeout == null) {
                timeout = time.toString();
            }

            String keystoreFile = connection.getKeystoreFile();
            if (keystoreFile != null) {
                System.setProperty("javax.net.ssl.keyStore", preprocessString(keystoreFile));
            }
            String keystoreType = connection.getKeystoreType();
            if (keystoreType != null) {
                System.setProperty("javax.net.ssl.keyStoreType", keystoreType);
            }
            String keystorePassword = connection.getKeystorePassword();
            if (keystorePassword != null) {
                System.setProperty("javax.net.ssl.keyStorePassword", keystorePassword);
            }

            String truststoreFile = connection.getTruststoreFile();
            if (truststoreFile != null) {
                System.setProperty("javax.net.ssl.trustStore", preprocessString(truststoreFile));
            }
            String truststoreType = connection.getTruststoreType();
            if (truststoreType != null) {
                System.setProperty("javax.net.ssl.trustStoreType", truststoreType);
            }
            String truststorePassword = connection.getTruststorePassword();
            if (truststorePassword != null) {
                System.setProperty("javax.net.ssl.trustStorePassword", truststorePassword);
            }
        }

        hostname = hostname == null ? CommandLineInterface.DEFAULT_HOST : hostname;
        useSsl = useSsl == null ? CommandLineInterface.DEFAULT_USE_SSL : useSsl;
        port = port == null ? (useSsl ? CommandLineInterface.DEFAULT_SSL_PORT : CommandLineInterface.DEFAULT_PORT) : port;
        Properties conf = AnzoClientConfigurationFactory.createJMSConfiguration(user, password, hostname, Integer.valueOf(port), useSsl);
        if (timeout == null) {
            timeout = "0";
        }
        ServicesProperties.setTimeout(conf, Integer.parseInt(timeout) * 1000);
        //File store = new File(anzoDirectory, ".store");
        //AnzoClientConfigurationFactory.configurePersistedClient(conf,"localstore", "HSQL","jdbc:hsqldb:file:" + store,"sa","");
        client = new AnzoClient(conf);

        CommandContext ctx = new CommandContext(client, settingsGraph, prefixes, noPrefixes, user, password, hostname, port, useSsl, timeout, showTrace, reqLogin, consoleWriter);
        return ctx;
    }

    /** Convert system properties to values */
    public static String preprocessString(String value) {
        if (value == null)
            return null;
        String result = value;
        while ((result).contains("${")) {
            int index = (result).indexOf("${");
            String val = (result).substring(0, index);
            int endIndex = (result).indexOf("}", index);
            if (endIndex < 0)
                endIndex = (result).length();
            String replacement = (result).substring(index + 2, endIndex);
            if (System.getProperty(replacement) != null) {
                val = val.concat(System.getProperty(replacement));
            } else if (System.getenv(replacement) != null) {
                val = val.concat(System.getenv(replacement));
            }
            if (endIndex < (result).length()) {
                val = val.concat((result).substring(endIndex + 1));
            }
            result = val;
        }
        return result;
    }

    private CommandContext(AnzoClient client, INamedGraph settings, Map<String, String> prefixes, boolean noPrefixes, String user, String password, String host, String port, boolean useSsl, String timeout, boolean showTrace, boolean requireLogin, IConsole consoleWriter) {
        this.client = client;
        this.settings = settings;
        this.prefixes = prefixes;
        this.noPrefixes = noPrefixes;
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
        this.useSsl = useSsl;
        this.timeout = timeout;
        this.showTrace = showTrace;
        this.requireLogin = requireLogin;
        this.consoleWriter = consoleWriter;

    }

    /**
     * @return the consoleWriter
     */
    public IConsole getConsoleWriter() {
        return consoleWriter;
    }

    /**
     * Gets the user provided settings.
     */
    INamedGraph getSettings() {
        return settings;
    }

    /**
     * Gets the prefix map defined in the user setting.
     */
    Map<String, String> getPrefixes() {
        return prefixes;
    }

    /**
     * Gets the anzo client configured for this command line execution.
     */
    AnzoClient getAnzoClient() {
        return client;
    }

    String getUser() {
        return user;
    }

    String getPassword() {
        return password;
    }

    String getHost() {
        return host;
    }

    int getPort() {
        return Integer.parseInt(port);
    }

    boolean getUseSsl() {
        return useSsl;
    }

    String getTimeout() {
        return timeout;
    }

    boolean getExcludePrefixes() {
        return noPrefixes;
    }

    boolean getRequireLogin() {
        return requireLogin;
    }

    /**
     * @return the showTrace
     */
    public boolean getShowTrace() {
        return showTrace;
    }

    /**
     * Creates a CURIE from the provided string, which may be either a CURIE, or a URI that is map-able to a CURIE using the user provided prefix map.
     */
    CURIE getCURIE(String in) {
        if (hasCommonScheme(in)) {
            for (Map.Entry<String, String> entry : prefixes.entrySet()) {
                String prefix = entry.getValue();
                if (in.startsWith(prefix)) {
                    return new CURIE(entry.getKey() + ":" + in.substring(prefix.length()));
                }
            }
            return null;
        } else {
            return new CURIE(in);
        }
    }

    /**
     * Checks that the input string is either a CURIE, or a URI that is map-able to a CURIE using the user provided prefix map.
     */
    boolean isCURIE(String in) {
        boolean ret = false;
        if (in.indexOf(':') != -1) {
            if (hasCommonScheme(in)) {
                // It's likely a URI so check that it's map-able to a CURIE using the user provided prefix map.
                for (Map.Entry<String, String> entry : prefixes.entrySet()) {
                    String prefix = entry.getValue();
                    if (in.startsWith(prefix)) {
                        ret = true;
                    }
                }
            } else {
                // It's a regular CURIE.
                ret = true;
            }
        }
        return ret;
    }

    static final Set<String> commonUriSchemeSet        = new HashSet<String>();

    static int               longestCommonSchemeLength = -1;
    static {
        commonUriSchemeSet.add("jdbc");
        commonUriSchemeSet.add("data");
        commonUriSchemeSet.add("file");
        commonUriSchemeSet.add("ftp");
        commonUriSchemeSet.add("gopher");
        commonUriSchemeSet.add("http");
        commonUriSchemeSet.add("https");
        commonUriSchemeSet.add("im");
        commonUriSchemeSet.add("imap");
        commonUriSchemeSet.add("info");
        commonUriSchemeSet.add("ldap");
        commonUriSchemeSet.add("mailto");
        commonUriSchemeSet.add("mid");
        commonUriSchemeSet.add("news");
        commonUriSchemeSet.add("nntp");
        commonUriSchemeSet.add("rtsp");
        commonUriSchemeSet.add("snmp");
        commonUriSchemeSet.add("tag");
        commonUriSchemeSet.add("tel");
        commonUriSchemeSet.add("telnet");
        commonUriSchemeSet.add("xmpp");
        commonUriSchemeSet.add("tcp");
        commonUriSchemeSet.add("lsid");
        commonUriSchemeSet.add("urn");
        commonUriSchemeSet.add("feed");
        commonUriSchemeSet.add("ldaps");
        commonUriSchemeSet.add("skype");
        commonUriSchemeSet.add("userdata");

        for (String prefix : commonUriSchemeSet) {
            int len = prefix.length();
            if (len > longestCommonSchemeLength) {
                longestCommonSchemeLength = len;
            }
        }
    }

    static String extractPrefix(String in) {
        return extractPrefix(in, -1);
    }

    static String extractPrefix(String in, int maxLength) {
        String prefix = null;
        int colonIndex = -1;
        int len = maxLength == -1 ? in.length() : Math.min(in.length(), maxLength);
        for (int i = 0; i < len; i++) {
            if (in.charAt(i) == ':') {
                colonIndex = i;
                break;
            }
        }
        if (colonIndex != -1) {
            prefix = in.substring(0, colonIndex);
        }
        return prefix;
    }

    static boolean hasCommonScheme(String in) {
        boolean ret = false;
        String prefix = extractPrefix(in, longestCommonSchemeLength + 1);
        if (prefix != null) {
            ret = commonUriSchemeSet.contains(prefix);
        }
        return ret;
    }

    /**
     * Creates a URI from the provided string, which may be either a URI, or a CURIE that is map-able to a URI using the user provided prefix map.
     */
    URI getURI(String in) throws URISyntaxException {
        if (hasCommonScheme(in)) {
            return MemURI.create(new java.net.URI(in));
        } else {
            String prefix = extractPrefix(in);
            if (prefix != null && prefixes.containsKey(prefix)) {
                return MemURI.create(prefixes.get(prefix) + in.substring(prefix.length() + 1));
            }
        }
        throw new URINotCURIEOrKnownScheme(in, "String does not have a recognized scheme for an absolute URI and does not have a registered prefix. So the URI cannot be parsed");
    }

    /**
     * Checks that the input string is either a URI, or a CURIE that is map-able to a URI using the user provided prefix map.
     */
    boolean isURI(String in) {
        if (hasCommonScheme(in)) {
            try {
                MemURI.create(new java.net.URI(in));
                return true;
            } catch (Exception e) {
                writeError("Invalid URI:(" + in + ")");
                consoleWriter.printException(e, showTrace);
                return false;
            }
        } else {
            for (Map.Entry<String, String> entry : prefixes.entrySet()) {
                String prefix = entry.getKey();
                if (in.startsWith(prefix + ":")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Writes the dataset to STDOUT in the format provided. If usePrefixes is set, included either all the prefixes, or if minimizePrefixes is false, just
     * include the prefixes required by the RDF being output.
     */
    void outputRdf(IDataset dataset, RDFFormat format) throws AnzoException {
        this.outputRdf(dataset, format, new OutputStreamWriter(System.out));
    }

    /**
     * Writes the dataset to the provided output stream in the format provided. If usePrefixes is set, included either all the prefixes, or if minimizePrefixes
     * is false, just include the prefixes required by the RDF being output.
     */
    void outputRdf(IDataset dataset, RDFFormat format, Writer writer) throws AnzoException {
        outputRdf(dataset.getStatements(), format, writer, Collections.<String, String> emptyMap());
    }

    /**
     * Writes the statements to the provided output stream in the format provided. If usePrefixes is set, included either all the prefixes, or if
     * minimizePrefixes is false, just include the prefixes required by the RDF being output.
     */
    void outputRdf(Collection<Statement> itr, RDFFormat format, Writer writer) throws AnzoException {
        outputRdf(itr, format, writer, Collections.<String, String> emptyMap());
    }

    /**
     * Writes the statements to the provided output stream in the format provided. If usePrefixes is set, included either all the prefixes, or if
     * minimizePrefixes is false, just include the prefixes required by the RDF being output.
     */
    void outputRdf(Collection<Statement> itr, RDFFormat format, Writer writer, Map<String, String> inputPrefixes) throws AnzoException {

        RioToAnzoWriterAdapter w = new RioToAnzoWriterAdapter(writer, format);
        w.startRDF();

        if (format.supportsNamespaces()) {
            Map<String, String> tempPrefixes = combinePrefixes(this.prefixes, inputPrefixes);
            tempPrefixes = findMinimumPrefixMap(tempPrefixes, itr);

            if (!noPrefixes) {
                for (Map.Entry<String, String> prefix : tempPrefixes.entrySet()) {
                    w.handleNamespace(prefix.getKey(), prefix.getValue());
                }
            }
        }
        for (Statement stmt : StatementComparator.sort(itr)) {
            try {
                if (stmt.getNamedGraphUri() != null && stmt.getNamedGraphUri().equals(defaultNamedGraph)) {
                    w.handleStatement(new Statement(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), null));
                } else {
                    w.handleStatement(stmt);
                }
            } catch (AnzoException e) {
                throw new AnzoRuntimeException(e);
            }
        }
        w.endRDF();
    }

    Map<String, String> combinePrefixes(Map<String, String> userPrefixes, Map<String, String> inputPrefixes) {
        Map<String, String> results = new HashMap<String, String>(userPrefixes);
        for (Map.Entry<String, String> prefixEntry : inputPrefixes.entrySet()) {
            if (!userPrefixes.containsValue(prefixEntry.getValue()) && !userPrefixes.containsKey(prefixEntry.getKey())) {
                results.put(prefixEntry.getKey(), prefixEntry.getValue());
            }
        }
        return results;
    }

    static final URI defaultNamedGraph = MemURI.create("http://cambridgesemantics.com/reserved/placeholder");

    void populateDataset(IDataset dataset, Collection<Statement> resultSet) {
        dataset.addNamedGraph(defaultNamedGraph);
        dataset.addDefaultGraph(defaultNamedGraph);
        for (Statement stmt : resultSet) {
            if (stmt.getNamedGraphUri() == null) {
                dataset.add(new Statement(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), defaultNamedGraph));
            } else {
                dataset.addNamedGraph(stmt.getNamedGraphUri());
                dataset.add(stmt);
            }
        }
    }

    // perform an 'suffix array' search against the nodes of the statements to determine which prefixes are used.
    // for a method outside the writer this will be near optimum.  If the writer could be modified to calculate prefixes
    // as it ran, that could be much faster.
    private static Map<String, String> findMinimumPrefixMap(Map<String, String> prefixes, Collection<Statement> stmts) {
        String[] values = new String[stmts.size() * 5];
        int i = 0;
        for (Statement stmt : stmts) {
            Resource subject = stmt.getSubject();
            if (subject instanceof URI) {
                values[i++] = subject.toString();
            }
            values[i++] = stmt.getPredicate().toString();

            Value object = stmt.getObject();
            if (object instanceof TypedLiteral) {
                values[i++] = ((TypedLiteral) object).getDatatypeURI().toString();
            } else if (object instanceof URI) {
                values[i++] = object.toString();
            }

            if (stmt.getNamedGraphUri() != null)
                values[i++] = stmt.getNamedGraphUri().toString();
        }
        values = (String[]) ArrayUtils.subarray(values, 0, i);
        Arrays.sort(values);

        HashMap<String, String> results = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : prefixes.entrySet()) {
            if (isUsed(entry.getValue(), values, i)) {
                results.put(entry.getKey(), entry.getValue());
            }
        }
        return results;
    }

    /**
     * Writes the statement to a string using the user provided prefix map to convert URIs to CURIEs where possible.
     */
    String applyPrefixes(Statement stmt) {
        return applyPrefixes(stmt.getSubject()) + " " + applyPrefixes(stmt.getPredicate()) + " " + applyPrefixes(stmt.getObject()) + " " + applyPrefixes(stmt.getNamedGraphUri());
    }

    private static final String curieTypeFormat = "\"\"\"{0}\"\"\"^^{1}";

    String applyPrefixes(Value val) {
        if (val instanceof URI) {
            CURIE curie = getCURIE(val.toString());
            if (curie == null) {
                return val.toString();
            } else {
                return curie.toString();
            }

        } else if (val instanceof TypedLiteral) {
            String label = ((TypedLiteral) val).getLabel();
            URI datatype = ((TypedLiteral) val).getDatatypeURI();

            if (isCURIE(datatype.toString())) {
                return MessageFormat.format(curieTypeFormat, label, applyPrefixes(datatype));
            } else {
                return val.toString();
            }
        } else {
            return val.toString();
        }
    }

    private static boolean isUsed(String prefix, String[] sortedNodes, int length) {
        int low = Arrays.binarySearch(sortedNodes, prefix + (char) 0);
        int high = Arrays.binarySearch(sortedNodes, prefix + Character.MAX_VALUE);
        if (low < 0 && low == high)
            return false;
        return true;
    }

    /*
    private static class PrefixCollector extends StatementCollector {
        Map<String, String> prefixes = new HashMap<String, String>();

        @Override
        void handleNamespace(String prefix, String uri) throws AnzoException {
            prefixes.put(prefix, uri);
        }

        Map<String, String> getPrefixes() {
            return prefixes;
        }
    }
    */

    private static void stripCommonSchemesFromPrefix(IConsole consoleWriter, Map<String, String> prefixes) {
        Set<String> toRemove = new HashSet<String>();
        for (String key : prefixes.keySet()) {
            if (commonUriSchemeSet.contains(key)) {
                toRemove.add(key);
            }
        }
        for (String key : toRemove) {
            prefixes.remove(key);
            consoleWriter.writeError("Warning, ignoring common uri scheme prefix: " + key);
        }
    }

    static class URINotCURIEOrKnownScheme extends URISyntaxException {

        private static final long serialVersionUID = 1L;

        URINotCURIEOrKnownScheme(String input, String reason) {
            super(input, reason);
        }

    }

    public void writeOutput(String output) {
        if (consoleWriter != null) {
            consoleWriter.writeOutput(output);
        } else {
            CommandLineInterface.DEFAULT_CONSOLE.writeOutput(output);
        }
    }

    public void writeError(String error) {
        if (consoleWriter != null) {
            consoleWriter.writeError(error);
        } else {
            CommandLineInterface.DEFAULT_CONSOLE.writeError(error);
        }
    }

    public void beep() {
        if (consoleWriter != null) {
            consoleWriter.beep();
        } else {
            CommandLineInterface.DEFAULT_CONSOLE.beep();
        }
    }

    public String readString(String prompt, boolean masked) throws IOException {
        if (consoleWriter != null) {
            return consoleWriter.readString(prompt, masked);
        } else {
            return CommandLineInterface.DEFAULT_CONSOLE.readString(prompt, masked);
        }
    }
}
