package com.bbs.domain;

import com.alibaba.druid.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 投诉信息实体类
 *
 * @author chenhuayang
 */
public class Complain implements Serializable {
    private Integer tid;
    /**
     * 投诉编码
     */
    private String code;
    /**
     * 投诉类型编码
     */
    private String typeCode;
    /**
     * 投诉帖子编码
     */
    private String postCode;
    /**
     * 帖子标题
     */
    private String postTitle;
    /**
     * 投诉内容描述
     */
    private String message;
    /**
     * 投诉者
     */
    private String complainant;
    /**
     * 阅读状态
     */
    private String status;
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

    /**
     * 阅读状态枚举
     */
    public static enum StatusEnum {
        CANCESTATUS("00", "未读"),
        NORMALSTATUS("01", "已读");
        private String code;
        private String value;

        StatusEnum(String code, String value) {
            this.code = code;
            this.value = value;
        }

        public static String getNameByCode(String code) {
            if (StringUtils.isEmpty(code)) {
                return null;
            }
            switch (code) {
                case "00":
                    return CANCESTATUS.value;
                case "01":
                    return NORMALSTATUS.value;
                default:
                    return "";
            }
        }
    }

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

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getComplainant() {
        return complainant;
    }

    public void setComplainant(String complainant) {
        this.complainant = complainant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}