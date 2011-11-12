package org.openanzo.jet.services;

import org.openanzo.ontologies.system.Operation;
import org.openanzo.ontologies.system.Parameter;
import org.openanzo.ontologies.system.Service;
import org.openanzo.rdf.jastor.JastorUtils;
import org.openanzo.rdf.vocabulary.DC;

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
public class ServicesSoapConstantsTemplate
{
  protected static String nl;
  public static synchronized ServicesSoapConstantsTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServicesSoapConstantsTemplate result = new ServicesSoapConstantsTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * File:        ";
  protected final String TEXT_2 = "Source";
  protected final String TEXT_3 = NL + " * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Revision:\t";
  protected final String TEXT_4 = "Id";
  protected final String TEXT_5 = NL + " * " + NL + " * Contributors:" + NL + " *     IBM Corporation - initial API and implementation" + NL + " *\t   Cambridge Semantics Incorporated - Fork to Anzo" + NL + " *******************************************************************************/" + NL + "package org.openanzo.services.services.proxy.ws;" + NL + "import javax.xml.soap.Name;" + NL + "import javax.xml.namespace.QName;" + NL + "import org.apache.axis.message.PrefixedQName;" + NL + "import org.openanzo.rdf.Constants;";
  protected final String TEXT_6 = NL + NL + " /**" + NL + " * Soap constants for ";
  protected final String TEXT_7 = " interface" + NL + " * @author Generated Code" + NL + " * " + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = "SoapConstants{" + NL + "\t/** Endpoint path */" + NL + "    public final static String endpointPath          = \"/model/service\";" + NL;
  protected final String TEXT_9 = NL + "    /** ";
  protected final String TEXT_10 = " webservice method */" + NL + "    public static class ";
  protected final String TEXT_11 = " {" + NL + "\t    /** ";
  protected final String TEXT_12 = " QName */" + NL + "\t    public final static QName name            = new QName(Constants.NAMESPACES.PREFIX, \"";
  protected final String TEXT_13 = "\");" + NL + "\t  " + NL + "\t    /** Format QName */" + NL + "\t    public final static QName formatQName            = new QName(Constants.NAMESPACES.PREFIX, \"format\");" + NL + "\t    " + NL + "\t    /** Format Name */" + NL + "\t    public final static Name  formatName        = new PrefixedQName(formatQName);" + NL + "\t " + NL + "\t   /** Format QName */" + NL + "\t    public final static QName resultFormatQName            = new QName(Constants.NAMESPACES.PREFIX, \"resultFormat\");" + NL + "\t    " + NL + "\t    /** Format Name */" + NL + "\t    public final static Name  resultFormatName        = new PrefixedQName(resultFormatQName);" + NL + "\t    " + NL + "\t    /** ";
  protected final String TEXT_14 = " QName */" + NL + "\t    public final static QName resultsQName    = new QName(Constants.NAMESPACES.PREFIX, \"";
  protected final String TEXT_15 = "Results\");" + NL + "\t  " + NL + "\t   /** ";
  protected final String TEXT_16 = " QName */" + NL + "\t    public final static Name resultsName    = new PrefixedQName(resultsQName);" + NL + "\t    " + NL + "\t    /** ";
  protected final String TEXT_17 = " response Name */" + NL + "       public final static QName responseQName = new QName(Constants.NAMESPACES.PREFIX, \"";
  protected final String TEXT_18 = "\");" + NL + "      ";
  protected final String TEXT_19 = NL + "\t\t/** ";
  protected final String TEXT_20 = " QName */" + NL + "\t    public final static QName ";
  protected final String TEXT_21 = "QName       = new QName(Constants.NAMESPACES.PREFIX, \"";
  protected final String TEXT_22 = "\");" + NL + "\t" + NL + "\t    /** ";
  protected final String TEXT_23 = " Name */" + NL + "\t    public final static Name  ";
  protected final String TEXT_24 = "Name        = new PrefixedQName(";
  protected final String TEXT_25 = "QName);";
  protected final String TEXT_26 = NL + "\t\t/** ";
  protected final String TEXT_27 = " format QName */" + NL + "\t\tpublic final static QName ";
  protected final String TEXT_28 = "FormatQName   = new QName(Constants.NAMESPACES.PREFIX, \"";
  protected final String TEXT_29 = "Format\");" + NL + "\t\t" + NL + "\t\t/** ";
  protected final String TEXT_30 = " format Name */" + NL + "\t    public final static Name  ";
  protected final String TEXT_31 = "FormatName        = new PrefixedQName(";
  protected final String TEXT_32 = "FormatQName);";
  protected final String TEXT_33 = NL + "\t}";
  protected final String TEXT_34 = NL + "}";
  protected final String TEXT_35 = NL;

	/**
	* Generate source code
	* @param argument source for template
	* @return Return generated source
    */
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_2);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_4);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_5);
     ServiceWrapper wrapper=(ServiceWrapper)argument;Service service = wrapper.service; 
    stringBuffer.append(TEXT_6);
     if(service.getPropertyValue(DC.TITLE)!=null){
    stringBuffer.append(JastorUtils.getStingValue(service.getPropertyValue(DC.TITLE)));
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_8);
    for(Operation operation:JastorUtils.sortByTitle(service.getOperation())){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_18);
    Parameter parameters[]=new Parameter[8];
    if(operation.getRequestParameter0()!=null){ parameters[0]=operation.getRequestParameter0();}
    if(operation.getRequestParameter1()!=null){ parameters[1]=operation.getRequestParameter1();}
    if(operation.getRequestParameter2()!=null){ parameters[2]=operation.getRequestParameter2();}
    if(operation.getRequestParameter3()!=null){ parameters[3]=operation.getRequestParameter3();}
    if(operation.getRequestParameter4()!=null){ parameters[4]=operation.getRequestParameter4();}
    if(operation.getRequestParameter5()!=null){ parameters[5]=operation.getRequestParameter5();}
    if(operation.getRequestParameter6()!=null){ parameters[6]=operation.getRequestParameter6();}
    if(operation.getRequestParameter7()!=null){ parameters[7]=operation.getRequestParameter7();}
    for(int i=0;i<8;i++){Parameter parameter=parameters[i];
    if(parameter!=null){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_25);
    if(parameter.getType()!=null&&(parameter.getType().getDefaultJMSFormat()!=null||parameter.getType().getDefaultJMSFormat()!=null||parameter.getType().getDefaultJMSFormat()!=null)){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_32);
    }
    }
    }
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
