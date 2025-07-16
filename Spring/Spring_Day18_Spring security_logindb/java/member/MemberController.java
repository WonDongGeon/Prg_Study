package member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/member") //full url사용하지 않고 xml설정에서 beans:beans
public class MemberController {

		@Autowired
		MemberService service;
	
		@RequestMapping("register")
		public void getRegister() {} //WEB-INf/views/member/register.jsp
		
		@PostMapping("register")
		public void register(Registerform form) {
			System.out.println(form);
			service.save(form);
		}
}
