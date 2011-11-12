/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/rdfs/Rdfs2Owl.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: Rdfs2Owl.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.rdfs;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.owl.OWL11Factory;
import org.openanzo.rdf.owl.Restriction;
import org.openanzo.rdf.vocabulary.OWL;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.rdf.vocabulary.RDFS;

/**
 * Convert an RDFs model to an OWL ontology
 */
public class Rdfs2Owl {

    /**
     * Convert an RDFs model to an OWL ontology
     * 
     * @param rdfsModel
     *            graph containing RDFs model
     * @param ontologyUri
     *            URI of ontology to create
     * @return Graph containing generated ontology data
     */
    public static INamedGraph convertToOwl(INamedGraph rdfsModel, String ontologyUri) {
        // add the ontology
        rdfsModel.add(Constants.valueFactory.createURI(ontologyUri), RDF.TYPE, OWL.ONTOLOGY);
        // find all the rdfs classes and turn them into owl classes
        Iterable<Statement> propertyIter = rdfsModel.find(null, RDF.TYPE, RDFS.Class);
        for (Statement stmt : propertyIter) {
            rdfsModel.remove(stmt.getSubject(), RDF.TYPE, RDFS.Class);
            rdfsModel.add(stmt.getSubject(), RDF.TYPE, OWL.CLASS);
        }

        propertyIter = rdfsModel.find(null, RDF.TYPE, RDFS.Datatype);
        for (Statement stmt : propertyIter) {
            rdfsModel.remove(stmt.getSubject(), RDF.TYPE, RDFS.Datatype);
            rdfsModel.add(stmt.getSubject(), RDF.TYPE, OWL.CLASS);
        }
        // find all the rdfs properties and turn them into owl properties
        // the the necessary restrictions
        propertyIter = rdfsModel.find(null, RDF.TYPE, RDF.Property);
        for (Statement stmt : propertyIter) {
            boolean foundDomain = false;
            Iterable<Statement> domainIter = rdfsModel.find(stmt.getSubject(), RDFS.domain, null);
            for (Statement domain : domainIter) {
                foundDomain = true;
                if (domain.getObject() instanceof Resource) {
                    org.openanzo.rdf.owl.Class oc = OWL11Factory.createClass((Resource) domain.getObject(), rdfsModel);//
                    Resource res = Constants.valueFactory.createBNode();
                    Restriction restriction = OWL11Factory.createRestriction(res, rdfsModel);
                    //  restriction.setOnProperty(stmt.getSubject());
                    oc.addSubClassOf(restriction.resource());
                }

            }
            if (!foundDomain) {
            }
            Iterable<Statement> rangeIter = rdfsModel.find(stmt.getSubject(), RDFS.range, null);
            boolean hasRange = false;
            for (Statement rangeStmt : rangeIter) {
                hasRange = true;
                Value range = rangeStmt.getObject();
                /*
                 * This used to be a test for range.isClass(), but rdfs:Literal is
                 * a class, so instead I just test for either Literal, XMLLiteral
                 * and anything else that might extend it. -Elias
                 */
                if (range instanceof Resource && (range.equals(RDFS.literal) || range.equals(RDF.XMLLiteral) || rdfsModel.contains((Resource) range, RDF.TYPE, RDFS.literal) || rdfsModel.contains((Resource) range, RDF.TYPE, RDF.XMLLiteral))) {
                    rdfsModel.add(stmt.getSubject(), RDF.TYPE, OWL.DATATYPEPROPERTY);
                } else {
                    rdfsModel.add(stmt.getSubject(), RDF.TYPE, OWL.OBJECTPROPERTY);
                }
            }
            if (!hasRange) {
                rdfsModel.add(stmt.getSubject(), RDF.TYPE, OWL.OBJECTPROPERTY);
            }
        }
        return rdfsModel;
    }
}
