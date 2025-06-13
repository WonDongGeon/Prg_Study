package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

	Connection conn;
	
	public MemberDAO() {
		//driver, url, user, password정보를 web.xml에 숨겨서 사용(서블릿 파라메다)
		System.out.println("MemberDAO 생성!!!!!");
		try {
		Class.forName("org.h2.Driver");
		conn=DriverManager
				.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		}catch (Exception e) {}
	}
	
	public int save(Member member) {
		try {
		String sql="insert into member(id,password,hp,email,address,pic)"
				+ " values(?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,member.getId());
		ps.setString(2, member.getPassword());
		ps.setString(3, member.getHp());
		ps.setString(4, member.getEmail());
		ps.setString(5, member.getAddress());
		ps.setString(6, member.getPic());
		int result=ps.executeUpdate();
		ps.close();
		return result;
		}catch (Exception e) {e.printStackTrace();}
		return 0;
	}
	
	public Member findById(String id) {
		try {
		String sql="select id,password from member where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			Member member=new Member();
			member.setId(rs.getString("id"));
			member.setPassword(rs.getString("password"));
			rs.close();
			ps.close();
			return member;
		}
		}catch (Exception e) {}
		return null;
		
	}

}
