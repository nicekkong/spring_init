/******************************************************
 * Project Name :  spring_board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 25. 오전 2:09
 * Description : 
 ******************************************************/

package com.nicekkong.board.controller;

import com.nicekkong.board.domain.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController5 {

    Logger logger = LoggerFactory.getLogger(SampleController5.class);

    @RequestMapping(value = "/doJSON")
    @ResponseBody
    public ProductVO doJSON() {

        ProductVO vo = new ProductVO("MacBook Pro", 2500000);

        /**
         * {
         *       name: "MacBook Pro",
         *      price: 2500000
         *  }
         */

        return vo;
    }
}
