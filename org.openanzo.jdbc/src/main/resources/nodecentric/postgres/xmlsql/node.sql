<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/postgres/xmlsql/node.sql,v $
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

	<preparedstatement name="updateUnResolvedIds" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName, String sequenceName">
		UPDATE {0}{1} AS A SET TYPE=1,ID=NEXTVAL(''{1}'') WHERE A.ID IS NULL
	</preparedstatement>

	<preparedstatement name="insertUnresolvedLiterals" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String nodeTableName, String sequenceName">
		INSERT INTO {2} (ID,VALUE,MODIFIER_ID,REF) SELECT (NEXTVAL(''{3}'')),VALUE,MODIFIER_ID,1 FROM {0}{1}
	</preparedstatement>
	
	<preparedstatement name="insertUnresolvedUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String nodeTableName, String sequenceName">
		INSERT INTO {2} (ID,VALUE,REF) SELECT (NEXTVAL(''{3}'')),VALUE,1 FROM {0}{1}
	</preparedstatement>
	
	<!-- Add a language to the language table -->
	<preparedstatement name="insertCommonValueWithIdentity" inputs=" String value" templateParams="String commonValuesTable" results="IDENTITY">
		INSERT INTO {0} ( VALUE) VALUES( ?) RETURNING ID
	</preparedstatement>
</preparedstatements>