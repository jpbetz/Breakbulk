/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 15, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jet.services;

import java.io.File;
import java.io.FilenameFilter;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.utils.ReadWriteUtils;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 *
 */
public class GenerateWikiText {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            INamedGraph graph= new NamedGraph(Constants.valueFactory.createURI("http://test"));
            File directory=new File("./docs/services");
            File files[]=directory.listFiles(new FilenameFilter() {           
                public boolean accept(File dir, String name) {
                    return name.endsWith(".nt");
                }
            
            });
            for(File file:files) {
                ReadWriteUtils.loadGraph(graph, file);
            }
             ServicesWikiTemplate template=new ServicesWikiTemplate();
            
            String output=template.generate(graph);
            System.err.println(output);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
