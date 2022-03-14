package com.example.jbdl.demobeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration(value = "myconfig") // - Used for component scanning
public class DemoConfig {

    // @Component - This annotation is used to define our own class as a bean
    // @Bean - This annotation is used to define beans of objects which are part of source code

    /**
     * Bean is stored as a Key - Value pair in the IOC container
     * Key is the bean name, value is the object reference (object type)
     * Component annotation - by default the bean name is the class name in camel case
     * Bean annotation - by default the bean name is the method name in camel case
     **/
    @Bean("bean1")
//    @Scope("prototype")
    public RestTemplate getTemplate(){
        System.out.println("In getTemplate function....");
        return new RestTemplate();
    }

    @Bean("bean2")
    public RestTemplate getTemplate2(){
        System.out.println("In getTemplate2 function....");
        return new RestTemplate();
    }
}
