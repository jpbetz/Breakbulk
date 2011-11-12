/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 19, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jet.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.apache.tools.ant.types.FileSet;
import org.openanzo.jet.exceptions.PropertiesDefinitionParser.PropertyGroup;
import org.openanzo.jet.exceptions.templates.MetatypeTemplate;

/**
 * Ant Task for running property definition generator
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class MetatypeDefinitionTask extends MatchingTask {

    File          destinationFolder;

    String        packageName = "org/openanzo/osgi/";

    List<FileSet> fileSets    = new Vector<FileSet>();

    /**
     * Create a new composition task
     */
    public MetatypeDefinitionTask() {
    }

    /**
     * Get the java package for the generated code
     * 
     * @return the java package for the generated code
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Set the java package for the generated code
     * 
     * @param packageName
     *            the java package for the generated code
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * Set the destination file
     * 
     * @param destinationFolder
     *            directory where the property classes is written
     */
    public void setDestdir(File destinationFolder) {
        this.destinationFolder = destinationFolder;
    }

    /**
     * Add a set of files to parse
     * 
     * @param fileSet
     *            a set of files to parse
     */
    public void addFileset(FileSet fileSet) {
        fileSets.add(fileSet);
    }

    @Override
    public void execute() throws BuildException {
        for (FileSet set : fileSets) {
            DirectoryScanner ds = set.getDirectoryScanner(getProject());
            String files[] = ds.getIncludedFiles();
            String base = ds.getBasedir().getAbsolutePath();
            for (int i = 0; i < files.length; i++) {
                String filename = files[i];
                String file = base + "/" + filename;
                parseFile(file);
            }
        }
    }

    /**
     * Parse a properties file
     * 
     * @param fileName
     *            file to parse
     */
    public void parseFile(String fileName) {
        try {
            PropertiesDefinitionParser parser = new PropertiesDefinitionParser();
            SAXParser fSAXParser = SAXParserFactory.newInstance().newSAXParser();
            fSAXParser.parse(new FileInputStream(fileName), parser);
            MetatypeTemplate template = new MetatypeTemplate();
            for (PropertyGroup group : parser.getGroups()) {
                if (getPackageName() != null)
                    group.setPackageName(getPackageName());
                String output = template.generate(group);
                File destFile = new File(this.destinationFolder, getPackageName().replace('.', File.separatorChar) + File.separatorChar + group.getClassName() + "Attributes.java");
                if (!destFile.exists()) {
                    destFile.getParentFile().mkdirs();
                    destFile.createNewFile();
                }
                Writer fos = new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8");
                fos.write(output);
                fos.close();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
