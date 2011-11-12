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
 *	ServerRdbWrapper provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class ServerRdbWrapper {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(ServerRdbWrapper.class);
	static final long CUTOFF=5;

	/**
	  *Constant "setInitialized" used to reference prepared statement  Server.setInitialized
	  *
	  * <code>
	  *  		UPDATE SERVER SET ID=?,INITIALIZED=1 WHERE INITIALIZED>1; 	
	  * </code>
	  */
	public static final String setInitialized = "Server.setInitialized";

	/**
	  *Constant "setServerId" used to reference prepared statement  Server.setServerId
	  *
	  * <code>
	  *  		UPDATE SERVER SET ID=? WHERE INITIALIZED=1; 	
	  * </code>
	  */
	public static final String setServerId = "Server.setServerId";

	/**
	  *Constant "getServerId" used to reference prepared statement  Server.getServerId
	  *
	  * <code>
	  *  		SELECT ID FROM SERVER; 	
	  * </code>
	  */
	public static final String getServerId = "Server.getServerId";

	/**
	  *Constant "getServerVersion" used to reference prepared statement  Server.getServerVersion
	  *
	  * <code>
	  *  		SELECT VERSION FROM SERVER; 	
	  * </code>
	  */
	public static final String getServerVersion = "Server.getServerVersion";

	/**
	  *Constant "setServerVersion" used to reference prepared statement  Server.setServerVersion
	  *
	  * <code>
	  *  		UPDATE SERVER SET VERSION=? WHERE INITIALIZED=1; 	
	  * </code>
	  */
	public static final String setServerVersion = "Server.setServerVersion";

	/**
	  *Constant "getInitialized" used to reference prepared statement  Server.getInitialized
	  *
	  * <code>
	  *  		SELECT INITIALIZED FROM SERVER; 	
	  * </code>
	  */
	public static final String getInitialized = "Server.getInitialized";

	/**
	  *Constant "setInitializing" used to reference prepared statement  Server.setInitializing
	  *
	  * <code>
	  *  		UPDATE SERVER SET INITIALIZED=? 	
	  * </code>
	  */
	public static final String setInitializing = "Server.setInitializing";

	/**
	  *Constant "setInitializingFailed" used to reference prepared statement  Server.setInitializingFailed
	  *
	  * <code>
	  *  		UPDATE SERVER SET INITIALIZED=NULL 	
	  * </code>
	  */
	public static final String setInitializingFailed = "Server.setInitializingFailed";

	/**
	  *Constant "lockTable" used to reference prepared statement  Server.lockTable
	  *
	  * <code>
	  *  		LOCK TABLE {0} {1} 	
	  * </code>
	  */
	public static final String lockTable = "Server.lockTable";

	/**
	  *Constant "unlockTable" used to reference prepared statement  Server.unlockTable
	  *
	  * <code>
	  * 
	  * </code>
	  */
	public static final String unlockTable = "Server.unlockTable";

	/**
	  *Constant "stats" used to reference prepared statement  Server.stats
	  *
	  * <code>
	  * 
	  * </code>
	  */
	public static final String stats = "Server.stats";



	
	/**
	 * Runs the setInitialized prepared statement.
	  * <code>
	 *  		UPDATE SERVER SET ID=?,INITIALIZED=1 WHERE INITIALIZED>1; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int setInitialized (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(setInitialized, new String[] {},connection); int argc = 1;
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"setInitialized",stmtProvider.getSqlString(setInitialized) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[setInitialized]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the SetInitialized prepared statement
	 */
	public static class BatchSetInitialized extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the SetInitialized prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchSetInitialized(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,setInitialized,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the setInitialized prepared statement.
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
	 * Runs the setServerId prepared statement.
	  * <code>
	 *  		UPDATE SERVER SET ID=? WHERE INITIALIZED=1; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int setServerId (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(setServerId, new String[] {},connection); int argc = 1;
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"setServerId",stmtProvider.getSqlString(setServerId) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[setServerId]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the SetServerId prepared statement
	 */
	public static class BatchSetServerId extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the SetServerId prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchSetServerId(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,setServerId,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the setServerId prepared statement.
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
	 * Runs the getServerId prepared statement.
	  * <code>
	 *  		SELECT ID FROM SERVER; 	
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
	public static Long getServerId (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getServerId, new String[] {},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getServerId",stmtProvider.getSqlString(getServerId) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getServerId]"+endtimer);
		}
	}




	
	/**
	 * Runs the getServerVersion prepared statement.
	  * <code>
	 *  		SELECT VERSION FROM SERVER; 	
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
	public static Long getServerVersion (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getServerVersion, new String[] {},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getServerVersion",stmtProvider.getSqlString(getServerVersion) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getServerVersion]"+endtimer);
		}
	}




	
	/**
	 * Runs the setServerVersion prepared statement.
	  * <code>
	 *  		UPDATE SERVER SET VERSION=? WHERE INITIALIZED=1; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param version template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int setServerVersion (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long version) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(setServerVersion, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, version);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"setServerVersion",stmtProvider.getSqlString(setServerVersion) ,""+ "version="+(version),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[setServerVersion]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the SetServerVersion prepared statement
	 */
	public static class BatchSetServerVersion extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the SetServerVersion prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchSetServerVersion(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,setServerVersion,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the setServerVersion prepared statement.
		 *
	 *@param version template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long version) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, version);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the getInitialized prepared statement.
	  * <code>
	 *  		SELECT INITIALIZED FROM SERVER; 	
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
	public static Long getInitialized (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getInitialized, new String[] {},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getInitialized",stmtProvider.getSqlString(getInitialized) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getInitialized]"+endtimer);
		}
	}




	
	/**
	 * Runs the setInitializing prepared statement.
	  * <code>
	 *  		UPDATE SERVER SET INITIALIZED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param timer template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int setInitializing (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long timer) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(setInitializing, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, timer);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"setInitializing",stmtProvider.getSqlString(setInitializing) ,""+ "timer="+(timer),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[setInitializing]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the SetInitializing prepared statement
	 */
	public static class BatchSetInitializing extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the SetInitializing prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchSetInitializing(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,setInitializing,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the setInitializing prepared statement.
		 *
	 *@param timer template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long timer) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, timer);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the setInitializingFailed prepared statement.
	  * <code>
	 *  		UPDATE SERVER SET INITIALIZED=NULL 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int setInitializingFailed (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(setInitializingFailed, new String[] {},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"setInitializingFailed",stmtProvider.getSqlString(setInitializingFailed) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[setInitializingFailed]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the SetInitializingFailed prepared statement
	 */
	public static class BatchSetInitializingFailed extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the SetInitializingFailed prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchSetInitializingFailed(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,setInitializingFailed,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the setInitializingFailed prepared statement.
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
	 * Runs the lockTable prepared statement.
	  * <code>
	 *  		LOCK TABLE {0} {1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *@param tableLocksExtra template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void lockTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName, String tableLocksExtra) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(lockTable, new String[] {tableName, tableLocksExtra},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"lockTable",stmtProvider.getSqlString(lockTable) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null") + "," +"tableLocksExtra="+((tableLocksExtra!=null)?tableLocksExtra.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[lockTable]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the LockTable prepared statement
	 */
	public static class BatchLockTable extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the LockTable prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tableName template parameter
	 *@param tableLocksExtra template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchLockTable(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tableName, String tableLocksExtra) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,lockTable,new String[] {tableName, tableLocksExtra});
		}
		
		/**
		 * Sets the input parameters for the lockTable prepared statement.
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
	 * Runs the unlockTable prepared statement.
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
	 *@param tableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void unlockTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(unlockTable, new String[] {tableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"unlockTable",stmtProvider.getSqlString(unlockTable) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[unlockTable]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UnlockTable prepared statement
	 */
	public static class BatchUnlockTable extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UnlockTable prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUnlockTable(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,unlockTable,new String[] {tableName});
		}
		
		/**
		 * Sets the input parameters for the unlockTable prepared statement.
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
	 * Runs the stats prepared statement.
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
	 *@param tablename template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void stats (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tablename) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(stats, new String[] {tablename},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"stats",stmtProvider.getSqlString(stats) ,"",""+ "tablename="+((tablename!=null)?tablename.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[stats]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Stats prepared statement
	 */
	public static class BatchStats extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Stats prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tablename template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchStats(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tablename) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,stats,new String[] {tablename});
		}
		
		/**
		 * Sets the input parameters for the stats prepared statement.
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


}