package org.openanzo.jet.services;

import java.util.Iterator;

import org.openanzo.ontologies.system.Format;
import org.openanzo.ontologies.system.Operation;
import org.openanzo.ontologies.system.Parameter;
import org.openanzo.ontologies.system.Service;
import org.openanzo.ontologies.system.SystemFactory;
import org.openanzo.rdf.INamedGraph;
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
public class ServicesWikiTemplate
{
  protected static String nl;
  public static synchronized ServicesWikiTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServicesWikiTemplate result = new ServicesWikiTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "[[PageOutline]]";
  protected final String TEXT_2 = NL + "= ";
  protected final String TEXT_3 = " =" + NL;
  protected final String TEXT_4 = " [[BR]] [[BR]]";
  protected final String TEXT_5 = "'''Java Interface Name''': ";
  protected final String TEXT_6 = " [[BR]]";
  protected final String TEXT_7 = NL + "=== '''";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = "''' ===" + NL;
  protected final String TEXT_10 = " [[BR]] [[BR]]";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = "'''User Must be in sysadmin role:''' ";
  protected final String TEXT_13 = " [[BR]]";
  protected final String TEXT_14 = "'''Rest Info'''[[BR]]" + NL + " Rest Endpoint URL: !http://host[:port]";
  protected final String TEXT_15 = " [[BR]]";
  protected final String TEXT_16 = NL + " Rest Method Type: ";
  protected final String TEXT_17 = " [[BR]]";
  protected final String TEXT_18 = NL + "'''!WebService Info'''[[BR]]" + NL + " !WebService call name: !";
  protected final String TEXT_19 = " [[BR]]";
  protected final String TEXT_20 = NL + "'''JMS Info'''[[BR]]" + NL + " JMS Queue Name: ";
  protected final String TEXT_21 = " [[BR]]" + NL + " JMS Operation Name: ";
  protected final String TEXT_22 = " [[BR]]";
  protected final String TEXT_23 = NL + "==== Request Parameters ====" + NL + "" + NL + "||Paremeter Name||Description||Type||Valid Formats||Default Formats||";
  protected final String TEXT_24 = NL + "||";
  protected final String TEXT_25 = "JMS: (body) [[BR]] REST: (body) [[BR]] WS:";
  protected final String TEXT_26 = " ";
  protected final String TEXT_27 = "!";
  protected final String TEXT_28 = " ";
  protected final String TEXT_29 = "||";
  protected final String TEXT_30 = "||";
  protected final String TEXT_31 = "||";
  protected final String TEXT_32 = "[";
  protected final String TEXT_33 = " ";
  protected final String TEXT_34 = "] [[BR]] ";
  protected final String TEXT_35 = " ||";
  protected final String TEXT_36 = "JMS:  [";
  protected final String TEXT_37 = " ";
  protected final String TEXT_38 = "] [[BR]] ";
  protected final String TEXT_39 = "Rest:  [";
  protected final String TEXT_40 = " ";
  protected final String TEXT_41 = "] [[BR]] ";
  protected final String TEXT_42 = "WS:  [";
  protected final String TEXT_43 = " ";
  protected final String TEXT_44 = "] [[BR]] ";
  protected final String TEXT_45 = "||";
  protected final String TEXT_46 = NL + "||";
  protected final String TEXT_47 = "Format|| Serialization format for ";
  protected final String TEXT_48 = "|| String || || || ";
  protected final String TEXT_49 = NL + "|| resultFormat || Serialization format for response || String || || ||";
  protected final String TEXT_50 = NL + "[[BR]]";
  protected final String TEXT_51 = NL + "==== Response Body ====" + NL + "||Description||Type||Valid Formats||Default Formats||" + NL + "||";
  protected final String TEXT_52 = "||";
  protected final String TEXT_53 = "||";
  protected final String TEXT_54 = "[";
  protected final String TEXT_55 = " ";
  protected final String TEXT_56 = "] [[BR]] ";
  protected final String TEXT_57 = " ||";
  protected final String TEXT_58 = "JMS:  [";
  protected final String TEXT_59 = " ";
  protected final String TEXT_60 = "] [[BR]] ";
  protected final String TEXT_61 = "Rest:  [";
  protected final String TEXT_62 = " ";
  protected final String TEXT_63 = "] [[BR]] ";
  protected final String TEXT_64 = "WS:  [";
  protected final String TEXT_65 = " ";
  protected final String TEXT_66 = "] [[BR]] ";
  protected final String TEXT_67 = "||";
  protected final String TEXT_68 = NL + "[[BR]]";
  protected final String TEXT_69 = NL + "[[BR]]";

	/**
	* Generate source code
	* @param argument source for template
	* @return Return generated source
    */
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - initial API and implementation     
 *******************************************************************************/ 

    stringBuffer.append(TEXT_1);
     INamedGraph graph = (INamedGraph)argument; 
     java.util.List<Service> services=SystemFactory.getAllService(graph);
     Iterator<Service> servicesSorted=JastorUtils.sortByTitle(services).iterator(); 
     while(servicesSorted.hasNext()) {
     Service service=servicesSorted.next(); 
    stringBuffer.append(TEXT_2);
     if(service.getPropertyValue(DC.TITLE)!=null){
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(service.getPropertyValue(DC.TITLE))));
    }else{
    stringBuffer.append(WikiFormatUtils.formatTitleString(service.resource().toString()));
    }
    stringBuffer.append(TEXT_3);
     if(service.getPropertyValue(DC.DESCRIPTION)!=null){
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(service.getPropertyValue(DC.DESCRIPTION))));
    stringBuffer.append(TEXT_4);
    }
     if(service.get_interface()!=null){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(service.get_interface());
    stringBuffer.append(TEXT_6);
    }
    for(Operation operation:JastorUtils.sortByTitle(service.getOperation())){
    
	Parameter result=null;
	String resultType=null;
	String resultDescription=null;
	boolean resultHasDefaultFormat=false;
	Iterator<Parameter> results=operation.getResult().iterator();
	if (results.hasNext()){
		result=results.next();
		if(result!=null){
			resultType=(result.getType().getJavaType()!=null)?result.getType().getJavaType():result.getType().resource().toString();
			resultHasDefaultFormat=result.getType().getDefaultJMSFormat()!=null||result.getType().getDefaultRestFormat()!=null||result.getType().getDefaultWSFormat()!=null;
			if(result.getPropertyValue(DC.DESCRIPTION)!=null){
				resultDescription=WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(result.getPropertyValue(DC.DESCRIPTION)));
			}
		}
	}

    stringBuffer.append(TEXT_7);
     if(operation.getPropertyValue(DC.TITLE)!=null){
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(operation.getPropertyValue(DC.TITLE))));
    }else{
    stringBuffer.append(WikiFormatUtils.formatTitleString(operation.resource().toString()));
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
     if(operation.getPropertyValue(DC.DESCRIPTION)!=null){
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(operation.getPropertyValue(DC.DESCRIPTION))));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
     if(operation.getSysadminRequired()!=null){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(operation.getSysadminRequired());
    stringBuffer.append(TEXT_13);
    }
     if(operation.getRestEndpoint()!=null){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(operation.getRestEndpoint());
    stringBuffer.append(TEXT_15);
    }
     if(operation.getRestType()!=null){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(operation.getRestType());
    stringBuffer.append(TEXT_17);
    }
     if(operation.getWsOperation()!=null){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(operation.getWsOperation());
    stringBuffer.append(TEXT_19);
    }
     if(service.getJmsQueueName()!=null){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(service.getJmsQueueName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(operation.getName());
    stringBuffer.append(TEXT_22);
    }
    Iterator<Parameter> parameters=JastorUtils.sortByTitle(operation.getRequestParameter()).iterator();
    if (parameters.hasNext()||resultHasDefaultFormat){
    stringBuffer.append(TEXT_23);
    while(parameters.hasNext()){
    Parameter parameter=parameters.next();
    
	String location=parameter.getParameterLocation();
	int propertyLocation=0;
	if(location==null){
		propertyLocation=0;
	}else if("body".equals(location)){
		propertyLocation=1;
	}else if("parameter".equals(location)){
		propertyLocation=0;
	}else if("transport".equals(location)){
		propertyLocation=2;
	}else if("callbackHandler".equals(location)){
		propertyLocation=-1;
	}


    stringBuffer.append(TEXT_24);
     if(propertyLocation==1){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_26);
    }else{
    if(parameter.getName()!=null){
    stringBuffer.append(parameter.getName());
    }else{
    stringBuffer.append(TEXT_27);
    stringBuffer.append(parameter.resource().toString());
    stringBuffer.append(TEXT_28);
    }}
    stringBuffer.append(TEXT_29);
     if(parameter.getPropertyValue(DC.DESCRIPTION)!=null){
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(parameter.getPropertyValue(DC.DESCRIPTION))));
    }
    stringBuffer.append(TEXT_30);
     if(parameter.getType()!=null){
    stringBuffer.append(WikiFormatUtils.formatTitleString(parameter.getType().getName()));
    }
    stringBuffer.append(TEXT_31);
    if(parameter.getType()!=null){Iterator<Format> validFormats=parameter.getType().getValidFormat().iterator();while(validFormats.hasNext()){Format format=validFormats.next();
    stringBuffer.append(TEXT_32);
    stringBuffer.append(format.getLocation());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(format.getPropertyValue(DC.TITLE))));
    stringBuffer.append(TEXT_34);
    }}
    stringBuffer.append(TEXT_35);
     if(parameter.getType()!=null){ Format jmsFormat=parameter.getType().getDefaultJMSFormat();if(jmsFormat!=null){Format format=jmsFormat;
    stringBuffer.append(TEXT_36);
    stringBuffer.append(format.getLocation());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(format.getPropertyValue(DC.TITLE))));
    stringBuffer.append(TEXT_38);
    }Format restFormat=parameter.getType().getDefaultRestFormat();if(restFormat!=null){Format format=restFormat;
    stringBuffer.append(TEXT_39);
    stringBuffer.append(format.getLocation());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(format.getPropertyValue(DC.TITLE))));
    stringBuffer.append(TEXT_41);
    }Format wsFormat=parameter.getType().getDefaultWSFormat();if(wsFormat!=null){Format format=wsFormat;
    stringBuffer.append(TEXT_42);
    stringBuffer.append(format.getLocation());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(format.getPropertyValue(DC.TITLE))));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
     if(parameter.getName()!=null&&(parameter.getType().getDefaultJMSFormat()!=null||parameter.getType().getDefaultRestFormat()!=null||parameter.getType().getDefaultWSFormat()!=null)){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_48);
    }}}
    if(resultHasDefaultFormat){
    stringBuffer.append(TEXT_49);
    }}
    stringBuffer.append(TEXT_50);
    if (result!=null){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(resultDescription);
    stringBuffer.append(TEXT_52);
     if(resultType!=null){
    stringBuffer.append(WikiFormatUtils.formatTitleString(resultType));
    }
    stringBuffer.append(TEXT_53);
    if(resultType!=null){java.util.Iterator<Format> validFormats=result.getType().getValidFormat().iterator();while(validFormats.hasNext()){Format format=validFormats.next();
    stringBuffer.append(TEXT_54);
    stringBuffer.append(format.getLocation());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(format.getPropertyValue(DC.TITLE))));
    stringBuffer.append(TEXT_56);
    }}
    stringBuffer.append(TEXT_57);
     if(result.getType()!=null){ Format jmsFormat=result.getType().getDefaultJMSFormat();if(jmsFormat!=null){Format format=jmsFormat;
    stringBuffer.append(TEXT_58);
    stringBuffer.append(format.getLocation());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(format.getPropertyValue(DC.TITLE))));
    stringBuffer.append(TEXT_60);
    }Format restFormat=result.getType().getDefaultRestFormat();if(restFormat!=null){Format format=restFormat;
    stringBuffer.append(TEXT_61);
    stringBuffer.append(format.getLocation());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(format.getPropertyValue(DC.TITLE))));
    stringBuffer.append(TEXT_63);
    }Format wsFormat=result.getType().getDefaultWSFormat();if(wsFormat!=null){Format format=wsFormat;
    stringBuffer.append(TEXT_64);
    stringBuffer.append(format.getLocation());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(WikiFormatUtils.formatTitleString(JastorUtils.getStingValue(format.getPropertyValue(DC.TITLE))));
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    }}
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    }
    return stringBuffer.toString();
  }
}
