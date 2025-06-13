/* 스캐너로 먼저 고객번호를 입력받아서 오라클로부터 검색한 다음 해당 고객번호가 있는 경우만  고객 번호를 기준으로 삭제되게 한다. 고객번호가 없으면
 * 유효성 검증메시지를 출력한다.
 * 
 * 쿼리문을 수행할 때는 보안이 좋은 PreparedStatement JDBC API를 사용합니다.
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import net.daum.dao.CustomerDAOImpl;
import net.daum.dto.CustomerDTO;

public class Customer_Del01 {
	public static void main(String[] args) {
		String driver  = "oracle.jdbc.OracleDriver"; //ojdbc6.jar에 있는 것으로 oracle.jdbc는 패키지명이고 OracleDriver는
		// 오라클 jdbc 드라이버 클래스명
		
		String url = "jdbc:oracle:thin:@localhost:1521"; //오라클 접속주소, 1521은 오라클 연결 포트번호
		String user = "night"; //오라클 사용자
		String password = "night"; //사용자 비번
		
		Connection con = null; //db연결
		PreparedStatement pt = null; //쿼리문 수행
		String sql = null; //쿼리문 저장변수
		
		CustomerDAOImpl cdao = new CustomerDAOImpl();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Scanner scan = new Scanner(System.in);
			System.out.println(">>>고객정보 삭제<<<");
			System.out.print("고객 번호 입력>>");
			int cus_no = Integer.parseInt(scan.nextLine());
			
			CustomerDTO cusNo = cdao.getCus_No(cus_no); //오라클로 부터 고객번호를 검색
			if(cusNo != null) {
				sql = "DELETE FROM customer WHERE cus_no =?"; //고객번호를 기준으로 삭제
				pt = con.prepareStatement(sql); //쿼리문을 미리 컴파일해서 수행할 pstmt생성 => 속도가 빠르다. 보안이 좋다.
				pt.setInt(1, cus_no); //쿼리문의 첫번째 물음표에 정수숫자로 변호값을 저장
				
				int re = pt.executeUpdate(); //삭제 쿼리문 수행후 성공한 레코드 행의 개수 반환				
			
				if(re == 1) {
					System.out.println("고객정보 삭제에 성공했습니다.");
				}
			
			} else {
				System.out.println("고객 번호가 검색되지 않아서 삭제 못합니다.");
			}
			
		}catch(Exception e) { e.printStackTrace(); }
		finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) { e.printStackTrace(); }
		}
	}
}
