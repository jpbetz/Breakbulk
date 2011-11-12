/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/graph/Attic/BocaEngineConfig.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/27/06
 * Revision: $Id: RdbEngineConfig.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.container.query;

import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionGeneratorFactory;
import org.openanzo.glitter.query.planning.QueryOptimizer;
import org.openanzo.rdf.query.CoreEngineConfig;

/**
 * RdbEngineConfig is the Glitter EngineConfig for queries against an RDB Container. It uses the QueryOptimizer query execution plan in order to determine extra
 * vs regular triple patterns.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class RdbEngineConfig extends CoreEngineConfig {

    protected RdbSolutionGeneratorFactory factory;

    /**
     * Create a new RdbEngineConfig, and initialize the factory and special predicates.
     */
    public RdbEngineConfig() {
        super();
        this.factory = new RdbSolutionGeneratorFactory();
        registerFunctionalPredicate(org.openanzo.glitter.util.Constants.TEXTLIKEPREDICATE, org.openanzo.jdbc.container.query.TextLikePredicate.class);
    }

    /**
     * Get the RdbSolutionGeneratorFactory from this config
     * 
     * @return the RdbSolutionGeneratorFactory from this config
     */
    public RdbSolutionGeneratorFactory getRdbSolutionGeneratorFactory() {
        return this.factory;
    }

    @Override
    public QueryOptimizer getQueryExecutionPlan(SolutionGenerator sg) {
        return new QueryOptimizer();
    }

    public SolutionGeneratorFactory getSolutionGeneratorFactory() {
        return this.factory;
    }
}
