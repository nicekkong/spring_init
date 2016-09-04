/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 3. 오후 10:37
 * Description  : 
 ******************************************************/
package com.nicekkong.board.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

    private static final Logger logger = LoggerFactory.getLogger(PageMaker.class);

    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int displayPageNum = 10;

    private Criteria cri;

    public void setCri(Criteria cri) {
        this.cri = cri;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;

        calcData();
    }

    private void calcData() {
        logger.info(">>>>>>>calcData()");
        logger.info(">>>>>>>>>>>>>> " + cri.toString());

        Criteria criForQuery = new Criteria();
        if(cri.getPage() <= 1) {
            criForQuery.setPage(0);
        } else {
            criForQuery.setPage((cri.getPage()-1) * cri.getPerPageNum());
        }

        logger.info(">>>After : " + cri.toString());

        if(criForQuery.getPage() == 0 ) {
            endPage = displayPageNum;
        } else if (criForQuery.getPage()%criForQuery.getPerPageNum() == 0) {
            endPage = (int) (Math.ceil(((criForQuery.getPage()+criForQuery.getPerPageNum())/criForQuery.getPerPageNum()) / (double) displayPageNum) * displayPageNum);
        } else {
            endPage = (int) (Math.ceil((criForQuery.getPage()/criForQuery.getPerPageNum()) / (double) displayPageNum) * displayPageNum);
        }

        startPage = (endPage - displayPageNum) + 1;
        logger.info("startPage : " + startPage);


        int tempEndPage = (int) (Math.ceil(totalCount / (double) criForQuery.getPerPageNum()));
        logger.info("tempEndPage : " + tempEndPage);


        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }
        logger.info("endPage : " + endPage);

        prev = startPage == 1 ? false : true;
        logger.info(" prev : " + prev);


        next = endPage * criForQuery.getPerPageNum() >= totalCount ? false : true;
        logger.info("next : " + next);

    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    public Criteria getCri() {
        return cri;
    }

    public String makeQuery(int page) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("perPageNum", cri.getPerPageNum()).build();

        return uriComponents.toUriString();
    }

/*
    public String makeSearch(int page){

        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .queryParam("page", page)
                        .queryParam("perPageNum", cri.getPerPageNum())
                        .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
                        .queryParam("keyword", ((SearchCriteria)cri).getKeyword())
                        .build();

        return uriComponents.toUriString();
    }
*/

    @Override
    public String toString() {
        return "PageMaker{" +
                "totalCount=" + totalCount +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", displayPageNum=" + displayPageNum +
                ", cri=" + cri +
                '}';
    }
}
