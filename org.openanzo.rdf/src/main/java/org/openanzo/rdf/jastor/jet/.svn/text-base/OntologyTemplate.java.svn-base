/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/jet/OntologyTemplate.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: OntologyTemplate.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.jet;

import org.openanzo.rdf.jastor.inference.Ontology;

/**
 * Ontology template
 * 
 * @author Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 * 
 */
public interface OntologyTemplate {
    /**
     * Generate the code for this ontology
     * 
     * @param ont
     *            the ontology for which to generate code
     * @return the generated code for this ontology
     */
    public String generate(Ontology ont);

    /**
     * Get the file provider
     * 
     * @return the file provider
     */
    public OntologyFileProvider getFileProvider();

    /**
     * Set the file provider
     * 
     * @param fileProvider
     *            the file provider
     */

    public void setFileProvider(OntologyFileProvider fileProvider);
}
