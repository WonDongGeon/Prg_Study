package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public String index(Model model) {
		 model.addAttribute("message", "Hello, Spring Boot!");
	     return "index"; // src/main/resources/templates/index.html 를 의미
	}
}
