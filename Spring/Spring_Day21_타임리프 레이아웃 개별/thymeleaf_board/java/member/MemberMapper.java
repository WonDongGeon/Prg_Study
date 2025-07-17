package member;

import java.util.List;

public interface MemberMapper {
	public int save	(Member member);
	public Member findByUsername(String username);	
}
