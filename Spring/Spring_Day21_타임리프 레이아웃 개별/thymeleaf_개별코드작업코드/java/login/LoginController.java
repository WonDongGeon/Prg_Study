package login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*
@RequestMapping("/login") //사용하지 않음
/login/login접속하면
full url해석하지 않고 web.xml설정 맵핑주소가 /login/* 처리하고 
컨트롤에서 *에 해당하는 login만 전달
login-servlet.xml beans:beans 설정하여 viewresolver에서 jsp적용
*/
public class LoginController {

	// http://localhost:8888/login/login
	@GetMapping("login")
	public void login() {
		//함수가 void형 즉 리턴이 없을 경우 주소를 참조하여 페이지 결정
		// /login -> login ->/WEB-INF/views/login.jsp
		//만약 url주소가 /login/login ->/WEB-INF/views/login/login.html
	}
	
	/*
	 로그아웃시 get, post 컨트롤러는 필요가 없음
	 이유는 spring security의 logout 태그가 처리함
	 이 태그는 post를 처리하는 tag임
	@GetMapping("/logout")
	public void logout() {
		System.out.println("get logout");
	}
	
	@PostMapping("/logout")
	public void postlogout() {
		System.out.println("post logout");
	}
	*/
}
