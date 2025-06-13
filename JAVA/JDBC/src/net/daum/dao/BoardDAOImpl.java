package net.daum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.daum.controller.BoardExample;
import net.daum.dto.BoardDTO;

public class BoardDAOImpl { //오라클 연동 클래스
	String driver = "oracle.jdbc.OracleDriver"; //oracle.jdbc는 패키지명, OracleDriver는 jdbc 드라이버 클래스명
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //오라클 접속주소, 1521은 포트번호, xe는 데이터베이스명
	String user = "night"; //오라클 접속 사용자
	String pwd = "night"; //사용자 비번

	Connection con = null; //DB연결
	PreparedStatement pt = null; //쿼리문 수행
	ResultSet rs = null; //검색 결과 레코르르 저장 rs
	String sql = null; //쿼리문(SQL) 저장변수
	
	BoardExample exitB = new BoardExample();
	
	public BoardDAOImpl() {
		try {
			Class.forName(driver);
		}catch(Exception e) { 
			e.printStackTrace(); 
			exitB.exit(); //게시판 종료
		}
	}//생성자
	
	
	//게시판 목록 
	public List<BoardDTO> getBoardList() { 
		List<BoardDTO> blist = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			sql = "select * from boards order by bno desc"; //번호를 기준으로 내림차순 정렬 검색
			pt = con.prepareStatement(sql); //쿼리문을 미리 컴파일하여 수행할 pt생성
			rs = pt.executeQuery(); //select 문 수행후 결과 레코드를 rs에 저장
			
			while(rs.next()) { //복수개의 레코드가 검색되면 while 반복문으로 처리, next() 메서드는 다음 레코드가 존재하면 참
				BoardDTO b= new BoardDTO();
				b.setBno(rs.getInt(1)); //1의 뜻은 select문 뒤에 검색되는 컬럼 순번이다. 해당 컬럼으로 정수 숫자로 번호값을 가져와서
				//setter() 메서드를 가져온다.
				b.setBwriter(rs.getString("bwriter")); //bwriter 컬럼에 저장된 작성자 레코드를 문자열로 가져와서 setter()메서드에 저장한다.
				b.setBdate(rs.getDate("bdate"));
				b.setBtitle(rs.getString("btitle"));
				
				blist.add(b); //컬렉션에 추가
			}//while end
			
			rs.close();
			pt.close();
		}catch(Exception e) {
			e.printStackTrace();
			exitB.exit();
		}finally {
			try {
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
		return blist;
	}//getBoardList()

	
	//게시판 저장
	public void insertBoard(BoardDTO board) {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			sql = "insert into boards (bno, bwriter, btitle, bcontent) values(seq_bno.nextval, ?,?,?)";
			pt = con.prepareStatement(sql);
			pt.setString(1, board.getBwriter()); //쿼리문의 첫번째 물음표에 문자열로 글쓴이를 저장
			pt.setString(2, board.getBtitle());
			pt.setString(3, board.getBcontent());
			pt.executeUpdate(); //저장 쿼리문 수행후 성공한 레코드 행의 개수를 반환.
			
			pt.close();	
		}catch(Exception e) {
			e.printStackTrace();
			exitB.exit();
		}finally {
			try {
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//게시판 읽기
	public BoardDTO getFindNo(int bno) {
		BoardDTO findNo = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			sql = "select bno from boards where bno = ?";
			pt = con.prepareStatement(sql);
			pt.setInt(1, bno);
			rs = pt.executeQuery();
			
			if(rs.next()) { // 검색된 레코드가 1개이면 if문으로 실행, 복수개이면 while
				findNo = new BoardDTO();
				findNo.setBno(rs.getInt("bno"));
			}
			rs.close();
			pt.close();
		}catch(Exception e) {
			e.printStackTrace();
			exitB.exit();
		}finally {
			try {
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return findNo;
	}

	//게시물 읽기
	public BoardDTO getBoardCont(int bno) {
		BoardDTO bc = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			sql = "select * from boards where bno = ?"; //번호를 기준으로 내림차순 정렬하면 숫자가 큰 게시판 번호가 먼저 출력
			pt = con.prepareStatement(sql);
			pt.setInt(1, bno);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				bc = new BoardDTO();
				bc.setBno(rs.getInt("bno"));
				bc.setBwriter(rs.getString("bwriter"));
				bc.setBtitle(rs.getString("btitle"));
				bc.setBcontent(rs.getString("bcontent"));
				bc.setBdate(rs.getDate("bdate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			exitB.exit();
		}finally {
			try {
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return bc;
	}
	
	//게시물 갱신
	public void updateBoard(BoardDTO eb) {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			sql = "update boards set bwriter = ?, btitle = ?, bcontent = ? where bno = ? ";
			pt = con.prepareStatement(sql);
			pt.setString(1, eb.getBwriter()); //쿼리문의 첫번째 물음표에 문자열로 글쓴이를 저장
			pt.setString(2, eb.getBtitle());
			pt.setString(3, eb.getBcontent());
			pt.setInt(4, eb.getBno());
			pt.executeUpdate(); //저장 쿼리문 수행후 성공한 레코드 행의 개수를 반환.
			
			pt.close();	
		}catch(Exception e) {
			e.printStackTrace();
			exitB.exit();
		}finally {
			try {
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	//게시물 삭제
	public void deleteBoard(BoardDTO bc) {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			sql = "delete from boards where bno = ?";
			pt = con.prepareStatement(sql);
			pt.setInt(1, bc.getBno());
			pt.executeUpdate(); //저장 쿼리문 수행후 성공한 레코드 행의 개수를 반환.
			
			pt.close();	
		}catch(Exception e) {
			e.printStackTrace();
			exitB.exit();
		}finally {
			try {
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

    //게시물 전체 삭제
	public void deleteAllBoard() {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			sql = "delete from boards";
			pt = con.prepareStatement(sql);
			pt.executeUpdate();
			
			pt.close();
		}catch(Exception e) {
			e.printStackTrace();
			exitB.exit();
		}finally {
			try {
			   if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
