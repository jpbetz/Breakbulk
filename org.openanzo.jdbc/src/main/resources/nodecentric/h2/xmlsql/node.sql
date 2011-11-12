<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/hsql/xmlsql/node.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: node.sql 178 2007-07-31 14:22:33Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>
	<preparedstatement name="resolveNodes" outputs="+Long node_id, String value" results="ITERATOR" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		SELECT B.ID,B.VALUE FROM {2} B WHERE B.VALUE IN (SELECT {0}{1}.VALUE FROM {0}{1})
	</preparedstatement>

	<preparedstatement name="resolveIdsUri"  inputs="+Long startId,+Long endId" outputs="+Long id,String value" results="ITERATOR" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		SELECT B.ID,B.VALUE FROM {2} B WHERE B.ID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.ID >= ? AND {0}{1}.ID &lt; ?)
	</preparedstatement>
	
	<preparedstatement name="resolveIdsLiteral"  inputs="+Long startId,+Long endId" outputs="+Long id,String value,+Long modifierId" results="ITERATOR" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		SELECT B.ID,B.VALUE,B.MODIFIER_ID FROM {2} B WHERE B.ID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.ID>=? AND {0}{1}.ID &lt; ?)
	</preparedstatement>

	<preparedstatement name="insertUnresolvedLiterals" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String nodeTableName, String sequenceName">
		INSERT INTO {2} (ID,VALUE,MODIFIER_ID,REF) SELECT NEXT VALUE FOR {3},VALUE,MODIFIER_ID,1 FROM {0}{1}
	</preparedstatement>
	
	<preparedstatement name="insertUnresolvedUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String nodeTableName, String sequenceName">
		INSERT INTO {2} (ID,VALUE,REF) SELECT NEXT VALUE FOR {3},VALUE,1 FROM {0}{1}
	</preparedstatement>

</preparedstatements>