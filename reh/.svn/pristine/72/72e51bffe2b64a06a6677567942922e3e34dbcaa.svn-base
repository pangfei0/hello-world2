package com.news.spider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.common.DBHelper;
import com.ree.common.FileHelper;
import com.ree.common.StringUtil;
import com.ree.hibernate.RepAdminNews;
import com.ree.news.NewsDao;

public class SpiderAction extends ActionSupport {
	/**
	 * 输入
	 */
	private String src = "http://www.gs88591.com/List.aspx?type=5";
	private Boolean isDel = false;// 是否删除原数据
	private String wayToCompare = "submittime";// 匹配方式-提交时间（submittime）：查询提交时间以后；标题（titile）：遍历标题
	
	/**
	 * 输出
	 */
	private String message = "";
	
	private int statusCode;
	private String navTabId;

	private SpiderDao sDao = new SpiderDao();
	private RepAdminNews tBean;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 定时器
	 */
	private ServletContext context = null;
	
	/**
	 *
	* @Title: doExecute 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param context
	* @param @throws ParseException
	* @param @throws IOException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public String doExecute(ServletContext context) throws ParseException, IOException{
	    this.context = context;
	    this.execute();
	    return message;
	}
	public String execute() throws ParseException, IOException {
		List<RepAdminNews> list = new ArrayList<RepAdminNews>();
		List<RepAdminNews> OldList = new ArrayList<RepAdminNews>();
		Map map = new HashMap();

		try {
			// 数据源
			//String source = HttpRequestProxy.doPost(src, map, "utf-8"), viewstate, subpage, pagestring;
			String source = WebUtils.doGet(src), viewstate, subpage, pagestring;
			if (null == source) {
				System.out.println("null");
				return ERROR;
			}

			// 获得viewstate
			viewstate = source.substring(source
					.indexOf("id=\"__VIEWSTATE\" value=\"")
					+ "id=\"__VIEWSTATE\" value=\"".length());
			viewstate = viewstate.substring(0, viewstate.indexOf("\" />"));

			// 获得页码,页数
			pagestring = source.substring(source.indexOf("页码：1/")
					+ "页码：1/".length());
			pagestring = pagestring.substring(0, pagestring.indexOf("  每"));
			int pagenum = Integer.parseInt(pagestring);

			// 遍历页面
			for (int n = 1; n <= pagenum; n++) {
				// viewstate
				map.put("__VIEWSTATE", viewstate);
				// 控件对象
				map.put("__EVENTTARGET",
						"ctl00$ContentPlaceHolder1$AspNetPager1");
				// 控件值
				map.put("__EVENTARGUMENT", n);
				subpage = HttpRequestProxy
						.doPost("http://www.gs88591.com/List.aspx?type=5", map,
								"utf-8");
				subpage = subpage
						.substring(subpage
								.indexOf(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">")
								+ " <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
										.length());
				subpage = subpage.substring(0, subpage.indexOf("</table>"));

				int num = (subpage.split("</tr>").length) / 2;

				// 得到table
				for (String s : subpage.split("</tr>")) {
					if (s.trim().length() == 0)
						continue;
					s = StringUtil.replaceBlank(s).replaceAll(" {2,}", " ");
					RepAdminNews rBean = new RepAdminNews();
					// url
					rBean.setReserved01((s.substring(s.indexOf("<a href='")
							+ "<a href='".length(), s.indexOf("' target=\""))
							.trim()).toString());
					// title
					rBean.setNewsTitle(s.substring(
							s.indexOf("target=\"_blank\">")
									+ "target=\"_blank\">".length(),
							s.indexOf("<span id")).trim());
					// submittime
					rBean.setNewsSubmittime(sdf.parse((s.substring(
							s.indexOf("width=\"10%\">")
									+ "width=\"10%\">".length(),
							s.indexOf("</td>")))));
					// ordertime
					rBean.setNewsOrdertime(rBean.getNewsSubmittime());
					list.add(rBean);
				}
			}

			// 入库

			// OldList = sDao.Get_News_By_All(1);//list_id=1
			OldList = sDao.Get_News_By_Spider(1);
			if (!isDel) {
				// 追加式
				Boolean isContinue = true;
				int inserted = 0;
				for (RepAdminNews n : list) {
					isContinue = true;
					switch (wayToCompare) {
					case "submittime":
						// 提交时间
						if (OldList.size() > 0 && OldList.get(0).getNewsSubmittime() .before(n.getNewsSubmittime()))
						{
						    isContinue = true;
						    
						}
						else
							isContinue = false;
						break;
					case "title":
						// 标题
						for (RepAdminNews o : OldList) {
							if (o.getNewsTitle().contains(n.getNewsTitle())) {
								isContinue = false;
								break;
							}

						}
						break;
					default:
						break;
					}

					if (isContinue) {
						// add
						//n.setNewsOrdertime(new Date());
						// n.setNewsSubmittime(new Date());
						n.setNewsAuthor("抓取");
						n.setNewsListNo(1);

						// content
						String detail = WebUtils
								.doGet("http://www.gs88591.com/"
										+ n.getReserved01());
						// String detail =
						// HttpRequestProxy.doGet("http://www.gs88591.com/"+rBean.getReserved01(),
						// "utf-8");
						detail = detail.substring(
								detail.indexOf("id=\"divCon1\">")
										+ "id=\"divCon1\">".length()).trim();
						detail = StringUtil.replaceBlank(detail).replaceAll(
								" {2,}", " ");
						detail = detail
								.substring(
										0,
										detail.indexOf("</div> </div> <div style=\"padding-top:10px\">"));
						n.setNewsContent(detail);
						if(context==null)
						    sDao.Save(n);
						else
						    sDao.Save(n, context);//Timer
						inserted++;
					}

				}
				message +="插入" + inserted +"条<br/>";
				if(null==context)
				    FileHelper.writeLog("主动抓取:" + message);
				else
				    FileHelper.writeLog("自动抓取:" + message,context);
				//sDao.SaveBatch(list);
			} else {
				// 删除式
				sDao.DeleteBatch(OldList);
				/*
				 * for(RepAdminNews o : OldList){ sDao.Delete(o); }
				 */
				for (RepAdminNews n : list) {
					// add
					//n.setNewsOrdertime(new Date());
					n.setNewsAuthor("抓取");
					n.setNewsListNo(1);

					// content
					String detail = WebUtils.doGet("http://www.gs88591.com/"
							+ n.getReserved01());
					// String detail =
					// HttpRequestProxy.doGet("http://www.gs88591.com/"+rBean.getReserved01(),
					// "utf-8");
					detail = detail.substring(
							detail.indexOf("id=\"divCon1\">")
									+ "id=\"divCon1\">".length()).trim();
					detail = StringUtil.replaceBlank(detail).replaceAll(
							" {2,}", " ");
					detail = detail
							.substring(
									0,
									detail.indexOf("</div> </div> <div style=\"padding-top:10px\">")>0?
											detail.indexOf("</div> </div> <div style=\"padding-top:10px\">"):0);
					n.setNewsContent(detail);

					//sDao.Save(n);
				}
				sDao.SaveBatch(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message+= DBHelper.GetMsg(e);
			this.setMessage(message);
			this.setStatusCode(300);
			return SUCCESS;
		}
		this.setMessage(message + "成功抓取："+list.size()+"条");
		this.setNavTabId("nav01");
		this.setStatusCode(200);
		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public Boolean getIsDel() {
		return isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	public String getWayToCompare() {
		return wayToCompare;
	}

	public void setWayToCompare(String wayToCompare) {
		this.wayToCompare = wayToCompare;
	}

}
