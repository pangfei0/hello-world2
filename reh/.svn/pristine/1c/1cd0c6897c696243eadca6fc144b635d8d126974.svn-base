package com.reh.Regist;

import java.util.LinkedHashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.reh.Regist.EntDao;
import com.reh.user.LoginDao;
import com.ree.common.DBHelper;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntInfoViewId;

public class EntRegist2 extends ActionSupport {
	private RepEntInfo entBean = new RepEntInfo();
	private EntDao eDao = new EntDao();
	LoginDao lDao = new LoginDao();
	/*
	 * 
	 * 输出
	                        身份类型
			企业名称： *
			用户名： *
			密       码： *
			电子邮件： *
			企业类型： *
			所属街道： *
			请点击并选择

	 */
	        private  int u_type;
			private String entName;
		    private String entUid;
		    private String entPwd;
		    private String entEmail;
		    private String entType;
		    private String entContactAddr;
    /*
     * 输出
     * 
     */
		    private boolean status;
		    private String mes;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		LinkedHashMap<String, Object> data ;
		entPwd=DBHelper.MD5(entPwd);
		entBean.setEntName(entName);
		entBean.setEntEmail(entEmail);
		entBean.setEntPwd(entPwd);
		entBean.setEntUid(entUid);
		entBean.setEntType(entType);
		entBean.setEntContactAddr(entContactAddr);
		String message = eDao.Add_EntInfo_By_Bean(entBean);
		if (message != null) {
			this.setMes(message);
			this.setStatus(false);
			return SUCCESS;
		}else{
			data= (LinkedHashMap<String, Object>) lDao.checkLogin(entUid, entPwd, u_type);
			RepEntInfoViewId entview = (RepEntInfoViewId) data.get("view");
			RepEntInfo e = (RepEntInfo) data.get("bean");
			session.put("entbean", e);
			session.put("view", entview);
			session.put("u_type", u_type);
			session.put("lastTime", e.getReserved01());
			mes = "申请成功，请等待审核";
			this.setStatus(true);
			return SUCCESS;
		}
		
	}
	public int getU_type() {
		return u_type;
	}
	public void setU_type(int u_type) {
		this.u_type = u_type;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getEntUid() {
		return entUid;
	}
	public void setEntUid(String entUid) {
		this.entUid = entUid;
	}
	public String getEntPwd() {
		return entPwd;
	}
	public void setEntPwd(String entPwd) {
		this.entPwd = entPwd;
	}
	public String getEntEmail() {
		return entEmail;
	}
	public void setEntEmail(String entEmail) {
		this.entEmail = entEmail;
	}
	public String getEntType() {
		return entType;
	}
	public void setEntType(String entType) {
		this.entType = entType;
	}
	public String getEntContactAddr() {
		return entContactAddr;
	}
	public void setEntContactAddr(String entContactAddr) {
		this.entContactAddr = entContactAddr;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}

}
