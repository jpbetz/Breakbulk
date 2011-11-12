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
 *	SequencesSQL provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class SequencesSQL {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(SequencesSQL.class);
	static final long CUTOFF=5;

	/**
	  *Constant "insertNode" used to reference prepared statement  with-sequences.insertNode
	  *
	  * <code>
	  * 
	  * </code>
	  */
	public static final String insertNode = "with-sequences.insertNode";

	/**
	  *Constant "insertLongNode" used to reference prepared statement  with-sequences.insertLongNode
	  *
	  * <code>
	  * 
	  * </code>
	  */
	public static final String insertLongNode = "with-sequences.insertLongNode";

	/**
	  *Constant "insertLiteral" used to reference prepared statement  with-sequences.insertLiteral
	  *
	  * <code>
	  * 
	  * </code>
	  */
	public static final String insertLiteral = "with-sequences.insertLiteral";

	/**
	  *Constant "insertLongLiteral" used to reference prepared statement  with-sequences.insertLongLiteral
	  *
	  * <code>
	  * 
	  * </code>
	  */
	public static final String insertLongLiteral = "with-sequences.insertLongLiteral";

	/**
	  *Constant "getNodeID" used to reference prepared statement  with-sequences.getNodeID
	  *
	  * <code>
	  * 
	  * </code>
	  */
	public static final String getNodeID = "with-sequences.getNodeID";



	
	/**
	 * Runs the insertNode prepared statement.
	  * <code>
	 * 
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
	 *@param sequenceName template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long insertNode (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, String nodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {			
			ps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(insertNode, new String[] {nodeTableName, sequenceName},connection); int argc = 1;
			if(value == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertNode",stmtProvider.getSqlString(insertNode) ,""+ "value="+((value!=null)?value.toString():"null"),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null") + "," +"sequenceName="+((sequenceName!=null)?sequenceName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertNode]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertNode prepared statement
	 */
	public static class BatchInsertNode extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertNode prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param nodeTableName template parameter
	 *@param sequenceName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertNode(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String nodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertNode,new String[] {nodeTableName, sequenceName});
		}
		
		/**
		 * Sets the input parameters for the insertNode prepared statement.
		 *
	 *@param value template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String value) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(value == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
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
	 * Runs the insertLongNode prepared statement.
	  * <code>
	 * 
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param hash template parameter
	 *@param value template parameter
	 *
	 *@param nodeTableName template parameter
	 *@param sequenceName template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long insertLongNode (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long hash, String value, String nodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {			
			ps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(insertLongNode, new String[] {nodeTableName, sequenceName},connection); int argc = 1;
			ps.setLong(argc++, hash);
			if(value == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLongNode",stmtProvider.getSqlString(insertLongNode) ,""+ "hash="+(hash) + "," +"value="+((value!=null)?value.toString():"null"),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null") + "," +"sequenceName="+((sequenceName!=null)?sequenceName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertLongNode]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertLongNode prepared statement
	 */
	public static class BatchInsertLongNode extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertLongNode prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param nodeTableName template parameter
	 *@param sequenceName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLongNode(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String nodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLongNode,new String[] {nodeTableName, sequenceName});
		}
		
		/**
		 * Sets the input parameters for the insertLongNode prepared statement.
		 *
	 *@param hash template parameter
	 *@param value template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long hash, String value) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, hash);
			if(value == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
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
	 * Runs the insertLiteral prepared statement.
	  * <code>
	 * 
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
	 *@param sequenceName template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long insertLiteral (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, Long modifier_id, String literalNodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {			
			ps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(insertLiteral, new String[] {literalNodeTableName, sequenceName},connection); int argc = 1;
			if(value == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, value);
			}
			if(modifier_id == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, modifier_id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLiteral",stmtProvider.getSqlString(insertLiteral) ,""+ "value="+((value!=null)?value.toString():"null") + "," +"modifier_id="+((modifier_id!=null)?modifier_id.toString():"null"),""+ "literalNodeTableName="+((literalNodeTableName!=null)?literalNodeTableName.toString():"null") + "," +"sequenceName="+((sequenceName!=null)?sequenceName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertLiteral]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertLiteral prepared statement
	 */
	public static class BatchInsertLiteral extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertLiteral prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param literalNodeTableName template parameter
	 *@param sequenceName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLiteral(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String literalNodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLiteral,new String[] {literalNodeTableName, sequenceName});
		}
		
		/**
		 * Sets the input parameters for the insertLiteral prepared statement.
		 *
	 *@param value template parameter
	 *@param modifier_id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String value, Long modifier_id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(value == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, value);
			}
			if(modifier_id == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, modifier_id);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertLongLiteral prepared statement.
	  * <code>
	 * 
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
	 *@param literalNodeTableName template parameter
	 *@param sequenceName template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long insertLongLiteral (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, long hash, Long modifier_id, String literalNodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {			
			ps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(insertLongLiteral, new String[] {literalNodeTableName, sequenceName},connection); int argc = 1;
			if(value == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, hash);
			if(modifier_id == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, modifier_id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLongLiteral",stmtProvider.getSqlString(insertLongLiteral) ,""+ "value="+((value!=null)?value.toString():"null") + "," +"hash="+(hash) + "," +"modifier_id="+((modifier_id!=null)?modifier_id.toString():"null"),""+ "literalNodeTableName="+((literalNodeTableName!=null)?literalNodeTableName.toString():"null") + "," +"sequenceName="+((sequenceName!=null)?sequenceName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertLongLiteral]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertLongLiteral prepared statement
	 */
	public static class BatchInsertLongLiteral extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertLongLiteral prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param literalNodeTableName template parameter
	 *@param sequenceName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLongLiteral(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String literalNodeTableName, String sequenceName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLongLiteral,new String[] {literalNodeTableName, sequenceName});
		}
		
		/**
		 * Sets the input parameters for the insertLongLiteral prepared statement.
		 *
	 *@param value template parameter
	 *@param hash template parameter
	 *@param modifier_id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String value, long hash, Long modifier_id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(value == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, hash);
			if(modifier_id == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, modifier_id);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the getNodeID prepared statement.
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
	 *@param sequenceName template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long getNodeID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sequenceName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getNodeID, new String[] {sequenceName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getNodeID",stmtProvider.getSqlString(getNodeID) ,"",""+ "sequenceName="+((sequenceName!=null)?sequenceName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getNodeID]"+endtimer);
		}
	}


}