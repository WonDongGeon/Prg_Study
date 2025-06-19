package d0617_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@AllArgsConstructor
@Setter
@Getter
@ToString
public class DAO {
	//Connection conn;
	DataSource ds; 
	
	public DAO(DataSource ds) {
		this.ds=ds;
	}
	
	public DAO() {
		System.out.println("DAO생성자 생성!!");
	}
	
	public void exec() {
		System.out.println("dao에 exec 함수 실행!!!");
		try {
			System.out.println(ds.getConnection());
			String sql="insert into phonebook values('홍길동', '010-1111-1111')";
			PreparedStatement ps=
					ds.getConnection().prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	private static Connection conn;
	
	public Connection getInstance() {
		if(conn ==null) {
			try {
			Class.forName("oracle.jdbc.driver");
			conn=DriverManager
			.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","light");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	*/
}