package com.ree.common;

import java.sql.*;   

import javax.sql.*;   
import javax.naming.*; 

import com.ree.hibernate.RepAdminSys;

import java.security.MessageDigest;
import java.util.List;

public class DBHelper {
	public static Connection getConnection() throws SQLException,NamingException   
    {   
        // 初始化查找命名空间   
        Context initContext = new InitialContext();   
        Context envContext = (Context)initContext.lookup("java:/comp/env");   
        // 找到DataSource   
        DataSource ds = (DataSource)envContext.lookup("jdbc/mysql");   
        return ds.getConnection();   
    }  
	/**
	 * 
	* @Title: GetSysValue_By_Name 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param name
	* @param @param list
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String GetSysValue_By_Name(String name ,List<RepAdminSys> list){
		String result = "";
		for(RepAdminSys s : list){
			if(s.getSysName()!=null&&s.getSysName().equals(name))
				result = s.getSysValue();
		}
		return result;
	}
	/**
	 * 
	* @Title: GetMsg 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param e
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String GetMsg (Exception e){
		if(e.getCause()==null)
			return e.getMessage()==null?e.getClass().getName():e.getMessage();
		return GetMsg(e.getCause());
	}
	private static String GetMsg(Throwable t){
		if(t.getCause()!=null)
			return GetMsg(t.getCause());
		else
			return t.toString();
	}
    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
        	if(s==null||s.length()==0)
        	{
        		throw (new Exception("string is null"));
        	}
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }
}
