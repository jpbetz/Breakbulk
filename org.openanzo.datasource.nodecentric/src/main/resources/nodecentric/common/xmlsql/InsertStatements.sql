<?xml version="1.0" encoding="UTF-8"?>
<!-- 
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/InsertStatements.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: InsertStatements.sql 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>
    <preparedstatement name="getTempTablespaceDefined" outputs="+Long count" results="VALUE">
        SELECT COUNT(1) FROM SYSIBM.SYSTABLESPACES WHERE TBSPACE=''USR_TBSP''
	</preparedstatement>

    <preparedstatement name="insertTempStatement" results="COUNTER" inputs="+Integer operation,+Integer stmtId,String id,+Integer metadata,+Long uuid,+Long graphid,+Long subject,+Long predicate,+Long object,Long revision,+Long committed" templateParams="String sessionPrefix">
        INSERT INTO {0}STMTS_TMP(OPERATION,STMTID,ID,METADATA,UUID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,REVISION,COMMITTED) VALUES(?,?,?,?,?,?,?,?,?,?,?)
	</preparedstatement>


    <preparedstatement name="selectInsertStatements" outputs="+Integer stmtId,+Integer operation" results="ITERATOR" templateParams="String sessionPrefix">
        SELECT
        ST.STMTID,
        ST.OPERATION
        FROM {0}STMTS_TMP ST
	</preparedstatement>

    <preparedstatement name="purgeInsertRemoveStatements" results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND {0}STMTS_TMP.ID IN (SELECT S.ID FROM {0}STMTS_TMP S WHERE S.OPERATION=1)
	</preparedstatement>

    <preparedstatement name="purgeInsertStatements" results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=1 AND EXISTS (SELECT S.ID FROM STATEMENTS S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0 AND S.REND IS NULL)
	</preparedstatement>

    <preparedstatement name="purgeRemoveStatements" results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND NOT EXISTS (SELECT S.ID FROM STATEMENTS S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0  AND S.REND IS NULL)
	</preparedstatement>

    <preparedstatement name="purgeInsertStatementsNR" results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=1 AND EXISTS (SELECT S.ID FROM STATEMENTS_NR S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0)
	</preparedstatement>

    <preparedstatement name="purgeRemoveStatementsNR" results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND NOT EXISTS (SELECT S.ID FROM STATEMENTS_NR S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0)
	</preparedstatement>
    
    <preparedstatement name="countInsertStatements" outputs="+Long count" results="VALUE" templateParams="String sessionPrefix">
        SELECT COUNT(1) FROM {0}STMTS_TMP WHERE OPERATION=1
	</preparedstatement>

    <preparedstatement name="countRemoveStatements" outputs="+Long count" results="VALUE" templateParams="String sessionPrefix">
        SELECT COUNT(1) FROM {0}STMTS_TMP WHERE OPERATION=0
	</preparedstatement>

    <preparedstatement name="commitStatementIds" results="COUNTER" templateParams="String sessionPrefix">
        INSERT INTO {0}STMT_ID_TMP(ID,STMTID)
        SELECT DISTINCT
        {0}STMTS_TMP.ID,
        {0}STMTS_TMP.STMTID
        FROM {0}STMTS_TMP
    </preparedstatement>
    
    <preparedstatement name="selectStatementIds" results="ROW" outputs="Integer min,+Integer max" templateParams="String sessionPrefix">
        SELECT MIN(STMTID),MAX(STMTID)
         FROM {0}STMT_ID_TMP
    </preparedstatement>
    
    <preparedstatement name="commitInsertStatements" results="COUNTER" templateParams="String sessionPrefix">
        INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,RSTART,COMMITTED)
        SELECT 
        {0}STMTS_TMP.ID,
        {0}STMTS_TMP.METADATA,
        {0}STMTS_TMP.UUID,
        {0}STMTS_TMP.NAMEDGRAPHID,
        {0}STMTS_TMP.SUBJECT,
        {0}STMTS_TMP.PREDICATE,
        {0}STMTS_TMP.OBJECT,
        {0}STMTS_TMP.REVISION,
        {0}STMTS_TMP.COMMITTED
        FROM {0}STMTS_TMP
        WHERE {0}STMTS_TMP.OPERATION=1
	</preparedstatement>
    
    <preparedstatement name="commitInsertStatementsRange" results="COUNTER" inputs="+Long start,+Long end" templateParams="String sessionPrefix">
        <![CDATA[
        INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,RSTART,COMMITTED)
        SELECT 
        {0}STMTS_TMP.ID,
        {0}STMTS_TMP.METADATA,
        {0}STMTS_TMP.UUID,
        {0}STMTS_TMP.NAMEDGRAPHID,
        {0}STMTS_TMP.SUBJECT,
        {0}STMTS_TMP.PREDICATE,
        {0}STMTS_TMP.OBJECT,
        {0}STMTS_TMP.REVISION,
        {0}STMTS_TMP.COMMITTED
        FROM {0}STMTS_TMP
        WHERE {0}STMTS_TMP.STMTID >= ? AND {0}STMTS_TMP.STMTID < ? AND {0}STMTS_TMP.OPERATION=1
         ]]>
    </preparedstatement>
    

    <preparedstatement name="commitInsertStatementsNR" results="COUNTER" templateParams="String sessionPrefix">
        INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,COMMITTED)
        SELECT 
        {0}STMTS_TMP.ID,
        {0}STMTS_TMP.METADATA,
        {0}STMTS_TMP.NAMEDGRAPHID,
        {0}STMTS_TMP.SUBJECT,
        {0}STMTS_TMP.PREDICATE,
        {0}STMTS_TMP.OBJECT,
        {0}STMTS_TMP.COMMITTED
        FROM {0}STMTS_TMP
        WHERE {0}STMTS_TMP.OPERATION=1
	</preparedstatement>
    
     <preparedstatement name="commitInsertStatementsNRRange" results="COUNTER" inputs="+Long start,+Long end" templateParams="String sessionPrefix">
        <![CDATA[
        INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,COMMITTED)
        SELECT 
        {0}STMTS_TMP.ID,
        {0}STMTS_TMP.METADATA,
        {0}STMTS_TMP.NAMEDGRAPHID,
        {0}STMTS_TMP.SUBJECT,
        {0}STMTS_TMP.PREDICATE,
        {0}STMTS_TMP.OBJECT,
        {0}STMTS_TMP.COMMITTED
        FROM {0}STMTS_TMP
        WHERE {0}STMTS_TMP.STMTID >= ? AND {0}STMTS_TMP.STMTID < ? AND {0}STMTS_TMP.OPERATION=1
         ]]>
    </preparedstatement>

    <preparedstatement name="commitRemoveStatements" inputs="+Long transactionId" results="COUNTER" templateParams="String sessionPrefix">
        UPDATE STATEMENTS SET 
            COMMITTED=?,
            REND=(SELECT ST.REVISION FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0 AND ST.ID=STATEMENTS.ID) 
        WHERE 
        	COMMITTED=0 AND 
            REND IS NULL AND 
            ID IN (SELECT ST.ID FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0)
	</preparedstatement>
    
    <preparedstatement name="commitRemoveStatementsRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[
        UPDATE STATEMENTS SET 
            COMMITTED=?,
            REND=(SELECT ST.REVISION FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0 AND ST.ID=STATEMENTS.ID) 
        WHERE 
        	COMMITTED=0 AND 
            REND IS NULL AND ID IN (SELECT ST.ID FROM {0}STMTS_TMP ST WHERE ST.STMTID >= ? AND ST.STMTID < ? AND ST.OPERATION=0)
         ]]>
    </preparedstatement>

    <preparedstatement name="commitRemoveStatementsNR" inputs="+Long transactionId" results="COUNTER" templateParams="String sessionPrefix">
        UPDATE STATEMENTS_NR SET COMMITTED=? WHERE ID IN(
        SELECT ST.ID
        FROM {0}STMTS_TMP ST
        WHERE ST.OPERATION=0 )
	</preparedstatement>
    
    <preparedstatement name="commitRemoveStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[
        UPDATE STATEMENTS_NR SET COMMITTED=? WHERE ID IN(
        SELECT ST.ID
        FROM {0}STMTS_TMP ST
        WHERE ST.STMTID >= ? AND ST.STMTID < ? AND ST.OPERATION=0)
       ]]>
    </preparedstatement>

    <preparedstatement name="commitTransactionStatements" inputs="+Long transactionId" results="COUNTER">
        UPDATE STATEMENTS SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionAddStatementsNR" inputs="+Long transactionId" results="COUNTER">
        UPDATE STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionRemoveStatementsNR" inputs="+Long transactionId" results="COUNTER">
        DELETE FROM STATEMENTS_NR WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionNamedGraphs" inputs="+Long transactionId" results="COUNTER">
        UPDATE NAMEDGRAPHS SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionAddNamedGraphsNR" inputs="+Long transactionId" results="COUNTER">
        UPDATE NAMEDGRAPHS_NR SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionRemoveNamedGraphsNR" inputs="+Long transactionId" results="COUNTER">
        DELETE FROM NAMEDGRAPHS_NR WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionStatementsRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[   
        UPDATE STATEMENTS SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ? )
        ]]>
    </preparedstatement>

    <preparedstatement name="commitTransactionAddStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[   
         UPDATE STATEMENTS_NR  SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS_NR.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)
         ]]>
    </preparedstatement>

    <preparedstatement name="commitTransactionRemoveStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
         <![CDATA[   
         DELETE FROM STATEMENTS_NR WHERE COMMITTED=? AND STATEMENTS_NR.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)
         ]]>
    </preparedstatement>


    <preparedstatement name="abortTransactionAddStatements" inputs="+Long transactionId" results="COUNTER">
        DELETE FROM STATEMENTS WHERE COMMITTED=?
	</preparedstatement>
	
	 <preparedstatement name="abortTransactionAlreadyAddedStatements"  results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM STATEMENTS WHERE ID IN (SELECT {0}STMT_ID_TMP.ID FROM {0}STMT_ID_TMP) AND COMMITTED=0 AND REND IS NULL;
	</preparedstatement>

    <preparedstatement name="abortTransactionRemoveStatements" inputs="+Long transactionId" results="COUNTER" templateParams="String bigInt">
        UPDATE STATEMENTS SET REND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="abortTransactionAddStatementsNR" inputs="+Long transactionId" results="COUNTER">
        DELETE FROM STATEMENTS_NR WHERE COMMITTED=?
	</preparedstatement>
	
	<preparedstatement name="abortTransactionAlreadyAddedStatementsNR"  results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM STATEMENTS_NR WHERE ID  IN (SELECT {0}STMT_ID_TMP.ID FROM {0}STMT_ID_TMP);
	</preparedstatement>
	

    <preparedstatement name="abortTransactionRemoveStatementsNR" inputs="+Long transactionId" results="COUNTER">
        UPDATE STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>
    
    <preparedstatement name="abortTransactionAddStatementsRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix" >
         <![CDATA[   
         DELETE FROM STATEMENTS WHERE COMMITTED=? AND STATEMENTS.ID IN  (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)
        ]]>
    </preparedstatement>

    <preparedstatement name="abortTransactionRemoveStatementsRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String bigInt,String sessionPrefix" >
         <![CDATA[   
         UPDATE STATEMENTS SET REND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=? AND ST.ID=STATEMENTS.ID IN (SELECT ST.ID FROM  {1}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)
        ]]>
    </preparedstatement>

    <preparedstatement name="abortTransactionAddStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix" >
         <![CDATA[   
         DELETE FROM STATEMENTS_NR WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ? )
        ]]>
    </preparedstatement>

    <preparedstatement name="abortTransactionRemoveStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
         <![CDATA[   
         UPDATE STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)
        ]]>
    </preparedstatement>

    <preparedstatement name="abortTransactionAddNamedGraphs" inputs="+Long transactionId" results="COUNTER">
        DELETE FROM NAMEDGRAPHS WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="abortTransactionRemoveNamedGraphs" inputs="+Long transactionId" results="COUNTER" templateParams="String bigInt">
        UPDATE NAMEDGRAPHS SET HEND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="abortTransactionAddNamedGraphsNR" inputs="+Long transactionId" results="COUNTER">
        DELETE FROM NAMEDGRAPHS_NR WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="abortTransactionRemoveNamedGraphsNR" inputs="+Long transactionId" results="COUNTER">
        UPDATE NAMEDGRAPHS_NR SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>
</preparedstatements>