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
package org.openanzo.rdf.jastor.test.tests;

import java.io.Reader;

import junit.framework.TestCase;

import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.inference.OntologyClass;
import org.openanzo.rdf.owl.Class;
import org.openanzo.rdf.owl.OWL11Factory;
import org.openanzo.rdf.utils.ReadWriteUtils;

/**
 * RDF RDFS Test
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class RDFRDFSTest extends TestCase {
    /**
     * Test RDF RDFS
     * 
     * @throws Exception
     */
    public void testRdfRdfs() throws Exception {
        JastorContext ctx = new JastorContext();

        Reader rdfsFileIn = ReadWriteUtils.createSmartFileReader("src/test/resources/owls-11/rdf.owl");

        String uri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";

        ctx.addOntologyToGenerate(rdfsFileIn, JastorContext.ONT_LANG_RDFS, null, uri, "org.openanzo.rdf.jastor.rdfs.test.rdf");
        ctx.setUseStrictTypeChecking(true);
        ctx.finalizeContext();

        INamedGraph gm = ctx.getOntGraph();
        Class ontclass = OWL11Factory.getClass(uri + "List", gm);
        new OntologyClass(ontclass, ctx);
    }
}
