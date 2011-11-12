<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/Statement.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: Statement.sql 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>
	
	<preparedstatement name="selectStatementId"
			inputs="+Long subject,  +Long predicate,  +Long object,+Long namedGraph" 
			outputs="+Long id"
			results="VALUE">
		SELECT S.ID
		FROM STATEMENTS S
		WHERE SUBJECT = ? AND PREDICATE = ? AND OBJECT = ? AND S.NAMEDGRAPHID = ? AND REND IS NULL;
	</preparedstatement>
	
	<preparedstatement name="insertStatement" inputs="+String id,+Integer metadata,+Long uuid,+Long namedGraphId,+Long subject,+Long predicate,+Long object,+Long rstart">
		INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,RSTART,COMMITTED) VALUES (?,?,?,?, ?, ?, ?, ?,0);
	</preparedstatement>
	
	<preparedstatement name="insertStatementNR" inputs="+String id,+Integer metadata,+Long namedGraphId,+Long subject,+Long predicate,+Long object">
		INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,COMMITTED) VALUES (?, ?,?, ?, ?, ?,0);
	</preparedstatement>
	
	
	<preparedstatement name="deleteStatement" inputs="+Long rend,String id" results="COUNTER">
		UPDATE STATEMENTS SET REND=? WHERE ID=?;
	</preparedstatement>
	
	<preparedstatement name="deleteStatementNR" inputs="+String id" results="COUNTER">
		DELETE FROM STATEMENTS_NR WHERE ID=?;
	</preparedstatement>
	
	<preparedstatement name="countStatements"
			outputs="+Long count"
			results="VALUE">
		<![CDATA[
		SELECT COUNT(1)
		FROM STATEMENTS
		WHERE ((REND IS NULL AND COMMITTED=0) OR (REND IS NOT NULL AND COMMITTED<0));
		]]>
	</preparedstatement>
    
    <preparedstatement name="resolveDataset"
            inputs="+Long gId,+Long g2Id"
            outputs="+Long predicateId,+Long object"
            results="ITERATOR"
            templateParams="String ngId,String dgId,String dngId"
     >
        <![CDATA[
        SELECT PREDICATE,OBJECT
        FROM STATEMENTS
        WHERE ((REND IS NULL AND COMMITTED=0) OR (REND IS NOT NULL AND COMMITTED<0)) AND
        PREDICATE IN ({0},{1},{2}) AND
        SUBJECT = ? AND
        NAMEDGRAPHID = ?
        ]]>
    </preparedstatement>
	<preparedstatement name="resolveDatasetNR"
            inputs="+Long gId,+Long g2Id"
            outputs="+Long predicateId,+Long object"
            results="ITERATOR"
            templateParams="String ngId,String dgId,String dngId"
     >
        <![CDATA[
        SELECT PREDICATE,OBJECT
        FROM STATEMENTS_NR
        WHERE COMMITTED<=0 AND
        PREDICATE IN ({0},{1},{2}) AND
        SUBJECT = ? AND
        NAMEDGRAPHID = ?
        ]]>
    </preparedstatement>
	<preparedstatement name="countStatementsNR"
			outputs="+Long count"
			results="VALUE">
		<![CDATA[ 
		SELECT COUNT(1)
		FROM STATEMENTS_NR WHERE COMMITTED <=0;
		]]>
	</preparedstatement>

	<preparedstatement name="findMinMaxId" results="ROW" outputs="+Long min,+Long max" templateParams="String tableName">
        SELECT MIN(ID),MAX(ID) FROM {0}
    </preparedstatement>
    
    <preparedstatement name="findLiteralStatementsRange" results="ITERATOR" outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj" inputs="+Long start,+Long end" >
       <![CDATA[
        SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT
        FROM STATEMENTS WHERE COMMITTED=0 AND REND IS NULL AND OBJECT > ? and OBJECT < ?
        ]]>
    </preparedstatement>
    
     <preparedstatement name="findLiteralStatementsNRRange"  results="ITERATOR" outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj" inputs="+Long start,+Long end" >
        <![CDATA[
        SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT 
        FROM STATEMENTS_NR WHERE COMMITTED=0 AND OBJECT > ? and OBJECT < ?
        ]]>
    </preparedstatement>

	<preparedstatement name="findLiteralStatements" results="ITERATOR" outputs="+Long namedGraphId,+Long subject,+Long predicate,+Long object">
        <![CDATA[
        SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM ALL_STMTS_VIEW WHERE OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855
        ]]>
    </preparedstatement>
	
      <preparedstatement name="findLiteralStatementsLimited" templateParams="String sessionPrefix" results="ITERATOR" outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj" inputs="+Long start,+Long end" >
        <![CDATA[
        SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM(
        SELECT ROW_NUMBER() OVER (ORDER BY NAMEDGRAPHID) AS ROWNUM,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT
        FROM STATEMENTS WHERE COMMITTED=0 AND REND IS NULL AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855) AS FOO
        WHERE ROWNUM > ? AND ROWNUM<= ?
        ]]>
    </preparedstatement>
    
    <preparedstatement name="findLiteralStatementsNRLimited" templateParams="String sessionPrefix"  results="ITERATOR" outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj" inputs="+Long start,+Long end" >
        <![CDATA[
        SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM(
        SELECT ROW_NUMBER() OVER (ORDER BY NAMEDGRAPHID) AS ROWNUM,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT
        FROM STATEMENTS_NR WHERE COMMITTED=0 AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855) AS FOO
        WHERE ROWNUM > ? AND ROWNUM<= ?
        
        ]]>
    </preparedstatement>
    
      <preparedstatement name="findLiteralStatementsLimitOffset" templateParams="String sessionPrefix" results="ITERATOR" outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj" inputs="+Long start,+Long end" >
       <![CDATA[
        SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT
        FROM STATEMENTS WHERE COMMITTED=0 AND REND IS NULL AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855
        ORDER BY NAMEDGRAPHID ASC
        LIMIT ? OFFSET ?
        ]]>
    </preparedstatement>
    
   <preparedstatement name="findLiteralStatementsNRLimitOffset" templateParams="String sessionPrefix"  results="ITERATOR" outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj" inputs="+Long start,+Long end">
        <![CDATA[
        SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT
        FROM STATEMENTS_NR WHERE COMMITTED=0 AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855
        ORDER BY NAMEDGRAPHID ASC
        LIMIT ? OFFSET ?
        ]]>
    </preparedstatement>
    
</preparedstatements>