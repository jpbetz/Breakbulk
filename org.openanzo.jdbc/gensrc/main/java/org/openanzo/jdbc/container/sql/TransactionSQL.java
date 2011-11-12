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
 *	TransactionSQL provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class TransactionSQL {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(TransactionSQL.class);
	static final long CUTOFF=5;

	/**
	  *Constant "insertNotificationStatementAdd" used to reference prepared statement  transaction.insertNotificationStatementAdd
	  *
	  * <code>
	  *  		INSERT INTO {0} (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,NS,NE) VALUES(?,?,?,?,?,1,0) 	
	  * </code>
	  */
	public static final String insertNotificationStatementAdd = "transaction.insertNotificationStatementAdd";

	/**
	  *Constant "insertNotificationStatementDel" used to reference prepared statement  transaction.insertNotificationStatementDel
	  *
	  * <code>
	  *  		INSERT INTO {0} (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,NS,NE) VALUES(?,?,?,?,?,0,1) 	
	  * </code>
	  */
	public static final String insertNotificationStatementDel = "transaction.insertNotificationStatementDel";

	/**
	  *Constant "updateNotificationStatementAdd" used to reference prepared statement  transaction.updateNotificationStatementAdd
	  *
	  * <code>
	  *  		UPDATE {0} SET NS=1,NE=0 WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NOT NULL OR TE_ID IS NOT NULL )  	
	  * </code>
	  */
	public static final String updateNotificationStatementAdd = "transaction.updateNotificationStatementAdd";

	/**
	  *Constant "updateNotificationStatementDel" used to reference prepared statement  transaction.updateNotificationStatementDel
	  *
	  * <code>
	  *  		UPDATE {0} SET NS=0,NE=1 WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NOT NULL OR TE_ID IS NOT NULL )  	
	  * </code>
	  */
	public static final String updateNotificationStatementDel = "transaction.updateNotificationStatementDel";

	/**
	  *Constant "purgeCommitedStatements" used to reference prepared statement  transaction.purgeCommitedStatements
	  *
	  * <code>
	  *  		DELETE FROM  {0}_ST WHERE (TS_ID IS NOT NULL AND TS_ID=?) OR (TE_ID IS NOT NULL AND TE_ID=?) 	
	  * </code>
	  */
	public static final String purgeCommitedStatements = "transaction.purgeCommitedStatements";

	/**
	  *Constant "purgeNotificationStatements" used to reference prepared statement  transaction.purgeNotificationStatements
	  *
	  * <code>
	  *  		DELETE FROM  {0} WHERE TS_ID IS NULL AND TE_ID IS NULL AND (NS=1 OR NE=1) 	
	  * </code>
	  */
	public static final String purgeNotificationStatements = "transaction.purgeNotificationStatements";

	/**
	  *Constant "updateStatementAdd" used to reference prepared statement  transaction.updateStatementAdd
	  *
	  * <code>
	  *  		UPDATE {0} SET NS=0,NE=0,TS_ID=NULL,TE_ID=NULL,CS_ID=NULL,TE_ID=NULL WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NULL OR TS_ID<?) AND (TE_ID IS NULL OR TE_ID<?)  	
	  * </code>
	  */
	public static final String updateStatementAdd = "transaction.updateStatementAdd";

	/**
	  *Constant "updateStatementDel" used to reference prepared statement  transaction.updateStatementDel
	  *
	  * <code>
	  *  		DELETE FROM  {0} WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NULL OR TS_ID<?) AND (TE_ID IS NULL OR TE_ID<?)  	
	  * </code>
	  */
	public static final String updateStatementDel = "transaction.updateStatementDel";

	/**
	  *Constant "insertCommandStatementAdd" used to reference prepared statement  transaction.insertCommandStatementAdd
	  *
	  * <code>
	  *  		INSERT INTO {0}_ST (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,TS_ID,CS_ID) VALUES(?,?,?,?,?,?,?) 	
	  * </code>
	  */
	public static final String insertCommandStatementAdd = "transaction.insertCommandStatementAdd";

	/**
	  *Constant "insertCommandStatementDel" used to reference prepared statement  transaction.insertCommandStatementDel
	  *
	  * <code>
	  *  		INSERT INTO {0}_ST (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,TE_ID,CE_ID) VALUES(?,?,?,?,?,?,?) 	
	  * </code>
	  */
	public static final String insertCommandStatementDel = "transaction.insertCommandStatementDel";

	/**
	  *Constant "updateTransactionStatementDel" used to reference prepared statement  transaction.updateTransactionStatementDel
	  *
	  * <code>
	  *  		UPDATE {0} SET TE_ID=?,CE_ID=? WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND TE_ID  IS NULL 	
	  * </code>
	  */
	public static final String updateTransactionStatementDel = "transaction.updateTransactionStatementDel";

	/**
	  *Constant "updateTransactionStatementAdd" used to reference prepared statement  transaction.updateTransactionStatementAdd
	  *
	  * <code>
	  *  		UPDATE {0} SET TS_ID=?,CS_ID=? WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND TS_ID IS NULL and TE_ID IS NULL AND CS_ID IS NULL AND CE_ID IS NULL 	
	  * </code>
	  */
	public static final String updateTransactionStatementAdd = "transaction.updateTransactionStatementAdd";

	/**
	  *Constant "selectAdditions" used to reference prepared statement  transaction.selectAdditions
	  *
	  * <code>
	  *  		SELECT ST.METADATA,ST.NAMEDGRAPHID,ST.subj,ST.prop,ST.obj FROM {0}_ST ST where ST.ts_id =? AND ST.cs_id=? 	
	  * </code>
	  */
	public static final String selectAdditions = "transaction.selectAdditions";

	/**
	  *Constant "selectDeletions" used to reference prepared statement  transaction.selectDeletions
	  *
	  * <code>
	  *  		SELECT ST.METADATA,ST.NAMEDGRAPHID,ST.subj,ST.prop,ST.obj FROM {0}_ST ST where ST.te_id =? AND ST.ce_id=? 	
	  * </code>
	  */
	public static final String selectDeletions = "transaction.selectDeletions";

	/**
	  *Constant "udpateChangeset" used to reference prepared statement  transaction.udpateChangeset
	  *
	  * <code>
	  *  		UPDATE {0} SET ADDGRAPH=?,REMOVEGRAPH=? ,METAADDGRAPH=?,METAREMOVEGRAPH=? WHERE ID=? 	
	  * </code>
	  */
	public static final String udpateChangeset = "transaction.udpateChangeset";

	/**
	  *Constant "insertChangeset" used to reference prepared statement  transaction.insertChangeset
	  *
	  * <code>
	  *  		INSERT INTO {0} (commandId, addGraph,removeGraph,metaddgraph,metaremovegraph,namedGraphUri) VALUES (?, ?, ?, ?,?,?) 	
	  * </code>
	  */
	public static final String insertChangeset = "transaction.insertChangeset";

	/**
	  *Constant "selectMaxChangesetId" used to reference prepared statement  transaction.selectMaxChangesetId
	  *
	  * <code>
	  *  		SELECT MAX(id) FROM {0} 	
	  * </code>
	  */
	public static final String selectMaxChangesetId = "transaction.selectMaxChangesetId";

	/**
	  *Constant "deleteChangeset" used to reference prepared statement  transaction.deleteChangeset
	  *
	  * <code>
	  *  		DELETE FROM {0} WHERE COMMANDID = ? AND ID = ? 	
	  * </code>
	  */
	public static final String deleteChangeset = "transaction.deleteChangeset";

	/**
	  *Constant "selectChangeset" used to reference prepared statement  transaction.selectChangeset
	  *
	  * <code>
	  *  		SELECT ID,ADDGRAPH,REMOVEGRAPH,METAADDGRAPH,METAREMOVEGRAPH,NAMEDGRAPHURI FROM {0} WHERE COMMANDID = ? ORDER BY ID 	
	  * </code>
	  */
	public static final String selectChangeset = "transaction.selectChangeset";

	/**
	  *Constant "updateCommand" used to reference prepared statement  transaction.updateCommand
	  *
	  * <code>
	  *  		UPDATE {0} set transactionId=?,commandType=?,context=?,preReq=? where id=? 	
	  * </code>
	  */
	public static final String updateCommand = "transaction.updateCommand";

	/**
	  *Constant "insertCommand" used to reference prepared statement  transaction.insertCommand
	  *
	  * <code>
	  *  		INSERT INTO {0} (transactionId, commandType,context,prereq) VALUES (?, ?, ?, ?) 	
	  * </code>
	  */
	public static final String insertCommand = "transaction.insertCommand";

	/**
	  *Constant "deleteCommand" used to reference prepared statement  transaction.deleteCommand
	  *
	  * <code>
	  *  		DELETE FROM {0} WHERE TRANSACTIONID = ? AND ID = ? 	
	  * </code>
	  */
	public static final String deleteCommand = "transaction.deleteCommand";

	/**
	  *Constant "deleteTransaction" used to reference prepared statement  transaction.deleteTransaction
	  *
	  * <code>
	  *  		DELETE FROM {0} WHERE ID = ? 	
	  * </code>
	  */
	public static final String deleteTransaction = "transaction.deleteTransaction";

	/**
	  *Constant "selectCommand" used to reference prepared statement  transaction.selectCommand
	  *
	  * <code>
	  *  		SELECT ID,COMMANDTYPE,PREREQ,CONTEXT FROM {0} WHERE TRANSACTIONID = ? ORDER BY ID 	
	  * </code>
	  */
	public static final String selectCommand = "transaction.selectCommand";

	/**
	  *Constant "insertTransaction" used to reference prepared statement  transaction.insertTransaction
	  *
	  * <code>
	  *  		INSERT INTO {0} (CREATED) VALUES (?) 	
	  * </code>
	  */
	public static final String insertTransaction = "transaction.insertTransaction";

	/**
	  *Constant "maxId" used to reference prepared statement  transaction.maxId
	  *
	  * <code>
	  *  		SELECT MAX(ID) FROM {0} 	
	  * </code>
	  */
	public static final String maxId = "transaction.maxId";

	/**
	  *Constant "selectTransactions" used to reference prepared statement  transaction.selectTransactions
	  *
	  * <code>
	  *  	   SELECT ID FROM {0} ORDER BY ID 	
	  * </code>
	  */
	public static final String selectTransactions = "transaction.selectTransactions";



	
	/**
	 * Runs the insertNotificationStatementAdd prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,NS,NE) VALUES(?,?,?,?,?,1,0) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertNotificationStatementAdd (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphid, long subj, long prop, long obj, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertNotificationStatementAdd, new String[] {transactionTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertNotificationStatementAdd",stmtProvider.getSqlString(insertNotificationStatementAdd) ,""+ "metadata="+(metadata) + "," +"namedgraphid="+(namedgraphid) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertNotificationStatementAdd]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertNotificationStatementAdd prepared statement
	 */
	public static class BatchInsertNotificationStatementAdd extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertNotificationStatementAdd prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertNotificationStatementAdd(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertNotificationStatementAdd,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the insertNotificationStatementAdd prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphid, long subj, long prop, long obj) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertNotificationStatementDel prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,NS,NE) VALUES(?,?,?,?,?,0,1) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertNotificationStatementDel (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphid, long subj, long prop, long obj, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertNotificationStatementDel, new String[] {transactionTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertNotificationStatementDel",stmtProvider.getSqlString(insertNotificationStatementDel) ,""+ "metadata="+(metadata) + "," +"namedgraphid="+(namedgraphid) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertNotificationStatementDel]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertNotificationStatementDel prepared statement
	 */
	public static class BatchInsertNotificationStatementDel extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertNotificationStatementDel prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertNotificationStatementDel(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertNotificationStatementDel,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the insertNotificationStatementDel prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphid, long subj, long prop, long obj) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the updateNotificationStatementAdd prepared statement.
	  * <code>
	 *  		UPDATE {0} SET NS=1,NE=0 WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NOT NULL OR TE_ID IS NOT NULL )  	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateNotificationStatementAdd (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphid, long subj, long prop, long obj, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateNotificationStatementAdd, new String[] {transactionTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateNotificationStatementAdd",stmtProvider.getSqlString(updateNotificationStatementAdd) ,""+ "metadata="+(metadata) + "," +"namedgraphid="+(namedgraphid) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateNotificationStatementAdd]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateNotificationStatementAdd prepared statement
	 */
	public static class BatchUpdateNotificationStatementAdd extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateNotificationStatementAdd prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateNotificationStatementAdd(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateNotificationStatementAdd,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the updateNotificationStatementAdd prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphid, long subj, long prop, long obj) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the updateNotificationStatementDel prepared statement.
	  * <code>
	 *  		UPDATE {0} SET NS=0,NE=1 WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NOT NULL OR TE_ID IS NOT NULL )  	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateNotificationStatementDel (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphid, long subj, long prop, long obj, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateNotificationStatementDel, new String[] {transactionTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateNotificationStatementDel",stmtProvider.getSqlString(updateNotificationStatementDel) ,""+ "metadata="+(metadata) + "," +"namedgraphid="+(namedgraphid) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateNotificationStatementDel]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateNotificationStatementDel prepared statement
	 */
	public static class BatchUpdateNotificationStatementDel extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateNotificationStatementDel prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateNotificationStatementDel(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateNotificationStatementDel,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the updateNotificationStatementDel prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphid, long subj, long prop, long obj) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeCommitedStatements prepared statement.
	  * <code>
	 *  		DELETE FROM  {0}_ST WHERE (TS_ID IS NOT NULL AND TS_ID=?) OR (TE_ID IS NOT NULL AND TE_ID=?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param lastTransaction template parameter
	 *@param lastTransaction2 template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeCommitedStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long lastTransaction, long lastTransaction2, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeCommitedStatements, new String[] {transactionTableName},connection); int argc = 1;
			ps.setLong(argc++, lastTransaction);
			ps.setLong(argc++, lastTransaction2);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeCommitedStatements",stmtProvider.getSqlString(purgeCommitedStatements) ,""+ "lastTransaction="+(lastTransaction) + "," +"lastTransaction2="+(lastTransaction2),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeCommitedStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeCommitedStatements prepared statement
	 */
	public static class BatchPurgeCommitedStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeCommitedStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeCommitedStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeCommitedStatements,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the purgeCommitedStatements prepared statement.
		 *
	 *@param lastTransaction template parameter
	 *@param lastTransaction2 template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long lastTransaction, long lastTransaction2) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, lastTransaction);
			ps.setLong(argc++, lastTransaction2);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeNotificationStatements prepared statement.
	  * <code>
	 *  		DELETE FROM  {0} WHERE TS_ID IS NULL AND TE_ID IS NULL AND (NS=1 OR NE=1) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeNotificationStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeNotificationStatements, new String[] {transactionTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeNotificationStatements",stmtProvider.getSqlString(purgeNotificationStatements) ,"",""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeNotificationStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeNotificationStatements prepared statement
	 */
	public static class BatchPurgeNotificationStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeNotificationStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeNotificationStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeNotificationStatements,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the purgeNotificationStatements prepared statement.
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
	 * Runs the updateStatementAdd prepared statement.
	  * <code>
	 *  		UPDATE {0} SET NS=0,NE=0,TS_ID=NULL,TE_ID=NULL,CS_ID=NULL,TE_ID=NULL WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NULL OR TS_ID<?) AND (TE_ID IS NULL OR TE_ID<?)  	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param lastTransaction template parameter
	 *@param lastTransaction2 template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateStatementAdd (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphid, long subj, long prop, long obj, long lastTransaction, long lastTransaction2, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateStatementAdd, new String[] {transactionTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, lastTransaction);
			ps.setLong(argc++, lastTransaction2);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateStatementAdd",stmtProvider.getSqlString(updateStatementAdd) ,""+ "metadata="+(metadata) + "," +"namedgraphid="+(namedgraphid) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj) + "," +"lastTransaction="+(lastTransaction) + "," +"lastTransaction2="+(lastTransaction2),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateStatementAdd]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateStatementAdd prepared statement
	 */
	public static class BatchUpdateStatementAdd extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateStatementAdd prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateStatementAdd(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateStatementAdd,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the updateStatementAdd prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param lastTransaction template parameter
	 *@param lastTransaction2 template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphid, long subj, long prop, long obj, long lastTransaction, long lastTransaction2) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, lastTransaction);
			ps.setLong(argc++, lastTransaction2);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the updateStatementDel prepared statement.
	  * <code>
	 *  		DELETE FROM  {0} WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND (TS_ID IS NULL OR TS_ID<?) AND (TE_ID IS NULL OR TE_ID<?)  	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param lastTransaction template parameter
	 *@param lastTransaction2 template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateStatementDel (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphid, long subj, long prop, long obj, long lastTransaction, long lastTransaction2, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateStatementDel, new String[] {transactionTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, lastTransaction);
			ps.setLong(argc++, lastTransaction2);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateStatementDel",stmtProvider.getSqlString(updateStatementDel) ,""+ "metadata="+(metadata) + "," +"namedgraphid="+(namedgraphid) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj) + "," +"lastTransaction="+(lastTransaction) + "," +"lastTransaction2="+(lastTransaction2),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateStatementDel]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateStatementDel prepared statement
	 */
	public static class BatchUpdateStatementDel extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateStatementDel prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateStatementDel(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateStatementDel,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the updateStatementDel prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param lastTransaction template parameter
	 *@param lastTransaction2 template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphid, long subj, long prop, long obj, long lastTransaction, long lastTransaction2) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, lastTransaction);
			ps.setLong(argc++, lastTransaction2);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertCommandStatementAdd prepared statement.
	  * <code>
	 *  		INSERT INTO {0}_ST (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,TS_ID,CS_ID) VALUES(?,?,?,?,?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param transId template parameter
	 *@param commandId template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertCommandStatementAdd (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphid, long subj, long prop, long obj, long transId, long commandId, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertCommandStatementAdd, new String[] {transactionTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, transId);
			ps.setLong(argc++, commandId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertCommandStatementAdd",stmtProvider.getSqlString(insertCommandStatementAdd) ,""+ "metadata="+(metadata) + "," +"namedgraphid="+(namedgraphid) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj) + "," +"transId="+(transId) + "," +"commandId="+(commandId),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertCommandStatementAdd]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertCommandStatementAdd prepared statement
	 */
	public static class BatchInsertCommandStatementAdd extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertCommandStatementAdd prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertCommandStatementAdd(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertCommandStatementAdd,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the insertCommandStatementAdd prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param transId template parameter
	 *@param commandId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphid, long subj, long prop, long obj, long transId, long commandId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, transId);
			ps.setLong(argc++, commandId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertCommandStatementDel prepared statement.
	  * <code>
	 *  		INSERT INTO {0}_ST (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ,TE_ID,CE_ID) VALUES(?,?,?,?,?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param transId template parameter
	 *@param commandId template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertCommandStatementDel (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphid, long subj, long prop, long obj, long transId, long commandId, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertCommandStatementDel, new String[] {transactionTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, transId);
			ps.setLong(argc++, commandId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertCommandStatementDel",stmtProvider.getSqlString(insertCommandStatementDel) ,""+ "metadata="+(metadata) + "," +"namedgraphid="+(namedgraphid) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj) + "," +"transId="+(transId) + "," +"commandId="+(commandId),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertCommandStatementDel]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertCommandStatementDel prepared statement
	 */
	public static class BatchInsertCommandStatementDel extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertCommandStatementDel prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertCommandStatementDel(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertCommandStatementDel,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the insertCommandStatementDel prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param transId template parameter
	 *@param commandId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphid, long subj, long prop, long obj, long transId, long commandId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, transId);
			ps.setLong(argc++, commandId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the updateTransactionStatementDel prepared statement.
	  * <code>
	 *  		UPDATE {0} SET TE_ID=?,CE_ID=? WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND TE_ID  IS NULL 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param transactionId template parameter
	 *@param commandId template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateTransactionStatementDel (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphid, long subj, long prop, long obj, long transactionId, long commandId, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateTransactionStatementDel, new String[] {transactionTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, commandId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateTransactionStatementDel",stmtProvider.getSqlString(updateTransactionStatementDel) ,""+ "metadata="+(metadata) + "," +"namedgraphid="+(namedgraphid) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj) + "," +"transactionId="+(transactionId) + "," +"commandId="+(commandId),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateTransactionStatementDel]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateTransactionStatementDel prepared statement
	 */
	public static class BatchUpdateTransactionStatementDel extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateTransactionStatementDel prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateTransactionStatementDel(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateTransactionStatementDel,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the updateTransactionStatementDel prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param transactionId template parameter
	 *@param commandId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphid, long subj, long prop, long obj, long transactionId, long commandId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, commandId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the updateTransactionStatementAdd prepared statement.
	  * <code>
	 *  		UPDATE {0} SET TS_ID=?,CS_ID=? WHERE METADATA=? AND NAMEDGRAPHID=? AND SUBJ=? AND PROP=? AND OBJ=? AND TS_ID IS NULL and TE_ID IS NULL AND CS_ID IS NULL AND CE_ID IS NULL 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param transactionId template parameter
	 *@param commandId template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateTransactionStatementAdd (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphid, long subj, long prop, long obj, long transactionId, long commandId, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateTransactionStatementAdd, new String[] {transactionTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, commandId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateTransactionStatementAdd",stmtProvider.getSqlString(updateTransactionStatementAdd) ,""+ "metadata="+(metadata) + "," +"namedgraphid="+(namedgraphid) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj) + "," +"transactionId="+(transactionId) + "," +"commandId="+(commandId),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateTransactionStatementAdd]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateTransactionStatementAdd prepared statement
	 */
	public static class BatchUpdateTransactionStatementAdd extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateTransactionStatementAdd prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateTransactionStatementAdd(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateTransactionStatementAdd,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the updateTransactionStatementAdd prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphid template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *@param transactionId template parameter
	 *@param commandId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphid, long subj, long prop, long obj, long transactionId, long commandId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, commandId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectAdditions prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectAdditionsResult> transformSelectAdditions = new org.openanzo.jdbc.utils.Transformer<SelectAdditionsResult>(){
		public SelectAdditionsResult transform(java.sql.ResultSet rs) {

			
				SelectAdditionsResult result = new SelectAdditionsResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.ng=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:ng",e);
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
	 * Runs the selectAdditions prepared statement.
	  * <code>
	 *  		SELECT ST.METADATA,ST.NAMEDGRAPHID,ST.subj,ST.prop,ST.obj FROM {0}_ST ST where ST.ts_id =? AND ST.cs_id=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param commandId2 template parameter
	 *
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectAdditionsResult> selectAdditions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long commandId2, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectAdditions, new String[] {containerName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, commandId2);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectAdditionsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectAdditionsResult>(rs, ps, stmtProvider, transformSelectAdditions);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectAdditions",stmtProvider.getSqlString(selectAdditions) ,""+ "transactionId="+(transactionId) + "," +"commandId2="+(commandId2),""+ "containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectAdditions]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectAdditionsResult
	 */
	public static class SelectAdditionsResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "ng" result value*/
			private long ng;
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
		  *Get Ng value
		  *@return Ng value
		  */
			public long getNg() {
				return this.ng;
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
	 * Transformer that transforms the rows in the result set for the selectDeletions prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectDeletionsResult> transformSelectDeletions = new org.openanzo.jdbc.utils.Transformer<SelectDeletionsResult>(){
		public SelectDeletionsResult transform(java.sql.ResultSet rs) {

			
				SelectDeletionsResult result = new SelectDeletionsResult();
				try {
				result.metadata=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metadata",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.ng=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:ng",e);
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
	 * Runs the selectDeletions prepared statement.
	  * <code>
	 *  		SELECT ST.METADATA,ST.NAMEDGRAPHID,ST.subj,ST.prop,ST.obj FROM {0}_ST ST where ST.te_id =? AND ST.ce_id=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param commandId template parameter
	 *
	 *@param containerName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectDeletionsResult> selectDeletions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long commandId, String containerName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectDeletions, new String[] {containerName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, commandId);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectDeletionsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectDeletionsResult>(rs, ps, stmtProvider, transformSelectDeletions);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectDeletions",stmtProvider.getSqlString(selectDeletions) ,""+ "transactionId="+(transactionId) + "," +"commandId="+(commandId),""+ "containerName="+((containerName!=null)?containerName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectDeletions]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectDeletionsResult
	 */
	public static class SelectDeletionsResult {
			/**Value for the "metadata" result value*/
			private int metadata;
			/**Value for the "ng" result value*/
			private long ng;
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
		  *Get Ng value
		  *@return Ng value
		  */
			public long getNg() {
				return this.ng;
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
	 * Runs the udpateChangeset prepared statement.
	  * <code>
	 *  		UPDATE {0} SET ADDGRAPH=?,REMOVEGRAPH=? ,METAADDGRAPH=?,METAREMOVEGRAPH=? WHERE ID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param addGraph template parameter
	 *@param removeGraph template parameter
	 *@param addMetaGraph template parameter
	 *@param removeMetaGraph template parameter
	 *@param id template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int udpateChangeset (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, java.sql.Clob addGraph, java.sql.Clob removeGraph, java.sql.Clob addMetaGraph, java.sql.Clob removeMetaGraph, long id, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(udpateChangeset, new String[] {transactionTableName},connection); int argc = 1;
			if(addGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, addGraph);
			}
			if(removeGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, removeGraph);
			}
			if(addMetaGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, addMetaGraph);
			}
			if(removeMetaGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, removeMetaGraph);
			}
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"udpateChangeset",stmtProvider.getSqlString(udpateChangeset) ,""+ "addGraph="+((addGraph!=null)?addGraph.toString():"null") + "," +"removeGraph="+((removeGraph!=null)?removeGraph.toString():"null") + "," +"addMetaGraph="+((addMetaGraph!=null)?addMetaGraph.toString():"null") + "," +"removeMetaGraph="+((removeMetaGraph!=null)?removeMetaGraph.toString():"null") + "," +"id="+(id),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[udpateChangeset]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UdpateChangeset prepared statement
	 */
	public static class BatchUdpateChangeset extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UdpateChangeset prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUdpateChangeset(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,udpateChangeset,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the udpateChangeset prepared statement.
		 *
	 *@param addGraph template parameter
	 *@param removeGraph template parameter
	 *@param addMetaGraph template parameter
	 *@param removeMetaGraph template parameter
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (java.sql.Clob addGraph, java.sql.Clob removeGraph, java.sql.Clob addMetaGraph, java.sql.Clob removeMetaGraph, long id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(addGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, addGraph);
			}
			if(removeGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, removeGraph);
			}
			if(addMetaGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, addMetaGraph);
			}
			if(removeMetaGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, removeMetaGraph);
			}
			ps.setLong(argc++, id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertChangeset prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (commandId, addGraph,removeGraph,metaddgraph,metaremovegraph,namedGraphUri) VALUES (?, ?, ?, ?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param commandId template parameter
	 *@param addGraph template parameter
	 *@param removeGraph template parameter
	 *@param addMetaGraph template parameter
	 *@param removeMetaGraph template parameter
	 *@param uri template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertChangeset (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long commandId, java.sql.Clob addGraph, java.sql.Clob removeGraph, java.sql.Clob addMetaGraph, java.sql.Clob removeMetaGraph, String uri, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertChangeset, new String[] {transactionTableName},connection); int argc = 1;
			ps.setLong(argc++, commandId);
			if(addGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, addGraph);
			}
			if(removeGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, removeGraph);
			}
			if(addMetaGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, addMetaGraph);
			}
			if(removeMetaGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, removeMetaGraph);
			}
			if(uri == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, uri);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertChangeset",stmtProvider.getSqlString(insertChangeset) ,""+ "commandId="+(commandId) + "," +"addGraph="+((addGraph!=null)?addGraph.toString():"null") + "," +"removeGraph="+((removeGraph!=null)?removeGraph.toString():"null") + "," +"addMetaGraph="+((addMetaGraph!=null)?addMetaGraph.toString():"null") + "," +"removeMetaGraph="+((removeMetaGraph!=null)?removeMetaGraph.toString():"null") + "," +"uri="+((uri!=null)?uri.toString():"null"),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertChangeset]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertChangeset prepared statement
	 */
	public static class BatchInsertChangeset extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertChangeset prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertChangeset(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertChangeset,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the insertChangeset prepared statement.
		 *
	 *@param commandId template parameter
	 *@param addGraph template parameter
	 *@param removeGraph template parameter
	 *@param addMetaGraph template parameter
	 *@param removeMetaGraph template parameter
	 *@param uri template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long commandId, java.sql.Clob addGraph, java.sql.Clob removeGraph, java.sql.Clob addMetaGraph, java.sql.Clob removeMetaGraph, String uri) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, commandId);
			if(addGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, addGraph);
			}
			if(removeGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, removeGraph);
			}
			if(addMetaGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, addMetaGraph);
			}
			if(removeMetaGraph == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, removeMetaGraph);
			}
			if(uri == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, uri);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the selectMaxChangesetId prepared statement.
	  * <code>
	 *  		SELECT MAX(id) FROM {0} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param transactionTableName template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long selectMaxChangesetId (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectMaxChangesetId, new String[] {transactionTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectMaxChangesetId",stmtProvider.getSqlString(selectMaxChangesetId) ,"",""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectMaxChangesetId]"+endtimer);
		}
	}




	
	/**
	 * Runs the deleteChangeset prepared statement.
	  * <code>
	 *  		DELETE FROM {0} WHERE COMMANDID = ? AND ID = ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param cmdId template parameter
	 *@param csId template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteChangeset (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long cmdId, long csId, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteChangeset, new String[] {transactionTableName},connection); int argc = 1;
			ps.setLong(argc++, cmdId);
			ps.setLong(argc++, csId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteChangeset",stmtProvider.getSqlString(deleteChangeset) ,""+ "cmdId="+(cmdId) + "," +"csId="+(csId),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteChangeset]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteChangeset prepared statement
	 */
	public static class BatchDeleteChangeset extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteChangeset prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteChangeset(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteChangeset,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the deleteChangeset prepared statement.
		 *
	 *@param cmdId template parameter
	 *@param csId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long cmdId, long csId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, cmdId);
			ps.setLong(argc++, csId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectChangeset prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectChangesetResult> transformSelectChangeset = new org.openanzo.jdbc.utils.Transformer<SelectChangesetResult>(){
		public SelectChangesetResult transform(java.sql.ResultSet rs) {

			
				SelectChangesetResult result = new SelectChangesetResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.addGraph=rs.getClob(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:addGraph",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.removeGraph=rs.getClob(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:removeGraph",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.metaAddGraph=rs.getClob(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metaAddGraph",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.metaRemoveGraph=rs.getClob(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metaRemoveGraph",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.nameGraphUri=rs.getString(6);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:nameGraphUri",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectChangeset prepared statement.
	  * <code>
	 *  		SELECT ID,ADDGRAPH,REMOVEGRAPH,METAADDGRAPH,METAREMOVEGRAPH,NAMEDGRAPHURI FROM {0} WHERE COMMANDID = ? ORDER BY ID 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param cmdId template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectChangesetResult> selectChangeset (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long cmdId, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectChangeset, new String[] {transactionTableName},connection); int argc = 1;
			ps.setLong(argc++, cmdId);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectChangesetResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectChangesetResult>(rs, ps, stmtProvider, transformSelectChangeset);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectChangeset",stmtProvider.getSqlString(selectChangeset) ,""+ "cmdId="+(cmdId),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectChangeset]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectChangesetResult
	 */
	public static class SelectChangesetResult {
			/**Value for the "id" result value*/
			private long id;
			/**Value for the "addGraph" result value*/
			private java.sql.Clob addGraph;
			/**Value for the "removeGraph" result value*/
			private java.sql.Clob removeGraph;
			/**Value for the "metaAddGraph" result value*/
			private java.sql.Clob metaAddGraph;
			/**Value for the "metaRemoveGraph" result value*/
			private java.sql.Clob metaRemoveGraph;
			/**Value for the "nameGraphUri" result value*/
			private String nameGraphUri;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public long getId() {
				return this.id;
			}

		/**
		  *Get AddGraph value
		  *@return AddGraph value
		  */
			public java.sql.Clob getAddGraph() {
				return this.addGraph;
			}

		/**
		  *Get RemoveGraph value
		  *@return RemoveGraph value
		  */
			public java.sql.Clob getRemoveGraph() {
				return this.removeGraph;
			}

		/**
		  *Get MetaAddGraph value
		  *@return MetaAddGraph value
		  */
			public java.sql.Clob getMetaAddGraph() {
				return this.metaAddGraph;
			}

		/**
		  *Get MetaRemoveGraph value
		  *@return MetaRemoveGraph value
		  */
			public java.sql.Clob getMetaRemoveGraph() {
				return this.metaRemoveGraph;
			}

		/**
		  *Get NameGraphUri value
		  *@return NameGraphUri value
		  */
			public String getNameGraphUri() {
				return this.nameGraphUri;
			}

	}



	
	/**
	 * Runs the updateCommand prepared statement.
	  * <code>
	 *  		UPDATE {0} set transactionId=?,commandType=?,context=?,preReq=? where id=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param commandType template parameter
	 *@param context template parameter
	 *@param preReq template parameter
	 *@param id template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateCommand (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String commandType, java.sql.Clob context, java.sql.Clob preReq, long id, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateCommand, new String[] {transactionTableName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			if(commandType == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, commandType);
			}
			if(context == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, context);
			}
			if(preReq == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, preReq);
			}
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateCommand",stmtProvider.getSqlString(updateCommand) ,""+ "transactionId="+(transactionId) + "," +"commandType="+((commandType!=null)?commandType.toString():"null") + "," +"context="+((context!=null)?context.toString():"null") + "," +"preReq="+((preReq!=null)?preReq.toString():"null") + "," +"id="+(id),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateCommand]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateCommand prepared statement
	 */
	public static class BatchUpdateCommand extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateCommand prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateCommand(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateCommand,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the updateCommand prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param commandType template parameter
	 *@param context template parameter
	 *@param preReq template parameter
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, String commandType, java.sql.Clob context, java.sql.Clob preReq, long id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			if(commandType == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, commandType);
			}
			if(context == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, context);
			}
			if(preReq == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, preReq);
			}
			ps.setLong(argc++, id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertCommand prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (transactionId, commandType,context,prereq) VALUES (?, ?, ?, ?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param commandType template parameter
	 *@param context template parameter
	 *@param preReq template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertCommand (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String commandType, java.sql.Clob context, java.sql.Clob preReq, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertCommand, new String[] {transactionTableName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			if(commandType == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, commandType);
			}
			if(context == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, context);
			}
			if(preReq == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, preReq);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertCommand",stmtProvider.getSqlString(insertCommand) ,""+ "transactionId="+(transactionId) + "," +"commandType="+((commandType!=null)?commandType.toString():"null") + "," +"context="+((context!=null)?context.toString():"null") + "," +"preReq="+((preReq!=null)?preReq.toString():"null"),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertCommand]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertCommand prepared statement
	 */
	public static class BatchInsertCommand extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertCommand prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertCommand(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertCommand,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the insertCommand prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param commandType template parameter
	 *@param context template parameter
	 *@param preReq template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, String commandType, java.sql.Clob context, java.sql.Clob preReq) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			if(commandType == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, commandType);
			}
			if(context == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, context);
			}
			if(preReq == null) {
				ps.setNull(argc++, java.sql.Types.CLOB);
			} else {
				ps.setClob(argc++, preReq);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteCommand prepared statement.
	  * <code>
	 *  		DELETE FROM {0} WHERE TRANSACTIONID = ? AND ID = ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param cmdId template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteCommand (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long cmdId, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteCommand, new String[] {transactionTableName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, cmdId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteCommand",stmtProvider.getSqlString(deleteCommand) ,""+ "transactionId="+(transactionId) + "," +"cmdId="+(cmdId),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteCommand]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteCommand prepared statement
	 */
	public static class BatchDeleteCommand extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteCommand prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteCommand(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteCommand,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the deleteCommand prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param cmdId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long cmdId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, cmdId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteTransaction prepared statement.
	  * <code>
	 *  		DELETE FROM {0} WHERE ID = ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteTransaction (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteTransaction, new String[] {transactionTableName},connection); int argc = 1;
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteTransaction",stmtProvider.getSqlString(deleteTransaction) ,""+ "transactionId="+(transactionId),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteTransaction]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteTransaction prepared statement
	 */
	public static class BatchDeleteTransaction extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteTransaction prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteTransaction(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteTransaction,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the deleteTransaction prepared statement.
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
	 * Transformer that transforms the rows in the result set for the selectCommand prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectCommandResult> transformSelectCommand = new org.openanzo.jdbc.utils.Transformer<SelectCommandResult>(){
		public SelectCommandResult transform(java.sql.ResultSet rs) {

			
				SelectCommandResult result = new SelectCommandResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.commandType=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:commandType",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prereq=rs.getClob(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prereq",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.context=rs.getClob(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:context",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectCommand prepared statement.
	  * <code>
	 *  		SELECT ID,COMMANDTYPE,PREREQ,CONTEXT FROM {0} WHERE TRANSACTIONID = ? ORDER BY ID 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectCommandResult> selectCommand (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectCommand, new String[] {transactionTableName},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectCommandResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectCommandResult>(rs, ps, stmtProvider, transformSelectCommand);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectCommand",stmtProvider.getSqlString(selectCommand) ,""+ "transactionId="+(transactionId),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectCommand]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectCommandResult
	 */
	public static class SelectCommandResult {
			/**Value for the "id" result value*/
			private long id;
			/**Value for the "commandType" result value*/
			private String commandType;
			/**Value for the "prereq" result value*/
			private java.sql.Clob prereq;
			/**Value for the "context" result value*/
			private java.sql.Clob context;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public long getId() {
				return this.id;
			}

		/**
		  *Get CommandType value
		  *@return CommandType value
		  */
			public String getCommandType() {
				return this.commandType;
			}

		/**
		  *Get Prereq value
		  *@return Prereq value
		  */
			public java.sql.Clob getPrereq() {
				return this.prereq;
			}

		/**
		  *Get Context value
		  *@return Context value
		  */
			public java.sql.Clob getContext() {
				return this.context;
			}

	}



	
	/**
	 * Runs the insertTransaction prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (CREATED) VALUES (?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param created template parameter
	 *
	 *@param transactionTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertTransaction (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, java.sql.Timestamp created, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertTransaction, new String[] {transactionTableName},connection); int argc = 1;
			if(created == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"created","insertTransaction");
			} else {
				ps.setTimestamp(argc++, created);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertTransaction",stmtProvider.getSqlString(insertTransaction) ,""+ "created="+((created!=null)?created.toString():"null"),""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertTransaction]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertTransaction prepared statement
	 */
	public static class BatchInsertTransaction extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertTransaction prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param transactionTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertTransaction(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertTransaction,new String[] {transactionTableName});
		}
		
		/**
		 * Sets the input parameters for the insertTransaction prepared statement.
		 *
	 *@param created template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (java.sql.Timestamp created) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(created == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"created","insertTransaction");
			} else {
				ps.setTimestamp(argc++, created);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the maxId prepared statement.
	  * <code>
	 *  		SELECT MAX(ID) FROM {0} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param transactionTableName template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long maxId (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(maxId, new String[] {transactionTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"maxId",stmtProvider.getSqlString(maxId) ,"",""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[maxId]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectTransactions prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectTransactions = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the selectTransactions prepared statement.
	  * <code>
	 *  	   SELECT ID FROM {0} ORDER BY ID 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param transactionTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectTransactions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String transactionTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectTransactions, new String[] {transactionTableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectTransactions);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectTransactions",stmtProvider.getSqlString(selectTransactions) ,"",""+ "transactionTableName="+((transactionTableName!=null)?transactionTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectTransactions]"+endtimer);
		}
	}


}