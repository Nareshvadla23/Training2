package com.hnt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

	@GetMapping
	String getUser() {
		return "test";
	}

}
