/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 9. 오전 12:08
 * Description  : 
 ******************************************************/
package com.nicekkong.board.service;

import com.nicekkong.board.domain.Message;

public interface MessageService {

    public void addMessage(Message message) throws Exception;
    public Message readMessage(String uid, int mid) throws Exception;

}
