package org.openanzo.jet.services;

import java.util.Iterator;

import org.openanzo.ontologies.system.Operation;
import org.openanzo.ontologies.system.Parameter;
import org.openanzo.ontologies.system.Service;
import org.openanzo.rdf.jastor.JastorUtils;
import org.openanzo.rdf.utils.WikiFormatUtils;
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
public class ServicesInterfaceTemplate
{
  protected static String nl;
  public static synchronized ServicesInterfaceTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServicesInterfaceTemplate result = new ServicesInterfaceTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " *" + NL + " * File:        ";
  protected final String TEXT_2 = "Source";
  protected final String TEXT_3 = NL + " * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Revision:\t";
  protected final String TEXT_4 = "Id";
  protected final String TEXT_5 = NL + " *" + NL + " * Contributors:" + NL + " *     IBM Corporation - initial API and implementation" + NL + " *\t   Cambridge Semantics Incorporated - Fork to Anzo" + NL + " *******************************************************************************/";
  protected final String TEXT_6 = NL + "package ";
  protected final String TEXT_7 = ";" + NL + "import org.openanzo.exceptions.AnzoException;" + NL + "import org.openanzo.rdf.Constants;" + NL + "import org.openanzo.services.IStatisticsProvider;" + NL + "import org.openanzo.services.IOperationContext;" + NL + "import org.openanzo.rdf.URI;" + NL + "" + NL + " /**" + NL + " * ";
  protected final String TEXT_8 = " interface" + NL + " * ";
  protected final String TEXT_9 = NL + " * @author Generated Code" + NL + " *" + NL + " */" + NL + "public interface I";
  protected final String TEXT_10 = " extends IStatisticsProvider ";
  protected final String TEXT_11 = ",org.openanzo.datasource.IDatasourceComponent";
  protected final String TEXT_12 = "{" + NL + "\t/** Service's Name in {@link String} form */" + NL + "    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + \"";
  protected final String TEXT_13 = "\";" + NL + "" + NL + "    /** Service's Name in {@link URI} form */" + NL + "    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);" + NL + "" + NL + "    /* Statistics object for this service" + NL + "    public ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "Stats getStatistics();" + NL + "    */";
  protected final String TEXT_16 = NL + "\t/**Constant for parameter ";
  protected final String TEXT_17 = " */" + NL + "\tpublic static final String PARAM_";
  protected final String TEXT_18 = " = \"";
  protected final String TEXT_19 = "\";";
  protected final String TEXT_20 = NL + "\t/**Constant for parameter ";
  protected final String TEXT_21 = " format */" + NL + "\tpublic static final String PARAM_";
  protected final String TEXT_22 = "Format = \"";
  protected final String TEXT_23 = "Format\";";
  protected final String TEXT_24 = NL + "\t/**";
  protected final String TEXT_25 = " operation name constant */" + NL + "    public static final String ";
  protected final String TEXT_26 = " = \"";
  protected final String TEXT_27 = "\";" + NL + "    /**" + NL + "     * ";
  protected final String TEXT_28 = NL + "     *" + NL + "     * @param context" + NL + "     *            {@link IOperationContext} context for this operation";
  protected final String TEXT_29 = NL + "     * @param ";
  protected final String TEXT_30 = NL + "     *            ";
  protected final String TEXT_31 = NL + "     * @return ";
  protected final String TEXT_32 = NL + "     * @throws AnzoException" + NL + "     */" + NL + "    public ";
  protected final String TEXT_33 = "void";
  protected final String TEXT_34 = " ";
  protected final String TEXT_35 = "(IOperationContext context";
  protected final String TEXT_36 = ",";
  protected final String TEXT_37 = " ";
  protected final String TEXT_38 = ") throws AnzoException;" + NL + "" + NL + "    /**" + NL + "     * ";
  protected final String TEXT_39 = NL + "     *" + NL + "     * @param context" + NL + "     *            {@link IOperationContext} context for this operation";
  protected final String TEXT_40 = NL + "     * @param ";
  protected final String TEXT_41 = NL + "     *            ";
  protected final String TEXT_42 = ",String" + NL + "\t * @param ";
  protected final String TEXT_43 = "Format" + NL + "     *            format for ";
  protected final String TEXT_44 = NL + "     * @param output" + NL + "     *            {@link java.io.Writer} onto which output is written";
  protected final String TEXT_45 = NL + "     * @param resultFormat" + NL + "     *            format of result data";
  protected final String TEXT_46 = NL + "     * @throws AnzoException" + NL + "     */" + NL + "    public void ";
  protected final String TEXT_47 = "(IOperationContext context";
  protected final String TEXT_48 = ",";
  protected final String TEXT_49 = " ";
  protected final String TEXT_50 = ",String ";
  protected final String TEXT_51 = "Format";
  protected final String TEXT_52 = ", java.io.Writer output";
  protected final String TEXT_53 = ", String resultFormat";
  protected final String TEXT_54 = ") throws AnzoException;";
  protected final String TEXT_55 = NL + "}";
  protected final String TEXT_56 = NL;

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
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getInterfacePackage()));
    stringBuffer.append(TEXT_7);
     if(service.getPropertyValue(DC.TITLE)!=null){
    stringBuffer.append(JastorUtils.getStingValue(service.getPropertyValue(DC.TITLE)));
    }
    stringBuffer.append(TEXT_8);
     if(service.getPropertyValue(DC.DESCRIPTION)!=null){
    stringBuffer.append(JastorUtils.getStingValue(service.getPropertyValue(DC.DESCRIPTION)));
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_10);
    Boolean isDs=service.getIsDatasourceService();if(isDs==null)isDs=false;
    if (isDs){
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getStatsPackage()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_15);
    
	java.util.Set<String> paramNames=new java.util.TreeSet<String>();
	java.util.Set<String> formatParamNames=new java.util.TreeSet<String>();
	for(Operation operation:JastorUtils.sortByTitle(service.getOperation())){

		java.util.Iterator<Parameter> parameters=operation.getRequestParameter().iterator();
		while(parameters.hasNext()){
			Parameter parameter=parameters.next();
			paramNames.add(parameter.getName());
			if(parameter.getType()!=null&&(parameter.getType().getDefaultJMSFormat()!=null||parameter.getType().getDefaultRestFormat()!=null||parameter.getType().getDefaultWSFormat()!=null)){
				formatParamNames.add(parameter.getName());
			}
		}
	}
	for(String paramName:paramNames){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(paramName));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_19);
    	}
	for(String paramName:formatParamNames){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(paramName));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_23);
    	}

    
	for(Operation operation:JastorUtils.sortByTitle(service.getOperation())){


	Parameter result=null;
	String resultJavaType=null;
	boolean resultHasDefaultFormat=false;
	Iterator<Parameter> results=operation.getResult().iterator();
	if (results.hasNext()){
		result=results.next();
		if(result!=null){
			resultJavaType=(result.getType().getJavaType()!=null)?result.getType().getJavaType():null;
			resultHasDefaultFormat=result.getType().getDefaultJMSFormat()!=null||result.getType().getDefaultRestFormat()!=null||result.getType().getDefaultWSFormat()!=null;
		}
	}
	Parameter parameters[]=new Parameter[8];
	String parameterName[]=new String[8];
	String javaType[]=new String[8];
	String type[]=new String[8];
	boolean nullAllowed[]=new boolean[8];
	boolean hasDefaultFormat[]=new boolean[8];
	int propertyLocation[]=new int[8];
	if(operation.getRequestParameter0()!=null){ parameters[0]=operation.getRequestParameter0();}
	if(operation.getRequestParameter1()!=null){ parameters[1]=operation.getRequestParameter1();}
	if(operation.getRequestParameter2()!=null){ parameters[2]=operation.getRequestParameter2();}
	if(operation.getRequestParameter3()!=null){ parameters[3]=operation.getRequestParameter3();}
	if(operation.getRequestParameter4()!=null){ parameters[4]=operation.getRequestParameter4();}
	if(operation.getRequestParameter5()!=null){ parameters[5]=operation.getRequestParameter5();}
	if(operation.getRequestParameter6()!=null){ parameters[6]=operation.getRequestParameter6();}
	if(operation.getRequestParameter7()!=null){ parameters[7]=operation.getRequestParameter7();}

	for(int i=0;i<8;i++){
		if(parameters[i]!=null){
			String location=parameters[i].getParameterLocation();
			if(location==null){
				propertyLocation[i]=0;
			}else if("body".equals(location)){
				propertyLocation[i]=1;
			}else if("parameter".equals(location)){
				propertyLocation[i]=0;
			}else if("transport".equals(location)){
				propertyLocation[i]=2;
			}else if("callbackHandler".equals(location)){
				propertyLocation[i]=-1;
			}
			parameterName[i]=parameters[i].getName();
			if(parameters[i].getType()!=null){
				type[i]=javaType[i]=parameters[i].getType().getJavaType();

			}

			Boolean nullAllowedBoolean=parameters[i].getNullAllowed();
			nullAllowed[i]=(nullAllowedBoolean!=null)?nullAllowedBoolean.booleanValue():true;
			hasDefaultFormat[i]=parameters[i].getType().getDefaultJMSFormat()!=null||parameters[i].getType().getDefaultRestFormat()!=null||parameters[i].getType().getDefaultWSFormat()!=null;
		}
	}
	int readerParam=-1;

    stringBuffer.append(TEXT_24);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(operation.getName()));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_27);
     if(operation.getPropertyValue(DC.DESCRIPTION)!=null){
    stringBuffer.append(JastorUtils.getStingValue(operation.getPropertyValue(DC.DESCRIPTION)));
    }
    stringBuffer.append(TEXT_28);
    for(int i=0;i<8;i++){
    if(parameterName[i]!=null){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(JastorUtils.getStingValue(parameters[i].getPropertyValue(DC.DESCRIPTION)));
    }
    }
    if(result!=null&&resultJavaType!=null&&!resultJavaType.equals("void")){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(JastorUtils.getStingValue(result.getPropertyValue(DC.DESCRIPTION)));
    }
    stringBuffer.append(TEXT_32);
    if(resultJavaType!=null){
    stringBuffer.append(resultJavaType);
    }else{
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_35);
    for(int i=0;i<8;i++){
    if (javaType[i]!=null){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(javaType[i]);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(parameterName[i]);
    }
    }
    stringBuffer.append(TEXT_38);
     if(operation.getPropertyValue(DC.DESCRIPTION)!=null){
    stringBuffer.append(JastorUtils.getStingValue(operation.getPropertyValue(DC.DESCRIPTION)));
    }
    stringBuffer.append(TEXT_39);
    for(int i=0;i<8;i++){
    
	if(propertyLocation[i]==1){
	    parameterName[i]="reader";
	    javaType[i]="String";
	    readerParam=i;
	}

    if(parameters[i]!=null&&parameterName[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(JastorUtils.getStingValue(parameters[i].getPropertyValue(DC.DESCRIPTION)));
    if(hasDefaultFormat[i]&&readerParam==i){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(parameterName[i]);
    }
    }
    }
    stringBuffer.append(TEXT_44);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_47);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&parameterName[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_48);
    if (javaType[i]!=null){
    stringBuffer.append(javaType[i]);
    }else{
    stringBuffer.append(javaType[i]);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(parameterName[i]);
    }
    if(hasDefaultFormat[i]&&readerParam==i){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_51);
    }
    }
    stringBuffer.append(TEXT_52);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    return stringBuffer.toString();
  }
}
