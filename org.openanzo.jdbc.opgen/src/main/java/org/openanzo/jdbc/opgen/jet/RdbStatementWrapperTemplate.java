package org.openanzo.jdbc.opgen.jet;

import java.util.*;
import org.openanzo.jdbc.opgen.RdbStatement;
import org.openanzo.jdbc.opgen.Result;
import org.openanzo.jdbc.opgen.RdbStatementSet;
import org.openanzo.jdbc.opgen.RdbStatement.Parameter;

/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Generated via javajet
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
@SuppressWarnings("all")
public class RdbStatementWrapperTemplate
{
  protected static String nl;
  public static synchronized RdbStatementWrapperTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    RdbStatementWrapperTemplate result = new RdbStatementWrapperTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2004, 2007-2009 IBM Corporation and Cambridge Semantics Incorporated." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " *" + NL + " * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " *" + NL + " * Contributors:" + NL + " *     IBM Corporation - initial API and implementation" + NL + " *\t   Cambridge Semantics Incorporated - Fork to Anzo" + NL + " *******************************************************************************/" + NL + "package ";
  protected final String TEXT_2 = ";" + NL + "// allow for all types that can be returned from a resultset" + NL + "" + NL + "/**" + NL + " *\t";
  protected final String TEXT_3 = " provides wrappers around SQL queries and transforms ResultSets into java objects" + NL + " *" + NL + " *\t@author Generated Source from org.openanzo.jdbc.utils.opgen.jet" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " {" + NL + "\tprivate static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(";
  protected final String TEXT_5 = ".class);" + NL + "\tstatic final long CUTOFF=5;";
  protected final String TEXT_6 = NL + NL + "\t/**" + NL + "\t  *Constant \"";
  protected final String TEXT_7 = "\" used to reference prepared statement  ";
  protected final String TEXT_8 = NL + "\t  *" + NL + "\t  * <code>" + NL + "\t  * ";
  protected final String TEXT_9 = NL + "\t  * </code>" + NL + "\t  */" + NL + "\tpublic static final String ";
  protected final String TEXT_10 = " = \"";
  protected final String TEXT_11 = "\";";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL + "\t/**" + NL + "\t * Runs the ";
  protected final String TEXT_15 = " prepared statement." + NL + "\t * <code>" + NL + "\t * ";
  protected final String TEXT_16 = NL + "\t * </code>" + NL + "\t *" + NL + "\t *@param stmtProvider" + NL + "\t *\t\t\tfactory and cache of PreparedStatments" + NL + "\t *@param connection" + NL + "\t * \t\t\tconnection to underlying database" + NL + "\t *@param params" + NL + "\t *\t\t\t";
  protected final String TEXT_17 = " input Interface" + NL + "\t *";
  protected final String TEXT_18 = NL + "\t *";
  protected final String TEXT_19 = "@return  ";
  protected final String TEXT_20 = " containing the results of the SQL operation";
  protected final String TEXT_21 = NL + "\t *";
  protected final String TEXT_22 = "@throws  ";
  protected final String TEXT_23 = "@throws java.sql.SQLException";
  protected final String TEXT_24 = NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_25 = "<";
  protected final String TEXT_26 = ">";
  protected final String TEXT_27 = " ";
  protected final String TEXT_28 = " (org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,java.sql.Connection connection, ";
  protected final String TEXT_29 = " params";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ") throws ";
  protected final String TEXT_32 = ",java.sql.SQLException";
  protected final String TEXT_33 = " {" + NL + "\t\t";
  protected final String TEXT_34 = "return ";
  protected final String TEXT_35 = " (" + NL + "\t\t\t\tstmtProvider,connection ";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = NL + "\t\t\t\tparams.get";
  protected final String TEXT_38 = "()";
  protected final String TEXT_39 = ",";
  protected final String TEXT_40 = NL + "\t\t\t\t";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = NL + "\t\t);" + NL + "\t}";
  protected final String TEXT_43 = NL;
  protected final String TEXT_44 = NL + "\t/**" + NL + "\t * Transformer that transforms the rows in the result set for the ";
  protected final String TEXT_45 = " prepared statement." + NL + "\t */" + NL + "\tstatic final org.openanzo.jdbc.utils.Transformer<";
  protected final String TEXT_46 = "> transform";
  protected final String TEXT_47 = " = new org.openanzo.jdbc.utils.Transformer<";
  protected final String TEXT_48 = ">(){";
  protected final String TEXT_49 = NL + "\t\tpublic ";
  protected final String TEXT_50 = " transform(java.sql.ResultSet rs) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_51 = " val = rs.get";
  protected final String TEXT_52 = "(1);" + NL + "\t\t\t\treturn val;" + NL + "\t\t\t} catch (java.sql.SQLException e) {" + NL + "\t\t\t\tlog.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,\"Error transforming result set value:";
  protected final String TEXT_53 = "\",e);" + NL + "\t\t\t\tthrow new org.apache.commons.collections.FunctorException(e);" + NL + "\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_54 = NL + "\t\tpublic ";
  protected final String TEXT_55 = " transform(java.sql.ResultSet rs) {" + NL + "" + NL + "\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_56 = " result = new ";
  protected final String TEXT_57 = "();";
  protected final String TEXT_58 = NL + "\t\t\t\ttry {" + NL + "\t\t\t\tresult.";
  protected final String TEXT_59 = "=rs.get";
  protected final String TEXT_60 = "(";
  protected final String TEXT_61 = ");" + NL + "\t\t\t\t} catch (java.sql.SQLException e) {" + NL + "\t\t\t\tlog.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,\"Error transforming result set param:";
  protected final String TEXT_62 = "\",e);" + NL + "\t\t\t\tthrow new org.apache.commons.collections.FunctorException(e);" + NL + "\t\t\t\t}";
  protected final String TEXT_63 = NL + "\t\t\t\treturn result;" + NL + "\t\t\t" + NL + "\t\t}";
  protected final String TEXT_64 = NL + NL + "\t};";
  protected final String TEXT_65 = NL + "\t/**" + NL + "\t * Runs the ";
  protected final String TEXT_66 = " prepared statement with the default transformer." + NL + "\t  * <code>" + NL + "\t * ";
  protected final String TEXT_67 = NL + "\t * </code>" + NL + "\t *" + NL + "\t *@param stmtProvider" + NL + "\t *\t\t\tfactory and cache of PreparedStatments" + NL + "\t *@param connection" + NL + "\t * \t\t\tconnection to underlying database" + NL + "\t *";
  protected final String TEXT_68 = NL + "\t *";
  protected final String TEXT_69 = NL + "\t *";
  protected final String TEXT_70 = "@return  ";
  protected final String TEXT_71 = NL + "\t *";
  protected final String TEXT_72 = "@throws  ";
  protected final String TEXT_73 = "@throws java.sql.SQLException";
  protected final String TEXT_74 = NL + "\t */" + NL + "\t public static ";
  protected final String TEXT_75 = "<";
  protected final String TEXT_76 = ">";
  protected final String TEXT_77 = " ";
  protected final String TEXT_78 = " (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = " result";
  protected final String TEXT_83 = ") throws ";
  protected final String TEXT_84 = ",java.sql.SQLException";
  protected final String TEXT_85 = " {" + NL + "\t\treturn ";
  protected final String TEXT_86 = " (stmtProvider,connection";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ", result";
  protected final String TEXT_90 = ", transform";
  protected final String TEXT_91 = ");" + NL + "\t}";
  protected final String TEXT_92 = NL + "\t" + NL + "\t/**" + NL + "\t * Runs the ";
  protected final String TEXT_93 = " prepared statement." + NL + "\t  * <code>" + NL + "\t * ";
  protected final String TEXT_94 = NL + "\t * </code>" + NL + "\t *" + NL + "\t *@param stmtProvider" + NL + "\t *\t\t\tfactory and cache of PreparedStatments" + NL + "\t *@param connection" + NL + "\t * \t\t\tconnection to underlying database" + NL + "\t *";
  protected final String TEXT_95 = NL + "\t *";
  protected final String TEXT_96 = NL + "\t *";
  protected final String TEXT_97 = "@return  ";
  protected final String TEXT_98 = NL + "\t *";
  protected final String TEXT_99 = "@throws  ";
  protected final String TEXT_100 = "@throws java.sql.SQLException";
  protected final String TEXT_101 = NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_102 = "<";
  protected final String TEXT_103 = ">";
  protected final String TEXT_104 = " ";
  protected final String TEXT_105 = " (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection";
  protected final String TEXT_106 = ", ";
  protected final String TEXT_107 = ", ";
  protected final String TEXT_108 = ") throws ";
  protected final String TEXT_109 = ",java.sql.SQLException";
  protected final String TEXT_110 = "{";
  protected final String TEXT_111 = NL + "\t\tjava.sql.PreparedStatement ps = null;" + NL + "\t\t//long startTimer=System.currentTimeMillis();" + NL + "\t\ttry {";
  protected final String TEXT_112 = "\t\t" + NL + "\t\t\tps = stmtProvider.getPreparedSQLStatement(";
  protected final String TEXT_113 = ", new String[] {";
  protected final String TEXT_114 = "},connection);";
  protected final String TEXT_115 = "\t\t\t" + NL + "\t\t\tps = stmtProvider.getPreparedSQLStatementWithGeneratedIDS(";
  protected final String TEXT_116 = ", new String[] {";
  protected final String TEXT_117 = "},connection);";
  protected final String TEXT_118 = " int argc = 1;";
  protected final String TEXT_119 = NL + "\t\t\tif(";
  protected final String TEXT_120 = " == null) {";
  protected final String TEXT_121 = NL + "\t\t\t\tthrow new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,\"";
  protected final String TEXT_122 = "\",\"";
  protected final String TEXT_123 = "\");";
  protected final String TEXT_124 = NL + "\t\t\t\tps.setNull(argc++, java.sql.Types.";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\t\t} else {" + NL + "\t\t\t\tps.set";
  protected final String TEXT_127 = "(argc++, ";
  protected final String TEXT_128 = ");" + NL + "\t\t\t}";
  protected final String TEXT_129 = NL + "\t\t\tps.set";
  protected final String TEXT_130 = "(argc++, ";
  protected final String TEXT_131 = ");";
  protected final String TEXT_132 = NL + "\t\t\ttry{\t\t\t" + NL + "\t\t\t\tps.execute();" + NL + "\t\t\t}catch(java.sql.SQLException sqle){" + NL + "\t\t\t\tif(sqle.getErrorCode()==1205){" + NL + "\t\t\t\t\tint retries=0;" + NL + "\t\t\t\t\twhile(retries<5){" + NL + "\t\t\t\t\t\ttry {" + NL + "                        \tThread.sleep(5000);" + NL + "                        }catch(InterruptedException ie) {" + NL + "                            throw sqle;" + NL + "                        }" + NL + "\t\t\t\t\t\ttry{\t\t\t" + NL + "\t\t\t\t\t\t\tps.execute();" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}catch(java.sql.SQLException sqleInner){" + NL + "\t\t\t\t\t\t\tif(sqleInner.getErrorCode()==1205){" + NL + "\t\t\t\t\t\t\t\tretries++;" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tthrow sqleInner;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(retries>=5){" + NL + "\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_133 = NL + "\t\t\tjava.sql.ResultSet rs = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\trs = ps.executeQuery();" + NL + "\t\t\t\t}catch(java.sql.SQLException sqle){" + NL + "\t\t\t\t\tif(sqle.getErrorCode()==1205){" + NL + "\t\t\t\t\t\tint retries=0;" + NL + "\t\t\t\t\t\twhile(retries<5){" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t                        \tThread.sleep(5000);" + NL + "\t                        }catch(InterruptedException ie) {" + NL + "\t                            throw sqle;" + NL + "\t                        }" + NL + "\t\t\t\t\t\t\ttry{\t\t\t" + NL + "\t\t\t\t\t\t\t\trs = ps.executeQuery();" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}catch(java.sql.SQLException sqleInner){" + NL + "\t\t\t\t\t\t\t\tif(sqleInner.getErrorCode()==1205){" + NL + "\t\t\t\t\t\t\t\t\tretries++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tthrow sqleInner;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(retries>=5){" + NL + "\t\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(!rs.next())";
  protected final String TEXT_134 = NL + "\t\t\t\t\treturn 0;";
  protected final String TEXT_135 = NL + "\t\t\t\t\treturn null;";
  protected final String TEXT_136 = "\t\t\t\t " + NL + "\t\t\t\t";
  protected final String TEXT_137 = " val = rs.get";
  protected final String TEXT_138 = "(1);" + NL + "\t\t\t\treturn val;" + NL + "\t\t\t} finally {" + NL + "\t\t\t\tif(rs != null) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\trs.close();" + NL + "\t\t\t\t\t} catch (java.sql.SQLException sqle) {" + NL + "\t\t\t\t\t\tif(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,\"Error closing result set\",sqle);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_139 = NL + "\t\t\t\tjava.sql.ResultSet rs=null;" + NL + "\t            try {" + NL + "\t\t\t\t\t if (ps.execute()) {" + NL + "\t                    rs = ps.getResultSet();" + NL + "\t                } else {" + NL + "\t                    rs = ps.getGeneratedKeys();" + NL + "\t                }" + NL + "\t                if (rs != null && rs.next()) {" + NL + "\t                    return rs.getLong(1);" + NL + "\t                } else {" + NL + "\t                    return null;" + NL + "\t                }" + NL + "\t            } finally {" + NL + "\t                if (rs != null) {" + NL + "\t                    try {" + NL + "\t                        rs.close();" + NL + "\t                    } catch (java.sql.SQLException sqle) {" + NL + "\t                    \tif(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,\"Error closing result set\",sqle);\t\t\t\t\t\t\t\t" + NL + "\t                    }" + NL + "\t                }" + NL + "\t            }";
  protected final String TEXT_140 = NL + "\t\t\t\tint counter = 0;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tcounter=ps.executeUpdate();" + NL + "\t\t\t\t}catch(java.sql.SQLException sqle){" + NL + "\t\t\t\t\tif(sqle.getErrorCode()==1205){" + NL + "\t\t\t\t\t\tint retries=0;" + NL + "\t\t\t\t\t\twhile(retries<5){" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t                        \tThread.sleep(5000);" + NL + "\t                        }catch(InterruptedException ie) {" + NL + "\t                            throw sqle;" + NL + "\t                        }" + NL + "\t\t\t\t\t\t\ttry{\t\t\t" + NL + "\t\t\t\t\t\t\t\tcounter=ps.executeUpdate();" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}catch(java.sql.SQLException sqleInner){" + NL + "\t\t\t\t\t\t\t\tif(sqleInner.getErrorCode()==1205){" + NL + "\t\t\t\t\t\t\t\t\tretries++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tthrow sqleInner;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(retries>=5){" + NL + "\t\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn counter;";
  protected final String TEXT_141 = NL + "\t\t\tjava.sql.ResultSet rs = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\trs = ps.executeQuery();" + NL + "\t\t\t\t}catch(java.sql.SQLException sqle){" + NL + "\t\t\t\t\tif(sqle.getErrorCode()==1205){" + NL + "\t\t\t\t\t\tint retries=0;" + NL + "\t\t\t\t\t\twhile(retries<5){" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t                        \tThread.sleep(5000);" + NL + "\t                        }catch(InterruptedException ie) {" + NL + "\t                            throw sqle;" + NL + "\t                        }" + NL + "\t\t\t\t\t\t\ttry{\t\t\t" + NL + "\t\t\t\t\t\t\t\trs = ps.executeQuery();" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}catch(java.sql.SQLException sqleInner){" + NL + "\t\t\t\t\t\t\t\tif(sqleInner.getErrorCode()==1205){" + NL + "\t\t\t\t\t\t\t\t\tretries++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tthrow sqleInner;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(retries>=5){" + NL + "\t\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(!rs.next()) return null;";
  protected final String TEXT_142 = NL + "\t\t";
  protected final String TEXT_143 = " result=new ";
  protected final String TEXT_144 = "();";
  protected final String TEXT_145 = NL + "\t\t\t\tresult.";
  protected final String TEXT_146 = "=rs.get";
  protected final String TEXT_147 = "(";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = NL + "\t\t\t\treturn result;" + NL + "\t\t\t} finally {" + NL + "\t\t\t\tif(rs != null) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\trs.close();" + NL + "\t\t\t\t\t} catch (java.sql.SQLException sqle) {" + NL + "\t\t\t\t\t\tif(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,\"Error closing result set\",sqle);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_150 = NL + "\t\t\tjava.sql.ResultSet rs = null;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\trs = ps.executeQuery();" + NL + "\t\t\t\t}catch(java.sql.SQLException sqle){" + NL + "\t\t\t\t\tif(sqle.getErrorCode()==1205){" + NL + "\t\t\t\t\t\tint retries=0;" + NL + "\t\t\t\t\t\twhile(retries<5){" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t                        \tThread.sleep(5000);" + NL + "\t                        }catch(InterruptedException ie) {" + NL + "\t                            throw sqle;" + NL + "\t                        }" + NL + "\t\t\t\t\t\t\ttry{\t\t\t" + NL + "\t\t\t\t\t\t\t\trs = ps.executeQuery();" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}catch(java.sql.SQLException sqleInner){" + NL + "\t\t\t\t\t\t\t\tif(sqleInner.getErrorCode()==1205){" + NL + "\t\t\t\t\t\t\t\t\tretries++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tthrow sqleInner;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(retries>=5){" + NL + "\t\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\torg.openanzo.jdbc.utils.ClosableIterator<";
  protected final String TEXT_151 = "> iter = new org.openanzo.jdbc.utils.ResultSetIterator<";
  protected final String TEXT_152 = ">(rs, ps, stmtProvider, transform";
  protected final String TEXT_153 = ");" + NL + "\t\t\treturn iter;";
  protected final String TEXT_154 = NL + NL + "\t\t} catch (java.sql.SQLException e) {";
  protected final String TEXT_155 = NL + "\t\t\tthrow e;";
  protected final String TEXT_156 = NL + "\t\t\tthrow new ";
  protected final String TEXT_157 = "(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,\"";
  protected final String TEXT_158 = "\",stmtProvider.getSqlString(";
  protected final String TEXT_159 = ") ,\"\"";
  protected final String TEXT_160 = "+ ";
  protected final String TEXT_161 = ",\"\"";
  protected final String TEXT_162 = "+ ";
  protected final String TEXT_163 = ");";
  protected final String TEXT_164 = NL + "\t\t} finally {";
  protected final String TEXT_165 = NL + "\t\t\tif (ps != null) {" + NL + "\t\t\t\ttry { " + NL + "\t\t\t\t\tps.close(); " + NL + "\t\t\t\t} catch (java.sql.SQLException sqle) {" + NL + "\t\t\t\t\tif(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,\"Error closing prepared statement\",sqle);" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_166 = NL + "\t\t\t//long endtimer=(System.currentTimeMillis()-startTimer);" + NL + "\t\t\t//if(endtimer>CUTOFF)System.out.println(\"[";
  protected final String TEXT_167 = "]\"+endtimer);" + NL + "\t\t}";
  protected final String TEXT_168 = NL + "\t\tjava.sql.Statement stmt = null;" + NL + "\t\t//long startTimer=System.currentTimeMillis();" + NL + "\t\ttry {" + NL + "\t\t\tString sql= stmtProvider.getSQL(";
  protected final String TEXT_169 = ", new String[] {";
  protected final String TEXT_170 = "});" + NL + "\t\t\tstmt=connection.createStatement();";
  protected final String TEXT_171 = NL + "\t\t\tstmt.executeUpdate(sql);";
  protected final String TEXT_172 = NL + "\t\t\tjava.sql.ResultSet rs = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\trs = stmt.executeQuery(sql);" + NL + "\t\t\t\t}catch(java.sql.SQLException sqle){" + NL + "\t\t\t\t\tif(sqle.getErrorCode()==1205){" + NL + "\t\t\t\t\t\tint retries=0;" + NL + "\t\t\t\t\t\twhile(retries<5){" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t                        \tThread.sleep(5000);" + NL + "\t                        }catch(InterruptedException ie) {" + NL + "\t                            throw sqle;" + NL + "\t                        }" + NL + "\t\t\t\t\t\t\ttry{\t\t\t" + NL + "\t\t\t\t\t\t\t\trs = stmt.executeQuery(sql);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}catch(java.sql.SQLException sqleInner){" + NL + "\t\t\t\t\t\t\t\tif(sqleInner.getErrorCode()==1205){" + NL + "\t\t\t\t\t\t\t\t\tretries++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tthrow sqleInner;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}\t" + NL + "\t\t\t\t\t\tif(retries>=5){" + NL + "\t\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(!rs.next()) return null;" + NL + "\t\t\t\t";
  protected final String TEXT_173 = " val = rs.get";
  protected final String TEXT_174 = "(1);" + NL + "\t\t\t\treturn val;" + NL + "\t\t\t} finally {" + NL + "\t\t\t\tif(rs != null) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\trs.close();" + NL + "\t\t\t\t\t} catch (java.sql.SQLException sqle) {" + NL + "\t\t\t\t\t\tif(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,\"Error closing result set\",sqle);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL;
  protected final String TEXT_175 = NL + "\t\t\t\tint counter = 0;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tcounter=stmt.executeUpdate(sql);" + NL + "\t\t\t\t}catch(java.sql.SQLException sqle){" + NL + "\t\t\t\t\tif(sqle.getErrorCode()==1205){" + NL + "\t\t\t\t\t\tint retries=0;" + NL + "\t\t\t\t\t\twhile(retries<5){" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t                        \tThread.sleep(5000);" + NL + "\t                        }catch(InterruptedException ie) {" + NL + "\t                            throw sqle;" + NL + "\t                        }" + NL + "\t\t\t\t\t\t\ttry{\t\t\t" + NL + "\t\t\t\t\t\t\t\tcounter=stmt.executeUpdate(sql);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}catch(java.sql.SQLException sqleInner){" + NL + "\t\t\t\t\t\t\t\tif(sqleInner.getErrorCode()==1205){" + NL + "\t\t\t\t\t\t\t\t\tretries++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tthrow sqleInner;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(retries>=5){" + NL + "\t\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn counter;";
  protected final String TEXT_176 = NL + "\t\t\tjava.sql.ResultSet rs = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\trs = stmt.executeQuery(sql);" + NL + "\t\t\t\t}catch(java.sql.SQLException sqle){" + NL + "\t\t\t\t\tif(sqle.getErrorCode()==1205){" + NL + "\t\t\t\t\t\tint retries=0;" + NL + "\t\t\t\t\t\twhile(retries<5){" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t                        \tThread.sleep(5000);" + NL + "\t                        }catch(InterruptedException ie) {" + NL + "\t                            throw sqle;" + NL + "\t                        }" + NL + "\t\t\t\t\t\t\ttry{\t\t\t" + NL + "\t\t\t\t\t\t\t\trs = stmt.executeQuery(sql);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}catch(java.sql.SQLException sqleInner){" + NL + "\t\t\t\t\t\t\t\tif(sqleInner.getErrorCode()==1205){" + NL + "\t\t\t\t\t\t\t\t\tretries++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tthrow sqleInner;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(retries>=5){" + NL + "\t\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(!rs.next()) return null;";
  protected final String TEXT_177 = NL + "\t\t\t\tresult.set";
  protected final String TEXT_178 = "(rs.get";
  protected final String TEXT_179 = "(";
  protected final String TEXT_180 = "));";
  protected final String TEXT_181 = NL + "\t\t\t\treturn result;" + NL + "\t\t\t} finally {" + NL + "\t\t\t\tif(rs != null) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\trs.close();" + NL + "\t\t\t\t\t} catch (java.sql.SQLException sqle) {" + NL + "\t\t\t\t\t\tif(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,\"Error closing result set\",sqle);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_182 = NL + "\t\t\tjava.sql.ResultSet rs = null;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\trs = ps.executeQuery();" + NL + "\t\t\t\t}catch(java.sql.SQLException sqle){" + NL + "\t\t\t\t\tif(sqle.getErrorCode()==1205){" + NL + "\t\t\t\t\t\tint retries=0;" + NL + "\t\t\t\t\t\twhile(retries<5){" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t                        \tThread.sleep(5000);" + NL + "\t                        }catch(InterruptedException ie) {" + NL + "\t                            throw sqle;" + NL + "\t                        }" + NL + "\t\t\t\t\t\t\ttry{\t\t\t" + NL + "\t\t\t\t\t\t\t\trs = ps.executeQuery();" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}catch(java.sql.SQLException sqleInner){" + NL + "\t\t\t\t\t\t\t\tif(sqleInner.getErrorCode()==1205){" + NL + "\t\t\t\t\t\t\t\t\tretries++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tthrow sqleInner;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(retries>=5){" + NL + "\t\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthrow sqle;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\torg.openanzo.jdbc.utils.ClosableIterator<";
  protected final String TEXT_183 = "> iter = new org.openanzo.jdbc.utils.ResultSetIterator<";
  protected final String TEXT_184 = ">(rs, ps, stmtProvider, transform);" + NL + "\t\t\treturn iter;";
  protected final String TEXT_185 = NL + NL + "\t\t} catch (java.sql.SQLException e) {" + NL + "\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\tthrow e;" + NL + "\t\t\t";
  protected final String TEXT_187 = NL + "\t\t\tthrow new ";
  protected final String TEXT_188 = "(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,\"";
  protected final String TEXT_189 = "\",stmtProvider.getSqlString(";
  protected final String TEXT_190 = ") ,\"\"";
  protected final String TEXT_191 = "+ ";
  protected final String TEXT_192 = ",\"\"";
  protected final String TEXT_193 = "+ ";
  protected final String TEXT_194 = ");" + NL + "\t\t\t";
  protected final String TEXT_195 = NL + "\t\t} finally {" + NL + "\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\tif (stmt != null) {" + NL + "\t\t\t\ttry { " + NL + "\t\t\t\t\tstmt.close(); " + NL + "\t\t\t\t} catch (java.sql.SQLException sqle) {" + NL + "\t\t\t\t\tif(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,\"Error closing statement\",sqle);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_197 = NL + "\t\t\t//long endtimer=(System.currentTimeMillis()-startTimer);" + NL + "\t\t\t//if(endtimer>CUTOFF)System.out.println(\"[";
  protected final String TEXT_198 = "]\"+endtimer);" + NL + "\t\t}";
  protected final String TEXT_199 = NL + "\t}";
  protected final String TEXT_200 = NL + "\t/**" + NL + "\t *Batch operation for adding parameters to the ";
  protected final String TEXT_201 = " prepared statement" + NL + "\t */" + NL + "\tpublic static class Batch";
  protected final String TEXT_202 = " extends org.openanzo.jdbc.utils.PreparedStatementExecutor {" + NL + "\t\t/**" + NL + "\t\t * Batch operation for adding parameters to the ";
  protected final String TEXT_203 = " prepared statement" + NL + "\t\t * @param connection Connection to execute " + NL + "\t\t * @param provider Prepared statement provider" + NL + "\t\t * ";
  protected final String TEXT_204 = NL + "\t\t * @throws org.openanzo.jdbc.utils.RdbException" + NL + "\t\t */" + NL + "\t\tpublic Batch";
  protected final String TEXT_205 = "(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider";
  protected final String TEXT_206 = ", ";
  protected final String TEXT_207 = ") throws org.openanzo.jdbc.utils.RdbException {" + NL + "\t\t\tsuper(connection,provider,";
  protected final String TEXT_208 = ",new String[] {";
  protected final String TEXT_209 = "});" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * Sets the input parameters for the ";
  protected final String TEXT_210 = " prepared statement." + NL + "\t\t *";
  protected final String TEXT_211 = NL + "\t\t *@throws org.openanzo.jdbc.utils.RdbException" + NL + "\t\t */" + NL + "\t\tpublic void addEntry (";
  protected final String TEXT_212 = ") throws org.openanzo.jdbc.utils.RdbException {" + NL + "\t \t\ttry{" + NL + "\t\t \t\tps.clearParameters();";
  protected final String TEXT_213 = " int argc = 1;";
  protected final String TEXT_214 = NL + "\t\t\tif(";
  protected final String TEXT_215 = " == null) {";
  protected final String TEXT_216 = NL + "\t\t\t\tthrow new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,\"";
  protected final String TEXT_217 = "\",\"";
  protected final String TEXT_218 = "\");";
  protected final String TEXT_219 = NL + "\t\t\t\tps.setNull(argc++, java.sql.Types.";
  protected final String TEXT_220 = ");";
  protected final String TEXT_221 = NL + "\t\t\t} else {" + NL + "\t\t\t\tps.set";
  protected final String TEXT_222 = "(argc++, ";
  protected final String TEXT_223 = ");" + NL + "\t\t\t}";
  protected final String TEXT_224 = NL + "\t\t\tps.set";
  protected final String TEXT_225 = "(argc++, ";
  protected final String TEXT_226 = ");";
  protected final String TEXT_227 = NL + "\t\t\t\tps.addBatch();" + NL + "\t\t\t}catch(java.sql.SQLException sqle){" + NL + "\t\t\t\tthrow new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_228 = NL + NL;
  protected final String TEXT_229 = NL + "\t" + NL + "\t/**" + NL + "\t *Default implementation of ";
  protected final String TEXT_230 = NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_231 = " {";
  protected final String TEXT_232 = NL + "\t\t\t/**Value for the \"";
  protected final String TEXT_233 = "\" result value*/" + NL + "\t\t\tprivate ";
  protected final String TEXT_234 = " ";
  protected final String TEXT_235 = ";";
  protected final String TEXT_236 = NL;
  protected final String TEXT_237 = NL + "\t\t/**" + NL + "\t\t  *Get ";
  protected final String TEXT_238 = " value" + NL + "\t\t  *@return ";
  protected final String TEXT_239 = " value" + NL + "\t\t  */" + NL + "\t\t\tpublic ";
  protected final String TEXT_240 = " get";
  protected final String TEXT_241 = "() {" + NL + "\t\t\t\treturn this.";
  protected final String TEXT_242 = ";" + NL + "\t\t\t}" + NL;
  protected final String TEXT_243 = NL + "\t}" + NL;
  protected final String TEXT_244 = NL + "}";

	/**
	* Generate source code
	* @param argument source for template
	* @return Return generated source
    */
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     RdbStatementSet.Context ctx = (RdbStatementSet.Context)argument; 
     List<RdbStatement> list = ctx.getDescriptorList().getList(); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(ctx.getPackageName() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ctx.getClassName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ctx.getClassName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ctx.getClassName() );
    stringBuffer.append(TEXT_5);
     for (RdbStatement ps : list) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ps.getQualifiedName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ps.getSql().replaceAll("\n", " "));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ps.getQualifiedName());
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
     for (RdbStatement ps : list) { 
     		List<Parameter> inputs = ps.getInputs(); 
     		List<Parameter> outputs = ps.getOutputs(); 
     		Result result = ps.getResults(); 
    		boolean prepare = ps.getPrepare(); 
    stringBuffer.append(TEXT_13);
     /*		if (ps.hasInputParamType()) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ps.getSql().replaceAll("\n", " "));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ps.getInputParamInterface());
    stringBuffer.append(TEXT_17);
    if(ps.hasTemplateParams()){
    stringBuffer.append(ps.getTemplateParamsJavadoc());
    }
    stringBuffer.append(TEXT_18);
    if(!ps.getReturnType().equals("void")){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(ps.getReturnType());
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
     if(!ctx.getRethrowSQLException()) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ctx.getRethrowExceptionName());
    }else{
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ps.getReturnType());
    if (result == Result.ITERATOR){ 
    stringBuffer.append(TEXT_25);
    if(outputs.size() == 1){
    stringBuffer.append(ps.getValueReturnType(true));
    }else{
    stringBuffer.append(ps.getResultsInterface());
    }
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ps.getInputParamInterface());
    stringBuffer.append(TEXT_29);
    if(ps.hasTemplateParams()){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ps.getTemplateParamSigniture());
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(ctx.getRethrowExceptionName());
     if(ctx.getRethrowSQLException()) {
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    if (ps.hasReturn()) {
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_35);
    if(inputs.size() > 0) { 
    stringBuffer.append(TEXT_36);
    }
     			for (Iterator<RdbStatement.Parameter> inIter = inputs.iterator(); inIter.hasNext();) {
              Parameter param = inIter.next(); 
    stringBuffer.append(TEXT_37);
    stringBuffer.append(param.getRdbProperty());
    stringBuffer.append(TEXT_38);
    if(inIter.hasNext()) {
    stringBuffer.append(TEXT_39);
     } 
     			} 
    stringBuffer.append(TEXT_40);
    if(ps.hasTemplateParams()) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ps.getTemplateParams());
    }
    stringBuffer.append(TEXT_42);
     } */
    stringBuffer.append(TEXT_43);
     if(result == Result.ITERATOR) { 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_45);
    if(outputs.size() == 1){
    stringBuffer.append(ps.getValueReturnType(true));
    }else{
    stringBuffer.append(ps.getResultsInterface());
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ps.capitalizedName());
    stringBuffer.append(TEXT_47);
    if(outputs.size() == 1){
    stringBuffer.append(ps.getValueReturnType(true));
    }else{
    stringBuffer.append(ps.getResultsInterface());
    }
    stringBuffer.append(TEXT_48);
     		if (outputs.size() == 1) { 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ps.getValueReturnType(true));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ps.getJavaType(true));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ps.getResultSetProperty());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ps.getResultSetProperty());
    stringBuffer.append(TEXT_53);
     		} else { 
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ps.getResultsInterface());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(ps.getResultsInterface());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ps.getResultsInterface());
    stringBuffer.append(TEXT_57);
    			int i = 1; 
     			for (Parameter param : outputs) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(param.getResultSetProperty());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(i++);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_62);
     			} 
    stringBuffer.append(TEXT_63);
     		} 
    stringBuffer.append(TEXT_64);
     } 
     /*if (result == Result.ITERATOR){ 
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ps.getSql().replaceAll("\n", " "));
    stringBuffer.append(TEXT_67);
    if(ps.hasInputParams()){
    stringBuffer.append(ps.getInputParamsJavadoc());
    }
    stringBuffer.append(TEXT_68);
    if(ps.hasTemplateParams()){
    stringBuffer.append(ps.getTemplateParamsJavadoc());
    }
    stringBuffer.append(TEXT_69);
    if(!ps.getReturnType().equals("void")){
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ps.getReturnType());
    }
    stringBuffer.append(TEXT_71);
     if(!ctx.getRethrowSQLException()) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(ctx.getRethrowExceptionName());
    }else{
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ps.getReturnType());
    if (result == Result.ITERATOR){ 
    stringBuffer.append(TEXT_75);
    if(outputs.size() == 1){
    stringBuffer.append(ps.getValueReturnType(true));
    }else{
    stringBuffer.append(ps.getResultsInterface());
    }
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_78);
    if(ps.hasInputParams()) { 
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ps.getInputParamSigniture());
    }
    if(ps.hasTemplateParams()){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ps.getTemplateParamSigniture());
    }
    if (result == Result.ROW){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ps.getResultsInterface());
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(ctx.getRethrowExceptionName());
     if(ctx.getRethrowSQLException()) {
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_86);
    if(ps.hasInputParams()) { 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(ps.getInputParams());
    }
    if(ps.hasTemplateParams()){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ps.getTemplateParams());
    }
    if (result == Result.ROW){
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(ps.capitalizedName());
    stringBuffer.append(TEXT_91);
     }*/
    stringBuffer.append(TEXT_92);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ps.getSql().replaceAll("\n", " "));
    stringBuffer.append(TEXT_94);
    if(ps.hasInputParams()){
    stringBuffer.append(ps.getInputParamsJavadoc());
    }
    stringBuffer.append(TEXT_95);
    if(ps.hasTemplateParams()){
    stringBuffer.append(ps.getTemplateParamsJavadoc());
    }
    stringBuffer.append(TEXT_96);
    if(!ps.getReturnType().equals("void")){
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ps.getReturnType());
    }
    stringBuffer.append(TEXT_98);
     if(!ctx.getRethrowSQLException()) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(ctx.getRethrowExceptionName());
    }else{
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ps.getReturnType());
    if (result == Result.ITERATOR){ 
    stringBuffer.append(TEXT_102);
    if(outputs.size() == 1){
    stringBuffer.append(ps.getValueReturnType(true));
    }else{
    stringBuffer.append(ps.getResultsInterface());
    }
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_105);
    if(ps.hasInputParams()) { 
    stringBuffer.append(TEXT_106);
    stringBuffer.append(ps.getInputParamSigniture());
    }
    if(ps.hasTemplateParams()){
    stringBuffer.append(TEXT_107);
    stringBuffer.append(ps.getTemplateParamSigniture());
    }
    stringBuffer.append(TEXT_108);
    stringBuffer.append(ctx.getRethrowExceptionName());
     if(ctx.getRethrowSQLException()) {
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    if(prepare){
    stringBuffer.append(TEXT_111);
    if (result != Result.IDENTITY) {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(ps.getTemplateParams());
    stringBuffer.append(TEXT_114);
    }else{
    stringBuffer.append(TEXT_115);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(ps.getTemplateParams());
    stringBuffer.append(TEXT_117);
    }
    if(ps.hasInputParams()){
    stringBuffer.append(TEXT_118);
    }
     for (Parameter param : inputs) { 
    if(!param.isPrimitive()){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_120);
    if(!param.canBeNull()){
    stringBuffer.append(TEXT_121);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_123);
    }else{
    stringBuffer.append(TEXT_124);
    stringBuffer.append(param.getJdbcType());
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    stringBuffer.append(param.getResultSetProperty());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_128);
    }else{
    stringBuffer.append(TEXT_129);
    stringBuffer.append(param.getResultSetProperty());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_131);
    }}
     if (result == Result.NONE) {
    stringBuffer.append(TEXT_132);
     } else if (result == Result.VALUE) {
    stringBuffer.append(TEXT_133);
    if(ps.isPrimitive()){
    stringBuffer.append(TEXT_134);
    }else{
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(ps.getJavaType(false));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(ps.getResultSetProperty());
    stringBuffer.append(TEXT_138);
     }else if (result == Result.IDENTITY) {
    stringBuffer.append(TEXT_139);
     }else if (result == Result.COUNTER) {
    stringBuffer.append(TEXT_140);
     }else if (result == Result.ROW) { 
    stringBuffer.append(TEXT_141);
    		int i = 1; 
    stringBuffer.append(TEXT_142);
    stringBuffer.append(ps.getResultsInterface());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(ps.getResultsInterface());
    stringBuffer.append(TEXT_144);
     		for (Parameter param : outputs) {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(param.getResultSetProperty());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(i++);
    stringBuffer.append(TEXT_148);
     		} 
    stringBuffer.append(TEXT_149);
     } else if (result == Result.ITERATOR){ 
    stringBuffer.append(TEXT_150);
    if(outputs.size() == 1){
    stringBuffer.append(ps.getValueReturnType(true));
    }else{
    stringBuffer.append(ps.getResultsInterface());
    }
    stringBuffer.append(TEXT_151);
    if(outputs.size() == 1){
    stringBuffer.append(ps.getValueReturnType(true));
    }else{
    stringBuffer.append(ps.getResultsInterface());
    }
    stringBuffer.append(TEXT_152);
    stringBuffer.append(ps.capitalizedName());
    stringBuffer.append(TEXT_153);
     } 
    stringBuffer.append(TEXT_154);
     if(ctx.getRethrowSQLException()) {
    stringBuffer.append(TEXT_155);
    }else{
    stringBuffer.append(TEXT_156);
    stringBuffer.append(ctx.getRethrowExceptionName());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_159);
    if(ps.hasInputParams()) { 
    stringBuffer.append(TEXT_160);
    stringBuffer.append(ps.getInputExceptionSignature());
    }
    stringBuffer.append(TEXT_161);
    if(ps.hasTemplateParams()){
    stringBuffer.append(TEXT_162);
    stringBuffer.append(ps.getTemplateExceptionSignature());
    }
    stringBuffer.append(TEXT_163);
    }
    stringBuffer.append(TEXT_164);
     if (result != Result.ITERATOR){ 
    stringBuffer.append(TEXT_165);
     } 
    stringBuffer.append(TEXT_166);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_167);
    }else{
    stringBuffer.append(TEXT_168);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(ps.getTemplateParams());
    stringBuffer.append(TEXT_170);
     if (result == Result.NONE) {
    stringBuffer.append(TEXT_171);
     } else if (result == Result.VALUE) {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(ps.getJavaType(false));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(ps.getResultSetProperty());
    stringBuffer.append(TEXT_174);
     }else if (result == Result.COUNTER) {
    stringBuffer.append(TEXT_175);
     }else if (result == Result.ROW) { 
    stringBuffer.append(TEXT_176);
    		int i = 1; 
     		for (Parameter param : outputs) {
    stringBuffer.append(TEXT_177);
    stringBuffer.append(param.getRdbProperty());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(param.getResultSetProperty());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(i++);
    stringBuffer.append(TEXT_180);
     		} 
    stringBuffer.append(TEXT_181);
     } else if (result == Result.ITERATOR){ 
    stringBuffer.append(TEXT_182);
    if(outputs.size() == 1){
    stringBuffer.append(ps.getValueReturnType(true));
    }else{
    stringBuffer.append(ps.getResultsInterface());
    }
    stringBuffer.append(TEXT_183);
    if(outputs.size() == 1){
    stringBuffer.append(ps.getValueReturnType(true));
    }else{
    stringBuffer.append(ps.getResultsInterface());
    }
    stringBuffer.append(TEXT_184);
     } 
    stringBuffer.append(TEXT_185);
     if(ctx.getRethrowSQLException()) {
    stringBuffer.append(TEXT_186);
    }else{
    stringBuffer.append(TEXT_187);
    stringBuffer.append(ctx.getRethrowExceptionName());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_189);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_190);
    if(ps.hasInputParams()) { 
    stringBuffer.append(TEXT_191);
    stringBuffer.append(ps.getInputExceptionSignature());
    }
    stringBuffer.append(TEXT_192);
    if(ps.hasTemplateParams()){
    stringBuffer.append(TEXT_193);
    stringBuffer.append(ps.getTemplateExceptionSignature());
    }
    stringBuffer.append(TEXT_194);
    }
    stringBuffer.append(TEXT_195);
     if (result != Result.ITERATOR){ 
    stringBuffer.append(TEXT_196);
     } 
    stringBuffer.append(TEXT_197);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_198);
    }
    stringBuffer.append(TEXT_199);
     if (result == Result.NONE||result == Result.IDENTITY||result==Result.COUNTER) { 
    stringBuffer.append(TEXT_200);
    stringBuffer.append(ps.capitalizedName());
    stringBuffer.append(TEXT_201);
    stringBuffer.append(ps.capitalizedName());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(ps.capitalizedName());
    stringBuffer.append(TEXT_203);
    if(ps.hasTemplateParams()){
    stringBuffer.append(ps.getTemplateParamsJavadoc());
    }
    stringBuffer.append(TEXT_204);
    stringBuffer.append(ps.capitalizedName());
    stringBuffer.append(TEXT_205);
    if(ps.hasTemplateParams()){
    stringBuffer.append(TEXT_206);
    stringBuffer.append(ps.getTemplateParamSigniture());
    }
    stringBuffer.append(TEXT_207);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(ps.getTemplateParams());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_210);
    if(ps.hasInputParams()){
    stringBuffer.append(ps.getInputParamsJavadoc());
    }
    stringBuffer.append(TEXT_211);
    if(ps.hasInputParams()) { 
    stringBuffer.append(ps.getInputParamSigniture());
    }
    stringBuffer.append(TEXT_212);
    if(ps.hasInputParams()){
    stringBuffer.append(TEXT_213);
    }
     for (Parameter param : inputs) { 
    if(!param.isPrimitive()){
    stringBuffer.append(TEXT_214);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_215);
    if(!param.canBeNull()){
    stringBuffer.append(TEXT_216);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(ps.getName());
    stringBuffer.append(TEXT_218);
    }else{
    stringBuffer.append(TEXT_219);
    stringBuffer.append(param.getJdbcType());
    stringBuffer.append(TEXT_220);
    }
    stringBuffer.append(TEXT_221);
    stringBuffer.append(param.getResultSetProperty());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_223);
     }else{
    stringBuffer.append(TEXT_224);
    stringBuffer.append(param.getResultSetProperty());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_226);
    }}
    stringBuffer.append(TEXT_227);
     } 
    stringBuffer.append(TEXT_228);
     if (outputs.size() > 1) { 
    stringBuffer.append(TEXT_229);
    stringBuffer.append(ps.getResultsInterface());
    stringBuffer.append(TEXT_230);
    stringBuffer.append(ps.getResultsInterface());
    stringBuffer.append(TEXT_231);
     		for (Parameter param : outputs) {
    stringBuffer.append(TEXT_232);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(param.getJavaType(false));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_235);
     		} 
    stringBuffer.append(TEXT_236);
     		for (Parameter param : outputs) {
    stringBuffer.append(TEXT_237);
    stringBuffer.append(param.getRdbProperty());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(param.getRdbProperty());
    stringBuffer.append(TEXT_239);
    stringBuffer.append(param.getJavaType(false));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(param.getRdbProperty());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(param.getName());
    stringBuffer.append(TEXT_242);
     		} 
    stringBuffer.append(TEXT_243);
     } 
     } 
    stringBuffer.append(TEXT_244);
    return stringBuffer.toString();
  }
}
