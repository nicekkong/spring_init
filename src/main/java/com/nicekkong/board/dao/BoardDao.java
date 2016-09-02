/******************************************************
 * Project Name :  board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 30. 오전 5:58
 * Description : 
 ******************************************************/

package com.nicekkong.board.dao;

import com.nicekkong.board.domain.Board;

import java.util.List;

public interface BoardDao {

    public void create(Board board) throws Exception;
    public Board read(int vno) throws Exception;
    public void update(Board board) throws Exception;
    public void delete(int vno) throws Exception;
    public List<Board> listAll() throws Exception;

}
