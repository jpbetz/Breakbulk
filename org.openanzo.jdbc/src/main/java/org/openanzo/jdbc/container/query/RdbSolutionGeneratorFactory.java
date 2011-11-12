/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/graph/Attic/BocaSolutionGeneratorFactory.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/27/06
 * Revision: $Id: RdbSolutionGeneratorFactory.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.container.query;

import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionGeneratorFactory;
import org.openanzo.jdbc.container.RDBQuadStore;

/**
 * Factory to create RdbSolutionGenerators
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class RdbSolutionGeneratorFactory implements SolutionGeneratorFactory {

	protected RDBQuadStore	container	= null;

	/**
	 * Create new RdbSolutionGeneratorFactory
	 */
	public RdbSolutionGeneratorFactory() {
	}

	/**
	 * Create new RdbSolutionGeneratorFactory for the given container
	 * 
	 * @param container
	 *            connection to rdb store which holds data
	 */
	public RdbSolutionGeneratorFactory(RDBQuadStore container) {
		setNodeCentricNamedGraphContainer(container);
	}

	/**
	 * Set the container for the factory
	 * 
	 * @param container
	 *            connection to rdb store which holds data
	 */
	public void setNodeCentricNamedGraphContainer(RDBQuadStore container) {
		this.container = container;
	}

	public SolutionGenerator getSolutionGenerator() {
		return new RdbSolutionGenerator(this.container);
	}
}
