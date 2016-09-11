/******************************************************
 * Project Name : board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 11. 오후 2:07
 * Description  : 
 ******************************************************/
package com.nicekkong.board.controller;

import com.nicekkong.board.domain.User;
import com.nicekkong.board.dto.Login;
import com.nicekkong.board.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value ="/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void loginGET(@ModelAttribute("login")Login login) {

    }

    @RequestMapping(value = "/loginPOST", method = RequestMethod.POST)
    public void loginPOST(@ModelAttribute("login")Login login, HttpSession session, Model model) throws Exception {

        User user = userService.login(login);

        if(user == null) {
            return;
        }
        model.addAttribute("user", user);
    }
}
