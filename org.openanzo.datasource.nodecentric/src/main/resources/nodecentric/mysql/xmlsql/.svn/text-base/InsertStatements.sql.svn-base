<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/mysql/xmlsql/Attic/InsertStatements.sql,v $
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
	<preparedstatement name="commitRemoveStatements" inputs="Long rstart" results="COUNTER" templateParams="String sessionPrefix">
		UPDATE {0}STMTS_TMP,STATEMENTS SET STATEMENTS.REND=? 
		WHERE {0}STMTS_TMP.OPERATION=0 AND {0}STMTS_TMP.SUBJ=STATEMENTS.SUBJ AND {0}STMTS_TMP.PROP=STATEMENTS.PROP AND {0}STMTS_TMP.OBJ=STATEMENTS.OBJ AND {0}STMTS_TMP.NAMEDGRAPHID=STATEMENTS.NAMEDGRAPHID AND STATEMENTS.REND IS NULL
	</preparedstatement>
	
</preparedstatements>