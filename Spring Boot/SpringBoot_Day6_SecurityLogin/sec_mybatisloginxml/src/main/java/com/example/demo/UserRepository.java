package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	@Autowired
	UserMapper usermapper;
	
	public List<User> findAll(){
		return usermapper.findAll();
	}

	public Optional<User> findByUsername(String username) {
		return usermapper.findByUsername(username);
	}

	public int save(User user) {
		return usermapper.save(user);
	}

	public int update(User user) {
		return usermapper.update(user);
	}

	public int delete(String username) {
		return usermapper.delete(username);
	}
}
