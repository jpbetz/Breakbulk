package org.openanzo.rdf.jastor.templates;

import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.JavaIdentifierEncoder;
import org.openanzo.rdf.jastor.inference.Ontology;
import org.openanzo.rdf.jastor.inference.OntologyClass;
import org.openanzo.rdf.jastor.inference.OntologyProperty;
import org.openanzo.rdf.jastor.jet.OntologyFileProvider;
import org.openanzo.rdf.jastor.jet.OntologyTemplate;

/*******************************************************************************
 * Copyright (c) 2004, 2009 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/templates/Attic/ontology.skeleton,v $
 * Created by:  Generated Source from Jastor
 * Created on:  7/27/05
 * Revision:	$Id: ontology.skeleton 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
@SuppressWarnings("all")
public class JSVocabTemplate implements OntologyTemplate {
  protected static String nl;
  public static synchronized JSVocabTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    JSVocabTemplate result = new JSVocabTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2009 IBM Corporation and Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * File:        ";
  protected final String TEXT_2 = "Source";
  protected final String TEXT_3 = NL + " * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Revision:\t";
  protected final String TEXT_4 = "Id";
  protected final String TEXT_5 = NL + " * " + NL + " * Contributors:" + NL + " *\t   Cambridge Semantics Incorporated" + NL + " *******************************************************************************/";
  protected final String TEXT_6 = NL + " " + NL + "" + NL + "dojo.provide(\"";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "\");" + NL + "" + NL + "dojo.require(\"anzo.rdf.Statement\");" + NL + "" + NL + "anzo.rdf.registerNamespace('";
  protected final String TEXT_9 = "',\"";
  protected final String TEXT_10 = "#\");" + NL;
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " = {" + NL + "" + NL + "// Class URIs";
  protected final String TEXT_14 = NL + "    ";
  protected final String TEXT_15 = " : anzo.createURI(\"";
  protected final String TEXT_16 = "\")";
  protected final String TEXT_17 = "    " + NL + "" + NL + "// Property URIs";
  protected final String TEXT_18 = NL + "\t";
  protected final String TEXT_19 = " : anzo.createURI(\"";
  protected final String TEXT_20 = "\")";
  protected final String TEXT_21 = NL + NL + "// Instance URIs";
  protected final String TEXT_22 = " " + NL + "\t";
  protected final String TEXT_23 = " : anzo.createURI(\"";
  protected final String TEXT_24 = "\")";
  protected final String TEXT_25 = NL + NL + "}";

	OntologyFileProvider fileProvider;

	public JSVocabTemplate(OntologyFileProvider fileProvider) {
		this.fileProvider = fileProvider;
	}
	
	public JSVocabTemplate() {
	}
	
	public OntologyFileProvider getFileProvider() {
		return fileProvider;
	}
	
	public void setFileProvider(OntologyFileProvider fileProvider) {
		this.fileProvider = fileProvider;
	}

	public String generate(Ontology ont)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Ontology pkg = ont; 
     String pkgstr = pkg.getPackage(); 
     JastorContext ctx = pkg.getContext(); 
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
    stringBuffer.append(pkgstr);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ont.getLocalName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ctx.getNamespacePrefix(ont.getURI().toString() + "#"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ont.getURI());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(pkgstr);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ont.getLocalName());
    stringBuffer.append(TEXT_13);
      java.util.Collection<OntologyClass> classes = pkg.getClasses();
      java.util.Collection<OntologyProperty> props = pkg.getProperties(true);
      java.util.Collection<org.openanzo.rdf.Resource> instances = pkg.getIndividuals();
      int i = 0;
      for(OntologyClass oc : classes) {
        i++;
        boolean lastProp = props.isEmpty() && instances.isEmpty() && i == classes.size();
    stringBuffer.append(TEXT_14);
    stringBuffer.append(oc.getLocalName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(oc.getURI());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(lastProp ? "" : " ,");
      } 
    stringBuffer.append(TEXT_17);
      i = 0;
      for (OntologyProperty prop : props) {
        i++;
        boolean lastProp = instances.isEmpty() && i == props.size();
    stringBuffer.append(TEXT_18);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(prop.getURI());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(lastProp ? "" : " ,");
      } 
    stringBuffer.append(TEXT_21);
      i = 0;
      for (org.openanzo.rdf.Resource instance : instances) {
        i++;
        boolean lastProp = i == instances.size();
        if (instance instanceof org.openanzo.rdf.URI) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(JavaIdentifierEncoder.encode(((org.openanzo.rdf.URI) instance).getLocalName()));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(instance);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(lastProp ? "" : " ,");
        }
      } 
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}