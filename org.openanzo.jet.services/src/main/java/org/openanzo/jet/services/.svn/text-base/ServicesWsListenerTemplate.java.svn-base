package org.openanzo.jet.services;

import java.util.Iterator;

import org.openanzo.ontologies.system.Operation;
import org.openanzo.ontologies.system.Parameter;
import org.openanzo.ontologies.system.Service;
import org.openanzo.rdf.jastor.JastorUtils;
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
public class ServicesWsListenerTemplate
{
  protected static String nl;
  public static synchronized ServicesWsListenerTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServicesWsListenerTemplate result = new ServicesWsListenerTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " *" + NL + " * File:        ";
  protected final String TEXT_2 = "Source";
  protected final String TEXT_3 = NL + " * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Revision:\t";
  protected final String TEXT_4 = "Id";
  protected final String TEXT_5 = NL + " *" + NL + " * Contributors:" + NL + " *     IBM Corporation - initial API and implementation" + NL + " *\t   Cambridge Semantics Incorporated - Fork to Anzo" + NL + " *******************************************************************************/" + NL + "package org.openanzo.server.endpoint.ws;" + NL + "import java.io.StringWriter;" + NL + "" + NL + "import org.openanzo.exceptions.ExceptionConstants;" + NL + "import org.openanzo.exceptions.AnzoException;";
  protected final String TEXT_6 = NL + " /**" + NL + " * Webservice listener for all services" + NL + " * @author Generated Code" + NL + " */" + NL + "" + NL + "public class WSListener extends org.openanzo.server.endpoint.ws.BaseWSListener{" + NL + "    private static final org.slf4j.Logger          log              = org.slf4j.LoggerFactory.getLogger(WSListener.class);" + NL + "" + NL + "    /**" + NL + "     * Create a new WSListener" + NL + "     *" + NL + "     */" + NL + "    public WSListener() {" + NL + "        super();" + NL + "  \t}" + NL;
  protected final String TEXT_7 = NL + "    /**" + NL + "     * Execute ";
  protected final String TEXT_8 = NL + "     *" + NL + "     * @param bodyElements" + NL + "     *            soap element containing request" + NL + "     * @return response to call" + NL + "     * @throws org.apache.axis.AxisFault" + NL + "     */" + NL + "    @SuppressWarnings(\"unused\") // some local variables are not used by all generated classes" + NL + "    public org.apache.axis.message.SOAPBodyElement[] ";
  protected final String TEXT_9 = "(org.apache.axis.message.SOAPBodyElement[] bodyElements) throws org.apache.axis.AxisFault {" + NL + "\t    try{" + NL + "\t    \tWSServlet repositoryServlet = getParentServlet();" + NL + "\t    \tlong start=0;" + NL + "\t        if (repositoryServlet.get";
  protected final String TEXT_10 = "().getStatistics()!=null&&repositoryServlet.get";
  protected final String TEXT_11 = "().getStatistics().isEnabled()) {" + NL + "\t           \tstart = System.currentTimeMillis();" + NL + "\t           \trepositoryServlet.get";
  protected final String TEXT_12 = "().getStatistics().get";
  protected final String TEXT_13 = "Use().increment();" + NL + "\t       \t}" + NL + "\t        try{" + NL + "\t        \torg.openanzo.services.serialization.WSMessageWrapper messageWrapper=new org.openanzo.services.serialization.WSMessageWrapper(bodyElements[0]);" + NL + "\t       \t\tString operationId = null;" + NL + "\t\t        javax.xml.soap.SOAPElement operationIdElement = bodyElements[0].getChildElement(org.openanzo.common.SoapConstants.operationidQName);" + NL + "\t\t        if (operationIdElement != null) {" + NL + "\t\t            operationId = org.openanzo.serialization.SoapSerializationUtils.deserialize(operationIdElement);" + NL + "\t\t        } else {" + NL + "\t\t            operationId = org.openanzo.services.BaseOperationContext.generateOperationId();" + NL + "\t\t        }" + NL;
  protected final String TEXT_14 = NL + "\t\t\t\tjavax.xml.soap.SOAPElement resultFormatElement = bodyElements[0].getChildElement(org.openanzo.services.services.proxy.ws.";
  protected final String TEXT_15 = "SoapConstants.";
  protected final String TEXT_16 = ".resultFormatQName);" + NL + "\t\t        String resultFormat = (resultFormatElement != null)?org.openanzo.serialization.SoapSerializationUtils.deserialize(resultFormatElement):";
  protected final String TEXT_17 = ";";
  protected final String TEXT_18 = NL + "\t       \t\torg.openanzo.services.IOperationContext context = getRequestContext(org.openanzo.services.services.proxy.ws.";
  protected final String TEXT_19 = "SoapConstants.";
  protected final String TEXT_20 = ".name.toString(), operationId,bodyElements[0]);";
  protected final String TEXT_21 = NL + " \t\t\t\tboolean ";
  protected final String TEXT_22 = "Exists = messageWrapper.hasProperty(org.openanzo.services.services.I";
  protected final String TEXT_23 = ".PARAM_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t       \t \tif(!";
  protected final String TEXT_26 = "Exists){" + NL + "\t       \t    \tthrow new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.services.services.I";
  protected final String TEXT_27 = ".PARAM_";
  protected final String TEXT_28 = ");" + NL + "\t       \t \t}";
  protected final String TEXT_29 = NL + "\t\t\t\tboolean ";
  protected final String TEXT_30 = "FormatExists = messageWrapper.hasProperty(org.openanzo.services.services.I";
  protected final String TEXT_31 = ".PARAM_";
  protected final String TEXT_32 = "Format);" + NL + "\t\t      \tString ";
  protected final String TEXT_33 = "Format = (";
  protected final String TEXT_34 = "FormatExists)?messageWrapper.getProperty(org.openanzo.services.services.I";
  protected final String TEXT_35 = ".PARAM_";
  protected final String TEXT_36 = "Format):";
  protected final String TEXT_37 = ";";
  protected final String TEXT_38 = NL + "\t\t\t\tString ";
  protected final String TEXT_39 = " = messageWrapper.getProperty(org.openanzo.services.services.I";
  protected final String TEXT_40 = ".PARAM_";
  protected final String TEXT_41 = ");" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t";
  protected final String TEXT_43 = " ";
  protected final String TEXT_44 = " =";
  protected final String TEXT_45 = "(";
  protected final String TEXT_46 = "Exists)?";
  protected final String TEXT_47 = ".deserialize(messageWrapper,org.openanzo.services.services.I";
  protected final String TEXT_48 = ".PARAM_";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = "Format";
  protected final String TEXT_51 = "null";
  protected final String TEXT_52 = ")";
  protected final String TEXT_53 = ":null";
  protected final String TEXT_54 = ";";
  protected final String TEXT_55 = NL + "\t \t\t\tStringWriter output = new StringWriter();" + NL + "\t            repositoryServlet.get";
  protected final String TEXT_56 = "().";
  protected final String TEXT_57 = "(context";
  protected final String TEXT_58 = ",";
  protected final String TEXT_59 = ",";
  protected final String TEXT_60 = "Format";
  protected final String TEXT_61 = ", output";
  protected final String TEXT_62 = ",resultFormat";
  protected final String TEXT_63 = ");" + NL + "\t            org.apache.axis.message.SOAPBodyElement ret = new org.apache.axis.message.SOAPBodyElement();" + NL + "\t            ret.setQName(org.openanzo.services.services.proxy.ws.";
  protected final String TEXT_64 = "SoapConstants.";
  protected final String TEXT_65 = ".responseQName);" + NL + "\t            String out = output.toString();" + NL + "\t            if (out != null && out.length() > 0) {" + NL + "\t                javax.xml.soap.SOAPElement resultsElement = ret.addChildElement(org.openanzo.services.services.proxy.ws.";
  protected final String TEXT_66 = "SoapConstants.";
  protected final String TEXT_67 = ".resultsName);" + NL + "\t                org.openanzo.serialization.SoapSerializationUtils.serializeStringToElement(out, resultsElement);" + NL + "\t            }" + NL + "\t            org.apache.axis.message.SOAPBodyElement[] element = new org.apache.axis.message.SOAPBodyElement[] { ret };" + NL + "\t            return element;" + NL + "\t        }finally{" + NL + "       \t\t\tif (repositoryServlet.get";
  protected final String TEXT_68 = "().getStatistics()!=null&&repositoryServlet.get";
  protected final String TEXT_69 = "().getStatistics().isEnabled()) {" + NL + "            \t    repositoryServlet.get";
  protected final String TEXT_70 = "().getStatistics().get";
  protected final String TEXT_71 = "Duration().addTime((System.currentTimeMillis() - start));" + NL + "           \t \t}" + NL + "    \t\t}" + NL + "        } catch (javax.xml.soap.SOAPException e) {" + NL + "            log.error(org.openanzo.rdf.utils.LogUtils.WS_EXCEPTION_FOLLOWS, e);" + NL + "            throw new org.openanzo.exceptions.AnzoAxisFault( ExceptionConstants.IO.SOAP_ERROR, e.getMessage());" + NL + "        } catch (org.openanzo.exceptions.AnzoException e) {" + NL + "            log.info(org.openanzo.rdf.utils.LogUtils.EXCEPTION_FOLLOWS, e);" + NL + "            throw new org.openanzo.exceptions.AnzoAxisFault(e);" + NL + "        } catch (org.openanzo.exceptions.AnzoRuntimeException e) {" + NL + "            log.error(org.openanzo.rdf.utils.LogUtils.EXCEPTION_FOLLOWS, e);" + NL + "            throw new org.openanzo.exceptions.AnzoAxisFault(e);" + NL + "        } catch (Throwable e) {" + NL + "            log.error(org.openanzo.rdf.utils.LogUtils.WS_EXCEPTION_FOLLOWS, e);" + NL + "            throw new org.openanzo.exceptions.AnzoAxisFault(ExceptionConstants.IO.SOAP_ERROR, e.getMessage());" + NL + "        }" + NL + "" + NL + "\t}";
  protected final String TEXT_72 = NL + "}";
  protected final String TEXT_73 = NL;

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
     @SuppressWarnings("unchecked") // marshal argument 
     java.util.List<Service> services = (java.util.List<Service>)argument; 
    stringBuffer.append(TEXT_6);
     for(Service service:services){ if(service.getAvailableOverWS()!=null&&service.getAvailableOverWS()){
    
	for(Operation operation:JastorUtils.sortByTitle(service.getOperation())){


	Parameter result=null;
	String resultDefaultFormat=null;
	boolean resultHasDefaultFormat=false;
	Iterator<Parameter> results=operation.getResult().iterator();
	if (results.hasNext()){
		result=results.next();
		if(result!=null){
			resultDefaultFormat=(result.getType().getDefaultJMSFormat()!=null)?result.getType().getDefaultJMSFormat().getJavaType():null;
			resultHasDefaultFormat=(resultDefaultFormat!=null);
		}
	}
	Parameter parameters[]=new Parameter[8];
	String parameterName[]=new String[8];
	String javaType[]=new String[8];
	String type[]=new String[8];
	String defaultValue[]=new String[8];
	boolean nullAllowed[]=new boolean[8];
	String defaultFormat[]=new String[8];
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
			parameterName[i]=parameters[i].getName();
			if(parameters[i].getType()!=null){
				type[i]=javaType[i]=parameters[i].getType().getJavaType();
				defaultValue[i]=parameters[i].getType().getDefaultValue();
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
				Boolean nullAllowedBoolean=parameters[i].getNullAllowed();
				nullAllowed[i]=(nullAllowedBoolean!=null)?nullAllowedBoolean.booleanValue():true;
				defaultFormat[i]=(parameters[i].getType().getDefaultWSFormat()!=null)?parameters[i].getType().getDefaultWSFormat().getJavaType():null;

			}
		}
	}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_13);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(resultDefaultFormat);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_20);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_24);
    if(!nullAllowed[i]){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_28);
    }
    if(defaultFormat[i]!=null){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(defaultFormat[i]);
    stringBuffer.append(TEXT_37);
    }
    if(propertyLocation[i]==1){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_41);
    readerParam=i;
    }else {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(javaType[i]);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_44);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(serializer[i]);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_49);
    if(defaultFormat[i]!=null){
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_50);
    }else{
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    }
    }}
    stringBuffer.append(TEXT_55);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_57);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(parameterName[i]);
    }
    if(defaultFormat[i]!=null&&readerParam==i){
    stringBuffer.append(TEXT_59);
    stringBuffer.append(parameterName[readerParam]);
    stringBuffer.append(TEXT_60);
    }
    }
    stringBuffer.append(TEXT_61);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_71);
    }}}
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    return stringBuffer.toString();
  }
}
