package com.hnt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.User;
import com.hnt.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;

	@GetMapping("/all")
	String getUser() {
		return "test";
	}

	@PostMapping("/age/{age}")
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity saveUser(@Valid @RequestBody User user, @PathVariable("age") int age) {

		userservice.saveUser(user);
		System.out.println(user.getAge());
		System.out.println(user.getName());
		System.out.println(user.getAddress());
		MultiValueMap headers = new LinkedMultiValueMap<String, String>();

		headers.add("headerfromserver", "success");

		ResponseEntity response = new ResponseEntity<>(user,headers, HttpStatus.CREATED);

		return response;

	}

	@PostMapping
	Integer saveUser1(@Valid @RequestBody User user) {

		userservice.saveUser(user);
		System.out.println(user.getAge());
		System.out.println(user.getName());
		System.out.println(user.getAddress());
		
		return user.getId();

	}

	@GetMapping
	Iterable<User> getUser1() {
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
	
	@DeleteMapping("/{userid}")
	void deleteUser(@PathVariable int userid) {
		userservice.delete(userid);	
	}

}
