package hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	MainService service;
	
	@RequestMapping("insertform")
	public String index() {
		return "insertform";
	}
	
	@RequestMapping("insert")
	public String insert(Student student) {
		System.out.println(student);
		service.insert(student);
		return null;
	}
}
