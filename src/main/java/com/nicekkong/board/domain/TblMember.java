/******************************************************
 * Project Name :  spring_board
 * File Name :
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 6. 29. 오후 11:30
 * Description :
 ******************************************************/

package com.nicekkong.board.domain;

import java.sql.Date;

public class TblMember {

    private String userId;
    private String userPw;
    private String userName;
    private String email;
    private Date regDate;
    private Date updDate;

    public String getEmail() {
        return email;
    }

    public TblMember setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getRegDate() {
        return regDate;
    }

    public TblMember setRegDate(Date regDate) {
        this.regDate = regDate;
        return this;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public TblMember setUpdDate(Date updDate) {
        this.updDate = updDate;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public TblMember setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public TblMember setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPw() {
        return userPw;
    }

    public TblMember setUserPw(String userPw) {
        this.userPw = userPw;
        return this;
    }
}
