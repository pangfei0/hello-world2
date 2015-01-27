/** 
 * Project Name:rep 
 * File Name:SessionCounter.java 
 * Package Name:com.rep.sessioncounter 
 * Date:2014年8月1日下午3:01:55 
 * 
 */  
package com.ree.sessioncounter;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * <p>Title: SessionCounter<／p>
 * <p>Description:统计在线人数 <／p> 
 * @author 李丁
 * @date 2014年8月1日
 */
public class SessionCounter implements HttpSessionListener {
	 private static int activeSessions = 0; 
	 public void sessionCreated(HttpSessionEvent se) { 
	     activeSessions++; 
	 } 
	 
	 public void sessionDestroyed(HttpSessionEvent se) { 
	  if(activeSessions > 0) 
	     activeSessions--; 
	 } 
	 
	 public static int getActiveSessions() { 
	    return activeSessions; 
	 }
}
