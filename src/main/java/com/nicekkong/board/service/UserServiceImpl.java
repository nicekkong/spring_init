/******************************************************
 * Project Name : board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 11. 오후 2:04
 * Description  : 
 ******************************************************/
package com.nicekkong.board.service;

import com.nicekkong.board.dao.UserDao;
import com.nicekkong.board.domain.User;
import com.nicekkong.board.dto.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User login(Login login) throws Exception {
        return userDao.login(login);
    }
}
