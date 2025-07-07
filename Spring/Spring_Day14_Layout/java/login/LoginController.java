package login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("index") 
	public String index(Model model) {
		model.addAttribute("page", "login/" + "index");
		return "index"; //무조건 views/index.jsp
	}
}
