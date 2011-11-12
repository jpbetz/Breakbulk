/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.tests.client.TestData");
dojo.require("anzo.rdf.Statement");

dojo.declare('anzo.tests.client.TestData', null, {
	
	constructor : function() {
		
		this.prefix = "http://test.example.com/test#";
		
		this.subj1  = anzo.createURI(this.prefix + "s1");
        this.subj2  = anzo.createURI(this.prefix + "s2");
        this.subj3  = anzo.createURI(this.prefix + "s3");
        this.subj4  = anzo.createURI(this.prefix + "s4");
        this.subj5  = anzo.createURI(this.prefix + "s5");
        this.subj6  = anzo.createURI(this.prefix + "s6");
        
        this.pred1  = anzo.createURI(this.prefix + "p1");
        this.pred2  = anzo.createURI(this.prefix + "p2");
        this.pred3  = anzo.createURI(this.prefix + "p3");
        this.pred4  = anzo.createURI(this.prefix + "p4");
        this.pred5  = anzo.createURI(this.prefix + "p5");
        this.pred6  = anzo.createURI(this.prefix + "p6");
        
        this.obj1   = anzo.createLiteral("o1");
        this.obj2   = anzo.createLiteral("o2");
        this.obj3   = anzo.createLiteral("o3");
        this.obj4   = anzo.createURI(this.prefix + "o4");
        this.obj5   = anzo.createURI(this.prefix + "o5");
        this.obj6   = anzo.createURI(this.prefix + "o6");
        
        this.graph1 = anzo.createURI(this.prefix + "namedGraph1");
        this.graph2 = anzo.createURI(this.prefix + "namedGraph2");
        this.graph3 = anzo.createURI(this.prefix + "namedGraph3");
        this.graph4 = anzo.createURI(this.prefix + "namedGraph4");
        this.graph5 = anzo.createURI(this.prefix + "namedGraph5");
        this.graph6 = anzo.createURI(this.prefix + "namedGraph6");
        
        this.stmt1  = anzo.createStatement(this.subj1, this.pred1, this.obj1, this.graph1);
        this.stmt2  = anzo.createStatement(this.subj1, this.pred2, this.obj2, this.graph1);
        this.stmt3  = anzo.createStatement(this.subj1, this.pred3, this.obj3, this.graph1);
        this.stmt4  = anzo.createStatement(this.subj1, this.pred3, this.obj4, this.graph1);
        this.stmt5  = anzo.createStatement(this.subj1, this.pred3, this.obj5, this.graph2);
        this.stmt6  = anzo.createStatement(this.subj1, this.pred3, this.obj6, this.graph2);
		
		this.dataset1 = anzo.createURI(this.prefix + "dataset1");
		this.dataset2 = anzo.createURI(this.prefix + "dataset2");
		this.dataset3 = anzo.createURI(this.prefix + "dataset3");
	}
	

});