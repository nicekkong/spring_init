/******************************************************
 * Project Name :  spring_board
 * File Name : .java
 * Author : nicekkong
 * Create Date : 2016. 6. 28. 오전 2:05
 * Description :
 ******************************************************/

package com.nicekkong.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "main";
    }
}