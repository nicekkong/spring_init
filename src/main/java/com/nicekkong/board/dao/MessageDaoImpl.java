/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 8. 오후 11:28
 * Description  : 
 ******************************************************/
package com.nicekkong.board.dao;

import com.nicekkong.board.domain.Message;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private SqlSession session;

    private static final String namespace = "com.nicekkong.mapper.MessageMapper";

    @Override
    public void create(Message message) throws Exception {
        session.insert(namespace + ".create", message);
    }

    @Override
    public Message readMessage(int mid) throws Exception {
        return session.selectOne(namespace + ".readMessage", mid);
    }

    @Override
    public void updateState(int mid) throws Exception {
        session.update(namespace + ".updateState", mid);
    }
}
