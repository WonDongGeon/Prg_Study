package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class MainController {

	
	///@GetMapping("index")
	@GetMapping("${url.index}")
	public String index() {
		return "index";
	}
	
	//URL 경로를 application.properties 또는 application.yml 파일에 정의한 url.index 값을 참조합니다. (ex: /index 등)
	@GetMapping("${url.login}")
	@ResponseBody
	public String login() {
		return "login";
	}
	
	@GetMapping("${url.logout}")
	@ResponseBody // ResponseBody는 페이지가 아닌 텍스트임.
	public String logout() {
		return "logout";
	}
 }
