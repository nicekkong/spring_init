/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 11. 오전 1:49
 * Description  : 
 ******************************************************/
package com.nicekkong.board.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class SampleInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LoggerFactory.getLogger(SampleInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();
        logger.debug("===> preHandler() call by [" + handler.getClass() + "." + methodObj +"]");
        logger.debug("===> Bean [" + method.getBean() + "]");

        //return super.preHandle(request, response, handler);
        String headerKey;
        String headerValue;
        Enumeration<String> headerNames = request.getHeaderNames();

        logger.info("=====Header Info.===============");
        if("".equals(headerNames)) {
            while (headerNames.hasMoreElements()) {
                headerKey = headerNames.nextElement();
                headerValue = request.getHeader(headerKey);
                logger.info("[" + headerKey + "] :" + headerValue);
            }
        }


        return true;
    }

    /**
     * controller 메서드가 끝나고 아직 화면 처리가 되기 직전에 호출이 된다
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        logger.debug("===> postHandler() call~!!!");

        Object result = modelAndView.getModel().get("result");

        if(result != null) {
            request.getSession().setAttribute("result", result);
            //response.sendRedirect("/doA");
        }

    }
}
