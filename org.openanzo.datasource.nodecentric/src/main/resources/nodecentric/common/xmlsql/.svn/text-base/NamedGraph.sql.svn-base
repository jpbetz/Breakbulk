<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/NamedGraph.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: NamedGraph.sql 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>  
	<preparedstatement name="deleteStatementsForNamedGraph" inputs="+Long rend,+Long id,+Long metaId" results="COUNTER" >
		UPDATE STATEMENTS SET REND=? WHERE REND IS NULL AND (NAMEDGRAPHID = ? OR NAMEDGRAPHID = ?);
	</preparedstatement>
    
    <preparedstatement name="deleteStatementsForNamedGraphBatch" results="COUNTER" templateParams="String sessionPrefix,String tableName">
        UPDATE STATEMENTS SET REND=(SELECT {0}{1}.REND FROM {0}{1} WHERE {0}{1}.TYPE=0 AND {0}{1}.ID=STATEMENTS.NAMEDGRAPHID)  WHERE REND IS NULL AND NAMEDGRAPHID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=0);
    </preparedstatement>
	
	<preparedstatement name="purgeStatementsForNamedGraph" inputs="+Long id,+Long metaId" results="COUNTER" >
		DELETE FROM STATEMENTS WHERE NAMEDGRAPHID = ? OR NAMEDGRAPHID = ?;
	</preparedstatement>
	
	<preparedstatement name="containsNamedGraphRevisioned" inputs="+Long id" outputs="Long id" results="VALUE">
	<![CDATA[ 
		SELECT ID FROM NAMEDGRAPHS WHERE ID = ? AND HEND IS NULL AND COMMITTED=0;
	]]>
	</preparedstatement>
	
	<preparedstatement name="containsMetadataGraphRevisioned" inputs="+Long id" outputs="Long id" results="VALUE">
	<![CDATA[ 
		SELECT ID FROM NAMEDGRAPHS WHERE METAID=? AND HEND IS NULL AND COMMITTED=0;
	]]>
	</preparedstatement>
	
	<preparedstatement name="containsNamedGraphAtRevision" inputs="+Long uuid,+Long revision" outputs="Long id" results="VALUE">
	<![CDATA[ 
		SELECT ID FROM NAMEDGRAPHS WHERE UUID=? AND REVISION=? AND COMMITTED<=0;
	]]>
	</preparedstatement>
	
	<preparedstatement name="selectNamedGraphRevisioned" inputs="+Long id" outputs="+Long id,+Long metaId,+Long uuid,+Long revision,+Long hstart,+Long lastModifiedBy" results="ROW">
	<![CDATA[ 	
		SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE ID = ? AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));
	]]>
	</preparedstatement>

	<preparedstatement name="selectNamedGraphNonRevisioned" inputs="+Long id" outputs="+Long id,+Long metaId,+Long uuid,+Long revision,+Long hstart,+Long lastModifiedBy" results="ROW">
	<![CDATA[ 	
		SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS_NR WHERE ID = ? AND COMMITTED<=0;
	]]>
	</preparedstatement>
    
    <preparedstatement name="selectNamedGraphRevisionedBatch" outputs="+Long id,+Long metaId,+Long uuid,+Long revision,+Long hstart,+Long lastModifiedBy" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE ID IN (SELECT ID FROM {0}{1}) AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));
    ]]>
    </preparedstatement>

    <preparedstatement name="selectNamedGraphNonRevisionedBatch" outputs="+Long id,+Long metaId,+Long uuid,+Long revision,+Long hstart,+Long lastModifiedBy" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS_NR WHERE ID IN (SELECT ID FROM {0}{1}) AND COMMITTED<=0;
    ]]>
    </preparedstatement>
	
	<preparedstatement name="getAllRevisionedNamedGraphs" outputs="Long id" results="ITERATOR">
	<![CDATA[ 	
		SELECT ID FROM NAMEDGRAPHS WHERE ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)) UNION SELECT METAID FROM NAMEDGRAPHS WHERE ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));
	]]>
	</preparedstatement>
	
	<preparedstatement name="countAllRevisionedNamedGraphs" outputs="+Long count" results="VALUE">
	<![CDATA[ 	
		SELECT COUNT(1) FROM NAMEDGRAPHS WHERE ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));
	]]>
	</preparedstatement>
	
	<preparedstatement name="containsNamedGraphNonRevisioned" inputs="+Long id" outputs="Long count" results="VALUE">
		SELECT ID FROM NAMEDGRAPHS_NR WHERE ID = ?;
	</preparedstatement>

	<preparedstatement name="containsNamedGraphNRAtRevision" inputs="+Long id,+Long revision" outputs="Long count" results="VALUE">
		SELECT ID FROM NAMEDGRAPHS_NR WHERE ID = ?  AND REVISION=?;
	</preparedstatement>
	
	<preparedstatement name="containsMetadataGraphNonRevisioned" inputs="+Long id" outputs="Long count" results="VALUE">
		SELECT ID FROM NAMEDGRAPHS_NR WHERE METAID=?;
	</preparedstatement>

	<preparedstatement name="containsMetadataGraphNRAtRevision" inputs="+Long id,+Long revision" outputs="Long count" results="VALUE">
		SELECT ID FROM NAMEDGRAPHS_NR WHERE METAID=? AND REVISION=?;
	</preparedstatement>

	<preparedstatement name="getAllNonRevisionedNamedGraphs" outputs="Long id" results="ITERATOR">
	<![CDATA[ 
		SELECT ID FROM NAMEDGRAPHS_NR WHERE COMMITTED<=0 UNION SELECT METAID FROM NAMEDGRAPHS_NR WHERE COMMITTED<=0;
	]]>
	</preparedstatement>

	<preparedstatement name="countAllNonRevisionedNamedGraphs" outputs="+Long count" results="VALUE">
	<![CDATA[ 
		SELECT COUNT(1) FROM NAMEDGRAPHS_NR WHERE COMMITTED<=0;
	]]>
	</preparedstatement>
	
	<preparedstatement name="getNamedGraphForUUID" inputs="+Long uuid" outputs="Long id" results="VALUE">
	<![CDATA[ 	
		SELECT ID FROM NAMEDGRAPHS WHERE UUID=? AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));
	]]>
	</preparedstatement>
	
	<preparedstatement name="getNamedGraphForUUIDNR" inputs="+Long uuid" outputs="Long id" results="VALUE">
	<![CDATA[ 	
		SELECT ID FROM NAMEDGRAPHS_NR WHERE UUID=? AND COMMITTED<=0;
	]]>
	</preparedstatement>
	
	<preparedstatement name="getUUIDForNamedGraph" inputs="+Long uri" outputs="Long uuid" results="VALUE">
	<![CDATA[ 	
		SELECT UUID FROM NAMEDGRAPHS WHERE ID=? AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));
	]]>
	</preparedstatement>
	
	<preparedstatement name="getUUIDForNamedGraphNR" inputs="+Long uri" outputs="Long uuid" results="VALUE">
	<![CDATA[ 	
		SELECT UUID FROM NAMEDGRAPHS_NR WHERE ID=? AND COMMITTED<=0;
	]]>
	</preparedstatement>
    
    <preparedstatement name="getBatchNamedGraphForUUID"  outputs="Long uuid,Long id" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT UUID,ID FROM NAMEDGRAPHS WHERE UUID IN (SELECT ID FROM {0}{1}) AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));
    ]]>
    </preparedstatement>
    
    <preparedstatement name="getBatchNamedGraphForUUIDNR"  outputs="Long uuid,Long id" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT UUID,ID FROM NAMEDGRAPHS_NR WHERE UUID IN (SELECT ID FROM {0}{1}) AND COMMITTED<=0;
    ]]>
    </preparedstatement>
    
    <preparedstatement name="getBatchUUIDForNamedGraph"  outputs="Long uuid,Long id" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT UUID,ID FROM NAMEDGRAPHS WHERE ID IN (SELECT ID FROM {0}{1}) AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));
    ]]>
    </preparedstatement>
    
    <preparedstatement name="getBatchUUIDForNamedGraphNR"  outputs="Long uuid,Long id" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT UUID,ID FROM NAMEDGRAPHS_NR WHERE ID IN (SELECT ID FROM {0}{1}) AND COMMITTED<=0;
    ]]>
    </preparedstatement>
	
	
	<preparedstatement name="insertNamedGraph" results="COUNTER" inputs="+Long modified, +Long namedgraphid,+Long metadataId,+Long uuid, +Long revision,+Long lastModifiedBy,+Long committed">
		INSERT INTO NAMEDGRAPHS (HSTART, ID, METAID,UUID,REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?, ?, ?,?, ?,?,?);
	</preparedstatement>
	
	<preparedstatement name="deleteNamedGraph" results="COUNTER"  inputs="+Long hend,+Long committed,+Long id">
		UPDATE NAMEDGRAPHS SET HEND=?,COMMITTED=? WHERE ID = ? AND HEND IS NULL;
	</preparedstatement>
    
    <preparedstatement name="deleteNamedGraphBatch" results="COUNTER"  inputs="+Long hend,+Long committed" templateParams="String sessionPrefix,String tableName">
        UPDATE NAMEDGRAPHS SET HEND=?,COMMITTED=? WHERE ID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=0) AND HEND IS NULL;
    </preparedstatement>
    
	
	<preparedstatement name="purgeNamedGraph" results="COUNTER"  inputs="+Long id">
		DELTE FROM NAMEDGRAPHS WHERE WHERE ID = ?
	</preparedstatement>
	
	<preparedstatement name="insertNamedGraphNR" results="COUNTER"  inputs="+Long modified, +Long namedgraphid,+Long metadataId,+Long uuid,  +Long revision,+Long lastModifiedBy,+Long committed">
		INSERT INTO NAMEDGRAPHS_NR (HSTART, ID, METAID,UUID, REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?, ?,?,?,?,?,?);
	</preparedstatement>
	
	<preparedstatement name="deleteNamedGraphNR" results="COUNTER"  inputs="+Long committed,+Long namedgraphid">
		UPDATE NAMEDGRAPHS_NR SET COMMITTED=? WHERE ID = ?;
	</preparedstatement>
    
    <preparedstatement name="deleteNamedGraphNRBatch" results="COUNTER"  inputs="+Long committed" templateParams="String sessionPrefix,String tableName">
        UPDATE NAMEDGRAPHS_NR SET COMMITTED=? WHERE ID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=1);
    </preparedstatement>
	
	<preparedstatement name="deleteStatementsForNamedGraphNR" inputs="+Long ngID,+Long metaID">
		DELETE FROM STATEMENTS_NR WHERE NAMEDGRAPHID = ? OR NAMEDGRAPHID = ?;
	</preparedstatement>
    
    <preparedstatement name="deleteStatementsForNamedGraphNRBatch"  results="COUNTER" templateParams="String sessionPrefix,String tableName">
        DELETE FROM STATEMENTS_NR WHERE NAMEDGRAPHID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=1);
    </preparedstatement>
	
	
	<preparedstatement name="updateNamedGraphNR" inputs="+Long transactionId,+Long id">
		UPDATE NAMEDGRAPHS_NR SET COMMITTED=? WHERE ID = ?;
	</preparedstatement>
	
	<preparedstatement name="selectNamedGraphRevision" inputs="+Long uuid,+Long revision, +Long revision2" outputs="+Long subject,+Long predicate,+Long object,+Long namedgraphid" results="ITERATOR" >
		<![CDATA[ 
		SELECT SUBJECT,PREDICATE,OBJECT,NAMEDGRAPHID
		FROM STATEMENTS S
		WHERE S.UUID=? AND COMMITTED=0 AND S.RSTART<=? AND (S.REND IS NULL OR S.REND>?);
		]]>
	</preparedstatement>
	

	<preparedstatement name="selectNamedGraphSize" inputs="+Long id" 
	outputs="+Long count" results="VALUE">
		<![CDATA[ 
			SELECT DISTINCT COUNT(1) 
			FROM STATEMENTS SH
			WHERE SH.NAMEDGRAPHID = ?  AND
			((SH.HEND IS NULL AND SH.COMMITTED=0) OR (SH.HEND IS NOT NULL AND SH.COMMITTED<0))
		]]>
	</preparedstatement>
	
	
	<preparedstatement name="selectNamedGraphSizeNonRevisioned" inputs="+Long id" 
	outputs="+Long count" results="VALUE">
		<![CDATA[ 
			SELECT DISTINCT COUNT(1) 
			FROM STATEMENTS_NR SH
			WHERE SH.NAMEDGRAPHID = ? AND
			SH.COMMITTED<=0
		]]>
	</preparedstatement>
	
	<preparedstatement name="insertIdsIntoTempTable" inputs="+Long id" results="COUNTER" templateParams="String sessionPrefix,String tableName">
	    INSERT INTO {0}{1} VALUES (?)
	</preparedstatement>
	
	<preparedstatement name="lockNamedGraph" inputs="+Long id,+Long transactionId"  >
	    INSERT INTO LOCKED_GRAPHS(ID,TRANSACTIONID) VALUES (?,?)
	</preparedstatement>
	
	<preparedstatement name="unlockNamedGraph" inputs="+Long id,+Long transactionId"  >
	    DELETE FROM LOCKED_GRAPHS WHERE ID=? AND TRANSACTIONID=?
	</preparedstatement>
	
	<preparedstatement name="purgelockedNamedGraph" inputs="+Long transactionId"  >
	    DELETE FROM LOCKED_GRAPHS WHERE TRANSACTIONID=?
	</preparedstatement>
    
    <preparedstatement name="insertRemovedGraph" inputs="+Long id,+Integer type,+Long rend" templateParams="String sessionPrefix,String tableName" >
        INSERT INTO {0}{1}(ID,TYPE,REND) VALUES (?,?,?)
    </preparedstatement>
	
</preparedstatements>
