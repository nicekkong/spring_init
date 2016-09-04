/******************************************************
 * Project Name :  board
 * File Name : BoardDaoImpl.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 30. 오전 6:04
 * Description : 
 ******************************************************/
package com.nicekkong.board.dao;

import com.nicekkong.board.domain.Board;
import com.nicekkong.board.domain.Criteria;
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

    @Override
    public List<Board> listPage(int page) throws Exception {

        if(page <= 0){
            page = 1;
        }
        page = (page-1) * 10;

        return session.selectList(namespace + ".listPage", page);
    }

    @Override
    public List<Board> listCritera(Criteria cri) throws Exception {
        return session.selectList(namespace + ".listCriteria", cri);
    }

    @Override
    public int countPaging(Criteria cri) throws Exception {
        return session.selectOne(namespace + ".countPaging", cri);
    }
}
