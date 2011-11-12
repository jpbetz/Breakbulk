<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/common/xmlsql/node.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: node.sql 178 2007-07-31 14:22:33Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>

	<preparedstatement name="getAllLiterals"  outputs="Long id,Long modifierId,String value" templateParams="String nodeTableName,String optimization" results="ITERATOR">
		SELECT ID,MODIFIER_ID,VALUE FROM {0} {1}
	</preparedstatement>

	<!-- Fetch a node _ID_ from the appropriate table -->
	<!-- {0} - Name of the node table -->
	<preparedstatement name="findNodeID" inputs="+Long modifierId,+String value" outputs="Long id" templateParams="String nodeTableName,String optimization" results="ITERATOR">
		SELECT ID FROM {0} WHERE (MODIFIER_ID=0 OR MODIFIER_ID=?) AND VALUE LIKE ?  {1}
	</preparedstatement>
	
	<!-- Fetch a node _ID_ from the appropriate table -->
	<!-- {0} - Name of the node table -->
	<preparedstatement name="fetchNodeID" inputs="+String value" outputs="Long id" templateParams="String nodeTableName,String optimization" results="VALUE">
		SELECT ID FROM {0} WHERE VALUE = ?  {1}
	</preparedstatement>
	
	<!-- Fetch a node _value_ from the appropriate table -->
	<!-- {0} - Name of the node table -->
	<preparedstatement name="fetchNodeValue" inputs="+Long id" outputs="String value" templateParams="String nodeTableName,String optimization" results="VALUE">
		SELECT VALUE FROM {0} WHERE ID = ?  {1}
	</preparedstatement>
	
	<preparedstatement name="fetchLongNodeID" inputs="+Long hash" outputs="Long id,String value" templateParams="String nodeTableName" results="ITERATOR">
		SELECT ID,VALUE FROM {0} WHERE HASH = ?
	</preparedstatement>
	
	<preparedstatement name="fetchLiteralNodeValue" inputs="+Long id" outputs="String value, Long modifier_id" templateParams="String literalNodeTableName,String optimization" results="ROW">
		SELECT VALUE, MODIFIER_ID FROM {0} WHERE ID = ?  {1}
	</preparedstatement>
	
	<preparedstatement name="fetchLiteralNodeID" inputs="+String value, +Long modifier_id" outputs="Long id" templateParams="String literalNodeTableName,String optimization" results="VALUE">
		SELECT ID FROM {0} WHERE VALUE = ? AND MODIFIER_ID = ?  {1}
	</preparedstatement>
	
	<preparedstatement name="fetchLongLiteralNodeID" inputs="+Long hash, +Long modifier_id" outputs="Long id,String value" templateParams="String longLiteralNodeTableName" results="ITERATOR">
		SELECT ID,VALUE FROM {0} WHERE HASH = ? AND MODIFIER_ID = ?
	</preparedstatement>
	
	<!-- Add a language to the language table -->
	<preparedstatement name="insertCommonValue" inputs="+Long id, +String value" templateParams="String commonValuesTable">
		INSERT INTO {0} (ID, VALUE) VALUES(?, ?)
	</preparedstatement>
    
	<!-- Add a language to the language table -->
	<preparedstatement name="insertCommonValueWithIdentity" inputs="+String value" templateParams="String commonValuesTable" results="IDENTITY">
		INSERT INTO {0} ( VALUE) VALUES( ?)
	</preparedstatement>
	
	<preparedstatement name="fetchCommonValueID" inputs="+String value" outputs="Long id" templateParams="String commonValuesTable,String optimization" results="VALUE">
		SELECT ID FROM {0} WHERE VALUE = ?  {1}
	</preparedstatement>
	
	<preparedstatement name="fetchCommonValue" inputs="+Long id" outputs="String value" templateParams="String commonValuesTable,String optimization" results="VALUE">
		SELECT VALUE FROM {0} WHERE ID = ?  {1}
	</preparedstatement>
	
	<preparedstatement name="fetchAllCommonValues" outputs="Long id, String value" templateParams="String commonValuesTable" results="ITERATOR">
		SELECT ID, VALUE FROM {0}
	</preparedstatement>
	
	<!-- Store a bulk node -->
	<preparedstatement name="storeBulkNode" inputs="+Long id, +String value" templateParams="String sessionPrefix,String bulkNodeTableName">
		INSERT INTO {0}{1} (ID, VALUE) VALUES(?, ?)
	</preparedstatement>
	
	<preparedstatement name="storeBulkLongNode" inputs="+Long id,  +Long hash, +String value" templateParams="String sessionPrefix,String bulkNodeTableName">
		INSERT INTO {0}{1} (ID, HASH, VALUE) VALUES(?, ?, ?)
	</preparedstatement>
	
	<!-- Store a bulk literal -->
	<preparedstatement name="storeBulkLiteral" inputs="+Long id, +String value, +Long modifier_id" templateParams="String sessionPrefix,String bulkLiteralTableName">
		INSERT INTO {0}{1} (ID, VALUE, MODIFIER_ID) VALUES(?, ?, ?)
	</preparedstatement>
	
	<preparedstatement name="storeBulkLongLiteral" inputs="+Long id,+String value,+Long hash,+Long modifier_id" templateParams="String sessionPrefix,String bulkLiteralTableName">
		INSERT INTO {0}{1} (ID, VALUE, HASH, MODIFIER_ID) VALUES(?, ?, ?, ?)
	</preparedstatement>
	
	<preparedstatement name="countTempTable" outputs="+Long count" templateParams="String sessionPrefix,String bulkLiteralTableName" results="VALUE">
		SELECT COUNT(1) FROM  {0}{1}
	</preparedstatement>	
	
	
	<preparedstatement name="storeResolveId" inputs="+Long id"   templateParams="String sessionPrefix,String bulkResolutionTableName">
		INSERT INTO {0}{1} (ID) VALUES(?)
	</preparedstatement>
	
	<preparedstatement name="storeResolveNode" inputs="+Integer rowId,+String value"  results="COUNTER"  templateParams="String sessionPrefix,String bulkResolutionTableName">
		INSERT INTO {0}{1} (ENTRYID,VALUE) VALUES(?,?)
	</preparedstatement>
	
	<preparedstatement name="storeResolveNodeLong" inputs="+String value,+Long hash"  results="COUNTER"  templateParams="String sessionPrefix,String bulkResolutionTableName">
		INSERT INTO {0}{1} (VALUE,HASH) VALUES(?,?)
	</preparedstatement>
	
	<preparedstatement name="storeResolveLiteral" inputs="+Integer rowId,+String value,+Long modifier_id"  results="COUNTER"  templateParams="String sessionPrefix,String bulkResolutionTableName">
		INSERT INTO {0}{1} (ENTRYID,VALUE,MODIFIER_ID) VALUES(?,?,?)
	</preparedstatement>
	
	<preparedstatement name="storeResolveLiteralLong" inputs="+String value,+Long hash,+Long modifier_id"  results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName">
		INSERT INTO {0}{1} (VALUE,HASH,MODIFIER_ID) VALUES(?,?,?)
	</preparedstatement>

	<preparedstatement name="resolveNodes" outputs="Long node_id,String value" results="ITERATOR" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		SELECT {2}.ID,{2}.VALUE FROM {2},{0}{1} WHERE  {2}.VALUE={0}{1}.VALUE
	</preparedstatement>
		
	<preparedstatement name="resolveLiterals" outputs="Long node_id,String value,Long modifier_id" results="ITERATOR" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		SELECT {2}.ID,{2}.VALUE,{2}.MODIFIER_ID FROM {2},{0}{1}
		WHERE 
		{2}.VALUE={0}{1}.VALUE AND {2}.MODIFIER_ID = {0}{1}.MODIFIER_ID
	</preparedstatement>
	
	<preparedstatement name="resolveIdsUri" inputs="+Long startId,+Long endId" outputs="Long id,String value" results="ITERATOR" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
        <![CDATA[
        SELECT {2}.ID,{2}.VALUE FROM {2},{0}{1} WHERE {2}.ID={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?
         ]]>
	</preparedstatement>
	<preparedstatement name="resolveTransactedIdsUri" inputs="+Long transactionId,+Long startId,+Long endId" outputs="Long id,String value" results="ITERATOR" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
        <![CDATA[
        SELECT {2}.ID,{2}.VALUE FROM {2},{0}{1} WHERE {0}{1}.TRANSACTIONID=? AND {2}.ID={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?
         ]]>
	</preparedstatement>
	
	<preparedstatement name="updateResolvedUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		UPDATE {0}{1} AS A SET TYPE=2,ID=(SELECT {2}.ID FROM {2} WHERE {2}.VALUE=A.VALUE AND {2}.REF=0) WHERE EXISTS (SELECT {2}.ID FROM {2} WHERE {2}.VALUE=A.VALUE AND {2}.REF=0)
	</preparedstatement>

	<preparedstatement name="resolveExistingUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName, String nodeTableName">
		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,2 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.REF=0
	</preparedstatement>
	
	<preparedstatement name="updateExistingUrisReferenceCount" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		UPDATE {2} SET REF=REF+1 WHERE REF>0 AND VALUE IN (SELECT {0}{1}.VALUE FROM {0}{1}) 
	</preparedstatement>
	
	<preparedstatement name="resolveExistingUncommittedUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName, String nodeTableName">
		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,3 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.REF>0
	</preparedstatement>
	
	<preparedstatement name="purgeResolvedUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName">
		DELETE FROM {0}{1} WHERE ENTRYID IN (SELECT {0}{2}.ENTRYID FROM {0}{2})
	</preparedstatement>
	
	<preparedstatement name="insertUnresolvedUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String nodeTableName, String sequenceName">
		EMPTY
	</preparedstatement>
	
	<preparedstatement name="resolveExistingLiterals" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName, String nodeTableName">
		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,2 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.MODIFIER_ID=T.MODIFIER_ID AND N.REF=0
	</preparedstatement>
	
	<preparedstatement name="updateExistingLiteralsReferenceCount" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		UPDATE {2} SET REF=REF+1 WHERE REF>0 AND EXISTS (SELECT {0}{1}.VALUE FROM {0}{1} WHERE {0}{1}.VALUE={2}.VALUE AND {0}{1}.MODIFIER_ID={2}.MODIFIER_ID) 
	</preparedstatement>
	
	<preparedstatement name="resolveExistingUncommittedLiterals" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName, String nodeTableName">
		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,3 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.MODIFIER_ID=T.MODIFIER_ID AND N.REF>0
	</preparedstatement>
	
	<preparedstatement name="purgeResolvedLiterals" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName">
		DELETE FROM {0}{1} WHERE ENTRYID IN (SELECT {0}{2}.ENTRYID FROM {0}{2})
	</preparedstatement>
	
	<preparedstatement name="insertUnresolvedLiterals" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String nodeTableName, String sequenceName">
		EMPTY
	</preparedstatement>
	
	<preparedstatement name="insertUncommittedReferences" prepare="false"  results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String lockedIdsTable,String transactionId">
		INSERT INTO {2} (ID,TRANSACTIONID) SELECT {0}{1}.ID,{3} FROM {0}{1} WHERE  {0}{1}.TYPE IN (1,3)
	</preparedstatement>

	<preparedstatement name="insertLockedId" inputs="+Long id,+Long transactionId" results="COUNTER" templateParams="String lockedIdsTable">
		INSERT INTO {0} (ID,TRANSACTIONID) VALUES(?,?)
	</preparedstatement>

	<preparedstatement name="commitUncommittedReferences" inputs="+Long transactionId" results="COUNTER" templateParams="String lockedIdsTable,String nodeTableName">
		UPDATE {1} SET REF=0 WHERE EXISTS (SELECT {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {1}.ID={0}.ID) AND REF>0
	</preparedstatement>
	
	<preparedstatement name="deleteUncommittedReferences" inputs="+Long transactionId" results="COUNTER" templateParams="String lockedIdsTable,String nodeTableName">
		DELETE FROM {1} WHERE REF=1 AND EXISTS (SELECT {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {1}.ID={0}.ID)
	</preparedstatement>
	
	<preparedstatement name="decrementUncommittedReferences" inputs="+Long transactionId" results="COUNTER" templateParams="String lockedIdsTable,String nodeTableName">
		UPDATE {1} SET REF=REF-1 WHERE REF>1 AND EXISTS (SELECT {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {1}.ID={0}.ID)
	</preparedstatement>
		
	<preparedstatement name="selectAllResolvedIds" outputs="Integer rowid,Long id" results="ITERATOR" templateParams="String sessionPrefix,String bulkResolutionTableName">
		SELECT {0}{1}.ENTRYID,{0}{1}.ID FROM {0}{1}
	</preparedstatement>
	
	<preparedstatement name="purge"  inputs="+Long transactionId" results="COUNTER" templateParams="String lockIdTable">
		DELETE FROM {0} WHERE TRANSACTIONID=?
	</preparedstatement>
	
	<preparedstatement name="resolveIdsLiteral" inputs="+Long startId,+Long endId"  outputs="Long id,String value,+Long modifierId" results="ITERATOR" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
        <![CDATA[
        SELECT {2}.ID,{2}.VALUE,{2}.MODIFIER_ID FROM {2},{0}{1} WHERE {2}.ID ={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?
         ]]>
	</preparedstatement>
	
	<preparedstatement name="resolveTransactedIdsLiteral" inputs="+Long transactionId,+Long startId,+Long endId" outputs="Long id,String value,Long modifierId" results="ITERATOR" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
        <![CDATA[
        SELECT {2}.ID,{2}.VALUE,{2}.MODIFIER_ID FROM {2},{0}{1} WHERE {0}{1}.TRANSACTIONID=? AND {2}.ID ={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?
         ]]>
	</preparedstatement>
</preparedstatements>