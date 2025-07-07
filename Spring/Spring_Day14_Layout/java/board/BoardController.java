package board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping("index") 
	public String index(Model model) {
		model.addAttribute("page", "board/" + "index");
		return "index"; //무조건 views/index.jsp
	}
}
