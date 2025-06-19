package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.Phonebook;

@Repository
public class OracleDAOPhonebook implements PhonebookInter{

	@Autowired
	DataSource ds; //Connection conn; -> ds.getConnection()
	
	@Override
	public int save(Phonebook pb) {
		String sql = "insert into phonebook values(pb_id_seq.nextval,?,?,?,?)";
		try {
			PreparedStatement ps =
			ds.getConnection().prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getHp());
			ps.setString(3, pb.getEmail());
			ps.setString(4, pb.getMemo());
			int result = ps.executeUpdate();
			ps.close();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public List<Phonebook> findAll() {
		String sql = "select * from phonebook";
		try {
			
			PreparedStatement ps =
			ds.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Phonebook> list = new ArrayList<Phonebook>();
			while (rs.next()) {
				
				Phonebook pb = new Phonebook();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setHp(rs.getString("hp"));
				pb.setEmail(rs.getString("email"));
				pb.setMemo(rs.getString("memo"));
				list.add(pb);
				
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
	public Phonebook findById(int id) {
		String sql = "select * from phonebook where id = ?";
		try {
			PreparedStatement ps =
			ds.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Phonebook pb = new Phonebook();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setHp(rs.getString("hp"));
				pb.setEmail(rs.getString("email"));
				pb.setMemo(rs.getString("memo"));
				return pb;
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
	public int update(Phonebook pb) {
		String sql = "update phonebook set name=?, hp=?, email=?, memo=? where id=?";
		try {
			PreparedStatement ps =
			ds.getConnection().prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getHp());
			ps.setString(3, pb.getEmail());
			ps.setString(4, pb.getMemo());
			ps.setInt(5, pb.getId());
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
		String sql ="delete from phonebook where id = ?";
		try {
			PreparedStatement ps =
			ds.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			ps.close();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
