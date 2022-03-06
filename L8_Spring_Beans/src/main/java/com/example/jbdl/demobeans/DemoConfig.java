package com.example.jbdl.demobeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@Configuration("myConfig")
//@Scope("singleton") // this is just a waste of effort
//@Scope("prototype")
public class DemoConfig {

    /**
     * For prototype beans, the object is initialized when it is required / autowired by some other beans
     * For singleton beans, the object is created in the beginning itself irrespective of whether it is autowired or not
     */

    private static Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    public DemoConfig(){
        System.out.println("In demo config constructor....");
    }

    public String getConfig(){
        return "Config::" + UUID.randomUUID();
    }
}
