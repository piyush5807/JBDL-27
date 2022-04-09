package com.example.jbdl.demosecuritydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class UserConfig extends WebSecurityConfigurerAdapter {

    // developer
    // devops

    @Value("${user.authority.developer}")
    private String DEVELOPER_AUTHORITY;

    @Value("${user.authority.devops}")
    private String DEVOPS_AUTHORITY;


    @Autowired
    private UserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    // IMP NOTE: Always define your matches from most restricted to least restrcited manner
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
//                csrf().disable().
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

    // CSRF - Cross site request forgery


    @Bean
    public PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
