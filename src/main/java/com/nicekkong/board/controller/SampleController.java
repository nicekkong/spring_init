/******************************************************
 * Project Name :  spring_board
 * File Name : SampleController.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 23. 오후 10:42
 * Description : 테스트용 Controller
 ******************************************************/

package com.nicekkong.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping("doA")
    public void doA() {
        logger.info(">>>>>>>doA called......");
    }

    @RequestMapping(value = "doB", method = RequestMethod.GET)
    public void doB() {
        logger.info(">>>>>>>doB called.........");
    }
}
