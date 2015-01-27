/**   
* @Title: SpiderTask.java 
* @Package com.ree.timer 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年11月26日 下午6:49:44 
* @version  
*/
package com.ree.timer;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.news.spider.SpiderAction;

/** 
 * @ClassName: SpiderTask 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年11月26日 下午6:49:44 
 *  
 */
public class SpiderTask extends TimerTask {
    private static boolean isRunning = false;
    private static final int C_SCHEDULE_HOUR = 4; 
    private ServletContext context = null; 
    
    public SpiderTask(ServletContext context){
	this.context = context; 
    }
    /** (非 Javadoc) 
    * <p>Title: run</p> 
    * <p>Description: </p>  
    * @see java.util.TimerTask#run() 
    */
    @Override
    public void run() {
	Calendar cal = Calendar.getInstance();
	// TODO Auto-generated method stub
	if (!isRunning&&(C_SCHEDULE_HOUR == cal.get(Calendar.HOUR_OF_DAY))) {
            isRunning = true;
            context.log("开始执行指定任务"); 
            //业务逻辑-start
            SpiderAction sa = new SpiderAction();
            try {
        	context.log(sa.doExecute(this.context));
	    } catch (ParseException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
            //业务逻辑-end
            isRunning = false;
            context.log("指定任务执行结束");
        } else {
            context.log(isRunning?"上一次任务执行还未结束":"不在定时范围内"+cal.get(Calendar.HOUR_OF_DAY));
        }
    }
}
