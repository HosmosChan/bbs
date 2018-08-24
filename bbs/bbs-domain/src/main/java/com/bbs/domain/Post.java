package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 帖子信息
 */
public class Post implements Serializable {

    private static final long serialVersionUID = -6405851612916402449L;
    private Integer tid;
    /**
     * 帖子编码
     */
    private String code;
    /**
     * 帖子板块
     */
    private String moduleCode;
    /**
     * 帖子类别
     */
    private String postClassCode;
    /**
     * 帖子标题
     */
    private String title;
    /**
     * 发帖人账号
     */
    private String hostAccount;
    /**
     * 发帖人名称
     */
    private String host;
    /**
     * 发帖日期
     */
    private Date publishDate;
    /**
     * 帖子内容
     */
    private String article;
    /**
     * 帖子的展示图片
     */
    private String icon;
    /**
     * 帖子阅读数
     */
    private Integer readingAmount;
    /**
     * 帖子点赞数
     */
    private Integer praiseAmount;
    /**
     * 帖子回复数
     */
    private Integer replyAmount;
    /**
     * 帖子状态: 01-帖子正常; 00-帖子关闭
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
     * 帖子状态枚举
     *
     * @author wangshixu
     */
    public static enum StatusEnum {
        CLOSESTATUS("00", "关闭"),
        NORMALSTATUS("00", "正常");
        public String code;
        public String value;

        private StatusEnum(String code, String value) {
            this.code = code;
            this.value = value;
        }

        public static String getNameByCode(String code) {
            if (StringUtils.isEmpty(code)) {
                return null;
            }
            switch (code) {
                case "00":
                    return CLOSESTATUS.value;
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

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getPostClassCode() {
        return postClassCode;
    }

    public void setPostClassCode(String postClassCode) {
        this.postClassCode = postClassCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHostAccount() {
        return hostAccount;
    }

    public void setHostAccount(String hostAccount) {
        this.hostAccount = hostAccount;
    }

    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getReadingAmount() {
        return readingAmount;
    }

    public void setReadingAmount(Integer readingAmount) {
        this.readingAmount = readingAmount;
    }

    public Integer getPraiseAmount() {
        return praiseAmount;
    }

    public void setPraiseAmount(Integer praiseAmount) {
        this.praiseAmount = praiseAmount;
    }

    public Integer getReplyAmount() {
        return replyAmount;
    }

    public void setReplyAmount(Integer replyAmount) {
        this.replyAmount = replyAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    @Override
    public String toString() {
        return "Post [tid=" + tid + ", code=" + code + ", moduleCode=" + moduleCode + ", postClassCode=" + postClassCode
                + ", title=" + title + ", hostAccount=" + hostAccount + ", host=" + host + ", publishDate="
                + publishDate + ", article=" + article + ", icon=" + icon + ", readingAmount=" + readingAmount
                + ", praiseAmount=" + praiseAmount + ", replyAmount=" + replyAmount + ", status=" + status
                + ", createDate=" + createDate + ", createBy=" + createBy + ", modifyDate=" + modifyDate + ", modifyBy="
                + modifyBy + "]";
    }
}
