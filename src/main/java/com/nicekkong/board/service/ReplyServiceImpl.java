/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 5. 오후 11:45
 * Description  : 
 ******************************************************/
package com.nicekkong.board.service;

import com.nicekkong.board.dao.ReplyDao;
import com.nicekkong.board.domain.Criteria;
import com.nicekkong.board.domain.Reply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{

    private final static Logger logger = LoggerFactory.getLogger(ReplyServiceImpl.class);

    @Autowired
    private ReplyDao replyDao;

    @Override
    public void addReply(Reply reply) throws Exception {
        replyDao.create(reply);
    }

    @Override
    public List<Reply> listReply(int bno) throws Exception {
        return replyDao.list(bno);
    }

    @Override
    public void modifyReply(Reply reply) throws Exception {
        replyDao.update(reply);
    }

    @Override
    public void removeReply(int rno) throws Exception {
        replyDao.delete(rno);
    }

    @Override
    public List<Reply> listReplyPage(int bno, Criteria cri) throws Exception {
        return replyDao.listPage(bno, cri);
    }

    @Override
    public int count(int bno) throws Exception {
        return replyDao.count(bno);
    }
}
