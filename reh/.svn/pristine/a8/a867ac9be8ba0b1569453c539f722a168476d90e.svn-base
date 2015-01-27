package com.ree.dict;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.common.ScoreHelper;
import com.ree.hibernate.RepAdminEntEconomyDict;
import com.ree.hibernate.RepAdminEntScaleDict;
import com.ree.hibernate.RepAdminEntTradeDict;
import com.ree.hibernate.RepAdminSys;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepAdminJobAgeDict;
import com.ree.hibernate.RepAdminJobExpDict;
import com.ree.hibernate.RepAdminJobIntentionDict;
import com.ree.hibernate.RepAdminJobSalaryDict;
import com.ree.hibernate.RepAdminJobTypePriDict;
import com.ree.hibernate.RepAdminScoreDict;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntJobInfoViewId;


public class DictAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int jobintno;
	private String jobintname;
	private String jobinttype;
	private int jobintid;
	private int ruleid;
	private int alterNo;
	private int ruleNo;
	private String ruleName;
	private Integer ruleScore;
	private Integer ruleFor;
	private Integer ruletype;
	private String sensitive;
	private int banword=0;
	private int entcheck=0;
	private int jobcheck=0;
	private DictDao dDao=new DictDao();
	private List<RepAdminScoreDict> list;
	public List<RepAdminScoreDict> getList() {
		return list;
	}
	public void setList(List<RepAdminScoreDict> list) {
		this.list = list;
	}
	private HashMap<String, Object> store = new LinkedHashMap<String, Object>();
	
	public HashMap<String, Object> getStore() {
		return store;
	}
	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}
	private String message;
	private int statusCode;
	private String navTabId;
	
	public String Add() throws IOException, ParseException
	{
		String rs=null;
		RepAdminScoreDict rbean = new RepAdminScoreDict();
		rbean.setRuleNo(ruleNo);
		rbean.setReserved01(ruleName);
		rbean.setRuleScore(ruleScore);
		rbean.setRuleFor(ruleFor);
		rs=dDao.AddScoreDict(rbean);
		if(rs!=null){
			message="规则号重复";
			this.setStatusCode(300);
			this.setNavTabId("nav04");
			this.setMessage(message);
			return SUCCESS;
		}else{
			message="添加成功";
			this.setStatusCode(200);
			this.setNavTabId("nav04");
			this.setMessage(message);
			new ScoreHelper();//重置静态变量
			return SUCCESS;
		}
	}
	public String JobAgeAdd() throws IOException, ParseException
	{
		String rs=null;
		RepAdminJobAgeDict rbean = new RepAdminJobAgeDict();
		rbean.setAgeNo(ruleNo);
		rbean.setAgeName(ruleName);
		rs=dDao.AddJobAgeDict(rbean);
		if(rs!=null){
			message="规则号重复";
			this.setStatusCode(300);
			this.setNavTabId("nav03");
			this.setMessage(message);
			return SUCCESS;
		}else{
			message="添加成功";
			this.setStatusCode(200);
			this.setNavTabId("nav03");
			this.setMessage(message);
			return SUCCESS;
		}
	}
	public String JobExpAdd() throws IOException, ParseException
	{
		String rs=null;
		RepAdminJobExpDict rbean = new RepAdminJobExpDict();
		rbean.setJobExpDictNo(ruleNo);
		rbean.setJobExpDictName(ruleName);
		rs=dDao.AddJobExpDict(rbean);
		if(rs!=null){
			message="规则号重复";
			this.setStatusCode(300);
			this.setNavTabId("nav02");
			this.setMessage(message);
			return SUCCESS;
		}else{
			message="添加成功";
			this.setStatusCode(200);
			this.setNavTabId("nav02");
			this.setMessage(message);
			return SUCCESS;
		}
	}
	public String eduAdd() throws IOException, ParseException
	{
		String rs=null;
		RepAdminUserEducationDict rbean = new RepAdminUserEducationDict();
		rbean.setEducationDictNo(ruleNo);
		rbean.setEducationDictName(ruleName);
		rbean.setEducationDictType(ruletype);
		rs=dDao.AddeduDict(rbean);
		if(rs!=null){
			message="学历序号重复";
			this.setStatusCode(300);
			this.setNavTabId("nav03");
			this.setMessage(message);
			return SUCCESS;
		}else{
			message="添加成功";
			this.setStatusCode(200);
			this.setNavTabId("nav03");
			this.setMessage(message);
			return SUCCESS;
		}
	}
	public String JobAdd() throws IOException, ParseException
	{
		String rs=null;
		RepAdminJobIntentionDict rbean = new RepAdminJobIntentionDict();
		rbean.setJobIntentionDictNo(jobintno);
		rbean.setJobIntentionDictName(jobintname);
		rbean.setJobIntentionDictType(jobinttype);
		rs=dDao.JobAddScoreDict(rbean);
		if(rs!=null){
			message="序号重复";
			this.setStatusCode(300);
			this.setNavTabId("nav02");
			this.setMessage(message);
			return SUCCESS;
		}else{
			message="添加成功";
			this.setStatusCode(200);
			this.setNavTabId("nav02");
			this.setMessage(message);
			DictAdapter.RefrushIntentlist();
			return SUCCESS;
		}
	}
	public String JobSalaryAdd() throws IOException, ParseException
	{
		String rs=null;
		RepAdminJobSalaryDict rbean = new RepAdminJobSalaryDict();
		rbean.setJobSalaryDictNo(ruleNo);
		rbean.setJobSalaryDictName(ruleName);
		rs=dDao.JobSalaryAddDict(rbean);
		if(rs!=null){
			message="序号重复";
			this.setStatusCode(300);
			this.setNavTabId("nav01");
			this.setMessage(message);
			return SUCCESS;
		}else{
			message="添加成功";
			this.setStatusCode(200);
			this.setNavTabId("nav01");
			this.setMessage(message);
			return SUCCESS;
		}
	}
	public String JobTypePriAdd() throws IOException, ParseException
	{
		String rs=null;
		RepAdminJobTypePriDict rbean = new RepAdminJobTypePriDict();
		rbean.setJobTypePriDictNo(ruleNo);
		rbean.setJobTypePriDictName(ruleName);
		rs=dDao.JobTypePriAddDict(rbean);
		if(rs!=null){
			message="序号重复";
			this.setStatusCode(300);
			this.setNavTabId("nav07");
			this.setMessage(message);
			return SUCCESS;
		}else{
			message="添加成功";
			this.setStatusCode(200);
			this.setNavTabId("nav07");
			this.setMessage(message);
			return SUCCESS;
		}
	}
	public String ScaleAdd() throws IOException, ParseException
	{
		String rs=null;
		RepAdminEntScaleDict rbean = new RepAdminEntScaleDict();
		rbean.setScaleNo(ruleNo);
		rbean.setScaleName(ruleName);
		rs=dDao.ScaleAddDict(rbean);
		if(rs!=null){
			message="序号重复";
			this.setStatusCode(300);
			this.setNavTabId("nav08");
			this.setMessage(message);
			return SUCCESS;
		}else{
			message="添加成功";
			this.setStatusCode(200);
			this.setNavTabId("nav08");
			this.setMessage(message);
			return SUCCESS;
		}
	}
	public String EntTradeAdd() throws IOException, ParseException
	{
		String rs=null;
		RepAdminEntTradeDict rbean = new RepAdminEntTradeDict();
		rbean.setTradeNo(ruleNo);
		rbean.setTradeName(ruleName);
		rs=dDao.EntTradeAddDict(rbean);
		if(rs!=null){
			message="序号重复";
			this.setStatusCode(300);
			this.setNavTabId("nav09");
			this.setMessage(message);
			return SUCCESS;
		}else{
			message="添加成功";
			this.setStatusCode(200);
			this.setNavTabId("nav09");
			this.setMessage(message);
			return SUCCESS;
		}
	}
	public String EntEconomyAdd() throws IOException, ParseException
	{
		String rs=null;
		RepAdminEntEconomyDict rbean = new RepAdminEntEconomyDict();
		rbean.setEconomyNo(ruleNo);
		rbean.setEconomyName(ruleName);
		rs=dDao.EntEconomyAddDict(rbean);
		if(rs!=null){
			message="序号重复";
			this.setStatusCode(300);
			this.setNavTabId("nav10");
			this.setMessage(message);
			return SUCCESS;
		}else{
			message="添加成功";
			this.setStatusCode(200);
			this.setNavTabId("nav10");
			this.setMessage(message);
			return SUCCESS;
		}
	}
	public String Del() throws IOException, ParseException
	{
		String rs=null;
		dDao.DelScoreDict(ruleid);
		this.setMessage("删除成功");
		this.setNavTabId("nav04");
		this.setStatusCode(200);
		return SUCCESS;
	}
	public String eduDel() throws IOException, ParseException
	{
		String rs=null;
		dDao.DeleduDict(ruleid);
		this.setMessage("删除成功");
		this.setNavTabId("nav06");
		this.setStatusCode(200);
		return SUCCESS;
	}
	public String JobDel() throws IOException, ParseException
	{
		String rs=null;
		dDao.JobDelScoreDict(jobintid);
		this.setMessage("删除成功");
		this.setNavTabId("nav02");
		this.setStatusCode(200);
		DictAdapter.RefrushIntentlist();
		return SUCCESS;
	}
	public String JobAgeDel() throws IOException, ParseException
	{
		String rs=null;
		dDao.JobAgeDelDict(ruleid);
		this.setMessage("删除成功");
		this.setNavTabId("nav03");
		this.setStatusCode(200);
		return SUCCESS;
	}
	public String JobExpDel() throws IOException, ParseException
	{
		String rs=null;
		dDao.JobExpDelDict(ruleid);
		this.setMessage("删除成功");
		this.setNavTabId("nav02");
		this.setStatusCode(200);
		return SUCCESS;
	}
	public String JobSalaryDel() throws IOException, ParseException
	{
		String rs=null;
		dDao.JobSalaryDelDict(ruleid);
		this.setMessage("删除成功");
		this.setNavTabId("nav02");
		this.setStatusCode(200);
		return SUCCESS;
	}
	public String JobTypePriDel() throws IOException, ParseException
	{
		String rs=null;
		dDao.JobTypePriDelDict(ruleid);
		this.setMessage("删除成功");
		this.setNavTabId("nav07");
		this.setStatusCode(200);
		return SUCCESS;
	}
	public String ScaleDel() throws IOException, ParseException
	{
		String rs=null;
		dDao.ScaleDelDict(ruleid);
		this.setMessage("删除成功");
		this.setNavTabId("nav08");
		this.setStatusCode(200);
		return SUCCESS;
	}
	public String EntTradeDel() throws IOException, ParseException
	{
		String rs=null;
		dDao.EntTradeDelDict(ruleid);
		this.setMessage("删除成功");
		this.setNavTabId("nav09");
		this.setStatusCode(200);
		return SUCCESS;
	}
	public String EntEconomyDel() throws IOException, ParseException
	{
		String rs=null;
		dDao.EntEconomyDelDict(ruleid);
		this.setMessage("删除成功");
		this.setNavTabId("nav10");
		this.setStatusCode(200);
		return SUCCESS;
	}
	
/*	public String SeeAlter() throws IOException, ParseException
	{
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();

		list = dDao.GetScoreDict_By_ruleNo(alterNo);
		store.put("data", list);
		this.setStore(store);
			
		return SUCCESS;
	}*/
/*	public String SeeeduAlter() throws IOException, ParseException
	{
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		List<RepAdminEducationDict> list;
		list = dDao.GeteduDict_By_ruleNo(alterNo);
		store.put("data", list);
		this.setStore(store);
			
		return SUCCESS;
	}*/
/*	public String SeeJobAlter() throws IOException, ParseException
	{
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		List<RepAdminJobIntentionDict> list;
		list = dDao.GetJobIntDict_By_No(alterNo);
		store.put("data", list);
		this.setStore(store);
			
		return SUCCESS;
	}*/
	public String Alter() throws IOException, ParseException
	{
		RepAdminScoreDict rbean = new RepAdminScoreDict();
		rbean.setRuleNo(ruleNo);
		rbean.setReserved01(ruleName);
		rbean.setRuleScore(ruleScore);
		rbean.setRuleFor(ruleFor);
        dDao.UpdateScoreDict(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav04");
		this.setMessage(message);
		new ScoreHelper();//重置静态变量
		return SUCCESS;

	}
	public String JobAlter() throws IOException, ParseException
	{
		RepAdminJobIntentionDict rbean = new RepAdminJobIntentionDict();
		rbean.setJobIntentionDictNo(jobintno);
		rbean.setJobIntentionDictName(jobintname);
		rbean.setJobIntentionDictType(jobinttype);
        dDao.UpdateJobIntDict(rbean);
        DictAdapter.RefrushIntentlist();
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav02");
		this.setMessage(message);
		return SUCCESS;

	}
	public String eduAlter() throws IOException, ParseException
	{
		RepAdminUserEducationDict rbean = new RepAdminUserEducationDict();
		rbean.setEducationDictNo(ruleNo);
		rbean.setEducationDictName(ruleName);
		rbean.setEducationDictType(ruletype);
        dDao.UpdateeduDict(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav03");
		this.setMessage(message);
		return SUCCESS;

	}
	public String AgeJobAlter() throws IOException, ParseException
	{
		RepAdminJobAgeDict rbean = new RepAdminJobAgeDict();
		rbean.setAgeNo(ruleNo);
		rbean.setAgeName(ruleName);
        dDao.UpdateAgeJobDict(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav03");
		this.setMessage(message);
		return SUCCESS;

	}
	public String JobExpAlter() throws IOException, ParseException
	{
		RepAdminJobExpDict rbean = new RepAdminJobExpDict();
		rbean.setJobExpDictNo(ruleNo);
		rbean.setJobExpDictName(ruleName);
        dDao.UpdateAgeExpDict(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav03");
		this.setMessage(message);
		return SUCCESS;

	}
	public String JobSalaryAlter() throws IOException, ParseException
	{
		RepAdminJobSalaryDict rbean = new RepAdminJobSalaryDict();
		rbean.setJobSalaryDictNo(ruleNo);
		rbean.setJobSalaryDictName(ruleName);
        dDao.UpdateJobSalaryDict(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav03");
		this.setMessage(message);
		return SUCCESS;

	}
	public String JobTypePriAlter() throws IOException, ParseException
	{
		RepAdminJobTypePriDict rbean = new RepAdminJobTypePriDict();
		rbean.setJobTypePriDictNo(ruleNo);
		rbean.setJobTypePriDictName(ruleName);
		//need some parm
        dDao.UpdateJobTypePriDict(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav07");
		this.setMessage(message);
		return SUCCESS;

	}
	public String ScaleAlter() throws IOException, ParseException
	{
		RepAdminEntScaleDict rbean = new RepAdminEntScaleDict();
		rbean.setScaleNo(ruleNo);
		rbean.setScaleName(ruleName);
        dDao.UpdateScaleDict(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav08");
		this.setMessage(message);
		return SUCCESS;

	}
	public String EntTradeAlter() throws IOException, ParseException
	{
		RepAdminEntTradeDict rbean = new RepAdminEntTradeDict();
		rbean.setTradeNo(ruleNo);
		rbean.setTradeName(ruleName);
        dDao.UpdateEntTradeDict(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav09");
		this.setMessage(message);
		return SUCCESS;

	}
	public String EntEconomyAlter() throws IOException, ParseException
	{
		RepAdminEntEconomyDict rbean = new RepAdminEntEconomyDict();
		rbean.setEconomyNo(ruleNo);
		rbean.setEconomyName(ruleName);
        dDao.UpdateEntEconomyDict(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav10");
		this.setMessage(message);
		return SUCCESS;

	}
	public String banwordCheck() throws IOException, ParseException
	{
		RepAdminSys rbean = new RepAdminSys();
		rbean=dDao.GetBanwordCheck_By_Id(1);		
		rbean.setSysNo(rbean.getSysNo());
		if(banword==1){
			rbean.setSysState(banword);
		}else{
			rbean.setSysState(0);
		}
        dDao.UpdateBanWord(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav11");
		this.setMessage(message);
		return SUCCESS;
	}
	public String entCheck() throws IOException, ParseException
	{
		RepAdminSys rbean = new RepAdminSys();
		rbean=dDao.GetBanwordCheck_By_Id(2);		
		rbean.setSysNo(rbean.getSysNo());		
		rbean.setSysName("entcheck");
		if(entcheck==1){
			rbean.setSysState(entcheck);        
		}else{
			rbean.setSysState(0);  
		}
		dDao.UpdateBanWord(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav11");
		this.setMessage(message);
		return SUCCESS;
	}
	public String jobCheck() throws IOException, ParseException
	{
		RepAdminSys rbean = new RepAdminSys();
		rbean=dDao.GetBanwordCheck_By_Id(3);		
		rbean.setSysNo(rbean.getSysNo());
		rbean.setSysName("jobcheck");
		if(jobcheck==1){
			rbean.setSysState(jobcheck);
		}else{
			rbean.setSysState(0);
		}
        dDao.UpdateBanWord(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav11");
		this.setMessage(message);
		return SUCCESS;
	}
	public String updateSensitive() throws IOException, ParseException
	{
		RepAdminSys rbean = new RepAdminSys();
		rbean=dDao.GetBanwordCheck_By_Id(1);
		rbean.setSysNo(1);
		rbean.setSysValue(sensitive);
        dDao.UpdateBanWord(rbean);
		message="修改成功";
		this.setStatusCode(200);
		this.setNavTabId("nav11");
		this.setMessage(message);
		return SUCCESS;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public int getRuleNo() {
		return ruleNo;
	}


	public void setRuleNo(int ruleNo) {
		this.ruleNo = ruleNo;
	}


	public String getRuleName() {
		return ruleName;
	}


	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}


	public Integer getRuleScore() {
		return ruleScore;
	}


	public void setRuleScore(Integer ruleScore) {
		this.ruleScore = ruleScore;
	}


	public Integer getRuleFor() {
		return ruleFor;
	}


	public void setRuleFor(Integer ruleFor) {
		this.ruleFor = ruleFor;
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
	public int getRuleid() {
		return ruleid;
	}
	public void setRuleid(int ruleid) {
		this.ruleid = ruleid;
	}
	public int getAlterNo() {
		return alterNo;
	}
	public void setAlterNo(int alterNo) {
		this.alterNo = alterNo;
	}
	public int getJobintno() {
		return jobintno;
	}
	public void setJobintno(int jobintno) {
		this.jobintno = jobintno;
	}
	public String getJobintname() {
		return jobintname;
	}
	public void setJobintname(String jobintname) {
		this.jobintname = jobintname;
	}
	public String getJobinttype() {
		return jobinttype;
	}
	public void setJobinttype(String jobinttype) {
		this.jobinttype = jobinttype;
	}
	public int getJobintid() {
		return jobintid;
	}
	public void setJobintid(int jobintid) {
		this.jobintid = jobintid;
	}
	public Integer getRuletype() {
		return ruletype;
	}
	public void setRuletype(Integer ruletype) {
		this.ruletype = ruletype;
	}
	public Integer getBanword() {
		return banword;
	}
	public void setBanword(Integer banword) {
		this.banword = banword;
	}
	public Integer getEntcheck() {
		return entcheck;
	}
	public void setEntcheck(Integer entcheck) {
		this.entcheck = entcheck;
	}
	public Integer getJobcheck() {
		return jobcheck;
	}
	public void setJobcheck(Integer jobcheck) {
		this.jobcheck = jobcheck;
	}
	public String getSensitive() {
		return sensitive;
	}
	public void setSensitive(String sensitive) {
		this.sensitive = sensitive;
	}
	
}

