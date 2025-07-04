package mybatisV2;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
//java-xml연결된것을 인터페이스에서 xml대신 어노테이션설정을 통해 처리
@Mapper //이 부분이 없어도 setting.xml에서 bean을 스캔하여 생성함.
public interface MemberMapper {
	@Insert("insert into member(id,password) values(#{id},#{password})")
	public int save	(@Param("id") String id,@Param("password")String password);
	@Select("select * from member where id=#{id}")
	public Member findById(String id);
	@Select("select * from member")
	public List<Member> findAll();
	@Update("update member set password=#{password} where id=#{id}")
	public int update(Member member);
	@Delete("delete from member where id=#{id}")
	public int delete(String id);

}