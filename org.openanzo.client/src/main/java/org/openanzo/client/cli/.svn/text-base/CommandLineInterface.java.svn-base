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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarFile;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.lang.ArrayUtils;
import org.openanzo.client.AnzoTrustManager;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.URI;
import org.openanzo.services.UpdateServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command line interface for anzo.java.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class CommandLineInterface {

    private static final Logger  log                = LoggerFactory.getLogger(CommandLineInterface.class);

    static final URI             CLIConfigURI       = Constants.valueFactory.createURI("http://openanzo.org/cli/config");

    // some defaults
    static final String          DEFAULT_HOST       = "localhost";

    static final String          DEFAULT_PORT       = "61616";

    static final String          DEFAULT_SSL_PORT   = "61617";

    // some defaults
    static final boolean         DEFAULT_USE_SSL    = false;

    static final String          DEFAULT_RDF_FORMAT = "trig";

    // global options
    private static final Option  HOST_OPTION        = new Option("h", "host", true, "anzo server hostname");

    private static final Option  PORT_OPTION        = new Option("p", "port", true, "anzo server port");

    private static final Option  USER_OPTION        = new Option("u", "user", true, "username to connect with");

    private static final Option  PASSWORD_OPTION    = new Option("w", "password", true, "user's password");

    private static final Option  SETTINGS_OPTION    = new Option("z", "settings", true, "override the default settings file location");

    private static final Option  TIMEOUT_OPTION     = new Option("t", "timeout", true, "override the default 30 second timeout for operations");

    public static DefaultConsole DEFAULT_CONSOLE    = new DefaultConsole();
    static {
        HOST_OPTION.setArgName("hostname");
        PORT_OPTION.setArgName("int");
        USER_OPTION.setArgName("string");
        PASSWORD_OPTION.setArgName("string");
        SETTINGS_OPTION.setArgName("file");
        TIMEOUT_OPTION.setArgName("timeout");
    }

    private static final Option  NO_PREFIXES_OPTION = new Option("x", "exclude-prefixes", false, "Do not use prefixes defined in user settings to expand options, arguments, or to write RDF.");

    private static final Option  USE_SSL_OPTION     = new Option("ssl", "use-ssl", false, "Use SSL for connection.");

    private static final Option  SHOW_TRACE_OPTION  = new Option("trace", "show-trace", false, "Show stack trace for errors.");

    private static final Option  PAUSE_EXIT_OPTION  = new Option("pause", "pause-exit", false, "Wait for a user key entry before an abnormal exit.");

    private static final Option  TRUST_OPTION       = new Option("trust", "trust-all", false, "Trust all certificates including invalid ones");

    private static final Option  BEEP_OPTION        = new Option("beep", "beep", false, "beep when command is completed");

    /**
     * Add default options to options
     * 
     * @param options
     *            options to augment
     */
    public static void appendGlobalOptions(Options options) {
        options.addOption(HOST_OPTION);
        options.addOption(PORT_OPTION);
        options.addOption(USER_OPTION);
        options.addOption(PASSWORD_OPTION);
        options.addOption(SETTINGS_OPTION);
        options.addOption(TIMEOUT_OPTION);

        options.addOption(NO_PREFIXES_OPTION);
        options.addOption(USE_SSL_OPTION);
        options.addOption(SHOW_TRACE_OPTION);
        options.addOption(PAUSE_EXIT_OPTION);
        options.addOption(TRUST_OPTION);
        options.addOption(BEEP_OPTION);
    }

    public static Options getGlobalOptions() {
        Options options = new Options();
        appendGlobalOptions(options);
        return options;
    }

    // sub commands
    static final List<SubCommand> subcommands = new ArrayList<SubCommand>();
    static {
        // retrieval and storage
        subcommands.add(new GetCommand());
        subcommands.add(new FindCommand());
        subcommands.add(new CreateCommand());
        subcommands.add(new UpdateCommand());
        subcommands.add(new ImportCommand());
        subcommands.add(new ReplaceCommand());
        subcommands.add(new RemoveCommand());

        // reset and dump (backup and restore?)
        subcommands.add(new ResetCommand());
        // dump: glitter can query for all data, need more?

        // query
        subcommands.add(new QueryCommand());

        // services and notification
        subcommands.add(new WatchCommand());
        subcommands.add(new CallCommand());

        // simple rdf manipulation
        subcommands.add(new ExpandCommand());
        subcommands.add(new CollapseCommand());
        subcommands.add(new ConvertCommand());
        subcommands.add(new UnionCommand());
        //subcommands.add(new DiffCommand());

        // logging and analysis
        subcommands.add(new PlayCommand());
        subcommands.add(new AnalyzeCommand());

        // jastor
        subcommands.add(new GenCommand());
    }

    /**
     * Run the Anzo command line interface
     * 
     * @param arguments
     * @throws Exception
     */
    public static void main(String[] arguments) throws Exception {
        if (arguments.length < 1) {
            String header = generateVersionHeader();
            System.out.println(header);
            System.out.println("Type anzo help for usage");
            System.exit(1);
        }
        int result = 0;
        result = processCommand(null, true, arguments);
        System.exit(result);
    }

    /**
     * 
     * @return
     */
    public static String generateVersionHeader() {
        StringBuilder str = new StringBuilder("Anzo Command Line Client. \nCopyright (c) 2009 Cambridge Semantics Inc and others.\nAll rights reserved.");
        String version;
        try {
            version = determineVersion();
        } catch (URISyntaxException e) {
            log.debug("Error obtaining version", e);
            version = null;
        } catch (IOException e) {
            log.debug("Error obtaining version", e);
            version = null;
        }
        str.append("\nVersion: ");
        str.append((version == null) ? "Unknown" : version);
        return str.toString();
    }

    private static String determineVersion() throws URISyntaxException, IOException {
        String version = null;
        if (CommandLineInterface.class.getProtectionDomain() != null && CommandLineInterface.class.getProtectionDomain().getCodeSource() != null && CommandLineInterface.class.getProtectionDomain().getCodeSource().getLocation() != null) {
            ProtectionDomain domain = CommandLineInterface.class.getProtectionDomain();
            CodeSource source = domain.getCodeSource();
            URL location = source.getLocation();
            if (location != null) {
                File file = new File(location.toURI());
                if (file.exists()) {
                    JarFile jar = new JarFile(file);
                    version = jar.getManifest().getMainAttributes().getValue("Bundle-Version");
                    if (version == null) {
                        version = jar.getManifest().getMainAttributes().getValue("Implementation-Build");
                    }
                }
            }
        }
        if (version == null) {
            version = CommandLineInterface.class.getPackage().getImplementationVersion();
        }
        return version;
    }

    static CommandContext createContext(IConsole consoleWriter, CommandLine cl, Options options, String... arguments) throws AnzoException {

        String hostname = cl.getOptionValue(HOST_OPTION.getOpt());
        String port = cl.getOptionValue(PORT_OPTION.getOpt());
        String username = cl.getOptionValue(USER_OPTION.getOpt());
        String password = cl.getOptionValue(PASSWORD_OPTION.getOpt());
        boolean noPrefixes = cl.hasOption(NO_PREFIXES_OPTION.getOpt());
        Boolean useSsl = cl.hasOption(USE_SSL_OPTION.getOpt()) ? Boolean.TRUE : null;
        String settingsPath = cl.getOptionValue(SETTINGS_OPTION.getOpt());
        String timeout = cl.getOptionValue(TIMEOUT_OPTION.getOpt());
        boolean showTrace = cl.hasOption(SHOW_TRACE_OPTION.getOpt());

        return CommandContext.create(settingsPath, hostname, port, useSsl, username, password, timeout, noPrefixes, showTrace, consoleWriter);

    }

    static int processCommand(CommandContext context, boolean exitOnException, String... arguments) {
        IConsole cw = context != null ? context.getConsoleWriter() : null;
        if (cw == null) {
            cw = DEFAULT_CONSOLE;
        }
        boolean beep = false;
        String subcommand = arguments[0];
        try {
            for (SubCommand sc : subcommands) {
                if (sc.getName().equals(subcommand)) {
                    boolean showStackTrace = false;
                    boolean pauseOnExit = false;
                    try {
                        Options options = sc.getOptions();
                        appendGlobalOptions(options);
                        CommandLineParser parser = new PosixParser();
                        String[] subcommandArgs = (String[]) ArrayUtils.subarray(arguments, 1, arguments.length);
                        CommandLine cl = parser.parse(options, subcommandArgs);

                        pauseOnExit = cl.hasOption(PAUSE_EXIT_OPTION.getOpt());
                        if (context == null) {
                            context = createContext(DEFAULT_CONSOLE, cl, options, arguments);
                        }

                        // set up the trust manager
                        boolean trustAll = cl.hasOption(TRUST_OPTION.getOpt());
                        showStackTrace = cl.hasOption(SHOW_TRACE_OPTION.getOpt());
                        beep = cl.hasOption(BEEP_OPTION.getOpt());
                        TrustManager[] myTMs = new TrustManager[] { new AnzoTrustManager(trustAll, showStackTrace) };
                        SSLContext ctx = SSLContext.getInstance("TLS");
                        ctx.init(null, myTMs, new java.security.SecureRandom());
                        SSLContext.setDefault(ctx);

                        return sc.invoke(cl, context, context.getAnzoClient());
                    } catch (ParseException e) {
                        cw.writeError("error: ");
                        cw.printException(e, showStackTrace);
                        HelpFormatter formatter = new HelpFormatter();
                        formatter.printHelp("anzo", sc.getOptions());
                        if (exitOnException)
                            exitOnError(1, pauseOnExit);
                    } catch (InvalidArgumentException e) {
                        cw.printException(e, showStackTrace);
                        sc.printHelp(cw);
                        if (exitOnException)
                            exitOnError(1, pauseOnExit);
                    } catch (CommandException ae) {
                        if (ae.getCause() != null && ae.getCause() instanceof AnzoException) {
                            if (((AnzoException) ae.getCause()).getErrorCode() == ExceptionConstants.COMBUS.JMS_CONNECT_FAILED) {
                                cw.writeError("Connection failed.");
                            }
                        }
                        cw.printException(ae, showStackTrace);
                        if (exitOnException)
                            exitOnError(1, pauseOnExit);
                    } catch (UpdateServerException e) {
                        cw.writeError(e.getUserMessage());
                        for (List<AnzoException> exceptions : e.getErrors()) {
                            if (exceptions != null) {
                                for (AnzoException ae : exceptions) {
                                    if (ae.getErrorCode() == ExceptionConstants.COMBUS.JMS_CONNECT_FAILED)
                                        cw.writeError("Connection failed.");
                                    cw.printException(ae, showStackTrace);
                                }
                            }
                        }
                        if (exitOnException)
                            exitOnError(1, pauseOnExit);
                    } catch (AnzoException e) {
                        if (e.getErrorCode() == ExceptionConstants.COMBUS.JMS_CONNECT_FAILED)
                            cw.writeError("Connection failed.");
                        cw.printException(e, showStackTrace);
                        if (exitOnException)
                            exitOnError(1, pauseOnExit);
                    } catch (AnzoRuntimeException e) {
                        cw.printException(e, showStackTrace);
                        sc.printHelp(cw);
                        if (exitOnException)
                            exitOnError(1, pauseOnExit);
                    } catch (NoSuchAlgorithmException e) {
                        cw.writeError("Error with ssl:");
                        cw.printException(e, showStackTrace);
                        if (exitOnException)
                            exitOnError(1, pauseOnExit);
                    } catch (KeyManagementException e) {
                        cw.writeError("Error with ssl:");
                        cw.printException(e, showStackTrace);
                        if (exitOnException)
                            exitOnError(1, pauseOnExit);
                    }
                }
            }

            if (subcommand.startsWith("-")) {
                cw.writeError("Option not allowed before subcommand: " + subcommand);
            } else if (subcommand.equals("help")) {
                if (arguments.length < 2) {
                    printHelp(cw);
                } else {
                    String helpSubcommand = arguments[1];
                    for (SubCommand sc : subcommands) {
                        if (sc.getName().equals(helpSubcommand)) {
                            sc.printHelp(cw);
                            return 0;
                        }
                    }
                    cw.writeError("unrecognized subcommand: " + helpSubcommand);
                }
            } else {
                cw.writeError("unrecognized subcommand: " + subcommand);
            }
        } finally {
            if (cw != null && beep) {
                cw.beep();
            }
        }
        return 0;
    }

    /**
     * If the PAUSE flag is set then the user must press enter before the program will exit
     * 
     * @param errCode
     *            The errCode is the exit code for the program, 0 is normal and 1 is abnormal
     * @param pauseOnExit
     *            If this is true then the user must press enter before the program will exit
     */
    private static void exitOnError(int errCode, boolean pauseOnExit) {
        if (pauseOnExit) {
            try {
                System.err.println("Press enter to exit");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                in.read();
                in.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(errCode);
            }
        }
        System.exit(errCode);
    }

    /*
     * Returns true if there is a javax.net.ssl.SSLException in the cause chain of the AnzoException argument.
     * 
     * @param ae
     * @return
     
    private static boolean isSSLFailure(AnzoException ae) {
        Throwable exception = ae;

        while (exception != null) {
            if (exception instanceof javax.net.ssl.SSLException)
                return true;
            if (exception == exception.getCause()) // prevents a possible infinite loop
                return false;
            exception = exception.getCause();
        }
        return false;
    }*/

    static void printHelp(IConsole consoleWriter) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.setOptPrefix("");
        String syntax = "anzo <subcommand> [options] [args]";
        String header = generateVersionHeader();
        header += "\n\nType 'anzo help <subcommand>' for help with a specific subcommand.";
        header += "\n\nAvailable subcommands:";

        String footer = "URI arguments to commands may either be fully qualified URIs (\"http://...\") or prefixed URIs (\"dc:title\"). ";
        footer += "The prefix mapping is defined in the users settings file.";
        footer += "\n\nUser settings are loaded from a user's \"~/.anzo/settings.trig\" file.";
        footer += "\n\nRDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        footer += "See documentation for details.";
        Options options = new Options();

        for (SubCommand command : subcommands) {
            options.addOption(new Option(command.getName(), ""));
        }

        formatter.printHelp(syntax, header, options, footer);
    }

    static String getRDFFormats() {
        StringBuilder builder = new StringBuilder();
        for (RDFFormat format : RDFFormat.values()) {
            builder.append("'" + Arrays.toString(format.getFileExtensions()) + "' (" + format.name() + ")");
            builder.append(" ");
        }
        return builder.toString();
    }

    static String getRDFFormatOptionsString() {
        return getRDFFormats() + ". Filename arguments default to the file format matching their filename extension.  STDIN and STDOUT default to '" + DEFAULT_RDF_FORMAT + "'.";
    }

}
