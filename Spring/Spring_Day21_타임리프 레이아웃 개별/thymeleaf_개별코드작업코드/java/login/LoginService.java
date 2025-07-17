package login;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import member.Member;
import member.MemberMapper;

@Service
public class LoginService implements UserDetailsService{

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	public LoginService() {
		System.out.println("로그인 서비스 생성자 생성!!");
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//1)username 전달
		System.out.println("로그인 폼으로 부터 전달된 username:"+username);
		//2)sqlSessionFactory를 이용하여 mapper에서 username을 이용하여 정보불러오기
		SqlSession sqlSession=sqlSessionFactory.openSession();
		MemberMapper memberDao=sqlSession.getMapper(MemberMapper.class);
		Member member=memberDao.findByUsername(username);
		System.out.println(member);
		//3)로그인성공, 실패를 security가 처리
		//(User객체가 로그인처리:org.springframework.security.core.userdetails.User.class)
		//로그인 처리전에 ROLE권한을 리스트에 사전에 입력을 해둬야한다.
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		if(member.getRole().equals("ROLE_ROOT")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}else if(member.getRole().equals("ROLE_ADMIN")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}else if(member.getRole().equals("ROLE_USER")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		//User객체를 이용하여 로그인 성공여부 확인
		//User객체는 이미 폼에서 전송받은 username,password를 가지고 있는 상태이고
		//데이터베이스로부터 받은 member의 username, password를 전달하고
		//이를 확인하는 과정이며 성공여부에 따라 User객체가 null인지 아닌지 결정
		//확인사항)db에 있는 password가 암호화가 되어 있는지 여부 반드시 확인
		//아래코드는 암호가 되지 않은 상태에서 값이 전달(1234,비교할 때 암호되어서 처리)
		/*
		User user=
		new User(member.getUsername(), member.getPassword(), authorities);
		*/
		
		//암호화 처리
		//db의 현 상태는 암호가 되지 않은 상태, 
		//패스워드가 암호가 된 상태에 입력되어야하는지? 
		//암호가 되지 않은 상태에서 입력되어야 하는지 확인?
		
		/*
		User user
		=new User(member.getUsername(),member.getPassword(),authorities);
		*/
		
		//폼의 password:1234, member의 password는 1234
		//new User()객체를 이용하여 패스워드를 비교할 때 
		//폼의 password는 1234가 아닌 암호화된 1234와
		//, new User의 password의 암호화된 값이 비교
		
		//추가적인 사항은 db의 password가 암호가 되어 있을 경우 encode()함수가 필요한가?
		//암호화된 db일 경우 encode()함수가 필요없음
		
		//결론적으로 암호화 되어 있는 경우 아래 코드 사용
		/*
		User user
		=new User(member.getUsername(),member.getPassword(),authorities);
		*/
		
		//db가 암호가 되어 있지 않은 경우 아래 코드 사용
		User user=
		new User(member.getUsername(), 
				new BCryptPasswordEncoder().encode(member.getPassword()),
				authorities);
		
		System.out.println("user 정보:"+user);
		return user;
	}

}
