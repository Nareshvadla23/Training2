package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.UserRepository;
import com.hnt.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepository UserRepository;

	public void saveUser(User user) {
		UserRepository.save(user);
	}

	public Iterable<User> getUser() {
		return UserRepository.findAll();
	}

}
