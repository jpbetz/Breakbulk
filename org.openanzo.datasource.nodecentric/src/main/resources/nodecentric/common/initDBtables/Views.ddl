#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/mysql/initDBtables/Attic/Views.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: Views.ddl 229 2007-08-07 15:22:00Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
CREATE VIEW ALL_STMTS_VIEW (METADATA,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,COMMITTED) AS
	SELECT 
		ST.METADATA,ST.NAMEDGRAPHID,ST.SUBJECT,ST.PREDICATE,ST.OBJECT,COMMITTED
	FROM
		STATEMENTS ST
	WHERE
		COMMITTED<=0 AND ST.REND IS NULL

UNION
	SELECT 
		ST.METADATA,ST.NAMEDGRAPHID,ST.SUBJECT,ST.PREDICATE,ST.OBJECT,COMMITTED
	FROM
		STATEMENTS_NR ST
	WHERE
		COMMITTED<=0;
		
		
CREATE VIEW ALL_LITERALS_VIEW (ID,VALUE,MODIFIER_ID,REF) AS
	SELECT
		L.ID,L.VALUE,L.MODIFIER_ID,L.REF
	FROM
		ANZO_L L
	WHERE
		L.REF=0
UNION
	SELECT
		TL.ID,TL.VALUE,TL.MODIFIER_ID,TL.REF
	FROM
		ANZO_TL TL
	WHERE
		TL.REF=0;
	