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
package org.openanzo.datasource.nodecentric.sql;
// allow for all types that can be returned from a resultset

/**
 *	LastTransactionTime provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class LastTransactionTime {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(LastTransactionTime.class);
	static final long CUTOFF=5;

	/**
	  *Constant "getLastTransactionTime" used to reference prepared statement  LastTransaction.getLastTransactionTime
	  *
	  * <code>
	  *  		SELECT COMMITED FROM LASTTRANSACTIONTIME 	
	  * </code>
	  */
	public static final String getLastTransactionTime = "LastTransaction.getLastTransactionTime";

	/**
	  *Constant "getLastTransaction" used to reference prepared statement  LastTransaction.getLastTransaction
	  *
	  * <code>
	  *  		SELECT COMMITED FROM LASTTRANSACTIONTIME WHERE ID=0 	
	  * </code>
	  */
	public static final String getLastTransaction = "LastTransaction.getLastTransaction";

	/**
	  *Constant "insertLastTransactionTime" used to reference prepared statement  LastTransaction.insertLastTransactionTime
	  *
	  * <code>
	  *  		UPDATE LASTTRANSACTIONTIME SET COMMITED=? WHERE ID=0 	
	  * </code>
	  */
	public static final String insertLastTransactionTime = "LastTransaction.insertLastTransactionTime";

	/**
	  *Constant "insertFirstTransactionTime" used to reference prepared statement  LastTransaction.insertFirstTransactionTime
	  *
	  * <code>
	  *  		INSERT INTO LASTTRANSACTIONTIME (ID,COMMITED)VALUES(0,?) 	
	  * </code>
	  */
	public static final String insertFirstTransactionTime = "LastTransaction.insertFirstTransactionTime";

	/**
	  *Constant "insertTransaction" used to reference prepared statement  LastTransaction.insertTransaction
	  *
	  * <code>
	  *  		INSERT INTO TRANSACTIONTIME (ID,COMMITED,SERVERID,URI,CONTEXT) VALUES(?,-1,?,?,?) 	
	  * </code>
	  */
	public static final String insertTransaction = "LastTransaction.insertTransaction";

	/**
	  *Constant "updateTransaction" used to reference prepared statement  LastTransaction.updateTransaction
	  *
	  * <code>
	  *  		UPDATE TRANSACTIONTIME SET COMMITED=? WHERE ID=? 	
	  * </code>
	  */
	public static final String updateTransaction = "LastTransaction.updateTransaction";

	/**
	  *Constant "purgeTransactions" used to reference prepared statement  LastTransaction.purgeTransactions
	  *
	  * <code>
	  *  		DELETE FROM TRANSACTIONTIME WHERE SERVERID=? AND COMMITED=-1 	
	  * </code>
	  */
	public static final String purgeTransactions = "LastTransaction.purgeTransactions";

	/**
	  *Constant "abortTransactions" used to reference prepared statement  LastTransaction.abortTransactions
	  *
	  * <code>
	  *  		DELETE FROM TRANSACTIONTIME WHERE ID= ? 	
	  * </code>
	  */
	public static final String abortTransactions = "LastTransaction.abortTransactions";

	/**
	  *Constant "selectUncommitedTransactions" used to reference prepared statement  LastTransaction.selectUncommitedTransactions
	  *
	  * <code>
	  *  		SELECT ID FROM TRANSACTIONTIME WHERE SERVERID=? AND COMMITED =-1 	
	  * </code>
	  */
	public static final String selectUncommitedTransactions = "LastTransaction.selectUncommitedTransactions";

	/**
	  *Constant "selectUnactivatedTransactions" used to reference prepared statement  LastTransaction.selectUnactivatedTransactions
	  *
	  * <code>
	  *  		SELECT ID FROM TRANSACTIONTIME WHERE SERVERID=? AND COMMITED =0 	
	  * </code>
	  */
	public static final String selectUnactivatedTransactions = "LastTransaction.selectUnactivatedTransactions";

	/**
	  *Constant "selectCurrentTimestamp" used to reference prepared statement  LastTransaction.selectCurrentTimestamp
	  *
	  * <code>
	  * NULL
	  * </code>
	  */
	public static final String selectCurrentTimestamp = "LastTransaction.selectCurrentTimestamp";



	
	/**
	 * Runs the getLastTransactionTime prepared statement.
	  * <code>
	 *  		SELECT COMMITED FROM LASTTRANSACTIONTIME 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long getLastTransactionTime (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getLastTransactionTime, new String[] {},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getLastTransactionTime",stmtProvider.getSqlString(getLastTransactionTime) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getLastTransactionTime]"+endtimer);
		}
	}




	
	/**
	 * Runs the getLastTransaction prepared statement.
	  * <code>
	 *  		SELECT COMMITED FROM LASTTRANSACTIONTIME WHERE ID=0 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long getLastTransaction (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getLastTransaction, new String[] {},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getLastTransaction",stmtProvider.getSqlString(getLastTransaction) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getLastTransaction]"+endtimer);
		}
	}




	
	/**
	 * Runs the insertLastTransactionTime prepared statement.
	  * <code>
	 *  		UPDATE LASTTRANSACTIONTIME SET COMMITED=? WHERE ID=0 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param commited template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertLastTransactionTime (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long commited) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertLastTransactionTime, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, commited);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLastTransactionTime",stmtProvider.getSqlString(insertLastTransactionTime) ,""+ "commited="+(commited),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertLastTransactionTime]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertLastTransactionTime prepared statement
	 */
	public static class BatchInsertLastTransactionTime extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertLastTransactionTime prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLastTransactionTime(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLastTransactionTime,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the insertLastTransactionTime prepared statement.
		 *
	 *@param commited template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long commited) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, commited);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertFirstTransactionTime prepared statement.
	  * <code>
	 *  		INSERT INTO LASTTRANSACTIONTIME (ID,COMMITED)VALUES(0,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param commited template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertFirstTransactionTime (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long commited) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertFirstTransactionTime, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, commited);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertFirstTransactionTime",stmtProvider.getSqlString(insertFirstTransactionTime) ,""+ "commited="+(commited),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertFirstTransactionTime]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertFirstTransactionTime prepared statement
	 */
	public static class BatchInsertFirstTransactionTime extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertFirstTransactionTime prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertFirstTransactionTime(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertFirstTransactionTime,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the insertFirstTransactionTime prepared statement.
		 *
	 *@param commited template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long commited) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, commited);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertTransaction prepared statement.
	  * <code>
	 *  		INSERT INTO TRANSACTIONTIME (ID,COMMITED,SERVERID,URI,CONTEXT) VALUES(?,-1,?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param serverId template parameter
	 *@param transactionUriId template parameter
	 *@param transactionContext template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertTransaction (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String serverId, long transactionUriId, String transactionContext) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertTransaction, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
			if(serverId == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"serverId","insertTransaction");
			} else {
				ps.setString(argc++, serverId);
			}
			ps.setLong(argc++, transactionUriId);
			if(transactionContext == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, transactionContext);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertTransaction",stmtProvider.getSqlString(insertTransaction) ,""+ "id="+(id) + "," +"serverId="+((serverId!=null)?serverId.toString():"null") + "," +"transactionUriId="+(transactionUriId) + "," +"transactionContext="+((transactionContext!=null)?transactionContext.toString():"null"),"");
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
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertTransaction(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertTransaction,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the insertTransaction prepared statement.
		 *
	 *@param id template parameter
	 *@param serverId template parameter
	 *@param transactionUriId template parameter
	 *@param transactionContext template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, String serverId, long transactionUriId, String transactionContext) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			if(serverId == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"serverId","insertTransaction");
			} else {
				ps.setString(argc++, serverId);
			}
			ps.setLong(argc++, transactionUriId);
			if(transactionContext == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, transactionContext);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the updateTransaction prepared statement.
	  * <code>
	 *  		UPDATE TRANSACTIONTIME SET COMMITED=? WHERE ID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param commited template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int updateTransaction (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, long commited) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateTransaction, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, commited);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateTransaction",stmtProvider.getSqlString(updateTransaction) ,""+ "id="+(id) + "," +"commited="+(commited),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateTransaction]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateTransaction prepared statement
	 */
	public static class BatchUpdateTransaction extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateTransaction prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateTransaction(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateTransaction,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the updateTransaction prepared statement.
		 *
	 *@param id template parameter
	 *@param commited template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, long commited) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, commited);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeTransactions prepared statement.
	  * <code>
	 *  		DELETE FROM TRANSACTIONTIME WHERE SERVERID=? AND COMMITED=-1 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param serverId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeTransactions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String serverId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeTransactions, new String[] {},connection); int argc = 1;
			if(serverId == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"serverId","purgeTransactions");
			} else {
				ps.setString(argc++, serverId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeTransactions",stmtProvider.getSqlString(purgeTransactions) ,""+ "serverId="+((serverId!=null)?serverId.toString():"null"),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeTransactions]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeTransactions prepared statement
	 */
	public static class BatchPurgeTransactions extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeTransactions prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeTransactions(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeTransactions,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the purgeTransactions prepared statement.
		 *
	 *@param serverId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String serverId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(serverId == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"serverId","purgeTransactions");
			} else {
				ps.setString(argc++, serverId);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactions prepared statement.
	  * <code>
	 *  		DELETE FROM TRANSACTIONTIME WHERE ID= ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactions, new String[] {},connection); int argc = 1;
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactions",stmtProvider.getSqlString(abortTransactions) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactions]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactions prepared statement
	 */
	public static class BatchAbortTransactions extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactions prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactions(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactions,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the abortTransactions prepared statement.
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
	 * Transformer that transforms the rows in the result set for the selectUncommitedTransactions prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectUncommitedTransactions = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the selectUncommitedTransactions prepared statement.
	  * <code>
	 *  		SELECT ID FROM TRANSACTIONTIME WHERE SERVERID=? AND COMMITED =-1 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param serverId template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectUncommitedTransactions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String serverId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectUncommitedTransactions, new String[] {},connection); int argc = 1;
			if(serverId == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, serverId);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectUncommitedTransactions);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectUncommitedTransactions",stmtProvider.getSqlString(selectUncommitedTransactions) ,""+ "serverId="+((serverId!=null)?serverId.toString():"null"),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectUncommitedTransactions]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectUnactivatedTransactions prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectUnactivatedTransactions = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the selectUnactivatedTransactions prepared statement.
	  * <code>
	 *  		SELECT ID FROM TRANSACTIONTIME WHERE SERVERID=? AND COMMITED =0 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param serverId template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectUnactivatedTransactions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String serverId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectUnactivatedTransactions, new String[] {},connection); int argc = 1;
			if(serverId == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, serverId);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectUnactivatedTransactions);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectUnactivatedTransactions",stmtProvider.getSqlString(selectUnactivatedTransactions) ,""+ "serverId="+((serverId!=null)?serverId.toString():"null"),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectUnactivatedTransactions]"+endtimer);
		}
	}




	
	/**
	 * Runs the selectCurrentTimestamp prepared statement.
	  * <code>
	 * NULL
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@return  SelectCurrentTimestampResult
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static SelectCurrentTimestampResult selectCurrentTimestamp (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectCurrentTimestamp, new String[] {},connection);
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
		SelectCurrentTimestampResult result=new SelectCurrentTimestampResult();
				result.timestamp=rs.getTimestamp(1);
				result.lastTime=rs.getLong(2);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectCurrentTimestamp",stmtProvider.getSqlString(selectCurrentTimestamp) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectCurrentTimestamp]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectCurrentTimestampResult
	 */
	public static class SelectCurrentTimestampResult {
			/**Value for the "timestamp" result value*/
			private java.sql.Timestamp timestamp;
			/**Value for the "lastTime" result value*/
			private Long lastTime;

		/**
		  *Get Timestamp value
		  *@return Timestamp value
		  */
			public java.sql.Timestamp getTimestamp() {
				return this.timestamp;
			}

		/**
		  *Get LastTime value
		  *@return LastTime value
		  */
			public Long getLastTime() {
				return this.lastTime;
			}

	}

}