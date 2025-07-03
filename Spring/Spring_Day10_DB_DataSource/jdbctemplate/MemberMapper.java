package jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<Member>{

	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member=new Member();
		member.setId( rs.getString("id"));
		member.setAddress(rs.getString("address"));
		member.setEmail(rs.getString("email"));
		member.setHp(rs.getString("hp"));
		member.setName(rs.getString("name"));
		member.setPassword(rs.getString("password"));
		return member;
	}

}
