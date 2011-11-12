<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/NamedGraph.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: NamedGraph.sql 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>  
    <preparedstatement name="selectNamedGraphRevisioned" inputs="+Long id" outputs="+Long id,+Long metaId,+Long uuid,+Long revision,+Long hstart,+Long lastModifiedBy" results="ROW">
	<![CDATA[ 	
		SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE ID = ? AND HEND IS NULL AND COMMITTED=0;
	]]>
	</preparedstatement>
    
    <preparedstatement name="selectNamedGraphRevisionedBatch" outputs="+Long id,+Long metaId,+Long uuid,+Long revision,+Long hstart,+Long lastModifiedBy" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE ID IN (SELECT  ID FROM {0}{1}) AND HEND IS NULL AND COMMITTED=0);
    ]]>
    </preparedstatement>

    <preparedstatement name="selectNamedGraphNonRevisionedBatch" outputs="+Long id,+Long metaId,+Long uuid,+Long revision,+Long hstart,+Long lastModifiedBy" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS_NR WHERE ID IN (SELECT  ID FROM {0}{1}) AND COMMITTED<=0);
    ]]>
    </preparedstatement>
    
    <preparedstatement name="getAllRevisionedNamedGraphs" outputs="Long id" results="ITERATOR">
	<![CDATA[ 	
		SELECT ID FROM NAMEDGRAPHS WHERE HEND IS NULL AND COMMITTED=0 UNION SELECT METAID FROM NAMEDGRAPHS WHERE HEND IS NULL AND COMMITTED=0;
	]]>
	</preparedstatement>
	
	<preparedstatement name="countAllRevisionedNamedGraphs" outputs="+Long count" results="VALUE">
	<![CDATA[ 	
		SELECT COUNT(1) FROM NAMEDGRAPHS WHERE HEND IS NULL AND COMMITTED=0;
	]]>
	</preparedstatement>
	
    <preparedstatement name="getUUIDForNamedGraph" inputs="+Long uri" outputs="Long uuid" results="VALUE">
	<![CDATA[ 	
		SELECT UUID FROM NAMEDGRAPHS WHERE ID=? AND HEND IS NULL AND COMMITTED=0;
	]]>
	</preparedstatement>
	
	<preparedstatement name="getUUIDForNamedGraphNR" inputs="+Long uri" outputs="Long uuid" results="VALUE">
	<![CDATA[ 	
		SELECT UUID FROM NAMEDGRAPHS_NR WHERE ID=? AND COMMITTED<=0;
	]]>
	</preparedstatement>
	
    <preparedstatement name="getBatchNamedGraphForUUID"  outputs="Long uuid,Long id" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT UUID,ID FROM NAMEDGRAPHS WHERE UUID IN (SELECT  ID FROM {0}{1}) AND HEND IS NULL AND COMMITTED=0);
    ]]>
    </preparedstatement>
    
    <preparedstatement name="getBatchNamedGraphForUUIDNR"  outputs="Long uuid,Long id" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT UUID,ID FROM NAMEDGRAPHS_NR WHERE UUID IN (SELECT  ID FROM {0}{1}) AND COMMITTED<=0);
    ]]>
    </preparedstatement>
    
    <preparedstatement name="getBatchUUIDForNamedGraph"  outputs="Long uuid,Long id" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT UUID,ID FROM NAMEDGRAPHS WHERE ID IN (SELECT  ID FROM {0}{1}) AND HEND IS NULL AND COMMITTED=0);
    ]]>
    </preparedstatement>
    
    <preparedstatement name="getBatchUUIDForNamedGraphNR"  outputs="Long uuid,Long id" results="ITERATOR" templateParams="String sessionPrefix,String tableName">
    <![CDATA[   
        SELECT UUID,ID FROM NAMEDGRAPHS_NR WHERE ID IN (SELECT  ID FROM {0}{1}) AND COMMITTED<=0);
    ]]>
    </preparedstatement>
	
	
    <preparedstatement name="deleteNamedGraphBatch" results="COUNTER"  inputs="+Long hend,+Long committed" templateParams="String sessionPrefix,String tableName">
        UPDATE NAMEDGRAPHS SET HEND=?,COMMITTED=? WHERE ID IN (SELECT  {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=0) AND HEND IS NULL;
    </preparedstatement>
    
	
    <preparedstatement name="deleteNamedGraphNRBatch" results="COUNTER"  inputs="+Long committed" templateParams="String sessionPrefix,String tableName">
        UPDATE NAMEDGRAPHS_NR SET COMMITTED=? WHERE ID IN (SELECT  {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=1);
    </preparedstatement>
	
    
    <preparedstatement name="deleteStatementsForNamedGraphNRBatch"  results="COUNTER" templateParams="String sessionPrefix,String tableName">
        DELETE FROM STATEMENTS_NR WHERE NAMEDGRAPHID IN (SELECT  {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=1);
    </preparedstatement>
    
    <preparedstatement name="containsNamedGraphRevisioned" inputs="+Long id" outputs="Long id" results="VALUE">
	<![CDATA[ 
		SELECT /*+ opt_param('optimizer_mode','first_rows_1') */ ID FROM NAMEDGRAPHS WHERE ID = ? AND HEND IS NULL AND COMMITTED=0;
	]]>
	</preparedstatement>
	
	<preparedstatement name="containsNamedGraphAtRevision" inputs="+Long uuid,+Long revision" outputs="Long id" results="VALUE">
	<![CDATA[ 
		SELECT /*+ opt_param('optimizer_mode','first_rows_1') */ ID FROM NAMEDGRAPHS WHERE UUID=? AND REVISION=? AND COMMITTED<=0;
	]]>
	</preparedstatement>
	
	<preparedstatement name="containsNamedGraphNonRevisioned" inputs="+Long id" outputs="Long id" results="VALUE">
		SELECT /*+ opt_param('optimizer_mode','first_rows_1') */ ID FROM NAMEDGRAPHS_NR WHERE ID = ? ;
	</preparedstatement>

	<preparedstatement name="containsNamedGraphNRAtRevision" inputs="+Long id,+Long revision" outputs="Long id" results="VALUE">
		SELECT /*+ opt_param('optimizer_mode','first_rows_1') */ ID FROM NAMEDGRAPHS_NR WHERE ID = ? AND REVISION=?;
	</preparedstatement>
	
	 <preparedstatement name="containsMetadataGraphRevisioned" inputs="+Long id" outputs="Long id" results="VALUE">
	<![CDATA[ 
		SELECT /*+ opt_param('optimizer_mode','first_rows_1') */ ID FROM NAMEDGRAPHS WHERE METAID=? AND HEND IS NULL AND COMMITTED=0;
	]]>
	</preparedstatement>
	
	
	<preparedstatement name="containsMetadataGraphNonRevisioned" inputs="+Long id" outputs="Long id" results="VALUE">
		SELECT /*+ opt_param('optimizer_mode','first_rows_1') */ ID FROM NAMEDGRAPHS_NR WHERE METAID=?;
	</preparedstatement>

	<preparedstatement name="containsMetadataGraphNRAtRevision" inputs="+Long id,+Long revision" outputs="Long id" results="VALUE">
		SELECT /*+ opt_param('optimizer_mode','first_rows_1') */ ID FROM NAMEDGRAPHS_NR WHERE  METAID=? AND REVISION=?;
	</preparedstatement>
	
</preparedstatements>
