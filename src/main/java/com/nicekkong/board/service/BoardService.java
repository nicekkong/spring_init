/******************************************************
 * Project Name :  board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 9. 2. 오후 11:12
 * Description : 
 ******************************************************/
package com.nicekkong.board.service;

import com.nicekkong.board.domain.Board;

import java.util.List;

public interface BoardService {

    void regist(Board board) throws Exception;

    Board read(int bno) throws Exception;

    void modify(Board board) throws Exception;

    void remove(int bno) throws Exception;

    List<Board> listAll() throws Exception;
}
