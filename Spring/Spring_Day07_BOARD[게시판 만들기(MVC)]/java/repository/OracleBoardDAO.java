package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.Board;

@Repository
public class OracleBoardDAO implements BoardDAO {

	@Autowired
	DataSource ds; //Connection conn; -> ds.getConnection()

	public OracleBoardDAO() {
		System.out.println("Board DAO");
	}
	
	@Override
	public int save(Board board) {
		String sql="insert into board(id,title,content,author,type,attachment,createdate,viewcnt) "
				+ "values(board_id_seq,?,?,?,?,?,sysdate,0)";
		try {
		PreparedStatement ps
		=ds.getConnection().prepareStatement(sql.toString());
		ps.setString(1, board.getTitle());
		ps.setString(2, board.getContent());
		ps.setString(3, board.getAuthor());
		ps.setString(4, board.getType());
		ps.setString(5, board.getAttachment());
		int result=ps.executeUpdate();
		ps.close();
		return result;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}

	@Override
	public List<Board> findAll(int statnum, int endnum) {
		StringBuffer sql2 = new StringBuffer();
		sql2.append("select * from ");
		sql2.append("(select rownum rid, t1.* from ");
		sql2.append("(select * from board order by id asc) t1) ");
		sql2.append("where rid>=? and rid<=?");
		try {
			PreparedStatement ps = ds.getConnection().prepareStatement(sql2.toString());
			ps.setInt(1, statnum);
			ps.setInt(2, endnum);
			ResultSet rs = ps.executeQuery();
			List<Board> list = new ArrayList<Board>();
			while(rs.next()) {
				Board bd = new Board();
				bd.setId(rs.getInt("id"));
				bd.setTitle(rs.getString("title"));
				bd.setAuthor(rs.getString("author"));
				bd.setCreatedate(rs.getDate("createdate"));
				bd.setContent(rs.getString("content"));
				bd.setAttachment(rs.getString("attachment"));
				bd.setViewcnt(rs.getInt("viewcnt"));
				bd.setType(rs.getString("type"));
				list.add(bd);	
			}
			rs.close();
			ps.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Board FindById(int id) {
		String sql = "select * from board where id = ?";
		try {
			PreparedStatement ps = ds.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Board bd = new Board();
				bd.setId(rs.getInt("id"));
				bd.setTitle(rs.getString("title"));
				bd.setAuthor(rs.getString("author"));
				bd.setCreatedate(rs.getDate("createdate"));
				bd.setContent(rs.getString("content"));
				bd.setAttachment(rs.getString("attachment"));
				bd.setViewcnt(rs.getInt("viewcnt"));
				bd.setType(rs.getString("type"));
				rs.close();
				ps.close();
				return bd;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public int update(Board board) {
		String sql = "update board set title=?,author=?,content=?,attachment=?,type=? where id=?";
		try {
			PreparedStatement ps = ds.getConnection().prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2,  board.getAuthor());
			ps.setString(3, board.getContent());
			ps.setString(4, board.getAttachment());
			ps.setString(5, board.getType());
			ps.setInt(6, board.getId());
			int result = ps.executeUpdate();
			ps.close();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		String sql = "delete from board where id=?";
		try {
			PreparedStatement ps = ds.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			ps.close();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int count() {
		String sql="select count(*) as count from board";
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
}
