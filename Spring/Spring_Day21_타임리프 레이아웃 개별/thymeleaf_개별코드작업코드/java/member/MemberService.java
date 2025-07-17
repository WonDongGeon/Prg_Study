package member;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberMapper dao;
	
	public void save(RegisterForm form) {
		//전달받은 값은 username, password, email 전달받았지만
		//추가적인 데이터를 Member에서 넣어서 전달
		Member member=new Member();
		BeanUtils.copyProperties(form, member);
		member.setRole("ROLE_USER");
		//new java.util.Date().getTime(); //long형임.
		//new java.sql.Date(long형이 입력)
		member.setRegdate
		(new java.sql.Date(new java.util.Date().getTime()));
		
		//암호화처리
		//PasswordEncoder pe=new BCryptPasswordEncoder();
		//member.setPassword(pe.encode(member.getPassword()));
		//오류발생 : 원인은 db password필드의 크기가 작아서 오류 발생
		//alter table member modify password varchar2(256); commit;
		
		dao.save(member);
	}

}
