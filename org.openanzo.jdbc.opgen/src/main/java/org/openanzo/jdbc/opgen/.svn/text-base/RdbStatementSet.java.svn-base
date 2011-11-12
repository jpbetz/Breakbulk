/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/opgen/RdbStatementSet.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: RdbStatementSet.java 176 2007-07-31 14:22:30Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.opgen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.openanzo.jdbc.opgen.jet.RdbStatementWrapperTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Provides XML deserialization and a jet context for sets of rdb statements (SQL, DDL, etc.).
 * 
 * @see org.openanzo.jdbc.opgen.RdbStatement
 * 
 * @author Joe Betz
 * 
 */
public class RdbStatementSet {

    List<RdbStatement> preparedStatements;

    /**
     * Create set of RdbStatements
     */
    public RdbStatementSet() {
        preparedStatements = new ArrayList<RdbStatement>();
    }

    /**
     * Create set of RdbStatements
     * 
     * @param sqlPackageName
     *            package name for this set of statements
     * @param xmlElement
     *            XML element containing contents of this set
     */
    public RdbStatementSet(String sqlPackageName, Element xmlElement) {
        preparedStatements = new ArrayList<RdbStatement>();
        NodeList nodeList = xmlElement.getElementsByTagName(RdbStatement.element);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element && node.getNodeName().equals(RdbStatement.element)) {
                preparedStatements.add(new RdbStatement(sqlPackageName, (Element) node));
            }
        }
    }

    /**
     * Add a prepared statement to the set
     * 
     * @param ps
     *            prepared statement to add to this set
     */
    public void addPreparedStatement(RdbStatement ps) {
        preparedStatements.add(ps);
    }

    /**
     * Get the list of prepared statements for this set
     * 
     * @return the list of prepared statements for this set
     */
    public List<RdbStatement> getList() {
        return preparedStatements;
    }

    /**
     * Write a java wrapper for this set of statements
     * 
     * @param dest
     *            directory where class file is to be written
     * @param javaClassName
     *            name of the java class
     * @param javaPackage
     *            package name for the java class
     * @param rethrowExceptionName
     *            Name of exception type for which wrap exceptions
     * @param rethrowSQLException
     *            Should SQLExceptions be rethrown or wrapped
     * @throws IOException
     */
    public void writeJavaStub(File dest, String javaClassName, String javaPackage, String rethrowExceptionName, boolean rethrowSQLException) throws IOException {
        Writer writer = new OutputStreamWriter(new FileOutputStream(dest), "UTF-8");
        RdbStatementWrapperTemplate template = new RdbStatementWrapperTemplate();
        String output = template.generate(new Context(javaClassName, javaPackage, rethrowExceptionName, rethrowSQLException, this));
        writer.write(output);
        writer.close();
    }

    /**
     * Overall context for a set of statement sets
     */
    public static class Context {

        String          javaClassName;

        String          javaPackage;

        String          rethrowExceptionName;

        boolean         rethrowSQLException;

        RdbStatementSet preparedStatements;

        /**
         * Create a new context
         * 
         * @param javaClassName
         *            classname for set of statements
         * @param javaPackage
         *            package for class
         * @param rethrowExceptionName
         *            Name of exception type for which wrap exceptions
         * @param rethrowSQLException
         *            Should SQLExceptions be rethrown or wrapped
         * @param preparedStatements
         *            set of prepared statements
         */
        public Context(String javaClassName, String javaPackage, String rethrowExceptionName, boolean rethrowSQLException, RdbStatementSet preparedStatements) {
            this.javaClassName = javaClassName;
            this.javaPackage = javaPackage;
            this.rethrowExceptionName = rethrowExceptionName;
            this.preparedStatements = preparedStatements;
            this.rethrowSQLException = rethrowSQLException;
        }

        /**
         * Get the classname for a set of statements
         * 
         * @return the classname for a set of statements
         */
        public String getClassName() {
            return javaClassName;
        }

        /**
         * Get the package name for this class
         * 
         * @return the package name for this class
         */
        public String getPackageName() {
            return javaPackage;
        }

        /**
         * Get the list of prepared statements
         * 
         * @return the list of prepared statements
         */
        public RdbStatementSet getDescriptorList() {
            return preparedStatements;
        }

        /**
         * Get the name of the exception for which to wrap exceptions
         * 
         * @return the name of the exception for which to wrap exceptions
         */
        public String getRethrowExceptionName() {
            return rethrowExceptionName;
        }

        /**
         * True if SQLExceptions should be rethrown, else they are wrapped
         * 
         * @return if SQLExceptions should be rethrown, else they are wrapped
         */
        public boolean getRethrowSQLException() {
            return rethrowSQLException;
        }
    }
}
