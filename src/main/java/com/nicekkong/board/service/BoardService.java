/******************************************************
 * Project Name :  board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 9. 2. 오후 11:12
 * Description : 
 ******************************************************/
package com.nicekkong.board.service;

import com.nicekkong.board.domain.Board;
import com.nicekkong.board.domain.Criteria;

import java.util.List;

public interface BoardService {

    public void regist(Board board) throws Exception;
    public Board read(int bno) throws Exception;
    public void modify(Board board) throws Exception;
    public void remove(int bno) throws Exception;
    public List<Board> listAll() throws Exception;
    public List<Board> listCriteria(Criteria cri) throws Exception;
    public int listCountCriteria(Criteria cri) throws Exception;
}
