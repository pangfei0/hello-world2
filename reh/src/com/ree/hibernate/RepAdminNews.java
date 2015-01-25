package com.ree.hibernate;

// Generated 2015-1-23 22:08:29 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * RepAdminNews generated by hbm2java
 */
public class RepAdminNews implements java.io.Serializable {

	private Integer newsNo;
	private String newsTitle;
	private String newsContent;
	private Date newsSubmittime;
	private Date newsOrdertime;
	private String newsAuthor;
	private int newsListNo;
	private String newsImgurl;
	private Date newsTrainEndtime;
	private String reserved01;
	private String reserved02;

	public RepAdminNews() {
	}

	public RepAdminNews(Date newsSubmittime, Date newsOrdertime,
			String newsAuthor, int newsListNo) {
		this.newsSubmittime = newsSubmittime;
		this.newsOrdertime = newsOrdertime;
		this.newsAuthor = newsAuthor;
		this.newsListNo = newsListNo;
	}

	public RepAdminNews(String newsTitle, String newsContent,
			Date newsSubmittime, Date newsOrdertime, String newsAuthor,
			int newsListNo, String newsImgurl, Date newsTrainEndtime,
			String reserved01, String reserved02) {
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsSubmittime = newsSubmittime;
		this.newsOrdertime = newsOrdertime;
		this.newsAuthor = newsAuthor;
		this.newsListNo = newsListNo;
		this.newsImgurl = newsImgurl;
		this.newsTrainEndtime = newsTrainEndtime;
		this.reserved01 = reserved01;
		this.reserved02 = reserved02;
	}

	public Integer getNewsNo() {
		return this.newsNo;
	}

	public void setNewsNo(Integer newsNo) {
		this.newsNo = newsNo;
	}

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public Date getNewsSubmittime() {
		return this.newsSubmittime;
	}

	public void setNewsSubmittime(Date newsSubmittime) {
		this.newsSubmittime = newsSubmittime;
	}

	public Date getNewsOrdertime() {
		return this.newsOrdertime;
	}

	public void setNewsOrdertime(Date newsOrdertime) {
		this.newsOrdertime = newsOrdertime;
	}

	public String getNewsAuthor() {
		return this.newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public int getNewsListNo() {
		return this.newsListNo;
	}

	public void setNewsListNo(int newsListNo) {
		this.newsListNo = newsListNo;
	}

	public String getNewsImgurl() {
		return this.newsImgurl;
	}

	public void setNewsImgurl(String newsImgurl) {
		this.newsImgurl = newsImgurl;
	}

	public Date getNewsTrainEndtime() {
		return this.newsTrainEndtime;
	}

	public void setNewsTrainEndtime(Date newsTrainEndtime) {
		this.newsTrainEndtime = newsTrainEndtime;
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
