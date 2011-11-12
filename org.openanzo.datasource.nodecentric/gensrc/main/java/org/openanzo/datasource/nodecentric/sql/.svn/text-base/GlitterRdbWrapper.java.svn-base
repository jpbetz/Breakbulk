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
 *	GlitterRdbWrapper provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class GlitterRdbWrapper {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(GlitterRdbWrapper.class);
	static final long CUTOFF=5;

	/**
	  *Constant "insertGraphIfValid" used to reference prepared statement  Glitter.insertGraphIfValid
	  *
	  * <code>
	  *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2} S 		WHERE S.METADATA = 1 		  AND S.SUBJECT = {4} 		  AND S.PREDICATE = {5} 		  AND S.OBJECT IN ({3}) 		  AND S.COMMITTED<=0 		
	  * </code>
	  */
	public static final String insertGraphIfValid = "Glitter.insertGraphIfValid";

	/**
	  *Constant "insertGraphSysAdmin" used to reference prepared statement  Glitter.insertGraphSysAdmin
	  *
	  * <code>
	  *  	 		INSERT INTO {0}{1} (ID) VALUES(?) 		
	  * </code>
	  */
	public static final String insertGraphSysAdmin = "Glitter.insertGraphSysAdmin";

	/**
	  *Constant "insertQueryDataset" used to reference prepared statement  Glitter.insertQueryDataset
	  *
	  * <code>
	  *  	 		INSERT INTO QUERY_GRAPHS (ID,DSID) VALUES(?,?) 		
	  * </code>
	  */
	public static final String insertQueryDataset = "Glitter.insertQueryDataset";

	/**
	  *Constant "selectQueryDatasets" used to reference prepared statement  Glitter.selectQueryDatasets
	  *
	  * <code>
	  *             SELECT ID,DSID FROM QUERY_GRAPHS ORDER BY DSID         
	  * </code>
	  */
	public static final String selectQueryDatasets = "Glitter.selectQueryDatasets";

	/**
	  *Constant "insertGraphsFromQueryDataset" used to reference prepared statement  Glitter.insertGraphsFromQueryDataset
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID) SELECT ID FROM QUERY_GRAPHS WHERE DSID=? 	
	  * </code>
	  */
	public static final String insertGraphsFromQueryDataset = "Glitter.insertGraphsFromQueryDataset";

	/**
	  *Constant "purgeQueryDataset" used to reference prepared statement  Glitter.purgeQueryDataset
	  *
	  * <code>
	  *  		DELETE FROM QUERY_GRAPHS WHERE DSID=? 	
	  * </code>
	  */
	public static final String purgeQueryDataset = "Glitter.purgeQueryDataset";

	/**
	  *Constant "insertAllValidGraphs" used to reference prepared statement  Glitter.insertAllValidGraphs
	  *
	  * <code>
	  *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2} S 		WHERE S.METADATA = 1 		  AND S.PREDICATE = {4} 		  AND S.OBJECT IN ({3}) 		  AND S.SUBJECT NOT IN ({5},{6},{7},{8}) 		  AND S.COMMITTED<=0 		
	  * </code>
	  */
	public static final String insertAllValidGraphs = "Glitter.insertAllValidGraphs";

	/**
	  *Constant "insertAllValidNamedGraphs" used to reference prepared statement  Glitter.insertAllValidNamedGraphs
	  *
	  * <code>
	  *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2} S 		WHERE S.METADATA = 1 		  AND S.PREDICATE = {4} 		  AND S.OBJECT IN ({3}) 		  AND S.SUBJECT != S.NAMEDGRAPHID 		  AND S.SUBJECT NOT IN ({5},{6}) 		  AND S.COMMITTED<=0 		
	  * </code>
	  */
	public static final String insertAllValidNamedGraphs = "Glitter.insertAllValidNamedGraphs";

	/**
	  *Constant "insertAllValidMetadataGraphs" used to reference prepared statement  Glitter.insertAllValidMetadataGraphs
	  *
	  * <code>
	  *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2} S 		WHERE S.METADATA = 1 		  AND S.PREDICATE = {4} 		  AND S.OBJECT IN ({3}) 		  AND S.SUBJECT = S.NAMEDGRAPHID 		  AND S.SUBJECT NOT IN ({5},{6}) 		  AND S.COMMITTED<=0 		
	  * </code>
	  */
	public static final String insertAllValidMetadataGraphs = "Glitter.insertAllValidMetadataGraphs";

	/**
	  *Constant "insertValidDatasetGraphs" used to reference prepared statement  Glitter.insertValidDatasetGraphs
	  *
	  * <code>
	  *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT DS.OBJECT FROM {2} S, {2} DS 		WHERE DS.NAMEDGRAPHID = {4} 		  AND DS.SUBJECT = {5}  		  AND DS.PREDICATE = {6} 		  AND DS.COMMITTED<=0 		  AND DS.METADATA=0 		  AND S.METADATA = 1 		  AND S.SUBJECT = DS.OBJECT 		  AND S.PREDICATE = {7} 		  AND S.OBJECT IN ({3}) 		  AND S.COMMITTED<=0 		
	  * </code>
	  */
	public static final String insertValidDatasetGraphs = "Glitter.insertValidDatasetGraphs";

	/**
	  *Constant "insertValidDatasetGraphsSysadmin" used to reference prepared statement  Glitter.insertValidDatasetGraphsSysadmin
	  *
	  * <code>
	  *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT DS.OBJECT FROM {2} DS 		WHERE DS.NAMEDGRAPHID = ? 		  AND DS.SUBJECT = ?  		  AND DS.PREDICATE = ?		 		  AND DS.COMMITTED<=0 		  AND DS.METADATA=0   		
	  * </code>
	  */
	public static final String insertValidDatasetGraphsSysadmin = "Glitter.insertValidDatasetGraphsSysadmin";

	/**
	  *Constant "copyDistinctDatasetIds" used to reference prepared statement  Glitter.copyDistinctDatasetIds
	  *
	  * <code>
	  *  		INSERT INTO {0}{2} SELECT DISTINCT ID FROM {0}{1} 	
	  * </code>
	  */
	public static final String copyDistinctDatasetIds = "Glitter.copyDistinctDatasetIds";

	/**
	  *Constant "insertTempDatasetGraph" used to reference prepared statement  Glitter.insertTempDatasetGraph
	  *
	  * <code>
	  *  	    INSERT INTO {0}TEMPGRAPHS VALUES (?) 	
	  * </code>
	  */
	public static final String insertTempDatasetGraph = "Glitter.insertTempDatasetGraph";

	/**
	  *Constant "insertAllNamedGraphs" used to reference prepared statement  Glitter.insertAllNamedGraphs
	  *
	  * <code>
	  *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT NG.ID FROM NAMEDGRAPHS NG WHERE (COMMITTED=0 AND HEND IS NULL) OR (COMMITTED<0 AND HEND IS NOT NULL) 		UNION 		SELECT DISTINCT NG.ID FROM NAMEDGRAPHS_NR NG WHERE COMMITTED<=0 		
	  * </code>
	  */
	public static final String insertAllNamedGraphs = "Glitter.insertAllNamedGraphs";

	/**
	  *Constant "insertAllMetadataGraphs" used to reference prepared statement  Glitter.insertAllMetadataGraphs
	  *
	  * <code>
	  *  	 		INSERT INTO {0}{1} (ID) 		SELECT DISTINCT NG.METAID FROM NAMEDGRAPHS NG WHERE (COMMITTED=0 AND HEND IS NULL) OR (COMMITTED<0 AND HEND IS NOT NULL) 		UNION 		SELECT DISTINCT NG.METAID FROM NAMEDGRAPHS_NR NG WHERE COMMITTED<=0 		
	  * </code>
	  */
	public static final String insertAllMetadataGraphs = "Glitter.insertAllMetadataGraphs";

	/**
	  *Constant "countRows" used to reference prepared statement  Glitter.countRows
	  *
	  * <code>
	  *  		SELECT COUNT(1) FROM {0}{1} 	
	  * </code>
	  */
	public static final String countRows = "Glitter.countRows";

	/**
	  *Constant "containsRevisionedGraph" used to reference prepared statement  Glitter.containsRevisionedGraph
	  *
	  * <code>
	  *  	 		SELECT COUNT(1) FROM {0}{1} TG,NAMEDGRAPHS NG WHERE TG.ID = ? and (TG.ID=NG.METAID OR TG.ID=NG.ID) AND ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0)) 		
	  * </code>
	  */
	public static final String containsRevisionedGraph = "Glitter.containsRevisionedGraph";

	/**
	  *Constant "containsNonRevisionedGraph" used to reference prepared statement  Glitter.containsNonRevisionedGraph
	  *
	  * <code>
	  *  	 		SELECT COUNT(1) FROM {0}{1} TG,NAMEDGRAPHS_NR NG WHERE TG.ID = ? and (TG.ID=NG.METAID OR TG.ID=NG.ID) AND COMMITTED <=0 		
	  * </code>
	  */
	public static final String containsNonRevisionedGraph = "Glitter.containsNonRevisionedGraph";

	/**
	  *Constant "datasetPartContainsGraph" used to reference prepared statement  Glitter.datasetPartContainsGraph
	  *
	  * <code>
	  *  		SELECT COUNT(1) FROM {0}{1} WHERE ID = ? 	
	  * </code>
	  */
	public static final String datasetPartContainsGraph = "Glitter.datasetPartContainsGraph";

	/**
	  *Constant "selectNamedGraphs" used to reference prepared statement  Glitter.selectNamedGraphs
	  *
	  * <code>
	  *   		SELECT {1}{0}.ID FROM {1}{0} WHERE {1}{0}.ID IN  		(SELECT NG.ID FROM NAMEDGRAPHS NG ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0))) 		
	  * </code>
	  */
	public static final String selectNamedGraphs = "Glitter.selectNamedGraphs";

	/**
	  *Constant "selectMetadataGraphs" used to reference prepared statement  Glitter.selectMetadataGraphs
	  *
	  * <code>
	  *   		SELECT {1}{0}.ID FROM {1}{0} WHERE {1}{0}.ID IN  		(SELECT NG.METAID FROM NAMEDGRAPHS NG ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0))) 		
	  * </code>
	  */
	public static final String selectMetadataGraphs = "Glitter.selectMetadataGraphs";

	/**
	  *Constant "countValidRevisionedGraphs" used to reference prepared statement  Glitter.countValidRevisionedGraphs
	  *
	  * <code>
	  *   		SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS(SELECT {1}{0}.ID FROM {1}{0},NAMEDGRAPHS NG WHERE (NG.ID ={1}{0}.ID OR NG.METAID={1}{0}.ID) AND ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0))) 		
	  * </code>
	  */
	public static final String countValidRevisionedGraphs = "Glitter.countValidRevisionedGraphs";

	/**
	  *Constant "countValidNonRevisionedGraphs" used to reference prepared statement  Glitter.countValidNonRevisionedGraphs
	  *
	  * <code>
	  *   		SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS (SELECT {1}{0}.ID FROM {1}{0},NAMEDGRAPHS_NR NG WHERE (NG.ID ={1}{0}.ID OR NG.METAID={1}{0}.ID) AND NG.COMMITTED<=0) 		
	  * </code>
	  */
	public static final String countValidNonRevisionedGraphs = "Glitter.countValidNonRevisionedGraphs";

	/**
	  *Constant "countValidRevisionedGraphsInSet" used to reference prepared statement  Glitter.countValidRevisionedGraphsInSet
	  *
	  * <code>
	  *   	       SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS(	 	           SELECT NG.ID FROM QUERY_GRAPHS,NAMEDGRAPHS NG WHERE QUERY_GRAPHS.DSID=? AND (NG.ID =QUERY_GRAPHS.ID OR NG.METAID=QUERY_GRAPHS.ID) AND ((NG.HEND IS NULL AND NG.COMMITTED=0) OR(NG.HEND IS NOT NULL AND NG.COMMITTED <0))             ) 		
	  * </code>
	  */
	public static final String countValidRevisionedGraphsInSet = "Glitter.countValidRevisionedGraphsInSet";

	/**
	  *Constant "countValidNonRevisionedGraphsInSet" used to reference prepared statement  Glitter.countValidNonRevisionedGraphsInSet
	  *
	  * <code>
	  *   		SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS(	 	       SELECT NG.ID FROM QUERY_GRAPHS,NAMEDGRAPHS_NR NG WHERE QUERY_GRAPHS.DSID=? AND (NG.ID =QUERY_GRAPHS.ID OR NG.METAID=QUERY_GRAPHS.ID) AND NG.COMMITTED <=0         ) 		
	  * </code>
	  */
	public static final String countValidNonRevisionedGraphsInSet = "Glitter.countValidNonRevisionedGraphsInSet";

	/**
	  *Constant "selectUntimelyGraphs" used to reference prepared statement  Glitter.selectUntimelyGraphs
	  *
	  * <code>
	  *  		SELECT TMP1.ID FROM {0}{1} TMP1 LEFT JOIN 		(SELECT NG.ID 		FROM NAMEDGRAPHS NG, {0}{2} TMP2 		WHERE 			NG.ID = TMP2.ID AND 			? >= NG.HSTART AND 			(NG.HEND IS NULL OR ? < NG.HEND) 		)AS TMP2 ON TMP1.ID=TMP2.ID WHERE TMP2.ID IS NULL 	
	  * </code>
	  */
	public static final String selectUntimelyGraphs = "Glitter.selectUntimelyGraphs";

	/**
	  *Constant "selectUntimelyMetadataGraphs" used to reference prepared statement  Glitter.selectUntimelyMetadataGraphs
	  *
	  * <code>
	  *  		SELECT TMP1.ID FROM {0}{1} TMP1 LEFT JOIN 		(SELECT DISTINCT NG.METAID 		FROM NAMEDGRAPHS NG, {0}{2} TMP2 		WHERE 			NG.METAID = TMP2.ID AND 			? >= NG.HSTART AND 			(NG.HEND IS NULL OR ? < NG.HEND) 		)AS TMP2 ON TMP1.ID=TMP2.METAID WHERE TMP2.METAID IS NULL 	
	  * </code>
	  */
	public static final String selectUntimelyMetadataGraphs = "Glitter.selectUntimelyMetadataGraphs";

	/**
	  *Constant "selectGraphs" used to reference prepared statement  Glitter.selectGraphs
	  *
	  * <code>
	  *  		SELECT TG.ID AS GRAPH			    		FROM {0}{1} TG 	
	  * </code>
	  */
	public static final String selectGraphs = "Glitter.selectGraphs";

	/**
	  *Constant "insertIdToTempTable" used to reference prepared statement  Glitter.insertIdToTempTable
	  *
	  * <code>
	  *  		INSERT INTO {0}{1} (ID) VALUES(?) 	
	  * </code>
	  */
	public static final String insertIdToTempTable = "Glitter.insertIdToTempTable";



	
	/**
	 * Runs the insertGraphIfValid prepared statement.
	  * <code>
	 *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2} S 		WHERE S.METADATA = 1 		  AND S.SUBJECT = {4} 		  AND S.PREDICATE = {5} 		  AND S.OBJECT IN ({3}) 		  AND S.COMMITTED<=0 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@param roleSql template parameter
	 *@param graphId template parameter
	 *@param canBeReadById template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertGraphIfValid (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String insertTable, String statementsTable, String roleSql, String graphId, String canBeReadById) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.Statement stmt = null;
		//long startTimer=System.currentTimeMillis();
		try {
			String sql= stmtProvider.getSQL(insertGraphIfValid, new String[] {sessionPrefix, insertTable, statementsTable, roleSql, graphId, canBeReadById});
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
			
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertGraphIfValid",stmtProvider.getSqlString(insertGraphIfValid) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"statementsTable="+((statementsTable!=null)?statementsTable.toString():"null") + "," +"roleSql="+((roleSql!=null)?roleSql.toString():"null") + "," +"graphId="+((graphId!=null)?graphId.toString():"null") + "," +"canBeReadById="+((canBeReadById!=null)?canBeReadById.toString():"null"));
			
		} finally {
			
			if (stmt != null) {
				try { 
					stmt.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing statement",sqle);
				}
			}
			
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertGraphIfValid]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertGraphIfValid prepared statement
	 */
	public static class BatchInsertGraphIfValid extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertGraphIfValid prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@param roleSql template parameter
	 *@param graphId template parameter
	 *@param canBeReadById template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertGraphIfValid(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String statementsTable, String roleSql, String graphId, String canBeReadById) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertGraphIfValid,new String[] {sessionPrefix, insertTable, statementsTable, roleSql, graphId, canBeReadById});
		}
		
		/**
		 * Sets the input parameters for the insertGraphIfValid prepared statement.
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
	 * Runs the insertGraphSysAdmin prepared statement.
	  * <code>
	 *  	 		INSERT INTO {0}{1} (ID) VALUES(?) 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param graphId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertGraphSysAdmin (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long graphId, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertGraphSysAdmin, new String[] {sessionPrefix, insertTable},connection); int argc = 1;
			ps.setLong(argc++, graphId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertGraphSysAdmin",stmtProvider.getSqlString(insertGraphSysAdmin) ,""+ "graphId="+(graphId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertGraphSysAdmin]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertGraphSysAdmin prepared statement
	 */
	public static class BatchInsertGraphSysAdmin extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertGraphSysAdmin prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertGraphSysAdmin(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertGraphSysAdmin,new String[] {sessionPrefix, insertTable});
		}
		
		/**
		 * Sets the input parameters for the insertGraphSysAdmin prepared statement.
		 *
	 *@param graphId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long graphId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, graphId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertQueryDataset prepared statement.
	  * <code>
	 *  	 		INSERT INTO QUERY_GRAPHS (ID,DSID) VALUES(?,?) 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param graphId template parameter
	 *@param datasetId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertQueryDataset (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long graphId, long datasetId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertQueryDataset, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, graphId);
			ps.setLong(argc++, datasetId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertQueryDataset",stmtProvider.getSqlString(insertQueryDataset) ,""+ "graphId="+(graphId) + "," +"datasetId="+(datasetId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertQueryDataset]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertQueryDataset prepared statement
	 */
	public static class BatchInsertQueryDataset extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertQueryDataset prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertQueryDataset(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertQueryDataset,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the insertQueryDataset prepared statement.
		 *
	 *@param graphId template parameter
	 *@param datasetId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long graphId, long datasetId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, graphId);
			ps.setLong(argc++, datasetId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectQueryDatasets prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectQueryDatasetsResult> transformSelectQueryDatasets = new org.openanzo.jdbc.utils.Transformer<SelectQueryDatasetsResult>(){
		public SelectQueryDatasetsResult transform(java.sql.ResultSet rs) {

			
				SelectQueryDatasetsResult result = new SelectQueryDatasetsResult();
				try {
				result.graphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:graphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.datasetId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:datasetId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectQueryDatasets prepared statement.
	  * <code>
	 *             SELECT ID,DSID FROM QUERY_GRAPHS ORDER BY DSID         
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectQueryDatasetsResult> selectQueryDatasets (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectQueryDatasets, new String[] {},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectQueryDatasetsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectQueryDatasetsResult>(rs, ps, stmtProvider, transformSelectQueryDatasets);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectQueryDatasets",stmtProvider.getSqlString(selectQueryDatasets) ,"","");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectQueryDatasets]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectQueryDatasetsResult
	 */
	public static class SelectQueryDatasetsResult {
			/**Value for the "graphId" result value*/
			private long graphId;
			/**Value for the "datasetId" result value*/
			private long datasetId;

		/**
		  *Get GraphId value
		  *@return GraphId value
		  */
			public long getGraphId() {
				return this.graphId;
			}

		/**
		  *Get DatasetId value
		  *@return DatasetId value
		  */
			public long getDatasetId() {
				return this.datasetId;
			}

	}



	
	/**
	 * Runs the insertGraphsFromQueryDataset prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{1} (ID) SELECT ID FROM QUERY_GRAPHS WHERE DSID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param dsId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertGraphsFromQueryDataset (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long dsId, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertGraphsFromQueryDataset, new String[] {sessionPrefix, insertTable},connection); int argc = 1;
			ps.setLong(argc++, dsId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertGraphsFromQueryDataset",stmtProvider.getSqlString(insertGraphsFromQueryDataset) ,""+ "dsId="+(dsId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertGraphsFromQueryDataset]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertGraphsFromQueryDataset prepared statement
	 */
	public static class BatchInsertGraphsFromQueryDataset extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertGraphsFromQueryDataset prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertGraphsFromQueryDataset(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertGraphsFromQueryDataset,new String[] {sessionPrefix, insertTable});
		}
		
		/**
		 * Sets the input parameters for the insertGraphsFromQueryDataset prepared statement.
		 *
	 *@param dsId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long dsId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, dsId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeQueryDataset prepared statement.
	  * <code>
	 *  		DELETE FROM QUERY_GRAPHS WHERE DSID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param dsId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeQueryDataset (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long dsId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeQueryDataset, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, dsId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeQueryDataset",stmtProvider.getSqlString(purgeQueryDataset) ,""+ "dsId="+(dsId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeQueryDataset]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeQueryDataset prepared statement
	 */
	public static class BatchPurgeQueryDataset extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeQueryDataset prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeQueryDataset(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeQueryDataset,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the purgeQueryDataset prepared statement.
		 *
	 *@param dsId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long dsId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, dsId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertAllValidGraphs prepared statement.
	  * <code>
	 *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2} S 		WHERE S.METADATA = 1 		  AND S.PREDICATE = {4} 		  AND S.OBJECT IN ({3}) 		  AND S.SUBJECT NOT IN ({5},{6},{7},{8}) 		  AND S.COMMITTED<=0 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@param roleSql template parameter
	 *@param canBeReadById template parameter
	 *@param ngDatasetId template parameter
	 *@param ngDatasetMetadataId template parameter
	 *@param mgDatasetId template parameter
	 *@param mgDatasetMetadataId template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllValidGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String insertTable, String statementsTable, String roleSql, String canBeReadById, String ngDatasetId, String ngDatasetMetadataId, String mgDatasetId, String mgDatasetMetadataId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.Statement stmt = null;
		//long startTimer=System.currentTimeMillis();
		try {
			String sql= stmtProvider.getSQL(insertAllValidGraphs, new String[] {sessionPrefix, insertTable, statementsTable, roleSql, canBeReadById, ngDatasetId, ngDatasetMetadataId, mgDatasetId, mgDatasetMetadataId});
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
			
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllValidGraphs",stmtProvider.getSqlString(insertAllValidGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"statementsTable="+((statementsTable!=null)?statementsTable.toString():"null") + "," +"roleSql="+((roleSql!=null)?roleSql.toString():"null") + "," +"canBeReadById="+((canBeReadById!=null)?canBeReadById.toString():"null") + "," +"ngDatasetId="+((ngDatasetId!=null)?ngDatasetId.toString():"null") + "," +"ngDatasetMetadataId="+((ngDatasetMetadataId!=null)?ngDatasetMetadataId.toString():"null") + "," +"mgDatasetId="+((mgDatasetId!=null)?mgDatasetId.toString():"null") + "," +"mgDatasetMetadataId="+((mgDatasetMetadataId!=null)?mgDatasetMetadataId.toString():"null"));
			
		} finally {
			
			if (stmt != null) {
				try { 
					stmt.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing statement",sqle);
				}
			}
			
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllValidGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllValidGraphs prepared statement
	 */
	public static class BatchInsertAllValidGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllValidGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@param roleSql template parameter
	 *@param canBeReadById template parameter
	 *@param ngDatasetId template parameter
	 *@param ngDatasetMetadataId template parameter
	 *@param mgDatasetId template parameter
	 *@param mgDatasetMetadataId template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllValidGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String statementsTable, String roleSql, String canBeReadById, String ngDatasetId, String ngDatasetMetadataId, String mgDatasetId, String mgDatasetMetadataId) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllValidGraphs,new String[] {sessionPrefix, insertTable, statementsTable, roleSql, canBeReadById, ngDatasetId, ngDatasetMetadataId, mgDatasetId, mgDatasetMetadataId});
		}
		
		/**
		 * Sets the input parameters for the insertAllValidGraphs prepared statement.
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
	 * Runs the insertAllValidNamedGraphs prepared statement.
	  * <code>
	 *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2} S 		WHERE S.METADATA = 1 		  AND S.PREDICATE = {4} 		  AND S.OBJECT IN ({3}) 		  AND S.SUBJECT != S.NAMEDGRAPHID 		  AND S.SUBJECT NOT IN ({5},{6}) 		  AND S.COMMITTED<=0 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@param roleSql template parameter
	 *@param canBeReadById template parameter
	 *@param ngDatasetId template parameter
	 *@param mgDatasetId template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllValidNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String insertTable, String statementsTable, String roleSql, String canBeReadById, String ngDatasetId, String mgDatasetId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.Statement stmt = null;
		//long startTimer=System.currentTimeMillis();
		try {
			String sql= stmtProvider.getSQL(insertAllValidNamedGraphs, new String[] {sessionPrefix, insertTable, statementsTable, roleSql, canBeReadById, ngDatasetId, mgDatasetId});
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
			
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllValidNamedGraphs",stmtProvider.getSqlString(insertAllValidNamedGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"statementsTable="+((statementsTable!=null)?statementsTable.toString():"null") + "," +"roleSql="+((roleSql!=null)?roleSql.toString():"null") + "," +"canBeReadById="+((canBeReadById!=null)?canBeReadById.toString():"null") + "," +"ngDatasetId="+((ngDatasetId!=null)?ngDatasetId.toString():"null") + "," +"mgDatasetId="+((mgDatasetId!=null)?mgDatasetId.toString():"null"));
			
		} finally {
			
			if (stmt != null) {
				try { 
					stmt.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing statement",sqle);
				}
			}
			
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllValidNamedGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllValidNamedGraphs prepared statement
	 */
	public static class BatchInsertAllValidNamedGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllValidNamedGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@param roleSql template parameter
	 *@param canBeReadById template parameter
	 *@param ngDatasetId template parameter
	 *@param mgDatasetId template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllValidNamedGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String statementsTable, String roleSql, String canBeReadById, String ngDatasetId, String mgDatasetId) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllValidNamedGraphs,new String[] {sessionPrefix, insertTable, statementsTable, roleSql, canBeReadById, ngDatasetId, mgDatasetId});
		}
		
		/**
		 * Sets the input parameters for the insertAllValidNamedGraphs prepared statement.
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
	 * Runs the insertAllValidMetadataGraphs prepared statement.
	  * <code>
	 *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT S.SUBJECT FROM {2} S 		WHERE S.METADATA = 1 		  AND S.PREDICATE = {4} 		  AND S.OBJECT IN ({3}) 		  AND S.SUBJECT = S.NAMEDGRAPHID 		  AND S.SUBJECT NOT IN ({5},{6}) 		  AND S.COMMITTED<=0 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@param roleSql template parameter
	 *@param canBeReadById template parameter
	 *@param ngDatasetMetadataId template parameter
	 *@param mgDatasetMetadataId template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllValidMetadataGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String insertTable, String statementsTable, String roleSql, String canBeReadById, String ngDatasetMetadataId, String mgDatasetMetadataId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.Statement stmt = null;
		//long startTimer=System.currentTimeMillis();
		try {
			String sql= stmtProvider.getSQL(insertAllValidMetadataGraphs, new String[] {sessionPrefix, insertTable, statementsTable, roleSql, canBeReadById, ngDatasetMetadataId, mgDatasetMetadataId});
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
			
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllValidMetadataGraphs",stmtProvider.getSqlString(insertAllValidMetadataGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"statementsTable="+((statementsTable!=null)?statementsTable.toString():"null") + "," +"roleSql="+((roleSql!=null)?roleSql.toString():"null") + "," +"canBeReadById="+((canBeReadById!=null)?canBeReadById.toString():"null") + "," +"ngDatasetMetadataId="+((ngDatasetMetadataId!=null)?ngDatasetMetadataId.toString():"null") + "," +"mgDatasetMetadataId="+((mgDatasetMetadataId!=null)?mgDatasetMetadataId.toString():"null"));
			
		} finally {
			
			if (stmt != null) {
				try { 
					stmt.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing statement",sqle);
				}
			}
			
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllValidMetadataGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllValidMetadataGraphs prepared statement
	 */
	public static class BatchInsertAllValidMetadataGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllValidMetadataGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@param roleSql template parameter
	 *@param canBeReadById template parameter
	 *@param ngDatasetMetadataId template parameter
	 *@param mgDatasetMetadataId template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllValidMetadataGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String statementsTable, String roleSql, String canBeReadById, String ngDatasetMetadataId, String mgDatasetMetadataId) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllValidMetadataGraphs,new String[] {sessionPrefix, insertTable, statementsTable, roleSql, canBeReadById, ngDatasetMetadataId, mgDatasetMetadataId});
		}
		
		/**
		 * Sets the input parameters for the insertAllValidMetadataGraphs prepared statement.
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
	 * Runs the insertValidDatasetGraphs prepared statement.
	  * <code>
	 *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT DS.OBJECT FROM {2} S, {2} DS 		WHERE DS.NAMEDGRAPHID = {4} 		  AND DS.SUBJECT = {5}  		  AND DS.PREDICATE = {6} 		  AND DS.COMMITTED<=0 		  AND DS.METADATA=0 		  AND S.METADATA = 1 		  AND S.SUBJECT = DS.OBJECT 		  AND S.PREDICATE = {7} 		  AND S.OBJECT IN ({3}) 		  AND S.COMMITTED<=0 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@param roleSql template parameter
	 *@param datasetId template parameter
	 *@param datasetIdRepeated template parameter
	 *@param datasetGraphPropertyId template parameter
	 *@param canBeReadById template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertValidDatasetGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String insertTable, String statementsTable, String roleSql, String datasetId, String datasetIdRepeated, String datasetGraphPropertyId, String canBeReadById) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.Statement stmt = null;
		//long startTimer=System.currentTimeMillis();
		try {
			String sql= stmtProvider.getSQL(insertValidDatasetGraphs, new String[] {sessionPrefix, insertTable, statementsTable, roleSql, datasetId, datasetIdRepeated, datasetGraphPropertyId, canBeReadById});
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
			
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertValidDatasetGraphs",stmtProvider.getSqlString(insertValidDatasetGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"statementsTable="+((statementsTable!=null)?statementsTable.toString():"null") + "," +"roleSql="+((roleSql!=null)?roleSql.toString():"null") + "," +"datasetId="+((datasetId!=null)?datasetId.toString():"null") + "," +"datasetIdRepeated="+((datasetIdRepeated!=null)?datasetIdRepeated.toString():"null") + "," +"datasetGraphPropertyId="+((datasetGraphPropertyId!=null)?datasetGraphPropertyId.toString():"null") + "," +"canBeReadById="+((canBeReadById!=null)?canBeReadById.toString():"null"));
			
		} finally {
			
			if (stmt != null) {
				try { 
					stmt.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing statement",sqle);
				}
			}
			
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertValidDatasetGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertValidDatasetGraphs prepared statement
	 */
	public static class BatchInsertValidDatasetGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertValidDatasetGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@param roleSql template parameter
	 *@param datasetId template parameter
	 *@param datasetIdRepeated template parameter
	 *@param datasetGraphPropertyId template parameter
	 *@param canBeReadById template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertValidDatasetGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String statementsTable, String roleSql, String datasetId, String datasetIdRepeated, String datasetGraphPropertyId, String canBeReadById) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertValidDatasetGraphs,new String[] {sessionPrefix, insertTable, statementsTable, roleSql, datasetId, datasetIdRepeated, datasetGraphPropertyId, canBeReadById});
		}
		
		/**
		 * Sets the input parameters for the insertValidDatasetGraphs prepared statement.
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
	 * Runs the insertValidDatasetGraphsSysadmin prepared statement.
	  * <code>
	 *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT DS.OBJECT FROM {2} DS 		WHERE DS.NAMEDGRAPHID = ? 		  AND DS.SUBJECT = ?  		  AND DS.PREDICATE = ?		 		  AND DS.COMMITTED<=0 		  AND DS.METADATA=0   		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param datasetId template parameter
	 *@param datasetIdRepeated template parameter
	 *@param datasetGraphPropertyId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertValidDatasetGraphsSysadmin (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long datasetId, long datasetIdRepeated, long datasetGraphPropertyId, String sessionPrefix, String insertTable, String statementsTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertValidDatasetGraphsSysadmin, new String[] {sessionPrefix, insertTable, statementsTable},connection); int argc = 1;
			ps.setLong(argc++, datasetId);
			ps.setLong(argc++, datasetIdRepeated);
			ps.setLong(argc++, datasetGraphPropertyId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertValidDatasetGraphsSysadmin",stmtProvider.getSqlString(insertValidDatasetGraphsSysadmin) ,""+ "datasetId="+(datasetId) + "," +"datasetIdRepeated="+(datasetIdRepeated) + "," +"datasetGraphPropertyId="+(datasetGraphPropertyId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null") + "," +"statementsTable="+((statementsTable!=null)?statementsTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertValidDatasetGraphsSysadmin]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertValidDatasetGraphsSysadmin prepared statement
	 */
	public static class BatchInsertValidDatasetGraphsSysadmin extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertValidDatasetGraphsSysadmin prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@param statementsTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertValidDatasetGraphsSysadmin(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable, String statementsTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertValidDatasetGraphsSysadmin,new String[] {sessionPrefix, insertTable, statementsTable});
		}
		
		/**
		 * Sets the input parameters for the insertValidDatasetGraphsSysadmin prepared statement.
		 *
	 *@param datasetId template parameter
	 *@param datasetIdRepeated template parameter
	 *@param datasetGraphPropertyId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long datasetId, long datasetIdRepeated, long datasetGraphPropertyId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, datasetId);
			ps.setLong(argc++, datasetIdRepeated);
			ps.setLong(argc++, datasetGraphPropertyId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the copyDistinctDatasetIds prepared statement.
	  * <code>
	 *  		INSERT INTO {0}{2} SELECT DISTINCT ID FROM {0}{1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param sourceTable template parameter
	 *@param destinationTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int copyDistinctDatasetIds (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String sourceTable, String destinationTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(copyDistinctDatasetIds, new String[] {sessionPrefix, sourceTable, destinationTable},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"copyDistinctDatasetIds",stmtProvider.getSqlString(copyDistinctDatasetIds) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"sourceTable="+((sourceTable!=null)?sourceTable.toString():"null") + "," +"destinationTable="+((destinationTable!=null)?destinationTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[copyDistinctDatasetIds]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CopyDistinctDatasetIds prepared statement
	 */
	public static class BatchCopyDistinctDatasetIds extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CopyDistinctDatasetIds prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param sourceTable template parameter
	 *@param destinationTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCopyDistinctDatasetIds(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String sourceTable, String destinationTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,copyDistinctDatasetIds,new String[] {sessionPrefix, sourceTable, destinationTable});
		}
		
		/**
		 * Sets the input parameters for the copyDistinctDatasetIds prepared statement.
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
	 * Runs the insertTempDatasetGraph prepared statement.
	  * <code>
	 *  	    INSERT INTO {0}TEMPGRAPHS VALUES (?) 	
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
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertTempDatasetGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertTempDatasetGraph, new String[] {sessionPrefix},connection); int argc = 1;
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertTempDatasetGraph",stmtProvider.getSqlString(insertTempDatasetGraph) ,""+ "id="+(id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertTempDatasetGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertTempDatasetGraph prepared statement
	 */
	public static class BatchInsertTempDatasetGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertTempDatasetGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertTempDatasetGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertTempDatasetGraph,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the insertTempDatasetGraph prepared statement.
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
	 * Runs the insertAllNamedGraphs prepared statement.
	  * <code>
	 *  	 		INSERT INTO {0}{1} (ID)  		SELECT DISTINCT NG.ID FROM NAMEDGRAPHS NG WHERE (COMMITTED=0 AND HEND IS NULL) OR (COMMITTED<0 AND HEND IS NOT NULL) 		UNION 		SELECT DISTINCT NG.ID FROM NAMEDGRAPHS_NR NG WHERE COMMITTED<=0 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertAllNamedGraphs, new String[] {sessionPrefix, insertTable},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllNamedGraphs",stmtProvider.getSqlString(insertAllNamedGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllNamedGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllNamedGraphs prepared statement
	 */
	public static class BatchInsertAllNamedGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllNamedGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllNamedGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllNamedGraphs,new String[] {sessionPrefix, insertTable});
		}
		
		/**
		 * Sets the input parameters for the insertAllNamedGraphs prepared statement.
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
	 * Runs the insertAllMetadataGraphs prepared statement.
	  * <code>
	 *  	 		INSERT INTO {0}{1} (ID) 		SELECT DISTINCT NG.METAID FROM NAMEDGRAPHS NG WHERE (COMMITTED=0 AND HEND IS NULL) OR (COMMITTED<0 AND HEND IS NOT NULL) 		UNION 		SELECT DISTINCT NG.METAID FROM NAMEDGRAPHS_NR NG WHERE COMMITTED<=0 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertAllMetadataGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertAllMetadataGraphs, new String[] {sessionPrefix, insertTable},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertAllMetadataGraphs",stmtProvider.getSqlString(insertAllMetadataGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertAllMetadataGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertAllMetadataGraphs prepared statement
	 */
	public static class BatchInsertAllMetadataGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertAllMetadataGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertAllMetadataGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertAllMetadataGraphs,new String[] {sessionPrefix, insertTable});
		}
		
		/**
		 * Sets the input parameters for the insertAllMetadataGraphs prepared statement.
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
	 * Runs the countRows prepared statement.
	  * <code>
	 *  		SELECT COUNT(1) FROM {0}{1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int countRows (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countRows, new String[] {sessionPrefix, tableName},connection);
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
				int val = rs.getInt(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countRows",stmtProvider.getSqlString(countRows) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countRows]"+endtimer);
		}
	}




	
	/**
	 * Runs the containsRevisionedGraph prepared statement.
	  * <code>
	 *  	 		SELECT COUNT(1) FROM {0}{1} TG,NAMEDGRAPHS NG WHERE TG.ID = ? and (TG.ID=NG.METAID OR TG.ID=NG.ID) AND ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0)) 		
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
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int containsRevisionedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(containsRevisionedGraph, new String[] {sessionPrefix, tableName},connection); int argc = 1;
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
					return 0;				 
				int val = rs.getInt(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"containsRevisionedGraph",stmtProvider.getSqlString(containsRevisionedGraph) ,""+ "id="+(id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[containsRevisionedGraph]"+endtimer);
		}
	}




	
	/**
	 * Runs the containsNonRevisionedGraph prepared statement.
	  * <code>
	 *  	 		SELECT COUNT(1) FROM {0}{1} TG,NAMEDGRAPHS_NR NG WHERE TG.ID = ? and (TG.ID=NG.METAID OR TG.ID=NG.ID) AND COMMITTED <=0 		
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
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int containsNonRevisionedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(containsNonRevisionedGraph, new String[] {sessionPrefix, tableName},connection); int argc = 1;
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
					return 0;				 
				int val = rs.getInt(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"containsNonRevisionedGraph",stmtProvider.getSqlString(containsNonRevisionedGraph) ,""+ "id="+(id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[containsNonRevisionedGraph]"+endtimer);
		}
	}




	
	/**
	 * Runs the datasetPartContainsGraph prepared statement.
	  * <code>
	 *  		SELECT COUNT(1) FROM {0}{1} WHERE ID = ? 	
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
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int datasetPartContainsGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(datasetPartContainsGraph, new String[] {sessionPrefix, tableName},connection); int argc = 1;
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
					return 0;				 
				int val = rs.getInt(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"datasetPartContainsGraph",stmtProvider.getSqlString(datasetPartContainsGraph) ,""+ "id="+(id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[datasetPartContainsGraph]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectNamedGraphs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectNamedGraphs = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the selectNamedGraphs prepared statement.
	  * <code>
	 *   		SELECT {1}{0}.ID FROM {1}{0} WHERE {1}{0}.ID IN  		(SELECT NG.ID FROM NAMEDGRAPHS NG ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0))) 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *@param sessionPrefix template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphs, new String[] {tableName, sessionPrefix},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectNamedGraphs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphs",stmtProvider.getSqlString(selectNamedGraphs) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null") + "," +"sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphs]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectMetadataGraphs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectMetadataGraphs = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the selectMetadataGraphs prepared statement.
	  * <code>
	 *   		SELECT {1}{0}.ID FROM {1}{0} WHERE {1}{0}.ID IN  		(SELECT NG.METAID FROM NAMEDGRAPHS NG ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0))) 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *@param sessionPrefix template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectMetadataGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectMetadataGraphs, new String[] {tableName, sessionPrefix},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectMetadataGraphs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectMetadataGraphs",stmtProvider.getSqlString(selectMetadataGraphs) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null") + "," +"sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectMetadataGraphs]"+endtimer);
		}
	}




	
	/**
	 * Runs the countValidRevisionedGraphs prepared statement.
	  * <code>
	 *   		SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS(SELECT {1}{0}.ID FROM {1}{0},NAMEDGRAPHS NG WHERE (NG.ID ={1}{0}.ID OR NG.METAID={1}{0}.ID) AND ((NG.HEND IS NULL AND COMMITTED=0) OR(NG.HEND IS NOT NULL AND COMMITTED <0))) 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *@param sessionPrefix template parameter
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long countValidRevisionedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countValidRevisionedGraphs, new String[] {tableName, sessionPrefix},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countValidRevisionedGraphs",stmtProvider.getSqlString(countValidRevisionedGraphs) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null") + "," +"sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countValidRevisionedGraphs]"+endtimer);
		}
	}




	
	/**
	 * Runs the countValidNonRevisionedGraphs prepared statement.
	  * <code>
	 *   		SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS (SELECT {1}{0}.ID FROM {1}{0},NAMEDGRAPHS_NR NG WHERE (NG.ID ={1}{0}.ID OR NG.METAID={1}{0}.ID) AND NG.COMMITTED<=0) 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *@param sessionPrefix template parameter
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long countValidNonRevisionedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countValidNonRevisionedGraphs, new String[] {tableName, sessionPrefix},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countValidNonRevisionedGraphs",stmtProvider.getSqlString(countValidNonRevisionedGraphs) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null") + "," +"sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countValidNonRevisionedGraphs]"+endtimer);
		}
	}




	
	/**
	 * Runs the countValidRevisionedGraphsInSet prepared statement.
	  * <code>
	 *   	       SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS(	 	           SELECT NG.ID FROM QUERY_GRAPHS,NAMEDGRAPHS NG WHERE QUERY_GRAPHS.DSID=? AND (NG.ID =QUERY_GRAPHS.ID OR NG.METAID=QUERY_GRAPHS.ID) AND ((NG.HEND IS NULL AND NG.COMMITTED=0) OR(NG.HEND IS NOT NULL AND NG.COMMITTED <0))             ) 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param dsId template parameter
	 *
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long countValidRevisionedGraphsInSet (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, Long dsId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countValidRevisionedGraphsInSet, new String[] {},connection); int argc = 1;
			if(dsId == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, dsId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countValidRevisionedGraphsInSet",stmtProvider.getSqlString(countValidRevisionedGraphsInSet) ,""+ "dsId="+((dsId!=null)?dsId.toString():"null"),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countValidRevisionedGraphsInSet]"+endtimer);
		}
	}




	
	/**
	 * Runs the countValidNonRevisionedGraphsInSet prepared statement.
	  * <code>
	 *   		SELECT COUNT(1) FROM GLITTERUNIT WHERE EXISTS(	 	       SELECT NG.ID FROM QUERY_GRAPHS,NAMEDGRAPHS_NR NG WHERE QUERY_GRAPHS.DSID=? AND (NG.ID =QUERY_GRAPHS.ID OR NG.METAID=QUERY_GRAPHS.ID) AND NG.COMMITTED <=0         ) 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param dsId template parameter
	 *
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long countValidNonRevisionedGraphsInSet (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, Long dsId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countValidNonRevisionedGraphsInSet, new String[] {},connection); int argc = 1;
			if(dsId == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, dsId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countValidNonRevisionedGraphsInSet",stmtProvider.getSqlString(countValidNonRevisionedGraphsInSet) ,""+ "dsId="+((dsId!=null)?dsId.toString():"null"),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countValidNonRevisionedGraphsInSet]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectUntimelyGraphs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectUntimelyGraphs = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the selectUntimelyGraphs prepared statement.
	  * <code>
	 *  		SELECT TMP1.ID FROM {0}{1} TMP1 LEFT JOIN 		(SELECT NG.ID 		FROM NAMEDGRAPHS NG, {0}{2} TMP2 		WHERE 			NG.ID = TMP2.ID AND 			? >= NG.HSTART AND 			(NG.HEND IS NULL OR ? < NG.HEND) 		)AS TMP2 ON TMP1.ID=TMP2.ID WHERE TMP2.ID IS NULL 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param lastTransactionTime1 template parameter
	 *@param lastTransactionTime2 template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempgraph1 template parameter
	 *@param tempgraph2 template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectUntimelyGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, Long lastTransactionTime1, Long lastTransactionTime2, String sessionPrefix, String tempgraph1, String tempgraph2) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectUntimelyGraphs, new String[] {sessionPrefix, tempgraph1, tempgraph2},connection); int argc = 1;
			if(lastTransactionTime1 == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, lastTransactionTime1);
			}
			if(lastTransactionTime2 == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, lastTransactionTime2);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectUntimelyGraphs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectUntimelyGraphs",stmtProvider.getSqlString(selectUntimelyGraphs) ,""+ "lastTransactionTime1="+((lastTransactionTime1!=null)?lastTransactionTime1.toString():"null") + "," +"lastTransactionTime2="+((lastTransactionTime2!=null)?lastTransactionTime2.toString():"null"),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempgraph1="+((tempgraph1!=null)?tempgraph1.toString():"null") + "," +"tempgraph2="+((tempgraph2!=null)?tempgraph2.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectUntimelyGraphs]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectUntimelyMetadataGraphs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectUntimelyMetadataGraphs = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the selectUntimelyMetadataGraphs prepared statement.
	  * <code>
	 *  		SELECT TMP1.ID FROM {0}{1} TMP1 LEFT JOIN 		(SELECT DISTINCT NG.METAID 		FROM NAMEDGRAPHS NG, {0}{2} TMP2 		WHERE 			NG.METAID = TMP2.ID AND 			? >= NG.HSTART AND 			(NG.HEND IS NULL OR ? < NG.HEND) 		)AS TMP2 ON TMP1.ID=TMP2.METAID WHERE TMP2.METAID IS NULL 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param lastTransactionTime1 template parameter
	 *@param lastTransactionTime2 template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tempgraph1 template parameter
	 *@param tempgraph2 template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectUntimelyMetadataGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, Long lastTransactionTime1, Long lastTransactionTime2, String sessionPrefix, String tempgraph1, String tempgraph2) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectUntimelyMetadataGraphs, new String[] {sessionPrefix, tempgraph1, tempgraph2},connection); int argc = 1;
			if(lastTransactionTime1 == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, lastTransactionTime1);
			}
			if(lastTransactionTime2 == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, lastTransactionTime2);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectUntimelyMetadataGraphs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectUntimelyMetadataGraphs",stmtProvider.getSqlString(selectUntimelyMetadataGraphs) ,""+ "lastTransactionTime1="+((lastTransactionTime1!=null)?lastTransactionTime1.toString():"null") + "," +"lastTransactionTime2="+((lastTransactionTime2!=null)?lastTransactionTime2.toString():"null"),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempgraph1="+((tempgraph1!=null)?tempgraph1.toString():"null") + "," +"tempgraph2="+((tempgraph2!=null)?tempgraph2.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectUntimelyMetadataGraphs]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectGraphs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectGraphs = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the selectGraphs prepared statement.
	  * <code>
	 *  		SELECT TG.ID AS GRAPH			    		FROM {0}{1} TG 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tempTable template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tempTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectGraphs, new String[] {sessionPrefix, tempTable},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectGraphs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectGraphs",stmtProvider.getSqlString(selectGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tempTable="+((tempTable!=null)?tempTable.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectGraphs]"+endtimer);
		}
	}




	
	/**
	 * Runs the insertIdToTempTable prepared statement.
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
	 *@param insertTable template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertIdToTempTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertIdToTempTable, new String[] {sessionPrefix, insertTable},connection); int argc = 1;
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertIdToTempTable",stmtProvider.getSqlString(insertIdToTempTable) ,""+ "id="+(id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"insertTable="+((insertTable!=null)?insertTable.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertIdToTempTable]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertIdToTempTable prepared statement
	 */
	public static class BatchInsertIdToTempTable extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertIdToTempTable prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param insertTable template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertIdToTempTable(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String insertTable) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertIdToTempTable,new String[] {sessionPrefix, insertTable});
		}
		
		/**
		 * Sets the input parameters for the insertIdToTempTable prepared statement.
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