package com.ree.exportexcel;

import java.io.InputStream;    
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.enterprise.EntAdapter;
import com.ree.hibernate.RepEntInfoViewId;
import com.ree.hibernate.RepEntTrainUser;
import com.ree.hibernate.RepTrainNewsViewId;
import com.ree.hibernate.RepTrainUserViewId;
import com.ree.hibernate.RepUserInfo;
import com.ree.train.TrainAdapter;
import com.ree.user.UserAdapter;

public class ExcelAction extends ActionSupport {     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	SimpleDateFormat dfb = new SimpleDateFormat("yyyy-MM-dd");
	

	
	/*private TrainDao tDao = new TrainDao();*/
	
	/*数据流*/
    InputStream excelStream;
    
    /*输入*/
    private int list_id;
    private int news_id;
    private String orderField;
    private String orderDirection;
    

    
    /*输出*/
    private String filename;
       
 
    public String users() throws UnsupportedEncodingException{
    	IExcelService es = new ExcelServiceImpl();
    	String name = "培训报名人员_";
    	TrainAdapter ta = new TrainAdapter();

    	List<RepTrainUserViewId> tBeans = ta.GetUserBeans_By_All(news_id,orderField, orderDirection);
    	List<LinkedHashMap<String,Object>> list = new ArrayList<LinkedHashMap<String,Object>>();
    	for(RepTrainUserViewId tBean : tBeans){
    		LinkedHashMap<String,Object> data = new LinkedHashMap<String,Object>();    		
    		data.put("姓名", tBean.getUserName());
    		data.put("性别", tBean.getUserSex());
    		data.put("联系方式", tBean.getUserPhone());
    		list.add(data);
    	}
        excelStream = es.getExcelInputStream(list,null);
        this.setFilename(new String((name).getBytes("gbk"),"iso8859-1") + df.format(new Date()) + ".xls");
        return "excel";   
    }
    public String ents() throws UnsupportedEncodingException{
    	IExcelService es = new ExcelServiceImpl();
    	String name = "企业信息_";
    	EntAdapter ea = new EntAdapter();

    	List<RepEntInfoViewId> tBeans = ea.GetEntBeans_By_All();
    	List<LinkedHashMap<String,Object>> list = new ArrayList<LinkedHashMap<String,Object>>();
    	for(RepEntInfoViewId tBean : tBeans){
    		LinkedHashMap<String,Object> data = new LinkedHashMap<String,Object>();    		
    		data.put("企业名称", tBean.getEntName());
    		data.put("联系人", tBean.getEntContactMan());
    		data.put("联系电话", tBean.getEntContactPhone());
    		data.put("电子邮箱", tBean.getEntEmail());
    		data.put("联系地址", tBean.getEntContactAddr());
    		data.put("所属街道", tBean.getCommunityAddr());
    		data.put("经济类型", tBean.getEntTypeEconomyName());
    		data.put("行业类型", tBean.getEntTypeTradeName());
    		data.put("社保编号", tBean.getEntSercurityNum());
    		data.put("机构代码", tBean.getEntOCode());
    		list.add(data);
    	}
        excelStream = es.getExcelInputStream(list,null);
        this.setFilename(new String((name).getBytes("gbk"),"iso8859-1") + df.format(new Date()) + ".xls");
        return "excel";   
    }
    
    public String trains() throws UnsupportedEncodingException{
    	IExcelService es = new ExcelServiceImpl();
    	String name = "培训信息_";
    	TrainAdapter ta = new TrainAdapter();

    	List<RepTrainNewsViewId> tBeans = ta.GetTrainBeans_By_All(list_id,orderField, orderDirection);
    	List<LinkedHashMap<String,Object>> list = new ArrayList<LinkedHashMap<String,Object>>();
    	for(RepTrainNewsViewId tBean : tBeans){
    		LinkedHashMap<String,Object> data = new LinkedHashMap<String,Object>();    		
    		data.put("培训名称", tBean.getNewsTitle());
    		data.put("作者", tBean.getNewsAuthor());
    		data.put("发布时间", tBean.getNewsSubmittime());
    		data.put("发布时间", df.format(tBean.getNewsSubmittime()));
    		data.put("报名人数", String.valueOf(tBean.getUserCount()));    
    		list.add(data);
    	}
        excelStream = es.getExcelInputStream(list,null);
        this.setFilename(new String((name).getBytes("gbk"),"iso8859-1") + df.format(new Date()) + ".xls");
        return "excel";   
    }
    public String allUsers() throws UnsupportedEncodingException{
    	IExcelService es = new ExcelServiceImpl();
    	String name = "人才库_";
    	UserAdapter ua = new UserAdapter();

    	List<RepUserInfo> tBeans = ua.Get_All_User_By_All();
    	List<LinkedHashMap<String,Object>> list = new ArrayList<LinkedHashMap<String,Object>>();
    	for(RepUserInfo tBean : tBeans){
    		LinkedHashMap<String,Object> data = new LinkedHashMap<String,Object>();    		
    		data.put("姓名", tBean.getUserName());
    		data.put("性别", tBean.getUserSex());
    		data.put("家庭地址", tBean.getUserAddrPos());
    		data.put("联系方式", tBean.getUserPhone());
    		data.put("身份证号", tBean.getUserCert());
    		/*data.put("学历", tBean.getRepAdminEducationDict().getEducationDictName());*/
    		data.put("邮件", tBean.getUserEmail());
    		/*data.put("所属街道", tBean.getRepAdminCommunityInfo().getCommunityName());*/
    		data.put("求职意向", tBean.getUserIntention());
    		data.put("专长", tBean.getUserSkill());
    		list.add(data);
    	}
        excelStream = es.getExcelInputStream(list,null);
        this.setFilename(new String((name).getBytes("gbk"),"iso8859-1") + df.format(new Date()) + ".xls");
        return "excel";   
    }
	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	/**
	 * @return the m
	 */
	
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the orderField
	 */
	public String getOrderField() {
		return orderField;
	}

	/**
	 * @param orderField the orderField to set
	 */
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	/**
	 * @return the orderDirection
	 */
	public String getOrderDirection() {
		return orderDirection;
	}
	/**
	 * @param orderDirection the orderDirection to set
	 */
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public int getList_id() {
		return list_id;
	}


	public void setList_id(int list_id) {
		this.list_id = list_id;
	}


	public int getNews_id() {
		return news_id;
	}


	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	

}  
