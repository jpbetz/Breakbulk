<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/Replication.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: Replication.sql 229 2007-08-07 15:22:00Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>  

	<preparedstatement name="insertNamedGraphRevision" inputs="+Long namedGraphId,+Long metaId,+Long revision" results="COUNTER"  templateParams="String sessionPrefix">
		INSERT INTO {0}NGR_TMP
		(ID,METAID,REVISION)
		VALUES 
		(?,?,?);
	</preparedstatement>
	
	<preparedstatement name="insertNamedGraphNewRevisions" prepare="false" results="COUNTER" templateParams="String ngId,String sessionPrefix,String revision">
	<![CDATA[
		INSERT INTO {1}NGR_TMP	(ID,METAID,NEW_REVISION,UUID,REVISION)	
			SELECT NAMEDGRAPHS.ID,NAMEDGRAPHS.METAID,NAMEDGRAPHS.REVISION,NAMEDGRAPHS.UUID,{2}
			FROM NAMEDGRAPHS 
			WHERE 
			NAMEDGRAPHS.ID={0} AND 
			NAMEDGRAPHS.REVISION > {2} AND
			(
				(NAMEDGRAPHS.HEND IS NULL AND NAMEDGRAPHS.COMMITTED=0) OR 
				(NAMEDGRAPHS.HEND IS NOT NULL AND NAMEDGRAPHS.COMMITTED>0)
			)		
	]]>
	</preparedstatement>

	<preparedstatement name="insertNamedGraphNRNewRevisions"  prepare="false" results="COUNTER"  templateParams="String ngId,String sessionPrefix,String revision">
	<![CDATA[
		INSERT INTO {1}NGR_TMP	(ID,METAID,NEW_REVISION,UUID,REVISION)		
			SELECT NAMEDGRAPHS_NR.ID,NAMEDGRAPHS_NR.METAID,NAMEDGRAPHS_NR.REVISION,NAMEDGRAPHS_NR.UUID,{2}
			FROM NAMEDGRAPHS_NR 
			WHERE 
			NAMEDGRAPHS_NR.ID={0} AND 
			NAMEDGRAPHS_NR.REVISION > {2} AND
			NAMEDGRAPHS_NR.COMMITTED=0		
	]]>
	</preparedstatement>
		
	<preparedstatement name="updateNamedGraphNewRevisions"  results="COUNTER"  templateParams="String sessionPrefix">
	<![CDATA[
		UPDATE {0}NGR_TMP 
		SET 
		NEW_REVISION=(
			SELECT NAMEDGRAPHS.REVISION 
			FROM NAMEDGRAPHS 
			WHERE 
			NAMEDGRAPHS.ID={0}NGR_TMP.ID AND 
			(
				(NAMEDGRAPHS.HEND IS NULL AND NAMEDGRAPHS.COMMITTED=0) OR 
				(NAMEDGRAPHS.HEND IS NOT NULL AND NAMEDGRAPHS.COMMITTED>0)
			)
		), 
		UUID=(
			SELECT NAMEDGRAPHS.UUID 
			FROM NAMEDGRAPHS 
			WHERE 
			NAMEDGRAPHS.ID={0}NGR_TMP.ID AND 
			(
				(NAMEDGRAPHS.HEND IS NULL AND NAMEDGRAPHS.COMMITTED=0) OR 
				(NAMEDGRAPHS.HEND IS NOT NULL AND NAMEDGRAPHS.COMMITTED>0)
			)
		)  
		WHERE EXISTS (SELECT NAMEDGRAPHS.ID FROM NAMEDGRAPHS WHERE NAMEDGRAPHS.ID={0}NGR_TMP.ID)
	]]>
	</preparedstatement>
	
	<preparedstatement name="updateNamedGraphNRNewRevisions"  results="COUNTER"  templateParams="String sessionPrefix">
	<![CDATA[
		UPDATE {0}NGR_TMP 
		SET 
		NEW_REVISION=(
			SELECT NAMEDGRAPHS_NR.REVISION 
			FROM NAMEDGRAPHS_NR 
			WHERE 
			NAMEDGRAPHS_NR.ID={0}NGR_TMP.ID AND
			NAMEDGRAPHS_NR.COMMITTED=0
		), 
		UUID=(
			SELECT NAMEDGRAPHS_NR.UUID 
			FROM NAMEDGRAPHS_NR 
			WHERE 
			NAMEDGRAPHS_NR.ID={0}NGR_TMP.ID  AND 
			NAMEDGRAPHS_NR.COMMITTED=0
		) 
		WHERE EXISTS (SELECT NAMEDGRAPHS_NR.ID FROM NAMEDGRAPHS_NR WHERE NAMEDGRAPHS_NR.ID={0}NGR_TMP.ID)
	]]>
	</preparedstatement>
	
	<preparedstatement name="purgeNonChangedNamedGraphEntries"  results="COUNTER"  templateParams="String sessionPrefix">
	<![CDATA[
		DELETE FROM {0}NGR_TMP WHERE EXISTS(SELECT NG.REVISION FROM NAMEDGRAPHS NG WHERE NG.ID={0}NGR_TMP.ID AND NG.REVISION={0}NGR_TMP.REVISION AND ((NG.HEND IS NULL AND NG.COMMITTED=0) OR (NG.HEND IS NOT NULL AND NG.COMMITTED>0)))
	]]>
	</preparedstatement>

	<preparedstatement name="purgeNonChangedNamedGraphNREntries"  results="COUNTER"  templateParams="String sessionPrefix">
	<![CDATA[
		DELETE FROM {0}NGR_TMP WHERE EXISTS(SELECT NG.REVISION FROM NAMEDGRAPHS_NR NG WHERE	NG.ID={0}NGR_TMP.ID AND	NG.REVISION={0}NGR_TMP.REVISION AND	NG.COMMITTED=0)
	]]>
	</preparedstatement>
	
	<preparedstatement name="selectNewStatements"
	 outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj"
	 results="ITERATOR"	 
	 templateParams="String sessionPrefix"
	 >
	<![CDATA[
		SELECT 
			S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT
		FROM 
			STATEMENTS S,{0}NGR_TMP NG
		WHERE
			S.COMMITTED<=0 AND
			S.UUID=NG.UUID AND 
			((S.RSTART>NG.REVISION AND S.REND IS NULL) OR (S.RSTART<=NG.REVISION AND S.REND>NG.REVISION))
		ORDER BY NAMEDGRAPHID,REND
	]]>
	</preparedstatement>
	
	<preparedstatement name="selectNewStatementsNR"
	 outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj"
	 results="ITERATOR"	 
	 templateParams="String sessionPrefix"
	 >
	<![CDATA[
		SELECT 
			S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT
		FROM 
			STATEMENTS_NR S,{0}NGR_TMP NG
		WHERE
			S.COMMITTED<=0 AND
			(S.NAMEDGRAPHID=NG.ID OR S.NAMEDGRAPHID=NG.METAID)
		ORDER BY NAMEDGRAPHID
	]]>
	</preparedstatement>
	
	<preparedstatement name="insertDeltaStatements"
	 results="COUNTER"	 
	 templateParams="String sessionPrefix"
	 >
	<![CDATA[
		INSERT INTO {0}STMTS_REP_TMP
		SELECT 
			S.ID,S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT,S.RSTART,S.REND
		FROM 
			STATEMENTS S,{0}NGR_TMP NG
		WHERE
			NG.REVISION > -1 AND
			S.COMMITTED=0 AND
			S.UUID=NG.UUID AND 
			((S.RSTART>NG.REVISION AND S.REND IS NULL) OR (S.RSTART<=NG.REVISION AND S.REND>NG.REVISION))
	]]>
	</preparedstatement>
	
	<preparedstatement name="insertDeltaNRStatements"
	 results="COUNTER"	 
	 templateParams="String sessionPrefix"
	 >
	<![CDATA[
		INSERT INTO {0}STMTS_REP_TMP(ID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT)
		SELECT 
			S.ID,S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT
		FROM 
			STATEMENTS_NR S
		WHERE
			S.COMMITTED=0 AND S.NAMEDGRAPHID IN (SELECT ID FROM {0}NGR_TMP WHERE REVISION>-1 UNION SELECT METAID FROM {0}NGR_TMP  WHERE REVISION>-1)
	]]>
	</preparedstatement>
	
	<preparedstatement name="purgeExtraStatements"
	 results="COUNTER"	 
	 templateParams="String sessionPrefix"
	 >
	<![CDATA[
		DELETE FROM {0}STMTS_REP_TMP
		WHERE 
		{0}STMTS_REP_TMP.REND IS NOT NULL AND
		EXISTS (SELECT ST2.ID FROM {0}STMTS_REP_TMP ST2 WHERE ST2.ID={0}STMTS_REP_TMP.ID AND (ST2.REND IS NULL OR ST2.REND>{0}STMTS_REP_TMP.REND))
		
	]]>
	</preparedstatement>
	
	<preparedstatement name="selectAllStatement" outputs="+Long namedGraphId,Long rend,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix">
		SELECT NAMEDGRAPHID,REND,SUBJECT,PREDICATE,OBJECT
		FROM {0}STMTS_REP_TMP
		ORDER BY NAMEDGRAPHID,REND
	</preparedstatement>
	
	<preparedstatement name="selectStatementAdditions" outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix">
		SELECT NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT
		FROM {0}STMTS_REP_TMP
		WHERE REND IS NULL ORDER BY NAMEDGRAPHID
	</preparedstatement>
	
	<preparedstatement name="selectStatementDeletions" outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj" results="ITERATOR" templateParams="String sessionPrefix">
		SELECT NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT
		FROM {0}STMTS_REP_TMP
		WHERE REND IS NOT NULL ORDER BY NAMEDGRAPHID
	</preparedstatement>
	
	<preparedstatement name="selectUniqueUris" outputs="+Long id,String uri" results="ITERATOR" templateParams="String tableNamePrefix,String sessionPrefix,String resultsTmp1,String resultsTmp2,String resultsTmp3,String resultsTmp4">
		SELECT DISTINCT {0}_U.ID,{0}_U.VALUE
		FROM {0}_U
		WHERE
			{0}_U.ID IN (SELECT  ID FROM {1}NAMEDGRAPHIDS UNION SELECT  SUBJ FROM {1}{2} UNION SELECT PREDICATE FROM {1}{3} UNION SELECT  NAMEDGRAPHID FROM {1}{4} UNION SELECT  OBJ FROM {1}{5});
	</preparedstatement>
	
	<preparedstatement name="selectUniqueIds" outputs="Long id" results="ITERATOR" templateParams="String sessionPrefix,String resultsTmp1,String resultsTmp2,String resultsTmp3,String resultsTmp4">
		SELECT SUBJECT FROM {0}{1} UNION SELECT PREDICATE FROM {0}{2} UNION SELECT NAMEDGRAPHID FROM {0}{3} UNION SELECT OBJECT FROM {0}{4};
	</preparedstatement>
	
	<preparedstatement name="selectNamedGraphs" outputs="+Long namedGraphid,+Long uuid,+Long revision" results="ITERATOR" templateParams="String sessionPrefix">
	<![CDATA[
		SELECT ID,UUID,NEW_REVISION FROM {0}NGR_TMP WHERE REVISION IS NULL OR REVISION < NEW_REVISION
	]]>
	</preparedstatement>
	
	<preparedstatement name="selectAllNamedGraphs" outputs="+Long namedGraphid,+Long uuid,+Long revision,+Long newRevision" results="ITERATOR" templateParams="String sessionPrefix">
		SELECT ID,UUID,REVISION,NEW_REVISION FROM {0}NGR_TMP WHERE REVISION IS NULL OR NEW_REVISION IS NULL
	</preparedstatement>
</preparedstatements>