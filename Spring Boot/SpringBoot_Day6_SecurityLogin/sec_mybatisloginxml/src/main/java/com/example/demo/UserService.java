package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findByUsername(String username) {
		return repository.findByUsername(username).get();
	}

	public int register(User entity) {
		//BeanUtils.copyProperties(entity, entity);
				User user=User.builder()
						.username(entity.getUsername())
						.password(entity.getPassword())
						.build();
				return repository.save(user);
	}

	public Optional<User> update(User entity) {
		// 새로운 user 객체 생성
	    User user = User.builder().build();
	    
	    // DTO에서 user 객체로 값 복사
	    BeanUtils.copyProperties(entity, user);
	    
	    // ID로 사용자 조회
	    Optional<User> opuser = repository.findByUsername(entity.getUsername());
	    
	    if (opuser.isEmpty()) {
	        System.out.println("찾는 아이디 없음");
	        return opuser;  // id가 존재하지 않으면 비어있는 Optional 반환
	    }
	    
	    // DB에서 가져온 기존 user 객체
	    User dbuser = opuser.get();
	    
	    // DTO의 값이 null일 경우 DB에서 가져온 값으로 설정
	    
	    if (user.getUsername() == null) {
	        user.setUsername(dbuser.getUsername());
	    }
	    if (user.getPassword() == null) {
	        user.setPassword(dbuser.getPassword());
	    }
	    
	    
	    System.out.println("*****" + user);
	    
	    // 업데이트 쿼리 실행
	    int status = repository.update(user);
	    
	    // 업데이트 성공 여부 확인
	    if (status == 0) {
	        return Optional.empty();  // 업데이트 실패 시 빈 Optional 반환
	    }	
	    
	    return Optional.of(user);  // 업데이트 성공 시 user 객체 반환
	}

	public int deleteByUsername(String username) {
		return repository.delete(username);
	}
}
