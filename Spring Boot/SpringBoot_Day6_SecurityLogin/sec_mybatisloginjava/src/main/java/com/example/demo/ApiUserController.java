package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiUserController {

	@Autowired
	UserService service;
	
	@GetMapping("users")
	public ResponseEntity<List<User>> getUsers(){
		 List<User> users = service.findAll();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("user/{username}")
	public ResponseEntity<User> 
	getUser(@PathVariable String username){
		 User user = service.findByUsername(username);
		return ResponseEntity.ok(user);
	}
}
