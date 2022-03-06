package com.example.jbdl.demobeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("mycontroller")
public class DemoController {

    @Autowired // This annotation tells spring to inject the already created bean in this class
    DemoConfig demoConfig;

    /**
     * IOC - Instead of you creating an object yourself, spring will be creating one for you
             but you need to notify spring for that by writing annotations or xml files
            After the object is created by spring, it will be stored in IOC container / Application context
     **/

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/dummy")
    public String generateRandomStr(){
        System.out.println("Inside generateRandomStr function at time " + System.currentTimeMillis());
        String randomString = UUID.randomUUID().toString();
        logger.error("randomString is {} at time {}", randomString, System.currentTimeMillis());
        logger.warn("randomString is {} at time {}", randomString, System.currentTimeMillis());
        logger.info("randomString is {} at time {}", randomString, System.currentTimeMillis());
        logger.debug("randomString is {} at time {}", randomString, System.currentTimeMillis());
        logger.trace("randomString is {} at time {}", randomString, System.currentTimeMillis());


        return randomString;
    }


    @GetMapping("/config")
    public String getConfig(){

        logger.info("demoConfig is {}", demoConfig);
        return demoConfig.getConfig(); // null.something -> NPE
    }

    // demoConfig is com.example.jbdl.demobeans.DemoConfig@66e371e
    // demoConfig is com.example.jbdl.demobeans.DemoConfig@67a773bc
    // demoConfig is com.example.jbdl.demobeans.DemoConfig@35d4d35



    // demoConfig is com.example.jbdl.demobeans.DemoConfig@43924568
    // demoConfig is com.example.jbdl.demobeans.DemoConfig@43924568
    // demoConfig is com.example.jbdl.demobeans.DemoConfig@43924568
}
