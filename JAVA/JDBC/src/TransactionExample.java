/* 트랜잭션은 논리적 기능 처리의 최소 단위를 말한다. 최소 단위라는 것은 이 소작업들을 분리할 수 없으며, 전체를 하나로 본다는 개념이다.
 *  소작업(출금/입금)들이 모두 성공하거나 실패해야 한다. 예를 들어 계좌 이체는 출금 작업과 입금 작업으로 구성된 트랜잭션이다.
 *  출금과 입금 작업 중 하나만 성공할 수 없으며, 모두 성공하거나 모두 실패해야 한다. 
 *  계좌 이체는 DB입장에서 보면 두 개의 계좌 금액을 수정하는 작업이다.
 *  출금은 계좌에서 잔액을 감소시키고, 입금은 계좌에서 잔액을 증가시킨다. 따라서 2개의 UPDATE문은 모두 성공하거나 모두 실패해야 한다.
 *  하나만 성공할 수 없다.
 *  
 *  트랜잭션 처리는 커밋(commit)과 롤백(rollback)으로 처리할 수 있다.
 *  commit은 내부 작업을 모두 성공 처리하고, rollback은 실행전으로 되돌아간다는 의미에서 모두 실패 처리한다.
 *  
 *  JDBC에서는 insert, update, delete 문을 실행할 때 마다 자동 커밋(Auto Commit)이 일어 난다. 
 *  이 기능은 계좌 이체와 같이 출금/입금 두 가지 update문이 동시에 실행할 때 문제가 된다.
 *  즉 출금 작업이 성공되면 바로 커밋이 되기 때문에 입금 작업의 성공여부와 상관없이 출금 작업만 별도로 처리한다. 따라서 JDBC에서 트랜잭션 코드를 제어할려면 자동 커밋 기능을 꺼놔야 한다.
 *  자동 커밋 설정 여부는 Connection의 setAutoCommit()메서드로 할 수 있다.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import net.daum.dao.CustomerDAOImpl;

public class TransactionExample {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.OracleDriver"; 
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //오라클 접속 주소, 1521은 포트번호, xe는 데이터베이스 명
		String user = "night"; //오라클 사용자
		String pwd = "night"; //사용자 비번
		
		Connection con = null; //db연결
		PreparedStatement pt1 = null; //저장 프로시저 호출 실행
		PreparedStatement pt2 = null; //저장 프로시저 호출 실행
		String sql01 = null;
		String sql02 = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			
			//트랜잭션 시작 -----------------------------
			con.setAutoCommit(false); //자동 커밋 기능 끄기
			
			//출금작업
			sql01 = "update accounts set balance = balance - ? where ano = ?";
			pt1 = con.prepareStatement(sql01);
			pt1.setInt(1, 10000); //쿼리문의 첫번째 물음표에 출금액 10000을 정수 숫자로 저장
			pt1.setString(2, "111-111-1111"); //쿼리문의 두번째 물음표에 문자열로 계좌번호를 저장
			int re01 = pt1.executeUpdate(); //수정 쿼리문 수행후 성공한 레코드 행의 개수 반환
			
			if(re01 == 0) {
				throw new Exception("출금 실패~"); //인위적 예외 발생
			}
			pt1.close();
			
			//입금작업
			sql02 = "update accounts set balance = balance + ? where ano = ?";
			pt2 = con.prepareStatement(sql02);
			pt2.setInt(1, 10000);
			pt2.setString(2,  "222-222-2222");
			int re02 = pt2.executeUpdate();
			
			if(re02 == 0) {
				throw new Exception("입금 실패~"); //인위적 예외 발생
			}
			pt2.close();
			
			//수동커밋 => 출금과 입금 모두 성공처리
			con.commit();
			System.out.println("계좌 이체 성공~");
			
		}catch(Exception e) { 
			try {
				con.rollback(); //수동 롤백처리 -> 입출금 모두 실패 처리
			}catch(Exception e01) {}
				System.out.println("계좌 이체 실패!");
				e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.setAutoCommit(true); //원래대로 자동커밋 기능 켜기
					con.close();
				}catch(Exception e) {e.printStackTrace();}			
			}
		}//finally
	}
}
