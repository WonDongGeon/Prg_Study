package springdatasource;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DriverManagerDatasouceMain {

	public static void main(String[] args) throws SQLException {
		//DriverManagerDataSource를 이용하여 db접속
		ApplicationContext app
		=new ClassPathXmlApplicationContext("springdatasource/setting.xml");
		
		DriverManagerDataSource ds
		=(DriverManagerDataSource)app.getBean("drivermanagerds");
		System.out.println(ds.getConnection());
	}

}
