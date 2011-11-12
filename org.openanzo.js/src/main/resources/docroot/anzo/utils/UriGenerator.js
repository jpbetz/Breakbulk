/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.utils.UriGenerator");

dojo.require("anzo.client.Vocabulary");
dojo.require("anzo.utils.JSUtil");

anzo.utils.UriGenerator = {
    
    
    generateUri : function(/*String*/ prefix) {
		return anzo.createURI(prefix + anzo.utils.newGuid());
	},
	
    generateEventUri : function(/*String*/ name) {
        return anzo.createURI(anzo.client.Vocabulary.EVENT_PREFIX + name);
    },
    
    generateTrackerUri : function() {
        return this.generateUri(anzo.client.Vocabulary.TRACKER_PREFIX);
    },
    
    generateStandardUri : function(/*String*/ name) {
		return anzo.createURI(anzo.client.Vocabulary.PREFIX + "/"+name);
	},
	
	getMetadataGraphUri : function(namedGraphUri) {
	    // summary: Given an named graph uri, this method generates the corresponding metadata graph uri.
	    if(!(namedGraphUri instanceof anzo.rdf.URI))
	        throw Error('The given named graph uri is not a valid anzo.rdf.URI');
	    return anzo.createURI(anzo.client.Vocabulary.METADATAGRAPH_PREFIX + '(' + window.encodeURIComponent(namedGraphUri) + ')');
	},
	
	isMetadataGraphUri : function(graphUri) {
		// summary: Returns true if the given uri is a metadata graph uri, false otherwise.
		return (graphUri.toString().indexOf(anzo.client.Vocabulary.METADATAGRAPH_PREFIX.toString()) == 0);
	},
	
	getDatasourceQueue : function(datasourceUri, serviceType) {
		if(!(datasourceUri instanceof anzo.rdf.URI))
	        throw Error('The given datasource uri is not a valid anzo.rdf.URI');
	    return 'services/(' + window.encodeURIComponent(datasourceUri) + ')/' + serviceType;
	},
	
	getTopicString : function(prefix, uri) {
		return prefix + '(' + window.encodeURIComponent(uri) + ')'
	},

	getUriFromTopicString : function(prefix, topic) {
		if (topic.toString().indexOf(prefix) == 0) {
            var namedGraphUri = topic.toString().substring(prefix.length);
            if (namedGraphUri.indexOf("(") == 0 && namedGraphUri.lastIndexOf(")") == namedGraphUri.length-1) {
                namedGraphUri = namedGraphUri.substring(1, namedGraphUri.length - 1);
            }
            var namedGraphUri =  window.decodeURIComponent(namedGraphUri);
            return namedGraphUri;
        } else {
        	return null;
        }
	},
	
	getNamedGraphUri : function(metadataGraphUri) {
	    return anzo.utils.UriGenerator.getUriFromTopicString(anzo.client.Vocabulary.METADATAGRAPH_PREFIX.toString(), metadataGraphUri);
	},
	
	generateNamedGraphUri : function(/*String*/ name) {
	    if(name == null)
	       name = anzo.utils.newGuid();
	    return anzo.createURI(anzo.client.Vocabulary.NAMEDGRAPH_PREFIX + "/" +name);
	},
	
	generateAclUri : function(/*String*/ name) {
	     if(name == null)
	       name = anzo.utils.newGuid();
	     return anzo.createURI(anzo.client.Vocabulary.ACL_PREFIX + "/" +name);
	},
	
	generateRoleUri : function(/*String*/ name) {
	     if(name == null)
	       name = anzo.utils.newGuid();
	     return anzo.createURI(anzo.client.Vocabulary.ROLE_PREFIX + "/" +name);
	}
    
}

