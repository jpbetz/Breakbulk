<?xml version="1.0" encoding="UTF-8"?>
    <!--
        #******************************************************************************* 
        # Copyright (c) 2009 Cambridge Semantics Incorporated. 
        # All rights reserved. This program and the accompanying materials 
        # are made available under the terms of the Eclipse Public License v1.0 
        # which accompanies this distribution, and is available at 
        # http://www.eclipse.org/legal/epl-v10.html 
        # 
        # Created by: Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>) 
        # 
        # Contributors: 
        # Cambridge Semantics
        #    Incorporated - Fork to Anzo 
        #*******************************************************************************
    -->
<preparedstatements>
    <preparedstatement name="selectDistinctRevisionedUUIDs" outputs="Long uuid" results="ITERATOR">
        SELECT DISTINCT UUID FROM NAMEDGRAPHS;
    </preparedstatement>
    
    <preparedstatement name="selectRevisionedGraphUUIDs" inputs="+Long graphId" outputs="Long uuid" results="ITERATOR">
        SELECT DISTINCT UUID FROM NAMEDGRAPHS WHERE ID=?;
    </preparedstatement>
   
    <preparedstatement name="selectDistinctNonRevisionedUUIDs" outputs="Long uuid" results="ITERATOR">
        SELECT DISTINCT UUID FROM NAMEDGRAPHS_NR;
    </preparedstatement>
   
   <preparedstatement name="selectNonRevisionedGraphUUIDs" inputs="+Long graphId" outputs="Long uuid" results="ITERATOR">
        SELECT DISTINCT UUID FROM NAMEDGRAPHS_NR WHERE ID=?;
    </preparedstatement>
    
    <preparedstatement name="selectNamedGraphsRevisioned" inputs="+Long uuid" outputs="+Long id,+Long metaId,+Long revision,+Long hstart,+Long hend,+Long lastModifiedBy" results="ITERATOR">
        SELECT ID,METAID,REVISION,HSTART,HEND,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE UUID=? ORDER BY REVISION ;
	</preparedstatement>

    <preparedstatement name="purgeNamedGraphRevisioned" inputs="+Long ngId"  results="COUNTER">
        DELETE FROM NAMEDGRAPHS WHERE ID=?
    </preparedstatement>
    
    <preparedstatement name="purgeNamedGraphNonRevisioned" inputs="+Long ngId"  results="COUNTER">
        DELETE FROM NAMEDGRAPHS_NR WHERE ID=?
    </preparedstatement>

    <preparedstatement name="purgeNamedGraphStatementsRevisioned" inputs="+Long ngId,+Long metaId"  results="COUNTER">
        DELETE FROM STATEMENTS WHERE (NAMEDGRAPHID=? OR NAMEDGRAPHID=?)
    </preparedstatement>
   
   <preparedstatement name="purgeNamedGraphStatementsNonRevisioned" inputs="+Long ngId,+Long metaId"  results="COUNTER">
        DELETE FROM STATEMENTS_NR WHERE (NAMEDGRAPHID=? OR NAMEDGRAPHID=?)
    </preparedstatement>
   
    <preparedstatement name="selectStatementsRevisioned" inputs="+Long uuid,+Long ngId" outputs="+Long subject,+Long predicate,+Long object,+Long start,+Long end" results="ITERATOR">
        SELECT SUBJECT,PREDICATE,OBJECT,RSTART,REND FROM STATEMENTS WHERE UUID=? AND NAMEDGRAPHID=? ORDER BY (RSTART);
    </preparedstatement>

    <preparedstatement name="selectNamedGraphsNonRevisioned" inputs="+Long uuid" outputs="+Long id,+Long metaId,+Long revision,+Long hstart,+Long lastModifiedBy" results="ITERATOR">
        SELECT ID,METAID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS_NR WHERE UUID=? ORDER BY REVISION;
	</preparedstatement>

    <preparedstatement name="selectStatementsNonRevisioned" inputs="+Long graphId" outputs="+Long subject,+Long predicate,+Long object" results="ITERATOR">
        SELECT SUBJECT,PREDICATE,OBJECT FROM STATEMENTS_NR WHERE NAMEDGRAPHID=?;
    </preparedstatement>

    <preparedstatement name="restoreNamedGraph" results="COUNTER"  inputs="+Long start,Long end, +Long namedgraphid,+Long metadataId,+Long uuid, +Long revision,+Long lastModifiedBy">
        INSERT INTO NAMEDGRAPHS (HSTART,HEND, ID, METAID,UUID,REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?,?, ?, ?,?, ?,?,0);
    </preparedstatement>
    
    <preparedstatement name="restoreNamedGraphNR" results="COUNTER"  inputs="+Long modified, +Long namedgraphid,+Long metadataId,+Long uuid,  +Long revision,+Long lastModifiedBy">
        INSERT INTO NAMEDGRAPHS_NR (HSTART, ID, METAID,UUID, REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?, ?,?,?,?,?,0);
    </preparedstatement>
    
    <preparedstatement name="restoreStatement" results="COUNTER"  inputs="+String id,+Integer metadata,+Long uuid,+Long namedGraphId,+Long subject,+Long predicate,+Long object,+Long rstart,Long rend">
        INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,RSTART,REND,COMMITTED) VALUES (?,?,?,?,?,?,?,?,?,0);
    </preparedstatement>
    
    <preparedstatement name="restoreStatementNR" inputs="+String id,+Integer metadata,+Long namedGraphId,+Long subject,+Long predicate,+Long object">
        INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,COMMITTED) VALUES (?, ?,?, ?, ?, ?,0);
    </preparedstatement>
    
    
    <preparedstatement name="replaceStatement" inputs="+String newId,+Long oid,+String id">
        UPDATE STATEMENTS SET STATEMENTS.ID=?, STATEMENTS.OBJECT=? WHERE STATEMENTS.ID=?
    </preparedstatement>
    
    <preparedstatement name="replaceStatementNR" inputs="+String newId,+Long oid,+String id">
        UPDATE STATEMENTS_NR SET STATEMENTS_NR.ID=?, STATEMENTS_NR.OBJECT=? WHERE STATEMENTS_NR.ID=?
    </preparedstatement>
    
    <preparedstatement name="selectFullStatements" inputs="+Long pid" outputs="+String id,+Long uuid,+Long subject,+Long predicate,+Long object,+Long namedGraphId,+Long start,+Long end" results="ITERATOR">
        SELECT ID,UUID,SUBJECT,PREDICATE,OBJECT,NAMEDGRAPHID,RSTART,REND FROM STATEMENTS WHERE PREDICATE=? AND METADATA=1;
    </preparedstatement>

    <preparedstatement name="selectFullStatementsNR" inputs="+Long pid" outputs="+String id,+Long subject,+Long predicate,+Long object,+Long namedGraphId" results="ITERATOR">
        SELECT ID,SUBJECT,PREDICATE,OBJECT,NAMEDGRAPHID FROM STATEMENTS_NR WHERE PREDICATE=? AND METADATA=1
    </preparedstatement>
   
    
</preparedstatements>
