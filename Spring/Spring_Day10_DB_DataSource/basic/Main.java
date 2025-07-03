package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1)일반 jdbc 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="test";
		String password="1111";
		Connection conn=DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		
	}

}
