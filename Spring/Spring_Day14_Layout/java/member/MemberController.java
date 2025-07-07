package member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	
	@RequestMapping("index") 
	public String index(Model model) {
		model.addAttribute("page", "member/" + "index");
		return "index"; //무조건 views/index.jsp
	}
	
	/*
	 * @RequestMapping("index") public String index() { return "member/index";
	 * //기본경로에 return 문자열이 합쳐서 jsp호출 }
	 */
}
