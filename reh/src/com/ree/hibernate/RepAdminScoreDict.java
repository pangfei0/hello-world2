package com.ree.hibernate;

// Generated 2015-1-23 22:08:29 by Hibernate Tools 3.4.0.CR1

/**
 * RepAdminScoreDict generated by hbm2java
 */
public class RepAdminScoreDict implements java.io.Serializable {

	private int ruleNo;
	private String ruleName;
	private Integer ruleScore;
	private Integer ruleFor;
	private String reserved01;

	public RepAdminScoreDict() {
	}

	public RepAdminScoreDict(int ruleNo) {
		this.ruleNo = ruleNo;
	}

	public RepAdminScoreDict(int ruleNo, String ruleName, Integer ruleScore,
			Integer ruleFor, String reserved01) {
		this.ruleNo = ruleNo;
		this.ruleName = ruleName;
		this.ruleScore = ruleScore;
		this.ruleFor = ruleFor;
		this.reserved01 = reserved01;
	}

	public int getRuleNo() {
		return this.ruleNo;
	}

	public void setRuleNo(int ruleNo) {
		this.ruleNo = ruleNo;
	}

	public String getRuleName() {
		return this.ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public Integer getRuleScore() {
		return this.ruleScore;
	}

	public void setRuleScore(Integer ruleScore) {
		this.ruleScore = ruleScore;
	}

	public Integer getRuleFor() {
		return this.ruleFor;
	}

	public void setRuleFor(Integer ruleFor) {
		this.ruleFor = ruleFor;
	}

	public String getReserved01() {
		return this.reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

}
