package home;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("message","hello thymeleaf!!");
		return "index"; //views/index.html
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message","home layout!!");
		return "home"; //views/home.html
	}
	
	@GetMapping("/func")
	public String func(Model model) {
		model.addAttribute("message","타임리프메시지!!");
		model.addAttribute("site","http://naver.com");
		model.addAttribute("sitename","naver");
		model.addAttribute("username","admin");
		model.addAttribute("size", 3);
		List<Fruit> products=Arrays.asList(
				new Fruit("사과",3000),
				new Fruit("오렌지",2000),
				new Fruit("망고",5000)
				);
		model.addAttribute("products", products);
		model.addAttribute("gender", "W"); //여자 W
		model.addAttribute("productName","notebook");
		model.addAttribute("productId", "sm-100");
		
		//model.addAttribute("date", LocalDateTime.of(2025, 1, 2, 11, 10));
		DateTimeFormatter fomat=DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
		LocalDateTime datetime=LocalDateTime.parse("25-01-02 11:10", fomat);
		model.addAttribute("date", datetime);
		
		model.addAttribute("fruit",new Fruit("사과",3000));
	
		return "func"; //views/func.html
	}
}
