/******************************************************
 * Project Name :  board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 9. 2. 오후 11:16
 * Description : 
 ******************************************************/
package com.nicekkong.board.service;

import com.nicekkong.board.dao.BoardDao;
import com.nicekkong.board.domain.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Autowired
    private BoardDao dao;

    @Override
    public void regist(Board board) throws Exception {
        dao.create(board);
    }

    @Override
    public Board read(int bno) throws Exception {
        return dao.read(bno);
    }

    @Override
    public void modify(Board board) throws Exception {
        dao.update(board);
    }

    @Override
    public void remove(int bno) throws Exception {
        dao.delete(bno);
    }

    @Override
    public List<Board> listAll() throws Exception {
        return dao.listAll();
    }

    public static int doA(int a, int b) {
        Integer c = new Integer(a);

        return a+b+c;
    }


}
