/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/glitter/BocaServerEngineConfig.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/27/06
 * Revision: $Id: ServerEngineConfig.java 227 2007-08-02 13:52:42Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.query;

import org.openanzo.glitter.query.QueryExecutionPlan;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.planning.OdoQueryOptimizer;
import org.openanzo.rdf.query.CoreEngineConfig;

/**
 * ServerEngineConfig is a Glitter Engine config that uses a connection to the relation db in order to do queries.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class ServerEngineConfig extends CoreEngineConfig {

    private final ServerSolutionGeneratorFactory factory;

    final boolean                                prepopulateSolutionNodes;

    /**
     * Create a new ServerEngineConfig
     * 
     * @param prepopulateSolutionNodes
     *            If true, result nodes are converted from ids to values before returning the results
     */
    public ServerEngineConfig(boolean prepopulateSolutionNodes) {
        this.factory = new ServerSolutionGeneratorFactory(this);
        this.prepopulateSolutionNodes = prepopulateSolutionNodes;
    }

    public ServerSolutionGeneratorFactory getSolutionGeneratorFactory() {
        return this.factory;
    }

    @Override
    public boolean substituteFixedBindings() {
        return true;
    }

    @Override
    public QueryExecutionPlan getQueryExecutionPlan(SolutionGenerator sg) {
        return new OdoQueryOptimizer();//quadStore);
    }
}
