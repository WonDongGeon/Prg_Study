package com.example.demo;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	//src/webapp/WEB-INF/index.jsp
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//src/webapp/WEB-INF/login.jsp
	//로그인처리
	@PostMapping("login")
	@ResponseBody
	public String login(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		byte[] decodedBytes = Base64.getDecoder().decode(password);
        password = new String(decodedBytes);
        System.out.println("Decoded String: " + password);
		return null;
	}
	//비대칭 암호화 해석
	@PostMapping("/login2")
	@ResponseBody
	public String login2(String username, String password) throws Exception {
		System.out.println("username:"+username);	
		System.out.println("base64+aes:"+password);
		
		byte[] decodedBytes = Base64.getDecoder().decode(password);
        String encryptedPassword = new String(decodedBytes);
        System.out.println("base 64 Decoded String: " + encryptedPassword);
        /*
        String key = "abcdkey";  // 암호화에 사용한 키
        // AES 복호화
       String decryptedPassword = decryptPassword(encryptedPassword, key);
       System.out.println("복호화된 비밀번호: " + decryptedPassword);
       */
		return "성공";
	}
	
	//gpt:자바 aes 복호화 함수 
	 public static String decryptPassword(String encrypted, String key) throws Exception {
	        // Cipher 인스턴스 생성: AES/ECB/PKCS5Padding
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

	        // 키 지정 (16, 24, 32 바이트만 가능)
	        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

	        // 복호화 초기화
	        cipher.init(Cipher.DECRYPT_MODE, keySpec);

	        // Base64로 인코딩된 암호문 디코딩
	        byte[] decodedBytes = Base64.getDecoder().decode(encrypted);

	        // 복호화 수행
	        byte[] decryptedBytes = cipher.doFinal(decodedBytes);

	        return new String(decryptedBytes, "UTF-8");
	    }

}
