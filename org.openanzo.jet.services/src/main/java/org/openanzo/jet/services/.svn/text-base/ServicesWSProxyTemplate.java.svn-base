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
public class ServicesWSProxyTemplate
{
  protected static String nl;
  public static synchronized ServicesWSProxyTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServicesWSProxyTemplate result = new ServicesWSProxyTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * File:        ";
  protected final String TEXT_2 = "Source";
  protected final String TEXT_3 = NL + " * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Revision:\t";
  protected final String TEXT_4 = "Id";
  protected final String TEXT_5 = NL + " * " + NL + " * Contributors:" + NL + " *     IBM Corporation - initial API and implementation" + NL + " *\t   Cambridge Semantics Incorporated - Fork to Anzo" + NL + " *******************************************************************************/" + NL + "package org.openanzo.services.services.proxy.ws;" + NL + "import java.io.IOException;" + NL + "import java.util.UUID;" + NL + "" + NL + "import javax.xml.soap.SOAPElement;" + NL + "import javax.xml.soap.SOAPException;" + NL + "" + NL + "import org.apache.axis.AxisFault;" + NL + "import org.apache.axis.client.Call;" + NL + "import org.apache.axis.message.SOAPBodyElement;" + NL + "import org.apache.axis.message.SOAPEnvelope;" + NL + "import org.openanzo.common.SoapConstants;" + NL + "" + NL + "import org.openanzo.exceptions.AnzoAxisFault;" + NL + "import org.openanzo.exceptions.AnzoException;" + NL + "import org.openanzo.exceptions.ExceptionConstants;" + NL + "import org.openanzo.rdf.Constants;" + NL + "import org.openanzo.services.IOperationContext;" + NL + "import org.openanzo.serialization.SoapSerializationUtils;" + NL + "import org.openanzo.rdf.URI;" + NL + NL;
  protected final String TEXT_6 = NL + NL + " /**" + NL + " * ";
  protected final String TEXT_7 = " interface" + NL + " * ";
  protected final String TEXT_8 = NL + " * @author Generated Code" + NL + " * " + NL + " */" + NL + "public class WS";
  protected final String TEXT_9 = "Proxy extends BaseWSProxyService implements org.openanzo.services.services.I";
  protected final String TEXT_10 = "{" + NL + "\t/** Service's Name in {@link String} form */" + NL + "    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + \"ws";
  protected final String TEXT_11 = "Proxy\";" + NL + "" + NL + "    /** Service's Name in {@link URI} form */" + NL + "    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);" + NL + "" + NL + "    /** Stats for object*/" + NL + "    protected org.openanzo.services.services.stats.";
  protected final String TEXT_12 = "Stats stats=null;" + NL + "    " + NL + "    /**" + NL + "     * Create a new JMS";
  protected final String TEXT_13 = "Proxy" + NL + "     * " + NL + "     */" + NL + "    public WS";
  protected final String TEXT_14 = "Proxy() {" + NL + "        super();" + NL + "        stats=new org.openanzo.services.services.stats.";
  protected final String TEXT_15 = "Stats();" + NL + "    }" + NL + "    " + NL + "    /**" + NL + "     * Create a new JMS";
  protected final String TEXT_16 = "Proxy" + NL + "     * @param properties configuration properties" + NL + "     */" + NL + "    public WS";
  protected final String TEXT_17 = "Proxy(java.util.Properties properties) {" + NL + "        super(properties);" + NL + "        instanceURI = Constants.valueFactory.createURI(SERVICE_NAME + \"/\" + UUID.randomUUID().toString());" + NL + "        stats=new org.openanzo.services.services.stats.";
  protected final String TEXT_18 = "Stats();" + NL + "    }" + NL + "    " + NL + "    public org.openanzo.rdf.URI getURI(){" + NL + "    \treturn SERVICE_URI;" + NL + "    }" + NL + "    " + NL + "    /** Statistics object for this service*/" + NL + "    public org.openanzo.services.services.stats.";
  protected final String TEXT_19 = "Stats getStatistics(){" + NL + "    \treturn stats;" + NL + "    }" + NL + "" + NL + "\t";
  protected final String TEXT_20 = NL + "\t public ";
  protected final String TEXT_21 = "void";
  protected final String TEXT_22 = " ";
  protected final String TEXT_23 = "(IOperationContext context";
  protected final String TEXT_24 = ",";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = ") throws AnzoException{" + NL + "        java.io.StringWriter responseWriter = new java.io.StringWriter();        ";
  protected final String TEXT_27 = NL + "        if(";
  protected final String TEXT_28 = "==null){" + NL + "             throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_";
  protected final String TEXT_29 = ");" + NL + "        }";
  protected final String TEXT_30 = NL + "        String _requestBody = null;";
  protected final String TEXT_31 = "        " + NL + "\t\tif(";
  protected final String TEXT_32 = "!=null){";
  protected final String TEXT_33 = NL + "\t    _requestBody= ";
  protected final String TEXT_34 = ".serialize(";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = "        " + NL + "\t\t}";
  protected final String TEXT_38 = NL + "\t\tString resultFormat=";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = NL + "\t\tString ";
  protected final String TEXT_41 = "Format=";
  protected final String TEXT_42 = ";";
  protected final String TEXT_43 = NL + "        ";
  protected final String TEXT_44 = "(context";
  protected final String TEXT_45 = ",";
  protected final String TEXT_46 = ",";
  protected final String TEXT_47 = "Format";
  protected final String TEXT_48 = ",responseWriter";
  protected final String TEXT_49 = ",resultFormat";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = "       ";
  protected final String TEXT_52 = NL + "\t\treturn ";
  protected final String TEXT_53 = ".deserialize(responseWriter.toString(),";
  protected final String TEXT_54 = "resultFormat";
  protected final String TEXT_55 = "null";
  protected final String TEXT_56 = ",";
  protected final String TEXT_57 = ");" + NL + "\t \t";
  protected final String TEXT_58 = " ";
  protected final String TEXT_59 = NL + "        ";
  protected final String TEXT_60 = ".deserialize(responseWriter.toString(),";
  protected final String TEXT_61 = "resultFormat";
  protected final String TEXT_62 = "null";
  protected final String TEXT_63 = ",";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t}" + NL + "    " + NL + "    public void ";
  protected final String TEXT_66 = "(IOperationContext context";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = " ";
  protected final String TEXT_69 = ",String ";
  protected final String TEXT_70 = "Format";
  protected final String TEXT_71 = ", java.io.Writer output";
  protected final String TEXT_72 = ", String resultFormat";
  protected final String TEXT_73 = ") throws AnzoException{" + NL + "   \t\tlong start=0;" + NL + "        if (stats.isEnabled()) {" + NL + "            start = System.currentTimeMillis();" + NL + "            stats.get";
  protected final String TEXT_74 = "Use().increment();" + NL + "        }" + NL + "        try{";
  protected final String TEXT_75 = NL + "        if(";
  protected final String TEXT_76 = "==null){" + NL + "             throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_";
  protected final String TEXT_77 = ");" + NL + "        }";
  protected final String TEXT_78 = "\t     " + NL + "\t\tif (serviceHostName == null) {" + NL + "            throw new RuntimeException(\"Server host name not set.\");" + NL + "        }" + NL + "        // Invoke web service." + NL + "        Call call = WSUtil.createCall(serviceHostName, servicePort, SoapConstants.endpointPath, serviceUser, servicePassword, serviceTimeout);" + NL + "        SOAPBodyElement request = new SOAPBodyElement();" + NL + "        " + NL + "        @SuppressWarnings(\"unused\") // not used by all generated classes" + NL + "        org.openanzo.services.serialization.WSMessageWrapper messageWrapper=new org.openanzo.services.serialization.WSMessageWrapper(request);\t       \t\t" + NL + "        request.setQName(";
  protected final String TEXT_79 = "SoapConstants.";
  protected final String TEXT_80 = ".name);" + NL + "        try {" + NL + "            SoapSerializationUtils.serializeStringToElement(context.getOperationId(), request.addChildElement(SoapConstants.operationidName));";
  protected final String TEXT_81 = NL + "            SoapSerializationUtils.serializeStringToElement(resultFormat, request.addChildElement(";
  protected final String TEXT_82 = "SoapConstants.";
  protected final String TEXT_83 = ".resultFormatName));";
  protected final String TEXT_84 = " " + NL + "            if (context.getOperationPrincipal() != null && context.getOperationPrincipal().getRunAsUser() != null) {" + NL + "                SoapSerializationUtils.serializeStringToElement(context.getOperationPrincipal().getRunAsUser(), request.addChildElement(SoapConstants.runAsName));" + NL + "            }";
  protected final String TEXT_85 = NL + "\t\t\tSoapSerializationUtils.serializeStringToElement(";
  protected final String TEXT_86 = "Format";
  protected final String TEXT_87 = ",request.addChildElement(";
  protected final String TEXT_88 = "SoapConstants.";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = "FormatName));";
  protected final String TEXT_91 = NL + "\t\t\t";
  protected final String TEXT_92 = "if(";
  protected final String TEXT_93 = "!=null)";
  protected final String TEXT_94 = ".serialize(";
  protected final String TEXT_95 = ",PARAM_";
  protected final String TEXT_96 = ",";
  protected final String TEXT_97 = ",messageWrapper);" + NL + "\t\t";
  protected final String TEXT_98 = NL + "\t\t\tSoapSerializationUtils.serializeStringToElement(";
  protected final String TEXT_99 = ", request.addChildElement(";
  protected final String TEXT_100 = "SoapConstants.";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = "Name));" + NL + "\t        ";
  protected final String TEXT_103 = NL + "        } catch (SOAPException ioe) {" + NL + "            throw new AnzoException(ExceptionConstants.IO.SOAP_ERROR, ioe, ioe.getMessage());" + NL + "        }" + NL + "        " + NL + "        SOAPEnvelope envelope = new SOAPEnvelope();" + NL + "        envelope.addBodyElement(request);" + NL + "        try {" + NL + "            call.invoke(envelope);" + NL + "            call.getResponseMessage().getSOAPEnvelope().getBodyElements();" + NL + "            java.util.Vector<?> belements = call.getResponseMessage().getSOAPEnvelope().getBodyElements();" + NL + "            if (belements.size() != 1) {" + NL + "                throw new AnzoException( ExceptionConstants.IO.SOAP_ERROR);" + NL + "            }" + NL + "            SOAPBodyElement el = (SOAPBodyElement) belements.get(0);" + NL + "            SOAPElement childElement = el.getChildElement(";
  protected final String TEXT_104 = "SoapConstants.";
  protected final String TEXT_105 = ".resultsQName);" + NL + "            if (childElement != null) {" + NL + "                String value = SoapSerializationUtils.deserialize(childElement);" + NL + "                output.write(value);" + NL + "            }" + NL + "        } catch (AxisFault e) {" + NL + "            throw AnzoAxisFault.createAnzoException(e);" + NL + "        } catch (IOException ioe) {" + NL + "            throw new AnzoException( ExceptionConstants.IO.WRITE_ERROR, ioe);" + NL + "        }" + NL + "        }finally{" + NL + "       \t\tif (stats.isEnabled()) {" + NL + "                stats.get";
  protected final String TEXT_106 = "Duration().addTime((System.currentTimeMillis() - start));" + NL + "            }" + NL + "        }" + NL + "    }";
  protected final String TEXT_107 = NL + "}";
  protected final String TEXT_108 = NL;

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
     if(service.getPropertyValue(DC.DESCRIPTION)!=null){
    stringBuffer.append(JastorUtils.getStingValue(service.getPropertyValue(DC.DESCRIPTION)));
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_19);
    for(Operation operation:JastorUtils.sortByTitle(service.getOperation())){

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
			defaultFormat[i]=(parameters[i].getType().getDefaultWSFormat()!=null)?parameters[i].getType().getDefaultWSFormat().getJavaType():null;
			hasDefaultFormat[i]=parameters[i].getType().getDefaultJMSFormat()!=null||parameters[i].getType().getDefaultRestFormat()!=null||parameters[i].getType().getDefaultWSFormat()!=null;
			
		}
	}

    stringBuffer.append(TEXT_20);
    if(resultJavaType!=null){
    stringBuffer.append(resultJavaType);
    }else{
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_23);
    for(int i=0;i<8;i++){
    if (parameters[i]!=null){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(javaType[i]);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(parameterName[i]);
    }
    }
    stringBuffer.append(TEXT_26);
    
	for(int i=0;i<8;i++){
		if(javaType[i]!=null){
			switch(propertyLocation[i]){
				case 1:{
					if(!nullAllowed[i]){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(serializer[i]);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(defaultFormat[i]);
    stringBuffer.append(TEXT_36);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_37);
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
    stringBuffer.append(TEXT_38);
    stringBuffer.append(resultDefaultFormat);
    stringBuffer.append(TEXT_39);
    }
    if(readerParam>-1){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(parameterName[readerParam]);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(defaultFormat[readerParam]);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_44);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(transportName[i]);
    }
    if(defaultFormat[i]!=null&&readerParam==i){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(parameterName[readerParam]);
    stringBuffer.append(TEXT_47);
    }
    }
    stringBuffer.append(TEXT_48);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
     if(resultSerializer!=null){ 
    stringBuffer.append(TEXT_51);
    if(resultJavaType!=null){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(resultSerializer);
    stringBuffer.append(TEXT_53);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_54);
    }else{
    stringBuffer.append(TEXT_55);
    }
    for(int i=0;i<8;i++){if(parameters[i]!=null&&propertyLocation[i]==-1){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(parameterName[i]);
    }}
    stringBuffer.append(TEXT_57);
    }else{
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(resultSerializer);
    stringBuffer.append(TEXT_60);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_61);
    }else{
    stringBuffer.append(TEXT_62);
    }
    for(int i=0;i<8;i++){if(parameters[i]!=null&&propertyLocation[i]==-1){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(parameterName[i]);
    }}
    stringBuffer.append(TEXT_64);
    }}
    stringBuffer.append(TEXT_65);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_66);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_67);
    if (javaType[i]!=null){
    stringBuffer.append(javaType[i]);
    }else{
    stringBuffer.append(javaType[i]);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(parameterName[i]);
    }
    if(defaultFormat[i]!=null&&readerParam==i){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_70);
    }
    }
    stringBuffer.append(TEXT_71);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    stringBuffer.append(WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_74);
    for(int i=0;i<8;i++){
		if(parameterName[i]!=null&&!nullAllowed[i]&&javaType[i]!=null&&!isPrimitive[i]){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_77);
    }
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_80);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    for(int i=0;i<8;i++){ 
    if(defaultFormat[i]!=null){
    stringBuffer.append(TEXT_85);
    if(readerParam==i){
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_86);
    }else{
    stringBuffer.append(defaultFormat[i]);
    }
    stringBuffer.append(TEXT_87);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_90);
    }
    if(javaType[i]!=null){
	switch(propertyLocation[i]){
		case 0:
    stringBuffer.append(TEXT_91);
    if(!isPrimitive[i]&&nullAllowed[i]){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(serializer[i]);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_96);
    stringBuffer.append((defaultFormat[i]!=null)?defaultFormat[i]:"null");
    stringBuffer.append(TEXT_97);
    
		break;
		case 1:
    stringBuffer.append(TEXT_98);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_102);
    break;	}
    }
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(TEXT_108);
    return stringBuffer.toString();
  }
}
