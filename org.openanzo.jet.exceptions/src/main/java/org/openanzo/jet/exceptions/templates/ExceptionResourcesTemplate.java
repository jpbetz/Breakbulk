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
public class ExceptionResourcesTemplate
{
  protected static String nl;
  public static synchronized ExceptionResourcesTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ExceptionResourcesTemplate result = new ExceptionResourcesTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*******************************************************************************" + NL + " * Copyright (c) 2007-2008 Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * File:        ";
  protected final String TEXT_3 = "Source";
  protected final String TEXT_4 = NL + " * Created by:  Generated Source from org.openanzo.rdf.utils.properties.jet" + NL + " * Created on:  Generated Source from org.openanzo.rdf.utils.properties.jet" + NL + " * Revision:\t";
  protected final String TEXT_5 = "Id";
  protected final String TEXT_6 = NL + " * " + NL + " * Contributors:" + NL + " *     Cambridge Semantics Incorporated - initial API and implementation" + NL + " *******************************************************************************/" + NL + " " + NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + "ExceptionConstants.";
  protected final String TEXT_9 = "=";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "ExceptionConstants.";
  protected final String TEXT_12 = "=";
  protected final String TEXT_13 = NL + " " + NL + " \t";

	/**
	* Generate source code
	* @param argument source for template
	* @return Return generated source
    */
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     ExceptionDefinitionParser  parser = (ExceptionDefinitionParser)argument; 
    stringBuffer.append(TEXT_2);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_4);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_5);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_6);
     for (ErrorGroup errorGroup:parser.getErrorGroups()){ 
    stringBuffer.append(TEXT_7);
    for (ErrorCode errorCode:errorGroup.getErrorCodes()){
    stringBuffer.append(TEXT_8);
    stringBuffer.append((errorCode.getId()|(1<<errorGroup.getMask())));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(errorCode.getMessage());
    }
     for (ErrorGroup subGroup:errorGroup.getSubGroups()){ 
    stringBuffer.append(TEXT_10);
    for (ErrorCode errorCode2:subGroup.getErrorCodes()){
    stringBuffer.append(TEXT_11);
    stringBuffer.append((errorCode2.getId()|(1<<subGroup.getMask())));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(errorCode2.getMessage());
    }
    }
    }
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
