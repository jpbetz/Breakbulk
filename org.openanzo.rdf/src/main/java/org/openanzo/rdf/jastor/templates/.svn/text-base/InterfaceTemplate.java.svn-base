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
public class InterfaceTemplate implements OntologyClassTemplate {
	
  protected static String nl;
  public static synchronized InterfaceTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    InterfaceTemplate result = new InterfaceTemplate();
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
  protected final String TEXT_7 = ";" + NL + "" + NL + "/**" + NL + " * Interface for ";
  protected final String TEXT_8 = " ontology class<br>" + NL + " * Use the ";
  protected final String TEXT_9 = " to create instances of this interface." + NL + " * <p>(URI: ";
  protected final String TEXT_10 = ")</p>" + NL + " * <br>";
  protected final String TEXT_11 = NL + " * RDF Schema Standard Properties <br>";
  protected final String TEXT_12 = NL + " * \t";
  protected final String TEXT_13 = " <br>";
  protected final String TEXT_14 = NL + " * <br>";
  protected final String TEXT_15 = NL + " * Dublin Core Standard Properties <br>";
  protected final String TEXT_16 = NL + " * \t";
  protected final String TEXT_17 = " <br>";
  protected final String TEXT_18 = NL + " * <br>";
  protected final String TEXT_19 = NL + " *\t@version ";
  protected final String TEXT_20 = NL + " */" + NL + " @SuppressWarnings(\"all\")" + NL + "public interface ";
  protected final String TEXT_21 = " extends ";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = " {" + NL + "\t" + NL + "\t/**" + NL + "\t * The rdf:type for this ontology class" + NL + "     */" + NL + "\tpublic static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(\"";
  protected final String TEXT_25 = "\");" + NL + "\t";
  protected final String TEXT_26 = NL + NL + "\t/**" + NL + "\t * The Anzo Property for ";
  protected final String TEXT_27 = " " + NL + "\t * <p>(URI: ";
  protected final String TEXT_28 = ")</p>" + NL + "\t * <br>";
  protected final String TEXT_29 = NL + "\t * <br>" + NL + "\t * RDF Schema Standard Properties <br>";
  protected final String TEXT_30 = NL + "\t * \t";
  protected final String TEXT_31 = " <br>";
  protected final String TEXT_32 = NL + "\t * <br>";
  protected final String TEXT_33 = NL + "\t * Dublin Core Standard Properties <br>";
  protected final String TEXT_34 = NL + "\t * \t";
  protected final String TEXT_35 = " <br>";
  protected final String TEXT_36 = NL + "\t * <br>";
  protected final String TEXT_37 = "  ";
  protected final String TEXT_38 = NL + "\t * @version ";
  protected final String TEXT_39 = NL + "\t */" + NL + "\tpublic static org.openanzo.rdf.URI ";
  protected final String TEXT_40 = "Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(\"";
  protected final String TEXT_41 = "\");" + NL;
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = NL + NL + "\t/**" + NL + "\t * Individual for URI: ";
  protected final String TEXT_44 = NL + "\t */" + NL + "\tpublic static org.openanzo.rdf.URI ";
  protected final String TEXT_45 = " = org.openanzo.rdf.MemURI.create(\"";
  protected final String TEXT_46 = "\");" + NL;
  protected final String TEXT_47 = NL;
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = NL + "\t/**" + NL + "\t * Gets the '";
  protected final String TEXT_50 = "' property value from the given graph" + NL + "\t * @return\t\t{@link ";
  protected final String TEXT_51 = "}" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_52 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_53 = " get";
  protected final String TEXT_54 = "() throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t" + NL + "\t/**" + NL + "\t * Gets the '";
  protected final String TEXT_55 = "' property value" + NL + "\t * @param \t\tincludeEntireDataset Get the properties from the entire dataset, and not just the namedgraph" + NL + "\t * @return\t\t{@link ";
  protected final String TEXT_56 = "}" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_57 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_58 = " get";
  protected final String TEXT_59 = "(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;" + NL + "" + NL + "\t/**" + NL + "\t * Sets the '";
  protected final String TEXT_60 = "' property value" + NL + "\t * @param\t";
  protected final String TEXT_61 = "\t{@link ";
  protected final String TEXT_62 = "}, the value to set" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_63 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic void set";
  protected final String TEXT_64 = "(";
  protected final String TEXT_65 = " ";
  protected final String TEXT_66 = ") throws org.openanzo.rdf.jastor.JastorException;" + NL;
  protected final String TEXT_67 = NL + "\t/**" + NL + "\t * Iterates through the '";
  protected final String TEXT_68 = "' property values.  This Iteartor" + NL + "\t * may be used to remove all such values." + NL + "\t * @return\t\t{@link java.util.Collection} of {@link ";
  protected final String TEXT_69 = "}" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_70 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic java.util.Collection<";
  protected final String TEXT_71 = "> get";
  protected final String TEXT_72 = "() throws org.openanzo.rdf.jastor.JastorException;" + NL + "" + NL + "\t/**" + NL + "\t * Iterates through the '";
  protected final String TEXT_73 = "' property values.  This Iteartor" + NL + "\t * may be used to remove all such values." + NL + "\t * @param \t\tincludeEntireDataset Get the properties from the entire dataset, and not just the namedgraph" + NL + "\t * @return\t\t{@link java.util.Collection} of {@link ";
  protected final String TEXT_74 = "}" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_75 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic java.util.Collection<";
  protected final String TEXT_76 = "> get";
  protected final String TEXT_77 = "(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t" + NL + "" + NL + "\t/**" + NL + "\t * Add a '";
  protected final String TEXT_78 = "' property value" + NL + "\t * @param\t";
  protected final String TEXT_79 = "\t{@link ";
  protected final String TEXT_80 = "}, the value to add" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_81 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic void add";
  protected final String TEXT_82 = "(";
  protected final String TEXT_83 = " ";
  protected final String TEXT_84 = ") throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t" + NL + "\t/**" + NL + "\t * Remove a '";
  protected final String TEXT_85 = "' property value. This method should not" + NL + "\t * be invoked while iterator through values.  In that case, the remove() method of the Iterator" + NL + "\t * itself should be used." + NL + "\t * @param\t";
  protected final String TEXT_86 = "\t{@link ";
  protected final String TEXT_87 = "}, the value to remove" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_88 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic void remove";
  protected final String TEXT_89 = "(";
  protected final String TEXT_90 = " ";
  protected final String TEXT_91 = ") throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t";
  protected final String TEXT_92 = NL + "\t/**" + NL + "\t * Gets the '";
  protected final String TEXT_93 = "' property value" + NL + "\t * @return\t\t{@link ";
  protected final String TEXT_94 = "}" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_95 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_96 = " get";
  protected final String TEXT_97 = "() throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t" + NL + "\t/**" + NL + "\t * Gets the '";
  protected final String TEXT_98 = "' property value" + NL + "\t * @param \t\tincludeEntireDataset Get the properties from the entire dataset, and not just the namedgraph" + NL + "\t * @return\t\t{@link ";
  protected final String TEXT_99 = "}" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_100 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_101 = " get";
  protected final String TEXT_102 = "(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;" + NL + "" + NL + "\t/**" + NL + "\t * Sets the '";
  protected final String TEXT_103 = "' property value" + NL + "\t * @param\t";
  protected final String TEXT_104 = "\t{@link ";
  protected final String TEXT_105 = "}, value to set" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_106 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic void set";
  protected final String TEXT_107 = "(";
  protected final String TEXT_108 = " ";
  protected final String TEXT_109 = ") throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t" + NL + "\t/**" + NL + "\t * Sets the '";
  protected final String TEXT_110 = "' property value to an anonymous node" + NL + "\t * @return\t\t{@link ";
  protected final String TEXT_111 = "}, the created value" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_112 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */\t" + NL + "\tpublic ";
  protected final String TEXT_113 = " set";
  protected final String TEXT_114 = "() throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t" + NL + "\t/**" + NL + "\t * Sets the '";
  protected final String TEXT_115 = "' property value to the given resource, and add's rdf:type properties.  This" + NL + "\t * method is equivalent constructing a new instance of {@link ";
  protected final String TEXT_116 = "} with the factory." + NL + "\t * and calling set";
  protected final String TEXT_117 = "(";
  protected final String TEXT_118 = " ";
  protected final String TEXT_119 = ")" + NL + "\t * The resource argument have rdf:type ";
  protected final String TEXT_120 = ".  That is, this method" + NL + "\t * should not be used as a shortcut for creating new objects in the model." + NL + "\t * @param\tresource\t{@link org.openanzo.rdf.Resource} must not be be null." + NL + "\t * @return\t\t{@link ";
  protected final String TEXT_121 = "}, the newly created value" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_122 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_123 = " set";
  protected final String TEXT_124 = "(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t";
  protected final String TEXT_125 = NL + "\t/**" + NL + "\t * Get an Iterator the '";
  protected final String TEXT_126 = "' property values.  This Iteartor" + NL + "\t * may be used to remove all such values." + NL + "\t * @return\t\t{@link java.util.Collection} of {@link ";
  protected final String TEXT_127 = "}" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_128 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic java.util.Collection<";
  protected final String TEXT_129 = "> get";
  protected final String TEXT_130 = "() throws org.openanzo.rdf.jastor.JastorException;" + NL + "" + NL + "\t/**" + NL + "\t * Get an Iterator the '";
  protected final String TEXT_131 = "' property values.  This Iteartor" + NL + "\t * may be used to remove all such values." + NL + "\t * @param \t\tincludeEntireDataset Get the properties from the entire dataset, and not just the namedgraph" + NL + "\t * @return\t\t{@link java.util.Collection} of {@link ";
  protected final String TEXT_132 = "}" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_133 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic java.util.Collection<";
  protected final String TEXT_134 = "> get";
  protected final String TEXT_135 = "(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t" + NL + "" + NL + "\t/**" + NL + "\t * Adds a value for the '";
  protected final String TEXT_136 = "' property" + NL + "\t * @param\t";
  protected final String TEXT_137 = "\tThe {@link ";
  protected final String TEXT_138 = "} to add" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_139 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic void add";
  protected final String TEXT_140 = "(";
  protected final String TEXT_141 = " ";
  protected final String TEXT_142 = ") throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t" + NL + "\t/**" + NL + "\t * Adds an anonymous value for the '";
  protected final String TEXT_143 = "' property" + NL + "\t * @return\t\tThe anoymous {@link ";
  protected final String TEXT_144 = "} created" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_145 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_146 = " add";
  protected final String TEXT_147 = "() throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t" + NL + "\t/**" + NL + "\t * Adds a value for the '";
  protected final String TEXT_148 = "' property.  This" + NL + "\t * method is equivalent constructing a new instance of {@link ";
  protected final String TEXT_149 = "} with the factory" + NL + "\t * and calling add";
  protected final String TEXT_150 = "(";
  protected final String TEXT_151 = " ";
  protected final String TEXT_152 = ")" + NL + "\t * The resource argument have rdf:type ";
  protected final String TEXT_153 = ".  That is, this method" + NL + "\t * should not be used as a shortcut for creating new objects in the model." + NL + "\t * @param\tresource\tThe {@link org.openanzo.rdf.Resource} to add" + NL + "\t * @return ";
  protected final String TEXT_154 = ", value added" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_155 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_156 = " add";
  protected final String TEXT_157 = "(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;" + NL + "\t" + NL + "\t/**" + NL + "\t * Removes a value for the '";
  protected final String TEXT_158 = "' property.  This method should not" + NL + "\t * be invoked while iterator through values.  In that case, the remove() method of the Iterator" + NL + "\t * itself should be used." + NL + "\t * @param\t";
  protected final String TEXT_159 = "\tThe {@link ";
  protected final String TEXT_160 = "} to remove" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_161 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic void remove";
  protected final String TEXT_162 = "(";
  protected final String TEXT_163 = " ";
  protected final String TEXT_164 = ") throws org.openanzo.rdf.jastor.JastorException;" + NL;
  protected final String TEXT_165 = NL + "\t\t" + NL + "\t/**" + NL + "\t * Removes a value for the '";
  protected final String TEXT_166 = "' property.  This method should not" + NL + "\t * be invoked while iterator through values.  In that case, the remove() method of the Iterator" + NL + "\t * itself should be used." + NL + "\t * @param\t";
  protected final String TEXT_167 = "\tThe {@link org.openanzo.rdf.Resource} to remove" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_168 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic void remove";
  protected final String TEXT_169 = "(org.openanzo.rdf.Resource ";
  protected final String TEXT_170 = ") throws org.openanzo.rdf.jastor.JastorException;" + NL + NL;
  protected final String TEXT_171 = NL + "/**" + NL + "\t * Clears all values for '";
  protected final String TEXT_172 = "'. " + NL + "\t * @param \t\tincludeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph" + NL + "\t * @see\t\t\t#";
  protected final String TEXT_173 = "Property" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic void clear";
  protected final String TEXT_174 = "(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;";
  protected final String TEXT_175 = NL;
  protected final String TEXT_176 = NL + "}";

	OntologyClassFileProvider fileProvider;

	public InterfaceTemplate(OntologyClassFileProvider fileProvider) {
		this.fileProvider = fileProvider;
	}
	
	public InterfaceTemplate() {
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
    stringBuffer.append(oc.getComment().getLabel());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(oc.getFactoryFullClassname());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ctx.remapUri(oc.getURI()) );
    stringBuffer.append(TEXT_10);
     if (oc.getComment().listRDFSPropertyNames().length > 0) { 
    stringBuffer.append(TEXT_11);
     	String[] names = oc.getComment().listRDFSPropertyNames(); 
     	for (int i=0;i<names.length;i++) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(names[i] + " : " + oc.getComment().getRDFSProperty(names[i]));
    stringBuffer.append(TEXT_13);
     	} 
     } 
    stringBuffer.append(TEXT_14);
     if (oc.getComment().listDCPropertyNames().length > 0) { 
    stringBuffer.append(TEXT_15);
     	String[] names = oc.getComment().listDCPropertyNames(); 
     	for (int i=0;i<names.length;i++) { 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(names[i] + " : " + oc.getComment().getDCProperty(names[i]));
    stringBuffer.append(TEXT_17);
     	} 
     } 
    stringBuffer.append(TEXT_18);
     if (oc.getComment().getVersionInfo() != null) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(oc.getComment().getVersionInfo());
     } 
    stringBuffer.append(TEXT_20);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_21);
     for (OntologyClass extClass: oc.listImmediateExtensionClasses()) { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(extClass.getInterfaceFullClassname());
    stringBuffer.append(TEXT_23);
     } 
    stringBuffer.append(ctx.getThingInterface().getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ctx.remapUri(oc.getURI()));
    stringBuffer.append(TEXT_25);
     for (OntologyProperty prop: oc.listProperties(false)) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ctx.remapUri(prop.getURI()));
    stringBuffer.append(TEXT_28);
     	if (prop.getComment().listRDFSPropertyNames().length > 0) { 
    stringBuffer.append(TEXT_29);
     		String[] names = prop.getComment().listRDFSPropertyNames(); 
     		for (int i=0;i<names.length;i++) { 
    stringBuffer.append(TEXT_30);
    stringBuffer.append(names[i] + " : " + prop.getComment().getRDFSProperty(names[i]));
    stringBuffer.append(TEXT_31);
     		} 
    stringBuffer.append(TEXT_32);
    		} 
     	if (prop.getComment().listDCPropertyNames().length > 0) { 
    stringBuffer.append(TEXT_33);
     		String[] names = prop.getComment().listDCPropertyNames(); 
     		for (int i=0;i<names.length;i++) { 
    stringBuffer.append(TEXT_34);
    stringBuffer.append(names[i] + " : " + prop.getComment().getDCProperty(names[i]));
    stringBuffer.append(TEXT_35);
     		} 
    stringBuffer.append(TEXT_36);
     	} 
    stringBuffer.append(TEXT_37);
    		if (prop.getComment().getVersionInfo() != null) { 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(prop.getComment().getVersionInfo());
    		} 
    stringBuffer.append(TEXT_39);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(ctx.remapUri(prop.getURI()));
    stringBuffer.append(TEXT_41);
     } 
    stringBuffer.append(TEXT_42);
     for (Resource individual: oc.listIndividuals()) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(individual.toString());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(oc.getIndividualIdentifierName(individual));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(individual.toString());
    stringBuffer.append(TEXT_46);
     } 
    stringBuffer.append(TEXT_47);
     if (!ctx.isGenerateVocabularyOnly()) { 
    stringBuffer.append(TEXT_48);
     	for (OntologyProperty prop: oc.listProperties(true)) {
    			if (prop.isSingleValued() && prop.isDatatypeProperty()) { 
    		   	boolean all = (prop.getRole() == OntologyProperty.ROLE_HERE); 
    				for (Resource res: prop.listRanges(all,true)) { 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_66);
              } 
           } 
    			if (prop.isMultiValued() && prop.isDatatypeProperty()) { 
    		   	boolean all = (prop.getRole() == OntologyProperty.ROLE_HERE); 
    				for (Resource res: prop.listRanges(all,true)) { 
    stringBuffer.append(TEXT_67);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_91);
              } 
           } 
    			if (prop.isSingleValued() && prop.isObjectProperty()) { 
    		   	boolean all = (prop.getRole() == OntologyProperty.ROLE_HERE); 
    				for (Resource res: prop.listRanges(all,true)) { 
    stringBuffer.append(TEXT_92);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(ctx.remapUri(prop.getRangeOntologyClass(res).getURI()));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_124);
              } 
           } 
    			if (prop.isMultiValued() && prop.isObjectProperty()) { 
    		   	boolean all = (prop.getRole() == OntologyProperty.ROLE_HERE); 
    				for (Resource res: prop.listRanges(all,true)) { 
    stringBuffer.append(TEXT_125);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(ctx.remapUri(prop.getRangeOntologyClass(res).getURI()));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(prop.getPropertyCapped(res));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(prop.getReturnType(res));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_164);
              } 
    stringBuffer.append(TEXT_165);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_170);
           } 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(prop.getPropertyName());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(prop.getPropertyCapped());
    stringBuffer.append(TEXT_174);
     	} 
    stringBuffer.append(TEXT_175);
     } 
    stringBuffer.append(TEXT_176);
    return stringBuffer.toString();
  }
}