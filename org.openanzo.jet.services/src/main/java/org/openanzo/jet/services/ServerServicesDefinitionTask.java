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
package org.openanzo.jet.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Vector;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.apache.tools.ant.types.FileSet;
import org.openanzo.ontologies.system.Service;
import org.openanzo.ontologies.system.SystemFactory;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.utils.ReadWriteUtils;

/**
 * Ant Task for running property definition generator
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class ServerServicesDefinitionTask extends MatchingTask {

    File          destinationFolder;

    File          wikiDestinationFolder;

    File          wsddDestinationFolder;

    String        servicesType;

    String        interfacePackage = "org/openanzo/services/";

    String        statsPackage     = "org/openanzo/services/stats/";

    String        combusPackage    = "org/openanzo/combus/listeners/";

    String        restPackage      = "org/openanzo/rest/listener/";

    String        wsPackage        = "org/openanzo/ws/listener/";

    List<FileSet> fileSets         = new Vector<FileSet>();

    /**
     * Create a new composition task
     */
    public ServerServicesDefinitionTask() {
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
     * Set the wikiDestinationFolder file
     * 
     * @param destinationFolder
     *            directory where the wiki text is written
     */
    public void setWikiDestdir(File destinationFolder) {
        this.wikiDestinationFolder = destinationFolder;
    }

    /**
     * Set the wsddDestinationFolder file
     * 
     * @param destinationFolder
     *            directory where the wsdd text is written
     */
    public void setWsddDestdir(File destinationFolder) {
        this.wsddDestinationFolder = destinationFolder;
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
        INamedGraph graph = new NamedGraph(Constants.valueFactory.createURI("http://test"));
        for (FileSet set : fileSets) {
            DirectoryScanner ds = set.getDirectoryScanner(getProject());
            String files[] = ds.getIncludedFiles();
            String base = ds.getBasedir().getAbsolutePath();

            for (String file : files) {
                if (file.endsWith(".ttl")) {
                    try {
                        ReadWriteUtils.loadGraph(graph, new File(base + File.separatorChar + file));
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new BuildException(e);
                    }
                }
            }
        }
        java.util.List<Service> services = SystemFactory.getAllService(graph);
        ServicesCombusListenerTemplate combusListenerTemplate = new ServicesCombusListenerTemplate();
        ServicesWsListenerTemplate wsListenerTemplate = new ServicesWsListenerTemplate();
        ServicesRestListenerTemplate restListenerTemplate = new ServicesRestListenerTemplate();
        ServicesWsddTemplate wsddTemplate = new ServicesWsddTemplate();
        try {
            for (Service service : services) {
                ServerServiceWrapper wrapper = new ServerServiceWrapper(service, this);
                if ((servicesType == null || servicesType.equals("COMBUS")) && service.getAvailableOverJms() != null && service.getAvailableOverJms()) {
                    String output = combusListenerTemplate.generate(wrapper);

                    File destFile = new File(this.destinationFolder, combusPackage + "/Combus" + service.getName() + "Listener.java");
                    if (!destFile.exists()) {
                        destFile.getParentFile().mkdirs();
                        destFile.createNewFile();
                    }
                    Writer fos = new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8");
                    fos.write(output);
                    fos.close();
                }

                if ((servicesType == null || servicesType.equals("REST")) && service.getAvailableOverRest() != null && service.getAvailableOverRest()) {
                    String restOutput = restListenerTemplate.generate(wrapper);
                    File restFile = new File(this.destinationFolder, restPackage + "Rest" + service.getName() + "Listener.java");
                    if (!restFile.exists()) {
                        restFile.getParentFile().mkdirs();
                        restFile.createNewFile();
                    }
                    Writer restos = new OutputStreamWriter(new FileOutputStream(restFile), "UTF-8");
                    restos.write(restOutput);
                    restos.close();
                }
            }
            if (servicesType == null || servicesType.equals("WS")) {
                String wsddOutput = wsddTemplate.generate(services);
                File wsddFile = new File(this.wsddDestinationFolder, "server-config.wsdd");
                if (!wsddFile.exists()) {
                    wsddFile.getParentFile().mkdirs();
                    wsddFile.createNewFile();
                }
                Writer wsddos = new OutputStreamWriter(new FileOutputStream(wsddFile), "UTF-8");
                wsddos.write(wsddOutput);
                wsddos.close();

                String wsOutput = wsListenerTemplate.generate(getWrapper());
                File wsFile = new File(this.destinationFolder, wsPackage + "WSListener.java");
                if (!wsFile.exists()) {
                    wsFile.getParentFile().mkdirs();
                    wsFile.createNewFile();
                }
                Writer wsos = new OutputStreamWriter(new FileOutputStream(wsFile), "UTF-8");
                wsos.write(wsOutput);
                wsos.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new BuildException(ioe);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            throw new BuildException(npe);
        }

    }

    /**
     * @return the servicesType
     */
    public String getServicesType() {
        return servicesType;
    }

    /**
     * @param servicesType
     *            the servicesType to set
     */
    public void setServicesType(String servicesType) {
        this.servicesType = servicesType;
    }

    /**
     * Get combus package
     * 
     * @return combus package
     */
    public String getCombusPackage() {
        return combusPackage;
    }

    /**
     * Set combus package
     * 
     * @param combusPackage
     *            combus package
     */
    public void setCombusPackage(String combusPackage) {
        this.combusPackage = combusPackage;
    }

    /**
     * Get rest package
     * 
     * @return rest package
     */
    public String getRestPackage() {
        return restPackage;
    }

    /**
     * Set rest package
     * 
     * @param restPackage
     *            rest package
     */
    public void setRestPackage(String restPackage) {
        this.restPackage = restPackage;
    }

    /**
     * Get ws package
     * 
     * @return ws package
     */
    public String getWsPackage() {
        return wsPackage;
    }

    /**
     * Set ws package
     * 
     * @param wsPackage
     *            ws package
     */
    public void setWsPackage(String wsPackage) {
        this.wsPackage = wsPackage;
    }

    /**
     * @return the interfacePackage
     */
    public String getInterfacePackage() {
        return interfacePackage;
    }

    /**
     * @param interfacePackage
     *            the interfacePackage to set
     */
    public void setInterfacePackage(String interfacePackage) {
        this.interfacePackage = interfacePackage;
    }

    /**
     * @return the statsPackage
     */
    public String getStatsPackage() {
        return statsPackage;
    }

    /**
     * @param statsPackage
     *            the statsPackage to set
     */
    public void setStatsPackage(String statsPackage) {
        this.statsPackage = statsPackage;
    }
}
