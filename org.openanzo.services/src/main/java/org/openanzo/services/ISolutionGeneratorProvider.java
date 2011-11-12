/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.SolutionGenerator;

/**
 * Class that provides a {@link SolutionGenerator} to solve glitter queries
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface ISolutionGeneratorProvider {
    /**
     * Acquire a configured {@link SolutionGenerator} for the given operation context
     * 
     * @param context
     *            operation context
     * @return the SolutionGenerator
     * @throws AnzoException
     */
    public SolutionGenerator acquireSolutionGenerator(IOperationContext context) throws AnzoException;

    /**
     * Release any resources used by this {@link SolutionGenerator}
     * 
     * @param solutionGenerator
     *            SolutionGenerator to release
     * @throws AnzoException
     */
    public void releaseSolutionGenerator(SolutionGenerator solutionGenerator) throws AnzoException;
}
