/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/glitter/BocaServerSolutionGeneratorFactory.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/27/06
 * Revision: $Id: ServerSolutionGeneratorFactory.java 227 2007-08-02 13:52:42Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.query;

import org.openanzo.glitter.query.SolutionGeneratorFactory;

/**
 * Factory for ServerSolutionGenerators
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class ServerSolutionGeneratorFactory implements SolutionGeneratorFactory {

    private final ServerEngineConfig config;

    /**
     * Create a new SolutionGeneratorFactory
     * 
     * @param config
     *            engine config for the factory
     */
    protected ServerSolutionGeneratorFactory(ServerEngineConfig config) {
        this.config = config;
    }

    public ServerSolutionGenerator getSolutionGenerator() {
        return new ServerSolutionGenerator(config.prepopulateSolutionNodes);
    }
}
