/** 
 * Project Name:rep 
 * File Name:ResultHelper.java 
 * Package Name:com.rep.common 
 * Date:2014年7月16日下午3:22:29 
 * 
 */
package com.ree.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

/**
 * <p>
 * Title: ResultHelper<／p>
 * <p>
 * Description: <／p>
 * 
 * @author 李丁
 * @date 2014年7月16日
 */
public class ResultHelper {
	private String driverName = "com.mysql.jdbc.Driver";
	private Connection con;
	private Statement stmt;
	private java.sql.PreparedStatement pstmt;
	private ResultSet result;

	private String querystatement;

	/**
	 * <p>
	 * Title: getResult<／p>
	 * <p>
	 * Description:返回resultset <／p>
	 * <p>
	 * Return:ResultSet
	 * </p>
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet getResult(String sql, String[] param) throws SQLException {
		try {
			Class.forName(driverName).newInstance();
			con = DBHelper.getConnection();
			stmt = con.createStatement();
			this.setQuerystatement(String.format(sql, param));
			result = stmt.executeQuery(this.getQuerystatement());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
		    con.close();
		}
		return result;
	}

	/**
	 * 
	 * <p>
	 * Title: runSql<／p>
	 * <p>
	 * Description:执行sql <／p>
	 * <p>
	 * Return:String
	 * </p>
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public String runSql(String sql,String[] param) throws SQLException {
		String rs = null;
		try {
			Class.forName(driverName).newInstance();
			con = DBHelper.getConnection();
			con.setAutoCommit(false);
			this.setQuerystatement(String.format(sql,param));
			pstmt = con.prepareStatement(this.getQuerystatement());
			pstmt.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
		} catch (Exception e) {
			System.out.println(rs += e.getMessage());
			con.rollback();
		}
		 finally 
		 { 
			pstmt.close();
			connStop();
	     } 
		return rs;
	}
	
	
	/**
	 * 
	* <p>Title: runBatch<／p>
	* <p>Description:通过Objectbatch执行sql <／p>
	* <p>Return:String</p>
	* @param sql
	* @param obj
	* @return
	 * @throws SQLException 
	 */
	public String runBatch(String sql,Object[][] obj) throws SQLException{
		String rs = null;
		try {
			Class.forName(driverName).newInstance();
			con = DBHelper.getConnection();
			con.setAutoCommit(false);
			this.setQuerystatement(sql);
			pstmt = con.prepareStatement(this.getQuerystatement());
			//封装
			for(Object[] os : obj){
				int j = 0;
				for(Object o: os){
					if(o instanceof Integer){
						pstmt.setInt(++j, (Integer)o);
					}
					else if(o instanceof String){
						pstmt.setString(++j, (String)o);
					}
					else if(o instanceof Double){
						pstmt.setDouble(++j, (Double)o);
					}
					else if(o instanceof Float){
						pstmt.setFloat(++j, (Float)o);
					}
					else if(o instanceof Boolean){
						pstmt.setBoolean(++j, (Boolean)o);
					}
					else if(o instanceof Date){
						pstmt.setDate(++j, (Date)o);
					}
				}
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			con.commit();
			con.setAutoCommit(true);
		} catch (Exception e) {
			System.out.println(rs += e.getMessage());
			con.rollback();
		}
		 finally 
		 { 
			pstmt.close();
			connStop();
	     } 
		return rs;
	}

	/**
	 * <p>
	 * Title: connStop<／p>
	 * <p>
	 * Description:关闭连接对象 <／p>
	 * <p>
	 * Return:void
	 * </p>
	 */
	public void connStop() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the querystatement
	 */
	public String getQuerystatement() {
		return querystatement;
	}

	/**
	 * @param querystatement
	 *            the querystatement to set
	 */
	public void setQuerystatement(String querystatement) {
		this.querystatement = querystatement;
	}
}
