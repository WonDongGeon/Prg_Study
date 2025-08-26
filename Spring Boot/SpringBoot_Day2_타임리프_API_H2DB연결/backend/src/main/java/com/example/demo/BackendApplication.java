package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Builder;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	@Autowired
	PersonJPA jpa;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		System.out.println(jpa.findAll());
		
		//lombok설치 확인
		for(Person p:jpa.findAll()) {
			System.out.println(p.getEmail());
		}
		*/
		
		//시나리오
		//1)자동증가하는 id에 값을 입력하여 처리 - 오류발생(unsaved-value mapping was incorrect)
		//2)id를 제외하고 입력처리 - 성공(auto_increment가 있을 경우 id는 제외)
		//3)id를 제외하고 입력처리 후 전체보기 실행 - 오류발생할 수도 있음
		/*
		Person p=new Person();
		//p.setId(200);
		p.setName("sangsu500");
		p.setEmail("sangsu500@gmail.com");
		jpa.save(p);
		
		System.out.println(jpa.findAll());
		*/
		
		//삭제
		/*
		jpa.deleteById(352);
		System.out.println(jpa.findAll());
		*/
		//여러개의 id를 입력하여 삭제(302,252,200,152,102,52)
		//List<Integer> ids=Arrays.asList(new Integer(302),new Integer(252));
		//List<Integer> ids=Arrays.asList(200,152);
		//int[] ids= {152,102,52};
		//jpa.deleteAllById(Arrays.stream(ids).boxed().collect(Collectors.toList()));
		//System.out.println(jpa.findAll());
		
		//수정 : id가 db에 입력되어 있는 상태여야하며 없을 경우 단순입력으로 처리, 입력처리하고 같음
		//기존의 데이터를 불러와서 변경되는 값에 대해서만 수정하고 다른값은 동일하게 입력처
		/*
		Person p=new Person();
		p.setId(1);
		p.setName("hongkildong1");
		//p.setEmail("hong@gmail.com");//주석처리할 경우 오류 발생
		jpa.save(p);
		System.out.println(jpa.findAll());
		*/
		
		//위의 문제를 해결하는 방법(필요한 값만을 수정하는 방법)
		//System.out.println(jpa.findById(1)); //Optional형태(Person객체가 아니라는 의미)
		//System.out.println(jpa.findById(1).get().getName());
		
		/*
		Person p=jpa.findById(1).get();
		p.setName("홍길동");
		jpa.save(p);
		System.out.println(jpa.findAll());
		*/
		//optional을 사용하는 이유는 검색한 데이터가 존재할 수도, 안 할수도 있기 때문
		/*
		if(jpa.findById(1).isEmpty()) {
			System.out.println("검색한 데이터가 존재하지 않습니다.!");
		}else {
			System.out.println("검색한 데이터가 존재합니다.!");
		}
		*/
		
		//시나리오. 객체리스트로 여러명의 데이터가 존재하는 경우 한번에 데이터를 입력처리방법
		//List<Person> list=new ArrayList<>();
		//id는 넣을 수 없는 상태, id를 제외한 필드생성자를 생성해야하지만 대신하여 build처리@Builder
		//list.add(new Person("user1","1234")); 코드 대신 아래 builder사용
		/*
		for(int i=1;i<10;i++)
		list.add(Person.builder().name("user"+i).email("user"+i+"@gmail.com").build());
		
		System.out.println(list);
		
		jpa.saveAll(list);
		*/
		//System.out.println(jpa.findAll()); 
		//오류발생, 원인은 동시에 db사용관련 트랙잭션오류발생
		
		
		
	}

}
