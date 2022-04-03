package com.example.jbdl.demosecuritydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter {

    // developer
    // devops

    private static final String DEVELOPER_AUTHORITY = "developer";
    private static final String DEVOPS_AUTHORITY = "devops";

    @Autowired
    private DemoService demoService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(demoService);
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

    @Bean
    public PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
