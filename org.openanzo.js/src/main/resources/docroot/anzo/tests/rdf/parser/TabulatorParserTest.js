/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 * Created on:  Oct 10, 2007
 * Revision:
 $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */

dojo.provide("anzo.tests.rdf.parser.TabulatorParserTest");

dojo.require("anzo.rdf.NamedGraph");
dojo.require("anzo.rdf.parser.TabulatorParser");
dojo.require("anzo.tests.utilities");

tests.register("anzo.tests.rdf.parser.TabulatorParserTest", 
	[
		
			function test_XML_RDF_Parsing1() {
			    if (anzo.tests.utilities.skipTestInRhino("DOMParser does not exist in Rhino")) {
			        return;
			    }
			    
				var graph = new anzo.rdf.NamedGraph();
				var string = "<rdf:RDF xmlns='urn:lsid:telar.cambridgesemantics.com:cvit#'    xmlns:base='urn:lsid:lsid.cambridgesemantics.com:predicates:'    xmlns:cvit='urn:lsid:telar.cambridgesemantics.com:cvit#'    xmlns:dc='http://purl.org/dc/elements/1.1/'    xmlns:foaf='http://xmlns.com/foaf/0.1/'    xmlns:log='http://www.w3.org/2000/10/swap/log#'    xmlns:owl='http://www.w3.org/2002/07/owl#'    xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#'    xmlns:rdfs='http://www.w3.org/2000/01/rdf-schema#'    xmlns:xsd='http://www.w3.org/2001/XMLSchema#'>    <owl:Ontology rdf:about='urn:lsid:telar.cambridgesemantics.com:cvit#CViT'>        <rdfs:comment>CViT Ontology</rdfs:comment>        <owl:imports rdf:resource='http://purl.org/dc/elements/1.1/'/>        <owl:imports rdf:resource='http://xmlns.com/foaf/0.1/'/>        <owl:versionInfo>0.1</owl:versionInfo>    </owl:Ontology>    <owl:Class rdf:about='urn:lsid:telar.cambridgesemantics.com:cvit#Entry'>        <dc:title rdf:datatype='http://www.w3.org/2001/XMLSchema#string'>Entry</dc:title>    </owl:Class>    <owl:Class rdf:about='urn:lsid:telar.cambridgesemantics.com:cvit#ExternalLink'>        <dc:title rdf:datatype='http://www.w3.org/2001/XMLSchema#string'>External Link</dc:title>    </owl:Class>    <owl:Class rdf:about='urn:lsid:telar.cambridgesemantics.com:cvit#File'>        <dc:title rdf:datatype='http://www.w3.org/2001/XMLSchema#string'>File</dc:title>    </owl:Class>    <owl:Class rdf:about='urn:lsid:telar.cambridgesemantics.com:cvit#FundingSource'>        <dc:title rdf:datatype='http://www.w3.org/2001/XMLSchema#string'>Funding Source</dc:title>        <rdfs:subClassOf rdf:resource='urn:lsid:telar.cambridgesemantics.com:cvit#Organization'/>    </owl:Class>    <owl:Class rdf:about='urn:lsid:telar.cambridgesemantics.com:cvit#Organization'>        <dc:title rdf:datatype='http://www.w3.org/2001/XMLSchema#string'>Organization</dc:title>    </owl:Class>    <owl:Class rdf:about='urn:lsid:telar.cambridgesemantics.com:cvit#Person'>        <dc:title rdf:datatype='http://www.w3.org/2001/XMLSchema#string'>Person</dc:title>    </owl:Class>    <owl:Class rdf:about='urn:lsid:telar.cambridgesemantics.com:cvit#TaskList'>        <dc:title rdf:datatype='http://www.w3.org/2001/XMLSchema#string'>Task List</dc:title>    </owl:Class></rdf:RDF>";
				anzo.rdf.parser.TabulatorParser.parse(string, graph);
				
				tests.assertTrue(graph.find('urn:lsid:telar.cambridgesemantics.com:cvit#TaskList', 'http://purl.org/dc/elements/1.1/title')[0].object.toString() == 'Task List');
			},
			
			function test_XML_RDF_Parsing2() {
			    if (anzo.tests.utilities.skipTestInRhino("DOMParser does not exist in Rhino")) {
			        return;
			    }
			    
				var graph = new anzo.rdf.NamedGraph();
				var string = '<rdf:RDF    xmlns:j.0="http://openanzo.org/ontologies/2008/07/Anzo#"    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"    xmlns:j.1="http://openanzo.org/ontologies/2008/07/Anzo#"    xmlns:j.2="http://openanzo.org/ontologies/2008/07/Anzo#" >   <rdf:Description rdf:about="http://openanzo.org/ACL/SystemAcl">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#ACL"/>    <j.2:read rdf:resource="http://openanzo.org/Role/sysAdmin"/>    <j.2:add rdf:resource="http://openanzo.org/Role/sysAdmin"/>    <j.2:remove rdf:resource="http://openanzo.org/Role/sysAdmin"/>    <j.2:insertNamedGraph rdf:resource="http://openanzo.org/Role/sysAdmin"/>    <j.2:removeNamedGraph rdf:resource="http://openanzo.org/Role/sysAdmin"/>    <j.2:changeNamedGraphACL rdf:resource="http://openanzo.org/Role/sysAdmin"/>    <j.2:insertNamedGraph rdf:resource="http://openanzo.org/Role/default"/>    <j.2:removeNamedGraph rdf:resource="http://openanzo.org/Role/default"/>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/namedGraphs/defaultSystemGraph">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"/>    <j.0:usesAcl rdf:resource="http://openanzo.org/ACL/SystemAcl"/>    <j.0:hasMetadataGraph rdf:resource="http://openanzo.org/metadataGraphs/defaultSystemMetadataGraph"/>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/Role/webuser">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#Role"/>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/users/webauthor1">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#User"/>    <j.0:userId>webauthor1</j.0:userId>    <j.0:password>webauthor1</j.0:password>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/namedGraphs/defaultNamedGraph">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"/>    <j.0:usesAcl rdf:resource="http://openanzo.org/ACL/1"/>    <j.0:hasMetadataGraph rdf:resource="http://openanzo.org/metadataGraphs/defaultMetadataGraph"/>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/users/webuser">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#User"/>    <j.0:userId>webuser</j.0:userId>    <j.0:password>webuser</j.0:password>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/Role/sysAdmin">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#Role"/>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/ACL/1">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#ACL"/>    <j.2:read rdf:resource="http://openanzo.org/Role/default"/>    <j.2:add rdf:resource="http://openanzo.org/Role/default"/>    <j.2:remove rdf:resource="http://openanzo.org/Role/default"/>    <j.2:insertNamedGraph rdf:resource="http://openanzo.org/Role/default"/>    <j.2:removeNamedGraph rdf:resource="http://openanzo.org/Role/default"/>    <j.2:changeNamedGraphACL rdf:resource="http://openanzo.org/Role/default"/>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/users/sysadmin">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#User"/>    <j.0:userId>sysadmin</j.0:userId>    <j.0:password>123</j.0:password>    <j.0:defaultRole rdf:resource="http://openanzo.org/Role/default"/>    <j.2:inRole rdf:resource="http://openanzo.org/Role/sysAdmin"/>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/Role/default">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#Role"/>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/users/default">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#User"/>    <j.0:userId>default</j.0:userId>    <j.0:password>123</j.0:password>    <j.0:defaultRole rdf:resource="http://openanzo.org/Role/default"/>  </rdf:Description>  <rdf:Description rdf:about="http://openanzo.org/Role/webauthors">    <rdf:type rdf:resource="http://openanzo.org/ontologies/2008/07/Anzo#Role"/>  </rdf:Description></rdf:RDF>';
				anzo.rdf.parser.TabulatorParser.parse(string, graph);
				
				tests.assertTrue(graph.contains("http://openanzo.org/namedGraphs/defaultNamedGraph", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"));
				tests.assertTrue(graph.contains("http://openanzo.org/users/webauthor1", "http://openanzo.org/ontologies/2008/07/Anzo#userId", "webauthor1"));
				tests.assertTrue(graph.contains("http://openanzo.org/users/sysadmin", "http://openanzo.org/ontologies/2008/07/Anzo#inRole", "http://openanzo.org/Role/sysAdmin"));
			}
	]
);







