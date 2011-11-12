/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/commands/IPrecondition.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  7/18/2006
 * Revision:	$Id: IPrecondition.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services;

import java.util.Set;

import org.openanzo.rdf.URI;


/**
 * To avoid race conditions during a transaction's commital on the Anzo server, the server allows a transaction author to
 * specify zero or more preconditions that must be satisfied (in an atomic fashion) before the actual triple additions and
 * deletions occur. A precondition is defined as a Sparql query and an expected result from said query. A dataset must be
 * defined to which the query is run against.
 * 
 * <pre><code>
 *  Example:
 *  
 *  ...
 *  final INamedGraph graph = anzoClient.getRemoteGraph(&quot;http://testGraph&quot;, true);
 * final Statement stmt = Constants.valueFactory.createStatement(Constants.valueFactory.createURI(&quot;http://openanzo.org/subject&quot;),Constants.valueFactory.createURI(&quot;http://openanzo.org/predicate1&quot;), Constants.valueFactory.createURI(&quot;http://openanzo.org/object1&quot;));
 * 
 *  Command testCommand{
 * 		public Object execute() {
 * 			graph.add(stmt);
 * 			return null;
 * 		}
 * 	};
 *  IPrecondition precondition = new Precondition();
 * Set&lt;URI&gt; defaults = new HashSet&lt;URI&gt;();
 * defaults.add(Constants.valueFactory.createURI(&quot;http://testGraph&quot;));
 * precondition.setQuery(&quot;ASK  { &lt;http://testGraph&gt; &quot; + QueryEncoder.encodeForQuery(NamedGraph.revisionProperty)+&quot; &quot;+ QueryEncoder.encodeForQuery(Constants.valueFactory.createTypedLiteral(Long.valueOf(5)))+&quot;}&quot;);
 * precondition.setResult(AskResult.createAskResult(true));
 * command.addPrecondition(precondition);
 * graph.executeInTransaction(command);
 * </code></pre>
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IPrecondition {

	/**
	 * Get the set of NamedGraph URIs that make up the dataset for this precondition.
	 * 
	 * @return Set of NamedGraph URIs
	 */
	public Set<URI> getNamedGraphUris();

	/**
	 * Set the set of NamedGraph URIs that make up the dataset for this precondition.
	 * 
	 * @param namedGraphUris
	 *            Set of NamedGraph URIs that make up the dataset.
	 */
	public void setNamedGraphUris(Set<URI> namedGraphUris);

	/**
	 * Get the set of NamedGraph URIs that make up the default graph for the dataset for this precondition.
	 * 
	 * @return Set of NamedGraph URIs
	 */
	public Set<URI> getDefaultGraphUris();

	/**
	 * Set the set of NamedGraph URIs that make up the default graph for the dataset for this precondition.
	 * 
	 * @param namedGraphUris
	 *            Set of NamedGraph URIs that make up the dataset.
	 */
	public void setDefaultGraphUris(Set<URI> namedGraphUris);

	/**
	 * Get the Sparql query string that defines the precondition
	 * 
	 * @return Sparql query string
	 */
	public String getQuery();

	/**
	 * Set the Sparql query string that defines the precondition.
	 * 
	 * @param query
	 */
	public void setQuery(String query);

	/**
	 * Get the expected result from the sparql query.
	 * 
	 * @return The expected result.
	 */
	public IResult getResult();

	/**
	 * Set the expected result from the sparql query.
	 * 
	 * @param result
	 *            the expected results from the query
	 */
	public void setResult(boolean result);
}
