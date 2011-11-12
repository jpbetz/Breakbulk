/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/TreeRewriter.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: TreeRewriter.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import org.openanzo.glitter.syntax.abstrakt.TreeNode;

/**
 * A TreeRewriter gets handed the nodes of a Glitter abstract syntax tree
 * in a post-order traversal and can rewrite it as it sees fit. 
 * @author Lee
 *
 */
public interface TreeRewriter {
	/**
	 * Rewrites the given node from a SPARQL abstract syntax tree.
	 * @param node the node in question
	 * @return A tree node to replace the passed in tree node. Returning 
	 * <tt>node</tt> leaves this spot in the AST unchanged. Returning <tt>null</tt>
	 * removes this node from the tree. (Note that it is possible that removing the
	 * node will leave the tree in an invalid state. Behavior in this case is undefined.) 
	 */
	public abstract TreeNode rewriteTreeNode(TreeNode node);
}
