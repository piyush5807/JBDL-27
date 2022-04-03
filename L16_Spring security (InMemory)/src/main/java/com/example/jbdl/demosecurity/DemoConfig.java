package com.example.jbdl.demosecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter {

    // developer
    // devops

    private static final String DEVELOPER_AUTHORITY = "developer";
    private static final String DEVOPS_AUTHORITY = "devops";


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Jim")
                .password("$2a$10$JN7Awz4.lRMn.tPZrUq2qeLmnnyZ4KFO321jMn2joTgb3Z8J02I4m")
                .authorities(DEVELOPER_AUTHORITY)
                .and()
                .withUser("John")
                .password("$2a$10$MbPXsheem0LKgFjuSrvbMeQHmopgj2WrnaL/Ksjn78ghLS/NHp9fi")
                .authorities(DEVOPS_AUTHORITY)
                .and()
                .withUser("Catalina")
                .password("$2a$10$TKMqp/oqs6wBqhLPHtpzeu7VTw7zlM91Qrk2vLeJmIyG4T/N5xKya")
                .authorities(DEVOPS_AUTHORITY, DEVELOPER_AUTHORITY);
    }

    // IMP NOTE: Always define your matches from most restricted to least restrcited manner
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers("/devops/**").hasAuthority(DEVOPS_AUTHORITY)
                .antMatchers(HttpMethod.POST, "/developer/**").hasAuthority(DEVOPS_AUTHORITY)
                .antMatchers("/developer/**").hasAuthority(DEVELOPER_AUTHORITY)
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }

//    @Bean
//    public PasswordEncoder getPE(){
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}

// Kamal@gmail.com
// kamal123 --> ks3e5r8ua2i4bhSHB
