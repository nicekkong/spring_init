/******************************************************
 * Project Name :  board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 9. 2. 오후 11:34
 * Description : 
 ******************************************************/
package com.nicekkong.board.controller;

import com.nicekkong.board.domain.Board;
import com.nicekkong.board.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public void registerGET(Board board, Model model) throws Exception {

        logger.info("register get..........");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPOST(Board board, RedirectAttributes rttr) throws Exception {

        logger.info("regist post...........");
        logger.info(board.toString());


        boardService.regist(board);

        Map<String, String> map = new HashMap<>();
        map.put("test", "1");
        map.put("test2", "2");

        //model.addAttribute("map", map); // value가 Map Object는 보이지 않고..
        //model.addAttribute("result", "success"); // value가 String인 값은 GET 파라메터로 보이게 된다.
        //return "/board/success";

        rttr.addFlashAttribute("msg", "success");   // Redirect 전달 시점시 한번만 사용되는 데이터로 넘어간다.

        return "redirect:/board/listAll";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public void listAll(Model model) throws Exception {

        logger.debug("model : " + model.toString());    // 일반 Model 객체는 아무것도 보이지 않으나,  RedirectAttributes로 전달된 객체의 정보는 보인다.
        logger.info("show all list...............");

        List<Board> boardList = boardService.listAll();
        model.addAttribute("boardList", boardList);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public void read(@RequestParam("bno") int bno, Model model) throws Exception {
        Board board = boardService.read(bno);

        model.addAttribute("board", board);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("bno")int bno, RedirectAttributes rttr) throws Exception {

        boardService.remove(bno);

        rttr.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/board/listAll";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public void modifyGET(int bno, Model model) throws Exception {
        model.addAttribute("board", boardService.read(bno));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyPOST(Board board, RedirectAttributes rttr) throws Exception {

        logger.info("modify post......");

        boardService.modify(board);
        rttr.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/board/listAll";
    }
}
