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
public class ServicesCombusListenerTemplate
{
  protected static String nl;
  public static synchronized ServicesCombusListenerTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServicesCombusListenerTemplate result = new ServicesCombusListenerTemplate();
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
  protected final String TEXT_7 = ";" + NL + "import javax.jms.MessageProducer;" + NL + "import javax.jms.Destination;" + NL + "import javax.jms.JMSException;" + NL + "import javax.jms.TextMessage;" + NL + "" + NL + "import org.openanzo.combus.endpoint.BaseServiceListener;" + NL + "import org.openanzo.exceptions.AnzoException;" + NL + "import org.openanzo.exceptions.ExceptionConstants;" + NL + "import org.openanzo.rdf.Constants;" + NL + "import org.openanzo.services.IOperationContext;" + NL + "import ";
  protected final String TEXT_8 = ".IAuthenticationService;" + NL + "" + NL + " /**" + NL + " * ";
  protected final String TEXT_9 = " combus listener interface" + NL + " * @author Generated Code" + NL + " */" + NL + "" + NL + "public class Combus";
  protected final String TEXT_10 = "Listener extends BaseServiceListener {" + NL + "\t/** Service's Name in {@link String} form */" + NL + "    public static final String SERVICE_ENDPOINT_NAME = Constants.NAMESPACES.SERVICE_PREFIX + \"Combus";
  protected final String TEXT_11 = "Listener\";" + NL + "" + NL + "" + NL + "    /** Stats for object*/" + NL + "    protected org.openanzo.services.DynamicServiceStats stats=null;" + NL + "" + NL + "   /** Service interface*/" + NL + "    protected ";
  protected final String TEXT_12 = ".I";
  protected final String TEXT_13 = " i";
  protected final String TEXT_14 = "=null;" + NL + "    " + NL + "    /**Queue Name Prefix*/" + NL + "    protected String queueNamePrefix=null;" + NL + "" + NL + "    /**" + NL + "     * Create a new JMS";
  protected final String TEXT_15 = "Listener" + NL + "     * @param authenticationService Authentication service used by this listener" + NL + "     * @param _service Service for which listener is handling requests" + NL + "     * @param queueNamePrefix Prefix for the queue name on which this listener is listening" + NL + "     */" + NL + "    public Combus";
  protected final String TEXT_16 = "Listener(IAuthenticationService authenticationService,";
  protected final String TEXT_17 = ".I";
  protected final String TEXT_18 = " _service,String queueNamePrefix) {" + NL + "        super(SERVICE_ENDPOINT_NAME,authenticationService);" + NL + "        this.i";
  protected final String TEXT_19 = " =_service;" + NL + "        this.queueNamePrefix=queueNamePrefix;" + NL + "        stats=new org.openanzo.services.DynamicServiceStats(";
  protected final String TEXT_20 = ".I";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ",";
  protected final String TEXT_23 = ");" + NL + "    }" + NL + "" + NL + "    /**" + NL + "     *  Statistics object for this service" + NL + "     * @return the stats object for this service" + NL + "     */" + NL + "    public org.openanzo.services.DynamicServiceStats getStatistics(){" + NL + "    \treturn stats;" + NL + "    }" + NL + "" + NL + "    public String getQueueName() {" + NL + "        return \"services/\"+((queueNamePrefix!=null)?queueNamePrefix:\"\")+\"";
  protected final String TEXT_24 = "\";" + NL + "    }" + NL + "" + NL + "   " + NL + "    public TextMessage handleMessage(IOperationContext context, Destination replyTo, String resultFormat, String operation, TextMessage request, MessageProducer messageProducer) throws JMSException, AnzoException {" + NL + "        verifyCaller(context);" + NL + "        TextMessage response = null;" + NL;
  protected final String TEXT_25 = "}else ";
  protected final String TEXT_26 = "if(";
  protected final String TEXT_27 = ".I";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ".equals(operation)){" + NL + "\t\t  \tlong start=0;" + NL + "        \tif (stats.isEnabled()) {" + NL + "            \tstart = System.currentTimeMillis();" + NL + "       \t\t}" + NL + "        \ttry{";
  protected final String TEXT_30 = "        \t" + NL + "                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);";
  protected final String TEXT_31 = NL + "\t\t\t\tboolean ";
  protected final String TEXT_32 = "FormatExists=request.propertyExists(";
  protected final String TEXT_33 = ".I";
  protected final String TEXT_34 = ".PARAM_";
  protected final String TEXT_35 = "Format);" + NL + "\t\t\t\tString ";
  protected final String TEXT_36 = "Format=(";
  protected final String TEXT_37 = "FormatExists)?request.getStringProperty(";
  protected final String TEXT_38 = ".I";
  protected final String TEXT_39 = ".PARAM_";
  protected final String TEXT_40 = "Format):";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = NL + "\t\t\t\tString ";
  protected final String TEXT_43 = "=request.getText();" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\tif(";
  protected final String TEXT_45 = "==null){" + NL + "\t\t\t\t\t throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,";
  protected final String TEXT_46 = ".I";
  protected final String TEXT_47 = ".PARAM_";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_49 = NL + "\t\t\t\tboolean ";
  protected final String TEXT_50 = "Exists=request.propertyExists(";
  protected final String TEXT_51 = ".I";
  protected final String TEXT_52 = ".PARAM_";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "\t\t\t\tif(!";
  protected final String TEXT_55 = "Exists){" + NL + "\t\t\t\t\t throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,";
  protected final String TEXT_56 = ".I";
  protected final String TEXT_57 = ".PARAM_";
  protected final String TEXT_58 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_59 = NL + "                ";
  protected final String TEXT_60 = " ";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = "(";
  protected final String TEXT_63 = "Exists)?";
  protected final String TEXT_64 = ".deserialize(messageWrapper,";
  protected final String TEXT_65 = ".I";
  protected final String TEXT_66 = ".PARAM_";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = "Format";
  protected final String TEXT_69 = "null";
  protected final String TEXT_70 = ")";
  protected final String TEXT_71 = ":";
  protected final String TEXT_72 = ":null";
  protected final String TEXT_73 = ";" + NL + "\t";
  protected final String TEXT_74 = NL + "\t\t\t\tjava.util.Collection<org.openanzo.rdf.Statement> trackers = org.openanzo.rdf.utils.ReadWriteUtils.readStatements(namedGraphs, org.openanzo.rdf.RDFFormat.forMIMEType(namedGraphsFormat));" + NL + "                org.openanzo.combus.listeners.BatchedReplicationHandler handler = new org.openanzo.combus.listeners.BatchedReplicationHandler(batchSize, replyTo, resultFormat, operation, request, session, mp,recorder);" + NL + "                this.iReplicationService.replicate(context, trackers, handler,batchSize);";
  protected final String TEXT_75 = "\t\t\t\t" + NL + "\t\t\t\tjava.io.StringWriter output = new java.io.StringWriter();" + NL + "\t\t        this.i";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = "(context";
  protected final String TEXT_78 = ",";
  protected final String TEXT_79 = ",";
  protected final String TEXT_80 = "Format";
  protected final String TEXT_81 = ", output";
  protected final String TEXT_82 = ",resultFormat";
  protected final String TEXT_83 = ");" + NL + "\t\t        response = session.createTextMessage();" + NL + "\t\t        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);" + NL + "\t\t        String out = output.toString();" + NL + "\t\t        if (out.length() > 0) {" + NL + "\t\t            response.setText(output.toString());" + NL + "\t\t        }";
  protected final String TEXT_84 = NL + "\t\t\t}finally{" + NL + "       \t\t\tif (stats.isEnabled()) {" + NL + "            \t    stats.use(\"";
  protected final String TEXT_85 = "\",(System.currentTimeMillis() - start));" + NL + "           \t \t}" + NL + "        \t}";
  protected final String TEXT_86 = NL + "\t\t} else {" + NL + "\t    \tthrow new AnzoException(ExceptionConstants.SERVER.UNKNOWN_OPERATION_ERROR, operation);" + NL + "\t    }" + NL + "\t    return response;" + NL + "    }" + NL + "}";
  protected final String TEXT_87 = NL;

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
     ServerServiceWrapper wrapper=(ServerServiceWrapper)argument;Service service = wrapper.service; 
     Boolean isDs=service.getIsDatasourceService(); if(isDs==null)isDs=false;
    stringBuffer.append(TEXT_6);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getCombusPackage()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getInterfacePackage()));
    stringBuffer.append(TEXT_8);
     if(service.getPropertyValue(DC.TITLE)!=null){
    stringBuffer.append(JastorUtils.getStingValue(service.getPropertyValue(DC.TITLE)));
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_19);
    for(Iterator<Operation> operations=JastorUtils.sortByTitle(service.getOperation()).iterator();operations.hasNext();){
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(operations.next().getName()));
    if(operations.hasNext()){
    stringBuffer.append(TEXT_22);
    }}
    stringBuffer.append(TEXT_23);
    stringBuffer.append(service.getJmsQueueName());
    stringBuffer.append(TEXT_24);
    
	boolean firstOp=true;
	for(Operation operation:JastorUtils.sortByTitle(service.getOperation())){


	Parameter result=null;
	boolean resultHasDefaultFormat=false;

	Iterator<Parameter> results=operation.getResult().iterator();
	if (results.hasNext()){
		result=results.next();
		if(result!=null){
			resultHasDefaultFormat=result.getType().getDefaultJMSFormat()!=null||result.getType().getDefaultRestFormat()!=null||result.getType().getDefaultWSFormat()!=null;
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
	boolean callback=false;
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
					callback=true;
				}
				Boolean nullAllowedBoolean=parameters[i].getNullAllowed();
				nullAllowed[i]=(nullAllowedBoolean!=null)?nullAllowedBoolean.booleanValue():true;
				defaultFormat[i]=(parameters[i].getType().getDefaultJMSFormat()!=null)?parameters[i].getType().getDefaultJMSFormat().getJavaType():null;

			}
		}
	}

    if(!firstOp){
    stringBuffer.append(TEXT_25);
    }else{
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(operation.getName()));
    stringBuffer.append(TEXT_29);
    
	for(int i=0;i<8;i++){
		if(javaType[i]!=null&&propertyLocation[i]==0){
    stringBuffer.append(TEXT_30);
    		break;}}
    
	for(int i=0;i<8;i++){
		if(javaType[i]!=null){

    if(defaultFormat[i]!=null){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(defaultFormat[i]);
    stringBuffer.append(TEXT_41);
    }
    if(propertyLocation[i]==1){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_43);
    readerParam=i;
    if(!nullAllowed[i]&&javaType[i]!=null){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_48);
    }
    }else if(propertyLocation[i]==0){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_53);
    if(!nullAllowed[i]){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(javaType[i]);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_61);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_62);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(serializer[i]);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(((isDs)?"org/openanzo/datasource/":wrapper.task.getInterfacePackage())));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_67);
    if(defaultFormat[i]!=null){
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_68);
    }else{
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    if(nullAllowed[i]){
    if(defaultValue[i]!=null){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(defaultValue[i]);
    }else{
    stringBuffer.append(TEXT_72);
    }}
    stringBuffer.append(TEXT_73);
    }}}
    if(callback){
    stringBuffer.append(TEXT_74);
    }else{
    stringBuffer.append(TEXT_75);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_77);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(parameterName[i]);
    }
    if(defaultFormat[i]!=null&&readerParam==i){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(parameterName[readerParam]);
    stringBuffer.append(TEXT_80);
    }
    }
    stringBuffer.append(TEXT_81);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    }
    firstOp=false;
    stringBuffer.append(TEXT_84);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TEXT_87);
    return stringBuffer.toString();
  }
}
