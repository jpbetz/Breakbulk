/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/query/Attic/ContainerSolutionGeneratorFactory.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/27/06
 * Revision: $Id: ContainerSolutionGeneratorFactory.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.query;

import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionGeneratorFactory;
import org.openanzo.rdf.IQuadStore;

/**
 * Factory for ContainerSolutionGeneratorFactory
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class QuadStoreSolutionGeneratorFactory implements SolutionGeneratorFactory {

    /** Source of data for queries */
    protected final IQuadStore container;

    /**
     * Create new ContainerSolutionGeneratorFactory with container defined as source of data
     * 
     * @param container
     *            Source of data
     */
    public QuadStoreSolutionGeneratorFactory(IQuadStore container) {
        this.container = container;
    }

    public SolutionGenerator getSolutionGenerator() {
        return new QuadStoreSolutionGenerator(container);
    }
}
