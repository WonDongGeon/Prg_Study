package springdatasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class SimpleDataSourceMain {

	public static void main(String[] args) throws SQLException {
		//spring context, jdbc 라이브러리 추가
		//spring은 spring configuration파일을 사용(setting.xml)
		//datasource bean등록
		//등록된 bean파일을 불러와서 확인
		ApplicationContext app
		=new ClassPathXmlApplicationContext("springdatasource/setting.xml");
		
		SimpleDriverDataSource datasource
		=(SimpleDriverDataSource)app.getBean("ds");
		
		Connection conn=datasource.getConnection();
		System.out.println(conn);
		
		DataSource ds=datasource;
		Connection conn2=ds.getConnection();
		System.out.println(conn2);
		
	}

}
