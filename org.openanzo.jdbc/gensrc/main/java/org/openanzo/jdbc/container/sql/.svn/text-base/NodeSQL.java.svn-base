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
 *	NodeSQL provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class NodeSQL {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(NodeSQL.class);
	static final long CUTOFF=5;

	/**
	  *Constant "getAllLiterals" used to reference prepared statement  node.getAllLiterals
	  *
	  * <code>
	  *  		SELECT ID,MODIFIER_ID,VALUE FROM {0} {1} 	
	  * </code>
	  */
	public static final String getAllLiterals = "node.getAllLiterals";

	/**
	  *Constant "findNodeID" used to reference prepared statement  node.findNodeID
	  *
	  * <code>
	  *  		SELECT ID FROM {0} WHERE (MODIFIER_ID=0 OR MODIFIER_ID=?) AND VALUE LIKE ?  {1} 	
	  * </code>
	  */
	public static final String findNodeID = "node.findNodeID";

	/**
	  *Constant "fetchNodeID" used to reference prepared statement  node.fetchNodeID
	  *
	  * <code>
	  *  		SELECT ID FROM {0} WHERE VALUE = ?  {1} 	
	  * </code>
	  */
	public static final String fetchNodeID = "node.fetchNodeID";

	/**
	  *Constant "fetchNodeValue" used to reference prepared statement  node.fetchNodeValue
	  *
	  * <code>
	  *  		SELECT VALUE FROM {0} WHERE ID = ?  {1} 	
	  * </code>
	  */
	public static final String fetchNodeValue = "node.fetchNodeValue";

	/**
	  *Constant "fetchLongNodeID" used to reference prepared statement  node.fetchLongNodeID
	  *
	  * <code>
	  *  		SELECT ID,VALUE FROM {0} WHERE HASH = ? 	
	  * </code>
	  */
	public static final String fetchLongNodeID = "node.fetchLongNodeID";

	/**
	  *Constant "fetchLiteralNodeValue" used to reference prepared statement  node.fetchLiteralNodeValue
	  *
	  * <code>
	  *  		SELECT VALUE, MODIFIER_ID FROM {0} WHERE ID = ?  {1} 	
	  * </code>
	  */
	public static final String fetchLiteralNodeValue = "node.fetchLiteralNodeValue";

	/**
	  *Constant "fetchLiteralNodeID" used to reference prepared statement  node.fetchLiteralNodeID
	  *
	  * <code>
	  *  		SELECT ID FROM {0} WHERE VALUE = ? AND MODIFIER_ID = ?  {1} 	
	  * </code>
	  */
	public static final String fetchLiteralNodeID = "node.fetchLiteralNodeID";

	/**
	  *Constant "fetchLongLiteralNodeID" used to reference prepared statement  node.fetchLongLiteralNodeID
	  *
	  * <code>
	  *  		SELECT ID,VALUE FROM {0} WHERE HASH = ? AND MODIFIER_ID = ? 	
	  * </code>
	  */
	public static final String fetchLongLiteralNodeID = "node.fetchLongLiteralNodeID";

	/**
	  *Constant "insertCommonValue" used to reference prepared statement  node.insertCommonValue
	  *
	  * <code>
	  *  		INSERT INTO {0} (ID, VALUE) VALUES(?, ?) 	
	  * </code>
	  */
	public static final String insertCommonValue = "node.insertCommonValue";

	/**
	  *Constant "insertCommonValueWithIdentity" used to reference prepared statement  node.insertCommonValueWithIdentity
	  *
	  * <code>
	  *  		INSERT INTO {0} ( VALUE) VALUES( ?) 	
	  * </code>
	  */
	public static final String insertCommonValueWithIdentity = "node.insertCommonValueWithIdentity";

	/**
	  *Constant "fetchCommonValueID" used to reference prepared statement  node.fetchCommonValueID
	  *
	  * <code>
	  *  		SELECT ID FROM {0} WHERE VALUE = ?  {1} 	
	  * </code>
	  */
	public static final String fetchCommonValueID = "node.fetchCommonValueID";

	/**
	  *Constant "fetchCommonValue" used to reference prepared statement  node.fetchCommonValue
	  *
	  * <code>
	  *  		SELECT VALUE FROM {0} WHERE ID = ?  {1} 	
	  * </code>
	  */
	public static final String fetchCommonValue = "node.fetchCommonValue";

	/**
	  *Constant "fetchAllCommonValues" used to reference prepared statement  node.fetchAllCommonValues
	  *
	  * <code>
	  *  		SELECT ID, VALUE FROM {0} 	
	  * </code>
	  */
	public static final String fetchAllCommonValues = "node.fetchAllCommonValues";

	/**
	  *Constant "storeBulkNode" used to reference prepared statement  node.storeBulkNode
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID, VALUE) VALUES(?, ?) 	
	  * </code>
	  */
	public static final String storeBulkNode = "node.storeBulkNode";

	/**
	  *Constant "storeBulkLongNode" used to reference prepared statement  node.storeBulkLongNode
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID, HASH, VALUE) VALUES(?, ?, ?) 	
	  * </code>
	  */
	public static final String storeBulkLongNode = "node.storeBulkLongNode";

	/**
	  *Constant "storeBulkLiteral" used to reference prepared statement  node.storeBulkLiteral
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID, VALUE, MODIFIER_ID) VALUES(?, ?, ?) 	
	  * </code>
	  */
	public static final String storeBulkLiteral = "node.storeBulkLiteral";

	/**
	  *Constant "storeBulkLongLiteral" used to reference prepared statement  node.storeBulkLongLiteral
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID, VALUE, HASH, MODIFIER_ID) VALUES(?, ?, ?, ?) 	
	  * </code>
	  */
	public static final String storeBulkLongLiteral = "node.storeBulkLongLiteral";

	/**
	  *Constant "countTempTable" used to reference prepared statement  node.countTempTable
	  *
	  * <code>
	  *  		SELECT COUNT(1) FROM  {0}{1} 	
	  * </code>
	  */
	public static final String countTempTable = "node.countTempTable";

	/**
	  *Constant "storeResolveId" used to reference prepared statement  node.storeResolveId
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID) VALUES(?) 	
	  * </code>
	  */
	public static final String storeResolveId = "node.storeResolveId";

	/**
	  *Constant "storeResolveNode" used to reference prepared statement  node.storeResolveNode
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ENTRYID,VALUE) VALUES(?,?) 	
	  * </code>
	  */
	public static final String storeResolveNode = "node.storeResolveNode";

	/**
	  *Constant "storeResolveNodeLong" used to reference prepared statement  node.storeResolveNodeLong
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (VALUE,HASH) VALUES(?,?) 	
	  * </code>
	  */
	public static final String storeResolveNodeLong = "node.storeResolveNodeLong";

	/**
	  *Constant "storeResolveLiteral" used to reference prepared statement  node.storeResolveLiteral
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ENTRYID,VALUE,MODIFIER_ID) VALUES(?,?,?) 	
	  * </code>
	  */
	public static final String storeResolveLiteral = "node.storeResolveLiteral";

	/**
	  *Constant "storeResolveLiteralLong" used to reference prepared statement  node.storeResolveLiteralLong
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (VALUE,HASH,MODIFIER_ID) VALUES(?,?,?) 	
	  * </code>
	  */
	public static final String storeResolveLiteralLong = "node.storeResolveLiteralLong";

	/**
	  *Constant "resolveNodes" used to reference prepared statement  node.resolveNodes
	  *
	  * <code>
	  *  		SELECT {2}.ID,{2}.VALUE FROM {2},{0}{1} WHERE  {2}.VALUE={0}{1}.VALUE 	
	  * </code>
	  */
	public static final String resolveNodes = "node.resolveNodes";

	/**
	  *Constant "resolveLiterals" used to reference prepared statement  node.resolveLiterals
	  *
	  * <code>
	  *  		SELECT {2}.ID,{2}.VALUE,{2}.MODIFIER_ID FROM {2},{0}{1} 		WHERE  		{2}.VALUE={0}{1}.VALUE AND {2}.MODIFIER_ID = {0}{1}.MODIFIER_ID 	
	  * </code>
	  */
	public static final String resolveLiterals = "node.resolveLiterals";

	/**
	  *Constant "resolveIdsUri" used to reference prepared statement  node.resolveIdsUri
	  *
	  * <code>
	  *          SELECT {2}.ID,{2}.VALUE FROM {2},{0}{1} WHERE {2}.ID={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?          
	  * </code>
	  */
	public static final String resolveIdsUri = "node.resolveIdsUri";

	/**
	  *Constant "resolveTransactedIdsUri" used to reference prepared statement  node.resolveTransactedIdsUri
	  *
	  * <code>
	  *          SELECT {2}.ID,{2}.VALUE FROM {2},{0}{1} WHERE {0}{1}.TRANSACTIONID=? AND {2}.ID={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?          
	  * </code>
	  */
	public static final String resolveTransactedIdsUri = "node.resolveTransactedIdsUri";

	/**
	  *Constant "updateResolvedUris" used to reference prepared statement  node.updateResolvedUris
	  *
	  * <code>
	  *  		UPDATE {0}{1} AS A SET TYPE=2,ID=(SELECT {2}.ID FROM {2} WHERE {2}.VALUE=A.VALUE AND {2}.REF=0) WHERE EXISTS (SELECT {2}.ID FROM {2} WHERE {2}.VALUE=A.VALUE AND {2}.REF=0) 	
	  * </code>
	  */
	public static final String updateResolvedUris = "node.updateResolvedUris";

	/**
	  *Constant "resolveExistingUris" used to reference prepared statement  node.resolveExistingUris
	  *
	  * <code>
	  *  		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,2 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.REF=0 	
	  * </code>
	  */
	public static final String resolveExistingUris = "node.resolveExistingUris";

	/**
	  *Constant "updateExistingUrisReferenceCount" used to reference prepared statement  node.updateExistingUrisReferenceCount
	  *
	  * <code>
	  *  		UPDATE {2} SET REF=REF+1 WHERE REF>0 AND VALUE IN (SELECT {0}{1}.VALUE FROM {0}{1})  	
	  * </code>
	  */
	public static final String updateExistingUrisReferenceCount = "node.updateExistingUrisReferenceCount";

	/**
	  *Constant "resolveExistingUncommittedUris" used to reference prepared statement  node.resolveExistingUncommittedUris
	  *
	  * <code>
	  *  		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,3 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.REF>0 	
	  * </code>
	  */
	public static final String resolveExistingUncommittedUris = "node.resolveExistingUncommittedUris";

	/**
	  *Constant "purgeResolvedUris" used to reference prepared statement  node.purgeResolvedUris
	  *
	  * <code>
	  *  		DELETE FROM {0}{1} WHERE ENTRYID IN (SELECT {0}{2}.ENTRYID FROM {0}{2}) 	
	  * </code>
	  */
	public static final String purgeResolvedUris = "node.purgeResolvedUris";

	/**
	  *Constant "insertUnresolvedUris" used to reference prepared statement  node.insertUnresolvedUris
	  *
	  * <code>
	  * 
	  * </code>
	  */
	public static final String insertUnresolvedUris = "node.insertUnresolvedUris";

	/**
	  *Constant "resolveExistingLiterals" used to reference prepared statement  node.resolveExistingLiterals
	  *
	  * <code>
	  *  		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,2 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.MODIFIER_ID=T.MODIFIER_ID AND N.REF=0 	
	  * </code>
	  */
	public static final String resolveExistingLiterals = "node.resolveExistingLiterals";

	/**
	  *Constant "updateExistingLiteralsReferenceCount" used to reference prepared statement  node.updateExistingLiteralsReferenceCount
	  *
	  * <code>
	  *  		UPDATE {2} SET REF=REF+1 WHERE REF>0 AND EXISTS (SELECT {0}{1}.VALUE FROM {0}{1} WHERE {0}{1}.VALUE={2}.VALUE AND {0}{1}.MODIFIER_ID={2}.MODIFIER_ID)  	
	  * </code>
	  */
	public static final String updateExistingLiteralsReferenceCount = "node.updateExistingLiteralsReferenceCount";

	/**
	  *Constant "resolveExistingUncommittedLiterals" used to reference prepared statement  node.resolveExistingUncommittedLiterals
	  *
	  * <code>
	  *  		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,3 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.MODIFIER_ID=T.MODIFIER_ID AND N.REF>0 	
	  * </code>
	  */
	public static final String resolveExistingUncommittedLiterals = "node.resolveExistingUncommittedLiterals";

	/**
	  *Constant "purgeResolvedLiterals" used to reference prepared statement  node.purgeResolvedLiterals
	  *
	  * <code>
	  *  		DELETE FROM {0}{1} WHERE ENTRYID IN (SELECT {0}{2}.ENTRYID FROM {0}{2}) 	
	  * </code>
	  */
	public static final String purgeResolvedLiterals = "node.purgeResolvedLiterals";

	/**
	  *Constant "insertUnresolvedLiterals" used to reference prepared statement  node.insertUnresolvedLiterals
	  *
	  * <code>
	  * 
	  * </code>
	  */
	public static final String insertUnresolvedLiterals = "node.insertUnresolvedLiterals";

	/**
	  *Constant "insertUncommittedReferences" used to reference prepared statement  node.insertUncommittedReferences
	  *
	  * <code>
	  *  		INSERT INTO {2} (ID,TRANSACTIONID) SELECT {0}{1}.ID,{3} FROM {0}{1} WHERE  {0}{1}.TYPE IN (1,3) 	
	  * </code>
	  */
	public static final String insertUncommittedReferences = "node.insertUncommittedReferences";

	/**
	  *Constant "insertLockedId" used to reference prepared statement  node.insertLockedId
	  *
	  * <code>
	  *  		INSERT INTO {0} (ID,TRANSACTIONID) VALUES(?,?) 	
	  * </code>
	  */
	public static final String insertLockedId = "node.insertLockedId";

	/**
	  *Constant "commitUncommittedReferences" used to reference prepared statement  node.commitUncommittedReferences
	  *
	  * <code>
	  *  		UPDATE {1} SET REF=0 WHERE EXISTS (SELECT {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {1}.ID={0}.ID) AND REF>0 	
	  * </code>
	  */
	public static final String commitUncommittedReferences = "node.commitUncommittedReferences";

	/**
	  *Constant "deleteUncommittedReferences" used to reference prepared statement  node.deleteUncommittedReferences
	  *
	  * <code>
	  *  		DELETE FROM {1} WHERE REF=1 AND EXISTS (SELECT {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {1}.ID={0}.ID) 	
	  * </code>
	  */
	public static final String deleteUncommittedReferences = "node.deleteUncommittedReferences";

	/**
	  *Constant "decrementUncommittedReferences" used to reference prepared statement  node.decrementUncommittedReferences
	  *
	  * <code>
	  *  		UPDATE {1} SET REF=REF-1 WHERE REF>1 AND EXISTS (SELECT {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {1}.ID={0}.ID) 	
	  * </code>
	  */
	public static final String decrementUncommittedReferences = "node.decrementUncommittedReferences";

	/**
	  *Constant "selectAllResolvedIds" used to reference prepared statement  node.selectAllResolvedIds
	  *
	  * <code>
	  *  		SELECT {0}{1}.ENTRYID,{0}{1}.ID FROM {0}{1} 	
	  * </code>
	  */
	public static final String selectAllResolvedIds = "node.selectAllResolvedIds";

	/**
	  *Constant "purge" used to reference prepared statement  node.purge
	  *
	  * <code>
	  *  		DELETE FROM {0} WHERE TRANSACTIONID=? 	
	  * </code>
	  */
	public static final String purge = "node.purge";

	/**
	  *Constant "resolveIdsLiteral" used to reference prepared statement  node.resolveIdsLiteral
	  *
	  * <code>
	  *          SELECT {2}.ID,{2}.VALUE,{2}.MODIFIER_ID FROM {2},{0}{1} WHERE {2}.ID ={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?          
	  * </code>
	  */
	public static final String resolveIdsLiteral = "node.resolveIdsLiteral";

	/**
	  *Constant "resolveTransactedIdsLiteral" used to reference prepared statement  node.resolveTransactedIdsLiteral
	  *
	  * <code>
	  *          SELECT {2}.ID,{2}.VALUE,{2}.MODIFIER_ID FROM {2},{0}{1} WHERE {0}{1}.TRANSACTIONID=? AND {2}.ID ={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?          
	  * </code>
	  */
	public static final String resolveTransactedIdsLiteral = "node.resolveTransactedIdsLiteral";



	/**
	 * Transformer that transforms the rows in the result set for the getAllLiterals prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<GetAllLiteralsResult> transformGetAllLiterals = new org.openanzo.jdbc.utils.Transformer<GetAllLiteralsResult>(){
		public GetAllLiteralsResult transform(java.sql.ResultSet rs) {

			
				GetAllLiteralsResult result = new GetAllLiteralsResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.modifierId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:modifierId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.value=rs.getString(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:value",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the getAllLiterals prepared statement.
	  * <code>
	 *  		SELECT ID,MODIFIER_ID,VALUE FROM {0} {1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param nodeTableName template parameter
	 *@param optimization template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<GetAllLiteralsResult> getAllLiterals (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String nodeTableName, String optimization) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getAllLiterals, new String[] {nodeTableName, optimization},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<GetAllLiteralsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<GetAllLiteralsResult>(rs, ps, stmtProvider, transformGetAllLiterals);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getAllLiterals",stmtProvider.getSqlString(getAllLiterals) ,"",""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null") + "," +"optimization="+((optimization!=null)?optimization.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getAllLiterals]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of GetAllLiteralsResult
	 */
	public static class GetAllLiteralsResult {
			/**Value for the "id" result value*/
			private Long id;
			/**Value for the "modifierId" result value*/
			private Long modifierId;
			/**Value for the "value" result value*/
			private String value;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

		/**
		  *Get ModifierId value
		  *@return ModifierId value
		  */
			public Long getModifierId() {
				return this.modifierId;
			}

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the findNodeID prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformFindNodeID = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the findNodeID prepared statement.
	  * <code>
	 *  		SELECT ID FROM {0} WHERE (MODIFIER_ID=0 OR MODIFIER_ID=?) AND VALUE LIKE ?  {1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param modifierId template parameter
	 *@param value template parameter
	 *
	 *@param nodeTableName template parameter
	 *@param optimization template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> findNodeID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long modifierId, String value, String nodeTableName, String optimization) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(findNodeID, new String[] {nodeTableName, optimization},connection); int argc = 1;
			ps.setLong(argc++, modifierId);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","findNodeID");
			} else {
				ps.setString(argc++, value);
			}
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformFindNodeID);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"findNodeID",stmtProvider.getSqlString(findNodeID) ,""+ "modifierId="+(modifierId) + "," +"value="+((value!=null)?value.toString():"null"),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null") + "," +"optimization="+((optimization!=null)?optimization.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[findNodeID]"+endtimer);
		}
	}




	
	/**
	 * Runs the fetchNodeID prepared statement.
	  * <code>
	 *  		SELECT ID FROM {0} WHERE VALUE = ?  {1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param value template parameter
	 *
	 *@param nodeTableName template parameter
	 *@param optimization template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long fetchNodeID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, String nodeTableName, String optimization) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(fetchNodeID, new String[] {nodeTableName, optimization},connection); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","fetchNodeID");
			} else {
				ps.setString(argc++, value);
			}
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"fetchNodeID",stmtProvider.getSqlString(fetchNodeID) ,""+ "value="+((value!=null)?value.toString():"null"),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null") + "," +"optimization="+((optimization!=null)?optimization.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[fetchNodeID]"+endtimer);
		}
	}




	
	/**
	 * Runs the fetchNodeValue prepared statement.
	  * <code>
	 *  		SELECT VALUE FROM {0} WHERE ID = ?  {1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@param nodeTableName template parameter
	 *@param optimization template parameter
	 *@return  String
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static String fetchNodeValue (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String nodeTableName, String optimization) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(fetchNodeValue, new String[] {nodeTableName, optimization},connection); int argc = 1;
			ps.setLong(argc++, id);
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
					return null;				 
				String val = rs.getString(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"fetchNodeValue",stmtProvider.getSqlString(fetchNodeValue) ,""+ "id="+(id),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null") + "," +"optimization="+((optimization!=null)?optimization.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[fetchNodeValue]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the fetchLongNodeID prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<FetchLongNodeIDResult> transformFetchLongNodeID = new org.openanzo.jdbc.utils.Transformer<FetchLongNodeIDResult>(){
		public FetchLongNodeIDResult transform(java.sql.ResultSet rs) {

			
				FetchLongNodeIDResult result = new FetchLongNodeIDResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.value=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:value",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the fetchLongNodeID prepared statement.
	  * <code>
	 *  		SELECT ID,VALUE FROM {0} WHERE HASH = ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param hash template parameter
	 *
	 *@param nodeTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<FetchLongNodeIDResult> fetchLongNodeID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long hash, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(fetchLongNodeID, new String[] {nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, hash);
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

			org.openanzo.jdbc.utils.ClosableIterator<FetchLongNodeIDResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<FetchLongNodeIDResult>(rs, ps, stmtProvider, transformFetchLongNodeID);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"fetchLongNodeID",stmtProvider.getSqlString(fetchLongNodeID) ,""+ "hash="+(hash),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[fetchLongNodeID]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FetchLongNodeIDResult
	 */
	public static class FetchLongNodeIDResult {
			/**Value for the "id" result value*/
			private Long id;
			/**Value for the "value" result value*/
			private String value;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

	}



	
	/**
	 * Runs the fetchLiteralNodeValue prepared statement.
	  * <code>
	 *  		SELECT VALUE, MODIFIER_ID FROM {0} WHERE ID = ?  {1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@param literalNodeTableName template parameter
	 *@param optimization template parameter
	 *@return  FetchLiteralNodeValueResult
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static FetchLiteralNodeValueResult fetchLiteralNodeValue (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String literalNodeTableName, String optimization) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(fetchLiteralNodeValue, new String[] {literalNodeTableName, optimization},connection); int argc = 1;
			ps.setLong(argc++, id);
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
				if(!rs.next()) return null;
		FetchLiteralNodeValueResult result=new FetchLiteralNodeValueResult();
				result.value=rs.getString(1);
				result.modifier_id=rs.getLong(2);
				return result;
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"fetchLiteralNodeValue",stmtProvider.getSqlString(fetchLiteralNodeValue) ,""+ "id="+(id),""+ "literalNodeTableName="+((literalNodeTableName!=null)?literalNodeTableName.toString():"null") + "," +"optimization="+((optimization!=null)?optimization.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[fetchLiteralNodeValue]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FetchLiteralNodeValueResult
	 */
	public static class FetchLiteralNodeValueResult {
			/**Value for the "value" result value*/
			private String value;
			/**Value for the "modifier_id" result value*/
			private Long modifier_id;

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

		/**
		  *Get Modifier_id value
		  *@return Modifier_id value
		  */
			public Long getModifier_id() {
				return this.modifier_id;
			}

	}



	
	/**
	 * Runs the fetchLiteralNodeID prepared statement.
	  * <code>
	 *  		SELECT ID FROM {0} WHERE VALUE = ? AND MODIFIER_ID = ?  {1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param value template parameter
	 *@param modifier_id template parameter
	 *
	 *@param literalNodeTableName template parameter
	 *@param optimization template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long fetchLiteralNodeID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, long modifier_id, String literalNodeTableName, String optimization) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(fetchLiteralNodeID, new String[] {literalNodeTableName, optimization},connection); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","fetchLiteralNodeID");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, modifier_id);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"fetchLiteralNodeID",stmtProvider.getSqlString(fetchLiteralNodeID) ,""+ "value="+((value!=null)?value.toString():"null") + "," +"modifier_id="+(modifier_id),""+ "literalNodeTableName="+((literalNodeTableName!=null)?literalNodeTableName.toString():"null") + "," +"optimization="+((optimization!=null)?optimization.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[fetchLiteralNodeID]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the fetchLongLiteralNodeID prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<FetchLongLiteralNodeIDResult> transformFetchLongLiteralNodeID = new org.openanzo.jdbc.utils.Transformer<FetchLongLiteralNodeIDResult>(){
		public FetchLongLiteralNodeIDResult transform(java.sql.ResultSet rs) {

			
				FetchLongLiteralNodeIDResult result = new FetchLongLiteralNodeIDResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.value=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:value",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the fetchLongLiteralNodeID prepared statement.
	  * <code>
	 *  		SELECT ID,VALUE FROM {0} WHERE HASH = ? AND MODIFIER_ID = ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param hash template parameter
	 *@param modifier_id template parameter
	 *
	 *@param longLiteralNodeTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<FetchLongLiteralNodeIDResult> fetchLongLiteralNodeID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long hash, long modifier_id, String longLiteralNodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(fetchLongLiteralNodeID, new String[] {longLiteralNodeTableName},connection); int argc = 1;
			ps.setLong(argc++, hash);
			ps.setLong(argc++, modifier_id);
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

			org.openanzo.jdbc.utils.ClosableIterator<FetchLongLiteralNodeIDResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<FetchLongLiteralNodeIDResult>(rs, ps, stmtProvider, transformFetchLongLiteralNodeID);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"fetchLongLiteralNodeID",stmtProvider.getSqlString(fetchLongLiteralNodeID) ,""+ "hash="+(hash) + "," +"modifier_id="+(modifier_id),""+ "longLiteralNodeTableName="+((longLiteralNodeTableName!=null)?longLiteralNodeTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[fetchLongLiteralNodeID]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FetchLongLiteralNodeIDResult
	 */
	public static class FetchLongLiteralNodeIDResult {
			/**Value for the "id" result value*/
			private Long id;
			/**Value for the "value" result value*/
			private String value;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

	}



	
	/**
	 * Runs the insertCommonValue prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (ID, VALUE) VALUES(?, ?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param value template parameter
	 *
	 *@param commonValuesTable template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void insertCommonValue (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String value, String commonValuesTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertCommonValue, new String[] {commonValuesTable},connection); int argc = 1;
			ps.setLong(argc++, id);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertCommonValue");
			} else {
				ps.setString(argc++, value);
			}
			try{			
				ps.execute();
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
							ps.execute();
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

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertCommonValue",stmtProvider.getSqlString(insertCommonValue) ,""+ "id="+(id) + "," +"value="+((value!=null)?value.toString():"null"),""+ "commonValuesTable="+((commonValuesTable!=null)?commonValuesTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertCommonValue]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertCommonValue prepared statement
	 */
	public static class BatchInsertCommonValue extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertCommonValue prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param commonValuesTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertCommonValue(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String commonValuesTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertCommonValue,new String[] {commonValuesTable});
		}
		
		/**
		 * Sets the input parameters for the insertCommonValue prepared statement.
		 *
	 *@param id template parameter
	 *@param value template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, String value) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertCommonValue");
			} else {
				ps.setString(argc++, value);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertCommonValueWithIdentity prepared statement.
	  * <code>
	 *  		INSERT INTO {0} ( VALUE) VALUES( ?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param value template parameter
	 *
	 *@param commonValuesTable template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long insertCommonValueWithIdentity (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, String commonValuesTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {			
			ps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(insertCommonValueWithIdentity, new String[] {commonValuesTable},connection); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertCommonValueWithIdentity");
			} else {
				ps.setString(argc++, value);
			}
				java.sql.ResultSet rs=null;
	            try {
					 if (ps.execute()) {
	                    rs = ps.getResultSet();
	                } else {
	                    rs = ps.getGeneratedKeys();
	                }
	                if (rs != null && rs.next()) {
	                    return rs.getLong(1);
	                } else {
	                    return null;
	                }
	            } finally {
	                if (rs != null) {
	                    try {
	                        rs.close();
	                    } catch (java.sql.SQLException sqle) {
	                    	if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing result set",sqle);								
	                    }
	                }
	            }

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertCommonValueWithIdentity",stmtProvider.getSqlString(insertCommonValueWithIdentity) ,""+ "value="+((value!=null)?value.toString():"null"),""+ "commonValuesTable="+((commonValuesTable!=null)?commonValuesTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertCommonValueWithIdentity]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertCommonValueWithIdentity prepared statement
	 */
	public static class BatchInsertCommonValueWithIdentity extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertCommonValueWithIdentity prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param commonValuesTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertCommonValueWithIdentity(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String commonValuesTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertCommonValueWithIdentity,new String[] {commonValuesTable});
		}
		
		/**
		 * Sets the input parameters for the insertCommonValueWithIdentity prepared statement.
		 *
	 *@param value template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String value) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertCommonValueWithIdentity");
			} else {
				ps.setString(argc++, value);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the fetchCommonValueID prepared statement.
	  * <code>
	 *  		SELECT ID FROM {0} WHERE VALUE = ?  {1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param value template parameter
	 *
	 *@param commonValuesTable template parameter
	 *@param optimization template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long fetchCommonValueID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, String commonValuesTable, String optimization) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(fetchCommonValueID, new String[] {commonValuesTable, optimization},connection); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","fetchCommonValueID");
			} else {
				ps.setString(argc++, value);
			}
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"fetchCommonValueID",stmtProvider.getSqlString(fetchCommonValueID) ,""+ "value="+((value!=null)?value.toString():"null"),""+ "commonValuesTable="+((commonValuesTable!=null)?commonValuesTable.toString():"null") + "," +"optimization="+((optimization!=null)?optimization.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[fetchCommonValueID]"+endtimer);
		}
	}




	
	/**
	 * Runs the fetchCommonValue prepared statement.
	  * <code>
	 *  		SELECT VALUE FROM {0} WHERE ID = ?  {1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@param commonValuesTable template parameter
	 *@param optimization template parameter
	 *@return  String
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static String fetchCommonValue (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String commonValuesTable, String optimization) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(fetchCommonValue, new String[] {commonValuesTable, optimization},connection); int argc = 1;
			ps.setLong(argc++, id);
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
					return null;				 
				String val = rs.getString(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"fetchCommonValue",stmtProvider.getSqlString(fetchCommonValue) ,""+ "id="+(id),""+ "commonValuesTable="+((commonValuesTable!=null)?commonValuesTable.toString():"null") + "," +"optimization="+((optimization!=null)?optimization.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[fetchCommonValue]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the fetchAllCommonValues prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<FetchAllCommonValuesResult> transformFetchAllCommonValues = new org.openanzo.jdbc.utils.Transformer<FetchAllCommonValuesResult>(){
		public FetchAllCommonValuesResult transform(java.sql.ResultSet rs) {

			
				FetchAllCommonValuesResult result = new FetchAllCommonValuesResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.value=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:value",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the fetchAllCommonValues prepared statement.
	  * <code>
	 *  		SELECT ID, VALUE FROM {0} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param commonValuesTable template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<FetchAllCommonValuesResult> fetchAllCommonValues (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String commonValuesTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(fetchAllCommonValues, new String[] {commonValuesTable},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<FetchAllCommonValuesResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<FetchAllCommonValuesResult>(rs, ps, stmtProvider, transformFetchAllCommonValues);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"fetchAllCommonValues",stmtProvider.getSqlString(fetchAllCommonValues) ,"",""+ "commonValuesTable="+((commonValuesTable!=null)?commonValuesTable.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[fetchAllCommonValues]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FetchAllCommonValuesResult
	 */
	public static class FetchAllCommonValuesResult {
			/**Value for the "id" result value*/
			private Long id;
			/**Value for the "value" result value*/
			private String value;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

	}



	
	/**
	 * Runs the storeBulkNode prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID, VALUE) VALUES(?, ?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param value template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkNodeTableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void storeBulkNode (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String value, String sessionPrefix, String bulkNodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(storeBulkNode, new String[] {sessionPrefix, bulkNodeTableName},connection); int argc = 1;
			ps.setLong(argc++, id);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeBulkNode");
			} else {
				ps.setString(argc++, value);
			}
			try{			
				ps.execute();
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
							ps.execute();
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

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"storeBulkNode",stmtProvider.getSqlString(storeBulkNode) ,""+ "id="+(id) + "," +"value="+((value!=null)?value.toString():"null"),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkNodeTableName="+((bulkNodeTableName!=null)?bulkNodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[storeBulkNode]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the StoreBulkNode prepared statement
	 */
	public static class BatchStoreBulkNode extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the StoreBulkNode prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkNodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchStoreBulkNode(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkNodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,storeBulkNode,new String[] {sessionPrefix, bulkNodeTableName});
		}
		
		/**
		 * Sets the input parameters for the storeBulkNode prepared statement.
		 *
	 *@param id template parameter
	 *@param value template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, String value) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeBulkNode");
			} else {
				ps.setString(argc++, value);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the storeBulkLongNode prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID, HASH, VALUE) VALUES(?, ?, ?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param hash template parameter
	 *@param value template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkNodeTableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void storeBulkLongNode (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, long hash, String value, String sessionPrefix, String bulkNodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(storeBulkLongNode, new String[] {sessionPrefix, bulkNodeTableName},connection); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, hash);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeBulkLongNode");
			} else {
				ps.setString(argc++, value);
			}
			try{			
				ps.execute();
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
							ps.execute();
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

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"storeBulkLongNode",stmtProvider.getSqlString(storeBulkLongNode) ,""+ "id="+(id) + "," +"hash="+(hash) + "," +"value="+((value!=null)?value.toString():"null"),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkNodeTableName="+((bulkNodeTableName!=null)?bulkNodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[storeBulkLongNode]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the StoreBulkLongNode prepared statement
	 */
	public static class BatchStoreBulkLongNode extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the StoreBulkLongNode prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkNodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchStoreBulkLongNode(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkNodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,storeBulkLongNode,new String[] {sessionPrefix, bulkNodeTableName});
		}
		
		/**
		 * Sets the input parameters for the storeBulkLongNode prepared statement.
		 *
	 *@param id template parameter
	 *@param hash template parameter
	 *@param value template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, long hash, String value) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, hash);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeBulkLongNode");
			} else {
				ps.setString(argc++, value);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the storeBulkLiteral prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID, VALUE, MODIFIER_ID) VALUES(?, ?, ?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param value template parameter
	 *@param modifier_id template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkLiteralTableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void storeBulkLiteral (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String value, long modifier_id, String sessionPrefix, String bulkLiteralTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(storeBulkLiteral, new String[] {sessionPrefix, bulkLiteralTableName},connection); int argc = 1;
			ps.setLong(argc++, id);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeBulkLiteral");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, modifier_id);
			try{			
				ps.execute();
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
							ps.execute();
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

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"storeBulkLiteral",stmtProvider.getSqlString(storeBulkLiteral) ,""+ "id="+(id) + "," +"value="+((value!=null)?value.toString():"null") + "," +"modifier_id="+(modifier_id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkLiteralTableName="+((bulkLiteralTableName!=null)?bulkLiteralTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[storeBulkLiteral]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the StoreBulkLiteral prepared statement
	 */
	public static class BatchStoreBulkLiteral extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the StoreBulkLiteral prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkLiteralTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchStoreBulkLiteral(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkLiteralTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,storeBulkLiteral,new String[] {sessionPrefix, bulkLiteralTableName});
		}
		
		/**
		 * Sets the input parameters for the storeBulkLiteral prepared statement.
		 *
	 *@param id template parameter
	 *@param value template parameter
	 *@param modifier_id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, String value, long modifier_id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeBulkLiteral");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, modifier_id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the storeBulkLongLiteral prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID, VALUE, HASH, MODIFIER_ID) VALUES(?, ?, ?, ?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param value template parameter
	 *@param hash template parameter
	 *@param modifier_id template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkLiteralTableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void storeBulkLongLiteral (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String value, long hash, long modifier_id, String sessionPrefix, String bulkLiteralTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(storeBulkLongLiteral, new String[] {sessionPrefix, bulkLiteralTableName},connection); int argc = 1;
			ps.setLong(argc++, id);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeBulkLongLiteral");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, hash);
			ps.setLong(argc++, modifier_id);
			try{			
				ps.execute();
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
							ps.execute();
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

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"storeBulkLongLiteral",stmtProvider.getSqlString(storeBulkLongLiteral) ,""+ "id="+(id) + "," +"value="+((value!=null)?value.toString():"null") + "," +"hash="+(hash) + "," +"modifier_id="+(modifier_id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkLiteralTableName="+((bulkLiteralTableName!=null)?bulkLiteralTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[storeBulkLongLiteral]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the StoreBulkLongLiteral prepared statement
	 */
	public static class BatchStoreBulkLongLiteral extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the StoreBulkLongLiteral prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkLiteralTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchStoreBulkLongLiteral(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkLiteralTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,storeBulkLongLiteral,new String[] {sessionPrefix, bulkLiteralTableName});
		}
		
		/**
		 * Sets the input parameters for the storeBulkLongLiteral prepared statement.
		 *
	 *@param id template parameter
	 *@param value template parameter
	 *@param hash template parameter
	 *@param modifier_id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, String value, long hash, long modifier_id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeBulkLongLiteral");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, hash);
			ps.setLong(argc++, modifier_id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the countTempTable prepared statement.
	  * <code>
	 *  		SELECT COUNT(1) FROM  {0}{1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkLiteralTableName template parameter
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long countTempTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkLiteralTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countTempTable, new String[] {sessionPrefix, bulkLiteralTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countTempTable",stmtProvider.getSqlString(countTempTable) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkLiteralTableName="+((bulkLiteralTableName!=null)?bulkLiteralTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countTempTable]"+endtimer);
		}
	}




	
	/**
	 * Runs the storeResolveId prepared statement.
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
	 *@param bulkResolutionTableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void storeResolveId (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(storeResolveId, new String[] {sessionPrefix, bulkResolutionTableName},connection); int argc = 1;
			ps.setLong(argc++, id);
			try{			
				ps.execute();
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
							ps.execute();
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

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"storeResolveId",stmtProvider.getSqlString(storeResolveId) ,""+ "id="+(id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[storeResolveId]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the StoreResolveId prepared statement
	 */
	public static class BatchStoreResolveId extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the StoreResolveId prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchStoreResolveId(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,storeResolveId,new String[] {sessionPrefix, bulkResolutionTableName});
		}
		
		/**
		 * Sets the input parameters for the storeResolveId prepared statement.
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
	 * Runs the storeResolveNode prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ENTRYID,VALUE) VALUES(?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param rowId template parameter
	 *@param value template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int storeResolveNode (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int rowId, String value, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(storeResolveNode, new String[] {sessionPrefix, bulkResolutionTableName},connection); int argc = 1;
			ps.setInt(argc++, rowId);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeResolveNode");
			} else {
				ps.setString(argc++, value);
			}
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"storeResolveNode",stmtProvider.getSqlString(storeResolveNode) ,""+ "rowId="+(rowId) + "," +"value="+((value!=null)?value.toString():"null"),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[storeResolveNode]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the StoreResolveNode prepared statement
	 */
	public static class BatchStoreResolveNode extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the StoreResolveNode prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchStoreResolveNode(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,storeResolveNode,new String[] {sessionPrefix, bulkResolutionTableName});
		}
		
		/**
		 * Sets the input parameters for the storeResolveNode prepared statement.
		 *
	 *@param rowId template parameter
	 *@param value template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int rowId, String value) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, rowId);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeResolveNode");
			} else {
				ps.setString(argc++, value);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the storeResolveNodeLong prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (VALUE,HASH) VALUES(?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param value template parameter
	 *@param hash template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int storeResolveNodeLong (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, long hash, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(storeResolveNodeLong, new String[] {sessionPrefix, bulkResolutionTableName},connection); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeResolveNodeLong");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, hash);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"storeResolveNodeLong",stmtProvider.getSqlString(storeResolveNodeLong) ,""+ "value="+((value!=null)?value.toString():"null") + "," +"hash="+(hash),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[storeResolveNodeLong]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the StoreResolveNodeLong prepared statement
	 */
	public static class BatchStoreResolveNodeLong extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the StoreResolveNodeLong prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchStoreResolveNodeLong(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,storeResolveNodeLong,new String[] {sessionPrefix, bulkResolutionTableName});
		}
		
		/**
		 * Sets the input parameters for the storeResolveNodeLong prepared statement.
		 *
	 *@param value template parameter
	 *@param hash template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String value, long hash) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeResolveNodeLong");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, hash);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the storeResolveLiteral prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ENTRYID,VALUE,MODIFIER_ID) VALUES(?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param rowId template parameter
	 *@param value template parameter
	 *@param modifier_id template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int storeResolveLiteral (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int rowId, String value, long modifier_id, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(storeResolveLiteral, new String[] {sessionPrefix, bulkResolutionTableName},connection); int argc = 1;
			ps.setInt(argc++, rowId);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeResolveLiteral");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, modifier_id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"storeResolveLiteral",stmtProvider.getSqlString(storeResolveLiteral) ,""+ "rowId="+(rowId) + "," +"value="+((value!=null)?value.toString():"null") + "," +"modifier_id="+(modifier_id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[storeResolveLiteral]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the StoreResolveLiteral prepared statement
	 */
	public static class BatchStoreResolveLiteral extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the StoreResolveLiteral prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchStoreResolveLiteral(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,storeResolveLiteral,new String[] {sessionPrefix, bulkResolutionTableName});
		}
		
		/**
		 * Sets the input parameters for the storeResolveLiteral prepared statement.
		 *
	 *@param rowId template parameter
	 *@param value template parameter
	 *@param modifier_id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int rowId, String value, long modifier_id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, rowId);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeResolveLiteral");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, modifier_id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the storeResolveLiteralLong prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (VALUE,HASH,MODIFIER_ID) VALUES(?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param value template parameter
	 *@param hash template parameter
	 *@param modifier_id template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int storeResolveLiteralLong (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, long hash, long modifier_id, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(storeResolveLiteralLong, new String[] {sessionPrefix, bulkResolutionTableName},connection); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeResolveLiteralLong");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, hash);
			ps.setLong(argc++, modifier_id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"storeResolveLiteralLong",stmtProvider.getSqlString(storeResolveLiteralLong) ,""+ "value="+((value!=null)?value.toString():"null") + "," +"hash="+(hash) + "," +"modifier_id="+(modifier_id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[storeResolveLiteralLong]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the StoreResolveLiteralLong prepared statement
	 */
	public static class BatchStoreResolveLiteralLong extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the StoreResolveLiteralLong prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchStoreResolveLiteralLong(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,storeResolveLiteralLong,new String[] {sessionPrefix, bulkResolutionTableName});
		}
		
		/**
		 * Sets the input parameters for the storeResolveLiteralLong prepared statement.
		 *
	 *@param value template parameter
	 *@param hash template parameter
	 *@param modifier_id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String value, long hash, long modifier_id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","storeResolveLiteralLong");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, hash);
			ps.setLong(argc++, modifier_id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the resolveNodes prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<ResolveNodesResult> transformResolveNodes = new org.openanzo.jdbc.utils.Transformer<ResolveNodesResult>(){
		public ResolveNodesResult transform(java.sql.ResultSet rs) {

			
				ResolveNodesResult result = new ResolveNodesResult();
				try {
				result.node_id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:node_id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.value=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:value",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the resolveNodes prepared statement.
	  * <code>
	 *  		SELECT {2}.ID,{2}.VALUE FROM {2},{0}{1} WHERE  {2}.VALUE={0}{1}.VALUE 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<ResolveNodesResult> resolveNodes (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveNodes, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<ResolveNodesResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<ResolveNodesResult>(rs, ps, stmtProvider, transformResolveNodes);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveNodes",stmtProvider.getSqlString(resolveNodes) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveNodes]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of ResolveNodesResult
	 */
	public static class ResolveNodesResult {
			/**Value for the "node_id" result value*/
			private Long node_id;
			/**Value for the "value" result value*/
			private String value;

		/**
		  *Get Node_id value
		  *@return Node_id value
		  */
			public Long getNode_id() {
				return this.node_id;
			}

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the resolveLiterals prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<ResolveLiteralsResult> transformResolveLiterals = new org.openanzo.jdbc.utils.Transformer<ResolveLiteralsResult>(){
		public ResolveLiteralsResult transform(java.sql.ResultSet rs) {

			
				ResolveLiteralsResult result = new ResolveLiteralsResult();
				try {
				result.node_id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:node_id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.value=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:value",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.modifier_id=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:modifier_id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the resolveLiterals prepared statement.
	  * <code>
	 *  		SELECT {2}.ID,{2}.VALUE,{2}.MODIFIER_ID FROM {2},{0}{1} 		WHERE  		{2}.VALUE={0}{1}.VALUE AND {2}.MODIFIER_ID = {0}{1}.MODIFIER_ID 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<ResolveLiteralsResult> resolveLiterals (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveLiterals, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<ResolveLiteralsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<ResolveLiteralsResult>(rs, ps, stmtProvider, transformResolveLiterals);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveLiterals",stmtProvider.getSqlString(resolveLiterals) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveLiterals]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of ResolveLiteralsResult
	 */
	public static class ResolveLiteralsResult {
			/**Value for the "node_id" result value*/
			private Long node_id;
			/**Value for the "value" result value*/
			private String value;
			/**Value for the "modifier_id" result value*/
			private Long modifier_id;

		/**
		  *Get Node_id value
		  *@return Node_id value
		  */
			public Long getNode_id() {
				return this.node_id;
			}

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

		/**
		  *Get Modifier_id value
		  *@return Modifier_id value
		  */
			public Long getModifier_id() {
				return this.modifier_id;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the resolveIdsUri prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<ResolveIdsUriResult> transformResolveIdsUri = new org.openanzo.jdbc.utils.Transformer<ResolveIdsUriResult>(){
		public ResolveIdsUriResult transform(java.sql.ResultSet rs) {

			
				ResolveIdsUriResult result = new ResolveIdsUriResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.value=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:value",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the resolveIdsUri prepared statement.
	  * <code>
	 *          SELECT {2}.ID,{2}.VALUE FROM {2},{0}{1} WHERE {2}.ID={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?          
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param startId template parameter
	 *@param endId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<ResolveIdsUriResult> resolveIdsUri (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long startId, long endId, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveIdsUri, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, startId);
			ps.setLong(argc++, endId);
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

			org.openanzo.jdbc.utils.ClosableIterator<ResolveIdsUriResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<ResolveIdsUriResult>(rs, ps, stmtProvider, transformResolveIdsUri);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveIdsUri",stmtProvider.getSqlString(resolveIdsUri) ,""+ "startId="+(startId) + "," +"endId="+(endId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveIdsUri]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of ResolveIdsUriResult
	 */
	public static class ResolveIdsUriResult {
			/**Value for the "id" result value*/
			private Long id;
			/**Value for the "value" result value*/
			private String value;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the resolveTransactedIdsUri prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<ResolveTransactedIdsUriResult> transformResolveTransactedIdsUri = new org.openanzo.jdbc.utils.Transformer<ResolveTransactedIdsUriResult>(){
		public ResolveTransactedIdsUriResult transform(java.sql.ResultSet rs) {

			
				ResolveTransactedIdsUriResult result = new ResolveTransactedIdsUriResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.value=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:value",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the resolveTransactedIdsUri prepared statement.
	  * <code>
	 *          SELECT {2}.ID,{2}.VALUE FROM {2},{0}{1} WHERE {0}{1}.TRANSACTIONID=? AND {2}.ID={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?          
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param startId template parameter
	 *@param endId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<ResolveTransactedIdsUriResult> resolveTransactedIdsUri (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long startId, long endId, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveTransactedIdsUri, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, startId);
			ps.setLong(argc++, endId);
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

			org.openanzo.jdbc.utils.ClosableIterator<ResolveTransactedIdsUriResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<ResolveTransactedIdsUriResult>(rs, ps, stmtProvider, transformResolveTransactedIdsUri);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveTransactedIdsUri",stmtProvider.getSqlString(resolveTransactedIdsUri) ,""+ "transactionId="+(transactionId) + "," +"startId="+(startId) + "," +"endId="+(endId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveTransactedIdsUri]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of ResolveTransactedIdsUriResult
	 */
	public static class ResolveTransactedIdsUriResult {
			/**Value for the "id" result value*/
			private Long id;
			/**Value for the "value" result value*/
			private String value;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

	}



	
	/**
	 * Runs the updateResolvedUris prepared statement.
	  * <code>
	 *  		UPDATE {0}{1} AS A SET TYPE=2,ID=(SELECT {2}.ID FROM {2} WHERE {2}.VALUE=A.VALUE AND {2}.REF=0) WHERE EXISTS (SELECT {2}.ID FROM {2} WHERE {2}.VALUE=A.VALUE AND {2}.REF=0) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateResolvedUris (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateResolvedUris, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateResolvedUris",stmtProvider.getSqlString(updateResolvedUris) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateResolvedUris]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateResolvedUris prepared statement
	 */
	public static class BatchUpdateResolvedUris extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateResolvedUris prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateResolvedUris(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateResolvedUris,new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the updateResolvedUris prepared statement.
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
	 * Runs the resolveExistingUris prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,2 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.REF=0 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int resolveExistingUris (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveExistingUris, new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName, nodeTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveExistingUris",stmtProvider.getSqlString(resolveExistingUris) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"resolvedTableName="+((resolvedTableName!=null)?resolvedTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveExistingUris]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the ResolveExistingUris prepared statement
	 */
	public static class BatchResolveExistingUris extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the ResolveExistingUris prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchResolveExistingUris(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,resolveExistingUris,new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName, nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the resolveExistingUris prepared statement.
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
	 * Runs the updateExistingUrisReferenceCount prepared statement.
	  * <code>
	 *  		UPDATE {2} SET REF=REF+1 WHERE REF>0 AND VALUE IN (SELECT {0}{1}.VALUE FROM {0}{1})  	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateExistingUrisReferenceCount (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateExistingUrisReferenceCount, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateExistingUrisReferenceCount",stmtProvider.getSqlString(updateExistingUrisReferenceCount) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateExistingUrisReferenceCount]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateExistingUrisReferenceCount prepared statement
	 */
	public static class BatchUpdateExistingUrisReferenceCount extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateExistingUrisReferenceCount prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateExistingUrisReferenceCount(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateExistingUrisReferenceCount,new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the updateExistingUrisReferenceCount prepared statement.
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
	 * Runs the resolveExistingUncommittedUris prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,3 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.REF>0 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int resolveExistingUncommittedUris (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveExistingUncommittedUris, new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName, nodeTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveExistingUncommittedUris",stmtProvider.getSqlString(resolveExistingUncommittedUris) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"resolvedTableName="+((resolvedTableName!=null)?resolvedTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveExistingUncommittedUris]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the ResolveExistingUncommittedUris prepared statement
	 */
	public static class BatchResolveExistingUncommittedUris extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the ResolveExistingUncommittedUris prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchResolveExistingUncommittedUris(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,resolveExistingUncommittedUris,new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName, nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the resolveExistingUncommittedUris prepared statement.
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
	 * Runs the purgeResolvedUris prepared statement.
	  * <code>
	 *  		DELETE FROM {0}{1} WHERE ENTRYID IN (SELECT {0}{2}.ENTRYID FROM {0}{2}) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeResolvedUris (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeResolvedUris, new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeResolvedUris",stmtProvider.getSqlString(purgeResolvedUris) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"resolvedTableName="+((resolvedTableName!=null)?resolvedTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeResolvedUris]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeResolvedUris prepared statement
	 */
	public static class BatchPurgeResolvedUris extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeResolvedUris prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeResolvedUris(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeResolvedUris,new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName});
		}
		
		/**
		 * Sets the input parameters for the purgeResolvedUris prepared statement.
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
	 * Runs the insertUnresolvedUris prepared statement.
	  * <code>
	 * 
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@param sequenceName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertUnresolvedUris (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String nodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertUnresolvedUris, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName, sequenceName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertUnresolvedUris",stmtProvider.getSqlString(insertUnresolvedUris) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null") + "," +"sequenceName="+((sequenceName!=null)?sequenceName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertUnresolvedUris]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertUnresolvedUris prepared statement
	 */
	public static class BatchInsertUnresolvedUris extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertUnresolvedUris prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@param sequenceName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertUnresolvedUris(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String nodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertUnresolvedUris,new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName, sequenceName});
		}
		
		/**
		 * Sets the input parameters for the insertUnresolvedUris prepared statement.
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
	 * Runs the resolveExistingLiterals prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,2 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.MODIFIER_ID=T.MODIFIER_ID AND N.REF=0 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int resolveExistingLiterals (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveExistingLiterals, new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName, nodeTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveExistingLiterals",stmtProvider.getSqlString(resolveExistingLiterals) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"resolvedTableName="+((resolvedTableName!=null)?resolvedTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveExistingLiterals]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the ResolveExistingLiterals prepared statement
	 */
	public static class BatchResolveExistingLiterals extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the ResolveExistingLiterals prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchResolveExistingLiterals(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,resolveExistingLiterals,new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName, nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the resolveExistingLiterals prepared statement.
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
	 * Runs the updateExistingLiteralsReferenceCount prepared statement.
	  * <code>
	 *  		UPDATE {2} SET REF=REF+1 WHERE REF>0 AND EXISTS (SELECT {0}{1}.VALUE FROM {0}{1} WHERE {0}{1}.VALUE={2}.VALUE AND {0}{1}.MODIFIER_ID={2}.MODIFIER_ID)  	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateExistingLiteralsReferenceCount (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateExistingLiteralsReferenceCount, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateExistingLiteralsReferenceCount",stmtProvider.getSqlString(updateExistingLiteralsReferenceCount) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateExistingLiteralsReferenceCount]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateExistingLiteralsReferenceCount prepared statement
	 */
	public static class BatchUpdateExistingLiteralsReferenceCount extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateExistingLiteralsReferenceCount prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateExistingLiteralsReferenceCount(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateExistingLiteralsReferenceCount,new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the updateExistingLiteralsReferenceCount prepared statement.
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
	 * Runs the resolveExistingUncommittedLiterals prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{2} (ENTRYID,ID,TYPE) SELECT T.ENTRYID,N.ID,3 FROM {0}{1} T,{3} N WHERE N.VALUE=T.VALUE AND N.MODIFIER_ID=T.MODIFIER_ID AND N.REF>0 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int resolveExistingUncommittedLiterals (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveExistingUncommittedLiterals, new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName, nodeTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveExistingUncommittedLiterals",stmtProvider.getSqlString(resolveExistingUncommittedLiterals) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"resolvedTableName="+((resolvedTableName!=null)?resolvedTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveExistingUncommittedLiterals]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the ResolveExistingUncommittedLiterals prepared statement
	 */
	public static class BatchResolveExistingUncommittedLiterals extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the ResolveExistingUncommittedLiterals prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchResolveExistingUncommittedLiterals(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,resolveExistingUncommittedLiterals,new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName, nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the resolveExistingUncommittedLiterals prepared statement.
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
	 * Runs the purgeResolvedLiterals prepared statement.
	  * <code>
	 *  		DELETE FROM {0}{1} WHERE ENTRYID IN (SELECT {0}{2}.ENTRYID FROM {0}{2}) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeResolvedLiterals (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeResolvedLiterals, new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeResolvedLiterals",stmtProvider.getSqlString(purgeResolvedLiterals) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"resolvedTableName="+((resolvedTableName!=null)?resolvedTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeResolvedLiterals]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeResolvedLiterals prepared statement
	 */
	public static class BatchPurgeResolvedLiterals extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeResolvedLiterals prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param resolvedTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeResolvedLiterals(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String resolvedTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeResolvedLiterals,new String[] {sessionPrefix, bulkResolutionTableName, resolvedTableName});
		}
		
		/**
		 * Sets the input parameters for the purgeResolvedLiterals prepared statement.
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
	 * Runs the insertUnresolvedLiterals prepared statement.
	  * <code>
	 * 
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@param sequenceName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertUnresolvedLiterals (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String nodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertUnresolvedLiterals, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName, sequenceName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertUnresolvedLiterals",stmtProvider.getSqlString(insertUnresolvedLiterals) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null") + "," +"sequenceName="+((sequenceName!=null)?sequenceName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertUnresolvedLiterals]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertUnresolvedLiterals prepared statement
	 */
	public static class BatchInsertUnresolvedLiterals extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertUnresolvedLiterals prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@param sequenceName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertUnresolvedLiterals(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String nodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertUnresolvedLiterals,new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName, sequenceName});
		}
		
		/**
		 * Sets the input parameters for the insertUnresolvedLiterals prepared statement.
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
	 * Runs the insertUncommittedReferences prepared statement.
	  * <code>
	 *  		INSERT INTO {2} (ID,TRANSACTIONID) SELECT {0}{1}.ID,{3} FROM {0}{1} WHERE  {0}{1}.TYPE IN (1,3) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param lockedIdsTable template parameter
	 *@param transactionId template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertUncommittedReferences (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName, String lockedIdsTable, String transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.Statement stmt = null;
		//long startTimer=System.currentTimeMillis();
		try {
			String sql= stmtProvider.getSQL(insertUncommittedReferences, new String[] {sessionPrefix, bulkResolutionTableName, lockedIdsTable, transactionId});
			stmt=connection.createStatement();
				int counter = 0;
				try{
					counter=stmt.executeUpdate(sql);
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
								counter=stmt.executeUpdate(sql);
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
			
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertUncommittedReferences",stmtProvider.getSqlString(insertUncommittedReferences) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"lockedIdsTable="+((lockedIdsTable!=null)?lockedIdsTable.toString():"null") + "," +"transactionId="+((transactionId!=null)?transactionId.toString():"null"));
			
		} finally {
			
			if (stmt != null) {
				try { 
					stmt.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing statement",sqle);
				}
			}
			
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertUncommittedReferences]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertUncommittedReferences prepared statement
	 */
	public static class BatchInsertUncommittedReferences extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertUncommittedReferences prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param lockedIdsTable template parameter
	 *@param transactionId template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertUncommittedReferences(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String bulkResolutionTableName, String lockedIdsTable, String transactionId) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertUncommittedReferences,new String[] {sessionPrefix, bulkResolutionTableName, lockedIdsTable, transactionId});
		}
		
		/**
		 * Sets the input parameters for the insertUncommittedReferences prepared statement.
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
	 * Runs the insertLockedId prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (ID,TRANSACTIONID) VALUES(?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param transactionId template parameter
	 *
	 *@param lockedIdsTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertLockedId (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, long transactionId, String lockedIdsTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertLockedId, new String[] {lockedIdsTable},connection); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, transactionId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLockedId",stmtProvider.getSqlString(insertLockedId) ,""+ "id="+(id) + "," +"transactionId="+(transactionId),""+ "lockedIdsTable="+((lockedIdsTable!=null)?lockedIdsTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertLockedId]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertLockedId prepared statement
	 */
	public static class BatchInsertLockedId extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertLockedId prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param lockedIdsTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLockedId(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String lockedIdsTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLockedId,new String[] {lockedIdsTable});
		}
		
		/**
		 * Sets the input parameters for the insertLockedId prepared statement.
		 *
	 *@param id template parameter
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitUncommittedReferences prepared statement.
	  * <code>
	 *  		UPDATE {1} SET REF=0 WHERE EXISTS (SELECT {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {1}.ID={0}.ID) AND REF>0 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@param lockedIdsTable template parameter
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitUncommittedReferences (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String lockedIdsTable, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitUncommittedReferences, new String[] {lockedIdsTable, nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitUncommittedReferences",stmtProvider.getSqlString(commitUncommittedReferences) ,""+ "transactionId="+(transactionId),""+ "lockedIdsTable="+((lockedIdsTable!=null)?lockedIdsTable.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitUncommittedReferences]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitUncommittedReferences prepared statement
	 */
	public static class BatchCommitUncommittedReferences extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitUncommittedReferences prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param lockedIdsTable template parameter
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitUncommittedReferences(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String lockedIdsTable, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitUncommittedReferences,new String[] {lockedIdsTable, nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the commitUncommittedReferences prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteUncommittedReferences prepared statement.
	  * <code>
	 *  		DELETE FROM {1} WHERE REF=1 AND EXISTS (SELECT {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {1}.ID={0}.ID) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@param lockedIdsTable template parameter
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteUncommittedReferences (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String lockedIdsTable, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteUncommittedReferences, new String[] {lockedIdsTable, nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteUncommittedReferences",stmtProvider.getSqlString(deleteUncommittedReferences) ,""+ "transactionId="+(transactionId),""+ "lockedIdsTable="+((lockedIdsTable!=null)?lockedIdsTable.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteUncommittedReferences]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteUncommittedReferences prepared statement
	 */
	public static class BatchDeleteUncommittedReferences extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteUncommittedReferences prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param lockedIdsTable template parameter
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteUncommittedReferences(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String lockedIdsTable, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteUncommittedReferences,new String[] {lockedIdsTable, nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the deleteUncommittedReferences prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the decrementUncommittedReferences prepared statement.
	  * <code>
	 *  		UPDATE {1} SET REF=REF-1 WHERE REF>1 AND EXISTS (SELECT {0}.ID FROM {0} WHERE {0}.TRANSACTIONID=? AND {1}.ID={0}.ID) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@param lockedIdsTable template parameter
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int decrementUncommittedReferences (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String lockedIdsTable, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(decrementUncommittedReferences, new String[] {lockedIdsTable, nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"decrementUncommittedReferences",stmtProvider.getSqlString(decrementUncommittedReferences) ,""+ "transactionId="+(transactionId),""+ "lockedIdsTable="+((lockedIdsTable!=null)?lockedIdsTable.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[decrementUncommittedReferences]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DecrementUncommittedReferences prepared statement
	 */
	public static class BatchDecrementUncommittedReferences extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DecrementUncommittedReferences prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param lockedIdsTable template parameter
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDecrementUncommittedReferences(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String lockedIdsTable, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,decrementUncommittedReferences,new String[] {lockedIdsTable, nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the decrementUncommittedReferences prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectAllResolvedIds prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectAllResolvedIdsResult> transformSelectAllResolvedIds = new org.openanzo.jdbc.utils.Transformer<SelectAllResolvedIdsResult>(){
		public SelectAllResolvedIdsResult transform(java.sql.ResultSet rs) {

			
				SelectAllResolvedIdsResult result = new SelectAllResolvedIdsResult();
				try {
				result.rowid=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:rowid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.id=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectAllResolvedIds prepared statement.
	  * <code>
	 *  		SELECT {0}{1}.ENTRYID,{0}{1}.ID FROM {0}{1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectAllResolvedIdsResult> selectAllResolvedIds (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String bulkResolutionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectAllResolvedIds, new String[] {sessionPrefix, bulkResolutionTableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectAllResolvedIdsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectAllResolvedIdsResult>(rs, ps, stmtProvider, transformSelectAllResolvedIds);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectAllResolvedIds",stmtProvider.getSqlString(selectAllResolvedIds) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectAllResolvedIds]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectAllResolvedIdsResult
	 */
	public static class SelectAllResolvedIdsResult {
			/**Value for the "rowid" result value*/
			private Integer rowid;
			/**Value for the "id" result value*/
			private Long id;

		/**
		  *Get Rowid value
		  *@return Rowid value
		  */
			public Integer getRowid() {
				return this.rowid;
			}

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

	}



	
	/**
	 * Runs the purge prepared statement.
	  * <code>
	 *  		DELETE FROM {0} WHERE TRANSACTIONID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@param lockIdTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purge (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String lockIdTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purge, new String[] {lockIdTable},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purge",stmtProvider.getSqlString(purge) ,""+ "transactionId="+(transactionId),""+ "lockIdTable="+((lockIdTable!=null)?lockIdTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purge]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Purge prepared statement
	 */
	public static class BatchPurge extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Purge prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param lockIdTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurge(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String lockIdTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purge,new String[] {lockIdTable});
		}
		
		/**
		 * Sets the input parameters for the purge prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the resolveIdsLiteral prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<ResolveIdsLiteralResult> transformResolveIdsLiteral = new org.openanzo.jdbc.utils.Transformer<ResolveIdsLiteralResult>(){
		public ResolveIdsLiteralResult transform(java.sql.ResultSet rs) {

			
				ResolveIdsLiteralResult result = new ResolveIdsLiteralResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.value=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:value",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.modifierId=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:modifierId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the resolveIdsLiteral prepared statement.
	  * <code>
	 *          SELECT {2}.ID,{2}.VALUE,{2}.MODIFIER_ID FROM {2},{0}{1} WHERE {2}.ID ={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?          
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param startId template parameter
	 *@param endId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<ResolveIdsLiteralResult> resolveIdsLiteral (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long startId, long endId, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveIdsLiteral, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, startId);
			ps.setLong(argc++, endId);
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

			org.openanzo.jdbc.utils.ClosableIterator<ResolveIdsLiteralResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<ResolveIdsLiteralResult>(rs, ps, stmtProvider, transformResolveIdsLiteral);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveIdsLiteral",stmtProvider.getSqlString(resolveIdsLiteral) ,""+ "startId="+(startId) + "," +"endId="+(endId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveIdsLiteral]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of ResolveIdsLiteralResult
	 */
	public static class ResolveIdsLiteralResult {
			/**Value for the "id" result value*/
			private Long id;
			/**Value for the "value" result value*/
			private String value;
			/**Value for the "modifierId" result value*/
			private long modifierId;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

		/**
		  *Get ModifierId value
		  *@return ModifierId value
		  */
			public long getModifierId() {
				return this.modifierId;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the resolveTransactedIdsLiteral prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<ResolveTransactedIdsLiteralResult> transformResolveTransactedIdsLiteral = new org.openanzo.jdbc.utils.Transformer<ResolveTransactedIdsLiteralResult>(){
		public ResolveTransactedIdsLiteralResult transform(java.sql.ResultSet rs) {

			
				ResolveTransactedIdsLiteralResult result = new ResolveTransactedIdsLiteralResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.value=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:value",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.modifierId=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:modifierId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the resolveTransactedIdsLiteral prepared statement.
	  * <code>
	 *          SELECT {2}.ID,{2}.VALUE,{2}.MODIFIER_ID FROM {2},{0}{1} WHERE {0}{1}.TRANSACTIONID=? AND {2}.ID ={0}{1}.ID AND {0}{1}.ID>=? AND {0}{1}.ID < ?          
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param startId template parameter
	 *@param endId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param bulkResolutionTableName template parameter
	 *@param nodeTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<ResolveTransactedIdsLiteralResult> resolveTransactedIdsLiteral (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long startId, long endId, String sessionPrefix, String bulkResolutionTableName, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveTransactedIdsLiteral, new String[] {sessionPrefix, bulkResolutionTableName, nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, startId);
			ps.setLong(argc++, endId);
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

			org.openanzo.jdbc.utils.ClosableIterator<ResolveTransactedIdsLiteralResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<ResolveTransactedIdsLiteralResult>(rs, ps, stmtProvider, transformResolveTransactedIdsLiteral);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveTransactedIdsLiteral",stmtProvider.getSqlString(resolveTransactedIdsLiteral) ,""+ "transactionId="+(transactionId) + "," +"startId="+(startId) + "," +"endId="+(endId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveTransactedIdsLiteral]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of ResolveTransactedIdsLiteralResult
	 */
	public static class ResolveTransactedIdsLiteralResult {
			/**Value for the "id" result value*/
			private Long id;
			/**Value for the "value" result value*/
			private String value;
			/**Value for the "modifierId" result value*/
			private Long modifierId;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

		/**
		  *Get Value value
		  *@return Value value
		  */
			public String getValue() {
				return this.value;
			}

		/**
		  *Get ModifierId value
		  *@return ModifierId value
		  */
			public Long getModifierId() {
				return this.modifierId;
			}

	}

}