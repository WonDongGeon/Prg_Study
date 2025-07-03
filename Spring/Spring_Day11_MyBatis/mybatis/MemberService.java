package mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService") //setting.xml에 bean 설정필요없는 대신(context-scan)
public class MemberService {
	@Autowired
	MemberMapper mapper; 
	//인터페이스파일이므로 bean생성(x), 
	//setting.xml에서 MemberMapper.xml파일을 bean생성(mybatis-scan을 통해)
	//mybatis에서 VO객체를 사용하려면 빈생성(@Componet) 
	public int save(String id, String password) {
		return mapper.save(id, password);
	}
}
