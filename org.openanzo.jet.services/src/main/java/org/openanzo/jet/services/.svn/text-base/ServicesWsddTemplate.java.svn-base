package org.openanzo.jet.services;

import org.openanzo.ontologies.system.Operation;
import org.openanzo.ontologies.system.Service;

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
public class ServicesWsddTemplate
{
  protected static String nl;
  public static synchronized ServicesWsddTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServicesWsddTemplate result = new ServicesWsddTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<deployment xmlns=\"http://xml.apache.org/axis/wsdd/\" xmlns:java=\"http://xml.apache.org/axis/wsdd/providers/java\">" + NL + " <globalConfiguration>" + NL + "  <parameter name=\"adminPassword\" value=\"admin\"/>" + NL + "  <parameter name=\"attachments.implementation\" value=\"org.apache.axis.attachments.AttachmentsImpl\"/>" + NL + "  <parameter name=\"sendXsiTypes\" value=\"true\"/>" + NL + "  <parameter name=\"sendMultiRefs\" value=\"true\"/>" + NL + "  <parameter name=\"sendXMLDeclaration\" value=\"true\"/>" + NL + "  <parameter name=\"axis.sendMinimizedElements\" value=\"true\"/>" + NL + "  <requestFlow>" + NL + "    <handler type=\"java:org.apache.axis.handlers.http.HTTPAuthHandler\"/>" + NL + "  </requestFlow>" + NL + " </globalConfiguration>" + NL + " <service name=\"WSListener\" provider=\"java:MSG\" style=\"rpc\" use=\"literal\">" + NL + "  \t<parameter name=\"allowedMethods\" value=\"";
  protected final String TEXT_2 = ",";
  protected final String TEXT_3 = "\"/>" + NL + "  \t<parameter name=\"className\" value=\"org.openanzo.server.endpoint.ws.WSListener\"/>" + NL + "  \t<parameter name=\"scope\" value=\"request\"/>" + NL + "  \t<namespace>http://openanzo.org</namespace>" + NL + " </service>" + NL + "" + NL + "</deployment>";
  protected final String TEXT_4 = NL;

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
     @SuppressWarnings("unchecked") // marshal argument 
     java.util.List<Service> services = (java.util.List<Service>)argument; 
     for(Service service:services){ if(service.getAvailableOverWS()!=null&&service.getAvailableOverWS()){
    for(Operation operation:service.getOperation()){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(operation.getName());
    }}}
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
