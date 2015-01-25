package com.reh.Regist;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.ree.common.DBHelper;
import com.ree.common.FileHelper;
import com.ree.hibernate.RepAdminCommunityInfo;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepAdminJobIntentionDict;
import com.ree.hibernate.RepAdminList;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntInfoViewId;
import com.ree.hibernate.RepUserInfo;
import com.ree.hibernate.RepUserInfoViewId;

public class UserAction extends ActionSupport {
	//
	private RepAdminCommunityInfo repAdminCommunityInfo;
	private RepAdminJobIntentionDict repAdminJobIntentionDict;
	private RepAdminUserEducationDict repAdminEducationDict;
	RepUserInfo userbean = new RepUserInfo();
	private String USER_NAME;
	private String USER_SEX;
	private String USER_CERT;
	private String USER_RESIDENCE;
	private int USER_ADDR_DIS_NO;
	private String USER_ADDR_POS;
	private int USER_EDUCATION_NO;;
	private String USER_INTENTION;
	private String USER_PHONE;
	private String USER_SKILL;
	private String RESERVED01;
	private int NO;
	private String USER_UID;
	private String USER_PWD;
	private String USER_PWD1;
	private String USER_EMAIL;

	private String username = null;
	private String password = null;
	private int u_type;

	/**
	 * 履历
	 */
	private String byNowStartTime = null;
	private String byNowEndTime = null;
	private String byNowContent = null;
	
	private String sc = null;

//	private LoginDao lDao = new LoginDao();

	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 
	 * @Title: Login
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	/*public String Login() throws Exception {
		String uname = getUsername();
		String pwd = DBHelper.MD5(getPassword());
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		if (session.get("u_type") != null)// 已经登录
		{
			this.setUsername((String) session.get("USER_NAME"));
			setSc("已登陆");
			if(Integer.parseInt(session.get("u_type").toString())==1)
				return "entSuc";
			return SUCCESS;
		} else if (uname == null || pwd == null)// 用户名和密码为空
		{
			setSc("用户名和密码为空");
			return ERROR;
		}
		LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) lDao
				.checkLogin(uname, pwd, u_type);
		if (data.isEmpty() || data.get("success")=="false") {// 登录不成功
			setSc("用户名或密码错误");
			return ERROR;
		}else if(data.get("success")=="notpass"){
			setSc("请等待审核通过!");
			return ERROR;
		}
		if (u_type == 0 && data.get("success")=="true") {
			RepUserInfoViewId userview = (RepUserInfoViewId) data.get("view");
			RepUserInfo u = (RepUserInfo) data.get("bean");
			session.put("userbean", u);
			session.put("view", userview);
			session.put("u_type", u_type);
			session.put("lastTime", userview==null?"":userview.getReserved02());
			setSc("一般用户，欢迎登录");
			
			//u.setReserved02(formatter.format(new Date()));
			//lDao.Update(userbean);
			
			FileHelper.writeLog("一般用户登录_" + u.getUserName());
			return SUCCESS;
		} else if (u_type == 1 && data.get("success")=="true") {
			RepEntInfoViewId entview = (RepEntInfoViewId) data.get("view");
			RepEntInfo e = (RepEntInfo) data.get("bean");
			session.put("entbean", e);
			session.put("view", entview);
			session.put("u_type", u_type);
			session.put("lastTime", e.getReserved01());
			setSc("企业用户，欢迎登录");
			e.setReserved01(formatter.format(new Date()));
			lDao.Update(e);
			
			FileHelper.writeLog("企业用户登录_" + e.getEntName());
			return "entSuc";
		}
		return ERROR;
	}
*/
	/**
	 * 
	 * @Title: Logout
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	/*public String Logout() throws Exception {
		String log = "";
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
		if(session.get("userbean")!=null){
			RepUserInfo sessionbean = (RepUserInfo)session.get("userbean");
			log += "一般用户："+ sessionbean.getUserName();
		}
		if(session.get("entbean")!=null){
			RepEntInfo sessionbean = (RepEntInfo)session.get("entbean");
			log += "企业用户："+ sessionbean.getEntName();
		}
		session.clear();
		setSc("退出登录");
		
		FileHelper.writeLog("退出登录_" + log);
		return "success";
	}
	public String Modify(){
		Pattern email = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");		
		
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        sc = "";
        
		try{
			if(session.get("u_type")==null)
				throw new Exception("未登录");
			if (userbean.getUserName() == null
					|| userbean.getUserName().trim().equals(""))
				throw new Exception("姓名不能为空");
			if (userbean.getUserAge() == null
					|| userbean.getUserAge()<=0)
				throw new Exception("年龄为空或输入不正确");
			if (userbean.getUserEmail() == null
					|| userbean.getUserEmail().trim().equals(""))
				throw new Exception("邮箱不能为空");
			if(userbean.getUserIntentDisNo()== null
					|| userbean.getUserIntentDisNo().trim().equals(""))
				throw new Exception("意向地址不能为空");
			if(userbean.getUserAddrDisNo()== null 
					|| userbean.getUserAddrDisNo()== 0 )
				throw new Exception("所属街道不能为空");
			Matcher matcher = email.matcher(userbean.getUserEmail().trim());
			if(!matcher.matches())
				throw new Exception("邮箱格式不正确");
			if(userbean.getUserPhone()==null||"".equals(userbean.getUserPhone())
					||(!userbean.getUserPhone().matches(("\\d{4}-\\d{8}|\\d{4}-\\d{7}|\\d(3)-\\d(8)"))
					&&!userbean.getUserPhone().matches("^[1][3,5,7,8,9]+\\d{9}")))
				throw new Exception("联系电话为空或不正确");
			if(userbean.getUserCert()==null||"".equals(userbean.getUserCert())
					||!userbean.getUserCert().matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$"))
				throw new Exception("身份证为空或格式不正确");
			//组装履历
			String byNow = "";
			if(byNowStartTime == null || byNowEndTime ==null || byNowContent==null ||"".equals(byNowStartTime) || "".equals(byNowEndTime) ||"".equals(byNowContent)
					||byNowContent.split(", ").length!=byNowStartTime.split(", ").length||
					byNowEndTime.split(", ").length!=byNowContent.split(", ").length)
				throw new Exception("履历不完整");
			else{
				for(int i = 0;i<byNowStartTime.split(", ").length;i++){
					byNow += byNowStartTime.split(", ")[i] + "★" + byNowEndTime.split(", ")[i] + "☆" + byNowContent.split(", ")[i] + "■";
				}
			}
			UserDao uDao = new UserDao();
			RepUserInfo sessionbean = (RepUserInfo)session.get("userbean");
			RepUserInfo oldbean = (RepUserInfo)uDao.getBean(RepUserInfo.class, sessionbean.getUserNo());
			userbean.setUserIntention(userbean.getUserIntention().replaceAll(" ", ""));
			userbean.setUserPwd(oldbean.getUserPwd());
			
			userbean.setUserNo(oldbean.getUserNo());
			userbean.setUserUid(oldbean.getUserUid());
			userbean.setUserBynow(byNow);
			uDao.Update(userbean);
			session.put("userbean",userbean);
			sc = "修改成功";
		}
		catch(Exception e){
			sc+= DBHelper.GetMsg(e);
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}*/
	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: execute
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@InputConfig(methodName = "inputRegister", resultName = "Register_input")
	public String Register() throws Exception {
		if (USER_NAME == null)
			return "error";
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		// get访问
		RepUserInfo userbean = new RepUserInfo();
		UserDao uDao = new UserDao();
		// userbean.setUserNo(dao1.GetTotalCount()+1);
		userbean.setUserName(getUSER_NAME());
		userbean.setUserUid(getUSER_UID());
		userbean.setUserPwd(DBHelper.MD5(getUSER_PWD()));
		userbean.setUserEmail(getUSER_EMAIL());
		userbean.setUserSex(this.getUSER_SEX());
		String message = uDao.AddUser_by_Bean(userbean);
		if (message != null) {
			this.setSc(message);
			return "ERROR";
		} else {
			this.setSc("注册成功！");
			session.put("userbean", userbean);
			RepUserInfoViewId view = uDao.GetUserView_By_UserNo(userbean.getUserNo());
			session.put("view", view);
			session.put("u_type", 0);//0-user;1-ent
			session.put("lastTime", view==null?"":view.getReserved02());
			return "SUCCESS";
		}
	}

	/**
	 * 
	 * @Title: validateRegister
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void validateRegister() {
		Pattern email = Pattern
				.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

		if (this.getUSER_UID() == null || getUSER_UID().trim().equals(""))
			addFieldError("USER_UID", "用户名不能为空");
		if (this.getUSER_PWD() == null || getUSER_PWD().trim().equals(""))
			addFieldError("USER_PWD", "密码不能为空");
		if (this.getUSER_PWD1() == null
				|| !this.getUSER_PWD().equals(this.getUSER_PWD1()))
			addFieldError("USER_PWD1", "密码不一致");
		if (this.getUSER_EMAIL() == null || getUSER_EMAIL().trim().equals(""))
			addFieldError("USER_EMAIL", "邮箱不能为空");
		else {
			Matcher matcher = email.matcher(getUSER_EMAIL().trim());
			if (!matcher.matches())
				addFieldError("USER_EMAIL", "邮箱格式不正确");
		}

	}

	public String inputRegister() {
		return "Register_input";
	}

	/**
	 * 
	 * @Title: UserAction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	// public String UserAction() throws Exception {
	// // TODO Auto-generated constructor stub
	// userInformationDao dao=new userInformationDao();
	// UserDao dao1=new UserDao();
	// repAdminCommunityInfo=dao.getRepAdminCommunityInfo(this.getUSER_ADDR_DIS_NO());
	// repAdminEducationDict=dao.getRepAdminEducationDict(this.getUSER_EDUCATION_NO());
	// userbean=(RepUserInfo)
	// ActionContext.getContext().getSession().get("userbean");
	// // RepUserInfo userbean=dao1.GetUserBean_By_USER_NO(this.getNO());
	// userbean.setUserName(this.getUSER_NAME());
	// userbean.setUserSex(this.getUSER_SEX());
	// userbean.setUserCert(this.getUSER_CERT());
	// userbean.setUserAddrPos(this.getUSER_ADDR_POS());
	// userbean.setUserIntention(dao.getRepAdminJobIntentionDictNames(this.getUSER_INTENTION()));
	// userbean.setRepAdminCommunityInfo(repAdminCommunityInfo);
	// userbean.setRepAdminEducationDict(repAdminEducationDict);
	// userbean.setUserPhone(this.getUSER_PHONE());
	// userbean.setUserResidence(this.getUSER_RESIDENCE());
	// userbean.setUserSkill(this.getUSER_SKILL());
	// userbean.setReserved01(this.getRESERVED01());
	// userbean.setUserName(this.getUSER_NAME());
	// dao1.Update_User_By_Bean(userbean);
	// ActionContext.getContext().getSession().put("userbean", userbean);
	// if(userbean.getUserName().equals(this.getUSER_NAME()))
	// {
	// return "SUCCESS";
	// }
	// else
	// return "ERROR";
	// }

	public String getUSER_PWD1() {
		return USER_PWD1;
	}

	public void setUSER_PWD1(String uSER_PWD1) {
		USER_PWD1 = uSER_PWD1;
	}

	public String getUSER_UID() {
		return USER_UID;
	}

	public void setUSER_UID(String uSER_UID) {
		USER_UID = uSER_UID;
	}

	public String getUSER_PWD() {
		return USER_PWD;
	}

	public void setUSER_PWD(String uSER_PWD) {
		USER_PWD = uSER_PWD;
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_SEX() {
		return USER_SEX;
	}

	public void setUSER_SEX(String uSER_SEX) {
		USER_SEX = uSER_SEX;
	}

	public String getUSER_CERT() {
		return USER_CERT;
	}

	public void setUSER_CERT(String uSER_CERT) {
		USER_CERT = uSER_CERT;
	}

	public String getUSER_RESIDENCE() {
		return USER_RESIDENCE;
	}

	public void setUSER_RESIDENCE(String uSER_RESIDENCE) {
		USER_RESIDENCE = uSER_RESIDENCE;
	}

	public int getUSER_ADDR_DIS_NO() {
		return USER_ADDR_DIS_NO;
	}

	public void setUSER_ADDR_DIS_NO(int uSER_ADDR_DIS_NO) {
		USER_ADDR_DIS_NO = uSER_ADDR_DIS_NO;
	}

	public String getUSER_ADDR_POS() {
		return USER_ADDR_POS;
	}

	public void setUSER_ADDR_POS(String uSER_ADDR_POS) {
		USER_ADDR_POS = uSER_ADDR_POS;
	}

	public int getUSER_EDUCATION_NO() {
		return USER_EDUCATION_NO;
	}

	public void setUSER_EDUCATION_NO(int uSER_EDUCATION_NO) {
		USER_EDUCATION_NO = uSER_EDUCATION_NO;
	}

	public String getUSER_INTENTION() {
		return USER_INTENTION;
	}

	public void setUSER_INTENTION(String uSER_INTENTION) {
		USER_INTENTION = uSER_INTENTION;
	}

	public String getUSER_PHONE() {
		return USER_PHONE;
	}

	public void setUSER_PHONE(String uSER_PHONE) {
		USER_PHONE = uSER_PHONE;
	}

	public String getUSER_SKILL() {
		return USER_SKILL;
	}

	public void setUSER_SKILL(String uSER_SKILL) {
		USER_SKILL = uSER_SKILL;
	}

	public String getRESERVED01() {
		return RESERVED01;
	}

	public void setRESERVED01(String rESERVED01) {
		RESERVED01 = rESERVED01;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	public int getU_type() {
		return u_type;
	}

	public void setU_type(int u_type) {
		this.u_type = u_type;
	}

	public RepUserInfo getUserbean() {
		return userbean;
	}

	public void setUserbean(RepUserInfo userbean) {
		this.userbean = userbean;
	}

	public String getByNowStartTime() {
		return byNowStartTime;
	}

	public void setByNowStartTime(String byNowStartTime) {
		this.byNowStartTime = byNowStartTime;
	}

	public String getByNowEndTime() {
		return byNowEndTime;
	}

	public void setByNowEndTime(String byNowEndTime) {
		this.byNowEndTime = byNowEndTime;
	}

	public String getByNowContent() {
		return byNowContent;
	}

	public void setByNowContent(String byNowContent) {
		this.byNowContent = byNowContent;
	}

}
