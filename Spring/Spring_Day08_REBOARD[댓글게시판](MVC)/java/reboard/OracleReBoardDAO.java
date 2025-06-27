package reboard;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//빈생성 이름이 별도로 없을 경우 객체명의 첫글자만 소문자 oracleReBoardDAO
//@Repository("orcaleReBoardDAO")
@Repository
public class OracleReBoardDAO implements ReBoardDAO{

	@Autowired
	DataSource ds;
	
	@Override
	public int save(ReBoard reboard) {
		String sql = "insert into reboard(id,title,author,createdate,content,attachment,viewcnt,type,isdel,updatedate,parentid,tab) "
				+ "values(reboard_id_seq.nextval,?,?,sysdate,?,?,0,'일반게시판',0,null,0,0)";
		try {
			PreparedStatement ps
			=ds.getConnection().prepareStatement(sql.toString());
			ps.setString(1, reboard.getTitle());
			ps.setString(2, reboard.getAuthor());
			ps.setString(3, reboard.getContent());
			ps.setString(4, reboard.getAttachment());
			int result = ps.executeUpdate();
			ps.close();
			return result;
			}catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
	}

	@Override
	public List<ReBoard> findAll(int startnum, int endnum) {
		String sql="select * from"
				+ " (select rownum rid, t1.* from "
				+ " (select * from reboard where isdel=0"
				+ " start with parentid=0 connect by prior id=parentid"
				+ " order siblings by id desc) t1)"
				+ " where rid>=? and rid<=?";
		try {
		PreparedStatement ps
		=ds.getConnection().prepareStatement(sql.toString());
		ps.setInt(1, startnum);
		ps.setInt(2, endnum);
		ResultSet rs=ps.executeQuery();
		List<ReBoard> list=new ArrayList<ReBoard>();
		while(rs.next()){
			//builder형식으로 변환
			ReBoard board=new ReBoard.ReBoardBuilder()
			.id(rs.getInt("id"))
			.title(rs.getString("title"))
			.author(rs.getString("author"))
			.content(rs.getString("content"))
			.createdate(rs.getDate("createdate"))
			.viewcnt(rs.getInt("viewcnt"))
			.attachment(rs.getString("attachment"))
			.type(rs.getString("type"))
			.parentid(rs.getInt("parentid"))
			.tab(rs.getInt("tab"))
			.updatedate(rs.getDate("updatedate"))
			.build();
			
			list.add(board);
		}
		rs.close(); ps.close();
		return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ReBoard findById(int id) {
		String sql="select * from reboard where id = ?";
		try {
			PreparedStatement ps = ds.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//ReBoard reboard = new ReBoard.ReBoardBuilder().build(); //빈 객체 생성 -> @No
				ReBoard reboard = new ReBoard.ReBoardBuilder()
						.id(rs.getInt("id"))
						.title(rs.getString("title"))
						.author(rs.getString("author"))
						.content(rs.getString("content"))
						.createdate(rs.getDate("createdate"))
						.viewcnt(rs.getInt("viewcnt"))
						.attachment(rs.getString("attachment"))
						.type(rs.getString("type"))
						.parentid(rs.getInt("parentid"))
						.tab(rs.getInt("tab"))
						.updatedate(rs.getDate("updatedate"))
						.build();
				return reboard;	
			}
			rs.close();
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public int update(ReBoard reboard) {
		String sql="update reboard set title=?, author=?, content=?, updatedate=sysdate, attachment=? where id=?";
		try {
			PreparedStatement ps=ds.getConnection().prepareStatement(sql);
			ps.setString(1, reboard.getTitle());
			ps.setString(2, reboard.getAuthor());
			ps.setString(3, reboard.getContent());
			ps.setString(4, reboard.getAttachment());
			ps.setInt(5, reboard.getId());
			int result=ps.executeUpdate();
			ps.close();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		String sql ="delete from reboard where id=?";
		try {
			PreparedStatement ps=ds.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			int result=ps.executeUpdate();
			ps.close();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	@Override
	public int count() {
		String sql="select count(*) count from reboard";
		try {
		PreparedStatement ps=ds.getConnection().prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			int totalCount=rs.getInt("count");
			rs.close();
			ps.close();
			return totalCount;
		}
		
		}catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return 0;
	}
	@Override
	public int viewcntup(int id) {
		String sql="update reboard set viewcnt=viewcnt+1 where id=?";
		try {
			PreparedStatement ps=ds.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			int result=ps.executeUpdate();
			ps.close();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int replySave(ReBoard reboard) {
		String sql="insert into reboard(id,title,content,author,createdate,type,parentid,tab)"
				+ " values(reboard_id_seq.nextval,?,?,?,sysdate,'일반게시판',?,?)";
				try {
					PreparedStatement ps
					=ds.getConnection().prepareStatement(sql.toString());
					ps.setString(1, reboard.getTitle());
					ps.setString(2, reboard.getContent());
					ps.setString(3, reboard.getAuthor());
					ps.setInt(4, reboard.getParentid());
					ps.setInt(5, reboard.getTab());
					int result=ps.executeUpdate();
					ps.close();
					return result;
					}catch (Exception e) {
						e.printStackTrace();
						return 0;
					}	
	}
}