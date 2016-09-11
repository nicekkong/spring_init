/******************************************************
 * Project Name : board
 * File Name    : MessageController.java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 10. 오후 8:54
 * Description  : 
 ******************************************************/
package com.nicekkong.board.controller;

import com.nicekkong.board.domain.Message;
import com.nicekkong.board.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    private final static Logger logger = LoggerFactory.getLogger(MessageController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    //@ResponseBody
    public ResponseEntity<String> addMessage(@RequestBody Message message) {

        logger.info(">>>>>> call addMessage()");
        ResponseEntity<String> entity = null;
        try {
            messageService.addMessage(message);
            entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

}
