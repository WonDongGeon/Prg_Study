/* 고객 목록 보기)
 * JDBC 쿼리문 수행하는 Statement API를 사용한다.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer_Select01 {
	public static void main(String[] args) {
		String driver  = "oracle.jdbc.OracleDriver"; //ojdbc6.jar에 있는 것으로 oracle.jdbc는 패키지명이고 OracleDriver는
		// 오라클 jdbc 드라이버 클래스명
		
		String url = "jdbc:oracle:thin:@localhost:1521"; //오라클 접속주소, 1521은 오라클 연결 포트번호
		String user = "night"; //오라클 사용자
		String password = "night"; //사용자 비번
		
		Connection con = null; //db연결
		Statement stmt = null; //쿼리문 수행
		ResultSet rs = null; //검색 결과 레코드를 저장할 rs
		String sql = null; //쿼리문 저장변수
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.createStatement(); //쿼리문을 수행할 stmt를 생성
			sql = "SELECT * FROM customer ORDER BY cus_no DESC";
			rs = stmt.executeQuery(sql); // SELECT문 수행 후 검색 결과 레코드를 rs에 저장시킴
			
			System.out.println(">>>>>>>>>>>>> 고객 목록 보기 <<<<<<<<<<<<<<");
			System.out.println("고객번호 \t 고객이름 \t 고객폰번호 \t 고객이메일 \t 등록날짜");
			System.out.println("======================================");
			while(rs.next()) { //복수개의 레코드행이 검색되면 while 반복문으로 처리, next() 메서드는 다음 레코드 행이 존재하면 참
				int cus_no = rs.getInt(1); //1의 뜻은 SELECT문 다음에 검색되는 컬럼 순번, 고객번호를 getInt()메서드로 정수 숫자로
				//가져와서 좌측변수에 저장시킴
				String cus_name = rs.getString("cus_name"); //cus_name 컬럼에 저장된 고객이름을 문자열로 가져와서 좌측변수에 저장
				String cus_phone = rs.getString("cus_phone");
				String cus_email = rs.getString("cus_email");
				String cus_date = rs.getString("cus_date");
				
				System.out.println(cus_no + "\t" + cus_name + "\t" + cus_phone + "\t" + cus_email + "\t" + cus_date);
				
			}
		}catch(Exception e) { e.printStackTrace(); }
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null ) stmt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace(); }
		}
	}
}
