package com.example.jbdl.demosecuritydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Value("${user.authority.developer}")
    private String DEVELOPER_AUTHORITY;

    @Value("${user.authority.devops}")
    private String DEVOPS_AUTHORITY;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

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

    @PostMapping("/signup")
    public MyUser createNewUser(@Valid @RequestBody UserCreateRequest userCreateRequest){

        MyUser myUser = MyUser.builder()
                .username(userCreateRequest.getUsername())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()))
                .authorities(userCreateRequest.getIsDeveloper() ? DEVELOPER_AUTHORITY : DEVOPS_AUTHORITY)
                .build();

        return userService.createUser(myUser);
    }

}
