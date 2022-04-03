package com.example.jbdl.demosecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String greet(){
        return "Hi User!!";
    }

    @GetMapping("/devops")
    public String greetDevops(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hi Devops " + user.getUsername() + "!!!";
    }

    @GetMapping("/developer")
    public String greetDeveloper(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hi Developer " + user.getUsername() + "!!!";
    }

    @PostMapping("/developer")
    public void createDeveloper(){

    }
}

// Q1. Whenever you add spring-boot-starter-security dependency in your code,
// by default all the API will be secured or only those which we will spring
// to secure

// 20c61b9e-184b-46ab-b9e9-f7299cd32101

// c2ca9da1-a745-4be6-a6d1-b048a52dd838
