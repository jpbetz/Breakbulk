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
public class ServicesRestProxyTemplate
{
  protected static String nl;
  public static synchronized ServicesRestProxyTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServicesRestProxyTemplate result = new ServicesRestProxyTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!--" + NL + "/*******************************************************************************" + NL + " * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * " + NL + " * Contributors:" + NL + " *     IBM Corporation - initial API and implementation" + NL + " *     Cambridge Semantics Incorporated - initial API and implementation     " + NL + " *******************************************************************************/ " + NL + "-->";
  protected final String TEXT_2 = NL + "/*******************************************************************************" + NL + " * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " *" + NL + " * File:        ";
  protected final String TEXT_3 = "Source";
  protected final String TEXT_4 = NL + " * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Revision:\t";
  protected final String TEXT_5 = "Id";
  protected final String TEXT_6 = NL + " *" + NL + " * Contributors:" + NL + " *     IBM Corporation - initial API and implementation" + NL + " *\t   Cambridge Semantics Incorporated - Fork to Anzo" + NL + " *******************************************************************************/";
  protected final String TEXT_7 = NL + "package ";
  protected final String TEXT_8 = ";" + NL + "import java.io.IOException;" + NL + "" + NL + "import org.openanzo.serialization.HttpParameterSet;" + NL + "import org.openanzo.exceptions.AnzoException;" + NL + "import org.openanzo.exceptions.ExceptionConstants;" + NL + "import org.openanzo.rdf.Constants;" + NL + "import org.openanzo.services.IOperationContext;" + NL + "import org.openanzo.rdf.utils.SerializationConstants;" + NL + "import org.openanzo.rdf.URI;" + NL + "" + NL + " /**" + NL + " * ";
  protected final String TEXT_9 = " interface" + NL + " * ";
  protected final String TEXT_10 = NL + " * @author Generated Code" + NL + " *" + NL + " */" + NL + "public class Rest";
  protected final String TEXT_11 = "Proxy extends BaseRestProxyService implements ";
  protected final String TEXT_12 = ".I";
  protected final String TEXT_13 = "{" + NL + "\t/** Service's Name in {@link String} form */" + NL + "    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + \"rest";
  protected final String TEXT_14 = "Proxy\";" + NL + "" + NL + "    /** Service's Name in {@link URI} form */" + NL + "    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);" + NL + "" + NL + "    /** Stats for object*/" + NL + "    protected ";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = "Stats stats=null;" + NL + "" + NL + "    /**" + NL + "     * Create a new JMS";
  protected final String TEXT_17 = "Proxy" + NL + "     *" + NL + "     */" + NL + "    public Rest";
  protected final String TEXT_18 = "Proxy(org.openanzo.services.Iservices services, org.openanzo.rdf.URI instanceURI) {" + NL + "        super(services,instanceURI);" + NL + "        stats=new ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = "Stats();" + NL + "    }" + NL + "" + NL + "    public org.openanzo.rdf.URI getURI(){" + NL + "    \treturn SERVICE_URI;" + NL + "    }" + NL + "" + NL + "    /** Statistics object for this service*/" + NL + "    public ";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = "Stats getStatistics(){" + NL + "    \treturn stats;" + NL + "    }";
  protected final String TEXT_23 = NL + "\t/**Test template string for operation ";
  protected final String TEXT_24 = " */" + NL + "\tpublic static final String TEMPLATE_";
  protected final String TEXT_25 = "=\"";
  protected final String TEXT_26 = "\";" + NL + "" + NL + " public ";
  protected final String TEXT_27 = "void";
  protected final String TEXT_28 = " ";
  protected final String TEXT_29 = "(IOperationContext context";
  protected final String TEXT_30 = ",";
  protected final String TEXT_31 = " ";
  protected final String TEXT_32 = ") throws AnzoException{" + NL + "        java.io.StringWriter responseWriter = new java.io.StringWriter();";
  protected final String TEXT_33 = NL + "        if(";
  protected final String TEXT_34 = "==null){" + NL + "             throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_";
  protected final String TEXT_35 = ");" + NL + "        }";
  protected final String TEXT_36 = NL + "       String _requestBody = null;";
  protected final String TEXT_37 = NL + "\t\tif(";
  protected final String TEXT_38 = "!=null){";
  protected final String TEXT_39 = NL + "\t    _requestBody= ";
  protected final String TEXT_40 = ".serialize(";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t\t}";
  protected final String TEXT_44 = NL + "\t\tString resultFormat=";
  protected final String TEXT_45 = ";";
  protected final String TEXT_46 = NL + "\t\tString ";
  protected final String TEXT_47 = "Format=";
  protected final String TEXT_48 = ";";
  protected final String TEXT_49 = NL + "        ";
  protected final String TEXT_50 = "(context";
  protected final String TEXT_51 = ",";
  protected final String TEXT_52 = ",";
  protected final String TEXT_53 = "Format";
  protected final String TEXT_54 = ",responseWriter";
  protected final String TEXT_55 = ",resultFormat";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "\t\treturn ";
  protected final String TEXT_58 = ".deserialize(responseWriter.toString(),";
  protected final String TEXT_59 = "resultFormat";
  protected final String TEXT_60 = "null";
  protected final String TEXT_61 = ",";
  protected final String TEXT_62 = ");" + NL + "\t \t";
  protected final String TEXT_63 = NL + "        ";
  protected final String TEXT_64 = ".deserialize(responseWriter.toString(),";
  protected final String TEXT_65 = "resultFormat";
  protected final String TEXT_66 = "null";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\t}" + NL + "" + NL + "    public void ";
  protected final String TEXT_70 = "(IOperationContext context";
  protected final String TEXT_71 = ",";
  protected final String TEXT_72 = " ";
  protected final String TEXT_73 = ",String ";
  protected final String TEXT_74 = "Format";
  protected final String TEXT_75 = ", java.io.Writer output";
  protected final String TEXT_76 = ", String resultFormat";
  protected final String TEXT_77 = ") throws AnzoException{" + NL + "        long start=0;" + NL + "        if (stats.isEnabled()) {" + NL + "            start = System.currentTimeMillis();" + NL + "            stats.get";
  protected final String TEXT_78 = "Use().increment();" + NL + "        }" + NL + "        try{";
  protected final String TEXT_79 = NL + "        if(";
  protected final String TEXT_80 = "==null){" + NL + "             throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_";
  protected final String TEXT_81 = ");" + NL + "        }";
  protected final String TEXT_82 = NL + NL + "        HttpParameterSet parameters = new HttpParameterSet();" + NL + "        @SuppressWarnings(\"unused\") // not used by all generated classes" + NL + "        org.openanzo.services.serialization.RestMessageWrapper messageWrapper=new org.openanzo.services.serialization.RestMessageWrapper(parameters);" + NL;
  protected final String TEXT_83 = NL + "        parameters.addParameter(SerializationConstants.resultFormat, resultFormat);";
  protected final String TEXT_84 = NL + "        parameters.addParameter(SerializationConstants.operationId, context.getOperationId());";
  protected final String TEXT_85 = NL + "        parameters.addParameter(PARAM_";
  protected final String TEXT_86 = "Format,  ";
  protected final String TEXT_87 = "Format";
  protected final String TEXT_88 = ");" + NL;
  protected final String TEXT_89 = NL + "\t\t";
  protected final String TEXT_90 = "if(";
  protected final String TEXT_91 = "!=null)";
  protected final String TEXT_92 = ".serialize(";
  protected final String TEXT_93 = ",PARAM_";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = ",messageWrapper);" + NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\tString _requestBody=";
  protected final String TEXT_97 = ";";
  protected final String TEXT_98 = NL + "        java.io.StringWriter requestWriter=new java.io.StringWriter();" + NL + "        org.openanzo.serialization.CommonSerializationUtils.serializeTrackers(trackersMap, requestWriter, ";
  protected final String TEXT_99 = ");" + NL + "        String _requestBody=requestWriter.toString();";
  protected final String TEXT_100 = NL + NL + "        StringBuffer result = new StringBuffer();";
  protected final String TEXT_101 = NL + "        int status = doGet(context, TEMPLATE_";
  protected final String TEXT_102 = ", parameters, result);";
  protected final String TEXT_103 = "String _requestBody=null;";
  protected final String TEXT_104 = NL + "        int status = doPut(context, TEMPLATE_";
  protected final String TEXT_105 = ", parameters,_requestBody, result);";
  protected final String TEXT_106 = "String _requestBody=null;";
  protected final String TEXT_107 = NL + "        int status = doPost(context, TEMPLATE_";
  protected final String TEXT_108 = ", parameters,_requestBody, result);";
  protected final String TEXT_109 = NL + "        int status = doDelete(context, TEMPLATE_";
  protected final String TEXT_110 = ", parameters, result);";
  protected final String TEXT_111 = NL + "        if (status != 200) {" + NL + "            throw new AnzoException( ExceptionConstants.IO.READ_ERROR, Integer.toString(status));" + NL + "        }" + NL + "        if (result.length() > 0) {" + NL + "            try {" + NL + "                output.write(result.toString());" + NL + "            } catch (IOException ioe) {" + NL + "                throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);" + NL + "            }" + NL + "        }" + NL + "        }finally{" + NL + "       \t\tif (stats.isEnabled()) {" + NL + "                stats.get";
  protected final String TEXT_112 = "Duration().addTime((System.currentTimeMillis() - start));" + NL + "            }" + NL + "        }" + NL + "" + NL + "    }";
  protected final String TEXT_113 = NL + "}";
  protected final String TEXT_114 = NL;

	/**
	* Generate source code
	* @param argument source for template
	* @return Return generated source
    */
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_4);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_5);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_6);
     ServiceWrapper wrapper=(ServiceWrapper)argument;Service service = wrapper.service; 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getRestPackage()));
    stringBuffer.append(TEXT_8);
     if(service.getPropertyValue(DC.TITLE)!=null){
    stringBuffer.append(JastorUtils.getStingValue(service.getPropertyValue(DC.TITLE)));
    }
    stringBuffer.append(TEXT_9);
     if(service.getPropertyValue(DC.DESCRIPTION)!=null){
    stringBuffer.append(JastorUtils.getStingValue(service.getPropertyValue(DC.DESCRIPTION)));
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getInterfacePackage()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getStatsPackage()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getStatsPackage()));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getStatsPackage()));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_22);
    
	for(Operation operation:JastorUtils.sortByTitle(service.getOperation())){

	boolean resultSet=false;
	Parameter result=null;
	String resultJavaType=null;
	String resultDefaultFormat=null;
	boolean resultHasDefaultFormat=false;
	String resultSerializer=null;

	Iterator<Parameter> results=operation.getResult().iterator();
	if (results.hasNext()){
		result=results.next();
		if(result!=null){
			resultJavaType=(result.getType().getJavaType()!=null)?result.getType().getJavaType():null;
			resultSerializer=(result.getType().getSerializer()!=null)?result.getType().getSerializer():null;
			resultDefaultFormat=(result.getType().getDefaultWSFormat()!=null)?result.getType().getDefaultWSFormat().getJavaType():null;
			resultHasDefaultFormat=result.getType().getDefaultJMSFormat()!=null||result.getType().getDefaultRestFormat()!=null||result.getType().getDefaultWSFormat()!=null;
		}
	}
	Parameter parameters[]=new Parameter[8];
	String parameterName[]=new String[8];
	String transportName[]=new String[8];
	String javaType[]=new String[8];
	String type[]=new String[8];
	boolean nullAllowed[]=new boolean[8];
	String defaultFormat[]=new String[8];
	boolean hasDefaultFormat[]=new boolean[8];
	String serializer[]=new String[8];
	int propertyLocation[]=new int[8];
	int readerParam=-1;
	boolean isPrimitive[]=new boolean[8];
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
			parameterName[i]=transportName[i]=parameters[i].getName();
			if(parameters[i].getType()!=null){
				type[i]=javaType[i]=parameters[i].getType().getJavaType();
				serializer[i]=parameters[i].getType().getSerializer();
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
				if(javaType[i]!=null&&("int".equals(javaType[i])||"long".equals(javaType[i])||"boolean".equals(javaType[i]))){
					isPrimitive[i]=true;
				}
			}

			Boolean nullAllowedBoolean=parameters[i].getNullAllowed();
			nullAllowed[i]=(nullAllowedBoolean!=null)?nullAllowedBoolean.booleanValue():true;
			defaultFormat[i]=(parameters[i].getType().getDefaultJMSFormat()!=null)?parameters[i].getType().getDefaultJMSFormat().getJavaType():null;
			hasDefaultFormat[i]=parameters[i].getType().getDefaultJMSFormat()!=null||parameters[i].getType().getDefaultRestFormat()!=null||parameters[i].getType().getDefaultWSFormat()!=null;

		}
	}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(operation.getName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(operation.getRestEndpoint());
    stringBuffer.append(TEXT_26);
    if(resultJavaType!=null){
    stringBuffer.append(resultJavaType);
    }else{
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_29);
    for(int i=0;i<8;i++){
    if (parameters[i]!=null){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(javaType[i]);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(parameterName[i]);
    }
    }
    stringBuffer.append(TEXT_32);
    
	for(int i=0;i<8;i++){
		if(javaType[i]!=null){
			switch(propertyLocation[i]){
				case 1:{
					if(!nullAllowed[i]){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(serializer[i]);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(defaultFormat[i]);
    stringBuffer.append(TEXT_42);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_43);
    }
					readerParam=i;
			   		transportName[i]="_requestBody";
			    	javaType[i]="String";
				}
				break;

			}
		}
	}
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(resultDefaultFormat);
    stringBuffer.append(TEXT_45);
    }
    if(readerParam>-1){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(parameterName[readerParam]);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(defaultFormat[readerParam]);
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_50);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(transportName[i]);
    }
    if(defaultFormat[i]!=null&&readerParam==i){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(parameterName[readerParam]);
    stringBuffer.append(TEXT_53);
    }
    }
    stringBuffer.append(TEXT_54);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
     if(resultSerializer!=null){ 
    if(resultJavaType!=null){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(resultSerializer);
    stringBuffer.append(TEXT_58);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_59);
    }else{
    stringBuffer.append(TEXT_60);
    }
    for(int i=0;i<8;i++){if(parameters[i]!=null&&propertyLocation[i]==-1){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(parameterName[i]);
    }}
    stringBuffer.append(TEXT_62);
    }else{
    stringBuffer.append(TEXT_63);
    stringBuffer.append(resultSerializer);
    stringBuffer.append(TEXT_64);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_65);
    }else{
    stringBuffer.append(TEXT_66);
    }
    for(int i=0;i<8;i++){if(parameters[i]!=null&&propertyLocation[i]==-1){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(parameterName[i]);
    }}
    stringBuffer.append(TEXT_68);
    }}
    stringBuffer.append(TEXT_69);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_70);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_71);
    if (javaType[i]!=null){
    stringBuffer.append(javaType[i]);
    }else{
    stringBuffer.append(javaType[i]);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(parameterName[i]);
    }
    if(defaultFormat[i]!=null&&readerParam==i){
    stringBuffer.append(TEXT_73);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_74);
    }
    }
    stringBuffer.append(TEXT_75);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append(WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_78);
    for(int i=0;i<8;i++){
		if(parameterName[i]!=null&&!nullAllowed[i]&&!isPrimitive[i]){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_81);
    }
    }
    stringBuffer.append(TEXT_82);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    int firstTracker=-1;
    for(int i=0;i<8;i++){ 
    if(defaultFormat[i]!=null){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_86);
    if(readerParam==i){
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_87);
    }else{
    stringBuffer.append(defaultFormat[i]);
    }
    stringBuffer.append(TEXT_88);
    }
    if(javaType[i]!=null){
		switch(propertyLocation[i]){
		case 0:
    stringBuffer.append(TEXT_89);
    if(!isPrimitive[i]&&nullAllowed[i]){
    stringBuffer.append(TEXT_90);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(serializer[i]);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_94);
    stringBuffer.append((defaultFormat[i]!=null)?defaultFormat[i]:"null");
    stringBuffer.append(TEXT_95);
    
		break;
		case 1:
		resultSet=true;

		
    stringBuffer.append(TEXT_96);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_97);
    break;	}}
    if(firstTracker>-1){
    resultSet=true;
    stringBuffer.append(TEXT_98);
    stringBuffer.append(defaultFormat[firstTracker]);
    stringBuffer.append(TEXT_99);
    }}
    stringBuffer.append(TEXT_100);
    if(operation.getRestType()!=null&&org.openanzo.jet.services.RestOperation.RequestType.GET.name().equals(operation.getRestType())){
    stringBuffer.append(TEXT_101);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(operation.getName()));
    stringBuffer.append(TEXT_102);
    }else if(operation.getRestType()!=null&&org.openanzo.jet.services.RestOperation.RequestType.PUT.name().equals(operation.getRestType())){
    if(!resultSet){
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(operation.getName()));
    stringBuffer.append(TEXT_105);
    }else if(operation.getRestType()!=null&&org.openanzo.jet.services.RestOperation.RequestType.POST.name().equals(operation.getRestType())){
    if(!resultSet){
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(operation.getName()));
    stringBuffer.append(TEXT_108);
    }else if(operation.getRestType()!=null&&org.openanzo.jet.services.RestOperation.RequestType.DELETE.name().equals(operation.getRestType())){
    stringBuffer.append(TEXT_109);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(operation.getName()));
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(TEXT_114);
    return stringBuffer.toString();
  }
}
