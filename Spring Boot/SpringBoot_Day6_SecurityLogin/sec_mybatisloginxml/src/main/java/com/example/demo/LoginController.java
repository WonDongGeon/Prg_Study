package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class LoginController {

	@GetMapping("login")
	public String getLogin() {
		System.out.println("실행!!!");
		return "login";
	}
	
	@PostMapping("login")
	public String postLogin(User user) {
		System.out.println(user.getUsername());
		return null;
	}
	
	// http://localhost:8888/user/deleteform
	@GetMapping("/user/deleteform")
	public String deleteform() {
		return "userdelete";
	}
}
