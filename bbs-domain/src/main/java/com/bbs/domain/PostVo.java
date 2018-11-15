package com.bbs.domain;

/**
 * 帖子附加信息实体类
 *
 * @author chenhuayang 2018/7/19
 */
public class PostVo extends Post {
    /**
     * 发帖作者昵称
     */
    private String userName;
    /**
     * 帖子类别编码
     */
    private String code;
    /**
     * 帖子板块
     */
    private String moduleCode;
    /**
     * 帖子类别
     */
    private String className;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}