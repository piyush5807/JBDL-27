package com.example.jbdl.demosecuritydb;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String greet(){
        return "Hi User!!";
    }

    @GetMapping("/devops")
    public String greetDevops(){
        MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hi Devops " + user.getUsername() + "!!!";
    }

    @GetMapping("/developer")
    public String greetDeveloper(){
        MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hi Developer " + user.getUsername() + "!!!";
    }

    /**
     * Sign up API
     * Input - Username, Raw Pwd, Authorities
     * Process - Save the user, but before saving make sure to encode the password
     * Note : This API should be unsecured
     */

}
