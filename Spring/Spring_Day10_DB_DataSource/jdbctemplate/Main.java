package jdbctemplate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {

	public static void main(String[] args) {
		ApplicationContext app
		=new ClassPathXmlApplicationContext("jdbctemplate/setting.xml");
		
		JdbcTemplate jtmp=
		(JdbcTemplate)app.getBean("jdbcTemplate");
		
		//jdbctemplate를 사용하여 sql문을 처리
		//라이브러리추가:lombok
		//db테이블의 객체와 동일한 vo객체
				
		int count
		=jtmp.queryForObject("select count(*) from member", Integer.class);
		System.out.println(count);
		
		String name
		=jtmp.queryForObject
		("select name from member where id='M002'", String.class);
		System.out.println(name);
		
		String name2
		=jtmp.queryForObject
		("select name from member where id=?", new Object[]{"M002"},String.class);
		System.out.println(name2);
		
		//만약에 결과를 객체로 얻기 위해서는 vo객체에 대한 mapper파일필요(RowMapper 인터페이스구현)
		Member member
		=jtmp.queryForObject
		("select * from member where id=?", new Object[]{"M002"},new MemberMapper());
		System.out.println(member);
		
		//리스트얻기
		List<Member> list=jtmp.query
				("select * from member",new MemberMapper());
		System.out.println(list);
		
		
	}

}
