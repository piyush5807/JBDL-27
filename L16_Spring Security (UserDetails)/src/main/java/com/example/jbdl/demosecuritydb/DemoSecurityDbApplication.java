package com.example.jbdl.demosecuritydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DemoSecurityDbApplication implements CommandLineRunner{

	private static final String DEVELOPER_AUTHORITY = "developer";
	private static final String DEVOPS_AUTHORITY = "devops";

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	// Runnable run()

	// Command Line Runner

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MyUser user1 = MyUser.builder()
				.username("Jim")
				.password(passwordEncoder.encode("jim123"))
				.authorities(DEVELOPER_AUTHORITY)
				.build();

		MyUser user2 = MyUser.builder()
				.username("John")
				.password(passwordEncoder.encode("john123"))
				.authorities(DEVOPS_AUTHORITY)
				.build();

		MyUser user3 = MyUser.builder()
				.username("Catalina")
				.password(passwordEncoder.encode("catalina123"))
				.authorities(DEVELOPER_AUTHORITY + "," + DEVOPS_AUTHORITY)
				.build();

		userRepository.saveAll(Arrays.asList(user1, user2, user3));
	}
}
