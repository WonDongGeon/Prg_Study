package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//수정된 코드 (ResponseEntity 사용)
@RestController
@RequestMapping("/api")
public class PersonAPI {
	
	@Autowired
	PersonJPA personJpa;
	
	
	@GetMapping("persons")
	public List<Person> getPersons(){
		return personJpa.findAll(); 
	}
	
	@GetMapping("person/{id}") //person 1번 id를 표시할 경우 person/1
	//@RequestParam /api/person?id=1
	//@RequestAttribute 클래스 함수의 파라메다를 들고오는 속성
	//@PathVariable /api/person/1
	public Person getPerson(@PathVariable Integer id){
		return personJpa.findById(id).get(); 
	}
	
	//http://localhost:8888/api/person?id=1
	@GetMapping("person")
	public Person getPersonParam(@RequestParam Integer id){
		return personJpa.findById(id).get(); 
	}
	
	//curl or javascript ajax로 확인
	//curl -v -X DELETE http://localhost:8888/api/person/1 
	//curl사용시 method는 대문자를 사용
	@DeleteMapping("person/{id}")
	public String deletePerson(@PathVariable Integer id){
		personJpa.deleteById(id);
		return "삭제성공";
	}
	
	//입력
	/* 
	 curl -v -X POST http://localhost:8888/api/person 
	 -H "Content-Type:application/json"
	 -d "{\"name\":\"user100\",\"email\":\"user100@gmail.com\"}"
	 */
	@PostMapping("person")
	public String postPerson(@RequestBody Person person) {
		personJpa.save(person);
		return "입력성공";
	}
	
	
	//수정
	/* 
	 curl -v -X PUT http://localhost:8888/api/person 
	 -H "Content-Type:application/json"
	 -d "{\"id\":603,\"name\":\"user\",\"email\":\"user@gmail.com\"}"
	 */
	@PutMapping("person")
	public String putPerson(@RequestBody Person person){
		Person dbperson=personJpa.findById(person.getId()).get();
		//수정하려는 person에 데이터가 null일 경우 dbperson을 그대로 사용 
		if(person.getName()!=null) dbperson.setName(person.getName());
		if(person.getEmail()!=null) dbperson.setEmail(person.getEmail());
		personJpa.save(dbperson);
		return "수정성공";
	}
	
	
	
	/*
	@GetMapping("persons")
	public ResponseEntity<List<Person>> getPersons() {
	    List<Person> persons = personJpa.findAll();
	    if (persons.isEmpty()) {
	        return ResponseEntity.noContent().build(); // 204 No Content if no persons found
	    }
	    return ResponseEntity.ok(persons); // 200 OK with the list of persons
	}
	*/

	//----------------------------------------------------------
	//ReponseEntity 사용
	/*
	@Autowired
    PersonJPA personJpa;

    // 전체 목록 조회
    @GetMapping("persons")
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> persons = personJpa.findAll();
        return ResponseEntity.ok(persons);
    }

    // ID로 조회 (PathVariable)
    @GetMapping("person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
        return personJpa.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ID로 조회 (RequestParam)
    @GetMapping("person")
    public ResponseEntity<Person> getPersonParam(@RequestParam Integer id) {
        return personJpa.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 삭제
    @DeleteMapping("person/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        if (personJpa.existsById(id)) {
            personJpa.deleteById(id);
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();   // 404 Not Found
        }
    }

    // 등록
    @PostMapping("person")
    public ResponseEntity<String> postPerson(@RequestBody Person person) {
        personJpa.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("입력성공");
    }

    // 수정
    @PutMapping("person")
    public ResponseEntity<String> putPerson(@RequestBody Person person) {
        return personJpa.findById(person.getId())
                .map(dbPerson -> {
                    if (person.getName() != null) dbPerson.setName(person.getName());
                    if (person.getEmail() != null) dbPerson.setEmail(person.getEmail());
                    personJpa.save(dbPerson);
                    return ResponseEntity.ok("수정성공");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 ID를 찾을 수 없습니다"));
    }*/
	
}
