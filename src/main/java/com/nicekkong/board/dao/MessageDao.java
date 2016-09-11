/******************************************************
 * Project Name :  board
 * File Name    : MessageDao.java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 8. 오후 11:15
 * Description  : 
 ******************************************************/
package com.nicekkong.board.dao;

import com.nicekkong.board.domain.Message;

public interface MessageDao {

    public void create(Message message) throws Exception;
    public Message readMessage(int mid) throws Exception;
    public void updateState(int mid) throws Exception;
}