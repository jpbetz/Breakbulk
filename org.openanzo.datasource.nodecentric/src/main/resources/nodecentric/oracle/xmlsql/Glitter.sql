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

	<preparedstatement name="containsRevisionedGraph" inputs="+Long id" outputs="+Integer count" results="VALUE" templateParams="String sessionPrefix,String tableName">
		<![CDATA[ 	
		SELECT  COUNT(1) FROM {0}{1} TG,NAMEDGRAPHS NG WHERE TG.ID = ? and (TG.ID=NG.METAID OR TG.ID=NG.ID) AND ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0))
		]]>
	</preparedstatement>
	
	<preparedstatement name="containsNonRevisionedGraph" inputs="+Long id" outputs="+Integer count" results="VALUE" templateParams="String sessionPrefix,String tableName">
		<![CDATA[ 	
		SELECT  COUNT(1) FROM {0}{1} TG,NAMEDGRAPHS_NR NG WHERE TG.ID = ? and (TG.ID=NG.METAID OR TG.ID=NG.ID) AND COMMITTED <=0
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
	
	<preparedstatement name="selectGraphs" outputs="Long graph" results="ITERATOR" templateParams="String sessionPrefix,String tempTable">
		SELECT  TG.ID AS GRAPH			   
		FROM {0}{1} TG
	</preparedstatement>
</preparedstatements>