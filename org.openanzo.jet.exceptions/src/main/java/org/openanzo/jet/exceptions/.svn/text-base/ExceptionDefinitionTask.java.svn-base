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
import org.openanzo.jet.exceptions.templates.ExceptionDefinitionsTemplate;
import org.openanzo.jet.exceptions.templates.ExceptionResourcesTemplate;
import org.openanzo.jet.exceptions.templates.ExceptionsDefinitionsWikiTemplate;

/**
 * Ant Task for running property definition generator
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class ExceptionDefinitionTask extends MatchingTask {

    File                      destinationFolder;

    File                      resourcesDestinationFolder;

    File                      wikiDestinationFolder;

    private String            destinationPackage;

    List<FileSet>             fileSets = new Vector<FileSet>();

    ExceptionDefinitionParser parser;

    /**
     * Create a new composition task
     */
    public ExceptionDefinitionTask() {
    }

    /**
     * Set the destination file
     * 
     * @param destinationFolder
     *            directory where the exception classes is written
     */
    public void setDestdir(File destinationFolder) {
        this.destinationFolder = destinationFolder;
    }

    /**
     * Set the resourcesDestinationFolder file
     * 
     * @param destinationFolder
     *            directory where the message.properties file is written
     */
    public void setResourcesDestdir(File destinationFolder) {
        this.resourcesDestinationFolder = destinationFolder;
    }

    /**
     * Set the wikiDestinationFolder file
     * 
     * @param destinationFolder
     *            directory where the wiki text is written
     */
    public void setWikiDestdir(File destinationFolder) {
        this.wikiDestinationFolder = destinationFolder;
    }

    /**
     * Sets the package of the generated ExceptionConstants class.
     * 
     * @param destinationPackage
     *            A java package name.
     */
    public void setDestinationPackage(String destinationPackage) {
        this.destinationPackage = destinationPackage;
    }

    /**
     * Gets the package of the generated ExceptionConstants class.
     * 
     * @return A java package name.
     */
    public String getDestinationPackage() {
        return destinationPackage;
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
        parser = new ExceptionDefinitionParser();

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
        generate();
    }

    /**
     * Parse a properties file
     * 
     * @param fileName
     *            file to parse
     */
    public void parseFile(String fileName) {
        try {

            SAXParser fSAXParser = SAXParserFactory.newInstance().newSAXParser();
            fSAXParser.parse(new FileInputStream(fileName), parser);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Generate the exception definitions
     */
    public void generate() {
        try {
            ExceptionDefinitionsTemplate template = new ExceptionDefinitionsTemplate();
            ExceptionResourcesTemplate resourcesTemplate = new ExceptionResourcesTemplate();
            ExceptionsDefinitionsWikiTemplate wikiTemplate = new ExceptionsDefinitionsWikiTemplate();
            parser.setPackage(this.getDestinationPackage());
            String output = template.generate(parser);
            String resourceOutput = resourcesTemplate.generate(parser);
            String wikiOutput = wikiTemplate.generate(parser);

            File destFile = new File(this.destinationFolder, "ExceptionConstants.java");
            if (!destFile.exists()) {
                destFile.getParentFile().mkdirs();
                destFile.createNewFile();
            }
            Writer fos = new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8");
            fos.write(output);
            fos.close();

            File destFile2 = new File(this.resourcesDestinationFolder, "messages.properties");
            if (!destFile2.exists()) {
                destFile2.getParentFile().mkdirs();
                destFile2.createNewFile();
            }
            Writer fos2 = new OutputStreamWriter(new FileOutputStream(destFile2), "UTF-8");
            fos2.write(resourceOutput);
            fos2.close();

            File destFile3 = new File(this.wikiDestinationFolder, "exceptions.wiki");
            if (!destFile3.exists()) {
                destFile3.getParentFile().mkdirs();
                destFile3.createNewFile();
            }
            Writer fos3 = new OutputStreamWriter(new FileOutputStream(destFile3), "UTF-8");
            fos3.write(wikiOutput);
            fos3.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
