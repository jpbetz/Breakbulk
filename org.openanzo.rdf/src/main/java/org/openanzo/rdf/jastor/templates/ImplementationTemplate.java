package org.openanzo.rdf.jastor.templates;

import java.util.List;

import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Value;
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
public class ImplementationTemplate implements OntologyClassTemplate {
	
  protected static String nl;
  public static synchronized ImplementationTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ImplementationTemplate result = new ImplementationTemplate();
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
  protected final String TEXT_7 = ";" + NL + "" + NL + "/**" + NL + " * Implementation of {@link ";
  protected final String TEXT_8 = "}" + NL + " * Use the ";
  protected final String TEXT_9 = " to create instances of this class." + NL + " * <p>(URI: ";
  protected final String TEXT_10 = ")</p>" + NL + " * <br>" + NL + " */" + NL + "public class ";
  protected final String TEXT_11 = " extends ";
  protected final String TEXT_12 = " implements ";
  protected final String TEXT_13 = " {";
  protected final String TEXT_14 = NL + "\tprivate ThingStatementListener _listener = null;";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL + "\tprotected static final org.openanzo.rdf.URI ";
  protected final String TEXT_17 = "Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(\"";
  protected final String TEXT_18 = "\");";
  protected final String TEXT_19 = NL + NL + "\t";
  protected final String TEXT_20 = "(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\tsuper(resource, namedGraphUri, dataset);";
  protected final String TEXT_21 = NL + "\t\t_listener = new ThingStatementListener();";
  protected final String TEXT_22 = NL + "\t}   " + NL + "\t";
  protected final String TEXT_23 = NL + "\tprivate static java.util.Set<org.openanzo.rdf.Resource> oneOfClasses = new java.util.HashSet<org.openanzo.rdf.Resource>();" + NL + "\tstatic {";
  protected final String TEXT_24 = NL + "\t\toneOfClasses.add(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t}";
  protected final String TEXT_27 = "   " + NL + "    \t" + NL + "\tstatic ";
  protected final String TEXT_28 = " get";
  protected final String TEXT_29 = "(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\tif(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){" + NL + "\t\t\tnamedGraphUri=null;" + NL + "\t\t\tfor(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ";
  protected final String TEXT_30 = ".TYPE)){" + NL + "\t\t\t\tnamedGraphUri=stmt.getNamedGraphUri();" + NL + "\t\t\t}" + NL + "\t\t\tif(namedGraphUri==null)return null;" + NL + "\t\t}";
  protected final String TEXT_31 = NL + "\t\tif (!dataset.contains(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ";
  protected final String TEXT_32 = ".TYPE, namedGraphUri))" + NL + "\t\t\treturn null;";
  protected final String TEXT_33 = NL + "\t\treturn new ";
  protected final String TEXT_34 = "(resource, namedGraphUri, dataset);" + NL + "\t}" + NL + "\t    " + NL + "\tstatic ";
  protected final String TEXT_35 = " create";
  protected final String TEXT_36 = "(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {";
  protected final String TEXT_37 = NL + "\t\tif (!oneOfClasses.contains(resource)) {" + NL + "\t\t\tthrow new org.openanzo.rdf.jastor.JastorException(\"Resource \" + resource + \" not a member of enumeration class ";
  protected final String TEXT_38 = "\"); " + NL + "\t\t}";
  protected final String TEXT_39 = " " + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_40 = " impl = new ";
  protected final String TEXT_41 = "(resource, namedGraphUri,dataset);" + NL + "\t\tif (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ";
  protected final String TEXT_42 = ".TYPE, namedGraphUri))" + NL + "\t\t\timpl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ";
  protected final String TEXT_43 = ".TYPE, namedGraphUri);" + NL + "\t\timpl.addSuperTypes();" + NL + "\t\timpl.addHasValueValues();" + NL + "\t\treturn impl;" + NL + "\t}" + NL + "\t" + NL + "\tvoid addSuperTypes() {";
  protected final String TEXT_44 = NL + "\t\tif (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ";
  protected final String TEXT_45 = ".TYPE,_graph.getNamedGraphUri()))" + NL + "\t\t\t_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ";
  protected final String TEXT_46 = ".TYPE,_graph.getNamedGraphUri());     ";
  protected final String TEXT_47 = NL + "\t}" + NL + "   " + NL + "\tvoid addHasValueValues() {";
  protected final String TEXT_48 = NL + "\t\tif (!_dataset.contains(_resource, ";
  protected final String TEXT_49 = "Property, org.openanzo.rdf.jastor.ThingFactory.valueFactory.createResource(\"";
  protected final String TEXT_50 = "\"),_graph.getNamedGraphUri()))" + NL + "\t\t\t_dataset.add(_resource, ";
  protected final String TEXT_51 = "Property, org.openanzo.rdf.jastor.ThingFactory.valueFactory.createResource(\"";
  protected final String TEXT_52 = "\"),_graph.getNamedGraphUri());";
  protected final String TEXT_53 = NL + "\t\tif (!_dataset.contains(_resource, ";
  protected final String TEXT_54 = "Property, org.openanzo.rdf.jastor.ThingFactory.valueFactory.createLiteral(\"";
  protected final String TEXT_55 = "\"),_graph.getNamedGraphUri()))" + NL + "\t\t\t_dataset.add(_resource, ";
  protected final String TEXT_56 = "Property, org.openanzo.rdf.jastor.ThingFactory.valueFactory.createLiteral(\"";
  protected final String TEXT_57 = "\"),_graph.getNamedGraphUri());";
  protected final String TEXT_58 = NL + "\t}" + NL + "   " + NL + "\tpublic java.util.Collection<org.openanzo.rdf.Statement> listStatements() {" + NL + "\t\tjava.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();" + NL + "\t\t";
  protected final String TEXT_59 = NL + "\t\tlist.addAll(_dataset.find(_resource, ";
  protected final String TEXT_60 = "Property, null, _graph.getNamedGraphUri()));" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\t" + NL + "\t\tlist.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ";
  protected final String TEXT_62 = ".TYPE, _graph.getNamedGraphUri()));";
  protected final String TEXT_63 = NL + "\t\tlist.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ";
  protected final String TEXT_64 = ".TYPE, _graph.getNamedGraphUri()));";
  protected final String TEXT_65 = NL + "\t\treturn list;" + NL + "\t}" + NL;
  protected final String TEXT_66 = NL + "\t/**" + NL + "\t * Clears all values for '";
  protected final String TEXT_67 = "'. " + NL + "\t * @param \t\tincludeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\t @SuppressWarnings(\"all\")" + NL + "\tpublic void clear";
  protected final String TEXT_68 = "(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{" + NL + "\t\t_dataset.remove(_resource, ";
  protected final String TEXT_69 = "Property, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());" + NL + "\t}" + NL + "// generating for property: ";
  protected final String TEXT_70 = NL + "\tpublic ";
  protected final String TEXT_71 = " get";
  protected final String TEXT_72 = "(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "" + NL + "\t\tjava.util.Collection<org.openanzo.rdf.Statement> __valIter =null;" + NL + "\t\t__valIter =_dataset.find(includeEntireDataset, _resource, ";
  protected final String TEXT_73 = "Property, null,_graph.getNamedGraphUri());" + NL + "\t\tif(__valIter.isEmpty()) return null;" + NL + "\t\torg.openanzo.rdf.Statement statement = __valIter.iterator().next();" + NL + "\t\tif (statement == null) return null;";
  protected final String TEXT_74 = NL + "\t\tif (!(statement.getObject() instanceof org.openanzo.rdf.URI))" + NL + "\t\t\tthrow new org.openanzo.rdf.jastor.InvalidNodeException(uri() + \": ";
  protected final String TEXT_75 = " getProperty() in ";
  protected final String TEXT_76 = " model not URI\", statement.getObject());" + NL + "\t\treturn (org.openanzo.rdf.URI)statement.getObject();";
  protected final String TEXT_77 = "\t\t" + NL + "\t\tif (!(statement.getObject() instanceof org.openanzo.rdf.Literal))" + NL + "\t\t\tthrow new org.openanzo.rdf.jastor.InvalidNodeException(uri() + \": ";
  protected final String TEXT_78 = " getProperty() in ";
  protected final String TEXT_79 = " model not Literal\", statement.getObject());" + NL + "\t\torg.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();";
  protected final String TEXT_80 = NL + "\t\treturn literal;";
  protected final String TEXT_81 = NL + "\t\tObject obj = getLiteralValue(literal, \"";
  protected final String TEXT_82 = "\");" + NL + "\t\tif (!(obj instanceof ";
  protected final String TEXT_83 = "))" + NL + "\t\t\tthrow new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + \": Literal ";
  protected final String TEXT_84 = " in ";
  protected final String TEXT_85 = " is not of type ";
  protected final String TEXT_86 = "\", literal);" + NL + "\t\treturn (";
  protected final String TEXT_87 = ")obj;";
  protected final String TEXT_88 = NL + "\t\t" + NL + "\t}" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_89 = " get";
  protected final String TEXT_90 = "() throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\treturn get";
  protected final String TEXT_91 = "(false);" + NL + "\t}" + NL + "\t" + NL + "\tpublic void set";
  protected final String TEXT_92 = "(";
  protected final String TEXT_93 = " ";
  protected final String TEXT_94 = ") throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\t_dataset.remove(_resource, ";
  protected final String TEXT_95 = "Property, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              " + NL + "\t\tif (";
  protected final String TEXT_96 = " != null) {" + NL + "\t";
  protected final String TEXT_97 = NL + "\t\t\t_dataset.add(_resource, ";
  protected final String TEXT_98 = "Property, ";
  protected final String TEXT_99 = ",_graph.getNamedGraphUri());" + NL + "\t";
  protected final String TEXT_100 = NL + "\t\t\torg.openanzo.rdf.Literal _literal = getLiteral(";
  protected final String TEXT_101 = ",\"";
  protected final String TEXT_102 = "\");" + NL + "\t\t\t_dataset.add(_resource, ";
  protected final String TEXT_103 = "Property, _literal,_graph.getNamedGraphUri());" + NL + "\t";
  protected final String TEXT_104 = NL + "\t\t}\t" + NL + "\t}";
  protected final String TEXT_105 = NL;
  protected final String TEXT_106 = NL + NL + "\torg.openanzo.rdf.jastor.PropertyCollection<";
  protected final String TEXT_107 = "> propertyCollection";
  protected final String TEXT_108 = " = new org.openanzo.rdf.jastor.PropertyCollection<";
  protected final String TEXT_109 = ">() {" + NL + "\t\tpublic ";
  protected final String TEXT_110 = " getPropertyValue(org.openanzo.rdf.Value value) {" + NL + "\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\tif(value instanceof org.openanzo.rdf.URI){ " + NL + "\t\t\t\t\treturn (org.openanzo.rdf.URI)value;";
  protected final String TEXT_112 = NL + "\t\t\t\tif(value instanceof org.openanzo.rdf.Literal){" + NL + "\t\t\t\t\torg.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;" + NL + "\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\t\treturn literal;" + NL + "\t";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\treturn getLiteralValue(literal, \"";
  protected final String TEXT_115 = "\");";
  protected final String TEXT_116 = NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tthrow new org.openanzo.rdf.jastor.InvalidNodeException (uri() + \": One of the ";
  protected final String TEXT_117 = " properties in ";
  protected final String TEXT_118 = " model not a Literal\",value);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t};" + NL + "" + NL + "\tpublic java.util.Collection<";
  protected final String TEXT_119 = "> get";
  protected final String TEXT_120 = "(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\treturn propertyCollection";
  protected final String TEXT_121 = ".getPropertyCollection(_dataset, _graph, _resource,";
  protected final String TEXT_122 = "Property, org.openanzo.rdf.MemURI.create(\"";
  protected final String TEXT_123 = "\"), includeEntireDataset);" + NL + "\t}" + NL + "\t" + NL + "\tpublic java.util.Collection<";
  protected final String TEXT_124 = "> get";
  protected final String TEXT_125 = "() throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\treturn get";
  protected final String TEXT_126 = "(false);" + NL + "\t}" + NL + "" + NL + "\tpublic void add";
  protected final String TEXT_127 = "(";
  protected final String TEXT_128 = " ";
  protected final String TEXT_129 = ") throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t";
  protected final String TEXT_130 = NL + "\t\t//if (_dataset.contains(_resource, ";
  protected final String TEXT_131 = "Property,";
  protected final String TEXT_132 = ",_graph.getNamedGraphUri()))" + NL + "\t\t//\treturn;" + NL + "\t\t_dataset.add(_resource, ";
  protected final String TEXT_133 = "Property, ";
  protected final String TEXT_134 = ",_graph.getNamedGraphUri());" + NL + "\t";
  protected final String TEXT_135 = NL + "\t\torg.openanzo.rdf.Literal _literal = getLiteral(";
  protected final String TEXT_136 = ",\"";
  protected final String TEXT_137 = "\");" + NL + "\t\t//if (_dataset.contains(_resource, ";
  protected final String TEXT_138 = "Property,_literal,_graph.getNamedGraphUri()))" + NL + "\t\t//\treturn;" + NL + "\t" + NL + "\t\tif (";
  protected final String TEXT_139 = " != null) {" + NL + "\t\t\t_dataset.add(_resource, ";
  protected final String TEXT_140 = "Property,_literal,_graph.getNamedGraphUri());" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_141 = NL + "\t}" + NL + "\t" + NL + "\tpublic void remove";
  protected final String TEXT_142 = "(";
  protected final String TEXT_143 = " ";
  protected final String TEXT_144 = ") throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\t";
  protected final String TEXT_145 = NL + "\t\tif (!_dataset.contains(_resource, ";
  protected final String TEXT_146 = "Property, ";
  protected final String TEXT_147 = ",_graph.getNamedGraphUri()))" + NL + "\t\t\treturn;" + NL + "\t\t_dataset.remove(_resource, ";
  protected final String TEXT_148 = "Property, ";
  protected final String TEXT_149 = ",_graph.getNamedGraphUri());" + NL + "\t\t";
  protected final String TEXT_150 = NL + "\t\torg.openanzo.rdf.Literal _literal = getLiteral(";
  protected final String TEXT_151 = ",\"";
  protected final String TEXT_152 = "\");" + NL + "\t\tif (!_dataset.contains(_resource, ";
  protected final String TEXT_153 = "Property, _literal,_graph.getNamedGraphUri()))" + NL + "\t\t\treturn;" + NL + "\t\t_dataset.remove(_resource, ";
  protected final String TEXT_154 = "Property, _literal,_graph.getNamedGraphUri());" + NL + "\t\t";
  protected final String TEXT_155 = NL + "\t}" + NL;
  protected final String TEXT_156 = NL + "\tpublic ";
  protected final String TEXT_157 = " get";
  protected final String TEXT_158 = "(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\tjava.util.Collection<org.openanzo.rdf.Statement> result = null;" + NL + "\t\tresult=_dataset.find(includeEntireDataset, _resource, ";
  protected final String TEXT_159 = "Property, null,_graph.getNamedGraphUri());" + NL + "\t\tif(result.isEmpty()) return null;" + NL + "\t\torg.openanzo.rdf.Statement statement = result.iterator().next();" + NL + "\t\tif (statement == null)" + NL + "\t\t\treturn null;" + NL + "\t\tif (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))" + NL + "\t\t\tthrow new org.openanzo.rdf.jastor.InvalidNodeException(uri() + \": ";
  protected final String TEXT_160 = " getProperty() in ";
  protected final String TEXT_161 = " model not Resource\", statement.getObject());" + NL + "\t\torg.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();" + NL + "\t\treturn ";
  protected final String TEXT_162 = ".get";
  protected final String TEXT_163 = "(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);" + NL + "\t\t" + NL + "\t}" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_164 = " get";
  protected final String TEXT_165 = "() throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\treturn get";
  protected final String TEXT_166 = "(false);" + NL + "\t}" + NL + "" + NL + "\tpublic void set";
  protected final String TEXT_167 = "(";
  protected final String TEXT_168 = " ";
  protected final String TEXT_169 = ") throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\t_dataset.remove(_resource, ";
  protected final String TEXT_170 = "Property, null,_graph.getNamedGraphUri());" + NL + "\t\tif (";
  protected final String TEXT_171 = " != null) {" + NL + "\t\t\t_dataset.add(_resource, ";
  protected final String TEXT_172 = "Property, ";
  protected final String TEXT_173 = ".resource(),_graph.getNamedGraphUri());" + NL + "\t\t}\t\t\t" + NL + "\t}" + NL + "\t\t" + NL + "\tpublic ";
  protected final String TEXT_174 = " set";
  protected final String TEXT_175 = "() throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\t_dataset.remove(_resource, ";
  protected final String TEXT_176 = "Property, null,_graph.getNamedGraphUri());" + NL + "\t\t";
  protected final String TEXT_177 = " ";
  protected final String TEXT_178 = " = ";
  protected final String TEXT_179 = ".create";
  protected final String TEXT_180 = "(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);" + NL + "\t\t_dataset.add(_resource, ";
  protected final String TEXT_181 = "Property, ";
  protected final String TEXT_182 = ".resource(),_graph.getNamedGraphUri());" + NL + "\t\treturn ";
  protected final String TEXT_183 = ";" + NL + "\t}" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_184 = " set";
  protected final String TEXT_185 = "(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {";
  protected final String TEXT_186 = NL + "\t\tif (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,";
  protected final String TEXT_187 = ".TYPE,_graph.getNamedGraphUri())) {" + NL + "\t\t\tthrow new org.openanzo.rdf.jastor.JastorException(\"Resource \" + resource + \" not of type \" + ";
  protected final String TEXT_188 = ".TYPE);" + NL + "\t\t}";
  protected final String TEXT_189 = NL + "\t\tif (_dataset.contains(_resource, ";
  protected final String TEXT_190 = "Property, null,_graph.getNamedGraphUri())) {" + NL + "\t\t\t_dataset.remove(_resource, ";
  protected final String TEXT_191 = "Property, null,_graph.getNamedGraphUri());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_192 = " ";
  protected final String TEXT_193 = " = ";
  protected final String TEXT_194 = ".get";
  protected final String TEXT_195 = "(resource,_graph.getNamedGraphUri(),_dataset);" + NL + "\t\t_dataset.add(_resource, ";
  protected final String TEXT_196 = "Property, ";
  protected final String TEXT_197 = ".resource(),_graph.getNamedGraphUri());" + NL + "\t\treturn ";
  protected final String TEXT_198 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_199 = NL + "// generating range: ";
  protected final String TEXT_200 = NL + NL + "\torg.openanzo.rdf.jastor.PropertyCollection<";
  protected final String TEXT_201 = "> propertyCollection";
  protected final String TEXT_202 = " = new org.openanzo.rdf.jastor.PropertyCollection<";
  protected final String TEXT_203 = ">() {" + NL + "\t\tpublic ";
  protected final String TEXT_204 = " getPropertyValue(org.openanzo.rdf.Value resource) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_205 = ".get";
  protected final String TEXT_206 = "((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());" + NL + "\t\t\t} catch (org.openanzo.rdf.jastor.JastorException e) {" + NL + "\t\t\t\tthrow new java.util.NoSuchElementException(e.getMessage());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "\t/**" + NL + "\t * " + NL + "\t * @param includeEntireDataset" + NL + "\t * @return collection of ";
  protected final String TEXT_207 = " " + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic java.util.Collection<";
  protected final String TEXT_208 = "> get";
  protected final String TEXT_209 = "(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\treturn propertyCollection";
  protected final String TEXT_210 = ".getPropertyCollection(_dataset, _graph, _resource,";
  protected final String TEXT_211 = "Property, org.openanzo.rdf.MemURI.create(\"";
  protected final String TEXT_212 = "\"), includeEntireDataset);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * " + NL + "\t * @return collection of ";
  protected final String TEXT_213 = "  not including entire dataset during search" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic java.util.Collection<";
  protected final String TEXT_214 = "> get";
  protected final String TEXT_215 = "() throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\treturn get";
  protected final String TEXT_216 = "(false);" + NL + "\t}" + NL + "" + NL + "/**" + NL + "     * " + NL + "     * @param ";
  protected final String TEXT_217 = " value to add" + NL + "     * @throws org.openanzo.rdf.jastor.JastorException" + NL + "     */" + NL + "\tpublic void add";
  protected final String TEXT_218 = "(";
  protected final String TEXT_219 = " ";
  protected final String TEXT_220 = ") throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\t_dataset.add(_resource, ";
  protected final String TEXT_221 = "Property,";
  protected final String TEXT_222 = ".resource(),_graph.getNamedGraphUri());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "     * Add anonymous object" + NL + "     * @return generated object" + NL + "     * @throws org.openanzo.rdf.jastor.JastorException" + NL + "     */\t" + NL + "\tpublic ";
  protected final String TEXT_223 = " add";
  protected final String TEXT_224 = "() throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\t";
  protected final String TEXT_225 = " ";
  protected final String TEXT_226 = " = ";
  protected final String TEXT_227 = ".create";
  protected final String TEXT_228 = "(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);" + NL + "\t\t_dataset.add(_resource, ";
  protected final String TEXT_229 = "Property,";
  protected final String TEXT_230 = ".resource(),_graph.getNamedGraphUri());" + NL + "\t\treturn ";
  protected final String TEXT_231 = ";" + NL + "\t}" + NL + "\t" + NL + "\t /**" + NL + "     * Add resource " + NL + "     * @param resource resource to add" + NL + "     * @return jastor object for resource" + NL + "     * @throws org.openanzo.rdf.jastor.JastorException" + NL + "     */" + NL + "\tpublic ";
  protected final String TEXT_232 = " add";
  protected final String TEXT_233 = "(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {";
  protected final String TEXT_234 = NL + "\t\tif (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,";
  protected final String TEXT_235 = ".TYPE,_graph.getNamedGraphUri()))" + NL + "\t\t\tthrow new org.openanzo.rdf.jastor.JastorException(\"Resource \" + resource + \" not of type \" + ";
  protected final String TEXT_236 = ".TYPE);";
  protected final String TEXT_237 = NL + "\t\t";
  protected final String TEXT_238 = " ";
  protected final String TEXT_239 = " = ";
  protected final String TEXT_240 = ".get";
  protected final String TEXT_241 = "(resource,_graph.getNamedGraphUri(),_dataset);" + NL + "\t\t_dataset.add(_resource, ";
  protected final String TEXT_242 = "Property,";
  protected final String TEXT_243 = ".resource(),_graph.getNamedGraphUri());" + NL + "\t\treturn ";
  protected final String TEXT_244 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Remove object" + NL + "\t * @param ";
  protected final String TEXT_245 = " object to remove" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic void remove";
  protected final String TEXT_246 = "(";
  protected final String TEXT_247 = " ";
  protected final String TEXT_248 = ") throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\tif (!_dataset.contains(_resource, ";
  protected final String TEXT_249 = "Property, ";
  protected final String TEXT_250 = ".resource(),_graph.getNamedGraphUri()))" + NL + "\t\t\treturn;" + NL + "\t\t_dataset.remove(_resource, ";
  protected final String TEXT_251 = "Property, ";
  protected final String TEXT_252 = ".resource(),_graph.getNamedGraphUri());" + NL + "\t}";
  protected final String TEXT_253 = NL + NL + "\t/**" + NL + "\t * Remove resource" + NL + "\t * @param resource resource to remove" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic void remove";
  protected final String TEXT_254 = "(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\tif (!_dataset.contains(_resource, ";
  protected final String TEXT_255 = "Property, resource,_graph.getNamedGraphUri()))" + NL + "\t\t\treturn;" + NL + "\t\t_dataset.remove(_resource, ";
  protected final String TEXT_256 = "Property, resource,_graph.getNamedGraphUri());" + NL + "\t}" + NL + " ";
  protected final String TEXT_257 = " " + NL;
  protected final String TEXT_258 = NL + NL + "\tprotected java.util.concurrent.CopyOnWriteArraySet<";
  protected final String TEXT_259 = "> listeners = new  java.util.concurrent.CopyOnWriteArraySet<";
  protected final String TEXT_260 = ">();" + NL + "\t" + NL + "\tpublic void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {" + NL + "\t\tif (!(listener instanceof ";
  protected final String TEXT_261 = ")) {" + NL + "\t\t\tthrow new org.openanzo.rdf.jastor.JastorException(\"Listener class not of proper type\");" + NL + "\t\t}" + NL + "\t\tif(listeners.size()==0){" + NL + "    \t\t_dataset.registerListener(_listener);" + NL + "    \t}" + NL + "    \t";
  protected final String TEXT_262 = " list = (";
  protected final String TEXT_263 = ")listener;" + NL + "\t\tif(!listeners.contains(list)){" + NL + "\t\t\tlisteners.add(list);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {" + NL + "\t\tif (!(listener instanceof ";
  protected final String TEXT_264 = ")) {" + NL + "\t\t\tthrow new org.openanzo.rdf.jastor.JastorException(\"Listener class not of proper type\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_265 = " list = (";
  protected final String TEXT_266 = ")listener;" + NL + "\t\tif(listeners.contains(list)){" + NL + "\t\t\tlisteners.remove(list);" + NL + "\t\t}" + NL + "\t\tif(listeners.size()==0){\t" + NL + "    \t\t_dataset.unregisterListener(_listener);" + NL + "    \t}" + NL + "\t}" + NL + "\t" + NL;
  protected final String TEXT_267 = NL;
  protected final String TEXT_268 = NL + NL + "\tprotected class ThingStatementListener implements org.openanzo.rdf.IStatementListener<org.openanzo.rdf.IDataset> {" + NL + "\t" + NL + "\t\tpublic void statementsAdded(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {" + NL + "\t\tfor(org.openanzo.rdf.Statement statement:statements){" + NL + "\t\t\tif (statement.getSubject().equals(resource())){";
  protected final String TEXT_269 = NL + "\t\t\tif (statement.getPredicate().equals(";
  protected final String TEXT_270 = "Property)) {";
  protected final String TEXT_271 = "\t\t\t\t" + NL + "\t\t\t\tif (!(statement.getObject() instanceof org.openanzo.rdf.Literal))" + NL + "\t\t\t\t\treturn;\t\t";
  protected final String TEXT_272 = NL + "\t\t\t\tfor(";
  protected final String TEXT_273 = "Listener listener : listeners){" + NL + "\t\t\t\t\tlistener.";
  protected final String TEXT_274 = "Changed(";
  protected final String TEXT_275 = ".this);" + NL + "\t\t\t\t}";
  protected final String TEXT_276 = "\t\t\t\t" + NL + "\t\t\t\tif (!(statement.getObject() instanceof org.openanzo.rdf.Literal))" + NL + "\t\t\t\t\treturn;\t\t" + NL + "" + NL + "\t\t\t\torg.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();" + NL;
  protected final String TEXT_277 = NL + "\t\t\t\tfor(";
  protected final String TEXT_278 = "Listener listener : listeners){" + NL + "\t\t\t\t\tlistener.";
  protected final String TEXT_279 = "Added(";
  protected final String TEXT_280 = ".this,literal);" + NL + "\t\t\t\t}";
  protected final String TEXT_281 = NL + "\t\t\t\tObject obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);" + NL + "\t\t\t\tif (obj instanceof ";
  protected final String TEXT_282 = ") {" + NL + "\t\t\t\t\tfor(";
  protected final String TEXT_283 = "Listener listener : listeners){" + NL + "\t\t\t\t\t\tlistener.";
  protected final String TEXT_284 = "Added(";
  protected final String TEXT_285 = ".this,(";
  protected final String TEXT_286 = ")obj);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_287 = NL + "\t\t\tif (statement.getObject() instanceof org.openanzo.rdf.URI) {" + NL + "\t\t\t\t\tfor(";
  protected final String TEXT_288 = "Listener listener : listeners){" + NL + "\t\t\t\t\t\tlistener.";
  protected final String TEXT_289 = "Added(";
  protected final String TEXT_290 = ".this,(org.openanzo.rdf.URI)statement.getObject());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_291 = NL + "\t\t\t\tif (!(statement.getObject() instanceof org.openanzo.rdf.Resource))" + NL + "\t\t\t\t\treturn;\t\t\t\t" + NL + "\t\t\t\tfor(";
  protected final String TEXT_292 = "Listener listener : listeners){" + NL + "\t\t\t\t\tlistener.";
  protected final String TEXT_293 = "Changed(";
  protected final String TEXT_294 = ".this);" + NL + "\t\t\t\t}";
  protected final String TEXT_295 = NL + "\t\t\t\tif (!(statement.getObject() instanceof org.openanzo.rdf.Resource))" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\torg.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();";
  protected final String TEXT_296 = NL + "\t\t\t\t";
  protected final String TEXT_297 = " _";
  protected final String TEXT_298 = " = ";
  protected final String TEXT_299 = ".get";
  protected final String TEXT_300 = "(resource,_graph.getNamedGraphUri(),dataset());" + NL + "\t\t\t\tif (_";
  protected final String TEXT_301 = " != null) {" + NL + "\t\t\t\t\tfor(";
  protected final String TEXT_302 = "Listener listener : listeners){" + NL + "\t\t\t\t\t\tlistener.";
  protected final String TEXT_303 = "Added(";
  protected final String TEXT_304 = ".this,_";
  protected final String TEXT_305 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_306 = "\t\t\t" + NL + "\t\t\t}";
  protected final String TEXT_307 = NL + "\t\t}}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {" + NL + "\t\tfor(org.openanzo.rdf.Statement statement:statements){" + NL + "\t\t\tif (statement.getSubject().equals(resource())){";
  protected final String TEXT_308 = NL + "\t\t\tif (statement.getPredicate().equals(";
  protected final String TEXT_309 = "Property)) {";
  protected final String TEXT_310 = "\t\t\t\t" + NL + "\t\t\t\tif (!(statement.getObject() instanceof org.openanzo.rdf.Literal))" + NL + "\t\t\t\t\treturn;\t\t";
  protected final String TEXT_311 = NL + "\t\t\t\tfor(";
  protected final String TEXT_312 = "Listener listener : listeners) {" + NL + "\t\t\t\t\tlistener.";
  protected final String TEXT_313 = "Changed(";
  protected final String TEXT_314 = ".this);" + NL + "\t\t\t\t}";
  protected final String TEXT_315 = "\t" + NL + "\t\t\t\tif (!(statement.getObject() instanceof org.openanzo.rdf.Literal))" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\torg.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();";
  protected final String TEXT_316 = NL + "\t\t\t\tfor(";
  protected final String TEXT_317 = "Listener listener:listeners){" + NL + "\t\t\t\t\tlistener.";
  protected final String TEXT_318 = "Removed(";
  protected final String TEXT_319 = ".this,literal);" + NL + "\t\t\t\t}";
  protected final String TEXT_320 = NL + "\t\t\t\tObject obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);" + NL + "\t\t\t\tif (obj instanceof ";
  protected final String TEXT_321 = ") {" + NL + "\t\t\t\t\tfor(";
  protected final String TEXT_322 = "Listener listener : listeners){" + NL + "\t\t\t\t\t\tlistener.";
  protected final String TEXT_323 = "Removed(";
  protected final String TEXT_324 = ".this,(";
  protected final String TEXT_325 = ")obj);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_326 = NL + "\t\t\tif (statement.getObject() instanceof org.openanzo.rdf.URI) {" + NL + "\t\t\t\t\tfor(";
  protected final String TEXT_327 = "Listener listener : listeners){" + NL + "\t\t\t\t\t\tlistener.";
  protected final String TEXT_328 = "Added(";
  protected final String TEXT_329 = ".this,(org.openanzo.rdf.URI)statement.getObject());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_330 = NL + "\t\t\t\tif (!(statement.getObject() instanceof org.openanzo.rdf.Resource))" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\tfor(";
  protected final String TEXT_331 = "Listener listener : listeners){" + NL + "\t\t\t\t\tlistener.";
  protected final String TEXT_332 = "Changed(";
  protected final String TEXT_333 = ".this);" + NL + "\t\t\t\t}";
  protected final String TEXT_334 = NL + "\t\t\t\tif (!(statement.getObject() instanceof org.openanzo.rdf.Resource))" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\torg.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();";
  protected final String TEXT_335 = NL + "\t\t\t\t";
  protected final String TEXT_336 = " _";
  protected final String TEXT_337 = " = ";
  protected final String TEXT_338 = ".get";
  protected final String TEXT_339 = "(resource,_graph.getNamedGraphUri(),dataset());" + NL + "\t\t\t\tif (_";
  protected final String TEXT_340 = " != null) {" + NL + "\t\t\t\t\tfor(";
  protected final String TEXT_341 = "Listener listener : listeners){" + NL + "\t\t\t\t\t\tlistener.";
  protected final String TEXT_342 = "Removed(";
  protected final String TEXT_343 = ".this,_";
  protected final String TEXT_344 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_345 = NL + "\t\t\t\treturn;" + NL + "\t\t\t}";
  protected final String TEXT_346 = NL + "\t\t}" + NL + "\t\t}}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_347 = NL + NL + NL + "}";

	OntologyClassFileProvider fileProvider;

	public ImplementationTemplate(OntologyClassFileProvider fileProvider) {
		this.fileProvider = fileProvider;
	}
	
	public ImplementationTemplate() {
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
    stringBuffer.append(oc.getFactoryFullClassname());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ctx.remapUri(oc.getURI()) );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(oc.getImplClassname());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ctx.getThingImpl().getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_13);
     if (ctx.isGenerateListeners()) { 
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
     for (OntologyProperty prop:oc.listProperties(true)) {
     // have to add the properties here to so we have no ambiguity with multiple inheritance 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(ctx.remapUri(prop.getURI()));
    stringBuffer.append(TEXT_18);
     } 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(oc.getImplClassname());
    stringBuffer.append(TEXT_20);
     if (ctx.isGenerateListeners()) { 
    stringBuffer.append(TEXT_21);
     } 
    stringBuffer.append(TEXT_22);
     if (oc.isEnumeratedClass()) { 
    stringBuffer.append(TEXT_23);
     java.util.Iterator<org.openanzo.rdf.Resource> oneOfClassesItr = oc.listOneOfClasses().iterator(); 
       while (oneOfClassesItr.hasNext()) { 
    		org.openanzo.rdf.Resource oneOfClass = oneOfClassesItr.next(); 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(oc.getIndividualIdentifierName(oneOfClass));
    stringBuffer.append(TEXT_25);
       } 
    stringBuffer.append(TEXT_26);
     } 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(oc.getImplClassname());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_30);
     if (ctx.isUseStrictTypeChecking()) { 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_32);
     } 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(oc.getImplClassname());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(oc.getImplClassname());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_36);
     if (oc.isEnumeratedClass()) { 
    stringBuffer.append(TEXT_37);
    stringBuffer.append(oc.getURI());
    stringBuffer.append(TEXT_38);
     } 
    stringBuffer.append(TEXT_39);
    stringBuffer.append(oc.getImplClassname());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(oc.getImplClassname());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_43);
    	for (OntologyClass ocl:oc.listAllExtensionClasses()) { 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ocl.getInterfaceFullClassname());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ocl.getInterfaceFullClassname());
    stringBuffer.append(TEXT_46);
    	} 
    stringBuffer.append(TEXT_47);
     for (OntologyProperty prop:oc.listProperties(true)) {
    			List<Value> list = prop.getHasValueValues(); 
    			for (int i=0;i<list.size();i++) { 
    				Value node = list.get(i); 
    				if (prop.isObjectProperty()) { 
    stringBuffer.append(TEXT_48);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(node);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(node);
    stringBuffer.append(TEXT_52);
    				} else { 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(((org.openanzo.rdf.Literal)node).getLabel());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(((org.openanzo.rdf.Literal)node).getLabel());
    stringBuffer.append(TEXT_57);
    				} 
    			} 
    		} 
    stringBuffer.append(TEXT_58);
     for (OntologyProperty prop:oc.listProperties(true)) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_60);
     } 
    stringBuffer.append(TEXT_61);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_62);
    	for (OntologyClass ocl: oc.listAllExtensionClasses()) { 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(ocl.getInterfaceFullClassname());
    stringBuffer.append(TEXT_64);
    	} 
    stringBuffer.append(TEXT_65);
     for (OntologyProperty prop: oc.listProperties(true)) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(prop.toString());
    		if (prop.isSingleValued() && prop.isDatatypeProperty()) { 
    			for (Resource res:prop.listAllRanges()) { 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_73);
    	if(prop.getReturnType(res).equals(org.openanzo.rdf.URI.class.getCanonicalName())){ 
    stringBuffer.append(TEXT_74);
    stringBuffer.append(prop.getPropertyName(res));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_76);
    }else{
    stringBuffer.append(TEXT_77);
    stringBuffer.append(prop.getPropertyName(res));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_79);
     			if (prop.getReturnType(res).equals("org.openanzo.rdf.Literal")) { 
    stringBuffer.append(TEXT_80);
     			} else { 
    stringBuffer.append(TEXT_81);
    stringBuffer.append(prop.getRangeURI(res));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(prop.getPropertyName(res));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_87);
     			}} 
    stringBuffer.append(TEXT_88);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_96);
    	if (prop.getReturnType(res).equals(org.openanzo.rdf.URI.class.getCanonicalName()) || prop.getReturnType(res).equals("org.openanzo.rdf.Literal")) { 
    stringBuffer.append(TEXT_97);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_99);
    } else { 
    stringBuffer.append(TEXT_100);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(prop.getRangeURI(res));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
           } // end allRanges 
       } // end single-data 
    stringBuffer.append(TEXT_105);
    	  if (prop.isMultiValued() && prop.isDatatypeProperty()) { 
    			for (Resource res:prop.listAllRanges()) { 
    stringBuffer.append(TEXT_106);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_110);
    	if(prop.getReturnType(res).equals(org.openanzo.rdf.URI.class.getCanonicalName())){ 
    stringBuffer.append(TEXT_111);
     			} else { 
    stringBuffer.append(TEXT_112);
     				if (prop.getReturnType(res).equals("org.openanzo.rdf.Literal")) { 
    stringBuffer.append(TEXT_113);
                 } else { 
    stringBuffer.append(TEXT_114);
    stringBuffer.append(prop.getRangeURI(res));
    stringBuffer.append(TEXT_115);
    					}} 
    stringBuffer.append(TEXT_116);
    stringBuffer.append(ctx.remapUri(prop.getURI()));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(prop.getRangeURI(res));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_129);
    	if(prop.getReturnType(res).equals(org.openanzo.rdf.URI.class.getCanonicalName())){ 
    stringBuffer.append(TEXT_130);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_134);
                 } else { 
    stringBuffer.append(TEXT_135);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(prop.getRangeURI(res));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_144);
    	if(prop.getReturnType(res).equals(org.openanzo.rdf.URI.class.getCanonicalName())){ 
    stringBuffer.append(TEXT_145);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_149);
                 } else { 
    stringBuffer.append(TEXT_150);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(prop.getRangeURI(res));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_154);
    }
    stringBuffer.append(TEXT_155);
       		} 
       } 
    	 if (prop.isSingleValued() && prop.isObjectProperty()) { 
    			for (Resource res:prop.listAllRanges()) { 
    stringBuffer.append(TEXT_156);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(prop.getPropertyName(res));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(prop.getRangeOntologyClass(res).getFactoryFullClassname());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceClassname());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(prop.getRangeOntologyClass(res).getFactoryFullClassname());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceClassname());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_185);
     			if (ctx.isUseStrictTypeChecking() && !prop.getRangeOntologyClass(res).getURI().equals(org.openanzo.rdf.vocabulary.RDFS.RESOURCE)) { 
    stringBuffer.append(TEXT_186);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceFullClassname());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceFullClassname());
    stringBuffer.append(TEXT_188);
     			} 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_193);
    stringBuffer.append(prop.getRangeOntologyClass(res).getFactoryFullClassname());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceClassname());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_198);
           } 
      } 
    	 if (prop.isMultiValued() && prop.isObjectProperty()) { 
    			for (Resource res:prop.listAllRanges()) { 
    stringBuffer.append(TEXT_199);
    stringBuffer.append(res.toString());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(prop.getRangeOntologyClass(res).getFactoryFullClassname());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceClassname());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(prop.getRangeURI(res));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_220);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_226);
    stringBuffer.append(prop.getRangeOntologyClass(res).getFactoryFullClassname());
    stringBuffer.append(TEXT_227);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceClassname());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_229);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_230);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_231);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_233);
     			if (ctx.isUseStrictTypeChecking() && !prop.getRangeOntologyClass(res).getURI().equals(org.openanzo.rdf.vocabulary.RDFS.RESOURCE)) { 
    stringBuffer.append(TEXT_234);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceFullClassname());
    stringBuffer.append(TEXT_235);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceFullClassname());
    stringBuffer.append(TEXT_236);
     			} 
    stringBuffer.append(TEXT_237);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_239);
    stringBuffer.append(prop.getRangeOntologyClass(res).getFactoryFullClassname());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceClassname());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_242);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_243);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_245);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_246);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_250);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_251);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_252);
        } // end alt return types 
    stringBuffer.append(TEXT_253);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_254);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_256);
      }  // end mulitvalued-object 
     } // end all props
    stringBuffer.append(TEXT_257);
     if (ctx.isGenerateListeners()) { 
    stringBuffer.append(TEXT_258);
    stringBuffer.append(oc.getListenerClassname());
    stringBuffer.append(TEXT_259);
    stringBuffer.append(oc.getListenerClassname());
    stringBuffer.append(TEXT_260);
    stringBuffer.append(oc.getListenerClassname());
    stringBuffer.append(TEXT_261);
    stringBuffer.append(oc.getListenerClassname());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(oc.getListenerClassname());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(oc.getListenerClassname());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(oc.getListenerClassname());
    stringBuffer.append(TEXT_265);
    stringBuffer.append(oc.getListenerClassname());
    stringBuffer.append(TEXT_266);
     } 
    stringBuffer.append(TEXT_267);
     if (ctx.isGenerateListeners()) { 
    stringBuffer.append(TEXT_268);
     	for (OntologyProperty prop: oc.listProperties(true)) {
    stringBuffer.append(TEXT_269);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_270);
    			if (prop.isSingleValued() && prop.isDatatypeProperty()) { 
     			if (!prop.getReturnType().equals("org.openanzo.rdf.URI")){
    stringBuffer.append(TEXT_271);
    }
    stringBuffer.append(TEXT_272);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_274);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_275);
    			} 
    			if (prop.isMultiValued() && prop.isDatatypeProperty()) { 
     			if (!prop.getReturnType().equals("org.openanzo.rdf.URI")){
    stringBuffer.append(TEXT_276);
    				for (Resource res:prop.listAllRanges()) { 
     					if (prop.getReturnType(res).equals("org.openanzo.rdf.Literal")) { 
    stringBuffer.append(TEXT_277);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_278);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_279);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_280);
    					}  else {
    stringBuffer.append(TEXT_281);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_283);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_285);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_286);
    					} 
    				} 
    				}else{
    stringBuffer.append(TEXT_287);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_288);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_290);
    			}} 
    			if (prop.isSingleValued() && prop.isObjectProperty()) { 
    stringBuffer.append(TEXT_291);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_293);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_294);
    			} 
    			if (prop.isMultiValued() && prop.isObjectProperty()) { 
    stringBuffer.append(TEXT_295);
    				for (Resource res:prop.listAllRanges()) { 
    stringBuffer.append(TEXT_296);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(prop.getPropertyName(res));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(prop.getRangeOntologyClass(res).getFactoryFullClassname());
    stringBuffer.append(TEXT_299);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceClassname());
    stringBuffer.append(TEXT_300);
    stringBuffer.append(prop.getPropertyName(res));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_302);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_303);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_304);
    stringBuffer.append(prop.getPropertyName(res));
    stringBuffer.append(TEXT_305);
    				} 
    			} 
    stringBuffer.append(TEXT_306);
    		} 
    stringBuffer.append(TEXT_307);
     	for (OntologyProperty prop: oc.listProperties(true)) {
    stringBuffer.append(TEXT_308);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_309);
    			if (prop.isSingleValued() && prop.isDatatypeProperty()) { 
     			if (!prop.getReturnType().equals("org.openanzo.rdf.URI")){
    stringBuffer.append(TEXT_310);
    }
    stringBuffer.append(TEXT_311);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_312);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_313);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_314);
    			} 
    			if (prop.isMultiValued() && prop.isDatatypeProperty()) { 
     			if (!prop.getReturnType().equals("org.openanzo.rdf.URI")){
    stringBuffer.append(TEXT_315);
    				for (Resource res:prop.listAllRanges()) { 
     					if (prop.getReturnType(res).equals("org.openanzo.rdf.Literal")) { 
    stringBuffer.append(TEXT_316);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_317);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_318);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_319);
    					}  else {
    stringBuffer.append(TEXT_320);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_322);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_323);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_324);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_325);
    					} 
    				} 
    			}else{
    stringBuffer.append(TEXT_326);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_328);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_329);
    			}} 
    			if (prop.isSingleValued() && prop.isObjectProperty()) { 
    stringBuffer.append(TEXT_330);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_331);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_333);
    			} 
    			if (prop.isMultiValued() && prop.isObjectProperty()) { 
    stringBuffer.append(TEXT_334);
    				for (Resource res:prop.listAllRanges()) { 
    stringBuffer.append(TEXT_335);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(prop.getPropertyName(res));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(prop.getRangeOntologyClass(res).getFactoryFullClassname());
    stringBuffer.append(TEXT_338);
    stringBuffer.append(prop.getRangeOntologyClass(res).getInterfaceClassname());
    stringBuffer.append(TEXT_339);
    stringBuffer.append(prop.getPropertyName(res));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_341);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_342);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_343);
    stringBuffer.append(prop.getPropertyName(res));
    stringBuffer.append(TEXT_344);
    				} 
    			} 
    stringBuffer.append(TEXT_345);
    		} 
    stringBuffer.append(TEXT_346);
     } 
    stringBuffer.append(TEXT_347);
    return stringBuffer.toString();
  }
}