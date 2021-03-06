/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Revision:	$Id$
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *	   Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.ontologies.execution;

/**
 * Implementation of {@link org.openanzo.ontologies.execution.StateStyleEnum}
 * Use the org.openanzo.ontologies.execution.SemanticServiceFactory to create instances of this class.
 * <p>(URI: http://jastor.openanzo.org/gen#StateStyleEnum)</p>
 * <br>
 */
public class StateStyleEnumImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.execution.StateStyleEnum {
	private ThingStatementListener _listener = null;


	StateStyleEnumImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	
	private static java.util.Set<org.openanzo.rdf.Resource> oneOfClasses = new java.util.HashSet<org.openanzo.rdf.Resource>();
	static {
		oneOfClasses.add(StatelessStyle);
		oneOfClasses.add(ConnectionStyle);
		oneOfClasses.add(LongRunningStyle);
	}   
    	
	static StateStyleEnumImpl getStateStyleEnum(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, StateStyleEnum.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new StateStyleEnumImpl(resource, namedGraphUri, dataset);
	}
	    
	static StateStyleEnumImpl createStateStyleEnum(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if (!oneOfClasses.contains(resource)) {
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not a member of enumeration class http://jastor.openanzo.org/gen#StateStyleEnum"); 
		} 
		
		StateStyleEnumImpl impl = new StateStyleEnumImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, StateStyleEnum.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, StateStyleEnum.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.execution.StateStyleEnum.TYPE, _graph.getNamedGraphUri()));
		return list;
	}
 


	protected java.util.concurrent.CopyOnWriteArraySet<StateStyleEnumListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<StateStyleEnumListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof StateStyleEnumListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	StateStyleEnumListener list = (StateStyleEnumListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof StateStyleEnumListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		StateStyleEnumListener list = (StateStyleEnumListener)listener;
		if(listeners.contains(list)){
			listeners.remove(list);
		}
		if(listeners.size()==0){	
    		_dataset.unregisterListener(_listener);
    	}
	}
	



	protected class ThingStatementListener implements org.openanzo.rdf.IStatementListener<org.openanzo.rdf.IDataset> {
	
		public void statementsAdded(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
		}
		}}
	}
	


}