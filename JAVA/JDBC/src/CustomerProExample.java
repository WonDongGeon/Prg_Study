/* 스캐너로 고객번호를 입력받아서 오라클로부터 검색을 한 다음 있는 경우는 저장프로시저를 실행하게 하고 없으면 유효성 검증 메시지를 띄운다.
 * 
 * 
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import net.daum.dao.CustomerDAOImpl;
import net.daum.dto.CustomerDTO;

public class CustomerProExample {

	public static void main(String[] args) {
		String drvier = "oracle.jdbc.OracleDriver"; 
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //오라클 접속 주소, 1521은 포트번호, xe는 데이터베이스 명
		String user = "night"; //오라클 사용자
		String pwd = "night"; //사용자 비번
		
		CustomerDAOImpl cdao = new CustomerDAOImpl();
		Scanner scan = new Scanner(System.in);
		
		Connection con = null; //db연결
		CallableStatement ct = null; //저장 프로시저 호출 실행
		String sql = null;
		
		try {
			Class.forName(drvier); //jdbc 드라이버 클래스 로드
			con = DriverManager.getConnection(url, user, pwd); //메서드 인자값으로 오라클 접속주소, 사용자, 비번을 전달해서 con생성
			System.out.println("####### 저장 프로시저 수행 실습 #######");
			System.out.print("고객 번호 입력>> ");
			int cus_no = Integer.parseInt(scan.nextLine());
			CustomerDTO cusNo = cdao.getCus_No(cus_no);
			
			if(cusNo == null) {
				System.out.println("고객번호가 없어서 저장프로시저를 수행하지 못합니다.!");
			}else {
				sql = "{call customer_pro(?,?,?,?)";
				ct = con.prepareCall(sql); //저장프로시저를 호출해서 수행할 ct생성
				ct.setInt(4, cus_no); //4번째 물음표에 정수 숫자로 고객번호를 저장
				
				ct.registerOutParameter(1, java.sql.Types.VARCHAR); //쿼리문의 첫번째 물음표에 오라클로 부터 받아올 값에 대한 타입을 지정
				ct.registerOutParameter(2, java.sql.Types.VARCHAR);
				ct.registerOutParameter(3, java.sql.Types.VARCHAR);
				
				ct.execute(); //저장 프로시저 실행
				
				System.out.println("고객 번호 \t 고객 이름 \t 고객 폰번호 \t 고객 이메일");
				System.out.println("==================================");
				System.out.println(cus_no + "\t" +ct.getString(1) + "\t" + ct.getString(2) + "\t" + ct.getString(3));
			}	
		}catch(Exception e) { e.printStackTrace(); }
		finally {
			try {
				if(ct != null) ct.close();
				if(con != null) con.close();
				if(scan != null) scan.close();
			}catch(Exception e) {e.printStackTrace();}
		}
	}
}
