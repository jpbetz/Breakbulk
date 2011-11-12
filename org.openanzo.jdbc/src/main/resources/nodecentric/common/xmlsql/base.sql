<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/common/xmlsql/base.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: base.sql 178 2007-07-31 14:22:33Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>

	<!--
		Delete all rows from named AST table
	-->
	<preparedstatement name="dropTable" results="COUNTER" templateParams="String tableName">
		DROP TABLE {0}
	</preparedstatement>
	
	<preparedstatement name="dropView" results="COUNTER"  templateParams="String tableName">
		DROP VIEW {0}
	</preparedstatement>
    <!--
        truncate table which may or may not commit open transaction
    -->
    <preparedstatement name="truncateTableMayCommit" templateParams="+String tableName">
        DELETE FROM {0}
    </preparedstatement>
    <!--
        truncate table which may or may not commit open transaction
    -->
    <preparedstatement prepare="false" name="truncateTableWithSessionMayCommit" templateParams="+String sessionPrefix,+String tableName">
        DELETE FROM {0}{1}
    </preparedstatement>
	<!--
		clear all data from a table
	-->
	<preparedstatement name="clearTable" templateParams="+String tableName">
		DELETE FROM {0}
	</preparedstatement>

    <!--
        clear all data from a table
    -->
    <preparedstatement name="clearTableWithSessionPrefix" templateParams="+String sessionPrefix,+String tableName">
        DELETE FROM {0}{1}
    </preparedstatement>
    
	<!--
		Remove all rows from given table with the given GraphID.
		Substitutes table name
	-->
	<preparedstatement name="removeRowsFromTable" results="COUNTER" inputs="+Long GraphID" templateParams="String tableName">
		DELETE FROM {0} WHERE (GraphID = ?)
	</preparedstatement>

	<!--
		Store the name of a new graph and create a unique identifier for it.
	-->
	<preparedstatement name="insertGraph"  results="COUNTER" inputs="+String Name" templateParams="String tableName">
		INSERT INTO {0} (Name) VALUES (?)
	</preparedstatement>

	<!--
		Return the count of rows in the table
	-->
	<preparedstatement name="getRowCount" outputs="+Integer count" templateParams="String tableName" results="VALUE">
		SELECT COUNT(1) FROM {0}
	</preparedstatement>
	
	<preparedstatement name="lockTable"  templateParams="String tableName,String mode" >
		LOCK TABLE {0} {1}
	</preparedstatement>
	
	<preparedstatement name="unlockTable"  templateParams="String tableName" >
		EMPTY
	</preparedstatement>

	
</preparedstatements>