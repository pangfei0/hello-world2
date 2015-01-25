package com.ree.news;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.common.DBHelper;
import com.ree.dict.DictDao;
import com.ree.hibernate.RepAdminList;
import com.ree.hibernate.RepAdminNews;
import com.ree.news.NewsDao;

/**
 * 
 * <p>Title: NewsAction<／p>
 * <p>Description:处理新闻的增加，修改 <／p> 
 * @author 李丁
 * @date 2014年7月15日
 */
public class NewsAction extends ActionSupport{
	
	/**
	 * 输入
	 */
	private int id = 0;
	private int list_id;
	private String title;
	private String author;
	private String submittime;
	private String ordertime;
	private String trainEndtime;
	private String content;
	private String method;

	/**
	 * 输出
	 */
	private String message;
	private int statusCode;
	private String navTabId;

	/**
	 * listadapter
	 */
	/*private ListAdapter la = new ListAdapter();*/
	/**
	 * Dao
	 */
	private NewsDao nDao = new NewsDao();
	/**
	 * bean
	 */
	private RepAdminNews nBean = new RepAdminNews();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String execute() throws IOException, ParseException
	{
		/**
		 * 验证超时
		 */
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
       /* if(!session.get("admin_type").equals("1")&&(id==0?(la.GetListBean_by_list_id(list_id).getType()!=(Integer.parseInt(session.get("admin_type").toString())))
        		:!(nDao.GetNewsItem_By_NewsId(id).getAuthor()
        		.equals(session.get("admin_uid")))))//求职意向允许一般用户提交
		{
			this.setMessage("权限错误");
			this.setStatusCode(300);
			return SUCCESS;
		}
		if(session.get("admin_uid")==null)
		{
			this.setMessage("登陆超时");
			this.setStatusCode(301);
			return SUCCESS;
		}	*/
		String message = null;
		/**
		 * 包装
		 */
		String imgurl = null;
		if(content!=null&&content.contains("<img src=\"")){
			imgurl=content.contains("<img src=\"")?content.substring(content.indexOf("<img src=\"") + 10, content.indexOf("\" ",10 + content.indexOf("<img src=\""))):"";
		}
		nBean.setNewsNo(id);
		nBean.setNewsTitle(title);
		nBean.setNewsAuthor(author);
		nBean.setNewsContent(StringEscapeUtils.escapeHtml4(content));
		nBean.setNewsImgurl(StringEscapeUtils.escapeHtml4(imgurl));
		nBean.setNewsListNo(list_id);
		
		//时间验证
		if(ordertime!=null&&submittime.length()>0&&trainEndtime!=null){
			nBean.setNewsOrdertime(sdf.parse(ordertime));
			nBean.setNewsSubmittime(sdf.parse(submittime));
			nBean.setNewsTrainEndtime(sdf.parse(trainEndtime));
		}
		if(trainEndtime!=null&&sdf.parse(trainEndtime).getTime()<sdf.parse(submittime).getTime())
		{
			this.setMessage("截止日期不能小于发布日期");
			this.setStatusCode(300);
		}else if(method!=null&&method.equals("del")&& String.valueOf(id).length()!=0&&id!=0){
			/**
			 * 删除新闻
			 */
			try{
				message = nDao.Del_News_By_id(id);
			}
			catch(Exception e){
				message += e.getMessage()==null?e.getClass():e.getMessage();
			}
			if(message==null)
			{
				this.setMessage("删除成功");
				this.setStatusCode(200);
			}
			else
			{
				this.setMessage("删除失败\n"+message);
				this.setStatusCode(300);
			}
		}		
		else if ((String.valueOf(id).length()==0||id==0)&&title!=null){
			/**
			 * 新增新闻
			 */
		    String sc = null;
			DictDao dDao = new DictDao();
			String bandWord[] = DBHelper.GetSysValue_By_Name("banword", dDao.GetSysDict()).split(",");
			for (String w : bandWord) {
	            if (content.indexOf(w)>=0){
	            	sc = content.indexOf(w)+"处存在敏感词"+w;
	            	break;		            
	            }			        				
			}
			if(sc!=null){
				this.setMessage("新增失败\n"+sc);
				this.setStatusCode(300);
			}else{
				try{
					message = nDao.Add_News_By_Bean(nBean);
				}catch(Exception e){
					message += e.getMessage()==null?e.getClass():e.getMessage();
				}
				if(message==null)
				{
					this.setMessage("新增成功");
					this.setNavTabId("NewsItems");
					this.setStatusCode(200);
				}
				else
				{
					this.setMessage("新增失败\n"+message);
					this.setStatusCode(300);
				}
			}
		}	
		else if(String.valueOf(id).length()!=0&&id!=0){
			/**
			 * 修改新闻
			 */
			 String sc = null;
				DictDao dDao = new DictDao();
				String bandWord[] = DBHelper.GetSysValue_By_Name("banword", dDao.GetSysDict()).split(",");
				for (String w : bandWord) {
		            if (content.indexOf(w)>=0){
		            	sc = content.indexOf(w)+"处存在敏感词"+w;
		            	break;		            
		            }			        				
				}
				if(sc!=null){
					this.setMessage("更新失败\n"+sc);
					this.setStatusCode(300);
				}else{
					try{
						message = nDao.Update_News_By_Bean(nBean);
					}
					catch(Exception e){
						message += e.getMessage()==null?e.getClass():e.getMessage();
					}
					if(message==null)
					{
						this.setMessage("更新成功");
						this.setNavTabId("NewsItems");
						this.setStatusCode(200);
					}
					else
					{
						this.setMessage("更新失败\n"+message);
						this.setStatusCode(300);
					}
				}
		}
		else
		{
			this.setMessage("错误的操作\n"+message);
			this.setStatusCode(300);
		}
		return SUCCESS;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the submittime
	 */
	public String getSubmittime() {
		return submittime;
	}

	/**
	 * @param submittime the submittime to set
	 */
	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}

	/**
	 * @return the ordertime
	 */
	public String getOrdertime() {
		return ordertime;
	}

	/**
	 * @param ordertime the ordertime to set
	 */
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return the list_id
	 */
	public int getList_id() {
		return list_id;
	}

	/**
	 * @param list_id the list_id to set
	 */
	public void setList_id(int list_id) {
		this.list_id = list_id;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
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

	public String getTrainEndtime() {
		return trainEndtime;
	}

	public void setTrainEndtime(String trainEndtime) {
		this.trainEndtime = trainEndtime;
	}

}

