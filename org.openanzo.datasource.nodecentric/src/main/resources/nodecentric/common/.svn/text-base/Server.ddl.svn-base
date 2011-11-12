#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/db2/Attic/Server.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: Server.ddl 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
#
CREATE TABLE SERVER (      
        ID  	  	            {6} NOT NULL,
        VERSION					{6} NOT NULL,
        INITIALIZED				{6} 
);
CREATE INDEX SERVERIVL ON SERVER (ID,VERSION,INITIALIZED);
CREATE INDEX SERVERIL ON SERVER(ID,INITIALIZED);
CREATE INDEX SERVERL ON SERVER(INITIALIZED);

INSERT INTO SERVER (ID,VERSION) VALUES(0,12);