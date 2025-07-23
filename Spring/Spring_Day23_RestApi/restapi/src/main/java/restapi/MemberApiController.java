package restapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

@RestController
@RequestMapping("/api")
public class MemberApiController {

	List<Member> members = new ArrayList<>(Arrays.asList(
			new Member("user1", "1234", "user1@naver.com"),
			new Member("user2", "1234", "user2@naver.com"),
			new Member("user3", "1234", "user3@naver.com"),
			new Member("user4", "1234", "user4@naver.com"),
			new Member("user5", "1234", "user5@naver.com")
	));
	
	//curl  http://localhost:8888/api/member -v -X POST -H "Content-Type:application/json" -d "{\"username\":\"admin\",\"password\":\"1234\",\"email\":\"admin@naver.com\"}"
	@PostMapping("member")
	public ResponseEntity<String> insert(@RequestBody Member member) {
		System.out.println(member);
	    members.add(member);
	    return ResponseEntity.ok("insert success!");
	}

	@GetMapping(value="members",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Member> selectAll() {
	return members;

	}

	@GetMapping(value="member")
	public Member selectById(@RequestBody String username) {
		System.out.println(username);	
		Optional<Member> foundMember = members.stream().filter(m -> m.getUsername().equals(username)).findFirst();
		foundMember.ifPresent(System.out::println);
		return foundMember.get();
	}
	
	/*
	@GetMapping(value = "member/{type}")
	public Member selectById(@PathVariable String type, @RequestParam String name, HttpServletResponse resp) {
	resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
	Optional<Member> foundMember = members.stream().filter(m -> m.getUsername().equals(name)).findFirst();
	foundMember.ifPresent(System.out::println);
	return foundMember.get();

	}
	
	@GetMapping(value = "reen/member/{type}")
	public ResponseEntity<Member> selectByIdReEn(@PathVariable String type, @RequestParam String name, HttpServletResponse resp) {
	if(!type.equals("json") && !type.equals("xml") ) {
	return ResponseEntity.badRequest().build();
	}
	Optional<Member> foundMember = members.stream().filter(m -> m.getUsername().equals(name)).findFirst();
	foundMember.ifPresent(System.out::println);
	return ResponseEntity.ok()
	    .contentType("json".equals(type) ? MediaType.APPLICATION_JSON : MediaType.APPLICATION_XML)
	    .body(foundMember.get());
	}
	 */	
	
	@PutMapping("member")
	public ResponseEntity<?> update(@RequestBody Member member) {

	Optional<Member> foundMember = members.stream().filter(m -> m.getUsername().equals(member.getUsername())).findFirst();
	System.out.println(foundMember.get().hashCode());
	System.out.println(members.get(0).hashCode());
	Member m = foundMember.get();
	m.setPassword(member.getPassword());
	m.setEmail(member.getEmail());
	return ResponseEntity.ok("update success!");
	}

	@DeleteMapping("member")
	public ResponseEntity<?> delete(@RequestBody Member deleteMember) {
	Optional<Member> foundMember 
	= members.stream()
	.filter(m -> m.getUsername().equals(deleteMember.getUsername()))
	.findFirst();
	//( )= >{ } : m->{ }
	members.remove(foundMember.get());

	return ResponseEntity.ok("delete member success!");

	}

	}