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

	<preparedstatement name="insertUnresolvedLiterals" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String nodeTableName, String sequenceName">
		INSERT INTO {2} (ID,VALUE,MODIFIER_ID,REF) SELECT ({3}.nextval),VALUE,MODIFIER_ID,1 FROM {0}{1}
	</preparedstatement>
	
	<preparedstatement name="insertUnresolvedUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String nodeTableName, String sequenceName">
		INSERT INTO {2} (ID,VALUE,REF) SELECT ({3}.nextval),VALUE,1 FROM {0}{1}
	</preparedstatement>
		
	<preparedstatement name="commitUncommittedReferences" inputs="Long transactionId" results="COUNTER" templateParams="String lockedIdsTable,String nodeTableName">
		UPDATE {1} SET {1}.REF=0 WHERE EXISTS(SELECT  {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {0}.ID={1}.ID ) AND REF>0
	</preparedstatement>
	
	<preparedstatement name="decrementUncommittedReferences" inputs="Long transactionId" results="COUNTER" templateParams="String lockedIdsTable,String nodeTableName">
		UPDATE {1} SET {1}.REF={1}.REF-1 WHERE {1}.REF>1 AND EXISTS(SELECT  {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {0}.ID={1}.ID )
	</preparedstatement>
	
	<preparedstatement name="updateExistingUrisReferenceCount" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		UPDATE /*+ index({2},ANZO_U_RV) */ {2} SET REF=REF+1 WHERE REF>0 AND VALUE IN (SELECT {0}{1}.VALUE FROM {0}{1}) 
	</preparedstatement>
	
	<preparedstatement name="purgeResolvedUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName">
		DELETE FROM {0}{1} WHERE ENTRYID IN (SELECT  {0}{2}.ENTRYID FROM {0}{2})
	</preparedstatement>
	
	
	<preparedstatement name="updateResolvedUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		UPDATE {0}{1} AS A SET TYPE=2,ID=(SELECT /*+ index({2},ANZO_U_RV) */ {2}.ID FROM {2} WHERE {2}.VALUE=A.VALUE AND {2}.REF=0) WHERE EXISTS (SELECT {2}.ID FROM {2} WHERE {2}.VALUE=A.VALUE AND {2}.REF=0)
	</preparedstatement>

	<preparedstatement name="resolveExistingUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName, String nodeTableName">
		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT /*+ index(N,ANZO_U_RV) */ T.ENTRYID,N.ID,2 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.REF=0
	</preparedstatement>
	
	<preparedstatement name="resolveExistingUncommittedUris" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName, String nodeTableName">
		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT /*+ index(N,ANZO_U_RV) */ T.ENTRYID,N.ID,3 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.REF>0
	</preparedstatement>
	
	
	
	
	<preparedstatement name="resolveExistingLiterals" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName, String nodeTableName">
		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT /*+ index(N,ANZO_L_RV) */ T.ENTRYID,N.ID,2 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.MODIFIER_ID=T.MODIFIER_ID AND N.REF=0
	</preparedstatement>
	
	<preparedstatement name="updateExistingLiteralsReferenceCount" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName, String nodeTableName">
		UPDATE /*+ index({2},ANZO_L_RV) */  {2} SET REF=REF+1 WHERE REF>0 AND EXISTS (SELECT  {0}{1}.VALUE FROM {0}{1} WHERE {0}{1}.VALUE={2}.VALUE AND {0}{1}.MODIFIER_ID={2}.MODIFIER_ID) 
	</preparedstatement>
	
	<preparedstatement name="resolveExistingUncommittedLiterals" results="COUNTER" templateParams="String sessionPrefix,String bulkResolutionTableName,String resolvedTableName, String nodeTableName">
		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT /*+ index(N,ANZO_L_RV) */ T.ENTRYID,N.ID,3 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.MODIFIER_ID=T.MODIFIER_ID AND N.REF>0
	</preparedstatement>
	
	
	
</preparedstatements>