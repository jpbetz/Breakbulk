/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/QueryExecutionPlan.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: QueryExecutionPlan.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.List;

import org.openanzo.glitter.syntax.abstrakt.TreeNode;

/**
 * A {@link QueryExecutionPlan} determines the order that bindings for sibling nodes in a SPARQL query.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public interface QueryExecutionPlan {
	/**
	 * Provides an execution plan by ordering a sequence of sibling nodes.
	 * @param nodes The original order of the nodes.
	 * @return An iterator over the nodes in the order in which bindings should be generated.
	 */
	public abstract List<TreeNode> orderNodes(List<? extends TreeNode> nodes);
}
