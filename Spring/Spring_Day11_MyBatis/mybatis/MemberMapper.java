package mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
	//public int save	(@Param("id") String id,@Param("password") String password);
	public int save	(String id,String password);
	//@Param이 없을 경우 오류발생 원인, 
	//xml에서 sql문이 id=값, values(값, 값) 두 가지 경우
	//id=값 형태는 @Param이 필요없음, 
	//속성=값이 아닌 값만 들어 있는 values(값, 값) 형태는 @Param사용
	
	//public String select(String id);
	//public List<Member> getList();
	//public int update(Member member);
	//public int delete(String id);

}
