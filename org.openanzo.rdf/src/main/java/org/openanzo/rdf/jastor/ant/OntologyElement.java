/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/ant/OntologyElement.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: OntologyElement.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     C Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.ant;

import java.security.InvalidParameterException;

import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.Path;

/**
 * 
 * @author Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 * @author Elias Torres (<a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com</a>) *
 */
public class OntologyElement extends Task {

    private boolean generate;

    private Path    path;

    private String  uri;

    private String  javaPackage;

    private String  ontlang;

    private String  lang;

    /**
     * Validate that this Ontology element has all the proper values
     */
    public void validate() {
        if (uri == null)
            throw new InvalidParameterException("OntologyElement uri must not be null.");
        if (javaPackage == null)
            throw new InvalidParameterException("OntologyElement javaPackage must not be null.");
        if (path == null)
            throw new InvalidParameterException("OntologyElement path must not be null.");
    }

    /**
     * Get path to generate
     * 
     * @return path to generate
     */
    public Path getPath() {
        return path;
    }

    /**
     * Return true if code should be generated
     * 
     * @return true if code should be generated
     */
    public boolean isGenerate() {
        return generate;
    }

    /**
     * Set if code should be generated
     * 
     * @param generate
     *            true if code should be generated
     */
    public void setGenerate(boolean generate) {
        this.generate = generate;
    }

    /**
     * Set path to place generated code
     * 
     * @param path
     *            path to place generated code
     */
    public void setPath(Path path) {
        this.path = path;
    }

    /**
     * Java package for generated code
     * 
     * @return Java package for generated code
     */
    public String getJavaPackage() {
        return javaPackage;
    }

    /**
     * Set Java package for generated code
     * 
     * @param javaPackage
     *            Java package for generated code
     */
    public void setJavaPackage(String javaPackage) {
        this.javaPackage = javaPackage;
    }

    /**
     * Get URI for ontology
     * 
     * @return URI for ontology
     */
    public String getUri() {
        return uri;
    }

    /**
     * Set URI for ontology
     * 
     * @param uri
     *            URI for ontology
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * Get ontology language
     * 
     * @return ontology language
     */
    public String getLang() {
        return lang;
    }

    /**
     * Set ontology language
     * 
     * @param lang
     *            ontology language
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * Get ontology language
     * 
     * @return ontology language
     */
    public String getOntlang() {
        return ontlang;
    }

    /**
     * Set ontology language
     * 
     * @param ontlang
     *            ontology language
     */
    public void setOntlang(String ontlang) {
        this.ontlang = ontlang;
    }
}
