package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setName("小明");
        user.setWord("XXX");
        return user;
    }
}
