package com.example.serviceApi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.User;

@RestController
@RequestMapping("/api")
public class MainController {

	/*
	@GetMapping("/")
	public String index() {
	return "service-api";
	}
	*/
	
	
	@GetMapping("/")
	public User index() {
		User user=new User();
		user.setUsername("admin");
		user.setPassword("1234");
		return user;
	}
	
}
