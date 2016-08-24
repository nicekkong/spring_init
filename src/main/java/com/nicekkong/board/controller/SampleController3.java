/******************************************************
 * Project Name :  spring_board
 * File Name : SampleController3.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 25. 오전 1:38
 * Description : 
 ******************************************************/

package com.nicekkong.board.controller;

import com.nicekkong.board.domain.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController3 {

    private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);

    @RequestMapping(value="/doD")
    public String doD(Model model){

        ProductVO productVO = new ProductVO("MacBook", 2800000);

        model.addAttribute("product", productVO);

        return "product";
    }

    @RequestMapping(value="/doD2")
    public String doD2(@ModelAttribute("product")ProductVO productVO) {

        productVO.setName("iPhone");
        productVO.setPrice(999000);

        return "product";
    }
}
