package com.ree.hibernate;

// Generated 2015-1-23 22:08:29 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * RepTrainNewsViewId generated by hbm2java
 */
public class RepTrainNewsViewId implements java.io.Serializable {

	private int newsNo;
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
	private long userCount;

	public RepTrainNewsViewId() {
	}

	public RepTrainNewsViewId(int newsNo, Date newsSubmittime,
			Date newsOrdertime, String newsAuthor, int newsListNo,
			long userCount) {
		this.newsNo = newsNo;
		this.newsSubmittime = newsSubmittime;
		this.newsOrdertime = newsOrdertime;
		this.newsAuthor = newsAuthor;
		this.newsListNo = newsListNo;
		this.userCount = userCount;
	}

	public RepTrainNewsViewId(int newsNo, String newsTitle, String newsContent,
			Date newsSubmittime, Date newsOrdertime, String newsAuthor,
			int newsListNo, String newsImgurl, Date newsTrainEndtime,
			String reserved01, String reserved02, long userCount) {
		this.newsNo = newsNo;
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
		this.userCount = userCount;
	}

	public int getNewsNo() {
		return this.newsNo;
	}

	public void setNewsNo(int newsNo) {
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

	public long getUserCount() {
		return this.userCount;
	}

	public void setUserCount(long userCount) {
		this.userCount = userCount;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RepTrainNewsViewId))
			return false;
		RepTrainNewsViewId castOther = (RepTrainNewsViewId) other;

		return (this.getNewsNo() == castOther.getNewsNo())
				&& ((this.getNewsTitle() == castOther.getNewsTitle()) || (this
						.getNewsTitle() != null
						&& castOther.getNewsTitle() != null && this
						.getNewsTitle().equals(castOther.getNewsTitle())))
				&& ((this.getNewsContent() == castOther.getNewsContent()) || (this
						.getNewsContent() != null
						&& castOther.getNewsContent() != null && this
						.getNewsContent().equals(castOther.getNewsContent())))
				&& ((this.getNewsSubmittime() == castOther.getNewsSubmittime()) || (this
						.getNewsSubmittime() != null
						&& castOther.getNewsSubmittime() != null && this
						.getNewsSubmittime().equals(
								castOther.getNewsSubmittime())))
				&& ((this.getNewsOrdertime() == castOther.getNewsOrdertime()) || (this
						.getNewsOrdertime() != null
						&& castOther.getNewsOrdertime() != null && this
						.getNewsOrdertime()
						.equals(castOther.getNewsOrdertime())))
				&& ((this.getNewsAuthor() == castOther.getNewsAuthor()) || (this
						.getNewsAuthor() != null
						&& castOther.getNewsAuthor() != null && this
						.getNewsAuthor().equals(castOther.getNewsAuthor())))
				&& (this.getNewsListNo() == castOther.getNewsListNo())
				&& ((this.getNewsImgurl() == castOther.getNewsImgurl()) || (this
						.getNewsImgurl() != null
						&& castOther.getNewsImgurl() != null && this
						.getNewsImgurl().equals(castOther.getNewsImgurl())))
				&& ((this.getNewsTrainEndtime() == castOther
						.getNewsTrainEndtime()) || (this.getNewsTrainEndtime() != null
						&& castOther.getNewsTrainEndtime() != null && this
						.getNewsTrainEndtime().equals(
								castOther.getNewsTrainEndtime())))
				&& ((this.getReserved01() == castOther.getReserved01()) || (this
						.getReserved01() != null
						&& castOther.getReserved01() != null && this
						.getReserved01().equals(castOther.getReserved01())))
				&& ((this.getReserved02() == castOther.getReserved02()) || (this
						.getReserved02() != null
						&& castOther.getReserved02() != null && this
						.getReserved02().equals(castOther.getReserved02())))
				&& (this.getUserCount() == castOther.getUserCount());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getNewsNo();
		result = 37 * result
				+ (getNewsTitle() == null ? 0 : this.getNewsTitle().hashCode());
		result = 37
				* result
				+ (getNewsContent() == null ? 0 : this.getNewsContent()
						.hashCode());
		result = 37
				* result
				+ (getNewsSubmittime() == null ? 0 : this.getNewsSubmittime()
						.hashCode());
		result = 37
				* result
				+ (getNewsOrdertime() == null ? 0 : this.getNewsOrdertime()
						.hashCode());
		result = 37
				* result
				+ (getNewsAuthor() == null ? 0 : this.getNewsAuthor()
						.hashCode());
		result = 37 * result + this.getNewsListNo();
		result = 37
				* result
				+ (getNewsImgurl() == null ? 0 : this.getNewsImgurl()
						.hashCode());
		result = 37
				* result
				+ (getNewsTrainEndtime() == null ? 0 : this
						.getNewsTrainEndtime().hashCode());
		result = 37
				* result
				+ (getReserved01() == null ? 0 : this.getReserved01()
						.hashCode());
		result = 37
				* result
				+ (getReserved02() == null ? 0 : this.getReserved02()
						.hashCode());
		result = 37 * result + (int) this.getUserCount();
		return result;
	}

}