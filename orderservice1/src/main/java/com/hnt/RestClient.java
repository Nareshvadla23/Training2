package com.hnt;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hnt.entity.User;

public class RestClient {

	private static final String URL = "http://localhost:8082/user";

	public static void main(String[] args) {

		 get();
		post();

	}

	private static void post() {
		User user = new User();

		user.setAge(32);
		user.setName("rohit");

		RestTemplate rs = new RestTemplate();

		Object response = rs.postForEntity(URL, user, Integer.class);

		System.out.println(response);

	}

	private static void get() {
		RestTemplate rs = new RestTemplate();

		ResponseEntity<String> response = rs.getForEntity(URL, String.class);

		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
	}

}
