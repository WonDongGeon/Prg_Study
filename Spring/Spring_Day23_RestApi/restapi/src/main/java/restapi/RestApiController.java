package restapi;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody //@RestController 함수에 @ResponseBody가 없어도 문자열을 리턴하는 역할
public class RestApiController {
	
	//@GetMapping("/")
	//@ResponseBody //페이지와는 전혀 무관한 코드
	public String index() {
		return "index.jsp";
		//index.jsp -> 문자열로 "index"문자가 페이지로 전송(@ResponseBody)
	}
	
	@GetMapping("/myjson")
	public String myjson() {
		return "{\"name\":\"kim\",\"age\":\"25\"}";
	}
	
	@GetMapping("/objectjson")
	public Person objectjson() {
		Person person = new Person();
		person.setName("hongkildong");
		person.setAge(30);
		return person;
	}
	
	@PostMapping("/receive")
    public Person receivePerson(@RequestBody Person person) {
        System.out.println("받은 이름: " + person.getName());
        System.out.println("받은 나이: " + person.getAge());
        return person;
    }
	
	/*
	@RequestMapping(
		value = "/person/xml", 
		method = RequestMethod.GET,
		produces = { MediaType.APPLICATION_XML_VALUE }
	)
	*/
	@GetMapping(
			value = "/person/xml", 
			produces = "application/xml"
	)
	public Person getXmlPerson() {
	    return new Person("홍길동", 30);
	}
	
	@RequestMapping(
			value = "/person/json", 
			method = RequestMethod.GET,
			produces = { MediaType.APPLICATION_JSON_VALUE }
		)
		public Person getJsonPerson() {
		    return new Person("홍길동", 30);
		}
}
