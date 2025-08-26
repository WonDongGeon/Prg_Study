package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonApi {

	@GetMapping("/api/person")
	public String getPerson() {
		return "{\"name\":\"hongkildong\",\"email\":\"hong@gmail.com\"}";
	}
}
