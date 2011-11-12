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
public class ExceptionDefinitionsTemplate
{
  protected static String nl;
  public static synchronized ExceptionDefinitionsTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ExceptionDefinitionsTemplate result = new ExceptionDefinitionsTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*******************************************************************************" + NL + " * Copyright (c) 2007-2008 Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * File:        ";
  protected final String TEXT_3 = "Source";
  protected final String TEXT_4 = NL + " * Created by:  Generated Source from org.openanzo.rdf.utils.properties.jet" + NL + " * Created on:  Generated Source from org.openanzo.rdf.utils.properties.jet" + NL + " * Revision:\t";
  protected final String TEXT_5 = "Id";
  protected final String TEXT_6 = NL + " * " + NL + " * Contributors:" + NL + " *     Cambridge Semantics Incorporated - initial API and implementation" + NL + " *******************************************************************************/" + NL + "package ";
  protected final String TEXT_7 = ";" + NL + "/**" + NL + " *  Exception constants" + NL + " *\t@author Generated Source from org.openanzo.rdf.utils.exceptions.jet" + NL + " */" + NL + " " + NL + " public class ExceptionConstants{" + NL + "  \t/** String constant for ErrorMessageArguements tag */" + NL + "    public static final String errorMessageArg = \"ErrorMessageArg\";" + NL + "" + NL + "  " + NL + " \t";
  protected final String TEXT_8 = NL + " \t  \t/**";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = "*/" + NL + "    \tpublic interface ";
  protected final String TEXT_11 = " {" + NL + "    \t\t/**Mask for ";
  protected final String TEXT_12 = " */" + NL + "    \t\tpublic static final long MASK=1<<";
  protected final String TEXT_13 = ";" + NL + "    \t\t";
  protected final String TEXT_14 = NL + "    \t\t\t/** ";
  protected final String TEXT_15 = " ";
  protected final String TEXT_16 = "*/" + NL + "    \t\t\t public static final long ";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = " | MASK; //";
  protected final String TEXT_19 = NL + "    \t\t";
  protected final String TEXT_20 = NL + "    \t\t";
  protected final String TEXT_21 = NL + "\t\t \t  \t/**";
  protected final String TEXT_22 = " */" + NL + "\t\t    \tpublic interface ";
  protected final String TEXT_23 = " {" + NL + "\t\t    \t/**Mask for ";
  protected final String TEXT_24 = " */" + NL + "\t\t    \t\tpublic static final long MASK=1<<";
  protected final String TEXT_25 = ";" + NL + "\t\t    \t\t";
  protected final String TEXT_26 = NL + "\t\t    \t\t\t/** ";
  protected final String TEXT_27 = " ";
  protected final String TEXT_28 = "*/" + NL + "\t\t    \t\t\t public static final long ";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = " | MASK; //";
  protected final String TEXT_31 = NL + "\t\t    \t\t";
  protected final String TEXT_32 = NL + "\t\t    \t\t" + NL + "\t\t    \t}" + NL + "\t\t \t";
  protected final String TEXT_33 = NL + "    \t}" + NL + " \t";
  protected final String TEXT_34 = NL + " \t" + NL + " \t";
  protected final String TEXT_35 = NL + " \t\t /** Is ";
  protected final String TEXT_36 = " type */" + NL + "    \tpublic static boolean is";
  protected final String TEXT_37 = "Exception(org.openanzo.exceptions.AnzoException ae) {" + NL + "        \treturn (ae.getErrorCode() & ";
  protected final String TEXT_38 = ".MASK) != 0;" + NL + "    \t}" + NL + " \t  \t\t";
  protected final String TEXT_39 = NL + "\t\t /** Is ";
  protected final String TEXT_40 = " type */" + NL + "    \tpublic static boolean is";
  protected final String TEXT_41 = "_";
  protected final String TEXT_42 = "Exception(org.openanzo.exceptions.AnzoException ae) {" + NL + "        \treturn (ae.getErrorCode() & ";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = ".MASK) != 0;" + NL + "    \t}    \t \t  " + NL + "\t\t \t";
  protected final String TEXT_45 = NL + " \t";
  protected final String TEXT_46 = NL + " \t" + NL + "   " + NL + " }" + NL + " \t";

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
    stringBuffer.append(parser.getPackage());
    stringBuffer.append(TEXT_7);
     for (ErrorGroup errorGroup:parser.getErrorGroups()){ 
    stringBuffer.append(TEXT_8);
    if(errorGroup.hasDescription()) {
    stringBuffer.append(errorGroup.getDescription());
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(errorGroup.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(errorGroup.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(errorGroup.getMask());
    stringBuffer.append(TEXT_13);
    for (ErrorCode errorCode:errorGroup.getErrorCodes()){
    stringBuffer.append(TEXT_14);
    if(errorCode.hasDescription()){
    stringBuffer.append(errorCode.getDescription());
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(errorCode.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(errorCode.getId());
    stringBuffer.append(TEXT_18);
    stringBuffer.append((errorCode.getId()|(1<<errorGroup.getMask())));
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
     for (ErrorGroup subGroup:errorGroup.getSubGroups()){ 
    stringBuffer.append(TEXT_21);
    if(subGroup.hasDescription()) {
    stringBuffer.append(subGroup.getDescription());
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(subGroup.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(subGroup.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(subGroup.getMask());
    stringBuffer.append(TEXT_25);
    for (ErrorCode errorCode2:subGroup.getErrorCodes()){
    stringBuffer.append(TEXT_26);
    if(errorCode2.hasDescription()) {
    stringBuffer.append(errorCode2.getDescription());
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(errorCode2.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(errorCode2.getId());
    stringBuffer.append(TEXT_30);
    stringBuffer.append((errorCode2.getId()|(1<<subGroup.getMask())));
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
     for (ErrorGroup errorGroup:parser.getErrorGroups()){ 
    stringBuffer.append(TEXT_35);
    stringBuffer.append(errorGroup.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(errorGroup.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(errorGroup.getName());
    stringBuffer.append(TEXT_38);
     for (ErrorGroup subGroup:errorGroup.getSubGroups()){ 
    stringBuffer.append(TEXT_39);
    stringBuffer.append(subGroup.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(errorGroup.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(subGroup.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(errorGroup.getName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(subGroup.getName());
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}
