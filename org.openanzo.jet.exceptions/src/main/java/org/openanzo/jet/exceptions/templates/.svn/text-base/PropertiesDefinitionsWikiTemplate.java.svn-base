package org.openanzo.jet.exceptions.templates;

import org.openanzo.jet.exceptions.PropertiesDefinitionParser;
import org.openanzo.jet.exceptions.PropertiesDefinitionParser.Description;
import org.openanzo.jet.exceptions.PropertiesDefinitionParser.Example;
import org.openanzo.jet.exceptions.PropertiesDefinitionParser.Property;

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
public class PropertiesDefinitionsWikiTemplate
{
  protected static String nl;
  public static synchronized PropertiesDefinitionsWikiTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    PropertiesDefinitionsWikiTemplate result = new PropertiesDefinitionsWikiTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "== !";
  protected final String TEXT_3 = " ==" + NL;
  protected final String TEXT_4 = " ";
  protected final String TEXT_5 = NL + NL + "|| Property Name || Description || Example || ";
  protected final String TEXT_6 = NL + "||";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "||";
  protected final String TEXT_9 = " [[BR]] ";
  protected final String TEXT_10 = "'''Server''':";
  protected final String TEXT_11 = " [[BR]] ";
  protected final String TEXT_12 = "'''Client''':";
  protected final String TEXT_13 = " [[BR]] ";
  protected final String TEXT_14 = "'''Embedded''':";
  protected final String TEXT_15 = "||";
  protected final String TEXT_16 = "Minimum: ";
  protected final String TEXT_17 = " [[BR]] ";
  protected final String TEXT_18 = "Maximum:";
  protected final String TEXT_19 = " [[BR]] ";
  protected final String TEXT_20 = " [[BR]] ";
  protected final String TEXT_21 = "'''Server''':";
  protected final String TEXT_22 = " [[BR]] ";
  protected final String TEXT_23 = "'''Client''':";
  protected final String TEXT_24 = " [[BR]] ";
  protected final String TEXT_25 = "'''Embedded''':";
  protected final String TEXT_26 = "||";
  protected final String TEXT_27 = NL;

	/**
	* Generate source code
	* @param argument source for template
	* @return Return generated source
    */
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     PropertiesDefinitionParser.PropertyGroup group = (PropertiesDefinitionParser.PropertyGroup)argument; 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(group.getClassName());
    stringBuffer.append(TEXT_3);
     if(group.getDescription()!=null){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(group.getDescription().getValue());
    }
    stringBuffer.append(TEXT_5);
     for (Property property:group.getProperties()) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(group.getPrefix());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_8);
    if (property.getGeneralDescription()!=null){ for(Description description:property.getGeneralDescription()){

    stringBuffer.append(description.getValue());
    stringBuffer.append(TEXT_9);
    }};if (property.getServerDescription()!=null){ 
	  
    stringBuffer.append(TEXT_10);
    stringBuffer.append(property.getServerDescription().getValue());
    stringBuffer.append(TEXT_11);
    };if (property.getClientDescription()!=null){ 
	  
    stringBuffer.append(TEXT_12);
    stringBuffer.append(property.getClientDescription().getValue());
    stringBuffer.append(TEXT_13);
    };if (property.getEmbeddedDescription()!=null){ 
	  
    stringBuffer.append(TEXT_14);
    stringBuffer.append(property.getEmbeddedDescription().getValue());
    };
    if(property.hasExample()){
	  
    stringBuffer.append(TEXT_15);
    if (property.getMinValue()!=null){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_17);
    };if (property.getMaxValue()!=null){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_19);
    };if (property.getGeneralExample()!=null){ for(Example example:property.getGeneralExample()){
	 
    stringBuffer.append(example.getValue());
    stringBuffer.append(TEXT_20);
    }};if (property.getServerExample()!=null){
	 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(property.getServerExample().getValue());
    stringBuffer.append(TEXT_22);
    };if (property.getClientExample()!=null){
	 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(property.getClientExample().getValue());
    stringBuffer.append(TEXT_24);
    };if (property.getEmbeddedExample()!=null){
	 
    stringBuffer.append(TEXT_25);
    stringBuffer.append(property.getEmbeddedExample().getValue());
    };
    }
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
