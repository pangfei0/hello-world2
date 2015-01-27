/**   
* @Title: SpiderTask.java 
* @Package com.ree.timer 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年11月26日 下午6:47:39 
* @version  
*/
package com.ree.timer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** 
 * @ClassName: SpiderTask 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年11月26日 下午6:47:39 
 *  
 */
public class SpiderTimer extends HttpServlet implements ServletContextListener {
    private Timer timer = null;
    private Calendar cal=Calendar.getInstance();
    /** (非 Javadoc) 
    * <p>Title: contextDestroyed</p> 
    * <p>Description: </p> 
    * @param arg0 
    * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent) 
    */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
	// TODO Auto-generated method stub
	timer.cancel();
        arg0.getServletContext().log("定时器销毁"); 
    }

    /** (非 Javadoc) 
    * <p>Title: contextInitialized</p> 
    * <p>Description: </p> 
    * @param arg0 
    * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent) 
    */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
	// TODO Auto-generated method stub
	 timer = new java.util.Timer(true);
	 arg0.getServletContext().log(cal.getTime()+"定时器已启动");
	 timer.schedule(new SpiderTask(arg0.getServletContext()), 0, 60 * 1000 * 60);
	 arg0.getServletContext().log(cal.getTime()+"已经添加任务调度表"); 
    }

}
