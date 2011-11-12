/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/PredicateSelectivityProvider.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: PredicateSelectivityProvider.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import org.openanzo.rdf.URI;

/**
 * A {@link PredicateSelectivityProvider} defines selectivity values for a given predicate. A higher selectivity indicates that
 * the predicate identifies a narrower set of subjects and objects. A predicate such as <tt>rdf:type</tt> has very low
 * selectivity, for example.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public interface PredicateSelectivityProvider {

	/**
	 * Get the (relative) selectivity for the given predicate
	 * 
	 * @param predicate
	 *            A value indicating the (relative) selectivity of the given predicate.
	 * @return the (relative) selectivity for the given predicate
	 */
	public abstract double getSelectivity(URI predicate);
}
