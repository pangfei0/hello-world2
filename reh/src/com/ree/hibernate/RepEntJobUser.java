package com.ree.hibernate;

// Generated 2015-1-23 22:08:29 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * RepEntJobUser generated by hbm2java
 */
public class RepEntJobUser implements java.io.Serializable {

	private RepEntJobUserId id;
	private int state;
	private Date submittime;
	private Date auditiontime;
	private Date hiretime;
	private Date trytime;
	private Date dismisstime;
	private Date membertime;
	private Date contracttime;
	private String memo;
	private String reserved01;

	public RepEntJobUser() {
	}

	public RepEntJobUser(RepEntJobUserId id, int state, Date submittime) {
		this.id = id;
		this.state = state;
		this.submittime = submittime;
	}

	public RepEntJobUser(RepEntJobUserId id, int state, Date submittime,
			Date auditiontime, Date hiretime, Date trytime, Date dismisstime,
			Date membertime, Date contracttime, String memo, String reserved01) {
		this.id = id;
		this.state = state;
		this.submittime = submittime;
		this.auditiontime = auditiontime;
		this.hiretime = hiretime;
		this.trytime = trytime;
		this.dismisstime = dismisstime;
		this.membertime = membertime;
		this.contracttime = contracttime;
		this.memo = memo;
		this.reserved01 = reserved01;
	}

	public RepEntJobUserId getId() {
		return this.id;
	}

	public void setId(RepEntJobUserId id) {
		this.id = id;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getSubmittime() {
		return this.submittime;
	}

	public void setSubmittime(Date submittime) {
		this.submittime = submittime;
	}

	public Date getAuditiontime() {
		return this.auditiontime;
	}

	public void setAuditiontime(Date auditiontime) {
		this.auditiontime = auditiontime;
	}

	public Date getHiretime() {
		return this.hiretime;
	}

	public void setHiretime(Date hiretime) {
		this.hiretime = hiretime;
	}

	public Date getTrytime() {
		return this.trytime;
	}

	public void setTrytime(Date trytime) {
		this.trytime = trytime;
	}

	public Date getDismisstime() {
		return this.dismisstime;
	}

	public void setDismisstime(Date dismisstime) {
		this.dismisstime = dismisstime;
	}

	public Date getMembertime() {
		return this.membertime;
	}

	public void setMembertime(Date membertime) {
		this.membertime = membertime;
	}

	public Date getContracttime() {
		return this.contracttime;
	}

	public void setContracttime(Date contracttime) {
		this.contracttime = contracttime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getReserved01() {
		return this.reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

}