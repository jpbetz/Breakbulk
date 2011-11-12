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
 *	NoSequencesSQL provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class NoSequencesSQL {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(NoSequencesSQL.class);
	static final long CUTOFF=5;

	/**
	  *Constant "insertCommonValue" used to reference prepared statement  no-sequences.insertCommonValue
	  *
	  * <code>
	  *          INSERT INTO {0} (VALUE) VALUES(?)     
	  * </code>
	  */
	public static final String insertCommonValue = "no-sequences.insertCommonValue";

	/**
	  *Constant "insertNode" used to reference prepared statement  no-sequences.insertNode
	  *
	  * <code>
	  *  		INSERT INTO {0} (ID, VALUE,REF) VALUES(?, ?,0) 	
	  * </code>
	  */
	public static final String insertNode = "no-sequences.insertNode";

	/**
	  *Constant "insertLongNode" used to reference prepared statement  no-sequences.insertLongNode
	  *
	  * <code>
	  *  		INSERT INTO {0} (ID, HASH, VALUE,REF) VALUES(?, ?, ?,0) 	
	  * </code>
	  */
	public static final String insertLongNode = "no-sequences.insertLongNode";

	/**
	  *Constant "insertNodeWithIdentity" used to reference prepared statement  no-sequences.insertNodeWithIdentity
	  *
	  * <code>
	  *  		INSERT INTO {0} (VALUE,REF) VALUES( ?,0) 	
	  * </code>
	  */
	public static final String insertNodeWithIdentity = "no-sequences.insertNodeWithIdentity";

	/**
	  *Constant "insertLongNodeWithIdentity" used to reference prepared statement  no-sequences.insertLongNodeWithIdentity
	  *
	  * <code>
	  *  		INSERT INTO {0} ( HASH, VALUE,REF) VALUES(?, ?,0) 	
	  * </code>
	  */
	public static final String insertLongNodeWithIdentity = "no-sequences.insertLongNodeWithIdentity";

	/**
	  *Constant "insertLiteral" used to reference prepared statement  no-sequences.insertLiteral
	  *
	  * <code>
	  *  		INSERT INTO {0} (ID, VALUE, MODIFIER_ID,REF) VALUES(?, ?, ?,0) 	
	  * </code>
	  */
	public static final String insertLiteral = "no-sequences.insertLiteral";

	/**
	  *Constant "insertLongLiteral" used to reference prepared statement  no-sequences.insertLongLiteral
	  *
	  * <code>
	  *  		INSERT INTO {0} (ID, HASH, VALUE, MODIFIER_ID,REF) VALUES(?, ?, ?, ?,0) 	
	  * </code>
	  */
	public static final String insertLongLiteral = "no-sequences.insertLongLiteral";

	/**
	  *Constant "insertLiteralWithIdentity" used to reference prepared statement  no-sequences.insertLiteralWithIdentity
	  *
	  * <code>
	  *  		INSERT INTO {0} (VALUE, MODIFIER_ID,REF) VALUES( ?, ?,0) 	
	  * </code>
	  */
	public static final String insertLiteralWithIdentity = "no-sequences.insertLiteralWithIdentity";

	/**
	  *Constant "insertLongLiteralWithIdentity" used to reference prepared statement  no-sequences.insertLongLiteralWithIdentity
	  *
	  * <code>
	  *  		INSERT INTO {0} ( HASH, VALUE, MODIFIER_ID,REF) VALUES( ?, ?, ?,0) 	
	  * </code>
	  */
	public static final String insertLongLiteralWithIdentity = "no-sequences.insertLongLiteralWithIdentity";

	/**
	  *Constant "selectNodeID" used to reference prepared statement  no-sequences.selectNodeID
	  *
	  * <code>
	  *  		SELECT ID FROM {0} 	
	  * </code>
	  */
	public static final String selectNodeID = "no-sequences.selectNodeID";

	/**
	  *Constant "updateNodeID" used to reference prepared statement  no-sequences.updateNodeID
	  *
	  * <code>
	  *  		UPDATE {0} SET ID = ? 	
	  * </code>
	  */
	public static final String updateNodeID = "no-sequences.updateNodeID";



	
	/**
	 * Runs the insertCommonValue prepared statement.
	  * <code>
	 *          INSERT INTO {0} (VALUE) VALUES(?)     
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
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long insertCommonValue (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {			
			ps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(insertCommonValue, new String[] {nodeTableName},connection); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertCommonValue");
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertCommonValue",stmtProvider.getSqlString(insertCommonValue) ,""+ "value="+((value!=null)?value.toString():"null"),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
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
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertCommonValue(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertCommonValue,new String[] {nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the insertCommonValue prepared statement.
		 *
	 *@param value template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String value) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
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
	 * Runs the insertNode prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (ID, VALUE,REF) VALUES(?, ?,0) 	
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
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertNode (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String value, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertNode, new String[] {nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, id);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertNode");
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertNode",stmtProvider.getSqlString(insertNode) ,""+ "id="+(id) + "," +"value="+((value!=null)?value.toString():"null"),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
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
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertNode(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertNode,new String[] {nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the insertNode prepared statement.
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
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertNode");
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
	 *  		INSERT INTO {0} (ID, HASH, VALUE,REF) VALUES(?, ?, ?,0) 	
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
	 *@param nodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertLongNode (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, long hash, String value, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertLongNode, new String[] {nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, hash);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLongNode");
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLongNode",stmtProvider.getSqlString(insertLongNode) ,""+ "id="+(id) + "," +"hash="+(hash) + "," +"value="+((value!=null)?value.toString():"null"),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
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
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLongNode(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLongNode,new String[] {nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the insertLongNode prepared statement.
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
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLongNode");
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
	 * Runs the insertNodeWithIdentity prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (VALUE,REF) VALUES( ?,0) 	
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
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long insertNodeWithIdentity (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {			
			ps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(insertNodeWithIdentity, new String[] {nodeTableName},connection); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertNodeWithIdentity");
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertNodeWithIdentity",stmtProvider.getSqlString(insertNodeWithIdentity) ,""+ "value="+((value!=null)?value.toString():"null"),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertNodeWithIdentity]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertNodeWithIdentity prepared statement
	 */
	public static class BatchInsertNodeWithIdentity extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertNodeWithIdentity prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertNodeWithIdentity(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertNodeWithIdentity,new String[] {nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the insertNodeWithIdentity prepared statement.
		 *
	 *@param value template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String value) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertNodeWithIdentity");
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
	 * Runs the insertLongNodeWithIdentity prepared statement.
	  * <code>
	 *  		INSERT INTO {0} ( HASH, VALUE,REF) VALUES(?, ?,0) 	
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
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long insertLongNodeWithIdentity (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long hash, String value, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {			
			ps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(insertLongNodeWithIdentity, new String[] {nodeTableName},connection); int argc = 1;
			ps.setLong(argc++, hash);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLongNodeWithIdentity");
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLongNodeWithIdentity",stmtProvider.getSqlString(insertLongNodeWithIdentity) ,""+ "hash="+(hash) + "," +"value="+((value!=null)?value.toString():"null"),""+ "nodeTableName="+((nodeTableName!=null)?nodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertLongNodeWithIdentity]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertLongNodeWithIdentity prepared statement
	 */
	public static class BatchInsertLongNodeWithIdentity extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertLongNodeWithIdentity prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param nodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLongNodeWithIdentity(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String nodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLongNodeWithIdentity,new String[] {nodeTableName});
		}
		
		/**
		 * Sets the input parameters for the insertLongNodeWithIdentity prepared statement.
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
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLongNodeWithIdentity");
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
	 *  		INSERT INTO {0} (ID, VALUE, MODIFIER_ID,REF) VALUES(?, ?, ?,0) 	
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
	 *@param literalNodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertLiteral (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String value, long modifier_id, String literalNodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertLiteral, new String[] {literalNodeTableName},connection); int argc = 1;
			ps.setLong(argc++, id);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLiteral");
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLiteral",stmtProvider.getSqlString(insertLiteral) ,""+ "id="+(id) + "," +"value="+((value!=null)?value.toString():"null") + "," +"modifier_id="+(modifier_id),""+ "literalNodeTableName="+((literalNodeTableName!=null)?literalNodeTableName.toString():"null"));
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
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLiteral(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String literalNodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLiteral,new String[] {literalNodeTableName});
		}
		
		/**
		 * Sets the input parameters for the insertLiteral prepared statement.
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
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLiteral");
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
	 * Runs the insertLongLiteral prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (ID, HASH, VALUE, MODIFIER_ID,REF) VALUES(?, ?, ?, ?,0) 	
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
	 *@param modifier_id template parameter
	 *
	 *@param longLiteralNodeTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertLongLiteral (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, long hash, String value, long modifier_id, String longLiteralNodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertLongLiteral, new String[] {longLiteralNodeTableName},connection); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, hash);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLongLiteral");
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLongLiteral",stmtProvider.getSqlString(insertLongLiteral) ,""+ "id="+(id) + "," +"hash="+(hash) + "," +"value="+((value!=null)?value.toString():"null") + "," +"modifier_id="+(modifier_id),""+ "longLiteralNodeTableName="+((longLiteralNodeTableName!=null)?longLiteralNodeTableName.toString():"null"));
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
	 *@param longLiteralNodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLongLiteral(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String longLiteralNodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLongLiteral,new String[] {longLiteralNodeTableName});
		}
		
		/**
		 * Sets the input parameters for the insertLongLiteral prepared statement.
		 *
	 *@param id template parameter
	 *@param hash template parameter
	 *@param value template parameter
	 *@param modifier_id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, long hash, String value, long modifier_id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, hash);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLongLiteral");
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
	 * Runs the insertLiteralWithIdentity prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (VALUE, MODIFIER_ID,REF) VALUES( ?, ?,0) 	
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
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long insertLiteralWithIdentity (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String value, long modifier_id, String literalNodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {			
			ps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(insertLiteralWithIdentity, new String[] {literalNodeTableName},connection); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLiteralWithIdentity");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, modifier_id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLiteralWithIdentity",stmtProvider.getSqlString(insertLiteralWithIdentity) ,""+ "value="+((value!=null)?value.toString():"null") + "," +"modifier_id="+(modifier_id),""+ "literalNodeTableName="+((literalNodeTableName!=null)?literalNodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertLiteralWithIdentity]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertLiteralWithIdentity prepared statement
	 */
	public static class BatchInsertLiteralWithIdentity extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertLiteralWithIdentity prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param literalNodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLiteralWithIdentity(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String literalNodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLiteralWithIdentity,new String[] {literalNodeTableName});
		}
		
		/**
		 * Sets the input parameters for the insertLiteralWithIdentity prepared statement.
		 *
	 *@param value template parameter
	 *@param modifier_id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String value, long modifier_id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLiteralWithIdentity");
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
	 * Runs the insertLongLiteralWithIdentity prepared statement.
	  * <code>
	 *  		INSERT INTO {0} ( HASH, VALUE, MODIFIER_ID,REF) VALUES( ?, ?, ?,0) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param hash template parameter
	 *@param value template parameter
	 *@param modifier_id template parameter
	 *
	 *@param longLiteralNodeTableName template parameter
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long insertLongLiteralWithIdentity (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long hash, String value, long modifier_id, String longLiteralNodeTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {			
			ps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(insertLongLiteralWithIdentity, new String[] {longLiteralNodeTableName},connection); int argc = 1;
			ps.setLong(argc++, hash);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLongLiteralWithIdentity");
			} else {
				ps.setString(argc++, value);
			}
			ps.setLong(argc++, modifier_id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertLongLiteralWithIdentity",stmtProvider.getSqlString(insertLongLiteralWithIdentity) ,""+ "hash="+(hash) + "," +"value="+((value!=null)?value.toString():"null") + "," +"modifier_id="+(modifier_id),""+ "longLiteralNodeTableName="+((longLiteralNodeTableName!=null)?longLiteralNodeTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertLongLiteralWithIdentity]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertLongLiteralWithIdentity prepared statement
	 */
	public static class BatchInsertLongLiteralWithIdentity extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertLongLiteralWithIdentity prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param longLiteralNodeTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertLongLiteralWithIdentity(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String longLiteralNodeTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertLongLiteralWithIdentity,new String[] {longLiteralNodeTableName});
		}
		
		/**
		 * Sets the input parameters for the insertLongLiteralWithIdentity prepared statement.
		 *
	 *@param hash template parameter
	 *@param value template parameter
	 *@param modifier_id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long hash, String value, long modifier_id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, hash);
			if(value == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"value","insertLongLiteralWithIdentity");
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
	 * Runs the selectNodeID prepared statement.
	  * <code>
	 *  		SELECT ID FROM {0} 	
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
	public static Long selectNodeID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sequenceName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNodeID, new String[] {sequenceName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNodeID",stmtProvider.getSqlString(selectNodeID) ,"",""+ "sequenceName="+((sequenceName!=null)?sequenceName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNodeID]"+endtimer);
		}
	}




	
	/**
	 * Runs the updateNodeID prepared statement.
	  * <code>
	 *  		UPDATE {0} SET ID = ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@param sequenceName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void updateNodeID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String sequenceName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateNodeID, new String[] {sequenceName},connection); int argc = 1;
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateNodeID",stmtProvider.getSqlString(updateNodeID) ,""+ "id="+(id),""+ "sequenceName="+((sequenceName!=null)?sequenceName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateNodeID]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateNodeID prepared statement
	 */
	public static class BatchUpdateNodeID extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateNodeID prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sequenceName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateNodeID(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sequenceName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateNodeID,new String[] {sequenceName});
		}
		
		/**
		 * Sets the input parameters for the updateNodeID prepared statement.
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


}