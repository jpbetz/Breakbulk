/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/query/Attic/ContainerEngineConfig.java,v $ 
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: $Date$ 
 * Revision: $Id: ContainerEngineConfig.java 168 2007-07-31 14:11:14Z mroy $ 
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.query;

import org.openanzo.glitter.EngineConfig;
import org.openanzo.glitter.query.QueryExecutionPlan;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionGeneratorFactory;
import org.openanzo.glitter.query.planning.OdoQueryOptimizer;
import org.openanzo.rdf.IQuadStore;

/**
 * ContainerEngineConfig is a Glitter Engine config that uses triple find operations on an IContainer in order to do queries.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class QuadStoreEngineConfig extends CoreEngineConfig implements EngineConfig {

    private final QuadStoreSolutionGeneratorFactory factory;

    //  private final IQuadStore                        quadStore;

    /**
     * Create new ContainerEngineConfig with container as source of data.
     * 
     * @param quadStore
     *            Source of data for query engine
     */
    public QuadStoreEngineConfig(IQuadStore quadStore) {
        //this.quadStore = quadStore;
        factory = new QuadStoreSolutionGeneratorFactory(quadStore);
    }

    public SolutionGeneratorFactory getSolutionGeneratorFactory() {
        return this.factory;
    }

    @Override
    public QueryExecutionPlan getQueryExecutionPlan(SolutionGenerator sg) {
        return new OdoQueryOptimizer();//quadStore);
    }
}
