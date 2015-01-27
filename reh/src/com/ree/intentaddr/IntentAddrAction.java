package com.ree.intentaddr;

import java.sql.SQLException;
import java.util.LinkedHashMap;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.hibernate.RepAdminCommunityInfo;
import com.ree.hibernate.RepAdminIntentAddrDict;



public class IntentAddrAction extends ActionSupport{

	
		/**
		 * 输入
		 */
		private String actionmethod;
		private String txtname;
		private int id;
		private int newlevel;
		private int newfatherid;
		private String txtaddr;
		
		/**
		 * 输出
		 */
		private String message;
		private int statusCode;
		private String navTabId;
		private LinkedHashMap<String, Object> res;
		
		String rs=null;
		
		/**
		 * bean
		 */
		private RepAdminIntentAddrDict cBean =new RepAdminIntentAddrDict();
		
		/**
		 * dao
		 */
		private IntentAddrDao cDao = new IntentAddrDao();
		
		public String execute() throws SQLException{
			//校验
			if(actionmethod.equals("alter") ||actionmethod.equals("del")){
			cBean=cDao.GetAddr_By_id(id);}
			if(actionmethod ==null ||actionmethod.length()==0)
			{
				this.setMessage("错误的操作\n"+message);
				this.setStatusCode(300);
			}
			/**
			 * 包装
			 */
			cBean.setIntentAddrName(txtname);
			cBean.setIntentAddrLever(newlevel);
			if(actionmethod.equals("add")||actionmethod.equals("del")){
			cBean.setIntentFatherNo(newfatherid); }
			//cBean.setIntentAddr(txtaddr);
			
			if(actionmethod.equals("alter"))
			{
				
				rs= cDao.UpdateIntentAddr_By_Bean(cBean);
				
				if(rs==null)
				{
					this.setMessage("更新" + txtname + "成功");
					this.setNavTabId("treeinfo");//刷新
					this.setStatusCode(200);
				}
				else
				{
					this.setMessage("更新失败\n"+rs);
					this.setStatusCode(300);
				}
			}
			else if(actionmethod.equals("add")){
				rs = cDao.AddIntentAddr_By_Bean(cBean);
				
				if(rs==null)
				{
					this.setMessage("添加" + txtname +"成功");
					this.setNavTabId("treeinfo");//刷新
					this.setStatusCode(200);
				}
				else
				{
					this.setMessage("添加失败\n"+rs);
					this.setStatusCode(300);
				}
				
			}
			else if(actionmethod.equals("del")){
				if(cBean.getIntentAddrNo()==0)
				{
					this.setMessage("没有选中节点！");
					this.setStatusCode(300);
					return SUCCESS;
				}
				rs = cDao.DelIntentAddr_By_Bean(cBean.getIntentAddrNo());
				
				if(rs==null)
				{
					this.setMessage("删除" + txtname );
					this.setNavTabId("treeinfo");//刷新
					this.setStatusCode(200);
				}
				else
				{
					this.setMessage("删除失败\n"+rs);
					this.setStatusCode(300);
				}
			}
			else{
				this.setMessage("错误的操作\n"+rs);
				this.setStatusCode(300);
			}


			return SUCCESS;
		}

		/**
		 * @return the newlevel
		 */
		public int getNewlevel() {
			return newlevel;
		}

		/**
		 * @param newlevel the newlevel to set
		 */
		public void setNewlevel(int newlevel) {
			this.newlevel = newlevel;
		}

		/**
		 * @return the newfatherid
		 */
		public int getNewfatherid() {
			return newfatherid;
		}

		/**
		 * @param newfatherid the newfatherid to set
		 */
		public void setNewfatherid(int newfatherid) {
			this.newfatherid = newfatherid;
		}

		/**
		 * @return the message
		 */
		public String getMessage() {
			return message;
		}

		/**
		 * @param message the message to set
		 */
		public void setMessage(String message) {
			this.message = message;
		}

		/**
		 * @return the statusCode
		 */
		public int getStatusCode() {
			return statusCode;
		}

		/**
		 * @param statusCode the statusCode to set
		 */
		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		/**
		 * @return the cBean
		 */
		public RepAdminIntentAddrDict getcBean() {
			return cBean;
		}

		/**
		 * @param cBean the cBean to set
		 */
		public void setcBean(RepAdminIntentAddrDict cBean) {
			this.cBean = cBean;
		}

		/**
		 * @return the txtname
		 */
		public String getTxtname() {
			return txtname;
		}

		/**
		 * @param txtname the txtname to set
		 */
		public void setTxtname(String txtname) {
			this.txtname = txtname;
		}

		/**
		 * @return the txtaddr
		 */
		public String getTxtaddr() {
			return txtaddr;
		}

		/**
		 * @param txtaddr the txtaddr to set
		 */
		public void setTxtaddr(String txtaddr) {
			this.txtaddr = txtaddr;
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @return the actionmethod
		 */
		public String getActionmethod() {
			return actionmethod;
		}

		/**
		 * @param actionmethod the actionmethod to set
		 */
		public void setActionmethod(String actionmethod) {
			this.actionmethod = actionmethod;
		}

		/**
		 * @return the navTabId
		 */
		public String getNavTabId() {
			return navTabId;
		}

		/**
		 * @param navTabId the navTabId to set
		 */
		public void setNavTabId(String navTabId) {
			this.navTabId = navTabId;
		}

	}



