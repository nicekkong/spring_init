/******************************************************
 * Project Name :  board
 * File Name : BoardDaoImpl.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 30. 오전 6:04
 * Description : 
 ******************************************************/
package com.nicekkong.board.dao;

import com.nicekkong.board.domain.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao {

    @Inject
    private SqlSession session;

    private static final String namespace = "com.nicekkong.mapper.BoardMapper";

    @Override
    public void create(Board board) throws Exception {
        session.insert(namespace + ".create", board);
    }

    @Override
    public Board read(int vno) throws Exception {
        return session.selectOne(namespace + ".read", vno);
    }

    @Override
    public void update(Board board) throws Exception {
        session.update(namespace + ".update", board);
    }

    @Override
    public void delete(int vno) throws Exception {
        session.delete(namespace + ".delete", vno);
    }

    @Override
    public List<Board> listAll() throws Exception {
        return session.selectList(namespace + ".listAll");
    }
}
