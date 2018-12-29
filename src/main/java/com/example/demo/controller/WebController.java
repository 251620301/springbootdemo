package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class WebController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public User getUser() {
        User user = userRepository.findByName("aa");
        System.out.println("测试成功！！！");
        return user;
    }
    @RequestMapping("uid")
    String uid(HttpSession session) {
        UUID uuid = (UUID)session.getAttribute("uid");
        if(uuid == null) {
            uuid = UUID.randomUUID();
        }
        session.setAttribute("uid",uuid);
        return session.getId();
    }
}
