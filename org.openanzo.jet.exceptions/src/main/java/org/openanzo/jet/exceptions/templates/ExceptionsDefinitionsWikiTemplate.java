package org.openanzo.jet.exceptions.templates;

import org.openanzo.jet.exceptions.ExceptionDefinitionParser;
import org.openanzo.jet.exceptions.ExceptionDefinitionParser.ErrorCode;
import org.openanzo.jet.exceptions.ExceptionDefinitionParser.ErrorGroup;

/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Generated via javajet
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
@SuppressWarnings("all")
public class ExceptionsDefinitionsWikiTemplate
{
  protected static String nl;
  public static synchronized ExceptionsDefinitionsWikiTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ExceptionsDefinitionsWikiTemplate result = new ExceptionsDefinitionsWikiTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "[[PageOutline]]" + NL + "Exceptions within Anzo are made up of 3 main components. Each exception can have zero or more error tags.  The tags are a combination of 64 possible bits that are bit ORed together.  " + NL + "Each exception also has an Error Code, which matches up to an error message, which are described on this page.  Error messages can have parameters, whose values are stored as an array " + NL + "of Strings within the exception." + NL + "" + NL + "= Error Codes =";
  protected final String TEXT_2 = NL + "----" + NL + "== ";
  protected final String TEXT_3 = " ==";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = " [[br]]";
  protected final String TEXT_6 = NL + "=== ";
  protected final String TEXT_7 = " ===" + NL + "'''Error Code:''' ";
  protected final String TEXT_8 = " [[br]]" + NL + "'''Description:''' ";
  protected final String TEXT_9 = " [[br]]" + NL + "'''Name:''' ";
  protected final String TEXT_10 = "  [[br]]" + NL + "'''Error Message:''' ";
  protected final String TEXT_11 = " [[br]]" + NL + "'''Possible Cause:''' ";
  protected final String TEXT_12 = " [[br]]" + NL + "'''Suggested Fix: '''";
  protected final String TEXT_13 = " [[br]]";
  protected final String TEXT_14 = NL + "----" + NL + "== ";
  protected final String TEXT_15 = " ==";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = " [[br]]";
  protected final String TEXT_18 = NL + "=== ";
  protected final String TEXT_19 = " ===" + NL + "'''Description:''' ";
  protected final String TEXT_20 = " [[br]]" + NL + "'''Error Code:''' ";
  protected final String TEXT_21 = " [[br]]" + NL + "'''Name:''' ";
  protected final String TEXT_22 = " [[br]]" + NL + "'''Error Message:''' ";
  protected final String TEXT_23 = " [[br]]" + NL + "'''Possible Cause:''' ";
  protected final String TEXT_24 = " [[br]]" + NL + "'''Suggested Fix:''' ";
  protected final String TEXT_25 = " [[br]]";

	/**
	* Generate source code
	* @param argument source for template
	* @return Return generated source
    */
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  9/18/2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation     
 *******************************************************************************/ 

     ExceptionDefinitionParser  parser = (ExceptionDefinitionParser)argument; 
    stringBuffer.append(TEXT_1);
     for (ErrorGroup errorGroup:parser.getErrorGroups()){ 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(errorGroup.getName());
    stringBuffer.append(TEXT_3);
    if(errorGroup.hasDescription()){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(errorGroup.getDescription());
    stringBuffer.append(TEXT_5);
    }
    for (ErrorCode errorCode:errorGroup.getErrorCodes()){
    stringBuffer.append(TEXT_6);
    stringBuffer.append((errorCode.getId()|(1<<errorGroup.getMask())));
    stringBuffer.append(TEXT_7);
    stringBuffer.append((errorCode.getId()|(1<<errorGroup.getMask())));
    stringBuffer.append(TEXT_8);
    if(errorCode.hasDescription()){
    stringBuffer.append(errorCode.getDescription());
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(errorCode.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(errorCode.getMessage());
    stringBuffer.append(TEXT_11);
    if(errorCode.hasPossibleCause()){
    stringBuffer.append(errorCode.getPossibleCause());
    }
    stringBuffer.append(TEXT_12);
    if(errorCode.hasSuggestedFix()){
    stringBuffer.append(errorCode.getSuggestedFix());
    }
    stringBuffer.append(TEXT_13);
    }
     for (ErrorGroup subGroup:errorGroup.getSubGroups()){ 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(subGroup.getName());
    stringBuffer.append(TEXT_15);
    if(subGroup.hasDescription()){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(subGroup.getDescription());
    stringBuffer.append(TEXT_17);
    }
    for (ErrorCode errorCode2:subGroup.getErrorCodes()){
    stringBuffer.append(TEXT_18);
    stringBuffer.append((errorCode2.getId()|(1<<subGroup.getMask())));
    stringBuffer.append(TEXT_19);
    if(errorCode2.hasDescription()){
    stringBuffer.append(errorCode2.getDescription());
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append((errorCode2.getId()|(1<<subGroup.getMask())));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(errorCode2.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(errorCode2.getMessage());
    stringBuffer.append(TEXT_23);
    if(errorCode2.hasPossibleCause()){
    stringBuffer.append(errorCode2.getPossibleCause());
    }
    stringBuffer.append(TEXT_24);
    if(errorCode2.hasSuggestedFix()){
    stringBuffer.append(errorCode2.getSuggestedFix());
    }
    stringBuffer.append(TEXT_25);
    }
    }
    }
    return stringBuffer.toString();
  }
}
