package com.example.demo;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity // Error creating bean with name 'personJPA' defined in PersonJPA
//@Table //테이블 생성
//@Builder // api사용시 builder를 사용할 경우 500에러 발생
public class Person {
	
	@Id
	@GeneratedValue//이 코드 역할이 자동으로 시퀀스를 생성하는 역할
	private Integer id;
	private String name;
	private String email;
	
	
}
