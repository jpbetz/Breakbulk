package org.openanzo.rdf.jastor.templates;

import org.openanzo.rdf.Resource;
import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.inference.OntologyClass;
import org.openanzo.rdf.jastor.inference.OntologyProperty;
import org.openanzo.rdf.jastor.jet.OntologyClassFileProvider;
import org.openanzo.rdf.jastor.jet.OntologyClassTemplate;

/*******************************************************************************
 * Copyright (c) 2004, 2009 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/templates/Attic/ontologyclass.skeleton,v $
 * Created by:  Generated Source from Jastor
 * Created on:  7/27/05
 * Revision:	$Id: ontologyclass.skeleton 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
@SuppressWarnings("all")
public class ListenerTemplate implements OntologyClassTemplate {
	
  protected static String nl;
  public static synchronized ListenerTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ListenerTemplate result = new ListenerTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * File:        ";
  protected final String TEXT_2 = "Source";
  protected final String TEXT_3 = NL + " * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Revision:\t";
  protected final String TEXT_4 = "Id";
  protected final String TEXT_5 = NL + " * " + NL + " * Contributors:" + NL + " *     IBM Corporation - initial API and implementation" + NL + " *\t   Cambridge Semantics Incorporated - Fork to Anzo" + NL + " *******************************************************************************/";
  protected final String TEXT_6 = NL + "package ";
  protected final String TEXT_7 = ";" + NL + "" + NL + "/**" + NL + " * Implementations of this listener may be registered with instances of ";
  protected final String TEXT_8 = " to " + NL + " * receive notification when properties changed, added or removed." + NL + " * <br>" + NL + " */" + NL + "public interface ";
  protected final String TEXT_9 = " extends org.openanzo.rdf.jastor.ThingListener {" + NL;
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * Called when ";
  protected final String TEXT_12 = " has changed" + NL + "\t * @param source the affected instance of ";
  protected final String TEXT_13 = NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_14 = "Changed(";
  protected final String TEXT_15 = " source);" + NL;
  protected final String TEXT_16 = NL + "\t/**" + NL + "\t * Called when a value of ";
  protected final String TEXT_17 = " has been added" + NL + "\t * @param source the affected instance of ";
  protected final String TEXT_18 = NL + "\t * @param newValue the object representing the new value" + NL + "\t */\t" + NL + "\tpublic void ";
  protected final String TEXT_19 = "Added(";
  protected final String TEXT_20 = " source, ";
  protected final String TEXT_21 = " newValue);" + NL + "" + NL + "\t/**" + NL + "\t * Called when a value of ";
  protected final String TEXT_22 = " has been removed" + NL + "\t * @param source the affected instance of ";
  protected final String TEXT_23 = NL + "\t * @param oldValue the object representing the removed value" + NL + "\t */\t" + NL + "\tpublic void ";
  protected final String TEXT_24 = "Removed(";
  protected final String TEXT_25 = " source, ";
  protected final String TEXT_26 = " oldValue);" + NL;
  protected final String TEXT_27 = NL + "\t/**" + NL + "\t * Called when ";
  protected final String TEXT_28 = " has changed" + NL + "\t * @param source the affected instance of ";
  protected final String TEXT_29 = NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_30 = "Changed(";
  protected final String TEXT_31 = " source);" + NL;
  protected final String TEXT_32 = NL + "\t/**" + NL + "\t * Called when a value of ";
  protected final String TEXT_33 = " has been added" + NL + "\t * @param source the affected instance of ";
  protected final String TEXT_34 = NL + "\t * @param newValue the object representing the new value" + NL + "\t */\t" + NL + "\tpublic void ";
  protected final String TEXT_35 = "Added(";
  protected final String TEXT_36 = " source, ";
  protected final String TEXT_37 = " newValue);" + NL + "" + NL + "\t/**" + NL + "\t * Called when a value of ";
  protected final String TEXT_38 = " has been removed" + NL + "\t * @param source the affected instance of ";
  protected final String TEXT_39 = NL + "\t * @param oldValue the object representing the removed value" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_40 = "Removed(";
  protected final String TEXT_41 = " source, ";
  protected final String TEXT_42 = " oldValue);" + NL + "\t\t";
  protected final String TEXT_43 = NL + "}";

	OntologyClassFileProvider fileProvider;

	public ListenerTemplate(OntologyClassFileProvider fileProvider) {
		this.fileProvider = fileProvider;
	}
	
	public ListenerTemplate() {
	}
	
	public OntologyClassFileProvider getFileProvider() {
		return fileProvider;
	}	
	
	public void setFileProvider(OntologyClassFileProvider fileProvider) {
		this.fileProvider = fileProvider;
	}

	public String generate(OntologyClass oc)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     JastorContext ctx = oc.getContext(); 
     if(ctx.isIncludeCopyright()){
    stringBuffer.append(TEXT_1);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_2);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_4);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(oc.getPackageName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(oc.getListenerClassname());
    stringBuffer.append(TEXT_9);
     if (!ctx.isGenerateVocabularyOnly()) { 
    stringBuffer.append(TEXT_10);
     	for (OntologyProperty prop: oc.listProperties(true)) {
    			if (prop.isSingleValued() && prop.isDatatypeProperty()) { 
    				// if (!(prop.getRole() == OntologyProperty.ROLE_HERE || prop.getRole() == OntologyProperty.ROLE_BOOLEAN)) { 
    					// continue; 
    				// } 
    	// one method regardless of the number of return types 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_15);
           } 
    			if (prop.isMultiValued() && prop.isDatatypeProperty()) { 
    				// boolean all = prop.getRole() == OntologyProperty.ROLE_HERE || prop.getRole() == OntologyProperty.ROLE_BOOLEAN; 
    				for (Resource res: prop.listRanges(true,false)) { 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_26);
              } 
           } 
    			if (prop.isSingleValued() && prop.isObjectProperty()) { 
    				// if (!(prop.getRole() == OntologyProperty.ROLE_HERE || prop.getRole() == OntologyProperty.ROLE_BOOLEAN)) { 
    					// continue; 
    				// } 
    	// one method regardless of the number of return types 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_31);
           } 
    			if (prop.isMultiValued() && prop.isObjectProperty()) { 
    				//boolean all = prop.getRole() == OntologyProperty.ROLE_HERE || prop.getRole() == OntologyProperty.ROLE_BOOLEAN; 
    				for (Resource res: prop.listRanges(true,false)) { 
    stringBuffer.append(TEXT_32);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_42);
              } 
           } 
     	} 
     } 
    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}