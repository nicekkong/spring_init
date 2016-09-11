/******************************************************
 * Project Name : board
 * File Name    : Login.java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 11. 오후 1:31
 * Description  : 
 ******************************************************/
package com.nicekkong.board.dto;

public class Login {

    private String uid;
    private String upw;
    private boolean useCookie;

    public String getUid() {
        return uid;
    }

    public Login setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getUpw() {
        return upw;
    }

    public Login setUpw(String upw) {
        this.upw = upw;
        return this;
    }

    public boolean isUseCookie() {
        return useCookie;
    }

    public Login setUseCookie(boolean useCookie) {
        this.useCookie = useCookie;
        return this;
    }

    @Override
    public String toString() {
        return "Login{" +
                "uid='" + uid + '\'' +
                ", upw='" + upw + '\'' +
                ", useCookie=" + useCookie +
                '}';
    }
}
