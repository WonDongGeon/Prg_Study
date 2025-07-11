package member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/member")
public class MemeberController {

	public MemeberController() {
		System.out.println("member 생성자");
	}
	
	@RequestMapping("index")
	public String index() {
		return "index"; //views/member/index.jsp
	}
}
