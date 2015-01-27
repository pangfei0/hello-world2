package com.ree.hibernate;

// Generated 2015-1-23 22:08:29 by Hibernate Tools 3.4.0.CR1

/**
 * RepAdminJobAgeDict generated by hbm2java
 */
public class RepAdminJobAgeDict implements java.io.Serializable {

	private int ageNo;
	private String ageName;
	private Integer ageLevel;
	private String reserved01;

	public RepAdminJobAgeDict() {
	}

	public RepAdminJobAgeDict(int ageNo) {
		this.ageNo = ageNo;
	}

	public RepAdminJobAgeDict(int ageNo, String ageName, Integer ageLevel,
			String reserved01) {
		this.ageNo = ageNo;
		this.ageName = ageName;
		this.ageLevel = ageLevel;
		this.reserved01 = reserved01;
	}

	public int getAgeNo() {
		return this.ageNo;
	}

	public void setAgeNo(int ageNo) {
		this.ageNo = ageNo;
	}

	public String getAgeName() {
		return this.ageName;
	}

	public void setAgeName(String ageName) {
		this.ageName = ageName;
	}

	public Integer getAgeLevel() {
		return this.ageLevel;
	}

	public void setAgeLevel(Integer ageLevel) {
		this.ageLevel = ageLevel;
	}

	public String getReserved01() {
		return this.reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

}