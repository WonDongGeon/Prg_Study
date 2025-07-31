package Work;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import restapi.Member;

public class Main2 {

	public static void main(String[] args) throws IOException {
		
		JSONObject jsonobj=new JSONObject();
		System.out.println(jsonobj);
		jsonobj.put("username","admin");
		System.out.println(jsonobj);
		jsonobj.put("password","1234");
		jsonobj.put("email","admin@naver.com");
		System.out.println(jsonobj);
		System.out.println(jsonobj.get("username"));
		
		//문자열인 json
		String strjson=
			"{\"password\":\"1234\",\"email\":\"user1@naver.com\",\"username\":\"user1\"}";
		//문자열 json을 객체로 변환
		JSONObject jsonobj2=new JSONObject(strjson);
		System.out.println(jsonobj2);
		
		//Member객체를 문자열을 이용하여 처리
		Member member=new Member(); //객체
		member.setUsername("user2");
		member.setPassword("1234");
		member.setEmail("user2@naver.com");
		System.out.println(member.toString());
		
		//Member객체를 JSONObject 이용하여 처리
		//JSONObject jsonobj3=new JSONObject(member);
		//System.out.println(jsonobj3);
		
		//Member객체를 ObjectMapper 이용하여 처리
		//member를 출력했을 때 toString함수가 호출되게 되며
		//toString override되지 않은 코드는 hashcode를 출력
		//일반 toString 재정의는 Member(속성=값,....)
		//하지만 ObjectMapper의 readValue의 첫번째 입력값은 문자열이며
		//문자열이 json형태의 문자열로 재정의된 toString만 사용이 가능
		ObjectMapper mapper=new ObjectMapper();
		Member member2=mapper.readValue(member.toString(), Member.class);
		System.out.println("member2:"+member2);
		
		//객체를 문자열로 변환
		String smember=mapper.writeValueAsString(member2);
		System.out.println(smember);
		
		//배열객체출력 [ ]:리스트
		List<Member> list=Arrays.asList(member,member2);
		System.out.println(list);
		
		//문자열 배열 출력 : { } =>출력 [ ]
		String[] amember= {member.toString(), member2.toString()};
		System.out.println(amember);
		
		//문자열 배열 문자열로 확인
		System.out.println(Arrays.toString(amember));
		
		//메모리를 기준으로 메모리에 기록write, 메모리에서 나오는 것 read
		//객체를 json파일로 생성
		//mapper.writeValue(new File("member.json"), member);
		Member member3
		=mapper.readValue(new File("member.json"), Member.class);
		System.out.println(member3);

	}

}