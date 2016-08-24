/******************************************************
 * Project Name :  spring_board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 23. 오후 11:02
 * Description : 
 ******************************************************/

package com.nicekkong.board.controller;

import com.nicekkong.board.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {

    private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);

    @RequestMapping(value="/doC")
    public String doC(@ModelAttribute("msg")String msg) {

        logger.info(">>>>>>> doC called........!!!");

        return "result";
    }

    @RequestMapping(value = "/emp")
    public String emp(@ModelAttribute("empView")Employee emp1, @ModelAttribute("name")String nameStr) {

        emp1.setName("Mr." + nameStr);
        emp1.setDept("IT Team");
        emp1.setAge(36);
        emp1.setEmpNo(1001857);

        return "emp";
    }


}
