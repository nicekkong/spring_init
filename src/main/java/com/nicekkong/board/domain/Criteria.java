/******************************************************
 * Project Name :  board
 * File Name    : Criteria.java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 3. 오후 4:54
 * Description  :
 ******************************************************/
package com.nicekkong.board.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Criteria {


    private static final Logger logger = LoggerFactory.getLogger(Criteria.class);

    private int page;
    private int perPageNum;

    public Criteria() {

//        logger.info(">>>>>>>>>>>>>>> call : Criteria()");

        this.page = 1;
        this.perPageNum = 10;
    }


    public Criteria(int page, int perPageNum) {
        this.page = page;
        this.perPageNum = perPageNum;
    }

    public void setPage(int page) {
//
//        if(page <= 1) {
//            this.page = 0;
//        } else {
//            this.page = (page -1) * this.perPageNum;
//        }
//
        this.page = page;
    }


    public void setPerPageNum(int perPageNum) {

//        logger.info(">>>>>>>>>>>>>>> call : setPerPageNum()");

        if (perPageNum <= 0 || perPageNum > 100) {
            this.perPageNum = 10;
            return;
        }

        this.perPageNum = perPageNum;
    }

    public int getPage() {

//        logger.info(">>>>>>>>>>>>>>> call : getPage()");

        return page;
    }

    // method for MyBatis SQL Mapper -
    public int getPageStart() {

        return (this.page - 1) * perPageNum;
    }

    // method for MyBatis SQL Mapper
    public int getPerPageNum() {

//        logger.info(">>>>>>>>>>>>>>> call : getPerPageNum()");

        return this.perPageNum;
    }

    @Override
    public String toString() {
        return "Criteria [page=" + page + ", "
                + "perPageNum=" + perPageNum + "]";
    }
}
