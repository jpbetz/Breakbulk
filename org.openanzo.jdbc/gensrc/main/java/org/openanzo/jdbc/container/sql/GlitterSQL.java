/*******************************************************************************
 * Copyright (c) 2004, 2007-2009 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *	   Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.container.sql;
// allow for all types that can be returned from a resultset

/**
 *	GlitterSQL provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class GlitterSQL {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(GlitterSQL.class);
	static final long CUTOFF=5;

	/**
	  *Constant "insertGraphIfValid" used to reference prepared statement  Glitter.insertGraphIfValid
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2}_S S 		WHERE S.METADATA = 1 		  AND S.SUBJECT = ? 	
	  * </code>
	  */
	public static final String insertGraphIfValid = "Glitter.insertGraphIfValid";

	/**
	  *Constant "insertAllValidGraphs" used to reference prepared statement  Glitter.insertAllValidGraphs
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2}_S S 		WHERE S.METADATA = 1 		  AND S.SUBJECT NOT IN (?,?,?,?) 	
	  * </code>
	  */
	public static final String insertAllValidGraphs = "Glitter.insertAllValidGraphs";

	/**
	  *Constant "insertAllValidNamedGraphs" used to reference prepared statement  Glitter.insertAllValidNamedGraphs
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2}_S S 		WHERE S.METADATA = 1 		  AND S.PREDICATE = ? 		  AND S.OBJECT = ? 		  AND S.SUBJECT NOT IN (?,?) 	
	  * </code>
	  */
	public static final String insertAllValidNamedGraphs = "Glitter.insertAllValidNamedGraphs";

	/**
	  *Constant "insertAllValidMetadataGraphs" used to reference prepared statement  Glitter.insertAllValidMetadataGraphs
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.OBJECT FROM {2}_S S 		WHERE S.METADATA = 1 		  AND S.PREDICATE = ? 		  AND S.OBJECT NOT IN (?,?) 	
	  * </code>
	  */
	public static final String insertAllValidMetadataGraphs = "Glitter.insertAllValidMetadataGraphs";

	/**
	  *Constant "insertValidDatasetGraphs" used to reference prepared statement  Glitter.insertValidDatasetGraphs
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT DS.OBJECT FROM {2}_S DS 		WHERE DS.NAMEDGRAPHID = ? 		  AND DS.SUBJECT = ?  		  AND DS.PREDICATE = ? 	
	  * </code>
	  */
	public static final String insertValidDatasetGraphs = "Glitter.insertValidDatasetGraphs";

	/**
	  *Constant "copyDistinctDatasetIds" used to reference prepared statement  Glitter.copyDistinctDatasetIds
	  *
	  * <code>
	  *  		INSERT INTO {0}{2} SELECT DISTINCT ID FROM {0}{1} 	
	  * </code>
	  */
	public static final String copyDistinctDatasetIds = "Glitter.copyDistinctDatasetIds";

	/**
	  *Constant "insertQueryStatement" used to reference prepared statement  Glitter.insertQueryStatement
	  *
	  * <code>
	  *  	    INSERT INTO {0}QUERY(NAMEDGRAPHID,SUBJ,PROP,OBJ) VALUES (?,?,?,?) 	
	  * </code>
	  */
	public static final String insertQueryStatement = "Glitter.insertQueryStatement";

	/**
	  *Constant "insertTempDatasetGraph" used to reference prepared statement  Glitter.insertTempDatasetGraph
	  *
	  * <code>
	  *  	    INSERT INTO {0}{1} VALUES (?,?) 	
	  * </code>
	  */
	public static final String insertTempDatasetGraph = "Glitter.insertTempDatasetGraph";

	/**
	  *Constant "insertAllNamedGraphs" used to reference prepared statement  Glitter.insertAllNamedGraphs
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} SELECT DISTINCT NAMEDGRAPHID FROM {2} WHERE METADATA=0 	
	  * </code>
	  */
	public static final String insertAllNamedGraphs = "Glitter.insertAllNamedGraphs";

	/**
	  *Constant "insertAllMetadataGraphs" used to reference prepared statement  Glitter.insertAllMetadataGraphs
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} SELECT DISTINCT NAMEDGRAPHID FROM {2} WHERE METADATA=1 	
	  * </code>
	  */
	public static final String insertAllMetadataGraphs = "Glitter.insertAllMetadataGraphs";

	/**
	  *Constant "insertAllGraphs" used to reference prepared statement  Glitter.insertAllGraphs
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} SELECT DISTINCT NAMEDGRAPHID FROM {2} 	
	  * </code>
	  */
	public static final String insertAllGraphs = "Glitter.insertAllGraphs";

	/**
	  *Constant "countRows" used to reference prepared statement  Glitter.countRows
	  *
	  * <code>
	  *  		SELECT COUNT(1) FROM {0}{1} 	
	  * </code>
	  */
	public static final String countRows = "Glitter.countRows";

	/**
	  *Constant "selectInferedInference" used to reference prepared statement  Glitter.selectInferedInference
	  *
	  * <code>
	  *  		SELECT (SELECT VALUE FROM {2}_U WHERE {2}_U.ID=PROP) AS PROP, 			   (SELECT VALUE FROM {2}_U WHERE {2}_U.ID=OBJ) AS OBJ, 			   (SELECT VALUE FROM {2}_U WHERE {2}_U.ID=OBJINFER) AS OBJINFER 		FROM {0}{1} 	
	  * </code>
	  */
	public static final String selectInferedInference = "Glitter.selectInferedInference";

	/**
	  *Constant "countInferedProperty" used to reference prepared statement  Glitter.countInferedProperty
	  *
	  * <code>
	  *  		SELECT COUNT(1) FROM {0}_PROP_INFER WHERE ONT=? AND PROP=? AND PROPINFER=? 	
	  * </code>
	  */
	public static final String countInferedProperty = "Glitter.countInferedProperty";

	/**
	  *Constant "countInferedObject" used to reference prepared statement  Glitter.countInferedObject
	  *
	  * <code>
	  *  		SELECT COUNT(1) FROM {0}_OBJ_INFER WHERE ONT=? AND PROP=? AND OBJ=? AND OBJINFER=? 	
	  * </code>
	  */
	public static final String countInferedObject = "Glitter.countInferedObject";

	/**
	  *Constant "insertInferedProperty" used to reference prepared statement  Glitter.insertInferedProperty
	  *
	  * <code>
	  *  		INSERT INTO {0}_PROP_INFER(ONT,PROP,PROPINFER) VALUES(?,?,?) 	
	  * </code>
	  */
	public static final String insertInferedProperty = "Glitter.insertInferedProperty";

	/**
	  *Constant "insertInferedObject" used to reference prepared statement  Glitter.insertInferedObject
	  *
	  * <code>
	  *  		INSERT INTO {0}_OBJ_INFER(ONT,PROP,OBJ,OBJINFER) VALUES(?,?,?,?) 	
	  * </code>
	  */
	public static final String insertInferedObject = "Glitter.insertInferedObject";

	/**
	  *Constant "deleteInferedProperty" used to reference prepared statement  Glitter.deleteInferedProperty
	  *
	  * <code>
	  *  		DELETE FROM {0}_PROP_INFER WHERE ONT=? AND PROP=? AND PROPINFER=? 	
	  * </code>
	  */
	public static final String deleteInferedProperty = "Glitter.deleteInferedProperty";

	/**
	  *Constant "deleteInferedObject" used to reference prepared statement  Glitter.deleteInferedObject
	  *
	  * <code>
	  *  		DELETE FROM {0}_OBJ_INFER WHERE ONT=? AND PROP=? AND OBJ=? AND OBJINFER=? 	
	  * </code>
	  */
	public static final String deleteInferedObject = "Glitter.deleteInferedObject";

	/**
	  *Constant "deleteOntologiesInferedProperties" used to reference prepared statement  Glitter.deleteOntologiesInferedProperties
	  *
	  * <code>
	  *  		DELETE FROM {0}_PROP_INFER WHERE ONT=? 	
	  * </code>
	  */
	public static final String deleteOntologiesInferedProperties = "Glitter.deleteOntologiesInferedProperties";

	/**
	  *Constant "deleteOntologiesInferedObjects" used to reference prepared statement  Glitter.deleteOntologiesInferedObjects
	  *
	  * <code>
	  *  		DELETE FROM {0}_OBJ_INFER ONT=? 	
	  * </code>
	  */
	public static final String deleteOntologiesInferedObjects = "Glitter.deleteOntologiesInferedObjects";

	/**
	  *Constant "selectGraphs" used to reference prepared statement  Glitter.selectGraphs
	  *
	  * <code>
	  *  		SELECT TG.ID AS GRAPH			    		FROM {0}{1} TG 	
	  * </code>
	  */
	public static final String selectGraphs = "Glitter.selectGraphs";

	/**
	  *Constant "preparePropInfer_0" used to reference prepared statement  Glitter.preparePropInfer_0
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) 		WITH TEMPTAB(ONT,PROP,PROPINFER) AS  		(		SELECT ONT,PROP,PROPINFER  				FROM {2}_PROP_INFER INFER  				WHERE INFER.ONT=? 		UNION ALL  			SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER  			FROM {2}_PROP_INFER SUB, TEMPTAB SUPER  			WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP  		)  		SELECT DISTINCT ONT,PROP,PROPINFER FROM TEMPTAB 	
	  * </code>
	  */
	public static final String preparePropInfer_0 = "Glitter.preparePropInfer_0";

	/**
	  *Constant "preparePropInfer_0_NO_WITH_0" used to reference prepared statement  Glitter.preparePropInfer_0_NO_WITH_0
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) SELECT ONT,PROP,PROPINFER FROM {2}_PROP_INFER INFER WHERE INFER.ONT=? 	
	  * </code>
	  */
	public static final String preparePropInfer_0_NO_WITH_0 = "Glitter.preparePropInfer_0_NO_WITH_0";

	/**
	  *Constant "preparePropInfer_0_NO_WITH_1" used to reference prepared statement  Glitter.preparePropInfer_0_NO_WITH_1
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER)  		SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER  		FROM {4}_PROP_INFER SUB, {0}{2} SUPER WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP AND  		NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUPER.ONT AND PROP=SUB.PROP AND PROPINFER=SUPER.PROPINFER) 	
	  * </code>
	  */
	public static final String preparePropInfer_0_NO_WITH_1 = "Glitter.preparePropInfer_0_NO_WITH_1";

	/**
	  *Constant "preparePropInferP_0" used to reference prepared statement  Glitter.preparePropInferP_0
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) 		WITH TEMPTAB(ONT,PROP,PROPINFER) AS  		(		SELECT ONT,PROP,PROPINFER  				FROM {2}_PROP_INFER INFER  				WHERE INFER.ONT=? AND INFER.PROPINFER=? 		UNION ALL  			SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER  			FROM {2}_PROP_INFER SUB, TEMPTAB SUPER  			WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP  		)  		SELECT DISTINCT ONT,PROP,PROPINFER FROM TEMPTAB 	
	  * </code>
	  */
	public static final String preparePropInferP_0 = "Glitter.preparePropInferP_0";

	/**
	  *Constant "preparePropInferP_0_NO_WITH_0" used to reference prepared statement  Glitter.preparePropInferP_0_NO_WITH_0
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) SELECT ONT,PROP,PROPINFER FROM {2}_PROP_INFER INFER WHERE INFER.ONT=? AND INFER.PROPINFER=? 	
	  * </code>
	  */
	public static final String preparePropInferP_0_NO_WITH_0 = "Glitter.preparePropInferP_0_NO_WITH_0";

	/**
	  *Constant "preparePropInferP_0_NO_WITH_1" used to reference prepared statement  Glitter.preparePropInferP_0_NO_WITH_1
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER)  		SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER  		FROM {4}_PROP_INFER SUB, {0}{2} SUPER WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP AND  		NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUPER.ONT AND PROP=SUB.PROP AND PROPINFER=SUPER.PROPINFER) 	
	  * </code>
	  */
	public static final String preparePropInferP_0_NO_WITH_1 = "Glitter.preparePropInferP_0_NO_WITH_1";

	/**
	  *Constant "prepareObjectInferO_0" used to reference prepared statement  Glitter.prepareObjectInferO_0
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)  		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS  		(		SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER 				FROM {2}_OBJ_INFER INFER  				WHERE INFER.ONT=? AND INFER.OBJINFER=? 		UNION ALL  			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER 			FROM {2}_OBJ_INFER SUB, TEMPTAB SUPER  			WHERE  SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUPER.OBJ = SUB.OBJINFER  		)  		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ 	
	  * </code>
	  */
	public static final String prepareObjectInferO_0 = "Glitter.prepareObjectInferO_0";

	/**
	  *Constant "prepareObjectInferO_0_NO_WITH_0" used to reference prepared statement  Glitter.prepareObjectInferO_0_NO_WITH_0
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)  				SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER 				FROM {2}_OBJ_INFER INFER  				WHERE INFER.ONT=? AND INFER.OBJINFER=?		 	
	  * </code>
	  */
	public static final String prepareObjectInferO_0_NO_WITH_0 = "Glitter.prepareObjectInferO_0_NO_WITH_0";

	/**
	  *Constant "prepareObjectInferO_0_NO_WITH_1" used to reference prepared statement  Glitter.prepareObjectInferO_0_NO_WITH_1
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)  			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER 			FROM {4}_OBJ_INFER SUB, {0}{2} SUPER  			WHERE SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUPER.OBJ = SUB.OBJINFER AND 			NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUB.ONT AND PROP=SUB.PROP AND OBJ=SUB.OBJ AND OBJINFER=SUPER.OBJINFER) 	
	  * </code>
	  */
	public static final String prepareObjectInferO_0_NO_WITH_1 = "Glitter.prepareObjectInferO_0_NO_WITH_1";

	/**
	  *Constant "prepareObjectInferO_1" used to reference prepared statement  Glitter.prepareObjectInferO_1
	  *
	  * <code>
	  * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS  		(		SELECT PI.ONT,PI.PROP,OI.OBJ,OI.OBJINFER  				FROM {0}{1} OI,{2}_PROP_INFER PI  				WHERE PI.PROPINFER=OI.PROP AND OI.ONT=? AND PI.ONT=OI.ONT AND OI.OBJINFER=? 			UNION ALL  				SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER 				FROM {2}_PROP_INFER PI_SUB,TEMPTAB SUPER  				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER 		)  		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ 	
	  * </code>
	  */
	public static final String prepareObjectInferO_1 = "Glitter.prepareObjectInferO_1";

	/**
	  *Constant "prepareObjectInferO_1_NO_WITH_0" used to reference prepared statement  Glitter.prepareObjectInferO_1_NO_WITH_0
	  *
	  * <code>
	  * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)  				SELECT PI.ONT,PI.PROPINFER,OI.OBJ,OI.OBJINFER  				FROM {2}_OBJ_INFER OI,{2}_PROP_INFER PI  				WHERE PI.PROP=OI.PROP AND OI.ONT=? AND OI.OBJINFER=?			 	
	  * </code>
	  */
	public static final String prepareObjectInferO_1_NO_WITH_0 = "Glitter.prepareObjectInferO_1_NO_WITH_0";

	/**
	  *Constant "prepareObjectInferO_1_NO_WITH_1" used to reference prepared statement  Glitter.prepareObjectInferO_1_NO_WITH_1
	  *
	  * <code>
	  * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)  			SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER  				FROM {2}_PROP_INFER PI_SUB,{0}{2} SUPER  				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER AND 			NOT EXISTS(SELECT * FROM {0}{3} WHERE PROP=PI_SUB.PROP AND ONT=SUPER.ONT AND OBJ=SUPER.OBJ AND OBJINFER=SUPER.OBJINFER) 	
	  * </code>
	  */
	public static final String prepareObjectInferO_1_NO_WITH_1 = "Glitter.prepareObjectInferO_1_NO_WITH_1";

	/**
	  *Constant "prepareObjectInferPO_0" used to reference prepared statement  Glitter.prepareObjectInferPO_0
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS  		(		 			SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER 			FROM {2}_OBJ_INFER INFER   			WHERE INFER.ONT=? AND INFER.PROP=? AND INFER.OBJINFER=? 			UNION ALL  			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER 			FROM {2}_OBJ_INFER SUB, TEMPTAB SUPER  			WHERE SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUB.OBJINFER = SUPER.OBJ  		)  		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ 	
	  * </code>
	  */
	public static final String prepareObjectInferPO_0 = "Glitter.prepareObjectInferPO_0";

	/**
	  *Constant "prepareObjectInferPO_0_NO_WITH_0" used to reference prepared statement  Glitter.prepareObjectInferPO_0_NO_WITH_0
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 				SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER 				FROM {2}_OBJ_INFER INFER   				WHERE INFER.ONT=? AND INFER.PROP=? AND INFER.OBJINFER=?		 	
	  * </code>
	  */
	public static final String prepareObjectInferPO_0_NO_WITH_0 = "Glitter.prepareObjectInferPO_0_NO_WITH_0";

	/**
	  *Constant "prepareObjectInferPO_0_NO_WITH_1" used to reference prepared statement  Glitter.prepareObjectInferPO_0_NO_WITH_1
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER 			FROM {4}_OBJ_INFER SUB, {0}{2} SUPER  			WHERE SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUB.OBJINFER = SUPER.OBJ AND 			NOT EXISTS(SELECT * FROM {0}{3} SUB2 WHERE SUB2.ONT=SUB.ONT AND SUB2.PROP=SUB.PROP AND SUB2.OBJ=SUB.OBJ AND SUB2.OBJINFER=SUPER.OBJINFER) 		 	
	  * </code>
	  */
	public static final String prepareObjectInferPO_0_NO_WITH_1 = "Glitter.prepareObjectInferPO_0_NO_WITH_1";

	/**
	  *Constant "prepareObjectInferPO_1" used to reference prepared statement  Glitter.prepareObjectInferPO_1
	  *
	  * <code>
	  * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS  		(		SELECT PI.ONT,PI.PROP,OI.OBJ,OI.OBJINFER  				FROM {0}{1} OI,{2}_PROP_INFER PI  				WHERE PI.PROPINFER=OI.PROP AND OI.ONT=? AND PI.ONT=OI.ONT AND PI.PROPINFER=? AND OI.OBJINFER=? 			UNION ALL  				SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER 				FROM {2}_PROP_INFER PI_SUB,TEMPTAB SUPER  				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER 		)  		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ 	
	  * </code>
	  */
	public static final String prepareObjectInferPO_1 = "Glitter.prepareObjectInferPO_1";

	/**
	  *Constant "prepareObjectInferPO_1_NO_WITH_0" used to reference prepared statement  Glitter.prepareObjectInferPO_1_NO_WITH_0
	  *
	  * <code>
	  * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 				SELECT PI.ONT,PI.PROPINFER,OI.OBJ,OI.OBJINFER  				FROM {2}_OBJ_INFER OI,{2}_PROP_INFER PI  				WHERE PI.PROP=OI.PROP AND OI.ONT=? AND OI.PROP=? AND OI.OBJINFER=?			 	
	  * </code>
	  */
	public static final String prepareObjectInferPO_1_NO_WITH_0 = "Glitter.prepareObjectInferPO_1_NO_WITH_0";

	/**
	  *Constant "prepareObjectInferPO_1_NO_WITH_1" used to reference prepared statement  Glitter.prepareObjectInferPO_1_NO_WITH_1
	  *
	  * <code>
	  * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 				SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER  				FROM {2}_PROP_INFER PI_SUB,{0}{2} SUPER  				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER 				NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUPER.ONT AND PROP=PI_SUB.PROP AND OBJ=SUPER.OBJ AND OBJINFER=SUPER.OBJINFER) 		 	
	  * </code>
	  */
	public static final String prepareObjectInferPO_1_NO_WITH_1 = "Glitter.prepareObjectInferPO_1_NO_WITH_1";

	/**
	  *Constant "insertFindNP" used to reference prepared statement  Glitter.insertFindNP
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.NAMEDGRAPHID=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	  * </code>
	  */
	public static final String insertFindNP = "Glitter.insertFindNP";

	/**
	  *Constant "insertFindP" used to reference prepared statement  Glitter.insertFindP
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	  * </code>
	  */
	public static final String insertFindP = "Glitter.insertFindP";

	/**
	  *Constant "insertFindPMETA" used to reference prepared statement  Glitter.insertFindPMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.METADATA=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	  * </code>
	  */
	public static final String insertFindPMETA = "Glitter.insertFindPMETA";

	/**
	  *Constant "insertFindNSP" used to reference prepared statement  Glitter.insertFindNSP
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	  * </code>
	  */
	public static final String insertFindNSP = "Glitter.insertFindNSP";

	/**
	  *Constant "insertFindSP" used to reference prepared statement  Glitter.insertFindSP
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.SUBJ=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	  * </code>
	  */
	public static final String insertFindSP = "Glitter.insertFindSP";

	/**
	  *Constant "insertFindSPMETA" used to reference prepared statement  Glitter.insertFindSPMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.METADATA=? AND S.SUBJ=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	  * </code>
	  */
	public static final String insertFindSPMETA = "Glitter.insertFindSPMETA";

	/**
	  *Constant "insertFindNO" used to reference prepared statement  Glitter.insertFindNO
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) 		SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,QUERY.OBJ  FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	 	
	  * </code>
	  */
	public static final String insertFindNO = "Glitter.insertFindNO";

	/**
	  *Constant "insertFindO" used to reference prepared statement  Glitter.insertFindO
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE  INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	 	
	  * </code>
	  */
	public static final String insertFindO = "Glitter.insertFindO";

	/**
	  *Constant "insertFindOMETA" used to reference prepared statement  Glitter.insertFindOMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE  S.METADATA=? AND INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	 	
	  * </code>
	  */
	public static final String insertFindOMETA = "Glitter.insertFindOMETA";

	/**
	  *Constant "insertFindNSO" used to reference prepared statement  Glitter.insertFindNSO
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	 	
	  * </code>
	  */
	public static final String insertFindNSO = "Glitter.insertFindNSO";

	/**
	  *Constant "insertFindSO" used to reference prepared statement  Glitter.insertFindSO
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE S.SUBJ=? AND INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	 	
	  * </code>
	  */
	public static final String insertFindSO = "Glitter.insertFindSO";

	/**
	  *Constant "insertFindSOMETA" used to reference prepared statement  Glitter.insertFindSOMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE S.METADATA=? AND S.SUBJ=? AND INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	 	
	  * </code>
	  */
	public static final String insertFindSOMETA = "Glitter.insertFindSOMETA";

	/**
	  *Constant "insertFindNPO_O" used to reference prepared statement  Glitter.insertFindNPO_O
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ)  		SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.PROP=S.PROP AND QUERY.OBJ=INFER.OBJINFER 	
	  * </code>
	  */
	public static final String insertFindNPO_O = "Glitter.insertFindNPO_O";

	/**
	  *Constant "insertFindNPO_P" used to reference prepared statement  Glitter.insertFindNPO_P
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ AND QUERY.PROP=INFER.PROPINFER 	
	  * </code>
	  */
	public static final String insertFindNPO_P = "Glitter.insertFindNPO_P";

	/**
	  *Constant "insertFindPO_O" used to reference prepared statement  Glitter.insertFindPO_O
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.PROP=INFER.PROP A AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER 	
	  * </code>
	  */
	public static final String insertFindPO_O = "Glitter.insertFindPO_O";

	/**
	  *Constant "insertFindPO_OMETA" used to reference prepared statement  Glitter.insertFindPO_OMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.METADATA=? AND S.PROP=INFER.PROP A AND S.OBJ=INFER.OBJ AND QUERY.PROP=SUBJ.PROP 	
	  * </code>
	  */
	public static final String insertFindPO_OMETA = "Glitter.insertFindPO_OMETA";

	/**
	  *Constant "insertFindPO_P" used to reference prepared statement  Glitter.insertFindPO_P
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {2}_S S,{0}{2}  INFER WHERE S.PROP=INFER.PROP AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insertFindPO_P = "Glitter.insertFindPO_P";

	/**
	  *Constant "insertFindPO_PMETA" used to reference prepared statement  Glitter.insertFindPO_PMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {2}_S S,{0}{2}  INFER WHERE S.METADATA=? AND S.PROP=INFER.PROP AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insertFindPO_PMETA = "Glitter.insertFindPO_PMETA";

	/**
	  *Constant "insertFindNSPO_O" used to reference prepared statement  Glitter.insertFindNSPO_O
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND S.SUBJ=QUERY.SUBJ AND  S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	  * </code>
	  */
	public static final String insertFindNSPO_O = "Glitter.insertFindNSPO_O";

	/**
	  *Constant "insertFindSPO_O" used to reference prepared statement  Glitter.insertFindSPO_O
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE  S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	  * </code>
	  */
	public static final String insertFindSPO_O = "Glitter.insertFindSPO_O";

	/**
	  *Constant "insertFindSPO_OMETA" used to reference prepared statement  Glitter.insertFindSPO_OMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.METADATA=? AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	  * </code>
	  */
	public static final String insertFindSPO_OMETA = "Glitter.insertFindSPO_OMETA";

	/**
	  *Constant "insertFindNSPO_P" used to reference prepared statement  Glitter.insertFindNSPO_P
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,QUERY.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=QUERY.NAMEDGRAPHID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ 	
	  * </code>
	  */
	public static final String insertFindNSPO_P = "Glitter.insertFindNSPO_P";

	/**
	  *Constant "insertFindSPO_P" used to reference prepared statement  Glitter.insertFindSPO_P
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY  WHERE S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ 	
	  * </code>
	  */
	public static final String insertFindSPO_P = "Glitter.insertFindSPO_P";

	/**
	  *Constant "insertFindSPO_PMETA" used to reference prepared statement  Glitter.insertFindSPO_PMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.METADATA=? AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ 	
	  * </code>
	  */
	public static final String insertFindSPO_PMETA = "Glitter.insertFindSPO_PMETA";

	/**
	  *Constant "insertFindMP" used to reference prepared statement  Glitter.insertFindMP
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND S.NAMEDGRAPHID=GRAPHS.ID  AND S.PROP=INFER.PROP 	
	  * </code>
	  */
	public static final String insertFindMP = "Glitter.insertFindMP";

	/**
	  *Constant "insertFindMSP" used to reference prepared statement  Glitter.insertFindMSP
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP 	
	  * </code>
	  */
	public static final String insertFindMSP = "Glitter.insertFindMSP";

	/**
	  *Constant "insertFindMO" used to reference prepared statement  Glitter.insertFindMO
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND INFER.PROP=S.PROP AND  S.OBJ=INFER.OBJ	 	
	  * </code>
	  */
	public static final String insertFindMO = "Glitter.insertFindMO";

	/**
	  *Constant "insertFindMSO" used to reference prepared statement  Glitter.insertFindMSO
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	 	
	  * </code>
	  */
	public static final String insertFindMSO = "Glitter.insertFindMSO";

	/**
	  *Constant "insertFindMPO_O" used to reference prepared statement  Glitter.insertFindMPO_O
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	  * </code>
	  */
	public static final String insertFindMPO_O = "Glitter.insertFindMPO_O";

	/**
	  *Constant "insertFindMPO_P" used to reference prepared statement  Glitter.insertFindMPO_P
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insertFindMPO_P = "Glitter.insertFindMPO_P";

	/**
	  *Constant "insertFindMSPO_O" used to reference prepared statement  Glitter.insertFindMSPO_O
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	  * </code>
	  */
	public static final String insertFindMSPO_O = "Glitter.insertFindMSPO_O";

	/**
	  *Constant "insertFindMSPO_P" used to reference prepared statement  Glitter.insertFindMSPO_P
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insertFindMSPO_P = "Glitter.insertFindMSPO_P";

	/**
	  *Constant "insertFindMPMETA" used to reference prepared statement  Glitter.insertFindMPMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP 	
	  * </code>
	  */
	public static final String insertFindMPMETA = "Glitter.insertFindMPMETA";

	/**
	  *Constant "insertFindMSPMETA" used to reference prepared statement  Glitter.insertFindMSPMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP 	
	  * </code>
	  */
	public static final String insertFindMSPMETA = "Glitter.insertFindMSPMETA";

	/**
	  *Constant "insertFindMOMETA" used to reference prepared statement  Glitter.insertFindMOMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	AND QUERY.OBJ=INFER.OBJINFER 	
	  * </code>
	  */
	public static final String insertFindMOMETA = "Glitter.insertFindMOMETA";

	/**
	  *Constant "insertFindMSOMETA" used to reference prepared statement  Glitter.insertFindMSOMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER	 	
	  * </code>
	  */
	public static final String insertFindMSOMETA = "Glitter.insertFindMSOMETA";

	/**
	  *Constant "insertFindMPO_OMETA" used to reference prepared statement  Glitter.insertFindMPO_OMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER 	
	  * </code>
	  */
	public static final String insertFindMPO_OMETA = "Glitter.insertFindMPO_OMETA";

	/**
	  *Constant "insertFindMPO_PMETA" used to reference prepared statement  Glitter.insertFindMPO_PMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insertFindMPO_PMETA = "Glitter.insertFindMPO_PMETA";

	/**
	  *Constant "insertFindMSPO_OMETA" used to reference prepared statement  Glitter.insertFindMSPO_OMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER 	
	  * </code>
	  */
	public static final String insertFindMSPO_OMETA = "Glitter.insertFindMSPO_OMETA";

	/**
	  *Constant "insertFindMSPO_PMETA" used to reference prepared statement  Glitter.insertFindMSPO_PMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insertFindMSPO_PMETA = "Glitter.insertFindMSPO_PMETA";

	/**
	  *Constant "selectS" used to reference prepared statement  Glitter.selectS
	  *
	  * <code>
	  *  	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1} 	 UNION 	 SELECT DISTINCT S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {0}{4} S,{3}_OBJ_INFER INFER WHERE S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	 UNION 	 SELECT DISTINCT S2.NAMEDGRAPHID,S2.SUBJ,PI.PROPINFER,OI.OBJINFER FROM {0}{5} S2,{3}_OBJ_INFER OI,{3}_PROP_INFER PI WHERE S2.PROP=PI.PROP AND S2.OBJ=OI.OBJ AND PI.PROPINFER=OI.PROP 	 UNION 	 SELECT DISTINCT S3.NAMEDGRAPHID,S3.SUBJ,INFER.PROPINFER,S3.OBJ FROM {0}{6} S3,{0}{2} INFER WHERE S3.PROP=INFER.PROP; 	
	  * </code>
	  */
	public static final String selectS = "Glitter.selectS";

	/**
	  *Constant "selectP" used to reference prepared statement  Glitter.selectP
	  *
	  * <code>
	  *  	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1} 	 UNION 	 SELECT DISTINCT S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {0}{2} S,{3}_OBJ_INFER INFER WHERE S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	  * </code>
	  */
	public static final String selectP = "Glitter.selectP";

	/**
	  *Constant "selectO" used to reference prepared statement  Glitter.selectO
	  *
	  * <code>
	  *  	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1} 	 UNION 	 SELECT DISTINCT S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {0}{2} S,{0}{3} INFER WHERE S.PROP=INFER.PROP; 	
	  * </code>
	  */
	public static final String selectO = "Glitter.selectO";

	/**
	  *Constant "selectAll" used to reference prepared statement  Glitter.selectAll
	  *
	  * <code>
	  *  	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1} 	
	  * </code>
	  */
	public static final String selectAll = "Glitter.selectAll";

	/**
	  *Constant "insert0" used to reference prepared statement  Glitter.insert0
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S 	
	  * </code>
	  */
	public static final String insert0 = "Glitter.insert0";

	/**
	  *Constant "insert0META" used to reference prepared statement  Glitter.insert0META
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? 	
	  * </code>
	  */
	public static final String insert0META = "Glitter.insert0META";

	/**
	  *Constant "insert1" used to reference prepared statement  Glitter.insert1
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? 	
	  * </code>
	  */
	public static final String insert1 = "Glitter.insert1";

	/**
	  *Constant "insert1M" used to reference prepared statement  Glitter.insert1M
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND  S.NAMEDGRAPHID=G.ID 	
	  * </code>
	  */
	public static final String insert1M = "Glitter.insert1M";

	/**
	  *Constant "insert1MMETA" used to reference prepared statement  Glitter.insert1MMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID 	
	  * </code>
	  */
	public static final String insert1MMETA = "Glitter.insert1MMETA";

	/**
	  *Constant "insert2" used to reference prepared statement  Glitter.insert2
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? 	
	  * </code>
	  */
	public static final String insert2 = "Glitter.insert2";

	/**
	  *Constant "insert2META" used to reference prepared statement  Glitter.insert2META
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? 	
	  * </code>
	  */
	public static final String insert2META = "Glitter.insert2META";

	/**
	  *Constant "insert3" used to reference prepared statement  Glitter.insert3
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? 	
	  * </code>
	  */
	public static final String insert3 = "Glitter.insert3";

	/**
	  *Constant "insert3M" used to reference prepared statement  Glitter.insert3M
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? 	
	  * </code>
	  */
	public static final String insert3M = "Glitter.insert3M";

	/**
	  *Constant "insert3MMETA" used to reference prepared statement  Glitter.insert3MMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? 	
	  * </code>
	  */
	public static final String insert3MMETA = "Glitter.insert3MMETA";

	/**
	  *Constant "insert4" used to reference prepared statement  Glitter.insert4
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=? 	
	  * </code>
	  */
	public static final String insert4 = "Glitter.insert4";

	/**
	  *Constant "insert4META" used to reference prepared statement  Glitter.insert4META
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String insert4META = "Glitter.insert4META";

	/**
	  *Constant "insert5" used to reference prepared statement  Glitter.insert5
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String insert5 = "Glitter.insert5";

	/**
	  *Constant "insert5M" used to reference prepared statement  Glitter.insert5M
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=? 	
	  * </code>
	  */
	public static final String insert5M = "Glitter.insert5M";

	/**
	  *Constant "insert5MMETA" used to reference prepared statement  Glitter.insert5MMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String insert5MMETA = "Glitter.insert5MMETA";

	/**
	  *Constant "insert6" used to reference prepared statement  Glitter.insert6
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String insert6 = "Glitter.insert6";

	/**
	  *Constant "insert6META" used to reference prepared statement  Glitter.insert6META
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String insert6META = "Glitter.insert6META";

	/**
	  *Constant "insert7" used to reference prepared statement  Glitter.insert7
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String insert7 = "Glitter.insert7";

	/**
	  *Constant "insert7M" used to reference prepared statement  Glitter.insert7M
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String insert7M = "Glitter.insert7M";

	/**
	  *Constant "insert7MMETA" used to reference prepared statement  Glitter.insert7MMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String insert7MMETA = "Glitter.insert7MMETA";

	/**
	  *Constant "insert8" used to reference prepared statement  Glitter.insert8
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.OBJ=? 	
	  * </code>
	  */
	public static final String insert8 = "Glitter.insert8";

	/**
	  *Constant "insert8META" used to reference prepared statement  Glitter.insert8META
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert8META = "Glitter.insert8META";

	/**
	  *Constant "insert9" used to reference prepared statement  Glitter.insert9
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert9 = "Glitter.insert9";

	/**
	  *Constant "insert9M" used to reference prepared statement  Glitter.insert9M
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert9M = "Glitter.insert9M";

	/**
	  *Constant "insert9MMETA" used to reference prepared statement  Glitter.insert9MMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE  S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert9MMETA = "Glitter.insert9MMETA";

	/**
	  *Constant "insert10" used to reference prepared statement  Glitter.insert10
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert10 = "Glitter.insert10";

	/**
	  *Constant "insert10META" used to reference prepared statement  Glitter.insert10META
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert10META = "Glitter.insert10META";

	/**
	  *Constant "insert11" used to reference prepared statement  Glitter.insert11
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert11 = "Glitter.insert11";

	/**
	  *Constant "insert11M" used to reference prepared statement  Glitter.insert11M
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert11M = "Glitter.insert11M";

	/**
	  *Constant "insert11MMETA" used to reference prepared statement  Glitter.insert11MMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert11MMETA = "Glitter.insert11MMETA";

	/**
	  *Constant "insert12" used to reference prepared statement  Glitter.insert12
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert12 = "Glitter.insert12";

	/**
	  *Constant "insert12META" used to reference prepared statement  Glitter.insert12META
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert12META = "Glitter.insert12META";

	/**
	  *Constant "insert13" used to reference prepared statement  Glitter.insert13
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert13 = "Glitter.insert13";

	/**
	  *Constant "insert13M" used to reference prepared statement  Glitter.insert13M
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert13M = "Glitter.insert13M";

	/**
	  *Constant "insert13MMETA" used to reference prepared statement  Glitter.insert13MMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert13MMETA = "Glitter.insert13MMETA";

	/**
	  *Constant "insert14" used to reference prepared statement  Glitter.insert14
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert14 = "Glitter.insert14";

	/**
	  *Constant "insert14META" used to reference prepared statement  Glitter.insert14META
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert14META = "Glitter.insert14META";

	/**
	  *Constant "insert15" used to reference prepared statement  Glitter.insert15
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert15 = "Glitter.insert15";

	/**
	  *Constant "insert15M" used to reference prepared statement  Glitter.insert15M
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert15M = "Glitter.insert15M";

	/**
	  *Constant "insert15MMETA" used to reference prepared statement  Glitter.insert15MMETA
	  *
	  * <code>
	  *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String insert15MMETA = "Glitter.insert15MMETA";

	/**
	  *Constant "select0" used to reference prepared statement  Glitter.select0
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S 	
	  * </code>
	  */
	public static final String select0 = "Glitter.select0";

	/**
	  *Constant "select0META" used to reference prepared statement  Glitter.select0META
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? 	
	  * </code>
	  */
	public static final String select0META = "Glitter.select0META";

	/**
	  *Constant "select1" used to reference prepared statement  Glitter.select1
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? 	
	  * </code>
	  */
	public static final String select1 = "Glitter.select1";

	/**
	  *Constant "select1M" used to reference prepared statement  Glitter.select1M
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID 	
	  * </code>
	  */
	public static final String select1M = "Glitter.select1M";

	/**
	  *Constant "select1MMETA" used to reference prepared statement  Glitter.select1MMETA
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID 	
	  * </code>
	  */
	public static final String select1MMETA = "Glitter.select1MMETA";

	/**
	  *Constant "select2" used to reference prepared statement  Glitter.select2
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? 	
	  * </code>
	  */
	public static final String select2 = "Glitter.select2";

	/**
	  *Constant "select2META" used to reference prepared statement  Glitter.select2META
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? 	
	  * </code>
	  */
	public static final String select2META = "Glitter.select2META";

	/**
	  *Constant "select3" used to reference prepared statement  Glitter.select3
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? 	
	  * </code>
	  */
	public static final String select3 = "Glitter.select3";

	/**
	  *Constant "select3M" used to reference prepared statement  Glitter.select3M
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? 	
	  * </code>
	  */
	public static final String select3M = "Glitter.select3M";

	/**
	  *Constant "select3MMETA" used to reference prepared statement  Glitter.select3MMETA
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? 	
	  * </code>
	  */
	public static final String select3MMETA = "Glitter.select3MMETA";

	/**
	  *Constant "select4" used to reference prepared statement  Glitter.select4
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=? 	
	  * </code>
	  */
	public static final String select4 = "Glitter.select4";

	/**
	  *Constant "select4META" used to reference prepared statement  Glitter.select4META
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String select4META = "Glitter.select4META";

	/**
	  *Constant "select5" used to reference prepared statement  Glitter.select5
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String select5 = "Glitter.select5";

	/**
	  *Constant "select5M" used to reference prepared statement  Glitter.select5M
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=? 	
	  * </code>
	  */
	public static final String select5M = "Glitter.select5M";

	/**
	  *Constant "select5MMETA" used to reference prepared statement  Glitter.select5MMETA
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String select5MMETA = "Glitter.select5MMETA";

	/**
	  *Constant "select6" used to reference prepared statement  Glitter.select6
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String select6 = "Glitter.select6";

	/**
	  *Constant "select6META" used to reference prepared statement  Glitter.select6META
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String select6META = "Glitter.select6META";

	/**
	  *Constant "select7" used to reference prepared statement  Glitter.select7
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String select7 = "Glitter.select7";

	/**
	  *Constant "select7M" used to reference prepared statement  Glitter.select7M
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String select7M = "Glitter.select7M";

	/**
	  *Constant "select7MMETA" used to reference prepared statement  Glitter.select7MMETA
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=? 	
	  * </code>
	  */
	public static final String select7MMETA = "Glitter.select7MMETA";

	/**
	  *Constant "select8" used to reference prepared statement  Glitter.select8
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.OBJ=? 	
	  * </code>
	  */
	public static final String select8 = "Glitter.select8";

	/**
	  *Constant "select8META" used to reference prepared statement  Glitter.select8META
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select8META = "Glitter.select8META";

	/**
	  *Constant "select9" used to reference prepared statement  Glitter.select9
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select9 = "Glitter.select9";

	/**
	  *Constant "select9M" used to reference prepared statement  Glitter.select9M
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select9M = "Glitter.select9M";

	/**
	  *Constant "select9MMETA" used to reference prepared statement  Glitter.select9MMETA
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE  S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select9MMETA = "Glitter.select9MMETA";

	/**
	  *Constant "select10" used to reference prepared statement  Glitter.select10
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select10 = "Glitter.select10";

	/**
	  *Constant "select10META" used to reference prepared statement  Glitter.select10META
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select10META = "Glitter.select10META";

	/**
	  *Constant "select11" used to reference prepared statement  Glitter.select11
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select11 = "Glitter.select11";

	/**
	  *Constant "select11M" used to reference prepared statement  Glitter.select11M
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select11M = "Glitter.select11M";

	/**
	  *Constant "select11MMETA" used to reference prepared statement  Glitter.select11MMETA
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select11MMETA = "Glitter.select11MMETA";

	/**
	  *Constant "select12" used to reference prepared statement  Glitter.select12
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select12 = "Glitter.select12";

	/**
	  *Constant "select12META" used to reference prepared statement  Glitter.select12META
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select12META = "Glitter.select12META";

	/**
	  *Constant "select13" used to reference prepared statement  Glitter.select13
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select13 = "Glitter.select13";

	/**
	  *Constant "select13M" used to reference prepared statement  Glitter.select13M
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select13M = "Glitter.select13M";

	/**
	  *Constant "select13MMETA" used to reference prepared statement  Glitter.select13MMETA
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select13MMETA = "Glitter.select13MMETA";

	/**
	  *Constant "select14" used to reference prepared statement  Glitter.select14
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select14 = "Glitter.select14";

	/**
	  *Constant "select14META" used to reference prepared statement  Glitter.select14META
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select14META = "Glitter.select14META";

	/**
	  *Constant "select15" used to reference prepared statement  Glitter.select15
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select15 = "Glitter.select15";

	/**
	  *Constant "select15M" used to reference prepared statement  Glitter.select15M
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select15M = "Glitter.select15M";

	/**
	  *Constant "select15MMETA" used to reference prepared statement  Glitter.select15MMETA
	  *
	  * <code>
	  *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	  * </code>
	  */
	public static final String select15MMETA = "Glitter.select15MMETA";

	/**
	  *Constant "insertIdToTempTable" used to reference prepared statement  Glitter.insertIdToTempTable
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID) VALUES(?) 	
	  * </code>
	  */
	public static final String insertIdToTempTable = "Glitter.insertIdToTempTable";



	
	/**
	 * Runs the insertGraphIfValid prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2}_S S 		WHERE S.METADATA = 1 		  AND S.SUBJECT = ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param graphId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertGraphIfValid (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long graphId, String sessionPrefix, String insertTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertGraphIfValid, new String[] {sessionPrefix, insertTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, graphId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertGraphIfValid",stmtProvider.getSqlString(insertGraphIfValid) ,""+ "graphId="+(graphId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertGraphIfValid]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertGraphIfValid prepared statement
	 */
	public static class BatchInsertGraphIfValid extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertGraphIfValid prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertGraphIfValid(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertGraphIfValid,new String[] {sessionPrefix, insertTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertGraphIfValid prepared statement.
		 *
	 *@param graphId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long graphId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, graphId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertAllValidGraphs prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2}_S S 		WHERE S.METADATA = 1 		  AND S.SUBJECT NOT IN (?,?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ngDatasetId template parameter
	 *@param ngDatasetMetadataId template parameter
	 *@param mgDatasetId template parameter
	 *@param mgDatasetMetadataId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllValidGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ngDatasetId, long ngDatasetMetadataId, long mgDatasetId, long mgDatasetMetadataId, String sessionPrefix, String insertTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertAllValidGraphs, new String[] {sessionPrefix, insertTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ngDatasetId);
			ps.setLong(argc++, ngDatasetMetadataId);
			ps.setLong(argc++, mgDatasetId);
			ps.setLong(argc++, mgDatasetMetadataId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllValidGraphs",stmtProvider.getSqlString(insertAllValidGraphs) ,""+ "ngDatasetId="+(ngDatasetId) + "," +"ngDatasetMetadataId="+(ngDatasetMetadataId) + "," +"mgDatasetId="+(mgDatasetId) + "," +"mgDatasetMetadataId="+(mgDatasetMetadataId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllValidGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllValidGraphs prepared statement
	 */
	public static class BatchInsertAllValidGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllValidGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllValidGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllValidGraphs,new String[] {sessionPrefix, insertTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertAllValidGraphs prepared statement.
		 *
	 *@param ngDatasetId template parameter
	 *@param ngDatasetMetadataId template parameter
	 *@param mgDatasetId template parameter
	 *@param mgDatasetMetadataId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ngDatasetId, long ngDatasetMetadataId, long mgDatasetId, long mgDatasetMetadataId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ngDatasetId);
			ps.setLong(argc++, ngDatasetMetadataId);
			ps.setLong(argc++, mgDatasetId);
			ps.setLong(argc++, mgDatasetMetadataId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertAllValidNamedGraphs prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2}_S S 		WHERE S.METADATA = 1 		  AND S.PREDICATE = ? 		  AND S.OBJECT = ? 		  AND S.SUBJECT NOT IN (?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param rdfTypeId template parameter
	 *@param anzotypesNamedGraphId template parameter
	 *@param ngDatasetId template parameter
	 *@param mgDatasetId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllValidNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long rdfTypeId, long anzotypesNamedGraphId, long ngDatasetId, long mgDatasetId, String sessionPrefix, String insertTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertAllValidNamedGraphs, new String[] {sessionPrefix, insertTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, rdfTypeId);
			ps.setLong(argc++, anzotypesNamedGraphId);
			ps.setLong(argc++, ngDatasetId);
			ps.setLong(argc++, mgDatasetId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllValidNamedGraphs",stmtProvider.getSqlString(insertAllValidNamedGraphs) ,""+ "rdfTypeId="+(rdfTypeId) + "," +"anzotypesNamedGraphId="+(anzotypesNamedGraphId) + "," +"ngDatasetId="+(ngDatasetId) + "," +"mgDatasetId="+(mgDatasetId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllValidNamedGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllValidNamedGraphs prepared statement
	 */
	public static class BatchInsertAllValidNamedGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllValidNamedGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllValidNamedGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllValidNamedGraphs,new String[] {sessionPrefix, insertTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertAllValidNamedGraphs prepared statement.
		 *
	 *@param rdfTypeId template parameter
	 *@param anzotypesNamedGraphId template parameter
	 *@param ngDatasetId template parameter
	 *@param mgDatasetId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long rdfTypeId, long anzotypesNamedGraphId, long ngDatasetId, long mgDatasetId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, rdfTypeId);
			ps.setLong(argc++, anzotypesNamedGraphId);
			ps.setLong(argc++, ngDatasetId);
			ps.setLong(argc++, mgDatasetId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertAllValidMetadataGraphs prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.OBJECT FROM {2}_S S 		WHERE S.METADATA = 1 		  AND S.PREDICATE = ? 		  AND S.OBJECT NOT IN (?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param hasMetadataGraphId template parameter
	 *@param ngDatasetMetadataId template parameter
	 *@param mgDatasetMetadataId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllValidMetadataGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long hasMetadataGraphId, long ngDatasetMetadataId, long mgDatasetMetadataId, String sessionPrefix, String insertTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertAllValidMetadataGraphs, new String[] {sessionPrefix, insertTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, hasMetadataGraphId);
			ps.setLong(argc++, ngDatasetMetadataId);
			ps.setLong(argc++, mgDatasetMetadataId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllValidMetadataGraphs",stmtProvider.getSqlString(insertAllValidMetadataGraphs) ,""+ "hasMetadataGraphId="+(hasMetadataGraphId) + "," +"ngDatasetMetadataId="+(ngDatasetMetadataId) + "," +"mgDatasetMetadataId="+(mgDatasetMetadataId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllValidMetadataGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllValidMetadataGraphs prepared statement
	 */
	public static class BatchInsertAllValidMetadataGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllValidMetadataGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllValidMetadataGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllValidMetadataGraphs,new String[] {sessionPrefix, insertTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertAllValidMetadataGraphs prepared statement.
		 *
	 *@param hasMetadataGraphId template parameter
	 *@param ngDatasetMetadataId template parameter
	 *@param mgDatasetMetadataId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long hasMetadataGraphId, long ngDatasetMetadataId, long mgDatasetMetadataId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, hasMetadataGraphId);
			ps.setLong(argc++, ngDatasetMetadataId);
			ps.setLong(argc++, mgDatasetMetadataId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertValidDatasetGraphs prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT DS.OBJECT FROM {2}_S DS 		WHERE DS.NAMEDGRAPHID = ? 		  AND DS.SUBJECT = ?  		  AND DS.PREDICATE = ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param datasetId template parameter
	 *@param datasetIdRepeated template parameter
	 *@param datasetGraphPropertyId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertValidDatasetGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long datasetId, long datasetIdRepeated, long datasetGraphPropertyId, String sessionPrefix, String insertTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertValidDatasetGraphs, new String[] {sessionPrefix, insertTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, datasetId);
			ps.setLong(argc++, datasetIdRepeated);
			ps.setLong(argc++, datasetGraphPropertyId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertValidDatasetGraphs",stmtProvider.getSqlString(insertValidDatasetGraphs) ,""+ "datasetId="+(datasetId) + "," +"datasetIdRepeated="+(datasetIdRepeated) + "," +"datasetGraphPropertyId="+(datasetGraphPropertyId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertValidDatasetGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertValidDatasetGraphs prepared statement
	 */
	public static class BatchInsertValidDatasetGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertValidDatasetGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertValidDatasetGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertValidDatasetGraphs,new String[] {sessionPrefix, insertTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertValidDatasetGraphs prepared statement.
		 *
	 *@param datasetId template parameter
	 *@param datasetIdRepeated template parameter
	 *@param datasetGraphPropertyId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long datasetId, long datasetIdRepeated, long datasetGraphPropertyId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, datasetId);
			ps.setLong(argc++, datasetIdRepeated);
			ps.setLong(argc++, datasetGraphPropertyId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the copyDistinctDatasetIds prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{2} SELECT DISTINCT ID FROM {0}{1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param sourceTable template parameter
	 *@param destinationTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int copyDistinctDatasetIds (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String sourceTable, String destinationTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(copyDistinctDatasetIds, new String[] {sessionPrefix, sourceTable, destinationTable},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"copyDistinctDatasetIds",stmtProvider.getSqlString(copyDistinctDatasetIds) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"sourceTable="+((sourceTable!=null)?sourceTable.toString():"null") + "," +"destinationTable="+((destinationTable!=null)?destinationTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[copyDistinctDatasetIds]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CopyDistinctDatasetIds prepared statement
	 */
	public static class BatchCopyDistinctDatasetIds extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CopyDistinctDatasetIds prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param sourceTable template parameter
	 *@param destinationTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCopyDistinctDatasetIds(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String sourceTable, String destinationTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,copyDistinctDatasetIds,new String[] {sessionPrefix, sourceTable, destinationTable});
		}
		
		/**
		 * Sets the input parameters for the copyDistinctDatasetIds prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertQueryStatement prepared statement.
	  * <code>
	 *  	    INSERT INTO {0}QUERY(NAMEDGRAPHID,SUBJ,PROP,OBJ) VALUES (?,?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ngId template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertQueryStatement (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ngId, long subjId, long propId, long objId, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertQueryStatement, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, ngId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertQueryStatement",stmtProvider.getSqlString(insertQueryStatement) ,""+ "ngId="+(ngId) + "," +"subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertQueryStatement]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertQueryStatement prepared statement
	 */
	public static class BatchInsertQueryStatement extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertQueryStatement prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertQueryStatement(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertQueryStatement,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the insertQueryStatement prepared statement.
		 *
	 *@param ngId template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ngId, long subjId, long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ngId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertTempDatasetGraph prepared statement.
	  * <code>
	 *  	    INSERT INTO {0}{1} VALUES (?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempGraphTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertTempDatasetGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String sessionPrefix, String tempGraphTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertTempDatasetGraph, new String[] {sessionPrefix, tempGraphTable},connection); int argc = 1;
			ps.setLong(argc++, id);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertTempDatasetGraph",stmtProvider.getSqlString(insertTempDatasetGraph) ,""+ "id="+(id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempGraphTable="+((tempGraphTable!=null)?tempGraphTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertTempDatasetGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertTempDatasetGraph prepared statement
	 */
	public static class BatchInsertTempDatasetGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertTempDatasetGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempGraphTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertTempDatasetGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempGraphTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertTempDatasetGraph,new String[] {sessionPrefix, tempGraphTable});
		}
		
		/**
		 * Sets the input parameters for the insertTempDatasetGraph prepared statement.
		 *
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertAllNamedGraphs prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} SELECT DISTINCT NAMEDGRAPHID FROM {2} WHERE METADATA=0 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempGraphTable template parameter
	 *@param statementsTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempGraphTable, String statementsTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertAllNamedGraphs, new String[] {sessionPrefix, tempGraphTable, statementsTable},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllNamedGraphs",stmtProvider.getSqlString(insertAllNamedGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempGraphTable="+((tempGraphTable!=null)?tempGraphTable.toString():"null") + "," +"statementsTable="+((statementsTable!=null)?statementsTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllNamedGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllNamedGraphs prepared statement
	 */
	public static class BatchInsertAllNamedGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllNamedGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempGraphTable template parameter
	 *@param statementsTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllNamedGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempGraphTable, String statementsTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllNamedGraphs,new String[] {sessionPrefix, tempGraphTable, statementsTable});
		}
		
		/**
		 * Sets the input parameters for the insertAllNamedGraphs prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertAllMetadataGraphs prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} SELECT DISTINCT NAMEDGRAPHID FROM {2} WHERE METADATA=1 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempGraphTable template parameter
	 *@param statementsTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllMetadataGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempGraphTable, String statementsTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertAllMetadataGraphs, new String[] {sessionPrefix, tempGraphTable, statementsTable},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllMetadataGraphs",stmtProvider.getSqlString(insertAllMetadataGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempGraphTable="+((tempGraphTable!=null)?tempGraphTable.toString():"null") + "," +"statementsTable="+((statementsTable!=null)?statementsTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllMetadataGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllMetadataGraphs prepared statement
	 */
	public static class BatchInsertAllMetadataGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllMetadataGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempGraphTable template parameter
	 *@param statementsTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllMetadataGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempGraphTable, String statementsTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllMetadataGraphs,new String[] {sessionPrefix, tempGraphTable, statementsTable});
		}
		
		/**
		 * Sets the input parameters for the insertAllMetadataGraphs prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertAllGraphs prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} SELECT DISTINCT NAMEDGRAPHID FROM {2} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempGraphTable template parameter
	 *@param statementsTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempGraphTable, String statementsTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertAllGraphs, new String[] {sessionPrefix, tempGraphTable, statementsTable},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllGraphs",stmtProvider.getSqlString(insertAllGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempGraphTable="+((tempGraphTable!=null)?tempGraphTable.toString():"null") + "," +"statementsTable="+((statementsTable!=null)?statementsTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllGraphs prepared statement
	 */
	public static class BatchInsertAllGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempGraphTable template parameter
	 *@param statementsTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempGraphTable, String statementsTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllGraphs,new String[] {sessionPrefix, tempGraphTable, statementsTable});
		}
		
		/**
		 * Sets the input parameters for the insertAllGraphs prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the countRows prepared statement.
	  * <code>
	 *  		SELECT COUNT(1) FROM {0}{1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempGraphTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int countRows (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempGraphTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countRows, new String[] {sessionPrefix, tempGraphTable},connection);
			java.sql.ResultSet rs = null;
			try {
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				if(!rs.next())
					return 0;				 
				int val = rs.getInt(1);
				return val;
			} finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (java.sql.SQLException sqle) {
						if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing result set",sqle);
					}
				}
			}

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countRows",stmtProvider.getSqlString(countRows) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempGraphTable="+((tempGraphTable!=null)?tempGraphTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countRows]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectInferedInference prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectInferedInferenceResult> transformSelectInferedInference = new org.openanzo.jdbc.utils.Transformer<SelectInferedInferenceResult>(){
		public SelectInferedInferenceResult transform(java.sql.ResultSet rs) {

			
				SelectInferedInferenceResult result = new SelectInferedInferenceResult();
				try {
				result.prop=rs.getString(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.objInfer=rs.getString(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:objInfer",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectInferedInference prepared statement.
	  * <code>
	 *  		SELECT (SELECT VALUE FROM {2}_U WHERE {2}_U.ID=PROP) AS PROP, 			   (SELECT VALUE FROM {2}_U WHERE {2}_U.ID=OBJ) AS OBJ, 			   (SELECT VALUE FROM {2}_U WHERE {2}_U.ID=OBJINFER) AS OBJINFER 		FROM {0}{1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectInferedInferenceResult> selectInferedInference (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectInferedInference, new String[] {sessionPrefix, tempTable, containerName},connection);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<SelectInferedInferenceResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectInferedInferenceResult>(rs, ps, stmtProvider, transformSelectInferedInference);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectInferedInference",stmtProvider.getSqlString(selectInferedInference) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectInferedInference]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectInferedInferenceResult
	 */
	public static class SelectInferedInferenceResult {
			/**Value for the "prop" result value*/
			private String prop;
			/**Value for the "obj" result value*/
			private String obj;
			/**Value for the "objInfer" result value*/
			private String objInfer;

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public String getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public String getObj() {
				return this.obj;
			}

		/**
		  *Get ObjInfer value
		  *@return ObjInfer value
		  */
			public String getObjInfer() {
				return this.objInfer;
			}

	}



	
	/**
	 * Runs the countInferedProperty prepared statement.
	  * <code>
	 *  		SELECT COUNT(1) FROM {0}_PROP_INFER WHERE ONT=? AND PROP=? AND PROPINFER=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param inferedPropId template parameter
	 *
	 *@param containerName template parameter
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long countInferedProperty (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, long inferedPropId, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countInferedProperty, new String[] {containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, inferedPropId);
			java.sql.ResultSet rs = null;
			try {
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				if(!rs.next())
					return 0;				 
				long val = rs.getLong(1);
				return val;
			} finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (java.sql.SQLException sqle) {
						if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing result set",sqle);
					}
				}
			}

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countInferedProperty",stmtProvider.getSqlString(countInferedProperty) ,""+ "ontId="+(ontId) + "," +"propId="+(propId) + "," +"inferedPropId="+(inferedPropId),""+ "containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countInferedProperty]"+endtimer);
		}
	}




	
	/**
	 * Runs the countInferedObject prepared statement.
	  * <code>
	 *  		SELECT COUNT(1) FROM {0}_OBJ_INFER WHERE ONT=? AND PROP=? AND OBJ=? AND OBJINFER=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *@param inferedObjId template parameter
	 *
	 *@param containerName template parameter
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long countInferedObject (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, long objId, long inferedObjId, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countInferedObject, new String[] {containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			ps.setLong(argc++, inferedObjId);
			java.sql.ResultSet rs = null;
			try {
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				if(!rs.next())
					return 0;				 
				long val = rs.getLong(1);
				return val;
			} finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (java.sql.SQLException sqle) {
						if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing result set",sqle);
					}
				}
			}

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countInferedObject",stmtProvider.getSqlString(countInferedObject) ,""+ "ontId="+(ontId) + "," +"propId="+(propId) + "," +"objId="+(objId) + "," +"inferedObjId="+(inferedObjId),""+ "containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countInferedObject]"+endtimer);
		}
	}




	
	/**
	 * Runs the insertInferedProperty prepared statement.
	  * <code>
	 *  		INSERT INTO {0}_PROP_INFER(ONT,PROP,PROPINFER) VALUES(?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param inferedPropId template parameter
	 *
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertInferedProperty (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, long inferedPropId, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertInferedProperty, new String[] {containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, inferedPropId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertInferedProperty",stmtProvider.getSqlString(insertInferedProperty) ,""+ "ontId="+(ontId) + "," +"propId="+(propId) + "," +"inferedPropId="+(inferedPropId),""+ "containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertInferedProperty]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertInferedProperty prepared statement
	 */
	public static class BatchInsertInferedProperty extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertInferedProperty prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertInferedProperty(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertInferedProperty,new String[] {containerName});
		}
		
		/**
		 * Sets the input parameters for the insertInferedProperty prepared statement.
		 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param inferedPropId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long propId, long inferedPropId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, inferedPropId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertInferedObject prepared statement.
	  * <code>
	 *  		INSERT INTO {0}_OBJ_INFER(ONT,PROP,OBJ,OBJINFER) VALUES(?,?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *@param inferedObjId template parameter
	 *
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertInferedObject (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, long objId, long inferedObjId, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertInferedObject, new String[] {containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			ps.setLong(argc++, inferedObjId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertInferedObject",stmtProvider.getSqlString(insertInferedObject) ,""+ "ontId="+(ontId) + "," +"propId="+(propId) + "," +"objId="+(objId) + "," +"inferedObjId="+(inferedObjId),""+ "containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertInferedObject]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertInferedObject prepared statement
	 */
	public static class BatchInsertInferedObject extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertInferedObject prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertInferedObject(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertInferedObject,new String[] {containerName});
		}
		
		/**
		 * Sets the input parameters for the insertInferedObject prepared statement.
		 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *@param inferedObjId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long propId, long objId, long inferedObjId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			ps.setLong(argc++, inferedObjId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteInferedProperty prepared statement.
	  * <code>
	 *  		DELETE FROM {0}_PROP_INFER WHERE ONT=? AND PROP=? AND PROPINFER=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param inferedPropId template parameter
	 *
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteInferedProperty (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, long inferedPropId, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteInferedProperty, new String[] {containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, inferedPropId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteInferedProperty",stmtProvider.getSqlString(deleteInferedProperty) ,""+ "ontId="+(ontId) + "," +"propId="+(propId) + "," +"inferedPropId="+(inferedPropId),""+ "containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteInferedProperty]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteInferedProperty prepared statement
	 */
	public static class BatchDeleteInferedProperty extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteInferedProperty prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteInferedProperty(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteInferedProperty,new String[] {containerName});
		}
		
		/**
		 * Sets the input parameters for the deleteInferedProperty prepared statement.
		 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param inferedPropId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long propId, long inferedPropId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, inferedPropId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteInferedObject prepared statement.
	  * <code>
	 *  		DELETE FROM {0}_OBJ_INFER WHERE ONT=? AND PROP=? AND OBJ=? AND OBJINFER=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *@param inferedObjId template parameter
	 *
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteInferedObject (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, long objId, long inferedObjId, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteInferedObject, new String[] {containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			ps.setLong(argc++, inferedObjId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteInferedObject",stmtProvider.getSqlString(deleteInferedObject) ,""+ "ontId="+(ontId) + "," +"propId="+(propId) + "," +"objId="+(objId) + "," +"inferedObjId="+(inferedObjId),""+ "containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteInferedObject]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteInferedObject prepared statement
	 */
	public static class BatchDeleteInferedObject extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteInferedObject prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteInferedObject(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteInferedObject,new String[] {containerName});
		}
		
		/**
		 * Sets the input parameters for the deleteInferedObject prepared statement.
		 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *@param inferedObjId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long propId, long objId, long inferedObjId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			ps.setLong(argc++, inferedObjId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteOntologiesInferedProperties prepared statement.
	  * <code>
	 *  		DELETE FROM {0}_PROP_INFER WHERE ONT=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteOntologiesInferedProperties (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteOntologiesInferedProperties, new String[] {containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteOntologiesInferedProperties",stmtProvider.getSqlString(deleteOntologiesInferedProperties) ,""+ "ontId="+(ontId),""+ "containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteOntologiesInferedProperties]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteOntologiesInferedProperties prepared statement
	 */
	public static class BatchDeleteOntologiesInferedProperties extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteOntologiesInferedProperties prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteOntologiesInferedProperties(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteOntologiesInferedProperties,new String[] {containerName});
		}
		
		/**
		 * Sets the input parameters for the deleteOntologiesInferedProperties prepared statement.
		 *
	 *@param ontId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteOntologiesInferedObjects prepared statement.
	  * <code>
	 *  		DELETE FROM {0}_OBJ_INFER ONT=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteOntologiesInferedObjects (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteOntologiesInferedObjects, new String[] {containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteOntologiesInferedObjects",stmtProvider.getSqlString(deleteOntologiesInferedObjects) ,""+ "ontId="+(ontId),""+ "containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteOntologiesInferedObjects]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteOntologiesInferedObjects prepared statement
	 */
	public static class BatchDeleteOntologiesInferedObjects extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteOntologiesInferedObjects prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteOntologiesInferedObjects(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteOntologiesInferedObjects,new String[] {containerName});
		}
		
		/**
		 * Sets the input parameters for the deleteOntologiesInferedObjects prepared statement.
		 *
	 *@param ontId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectGraphs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectGraphs = new org.openanzo.jdbc.utils.Transformer<Long>(){
		public Long transform(java.sql.ResultSet rs) {
			try {
				Long val = rs.getLong(1);
				return val;
			} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set value:Long",e);
				throw new org.apache.commons.collections.FunctorException(e);
			}
			}

	};
	
	/**
	 * Runs the selectGraphs prepared statement.
	  * <code>
	 *  		SELECT TG.ID AS GRAPH			    		FROM {0}{1} TG 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectGraphs, new String[] {sessionPrefix, tempTable, containerName},connection);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectGraphs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectGraphs",stmtProvider.getSqlString(selectGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectGraphs]"+endtimer);
		}
	}




	
	/**
	 * Runs the preparePropInfer_0 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) 		WITH TEMPTAB(ONT,PROP,PROPINFER) AS  		(		SELECT ONT,PROP,PROPINFER  				FROM {2}_PROP_INFER INFER  				WHERE INFER.ONT=? 		UNION ALL  			SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER  			FROM {2}_PROP_INFER SUB, TEMPTAB SUPER  			WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP  		)  		SELECT DISTINCT ONT,PROP,PROPINFER FROM TEMPTAB 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int preparePropInfer_0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(preparePropInfer_0, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"preparePropInfer_0",stmtProvider.getSqlString(preparePropInfer_0) ,""+ "ontId="+(ontId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[preparePropInfer_0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PreparePropInfer_0 prepared statement
	 */
	public static class BatchPreparePropInfer_0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PreparePropInfer_0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPreparePropInfer_0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,preparePropInfer_0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the preparePropInfer_0 prepared statement.
		 *
	 *@param ontId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the preparePropInfer_0_NO_WITH_0 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) SELECT ONT,PROP,PROPINFER FROM {2}_PROP_INFER INFER WHERE INFER.ONT=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int preparePropInfer_0_NO_WITH_0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(preparePropInfer_0_NO_WITH_0, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"preparePropInfer_0_NO_WITH_0",stmtProvider.getSqlString(preparePropInfer_0_NO_WITH_0) ,""+ "ontId="+(ontId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[preparePropInfer_0_NO_WITH_0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PreparePropInfer_0_NO_WITH_0 prepared statement
	 */
	public static class BatchPreparePropInfer_0_NO_WITH_0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PreparePropInfer_0_NO_WITH_0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPreparePropInfer_0_NO_WITH_0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,preparePropInfer_0_NO_WITH_0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the preparePropInfer_0_NO_WITH_0 prepared statement.
		 *
	 *@param ontId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the preparePropInfer_0_NO_WITH_1 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER)  		SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER  		FROM {4}_PROP_INFER SUB, {0}{2} SUPER WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP AND  		NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUPER.ONT AND PROP=SUB.PROP AND PROPINFER=SUPER.PROPINFER) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempTable3 template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int preparePropInfer_0_NO_WITH_1 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempTable2, String tempTable3, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(preparePropInfer_0_NO_WITH_1, new String[] {sessionPrefix, tempTable, tempTable2, tempTable3, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"preparePropInfer_0_NO_WITH_1",stmtProvider.getSqlString(preparePropInfer_0_NO_WITH_1) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempTable2="+((tempTable2!=null)?tempTable2.toString():"null") + "," +"tempTable3="+((tempTable3!=null)?tempTable3.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[preparePropInfer_0_NO_WITH_1]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PreparePropInfer_0_NO_WITH_1 prepared statement
	 */
	public static class BatchPreparePropInfer_0_NO_WITH_1 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PreparePropInfer_0_NO_WITH_1 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempTable3 template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPreparePropInfer_0_NO_WITH_1(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempTable2, String tempTable3, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,preparePropInfer_0_NO_WITH_1,new String[] {sessionPrefix, tempTable, tempTable2, tempTable3, containerName});
		}
		
		/**
		 * Sets the input parameters for the preparePropInfer_0_NO_WITH_1 prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the preparePropInferP_0 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) 		WITH TEMPTAB(ONT,PROP,PROPINFER) AS  		(		SELECT ONT,PROP,PROPINFER  				FROM {2}_PROP_INFER INFER  				WHERE INFER.ONT=? AND INFER.PROPINFER=? 		UNION ALL  			SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER  			FROM {2}_PROP_INFER SUB, TEMPTAB SUPER  			WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP  		)  		SELECT DISTINCT ONT,PROP,PROPINFER FROM TEMPTAB 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int preparePropInferP_0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(preparePropInferP_0, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"preparePropInferP_0",stmtProvider.getSqlString(preparePropInferP_0) ,""+ "ontId="+(ontId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[preparePropInferP_0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PreparePropInferP_0 prepared statement
	 */
	public static class BatchPreparePropInferP_0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PreparePropInferP_0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPreparePropInferP_0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,preparePropInferP_0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the preparePropInferP_0 prepared statement.
		 *
	 *@param ontId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the preparePropInferP_0_NO_WITH_0 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER) SELECT ONT,PROP,PROPINFER FROM {2}_PROP_INFER INFER WHERE INFER.ONT=? AND INFER.PROPINFER=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int preparePropInferP_0_NO_WITH_0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(preparePropInferP_0_NO_WITH_0, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"preparePropInferP_0_NO_WITH_0",stmtProvider.getSqlString(preparePropInferP_0_NO_WITH_0) ,""+ "ontId="+(ontId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[preparePropInferP_0_NO_WITH_0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PreparePropInferP_0_NO_WITH_0 prepared statement
	 */
	public static class BatchPreparePropInferP_0_NO_WITH_0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PreparePropInferP_0_NO_WITH_0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPreparePropInferP_0_NO_WITH_0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,preparePropInferP_0_NO_WITH_0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the preparePropInferP_0_NO_WITH_0 prepared statement.
		 *
	 *@param ontId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the preparePropInferP_0_NO_WITH_1 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,PROPINFER)  		SELECT SUPER.ONT,SUB.PROP,SUPER.PROPINFER  		FROM {4}_PROP_INFER SUB, {0}{2} SUPER WHERE SUB.ONT=SUPER.ONT AND SUB.PROPINFER = SUPER.PROP AND  		NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUPER.ONT AND PROP=SUB.PROP AND PROPINFER=SUPER.PROPINFER) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempTable3 template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int preparePropInferP_0_NO_WITH_1 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempTable2, String tempTable3, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(preparePropInferP_0_NO_WITH_1, new String[] {sessionPrefix, tempTable, tempTable2, tempTable3, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"preparePropInferP_0_NO_WITH_1",stmtProvider.getSqlString(preparePropInferP_0_NO_WITH_1) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempTable2="+((tempTable2!=null)?tempTable2.toString():"null") + "," +"tempTable3="+((tempTable3!=null)?tempTable3.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[preparePropInferP_0_NO_WITH_1]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PreparePropInferP_0_NO_WITH_1 prepared statement
	 */
	public static class BatchPreparePropInferP_0_NO_WITH_1 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PreparePropInferP_0_NO_WITH_1 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempTable3 template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPreparePropInferP_0_NO_WITH_1(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempTable2, String tempTable3, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,preparePropInferP_0_NO_WITH_1,new String[] {sessionPrefix, tempTable, tempTable2, tempTable3, containerName});
		}
		
		/**
		 * Sets the input parameters for the preparePropInferP_0_NO_WITH_1 prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferO_0 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)  		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS  		(		SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER 				FROM {2}_OBJ_INFER INFER  				WHERE INFER.ONT=? AND INFER.OBJINFER=? 		UNION ALL  			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER 			FROM {2}_OBJ_INFER SUB, TEMPTAB SUPER  			WHERE  SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUPER.OBJ = SUB.OBJINFER  		)  		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param objectId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferO_0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long objectId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferO_0, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, objectId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferO_0",stmtProvider.getSqlString(prepareObjectInferO_0) ,""+ "ontId="+(ontId) + "," +"objectId="+(objectId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferO_0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferO_0 prepared statement
	 */
	public static class BatchPrepareObjectInferO_0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferO_0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferO_0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferO_0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferO_0 prepared statement.
		 *
	 *@param ontId template parameter
	 *@param objectId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long objectId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, objectId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferO_0_NO_WITH_0 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)  				SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER 				FROM {2}_OBJ_INFER INFER  				WHERE INFER.ONT=? AND INFER.OBJINFER=?		 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param objectId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferO_0_NO_WITH_0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long objectId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferO_0_NO_WITH_0, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, objectId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferO_0_NO_WITH_0",stmtProvider.getSqlString(prepareObjectInferO_0_NO_WITH_0) ,""+ "ontId="+(ontId) + "," +"objectId="+(objectId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferO_0_NO_WITH_0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferO_0_NO_WITH_0 prepared statement
	 */
	public static class BatchPrepareObjectInferO_0_NO_WITH_0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferO_0_NO_WITH_0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferO_0_NO_WITH_0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferO_0_NO_WITH_0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferO_0_NO_WITH_0 prepared statement.
		 *
	 *@param ontId template parameter
	 *@param objectId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long objectId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, objectId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferO_0_NO_WITH_1 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)  			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER 			FROM {4}_OBJ_INFER SUB, {0}{2} SUPER  			WHERE SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUPER.OBJ = SUB.OBJINFER AND 			NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUB.ONT AND PROP=SUB.PROP AND OBJ=SUB.OBJ AND OBJINFER=SUPER.OBJINFER) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempTable3 template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferO_0_NO_WITH_1 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempTable2, String tempTable3, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferO_0_NO_WITH_1, new String[] {sessionPrefix, tempTable, tempTable2, tempTable3, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferO_0_NO_WITH_1",stmtProvider.getSqlString(prepareObjectInferO_0_NO_WITH_1) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempTable2="+((tempTable2!=null)?tempTable2.toString():"null") + "," +"tempTable3="+((tempTable3!=null)?tempTable3.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferO_0_NO_WITH_1]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferO_0_NO_WITH_1 prepared statement
	 */
	public static class BatchPrepareObjectInferO_0_NO_WITH_1 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferO_0_NO_WITH_1 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempTable3 template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferO_0_NO_WITH_1(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempTable2, String tempTable3, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferO_0_NO_WITH_1,new String[] {sessionPrefix, tempTable, tempTable2, tempTable3, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferO_0_NO_WITH_1 prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferO_1 prepared statement.
	  * <code>
	 * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS  		(		SELECT PI.ONT,PI.PROP,OI.OBJ,OI.OBJINFER  				FROM {0}{1} OI,{2}_PROP_INFER PI  				WHERE PI.PROPINFER=OI.PROP AND OI.ONT=? AND PI.ONT=OI.ONT AND OI.OBJINFER=? 			UNION ALL  				SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER 				FROM {2}_PROP_INFER PI_SUB,TEMPTAB SUPER  				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER 		)  		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param objectId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferO_1 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long objectId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferO_1, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, objectId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferO_1",stmtProvider.getSqlString(prepareObjectInferO_1) ,""+ "ontId="+(ontId) + "," +"objectId="+(objectId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferO_1]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferO_1 prepared statement
	 */
	public static class BatchPrepareObjectInferO_1 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferO_1 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferO_1(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferO_1,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferO_1 prepared statement.
		 *
	 *@param ontId template parameter
	 *@param objectId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long objectId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, objectId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferO_1_NO_WITH_0 prepared statement.
	  * <code>
	 * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)  				SELECT PI.ONT,PI.PROPINFER,OI.OBJ,OI.OBJINFER  				FROM {2}_OBJ_INFER OI,{2}_PROP_INFER PI  				WHERE PI.PROP=OI.PROP AND OI.ONT=? AND OI.OBJINFER=?			 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param objectId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferO_1_NO_WITH_0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long objectId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferO_1_NO_WITH_0, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, objectId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferO_1_NO_WITH_0",stmtProvider.getSqlString(prepareObjectInferO_1_NO_WITH_0) ,""+ "ontId="+(ontId) + "," +"objectId="+(objectId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferO_1_NO_WITH_0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferO_1_NO_WITH_0 prepared statement
	 */
	public static class BatchPrepareObjectInferO_1_NO_WITH_0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferO_1_NO_WITH_0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferO_1_NO_WITH_0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferO_1_NO_WITH_0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferO_1_NO_WITH_0 prepared statement.
		 *
	 *@param ontId template parameter
	 *@param objectId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long objectId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, objectId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferO_1_NO_WITH_1 prepared statement.
	  * <code>
	 * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER)  			SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER  				FROM {2}_PROP_INFER PI_SUB,{0}{2} SUPER  				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER AND 			NOT EXISTS(SELECT * FROM {0}{3} WHERE PROP=PI_SUB.PROP AND ONT=SUPER.ONT AND OBJ=SUPER.OBJ AND OBJINFER=SUPER.OBJINFER) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempTable3 template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferO_1_NO_WITH_1 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempTable2, String tempTable3, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferO_1_NO_WITH_1, new String[] {sessionPrefix, tempTable, tempTable2, tempTable3, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferO_1_NO_WITH_1",stmtProvider.getSqlString(prepareObjectInferO_1_NO_WITH_1) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempTable2="+((tempTable2!=null)?tempTable2.toString():"null") + "," +"tempTable3="+((tempTable3!=null)?tempTable3.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferO_1_NO_WITH_1]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferO_1_NO_WITH_1 prepared statement
	 */
	public static class BatchPrepareObjectInferO_1_NO_WITH_1 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferO_1_NO_WITH_1 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempTable3 template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferO_1_NO_WITH_1(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempTable2, String tempTable3, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferO_1_NO_WITH_1,new String[] {sessionPrefix, tempTable, tempTable2, tempTable3, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferO_1_NO_WITH_1 prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferPO_0 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS  		(		 			SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER 			FROM {2}_OBJ_INFER INFER   			WHERE INFER.ONT=? AND INFER.PROP=? AND INFER.OBJINFER=? 			UNION ALL  			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER 			FROM {2}_OBJ_INFER SUB, TEMPTAB SUPER  			WHERE SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUB.OBJINFER = SUPER.OBJ  		)  		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objectId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferPO_0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, long objectId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferPO_0, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objectId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferPO_0",stmtProvider.getSqlString(prepareObjectInferPO_0) ,""+ "ontId="+(ontId) + "," +"propId="+(propId) + "," +"objectId="+(objectId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferPO_0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferPO_0 prepared statement
	 */
	public static class BatchPrepareObjectInferPO_0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferPO_0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferPO_0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferPO_0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferPO_0 prepared statement.
		 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objectId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long propId, long objectId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objectId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferPO_0_NO_WITH_0 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 				SELECT INFER.ONT,INFER.PROP,INFER.OBJ,INFER.OBJINFER 				FROM {2}_OBJ_INFER INFER   				WHERE INFER.ONT=? AND INFER.PROP=? AND INFER.OBJINFER=?		 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objectId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferPO_0_NO_WITH_0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, long objectId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferPO_0_NO_WITH_0, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objectId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferPO_0_NO_WITH_0",stmtProvider.getSqlString(prepareObjectInferPO_0_NO_WITH_0) ,""+ "ontId="+(ontId) + "," +"propId="+(propId) + "," +"objectId="+(objectId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferPO_0_NO_WITH_0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferPO_0_NO_WITH_0 prepared statement
	 */
	public static class BatchPrepareObjectInferPO_0_NO_WITH_0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferPO_0_NO_WITH_0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferPO_0_NO_WITH_0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferPO_0_NO_WITH_0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferPO_0_NO_WITH_0 prepared statement.
		 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objectId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long propId, long objectId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objectId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferPO_0_NO_WITH_1 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 			SELECT SUB.ONT,SUB.PROP,SUB.OBJ,SUPER.OBJINFER 			FROM {4}_OBJ_INFER SUB, {0}{2} SUPER  			WHERE SUB.ONT=SUPER.ONT AND SUB.PROP=SUPER.PROP AND SUB.OBJINFER = SUPER.OBJ AND 			NOT EXISTS(SELECT * FROM {0}{3} SUB2 WHERE SUB2.ONT=SUB.ONT AND SUB2.PROP=SUB.PROP AND SUB2.OBJ=SUB.OBJ AND SUB2.OBJINFER=SUPER.OBJINFER) 		 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable3 template parameter
	 *@param tempTable2 template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferPO_0_NO_WITH_1 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempTable3, String tempTable2, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferPO_0_NO_WITH_1, new String[] {sessionPrefix, tempTable, tempTable3, tempTable2, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferPO_0_NO_WITH_1",stmtProvider.getSqlString(prepareObjectInferPO_0_NO_WITH_1) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempTable3="+((tempTable3!=null)?tempTable3.toString():"null") + "," +"tempTable2="+((tempTable2!=null)?tempTable2.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferPO_0_NO_WITH_1]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferPO_0_NO_WITH_1 prepared statement
	 */
	public static class BatchPrepareObjectInferPO_0_NO_WITH_1 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferPO_0_NO_WITH_1 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable3 template parameter
	 *@param tempTable2 template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferPO_0_NO_WITH_1(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempTable3, String tempTable2, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferPO_0_NO_WITH_1,new String[] {sessionPrefix, tempTable, tempTable3, tempTable2, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferPO_0_NO_WITH_1 prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferPO_1 prepared statement.
	  * <code>
	 * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 		WITH TEMPTAB(ONT,PROP,OBJ,OBJINFER) AS  		(		SELECT PI.ONT,PI.PROP,OI.OBJ,OI.OBJINFER  				FROM {0}{1} OI,{2}_PROP_INFER PI  				WHERE PI.PROPINFER=OI.PROP AND OI.ONT=? AND PI.ONT=OI.ONT AND PI.PROPINFER=? AND OI.OBJINFER=? 			UNION ALL  				SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER 				FROM {2}_PROP_INFER PI_SUB,TEMPTAB SUPER  				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER 		)  		SELECT DISTINCT ONT,PROP,OBJ,OBJINFER FROM TEMPTAB ORDER BY PROP,OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objectId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferPO_1 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, long objectId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferPO_1, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objectId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferPO_1",stmtProvider.getSqlString(prepareObjectInferPO_1) ,""+ "ontId="+(ontId) + "," +"propId="+(propId) + "," +"objectId="+(objectId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferPO_1]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferPO_1 prepared statement
	 */
	public static class BatchPrepareObjectInferPO_1 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferPO_1 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferPO_1(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferPO_1,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferPO_1 prepared statement.
		 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objectId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long propId, long objectId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objectId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferPO_1_NO_WITH_0 prepared statement.
	  * <code>
	 * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 				SELECT PI.ONT,PI.PROPINFER,OI.OBJ,OI.OBJINFER  				FROM {2}_OBJ_INFER OI,{2}_PROP_INFER PI  				WHERE PI.PROP=OI.PROP AND OI.ONT=? AND OI.PROP=? AND OI.OBJINFER=?			 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objectId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferPO_1_NO_WITH_0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ontId, long propId, long objectId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferPO_1_NO_WITH_0, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objectId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferPO_1_NO_WITH_0",stmtProvider.getSqlString(prepareObjectInferPO_1_NO_WITH_0) ,""+ "ontId="+(ontId) + "," +"propId="+(propId) + "," +"objectId="+(objectId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferPO_1_NO_WITH_0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferPO_1_NO_WITH_0 prepared statement
	 */
	public static class BatchPrepareObjectInferPO_1_NO_WITH_0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferPO_1_NO_WITH_0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferPO_1_NO_WITH_0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferPO_1_NO_WITH_0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferPO_1_NO_WITH_0 prepared statement.
		 *
	 *@param ontId template parameter
	 *@param propId template parameter
	 *@param objectId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ontId, long propId, long objectId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ontId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objectId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the prepareObjectInferPO_1_NO_WITH_1 prepared statement.
	  * <code>
	 * 	 		INSERT INTO {0}{1}(ONT,PROP,OBJ,OBJINFER) 				SELECT PI_SUB.ONT,PI_SUB.PROP,SUPER.OBJ,SUPER.OBJINFER  				FROM {2}_PROP_INFER PI_SUB,{0}{2} SUPER  				WHERE PI_SUB.ONT=SUPER.ONT AND SUPER.PROP=PI_SUB.PROPINFER 				NOT EXISTS(SELECT * FROM {0}{3} WHERE ONT=SUPER.ONT AND PROP=PI_SUB.PROP AND OBJ=SUPER.OBJ AND OBJINFER=SUPER.OBJINFER) 		 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempTable3 template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int prepareObjectInferPO_1_NO_WITH_1 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempTable2, String tempTable3, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(prepareObjectInferPO_1_NO_WITH_1, new String[] {sessionPrefix, tempTable, tempTable2, tempTable3, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"prepareObjectInferPO_1_NO_WITH_1",stmtProvider.getSqlString(prepareObjectInferPO_1_NO_WITH_1) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempTable2="+((tempTable2!=null)?tempTable2.toString():"null") + "," +"tempTable3="+((tempTable3!=null)?tempTable3.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[prepareObjectInferPO_1_NO_WITH_1]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PrepareObjectInferPO_1_NO_WITH_1 prepared statement
	 */
	public static class BatchPrepareObjectInferPO_1_NO_WITH_1 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PrepareObjectInferPO_1_NO_WITH_1 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempTable3 template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPrepareObjectInferPO_1_NO_WITH_1(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempTable2, String tempTable3, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,prepareObjectInferPO_1_NO_WITH_1,new String[] {sessionPrefix, tempTable, tempTable2, tempTable3, containerName});
		}
		
		/**
		 * Sets the input parameters for the prepareObjectInferPO_1_NO_WITH_1 prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindNP prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.NAMEDGRAPHID=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedGraphId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindNP (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedGraphId, long propId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindNP, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindNP",stmtProvider.getSqlString(insertFindNP) ,""+ "namedGraphId="+(namedGraphId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindNP]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindNP prepared statement
	 */
	public static class BatchInsertFindNP extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindNP prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindNP(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindNP,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindNP prepared statement.
		 *
	 *@param namedGraphId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedGraphId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindP prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindP (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long propId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindP, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindP",stmtProvider.getSqlString(insertFindP) ,""+ "propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindP]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindP prepared statement
	 */
	public static class BatchInsertFindP extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindP prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindP(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindP,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindP prepared statement.
		 *
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindPMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.METADATA=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindPMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long propId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindPMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindPMETA",stmtProvider.getSqlString(insertFindPMETA) ,""+ "meta="+(meta) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindPMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindPMETA prepared statement
	 */
	public static class BatchInsertFindPMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindPMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindPMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindPMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindPMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindNSP prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedGraphId template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindNSP (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedGraphId, long subjId, long propId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindNSP, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindNSP",stmtProvider.getSqlString(insertFindNSP) ,""+ "namedGraphId="+(namedGraphId) + "," +"subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindNSP]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindNSP prepared statement
	 */
	public static class BatchInsertFindNSP extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindNSP prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindNSP(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindNSP,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindNSP prepared statement.
		 *
	 *@param namedGraphId template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedGraphId, long subjId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindSP prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.SUBJ=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindSP (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long propId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindSP, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindSP",stmtProvider.getSqlString(insertFindSP) ,""+ "subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindSP]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindSP prepared statement
	 */
	public static class BatchInsertFindSP extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindSP prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindSP(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindSP,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindSP prepared statement.
		 *
	 *@param subjId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindSPMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER WHERE S.METADATA=? AND S.SUBJ=? AND INFER.PROPINFER=? AND S.PROP=INFER.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindSPMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long propId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindSPMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindSPMETA",stmtProvider.getSqlString(insertFindSPMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindSPMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindSPMETA prepared statement
	 */
	public static class BatchInsertFindSPMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindSPMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindSPMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindSPMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindSPMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindNO prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) 		SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,QUERY.OBJ  FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedGraphId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindNO (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedGraphId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindNO, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedGraphId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindNO",stmtProvider.getSqlString(insertFindNO) ,""+ "namedGraphId="+(namedGraphId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindNO]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindNO prepared statement
	 */
	public static class BatchInsertFindNO extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindNO prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindNO(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindNO,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindNO prepared statement.
		 *
	 *@param namedGraphId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedGraphId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedGraphId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindO prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE  INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindO (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long objId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindO, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindO",stmtProvider.getSqlString(insertFindO) ,""+ "objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindO]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindO prepared statement
	 */
	public static class BatchInsertFindO extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindO prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindO(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindO,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindO prepared statement.
		 *
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindOMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE  S.METADATA=? AND INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindOMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long objId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindOMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindOMETA",stmtProvider.getSqlString(insertFindOMETA) ,""+ "meta="+(meta) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindOMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindOMETA prepared statement
	 */
	public static class BatchInsertFindOMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindOMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindOMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindOMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindOMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindNSO prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedGraphId template parameter
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindNSO (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedGraphId, long subjId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindNSO, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, subjId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindNSO",stmtProvider.getSqlString(insertFindNSO) ,""+ "namedGraphId="+(namedGraphId) + "," +"subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindNSO]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindNSO prepared statement
	 */
	public static class BatchInsertFindNSO extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindNSO prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindNSO(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindNSO,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindNSO prepared statement.
		 *
	 *@param namedGraphId template parameter
	 *@param subjId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedGraphId, long subjId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, subjId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindSO prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE S.SUBJ=? AND INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindSO (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long objId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindSO, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindSO",stmtProvider.getSqlString(insertFindSO) ,""+ "subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindSO]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindSO prepared statement
	 */
	public static class BatchInsertFindSO extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindSO prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindSO(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindSO,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindSO prepared statement.
		 *
	 *@param subjId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindSOMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER WHERE S.METADATA=? AND S.SUBJ=? AND INFER.PROP=S.PROP AND INFER.OBJINFER=? AND S.OBJ=INFER.OBJ	 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindSOMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long objId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindSOMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindSOMETA",stmtProvider.getSqlString(insertFindSOMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindSOMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindSOMETA prepared statement
	 */
	public static class BatchInsertFindSOMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindSOMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindSOMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindSOMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindSOMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindNPO_O prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ)  		SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.PROP=S.PROP AND QUERY.OBJ=INFER.OBJINFER 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedGraphId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindNPO_O (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedGraphId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindNPO_O, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedGraphId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindNPO_O",stmtProvider.getSqlString(insertFindNPO_O) ,""+ "namedGraphId="+(namedGraphId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindNPO_O]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindNPO_O prepared statement
	 */
	public static class BatchInsertFindNPO_O extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindNPO_O prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindNPO_O(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindNPO_O,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindNPO_O prepared statement.
		 *
	 *@param namedGraphId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedGraphId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedGraphId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindNPO_P prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ AND QUERY.PROP=INFER.PROPINFER 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedGraphId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindNPO_P (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedGraphId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindNPO_P, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedGraphId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindNPO_P",stmtProvider.getSqlString(insertFindNPO_P) ,""+ "namedGraphId="+(namedGraphId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindNPO_P]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindNPO_P prepared statement
	 */
	public static class BatchInsertFindNPO_P extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindNPO_P prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindNPO_P(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindNPO_P,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindNPO_P prepared statement.
		 *
	 *@param namedGraphId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedGraphId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedGraphId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindPO_O prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.PROP=INFER.PROP A AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindPO_O (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindPO_O, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindPO_O",stmtProvider.getSqlString(insertFindPO_O) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindPO_O]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindPO_O prepared statement
	 */
	public static class BatchInsertFindPO_O extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindPO_O prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindPO_O(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindPO_O,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindPO_O prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindPO_OMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.METADATA=? AND S.PROP=INFER.PROP A AND S.OBJ=INFER.OBJ AND QUERY.PROP=SUBJ.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindPO_OMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindPO_OMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindPO_OMETA",stmtProvider.getSqlString(insertFindPO_OMETA) ,""+ "meta="+(meta),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindPO_OMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindPO_OMETA prepared statement
	 */
	public static class BatchInsertFindPO_OMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindPO_OMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindPO_OMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindPO_OMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindPO_OMETA prepared statement.
		 *
	 *@param meta template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindPO_P prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {2}_S S,{0}{2}  INFER WHERE S.PROP=INFER.PROP AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindPO_P (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long objId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindPO_P, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindPO_P",stmtProvider.getSqlString(insertFindPO_P) ,""+ "objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindPO_P]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindPO_P prepared statement
	 */
	public static class BatchInsertFindPO_P extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindPO_P prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindPO_P(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindPO_P,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindPO_P prepared statement.
		 *
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindPO_PMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {2}_S S,{0}{2}  INFER WHERE S.METADATA=? AND S.PROP=INFER.PROP AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindPO_PMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long objId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindPO_PMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindPO_PMETA",stmtProvider.getSqlString(insertFindPO_PMETA) ,""+ "meta="+(meta) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindPO_PMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindPO_PMETA prepared statement
	 */
	public static class BatchInsertFindPO_PMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindPO_PMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindPO_PMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindPO_PMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindPO_PMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindNSPO_O prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=? AND S.SUBJ=QUERY.SUBJ AND  S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedGraphId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindNSPO_O (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedGraphId, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindNSPO_O, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedGraphId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindNSPO_O",stmtProvider.getSqlString(insertFindNSPO_O) ,""+ "namedGraphId="+(namedGraphId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindNSPO_O]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindNSPO_O prepared statement
	 */
	public static class BatchInsertFindNSPO_O extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindNSPO_O prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindNSPO_O(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindNSPO_O,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindNSPO_O prepared statement.
		 *
	 *@param namedGraphId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedGraphId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedGraphId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindSPO_O prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE  S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindSPO_O (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindSPO_O, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindSPO_O",stmtProvider.getSqlString(insertFindSPO_O) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindSPO_O]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindSPO_O prepared statement
	 */
	public static class BatchInsertFindSPO_O extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindSPO_O prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindSPO_O(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindSPO_O,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindSPO_O prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindSPO_OMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.METADATA=? AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindSPO_OMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindSPO_OMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindSPO_OMETA",stmtProvider.getSqlString(insertFindSPO_OMETA) ,""+ "meta="+(meta),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindSPO_OMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindSPO_OMETA prepared statement
	 */
	public static class BatchInsertFindSPO_OMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindSPO_OMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindSPO_OMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindSPO_OMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindSPO_OMETA prepared statement.
		 *
	 *@param meta template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindNSPO_P prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,QUERY.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.NAMEDGRAPHID=QUERY.NAMEDGRAPHID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindNSPO_P (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindNSPO_P, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindNSPO_P",stmtProvider.getSqlString(insertFindNSPO_P) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindNSPO_P]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindNSPO_P prepared statement
	 */
	public static class BatchInsertFindNSPO_P extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindNSPO_P prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindNSPO_P(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindNSPO_P,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindNSPO_P prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindSPO_P prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY  WHERE S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindSPO_P (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindSPO_P, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindSPO_P",stmtProvider.getSqlString(insertFindSPO_P) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindSPO_P]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindSPO_P prepared statement
	 */
	public static class BatchInsertFindSPO_P extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindSPO_P prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindSPO_P(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindSPO_P,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindSPO_P prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindSPO_PMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}QUERY QUERY WHERE S.METADATA=? AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=QUERY.OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindSPO_PMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindSPO_PMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindSPO_PMETA",stmtProvider.getSqlString(insertFindSPO_PMETA) ,""+ "meta="+(meta),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindSPO_PMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindSPO_PMETA prepared statement
	 */
	public static class BatchInsertFindSPO_PMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindSPO_PMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindSPO_PMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindSPO_PMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName});
		}
		
		/**
		 * Sets the input parameters for the insertFindSPO_PMETA prepared statement.
		 *
	 *@param meta template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMP prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND S.NAMEDGRAPHID=GRAPHS.ID  AND S.PROP=INFER.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMP (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMP, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMP",stmtProvider.getSqlString(insertFindMP) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMP]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMP prepared statement
	 */
	public static class BatchInsertFindMP extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMP prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMP(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMP,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMP prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMSP prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMSP (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMSP, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setLong(argc++, subjId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMSP",stmtProvider.getSqlString(insertFindMSP) ,""+ "subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMSP]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMSP prepared statement
	 */
	public static class BatchInsertFindMSP extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMSP prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMSP(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMSP,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMSP prepared statement.
		 *
	 *@param subjId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMO prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND INFER.PROP=S.PROP AND  S.OBJ=INFER.OBJ	 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMO (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMO, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMO",stmtProvider.getSqlString(insertFindMO) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMO]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMO prepared statement
	 */
	public static class BatchInsertFindMO extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMO prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMO(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMO,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMO prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMSO prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMSO (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMSO, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMSO",stmtProvider.getSqlString(insertFindMSO) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMSO]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMSO prepared statement
	 */
	public static class BatchInsertFindMSO extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMSO prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMSO(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMSO,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMSO prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMPO_O prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMPO_O (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMPO_O, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMPO_O",stmtProvider.getSqlString(insertFindMPO_O) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMPO_O]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMPO_O prepared statement
	 */
	public static class BatchInsertFindMPO_O extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMPO_O prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMPO_O(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMPO_O,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMPO_O prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMPO_P prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMPO_P (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long objId, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMPO_P, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMPO_P",stmtProvider.getSqlString(insertFindMPO_P) ,""+ "objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMPO_P]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMPO_P prepared statement
	 */
	public static class BatchInsertFindMPO_P extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMPO_P prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMPO_P(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMPO_P,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMPO_P prepared statement.
		 *
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMSPO_O prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,QUERY.SUBJ,QUERY.PROP,QUERY.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMSPO_O (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMSPO_O, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMSPO_O",stmtProvider.getSqlString(insertFindMSPO_O) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMSPO_O]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMSPO_O prepared statement
	 */
	public static class BatchInsertFindMSPO_O extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMSPO_O prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMSPO_O(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMSPO_O,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMSPO_O prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMSPO_P prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMSPO_P (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long objId, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMSPO_P, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMSPO_P",stmtProvider.getSqlString(insertFindMSPO_P) ,""+ "subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMSPO_P]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMSPO_P prepared statement
	 */
	public static class BatchInsertFindMSPO_P extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMSPO_P prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMSPO_P(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMSPO_P,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMSPO_P prepared statement.
		 *
	 *@param subjId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMPMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMPMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMPMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setInt(argc++, meta);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMPMETA",stmtProvider.getSqlString(insertFindMPMETA) ,""+ "meta="+(meta),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMPMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMPMETA prepared statement
	 */
	public static class BatchInsertFindMPMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMPMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMPMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMPMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMPMETA prepared statement.
		 *
	 *@param meta template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMSPMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMSPMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMSPMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMSPMETA",stmtProvider.getSqlString(insertFindMSPMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMSPMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMSPMETA prepared statement
	 */
	public static class BatchInsertFindMSPMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMSPMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMSPMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMSPMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMSPMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMOMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND INFER.PROP=S.PROP AND S.OBJ=INFER.OBJ	AND QUERY.OBJ=INFER.OBJINFER 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMOMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMOMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setInt(argc++, meta);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMOMETA",stmtProvider.getSqlString(insertFindMOMETA) ,""+ "meta="+(meta),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMOMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMOMETA prepared statement
	 */
	public static class BatchInsertFindMOMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMOMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMOMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMOMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMOMETA prepared statement.
		 *
	 *@param meta template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMSOMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER	 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMSOMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMSOMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setInt(argc++, meta);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMSOMETA",stmtProvider.getSqlString(insertFindMSOMETA) ,""+ "meta="+(meta),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMSOMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMSOMETA prepared statement
	 */
	public static class BatchInsertFindMSOMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMSOMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMSOMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMSOMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMSOMETA prepared statement.
		 *
	 *@param meta template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMPO_OMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMPO_OMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMPO_OMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setInt(argc++, meta);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMPO_OMETA",stmtProvider.getSqlString(insertFindMPO_OMETA) ,""+ "meta="+(meta),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMPO_OMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMPO_OMETA prepared statement
	 */
	public static class BatchInsertFindMPO_OMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMPO_OMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMPO_OMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMPO_OMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMPO_OMETA prepared statement.
		 *
	 *@param meta template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMPO_PMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.PROP=INFER.PROP AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMPO_PMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long objId, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMPO_PMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMPO_PMETA",stmtProvider.getSqlString(insertFindMPO_PMETA) ,""+ "meta="+(meta) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMPO_PMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMPO_PMETA prepared statement
	 */
	public static class BatchInsertFindMPO_PMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMPO_PMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMPO_PMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMPO_PMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMPO_PMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMSPO_OMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,QUERY.PROP,INFER.OBJINFER FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS,{0}QUERY QUERY WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=QUERY.SUBJ AND S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ AND QUERY.OBJ=INFER.OBJINFER 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMSPO_OMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMSPO_OMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setInt(argc++, meta);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMSPO_OMETA",stmtProvider.getSqlString(insertFindMSPO_OMETA) ,""+ "meta="+(meta),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMSPO_OMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMSPO_OMETA prepared statement
	 */
	public static class BatchInsertFindMSPO_OMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMSPO_OMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMSPO_OMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMSPO_OMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMSPO_OMETA prepared statement.
		 *
	 *@param meta template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFindMSPO_PMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {3}_S S,{0}{2} INFER,{0}{4} GRAPHS WHERE S.METADATA=? AND S.METADATA=GRAPHS.METADATA AND  S.NAMEDGRAPHID=GRAPHS.ID AND S.SUBJ=? AND S.PROP=INFER.PROP AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFindMSPO_PMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long objId, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFindMSPO_PMETA, new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFindMSPO_PMETA",stmtProvider.getSqlString(insertFindMSPO_PMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTempTable="+((graphTempTable!=null)?graphTempTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFindMSPO_PMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFindMSPO_PMETA prepared statement
	 */
	public static class BatchInsertFindMSPO_PMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFindMSPO_PMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param graphTempTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFindMSPO_PMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String tempInferName, String containerName, String graphTempTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFindMSPO_PMETA,new String[] {sessionPrefix, tempTable, tempInferName, containerName, graphTempTable});
		}
		
		/**
		 * Sets the input parameters for the insertFindMSPO_PMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectS prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectSResult> transformSelectS = new org.openanzo.jdbc.utils.Transformer<SelectSResult>(){
		public SelectSResult transform(java.sql.ResultSet rs) {

			
				SelectSResult result = new SelectSResult();
				try {
				result.namedgraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedgraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subjId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subjId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.propId=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:propId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.objId=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:objId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectS prepared statement.
	  * <code>
	 *  	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1} 	 UNION 	 SELECT DISTINCT S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {0}{4} S,{3}_OBJ_INFER INFER WHERE S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	 UNION 	 SELECT DISTINCT S2.NAMEDGRAPHID,S2.SUBJ,PI.PROPINFER,OI.OBJINFER FROM {0}{5} S2,{3}_OBJ_INFER OI,{3}_PROP_INFER PI WHERE S2.PROP=PI.PROP AND S2.OBJ=OI.OBJ AND PI.PROPINFER=OI.PROP 	 UNION 	 SELECT DISTINCT S3.NAMEDGRAPHID,S3.SUBJ,INFER.PROPINFER,S3.OBJ FROM {0}{6} S3,{0}{2} INFER WHERE S3.PROP=INFER.PROP; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempInferName template parameter
	 *@param containerName template parameter
	 *@param tempInferName2 template parameter
	 *@param tempInferName3 template parameter
	 *@param tempInferName4 template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectSResult> selectS (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempInferName, String containerName, String tempInferName2, String tempInferName3, String tempInferName4) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectS, new String[] {sessionPrefix, tempTable, tempInferName, containerName, tempInferName2, tempInferName3, tempInferName4},connection);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<SelectSResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectSResult>(rs, ps, stmtProvider, transformSelectS);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectS",stmtProvider.getSqlString(selectS) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempInferName="+((tempInferName!=null)?tempInferName.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"tempInferName2="+((tempInferName2!=null)?tempInferName2.toString():"null") + "," +"tempInferName3="+((tempInferName3!=null)?tempInferName3.toString():"null") + "," +"tempInferName4="+((tempInferName4!=null)?tempInferName4.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectS]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectSResult
	 */
	public static class SelectSResult {
			/**Value for the "namedgraphId" result value*/
			private long namedgraphId;
			/**Value for the "subjId" result value*/
			private long subjId;
			/**Value for the "propId" result value*/
			private long propId;
			/**Value for the "objId" result value*/
			private long objId;

		/**
		  *Get NamedgraphId value
		  *@return NamedgraphId value
		  */
			public long getNamedgraphId() {
				return this.namedgraphId;
			}

		/**
		  *Get SubjId value
		  *@return SubjId value
		  */
			public long getSubjId() {
				return this.subjId;
			}

		/**
		  *Get PropId value
		  *@return PropId value
		  */
			public long getPropId() {
				return this.propId;
			}

		/**
		  *Get ObjId value
		  *@return ObjId value
		  */
			public long getObjId() {
				return this.objId;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the selectP prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectPResult> transformSelectP = new org.openanzo.jdbc.utils.Transformer<SelectPResult>(){
		public SelectPResult transform(java.sql.ResultSet rs) {

			
				SelectPResult result = new SelectPResult();
				try {
				result.namedgraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedgraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subjId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subjId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.propId=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:propId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.objId=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:objId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectP prepared statement.
	  * <code>
	 *  	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1} 	 UNION 	 SELECT DISTINCT S.NAMEDGRAPHID,S.SUBJ,S.PROP,INFER.OBJINFER FROM {0}{2} S,{3}_OBJ_INFER INFER WHERE S.PROP=INFER.PROP AND S.OBJ=INFER.OBJ 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectPResult> selectP (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempTable2, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectP, new String[] {sessionPrefix, tempTable, tempTable2, containerName},connection);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<SelectPResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectPResult>(rs, ps, stmtProvider, transformSelectP);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectP",stmtProvider.getSqlString(selectP) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempTable2="+((tempTable2!=null)?tempTable2.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectP]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectPResult
	 */
	public static class SelectPResult {
			/**Value for the "namedgraphId" result value*/
			private long namedgraphId;
			/**Value for the "subjId" result value*/
			private long subjId;
			/**Value for the "propId" result value*/
			private long propId;
			/**Value for the "objId" result value*/
			private long objId;

		/**
		  *Get NamedgraphId value
		  *@return NamedgraphId value
		  */
			public long getNamedgraphId() {
				return this.namedgraphId;
			}

		/**
		  *Get SubjId value
		  *@return SubjId value
		  */
			public long getSubjId() {
				return this.subjId;
			}

		/**
		  *Get PropId value
		  *@return PropId value
		  */
			public long getPropId() {
				return this.propId;
			}

		/**
		  *Get ObjId value
		  *@return ObjId value
		  */
			public long getObjId() {
				return this.objId;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the selectO prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectOResult> transformSelectO = new org.openanzo.jdbc.utils.Transformer<SelectOResult>(){
		public SelectOResult transform(java.sql.ResultSet rs) {

			
				SelectOResult result = new SelectOResult();
				try {
				result.namedgraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedgraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subjId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subjId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.propId=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:propId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.objId=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:objId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectO prepared statement.
	  * <code>
	 *  	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1} 	 UNION 	 SELECT DISTINCT S.NAMEDGRAPHID,S.SUBJ,INFER.PROPINFER,S.OBJ FROM {0}{2} S,{0}{3} INFER WHERE S.PROP=INFER.PROP; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param tempTable2 template parameter
	 *@param tempInferTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectOResult> selectO (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String tempTable2, String tempInferTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectO, new String[] {sessionPrefix, tempTable, tempTable2, tempInferTable, containerName},connection);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<SelectOResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectOResult>(rs, ps, stmtProvider, transformSelectO);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectO",stmtProvider.getSqlString(selectO) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"tempTable2="+((tempTable2!=null)?tempTable2.toString():"null") + "," +"tempInferTable="+((tempInferTable!=null)?tempInferTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectO]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectOResult
	 */
	public static class SelectOResult {
			/**Value for the "namedgraphId" result value*/
			private long namedgraphId;
			/**Value for the "subjId" result value*/
			private long subjId;
			/**Value for the "propId" result value*/
			private long propId;
			/**Value for the "objId" result value*/
			private long objId;

		/**
		  *Get NamedgraphId value
		  *@return NamedgraphId value
		  */
			public long getNamedgraphId() {
				return this.namedgraphId;
			}

		/**
		  *Get SubjId value
		  *@return SubjId value
		  */
			public long getSubjId() {
				return this.subjId;
			}

		/**
		  *Get PropId value
		  *@return PropId value
		  */
			public long getPropId() {
				return this.propId;
			}

		/**
		  *Get ObjId value
		  *@return ObjId value
		  */
			public long getObjId() {
				return this.objId;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the selectAll prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectAllResult> transformSelectAll = new org.openanzo.jdbc.utils.Transformer<SelectAllResult>(){
		public SelectAllResult transform(java.sql.ResultSet rs) {

			
				SelectAllResult result = new SelectAllResult();
				try {
				result.namedgraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedgraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subjId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subjId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.propId=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:propId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.objId=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:objId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectAll prepared statement.
	  * <code>
	 *  	 SELECT DISTINCT NAMEDGRAPHID,SUBJ,PROP,OBJ FROM {0}{1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectAllResult> selectAll (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectAll, new String[] {sessionPrefix, tempTable},connection);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<SelectAllResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectAllResult>(rs, ps, stmtProvider, transformSelectAll);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectAll",stmtProvider.getSqlString(selectAll) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectAll]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectAllResult
	 */
	public static class SelectAllResult {
			/**Value for the "namedgraphId" result value*/
			private long namedgraphId;
			/**Value for the "subjId" result value*/
			private long subjId;
			/**Value for the "propId" result value*/
			private long propId;
			/**Value for the "objId" result value*/
			private long objId;

		/**
		  *Get NamedgraphId value
		  *@return NamedgraphId value
		  */
			public long getNamedgraphId() {
				return this.namedgraphId;
			}

		/**
		  *Get SubjId value
		  *@return SubjId value
		  */
			public long getSubjId() {
				return this.subjId;
			}

		/**
		  *Get PropId value
		  *@return PropId value
		  */
			public long getPropId() {
				return this.propId;
			}

		/**
		  *Get ObjId value
		  *@return ObjId value
		  */
			public long getObjId() {
				return this.objId;
			}

	}



	
	/**
	 * Runs the insert0 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert0, new String[] {sessionPrefix, tempTable, containerName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert0",stmtProvider.getSqlString(insert0) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert0]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert0 prepared statement
	 */
	public static class BatchInsert0 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert0 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert0(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert0,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert0 prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert0META prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert0META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert0META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert0META",stmtProvider.getSqlString(insert0META) ,""+ "meta="+(meta),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert0META]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert0META prepared statement
	 */
	public static class BatchInsert0META extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert0META prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert0META(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert0META,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert0META prepared statement.
		 *
	 *@param meta template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert1 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert1 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert1, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert1",stmtProvider.getSqlString(insert1) ,""+ "namedgraphId="+(namedgraphId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert1]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert1 prepared statement
	 */
	public static class BatchInsert1 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert1 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert1(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert1,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert1 prepared statement.
		 *
	 *@param namedgraphId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedgraphId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedgraphId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert1M prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND  S.NAMEDGRAPHID=G.ID 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert1M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert1M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert1M",stmtProvider.getSqlString(insert1M) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert1M]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert1M prepared statement
	 */
	public static class BatchInsert1M extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert1M prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert1M(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert1M,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert1M prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert1MMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert1MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert1MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert1MMETA",stmtProvider.getSqlString(insert1MMETA) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert1MMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert1MMETA prepared statement
	 */
	public static class BatchInsert1MMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert1MMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert1MMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert1MMETA,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert1MMETA prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert2 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert2 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert2, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert2",stmtProvider.getSqlString(insert2) ,""+ "subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert2]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert2 prepared statement
	 */
	public static class BatchInsert2 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert2 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert2(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert2,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert2 prepared statement.
		 *
	 *@param subjId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert2META prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert2META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert2META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert2META",stmtProvider.getSqlString(insert2META) ,""+ "meta="+(meta) + "," +"subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert2META]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert2META prepared statement
	 */
	public static class BatchInsert2META extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert2META prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert2META(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert2META,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert2META prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert3 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert3 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long subjId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert3, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert3",stmtProvider.getSqlString(insert3) ,""+ "namedgraphId="+(namedgraphId) + "," +"subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert3]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert3 prepared statement
	 */
	public static class BatchInsert3 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert3 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert3(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert3,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert3 prepared statement.
		 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedgraphId, long subjId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert3M prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert3M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert3M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert3M",stmtProvider.getSqlString(insert3M) ,""+ "subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert3M]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert3M prepared statement
	 */
	public static class BatchInsert3M extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert3M prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert3M(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert3M,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert3M prepared statement.
		 *
	 *@param subjId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert3MMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert3MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert3MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert3MMETA",stmtProvider.getSqlString(insert3MMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert3MMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert3MMETA prepared statement
	 */
	public static class BatchInsert3MMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert3MMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert3MMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert3MMETA,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert3MMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert4 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert4 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert4, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert4",stmtProvider.getSqlString(insert4) ,""+ "propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert4]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert4 prepared statement
	 */
	public static class BatchInsert4 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert4 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert4(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert4,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert4 prepared statement.
		 *
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert4META prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert4META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert4META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert4META",stmtProvider.getSqlString(insert4META) ,""+ "meta="+(meta) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert4META]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert4META prepared statement
	 */
	public static class BatchInsert4META extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert4META prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert4META(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert4META,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert4META prepared statement.
		 *
	 *@param meta template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert5 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert5 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert5, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert5",stmtProvider.getSqlString(insert5) ,""+ "namedgraphId="+(namedgraphId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert5]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert5 prepared statement
	 */
	public static class BatchInsert5 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert5 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert5(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert5,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert5 prepared statement.
		 *
	 *@param namedgraphId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedgraphId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert5M prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert5M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long propId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert5M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert5M",stmtProvider.getSqlString(insert5M) ,""+ "propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert5M]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert5M prepared statement
	 */
	public static class BatchInsert5M extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert5M prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert5M(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert5M,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert5M prepared statement.
		 *
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert5MMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert5MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long propId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert5MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert5MMETA",stmtProvider.getSqlString(insert5MMETA) ,""+ "meta="+(meta) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert5MMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert5MMETA prepared statement
	 */
	public static class BatchInsert5MMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert5MMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert5MMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert5MMETA,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert5MMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert6 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert6 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert6, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert6",stmtProvider.getSqlString(insert6) ,""+ "subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert6]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert6 prepared statement
	 */
	public static class BatchInsert6 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert6 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert6(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert6,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert6 prepared statement.
		 *
	 *@param subjId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert6META prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert6META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert6META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert6META",stmtProvider.getSqlString(insert6META) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert6META]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert6META prepared statement
	 */
	public static class BatchInsert6META extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert6META prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert6META(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert6META,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert6META prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert7 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert7 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long subjId, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert7, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert7",stmtProvider.getSqlString(insert7) ,""+ "namedgraphId="+(namedgraphId) + "," +"subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert7]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert7 prepared statement
	 */
	public static class BatchInsert7 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert7 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert7(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert7,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert7 prepared statement.
		 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedgraphId, long subjId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert7M prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert7M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long propId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert7M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert7M",stmtProvider.getSqlString(insert7M) ,""+ "subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert7M]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert7M prepared statement
	 */
	public static class BatchInsert7M extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert7M prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert7M(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert7M,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert7M prepared statement.
		 *
	 *@param subjId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert7MMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert7MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long propId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert7MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert7MMETA",stmtProvider.getSqlString(insert7MMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert7MMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert7MMETA prepared statement
	 */
	public static class BatchInsert7MMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert7MMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert7MMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert7MMETA,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert7MMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId, long propId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert8 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert8 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert8, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert8",stmtProvider.getSqlString(insert8) ,""+ "objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert8]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert8 prepared statement
	 */
	public static class BatchInsert8 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert8 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert8(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert8,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert8 prepared statement.
		 *
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert8META prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert8META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert8META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert8META",stmtProvider.getSqlString(insert8META) ,""+ "meta="+(meta) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert8META]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert8META prepared statement
	 */
	public static class BatchInsert8META extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert8META prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert8META(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert8META,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert8META prepared statement.
		 *
	 *@param meta template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert9 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert9 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert9, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert9",stmtProvider.getSqlString(insert9) ,""+ "namedgraphId="+(namedgraphId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert9]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert9 prepared statement
	 */
	public static class BatchInsert9 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert9 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert9(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert9,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert9 prepared statement.
		 *
	 *@param namedgraphId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedgraphId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert9M prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert9M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert9M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert9M",stmtProvider.getSqlString(insert9M) ,""+ "objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert9M]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert9M prepared statement
	 */
	public static class BatchInsert9M extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert9M prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert9M(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert9M,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert9M prepared statement.
		 *
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert9MMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE  S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert9MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert9MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert9MMETA",stmtProvider.getSqlString(insert9MMETA) ,""+ "meta="+(meta) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert9MMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert9MMETA prepared statement
	 */
	public static class BatchInsert9MMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert9MMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert9MMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert9MMETA,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert9MMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert10 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert10 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert10, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert10",stmtProvider.getSqlString(insert10) ,""+ "subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert10]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert10 prepared statement
	 */
	public static class BatchInsert10 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert10 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert10(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert10,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert10 prepared statement.
		 *
	 *@param subjId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert10META prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert10META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert10META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert10META",stmtProvider.getSqlString(insert10META) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert10META]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert10META prepared statement
	 */
	public static class BatchInsert10META extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert10META prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert10META(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert10META,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert10META prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert11 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert11 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long subjId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert11, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert11",stmtProvider.getSqlString(insert11) ,""+ "namedgraphId="+(namedgraphId) + "," +"subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert11]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert11 prepared statement
	 */
	public static class BatchInsert11 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert11 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert11(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert11,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert11 prepared statement.
		 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedgraphId, long subjId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert11M prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert11M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert11M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert11M",stmtProvider.getSqlString(insert11M) ,""+ "subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert11M]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert11M prepared statement
	 */
	public static class BatchInsert11M extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert11M prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert11M(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert11M,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert11M prepared statement.
		 *
	 *@param subjId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert11MMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert11MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert11MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert11MMETA",stmtProvider.getSqlString(insert11MMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert11MMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert11MMETA prepared statement
	 */
	public static class BatchInsert11MMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert11MMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert11MMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert11MMETA,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert11MMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert12 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert12 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert12, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert12",stmtProvider.getSqlString(insert12) ,""+ "propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert12]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert12 prepared statement
	 */
	public static class BatchInsert12 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert12 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert12(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert12,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert12 prepared statement.
		 *
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert12META prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert12META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert12META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert12META",stmtProvider.getSqlString(insert12META) ,""+ "meta="+(meta) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert12META]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert12META prepared statement
	 */
	public static class BatchInsert12META extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert12META prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert12META(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert12META,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert12META prepared statement.
		 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert13 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert13 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert13, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert13",stmtProvider.getSqlString(insert13) ,""+ "namedgraphId="+(namedgraphId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert13]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert13 prepared statement
	 */
	public static class BatchInsert13 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert13 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert13(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert13,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert13 prepared statement.
		 *
	 *@param namedgraphId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedgraphId, long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert13M prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert13M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long propId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert13M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert13M",stmtProvider.getSqlString(insert13M) ,""+ "propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert13M]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert13M prepared statement
	 */
	public static class BatchInsert13M extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert13M prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert13M(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert13M,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert13M prepared statement.
		 *
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert13MMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert13MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long propId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert13MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert13MMETA",stmtProvider.getSqlString(insert13MMETA) ,""+ "meta="+(meta) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert13MMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert13MMETA prepared statement
	 */
	public static class BatchInsert13MMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert13MMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert13MMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert13MMETA,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert13MMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert14 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert14 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert14, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert14",stmtProvider.getSqlString(insert14) ,""+ "subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert14]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert14 prepared statement
	 */
	public static class BatchInsert14 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert14 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert14(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert14,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert14 prepared statement.
		 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId, long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert14META prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert14META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert14META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert14META",stmtProvider.getSqlString(insert14META) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert14META]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert14META prepared statement
	 */
	public static class BatchInsert14META extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert14META prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert14META(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert14META,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert14META prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId, long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert15 prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert15 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long subjId, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert15, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert15",stmtProvider.getSqlString(insert15) ,""+ "namedgraphId="+(namedgraphId) + "," +"subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert15]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert15 prepared statement
	 */
	public static class BatchInsert15 extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert15 prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert15(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert15,new String[] {sessionPrefix, tempTable, containerName});
		}
		
		/**
		 * Sets the input parameters for the insert15 prepared statement.
		 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedgraphId, long subjId, long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert15M prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert15M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long propId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert15M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert15M",stmtProvider.getSqlString(insert15M) ,""+ "subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert15M]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert15M prepared statement
	 */
	public static class BatchInsert15M extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert15M prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert15M(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert15M,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert15M prepared statement.
		 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long subjId, long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insert15MMETA prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1}(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insert15MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long propId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insert15MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insert15MMETA",stmtProvider.getSqlString(insert15MMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insert15MMETA]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Insert15MMETA prepared statement
	 */
	public static class BatchInsert15MMETA extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Insert15MMETA prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsert15MMETA(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insert15MMETA,new String[] {sessionPrefix, tempTable, containerName, graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insert15MMETA prepared statement.
		 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int meta, long subjId, long propId, long objId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the select0 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select0Result> transformSelect0 = new org.openanzo.jdbc.utils.Transformer<Select0Result>(){
		public Select0Result transform(java.sql.ResultSet rs) {

			
				Select0Result result = new Select0Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select0 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select0Result> select0 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select0, new String[] {sessionPrefix, tempTable, containerName},connection);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select0Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select0Result>(rs, ps, stmtProvider, transformSelect0);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select0",stmtProvider.getSqlString(select0) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select0]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select0Result
	 */
	public static class Select0Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select0META prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select0METAResult> transformSelect0META = new org.openanzo.jdbc.utils.Transformer<Select0METAResult>(){
		public Select0METAResult transform(java.sql.ResultSet rs) {

			
				Select0METAResult result = new Select0METAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select0META prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select0METAResult> select0META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select0META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select0METAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select0METAResult>(rs, ps, stmtProvider, transformSelect0META);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select0META",stmtProvider.getSqlString(select0META) ,""+ "meta="+(meta),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select0META]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select0METAResult
	 */
	public static class Select0METAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select1 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select1Result> transformSelect1 = new org.openanzo.jdbc.utils.Transformer<Select1Result>(){
		public Select1Result transform(java.sql.ResultSet rs) {

			
				Select1Result result = new Select1Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select1 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select1Result> select1 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select1, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select1Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select1Result>(rs, ps, stmtProvider, transformSelect1);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select1",stmtProvider.getSqlString(select1) ,""+ "namedgraphId="+(namedgraphId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select1]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select1Result
	 */
	public static class Select1Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select1M prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select1MResult> transformSelect1M = new org.openanzo.jdbc.utils.Transformer<Select1MResult>(){
		public Select1MResult transform(java.sql.ResultSet rs) {

			
				Select1MResult result = new Select1MResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select1M prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select1MResult> select1M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select1M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select1MResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select1MResult>(rs, ps, stmtProvider, transformSelect1M);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select1M",stmtProvider.getSqlString(select1M) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select1M]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select1MResult
	 */
	public static class Select1MResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select1MMETA prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select1MMETAResult> transformSelect1MMETA = new org.openanzo.jdbc.utils.Transformer<Select1MMETAResult>(){
		public Select1MMETAResult transform(java.sql.ResultSet rs) {

			
				Select1MMETAResult result = new Select1MMETAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select1MMETA prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select1MMETAResult> select1MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select1MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select1MMETAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select1MMETAResult>(rs, ps, stmtProvider, transformSelect1MMETA);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select1MMETA",stmtProvider.getSqlString(select1MMETA) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select1MMETA]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select1MMETAResult
	 */
	public static class Select1MMETAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select2 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select2Result> transformSelect2 = new org.openanzo.jdbc.utils.Transformer<Select2Result>(){
		public Select2Result transform(java.sql.ResultSet rs) {

			
				Select2Result result = new Select2Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select2 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select2Result> select2 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select2, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select2Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select2Result>(rs, ps, stmtProvider, transformSelect2);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select2",stmtProvider.getSqlString(select2) ,""+ "subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select2]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select2Result
	 */
	public static class Select2Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select2META prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select2METAResult> transformSelect2META = new org.openanzo.jdbc.utils.Transformer<Select2METAResult>(){
		public Select2METAResult transform(java.sql.ResultSet rs) {

			
				Select2METAResult result = new Select2METAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select2META prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select2METAResult> select2META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select2META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select2METAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select2METAResult>(rs, ps, stmtProvider, transformSelect2META);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select2META",stmtProvider.getSqlString(select2META) ,""+ "meta="+(meta) + "," +"subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select2META]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select2METAResult
	 */
	public static class Select2METAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select3 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select3Result> transformSelect3 = new org.openanzo.jdbc.utils.Transformer<Select3Result>(){
		public Select3Result transform(java.sql.ResultSet rs) {

			
				Select3Result result = new Select3Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select3 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select3Result> select3 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long subjId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select3, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select3Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select3Result>(rs, ps, stmtProvider, transformSelect3);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select3",stmtProvider.getSqlString(select3) ,""+ "namedgraphId="+(namedgraphId) + "," +"subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select3]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select3Result
	 */
	public static class Select3Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select3M prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select3MResult> transformSelect3M = new org.openanzo.jdbc.utils.Transformer<Select3MResult>(){
		public Select3MResult transform(java.sql.ResultSet rs) {

			
				Select3MResult result = new Select3MResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select3M prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select3MResult> select3M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select3M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select3MResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select3MResult>(rs, ps, stmtProvider, transformSelect3M);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select3M",stmtProvider.getSqlString(select3M) ,""+ "subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select3M]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select3MResult
	 */
	public static class Select3MResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select3MMETA prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select3MMETAResult> transformSelect3MMETA = new org.openanzo.jdbc.utils.Transformer<Select3MMETAResult>(){
		public Select3MMETAResult transform(java.sql.ResultSet rs) {

			
				Select3MMETAResult result = new Select3MMETAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select3MMETA prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=? AND S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select3MMETAResult> select3MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select3MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select3MMETAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select3MMETAResult>(rs, ps, stmtProvider, transformSelect3MMETA);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select3MMETA",stmtProvider.getSqlString(select3MMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select3MMETA]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select3MMETAResult
	 */
	public static class Select3MMETAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select4 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select4Result> transformSelect4 = new org.openanzo.jdbc.utils.Transformer<Select4Result>(){
		public Select4Result transform(java.sql.ResultSet rs) {

			
				Select4Result result = new Select4Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select4 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select4Result> select4 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select4, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, propId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select4Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select4Result>(rs, ps, stmtProvider, transformSelect4);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select4",stmtProvider.getSqlString(select4) ,""+ "propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select4]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select4Result
	 */
	public static class Select4Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select4META prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select4METAResult> transformSelect4META = new org.openanzo.jdbc.utils.Transformer<Select4METAResult>(){
		public Select4METAResult transform(java.sql.ResultSet rs) {

			
				Select4METAResult result = new Select4METAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select4META prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select4METAResult> select4META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select4META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select4METAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select4METAResult>(rs, ps, stmtProvider, transformSelect4META);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select4META",stmtProvider.getSqlString(select4META) ,""+ "meta="+(meta) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select4META]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select4METAResult
	 */
	public static class Select4METAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select5 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select5Result> transformSelect5 = new org.openanzo.jdbc.utils.Transformer<Select5Result>(){
		public Select5Result transform(java.sql.ResultSet rs) {

			
				Select5Result result = new Select5Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select5 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select5Result> select5 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select5, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, propId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select5Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select5Result>(rs, ps, stmtProvider, transformSelect5);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select5",stmtProvider.getSqlString(select5) ,""+ "namedgraphId="+(namedgraphId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select5]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select5Result
	 */
	public static class Select5Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select5M prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select5MResult> transformSelect5M = new org.openanzo.jdbc.utils.Transformer<Select5MResult>(){
		public Select5MResult transform(java.sql.ResultSet rs) {

			
				Select5MResult result = new Select5MResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select5M prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select5MResult> select5M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long propId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select5M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, propId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select5MResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select5MResult>(rs, ps, stmtProvider, transformSelect5M);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select5M",stmtProvider.getSqlString(select5M) ,""+ "propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select5M]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select5MResult
	 */
	public static class Select5MResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select5MMETA prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select5MMETAResult> transformSelect5MMETA = new org.openanzo.jdbc.utils.Transformer<Select5MMETAResult>(){
		public Select5MMETAResult transform(java.sql.ResultSet rs) {

			
				Select5MMETAResult result = new Select5MMETAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select5MMETA prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select5MMETAResult> select5MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long propId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select5MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select5MMETAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select5MMETAResult>(rs, ps, stmtProvider, transformSelect5MMETA);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select5MMETA",stmtProvider.getSqlString(select5MMETA) ,""+ "meta="+(meta) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select5MMETA]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select5MMETAResult
	 */
	public static class Select5MMETAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select6 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select6Result> transformSelect6 = new org.openanzo.jdbc.utils.Transformer<Select6Result>(){
		public Select6Result transform(java.sql.ResultSet rs) {

			
				Select6Result result = new Select6Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select6 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select6Result> select6 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select6, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select6Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select6Result>(rs, ps, stmtProvider, transformSelect6);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select6",stmtProvider.getSqlString(select6) ,""+ "subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select6]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select6Result
	 */
	public static class Select6Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select6META prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select6METAResult> transformSelect6META = new org.openanzo.jdbc.utils.Transformer<Select6METAResult>(){
		public Select6METAResult transform(java.sql.ResultSet rs) {

			
				Select6METAResult result = new Select6METAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select6META prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select6METAResult> select6META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select6META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select6METAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select6METAResult>(rs, ps, stmtProvider, transformSelect6META);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select6META",stmtProvider.getSqlString(select6META) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select6META]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select6METAResult
	 */
	public static class Select6METAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select7 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select7Result> transformSelect7 = new org.openanzo.jdbc.utils.Transformer<Select7Result>(){
		public Select7Result transform(java.sql.ResultSet rs) {

			
				Select7Result result = new Select7Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select7 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select7Result> select7 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long subjId, long propId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select7, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select7Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select7Result>(rs, ps, stmtProvider, transformSelect7);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select7",stmtProvider.getSqlString(select7) ,""+ "namedgraphId="+(namedgraphId) + "," +"subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select7]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select7Result
	 */
	public static class Select7Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select7M prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select7MResult> transformSelect7M = new org.openanzo.jdbc.utils.Transformer<Select7MResult>(){
		public Select7MResult transform(java.sql.ResultSet rs) {

			
				Select7MResult result = new Select7MResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select7M prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select7MResult> select7M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long propId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select7M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select7MResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select7MResult>(rs, ps, stmtProvider, transformSelect7M);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select7M",stmtProvider.getSqlString(select7M) ,""+ "subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select7M]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select7MResult
	 */
	public static class Select7MResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select7MMETA prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select7MMETAResult> transformSelect7MMETA = new org.openanzo.jdbc.utils.Transformer<Select7MMETAResult>(){
		public Select7MMETAResult transform(java.sql.ResultSet rs) {

			
				Select7MMETAResult result = new Select7MMETAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select7MMETA prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select7MMETAResult> select7MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long propId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select7MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select7MMETAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select7MMETAResult>(rs, ps, stmtProvider, transformSelect7MMETA);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select7MMETA",stmtProvider.getSqlString(select7MMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"propId="+(propId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select7MMETA]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select7MMETAResult
	 */
	public static class Select7MMETAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select8 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select8Result> transformSelect8 = new org.openanzo.jdbc.utils.Transformer<Select8Result>(){
		public Select8Result transform(java.sql.ResultSet rs) {

			
				Select8Result result = new Select8Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select8 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select8Result> select8 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select8, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select8Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select8Result>(rs, ps, stmtProvider, transformSelect8);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select8",stmtProvider.getSqlString(select8) ,""+ "objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select8]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select8Result
	 */
	public static class Select8Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select8META prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select8METAResult> transformSelect8META = new org.openanzo.jdbc.utils.Transformer<Select8METAResult>(){
		public Select8METAResult transform(java.sql.ResultSet rs) {

			
				Select8METAResult result = new Select8METAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select8META prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select8METAResult> select8META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select8META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select8METAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select8METAResult>(rs, ps, stmtProvider, transformSelect8META);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select8META",stmtProvider.getSqlString(select8META) ,""+ "meta="+(meta) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select8META]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select8METAResult
	 */
	public static class Select8METAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select9 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select9Result> transformSelect9 = new org.openanzo.jdbc.utils.Transformer<Select9Result>(){
		public Select9Result transform(java.sql.ResultSet rs) {

			
				Select9Result result = new Select9Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select9 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select9Result> select9 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select9, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select9Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select9Result>(rs, ps, stmtProvider, transformSelect9);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select9",stmtProvider.getSqlString(select9) ,""+ "namedgraphId="+(namedgraphId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select9]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select9Result
	 */
	public static class Select9Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select9M prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select9MResult> transformSelect9M = new org.openanzo.jdbc.utils.Transformer<Select9MResult>(){
		public Select9MResult transform(java.sql.ResultSet rs) {

			
				Select9MResult result = new Select9MResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select9M prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select9MResult> select9M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select9M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select9MResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select9MResult>(rs, ps, stmtProvider, transformSelect9M);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select9M",stmtProvider.getSqlString(select9M) ,""+ "objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select9M]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select9MResult
	 */
	public static class Select9MResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select9MMETA prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select9MMETAResult> transformSelect9MMETA = new org.openanzo.jdbc.utils.Transformer<Select9MMETAResult>(){
		public Select9MMETAResult transform(java.sql.ResultSet rs) {

			
				Select9MMETAResult result = new Select9MMETAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select9MMETA prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE  S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select9MMETAResult> select9MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select9MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select9MMETAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select9MMETAResult>(rs, ps, stmtProvider, transformSelect9MMETA);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select9MMETA",stmtProvider.getSqlString(select9MMETA) ,""+ "meta="+(meta) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select9MMETA]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select9MMETAResult
	 */
	public static class Select9MMETAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select10 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select10Result> transformSelect10 = new org.openanzo.jdbc.utils.Transformer<Select10Result>(){
		public Select10Result transform(java.sql.ResultSet rs) {

			
				Select10Result result = new Select10Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select10 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select10Result> select10 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select10, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select10Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select10Result>(rs, ps, stmtProvider, transformSelect10);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select10",stmtProvider.getSqlString(select10) ,""+ "subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select10]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select10Result
	 */
	public static class Select10Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select10META prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select10METAResult> transformSelect10META = new org.openanzo.jdbc.utils.Transformer<Select10METAResult>(){
		public Select10METAResult transform(java.sql.ResultSet rs) {

			
				Select10METAResult result = new Select10METAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select10META prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select10METAResult> select10META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select10META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select10METAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select10METAResult>(rs, ps, stmtProvider, transformSelect10META);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select10META",stmtProvider.getSqlString(select10META) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select10META]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select10METAResult
	 */
	public static class Select10METAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select11 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select11Result> transformSelect11 = new org.openanzo.jdbc.utils.Transformer<Select11Result>(){
		public Select11Result transform(java.sql.ResultSet rs) {

			
				Select11Result result = new Select11Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select11 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select11Result> select11 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long subjId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select11, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select11Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select11Result>(rs, ps, stmtProvider, transformSelect11);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select11",stmtProvider.getSqlString(select11) ,""+ "namedgraphId="+(namedgraphId) + "," +"subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select11]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select11Result
	 */
	public static class Select11Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select11M prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select11MResult> transformSelect11M = new org.openanzo.jdbc.utils.Transformer<Select11MResult>(){
		public Select11MResult transform(java.sql.ResultSet rs) {

			
				Select11MResult result = new Select11MResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select11M prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select11MResult> select11M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select11M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select11MResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select11MResult>(rs, ps, stmtProvider, transformSelect11M);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select11M",stmtProvider.getSqlString(select11M) ,""+ "subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select11M]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select11MResult
	 */
	public static class Select11MResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select11MMETA prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select11MMETAResult> transformSelect11MMETA = new org.openanzo.jdbc.utils.Transformer<Select11MMETAResult>(){
		public Select11MMETAResult transform(java.sql.ResultSet rs) {

			
				Select11MMETAResult result = new Select11MMETAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select11MMETA prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select11MMETAResult> select11MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select11MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select11MMETAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select11MMETAResult>(rs, ps, stmtProvider, transformSelect11MMETA);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select11MMETA",stmtProvider.getSqlString(select11MMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select11MMETA]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select11MMETAResult
	 */
	public static class Select11MMETAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select12 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select12Result> transformSelect12 = new org.openanzo.jdbc.utils.Transformer<Select12Result>(){
		public Select12Result transform(java.sql.ResultSet rs) {

			
				Select12Result result = new Select12Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select12 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select12Result> select12 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select12, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select12Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select12Result>(rs, ps, stmtProvider, transformSelect12);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select12",stmtProvider.getSqlString(select12) ,""+ "propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select12]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select12Result
	 */
	public static class Select12Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select12META prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select12METAResult> transformSelect12META = new org.openanzo.jdbc.utils.Transformer<Select12METAResult>(){
		public Select12METAResult transform(java.sql.ResultSet rs) {

			
				Select12METAResult result = new Select12METAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select12META prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select12METAResult> select12META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select12META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select12METAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select12METAResult>(rs, ps, stmtProvider, transformSelect12META);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select12META",stmtProvider.getSqlString(select12META) ,""+ "meta="+(meta) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select12META]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select12METAResult
	 */
	public static class Select12METAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select13 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select13Result> transformSelect13 = new org.openanzo.jdbc.utils.Transformer<Select13Result>(){
		public Select13Result transform(java.sql.ResultSet rs) {

			
				Select13Result result = new Select13Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select13 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select13Result> select13 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select13, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select13Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select13Result>(rs, ps, stmtProvider, transformSelect13);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select13",stmtProvider.getSqlString(select13) ,""+ "namedgraphId="+(namedgraphId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select13]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select13Result
	 */
	public static class Select13Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select13M prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select13MResult> transformSelect13M = new org.openanzo.jdbc.utils.Transformer<Select13MResult>(){
		public Select13MResult transform(java.sql.ResultSet rs) {

			
				Select13MResult result = new Select13MResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select13M prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select13MResult> select13M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long propId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select13M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select13MResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select13MResult>(rs, ps, stmtProvider, transformSelect13M);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select13M",stmtProvider.getSqlString(select13M) ,""+ "propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select13M]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select13MResult
	 */
	public static class Select13MResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select13MMETA prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select13MMETAResult> transformSelect13MMETA = new org.openanzo.jdbc.utils.Transformer<Select13MMETAResult>(){
		public Select13MMETAResult transform(java.sql.ResultSet rs) {

			
				Select13MMETAResult result = new Select13MMETAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select13MMETA prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select13MMETAResult> select13MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long propId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select13MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select13MMETAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select13MMETAResult>(rs, ps, stmtProvider, transformSelect13MMETA);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select13MMETA",stmtProvider.getSqlString(select13MMETA) ,""+ "meta="+(meta) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select13MMETA]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select13MMETAResult
	 */
	public static class Select13MMETAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select14 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select14Result> transformSelect14 = new org.openanzo.jdbc.utils.Transformer<Select14Result>(){
		public Select14Result transform(java.sql.ResultSet rs) {

			
				Select14Result result = new Select14Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select14 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select14Result> select14 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select14, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select14Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select14Result>(rs, ps, stmtProvider, transformSelect14);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select14",stmtProvider.getSqlString(select14) ,""+ "subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select14]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select14Result
	 */
	public static class Select14Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select14META prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select14METAResult> transformSelect14META = new org.openanzo.jdbc.utils.Transformer<Select14METAResult>(){
		public Select14METAResult transform(java.sql.ResultSet rs) {

			
				Select14METAResult result = new Select14METAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select14META prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select14METAResult> select14META (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select14META, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select14METAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select14METAResult>(rs, ps, stmtProvider, transformSelect14META);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select14META",stmtProvider.getSqlString(select14META) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select14META]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select14METAResult
	 */
	public static class Select14METAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select15 prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select15Result> transformSelect15 = new org.openanzo.jdbc.utils.Transformer<Select15Result>(){
		public Select15Result transform(java.sql.ResultSet rs) {

			
				Select15Result result = new Select15Result();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select15 prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S WHERE S.NAMEDGRAPHID=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select15Result> select15 (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long subjId, long propId, long objId, String sessionPrefix, String tempTable, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select15, new String[] {sessionPrefix, tempTable, containerName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select15Result> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select15Result>(rs, ps, stmtProvider, transformSelect15);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select15",stmtProvider.getSqlString(select15) ,""+ "namedgraphId="+(namedgraphId) + "," +"subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select15]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select15Result
	 */
	public static class Select15Result {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select15M prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select15MResult> transformSelect15M = new org.openanzo.jdbc.utils.Transformer<Select15MResult>(){
		public Select15MResult transform(java.sql.ResultSet rs) {

			
				Select15MResult result = new Select15MResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select15M prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select15MResult> select15M (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subjId, long propId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select15M, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select15MResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select15MResult>(rs, ps, stmtProvider, transformSelect15M);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select15M",stmtProvider.getSqlString(select15M) ,""+ "subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select15M]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select15MResult
	 */
	public static class Select15MResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the select15MMETA prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Select15MMETAResult> transformSelect15MMETA = new org.openanzo.jdbc.utils.Transformer<Select15MMETAResult>(){
		public Select15MMETAResult transform(java.sql.ResultSet rs) {

			
				Select15MMETAResult result = new Select15MMETAResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the select15MMETA prepared statement.
	  * <code>
	 *  		 SELECT S.METADATA,S.NAMEDGRAPHID,S.SUBJ,S.PROP,S.OBJ FROM {2}_S S,{0}{3} G WHERE S.METADATA=G.METADATA AND S.NAMEDGRAPHID=G.ID AND S.METADATA=? AND S.SUBJ=? AND S.PROP=? AND S.OBJ=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param meta template parameter
	 *@param subjId template parameter
	 *@param propId template parameter
	 *@param objId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@param containerName template parameter
	 *@param graphTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Select15MMETAResult> select15MMETA (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int meta, long subjId, long propId, long objId, String sessionPrefix, String tempTable, String containerName, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(select15MMETA, new String[] {sessionPrefix, tempTable, containerName, graphTableName},connection); int argc = 1;
			ps.setInt(argc++, meta);
			ps.setLong(argc++, subjId);
			ps.setLong(argc++, propId);
			ps.setLong(argc++, objId);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<Select15MMETAResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Select15MMETAResult>(rs, ps, stmtProvider, transformSelect15MMETA);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"select15MMETA",stmtProvider.getSqlString(select15MMETA) ,""+ "meta="+(meta) + "," +"subjId="+(subjId) + "," +"propId="+(propId) + "," +"objId="+(objId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null") + "," +"containerName="+((containerName!=null)?containerName.toString():"null") + "," +"graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[select15MMETA]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of Select15MMETAResult
	 */
	public static class Select15MMETAResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get Metadata value
		  *@return Metadata value
		  */
			public int getMetadata() {
				return this.metadata;
			}

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	
	/**
	 * Runs the insertIdToTempTable prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID) VALUES(?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertIdToTempTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertIdToTempTable, new String[] {sessionPrefix, insertTable},connection); int argc = 1;
			ps.setLong(argc++, id);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertIdToTempTable",stmtProvider.getSqlString(insertIdToTempTable) ,""+ "id="+(id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertIdToTempTable]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertIdToTempTable prepared statement
	 */
	public static class BatchInsertIdToTempTable extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertIdToTempTable prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertIdToTempTable(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertIdToTempTable,new String[] {sessionPrefix, insertTable});
		}
		
		/**
		 * Sets the input parameters for the insertIdToTempTable prepared statement.
		 *
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}


}