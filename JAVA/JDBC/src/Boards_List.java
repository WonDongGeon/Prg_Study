// boards테이블 전체 레코드 가져오기

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Boards_List {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver"; //oracle.jdbc.driver는 패키지명, OracleDriver는 jdbc 드라이버 클래스명
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //오라클 접속 주소
		String user = "night"; // 오라클 사용자
		String pwd = "night"; // 사용자 비번
		
		Connection con = null; //db연결
		PreparedStatement pt = null; //쿼리문 수행
		ResultSet rs = null; // 검색 결과 레코드를 저장할 rs
		String sql = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pwd);
			sql = "select * from boards order by bno desc";
			pt = con.prepareStatement(sql); //쿼리문을 수행할 rs
			rs = pt.executeQuery(); //select 문 수행후 결과 레코드르 rs에 저장
			System.out.println("no \t name \t title \t cont \t date");
			System.out.println("------------------------------------------------------");
			
			while(rs.next()) { //next()메서드는 다음 레코드가 존재하면 참
				System.out.println(rs.getInt("bno") + "\t" + rs.getString("bwriter") + "\t"+ rs.getString("btitle") + "\t" + rs.getString("bcontent") + "\t" + rs.getDate("bdate"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
