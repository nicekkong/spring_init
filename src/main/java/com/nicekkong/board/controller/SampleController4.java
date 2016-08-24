/******************************************************
 * Project Name :  spring_board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 25. 오전 1:55
 * Description : 
 ******************************************************/

package com.nicekkong.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

    Logger logger = LoggerFactory.getLogger(SampleController4.class);

    @RequestMapping(value = "/doE")
    public String doE(RedirectAttributes rttr){

        rttr.addFlashAttribute("msg", "This is the Message!!");

        return "redirect:/doF";
    }

    @RequestMapping(value = "/doF")
    public void doF(@ModelAttribute("msg") String msg){

        logger.info(">>>>>>> msg : " + msg);
    }
}
