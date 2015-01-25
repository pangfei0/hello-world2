package com.ree.hibernate;

// Generated 2015-1-23 22:08:29 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * RepUserCompany generated by hbm2java
 */
public class RepUserCompany implements java.io.Serializable {

	private int gid;
	private int userno;
	private String corname;
	private String cornature;
	private String corscale;
	private String corindustry;
	private String department;
	private String report;
	private Integer subordinate;
	private String jobname;
	private Date worktime;
	private String workaddr;
	private String summary;
	private String jobperformance;
	private String reserved01;
	private String reserved02;

	public RepUserCompany() {
	}

	public RepUserCompany(int gid, int userno, String corname) {
		this.gid = gid;
		this.userno = userno;
		this.corname = corname;
	}

	public RepUserCompany(int gid, int userno, String corname,
			String cornature, String corscale, String corindustry,
			String department, String report, Integer subordinate,
			String jobname, Date worktime, String workaddr, String summary,
			String jobperformance, String reserved01, String reserved02) {
		this.gid = gid;
		this.userno = userno;
		this.corname = corname;
		this.cornature = cornature;
		this.corscale = corscale;
		this.corindustry = corindustry;
		this.department = department;
		this.report = report;
		this.subordinate = subordinate;
		this.jobname = jobname;
		this.worktime = worktime;
		this.workaddr = workaddr;
		this.summary = summary;
		this.jobperformance = jobperformance;
		this.reserved01 = reserved01;
		this.reserved02 = reserved02;
	}

	public int getGid() {
		return this.gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getUserno() {
		return this.userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getCorname() {
		return this.corname;
	}

	public void setCorname(String corname) {
		this.corname = corname;
	}

	public String getCornature() {
		return this.cornature;
	}

	public void setCornature(String cornature) {
		this.cornature = cornature;
	}

	public String getCorscale() {
		return this.corscale;
	}

	public void setCorscale(String corscale) {
		this.corscale = corscale;
	}

	public String getCorindustry() {
		return this.corindustry;
	}

	public void setCorindustry(String corindustry) {
		this.corindustry = corindustry;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getReport() {
		return this.report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Integer getSubordinate() {
		return this.subordinate;
	}

	public void setSubordinate(Integer subordinate) {
		this.subordinate = subordinate;
	}

	public String getJobname() {
		return this.jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public Date getWorktime() {
		return this.worktime;
	}

	public void setWorktime(Date worktime) {
		this.worktime = worktime;
	}

	public String getWorkaddr() {
		return this.workaddr;
	}

	public void setWorkaddr(String workaddr) {
		this.workaddr = workaddr;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getJobperformance() {
		return this.jobperformance;
	}

	public void setJobperformance(String jobperformance) {
		this.jobperformance = jobperformance;
	}

	public String getReserved01() {
		return this.reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

	public String getReserved02() {
		return this.reserved02;
	}

	public void setReserved02(String reserved02) {
		this.reserved02 = reserved02;
	}

}