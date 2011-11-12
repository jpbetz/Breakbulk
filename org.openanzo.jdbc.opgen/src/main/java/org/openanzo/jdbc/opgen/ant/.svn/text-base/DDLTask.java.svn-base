/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/opgen/ant/DDLTask.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: DDLTask.java 176 2007-07-31 14:22:30Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     C Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.opgen.ant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;

/**
 * Provides file listings and procedure names of DDL.
 * 
 * @author Joe Betz
 * 
 */
public class DDLTask extends Task {

    private List<FileSet> fileSets = new Vector<FileSet>();

    String                procedureName;

    List<String>          params   = new ArrayList<String>(6);

    /**
     * Add set of files to task
     * 
     * @param fileSet
     *            set of files to process
     */
    public void addFileset(FileSet fileSet) {
        fileSets.add(fileSet);
    }

    /**
     * Get the set of files to process
     * 
     * @return the set of files to process
     */
    public List<FileSet> getFiles() {
        return fileSets;
    }

    /**
     * Get the name of the procedure
     * 
     * @return the name of the procedure
     */
    public String getProcedure() {
        return procedureName;
    }

    /**
     * Set the name of the procedure
     * 
     * @param procedure
     *            the name of the procedure
     */
    public void setProcedure(String procedure) {
        this.procedureName = procedure;
    }

    /**
     * Set the A parameter
     * 
     * @param paramA
     *            the A parameter
     */
    public void setA(String paramA) {
        params.add(0, paramA);
    }

    /**
     * Set the B parameter
     * 
     * @param paramB
     *            the B parameter
     */
    public void setB(String paramB) {
        params.add(1, paramB);
    }

    /**
     * Set the C parameter
     * 
     * @param paramC
     *            the C parameter
     */
    public void setC(String paramC) {
        params.add(2, paramC);
    }

    /**
     * Set the D parameter
     * 
     * @param paramD
     *            the D parameter
     */
    public void setD(String paramD) {
        params.add(3, paramD);
    }

    /**
     * Set the E parameter
     * 
     * @param paramE
     *            the E parameter
     */
    public void setE(String paramE) {
        params.add(4, paramE);
    }

    /**
     * Set the F parameter
     * 
     * @param paramF
     *            the A parameter
     */
    public void setF(String paramF) {
        params.add(5, paramF);
    }

    /**
     * Get the template parameters for this statement
     * 
     * @return the template parameters for this statement
     */
    public String[] getParams() {
        if (params.isEmpty() || params.get(0) == null) {
            return new String[] {};
        }
        int i;
        for (i = 1; i < params.size(); i++) {
            if (params.get(i) == null) {
                System.err.println(params.get(i));
                break;
            }
        }
        return params.subList(0, i).toArray(new String[i]);
    }

    @Override
    public void execute() {
    }

    /**
     * Write the DDL output to a file
     * 
     * @param writer
     *            output writer for task
     * @param outputFormat
     *            format to write
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void write(Writer writer, String outputFormat) throws IOException, FileNotFoundException {
        writer.write(getProcedure() + "=");
        for (FileSet set : getFiles()) {
            DirectoryScanner ds = set.getDirectoryScanner(getProject());
            String files[] = ds.getIncludedFiles();
            String base = ds.getBasedir().getAbsolutePath();
            for (int i = 0; i < files.length; i++) {
                String filename = files[i];
                String file = base + "/" + filename;
                writeFile(writer, filename, file, outputFormat);
            }
        }
        writer.write("\n");
    }

    private void writeFile(Writer writer, String filename, String file, String outputFormat) throws FileNotFoundException, IOException {
        Reader in = new InputStreamReader(new FileInputStream(file), "UTF-8");
        LineNumberReader lnr = new LineNumberReader(in);
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = lnr.readLine()) != null) {
            line = StringUtils.trim(line);
            if (line.length() == 0 || line.startsWith("#"))
                continue;
            line = Pattern.compile("[\\s+]", Pattern.MULTILINE).matcher(line).replaceAll(" ");
            line = Pattern.compile(";+", Pattern.MULTILINE).matcher(line).replaceAll(";;");
            line = Pattern.compile("&sc", Pattern.MULTILINE).matcher(line).replaceAll(";");
            line = Pattern.compile("&plus", Pattern.MULTILINE).matcher(line).replaceAll("+");
            content.append(line);
            content.append(" ");
        }
        writer.write(content.toString());
        in.close();
        lnr.close();
    }
}
