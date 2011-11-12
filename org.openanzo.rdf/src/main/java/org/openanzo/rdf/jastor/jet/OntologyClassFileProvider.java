/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/jet/OntologyClassFileProvider.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: OntologyClassFileProvider.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     C Semantics Incorporated - Fork to Anzo
 *******************************************************************************/

package org.openanzo.rdf.jastor.jet;

import java.io.File;

import org.openanzo.rdf.jastor.inference.OntologyClass;

/**
 * 
 * @author Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 * 
 */
public interface OntologyClassFileProvider {
    /**
     * Get file
     * 
     * @param oc
     *            ontology class
     * @param outputDir
     *            output directory
     * @return File to generate
     */
    public File getFile(OntologyClass oc, File outputDir);

}
