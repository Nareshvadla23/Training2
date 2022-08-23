package com.hnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.User;
import com.hnt.service.userService;

@RestController
public class userController {
	
	@Autowired
	userService userservice;


	@GetMapping
	String getUser() {
		return "test";
	}
	
	@PostMapping
	void saveUser(@RequestBody User user) {

		userservice.saveUser(user);
		System.out.println(user.getAge());
		System.out.println(user.getName());

	}


}
