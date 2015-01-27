/**   
* @Title: SessionHelper.java 
* @Package com.ree.commmon 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年9月27日 下午4:28:34 
* @version  
*/
package com.ree.common;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.ree.hibernate.RepAdminNews;
/** 
 * @ClassName: SessionHelper 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年9月27日 下午4:28:34 
 *  
 */
public class SessionHelper {
	private static Configuration cfg;
	private static ServiceRegistry sr;
	private SessionFactory sf ;
	Session session;
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: </p>
	 */
	public SessionHelper(){
		try{
		    if(cfg == null)
			cfg = new Configuration().configure();
		    if(sr == null)
			sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		}
		catch(HibernateException e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	/**
	 * 
	* @Title: getSession 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return Session    返回类型 
	* @throws
	 */
	private Session getSession(){
		try{
		    
			sf = cfg.buildSessionFactory(sr);
		    	//sf = cfg.buildSessionFactory();
			session = sf.openSession();
		}
		catch(HibernateException e){
			throw new RuntimeException(e.getMessage(),e);
		}
		
		return session;
	}
	/**
	 * 
	* @Title: Update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param o    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void Update(Object o){
		if(!isOpen()){
			this.getSession();
		}
		try{
			session.beginTransaction();
			session.update(o);
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			closeSession();
			FileHelper.writeLog("Update_" + o.getClass().getName());
		}
	}
	/**
	 * 
	* @Title: Save 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param o    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void Save(Object o){
		if(!isOpen()){
			this.getSession();
		}
		try{
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			closeSession();
			FileHelper.writeLog("Save_" + o.getClass().getName());
		}
	}
	/**
	 * 
	* @Title: Save 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param o
	* @param @param context    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void Save(Object o,ServletContext context){
	    if(!isOpen()){
		this.getSession();
	}
	try{
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
	}
	catch(HibernateException e){
		throw new RuntimeException(e);
	}
	finally{
		closeSession();
		FileHelper.writeLog("Save_" + o.getClass().getName(),context);
	}
	}
	/**
	 * 
	* @Title: SaveBatch 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param oldList    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void SaveBatch(List<RepAdminNews> oldList){
		if(!isOpen()){
			this.getSession();
		}
		try{
			session.beginTransaction();
			for(Object o : oldList){
				session.save(o);
			}
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			closeSession();
		}
	}
	/**
	 * 
	* @Title: Delete 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param o    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void Delete(Object o){
		if(!isOpen()){
			this.getSession();
		}
		try{
			session.beginTransaction();
			session.delete(o);
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			closeSession();
			FileHelper.writeLog("Delete_" + o.getClass().getName());
		}
	}
	/**
	 * 
	* @Title: Delete 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param os    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void DeleteBatch(List<RepAdminNews> oldList){
		if(!isOpen()){
			this.getSession();
		}
		try{
			session.beginTransaction();
			for(Object o : oldList){
				session.delete(o);
			}
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			closeSession();
		}
	}
	/**
	 * 
	* @Title: getBean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param c
	* @param @param p
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public Object getBean(Class c,Serializable p){
		Object result = null;
		if(!isOpen()){
			this.getSession();
		}
		try{
			result = session.get(c, p);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			closeSession();
		}
		return result;
	}
	/**
	 * 
	* @Title: getQuery 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param sql
	* @param @return    设定文件 
	* @return Query    返回类型 
	* @throws
	 */
	public Query getQuery(String sql){
		if(!isOpen()){
			this.getSession();
		}
		Query q;
		try{
			q = session.createQuery(sql);
		}
		catch(Exception e){
			throw e;
		}
		return q;
	}
	/**
	 * 
	* @Title
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param fatherid    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void runProc_one_int_parma(final String proc,final int p) {
		//return
        //final List<Object[]> rtnObjs = new ArrayList<Object[]>();
		if(!isOpen()){
			this.getSession();
		}
		try{
	            session.beginTransaction();
	            Work work = new Work() {
					@Override
					public void execute(java.sql.Connection arg0)
							throws SQLException {
						// TODO Auto-generated method stub
					    java.sql.CallableStatement csmt = arg0.prepareCall(proc);
			                    //CallableStatement csmt = (CallableStatement) arg0.prepareCall(proc);
		                    csmt.setInt(1, p);
		                    csmt.execute();
					}
	            };
	            session.doWork(work);
	            session.getTransaction().commit();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			closeSession();
		}
		
        try {
           

        } catch (Exception e) {
            System.out.println("DAO层访问存储过程失败");
        }
    }
//	public ResultSet getResultBySp(String proc,int c,int p,String _title,String _where,String _order) throws Exception{
//		ResultSet rs = null;
//		if(!isOpen()){
//			this.getSession();
//		}
//		Query q;
//		try{
//			SessionFactoryImplementor sessionFactory = (SessionFactoryImplementor)new Configuration().configure().buildSessionFactory();
//			ConnectionProvider cp =((SessionFactoryImplementor)sessionFactory).getConnectionProvider(); 
//			Connection con = (Connection) cp.getConnection();
//			CallableStatement statement = (CallableStatement) con.prepareCall(proc);
//			statement.setInt(1, c);
//			statement.setInt(2, p);
//			statement.setString(3, _title);
//			statement.setString(4, _where);
//			statement.setString(5, _order);
//			//statement.registerOutParameter(6, java.sql.Types.INTEGER);
//			rs = statement.getResultSet();
//		}
//		catch(Exception e){
//			throw e;
//		}
//		return rs;
//	}
	/**
	 * 
	* @Title: getNamedQuery 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param proc
	* @param @return    设定文件 
	* @return Query    返回类型 
	* @throws
	 */
	public Query getNamedQuery(String proc){
		if(!isOpen()){
			this.getSession();
		}
		Query q;
		try{
			q = session.getNamedQuery(proc);
		}
		catch(Exception e){
			throw e;
		}
		return q;
	}
	/**
	 * 
	* @Title: closeSession 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param session    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void closeSession(){
		if(isOpen()){
			session.close();
			sf.close();
		}
	}
	private boolean isOpen(){
		if(session==null||sf==null)
			return false;
		return session.isOpen()||!sf.isClosed();
	}

}
