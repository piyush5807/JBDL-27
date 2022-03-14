package com.example.jbdl.demobeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController2 {

    @Autowired
    @Qualifier("bean2")
    private RestTemplate restTemplate;


    // Template will be different

//    @Autowired
//    DemoConfig demoConfig;

    private static Logger logger = LoggerFactory.getLogger(DemoController2.class);

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@RequestParam("id") int id,
                           @RequestParam(value = "l", required = false, defaultValue = "200") int l,
                           @RequestParam(value = "b", required = false, defaultValue = "300") int b){

        String url = "https://picsum.photos/id/" + id + "/" + l + "/" + b; // StringBuilder

//        RestTemplate restTemplate = demoConfig.getTemplate();

        RestTemplate restTemplate1 = new RestTemplate();
        logger.info("restTemplate {}", restTemplate);

        byte[] response = restTemplate.getForObject(url, byte[].class);

        return response;
    }
}
