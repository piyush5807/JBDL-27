package com.example.jbdl.demobeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {

    private static Logger logger = LoggerFactory.getLogger(DemoController2.class);

    @Autowired
    DemoConfig demoConfig2;

    @PutMapping("/config")
    public String getConfig(){
        logger.info("demoConfig2 is {}", demoConfig2);
        return demoConfig2.getConfig();
    }


    // demoConfig2 is com.example.jbdl.demobeans.DemoConfig$$EnhancerBySpringCGLIB$$8e3cbb44@5a580161
    // demoConfig is com.example.jbdl.demobeans.DemoConfig$$EnhancerBySpringCGLIB$$8e3cbb44@5a580161
    // demoConfig is com.example.jbdl.demobeans.DemoConfig$$EnhancerBySpringCGLIB$$8e3cbb44@5a580161
}
