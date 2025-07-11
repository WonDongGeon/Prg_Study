package test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoding {

	public static void main(String[] args) {
		//라이브러리 : spring-context, spring-security 추가
		// BCryptPasswordEncoder 객체 생성
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        // 원본 패스워드
        String rawPassword = "1234";
        
        // 패스워드를 암호화
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("Encoded password: " + encodedPassword);
        
        // 패스워드 일치 여부 확인
        boolean isMatch = passwordEncoder.matches("1111", encodedPassword);
        System.out.println("Password matches: " + isMatch);

	}

}