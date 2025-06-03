package phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//인터페이스를 사용하는 이유 : 함수는 변하지 않고 기능은 늘 똑같기 때문
public class PhonebookDAOOracle implements PhonebookDAO {

	Connection conn;
	
	public PhonebookDAOOracle() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			conn = DriverManager.getConnection(url, "night", "night");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		//System.out.println(conn);
		
		//Phonebook pb = new Phonebook(0, "kim", "010-2222-1234", "kim@my.com", "회사");
		//System.out.println("result : " + insert(pb));
		System.out.println(findAll());
		//System.out.println(findAll());
	}
	
	
	@Override
	public int insert(Phonebook pb) {
		String sql = "insert into phonebook(id, name, hp, email, memo) values(pb_id_seq.nextval,?,?,?,?)";
		int result;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getHp());
			ps.setString(3, pb.getEmail());
			ps.setString(4, pb.getMemo());
			result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Phonebook> findAll() {
		String sql = "select * from phonebook";
		try {
			PreparedStatement ps = conn.prepareStatement(sql); //pre는 사전, 이전
			ResultSet rs = ps.executeQuery();
			
			List<Phonebook> list = new ArrayList<Phonebook>();
			while(rs.next()) {
				Phonebook pb = new Phonebook();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setHp(rs.getString("hp"));
				pb.setEmail(rs.getString("email"));
				pb.setMemo(rs.getString("memo"));
				list.add(pb);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Phonebook findById(int id) {
		String sql = "select * from phonebook where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Phonebook pb=  new Phonebook();
				pb.setId(id);
				pb.setName(rs.getString("name"));
				pb.setHp(rs.getString("hp"));
				pb.setEmail(rs.getString("email"));
				pb.setMemo(rs.getString("memo"));
				return pb;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateById(Phonebook pb) {
		String sql = "update phonebook set name=?, hp=?, email=?, Memo=? where id=?";
		// 시나리오 : pb객체에 수정할 내용만 입력된 상태로 전달될 경우
		// 수정할 sql문만을 별도로 만들어야 하는가?
		// null값일 경우 기존 데이터를 가지고 와서 pb에 셋팅 후 위의 sql문 제외
		Phonebook prepb = findById(pb.getId()); //이전의 값을 가지고 옴
		if(pb.getName() == null) {pb.setName(prepb.getName());}
		if(pb.getHp() == null) {pb.setName(prepb.getName());}
		if(pb.getName() == null) {pb.setName(prepb.getName());}
		if(pb.getName() == null) {pb.setName(prepb.getName());}
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getHp());
			ps.setString(3, pb.getEmail());
			ps.setString(4, pb.getMemo());
			ps.setInt(5, pb.getId());
			int result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from phonebook where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
