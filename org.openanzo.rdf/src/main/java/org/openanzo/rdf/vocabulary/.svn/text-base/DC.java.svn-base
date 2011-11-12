/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/vocabulary/Attic/DC.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Apr 3, 2007
 * Revision:	$Id: DC.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.vocabulary;

import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.URI;

/**
 * Vocabulary file containing constants for purl.org's dc predicates
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class DC {

	protected static URI createProperty(String localName) {
	    return MemURI.create(NAMESPACE + localName);
	}

	/** Namespace for DC Ontology */
	public static final String	NAMESPACE	= "http://purl.org/dc/elements/1.1/";

	/** http://purl.org/dc/elements/1.1/title property */
	public static final URI		TITLE		= createProperty("title");

	/** http://purl.org/dc/elements/1.1/creator property */
	public static final URI		CREATOR		= createProperty("creator");

	/** http://purl.org/dc/elements/1.1/subject property */
	public static final URI		SUBJECT		= createProperty("subject");

	/** http://purl.org/dc/elements/1.1/description property */
	public static final URI		DESCRIPTION	= createProperty("description");

	/** http://purl.org/dc/elements/1.1/publisher property */
	public static final URI		PUBLISHER	= createProperty("publisher");

	/** http://purl.org/dc/elements/1.1/contributor property */
	public static final URI		CONTRIBUTOR	= createProperty("contributor");

	/** http://purl.org/dc/elements/1.1/date property */
	public static final URI		DATE		= createProperty("date");

	/** http://purl.org/dc/elements/1.1/type property */
	public static final URI		TYPE		= createProperty("type");

	/** http://purl.org/dc/elements/1.1/format property */
	public static final URI		FORMAT		= createProperty("format");

	/** http://purl.org/dc/elements/1.1/identifier property */
	public static final URI		IDENTIFIER	= createProperty("identifier");

	/** http://purl.org/dc/elements/1.1/source property */
	public static final URI		SOURCE		= createProperty("source");

	/** http://purl.org/dc/elements/1.1/language property */
	public static final URI		LANGUAGE	= createProperty("language");

	/** http://purl.org/dc/elements/1.1/relation property */
	public static final URI		RELATION	= createProperty("relation");

	/** http://purl.org/dc/elements/1.1/coverage property */
	public static final URI		COVERAGE	= createProperty("coverage");

	/** http://purl.org/dc/elements/1.1/rights property */
	public static final URI		RIGHTS		= createProperty("rights");
}
