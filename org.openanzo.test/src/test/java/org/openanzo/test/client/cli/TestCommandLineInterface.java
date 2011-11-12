/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.test.client.cli;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.cli.CommandLineInterface;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SmartEncodingInputStream;
import org.openanzo.test.AbstractTest;

/**
 * Tests the command line interface commands against a live repository.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class TestCommandLineInterface extends AbstractTest {
    // directory containing test data
    static final String PATH = "../org.openanzo.test/src/test/resources/org/openanzo/test/client/cli";

    // select a CLI user settings file for the appropriate environment
    static String       SETTINGS;
    static {
        String env = System.getProperty(TEST_ENVIRONMENT_PROPERTY);
        if (env != null && env.equals(REGRESSION)) {
            SETTINGS = PATH + "/settings-regress.trig";
        } else {
            SETTINGS = PATH + "/settings.trig";
        }
    }

    static String       SETTINGS_LDAP;
    static {
        String env = System.getProperty(TEST_ENVIRONMENT_PROPERTY);
        if (env != null && env.equals(REGRESSION)) {
            SETTINGS_LDAP = PATH + "/settings-ldap-regress.trig";
        } else {
            SETTINGS_LDAP = PATH + "/settings-ldap.trig";
        }
    }

    /**
     * Verify RDF sent to STDIN can be converted to RDF and sent to STDOUT.
     * 
     * @throws Exception
     */
    public void testConvertStdin() throws Exception {
        verifyTextOutput("convert -z " + SETTINGS + " -x -o rdf", "convert-input.trig", "convert-output.rdf");
    }

    /**
     * Verify RDF in a file can be read and sent to STDOUT.
     * 
     * @throws Exception
     */
    public void testConvertFile() throws Exception {
        verifyOutput("convert -z " + SETTINGS + " -x -o trix " + PATH + "/convert-file-input.trig", null, "convert-file-output.trix", RDFFormat.TRIX);
    }

    /**
     * Verify RDF in a file can converted to a TriX file correctly.
     * 
     * @throws Exception
     */
    public void testConvertTurtleFile() throws Exception {
        verifyOutput("convert -z " + SETTINGS + " -x -g clitest:g2 -o trix " + PATH + "/convert-turtle-file-input.ttl", null, "convert-file-output.trix", RDFFormat.TRIX);
    }

    /**
     * Verify that an input file format without support for named graphs can be converted without having to specify a default graph URI. See
     * http://www.openanzo.org/projects/openanzo/ticket/566
     * 
     * @throws Exception
     */
    public void testConvertNoDefaultGraph() throws Exception {
        verifyOutput("convert -z " + SETTINGS + " -x -o nt " + PATH + "/convert-nograph-input.rdf", null, "convert-nograph-output.nt", RDFFormat.NTRIPLES);
    }

    /**
     * Verify that both CURIEs and URIs are collapsed only if they are in the prefix map
     * 
     * @throws Exception
     */
    public void testCollapse() throws Exception {
        verifyTextOutput("collapse -z " + SETTINGS + " http://cambridgesemantics.com/cli-tests#a clitest:b http://cambridgesemantics.com/unprefixed#a invalid:prefix", null, "collapse-output.txt");
    }

    /**
     * Verify that both CURIEs and URIs are collapsed only if they are in the prefix map
     * 
     * @throws Exception
     */
    public void testExpand() throws Exception {
        verifyTextOutput("expand -z " + SETTINGS + " http://cambridgesemantics.com/cli-tests#a clitest:b http://cambridgesemantics.com/unprefixed#a invalid:prefix", null, "expand-output.txt");
    }

    /**
     * Verify that we warn the user about common schemes
     * 
     * @throws Exception
     */
    public void testWarnCommonSchemes() throws Exception {
        verifyTextOutput("expand -z " + SETTINGS_LDAP + " ldap:foo", null, "warn-output.txt", "warn-error.txt");
    }

    /**
     * Verify that RDF can be read from STDIN and can be sent to the repository to create a graph.
     * 
     * Also test a expanded URI input
     * 
     * @throws Exception
     */
    public void testCreateStdin() throws Exception {
        reset();
        verifySuccessStatus("create -z " + SETTINGS + " ", "create-stdin-input.trig");
        verifyOutput("get -z " + SETTINGS + " http://cambridgesemantics.com/cli-tests#create", null, "create-stdin-output.trig", RDFFormat.TRIG);
    }

    /**
     * Verify that RDF can be read from a Turtle file and be sent to the repository to create a graph. Since Turtle does not support named graphs, a named graph
     * uri is provided on the command line.
     * 
     * @throws Exception
     */
    public void testCreateFile() throws Exception {
        reset();
        verifySuccessStatus("create -z " + SETTINGS + " -g clitest:create-file " + PATH + "/create-file-input.ttl", null);
        verifyOutput("get -z " + SETTINGS + " clitest:create-file", null, "create-file-output.trig", RDFFormat.TRIG);
    }

    /**
     * Verify that a file containing relative URIs is imported correctly when the base option is set.
     * 
     * @throws Exception
     */
    public void testImportWithBase() throws Exception {
        reset();
        verifySuccessStatus("import -z " + SETTINGS + " --base http://cambridgesemantics.com/base/ " + PATH + "/import-with-base-input.trig", null);
        verifyOutput("get -z " + SETTINGS + " clitest:import", null, "import-with-base-output.trig", RDFFormat.TRIG);
    }

    /**
     * Verify that a replace command can be executed using rdf provided via STDIN.
     * 
     * @throws Exception
     */
    public void testReplaceStdin() throws Exception {
        reset();
        verifySuccessStatus("create -z " + SETTINGS + " -g clitest:create-file " + PATH + "/create-file-input.ttl", null);
        verifySuccessStatus("replace -z " + SETTINGS + " " + PATH + "/replace-stdin-input.trig", null);
        verifyOutput("get -z " + SETTINGS + " clitest:create-file", null, "replace-stdin-input.trig", RDFFormat.TRIG);
    }

    /**
     * Verify that a replace command can be executed using rdf from a file.
     * 
     * Include bnodes in initial create to verify they are handled properly.
     * 
     * See openanzo ticket #358
     * 
     * @throws Exception
     */
    public void testReplaceFile() throws Exception {
        reset();
        verifySuccessStatus("create -z " + SETTINGS + " " + PATH + "/replace-file-initial.trig", null);
        verifySuccessStatus("replace -z " + SETTINGS + " " + PATH + "/replace-stdin-input.trig", null);
        verifyOutput("get -z " + SETTINGS + " clitest:create-file", null, "replace-stdin-input.trig", RDFFormat.TRIG);
    }

    /**
     * Verify that an error is thrown if a replace call is attempted on a graph that does not exist.
     * 
     * @throws Exception
     */
    public void testIllegalReplaceFile() throws Exception {
        reset();
        verifyFailureStatus("replace -z " + SETTINGS, "replace-stdin-input.trig");
    }

    /**
     * Verify that the '-f' flag will force a graph to be created if it does not exist.
     * 
     * @throws Exception
     */
    public void testForceReplaceFile() throws Exception {
        reset();
        verifySuccessStatus("replace -z " + SETTINGS + " -f", "replace-stdin-input.trig");
        verifyOutput("get -z " + SETTINGS + " clitest:create-file", null, "replace-stdin-input.trig", RDFFormat.TRIG);
    }

    /**
     * Verify that non-reserved predicates in a metadata graph can be altered by the replace command.
     * 
     * See openanzo ticket #742
     * 
     * @throws Exception
     */
    public void testReplaceMetadataGraph() throws Exception {
        reset();
        verifySuccessStatus("create -z " + SETTINGS + " " + PATH + "/replace-stdin-input.trig", null);
        verifySuccessStatus("replace -z " + SETTINGS + " " + PATH + "/replace-metadata-input.trig", null);
        verifyOutput("find -z " + SETTINGS + " -sub clitest:create-file -pred anzo:canBeReadBy", null, "replace-metadata-output.trig", RDFFormat.TRIG);
    }

    /**
     * Run a query from the arguments of the command. Also make sure the -a flag runs the query against a default graph containing all the named graphs on the
     * server.
     * 
     * @throws Exception
     */
    public void testQueryFromArguments() throws Exception {
        reset();
        verifySuccessStatus("create -z " + SETTINGS + " " + PATH + "/query-data.trig", null);
        verifyTextOutput("query -z " + SETTINGS + " -a -o srx SELECT ?o WHERE { clitest:query dc:title ?o } ", null, "query-arguments.srx");
    }

    /**
     * Run a CONSTRUCT query from a file.
     * 
     * @throws Exception
     */
    public void testQueryFromFile() throws Exception {
        reset();
        verifySuccessStatus("create  -z " + SETTINGS + " " + PATH + "/query-data.trig", null);
        verifyOutput("query -z " + SETTINGS + " -f " + PATH + "/query-from-file.rq ", null, "query-from-file.trig", RDFFormat.TRIG);
    }

    /**
     * Run a CONSTRUCT query from a file.
     * 
     * @throws Exception
     */
    public void testNonRevisionedQueryFromFile() throws Exception {
        reset();
        verifySuccessStatus("create -nr -z " + SETTINGS + " " + PATH + "/query-data.trig", null);
        verifyOutput("query -z " + SETTINGS + " -f " + PATH + "/query-from-file.rq ", null, "query-from-file.trig", RDFFormat.TRIG);
    }

    /**
     * Run a CONSTRUCT query from STDIN.
     * 
     * @throws Exception
     */
    public void testQueryFromStdin() throws Exception {
        reset();
        verifySuccessStatus("create -z " + SETTINGS + " " + PATH + "/query-data.trig", null);
        verifyOutput("query -z " + SETTINGS + " ", "query-from-file.rq", "query-from-file.trig", RDFFormat.TRIG);
    }

    /**
     * Run a CONSTRUCT query against a local file that does not support named graphs.
     * 
     * @throws Exception
     */
    public void testQueryLocalTurtleFileFromArguments() throws Exception {
        reset();
        verifyOutput("query -z " + SETTINGS + " -d " + PATH + "/query-data.trig CONSTRUCT { clitest:custom dc:title ?o } WHERE { clitest:query dc:source ?o }", null, "query-from-file.trig", RDFFormat.TRIG);
    }

    /**
     * Remove a graph and make sure it's gone.
     * 
     * @throws Exception
     */
    public void testRemove() throws Exception {
        reset();
        verifySuccessStatus("create -z " + SETTINGS + " -g clitest:create-file " + PATH + "/create-file-input.ttl", null);
        verifySuccessStatus("remove -z " + SETTINGS + " clitest:create-file", null);
        verifyCommand("get -z " + SETTINGS + " clitest:create-file", null, "empty.txt", null, true);
        //verifyTextOutput(, null, "empty.txt");
    }

    /**
     * Update a graph with a file of additions and a file of removals and verify the update is applied correctly.
     * 
     * @throws Exception
     */
    public void testUpdate() throws Exception {
        reset();

        verifySuccessStatus("create -z " + SETTINGS + " -g clitest:create-file " + PATH + "/create-file-input.ttl", null);
        verifySuccessStatus("update -z " + SETTINGS + " -a " + PATH + "/update-additions.trig -r " + PATH + "/update-removals.trig", null);
        verifyOutput("get -z " + SETTINGS + " clitest:create-file", null, "update-results.trig", RDFFormat.TRIG);
    }

    /**
     * Check that an error occurs trying to update a graph that does not exist.
     * 
     * @throws Exception
     */
    public void testIllegalUpdate() throws Exception {
        reset();
        verifyFailureStatus("update -z " + SETTINGS + " -a " + PATH + "/update-additions.trig -r " + PATH + "/update-removals.trig", null);
    }

    /**
     * Check that the '-f' flag will force a graph to be created if it does not exist.
     * 
     * @throws Exception
     */
    public void testForceUpdate() throws Exception {
        reset();
        verifySuccessStatus("update -z " + SETTINGS + " -f -a " + PATH + "/update-additions.trig", null);
        verifyOutput("get -z " + SETTINGS + " clitest:create-file", null, "update-additions.trig", RDFFormat.TRIG);
    }

    /**
     * Check that the update command does removes before adds. See http://www.openanzo.org/projects/openanzo/ticket/743
     * 
     * @throws Exception
     */
    public void testUpdateRemoveAndAddOrder() throws Exception {
        reset();
        verifySuccessStatus("update -z " + SETTINGS + " -f -a " + PATH + "/update-additions.trig -r " + PATH + "/update-additions.trig", null);
        verifyOutput("get -z " + SETTINGS + " clitest:create-file", null, "update-additions.trig", RDFFormat.TRIG);
    }

    /**
     * Check that a anzo 'dataset' graph is correctly expanded to a dataset.
     * 
     * @throws Exception
     */
    public void testExpandDataset() throws Exception {
        reset();
        verifySuccessStatus("create -z " + SETTINGS + " " + PATH + "/expand-dataset-initial.trig", null);
        verifyOutput("get --expand-dataset -z " + SETTINGS + " clitest:dataset", null, "expand-dataset-output.trig", RDFFormat.TRIG);
    }

    /**
     * Verify a simple semantic service executes correctly.
     * 
     * @throws Exception
     */
    public void testCall() throws Exception {
        verifyOutput("call -z " + SETTINGS + " echo:echo " + PATH + "/echo-request.trig", null, "echo-request.trig", RDFFormat.TRIG);
    }

    /**
     * Test union command
     * 
     * @throws Exception
     */
    public void testUnion() throws Exception {
        verifyOutput("union -z " + SETTINGS + " " + PATH + "/union-input-1.trig " + PATH + "/union-input-2.trig", null, "union-output.trig", RDFFormat.TRIG);
    }

    /**
     * Test reset command
     * 
     * @throws Exception
     */
    public void testReset() throws Exception {
        reset();
        verifySuccessStatus("create -z " + SETTINGS + " " + PATH + "/query-data.trig", null);
        verifySuccessStatus("reset -z " + SETTINGS + " " + PATH + "/reset-input.trig", null);
        verifyOutput("get -z " + SETTINGS + " clitest:query", null, "empty.txt", RDFFormat.TRIG, true);
    }

    void reset() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
        } finally {
            client.close();
        }
    }

    private void verifySuccessStatus(String command, String stdinFile) throws Exception {
        verifyCommand(command, stdinFile, null, null, false);
    }

    private void verifyFailureStatus(String command, String stdinFile) throws Exception {
        verifyCommand(command, stdinFile, null, null, true);
    }

    private void verifyTextOutput(String command, String stdinFile, String expectedStdoutFile) throws Exception {
        verifyCommand(command, stdinFile, expectedStdoutFile, null, false);
    }

    private void verifyTextOutput(String command, String stdinFile, String expectedStdoutFile, String expectedStderrFile) throws Exception {
        verifyCommand(command, stdinFile, expectedStdoutFile, expectedStderrFile, false);
    }

    /**
     * Run a command and verify it's outputs match the contents of the given files for the given filenames.
     */
    private void verifyCommand(String command, String stdinFile, String expectedStdoutFile, String expectedStderrFile, boolean expectFailure) throws Exception {
        TestCommandResult result;
        try {
            result = runCommandTest(command, stdinFile == null ? IOUtils.toInputStream("") : TestCommandLineInterface.class.getResourceAsStream(stdinFile));
        } catch (Exception t) {
            if (expectFailure)
                return;
            throw t;
        }

        if (expectFailure) {
            if (result.status == 0) {
                throw new IllegalStateException("Command Line Interface returned status code 0, expected non-zero: " + result.status);
            }
            return;
        }

        if (result.status != 0) {
            throw new IllegalStateException("Command Line Interface returned a non-zero status code (" + result.status + "), expected 0: " + result.error);
        }

        if (expectedStdoutFile != null) {
            assertEquals(IOUtils.toString(TestCommandLineInterface.class.getResourceAsStream(expectedStdoutFile)), result.output);
        }

        if (expectedStderrFile != null) {
            assertEquals(IOUtils.toString(TestCommandLineInterface.class.getResourceAsStream(expectedStderrFile)), result.error);
        }
    }

    private void verifyOutput(String command, String stdinFile, String expectedStdoutRdfFile, RDFFormat expectedFormat) throws Exception {
        verifyOutput(command, stdinFile, expectedStdoutRdfFile, expectedFormat, false);
    }

    /**
     * Run a command and verify it's RDF output matches the contents of the RDF in the expectedFile.
     */
    private void verifyOutput(String command, String stdinFile, String expectedStdoutRdfFile, RDFFormat expectedFormat, boolean expectFailure) throws Exception {
        TestCommandResult result;
        try {
            result = runCommandTest(command, stdinFile == null ? IOUtils.toInputStream("") : TestCommandLineInterface.class.getResourceAsStream(stdinFile));
        } catch (Exception t) {
            if (expectFailure)
                return;
            throw t;
        }

        if (expectFailure) {
            if (result.status == 0) {
                throw new IllegalStateException("Command Line Interface returned status code 0, expected non-zero: " + result.status);
            }
            return;
        }

        if (result.status != 0) {
            throw new IllegalStateException("Command Line Interface returned a non-zero status code (" + result.status + "), expected 0: " + result.error);
        }

        List<Statement> out = new ArrayList<Statement>(ReadWriteUtils.loadStatements(new StringReader(result.output), expectedFormat, ""));
        List<Statement> expected = new ArrayList<Statement>(ReadWriteUtils.loadStatements(SmartEncodingInputStream.createSmartReader(TestCommandLineInterface.class.getResourceAsStream(expectedStdoutRdfFile)), expectedFormat, ""));

        assertEquals(expected.size(), out.size());
        for (Statement stmt : expected) {
            int index = out.indexOf(stmt);
            assertTrue("statement missing from output" + stmt, index >= 0);
            Statement actualStmt = out.get(index);
            assertEquals(actualStmt.getNamedGraphUri(), stmt.getNamedGraphUri()); // we want exact matches, so check the named graph explicitly
        }
    }

    /**
     * Isolates a java method call to the command line interface's main method. Mock System in, out and error are put around the method call and System.exit's
     * are managed and their status captured.
     * 
     * The System out, error and exit status are returned.
     * 
     */
    private TestCommandResult runCommandTest(String command, InputStream input) throws Exception {
        InputStream defaultInput = System.in;
        PrintStream defaultOutput = System.out;
        PrintStream defaultError = System.err;
        SecurityManager defaultSecurityManager = System.getSecurityManager();

        int status = -1;
        String output = null;
        String error = null;
        try {
            System.setIn(input);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(new PrintStream(out)));

            ByteArrayOutputStream err = new ByteArrayOutputStream();
            System.setErr(new PrintStream(new PrintStream(err)));

            System.setSecurityManager(new ExitStatusManager());
            try {
                CommandLineInterface.main(command.split("\\s+"));

            } catch (ExitStatusException e) {
                status = e.getStatus();
            }

            output = out.toString("UTF-8");
            error = err.toString("UTF-8");
        } finally {
            System.setIn(defaultInput);
            System.setOut(defaultOutput);
            System.setErr(defaultError);
            System.setSecurityManager(defaultSecurityManager);
        }

        return new TestCommandResult(output, error, status);
    }

    /**
     * Tracks the output of a command invocation.
     * 
     * @author Joe Betz <jpbetz@cambridgesemantics.com>
     * 
     */
    private static class TestCommandResult {
        public String output;

        public String error;

        public int    status;

        public TestCommandResult(String output, String error, int status) {
            this.output = output;
            this.error = error;
            this.status = status;
        }
    }

    /**
     * For testing command line interface.
     * 
     * Custom security manager specifically for catching System.exit() calls and converting them into an exception which can be caught.
     * 
     * @author Joe Betz <jpbetz@cambridgesemantics.com>
     * 
     */
    private static class ExitStatusManager extends SecurityManager {

        @Override
        public void checkExit(int status) {
            throw new ExitStatusException(status);
        }

        @Override
        public void checkPermission(Permission perm) {
        }
    }

    /**
     * Exception to work with StopExitManager.
     * 
     * @author Joe Betz <jpbetz@cambridgesemantics.com>
     * 
     */
    private static class ExitStatusException extends SecurityException {
        private static final long serialVersionUID = 1L;

        int                       status;

        public ExitStatusException(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
    }

}
