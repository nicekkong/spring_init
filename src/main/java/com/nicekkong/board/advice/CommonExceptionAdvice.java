/******************************************************
 * Project Name :  board
 * File Name : CommonExceptionAdvice.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 9. 3. 오후 1:53
 * Description : 공통 예외 처리 Advice
 ******************************************************/
package com.nicekkong.board.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice   // 컨트롤러에서 호출되는 메서드에서 발생된  Exception을 처리
public class CommonExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

    @ExceptionHandler(Exception.class)  // 처리하려는 예외 타입을 선언
    public ModelAndView common(Exception e) {

        logger.info(">>>>>>>>>> CommonExceptionAdvice : " + e.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error_common");
        modelAndView.addObject("exception", e);

        return modelAndView;
    }

}
