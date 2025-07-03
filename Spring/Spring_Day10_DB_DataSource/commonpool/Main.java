package commonpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 2)apache에서 지원하는 라이브러리를 통해 db접속 방법
		//필요한 라이브러리: commons-pool, commons-dbcp
		Class.forName("org.apache.commons.dbcp.PoolingDriver");
		Connection conn=DriverManager.getConnection(
		"jdbc:apache:commons:dbcp:/commonpool/pool");
		System.out.println(conn);
		
		//일반에서 사용하는 용도가 아닌 dynamic web project에서 설정하여 사용
		//web.xml에서 다음과 같이 설정
		/*
		 <servlet>
 		<servlet-name>DBCPInit</servlet-name>
 		<servlet-class>jdbc.DBCPInit</servlet-class>
 		<!-- jdbc/DBCPInit.java 로드 : Class.forName()로드
 		jsp에서 DriverManager.getConnection(
		"jdbc:apache:commons:dbcp:/commonpool/pool");-->
 	
 		<init-param>
 			<param-name>jdbcdriver</param-name>
 			<param-value>oracle.jdbc.driver.OracleDriver</param-value>
 		</init-param>
 		<load-on-startup>1</load-on-startup>
 		</servlet> 
		 */
	}

}
