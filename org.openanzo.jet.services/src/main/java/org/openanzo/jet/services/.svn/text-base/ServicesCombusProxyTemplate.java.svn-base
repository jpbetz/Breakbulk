package org.openanzo.jet.services;

import org.openanzo.rdf.jastor.JastorUtils;
import org.openanzo.ontologies.system.*;
import org.openanzo.rdf.vocabulary.DC;
import java.util.Iterator;
import org.openanzo.rdf.utils.WikiFormatUtils;

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
public class ServicesCombusProxyTemplate
{
  protected static String nl;
  public static synchronized ServicesCombusProxyTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServicesCombusProxyTemplate result = new ServicesCombusProxyTemplate();
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
  protected final String TEXT_7 = ";" + NL + "import java.io.IOException;" + NL + "" + NL + "import javax.jms.JMSException;" + NL + "import javax.jms.TextMessage;" + NL + "" + NL + "import org.openanzo.exceptions.AnzoException;" + NL + "import org.openanzo.exceptions.ExceptionConstants;" + NL + "//import org.openanzo.rdf.Constants;" + NL + "import org.openanzo.services.IOperationContext;" + NL + "import org.openanzo.rdf.utils.SerializationConstants;" + NL + "//import org.openanzo.rdf.URI;";
  protected final String TEXT_8 = NL + "import org.openanzo.combus.CombusDatasource;" + NL + "import org.openanzo.combus.BaseCombusProxyDatasourceService;";
  protected final String TEXT_9 = NL + "import org.openanzo.combus.BaseCombusProxyService;";
  protected final String TEXT_10 = NL + " /**" + NL + " * ";
  protected final String TEXT_11 = " interface" + NL + " * ";
  protected final String TEXT_12 = NL + " * @author Generated Code" + NL + " *" + NL + " */" + NL + "public class Combus";
  protected final String TEXT_13 = "Proxy extends ";
  protected final String TEXT_14 = "BaseCombusProxyDatasourceService";
  protected final String TEXT_15 = "BaseCombusProxyService";
  protected final String TEXT_16 = " implements ";
  protected final String TEXT_17 = ".I";
  protected final String TEXT_18 = "{" + NL + "    /** Stats for object*/" + NL + "   protected org.openanzo.services.DynamicServiceStats stats=null;";
  protected final String TEXT_19 = NL + "   protected CombusDatasource datasource=null;";
  protected final String TEXT_20 = NL + "    /**" + NL + "     * Create a new JMS";
  protected final String TEXT_21 = "Proxy";
  protected final String TEXT_22 = "     " + NL + "\t * @param datasource Datasource to which this service belongs";
  protected final String TEXT_23 = NL + "     * @param combusConnection Connection which this proxy class uses to communicate to the server" + NL + "     *" + NL + "     */" + NL + "    public Combus";
  protected final String TEXT_24 = "Proxy( ";
  protected final String TEXT_25 = "CombusDatasource datasource ,";
  protected final String TEXT_26 = "org.openanzo.combus.CombusConnection combusConnection) {" + NL + "        ";
  protected final String TEXT_27 = "super(datasource,combusConnection);";
  protected final String TEXT_28 = NL + "        super(combusConnection);";
  protected final String TEXT_29 = NL + "        stats=new org.openanzo.services.DynamicServiceStats(";
  protected final String TEXT_30 = ",";
  protected final String TEXT_31 = ");" + NL + "\t" + NL + "    }" + NL + "" + NL + "\tpublic String getName(){" + NL + "\t\treturn \"Combus";
  protected final String TEXT_32 = "Proxy\";" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getDescription(){" + NL + "\t\treturn \"Combus  ";
  protected final String TEXT_33 = " Proxy Service\";" + NL + "\t}" + NL + "" + NL + "    /** Statistics object for this service*/" + NL + "    public org.openanzo.services.DynamicServiceStats getStatistics(){" + NL + "    \treturn stats;" + NL + "    }" + NL + "    ";
  protected final String TEXT_34 = NL + "    public ";
  protected final String TEXT_35 = "void";
  protected final String TEXT_36 = " ";
  protected final String TEXT_37 = "(IOperationContext context";
  protected final String TEXT_38 = ",";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = ") throws AnzoException{" + NL + "        java.io.StringWriter responseWriter = new java.io.StringWriter();";
  protected final String TEXT_41 = NL + "        if(";
  protected final String TEXT_42 = "==null){" + NL + "             throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_";
  protected final String TEXT_43 = ");" + NL + "        }";
  protected final String TEXT_44 = NL + "        String _requestBody = null;";
  protected final String TEXT_45 = NL + "\t\tif(";
  protected final String TEXT_46 = "!=null){";
  protected final String TEXT_47 = NL + "\t    _requestBody= ";
  protected final String TEXT_48 = ".serialize(";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "\t\t}";
  protected final String TEXT_52 = NL + "\t\tString resultFormat=";
  protected final String TEXT_53 = ";";
  protected final String TEXT_54 = NL + "\t\tString ";
  protected final String TEXT_55 = "Format=";
  protected final String TEXT_56 = ";";
  protected final String TEXT_57 = NL + "        ";
  protected final String TEXT_58 = "(context";
  protected final String TEXT_59 = ",";
  protected final String TEXT_60 = ",";
  protected final String TEXT_61 = "Format";
  protected final String TEXT_62 = ",responseWriter";
  protected final String TEXT_63 = ",resultFormat";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\treturn ";
  protected final String TEXT_66 = ".deserialize(responseWriter.toString(),";
  protected final String TEXT_67 = "resultFormat";
  protected final String TEXT_68 = "null";
  protected final String TEXT_69 = ",";
  protected final String TEXT_70 = ");" + NL + "\t \t";
  protected final String TEXT_71 = NL + "        ";
  protected final String TEXT_72 = ".deserialize(responseWriter.toString(),";
  protected final String TEXT_73 = "resultFormat";
  protected final String TEXT_74 = "null";
  protected final String TEXT_75 = ",";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "\t}" + NL + "" + NL + "    public void ";
  protected final String TEXT_78 = "(IOperationContext context";
  protected final String TEXT_79 = ",";
  protected final String TEXT_80 = " ";
  protected final String TEXT_81 = ",String ";
  protected final String TEXT_82 = "Format";
  protected final String TEXT_83 = ", java.io.Writer output";
  protected final String TEXT_84 = ", String resultFormat";
  protected final String TEXT_85 = ") throws AnzoException{" + NL + "     \tif (!combusConnection.isConnected()) {" + NL + "     \t    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);" + NL + "            //combusConnection.connect();" + NL + "        }" + NL + "        long start=0;" + NL + "        if (stats.isEnabled()) {" + NL + "            start = System.currentTimeMillis();" + NL + "        }" + NL + "        try{";
  protected final String TEXT_86 = NL + "       \t    if(";
  protected final String TEXT_87 = "==null){" + NL + "                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_";
  protected final String TEXT_88 = ");" + NL + "            }";
  protected final String TEXT_89 = NL + "            TextMessage request = combusConnection.createMessage();" + NL + "            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);" + NL;
  protected final String TEXT_90 = NL + "            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);";
  protected final String TEXT_91 = NL + "            messageWrapper.setProperty(SerializationConstants.operation, ";
  protected final String TEXT_92 = ");" + NL + "            if (context.getAttribute(SerializationConstants.userDescription) != null) {" + NL + "                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));" + NL + "            }" + NL + "            ";
  protected final String TEXT_93 = NL + "            messageWrapper.setProperty(PARAM_";
  protected final String TEXT_94 = "Format, ";
  protected final String TEXT_95 = "Format";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + "            if(";
  protected final String TEXT_98 = "!=null)";
  protected final String TEXT_99 = NL + "            ";
  protected final String TEXT_100 = ".serialize(";
  protected final String TEXT_101 = ",PARAM_";
  protected final String TEXT_102 = ",";
  protected final String TEXT_103 = ",messageWrapper);" + NL + "\t\t";
  protected final String TEXT_104 = NL + "            messageWrapper.setBody(";
  protected final String TEXT_105 = ");";
  protected final String TEXT_106 = NL + "\t\t\tmessageWrapper.setProperty(SerializationConstants.bypassPool,\"true\");";
  protected final String TEXT_107 = NL + "            TextMessage response = combusConnection.requestResponse(context, ";
  protected final String TEXT_108 = ".I";
  protected final String TEXT_109 = ".SERVICE_NAME, request, getTimeout());" + NL + "            try {" + NL + "\t            if (response != null && response.getText() != null) {" + NL + "\t                output.write(response.getText());" + NL + "\t                output.flush();" + NL + "\t            }" + NL + "\t        } catch (IOException ioe) {" + NL + "\t            throw new AnzoException( ExceptionConstants.IO.WRITE_ERROR, ioe);" + NL + "\t        } catch (JMSException jmsex) {" + NL + "\t            throw new AnzoException( ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);" + NL + "\t        }" + NL + "        }finally{" + NL + "       \t\tif (stats.isEnabled()) {" + NL + "       \t\t      stats.use(\"";
  protected final String TEXT_110 = "\",(System.currentTimeMillis() - start));" + NL + "            }" + NL + "        }" + NL + "    }";
  protected final String TEXT_111 = NL + "}";
  protected final String TEXT_112 = NL;

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
     Boolean isDs=service.getIsDatasourceService(); if(isDs==null)isDs=false;
    stringBuffer.append(TEXT_6);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getCombusPackage()));
    stringBuffer.append(TEXT_7);
    if(isDs){
    stringBuffer.append(TEXT_8);
    }else{
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
     if(service.getPropertyValue(DC.TITLE)!=null){
    stringBuffer.append(JastorUtils.getStingValue(service.getPropertyValue(DC.TITLE)));
    }
    stringBuffer.append(TEXT_11);
     if(service.getPropertyValue(DC.DESCRIPTION)!=null){
    stringBuffer.append(JastorUtils.getStingValue(service.getPropertyValue(DC.DESCRIPTION)));
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_13);
    if(isDs){
    stringBuffer.append(TEXT_14);
    }else{
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_18);
    if(isDs){
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_21);
    if(isDs){
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_24);
    if(isDs){
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    if(isDs){
    stringBuffer.append(TEXT_27);
    }else{
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    for(Iterator<Operation> operations=JastorUtils.sortByTitle(service.getOperation()).iterator();operations.hasNext();){
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(operations.next().getName()));
    if(operations.hasNext()){
    stringBuffer.append(TEXT_30);
    }}
    stringBuffer.append(TEXT_31);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_33);
    
	for(Operation operation:JastorUtils.sortByTitle(service.getOperation())){

	Parameter result=null;
	String resultJavaType=null;
	String resultDefaultFormat=null;
	String resultSerializer=null;
	boolean bypassPool=operation.getBypassPool()!=null?operation.getBypassPool():false;
	boolean resultHasDefaultFormat=false;
	Iterator<Parameter> results=operation.getResult().iterator();
	if (results.hasNext()){
		result=results.next();
		if(result!=null){
			resultJavaType=(result.getType().getJavaType()!=null)?result.getType().getJavaType():null;
			resultSerializer=(result.getType().getSerializer()!=null)?result.getType().getSerializer():null;
			resultDefaultFormat=(result.getType().getDefaultJMSFormat()!=null)?result.getType().getDefaultJMSFormat().getJavaType():null;
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
	boolean isPrimitive[]=new boolean[8];
	String serializer[]=new String[8];
	int propertyLocation[]=new int[8];
	int readerParam=-1;
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

    stringBuffer.append(TEXT_34);
    if(resultJavaType!=null){
    stringBuffer.append(resultJavaType);
    }else{
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_37);
    for(int i=0;i<8;i++){
    if (parameters[i]!=null){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(javaType[i]);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(parameterName[i]);
    }
    }
    stringBuffer.append(TEXT_40);
    
	for(int i=0;i<8;i++){
		if(javaType[i]!=null){
			switch(propertyLocation[i]){
				case 1:{
					if(!nullAllowed[i]){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(serializer[i]);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(defaultFormat[i]);
    stringBuffer.append(TEXT_50);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_51);
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
    stringBuffer.append(TEXT_52);
    stringBuffer.append(resultDefaultFormat);
    stringBuffer.append(TEXT_53);
    }
    if(readerParam>-1&&defaultFormat[readerParam]!=null){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(parameterName[readerParam]);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(defaultFormat[readerParam]);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_58);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_59);
    stringBuffer.append(transportName[i]);
    }
    if(defaultFormat[i]!=null&&readerParam==i){
    stringBuffer.append(TEXT_60);
    stringBuffer.append(parameterName[readerParam]);
    stringBuffer.append(TEXT_61);
    }
    }
    stringBuffer.append(TEXT_62);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
     if(resultSerializer!=null){ 
    if(resultJavaType!=null){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(resultSerializer);
    stringBuffer.append(TEXT_66);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_67);
    }else{
    stringBuffer.append(TEXT_68);
    }
    for(int i=0;i<8;i++){if(parameters[i]!=null&&propertyLocation[i]==-1){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(parameterName[i]);
    }}
    stringBuffer.append(TEXT_70);
    }else{
    stringBuffer.append(TEXT_71);
    stringBuffer.append(resultSerializer);
    stringBuffer.append(TEXT_72);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_73);
    }else{
    stringBuffer.append(TEXT_74);
    }
    for(int i=0;i<8;i++){if(parameters[i]!=null&&propertyLocation[i]==-1){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(parameterName[i]);
    }}
    stringBuffer.append(TEXT_76);
    }}
    stringBuffer.append(TEXT_77);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_78);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_79);
    if (javaType[i]!=null){
    stringBuffer.append(javaType[i]);
    }else{
    stringBuffer.append(javaType[i]);
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(parameterName[i]);
    }
    if(defaultFormat[i]!=null&&readerParam==i){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_82);
    }
    }
    stringBuffer.append(TEXT_83);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    for(int i=0;i<8;i++){
		if(parameterName[i]!=null&&!nullAllowed[i]&&!isPrimitive[i]){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_88);
    }
    }
    stringBuffer.append(TEXT_89);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(operation.getName()));
    stringBuffer.append(TEXT_92);
    for(int i=0;i<8;i++){
    if(defaultFormat[i]!=null){
    stringBuffer.append(TEXT_93);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_94);
    if(readerParam==i){
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_95);
    }else{
    stringBuffer.append(defaultFormat[i]);
    }
    stringBuffer.append(TEXT_96);
    }
    if(javaType[i]!=null){
	switch(propertyLocation[i]){
		case 0:
    if(!isPrimitive[i]&&nullAllowed[i]){
    stringBuffer.append(TEXT_97);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    stringBuffer.append(serializer[i]);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_102);
    stringBuffer.append((defaultFormat[i]!=null)?defaultFormat[i]:"null");
    stringBuffer.append(TEXT_103);
    
		break;
		case 1:
    stringBuffer.append(TEXT_104);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_105);
    break;	}
    }
    }
    if(bypassPool){
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    return stringBuffer.toString();
  }
}
