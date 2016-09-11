/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 11. 오전 1:55
 * Description  : 
 ******************************************************/
package com.nicekkong.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class SampleInterceptorController {

    private final static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping(value = "/interceptorA", method = RequestMethod.GET)
    public String interceptorA(Locale locale, Model model) {

        logger.debug("=========> /interceptorA");

        return "home";
    }


    @RequestMapping(value = "/interceptorB", method = RequestMethod.GET)
    public String interceptorB(Locale locale, Model model) {

        logger.debug("=========> /interceptorB");

        model.addAttribute("result", "interceptorBBB Result");

        return "home";
    }
}
