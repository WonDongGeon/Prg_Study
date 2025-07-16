package member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
	public int save	(Member member);
	public Member findByUsername(String username);
}
