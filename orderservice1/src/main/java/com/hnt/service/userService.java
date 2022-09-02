package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.UserRepository;
import com.hnt.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepository UserRepository;

	public User saveUser(User user) {
		UserRepository.save(user);
		return user;
	}

	public Iterable<User> getUser() {
		return UserRepository.findAll();
	}
	
	public void delete(int userid) {
		UserRepository.deleteById(userid);
	}

}
