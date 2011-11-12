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
public class GenerateCollectionsClasses {

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
        jc.addOntologyToGenerate(ReadWriteUtils.createSmartFileReader("../org.openanzo.rdf/ontologies/collections.owl"), "RDF/XML", "http://openanzo.org/ontologies/Collections", "org.openanzo.rdf.jastor.collections");
        JastorGenerator jg = new JastorGenerator(new File("../org.openanzo.rdf/src/main/java"), jc);
        jg.run();
    }
}
