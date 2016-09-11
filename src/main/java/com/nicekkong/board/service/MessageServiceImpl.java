/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 9. 오전 12:09
 * Description  : 
 ******************************************************/
package com.nicekkong.board.service;

import com.nicekkong.board.dao.MessageDao;
import com.nicekkong.board.dao.PointDao;
import com.nicekkong.board.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {

    private static final int POINT = 5;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private PointDao pointDao;

    private final static int MESSAGE_POINT = 10;

    @Transactional
    @Override
    public void addMessage(Message message) throws Exception {
        messageDao.create(message);
        pointDao.updatePoint(message.getSender(), MESSAGE_POINT);
    }

    @Override
    public Message readMessage(String uid, int mid) throws Exception {
        messageDao.updateState(mid);
        pointDao.updatePoint(uid, POINT);

        return messageDao.readMessage(mid);
    }
}
