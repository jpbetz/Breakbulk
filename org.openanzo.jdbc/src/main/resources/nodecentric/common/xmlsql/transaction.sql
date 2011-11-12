<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/common/xmlsql/transaction.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: transaction.sql 178 2007-07-31 14:22:33Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>

	<preparedstatement name="insertNotificationStatementAdd" inputs="+Integer metadata,+Long namedgraphid,+Long subj,+Long prop,+Long obj" results="COUNTER" templateParams="String transactionTableName">
		INSERT INTO {0} (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,NS,NE) VALUES(?,?,?,?,?,1,0)
	</preparedstatement>
	
	<preparedstatement name="insertNotificationStatementDel" inputs="+Integer metadata,+Long namedgraphid,+Long subj,+Long prop,+Long obj" results="COUNTER" templateParams="String transactionTableName">
		INSERT INTO {0} (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,NS,NE) VALUES(?,?,?,?,?,0,1)
	</preparedstatement>
	
	<preparedstatement name="updateNotificationStatementAdd" inputs="+Integer metadata,+Long namedgraphid,+Long subj,+Long prop,+Long obj" results="COUNTER" templateParams="String transactionTableName">
		UPDATE {0} SET NS=1,NE=0 WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NOT NULL OR TE_ID IS NOT NULL ) 
	</preparedstatement>
	
	<preparedstatement name="updateNotificationStatementDel" inputs="+Integer metadata,+Long namedgraphid,+Long subj,+Long prop,+Long obj" results="COUNTER" templateParams="String transactionTableName">
		UPDATE {0} SET NS=0,NE=1 WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NOT NULL OR TE_ID IS NOT NULL ) 
	</preparedstatement>

	<preparedstatement name="purgeCommitedStatements" inputs="+Long lastTransaction,+Long lastTransaction2" results="COUNTER" templateParams="String transactionTableName">
		DELETE FROM  {0}_ST WHERE (TS_ID IS NOT NULL AND TS_ID=?) OR (TE_ID IS NOT NULL AND TE_ID=?)
	</preparedstatement>
	
	<preparedstatement name="purgeNotificationStatements"  results="COUNTER" templateParams="String transactionTableName">
		DELETE FROM  {0} WHERE TS_ID IS NULL AND TE_ID IS NULL AND (NS=1 OR NE=1)
	</preparedstatement>

	<preparedstatement name="updateStatementAdd" inputs="+Integer metadata,+Long namedgraphid,+Long subj,+Long prop,+Long obj,+Long lastTransaction,+Long lastTransaction2" results="COUNTER" templateParams="String transactionTableName">
		UPDATE {0} SET NS=0,NE=0,TS_ID=NULL,TE_ID=NULL,CS_ID=NULL,TE_ID=NULL WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NULL OR TS_ID&lt;?) AND (TE_ID IS NULL OR TE_ID&lt;?) 
	</preparedstatement>

	<preparedstatement name="updateStatementDel" inputs="+Integer metadata,+Long namedgraphid,+Long subj,+Long prop,+Long obj,+Long lastTransaction,+Long lastTransaction2" results="COUNTER"  templateParams="String transactionTableName">
		DELETE FROM  {0} WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NULL OR TS_ID&lt;?) AND (TE_ID IS NULL OR TE_ID&lt;?) 
	</preparedstatement>
	
	<preparedstatement name="insertCommandStatementAdd" inputs="+Integer metadata,+Long namedgraphid,+Long subj,+Long prop,+Long obj,+Long transId,+Long commandId" results="COUNTER" templateParams="String transactionTableName">
		INSERT INTO {0}_ST (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,TS_ID,CS_ID) VALUES(?,?,?,?,?,?,?)
	</preparedstatement>
	
	<preparedstatement name="insertCommandStatementDel" inputs="+Integer metadata,+Long namedgraphid,+Long subj,+Long prop,+Long obj,+Long transId,+Long commandId" results="COUNTER" templateParams="String transactionTableName">
		INSERT INTO {0}_ST (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,TE_ID,CE_ID) VALUES(?,?,?,?,?,?,?)
	</preparedstatement>
	
	
	<preparedstatement name="updateTransactionStatementDel" inputs="+Integer metadata,+Long namedgraphid,+Long subj,+Long prop,+Long obj,+Long transactionId,+Long commandId"  results="COUNTER" templateParams="String transactionTableName">
		UPDATE {0} SET TE_ID=?,CE_ID=? WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND TE_ID  IS NULL
	</preparedstatement>

	<preparedstatement name="updateTransactionStatementAdd" inputs="+Integer metadata,+Long namedgraphid,+Long subj,+Long prop,+Long obj,+Long transactionId,+Long commandId"  results="COUNTER" templateParams="String transactionTableName">
		UPDATE {0} SET TS_ID=?,CS_ID=? WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND TS_ID IS NULL and TE_ID IS NULL AND CS_ID IS NULL AND CE_ID IS NULL
	</preparedstatement>
	
	<preparedstatement name="selectAdditions" inputs="+Long transactionId,+Long commandId2" outputs="+Integer metadata,+Long ng,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String containerName">
		SELECT ST.METADATA,ST.NAMEDGRAPHID,ST.subj,ST.prop,ST.obj FROM {0}_ST ST where ST.ts_id =? AND ST.cs_id=?
	</preparedstatement>
	
	<preparedstatement name="selectDeletions" inputs="+Long transactionId,+Long commandId" outputs="+Integer metadata,+Long ng,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String containerName">
		SELECT ST.METADATA,ST.NAMEDGRAPHID,ST.subj,ST.prop,ST.obj FROM {0}_ST ST where ST.te_id =? AND ST.ce_id=?
	</preparedstatement>
	
	<preparedstatement name="udpateChangeset" inputs="CLOB addGraph,CLOB removeGraph,CLOB addMetaGraph,CLOB removeMetaGraph,+Long id" results="COUNTER" templateParams="String transactionTableName">
		UPDATE {0} SET ADDGRAPH=?,REMOVEGRAPH=? ,METAADDGRAPH=?,METAREMOVEGRAPH=? WHERE ID=?
	</preparedstatement>
	
	<preparedstatement name="insertChangeset" inputs="+Long commandId,CLOB addGraph,CLOB removeGraph,CLOB addMetaGraph,CLOB removeMetaGraph,String uri" results="COUNTER" templateParams="String transactionTableName">
		INSERT INTO {0} (commandId, addGraph,removeGraph,metaddgraph,metaremovegraph,namedGraphUri) VALUES (?, ?, ?, ?,?,?)
	</preparedstatement>
	
	<preparedstatement name="selectMaxChangesetId" outputs="Long id" results="VALUE" templateParams="String transactionTableName">
		SELECT MAX(id) FROM {0}
	</preparedstatement>
	
	<preparedstatement name="deleteChangeset" inputs="+Long cmdId,+Long csId" results="COUNTER" templateParams="String transactionTableName">
		DELETE FROM {0} WHERE COMMANDID = ? AND ID = ?
	</preparedstatement>
	
	<preparedstatement name="selectChangeset" inputs="+Long cmdId" results="ITERATOR" outputs="+Long id,CLOB addGraph,CLOB removeGraph,CLOB metaAddGraph,CLOB metaRemoveGraph,String nameGraphUri" templateParams="String transactionTableName">
		SELECT ID,ADDGRAPH,REMOVEGRAPH,METAADDGRAPH,METAREMOVEGRAPH,NAMEDGRAPHURI FROM {0} WHERE COMMANDID = ? ORDER BY ID
	</preparedstatement>
	
	<preparedstatement name="updateCommand" inputs="+Long transactionId,String commandType,CLOB context,CLOB preReq,+Long id" results="COUNTER" templateParams="String transactionTableName">
		UPDATE {0} set transactionId=?,commandType=?,context=?,preReq=? where id=?
	</preparedstatement>
	
	<preparedstatement name="insertCommand" results="COUNTER" inputs="+Long transactionId,String commandType,CLOB context,CLOB preReq" templateParams="String transactionTableName">
		INSERT INTO {0} (transactionId, commandType,context,prereq) VALUES (?, ?, ?, ?)
	</preparedstatement>
	
	<preparedstatement name="deleteCommand" inputs="+Long transactionId,+Long cmdId" results="COUNTER" templateParams="String transactionTableName">
		DELETE FROM {0} WHERE TRANSACTIONID = ? AND ID = ?
	</preparedstatement>
	
	<preparedstatement name="deleteTransaction" inputs="+Long transactionId" results="COUNTER" templateParams="String transactionTableName">
		DELETE FROM {0} WHERE ID = ?
	</preparedstatement>
	
	<preparedstatement name="selectCommand" inputs="+Long transactionId" outputs="+Long id,String commandType,CLOB prereq,CLOB context" results="ITERATOR" templateParams="String transactionTableName">
		SELECT ID,COMMANDTYPE,PREREQ,CONTEXT FROM {0} WHERE TRANSACTIONID = ? ORDER BY ID
	</preparedstatement>
	
	<preparedstatement name="insertTransaction" inputs="+Timestamp created" results="COUNTER" templateParams="String transactionTableName">
		INSERT INTO {0} (CREATED) VALUES (?)
	</preparedstatement>
	
	<preparedstatement name="maxId" outputs="Long counter" results="VALUE" templateParams="String transactionTableName">
		SELECT MAX(ID) FROM {0}
	</preparedstatement>
	
	<preparedstatement name="selectTransactions" outputs="Long id" results="ITERATOR" templateParams="String transactionTableName">
	   SELECT ID FROM {0} ORDER BY ID
	</preparedstatement>
	
</preparedstatements>