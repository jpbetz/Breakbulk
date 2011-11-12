/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Apr 13, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client.cli;

import java.io.File;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.JarFile;

import jline.console.completer.Completer;
import jline.console.completer.NullCompleter;
import jline.console.completer.StringsCompleter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.lang.ArrayUtils;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class AnzoConsole {
    static final String    EXIT = "EXIT";

    static final String    QUIT = "QUIT";

    private CommandContext context;

    //ConsoleReader          cr;

    DefaultConsole         dcw;

    /**
     * @param args
     */
    public static void main(String... args) {
        new AnzoConsole();
    }

    AnzoConsole() {
        try {
            dcw = CommandLineInterface.DEFAULT_CONSOLE;
            if (dcw.cr != null) {
                dcw.cr.setBellEnabled(true);
                dcw.cr.setPrompt("Anzo>");
                dcw.cr.setHistoryEnabled(true);
            }
            dcw.writeOutput("Anzo Command Line Client. \nCopyright (c) 2009 Cambridge Semantics Inc and others. All rights reserved.");
            String version = null;
            if (CommandLineInterface.class.getProtectionDomain() != null && CommandLineInterface.class.getProtectionDomain().getCodeSource() != null && CommandLineInterface.class.getProtectionDomain().getCodeSource().getLocation() != null) {
                ProtectionDomain domain = CommandLineInterface.class.getProtectionDomain();
                CodeSource source = domain.getCodeSource();
                URL location = source.getLocation();
                if (location != null) {
                    File file = new File(location.toURI());
                    if (file.exists() && file.getName().toLowerCase().endsWith(".jar")) {
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
            dcw.writeOutput("Version: " + ((version == null) ? "Unknown" : version));
            dcw.writeOutput("Type help for usage");

            HashMap<String, Completer> completers = new HashMap<String, Completer>();
            completers.put("exit", new NullCompleter());
            completers.put("quit", new NullCompleter());
            completers.put("connect", new NullCompleter());
            completers.put("disconnect", new NullCompleter());
            completers.put("trace", new StringsCompleter("on", "off"));
            Options global = CommandLineInterface.getGlobalOptions();
            for (SubCommand sc : CommandLineInterface.subcommands) {
                String command = sc.getName();
                ArrayList<String> subcommands = new ArrayList<String>();
                for (Object o : sc.getOptions().getOptions()) {
                    Option options = (Option) o;
                    subcommands.add("-" + options.getOpt());
                    subcommands.add("--" + options.getLongOpt());
                }
                for (Object o : global.getOptions()) {
                    Option options = (Option) o;
                    subcommands.add("-" + options.getOpt());
                    subcommands.add("--" + options.getLongOpt());
                }
                completers.put(command, new StringsCompleter(subcommands));
            }
            if (dcw.cr != null) {
                dcw.cr.addCompleter(new CLICompleter(completers));
            }
            boolean showStackTrace = false;
            while (true) {
                String command = dcw.readLine("Anzo>");
                if (command != null) {
                    if (EXIT.toLowerCase().equals(command.trim().toLowerCase()) || QUIT.toLowerCase().equals(command.trim().toLowerCase())) {
                        if (context != null && context.client != null && context.client.isConnected()) {
                            context.client.disconnect();
                            context.client.close();
                            dcw.writeOutput("Disonnected from:" + context.host);
                        }
                        System.exit(0);
                    }
                    String arguments[] = stringToArgs(command);
                    try {
                        if (arguments.length > 0) {
                            String subcommand = arguments[0];
                            if ("connect".equals(subcommand.toLowerCase())) {
                                Options options = new Options();
                                CommandLineInterface.appendGlobalOptions(options);
                                CommandLineParser parser = new PosixParser();
                                String[] subcommandArgs = (String[]) ArrayUtils.subarray(arguments, 1, arguments.length);
                                CommandLine cl = parser.parse(options, subcommandArgs);
                                if (context == null) {
                                    context = CommandLineInterface.createContext(dcw, cl, options, arguments);
                                }
                                if (!context.client.isConnected()) {
                                    context.client.connect();
                                    dcw.writeOutput("Connected to:" + context.host);
                                }
                            } else if ("disconnect".equals(subcommand.toLowerCase())) {
                                if (context != null && context.client != null && context.client.isConnected()) {
                                    context.client.disconnect();
                                    context.client.close();
                                    dcw.writeOutput("Disonnected from:" + context.host);
                                } else {
                                    dcw.writeOutput("Not connected to:" + context.host);
                                }
                                context = null;
                            } else if ("trace".equals(subcommand.toLowerCase())) {
                                String[] subcommandArgs = (String[]) ArrayUtils.subarray(arguments, 1, arguments.length);
                                if (subcommandArgs.length == 0) {
                                    dcw.writeOutput("Show Stack Trace:" + showStackTrace);
                                } else {
                                    String flag = subcommandArgs[0];
                                    if (flag.equals("on"))
                                        showStackTrace = true;
                                    else if (flag.equals("off"))
                                        showStackTrace = false;
                                    else
                                        showStackTrace = Boolean.parseBoolean(flag);
                                }
                                if (context != null) {
                                    context.showTrace = showStackTrace;
                                }
                            } else if ("version".equals(subcommand.toLowerCase())) {
                                String header = CommandLineInterface.generateVersionHeader();
                                dcw.writeOutput(header);

                            } else {
                                CommandLineInterface.processCommand(context, false, arguments);
                            }
                        }
                    } catch (AnzoException e) {
                        if (e.getErrorCode() == ExceptionConstants.COMBUS.JMS_CONNECT_FAILED) {
                            dcw.writeError("Connection failed.");
                            if (showStackTrace)
                                dcw.printException(e, showStackTrace);
                        } else {
                            dcw.printException(e, showStackTrace);
                        }
                    } catch (AnzoRuntimeException e) {
                        dcw.printException(e, showStackTrace);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static String[] stringToArgs(String input) {
        ArrayList<String> args = new ArrayList<String>();
        if (input != null) {
            input = input.trim();
            int j = 0;
            StringBuilder sb = new StringBuilder();
            boolean inQuote = false;
            boolean startQuote = false;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ' && !inQuote) {
                    if (sb.toString().trim().length() > 0) {
                        args.add(sb.toString().trim());
                    }
                    sb = new StringBuilder();
                    j = i + 1;
                    startQuote = false;
                }
                if (input.charAt(i) == '"') {
                    if (!inQuote) {
                        inQuote = true;
                        if (i == j)
                            startQuote = true;
                    } else {
                        inQuote = false;
                        if (startQuote) {
                            if (sb.toString().trim().length() > 0) {
                                args.add(sb.toString().trim());
                            }
                            sb = new StringBuilder();
                            j = i + 1;
                            startQuote = false;
                        }
                    }
                } else {
                    sb.append(input.charAt(i));
                }
            }
            if (sb.toString().trim().length() > 0) {
                args.add(sb.toString().trim());
            }
        }
        return args.toArray(new String[0]);
    }
}
