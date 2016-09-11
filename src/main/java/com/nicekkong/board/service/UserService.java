/******************************************************
 * Project Name : board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 11. 오후 1:56
 * Description  : 
 ******************************************************/
package com.nicekkong.board.service;

import com.nicekkong.board.domain.User;
import com.nicekkong.board.dto.Login;

public interface UserService {

    public User login(Login login) throws Exception;
}