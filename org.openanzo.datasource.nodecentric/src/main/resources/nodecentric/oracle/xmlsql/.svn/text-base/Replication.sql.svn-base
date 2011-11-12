<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/Replication.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: Replication.sql 229 2007-08-07 15:22:00Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>  

	
	
	<preparedstatement name="insertDeltaNRStatements"
	 results="COUNTER"	 
	 templateParams="String sessionPrefix"
	 >
	<![CDATA[
		INSERT INTO {0}STMTS_REP_TMP(ID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT)
		SELECT 
			S.ID,S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT
		FROM 
			STATEMENTS_NR S
		WHERE
			S.COMMITTED=0 AND S.NAMEDGRAPHID IN (SELECT  ID FROM {0}NGR_TMP WHERE REVISION>-1 UNION SELECT  METAID FROM {0}NGR_TMP  WHERE REVISION>-1)
	]]>
	</preparedstatement>
	
	<preparedstatement name="purgeExtraStatements"
	 results="COUNTER"	 
	 templateParams="String sessionPrefix"
	 >
	<![CDATA[
		DELETE FROM {0}STMTS_REP_TMP
		WHERE 
		{0}STMTS_REP_TMP.REND IS NOT NULL AND
		EXISTS (SELECT  ST2.ID FROM {0}STMTS_REP_TMP ST2 WHERE ST2.ID={0}STMTS_REP_TMP.ID AND (ST2.REND IS NULL OR ST2.REND>{0}STMTS_REP_TMP.REND))
		
	]]>
	</preparedstatement>
	
	
</preparedstatements>