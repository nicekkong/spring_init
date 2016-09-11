/******************************************************
 * Project Name :  board
 * File Name    : SampleAdvice.java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 10. 오후 8:30
 * Description  : 
 ******************************************************/
package com.nicekkong.board.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class SampleAdvice {

    private final static Logger logger = LoggerFactory.getLogger(SampleAdvice.class);

    @Before("execution(* com.nicekkong.board.service.MessageService*.*(..))")
    public void startLog(JoinPoint jp) {

        logger.info("---------------------------------");
        logger.info("파라메터 getArgs() : " + Arrays.toString(jp.getArgs()));
        logger.info("Advice 타입 getKind() : " + jp.getKind());
        logger.info("대상 객체 메서드 정보 getSignature"  + jp.getSignature().toString());
        logger.info("target 객체 getTarget() : "  + jp.getTarget());
        logger.info("Advice 행하는 객체 getThis() : "  + jp.getThis());
        logger.info("---------------------------------");
    }


    @Around("execution(* com.nicekkong.board.service.MessageService*.*(..))")
    public Object timeLog(ProceedingJoinPoint point) throws Throwable {
        logger.info("== START timeLog() =======================================");
        long startTime = System.currentTimeMillis();
        logger.info(Arrays.toString(point.getArgs()));

        Object result = point.proceed();        // 실제 메서드를 호출한다.

        long endTime = System.currentTimeMillis();
        logger.info("Method Time : " + point.getSignature().getName() + " : " + (endTime - startTime) + "ms");
        logger.info("== End timeLog() =======================================");

        return result;
    }
}
