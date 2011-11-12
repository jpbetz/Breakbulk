/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.rdf.jastor.test.builders;

import java.io.File;

import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.JastorGenerator;
import org.openanzo.rdf.utils.ReadWriteUtils;

/**
 * Generate ski ontology
 */
public class GenerateSkiOntology {
    /**
     * Generate ski ontology
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        JastorContext ctx = new JastorContext();
        ctx.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("src/test/resources/ski.owl"), "http://org.openanzo.rdf.jastor/testonts/Ski", "org.openanzo.rdf.jastor.test.ski");
        ctx.setUseStrictTypeChecking(true);
        JastorGenerator gen = new JastorGenerator(new File("src/test/java").getCanonicalFile(), ctx);
        gen.run();
    }
}
