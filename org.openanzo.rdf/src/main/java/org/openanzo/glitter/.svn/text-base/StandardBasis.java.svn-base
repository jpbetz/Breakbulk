/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/StandardBasis.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: StandardBasis.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter;

import org.openanzo.glitter.expression.Function;
import org.openanzo.glitter.expression.FunctionRegistry;
import org.openanzo.glitter.expression.builtin.Coalesce;
import org.openanzo.glitter.expression.builtin.If;
import org.openanzo.glitter.expression.builtin.cast.XSDDouble;
import org.openanzo.glitter.expression.builtin.cast.XSDInteger;
import org.openanzo.glitter.expression.builtin.cast.XSDString;
import org.openanzo.glitter.expression.builtin.function.Concat;
import org.openanzo.glitter.expression.builtin.function.DatePart;
import org.openanzo.glitter.expression.builtin.function.LocalName;
import org.openanzo.glitter.expression.builtin.function.Now;
import org.openanzo.glitter.expression.builtin.function.PartitionIndex;
import org.openanzo.glitter.expression.builtin.function.Round;
import org.openanzo.glitter.expression.builtin.function.TimePart;
import org.openanzo.glitter.expression.builtin.function.ToURI;
import org.openanzo.glitter.expression.builtin.function.UnboundAsMaxValue;

/**
 * This class provides a standard basis of standard and extension SPARQL
 * functions, including cast functions. Currently supports:<br><br>
 * <tt>xsd:string(...)</tt><br>
 * <tt>xsd:integer(...)</tt><br>
 * <tt>xsd:double(...)</tt><br>
 * @author lee <lee@cambridgesemantics.com>
 *
 */
 public class StandardBasis {
	 private StandardBasis() { }
	 /**
	  * Registers all of the standard basis functions using the singleton
	  * {@link FunctionRegistry}.
	  */
	 static public void registerStandardFunctions() {
		 registerCastFunctions();
		 registerGlitterFunctions();
	 }
	 static private void registerGlitterFunctions() {
	     FunctionRegistry r = FunctionRegistry.getRegistry();

	     Function[] functions = {
	             new UnboundAsMaxValue(),
	             new DatePart(),
	             new TimePart(),
	             new PartitionIndex(),
	             new LocalName(),
	             new Concat(),
	             new ToURI(),
	             new Round(),
	             new Now(),
	             new If(),
	             new Coalesce()
	     };
	     
	     for (Function f : functions) {
	         r.registerFunction(f.getIdentifier(), f);
	     }
	 }

	 static private void registerCastFunctions() {
		 FunctionRegistry r = FunctionRegistry.getRegistry();

		 Function[] casts = {
				 new XSDString(),
				 new XSDInteger(),
				 new XSDDouble()
		 };

		 for (int i = 0; i < casts.length; i++)
			 r.registerFunction(casts[i].getIdentifier(), casts[i]);
	 }

}
