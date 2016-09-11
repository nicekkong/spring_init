/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 8. 오후 11:12
 * Description  : 
 ******************************************************/
package com.nicekkong.board.domain;

import java.util.Date;

public class Message {

    private int mid;
    private String targetId;
    private String sender;
    private String message;
    private Date openDate;
    private Date sendDate;

    public int getMid() {
        return mid;
    }

    public Message setMid(int mid) {
        this.mid = mid;
        return this;
    }

    public String getTargetId() {
        return targetId;
    }

    public Message setTargetId(String targetId) {
        this.targetId = targetId;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public Message setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public Message setOpenDate(Date openDate) {
        this.openDate = openDate;
        return this;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public Message setSendDate(Date sendDate) {
        this.sendDate = sendDate;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", targetId='" + targetId + '\'' +
                ", sender='" + sender + '\'' +
                ", message='" + message + '\'' +
                ", openDate=" + openDate +
                ", sendDate=" + sendDate +
                '}';
    }
}
