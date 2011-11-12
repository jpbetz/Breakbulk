<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/common/xmlsql/graph.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: graph.sql 229 2007-08-07 15:22:00Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>

	<preparedstatement name="insertStatement" inputs="+Integer metadata,+Long namedgraphId,+Long subj, +Long prop, +Long obj" templateParams="String graphTableName">
		INSERT INTO {0} (METADATA,NAMEDGRAPHID,SUBJ, PROP, OBJ) VALUES(?,?, ?,  ?, ?)
	</preparedstatement>
	
	<preparedstatement name="statementExists" inputs="+Long namedgraphId,+Long subj, +Long prop, +Long obj" outputs="+Integer count" results="VALUE" templateParams="String graphTableName">
		SELECT COUNT(1) FROM {0} WHERE NAMEDGRAPHID=? AND SUBJ = ? AND PROP = ? AND OBJ = ?
	</preparedstatement>
	
	<preparedstatement name="size" inputs="+Long namedgraphId" outputs="+Integer count" results="VALUE" templateParams="String graphTableName">
		SELECT COUNT(1) FROM {0} WHERE NAMEDGRAPHID=?
	</preparedstatement>
	
	<preparedstatement name="deleteStatement" inputs="+Long namedgraphId,+Long subj, +Long prop, +Long obj" templateParams="String graphTableName">
		DELETE FROM {0} WHERE NAMEDGRAPHID=? AND SUBJ = ? AND PROP = ? AND OBJ = ?
	</preparedstatement>
	
	<preparedstatement name="resolveStatements" outputs="+Long namedGraphId,+Long subj, +Long prop, +Long obj" results="ITERATOR" templateParams="String bulkResolutionTableName, String statementTableName">
		SELECT A.METADATA,A.NAMEDGRAPHID,A.SUBJ, A.PROP, A.OBJ FROM {0} AS A WHERE EXISTS(SELECT B.NAMEDGRAPHID FROM {1} AS B WHERE A.METADATA=B.METADATA AND A.NAMEDGRAPHID=B.NAMEDGRAPHID AND A.SUBJ = B.SUBJ AND A.PROP = B.PROP AND A.OBJ = B.OBJ	)
	</preparedstatement>
	
	<preparedstatement name="purgeInsertStatements" results="COUNTER" templateParams="String bulkResolutionTableName,String bulkResolutionTableName2, String statementTableName">
			DELETE FROM {0} ST WHERE EXISTS (SELECT S.NAMEDGRAPHID  FROM {2} S  WHERE ST.METADATA=S.METADATA AND  S.NAMEDGRAPHID=ST.NAMEDGRAPHID AND S.SUBJ=ST.SUBJ AND S.PROP=ST.PROP AND S.OBJ=ST.OBJ)
	</preparedstatement>
	
	<preparedstatement name="commitInsertStatements" results="COUNTER" templateParams="String bulkResolutionTableName, String statementTableName">
		INSERT INTO {1} (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ)
		SELECT 
			ST.METADATA,
			ST.NAMEDGRAPHID,
			ST.SUBJ,
			ST.PROP,
			ST.OBJ
		FROM  {0} ST
	</preparedstatement>
	
	<preparedstatement name="commitInsertStatementsNew" results="COUNTER" templateParams="String bulkResolutionTableName, String statementTableName">
		MERGE INTO {1} USING {0} ON {1}.NAMEDGRAPHID = {0}.NAMEDGRAPHID AND {1}.SUBJ = {0}.SUBJ AND {1}.PROP = {0}.PROP AND {1}.OBJ = {0}.OBJ
     	WHEN NOT MATCHED THEN INSERT (NAMEDGRAPHID,SUBJ,PROP,OBJ) VALUES({0}.NAMEDGRAPHID,{0}.SUBJ,{0}.PROP,{0}.OBJ)
     	ELSE IGNORE
     	
	</preparedstatement>
	
	<preparedstatement name="clear" inputs="+Long namedgraphId" templateParams="String graphTableName">
		DELETE FROM {0} WHERE NAMEDGRAPHID=?
	</preparedstatement>
	
	
</preparedstatements>