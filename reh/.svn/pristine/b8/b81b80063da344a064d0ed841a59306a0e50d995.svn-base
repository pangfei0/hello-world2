/** 
 * Project Name:rep 
 * File Name:UploadFileAction.java 
 * Package Name:com.rep.uploadfile.action 
 * Date:2014年7月21日下午1:03:50 
 * 
 */  
package com.ree.news;

import java.io.File;
import java.util.concurrent.ExecutionException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.omg.PortableServer.Servant;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: UploadFileAction<／p>
 * <p>Description:上传文件 <／p> 
 * @author 李丁
 * @date 2014年7月21日
 */
public class UploadFileAction extends ActionSupport {
	private String err;
	private File filedata;
	private String filedataFileName; // FileName为固定格式  
    private String filedataContentType; // ContentType为固定格式  
	private String msg;
	public String execute(){
		String dirpath = ServletActionContext.getServletContext().getRealPath("/upload/");
		File filepath = new File(dirpath);
		try{
			//文件类型验证
			if(!filedataContentType.equals("application/msword")&&
				!filedataContentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")&&
					!filedataContentType.equals("image/jpeg")&&
					!filedataContentType.equals("application/x-jpg")&&
					!filedataContentType.equals("image/png")&&
					!filedataContentType.equals("application/x-png")&&
					!filedataContentType.equals("image/gif")&&
					!filedataContentType.equals("application/octet-stream")&&//rar
					!filedataContentType.equals("application/x-zip-compressed")&&//zip
					!filedataContentType.equals("application/vnd.ms-excel")&&//xls
					!filedataContentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))//xlsx
			{
				throw(new Exception("文件类型不正确"));
			}
			//如果目录不存在  
	        if (!filepath.exists()) {  
	            //创建目录  
	        	filepath.mkdir();  
	        }  
	        String filename = System.currentTimeMillis() + "_" + filedataFileName.replaceAll("%", "_") ;
	        FileUtils.copyFile(filedata, new File(filepath,filename));
			msg = ServletActionContext.getRequest().getContextPath() +"/upload/"+filename;
	        	//msg = "./upload/"+filename;
			err = "";
		}
		catch(Exception e){
			e.printStackTrace();
			err = e.getMessage();
		}
		return SUCCESS;
	}
	/**
	 * @return the err
	 */
	public String getErr() {
		return err;
	}
	/**
	 * @param err the err to set
	 */
	public void setErr(String err) {
		this.err = err;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the filedata
	 */
	public File getFiledata() {
		return filedata;
	}
	/**
	 * @param filedata the filedata to set
	 */
	public void setFiledata(File filedata) {
		this.filedata = filedata;
	}
	/**
	 * @return the filedataContentType
	 */
	public String getFiledataContentType() {
		return filedataContentType;
	}
	/**
	 * @param filedataContentType the filedataContentType to set
	 */
	public void setFiledataContentType(String filedataContentType) {
		this.filedataContentType = filedataContentType;
	}
	/**
	 * @return the filedataFileName
	 */
	public String getFiledataFileName() {
		return filedataFileName;
	}
	/**
	 * @param filedataFileName the filedataFileName to set
	 */
	public void setFiledataFileName(String filedataFileName) {
		this.filedataFileName = filedataFileName;
	}
}
