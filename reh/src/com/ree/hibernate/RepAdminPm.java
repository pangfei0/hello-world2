package com.ree.hibernate;

// Generated 2015-1-23 22:08:29 by Hibernate Tools 3.4.0.CR1

/**
 * RepAdminPm generated by hbm2java
 */
public class RepAdminPm implements java.io.Serializable {

	private int pmNo;
	private String pmTitle;
	private String pmContent;
	private Integer pmFNo;
	private Integer pmTNo;
	private int pmType;
	private int pmState;
	private String reserved01;

	public RepAdminPm() {
	}

	public RepAdminPm(int pmNo, int pmType, int pmState) {
		this.pmNo = pmNo;
		this.pmType = pmType;
		this.pmState = pmState;
	}

	public RepAdminPm(int pmNo, String pmTitle, String pmContent,
			Integer pmFNo, Integer pmTNo, int pmType, int pmState,
			String reserved01) {
		this.pmNo = pmNo;
		this.pmTitle = pmTitle;
		this.pmContent = pmContent;
		this.pmFNo = pmFNo;
		this.pmTNo = pmTNo;
		this.pmType = pmType;
		this.pmState = pmState;
		this.reserved01 = reserved01;
	}

	public int getPmNo() {
		return this.pmNo;
	}

	public void setPmNo(int pmNo) {
		this.pmNo = pmNo;
	}

	public String getPmTitle() {
		return this.pmTitle;
	}

	public void setPmTitle(String pmTitle) {
		this.pmTitle = pmTitle;
	}

	public String getPmContent() {
		return this.pmContent;
	}

	public void setPmContent(String pmContent) {
		this.pmContent = pmContent;
	}

	public Integer getPmFNo() {
		return this.pmFNo;
	}

	public void setPmFNo(Integer pmFNo) {
		this.pmFNo = pmFNo;
	}

	public Integer getPmTNo() {
		return this.pmTNo;
	}

	public void setPmTNo(Integer pmTNo) {
		this.pmTNo = pmTNo;
	}

	public int getPmType() {
		return this.pmType;
	}

	public void setPmType(int pmType) {
		this.pmType = pmType;
	}

	public int getPmState() {
		return this.pmState;
	}

	public void setPmState(int pmState) {
		this.pmState = pmState;
	}

	public String getReserved01() {
		return this.reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

}
