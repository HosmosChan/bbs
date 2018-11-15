package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

public class Data implements Serializable {
    private static final long serialVersionUID = -2473570927289240556L;
    private Integer tid;
    private String day;
    private String moduleId;
    private Integer sumPost;
    private Integer sumPraise;
    private String maxPraisePostName;
    private String bestActiviteUsername;
    private Date createDate;
    private String createBy;
    private Date modifyDate;
    private String modifyBy;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getSumPost() {
        return sumPost;
    }

    public void setSumPost(Integer sumPost) {
        this.sumPost = sumPost;
    }

    public Integer getSumPraise() {
        return sumPraise;
    }

    public void setSumPraise(Integer sumPraise) {
        this.sumPraise = sumPraise;
    }

    public String getMaxPraisePostName() {
        return maxPraisePostName;
    }

    public void setMaxPraisePostName(String maxPraisePostName) {
        this.maxPraisePostName = maxPraisePostName;
    }

    public String getBestActiviteUsername() {
        return bestActiviteUsername;
    }

    public void setBestActiviteUsername(String bestActiviteUsername) {
        this.bestActiviteUsername = bestActiviteUsername;
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