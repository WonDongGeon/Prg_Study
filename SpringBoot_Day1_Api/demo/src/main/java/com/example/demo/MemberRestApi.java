package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberRestApi {
	
	/*
	@GetMapping("members")
	public String members() {
		String members= "["
				+ "{\"id\":1, \"user\":\"admin\", \"email\":\"admin@gmail.com\"}"
				+ "{\"id\":2, \"user\":\"admin\", \"email\":\"admin@gmail.com\"}"
				+ "{\"id\":3, \"user\":\"admin\", \"email\":\"admin@gmail.com\"}"
				+ "{\"id\":4, \"user\":\"admin\", \"email\":\"admin@gmail.com\"}"
				+ "{\"id\":5, \"user\":\"admin\", \"email\":\"admin@gmail.com\"}"
	            + "]";
		return members;
	}
	*/
	
	@GetMapping("members")
	public List<Member> members() {
		List<Member> members = new ArrayList<>();
		members.add(new Member(1, "admin", "admin@gmail.com"));
		members.add(new Member(2, "admin2", "admin2@gmail.com"));
		members.add(new Member(3, "admin3", "admin3@gmail.com"));
		members.add(new Member(4, "admin4", "admin4@gmail.com"));
		members.add(new Member(5, "admin5", "admin5@gmail.com"));
		
		return members;
	}
}
