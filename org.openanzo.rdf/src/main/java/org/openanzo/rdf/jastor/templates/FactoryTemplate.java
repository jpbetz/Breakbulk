package org.openanzo.rdf.jastor.templates;

import org.openanzo.rdf.jastor.JastorContext;
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
public class FactoryTemplate implements OntologyTemplate {
  protected static String nl;
  public static synchronized FactoryTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    FactoryTemplate result = new FactoryTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * File:        ";
  protected final String TEXT_2 = "Source";
  protected final String TEXT_3 = NL + " * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " * Revision:\t";
  protected final String TEXT_4 = "Id";
  protected final String TEXT_5 = NL + " * " + NL + " * Contributors:" + NL + " *     IBM Corporation - initial API and implementation" + NL + " *\t   Cambridge Semantics Incorporated - Fork to Anzo" + NL + " *******************************************************************************/";
  protected final String TEXT_6 = NL + NL + "package ";
  protected final String TEXT_7 = ";" + NL + "" + NL + "/**" + NL + " * Factory for instantiating objects for ontology classes in the ";
  protected final String TEXT_8 = " ontology.  The" + NL + " * get methods leave the dataset unchanged and return a Java view of the object in the dataset.  The create methods" + NL + " * may add certain baseline properties to the dataset such as rdf:type and any properties with hasValue restrictions." + NL + " * <p>(URI: ";
  protected final String TEXT_9 = ")</p>" + NL + " * <br>";
  protected final String TEXT_10 = NL + " * RDF Schema Standard Properties <br>";
  protected final String TEXT_11 = NL + " * \t";
  protected final String TEXT_12 = " <br>";
  protected final String TEXT_13 = NL + " * <br>";
  protected final String TEXT_14 = NL + " * Dublin Core Standard Properties <br>";
  protected final String TEXT_15 = NL + " * \t";
  protected final String TEXT_16 = " <br>";
  protected final String TEXT_17 = NL + " * <br>";
  protected final String TEXT_18 = NL + " *\t@version ";
  protected final String TEXT_19 = NL + " */" + NL + "public class ";
  protected final String TEXT_20 = " extends ";
  protected final String TEXT_21 = " { " + NL + NL;
  protected final String TEXT_22 = NL + "\t/**" + NL + "\t *Determine if the given predicate is one of the properties for the given class " + NL + "\t *@param predicate predicate to check" + NL + "\t *@return true if the given predicate is one of the properties for the given class" + NL + "\t */" + NL + "\tpublic static boolean is";
  protected final String TEXT_23 = "Predicate(org.openanzo.rdf.URI predicate){" + NL + "\t\treturn ";
  protected final String TEXT_24 = NL + "\t\t\tpredicate.equals(";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = "Property) ";
  protected final String TEXT_27 = "||";
  protected final String TEXT_28 = ";" + NL + "\t}";
  protected final String TEXT_29 = NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_30 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param resource The resource of the ";
  protected final String TEXT_31 = NL + "\t * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created" + NL + "\t * @param dataset the IDataset containing the data" + NL + "\t * @return the newly created ";
  protected final String TEXT_32 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_33 = " create";
  protected final String TEXT_34 = "(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\t";
  protected final String TEXT_35 = " result= ";
  protected final String TEXT_36 = ".create";
  protected final String TEXT_37 = "(resource,_namedGraphUri,dataset);" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\tString code = (dataset.hashCode()*17 + ";
  protected final String TEXT_39 = ".class.hashCode()+((_namedGraphUri!=null)?_namedGraphUri.hashCode():0)) + resource.toString();" + NL + "\t\tobjects.put(code, result);\t\t\t" + NL + "\t\t";
  protected final String TEXT_40 = NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_41 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param resource The resource of the ";
  protected final String TEXT_42 = NL + "\t * @param dataset the IDataset containing the data" + NL + "\t * @return the newly created ";
  protected final String TEXT_43 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_44 = " create";
  protected final String TEXT_45 = "(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\treturn create";
  protected final String TEXT_46 = "(resource, resource, dataset);" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_47 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param uri The uri of the ";
  protected final String TEXT_48 = NL + "\t * @param dataset the IDataset containing the data" + NL + "\t * @return the newly created ";
  protected final String TEXT_49 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_50 = " create";
  protected final String TEXT_51 = "(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);" + NL + "\t\treturn create";
  protected final String TEXT_52 = "(resource, resource, dataset);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_53 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param uri The uri of the ";
  protected final String TEXT_54 = NL + "\t * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created" + NL + "\t * @param dataset the IDataset containing the data" + NL + "\t * @return the newly created ";
  protected final String TEXT_55 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_56 = " create";
  protected final String TEXT_57 = "(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);" + NL + "\t\treturn create";
  protected final String TEXT_58 = "(resource, _namedGraphUri, dataset);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_59 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param resource The resource of the ";
  protected final String TEXT_60 = NL + "\t * @param graph the NamedGraph within the dataset where this object is to be created" + NL + "\t * @return the newly created ";
  protected final String TEXT_61 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_62 = " create";
  protected final String TEXT_63 = "(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);" + NL + "\t\treturn create";
  protected final String TEXT_64 = "(resource, graph.getNamedGraphUri(), dataset);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_65 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param uri The uri of the ";
  protected final String TEXT_66 = NL + "\t * @param graph the NamedGraph within the dataset where this object is to be created" + NL + "\t * @return the newly created ";
  protected final String TEXT_67 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_68 = " create";
  protected final String TEXT_69 = "(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);" + NL + "\t\treturn create";
  protected final String TEXT_70 = "(resource, graph);" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_71 = ".  Leaves the dataset unchanged." + NL + "\t * @param resource The resource of the ";
  protected final String TEXT_72 = NL + "\t * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created" + NL + "\t * @param dataset the IDataset containing the data" + NL + "\t * @return the newly created ";
  protected final String TEXT_73 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_74 = " get";
  protected final String TEXT_75 = "(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {";
  protected final String TEXT_76 = NL + "\t\tString code = (dataset.hashCode()*17 + ";
  protected final String TEXT_77 = ".class.hashCode()+((_namedGraphUri!=null)?_namedGraphUri.hashCode():0)) + resource.toString();" + NL + "\t\t";
  protected final String TEXT_78 = " obj = (";
  protected final String TEXT_79 = ")objects.get(code);" + NL + "\t\tif (obj == null) {" + NL + "\t\t\tobj = ";
  protected final String TEXT_80 = ".get";
  protected final String TEXT_81 = "(resource,_namedGraphUri, dataset);" + NL + "\t\t\tif (obj == null)" + NL + "\t\t\t\treturn null;" + NL + "\t\t\tobjects.put(code, obj);" + NL + "\t\t}" + NL + "\t\treturn obj;";
  protected final String TEXT_82 = NL + "\t\treturn ";
  protected final String TEXT_83 = ".get";
  protected final String TEXT_84 = "(resource, _namedGraphUri,dataset);";
  protected final String TEXT_85 = NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_86 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param resource The resource of the ";
  protected final String TEXT_87 = NL + "\t * @param dataset the IDataset containing the data" + NL + "\t * @return the newly created ";
  protected final String TEXT_88 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_89 = " get";
  protected final String TEXT_90 = "(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\treturn get";
  protected final String TEXT_91 = "(resource, resource, dataset);" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_92 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param uri The uri of the ";
  protected final String TEXT_93 = NL + "\t * @param dataset the IDataset containing the data" + NL + "\t * @return the newly created ";
  protected final String TEXT_94 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_95 = " get";
  protected final String TEXT_96 = "(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);" + NL + "\t\treturn get";
  protected final String TEXT_97 = "(resource, resource, dataset);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_98 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param uri The uri of the ";
  protected final String TEXT_99 = NL + "\t * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created" + NL + "\t * @param dataset the IDataset containing the data" + NL + "\t * @return the newly created ";
  protected final String TEXT_100 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_101 = " get";
  protected final String TEXT_102 = "(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);" + NL + "\t\treturn get";
  protected final String TEXT_103 = "(resource, _namedGraphUri, dataset);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_104 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param resource The resource of the ";
  protected final String TEXT_105 = NL + "\t * @param graph  the NamedGraph within the dataset where this object is to be created" + NL + "\t * @return the newly created ";
  protected final String TEXT_106 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_107 = " get";
  protected final String TEXT_108 = "(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);" + NL + "\t\treturn get";
  protected final String TEXT_109 = "(resource, graph.getNamedGraphUri(), dataset);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Create a new instance of ";
  protected final String TEXT_110 = ".  Adds the rdf:type property for the given resource to the dataset." + NL + "\t * @param uri The uri of the ";
  protected final String TEXT_111 = NL + "\t * @param graph the NamedGraph within the dataset where this object is to be created" + NL + "\t * @return the newly created ";
  protected final String TEXT_112 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_113 = " get";
  protected final String TEXT_114 = "(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);" + NL + "\t\treturn get";
  protected final String TEXT_115 = "(resource, graph);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Return an instance of ";
  protected final String TEXT_116 = " for every resource in the dataset with rdf:Type ";
  protected final String TEXT_117 = NL + "\t * @param _namedGraphUri the URI of the NamedGraph" + NL + "\t * @param dataset the IDataset containing the data" + NL + "\t * @return a List of ";
  protected final String TEXT_118 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static java.util.List<";
  protected final String TEXT_119 = "> getAll";
  protected final String TEXT_120 = "(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\tjava.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,";
  protected final String TEXT_121 = ".TYPE,_namedGraphUri);" + NL + "\t\tjava.util.List<";
  protected final String TEXT_122 = "> list = new java.util.ArrayList<";
  protected final String TEXT_123 = ">();" + NL + "\t\tfor(org.openanzo.rdf.Statement stmt :result){" + NL + "\t\t\torg.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();" + NL + "\t\t\tlist.add(get";
  protected final String TEXT_124 = "(stmt.getSubject(),nguri,dataset));" + NL + "\t\t}" + NL + "\t\treturn list;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Return an instance of ";
  protected final String TEXT_125 = " for every resource in the dataset with rdf:Type ";
  protected final String TEXT_126 = NL + "\t * @param dataset the IDataset containing the data" + NL + "\t * @return a List of ";
  protected final String TEXT_127 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static java.util.List<";
  protected final String TEXT_128 = "> getAll";
  protected final String TEXT_129 = "(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\treturn getAll";
  protected final String TEXT_130 = "(null, dataset);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Return an instance of ";
  protected final String TEXT_131 = " for every resource in the dataset with rdf:Type ";
  protected final String TEXT_132 = NL + "\t * @param graph the NamedGraph containing the data" + NL + "\t * @return a List of ";
  protected final String TEXT_133 = NL + "\t * @throws org.openanzo.rdf.jastor.JastorException" + NL + "\t */" + NL + "\tpublic static java.util.List<";
  protected final String TEXT_134 = "> getAll";
  protected final String TEXT_135 = "(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);" + NL + "\t\treturn getAll";
  protected final String TEXT_136 = "(graph.getNamedGraphUri(), dataset);" + NL + "\t}" + NL + NL;
  protected final String TEXT_137 = NL + NL + "\t/**" + NL + "\t * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to " + NL + "\t * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior" + NL + "\t * is unspecified for resources with RDF types from different hierarchies." + NL + "\t * @return an instance of Thing" + NL + "\t * @throws org.openanzo.rdf.jastor.JastorException " + NL + "\t */" + NL + "\tpublic static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {";
  protected final String TEXT_138 = NL + "\t\tif (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create(\"";
  protected final String TEXT_139 = "\"), namedGraphUri)) {" + NL + "\t\t\treturn get";
  protected final String TEXT_140 = "(resource, namedGraphUri, dataset);" + NL + "\t\t}";
  protected final String TEXT_141 = NL + "\t\treturn new org.openanzo.rdf.jastor.ThingImpl(resource, namedGraphUri, dataset);" + NL + "\t}" + NL + "\t/*" + NL + "\tpublic static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\treturn getThing(resource, resource, dataset);" + NL + "\t}" + NL + "\t" + NL + "\tpublic static org.openanzo.rdf.jastor.Thing getThing(String uri, org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);" + NL + "\t\treturn getThing(resource, namedGraphUri, dataset);" + NL + "\t}" + NL + "\t" + NL + "\tpublic static org.openanzo.rdf.jastor.Thing getThing(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);" + NL + "\t\treturn getThing(resource, dataset);" + NL + "\t}" + NL + "\t" + NL + "\tpublic static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);" + NL + "\t\treturn getThing(resource, graph.getNamedGraphUri(), dataset);" + NL + "\t}" + NL + "\t" + NL + "\tpublic static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.URI resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);" + NL + "\t\treturn getThing(resource, graph.getNamedGraphUri(), dataset);" + NL + "\t}" + NL + "\t" + NL + "\tpublic static org.openanzo.rdf.jastor.Thing getThing(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {" + NL + "\t\torg.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);" + NL + "\t\treturn getThing(resource, graph);" + NL + "\t}" + NL + "\t*/" + NL + "\t/**" + NL + "\t * Return a list of compatible interfaces for the given type.  Searches through all ontology classes" + NL + "\t * in the ";
  protected final String TEXT_142 = " ontology." + NL + "\t * @param type the type for which to find compatible interfaces" + NL + "\t * @return a List of type java.lang.Class" + NL + "\t */" + NL + "\tpublic static java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> listCompatibleInterfaces (org.openanzo.rdf.Resource type) {" + NL + "\t\tjava.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> types = new java.util.ArrayList<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>>();";
  protected final String TEXT_143 = NL + "\t\tif (type.equals(";
  protected final String TEXT_144 = ".TYPE)) {" + NL + "\t\t\ttypes.add(";
  protected final String TEXT_145 = ".class);" + NL + "\t\t}";
  protected final String TEXT_146 = NL + "\t\treturn types;" + NL + "\t}" + NL + "}";

	OntologyFileProvider fileProvider;

	public FactoryTemplate(OntologyFileProvider fileProvider) {
		this.fileProvider = fileProvider;
	}
	
	public FactoryTemplate() {
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
    stringBuffer.append(pkg.getLocalName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ctx.remapUri(pkg.getURI()) );
    stringBuffer.append(TEXT_9);
     if (pkg.getComment().listRDFSPropertyNames().length > 0) { 
    stringBuffer.append(TEXT_10);
     	String[] names = pkg.getComment().listRDFSPropertyNames(); 
     	for (int i=0;i<names.length;i++) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(names[i] + " : " + pkg.getComment().getRDFSProperty(names[i]));
    stringBuffer.append(TEXT_12);
     	} 
     } 
    stringBuffer.append(TEXT_13);
     if (pkg.getComment().listDCPropertyNames().length > 0) { 
    stringBuffer.append(TEXT_14);
     	String[] names = pkg.getComment().listDCPropertyNames(); 
     	for (int i=0;i<names.length;i++) { 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(names[i] + " : " + pkg.getComment().getDCProperty(names[i]));
    stringBuffer.append(TEXT_16);
     	} 
     } 
    stringBuffer.append(TEXT_17);
     if (pkg.getComment().getVersionInfo() != null) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(pkg.getComment().getVersionInfo());
     } 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(pkg.getFactoryClassname());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ctx.getThingFactory().getName());
    stringBuffer.append(TEXT_21);
     for(OntologyClass oc : pkg.getClasses()) {
    if(oc.listProperties(true).size()>0){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_23);
     for (java.util.Iterator<OntologyProperty> iter= oc.listProperties(true).iterator();iter.hasNext();) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(oc.getImplClassname());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(iter.next().getPropertyName());
    stringBuffer.append(TEXT_26);
    if (iter.hasNext()){
    stringBuffer.append(TEXT_27);
    }
     } 
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_37);
     if (ctx.isGenerateCacheInFactory()) { 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_39);
     } 
    stringBuffer.append(TEXT_40);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_75);
     	if (ctx.isGenerateCacheInFactory()) { 
    stringBuffer.append(TEXT_76);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_81);
     	} else { 
    stringBuffer.append(TEXT_82);
    stringBuffer.append(oc.getImplFullClassname());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_84);
     	} 
    stringBuffer.append(TEXT_85);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(ctx.remapUri(oc.getURI()));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(ctx.remapUri(oc.getURI()));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(ctx.remapUri(oc.getURI()));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_136);
     } 
    stringBuffer.append(TEXT_137);
     for(org.openanzo.rdf.jastor.inference.OntologyClass oc:ont.getClassesSorted()) {
    stringBuffer.append(TEXT_138);
    stringBuffer.append(oc.getURI());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(oc.getInterfaceClassname());
    stringBuffer.append(TEXT_140);
     } 
    stringBuffer.append(TEXT_141);
    stringBuffer.append(pkg.getLocalName());
    stringBuffer.append(TEXT_142);
     for(OntologyClass oc: pkg.getClasses()) {
    stringBuffer.append(TEXT_143);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(oc.getInterfaceFullClassname());
    stringBuffer.append(TEXT_145);
     } 
    stringBuffer.append(TEXT_146);
    return stringBuffer.toString();
  }
}