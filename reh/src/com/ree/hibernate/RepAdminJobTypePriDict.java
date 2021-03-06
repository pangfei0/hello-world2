package com.ree.hibernate;

// Generated 2015-1-23 22:08:29 by Hibernate Tools 3.4.0.CR1

/**
 * RepAdminJobTypePriDict generated by hbm2java
 */
public class RepAdminJobTypePriDict implements java.io.Serializable {

	private Integer jobTypePriDictNo;
	private String jobTypePriDictType;
	private String jobTypePriDictName;
	private String reserved01;

	public RepAdminJobTypePriDict() {
	}

	public RepAdminJobTypePriDict(String jobTypePriDictType,
			String jobTypePriDictName) {
		this.jobTypePriDictType = jobTypePriDictType;
		this.jobTypePriDictName = jobTypePriDictName;
	}

	public RepAdminJobTypePriDict(String jobTypePriDictType,
			String jobTypePriDictName, String reserved01) {
		this.jobTypePriDictType = jobTypePriDictType;
		this.jobTypePriDictName = jobTypePriDictName;
		this.reserved01 = reserved01;
	}

	public Integer getJobTypePriDictNo() {
		return this.jobTypePriDictNo;
	}

	public void setJobTypePriDictNo(Integer jobTypePriDictNo) {
		this.jobTypePriDictNo = jobTypePriDictNo;
	}

	public String getJobTypePriDictType() {
		return this.jobTypePriDictType;
	}

	public void setJobTypePriDictType(String jobTypePriDictType) {
		this.jobTypePriDictType = jobTypePriDictType;
	}

	public String getJobTypePriDictName() {
		return this.jobTypePriDictName;
	}

	public void setJobTypePriDictName(String jobTypePriDictName) {
		this.jobTypePriDictName = jobTypePriDictName;
	}

	public String getReserved01() {
		return this.reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

}
