package com.bbs.domain;

/**
 * 投诉附加信息实体类
 *
 * @author chenhuayang 2018/7/23
 */
public class ComplainVo extends Complain {
    /**
     * 投诉类型
     */
    private String typer;

    public String getTyper() {
        return typer;
    }

    public void setTyper(String typer) {
        this.typer = typer;
    }

    /**
     * 用户昵称
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}