package com.example.jbdl.demobeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo3")
public class DemoController3 {

    @Autowired
    DemoConfig demoConfig;

    @PostMapping("/config")
    public String getConfig(){
        return demoConfig.getConfig();
    }
}
