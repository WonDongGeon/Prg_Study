package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
	@Insert("INSERT INTO USERS (username,password) "
			+ "VALUES (#{username}, #{password})")
	int save(User user);
	@Select("SELECT username, password FROM USERS")
	List<User> findAll();
	@Select("SELECT username, password FROM users "
			+ "WHERE username = #{username}")
	Optional<User> findByUsername(String username);
	@Update("UPDATE USERS SET password = #{password} "
			+ "WHERE username = #{username}")
	int update(User user);
	@Delete("DELETE FROM USERS WHERE username = #{username}")
	int delete(String username);
}
