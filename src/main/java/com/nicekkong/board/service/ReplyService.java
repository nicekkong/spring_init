/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 5. 오후 11:41
 * Description  : 
 ******************************************************/
package com.nicekkong.board.service;

import com.nicekkong.board.domain.Criteria;
import com.nicekkong.board.domain.Reply;

import java.util.List;

public interface ReplyService {

    public void addReply(Reply reply) throws Exception;
    public List<Reply> listReply(int bno) throws Exception;
    public void modifyReply(Reply reply) throws Exception;
    public void removeReply(int rno) throws Exception;

    public List<Reply> listReplyPage(int bno, Criteria cri) throws Exception;
    public int count(int bno) throws Exception;
}
