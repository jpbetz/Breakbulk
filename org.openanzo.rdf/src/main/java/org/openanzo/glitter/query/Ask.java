/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/Ask.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Ask.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;


/**
 * The {@link Ask} query form serializes results as a booealn depending on whether or not there
 * are any solutions in the result set.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class Ask implements QueryResultForm {

	public SolutionSet refineSolutionsBeforeOrdering(SolutionSet solutions) {
		return solutions;
	}

	public SolutionSet refineSolutionsAfterOrdering(SolutionSet solutions, List<OrderingCondition> sortedByConditions) {
	     return solutions;
	}

	public Object serializeResults(SolutionSet results) {
		return results.size() > 0 ? true : false;
	}

	@Override
	public String toString() {
	    return "ASK";
	}

	public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
	    s.append("ASK");
	}

	public void prettyPrint(StringBuilder buffer) {
        buffer.append("Ask()");
	}


    public Collection<Variable> getBindableVariables() {
        return Collections.emptyList();
    }

    public Collection<URI> getReferencedURIs() {
        return Collections.emptyList();    }

    public Collection<Variable> getReferencedVariables() {
        return Collections.emptyList();    }

}
