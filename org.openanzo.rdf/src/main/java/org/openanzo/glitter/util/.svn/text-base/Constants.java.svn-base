/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/util/Constants.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Constants.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.util;

import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;

/**
 * A collection of static members that represent common constants used in working with SPARQL queries.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Constants {
    /**
     * A {@link TypedLiteral} representing boolean true.
     */
    static public final TypedLiteral TRUE               = MemTypedLiteral.TRUE;

    /**
     * A {@link TypedLiteral} representing boolean false.
     */
    static public final TypedLiteral FALSE              = MemTypedLiteral.FALSE;

    /** Special SPARQL predicate for doing queries using sql like text search */
    public static final String       TEXTLIKEPREDICATE  = org.openanzo.rdf.Constants.NAMESPACES.OPENANZO_ONTOLOGY_PREFIX + "textlike";

    /** Special SPARQL predicate for doing queries using text indexer */
    public static final String       TEXTMATCHPREDICATE = org.openanzo.rdf.Constants.NAMESPACES.OPENANZO_ONTOLOGY_PREFIX + "textmatch";

    public static final URI          TEXTMATCH_URI      = org.openanzo.rdf.Constants.valueFactory.createURI(TEXTMATCHPREDICATE);

}
