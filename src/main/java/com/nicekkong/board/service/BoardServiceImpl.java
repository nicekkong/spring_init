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
import com.nicekkong.board.domain.Criteria;
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

    @Override
    public List<Board> listCriteria(Criteria cri) throws Exception {

//        logger.info(">>>>>>>> Before <<<<<<<<<<");
//        logger.info("page : " + cri.getPage());
//        logger.info("perPageNum : " + cri.getPerPageNum());
//
        calcPageForQuery(cri);
//
//        logger.info(">>>>>>>> After <<<<<<<<<<");
//        logger.info("page : " + cri.getPage());
//        logger.info("perPageNum : " + cri.getPerPageNum());

        return dao.listCritera(calcPageForQuery(cri));
    }

    @Override
    public int listCountCriteria(Criteria cri) throws Exception {
        calcPageForQuery(cri);
        return dao.countPaging(calcPageForQuery(cri));
    }

    /**
     * page를 쿼리에 적합한 변수로 변환한다
     * @param cri 페이지 정보 객체
     */
    private Criteria calcPageForQuery(Criteria cri) {
        Criteria criForQuery = new Criteria();
        if(cri.getPage() <= 1) {
            criForQuery.setPage(0);
        } else {
            criForQuery.setPage((cri.getPage()-1) * cri.getPerPageNum());
        }

        return criForQuery;
    }
}
