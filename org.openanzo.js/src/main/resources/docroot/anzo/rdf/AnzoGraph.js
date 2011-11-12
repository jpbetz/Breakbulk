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
 
dojo.provide("anzo.rdf.AnzoGraph");
dojo.require("anzo.rdf.NamedGraph");
dojo.require("anzo.rdf.QuadStore");
dojo.require("anzo.rdf.INamedGraph");
dojo.require('anzo.rdf.Statement');

dojo.declare('anzo.rdf.AnzoGraph', anzo.rdf.NamedGraph, {
    
    constructor : function(namedGraphUri, store, metadataGraph) {
        anzo.rdf.AnzoGraph.superclass.constructor.call(this, namedGraphUri, store);
    	this.metadataGraph   = metadataGraph;
    }

});