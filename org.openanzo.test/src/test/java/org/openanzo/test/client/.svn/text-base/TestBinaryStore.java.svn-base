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
package org.openanzo.test.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.BinaryStoreClient;
import org.openanzo.client.IBinaryStoreItemProgressListener;
import org.openanzo.client.BinaryStoreClient.BinaryStoreItem;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.Value;
import org.openanzo.test.AbstractTest;

/**
 * Test the binary store
 */
public class TestBinaryStore extends AbstractTest {
    /** Base URI for binary store server */
    public static final String binstoreServerBaseUri;

    static {
        String env = System.getProperty(AbstractTest.TEST_ENVIRONMENT_PROPERTY);
        int httpPort = 80;
        if (env != null && env.equals(REGRESSION)) {
            httpPort = 8082;
        } else {
            httpPort = 80;
        }
        binstoreServerBaseUri = "http://localhost:" + httpPort + "/binarystore";
    }

    /**
     * Test uploading a file
     * 
     * @throws Exception
     */
    public void testUploadFile() throws Exception {
        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            //            client = new AnzoClient(getSystemClientConfiguration());
            client.connect();

            //client.reset(loadStatements("initialize.trig"));
            BinaryStoreClient bsc = new BinaryStoreClient(binstoreServerBaseUri, client);
            BinaryStoreItem bsi = bsc.addItem(true);
            bsi.registerProgressListener(new IBinaryStoreItemProgressListener() {

                public void progress(Value job, long jobCompleted, long jobComplete, Collection<Statement> additionalStatements) {
                    //System.out.println(job.toString() + " " + jobCompleted + ":" + jobComplete);

                }

            });
            String contents = "This is a test file for the binary store.";
            File tmp = File.createTempFile("test", null);
            writeFile(tmp, "utf-8", contents);

            bsi.updateFromFile(tmp);

            File tmp2 = File.createTempFile("test2", null);
            bsi.downloadToFile(tmp2.getAbsolutePath(), Long.valueOf(0));

            StringBuffer buf = readFile(tmp2, "utf-8");
            assertEquals(contents, buf.toString());
            tmp.deleteOnExit();
            tmp2.deleteOnExit();
            InputStream stream = bsi.downloadToStream(Long.valueOf(0));
            byte[] data = IOUtils.toByteArray(stream);
            assertEquals(contents, new String(data));

        } finally {
            if (client != null) {
                client.close();
            }
        }

    }

    private static void writeFile(File f, String encoding, String fileContents) throws IOException {
        OutputStreamWriter outWriter;
        if (encoding != null) {
            outWriter = new OutputStreamWriter(new FileOutputStream(f), encoding);
        } else {
            outWriter = new OutputStreamWriter(new FileOutputStream(f));
        }

        BufferedWriter os = new BufferedWriter(outWriter);
        try {
            os.write(fileContents);
        } finally {
            os.close();
        }

    }

    private static StringBuffer readFile(File file, String encoding) throws IOException {
        Reader reader = new InputStreamReader(new FileInputStream(file), encoding);

        String lineSeparator = System.getProperty("line.separator");
        BufferedReader input = null;
        try {
            input = new BufferedReader(reader);
            StringBuffer stringBuffer = new StringBuffer();
            String line = input.readLine();

            // Byte Order Mark (BOM) - The Unicode Standard, version 3.0, page 324
            // http://www.unicode.org/faq/utf_bom.html

            // Note that when we use utf-8, the BOM should appear as "EF BB BF", but it doesn't due to this bug in the JDK:
            // http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4508058
            if ((line != null) && (line.length() > 0) && (line.charAt(0) == 0xfeff)) {
                // Eat the BOM, since we've already found the encoding on this file,
                // and we plan to concatenating this buffer with others; the BOM should
                // only appear at the top of a file.
                line = line.substring(1);
            }
            while (line != null) {
                stringBuffer.append(line);
                line = input.readLine();
                if (line != null)
                    stringBuffer.append(lineSeparator);
            }
            //Make sure we return a JavaScript string and not a Java string.
            return stringBuffer; //String
        } finally {
            if (input != null)
                input.close();
        }
    }
}
