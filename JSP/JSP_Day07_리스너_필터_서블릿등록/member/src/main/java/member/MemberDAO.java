package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class MemberDAO {

	Connection conn;
	DBConfig dbconfig;
	
	public MemberDAO(ServletContext context) {
		dbconfig=new DBConfig();
		dbconfig.setDriver(context.getInitParameter("driver"));
		dbconfig.setUrl(context.getInitParameter("url"));
		dbconfig.setUser(context.getInitParameter("user"));
		dbconfig.setPassword(context.getInitParameter("password"));
		System.out.println(dbconfig.toString());
		try {
			Class.forName(dbconfig.getDriver());
			conn=DriverManager
					.getConnection(
							dbconfig.getUrl(), 
							dbconfig.getUser(),
							dbconfig.getPassword()
							);
			}catch (Exception e) {}
	}
	
	public MemberDAO() {
		//driver, url, user, password정보를 web.xml에 숨겨서 사용(서블릿 파라메다)
		System.out.println("MemberDAO 생성!!!!!");
		//new DBConfig(null);
		System.out.println(dbconfig);
		try {
		Class.forName(dbconfig.getDriver());
		conn=DriverManager
				.getConnection(
						dbconfig.getUrl(), 
						dbconfig.getUser(),
						dbconfig.getPassword()
						);
		}catch (Exception e) {}
	}
	
	public MemberDAO(ServletConfig config) {
		dbconfig=new DBConfig();
		dbconfig.setDriver(config.getInitParameter("driver"));
		dbconfig.setUrl(config.getInitParameter("url"));
		dbconfig.setUser(config.getInitParameter("user"));
		dbconfig.setPassword(config.getInitParameter("password"));
		System.out.println(dbconfig.toString());
		try {
			Class.forName(dbconfig.getDriver());
			conn=DriverManager
					.getConnection(
							dbconfig.getUrl(), 
							dbconfig.getUser(),
							dbconfig.getPassword()
							);
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
