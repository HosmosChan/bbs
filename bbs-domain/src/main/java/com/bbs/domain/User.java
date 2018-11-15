package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.druid.util.StringUtils;

/**
 * @author liuqiangsheng
 */
public class User implements Serializable {
    private static final long serialVersionUID = 6834168215488280221L;
    private Integer tid;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户登录密码
     */
    private String password;
    /**
     * 确认密码
     */
    private String confirmPassword;
    /**
     * 用户角色
     */
    private Integer levelCode;
    /**
     * 用户状态
     */
    private String statusCode;
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
    private int pageNum;
    private int pageSize;

    /**
     * 用户状态枚举
     *
     * @author liuqiangsheng
     */
    public static enum StatusEnum {
        CANCESTATUS("00", "注销"),
        NORMALSTATUS("01", "正常");
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}