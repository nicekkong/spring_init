/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 5. 오후 11:49
 * Description  : 
 ******************************************************/
package com.nicekkong.board.controller;

import com.nicekkong.board.domain.Criteria;
import com.nicekkong.board.domain.PageMaker;
import com.nicekkong.board.domain.Reply;
import com.nicekkong.board.service.ReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/replies")
public class ReplyController {

    private final static Logger logger = LoggerFactory.getLogger(ReplyController.class);

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody Reply reply) {  // ResponseEntity

        ResponseEntity<String> entity;
        try {
            replyService.addReply(reply);
            entity = new ResponseEntity<>("SUCCESS -- ", HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
    public ResponseEntity<List<Reply>> listReply (@PathVariable("bno")int bno){

        ResponseEntity<List<Reply>> entity = null;
        try {
            entity = new ResponseEntity<List<Reply>>(
                    replyService.listReply(bno), HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

//    @RequestMapping(value = "/{rno}", method = {RequestMethod.PUT, RequestMethod.PATCH})
//    public Map<String, Object> update(@PathVariable("rno")int rno, @RequestBody Reply reply) {
//
//        Map<String, Object> result = new HashMap<>();
//
//        try {
//            reply.setRno(rno);
//            replyService.modifyReply(reply);
//            result.put("result", "success");
//        } catch (Exception e) {
//            logger.error(e.getLocalizedMessage());
//            result.put("result", "fail");
//        }
//
//        return result;
//    }
    @RequestMapping(value = "/{rno}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<String> update(@PathVariable("rno")int rno, @RequestBody Reply reply) {
        ResponseEntity<String> entity;

        try {
            reply.setRno(rno);
            replyService.modifyReply(reply);

            entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
    public ResponseEntity<String> remove(@PathVariable("rno")int rno) {

        ResponseEntity<String> entity ;

        try {
            replyService.removeReply(rno);

            entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @RequestMapping(value = "/{bno}/{page}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> listPage(@PathVariable("bno")int bno,
                                                        @PathVariable("page")int page) {
        ResponseEntity<Map<String, Object>> entity = null;

        try{
            Criteria cri = new Criteria();
            cri.setPage(page);

            PageMaker pageMaker = new PageMaker();
            pageMaker.setCri(cri);

            Map<String, Object> map = new HashMap<>();
            List<Reply> list = replyService.listReplyPage(bno, cri);

            map.put("replyList", list);

            int replyCount = replyService.count(bno);
            pageMaker.setTotalCount(replyCount);

            map.put("pageMaker", pageMaker);

            entity = new ResponseEntity<>(map, HttpStatus.OK);

        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
