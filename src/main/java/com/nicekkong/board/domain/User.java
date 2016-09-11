/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 8. 오후 11:14
 * Description  : 
 ******************************************************/
package com.nicekkong.board.domain;

public class User {

    private String uid;
    private String upw;
    private String uname;
    private int upoint;

    public String getUid() {
        return uid;
    }

    public User setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getUpw() {
        return upw;
    }

    public User setUpw(String upw) {
        this.upw = upw;
        return this;
    }

    public String getUname() {
        return uname;
    }

    public User setUname(String uname) {
        this.uname = uname;
        return this;
    }

    public int getUpoint() {
        return upoint;
    }

    public User setUpoint(int upoint) {
        this.upoint = upoint;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", upw='" + upw + '\'' +
                ", uname='" + uname + '\'' +
                ", upoint=" + upoint +
                '}';
    }
}
