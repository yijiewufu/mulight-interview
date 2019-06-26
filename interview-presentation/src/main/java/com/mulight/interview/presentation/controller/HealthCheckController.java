package com.mulight.interview.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@RequestMapping(value = "ping")
	public String healthCheck() {
		return "Up and running";
	}
}
