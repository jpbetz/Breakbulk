/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/util/graph/HasCycle.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: HasCycle.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.util.graph;

/**
 * Has cycle
 * 
 * @author Elias Torres ( <a href="mailto:eliast@us.ibm.com">eliast@us.ibm.com </a>)
 * 
 */
public class HasCycle extends DFS {

    private boolean hasCycle = false;

    @Override
    public synchronized void execute(INode start, INode end) {
    }

    @Override
    protected void reinit() {
        super.reinit();
        hasCycle = false;
    }

    @Override
    protected void foundBackEdge(IEdge edge) {
        hasCycle = true;
        done = true;
    }

    @Override
    public Object result() {
        checkState();
        return Boolean.valueOf(hasCycle);
    }

    /**
     * Return true if there was a cycle
     * 
     * @return true if there was a cycle
     */
    public boolean hasCycle() {
        checkState();
        return hasCycle;
    }
}
