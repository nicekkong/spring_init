/******************************************************
 * Project Name :  board
 * File Name : Board.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 30. 오전 5:54
 * Description : 
 ******************************************************/
package com.nicekkong.board.domain;

import java.util.Date;

public class Board {

    private int bno;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private int viewCnt;


    public int getBno() {
        return bno;
    }

    public Board setBno(int bno) {
        this.bno = bno;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Board setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Board setContent(String content) {
        this.content = content;
        return this;
    }

    public String getWriter() {
        return writer;
    }

    public Board setWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public Date getRegDate() {
        return regDate;
    }

    public Board setRegDate(Date regDate) {
        this.regDate = regDate;
        return this;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public Board setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
        return this;
    }

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", regDate=" + regDate +
                ", viewCnt=" + viewCnt +
                '}';
    }
}
