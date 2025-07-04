package mybatisV2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisV2Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx 
		=new ClassPathXmlApplicationContext("mybatisv2/setting.xml");
		MemberService service = 
		(MemberService)ctx.getBean("memberService",mybatisV2.MemberService.class);
		
		//저장 테스트
		//System.out.println(service.save("user3","1234"));
		
		//선택출력테스트
		//System.out.println(service.getMember("user3"));
		
		//전체출력테스트
		//System.out.println(service.getMemberList());
		
		//수정테스트
		/*
		Member member=new Member();
		member.setId("M001");
		member.setPassword("1234");
		service.update(member);
		System.out.println(service.getMember("M001"));
		*/
		
		//삭제테스트
		//System.out.println(service.delete("user1"));
		System.out.println(service.getMemberList());
		
	}

}