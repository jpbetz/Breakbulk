<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/Glitter.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: Glitter.sql 229 2007-08-07 15:22:00Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>

	<preparedstatement name="insertGraphIfValid" prepare="false"  results="COUNTER"
		templateParams="String sessionPrefix, String insertTable, String statementsTable, String roleSql,String graphId, String canBeReadById">
		<![CDATA[ 	
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT S.SUBJECT FROM {2} S
		WHERE S.METADATA = 1
		  AND S.SUBJECT = {4}
		  AND S.PREDICATE = {5}
		  AND S.OBJECT IN ({3})
		  AND S.COMMITTED<=0
		]]>
	</preparedstatement>
	
	<preparedstatement name="insertGraphSysAdmin"  results="COUNTER"
		inputs="+Long graphId"
		templateParams="String sessionPrefix, String insertTable">
		<![CDATA[ 	
		INSERT INTO {0}{1} (ID) VALUES(?)
		]]>
	</preparedstatement>
	
	<preparedstatement name="insertQueryDataset"  results="COUNTER" inputs="+Long graphId,+Long datasetId">
		<![CDATA[ 	
		INSERT INTO QUERY_GRAPHS (ID,DSID) VALUES(?,?)
		]]>
	</preparedstatement>
    
    <preparedstatement name="selectQueryDatasets"  results="ITERATOR" outputs="+Long graphId,+Long datasetId">
        <![CDATA[   
        SELECT ID,DSID FROM QUERY_GRAPHS ORDER BY DSID
        ]]>
    </preparedstatement>
	
	<preparedstatement name="insertGraphsFromQueryDataset"  results="COUNTER"
		inputs="+Long dsId"
		templateParams="String sessionPrefix, String insertTable">
		INSERT INTO {0}{1} (ID) SELECT ID FROM QUERY_GRAPHS WHERE DSID=?
	</preparedstatement>
	
	<preparedstatement name="purgeQueryDataset"  results="COUNTER" inputs="+Long dsId">
		DELETE FROM QUERY_GRAPHS WHERE DSID=?
	</preparedstatement>
	
	
	<preparedstatement name="insertAllValidGraphs" prepare="false" results="COUNTER"
		templateParams="String sessionPrefix, String insertTable, String statementsTable, String roleSql,String canBeReadById, String ngDatasetId, String ngDatasetMetadataId, String mgDatasetId, String mgDatasetMetadataId">
		<![CDATA[ 	
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT S.SUBJECT FROM {2} S
		WHERE S.METADATA = 1
		  AND S.PREDICATE = {4}
		  AND S.OBJECT IN ({3})
		  AND S.SUBJECT NOT IN ({5},{6},{7},{8})
		  AND S.COMMITTED<=0
		]]>
	</preparedstatement>

	<preparedstatement name="insertAllValidNamedGraphs" prepare="false" results="COUNTER"
		templateParams="String sessionPrefix, String insertTable, String statementsTable, String roleSql,String canBeReadById, String ngDatasetId, String mgDatasetId">
		<![CDATA[ 	
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT S.SUBJECT FROM {2} S
		WHERE S.METADATA = 1
		  AND S.PREDICATE = {4}
		  AND S.OBJECT IN ({3})
		  AND S.SUBJECT != S.NAMEDGRAPHID
		  AND S.SUBJECT NOT IN ({5},{6})
		  AND S.COMMITTED<=0
		]]>
	</preparedstatement>

	<preparedstatement name="insertAllValidMetadataGraphs" prepare="false" results="COUNTER"
		templateParams="String sessionPrefix, String insertTable, String statementsTable, String roleSql,String canBeReadById, String ngDatasetMetadataId, String mgDatasetMetadataId">
		<![CDATA[ 	
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT S.SUBJECT FROM {2} S
		WHERE S.METADATA = 1
		  AND S.PREDICATE = {4}
		  AND S.OBJECT IN ({3})
		  AND S.SUBJECT = S.NAMEDGRAPHID
		  AND S.SUBJECT NOT IN ({5},{6})
		  AND S.COMMITTED<=0
		]]>
	</preparedstatement>

	<preparedstatement name="insertValidDatasetGraphs" prepare="false" results="COUNTER"
		templateParams="String sessionPrefix, String insertTable, String statementsTable, String roleSql,String datasetId, String datasetIdRepeated, String datasetGraphPropertyId, String canBeReadById">
		<![CDATA[ 	
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT DS.OBJECT FROM {2} S, {2} DS
		WHERE DS.NAMEDGRAPHID = {4}
		  AND DS.SUBJECT = {5} 
		  AND DS.PREDICATE = {6}
		  AND DS.COMMITTED<=0
		  AND DS.METADATA=0
		  AND S.METADATA = 1
		  AND S.SUBJECT = DS.OBJECT
		  AND S.PREDICATE = {7}
		  AND S.OBJECT IN ({3})
		  AND S.COMMITTED<=0
		]]>
	</preparedstatement>
	
	<preparedstatement name="insertValidDatasetGraphsSysadmin" inputs="+Long datasetId, +Long datasetIdRepeated, +Long datasetGraphPropertyId" results="COUNTER"
		templateParams="String sessionPrefix, String insertTable, String statementsTable">
		<![CDATA[ 	
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT DS.OBJECT FROM {2} DS
		WHERE DS.NAMEDGRAPHID = ?
		  AND DS.SUBJECT = ? 
		  AND DS.PREDICATE = ?		
		  AND DS.COMMITTED<=0
		  AND DS.METADATA=0  
		]]>
	</preparedstatement>
	
	<preparedstatement name="copyDistinctDatasetIds" results="COUNTER" templateParams="String sessionPrefix, String sourceTable, String destinationTable" >
		INSERT INTO {0}{2} SELECT DISTINCT ID FROM {0}{1}
	</preparedstatement>
	
	<preparedstatement name="insertTempDatasetGraph" inputs="+Long id" results="COUNTER" templateParams="String sessionPrefix">
	    INSERT INTO {0}TEMPGRAPHS VALUES (?)
	</preparedstatement>
	
	<preparedstatement name="insertAllNamedGraphs" results="COUNTER" templateParams="String sessionPrefix,String insertTable">
		<![CDATA[ 	
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT NG.ID FROM NAMEDGRAPHS NG WHERE (COMMITTED=0 AND HEND IS NULL) OR (COMMITTED<0 AND HEND IS NOT NULL)
		UNION
		SELECT DISTINCT NG.ID FROM NAMEDGRAPHS_NR NG WHERE COMMITTED<=0
		]]>
	</preparedstatement>
	
	<preparedstatement name="insertAllMetadataGraphs" results="COUNTER" templateParams="String sessionPrefix,String insertTable">
		<![CDATA[ 	
		INSERT INTO {0}{1} (ID)
		SELECT DISTINCT NG.METAID FROM NAMEDGRAPHS NG WHERE (COMMITTED=0 AND HEND IS NULL) OR (COMMITTED<0 AND HEND IS NOT NULL)
		UNION
		SELECT DISTINCT NG.METAID FROM NAMEDGRAPHS_NR NG WHERE COMMITTED<=0
		]]>
	</preparedstatement>
	
	<preparedstatement name="countRows" outputs="+Integer count" results="VALUE" templateParams="String sessionPrefix,String tableName">
		SELECT COUNT(1) FROM {0}{1}
	</preparedstatement>
	
	<preparedstatement name="containsRevisionedGraph" inputs="+Long id" outputs="+Integer count" results="VALUE" templateParams="String sessionPrefix,String tableName">
		<![CDATA[ 	
		SELECT COUNT(1) FROM {0}{1} TG,NAMEDGRAPHS NG WHERE TG.ID = ? and (TG.ID=NG.METAID OR TG.ID=NG.ID) AND ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0))
		]]>
	</preparedstatement>
	
	<preparedstatement name="containsNonRevisionedGraph" inputs="+Long id" outputs="+Integer count" results="VALUE" templateParams="String sessionPrefix,String tableName">
		<![CDATA[ 	
		SELECT COUNT(1) FROM {0}{1} TG,NAMEDGRAPHS_NR NG WHERE TG.ID = ? and (TG.ID=NG.METAID OR TG.ID=NG.ID) AND COMMITTED <=0
		]]>
	</preparedstatement>

	<preparedstatement name="datasetPartContainsGraph" inputs="+Long id" outputs="+Integer count" results="VALUE" templateParams="String sessionPrefix,String tableName">
		SELECT COUNT(1) FROM {0}{1} WHERE ID = ?
	</preparedstatement>
	
	<preparedstatement name="selectNamedGraphs" outputs="Long id" results="ITERATOR"   templateParams="String tableName,String sessionPrefix">
		<![CDATA[ 
		SELECT {1}{0}.ID FROM {1}{0} WHERE {1}{0}.ID IN 
		(SELECT NG.ID FROM NAMEDGRAPHS NG ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0)))
		]]>
	</preparedstatement>
	
	<preparedstatement name="selectMetadataGraphs" outputs="Long id" results="ITERATOR"   templateParams="String tableName,String sessionPrefix">
		<![CDATA[ 
		SELECT {1}{0}.ID FROM {1}{0} WHERE {1}{0}.ID IN 
		(SELECT NG.METAID FROM NAMEDGRAPHS NG ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0)))
		]]>
	</preparedstatement>
	
	<preparedstatement name="countValidRevisionedGraphs" outputs="+Long count" results="VALUE"   templateParams="String tableName,String sessionPrefix">
		<![CDATA[ 
		SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS(SELECT {1}{0}.ID FROM {1}{0},NAMEDGRAPHS NG WHERE (NG.ID ={1}{0}.ID OR NG.METAID={1}{0}.ID) AND ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0)))
		]]>
	</preparedstatement>
	
	<preparedstatement name="countValidNonRevisionedGraphs" outputs="+Long count" results="VALUE"   templateParams="String tableName,String sessionPrefix">
		<![CDATA[ 
		SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS (SELECT {1}{0}.ID FROM {1}{0},NAMEDGRAPHS_NR NG WHERE (NG.ID ={1}{0}.ID OR NG.METAID={1}{0}.ID) AND NG.COMMITTED<=0)
		]]>
	</preparedstatement>
	
	<preparedstatement name="countValidRevisionedGraphsInSet" inputs="Long dsId" outputs="+Long count" results="VALUE" >
		<![CDATA[ 
	       SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS(	
	           SELECT NG.ID FROM QUERY_GRAPHS,NAMEDGRAPHS NG WHERE QUERY_GRAPHS.DSID=? AND (NG.ID =QUERY_GRAPHS.ID OR NG.METAID=QUERY_GRAPHS.ID) AND ((NG.HEND IS NULL AND NG.COMMITTED=0) OR(NG.HEND IS NOT NULL AND NG.COMMITTED <0))
            )
		]]>
	</preparedstatement>
	
	<preparedstatement name="countValidNonRevisionedGraphsInSet"  inputs="Long dsId" outputs="+Long count" results="VALUE">
		<![CDATA[ 
		SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS(	
	       SELECT NG.ID FROM QUERY_GRAPHS,NAMEDGRAPHS_NR NG WHERE QUERY_GRAPHS.DSID=? AND (NG.ID =QUERY_GRAPHS.ID OR NG.METAID=QUERY_GRAPHS.ID) AND NG.COMMITTED <=0
        )
		]]>
	</preparedstatement>
	
	<preparedstatement name="selectUntimelyGraphs" outputs="Long id" results="ITERATOR" inputs="Long lastTransactionTime1, Long lastTransactionTime2"  templateParams="String sessionPrefix,String tempgraph1,String tempgraph2">
		SELECT TMP1.ID FROM {0}{1} TMP1 LEFT JOIN
		(SELECT NG.ID
		FROM NAMEDGRAPHS NG, {0}{2} TMP2
		WHERE
			NG.ID = TMP2.ID AND
			? >= NG.HSTART AND
			(NG.HEND IS NULL OR ? &lt; NG.HEND)
		)AS TMP2 ON TMP1.ID=TMP2.ID WHERE TMP2.ID IS NULL
	</preparedstatement>

	<preparedstatement name="selectUntimelyMetadataGraphs" outputs="Long id" results="ITERATOR" inputs="Long lastTransactionTime1, Long lastTransactionTime2"  templateParams="String sessionPrefix,String tempgraph1,String tempgraph2">
		SELECT TMP1.ID FROM {0}{1} TMP1 LEFT JOIN
		(SELECT DISTINCT NG.METAID
		FROM NAMEDGRAPHS NG, {0}{2} TMP2
		WHERE
			NG.METAID = TMP2.ID AND
			? >= NG.HSTART AND
			(NG.HEND IS NULL OR ? &lt; NG.HEND)
		)AS TMP2 ON TMP1.ID=TMP2.METAID WHERE TMP2.METAID IS NULL
	</preparedstatement>
	
	<preparedstatement name="selectGraphs" outputs="Long graph" results="ITERATOR" templateParams="String sessionPrefix,String tempTable">
		SELECT TG.ID AS GRAPH			   
		FROM {0}{1} TG
	</preparedstatement>
	
	<preparedstatement name="insertIdToTempTable"  results="COUNTER" inputs="+Long id"	templateParams="String sessionPrefix, String insertTable">
		INSERT INTO {0}{1} (ID) VALUES(?)
	</preparedstatement>
</preparedstatements>