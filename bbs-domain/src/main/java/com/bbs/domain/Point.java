package com.bbs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author chenhuayang
 * @description
 * @date 2019年01月30日
 */
public class Point {
    private String account;
    private Integer pointAmount;
    private Integer pointChange;
    private String grade;
    private Integer status;
    private String reason;
    private Date createTime;
    private Date gmtTime;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(Integer pointAmount) {
        this.pointAmount = pointAmount;
    }

    public Integer getPointChange() {
        return pointChange;
    }

    public void setPointChange(Integer pointChange) {
        this.pointChange = pointChange;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getGmtTime() {
        return gmtTime;
    }

    public void setGmtTime(Date gmtTime) {
        this.gmtTime = gmtTime;
    }

    public enum statusEnum {
        /**
         * 积分增加
         */
        decrease(-1, "decrease", "减"),
        /**
         * 积分减少
         */
        increase(1, "increase", "增");

        private int code;
        private String sign;
        private String message;

        statusEnum(int code, String sign, String message) {
            this.code = code;
            this.sign = sign;
            this.message = message;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getSign() {
            return sign;
        }

        public String getMessage() {
            return message;
        }
    }

    private enum gradeEnum {
        /**
         * 等级零，积分为0
         */
        zeroGrade(0, "zeroGrade", "等级零"),
        /**
         * 等级一，积分为1-199
         */
        firstGrade(1, "firstGrade", "等级一"),
        /**
         * 等级二，积分为200-499
         */
        secondGrade(2, "secondGrade", "等级二"),
        /**
         * 等级三，积分为500-999
         */
        thirdGrade(3, "thirdGrade", "等级三"),
        /**
         * 等级四，积分为1000-1999
         */
        forthGrade(4, "forthGrade", "等级四"),
        /**
         * 等级五，积分为2000-4999
         */
        fifthGrade(5, "fifthGrade", "等级五"),
        /**
         * 等级六，积分为5000+
         */
        sixthGrade(6, "sixthGrade", "等级六");

        private int code;
        private String sign;
        private String message;

        gradeEnum(int code, String sign, String message) {
            this.code = code;
            this.sign = sign;
            this.message = message;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getSign() {
            return sign;
        }

        public String getMessage() {
            return message;
        }
    }
}