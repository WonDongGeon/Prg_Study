package login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/login")
public class LoginController {

	public LoginController() {
		System.out.println("login 생성자");
	}
	
	@RequestMapping("index")
	public String index() {
		return "index"; //views/login/index.jsp
	}
}
