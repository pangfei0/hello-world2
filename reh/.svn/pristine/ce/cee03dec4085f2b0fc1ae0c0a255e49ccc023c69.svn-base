package com.ree.user;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import java.sql.CallableStatement;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException; 

import com.opensymphony.xwork2.ActionSupport;
import com.ree.common.SessionHelper;
import com.ree.hibernate.RepUserAble;
import com.ree.hibernate.RepUserCompany;
import com.ree.hibernate.RepUserEdu;
import com.ree.hibernate.RepUserInfo;
import com.ree.hibernate.RepUserProgram;
import com.ree.hibernate.RepUserSupple;
import com.ree.hibernate.RepUserTrainExp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.ServiceRegistry;
public class ResumeAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 输入
	 */
	private int userno;
	private SessionHelper s = new SessionHelper();
	private HashMap<String,Object> store = new HashMap<String,Object>();
	private RepUserInfo rbean = new RepUserInfo(); 
	private RepUserCompany rcbean = new RepUserCompany(); 
	private RepUserEdu rebean = new RepUserEdu(); 
	private RepUserProgram rpbean = new RepUserProgram(); 
	private RepUserTrainExp rtbean = new RepUserTrainExp(); 
	private RepUserAble rabean = new RepUserAble(); 
	private RepUserSupple rsbean = new RepUserSupple(); 
	List<RepUserInfo> list1 = new ArrayList<RepUserInfo>();
	List<RepUserCompany> list2 = new ArrayList<RepUserCompany>();
	List<RepUserEdu> list3 = new ArrayList<RepUserEdu>();
	List<RepUserProgram> list4= new ArrayList<RepUserProgram>();
	List<RepUserTrainExp> list5 = new ArrayList<RepUserTrainExp>();
	List<RepUserAble> list6 = new ArrayList<RepUserAble>();
	List<RepUserSupple> list7 = new ArrayList<RepUserSupple>();

	public String execute() throws IOException, ParseException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{	
		
		try {		
			 String sql = "{call proc_user_resume(75)}";
			Configuration cfg = new Configuration().configure();
	        SessionFactory sf = cfg.buildSessionFactory();
	         Session session = sf.openSession();        	        
	         Connection con=((SessionFactoryImplementor)sf).getConnectionProvider().getConnection();  	        
	         CallableStatement cs = con.prepareCall(sql);
	         cs.executeQuery();
	         ResultSet rs = cs.getResultSet();
	         if(rs!=null){
	        	 while(rs.next()){
	        		 rbean.setUserNo(rs.getInt("USER_NO"));
		        	 rbean.setUserUid(rs.getString("USER_UID"));
		        	 rbean.setUserPwd(rs.getString("USER_PWD"));
		        	 rbean.setUserEmail(rs.getString("USER_EMAIL"));
		        	 rbean.setUserName(rs.getString("USER_NAME"));
		        	 rbean.setUserSex(rs.getString("USER_SEX"));
		        	 rbean.setUserCert(rs.getString("USER_CERT"));
		        	 rbean.setUserResidence(rs.getString("USER_RESIDENCE"));
		        	 rbean.setUserAddrDisNo(rs.getInt("USER_ADDR_DIS_NO"));
		        	 rbean.setUserAddrPos(rs.getString("USER_ADDR_POS"));
		        	 rbean.setUserIntentDisNo(rs.getString("USER_INTENT_DIS_NO"));
		        	 rbean.setUserEducationNo(rs.getInt("USER_EDUCATION_NO"));
		        	 rbean.setUserExpNo(rs.getInt("USER_EXP_NO"));
		        	 rbean.setUserIntentJobTypeNo(rs.getInt("USER_INTENT_JOB_TYPE_NO"));
		        	 rbean.setUserIntention(rs.getString("USER_INTENTION"));
		        	 rbean.setUserPhone(rs.getString("USER_PHONE"));
		        	 rbean.setUserAge(rs.getInt("USER_AGE"));
		        	 rbean.setUserBynow(rs.getString("USER_BYNOW"));
		        	 rbean.setUserSkill(rs.getString("USER_SKILL"));
		        	 rbean.setUserContent(rs.getString("USER_CONTENT"));
		        	 list1.add(rbean);
		         }
		         while(cs.getMoreResults()){
		        	 rs = cs.getResultSet();
		        	 while(rs.next()){
		        		 rcbean.setUserno(rs.getInt("USERNO"));
		        		 rcbean.setCorname(rs.getString("CORNAME"));
		        		 rcbean.setCornature(rs.getString("CORNATURE"));
		        		 rcbean.setCorscale(rs.getString("CORSCALE"));
		        		 rcbean.setCorindustry(rs.getString("CORINDUSTRY"));
		        		 rcbean.setDepartment(rs.getString("DEPARTMENT"));
		        		 rcbean.setReport(rs.getString("REPORT"));
		        		 rcbean.setSubordinate(rs.getInt("SUBORDINATE"));
		        		 rcbean.setJobname(rs.getString("JOBNAME"));
		        		 rcbean.setWorktime(rs.getDate("WORKTIME"));
		        		 rcbean.setWorkaddr(rs.getString("WORKADDR"));
		        		 rcbean.setSummary(rs.getString("SUMMARY"));
		        		 rcbean.setJobperformance(rs.getString("JOBPERFORMANCE"));
		        		 list2.add(rcbean);
		        	 }
		        	 while(cs.getMoreResults()){
			        	 rs = cs.getResultSet();
			        	 while(rs.next()){
			        		 rebean.setUserno(rs.getInt("USERNO"));
			        		 rebean.setStudytime(rs.getString("STUDYTIME"));
			        		 rebean.setSchool(rs.getString("SCHOOL"));
			        		 rebean.setObjname(rs.getString("OBJNAME"));
			        		 rebean.setEntrance(rs.getString("ENTRANCE"));
			        		 rebean.setDegree(rs.getString("DEGREE"));
			        		 list3.add(rebean);
			        	 }
			        	 while(cs.getMoreResults()){
				        	 rs = cs.getResultSet();
				        	 while(rs.next()){
				        		 rpbean.setUserno(rs.getInt("USERNO"));
				        		 rpbean.setPname(rs.getString("PNAME"));
				        		 rpbean.setPtime(rs.getString("PTIME"));
				        		 rpbean.setCompany(rs.getString("COMPANY"));
				        		 rpbean.setProJobname(rs.getString("PRO_JOBNAME"));
				        		 rpbean.setProDescribe(rs.getString("PRO_DESCRIBE"));
				        		 rpbean.setPduty(rs.getString("PDUTY"));
				        		 rpbean.setJobgain(rs.getString("JOBGAIN"));
				        		 list4.add(rpbean);
				        	 }
				        	 while(cs.getMoreResults()){
					        	 rs = cs.getResultSet();
					        	 while(rs.next()){
					        		 rtbean.setUserno(rs.getInt("USERNO"));
					        		 rtbean.setTraintime(rs.getDate("TRAINTIME"));
					        		 rtbean.setTrainorgan(rs.getString("TRAINORGAN"));
					        		 rtbean.setTraincourse(rs.getString("TRAINCOURSE"));
					        		 rtbean.setCertificate(rs.getString("CERTIFICATE"));
					        		 rtbean.setDescribe(rs.getString("DESCRIBE"));
					        		 list5.add(rtbean);
					        	 }
					        	 while(cs.getMoreResults()){
						        	 rs = cs.getResultSet();
						        	 while(rs.next()){
						        		 rabean.setUserno(rs.getInt("USERNO"));
						        		 rabean.setLanguage(rs.getString("LANGUAGE"));
						        		 rabean.setListen(rs.getString("LISTEN"));
						        		 rabean.setWrite(rs.getString("WRITE"));
						        		 list6.add(rabean);
						        	 }
						        	 while(cs.getMoreResults()){
							        	 rs = cs.getResultSet();
							        	 while(rs.next()){
							        		 rsbean.setUserno(rs.getInt("USERNO"));
							        		 rsbean.setSupInfo(rs.getString("SUP_INFO"));
							        		 rsbean.setSupContent(rs.getString("SUP_CONTENT"));
							        		 list7.add(rsbean);
							        	 }
							         }
						         }
					         }
				         }
			         }
		         }		         
	         } 
	         store.put("rdata", list1);
	         store.put("cdata", list2);
	         store.put("edata", list3);
	         store.put("pdata", list4);
	         store.put("tdata", list5);
	         store.put("adata", list6);
	         store.put("sdata", list7);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			
		}	
	    	return SUCCESS;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public HashMap<String, Object> getStore() {
		return store;
	}

	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}
	
}
	
	