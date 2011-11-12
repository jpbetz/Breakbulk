<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/Statement.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: Statement.sql 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>
	
      <preparedstatement name="findLiteralStatementsLimited" templateParams="String sessionPrefix" results="ITERATOR" outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj" inputs="+Long start,+Long end" >
        <![CDATA[
        SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM(
        SELECT ROW_NUMBER() OVER (ORDER BY NAMEDGRAPHID) AS ROWNUMBER,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT
        FROM STATEMENTS WHERE COMMITTED=0 AND REND IS NULL AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855) 
        WHERE ROWNUMBER > ? AND ROWNUMBER<= ?
        ]]>
    </preparedstatement>
    
    <preparedstatement name="findLiteralStatementsNRLimited" templateParams="String sessionPrefix"  results="ITERATOR" outputs="+Long namedGraphId,+Long subj,+Long prop,+Long obj" inputs="+Long start,+Long end" >
          <![CDATA[
        SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM(
        SELECT ROW_NUMBER() OVER (ORDER BY NAMEDGRAPHID) AS ROWNUMBER,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT
        FROM STATEMENTS_NR WHERE COMMITTED=0 AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855) 
        WHERE ROWNUMBER > ? AND ROWNUMBER<= ?
        ]]>
    </preparedstatement>
</preparedstatements>