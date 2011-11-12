<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/common/xmlsql/Glitter.sql,v $
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
	<!-- -->
		<preparedstatement name="insertGraphIfValid" inputs="+Long graphId" results="COUNTER"
		templateParams="String sessionPrefix, String insertTable, String containerName">
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT S.SUBJECT FROM {2}_S S
		WHERE S.METADATA = 1
		  AND S.SUBJECT = ?
	</preparedstatement>

	<preparedstatement name="insertAllValidGraphs" results="COUNTER"
		inputs="+Long ngDatasetId, +Long ngDatasetMetadataId, +Long mgDatasetId, +Long mgDatasetMetadataId"
		templateParams="String sessionPrefix, String insertTable, String containerName">
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT S.SUBJECT FROM {2}_S S
		WHERE S.METADATA = 1
		  AND S.SUBJECT NOT IN (?,?,?,?)
	</preparedstatement>

	<preparedstatement name="insertAllValidNamedGraphs" inputs="+Long rdfTypeId, +Long anzotypesNamedGraphId, +Long ngDatasetId, +Long mgDatasetId" results="COUNTER"
		templateParams="String sessionPrefix, String insertTable, String containerName">
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT S.SUBJECT FROM {2}_S S
		WHERE S.METADATA = 1
		  AND S.PREDICATE = ?
		  AND S.OBJECT = ?
		  AND S.SUBJECT NOT IN (?,?)
	</preparedstatement>

	<preparedstatement name="insertAllValidMetadataGraphs" inputs="+Long hasMetadataGraphId, +Long ngDatasetMetadataId, +Long mgDatasetMetadataId" results="COUNTER"
		templateParams="String sessionPrefix, String insertTable, String containerName">
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT S.OBJECT FROM {2}_S S
		WHERE S.METADATA = 1
		  AND S.PREDICATE = ?
		  AND S.OBJECT NOT IN (?,?)
	</preparedstatement>

	<preparedstatement name="insertValidDatasetGraphs" inputs="+Long datasetId, +Long datasetIdRepeated, +Long datasetGraphPropertyId" results="COUNTER"
		templateParams="String sessionPrefix, String insertTable, String containerName">
		INSERT INTO {0}{1} (ID) 
		SELECT DISTINCT DS.OBJECT FROM {2}_S DS
		WHERE DS.NAMEDGRAPHID = ?
		  AND DS.SUBJECT = ? 
		  AND DS.PREDICATE = ?
	</preparedstatement>
	
	<preparedstatement name="copyDistinctDatasetIds" results="COUNTER" templateParams="String sessionPrefix, String sourceTable, String destinationTable" >
		INSERT INTO {0}{2} SELECT DISTINCT ID FROM {0}{1}
	</preparedstatement>
	
	<preparedstatement name="insertQueryStatement" inputs="+Long ngId,+Long subjId,+Long propId,+Long objId"  results="COUNTER" templateParams="String sessionPrefix" >
	    INSERT INTO {0}QUERY(NAMEDGRAPHID,SUBJ,PROP,OBJ) VALUES (?,?,?,?)
	</preparedstatement>
	
	<preparedstatement name="insertTempDatasetGraph" inputs="+Long id"  results="COUNTER" templateParams="String sessionPrefix,String tempGraphTable" >
	    INSERT INTO {0}{1} VALUES (?,?)
	</preparedstatement>
	
	<preparedstatement name="insertAllNamedGraphs"  results="COUNTER" templateParams="String sessionPrefix,String tempGraphTable,String statementsTable">
		INSERT INTO {0}{1} SELECT DISTINCT NAMEDGRAPHID FROM {2} WHERE METADATA=0
	</preparedstatement>
	
	<preparedstatement name="insertAllMetadataGraphs"  results="COUNTER" templateParams="String sessionPrefix,String tempGraphTable,String statementsTable">
		INSERT INTO {0}{1} SELECT DISTINCT NAMEDGRAPHID FROM {2} WHERE METADATA=1
	</preparedstatement>
	
	<preparedstatement name="insertAllGraphs"  results="COUNTER" templateParams="String sessionPrefix,String tempGraphTable,String statementsTable">
		INSERT INTO {0}{1} SELECT DISTINCT NAMEDGRAPHID FROM {2}
	</preparedstatement>
	
	<preparedstatement name="countRows" outputs="+Integer count" results="VALUE" templateParams="String sessionPrefix,String tempGraphTable">
		SELECT COUNT(1) FROM {0}{1}
	</preparedstatement>
	
	<preparedstatement name="selectInferedInference" outputs="String prop,String obj,String objInfer" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		SELECT (SELECT VALUE FROM {2}_U WHERE {2}_U.ID=PROP) AS PROP,
			   (SELECT VALUE FROM {2}_U WHERE {2}_U.ID=OBJ) AS OBJ,
			   (SELECT VALUE FROM {2}_U WHERE {2}_U.ID=OBJINFER) AS OBJINFER
		FROM {0}{1}
	</preparedstatement>

	<preparedstatement name="countInferedProperty" inputs="+Long ontId,+Long propId,+Long inferedPropId" outputs="+Long count" results="VALUE" templateParams="String containerName">
		SELECT COUNT(1) FROM {0}_PROP_INFER WHERE ONT=? AND PROP=? AND PROPINFER=?
	</preparedstatement>
	
	<preparedstatement name="countInferedObject" inputs="+Long ontId,+Long propId,+Long objId,+Long inferedObjId" outputs="+Long count" results="VALUE" templateParams="String containerName">
		SELECT COUNT(1) FROM {0}_OBJ_INFER WHERE ONT=? AND PROP=? AND OBJ=? AND OBJINFER=?
	</preparedstatement>
	
	<preparedstatement name="insertInferedProperty" inputs="+Long ontId,+Long propId,+Long inferedPropId" results="COUNTER" templateParams="String containerName">
		INSERT INTO {0}_PROP_INFER(ONT,PROP,PROPINFER) VALUES(?,?,?)
	</preparedstatement>
	
	<preparedstatement name="insertInferedObject" inputs="+Long ontId,+Long propId,+Long objId,+Long inferedObjId" results="COUNTER" templateParams="String containerName">
		INSERT INTO {0}_OBJ_INFER(ONT,PROP,OBJ,OBJINFER) VALUES(?,?,?,?)
	</preparedstatement>
	
	<preparedstatement name="deleteInferedProperty" inputs="+Long ontId,+Long propId,+Long inferedPropId" results="COUNTER" templateParams="String containerName">
		DELETE FROM {0}_PROP_INFER WHERE ONT=? AND PROP=? AND PROPINFER=?
	</preparedstatement>
	
	<preparedstatement name="deleteInferedObject" inputs="+Long ontId,+Long propId,+Long objId,+Long inferedObjId" results="COUNTER" templateParams="String containerName">
		DELETE FROM {0}_OBJ_INFER WHERE ONT=? AND PROP=? AND OBJ=? AND OBJINFER=?
	</preparedstatement>
	
	
	<preparedstatement name="deleteOntologiesInferedProperties" inputs="+Long ontId" results="COUNTER" templateParams="String containerName">
		DELETE FROM {0}_PROP_INFER WHERE ONT=?
	</preparedstatement>
	
	
	<preparedstatement name="deleteOntologiesInferedObjects" inputs="+Long ontId" results="COUNTER" templateParams="String containerName">
		DELETE FROM {0}_OBJ_INFER ONT=?
	</preparedstatement>
	
	
	<preparedstatement name="selectGraphs" outputs="Long graph" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		SELECT TG.ID AS GRAPH			   
		FROM {0}{1} TG
	</preparedstatement>
	
	<!--	Insert fully expaned inferred properties from  prop_infer-->
	<preparedstatement name="preparePropInfer_0" inputs="+Long ontId," results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,PROPINFER)
		WITH TEMPTAB(ONT,PROP,PROPINFER) AS 
		(		SELECT ONT,PROP,PROPINFER 
				FROM {2}_PROP_INFER INFER 
				WHERE INFER.ONT=?
		UNION ALL 
			SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER 
			FROM {2}_PROP_INFER SUB, TEMPTAB SUPER 
			WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP 
		) 
		SELECT DISTINCT ONT,PROP,PROPINFER FROM TEMPTAB
	</preparedstatement>
	
	<preparedstatement name="preparePropInfer_0_NO_WITH_0" inputs="+Long ontId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) SELECT ONT,PROP,PROPINFER FROM {2}_PROP_INFER INFER WHERE INFER.ONT=?
	</preparedstatement>

	<preparedstatement name="preparePropInfer_0_NO_WITH_1" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempTable2,String tempTable3,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) 
		SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER 
		FROM {4}_PROP_INFER SUB, {0}{2} SUPER WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP AND 
		NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUPER.ONT AND PROP=SUB.PROP AND PROPINFER=SUPER.PROPINFER)
	</preparedstatement>
	
	<!--	Insert fully expaned inferred properties from  prop_infer for given property-->
	<preparedstatement name="preparePropInferP_0" inputs="+Long ontId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,PROPINFER)
		WITH TEMPTAB(ONT,PROP,PROPINFER) AS 
		(		SELECT ONT,PROP,PROPINFER 
				FROM {2}_PROP_INFER INFER 
				WHERE INFER.ONT=? AND INFER.PROPINFER=?
		UNION ALL 
			SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER 
			FROM {2}_PROP_INFER SUB, TEMPTAB SUPER 
			WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP 
		) 
		SELECT DISTINCT ONT,PROP,PROPINFER FROM TEMPTAB
	</preparedstatement>
	
	<preparedstatement name="preparePropInferP_0_NO_WITH_0" inputs="+Long ontId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) SELECT ONT,PROP,PROPINFER FROM {2}_PROP_INFER INFER WHERE INFER.ONT=? AND INFER.PROPINFER=?
	</preparedstatement>

	<preparedstatement name="preparePropInferP_0_NO_WITH_1" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempTable2,String tempTable3,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) 
		SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER 
		FROM {4}_PROP_INFER SUB, {0}{2} SUPER WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP AND 
		NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUPER.ONT AND PROP=SUB.PROP AND PROPINFER=SUPER.PROPINFER)
	</preparedstatement>

	<!--	Insert fully expaned inferred objects from  obj_infer for given object
			This expands the hierarchy of object_infer based on object->objectInfer
	-->
	
	<preparedstatement name="prepareObjectInferO_0" inputs="+Long ontId,+Long objectId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 
		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS 
		(		SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER
				FROM {2}_OBJ_INFER INFER 
				WHERE INFER.ONT=? AND INFER.OBJINFER=?
		UNION ALL 
			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER
			FROM {2}_OBJ_INFER SUB, TEMPTAB SUPER 
			WHERE  SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUPER.OBJ = SUB.OBJINFER 
		) 
		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ
	</preparedstatement>		
	
	<preparedstatement name="prepareObjectInferO_0_NO_WITH_0" inputs="+Long ontId,+Long objectId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 
				SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER
				FROM {2}_OBJ_INFER INFER 
				WHERE INFER.ONT=? AND INFER.OBJINFER=?		
	</preparedstatement>	
	
	<preparedstatement name="prepareObjectInferO_0_NO_WITH_1" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempTable2,String tempTable3,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 
			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER
			FROM {4}_OBJ_INFER SUB, {0}{2} SUPER 
			WHERE SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUPER.OBJ = SUB.OBJINFER AND
			NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUB.ONT AND PROP=SUB.PROP AND OBJ=SUB.OBJ AND OBJINFER=SUPER.OBJINFER)
	</preparedstatement>	
	
	<!--	Insert fully expaned inferred objects from  obj_infer for given object
			This expands the hierarchy of object_infer based on prop_infer expansion
	-->
	<preparedstatement name="prepareObjectInferO_1" inputs="+Long ontId,+Long objectId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">	
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)
		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS 
		(		SELECT PI.ONT,PI.PROP,OI.OBJ,OI.OBJINFER 
				FROM {0}{1} OI,{2}_PROP_INFER PI 
				WHERE PI.PROPINFER=OI.PROP AND OI.ONT=? AND PI.ONT=OI.ONT AND OI.OBJINFER=?
			UNION ALL 
				SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER
				FROM {2}_PROP_INFER PI_SUB,TEMPTAB SUPER 
				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER
		) 
		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ
	</preparedstatement>
	
	<preparedstatement name="prepareObjectInferO_1_NO_WITH_0" inputs="+Long ontId,+Long objectId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">	
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 
				SELECT PI.ONT,PI.PROPINFER,OI.OBJ,OI.OBJINFER 
				FROM {2}_OBJ_INFER OI,{2}_PROP_INFER PI 
				WHERE PI.PROP=OI.PROP AND OI.ONT=? AND OI.OBJINFER=?			
	</preparedstatement>
	
	<preparedstatement name="prepareObjectInferO_1_NO_WITH_1"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempTable2,String tempTable3,String containerName">	
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 
			SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER 
				FROM {2}_PROP_INFER PI_SUB,{0}{2} SUPER 
				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER AND
			NOT EXISTS(SELECT * FROM {0}{3} WHERE PROP=PI_SUB.PROP AND ONT=SUPER.ONT AND OBJ=SUPER.OBJ AND OBJINFER=SUPER.OBJINFER)
	</preparedstatement>
	
	<!--	Insert fully expaned inferred objects from  obj_infer for given object and property
			This expands the hierarchy of object_infer based on object->objectInfer
	-->
	<preparedstatement name="prepareObjectInferPO_0" inputs="+Long ontId,+Long propId,+Long objectId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)
		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS 
		(		
			SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER
			FROM {2}_OBJ_INFER INFER  
			WHERE INFER.ONT=? AND INFER.PROP=? AND INFER.OBJINFER=?
			UNION ALL 
			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER
			FROM {2}_OBJ_INFER SUB, TEMPTAB SUPER 
			WHERE SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUB.OBJINFER = SUPER.OBJ 
		) 
		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ
	</preparedstatement>	
	
	<preparedstatement name="prepareObjectInferPO_0_NO_WITH_0" inputs="+Long ontId,+Long propId,+Long objectId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)
				SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER
				FROM {2}_OBJ_INFER INFER  
				WHERE INFER.ONT=? AND INFER.PROP=? AND INFER.OBJINFER=?		
	</preparedstatement>	
	
	<preparedstatement name="prepareObjectInferPO_0_NO_WITH_1" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempTable3,String tempTable2,String containerName">
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)
			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER
			FROM {4}_OBJ_INFER SUB, {0}{2} SUPER 
			WHERE SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUB.OBJINFER = SUPER.OBJ AND
			NOT EXISTS(SELECT * FROM {0}{3} SUB2 WHERE SUB2.ONT=SUB.ONT AND SUB2.PROP=SUB.PROP AND SUB2.OBJ=SUB.OBJ AND SUB2.OBJINFER=SUPER.OBJINFER)
		
	</preparedstatement>	
	
	<!--	Insert fully expaned inferred objects from  obj_infer for given object and property
			This expands the hierarchy of object_infer based on prop_infer expansion
	-->
	<preparedstatement name="prepareObjectInferPO_1" inputs="+Long ontId,+Long propId,+Long objectId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">	
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)
		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS 
		(		SELECT PI.ONT,PI.PROP,OI.OBJ,OI.OBJINFER 
				FROM {0}{1} OI,{2}_PROP_INFER PI 
				WHERE PI.PROPINFER=OI.PROP AND OI.ONT=? AND PI.ONT=OI.ONT AND PI.PROPINFER=? AND OI.OBJINFER=?
			UNION ALL 
				SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER
				FROM {2}_PROP_INFER PI_SUB,TEMPTAB SUPER 
				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER
		) 
		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ
	</preparedstatement>
	
	<preparedstatement name="prepareObjectInferPO_1_NO_WITH_0" inputs="+Long ontId,+Long propId,+Long objectId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">	
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)
				SELECT PI.ONT,PI.PROPINFER,OI.OBJ,OI.OBJINFER 
				FROM {2}_OBJ_INFER OI,{2}_PROP_INFER PI 
				WHERE PI.PROP=OI.PROP AND OI.ONT=? AND OI.PROP=? AND OI.OBJINFER=?			
	</preparedstatement>
	
	<preparedstatement name="prepareObjectInferPO_1_NO_WITH_1" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempTable2,String tempTable3,String containerName">	
		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)
				SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER 
				FROM {2}_PROP_INFER PI_SUB,{0}{2} SUPER 
				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER
				NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUPER.ONT AND PROP=PI_SUB.PROP AND OBJ=SUPER.OBJ AND OBJINFER=SUPER.OBJINFER)
		
	</preparedstatement>
	
	<preparedstatement name="insertFindNP" inputs="+Long namedGraphId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.NAMEDGRAPHID=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP
	</preparedstatement>
	
	<preparedstatement name="insertFindP" inputs="+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE INFER.PROPINFER=? AND S.PROP=INFER.PROP
	</preparedstatement>
	
	<preparedstatement name="insertFindPMETA" inputs="+Integer meta,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.METADATA=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP
	</preparedstatement>
	
	<preparedstatement name="insertFindNSP" inputs="+Long namedGraphId,+Long subjId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP
	</preparedstatement>
	
	<preparedstatement name="insertFindSP" inputs="+Long subjId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.SUBJ=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP
	</preparedstatement>
	
	<preparedstatement name="insertFindSPMETA" inputs="+Integer meta,+Long subjId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.METADATA=? AND S.SUBJ=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP
	</preparedstatement>
	
	<preparedstatement name="insertFindNO" inputs="+Long namedGraphId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ)
		SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,QUERY.OBJ  FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	
	</preparedstatement>
	
	<preparedstatement name="insertFindO" inputs="+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE  INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	
	</preparedstatement>
	
	<preparedstatement name="insertFindOMETA" inputs="+Integer meta,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE  S.METADATA=? AND INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	
	</preparedstatement>
	
	<preparedstatement name="insertFindNSO" inputs="+Long namedGraphId,+Long subjId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	
	</preparedstatement>
	
	<preparedstatement name="insertFindSO" inputs="+Long subjId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE S.SUBJ=? AND INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	
	</preparedstatement>

	<preparedstatement name="insertFindSOMETA" inputs="+Integer meta,+Long subjId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE S.METADATA=? AND S.SUBJ=? AND INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	
	</preparedstatement>
	
	<preparedstatement name="insertFindNPO_O" inputs="+Long namedGraphId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) 
		SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.PROP=S.PROP AND QUERY.OBJ=INFER.OBJINFER
	</preparedstatement>
	
	<preparedstatement name="insertFindNPO_P" inputs="+Long namedGraphId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ AND QUERY.PROP=INFER.PROPINFER
	</preparedstatement>
	
	<preparedstatement name="insertFindPO_O"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.PROP=INFER.PROP A AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER
	</preparedstatement>
	
	<preparedstatement name="insertFindPO_OMETA" inputs="+Integer meta" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.METADATA=? AND S.PROP=INFER.PROP A AND S.OBJ=INFER.OBJ AND QUERY.PROP=SUBJ.PROP
	</preparedstatement>
	
	
	<preparedstatement name="insertFindPO_P" inputs="+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {2}_S S,{0}{2}  INFER WHERE S.PROP=INFER.PROP AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="insertFindPO_PMETA" inputs="+Integer meta,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {2}_S S,{0}{2}  INFER WHERE S.METADATA=? AND S.PROP=INFER.PROP AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insertFindNSPO_O" inputs="+Long namedGraphId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND S.SUBJ=QUERY.SUBJ AND  S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ
	</preparedstatement>
	
	<preparedstatement name="insertFindSPO_O"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE  S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ
	</preparedstatement>
	
	<preparedstatement name="insertFindSPO_OMETA" inputs="+Integer meta" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.METADATA=? AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ
	</preparedstatement>
	
	<preparedstatement name="insertFindNSPO_P"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,QUERY.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=QUERY.NAMEDGRAPHID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ
	</preparedstatement>
	
	<preparedstatement name="insertFindSPO_P"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY  WHERE S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ
	</preparedstatement>
	
	<preparedstatement name="insertFindSPO_PMETA" inputs="+Integer meta" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.METADATA=? AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ
	</preparedstatement>
	
	<preparedstatement name="insertFindMP"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND S.NAMEDGRAPHID=GRAPHS.ID  AND S.PROP=INFER.PROP
	</preparedstatement>

	<preparedstatement name="insertFindMSP" inputs="+Long subjId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP
	</preparedstatement>
	
	<preparedstatement name="insertFindMO"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND INFER.PROP=S.PROP AND  S.OBJ=INFER.OBJ	
	</preparedstatement>
	
	<preparedstatement name="insertFindMSO"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	
	</preparedstatement>
	
	<preparedstatement name="insertFindMPO_O"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ
	</preparedstatement>
	
	<preparedstatement name="insertFindMPO_P" inputs="+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="insertFindMSPO_O"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ
	</preparedstatement>
	
	<preparedstatement name="insertFindMSPO_P" inputs="+Long subjId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insertFindMPMETA" inputs="+Integer meta" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP
	</preparedstatement>

	<preparedstatement name="insertFindMSPMETA" inputs="+Integer meta,+Long subjId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP
	</preparedstatement>
	
	<preparedstatement name="insertFindMOMETA" inputs="+Integer meta" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	AND QUERY.OBJ=INFER.OBJINFER
	</preparedstatement>
	
	<preparedstatement name="insertFindMSOMETA" inputs="+Integer meta" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER	
	</preparedstatement>
	
	<preparedstatement name="insertFindMPO_OMETA" inputs="+Integer meta" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER
	</preparedstatement>
	
	<preparedstatement name="insertFindMPO_PMETA" inputs="+Integer meta,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="insertFindMSPO_OMETA" inputs="+Integer meta" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER
	</preparedstatement>
	
	<preparedstatement name="insertFindMSPO_PMETA" inputs="+Integer meta,+Long subjId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String graphTempTable">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="selectS" outputs="+Long namedgraphId,+Long subjId,+Long propId,+Long objId" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String tempInferName,String containerName,String tempInferName2,String tempInferName3,String tempInferName4">
	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1}
	 UNION
	 SELECT DISTINCT S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {0}{4} S,{3}_OBJ_INFER INFER WHERE S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ
	 UNION
	 SELECT DISTINCT S2.NAMEDGRAPHID,S2.SUBJ,PI.PROPINFER,OI.OBJINFER FROM {0}{5} S2,{3}_OBJ_INFER OI,{3}_PROP_INFER PI WHERE S2.PROP=PI.PROP AND S2.OBJ=OI.OBJ AND PI.PROPINFER=OI.PROP
	 UNION
	 SELECT DISTINCT S3.NAMEDGRAPHID,S3.SUBJ,INFER.PROPINFER,S3.OBJ FROM {0}{6} S3,{0}{2} INFER WHERE S3.PROP=INFER.PROP;
	</preparedstatement>
	
	<preparedstatement name="selectP" outputs="+Long namedgraphId,+Long subjId,+Long propId,+Long objId" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String tempTable2,String containerName">
	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1}
	 UNION
	 SELECT DISTINCT S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {0}{2} S,{3}_OBJ_INFER INFER WHERE S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ
	</preparedstatement>
	
	<preparedstatement name="selectO" outputs="+Long namedgraphId,+Long subjId,+Long propId,+Long objId" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String tempTable2,String tempInferTable,String containerName">
	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1}
	 UNION
	 SELECT DISTINCT S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {0}{2} S,{0}{3} INFER WHERE S.PROP=INFER.PROP;
	</preparedstatement>
		
	<preparedstatement name="selectAll" outputs="+Long namedgraphId,+Long subjId,+Long propId,+Long objId" results="ITERATOR" templateParams="String sessionPrefix,String tempTable">
	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1}
	</preparedstatement>
	
	<preparedstatement name="insert0" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S
	</preparedstatement>
	
	<preparedstatement name="insert0META" inputs="+Integer meta" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=?
	</preparedstatement>
		
	<preparedstatement name="insert1" inputs="+Long namedgraphId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=?
	</preparedstatement>

	<preparedstatement name="insert1M"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND  S.NAMEDGRAPHID=G.ID
	</preparedstatement>
	
	<preparedstatement name="insert1MMETA"  results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID
	</preparedstatement>
	
	<preparedstatement name="insert2" inputs="+Long subjId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert2META" inputs="+Integer meta,+Long subjId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert3" inputs="+Long namedgraphId,+Long subjId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert3M" inputs="+Long subjId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=?
	</preparedstatement>
	
		<preparedstatement name="insert3MMETA" inputs="+Integer meta,+Long subjId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert4" inputs="+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="insert4META" inputs="+Integer meta,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="insert5" inputs="+Long namedgraphId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=?
	</preparedstatement>

	<preparedstatement name="insert5M" inputs="+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="insert5MMETA" inputs="+Integer meta,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=?
	</preparedstatement>

	<preparedstatement name="insert6" inputs="+Long subjId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="insert6META" inputs="+Integer meta,+Long subjId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="insert7" inputs="+Long namedgraphId,+Long subjId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=?
	</preparedstatement>

	<preparedstatement name="insert7M" inputs="+Long subjId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=?
	</preparedstatement>

	<preparedstatement name="insert7MMETA" inputs="+Integer meta,+Long subjId,+Long propId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="insert8" inputs="+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert8META" inputs="+Integer meta,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert9" inputs="+Long namedgraphId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="insert9M" inputs="+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert9MMETA" inputs="+Integer meta,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE  S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="insert10" inputs="+Long subjId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert10META" inputs="+Integer meta,+Long subjId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert11" inputs="+Long namedgraphId,+Long subjId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert11M" inputs="+Long subjId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert11MMETA" inputs="+Integer meta,+Long subjId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert12" inputs="+Long propId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert12META" inputs="+Integer meta,+Long propId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert13" inputs="+Long namedgraphId,+Long propId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="insert13M" inputs="+Long propId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert13MMETA" inputs="+Integer meta,+Long propId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="insert14" inputs="+Long subjId,+Long propId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert14META" inputs="+Integer meta,+Long subjId,+Long propId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert15" inputs="+Long namedgraphId,+Long subjId,+Long propId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert15M" inputs="+Long subjId,+Long propId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insert15MMETA" inputs="+Integer meta,+Long subjId,+Long propId,+Long objId" results="COUNTER" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	
	<preparedstatement name="select0" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S
	</preparedstatement>
	
	<preparedstatement name="select0META" inputs="+Integer meta" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=?
	</preparedstatement>
		
	<preparedstatement name="select1" inputs="+Long namedgraphId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=?
	</preparedstatement>

	<preparedstatement name="select1M"  outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID
	</preparedstatement>
	
	<preparedstatement name="select1MMETA"  outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID
	</preparedstatement>
	
	<preparedstatement name="select2" inputs="+Long subjId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=?
	</preparedstatement>
	
	<preparedstatement name="select2META" inputs="+Integer meta,+Long subjId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=?
	</preparedstatement>
	
	<preparedstatement name="select3" inputs="+Long namedgraphId,+Long subjId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=?
	</preparedstatement>
	
	<preparedstatement name="select3M" inputs="+Long subjId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=?
	</preparedstatement>
	
		<preparedstatement name="select3MMETA" inputs="+Integer meta,+Long subjId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=?
	</preparedstatement>
	
	<preparedstatement name="select4" inputs="+Long propId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="select4META" inputs="+Integer meta,+Long propId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="select5" inputs="+Long namedgraphId,+Long propId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=?
	</preparedstatement>

	<preparedstatement name="select5M" inputs="+Long propId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="select5MMETA" inputs="+Integer meta,+Long propId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=?
	</preparedstatement>

	<preparedstatement name="select6" inputs="+Long subjId,+Long propId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="select6META" inputs="+Integer meta,+Long subjId,+Long propId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="select7" inputs="+Long namedgraphId,+Long subjId,+Long propId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=?
	</preparedstatement>

	<preparedstatement name="select7M" inputs="+Long subjId,+Long propId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=?
	</preparedstatement>

	<preparedstatement name="select7MMETA" inputs="+Integer meta,+Long subjId,+Long propId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=?
	</preparedstatement>
	
	<preparedstatement name="select8" inputs="+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select8META" inputs="+Integer meta,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select9" inputs="+Long namedgraphId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="select9M" inputs="+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select9MMETA" inputs="+Integer meta,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE  S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="select10" inputs="+Long subjId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select10META" inputs="+Integer meta,+Long subjId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select11" inputs="+Long namedgraphId,+Long subjId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select11M" inputs="+Long subjId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select11MMETA" inputs="+Integer meta,+Long subjId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select12" inputs="+Long propId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select12META" inputs="+Integer meta,+Long propId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select13" inputs="+Long namedgraphId,+Long propId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="select13M" inputs="+Long propId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select13MMETA" inputs="+Integer meta,+Long propId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>

	<preparedstatement name="select14" inputs="+Long subjId,+Long propId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select14META" inputs="+Integer meta,+Long subjId,+Long propId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select15" inputs="+Long namedgraphId,+Long subjId,+Long propId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select15M" inputs="+Long subjId,+Long propId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="select15MMETA" inputs="+Integer meta,+Long subjId,+Long propId,+Long objId" outputs="+Integer metadata,+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix,String tempTable,String containerName,String graphTableName">
		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=?
	</preparedstatement>
	
	<preparedstatement name="insertIdToTempTable"  results="COUNTER" inputs="+Long id"	templateParams="String sessionPrefix, String insertTable">
		INSERT INTO {0}{1} (ID) VALUES(?)
	</preparedstatement>
	
</preparedstatements>