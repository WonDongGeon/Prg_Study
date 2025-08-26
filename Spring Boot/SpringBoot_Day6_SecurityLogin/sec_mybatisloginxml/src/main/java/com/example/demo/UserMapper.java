package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	int save(User user);
	List<User> findAll();
	Optional<User> findByUsername(String username);
	int update(User user);
	int delete(String username);
}
