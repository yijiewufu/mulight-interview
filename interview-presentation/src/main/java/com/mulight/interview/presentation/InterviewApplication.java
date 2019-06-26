package com.mulight.interview.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.mulight")
public class InterviewApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
	}

}
