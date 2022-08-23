package com.hnt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.User;
import com.hnt.service.userService;

@RestController
@RequestMapping("/user")
public class userController {

	@Autowired
	userService userservice;

	@GetMapping
	String getUser() {
		return "test";
	}

	@PostMapping("/age/{age}")
	void saveUser(@Valid @RequestBody User user, @PathVariable("age") int age) {

		userservice.saveUser(user);
		System.out.println(user.getAge());
		System.out.println(user.getName());

	}

	@PostMapping
	void saveUser1(@Valid @RequestBody User user) {

		userservice.saveUser(user);
		System.out.println(user.getAge());
		System.out.println(user.getName());

	}
	@GetMapping("/all")
	 Iterable<User> getUser1()
	 {
		 return userservice.getUser();
	 }
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String, String> handlingException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldname = ((FieldError) error).getField();

			String message = ((FieldError) error).getDefaultMessage();

			errors.put(fieldname, message);

		});

		return errors;
	}

}
