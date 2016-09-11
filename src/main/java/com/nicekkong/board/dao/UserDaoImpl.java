/******************************************************
 * Project Name : board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 11. 오후 1:47
 * Description  : 
 ******************************************************/
package com.nicekkong.board.dao;

import com.nicekkong.board.domain.User;
import com.nicekkong.board.dto.Login;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession session;

    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private static final String namespace = "com.nicekkong.board.mapper.UserMapper";

    @Override
    public User login(Login login) throws Exception {
        return session.selectOne(namespace + ".login", login);
    }
}
