package home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("home controller !!!");
		}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message","hello thymeleaf!!");
		return "index"; //views/index.html
	}
	
	@GetMapping("/index2")
	public String index2(Model model) {
		model.addAttribute("message","index2 hello thymeleaf!!");
		return "index2"; //views/index.html
	}
	
}
