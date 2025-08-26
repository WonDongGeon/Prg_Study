package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//입력
	@PostMapping("user")
	public ResponseEntity<Map<String,Object>> postUser
	(@RequestBody User entity) {
		Map<String,Object> response =new HashMap<>();
		int status=service.register(entity);
		System.out.println(status);
		
		if(status>0) {
			response.put("status","success");
			response.put("message","회원등록성공");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		
		response.put("status","fail");
		response.put("message","회원등록실패");
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}
	//수정
	@PutMapping("user/{id}")
	public ResponseEntity<Map<String, Object>> putUser(@PathVariable String username, @RequestBody User entity) {
		Map<String,Object> response =new HashMap<>();
		Optional<User> user = service.update(entity);
		if (user.isEmpty()) {
		       response.put("status", "fail");
		       response.put("message", "사용자정보 update 실패");
		       return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		        
		response.put("status", "success");
		response.put("message", "사용자 정보 update 성공");
		response.put("user", user.get());
		return new ResponseEntity<>(response, HttpStatus.OK);		
	}
	//삭제(ajax(o), curl)
	@DeleteMapping("user/{username}")
	public ResponseEntity<Map<String, Object>> 
	deleteUser(@PathVariable String username) {
		System.out.println(username);
		Map<String,Object> response =new HashMap<>();
		int status=service.deleteByUsername(username);
		if(status>0) {
			response.put("status","success");
			response.put("message","회원삭제성공");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		
		response.put("status","fail");
		response.put("message","회원삭제실패");
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}
}
