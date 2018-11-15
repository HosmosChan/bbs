package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private static final long serialVersionUID = 6329376930573607907L;
    private Integer tid;
    /**
     * 评论编码
     */
    private String code;
    /**
     * 属于帖子的编码
     */
    private String postCode;
    /**
     * 评论人
     */
    private String userAccount;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private Date commentTime;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 修改人
     */
    private String modifyBy;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * 修改人昵称
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}