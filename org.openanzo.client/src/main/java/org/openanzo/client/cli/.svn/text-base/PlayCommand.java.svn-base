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
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.lang.StringUtils;
import org.openanzo.analysis.RequestParser;
import org.openanzo.client.AnzoClient;
import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IModelService;
import org.openanzo.datasource.IQueryService;
import org.openanzo.datasource.IReplicationService;
import org.openanzo.datasource.IResetService;
import org.openanzo.datasource.IUpdateService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.utils.SmartEncodingInputStream;
import org.openanzo.services.IExecutionService;
import org.openanzo.services.INotificationRegistrationService;

/**
 * Executes a SPARQL query against the server.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
class PlayCommand extends RdfIOCommand {
    //private static final String NEWLINE_PATTERN             = "\r\n|\r|\n";

    //private static final Logger log                         = LoggerFactory.getLogger(PlayCommand.class);

    private static final Option REQUEST_INPUT_OPTION = new Option("f", "request-input", true, "Playback the requests in the given file");

    private static final Option SERVICES_OPTION      = new Option("s", "services", true, "Include only the given services (r)eplication, (q)uery, (m)odel, (a)authorization, (u)pdate,  (n)otification, rese(t)");

    private static final Option BODY_OPTION          = new Option("b", "body-pattern", true, "A simple text-match pattern to filter requests based on the body");

    //private static final Option              PROPERTY_OPTION      = new Option("r", "property-pattern", true, "A simple text-match pattern to filter request based on property values (disjunctively), example -r \"operationUri=http://cambridgesemantics.com/semanticServices/OntologyService#listClasses,jmsCorrelationId=1ef2wn8acq66me902t-10\"");
    private static final Option PROPERTY_OPTION      = new Option("r", "property-pattern", true, "A simple text-match pattern to filter request based on property values (disjunctively)");

    private static final Option CREDS_OPTION         = new Option("c", "credential-file", true, "A name=value pair file with user/passwords for requests that use a different user");

    private static final Option CSV_STATS            = new Option("v", "csv-summary", false, "Outputs a CSV version of the summary playback time statistics");

    private static final Option NUM_CLIENTS_OPTION   = new Option("n", "num-clients", true, "Peform the playback with n concurrent clients");

    private static final Option ENCODING             = new Option("e", "encoding", true, "Override the default charset for uploading RDF files.");

    static {
        REQUEST_INPUT_OPTION.setArgName("file | URI");
    }

    public String getName() {
        return "play";
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(REQUEST_INPUT_OPTION);
        options.addOption(SERVICES_OPTION);
        options.addOption(BODY_OPTION);
        options.addOption(CREDS_OPTION);
        options.addOption(PROPERTY_OPTION);
        options.addOption(CSV_STATS);
        options.addOption(NUM_CLIENTS_OPTION);
        options.addOption(ENCODING);
        return options;
    }

    public int invoke(CommandLine cl, final CommandContext context, AnzoClient client) throws AnzoException {
        try {

            Set<String> allowedDestinations = null;
            String serviceFlags = cl.getOptionValue(SERVICES_OPTION.getOpt());
            if (serviceFlags != null) {
                allowedDestinations = new HashSet<String>();
                for (int i = 0; i < serviceFlags.length(); i++) {
                    if (serviceFlags.charAt(i) == 'r') {
                        allowedDestinations.add(IReplicationService.SERVICE_NAME);
                    } else if (serviceFlags.charAt(i) == 'q') {
                        allowedDestinations.add(IQueryService.SERVICE_NAME);
                    } else if (serviceFlags.charAt(i) == 'm') {
                        allowedDestinations.add(IModelService.SERVICE_NAME);
                    } else if (serviceFlags.charAt(i) == 'a') {
                        allowedDestinations.add(IAuthorizationService.SERVICE_NAME);
                    } else if (serviceFlags.charAt(i) == 'n') {
                        allowedDestinations.add(INotificationRegistrationService.SERVICE_NAME);
                    } else if (serviceFlags.charAt(i) == 'u') {
                        allowedDestinations.add(IUpdateService.SERVICE_NAME);
                    } else if (serviceFlags.charAt(i) == 't') {
                        allowedDestinations.add(IResetService.SERVICE_NAME);
                    } else if (serviceFlags.charAt(i) == 'e') {
                        allowedDestinations.add(IExecutionService.SERVICE_NAME);
                    }
                }
            } else {
                // setup some default allowed destinations if necessary
            }
            String bodyPattern = cl.getOptionValue(BODY_OPTION.getOpt());
            String charsetName = getEncodingOption(cl, ENCODING);

            HashMap<String, String> creds = new HashMap<String, String>();
            if (cl.hasOption(CREDS_OPTION.getOpt())) {
                Reader credsInput = getRdfInputOption(context, cl, CREDS_OPTION, null, charsetName).getReader();
                BufferedReader reader = new BufferedReader(credsInput);
                try {
                    String line = reader.readLine();
                    while (line != null) {
                        String[] parts = StringUtils.split(line, '=');
                        creds.put(parts[0], parts[1]);
                        line = reader.readLine();
                    }
                } finally {
                    reader.close();
                }
            }

            HashMap<String, List<String>> propFilter = null;
            if (cl.hasOption(PROPERTY_OPTION.getOpt())) {
                propFilter = new HashMap<String, List<String>>();
                String str = cl.getOptionValue(PROPERTY_OPTION.getOpt());
                String[] filters = StringUtils.split(str, ',');
                for (int i = 0; i < filters.length; i++) {
                    String[] parts = StringUtils.split(filters[i], '=');
                    List<String> vals = propFilter.get(parts[0]);
                    if (vals == null) {
                        vals = new ArrayList<String>();
                        propFilter.put(parts[0], vals);
                    }
                    vals.add(parts[1]);
                }
            }

            int numClients = 1;

            if (cl.hasOption(NUM_CLIENTS_OPTION.getOpt())) {
                numClients = Integer.parseInt(cl.getOptionValue(NUM_CLIENTS_OPTION.getOpt()));
            }
            context.writeOutput("numClients: " + numClients);

            final RequestParser parser = new RequestParser();
            final PlaybackHandler[] handlers = new PlaybackHandler[numClients];
            creds.put(context.getUser(), context.getPassword());

            final Set<PlaybackHandler> completedHandlers = new HashSet<PlaybackHandler>();

            final Boolean[] failed = { false };
            for (int i = 0; i < numClients; i++) {
                handlers[i] = new PlaybackHandler(i, creds, context.getHost(), context.getPort(), context.getUseSsl(), context.getTimeout(), bodyPattern, allowedDestinations, propFilter);
                final int ind = i;
                Reader requestInput = null;
                if (!cl.hasOption(REQUEST_INPUT_OPTION.getOpt())) {
                    requestInput = SmartEncodingInputStream.createSmartReader(System.in);
                } else {
                    requestInput = getRdfInputOption(context, cl, REQUEST_INPUT_OPTION, null, charsetName).getReader();
                }
                final Reader finalRequestInput = requestInput;
                final boolean hasCsvOpt = cl.hasOption(CSV_STATS.getOpt());
                Runnable runner = new Runnable() {
                    public void run() {
                        System.out.println("Starting client (" + ind + ")");
                        try {
                            parser.parseRequest(finalRequestInput, handlers[ind]);
                        } catch (Exception e) {
                            context.writeError("Error parsing request:" + e.getMessage());
                            if (context.showTrace) {
                                e.printStackTrace();
                            }
                            failed[0] = true;

                        }
                        outputSummaryStatistics(handlers[ind], hasCsvOpt);
                        context.writeError("Handler completed: " + ind);
                        completedHandlers.add(handlers[ind]);
                    }
                };
                if (numClients == 1) {
                    runner.run();
                } else {
                    new Thread(runner).start();
                }
            }

            while (completedHandlers.size() != numClients) {
                context.writeError("Completed handlers: " + completedHandlers.size());
                Thread.sleep(200);
                if (failed[0]) {
                    return 1;
                }
            }

            System.out.println("All clients have completed.");
            return 0;
        } catch (Exception e) {
            throw new CommandException(e, "play");
        }
    }

    /**
     * Print out some statistics about the playback session.
     * 
     * @param handler
     *            - a handler that was already executed and has collected statistics about the playback.
     */
    private void outputSummaryStatistics(PlaybackHandler handler, boolean outputCSV) {

        long endTime = System.currentTimeMillis();

        StringBuilder csvHeaderStr = null;
        StringBuilder csvStatsStr = null;
        if (outputCSV) {
            csvHeaderStr = new StringBuilder("Total Time,Duration Sum");
            csvStatsStr = new StringBuilder("");
            csvStatsStr.append(endTime - handler.overallStartTime);
            csvStatsStr.append(",");
            csvStatsStr.append(handler.requestDurationTotal);
        }
        System.out.println("Total requests sent: " + handler.totalRequestsSent);
        System.out.println("Total time (ms): " + (endTime - handler.overallStartTime));
        System.out.println("Sum of request durations (ms): " + handler.requestDurationTotal);
        System.out.println("Total Duration By Operation in ms (with % of sum):");
        long longestOperationLength = 0;
        for (Map.Entry<String, Long> entry : handler.perOperationDurationTotals.entrySet()) {
            long len = entry.getKey().length();
            if (len > longestOperationLength) {
                longestOperationLength = len;
            }
        }
        for (Map.Entry<String, Long> entry : handler.perOperationDurationTotals.entrySet()) {
            double ratio = (double) entry.getValue() / (double) handler.requestDurationTotal;
            System.out.format("\t %-" + (longestOperationLength + 1) + "s %d (%.2f%%)\n", entry.getKey() + ":", entry.getValue(), ratio * 100.0);
            if (csvHeaderStr != null && csvStatsStr != null) {
                csvHeaderStr.append(",Duration (");
                csvHeaderStr.append(entry.getKey());
                csvHeaderStr.append("),% Duration(");
                csvHeaderStr.append(entry.getKey());
                csvHeaderStr.append(")");

                csvStatsStr.append(",");
                csvStatsStr.append(entry.getValue());
                csvStatsStr.append(",");
                csvStatsStr.append(String.format("%.4f", ratio));
            }
        }
        System.out.println("Total Requests By Operation (with % of total):");
        for (Map.Entry<String, Long> entry : handler.perOperationCounts.entrySet()) {
            double ratio = (double) entry.getValue() / (double) handler.totalRequestsSent;
            System.out.format("\t %-" + (longestOperationLength + 1) + "s %d (%.2f%%)\n", entry.getKey() + ":", entry.getValue(), ratio * 100.0);
            if (csvHeaderStr != null && csvStatsStr != null) {
                csvHeaderStr.append(",Request Count (");
                csvHeaderStr.append(entry.getKey());
                csvHeaderStr.append("),% Request Count(");
                csvHeaderStr.append(entry.getKey());
                csvHeaderStr.append(")");

                csvStatsStr.append(",");
                csvStatsStr.append(entry.getValue());
                csvStatsStr.append(",");
                csvStatsStr.append(String.format("%.4f", ratio));
            }
        }

        if (outputCSV) {
            System.out.println("CSV Summary Statistics:");
            System.out.println(csvHeaderStr);
            System.out.println(csvStatsStr);
        }

    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Playback a sequences of recorded requests specified by ";
        header += "the " + REQUEST_INPUT_OPTION.getLongOpt() + " option, if set.  If not provided, the query is read from STDIN. ";
        String syntax = "anzo play [options] [-f REQUEST-INPUT-FILE ]";
        String footer = "To include only replication and query services: anzo play -s qr request.txt";

        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
