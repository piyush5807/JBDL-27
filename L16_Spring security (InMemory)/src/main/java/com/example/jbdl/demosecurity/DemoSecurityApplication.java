package com.example.jbdl.demosecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("jim123"));
		System.out.println(bCryptPasswordEncoder.encode("john123"));
		System.out.println(bCryptPasswordEncoder.encode("catalina123"));


	}

	/*
	$2a$10$JN7Awz4.lRMn.tPZrUq2qeLmnnyZ4KFO321jMn2joTgb3Z8J02I4m
	$2a$10$MbPXsheem0LKgFjuSrvbMeQHmopgj2WrnaL/Ksjn78ghLS/NHp9fi
	$2a$10$TKMqp/oqs6wBqhLPHtpzeu7VTw7zlM91Qrk2vLeJmIyG4T/N5xKya
	 */

	/*
	$2a$10$ZgXiJrz9C7S.I31qwNBxvuL285jFcFHSAJeWLc.cmwXAorIxc016S
	$2a$10$NB6jJ1PyOHRxUSmsyWltP.3Lm/5kO6j.XcSv2vNwGdJHeyqJ5v9NC
	$2a$10$n5XwnxrXSy7Gy1OkzOu17.CajEuPFn5K.FLgy54.opTJaI1nihCAa

	 */

}
