package org.openanzo.jet.services;

import java.util.Iterator;

import org.apache.commons.collections15.multimap.MultiHashMap;
import org.openanzo.jet.services.RestOperation.RequestType;
import org.openanzo.ontologies.system.Operation;
import org.openanzo.ontologies.system.Parameter;
import org.openanzo.ontologies.system.Service;
import org.openanzo.rdf.jastor.JastorUtils;
import org.openanzo.rdf.utils.SerializationConstants;
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
public class ServicesRestListenerTemplate
{
  protected static String nl;
  public static synchronized ServicesRestListenerTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServicesRestListenerTemplate result = new ServicesRestListenerTemplate();
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
  protected final String TEXT_8 = ";" + NL + "//import java.io.StringWriter;" + NL + "" + NL + "import org.openanzo.exceptions.AnzoException;" + NL + "import org.openanzo.rdf.Constants;" + NL + "import org.openanzo.services.IOperationContext;" + NL + "import org.openanzo.rdf.URI;" + NL + "import org.openanzo.rdf.utils.RequestType;";
  protected final String TEXT_9 = NL + " /**" + NL + " * ";
  protected final String TEXT_10 = " rest listener interface" + NL + " * @author Generated Code" + NL + " */" + NL + "public class Rest";
  protected final String TEXT_11 = "Listener extends org.openanzo.services.BaseContainerComponent implements org.openanzo.rest.IRestEndpointHandler {" + NL + "\t/** Service's Name in {@link String} form */" + NL + "    public static final String SERVICE_ENDPOINT_NAME = Constants.NAMESPACES.SERVICE_PREFIX + \"Combus";
  protected final String TEXT_12 = "Listener\";" + NL + "" + NL + "    /** Service's Name in {@link URI} form */" + NL + "    public static final URI    SERVICE_ENDPOINT_URI  = Constants.valueFactory.createURI(SERVICE_ENDPOINT_NAME);" + NL + "" + NL + "    /** Stats for object*/" + NL + "    protected ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = "Stats stats=null;" + NL + "" + NL + "   /** Service interface*/" + NL + "    protected ";
  protected final String TEXT_15 = ".I";
  protected final String TEXT_16 = " i";
  protected final String TEXT_17 = "=null;" + NL + "" + NL + "    protected org.apache.commons.collections15.multimap.MultiHashMap<String, String> operationMethods = new org.apache.commons.collections15.multimap.MultiHashMap<String, String>();" + NL + NL;
  protected final String TEXT_18 = NL + "    /** Constant for operation ";
  protected final String TEXT_19 = " */" + NL + "    public static final String OP_";
  protected final String TEXT_20 = " = \"";
  protected final String TEXT_21 = "\";" + NL;
  protected final String TEXT_22 = NL + "    /** Constant for method ";
  protected final String TEXT_23 = "*/" + NL + "    public static final String METHOD_";
  protected final String TEXT_24 = " = \"";
  protected final String TEXT_25 = "\";";
  protected final String TEXT_26 = NL + NL + NL + "    /**" + NL + "     * Create a new JMS";
  protected final String TEXT_27 = "Proxy" + NL + "     *" + NL + "     */" + NL + "    public Rest";
  protected final String TEXT_28 = "Listener(";
  protected final String TEXT_29 = ".I";
  protected final String TEXT_30 = " _service) {" + NL + "        super();" + NL + "        this.i";
  protected final String TEXT_31 = " = _service;" + NL + "        stats=new ";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = "Stats();";
  protected final String TEXT_34 = NL + "        operationMethods.put(";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "    }" + NL + "" + NL + "    public org.apache.commons.collections15.multimap.MultiHashMap<String, String> getMethodOperations(){" + NL + "    \treturn operationMethods;" + NL + "    }" + NL + "" + NL + "    public org.openanzo.rdf.URI getURI(){" + NL + "    \treturn SERVICE_ENDPOINT_URI;" + NL + "    }" + NL + "" + NL + "    /** Statistics object for this service*/" + NL + "    public ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = "Stats getStatistics(){" + NL + "    \treturn stats;" + NL + "    }" + NL + "" + NL + "    public void start() throws AnzoException {" + NL + "        if (state == org.openanzo.services.servicesState.INITIALIZED || state == org.openanzo.services.servicesState.STOPPED) {" + NL + "            super.start();" + NL + "        }" + NL + "    }" + NL + "" + NL + "\t@SuppressWarnings(\"unused\")" + NL + "    public boolean handleOperation(IOperationContext context, RequestType type, String objectURI, String method, String operation, String resultFormat, java.util.Map<String, String[]> parameters, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse resp) throws java.io.IOException, AnzoException {" + NL + "         org.openanzo.services.serialization.RestMessageWrapper messageWrapper=new org.openanzo.services.serialization.RestMessageWrapper(parameters);";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = "        }else ";
  protected final String TEXT_42 = "        ";
  protected final String TEXT_43 = " if(";
  protected final String TEXT_44 = "method==null";
  protected final String TEXT_45 = ".equals(method)";
  protected final String TEXT_46 = "){" + NL + "\t\t\tswitch(type){";
  protected final String TEXT_47 = "\t\t\t\t}break;";
  protected final String TEXT_48 = NL + "\t\t\t\tcase ";
  protected final String TEXT_49 = ":" + NL + "\t\t\t\t{";
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = "                    }else ";
  protected final String TEXT_52 = "                   ";
  protected final String TEXT_53 = " if(";
  protected final String TEXT_54 = "operation==null";
  protected final String TEXT_55 = ".equals(operation)";
  protected final String TEXT_56 = "&& objectURI!=null";
  protected final String TEXT_57 = "){" + NL + "\t\t\t\t\t\tlong start=0;" + NL + "\t\t\t        \tif (stats.isEnabled()) {" + NL + "\t\t\t            \tstart = System.currentTimeMillis();" + NL + "\t\t\t            \tstats.get";
  protected final String TEXT_58 = "Use().increment();" + NL + "\t\t\t       \t\t}" + NL + "\t\t\t        \ttry{";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\t\tString[] ";
  protected final String TEXT_60 = "FormatStrings = parameters.get(";
  protected final String TEXT_61 = ".I";
  protected final String TEXT_62 = ".PARAM_";
  protected final String TEXT_63 = "Format);" + NL + "\t  \t\t\t\t\t\tboolean ";
  protected final String TEXT_64 = "FormatExists=(";
  protected final String TEXT_65 = "FormatStrings!=null&&";
  protected final String TEXT_66 = "FormatStrings.length>0);" + NL + "\t\t\t\t\t\t\tString ";
  protected final String TEXT_67 = "Format=(";
  protected final String TEXT_68 = "FormatExists)?";
  protected final String TEXT_69 = "FormatStrings[0]:";
  protected final String TEXT_70 = ";";
  protected final String TEXT_71 = NL + "\t\t\t\t\t\t\tString ";
  protected final String TEXT_72 = " =  org.apache.commons.io.IOUtils.toString(request.getReader());";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t\tboolean ";
  protected final String TEXT_74 = "Exists=messageWrapper.hasProperty(";
  protected final String TEXT_75 = ".I";
  protected final String TEXT_76 = ".PARAM_";
  protected final String TEXT_77 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = " = ";
  protected final String TEXT_80 = "(";
  protected final String TEXT_81 = "Exists)?";
  protected final String TEXT_82 = ".deserialize(messageWrapper,";
  protected final String TEXT_83 = ".I";
  protected final String TEXT_84 = ".PARAM_";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = "Format";
  protected final String TEXT_87 = "null";
  protected final String TEXT_88 = ")";
  protected final String TEXT_89 = ":null";
  protected final String TEXT_90 = ";";
  protected final String TEXT_91 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_92 = " ";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = ".deserialize(objectURI,null);";
  protected final String TEXT_95 = NL + "\t\t\t\t\t   \t \tthis.i";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = "(context";
  protected final String TEXT_98 = ",";
  protected final String TEXT_99 = ",";
  protected final String TEXT_100 = "Format";
  protected final String TEXT_101 = ", resp.getWriter()";
  protected final String TEXT_102 = ",resultFormat";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t\t    \treturn true;" + NL + "\t\t\t\t\t\t}finally{" + NL + "\t\t\t\t       \t\tif (stats.isEnabled()) {" + NL + "\t\t\t\t                stats.get";
  protected final String TEXT_104 = "Duration().addTime((System.currentTimeMillis() - start));" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }";
  protected final String TEXT_105 = NL + "\t\t\t\t\t}";
  protected final String TEXT_106 = NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}";
  protected final String TEXT_107 = NL + "\t\t}" + NL + "\t    return false;" + NL + "" + NL + "    }" + NL + "}";
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
     java.util.regex.Pattern objectPattern = java.util.regex.Pattern.compile("^/anzo/([a-zA-Z]*)?((\\((\\?[a-zA-Z]*)\\))?(/(([a-zA-Z]*)))?)?$");
    stringBuffer.append(TEXT_9);
     if(service.getPropertyValue(DC.TITLE)!=null){
    stringBuffer.append(JastorUtils.getStingValue(service.getPropertyValue(DC.TITLE)));
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getStatsPackage()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getInterfacePackage()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_17);
    
	java.util.HashMap<String, java.util.HashMap<RequestType, java.util.Collection<RestOperation>>> methods = new java.util.HashMap<String, java.util.HashMap<RequestType, java.util.Collection<RestOperation>>>();
	java.util.HashSet<String> operationNames=new java.util.HashSet<String>();
	for(Operation operation:JastorUtils.sortByTitle(service.getOperation())){

		String opTemplate=operation.getRestEndpoint();
 		java.util.regex.Matcher match = objectPattern.matcher(opTemplate);
 		if (match.matches()) {
            String method = null;
            String op = null;
            if (match.groupCount()>0&&match.group(1) != null) {
                method = match.group(1);
            }
            if (match.groupCount()>6&&match.group(6) != null) {
                op = match.group(6);
            }
            if(op!=null&&!operationNames.contains(op)){
            	operationNames.add(op);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(op);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(op));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(op);
    stringBuffer.append(TEXT_21);
            }
            java.util.HashMap<RequestType, java.util.Collection<RestOperation>> typeMaps = methods.get("METHOD_"+org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(method));
            if (typeMaps == null) {
                java.util.HashMap<RequestType, java.util.Collection<RestOperation>> maps = new java.util.HashMap<RequestType, java.util.Collection<RestOperation>>();
                java.util.Collection<RestOperation> ops = new java.util.TreeSet<RestOperation>();
                ops.add(new RestOperation((op!=null)?op:org.openanzo.rdf.utils.SerializationConstants.NULL_OP,operation,(match.matches()&&match.groupCount()>4&&match.group(4) != null)));

                maps.put(RequestType.valueOf(operation.getRestType()), ops);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(method));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_25);
    
                methods.put("METHOD_"+org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(method), maps);
            } else {
                java.util.Collection<RestOperation> ops = typeMaps.get(RequestType.valueOf(operation.getRestType()));
                if (ops == null) {
                    ops =  new java.util.TreeSet<RestOperation>();
                    typeMaps.put(RequestType.valueOf(operation.getRestType()), ops);
                }
                ops.add(new RestOperation((op!=null)?op:org.openanzo.rdf.utils.SerializationConstants.NULL_OP,operation,(match.matches()&&match.groupCount()>4&&match.group(4) != null)));
            }
       }else{
			java.util.HashMap<RequestType, java.util.Collection<RestOperation>> typeMaps = methods.get(SerializationConstants.NULL_OP);
            if (typeMaps == null) {
                java.util.HashMap<RequestType, java.util.Collection<RestOperation>> maps = new java.util.HashMap<RequestType, java.util.Collection<RestOperation>>();
                java.util.Collection<RestOperation> ops = new java.util.TreeSet<RestOperation>();
                ops.add(new RestOperation(SerializationConstants.NULL_OP,operation,(match.matches()&&match.groupCount()>4&&match.group(4) != null)));
                maps.put(RequestType.valueOf(operation.getRestType()), ops);
                methods.put(SerializationConstants.NULL_OP, maps);
            } else {
                java.util.Collection<RestOperation> ops = typeMaps.get(RequestType.valueOf(operation.getRestType()));
                if (ops == null) {
                    ops = new java.util.TreeSet<RestOperation>();
                    typeMaps.put(RequestType.valueOf(operation.getRestType()), ops);
                }
                ops.add(new RestOperation(SerializationConstants.NULL_OP,operation,(match.matches()&&match.groupCount()>4&&match.group(4) != null)));
            }
		}
	}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getInterfacePackage()));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getStatsPackage()));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_33);
    
	MultiHashMap<String,String> methodOps=new MultiHashMap<String,String>();
	for(java.util.Map.Entry<String,java.util.HashMap<RequestType, java.util.Collection<RestOperation>>> entry:methods.entrySet()){
		for(java.util.Collection<RestOperation> ops:entry.getValue().values()){
			for(RestOperation op:ops){
				if(!methodOps.containsValue(entry.getKey().equals(SerializationConstants.NULL_OP)?"SerializationConstants.NULL_OP":entry.getKey(),(op.operationName!=null&&!op.operationName.equals(SerializationConstants.NULL_OP))?"OP_"+org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(op.operationName):"org.openanzo.rdf.utils.SerializationConstants.NULL_OP")){
					methodOps.put(entry.getKey().equals(SerializationConstants.NULL_OP)?"org.openanzo.rdf.utils.SerializationConstants.NULL_OP":entry.getKey(),(op.operationName!=null&&!op.operationName.equals(SerializationConstants.NULL_OP))?"OP_"+org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(op.operationName):"org.openanzo.rdf.utils.SerializationConstants.NULL_OP");
				}
			}
		}
	}
	for(java.util.Map.Entry<String,java.util.Collection<String>> entry:methodOps.entrySet()){
		for(String opp:entry.getValue()){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(opp);
    stringBuffer.append(TEXT_36);
    }}
    stringBuffer.append(TEXT_37);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getStatsPackage()));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_39);
    boolean firstMethod=true;
for(String key:methods.keySet()) {
	 boolean firstRequestType=true;
	 java.util.HashMap<RequestType,java.util.Collection<RestOperation>> ops=methods.get(key);
    stringBuffer.append(TEXT_40);
    if(!firstMethod){
    stringBuffer.append(TEXT_41);
    }else{
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    if(SerializationConstants.NULL_OP.equals(key)){
    stringBuffer.append(TEXT_44);
    }else{
    stringBuffer.append(key);
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    for(java.util.Map.Entry<RequestType,java.util.Collection<RestOperation>> entry:ops.entrySet()){
    if(!firstRequestType){
    stringBuffer.append(TEXT_47);
    }firstRequestType=false;
    stringBuffer.append(TEXT_48);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_49);
    boolean firstOp=true;
    for(RestOperation restOperation:entry.getValue()){
	Operation operation=restOperation.operation;
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
				defaultFormat[i]=(parameters[i].getType().getDefaultJMSFormat()!=null)?parameters[i].getType().getDefaultJMSFormat().getJavaType():null;

			}
		}
	}

	String opTemplate=operation.getRestEndpoint();
 	java.util.regex.Matcher match = objectPattern.matcher(opTemplate);
 	int uriParam=-1;
 	if (match.matches()) {
      	String param=null;
        if (match.groupCount()>4&&match.group(4) != null) {
            param = match.group(4);
            if(param.startsWith("?")){
            	param=param.substring(1);
                for(int i=0;i<8;i++){
                	if(parameterName[i]!=null&&parameterName[i].equals(param)){
                		uriParam=i;
                	}
                }
           	}
        }
    }

    stringBuffer.append(TEXT_50);
    if(!firstOp){
    stringBuffer.append(TEXT_51);
    }else{
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    if(restOperation.operationName==SerializationConstants.NULL_OP){
    stringBuffer.append(TEXT_54);
    }else{
    stringBuffer.append("OP_"+org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(restOperation.operationName));
    stringBuffer.append(TEXT_55);
    }
    if(uriParam>-1){
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_58);
    for(int i=0;i<8;i++){ Parameter parameter=parameters[i];
    if(defaultFormat[i]!=null){
    stringBuffer.append(TEXT_59);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getInterfacePackage()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(defaultFormat[i]);
    stringBuffer.append(TEXT_70);
    }
    if(parameter!=null&&propertyLocation[i]>-1&&i!=uriParam){
    if(propertyLocation[i]==1){
    readerParam=i;
    stringBuffer.append(TEXT_71);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_72);
    }else{
    stringBuffer.append(TEXT_73);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getInterfacePackage()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(javaType[i]);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_79);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(serializer[i]);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(WikiFormatUtils.convertPackageDirectory(wrapper.task.getInterfacePackage()));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(org.openanzo.rdf.utils.WikiFormatUtils.formatConstantString(parameterName[i]));
    stringBuffer.append(TEXT_85);
    if(defaultFormat[i]!=null){
    stringBuffer.append(parameterName[i]);
    stringBuffer.append(TEXT_86);
    }else{
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    if(nullAllowed[i]){
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    }}}
    if (uriParam>-1){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(javaType[uriParam]);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(parameterName[uriParam]);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(serializer[uriParam]);
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    stringBuffer.append(service.getName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_97);
    for(int i=0;i<8;i++){
    if(parameters[i]!=null&&propertyLocation[i]>-1){
    stringBuffer.append(TEXT_98);
    stringBuffer.append(parameterName[i]);
    }
    if(defaultFormat[i]!=null&&readerParam==i){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(parameterName[readerParam]);
    stringBuffer.append(TEXT_100);
    }
    }
    stringBuffer.append(TEXT_101);
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(WikiFormatUtils.capFirstLetter(operation.getName()));
    stringBuffer.append(TEXT_104);
    firstOp=false;
    }
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    firstMethod=false;
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(TEXT_108);
    return stringBuffer.toString();
  }
}
