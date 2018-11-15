package com.bbs.domain;

/**
 * 私信附加信息实体类
 *
 * @author chenhuayang
 * @version 2018/10/19
 */
public class PrivateMessageVo extends PrivateMessage {
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
    /**
     * 帖子标题
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}