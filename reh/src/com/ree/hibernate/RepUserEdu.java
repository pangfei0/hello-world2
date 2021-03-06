package com.ree.hibernate;

// Generated 2015-1-23 22:08:29 by Hibernate Tools 3.4.0.CR1

/**
 * RepUserEdu generated by hbm2java
 */
public class RepUserEdu implements java.io.Serializable {

	private Integer gid;
	private int userno;
	private String studytime;
	private String school;
	private String objname;
	private String degree;
	private String entrance;

	public RepUserEdu() {
	}

	public RepUserEdu(int userno) {
		this.userno = userno;
	}

	public RepUserEdu(int userno, String studytime, String school,
			String objname, String degree, String entrance) {
		this.userno = userno;
		this.studytime = studytime;
		this.school = school;
		this.objname = objname;
		this.degree = degree;
		this.entrance = entrance;
	}

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public int getUserno() {
		return this.userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getStudytime() {
		return this.studytime;
	}

	public void setStudytime(String studytime) {
		this.studytime = studytime;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getObjname() {
		return this.objname;
	}

	public void setObjname(String objname) {
		this.objname = objname;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEntrance() {
		return this.entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

}
