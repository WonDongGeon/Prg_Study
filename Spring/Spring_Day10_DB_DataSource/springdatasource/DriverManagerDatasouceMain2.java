package springdatasource;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DriverManagerDatasouceMain2 {

	public static void main(String[] args) throws SQLException {
		//db.properties파일의 정보를 bean에서 사용하기
		//setting.xml  context를 등록하고 property-placeholder사용
		//property-placeholder 외부의 파일에 접근 ${ }
		ApplicationContext app
		=new ClassPathXmlApplicationContext("springdatasource/setting.xml");
		
		DriverManagerDataSource ds
		=(DriverManagerDataSource)app.getBean("drivermanagerds2");
		System.out.println(ds.getConnection());
	}

}
