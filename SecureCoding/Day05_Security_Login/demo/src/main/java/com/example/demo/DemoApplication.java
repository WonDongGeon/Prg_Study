package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@Controller
@RequiredArgsConstructor

public class DemoApplication {

	final SiteUserResposity resp; //jpa구현

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//회원가입 폼
	@RequestMapping("/creatememberform")
	public String creatememberform() {
	return "createmember";
	}

	//회원가입처리 th:action="@{/creatememberProc}"
	@RequestMapping("/creatememberProc")
	public String creatememberProc(@Validated SiteUser user) {
	//패스워드 암호화
	BCryptPasswordEncoder passencoder=new BCryptPasswordEncoder();
	user.setPassword(passencoder.encode(user.getPassword()));
	System.out.println(user.toString());
	//db에 암화화된 데이터를 입력
	resp.save(user);
	return "login";
	}


	//로그인 폼
	@GetMapping("/login")
	public String login() {
	return "login";
	}

	


}
