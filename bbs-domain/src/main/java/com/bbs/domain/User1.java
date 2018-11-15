package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 唐垒
 * @description 用户注册实体类
 */
public class User1 implements Serializable {
    private static final long serialVersionUID = 313458296429042376L;
    /*用户id*/
    private Integer id;
    /*用户账号 userName -> account*/
    private String account;
    /*用户昵称name->userName*/
    private String userName;
    /*用户密码*/
    private String password;
    /*性别*/
    private Integer sex;
    /*用户角色*/
    private String roleName;
    /*用户创建日期*/
    private Date createDate;
    /*用户最新修改日期*/
    private Date modifyDate;
    /**/
    private String key;

    public static enum roleNameEnum {
        ORDINARY(1, "普通用户"),
        MODERATOR(2, "版主"),
        MANAGER(3, "管理员");
        public int code;
        public String value;

        private roleNameEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public static String getValueBycode(int code) {
            switch (code) {
                case 1:
                    return ORDINARY.value;
                case 2:
                    return MODERATOR.value;
                case 3:
                    return MANAGER.value;
                default:
                    return "";
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}