/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 5. 오후 11:17
 * Description  : 
 ******************************************************/
package com.nicekkong.board.dao;

import com.nicekkong.board.domain.Criteria;
import com.nicekkong.board.domain.Reply;

import java.util.List;

public interface ReplyDao {

    public List<Reply> list(int bno) throws Exception;
    public void create(Reply reply) throws Exception;
    public void update(Reply reply) throws Exception;
    public void delete(int rno) throws Exception;

    public List<Reply> listPage(int bno, Criteria cri) throws Exception;
    public int count(int bno) throws Exception;
}
