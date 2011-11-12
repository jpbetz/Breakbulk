/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.utils.ReadWriteUtils;

/**
 * Test class to convert trig to json
 * 
 */
public class TrigToJson {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        InputStream in = TrigToJson.class.getResourceAsStream("initialize.trig");

        String input = IOUtils.toString(in);
        Collection<Statement> statements = ReadWriteUtils.readStatements(input, RDFFormat.TRIG);

        Writer writer = new OutputStreamWriter(new FileOutputStream("initialize.json"), "UTF-8");
        ReadWriteUtils.writeStatements(statements, writer, RDFFormat.JSON);
        writer.flush();
        writer.close();

    }

}
