<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/postgres/xmlsql/Attic/with-sequences.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: with-sequences.sql 180 2007-07-31 14:24:13Z mroy $
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
	<preparedstatement name="insertNode" inputs="String value" templateParams="String nodeTableName">
		INSERT INTO {0} (id, value) VALUES(NODE_SEQ.NEXTVAL, ?)
	</preparedstatement>
	
	<preparedstatement name="insertLongNode" inputs="+Long hash, String value" templateParams="String nodeTableName">
		INSERT INTO {0} (ID, HASH, VALUE) VALUES(NODE_SEQ.NEXTVAL, ?, ?)
	</preparedstatement>

	<!--
		Insert a literal and its associated datatype or language if available
	-->	
	<preparedstatement name="insertLiteral" inputs="String value, BIGINT datatype_id, BIGINT language_id" templateParams="String literalNodeTableName">
		INSERT INTO {0} (ID, VALUE, DATATYPE_ID, LANGUAGE_ID) VALUES(NODE_SEQ.NEXTVAL, ?, ?, ?)
	</preparedstatement>
	
	<preparedstatement name="insertLongLiteral" inputs="String value, +Long hash, BIGINT datatype_id, BIGINT language_id" templateParams="String literalNodeTableName">
		INSERT INTO {0} (ID, HASH, VALUE, DATATYPE_ID, LANGUAGE_ID) VALUES(NODE_SEQ.NEXTVAL, ?, ?, ?, ?)
	</preparedstatement>
	
	<preparedstatement name="getNodeID" outputs="+Long node_id" templateParams="String sequenceName" results="VALUE">
		SELECT ({0}.NEXTVAL) FROM DUAL
	</preparedstatement>
</preparedstatements>