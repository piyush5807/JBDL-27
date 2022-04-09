package com.example.jbdl.minorproject1;

import com.example.jbdl.minorproject1.security.User;
import com.example.jbdl.minorproject1.security.UserRepository;
import com.example.jbdl.minorproject1.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MinorProject1Application implements CommandLineRunner {

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(MinorProject1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		User user = User.builder()
//				.username("sagar@gmail.com")
//				.password(passwordEncoder.encode("sagar123"))
//				.authority("adm")
//				.build();
//
//		userService.createUser(user);
	}
}
