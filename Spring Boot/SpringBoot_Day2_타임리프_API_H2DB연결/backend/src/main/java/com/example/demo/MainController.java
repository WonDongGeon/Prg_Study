package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	//@GetMapping("index")
	@GetMapping("${url.index}")
	public String index() {
		return "index";
	}
	
	@GetMapping("${url.login}")
	@ResponseBody
	public String login() {
		return "login";
	}
	
	@GetMapping("${url.logout}")
	@ResponseBody
	public String logout() {
		return "logout";
	}
	
}
