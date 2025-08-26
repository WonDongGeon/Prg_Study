package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	@Autowired
	UserMapper usermapper;
	
	public List<User> findAll(){
		return usermapper.findAll();
	}

	public User findByUsername(String username) {
		return usermapper.findByUsername(username).get();
	}
}
