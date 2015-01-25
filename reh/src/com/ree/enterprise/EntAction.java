package com.ree.enterprise;

import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.ree.common.DBHelper;
import com.ree.hibernate.RepEntInfo;

/**
 * @ClassName: EntAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator - 李丁
 * @date 2014年10月15日 下午3:57:48
 * 
 */
public class EntAction extends ActionSupport {
	private RepEntInfo entBean = new RepEntInfo();
	private EntDao eDao = new EntDao();
	
	/**
	 * file
	 */
	private File entCertUrlSer;
	private String entCertUrlSerFileName; // FileName为固定格式  
    private String entCertUrlSerContentType; // ContentType为固定格式  
	private File entCertUrlO;
	private String entCertUrlOFileName; // FileName为固定格式  
    private String entCertUrlOContentType; // ContentType为固定格式  
	private File entCertUrlLicence;
	private String entCertUrlLicenceFileName; // FileName为固定格式  
    private String entCertUrlLicenceContentType; // ContentType为固定格式  
	
	private int u_type;
	
	private String sc = "";
	Pattern email = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");		
	/**
	 * 注册
	* @Title: Register 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Register(){
		try{
			if (entBean.getEntName() == null
					|| entBean.getEntName().trim().equals(""))
				throw new Exception("企业名称不能为空");
			if (entBean.getEntUid() == null
					|| entBean.getEntUid().trim().equals(""))
				throw new Exception("用户名不能为空");
			if (entBean.getEntPwd() == null
					|| entBean.getEntPwd().trim().equals(""))
				throw new Exception("密码不能为空");
			//
			entBean.setEntPwd(DBHelper.MD5(entBean.getEntPwd()));
			if (entBean.getEntEmail() == null
					|| entBean.getEntEmail().trim().equals(""))
				throw new Exception("邮箱不能为空");
			Matcher matcher = email.matcher(entBean.getEntEmail().trim());
			if(!matcher.matches())
				throw new Exception("邮箱格式不正确");
//			if (entBean.getEntTypeEconomy() == 0)
//				throw new Exception("经济类型不能为空");
			if (entBean.getEntTypeTrade() == 0)
				throw new Exception("行业类型不能为空");
			if (entBean.getEntAddrDisNo() == 0)
				throw new Exception("所属街道不能为空");
			//
			entBean.setReserved02(0); 
			String message = eDao.Add_EntInfo_By_Bean(entBean);
			if (message != null) {
				this.setSc(message);
				return SUCCESS;
			}else{
				sc = "申请成功，请等待审核";
			}
		}
		catch(Exception e){
			sc+= DBHelper.GetMsg(e);
		}
		return SUCCESS;
	}
	/**
	 * 登记
	* @Title: Modify 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Modify() {
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
		try{
			if(session.get("u_type")==null)
				throw new Exception("未登录");
			if (entBean.getEntName() == null
					|| entBean.getEntName().trim().equals(""))
				throw new Exception("企业名称不能为空");
			if (entBean.getEntEmail() == null
					|| entBean.getEntEmail().trim().equals(""))
				throw new Exception("邮箱不能为空");
			Matcher matcher = email.matcher(entBean.getEntEmail().trim());
			if(!matcher.matches())
				throw new Exception("邮箱格式不正确");
			//file
			String dirpath = ServletActionContext.getServletContext().getRealPath("/upload/");
			File filepath = new File(dirpath);
			//文件类型验证
			if((entCertUrlSerContentType!=null&&!entCertUrlSerContentType.equals("image/jpeg")&&!entCertUrlSerContentType.equals("application/x-jpg")&&
					!entCertUrlSerContentType.equals("image/png")&&!entCertUrlSerContentType.equals("application/x-png")&&
					!entCertUrlSerContentType.equals("image/gif"))
					||
					(entCertUrlOContentType!=null&&!entCertUrlOContentType.equals("image/jpeg")&&!entCertUrlOContentType.equals("application/x-jpg")&&
					!entCertUrlOContentType.equals("image/png")&&!entCertUrlOContentType.equals("application/x-png")&&
					!entCertUrlOContentType.equals("image/gif"))
					||
					(entCertUrlLicenceContentType!=null&&!entCertUrlLicenceContentType.equals("image/jpeg")&&!entCertUrlLicenceContentType.equals("application/x-jpg")&&
					!entCertUrlLicenceContentType.equals("image/png")&&!entCertUrlLicenceContentType.equals("application/x-png")&&
					!entCertUrlLicenceContentType.equals("image/gif")))
			{
				throw(new Exception("文件类型不正确"));
			}
			//如果目录不存在  
	        if (!filepath.exists()) {  
	            //创建目录  
	        	filepath.mkdir();  
	        }  

			RepEntInfo sessionbean = (RepEntInfo)session.get("entbean");
			RepEntInfo oldbean = (RepEntInfo)eDao.getBean(RepEntInfo.class, sessionbean.getEntNo());
			entBean.setEntUid(oldbean.getEntUid());
			entBean.setEntPwd(oldbean.getEntPwd());
			entBean.setEntNo(sessionbean.getEntNo());
			entBean.setEntCertUrlSer(oldbean.getEntCertUrlSer());
			entBean.setEntCertUrlO(oldbean.getEntCertUrlO());
			entBean.setEntCertUrlLicence(oldbean.getEntCertUrlLicence());
			String filename;
			
			if(entCertUrlSerFileName!=null&&!entCertUrlSerFileName.equals("")){
				filename = System.currentTimeMillis() + "_" + entCertUrlSerFileName.replaceAll("%", "_") ;
		        FileUtils.copyFile(entCertUrlSer, new File(filepath,filename));
		        entBean.setEntCertUrlSer(ServletActionContext.getRequest().getContextPath() +"/upload/"+filename);
			}

	        if(entCertUrlOFileName!=null&&!entCertUrlOFileName.equals("")){
	        	 filename = System.currentTimeMillis() + "_" + entCertUrlOFileName.replaceAll("%", "_") ;
	 	        FileUtils.copyFile(entCertUrlO, new File(filepath,filename));
	 	        entBean.setEntCertUrlO(ServletActionContext.getRequest().getContextPath() +"/upload/"+filename);
	        }
	        
	        if(entCertUrlLicenceFileName!=null&&!entCertUrlLicenceFileName.equals("")){
	        	filename = System.currentTimeMillis() + "_" + entCertUrlLicenceFileName.replaceAll("%", "_") ;
		        FileUtils.copyFile(entCertUrlLicence, new File(filepath,filename));
		        entBean.setEntCertUrlLicence(ServletActionContext.getRequest().getContextPath() +"/upload/"+filename);
	        }
	        
			eDao.Update(entBean);
			session.put("entbean",entBean);
			sc = "修改成功";
		}
		catch(Exception e){
			sc+= DBHelper.GetMsg(e);
		}
		
		
		return "entSuc";
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public RepEntInfo getEntBean() {
		return entBean;
	}

	public void setEntBean(RepEntInfo entBean) {
		this.entBean = entBean;
	}
	public int getU_type() {
		return u_type;
	}
	public void setU_type(int u_type) {
		this.u_type = u_type;
	}
	public File getEntCertUrlSer() {
		return entCertUrlSer;
	}
	public void setEntCertUrlSer(File entCertUrlSer) {
		this.entCertUrlSer = entCertUrlSer;
	}
	public String getEntCertUrlSerFileName() {
		return entCertUrlSerFileName;
	}
	public void setEntCertUrlSerFileName(String entCertUrlSerFileName) {
		this.entCertUrlSerFileName = entCertUrlSerFileName;
	}
	public String getEntCertUrlSerContentType() {
		return entCertUrlSerContentType;
	}
	public void setEntCertUrlSerContentType(String entCertUrlSerContentType) {
		this.entCertUrlSerContentType = entCertUrlSerContentType;
	}
	public File getEntCertUrlO() {
		return entCertUrlO;
	}
	public void setEntCertUrlO(File entCertUrlO) {
		this.entCertUrlO = entCertUrlO;
	}
	public String getEntCertUrlOFileName() {
		return entCertUrlOFileName;
	}
	public void setEntCertUrlOFileName(String entCertUrlOFileName) {
		this.entCertUrlOFileName = entCertUrlOFileName;
	}
	public String getEntCertUrlOContentType() {
		return entCertUrlOContentType;
	}
	public void setEntCertUrlOContentType(String entCertUrlOContentType) {
		this.entCertUrlOContentType = entCertUrlOContentType;
	}
	public File getEntCertUrlLicence() {
		return entCertUrlLicence;
	}
	public void setEntCertUrlLicence(File entCertUrlLicence) {
		this.entCertUrlLicence = entCertUrlLicence;
	}
	public String getEntCertUrlLicenceFileName() {
		return entCertUrlLicenceFileName;
	}
	public void setEntCertUrlLicenceFileName(String entCertUrlLicenceFileName) {
		this.entCertUrlLicenceFileName = entCertUrlLicenceFileName;
	}
	public String getEntCertUrlLicenceContentType() {
		return entCertUrlLicenceContentType;
	}
	public void setEntCertUrlLicenceContentType(String entCertUrlLicenceContentType) {
		this.entCertUrlLicenceContentType = entCertUrlLicenceContentType;
	}
}