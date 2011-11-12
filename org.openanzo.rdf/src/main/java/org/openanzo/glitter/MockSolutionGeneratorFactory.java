/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.glitter;

import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionGeneratorFactory;

/**
 * Get the mock solution generator factory
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class MockSolutionGeneratorFactory implements SolutionGeneratorFactory {
    SolutionGenerator solutionGenerator;

    MockSolutionGeneratorFactory(SolutionGenerator solutionGenerator) {
        this.solutionGenerator = solutionGenerator;
    }

    MockSolutionGeneratorFactory() {
        this(new MockSolutionGenerator());
    }

    public SolutionGenerator getSolutionGenerator() {
        return solutionGenerator;
    }

}
