package com.bbs.domain;

/**
 * @author:tanglei
 * @Create time:2018年7月17日
 * @ClassName:
 * @Description:
 */
public class Role {
    private int tid;
    private String roleName;
    private String description;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}