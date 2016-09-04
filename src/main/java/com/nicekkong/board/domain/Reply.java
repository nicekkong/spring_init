/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 5. 오전 12:43
 * Description  : 
 ******************************************************/
package com.nicekkong.board.domain;

import java.util.Date;

public class Reply {

    private int rno;
    private int bno;
    private String replyText;
    private String replyer;
    private Date regDate;
    private Date updateDate;

    public int getRno() {
        return rno;
    }

    public Reply setRno(int rno) {
        this.rno = rno;
        return this;
    }

    public int getBno() {
        return bno;
    }

    public Reply setBno(int bno) {
        this.bno = bno;
        return this;
    }

    public String getReplyText() {
        return replyText;
    }

    public Reply setReplyText(String replyText) {
        this.replyText = replyText;
        return this;
    }

    public String getReplyer() {
        return replyer;
    }

    public Reply setReplyer(String replyer) {
        this.replyer = replyer;
        return this;
    }

    public Date getRegDate() {
        return regDate;
    }

    public Reply setRegDate(Date regDate) {
        this.regDate = regDate;
        return this;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Reply setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rno=" + rno +
                ", bno=" + bno +
                ", replyText='" + replyText + '\'' +
                ", replyer='" + replyer + '\'' +
                ", regDate=" + regDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
