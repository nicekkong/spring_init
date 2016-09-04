/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 4. 오후 9:00
 * Description  : 
 ******************************************************/
package com.nicekkong.board.controller;

import com.nicekkong.board.domain.RestSampleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sample")
public class SampleRestController {

    Logger logger = LoggerFactory.getLogger(SampleRestController.class);

    @RequestMapping(value = "/hello")
    // @ResponseBody  // @RestController로 선언된 class의 매서드는 @ResponseBody가 이미 선언된 것과 동일하다
    public String sayHello() {
        return "Hello Nicekkong's World";       //  Response : Content-Type: text/html;charset=ISO-8859-1
    }

    @RequestMapping(value = "/mapSample")
    public Map<String, Object> mapSample() {
        Map<String, Object> result = new HashMap<>();

        Map<String, String> subject = new HashMap<>();
        subject.put("java", "1001001");
        subject.put("Object-C", "200425");
        subject.put("Data Structure", "1005345");

        result.put("subject", subject);

        result.put("name", "nicekkong");
        result.put("student id", "2002560");

        return result;      // Response : Content-Type:application/json;charset=UTF-8
    }

    @RequestMapping(value = "/sendVO")
    public RestSampleVo sendVO() {

        RestSampleVo vo = new RestSampleVo();

        //vo.setMno(123);
        //vo.setFristName("nicek");
        vo.setLastName("kkong");

        return vo;
    }

    @RequestMapping(value = "/sendErrorAuth")
    public ResponseEntity<Void> sendListAuth() {



        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
