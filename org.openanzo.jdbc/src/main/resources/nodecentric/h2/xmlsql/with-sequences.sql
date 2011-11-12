<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/hsql/xmlsql/with-sequences.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: with-sequences.sql 178 2007-07-31 14:22:33Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>

	<!--
		New database structure
		
		Insert a node in to the appropriate table
		tableName - Name of the node table
	-->
	<preparedstatement name="insertNode" inputs="String value" templateParams="String nodeTableName,String sequenceName">
		INSERT INTO {0} (id, value) VALUES(NEXT VALUE FOR {1}, ?)
	</preparedstatement>
	
	<preparedstatement name="insertLongNode" inputs="+Long hash, String value" templateParams="String nodeTableName,String sequenceName">
			INSERT INTO {0} (ID, HASH, VALUE,REF) VALUES(NEXT VALUE FOR {1}, ?, ?,0)
	</preparedstatement>

	<!--
		Insert a literal and its associated datatype or language if available
	-->	
	<preparedstatement name="insertLiteral" inputs="String value, BIGINT modifier_id" templateParams="String literalNodeTableName,String sequenceName">
			INSERT INTO {0} (ID, VALUE, DATATYPE_ID, LANGUAGE_ID,REF) VALUES(NEXT VALUE FOR {1}, ?, ?, ?,0)
	</preparedstatement>
	
	<preparedstatement name="insertLongLiteral" inputs="String value, +Long hash, BIGINT modifier_id" templateParams="String literalNodeTableName,String sequenceName">
		INSERT INTO {0} (ID, HASH, VALUE, DATATYPE_ID, LANGUAGE_ID,REF) VALUES(NEXT VALUE FOR {1}, ?, ?, ?, ?,0)
	</preparedstatement>
	
	<preparedstatement name="getNodeID" outputs="+Long node_id" templateParams="String sequenceName" results="VALUE">
		SELECT NEXT VALUE FOR {0} FROM GLITTERUNIT
	</preparedstatement>
</preparedstatements>