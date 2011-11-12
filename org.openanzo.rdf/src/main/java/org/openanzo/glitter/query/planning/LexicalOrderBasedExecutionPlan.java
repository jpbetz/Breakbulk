/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/planning/LexicalOrderBasedExecutionPlan.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: LexicalOrderBasedExecutionPlan.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.planning;

import java.util.ArrayList;
import java.util.List;

import org.openanzo.glitter.query.QueryExecutionPlan;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;


/**
 * Despite its fancy sounding name, the LexicalOrderBasedExecutionPlan simply
 * iterates over the nodes in the order in which it is given them. In the absence
 * of any other sort of tree-rewriting scheme, this ends up executing the query in
 * the order in which it is written.
 * 
 * @author Lee
 *
 */
public class LexicalOrderBasedExecutionPlan implements QueryExecutionPlan {

	public List<TreeNode> orderNodes(List<? extends TreeNode> nodes) {
		return new ArrayList<TreeNode>(nodes);
	}

}
