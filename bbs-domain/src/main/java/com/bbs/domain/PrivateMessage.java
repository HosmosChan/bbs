package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 私信信息实体类
 *
 * @author chenhuayang
 * @version 2018/10/19
 */
public class PrivateMessage implements Serializable {
    private Integer tid;
    /**
     * 私信编码
     */
    private String code;
    /**
     * 私信发送人
     */
    private String sendPersonAccount;
    /**
     * 私信接收人
     */
    private String recievePersonAccount;
    /**
     * 相关的帖子编码(即记录从哪个帖子发私信的)
     */
    private String aboutPostCode;
    /**
     * 私信内容
     */
    private String message;
    /**
     * 加密私钥
     */
    private String privateKey;
    /**
     * 私信状态("未读";"已读";"回收站状态")
     */
    private String messageStatus;
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

    public String getSendPersonAccount() {
        return sendPersonAccount;
    }

    public void setSendPersonAccount(String sendPersonAccount) {
        this.sendPersonAccount = sendPersonAccount;
    }

    public String getRecievePersonAccount() {
        return recievePersonAccount;
    }

    public void setRecievePersonAccount(String recievePersonAccount) {
        this.recievePersonAccount = recievePersonAccount;
    }

    public String getAboutPostCode() {
        return aboutPostCode;
    }

    public void setAboutPostCode(String aboutPostCode) {
        this.aboutPostCode = aboutPostCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
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
}