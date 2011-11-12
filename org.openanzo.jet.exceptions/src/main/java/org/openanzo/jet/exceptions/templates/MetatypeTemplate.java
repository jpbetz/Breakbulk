package org.openanzo.jet.exceptions.templates;

import org.openanzo.jet.exceptions.PropertiesDefinitionParser;
import org.openanzo.jet.exceptions.PropertiesDefinitionParser.Description;
import org.openanzo.jet.exceptions.PropertiesDefinitionParser.Example;
import org.openanzo.jet.exceptions.PropertiesDefinitionParser.Property;
import org.openanzo.jet.exceptions.PropertiesDefinitionParser.Tag;

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
public class MetatypeTemplate
{
  protected static String nl;
  public static synchronized MetatypeTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    MetatypeTemplate result = new MetatypeTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*******************************************************************************" + NL + " * Copyright (c) 2007-2008 Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * File:        ";
  protected final String TEXT_3 = "Source";
  protected final String TEXT_4 = NL + " * Created by:  Generated Source from org.openanzo.rdf.utils.properties.jet" + NL + " * Created on:  Generated Source from org.openanzo.rdf.utils.properties.jet" + NL + " * Revision:\t";
  protected final String TEXT_5 = "Id";
  protected final String TEXT_6 = NL + " * " + NL + " * Contributors:" + NL + " *     Cambridge Semantics Incorporated - initial API and implementation" + NL + " *******************************************************************************/" + NL + "package ";
  protected final String TEXT_7 = ";" + NL + "import org.openanzo.osgi.AnzoAttributeDefinition;" + NL + "" + NL + "/**" + NL + " *  ";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = NL + " *\t@author Generated Source from org.openanzo.rdf.utils.properties.jet" + NL + " */" + NL + " " + NL + " public class ";
  protected final String TEXT_10 = "Attributes{" + NL + " \t";
  protected final String TEXT_11 = NL + "\t " + NL + " \t/**" + NL + "\t * AnzoAttributeDefinition for \"";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = "\"";
  protected final String TEXT_14 = NL + "\t * ";
  protected final String TEXT_15 = NL + "\t * <li><b>Server:</b>";
  protected final String TEXT_16 = "</li>";
  protected final String TEXT_17 = NL + "\t * <li><b>Client:</b>";
  protected final String TEXT_18 = "</li>";
  protected final String TEXT_19 = NL + "\t * <li><b>Embedded:</b>";
  protected final String TEXT_20 = "</li>";
  protected final String TEXT_21 = NL + "\t *";
  protected final String TEXT_22 = NL + "\t * Examples:";
  protected final String TEXT_23 = NL + "\t * ";
  protected final String TEXT_24 = NL + "\t * <li><b>Server:</b>";
  protected final String TEXT_25 = "</li>";
  protected final String TEXT_26 = NL + "\t * <li><b>Client:</b>";
  protected final String TEXT_27 = "</li>";
  protected final String TEXT_28 = NL + "\t * <li><b>Embedded:</b>";
  protected final String TEXT_29 = "</li>";
  protected final String TEXT_30 = NL + "\t * ";
  protected final String TEXT_31 = " ";
  protected final String TEXT_32 = " ";
  protected final String TEXT_33 = NL + "\t */" + NL + "\t " + NL + "\t public static final AnzoAttributeDefinition  ";
  protected final String TEXT_34 = " = new AnzoAttributeDefinition() {" + NL + "            public String getName() {" + NL + "                return \"";
  protected final String TEXT_35 = "\";" + NL + "            }" + NL + "\t\t\tpublic boolean isRestartRequired() {" + NL + "                return ";
  protected final String TEXT_36 = ";" + NL + "            }" + NL + "            public String getID() {" + NL + "                return \"";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = "\";" + NL + "            }" + NL + "" + NL + "            public String getDescription() {" + NL + "                return \"\"";
  protected final String TEXT_39 = "+\"";
  protected final String TEXT_40 = "\"";
  protected final String TEXT_41 = ";" + NL + "            }" + NL + "" + NL + "            public String validate(String value) {" + NL + "            \t";
  protected final String TEXT_42 = NL + "                try {" + NL + "                    int _val = Integer.valueOf(value);";
  protected final String TEXT_43 = NL + "                    \tif(_val< ";
  protected final String TEXT_44 = "){return \"Value must be greater than ";
  protected final String TEXT_45 = "\";}";
  protected final String TEXT_46 = NL + "                    if(_val> ";
  protected final String TEXT_47 = "){return \"Value must be less than ";
  protected final String TEXT_48 = "\";}";
  protected final String TEXT_49 = NL + "                    return \"\";" + NL + "                } catch (NumberFormatException nfe) {" + NL + "                    return \"Value is not an Integer\";" + NL + "                }";
  protected final String TEXT_50 = NL + "                  try {" + NL + "                    long _val = Long.valueOf(value);";
  protected final String TEXT_51 = NL + "                    \tif(_val< ";
  protected final String TEXT_52 = "){return \"Value must be greater than ";
  protected final String TEXT_53 = "\";}";
  protected final String TEXT_54 = NL + "                    if(_val> ";
  protected final String TEXT_55 = "){return \"Value must be less than ";
  protected final String TEXT_56 = "\";}";
  protected final String TEXT_57 = NL + "                    return \"\";" + NL + "                } catch (NumberFormatException nfe) {" + NL + "                    return \"Value is not a Long\";" + NL + "                }";
  protected final String TEXT_58 = "return \"\";";
  protected final String TEXT_59 = NL + "            }" + NL + "" + NL + "            public int getType() {" + NL + "                return ";
  protected final String TEXT_60 = "AnzoAttributeDefinition.STRING;";
  protected final String TEXT_61 = "AnzoAttributeDefinition.INTEGER;";
  protected final String TEXT_62 = "AnzoAttributeDefinition.BOOLEAN;";
  protected final String TEXT_63 = "AnzoAttributeDefinition.LONG;";
  protected final String TEXT_64 = "AnzoAttributeDefinition.STRING;";
  protected final String TEXT_65 = NL + "            }" + NL + "" + NL + "            public String[] getOptionValues() {" + NL + "                return null;" + NL + "            }" + NL + "" + NL + "            public String[] getOptionLabels() {" + NL + "                return null;" + NL + "            }" + NL + "" + NL + "            public String[] getDefaultValue() {" + NL + "                return ";
  protected final String TEXT_66 = "new String[] {";
  protected final String TEXT_67 = "Integer.toString(";
  protected final String TEXT_68 = ")";
  protected final String TEXT_69 = "Boolean.toString(";
  protected final String TEXT_70 = ")";
  protected final String TEXT_71 = "Long.toString(";
  protected final String TEXT_72 = ")";
  protected final String TEXT_73 = "\"";
  protected final String TEXT_74 = "\"";
  protected final String TEXT_75 = "}";
  protected final String TEXT_76 = " null";
  protected final String TEXT_77 = ";" + NL + "            }" + NL + "" + NL + "            public int getCardinality() {" + NL + "                return 0;" + NL + "            }" + NL + "        };" + NL + "        ";
  protected final String TEXT_78 = " " + NL + " }" + NL + " \t";

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
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_4);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_5);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(group.getPackageName() );
    stringBuffer.append(TEXT_7);
     if(group.getDescription()!=null){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(group.getDescription().getValue());
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(group.getClassName());
    stringBuffer.append(TEXT_10);
     for (Property property:group.getProperties()) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(group.getPrefix());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_13);
    if (property.getGeneralDescription()!=null){ for(Description description:property.getGeneralDescription()){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(description.getValue());
    }};if (property.getServerDescription()!=null){ 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(property.getServerDescription().getValue());
    stringBuffer.append(TEXT_16);
    };if (property.getClientDescription()!=null){ 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(property.getClientDescription().getValue());
    stringBuffer.append(TEXT_18);
    };if (property.getEmbeddedDescription()!=null){ 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(property.getEmbeddedDescription().getValue());
    stringBuffer.append(TEXT_20);
    };
    stringBuffer.append(TEXT_21);
    if(property.hasExample()){
    stringBuffer.append(TEXT_22);
    if (property.getGeneralExample()!=null){ for(Example example:property.getGeneralExample()){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(example.getValue());
    }};if (property.getServerExample()!=null){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(property.getServerExample().getValue());
    stringBuffer.append(TEXT_25);
    };if (property.getClientExample()!=null){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(property.getClientExample().getValue());
    stringBuffer.append(TEXT_27);
    };if (property.getEmbeddedExample()!=null){
    stringBuffer.append(TEXT_28);
    stringBuffer.append(property.getEmbeddedExample().getValue());
    stringBuffer.append(TEXT_29);
    };
    }
     for(Tag tag:property.getTags()){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(tag.getType());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(tag.getValue());
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(property.isRestartRequired());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(group.getPrefix());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_38);
    if (property.getGeneralDescription()!=null){ for(Description description:property.getGeneralDescription()){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(description.getValue());
    stringBuffer.append(TEXT_40);
    }}
    stringBuffer.append(TEXT_41);
    if (property.getType().equals(PropertiesDefinitionParser.PropType.INTEGER) && property.getMinValue()!=null || property.getMaxValue()!=null){
    stringBuffer.append(TEXT_42);
    if (property.getMinValue()!=null) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_45);
    }
    if (property.getMaxValue()!=null) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    }else if (property.getType().equals(PropertiesDefinitionParser.PropType.LONG) && property.getMinValue()!=null || property.getMaxValue()!=null){
    stringBuffer.append(TEXT_50);
    if (property.getMinValue()!=null) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_53);
    }
    if (property.getMaxValue()!=null) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    }else{
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    if(property.getType().equals(PropertiesDefinitionParser.PropType.STRING)){
    stringBuffer.append(TEXT_60);
    }
                else if (property.getType().equals(PropertiesDefinitionParser.PropType.INTEGER)){
    stringBuffer.append(TEXT_61);
    }
                else if (property.getType().equals(PropertiesDefinitionParser.PropType.BOOLEAN)){
    stringBuffer.append(TEXT_62);
    }
                else if (property.getType().equals(PropertiesDefinitionParser.PropType.LONG)){
    stringBuffer.append(TEXT_63);
    }else{
                
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    if(property.getDefaultValue()!=null){
    stringBuffer.append(TEXT_66);
    
                if (property.getType().equals(PropertiesDefinitionParser.PropType.INTEGER)){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(property.getDefaultValue());
    stringBuffer.append(TEXT_68);
    }
                else if (property.getType().equals(PropertiesDefinitionParser.PropType.BOOLEAN)){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(property.getDefaultValue());
    stringBuffer.append(TEXT_70);
    }
                else if (property.getType().equals(PropertiesDefinitionParser.PropType.LONG)){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(property.getDefaultValue());
    stringBuffer.append(TEXT_72);
    }else{
                if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(property.getDefaultValue());
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_74);
    }
    }
    stringBuffer.append(TEXT_75);
    }else{
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    return stringBuffer.toString();
  }
}
