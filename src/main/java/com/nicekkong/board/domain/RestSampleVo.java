/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 4. 오후 11:19
 * Description  : 
 ******************************************************/
package com.nicekkong.board.domain;

public class RestSampleVo {

    private int mno;
    private String fristName;
    private String lastName;

    @Override
    public String toString() {
        return "RestSampleVo{" +
                "mno=" + mno +
                ", fristName='" + fristName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getMno() {
        return mno;
    }

    public RestSampleVo setMno(int mno) {
        this.mno = mno;
        return this;
    }

    public String getFristName() {
        return fristName;
    }

    public RestSampleVo setFristName(String fristName) {
        this.fristName = fristName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RestSampleVo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
