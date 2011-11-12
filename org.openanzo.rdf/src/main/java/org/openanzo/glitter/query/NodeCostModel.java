/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/NodeCostModel.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: NodeCostModel.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import org.openanzo.glitter.syntax.abstrakt.TreeNode;

/**
 * A {@link NodeCostModel} can assign a query-execution cost to any {@link TreeNode} in a SPARQL query 
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public interface NodeCostModel {
	/**
	 * 
	 * @param node A node in the SPARQL query
	 * @return The cost (an arbitrary numeric) of generating bindings for the given <tt>node</tt>
	 */
	public abstract double computeCost(TreeNode node);
}
