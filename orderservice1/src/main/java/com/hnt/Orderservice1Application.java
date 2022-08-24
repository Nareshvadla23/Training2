package com.hnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class Orderservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Orderservice1Application.class, args);
	}

}
