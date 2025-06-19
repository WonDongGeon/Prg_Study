package d0617_02;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceTest {

	public static void main(String[] args) throws SQLException {
		BasicDataSource bds=new BasicDataSource();
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("system");
		bds.setPassword("light");
		Connection conn=bds.getConnection();
		
		DataSource ds=bds;
		Connection conn2=ds.getConnection();
		System.out.println(conn2);
		//new DataSource();

	}

}