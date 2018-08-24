package com.bbs.domain;

import java.io.Serializable;
import java.sql.Date;

public class UserLiveness implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7641643517256072025L;
	private int tid;
    private String userTid;
    private String loginDate;
    private String loginModuleId;
    private int loginTimes;
    private int publishTimes;
    private int userLiveness;
	private java.util.Date createDate;
	private String createBy;
	private java.util.Date modifyDate;
	private String modifyBy;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public int getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getLoginModuleId() {
		return loginModuleId;
	}
	public void setLoginModuleId(String loginModuleId) {
		this.loginModuleId = loginModuleId;
	}
	public String getUserTid() {
		return userTid;
	}
	public void setUserTid(String userId) {
		this.userTid = userId;
	}
	
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public int getPublishTimes() {
		return publishTimes;
	}
	public void setPublishTimes(int publishTimes) {
		this.publishTimes = publishTimes;
	}
	public int getUserLiveness() {
		return userLiveness;
	}
	public void setUserLiveness(int userLiveness) {
		this.userLiveness = userLiveness;
	}

	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(java.util.Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	
}
