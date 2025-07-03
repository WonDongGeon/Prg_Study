package mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisMain {

	public static void main(String[] args) {
		//mybatis -> db연결을 인터페이스연결하고 이 연결에 관한 동일한 xml파일(sql문)
		//예)MemberInter.java -> MemberInter.xml(sql문) : 두 파일을 연결하는 설정파일(xml)
		
		//라이브러리 추가 : mybatis, mybatis-spring, hikaricp
		
		//MemberMapper.java (인터페이스파일-MemberMapper.xml)
		//MemberMapper.xml 만들기 전 설정파일 플러그인 설치
		//MemberMapper.xml생성
		//MemberMapper.java생성
		//MemberMapper.java를 사용할 MapperService.java파일 생성
		//VO객체도 반드시 bean으로 생성해둬야한다.@Component
		ApplicationContext ctx 
		=new ClassPathXmlApplicationContext("mybatis/setting.xml");
		MemberService service = 
		(MemberService)ctx.getBean("memberService",mybatis.MemberService.class);
		service.save("user3","1234");
		//오류사항 : mybatis버전 오류인한 에러발생(2 version으로 변경)
		//테이블 전체를 사용하지 않을 경우 빈값여부 확인
	}

}







