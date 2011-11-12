/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/ParallelQueryExecutor.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: ParallelQueryExecutor.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import org.openanzo.glitter.EngineConfig;
import org.openanzo.glitter.exception.FeatureNotImplementedException;

/**
 * The {@link ParallelQueryExecutor} is unimplemented.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class ParallelQueryExecutor implements QueryExecutor {
	/**
	 * Default constructor. Unimplemented.
	 */
	public ParallelQueryExecutor() {
		throw new FeatureNotImplementedException("ParallelQueryExecutor");
	}

	public void initialize(EngineConfig config, QueryController controller, SolutionGenerator sg, QueryExecutionPlan plan) {
		throw new FeatureNotImplementedException("ParallelQueryExecutor");
	}
	
	public boolean composedSolutions() {
		throw new FeatureNotImplementedException("ParallelQueryExecutor");
	}

	public SolutionSet executeQuery() {
		throw new FeatureNotImplementedException("ParallelQueryExecutor");		
	}
}
