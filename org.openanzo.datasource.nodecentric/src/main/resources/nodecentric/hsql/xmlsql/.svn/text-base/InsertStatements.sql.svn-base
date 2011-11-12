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
	
	
	<preparedstatement name="purgeInsertStatements" results="COUNTER" templateParams="String sessionPrefix">
		DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=1 AND {0}STMTS_TMP.ID IN (SELECT S.ID FROM STATEMENTS S,{0}STMTS_TMP ST WHERE S.ID=ST.ID AND S.COMMITTED=0 AND S.REND IS NULL)
	</preparedstatement>
	
	<preparedstatement name="purgeRemoveStatements" results="COUNTER" templateParams="String sessionPrefix">
		DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND {0}STMTS_TMP.ID NOT IN  (SELECT S.ID FROM STATEMENTS S,{0}STMTS_TMP ST WHERE S.ID=ST.ID AND S.COMMITTED=0 AND S.REND IS NULL)
	</preparedstatement>
	
	<preparedstatement name="purgeInsertStatementsNR" results="COUNTER" templateParams="String sessionPrefix">
		DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=1 AND {0}STMTS_TMP.ID IN  (SELECT S.ID FROM STATEMENTS_NR S,{0}STMTS_TMP ST WHERE S.ID=ST.ID AND S.COMMITTED=0 AND S.ID={0}STMTS_TMP.ID)
	</preparedstatement>
	
	<preparedstatement name="purgeRemoveStatementsNR" results="COUNTER" templateParams="String sessionPrefix">
		DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND {0}STMTS_TMP.ID NOT IN  (SELECT S.ID FROM STATEMENTS_NR S,{0}STMTS_TMP ST WHERE S.ID=ST.ID AND S.COMMITTED=0 AND S.ID={0}STMTS_TMP.ID)
	</preparedstatement>
	
</preparedstatements>