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
public class DictionaryDefinitionsTemplate
{
  protected static String nl;
  public static synchronized DictionaryDefinitionsTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    DictionaryDefinitionsTemplate result = new DictionaryDefinitionsTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2007-2008 Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * File:        ";
  protected final String TEXT_2 = "Source";
  protected final String TEXT_3 = NL + " * Created by:  Generated Source from org.openanzo.rdf.utils.properties.jet" + NL + " * Created on:  Generated Source from org.openanzo.rdf.utils.properties.jet" + NL + " * Revision:\t";
  protected final String TEXT_4 = "Id";
  protected final String TEXT_5 = NL + " * " + NL + " * Contributors:" + NL + " *     Cambridge Semantics Incorporated - initial API and implementation" + NL + " *******************************************************************************/" + NL + "package ";
  protected final String TEXT_6 = ";" + NL + "import java.util.Dictionary;" + NL + "/**" + NL + " *  ";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = NL + " *\t@author Generated Source from org.openanzo.rdf.utils.properties.jet" + NL + " */" + NL + " " + NL + " public class ";
  protected final String TEXT_9 = "Dictionary{" + NL + " \t";
  protected final String TEXT_10 = NL + "\t/**" + NL + "\t * Key for property \"";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = "\"";
  protected final String TEXT_13 = NL + "\t * ";
  protected final String TEXT_14 = NL + "\t * <li><b>Server:</b>";
  protected final String TEXT_15 = "</li>";
  protected final String TEXT_16 = NL + "\t * <li><b>Client:</b>";
  protected final String TEXT_17 = "</li>";
  protected final String TEXT_18 = NL + "\t * <li><b>Embedded:</b>";
  protected final String TEXT_19 = "</li>";
  protected final String TEXT_20 = NL + "\t *";
  protected final String TEXT_21 = NL + "\t * Examples:";
  protected final String TEXT_22 = NL + "\t * ";
  protected final String TEXT_23 = NL + "\t * <li><b>Server:</b>";
  protected final String TEXT_24 = "</li>";
  protected final String TEXT_25 = NL + "\t * <li><b>Client:</b>";
  protected final String TEXT_26 = "</li>";
  protected final String TEXT_27 = NL + "\t * <li><b>Embedded:</b>";
  protected final String TEXT_28 = "</li>";
  protected final String TEXT_29 = NL + "\t * ";
  protected final String TEXT_30 = " ";
  protected final String TEXT_31 = " ";
  protected final String TEXT_32 = NL + "\t */" + NL + "\tpublic static final String\t";
  protected final String TEXT_33 = "\t= \"";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = "\";" + NL + " \t";
  protected final String TEXT_36 = NL + " \t/**" + NL + "\t * Get {@link #";
  protected final String TEXT_37 = "} property from properties" + NL + "\t * " + NL + "\t * @param properties" + NL + "\t *            containing configuration data" + NL + "\t * ";
  protected final String TEXT_38 = "@param defaultValue defaultValue for ";
  protected final String TEXT_39 = NL + "\t * @return value of {@link #";
  protected final String TEXT_40 = "}";
  protected final String TEXT_41 = ",fallback to {@link ";
  protected final String TEXT_42 = "} if available ";
  protected final String TEXT_43 = ",or \"";
  protected final String TEXT_44 = "\" ";
  protected final String TEXT_45 = "or defaultValue";
  protected final String TEXT_46 = " if not present" + NL + "\t */" + NL + "\t @SuppressWarnings(\"unchecked\")" + NL + "\tstatic public String get";
  protected final String TEXT_47 = "(Dictionary properties";
  protected final String TEXT_48 = ",String defaultValue";
  protected final String TEXT_49 = ") {" + NL + "\t\tObject _prop = properties.get(";
  protected final String TEXT_50 = ");" + NL + "\t\t";
  protected final String TEXT_51 = NL + "\t\tif(_prop==null){" + NL + "\t\t\t_prop=properties.get(";
  protected final String TEXT_52 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = NL + "\t\tif(_prop==null){" + NL + "\t\t\treturn ";
  protected final String TEXT_55 = "\"";
  protected final String TEXT_56 = "\"";
  protected final String TEXT_57 = "defaultValue";
  protected final String TEXT_58 = ";" + NL + "\t\t}else{" + NL + "\t\t\treturn _prop.toString();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_59 = "\t\t" + NL + "\t\treturn (_prop!=null)?_prop.toString():null;" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Set {@link #";
  protected final String TEXT_61 = "} property to ";
  protected final String TEXT_62 = " in properties" + NL + "\t * " + NL + "\t * @param properties" + NL + "\t *            containing configuration data" + NL + "\t * @param ";
  protected final String TEXT_63 = NL + "\t *            value for ";
  protected final String TEXT_64 = NL + "\t */" + NL + "\t @SuppressWarnings(\"unchecked\")" + NL + "\tstatic public void set";
  protected final String TEXT_65 = "(Dictionary properties, String ";
  protected final String TEXT_66 = ") {" + NL + "\t\tif(";
  protected final String TEXT_67 = "==null){" + NL + "\t\t\tproperties.remove(";
  protected final String TEXT_68 = ");" + NL + "\t\t}else{" + NL + "\t\t\tproperties.put(";
  protected final String TEXT_69 = ", ";
  protected final String TEXT_70 = ");" + NL + "\t\t}" + NL + "\t}" + NL + " \t";
  protected final String TEXT_71 = NL + " \t/**" + NL + "\t * Get {@link #";
  protected final String TEXT_72 = "} property from properties" + NL + "\t * " + NL + "\t * @param properties" + NL + "\t *            containing configuration data" + NL + "\t * ";
  protected final String TEXT_73 = "@param defaultValue defaultValue for ";
  protected final String TEXT_74 = NL + "\t * @return value of {@link #";
  protected final String TEXT_75 = "}";
  protected final String TEXT_76 = ",fallback to {@link ";
  protected final String TEXT_77 = "} if available ";
  protected final String TEXT_78 = ",or \"";
  protected final String TEXT_79 = "\" ";
  protected final String TEXT_80 = "or defaultValue";
  protected final String TEXT_81 = " if not present" + NL + "\t * @throws org.openanzo.exceptions.AnzoException if there is an exception decrypting value" + NL + "\t */" + NL + "\t  @SuppressWarnings(\"unchecked\")" + NL + "\tstatic public String get";
  protected final String TEXT_82 = "(Dictionary properties";
  protected final String TEXT_83 = ",String defaultValue";
  protected final String TEXT_84 = ") throws org.openanzo.exceptions.AnzoException{" + NL + "\t\ttry{" + NL + "\t\tObject _prop = properties.get(";
  protected final String TEXT_85 = ");" + NL + "\t\t";
  protected final String TEXT_86 = NL + "\t\tif(_prop==null){" + NL + "\t\t\t_prop=properties.get(";
  protected final String TEXT_87 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t\t";
  protected final String TEXT_89 = NL + "\t\tif(_prop==null){" + NL + "\t\t\treturn ";
  protected final String TEXT_90 = "\"";
  protected final String TEXT_91 = "\"";
  protected final String TEXT_92 = "defaultValue";
  protected final String TEXT_93 = ";" + NL + "\t\t}else{" + NL + "\t\t\tif(_prop.toString().startsWith(\"encrypted:\")){" + NL + "\t\t\t\t_prop=_prop.toString().substring(\"encrypted:\".length());" + NL + "\t\t\t\tif(_prop.toString().length()>0){" + NL + "\t\t\t\t\treturn org.openanzo.exceptions.EncryptionUtil.decryptBase64(_prop.toString());" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\treturn _prop.toString();" + NL + "\t\t\t\t}" + NL + "\t\t\t}else{" + NL + "\t\t\t\treturn _prop.toString();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_94 = "\t" + NL + "\t\tif(_prop==null){" + NL + "\t\t\treturn null;" + NL + "\t\t}else if(_prop.toString().startsWith(\"encrypted:\")){" + NL + "\t\t\t_prop=_prop.toString().substring(\"encrypted:\".length());" + NL + "\t\t\tif(_prop.toString().length()>0){" + NL + "\t\t\t\treturn org.openanzo.exceptions.EncryptionUtil.decryptBase64(_prop.toString());" + NL + "\t\t\t}else{" + NL + "\t\t\t\treturn _prop.toString();" + NL + "\t\t\t}" + NL + "\t\t}else{" + NL + "\t\t\treturn _prop.toString();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_95 = NL + "\t\t}catch(Exception e){" + NL + "\t\t\t throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Set {@link #";
  protected final String TEXT_96 = "} property to ";
  protected final String TEXT_97 = " in properties" + NL + "\t * " + NL + "\t * @param properties" + NL + "\t *            containing configuration data" + NL + "\t * @param ";
  protected final String TEXT_98 = NL + "\t *            value for ";
  protected final String TEXT_99 = NL + "\t * @throws org.openanzo.exceptions.AnzoException if there is an exception encrypting value" + NL + "\t */" + NL + "\t  @SuppressWarnings(\"unchecked\")" + NL + "\tstatic public void set";
  protected final String TEXT_100 = "(Dictionary properties, String ";
  protected final String TEXT_101 = ") throws org.openanzo.exceptions.AnzoException {" + NL + "\t\ttry{" + NL + "\t\t\tif(";
  protected final String TEXT_102 = "==null){" + NL + "\t\t\t\tproperties.remove(";
  protected final String TEXT_103 = ");" + NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_104 = "=\"encrypted:\"+org.openanzo.exceptions.EncryptionUtil.encryptBase64(";
  protected final String TEXT_105 = ");" + NL + "\t\t\t\tproperties.put(";
  protected final String TEXT_106 = ",";
  protected final String TEXT_107 = ");" + NL + "\t\t\t}" + NL + "\t\t}catch(Exception e){" + NL + "\t\t\t throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);" + NL + "\t\t}" + NL + "\t}" + NL + " \t";
  protected final String TEXT_108 = NL + " \t/**" + NL + "\t * Get {@link #";
  protected final String TEXT_109 = "} property from properties" + NL + "\t * " + NL + "\t * @param properties" + NL + "\t *            containing configuration data" + NL + "\t * ";
  protected final String TEXT_110 = "@param defaultValue defaultValue for ";
  protected final String TEXT_111 = NL + "\t * @return value of {@link #";
  protected final String TEXT_112 = "}";
  protected final String TEXT_113 = ",fallback to {@link ";
  protected final String TEXT_114 = "} if available ";
  protected final String TEXT_115 = ",or \"";
  protected final String TEXT_116 = "\" ";
  protected final String TEXT_117 = "or defaultValue";
  protected final String TEXT_118 = ", or false ";
  protected final String TEXT_119 = " if not present" + NL + "\t */" + NL + "\t @SuppressWarnings(\"unchecked\")" + NL + "\tstatic public Boolean get";
  protected final String TEXT_120 = "(Dictionary properties";
  protected final String TEXT_121 = ",boolean defaultValue";
  protected final String TEXT_122 = ") {" + NL + "\t\tObject _prop=properties.get(";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + "\t\tif(_prop==null){" + NL + "\t\t\t_prop=properties.get(";
  protected final String TEXT_125 = ");" + NL + "\t\t}";
  protected final String TEXT_126 = NL + "\t\tif(_prop==null){" + NL + "\t\t\t_prop=Boolean.valueOf(";
  protected final String TEXT_127 = "\"";
  protected final String TEXT_128 = "\"";
  protected final String TEXT_129 = ");" + NL + "\t\t}";
  protected final String TEXT_130 = NL + "\t\treturn (_prop!=null)?Boolean.valueOf(_prop.toString()):Boolean.valueOf(defaultValue);";
  protected final String TEXT_131 = NL + "\t\treturn (_prop!=null)?Boolean.valueOf(_prop.toString()):null;";
  protected final String TEXT_132 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Set {@link #";
  protected final String TEXT_133 = "} property to ";
  protected final String TEXT_134 = " in properties" + NL + "\t * " + NL + "\t * @param properties" + NL + "\t *            containing configuration data" + NL + "\t * @param ";
  protected final String TEXT_135 = NL + "\t *           value for ";
  protected final String TEXT_136 = NL + "\t */" + NL + "\t @SuppressWarnings(\"unchecked\")" + NL + "\tstatic public void set";
  protected final String TEXT_137 = "(Dictionary properties, Boolean ";
  protected final String TEXT_138 = ") {" + NL + "\t\tif(";
  protected final String TEXT_139 = "==null){" + NL + "\t\t\tproperties.remove(";
  protected final String TEXT_140 = ");" + NL + "\t\t}else{" + NL + "\t\t\tproperties.put(";
  protected final String TEXT_141 = ", ";
  protected final String TEXT_142 = ".toString());" + NL + "\t\t}" + NL + "\t}" + NL + " \t";
  protected final String TEXT_143 = NL + " \t/**" + NL + "\t * Get {@link #";
  protected final String TEXT_144 = "} property from properties" + NL + "\t * " + NL + "\t * @param properties" + NL + "\t *            containing configuration data" + NL + "\t * ";
  protected final String TEXT_145 = "@param defaultValue defaultValue for ";
  protected final String TEXT_146 = NL + "\t * @return value of {@link #";
  protected final String TEXT_147 = "}";
  protected final String TEXT_148 = ",fallback to {@link ";
  protected final String TEXT_149 = "} if available ";
  protected final String TEXT_150 = ",or \"";
  protected final String TEXT_151 = "\" ";
  protected final String TEXT_152 = "or defaultValue";
  protected final String TEXT_153 = " if not present" + NL + "\t */" + NL + "\t @SuppressWarnings(\"unchecked\")" + NL + "\tstatic public Integer get";
  protected final String TEXT_154 = "(Dictionary properties";
  protected final String TEXT_155 = ",Integer defaultValue";
  protected final String TEXT_156 = ") {" + NL + "\t\tObject _prop= properties.get(";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = NL + "\t\tif(_prop==null){" + NL + "\t\t\t_prop=properties.get(";
  protected final String TEXT_159 = ");" + NL + "\t\t}";
  protected final String TEXT_160 = NL + "\t\tInteger value= (_prop!=null)?Integer.valueOf(_prop.toString()):defaultValue;";
  protected final String TEXT_161 = NL + "\t\tInteger value= (_prop!=null)?Integer.valueOf(_prop.toString()):";
  protected final String TEXT_162 = "\"";
  protected final String TEXT_163 = "\"";
  protected final String TEXT_164 = "null";
  protected final String TEXT_165 = ";";
  protected final String TEXT_166 = NL + "\t\tif(value!=null&&value <= ";
  protected final String TEXT_167 = ")" + NL + "\t\t\tthrow new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,\"";
  protected final String TEXT_168 = "\",\"";
  protected final String TEXT_169 = "\");";
  protected final String TEXT_170 = NL + "\t\tif(value!=null&&value >= ";
  protected final String TEXT_171 = ")" + NL + "\t\t\tthrow new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,\"";
  protected final String TEXT_172 = "\",\"";
  protected final String TEXT_173 = "\");";
  protected final String TEXT_174 = NL + "\t\treturn value;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Set {@link #";
  protected final String TEXT_175 = "} property to ";
  protected final String TEXT_176 = " in properties" + NL + "\t * " + NL + "\t * @param properties" + NL + "\t *            containing configuration data" + NL + "\t * @param ";
  protected final String TEXT_177 = NL + "\t *           value for ";
  protected final String TEXT_178 = NL + "\t */" + NL + "\t @SuppressWarnings(\"unchecked\")" + NL + "\tstatic public void set";
  protected final String TEXT_179 = "(Dictionary properties, Integer ";
  protected final String TEXT_180 = ") {" + NL + "\t\tif(";
  protected final String TEXT_181 = "==null){" + NL + "\t\t\tproperties.remove(";
  protected final String TEXT_182 = ");" + NL + "\t\t}else{";
  protected final String TEXT_183 = NL + "\t\tif(";
  protected final String TEXT_184 = " <= ";
  protected final String TEXT_185 = ")" + NL + "\t\t\tthrow new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,\"";
  protected final String TEXT_186 = "\",\"";
  protected final String TEXT_187 = "\");";
  protected final String TEXT_188 = NL + "\t\tif(";
  protected final String TEXT_189 = " >= ";
  protected final String TEXT_190 = ")" + NL + "\t\t\tthrow new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,\"";
  protected final String TEXT_191 = "\",\"";
  protected final String TEXT_192 = "\");";
  protected final String TEXT_193 = NL + "\t\tproperties.put(";
  protected final String TEXT_194 = ", Integer.toString(";
  protected final String TEXT_195 = "));" + NL + "\t\t}" + NL + "\t}" + NL + " \t";
  protected final String TEXT_196 = NL + " \t/**" + NL + "\t * Get {@link #";
  protected final String TEXT_197 = "} property from properties" + NL + "\t * " + NL + "\t * @param properties" + NL + "\t *            containing configuration data" + NL + "\t * ";
  protected final String TEXT_198 = "@param defaultValue defaultValue for ";
  protected final String TEXT_199 = NL + "\t * @return value of {@link #";
  protected final String TEXT_200 = "}";
  protected final String TEXT_201 = ",fallback to {@link ";
  protected final String TEXT_202 = "} if available ";
  protected final String TEXT_203 = ",or \"";
  protected final String TEXT_204 = "\" ";
  protected final String TEXT_205 = "or defaultValue";
  protected final String TEXT_206 = " if not present" + NL + "\t */" + NL + "\t @SuppressWarnings(\"unchecked\")" + NL + "\tstatic public Long get";
  protected final String TEXT_207 = "(Dictionary properties";
  protected final String TEXT_208 = ",Long defaultValue";
  protected final String TEXT_209 = ") {" + NL + "\t\tObject _prop= properties.get(";
  protected final String TEXT_210 = ");" + NL + "\t\t";
  protected final String TEXT_211 = NL + "\t\tif(_prop==null){" + NL + "\t\t\t_prop=properties.get(";
  protected final String TEXT_212 = ");" + NL + "\t\t}";
  protected final String TEXT_213 = NL + "\t\tif(_prop==null){" + NL + "\t\t\t_prop=";
  protected final String TEXT_214 = "\"";
  protected final String TEXT_215 = "\"";
  protected final String TEXT_216 = ";" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_217 = NL + "\t\t";
  protected final String TEXT_218 = NL + "\t\tLong value= (_prop!=null)?Long.valueOf(_prop.toString()):defaultValue;";
  protected final String TEXT_219 = NL + "\t\tLong value= (_prop!=null)?Long.valueOf(_prop.toString()):null;";
  protected final String TEXT_220 = NL + "\t\t";
  protected final String TEXT_221 = NL + "\t\tif(value!=null&&value <= ";
  protected final String TEXT_222 = ")" + NL + "\t\t\tthrow new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,\"";
  protected final String TEXT_223 = "\",\"";
  protected final String TEXT_224 = "\");";
  protected final String TEXT_225 = NL + "\t\tif(value!=null&&value >= ";
  protected final String TEXT_226 = ")" + NL + "\t\t\tthrow new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,\"";
  protected final String TEXT_227 = "\",\"";
  protected final String TEXT_228 = "\");";
  protected final String TEXT_229 = NL + "\t\treturn value;\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Set {@link #";
  protected final String TEXT_230 = "} property to ";
  protected final String TEXT_231 = " in properties" + NL + "\t * " + NL + "\t * @param properties" + NL + "\t *            containing configuration data" + NL + "\t * @param ";
  protected final String TEXT_232 = NL + "\t *           value for ";
  protected final String TEXT_233 = NL + "\t */" + NL + "\t @SuppressWarnings(\"unchecked\")" + NL + "\tstatic public void set";
  protected final String TEXT_234 = "(Dictionary properties, Long ";
  protected final String TEXT_235 = ") {" + NL + "\t\tif(";
  protected final String TEXT_236 = "==null){" + NL + "\t\t\tproperties.remove(";
  protected final String TEXT_237 = ");" + NL + "\t\t}else{";
  protected final String TEXT_238 = NL + "\t\tif(";
  protected final String TEXT_239 = " <= ";
  protected final String TEXT_240 = ")" + NL + "\t\t\tthrow new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,\"";
  protected final String TEXT_241 = "\",\"";
  protected final String TEXT_242 = "\");";
  protected final String TEXT_243 = NL + "\t\tif(";
  protected final String TEXT_244 = " >= ";
  protected final String TEXT_245 = ")\t" + NL + "\t\t\tthrow new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,\"";
  protected final String TEXT_246 = "\",\"";
  protected final String TEXT_247 = "\");";
  protected final String TEXT_248 = NL + "\t\tproperties.put(";
  protected final String TEXT_249 = ", Long.toString(";
  protected final String TEXT_250 = "));" + NL + "\t\t}" + NL + "\t}" + NL + " \t";
  protected final String TEXT_251 = NL + " \t";
  protected final String TEXT_252 = NL + " }" + NL + " \t";

	/**
	* Generate source code
	* @param argument source for template
	* @return Return generated source
    */
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     PropertiesDefinitionParser.PropertyGroup group = (PropertiesDefinitionParser.PropertyGroup)argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_2);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_4);
    stringBuffer.append("$".toString());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(group.getPackageName() );
    stringBuffer.append(TEXT_6);
     if(group.getDescription()!=null){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(group.getDescription().getValue());
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(group.getClassName());
    stringBuffer.append(TEXT_9);
     for (Property property:group.getProperties()) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(group.getPrefix());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_12);
    if (property.getGeneralDescription()!=null){ for(Description description:property.getGeneralDescription()){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(description.getValue());
    }};if (property.getServerDescription()!=null){ 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(property.getServerDescription().getValue());
    stringBuffer.append(TEXT_15);
    };if (property.getClientDescription()!=null){ 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(property.getClientDescription().getValue());
    stringBuffer.append(TEXT_17);
    };if (property.getEmbeddedDescription()!=null){ 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(property.getEmbeddedDescription().getValue());
    stringBuffer.append(TEXT_19);
    };
    stringBuffer.append(TEXT_20);
    if(property.hasExample()){
    stringBuffer.append(TEXT_21);
    if (property.getGeneralExample()!=null){ for(Example example:property.getGeneralExample()){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(example.getValue());
    }};if (property.getServerExample()!=null){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(property.getServerExample().getValue());
    stringBuffer.append(TEXT_24);
    };if (property.getClientExample()!=null){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(property.getClientExample().getValue());
    stringBuffer.append(TEXT_26);
    };if (property.getEmbeddedExample()!=null){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(property.getEmbeddedExample().getValue());
    stringBuffer.append(TEXT_28);
    };
    }
     for(Tag tag:property.getTags()){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(tag.getType());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(tag.getValue());
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(group.getPrefix());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_35);
    }for (Property property:group.getProperties()) {  if(property.getType().equals(PropertiesDefinitionParser.PropType.STRING)){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_37);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(property.getName());
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(property.getKey());
    stringBuffer.append(TEXT_40);
    if(property.getParentProperty()!=null){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(property.getParentPropertyLink());
    stringBuffer.append(TEXT_42);
    };if(property.getDefaultValue()!=null){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(property.getDefaultValue());
    stringBuffer.append(TEXT_44);
    }else if(property.getPassDefault()){
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_47);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_50);
    if(property.getParentProperty()!=null){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(property.getParentProperty());
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    if(property.getDefaultValue()!=null||property.getPassDefault()){
    stringBuffer.append(TEXT_54);
    if(property.getDefaultValue()!=null){
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(property.getDefaultValue());
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_56);
    }
    }else if(property.getPassDefault()){
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    }else{
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()));
    stringBuffer.append(TEXT_70);
    }else if(property.getType().equals(PropertiesDefinitionParser.PropType.ENCRYPTED)){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_72);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_73);
    stringBuffer.append(property.getName());
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(property.getKey());
    stringBuffer.append(TEXT_75);
    if(property.getParentProperty()!=null){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(property.getParentPropertyLink());
    stringBuffer.append(TEXT_77);
    };if(property.getDefaultValue()!=null){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(property.getDefaultValue());
    stringBuffer.append(TEXT_79);
    }else if(property.getPassDefault()){
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_82);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_85);
    if(property.getParentProperty()!=null){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(property.getParentProperty());
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    if(property.getDefaultValue()!=null||property.getPassDefault()){
    stringBuffer.append(TEXT_89);
    if(property.getDefaultValue()!=null){
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(property.getDefaultValue());
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_91);
    }
    }else if(property.getPassDefault()){
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    }else{
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()));
    stringBuffer.append(TEXT_107);
    }else if (property.getType().equals(PropertiesDefinitionParser.PropType.BOOLEAN)){
    stringBuffer.append(TEXT_108);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_109);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_110);
    stringBuffer.append(property.getName() );
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_112);
    if(property.getParentProperty()!=null){
    stringBuffer.append(TEXT_113);
    stringBuffer.append(property.getParentPropertyLink());
    stringBuffer.append(TEXT_114);
    };if(property.getDefaultValue()!=null){
    stringBuffer.append(TEXT_115);
    stringBuffer.append(property.getDefaultValue());
    stringBuffer.append(TEXT_116);
    }else if(property.getPassDefault()){
    stringBuffer.append(TEXT_117);
    }else{
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_120);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    stringBuffer.append(property.getKey());
    stringBuffer.append(TEXT_123);
    if(property.getParentProperty()!=null){
    stringBuffer.append(TEXT_124);
    stringBuffer.append(property.getParentProperty());
    stringBuffer.append(TEXT_125);
    }
    if(property.getDefaultValue()!=null){
    stringBuffer.append(TEXT_126);
    if(property.getDefaultValue()!=null){
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(property.getDefaultValue());
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_128);
    }
    }
    stringBuffer.append(TEXT_129);
    }
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_130);
    }else{
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(property.getKey());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(property.getKey());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_142);
    }else if (property.getType().equals(PropertiesDefinitionParser.PropType.INTEGER)){
    stringBuffer.append(TEXT_143);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_144);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_145);
    stringBuffer.append(property.getName() );
    }
    stringBuffer.append(TEXT_146);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_147);
    if(property.getParentProperty()!=null){
    stringBuffer.append(TEXT_148);
    stringBuffer.append(property.getParentPropertyLink());
    stringBuffer.append(TEXT_149);
    };if(property.getDefaultValue()!=null){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(property.getDefaultValue());
    stringBuffer.append(TEXT_151);
    }else if(property.getPassDefault()){
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_154);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_157);
    if(property.getParentProperty()!=null){
    stringBuffer.append(TEXT_158);
    stringBuffer.append(property.getParentProperty());
    stringBuffer.append(TEXT_159);
    }
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_160);
    }else{
    stringBuffer.append(TEXT_161);
    if(property.getDefaultValue()!=null){
    if(property.getDefaultValue()!=null){
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(property.getDefaultValue());
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_163);
    }}}else{
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    }
    if (property.getMinValue()!=null){
    stringBuffer.append(TEXT_166);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_169);
    }
    if (property.getMaxValue()!=null){
		
    stringBuffer.append(TEXT_170);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    stringBuffer.append(property.getKey());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_182);
    if (property.getMinValue()!=null){
    stringBuffer.append(TEXT_183);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_185);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_187);
    }
    if (property.getMaxValue()!=null){
		
    stringBuffer.append(TEXT_188);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    stringBuffer.append(property.getKey());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_195);
    }else if (property.getType().equals(PropertiesDefinitionParser.PropType.LONG)){
    stringBuffer.append(TEXT_196);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_197);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_198);
    stringBuffer.append(property.getName() );
    }
    stringBuffer.append(TEXT_199);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_200);
    if(property.getParentProperty()!=null){
    stringBuffer.append(TEXT_201);
    stringBuffer.append(property.getParentPropertyLink());
    stringBuffer.append(TEXT_202);
    };if(property.getDefaultValue()!=null){
    stringBuffer.append(TEXT_203);
    stringBuffer.append(property.getDefaultValue());
    stringBuffer.append(TEXT_204);
    }else if(property.getPassDefault()){
    stringBuffer.append(TEXT_205);
    }
    stringBuffer.append(TEXT_206);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_207);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_208);
    }
    stringBuffer.append(TEXT_209);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_210);
    if(property.getParentProperty()!=null){
    stringBuffer.append(TEXT_211);
    stringBuffer.append(property.getParentProperty());
    stringBuffer.append(TEXT_212);
    }
    if(property.getDefaultValue()!=null){
    stringBuffer.append(TEXT_213);
    if(property.getDefaultValue()!=null){
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_214);
    }
    stringBuffer.append(property.getDefaultValue());
    if(property.getQuoteDefault()){
    stringBuffer.append(TEXT_215);
    }
    }
    stringBuffer.append(TEXT_216);
    }
    stringBuffer.append(TEXT_217);
    if(property.getPassDefault()){
    stringBuffer.append(TEXT_218);
    }else{
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    if (property.getMinValue()!=null){
    stringBuffer.append(TEXT_221);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_224);
    }
    if (property.getMaxValue()!=null){
		
    stringBuffer.append(TEXT_225);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_226);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_228);
    }
    stringBuffer.append(TEXT_229);
    stringBuffer.append(property.getKey());
    stringBuffer.append(TEXT_230);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(property.getName() );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(PropertiesDefinitionParser.capFirstLetter(property.getName()));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(property.getKey() );
    stringBuffer.append(TEXT_237);
    if (property.getMinValue()!=null){
    stringBuffer.append(TEXT_238);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(property.getMinValue());
    stringBuffer.append(TEXT_242);
    }
    if (property.getMaxValue()!=null){
		
    stringBuffer.append(TEXT_243);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_245);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(property.getMaxValue());
    stringBuffer.append(TEXT_247);
    }
    stringBuffer.append(TEXT_248);
    stringBuffer.append(property.getKey());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(PropertiesDefinitionParser.replaceDots(property.getName()) );
    stringBuffer.append(TEXT_250);
    }
    stringBuffer.append(TEXT_251);
    }
    stringBuffer.append(TEXT_252);
    return stringBuffer.toString();
  }
}
