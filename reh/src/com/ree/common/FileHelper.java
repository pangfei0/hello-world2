/**   
 * @Title: FileHelper.java 
 * @Package com.ree.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Administrator - 李丁
 * @date 2014年10月31日 上午12:52:58 
 * @version  
 */
package com.ree.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.ree.timer.SpiderTask;

/**
 * @ClassName: FileHelper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator - 李丁
 * @date 2014年10月31日 上午12:52:58
 * 
 */
public class FileHelper {
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	public static void writeLog(String s) {
		File file = new File(ServletActionContext.getServletContext().getRealPath("/") +"log.txt");
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = df.format(new Date()) + "___IP:"+request.getRemoteAddr() +"___serverName:"+request.getRemoteHost()
				+"___CONTENT:"+s + "\r\n";
		try (FileOutputStream fop = new FileOutputStream(file,true)) {
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writeLog(String s,ServletContext context) {
		File file = new File(context.getRealPath("/") +"log.txt");
		String content = df.format(new Date()) + "___IP:Timer___serverName:Timer___CONTENT:"+s + "\r\n";
		try (FileOutputStream fop = new FileOutputStream(file,true)) {
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
