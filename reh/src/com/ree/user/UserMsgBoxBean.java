/**   
* @Title: UserMsgBoxBean.java 
* @Package com.ree.user 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月23日 上午6:14:04 
* @version  
*/
package com.ree.user;

/** 
 * @ClassName: UserMsgBoxBean 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月23日 上午6:14:04 
 *  
 */
public class UserMsgBoxBean {
	private Long recruitNum;
	private Long MsgNum;
	private Long recruitHasStateNum;
	private Long inFavouriteNum;
	public Long getRecruitNum() {
		return recruitNum;
	}
	public void setRecruitNum(Long recruitNum) {
		this.recruitNum = recruitNum;
	}
	public Long getMsgNum() {
		return MsgNum;
	}
	public void setMsgNum(Long msgNum) {
		MsgNum = msgNum;
	}
	public Long getRecruitHasStateNum() {
		return recruitHasStateNum;
	}
	public void setRecruitHasStateNum(Long recruitHasStateNum) {
		this.recruitHasStateNum = recruitHasStateNum;
	}
	public Long getInFavouriteNum() {
		return inFavouriteNum;
	}
	public void setInFavouriteNum(Long inFavouriteNum) {
		this.inFavouriteNum = inFavouriteNum;
	}
	
}
