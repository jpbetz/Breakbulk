/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/builders/Attic/GenerateJastorClasses.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: GenerateJastorOwlClasses.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.builders;

import java.io.File;

import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.JastorGenerator;
import org.openanzo.rdf.utils.ReadWriteUtils;

/**
 * Generate the Jastor OWL jastor beans. These beans are INamedGraph based.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class GenerateJastorOwlClasses {

    /**
     * Generate the jastor beans
     * 
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        JastorContext jc = new JastorContext();
        jc.setGenerateCacheInFactory(false);
        jc.setGenerateListeners(false);
        jc.setGenerateStandardCode(true);
        jc.setNamespaceRemapper("http://www.w3.org/owl10#", "http://www.w3.org/2002/07/owl#");
        jc.setNamespaceRemapper("http://RDFS#", "http://www.w3.org/2000/01/rdf-schema#");
        jc.setNamespaceRemapper("http://RDF#", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        jc.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("./ontologies/rdfs.owl"), "RDF/XML", "http://www.w3.org/2000/01/rdf-schema#RDFS", "org.openanzo.rdf.rdfs");
        jc.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("./ontologies/owl_1_1.owl"), "RDF/XML", "http://www.w3.org/2002/07/owl#OWL11", "org.openanzo.rdf.owl");
        JastorGenerator jg = new JastorGenerator(new File("./src/main/java"), jc);
        jg.run();
    }
}
