/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 5. 오후 11:29
 * Description  : 
 ******************************************************/
package com.nicekkong.board.dao;

import com.nicekkong.board.domain.Criteria;
import com.nicekkong.board.domain.Reply;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReplyDaoImpl implements ReplyDao {

    @Autowired
    private SqlSession session;

    private final static String namespace = "com.nicekkong.mapper.ReplyMapper";

    @Override
    public List<Reply> list(int bno) throws Exception {
        return session.selectList(namespace + ".list", bno);
    }

    @Override
    public void create(Reply reply) throws Exception {
        session.insert(namespace + ".create", reply);
    }

    @Override
    public void update(Reply reply) throws Exception {
        session.update(namespace + ".update", reply);
    }

    @Override
    public void delete(int rno) throws Exception {
        session.delete(namespace + ".delete", rno);
    }

    @Override
    public List<Reply> listPage(int bno, Criteria cri) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("bno", bno);
        paramMap.put("cri", cri);

        return session.selectList(namespace + ".listPage", paramMap);
    }

    @Override
    public int count(int bno) throws Exception {
        return session.selectOne(namespace + ".count", bno);
    }
}
