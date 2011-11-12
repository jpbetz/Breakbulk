/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/JastorGenerator.java,v $
 * Created by:
 * Created on:  01/23/2007
 * Revision:	$Id: JastorGenerator.java 172 2007-07-31 14:22:23Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.jastor.inference.Ontology;
import org.openanzo.rdf.jastor.inference.OntologyClass;
import org.openanzo.rdf.jastor.jet.OntologyClassTemplate;
import org.openanzo.rdf.jastor.jet.OntologyTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For a given JastorContext, generate code for the elements within the ontology
 * 
 * @author Ben Szekely ( <a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com </a>)
 * 
 */
public class JastorGenerator {
    private static final Logger log = LoggerFactory.getLogger(JastorGenerator.class);

    final private File          outputDir;

    final private JastorContext ctx;

    /**
     * Create a new JastorGenerator for the given context
     * 
     * @param outputDir
     *            directory where generated files should be saved
     * @param ctx
     *            context
     */
    public JastorGenerator(File outputDir, JastorContext ctx) {
        this.ctx = ctx;
        this.outputDir = outputDir;
    }

    /**
     * Run the generatrion of code
     * 
     * @throws JastorException
     */
    public void run() throws JastorException {
        try {
            ctx.finalizeContext();
            Map<String, OntologyTemplate> map = ctx.getOntologyTemplates();
            for (Entry<String, OntologyTemplate> entry : map.entrySet()) {
                for (Ontology ont : ctx.listOntologiesToGenerate()) {
                    log.info(LogUtils.GLITTER_MARKER, "Generating " + entry.getKey() + " : " + ont.getURI());
                    String genstr = entry.getValue().generate(ont);
                    File genfile = entry.getValue().getFileProvider().getFile(ont, outputDir);
                    genfile.getParentFile().mkdirs();
                    Writer out = null;
                    try {
                        out = new OutputStreamWriter(new FileOutputStream(genfile), "UTF-8");
                        out.write(genstr);
                        out.flush();
                    } finally {
                        if (out != null)
                            out.close();
                    }
                }
            }
            Map<String, OntologyClassTemplate> map2 = ctx.getOntologyClassTemplates();
            for (Entry<String, OntologyClassTemplate> entry : map2.entrySet()) {
                for (OntologyClass ont : ctx.listOntologyClassesToGenerate()) {
                    log.info(LogUtils.GLITTER_MARKER, "Generating " + entry.getKey() + " : " + ont.getURI());
                    String genstr = entry.getValue().generate(ont);
                    File genfile = entry.getValue().getFileProvider().getFile(ont, outputDir);
                    genfile.getParentFile().mkdirs();
                    Writer out = null;
                    try {
                        out = new OutputStreamWriter(new FileOutputStream(genfile), "UTF-8");
                        out.write(genstr);
                        out.flush();
                    } finally {
                        if (out != null)
                            out.close();
                    }
                }
            }
        } catch (IOException e) {
            throw new JastorException(e, "IO Error generating code");
        }
    }
}
