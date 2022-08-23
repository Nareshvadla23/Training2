package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.userRepository;
import com.hnt.entity.User;

@Service
public class userService {
	
	@Autowired
	userRepository UserRepository;

	public void saveUser(User user) {
		UserRepository.save(user);
	}

}
