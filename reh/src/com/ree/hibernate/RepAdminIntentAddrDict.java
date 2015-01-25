package com.ree.hibernate;

// Generated 2015-1-23 22:08:29 by Hibernate Tools 3.4.0.CR1

/**
 * RepAdminIntentAddrDict generated by hbm2java
 */
public class RepAdminIntentAddrDict implements java.io.Serializable {

	private Integer intentAddrNo;
	private int intentAddrLever;
	private String intentAddrName;
	private String intentAddr;
	private Integer intentFatherNo;
	private String intentRange;
	private String reserved01;

	public RepAdminIntentAddrDict() {
	}

	public RepAdminIntentAddrDict(int intentAddrLever, String intentAddrName) {
		this.intentAddrLever = intentAddrLever;
		this.intentAddrName = intentAddrName;
	}

	public RepAdminIntentAddrDict(int intentAddrLever, String intentAddrName,
			String intentAddr, Integer intentFatherNo, String intentRange,
			String reserved01) {
		this.intentAddrLever = intentAddrLever;
		this.intentAddrName = intentAddrName;
		this.intentAddr = intentAddr;
		this.intentFatherNo = intentFatherNo;
		this.intentRange = intentRange;
		this.reserved01 = reserved01;
	}

	public Integer getIntentAddrNo() {
		return this.intentAddrNo;
	}

	public void setIntentAddrNo(Integer intentAddrNo) {
		this.intentAddrNo = intentAddrNo;
	}

	public int getIntentAddrLever() {
		return this.intentAddrLever;
	}

	public void setIntentAddrLever(int intentAddrLever) {
		this.intentAddrLever = intentAddrLever;
	}

	public String getIntentAddrName() {
		return this.intentAddrName;
	}

	public void setIntentAddrName(String intentAddrName) {
		this.intentAddrName = intentAddrName;
	}

	public String getIntentAddr() {
		return this.intentAddr;
	}

	public void setIntentAddr(String intentAddr) {
		this.intentAddr = intentAddr;
	}

	public Integer getIntentFatherNo() {
		return this.intentFatherNo;
	}

	public void setIntentFatherNo(Integer intentFatherNo) {
		this.intentFatherNo = intentFatherNo;
	}

	public String getIntentRange() {
		return this.intentRange;
	}

	public void setIntentRange(String intentRange) {
		this.intentRange = intentRange;
	}

	public String getReserved01() {
		return this.reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

}